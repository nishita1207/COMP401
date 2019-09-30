package a4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import a4.IngredientPortion;
import a4.IngredientPortionDetail;
import a4.SeaweedPortion;

public class Roll implements Sushi {

    IngredientPortion[] roll_ingredients;
    String name ; 

    public static  void main() {
    	System.out.println("Hello ") ; 
    	IngredientPortion[]roll_ingredients = new IngredientPortion[4] ; 
    	
    	roll_ingredients[0] = new RicePortion(2.5); 
    	roll_ingredients[1] = new RicePortion(2.5); 
    	roll_ingredients[2] = new AvocadoPortion(3.5); 
    	
    	
    	Roll r  =  new Roll("Sushi" , roll_ingredients) ; 
    
    	
    }


	

	public Roll(String name, IngredientPortion[] roll_ingredients) {

	    	

	    	

	    	this.name  = name ; 

	    	HashMap<String,IngredientPortion> map = new HashMap() ; 

	        

	    	boolean containsSeaweed = false;
	    	double lessAmount = 0.1 ; 
	    	

	        if (roll_ingredients == null) {

	        	//IngredientPortionDetail[] seaweed = new IngredientPortionDetail[1];
	            //seaweed[0] = new SeaweedPortion(.1) ; 
	            //this.roll_ingredients = seaweed.clone() ; 
	            //System.out.println("Reached here") ; 
	            throw new RuntimeException("Roll Ingredients cannot be null.");
	         
	            

	        } else {

	            for (IngredientPortion roll_ingredient : roll_ingredients) {

	                if (roll_ingredient == null) {

	                    throw new RuntimeException("Ingredient portion cannot be null.");

	                } else if (roll_ingredient.getName().equals("seaweed") && roll_ingredient.getAmount() >= 0.1 ) {

	                    containsSeaweed = true;

	                }
	                else if (roll_ingredient.getName().equals("seaweed"))
	                {
	                		lessAmount = 0.1 - roll_ingredient.getAmount() ; 
	                }

	          

	                

	                	if ( map.get(roll_ingredient.getName()) == null) 

	                		

	                       map.put(roll_ingredient.getName(), roll_ingredient) ; 

	                    else

	                       map.put(roll_ingredient.getName(), roll_ingredient.combine(map.get(roll_ingredient.getName()))) ;  

	                

	            }

	            System.out.println(map) ; 

	            

	            if (!containsSeaweed) {

	            	

	            	map.put("Seaweed" , new SeaweedPortion(lessAmount)) ;

	            	


	            } else {

	                this.roll_ingredients

	                        = new IngredientPortionDetail[roll_ingredients.length];

	            }

	            

	            

	            System.out.println(map) ; 

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
        this.roll_ingredients = ingredients.clone() ; 
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
                cost = cost + ingredient.getCost() ;
        }
        return Math.round(cost * 100 )/ 100D ;
    }

    @Override
    public boolean getHasRice() {
        boolean hasRice = false;
       
  
        
        for (IngredientPortion ingredient : roll_ingredients) {
        	if (ingredient == null)  
        		{
        		   System.out.println("hi" );
        		   continue ; 
        		}
            hasRice = ingredient.getIsRice();
            if (hasRice == true) 
            	break ; 
            
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
