package a7;

import comp401sushi.Plate;

public interface Belt {

    public int getSize();

    public Plate getPlateAtPosition(int position);

    public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException;

    public void clearPlateAtPosition(int position);

    default public Plate removePlateAtPosition(int position) {
        Plate result = getPlateAtPosition(position);
        if (result == null) {
            throw new java.util.NoSuchElementException("No plate");
        }
        clearPlateAtPosition(position);
        return result;
    }

    public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException;

    public void rotate();

    void addBeltObserver(BeltObserver o);

    void removeBeltObserver(BeltObserver o);

    public void registerCustomerAtPosition(Customer c, int position);

    public Customer unregisterCustomerAtPosition(int position);

}