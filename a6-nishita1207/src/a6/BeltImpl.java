package a6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BeltImpl implements Belt {

    private int belt_size;
    private Plate[] plates;

    public BeltImpl(int belt_size) {

        if (belt_size < 0) {
            throw new IllegalArgumentException();
        } else {
            this.belt_size = belt_size;
            plates = new Plate[belt_size];
        }

    }

    @Override
    public int getSize() {
        return belt_size;
    }

    @Override
    public Plate getPlateAtPosition(int position) {

        if (position < 0) {
            position = ((position % belt_size) + belt_size) % belt_size;
        } else {
            position = position % belt_size;
        }


        if (plates[position] == null) {
            return null;
        } else {
            return plates[position];
        }
    }

    @Override
    public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {

        if (position < 0) {
            position = ((position % belt_size) + belt_size) % belt_size;
        } else {
            position = position % belt_size;
        }

        if (plate == null) {
            throw new IllegalArgumentException();
        } else if (getPlateAtPosition(position) != null) {
            throw new BeltPlateException(position, plate, this);
        } else {
            plates[position] = plate;
        }
    }

    @Override
    public void clearPlateAtPosition(int position) {

        if (position < 0) {
            position = ((position % belt_size) + belt_size) % belt_size;
        }

        plates[position] = null;

    }

    @Override
    public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {


        if (position < 0) {
            position = ((position % belt_size) + belt_size) % belt_size;
        } else {
            position = position % belt_size;
        }


        for (int i = 0; i < plates.length; i++) {

            int new_position = position + i;

            if (plates[new_position] == null) {

                plates[new_position] = plate;
                return new_position;
            }

        }
        throw new BeltFullException(this);

    }

    @Override
    public Plate removePlateAtPosition(int position) {

        if (position < 0) {
            position = ((position % belt_size) + belt_size) % belt_size;
        } else {
            position = position % belt_size;
        }

        Plate p = getPlateAtPosition(position);

        if (p == null) {
            throw new NoSuchElementException();
        } else {
            clearPlateAtPosition(position);
            return p;
        }
    }

    @Override
    public Iterator<Plate> iterator() {
        return new BeltIterator(this, 0);
    }

    public Iterator<Plate> iterator(double max_price) {

        return new PriceThresholdBeltIterator(this, 0, max_price);

    }

    public Iterator<Plate> iterator(Plate.Color color) {

        return new ColorFilteredBeltIterator(this, 0, color);
    }


    @Override
    public Iterator<Plate> iteratorFromPosition(int position) {
        return new BeltIterator(this, position);
    }

    public Iterator<Plate> iteratorFromPosition(int position, double max_price) {
        return new PriceThresholdBeltIterator(this, position, max_price);
    }


    public Iterator<Plate> iteratorFromPosition(int position, Plate.Color color) {
        return new ColorFilteredBeltIterator(this, position, color);
    }

    @Override
    public void rotate() {

        Plate[] new_plates = new PlateImpl[this.getSize()];

        for (int i = 0; i < getSize() - 1; i++) {

            new_plates[i + 1] = plates[i];
        }

        plates = new_plates;

    }
}

    
