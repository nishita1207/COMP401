package sushigame.view;

import java.awt.BorderLayout;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;
import sushigame.model.Chef;
import sushigame.model.SushiGameModel;

public class ScoreboardWidget extends JPanel implements BeltObserver {

	private SushiGameModel game_model;
	private JLabel display;
	private Chef[] opponent_chefs;
	private Chef[] chefs;
	private String setString = "";
	
	public ScoreboardWidget(SushiGameModel gm) {
		game_model = gm;
		game_model.getBelt().registerBeltObserver(this);
		
		display = new JLabel();
		display.setVerticalAlignment(SwingConstants.TOP);
		setLayout(new BorderLayout());
		add(display, BorderLayout.CENTER);
		
		display.setText(makeScoreboardHTML());
	}

	private String makeScoreboardHTML() {
		String sb_html = "<html>";
		sb_html += "<p><big>" + "SCOREBOARD" + "</big></p>" + "<br>";
	
		opponent_chefs= game_model.getOpponentChefs();
		chefs = new Chef[opponent_chefs.length+1];
		chefs[0] = game_model.getPlayerChef();
		for (int i=1; i<chefs.length; i++) {
			chefs[i] = opponent_chefs[i-1];
		}
		
		Arrays.sort(chefs, new HighToLowBalanceComparator());
		if (setString.equals("highToLow")) {
		
			Arrays.sort(chefs, new HighToLowBalanceComparator());
			for (Chef c : chefs) {
				sb_html += c.getName() + " balance is " + Math.round(c.getBalance()*100.0)/100.0 + "<br>";
			}
			

		} else if (setString.equals("lowtohigh")) {
			Arrays.sort(chefs, new LowToHighBalanceComparator());
			for (Chef c : chefs) {
				sb_html += c.getName() + " balance is " + Math.round(c.getBalance()*100.0)/100.0 + "<br>";
			} 
			
			
		} else if (setString.equals("foodsold")) {
			Arrays.sort(chefs, new FoodSoldComparator());
			for (Chef c : chefs) {
				if (c.totalFoodConsumed() == 1) {
					sb_html += c.getName() + " has sold " + (int) c.totalFoodConsumed() + " plates" + "<br>";
				} else {
					sb_html += c.getName() + " has sold " + (int) c.totalFoodConsumed() + " plates" + "<br>";
				}
			}
			
		// Sorts array from highest food spoiled to lowest food spoiled
		} else if (setString.equals("foodspoiled")) {
			Arrays.sort(chefs, new FoodSpoiledOrderComparator());
			for (Chef c : chefs) {
				if (c.totalSpoiledFood() == 1) {
					sb_html += c.getName() + " has " + (int) c.totalSpoiledFood() + " spoiled plates" + "<br>";
				} else {
					sb_html += c.getName() + " has " + (int) c.totalSpoiledFood() + " spoiled plates" + "<br>";
				}
			}
			
		} else {
			for (Chef c : chefs) {
				sb_html += c.getName() + " balance is " + Math.round(c.getBalance()*100.0)/100.0 + "<br>";
			}
		}
		
		sb_html += "<br>";
		sb_html += "<br>";

		sb_html += "<h2>" + "Click each Plate for info &nbsp;&nbsp;" + "<h2>";
		
		sb_html += "<h2>" + "Plate Prices: " + "</h2>";
		sb_html += "Red Plate: $1" + "<br>";
		sb_html += "Green Plate: $2" + "<br>";
		sb_html += "Blue Plate: $4" + "<br>";
		sb_html += "Gold Plate: $5 - $10" + "<br>";
		

		return sb_html;
	}

	public void refresh() {
		display.setText(makeScoreboardHTML());		
	}
	
	@Override
	public void handleBeltEvent(BeltEvent e) {
		if (e.getType() == BeltEvent.EventType.ROTATE) {
			refresh();
		}		
	}

	public void setString(String x) {
		setString = x;
	}

}
