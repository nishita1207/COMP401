    
package sushigame.view;

import java.util.Comparator;

import sushigame.model.Chef;

public class FoodSoldComparator implements Comparator<Chef> {

	@Override
	public int compare(Chef n, Chef m) {
		return (int) (m.totalFoodConsumed() - 
				n.totalFoodConsumed());
	}			
}
