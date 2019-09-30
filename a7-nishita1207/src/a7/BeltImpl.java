package a7;

import comp401sushi.Plate;

import java.util.ArrayList;
import java.util.List;

public class BeltImpl implements Belt {

    private List<BeltObserver> beltObserver = new ArrayList<BeltObserver>();
    private Plate[] belt;
    private Customer[] customer;

    public BeltImpl(int belt_size) {
        if (belt_size < 1) {
            throw new IllegalArgumentException("Illegal");
        }

        belt = new Plate[belt_size];
        customer = new Customer[belt_size];

    }

    @Override
    public int getSize() {
        return belt.length;
    }

    @Override
    public Plate getPlateAtPosition(int position) {
        position = normalize_position(position);

        return belt[normalize_position(position)];
    }

    @Override
    public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
        if (plate == null) {
            throw new IllegalArgumentException();
        }

        position = normalize_position(position);

        if (getPlateAtPosition(position) != null) {
            throw new BeltPlateException(position, plate, this);
        }

        PlateEvent plateEvent = new PlateEvent(PlateEvent.EventType.PLATE_PLACED, plate, position);

        notifyObserver(plateEvent);

        belt[position] = plate;
    }

    @Override
    public void clearPlateAtPosition(int position) {
        position = normalize_position(position);

        PlateEvent plateEvent = new PlateEvent(PlateEvent.EventType.PLATE_REMOVED, belt[position], position);

        notifyObserver(plateEvent);

        belt[position] = null;
    }

    private int normalize_position(int position) {
        int size = getSize();
        return (((position % size) + size) % size);
    }


    @Override
    public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
        int offset = 0;
        position = normalize_position(position);

        while (offset < getSize()) {
            try {
                setPlateAtPosition(plate, position + offset);

                return normalize_position(position + offset);
            } catch (BeltPlateException e) {
                offset += 1;
            }
        }
        throw new BeltFullException(this);
    }

    @Override
    public void rotate() {
        Plate last_plate = belt[getSize() - 1];

        for (int i = getSize() - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = last_plate;

        //Notify registered customers
        for (int i = 0; i < customer.length; i++) {
            if (customer[i] != null) {
                customer[i].observePlateOnBelt(this, belt[i], i);
            }
        }
    }

    @Override
    public void addBeltObserver(BeltObserver o) {
        beltObserver.add(o);
    }

    @Override
    public void removeBeltObserver(BeltObserver o) {
        beltObserver.remove(o);
    }

    public void notifyObserver(PlateEvent e) {

        for (BeltObserver b : beltObserver) {
            b.handlePlateEvent(e);
        }

    }

    @Override
    public void registerCustomerAtPosition(Customer customers, int position) {
        int normal_position = normalize_position(position);

        if (customers == null) {
            throw new IllegalArgumentException();
        }

        if (customer[normal_position] != null) {
            throw new RuntimeException();
        }

        for (int i = 0; i < customer.length; i++) {
            if (customers == customer[i]) {
                throw new RuntimeException();
            }
        }

        customer[normal_position] = customers;
    }

    @Override
    public Customer unregisterCustomerAtPosition(int position) {

        Customer a = customer[normalize_position(position)];
        customer[normalize_position(position)] = null;
        return a;
    }
}