package a6;

import java.util.*;

import a6.Belt;


public class PriceThresholdBeltIterator implements Iterator<Plate>{
	private Belt _belt;
	private int _start;
	private double _max;
	private ArrayList<Plate> maxplates = new ArrayList<Plate>();
	private ArrayList<Integer> maxposition = new ArrayList<Integer>();
	
	public PriceThresholdBeltIterator(Belt belt, int start_position, double max_price) {
		this._belt = belt;
		this._start = start_position;
		this._max = max_price;
		for (int i = 0; i < belt.getSize(); i++) {
			if (belt.getPlateAtPosition(i) != null) {
				if (belt.getPlateAtPosition(i).getPrice() <= max_price) {
					this.maxplates.add(belt.getPlateAtPosition(i));
					this.maxposition.add(i);
				}
			}
		}
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (this.maxplates.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Plate next() {
		
		// TODO Auto-generated method stub
		if (this.maxplates.size() == 0) {
			throw new java.util.NoSuchElementException();
		}
		Plate temp = this._belt.getPlateAtPosition(this._start);
		if (check(temp)) {
			this._start++;
			return next();
		} else {
			if (temp.getPrice() <= this._max) {
				this._start++;
				return temp;
			}
		}
		this._start++;
		return next();
	}
	
	public boolean check(Plate plate) {
		if (plate == null) {
			return true;
		} else {
			return false;
		}
	}

}
