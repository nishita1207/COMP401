package a3;

import java.util.*;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;
import a3.Ingredient;
import a3.IngredientImpl;
import a3.IngredientPortionImpl;
import a3.MenuItemImpl; 
import a3.IngredientPortion; 

public class A3Jedi 
{
	 

	    

	public static void main(String[] args) 
	{
		 LinkedHashMap <String,IngredientImpl> TreeIngMap  = new LinkedHashMap () ; 
		 LinkedHashMap <String,MenuItemImpl> TreeMenuMap  = new LinkedHashMap () ;

		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	

        A3Jedi a3Jedi = new A3Jedi() ; 
        a3Jedi.readIngList(sc, TreeIngMap);
	    a3Jedi.readIngPortion(sc,TreeIngMap,TreeMenuMap );
		a3Jedi.placeOrder(sc,TreeIngMap, TreeMenuMap ); 
	    

	}
	
	
	   public void readIngPortion(Scanner sc, LinkedHashMap <String,IngredientImpl> ingMap,  LinkedHashMap<String,MenuItemImpl> map)
       {
               int number_of_menu_items  = sc.nextInt() ;   //read 4 


               for (int i = 0 ; i < number_of_menu_items; i++)
               {
                       String menu_item_name =  sc.next() ;  //read avocado roll
                       int number_of_ingredients = sc.nextInt();

                       IngredientPortionImpl[] arrayOfIngPortion  =  new IngredientPortionImpl[number_of_ingredients] ;


                       for (int j = 0; j < number_of_ingredients; j ++)
                       {
                               String ingredient_name = sc.next();
                               double ingredient_weight = sc.nextDouble();

                               arrayOfIngPortion[j] =  new  IngredientPortionImpl(ingMap.get(ingredient_name), ingredient_weight); 
                       }
                       MenuItemImpl  menuItem = new MenuItemImpl(menu_item_name, arrayOfIngPortion) ; 
                       map.put(menu_item_name,menuItem); 

               }


       }
	
	
	
	
	 public  void readIngList(Scanner sc, LinkedHashMap<String, IngredientImpl> TreeIngMap  )
		{
		     

			 int total_products = sc.nextInt();
			 

			 String ingredient_name = "";
			 Double price_per_ounce = 0.0;
			 Boolean veg_nonveg = true ;  
			 Integer cal_per_ounce = 0;
			 int vegIndex  = 0 ; 
			 int nVegIndex  = 0 ; 
			 
			 for (int i= 0 ; i < total_products ;  i++ )
			 {
				 
				 ingredient_name = sc.next();
				

				 price_per_ounce = sc.nextDouble(); 
			

				 veg_nonveg = sc.nextBoolean();
				 

				 cal_per_ounce = sc.nextInt();

			     TreeIngMap.put(ingredient_name ,new IngredientImpl(ingredient_name, price_per_ounce, cal_per_ounce, veg_nonveg));
				

			   

			 }
			           

		}
	

	

	

	public  void printResult(HashMap <String, Double> resultMap,LinkedHashMap <String,IngredientImpl> ingMap )
	   {
		

		  //iterate through the ing list map
		   System.out.println("The  order will require: "); 
		    Iterator it = ingMap.entrySet().iterator();
		    while (it.hasNext()) 
		    {
		        Map.Entry <String,IngredientImpl> pair = (Map.Entry)it.next();
		        String key = pair.getKey() ; 
		      

		        if (resultMap.get(key) == null)
		    	{
		    		  resultMap.put(key, 0.0);
		    	}
		    		    

		        String value= String.format("%.02f", resultMap.get(key) ); 
		    	        

		    	System.out.println(value + " ounces of" + " " + key); 
		        
 
		    }
		    

	     


	   }
	

	public void placeOrder(Scanner sc, LinkedHashMap <String,IngredientImpl> ingMap, LinkedHashMap <String,MenuItemImpl> menuMap)
	   {
		   String orderItem = "" ; 
		  

		   HashMap<String, Double> result = new HashMap<String, Double>();
		   

		   

		   while (sc.hasNext()) 
		   {
			   orderItem = sc.next();  
			   if (orderItem.equals("EndOrder")) break ; 
			  

			  MenuItemImpl menu = menuMap.get(orderItem); 
			  IngredientPortion[] ingList = menu.getIngredients() ;
			  for (int i = 0 ;i < ingList.length;  i++  )
			  {
			        String key = ingList[i].getName() ; 
			        

			        Double value = ingList[i].getAmount(); 
			        if ( result.containsKey(ingList[i].getName()))
			        {
			        	value += result.get(key); 
			            result.put(key, value);
			        }
			        else
			        {
			        	result.put(key, value);
			        }
			        

			        

		       }  
			    

	      }
		  printResult(result,ingMap); 
	   }
	
	
}