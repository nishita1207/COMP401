package a2;

import java.util.Scanner;
import java.util.TreeMap;



public class A2Novice 
{
	   
       
	  
	   public static void main(String[] args)
       {
		 TreeMap<Double, String> TreeMapVeg = new TreeMap<Double, String>() ; 
	     TreeMap <Double, String> TreeMapNVeg  = new TreeMap<Double, String> () ; 
          Scanner sc = new Scanner(System.in);
          Readinput(sc, TreeMapVeg, TreeMapNVeg) ;
          
          
       }

	    public static void printOutput(TreeMap<Double, String> TreeMapVeg, TreeMap<Double, String> TreeMapNVeg) 
	    {
	    	System.out.println("Number of vegetarian ingredients:  " + TreeMapVeg.size()) ; 
	    	
	    	if (TreeMapVeg.size() > 0 )
	    	{
	    		if ( TreeMapVeg.lastEntry().getKey() > TreeMapNVeg.lastEntry().getKey())
	    		{
	    			System.out.println("Highest cals/$: " + TreeMapVeg.lastEntry().getValue());
	    		}
	    	}
	    	else
	    	{	
	    			if  (TreeMapNVeg.size() > 0 )
	    			{
	    				System.out.println("Highest cals/$: " +TreeMapNVeg.lastEntry().getValue());
	    			}
	    			
	    	}
	    	
	    	
	    	if (TreeMapVeg.size() > 0 )
	    	{
	    		if ( TreeMapVeg.firstEntry().getKey() < TreeMapNVeg.firstEntry().getKey())
	    		{
	    			System.out.println("Lowest cals/$: " + TreeMapVeg.firstEntry().getValue());
	    		}
	    		else
	    			System.out.println("Lowest cals/$: " +TreeMapNVeg.firstEntry().getValue());
	    		
	    	}
	    	else
	    		{
	    			if  (TreeMapNVeg.size() > 0 )
	    			{
	    				System.out.println("Lowest cals/$: " +TreeMapNVeg.firstEntry().getValue());
	    			}
	    		}	
	    	
	    }
	    
	    public static void Readinput(Scanner sc, TreeMap<Double, String> TreeMapVeg, TreeMap<Double, String> TreeMapNVeg)
		{
		     
			 int total_products = sc.nextInt();
			 String ingredient_name = "";
			 Double price_per_ounce = 0.0;
			 Boolean veg_nonveg = true ;  
			 int cal_per_ounce = 0;
			 Double caloriePerDollar = 0.0; 
			 
			 for (int i= 0 ; i < total_products ;  i++ )
			 {
				 ingredient_name = sc.next();
				
				 price_per_ounce = sc.nextDouble(); 
			
				 veg_nonveg = sc.nextBoolean();
				
				 cal_per_ounce = sc.nextInt();
				 
				 caloriePerDollar = cal_per_ounce / price_per_ounce ; 
				
				 if (veg_nonveg == true) {
					 TreeMapVeg.put(caloriePerDollar, ingredient_name);
					
					 
				 }else {
					 TreeMapNVeg.put(caloriePerDollar, ingredient_name); 
					
				 }
				 
			   
			 }
			 
		  printOutput(TreeMapVeg, TreeMapNVeg) ; 
          //System.out.println(TreeMapVeg);
          //System.out.println(TreeMapNVeg);
		}
	}
   