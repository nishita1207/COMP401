package sushigame.model;

import comp401sushi.Plate;
import comp401sushi.PlateImpl;

public interface Chef {

	String getName();
	void setName(String name);
	
	void makeAndPlacePlate(Plate plate, int position) 
			throws InsufficientBalanceException, BeltFullException, AlreadyPlacedThisRotationException;
		
	HistoricalPlate[] getPlateHistory(int max_history_length);
	HistoricalPlate[] getPlateHistory();
	
	double getBalance();
	
	boolean alreadyPlacedThisRotation();
	
	public double totalFoodConsumed();
	
	public double totalSpoiledFood();

}
