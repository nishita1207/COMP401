package sushigame.view;

import java.util.Comparator;

import sushigame.model.Chef;

public class FoodSpoiledOrderComparator implements Comparator<Chef> {

	@Override
	public int compare(Chef n, Chef m) {
		return (int) (m.totalSpoiledFood() - n.totalSpoiledFood());
	}			
}
