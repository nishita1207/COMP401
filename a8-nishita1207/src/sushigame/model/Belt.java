package sushigame.model;

import comp401sushi.Plate;

public interface Belt {

	int getRotationCount();

	int getSize();

	void rotate();

	Plate getPlateAtPosition(int position);
	
	int getAgeOfPlateAtPosition(int position);

	int findPlate(Plate plate);

	void registerBeltObserver(BeltObserver o);
	
	void unregisterBeltObserver(BeltObserver o);
	
	Customer getCustomerAtPosition(int position);
}




