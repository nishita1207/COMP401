package a3;

    public class MenuItemImpl implements MenuItem
    {
            private String menuName;
            private IngredientPortion[] ingredients ; 

            public MenuItemImpl(String menuName1,IngredientPortion[] ingredients1)
            { 
            	
            	 if (menuName1 == null || (menuName1.isEmpty())){
                 	throw new RuntimeException("fluffy");
                 }
            	
            	
            	 if (ingredients1 == null || ingredients1.length < 1)	{
                 	throw new RuntimeException("fluffy");
                 }
                   
                   
                    
                    for (int i = 0; i < ingredients1.length; i++) {
                    	if (ingredients1[i] == null) {
                    		throw new RuntimeException("hello");
                    	}
                    }
                    
                   
                    
                    this.menuName = menuName1 ; 
                    this.ingredients = ingredients1 ;
                    
                    
            }

            public String getName()
            {
                   return menuName ; 
            }
            public IngredientPortion[] getIngredients()
            {
                    return ingredients.clone() ; 
            }


            public int getCalories()
            {
                    double calories = 0 ; 


                    for (int i= 0 ; i < ingredients.length ; i++)
                    {
                            calories =  calories + ingredients[i].getCalories(); 

                    }
                    return (int) (calories + .5)  ; 
            }


            public double getCost()
            {
                    double cost = 0.00; 
                    for (int i= 0 ; i < ingredients.length ; i++)
                    {
                            cost  =  cost  +  ingredients[i].getCost() ;
                    }
                    return cost ; 
            }


            public boolean getIsVegetarian()
            {
                    Boolean vegNveg =  true; 
                    for (int i= 0 ; i < ingredients.length ; i++)
                    {
                              if ( ingredients[i].getIsVegetarian() == false)
                              {
                                      vegNveg =  false; 
                              }
                    }
                    return vegNveg; 
            }




    }

	
	

