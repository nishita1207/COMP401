
package sushigame.view;

import java.util.Comparator;

import sushigame.model.Chef;

public class LowToHighBalanceComparator implements Comparator<Chef> {

	@Override
	public int compare(Chef n, Chef m) {
		return (int) (Math.round(n.getBalance()*100.0) - 
				Math.round(m.getBalance()*100));
	}			
}