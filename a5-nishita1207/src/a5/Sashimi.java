package a5;

import a5.CrabPortion;

import a5.EelPortion;
import a5.IngredientPortion;
import a5.ShrimpPortion;
import a5.TunaPortion;
import a5.YellowTailPortion;

/* Creates a Sashimi object that is an instance of Sushi. Uses enumeration and switch cases to create variations of the 
 * Sashimi object. Override methods are used to set new values to methods originally outlined in the parent interface.
 */

public class Sashimi implements Sushi {

    private IngredientPortion[] ingredients;
    private final SashimiType sashimiType;

    public enum SashimiType {
        TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP
    };

    public Sashimi(SashimiType type) {
        sashimiType = type;
        {
            
            this.ingredients = new IngredientPortion[1]; 
            
            switch(sashimiType){
            case CRAB:
            	ingredients[0] =  new CrabPortion(.75) ; 
            	 break; 
            case EEL:
            	ingredients[0] =  new EelPortion(.75) ; 
            	break; 
            case SHRIMP:
            	ingredients[0] = new ShrimpPortion(.75) ;
            	break; 
            case TUNA:
            	ingredients[0] = new TunaPortion(.75) ; 
            	break; 
            case YELLOWTAIL:
            	ingredients[0] = new YellowTailPortion(.75) ;
            	break; 
            }
            
          
        }
    }

    @Override
    public String getName() {
        switch(sashimiType){
            case CRAB:
                return "crab sashimi";
            case EEL:
                return "eel sashimi";
            case SHRIMP:
                return "shrimp sashimi";
            case TUNA:
                return "tuna sashimi";
            case YELLOWTAIL:
                return "yellowtail sashimi";
            default:
                return "";
        }
    }

    @Override
    public IngredientPortion[] getIngredients() {
        return ingredients;
    }

    @Override
    public int getCalories() {
        double calories = 0;
        for (IngredientPortion ingredient : ingredients) {
            calories = calories + ingredient.getCalories() * ingredient.getAmount();
        }
        return (int) (calories+ 0.5);
    }

    @Override
    public double getCost() {
        double cost = 0.0;
        for (IngredientPortion ingredient : ingredients) {
            cost = cost + ingredient.getCost() * ingredient.getAmount();
        }
        System.out.print(cost);
        return cost;
    }

    @Override
    public boolean getHasRice() {
        boolean hasRice = true;
        for (IngredientPortion ingredient : ingredients) {
            hasRice = ingredient.getIsRice();
        }
        return hasRice;
    }

    @Override
    public boolean getHasShellfish() {
        boolean hasShellfish = true;
        for (IngredientPortion ingredient : ingredients) {
            hasShellfish = ingredient.getIsShellfish();
        }
        return hasShellfish;
    }

    @Override
    public boolean getIsVegetarian() {
        boolean isVegetarian = true;
        for (IngredientPortion ingredient : ingredients) {
            isVegetarian = ingredient.getIsVegetarian();
        }
        return isVegetarian;
    }
}
