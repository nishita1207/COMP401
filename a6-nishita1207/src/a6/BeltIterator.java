package a6;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class BeltIterator implements Iterator<Plate> {

    protected int start_position1;
    protected Belt belt;
    protected boolean called = false;


    public BeltIterator(Belt b, int start_position1) {

        this.belt = b;

        int position = 0;

        if (start_position1 < 0) {
            position = ((start_position1 % b.getSize()) + b.getSize()) % b.getSize();
        } else if (start_position1 > 0) {
            position = start_position1 % b.getSize();
        }

        this.start_position1 = position;

    }

    public boolean hasNext() {

        for (int i = 0; i < belt.getSize() + start_position1; i++) {
            if (belt.getPlateAtPosition(i) != null) {
                return true;
            }
        }

        return false;
    }

    public Plate next() {

        called = true;

        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            for (int i = this.start_position1; true; i++) {

                if (i == this.belt.getSize()) {
                    i = 0;
                }

                this.start_position1 = i;

                if (this.belt.getPlateAtPosition(i) != null) {
                    this.start_position1++;
                    return this.belt.getPlateAtPosition(i);
                }
            }
        }


    }

    public void remove() {

        if (!called) {
            throw new IllegalStateException();
        }

        called = false;
        belt.removePlateAtPosition(start_position1 - 1);


    }
}