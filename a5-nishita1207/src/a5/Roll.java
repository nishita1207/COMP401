package a5;

import java.util.HashMap;

import java.util.Iterator;
import java.util.Map;

import a5.IngredientPortion;
import a5.IngredientPortionDetail;
import a5.SeaweedPortion;
import a5.Sushi;

/* Creates a Roll object that is an instance of Sushi. Uses enumeration and switch cases to create variations of the 
 * Roll object. Override methods are used to set new values to methods originally outlined in the parent interface.
 */

public class Roll implements Sushi {

    IngredientPortion[] roll_ingredients;
    String name ; 

public Roll(String name, IngredientPortion[] roll_ingredients) {
    	
    	
    	this.name  = name ; 
    	HashMap<String,IngredientPortion> map = new HashMap() ; 
        
    	boolean containsSeaweed = false;
        if (roll_ingredients == null) 
        {
            throw new RuntimeException("Roll Ingredients cannot be null.");
        } 
        else 
        {
            for (IngredientPortion roll_ingredient : roll_ingredients) 
            {
            	 
                if (roll_ingredient == null) 
                {
                    throw new RuntimeException("Ingredient portion cannot be null.");
                } else if (roll_ingredient.getName().equals("seaweed") && roll_ingredient.getAmount() >= 0.1) 
                {
                    containsSeaweed = true;
                    
                }
                if (!containsSeaweed) {
                	
                	map.put("Seaweed" , new SeaweedPortion(0.1)) ;
                	map.put(roll_ingredient.getName(), roll_ingredient) ; 
                	containsSeaweed = true ; 
                	
                }	
                else
                {
                	if ( map.get(roll_ingredient.getName()) == null) 
                		
                       map.put(roll_ingredient.getName(), roll_ingredient) ; 
                    else
                       map.put(roll_ingredient.getName(), roll_ingredient.combine(map.get(roll_ingredient.getName()))) ;  
                }
                
            }

            //System.out.println(map) ; 
            
            
            	
                
            
            
            //System.out.println(map) ; 
            //System.out.println(map.get("rice").getAmount()); 
            
            IngredientPortionDetail[] arr = new IngredientPortionDetail[map.size()];
            
            int i = 0 ; 
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
            	
                Map.Entry pair = (Map.Entry)it.next();
                arr[i] = (IngredientPortionDetail) pair.getValue() ; 
                i++ ; 
            }         
                
            this.roll_ingredients = arr.clone(); 
            }
        }
     

    @Override
    public String getName() {
        return name; 
    }

    @Override
    public IngredientPortion[] getIngredients() {
        return roll_ingredients.clone();
    }
    
    public void setIngredients(IngredientPortion[] ingredients) {
        this.roll_ingredients = ingredients ; 
    }
    

    @Override
    public int getCalories() {
        double calories = 0;
        for (IngredientPortion ingredient : roll_ingredients) {
        	if (ingredient != null) 
                calories = calories + ingredient.getCalories() ;
        }
        return (int) (calories + .5);
    }

    @Override
    public double getCost() {
        double cost = 0.0;
        for (IngredientPortion ingredient : roll_ingredients) {
        	if (ingredient != null) 
        	{
                cost = cost + ingredient.getCost() ;
                System.out.println(cost + ingredient.getName() + ingredient.getAmount());
        	}
        }
        return Math.round(cost * 100 )/ 100D ;
    }

    @Override
    public boolean getHasRice() {
        boolean hasRice = false;
        for (IngredientPortion ingredient : roll_ingredients) {
            hasRice = ingredient.getIsRice();
        }
        return hasRice;
    }

    @Override
    public boolean getHasShellfish() {
        boolean hasShellfish = false;
        for (IngredientPortion ingredient : roll_ingredients) {
            hasShellfish = ingredient.getIsShellfish();
        }
        return hasShellfish;
    }

    @Override
    public boolean getIsVegetarian() {
        boolean isVegetarian = false;
        for (IngredientPortion ingredient : roll_ingredients) {
            isVegetarian = ingredient.getIsVegetarian();
        }
        return isVegetarian;
    }

}