package a3;


    public class IngredientPortionImpl implements IngredientPortion
    {
            private Ingredient ing;
            private double amount;


            public IngredientPortionImpl(Ingredient ing1, double amount1)
            {
                   
          
                                 this.ing = ing1 ; 
                                 this.amount = amount1;
                                 
                                 
                            if (ing1 == null) {
                            	throw new RuntimeException("Input parameter is not Ingredient type");
                            }
             
                            if (amount1 < 0) {
                            	throw new RuntimeException("Input parameter is not Ingredient type");
                            }


        
                           

            }

    
    public Ingredient getIngredient()
    {
            return ing;
    }
    public double getAmount()
    {
            return amount;


    }
    public String getName()
    {
            return ing.getName();
    }
    public boolean getIsVegetarian()
    {
            return ing.getIsVegetarian();
    }
    public double getCalories()
    {
            return ing.getCaloriesPerOunce() * amount;


    }
    public double getCost()
    {
            return ing.getPricePerOunce() * amount;
    }
    public IngredientPortion combine(IngredientPortion other)
    {
           //double combinedWeight = this.amount + other.getAmount();


           //return new IngredientPortionImpl(this.ing, combinedWeight);
           
           
           
   			

  			 if (other == null) {
  		            return this;
  		        } else {
  		            if (!this.ing.equals(other.getIngredient())) {
  		                throw new RuntimeException("Ingredients are not same.");
  		            } else {
  		                double combinedWeight = this.amount + other.getAmount();
  		                return new IngredientPortionImpl(this.ing, combinedWeight);
  		            }
  		        }

  		 
    }


}

