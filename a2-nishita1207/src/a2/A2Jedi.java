package a2;

import java.util.*;


public class A2Jedi
{
	

	public static HashMap <String, HashMap> receipeList =  new HashMap<String, HashMap>() ;
	public static ArrayList<String> ingList =  new ArrayList() ;
	public static ArrayList<Double> priceList =new ArrayList() ;
	public static ArrayList<Boolean> vegNonveg = new ArrayList() ; 
	public static ArrayList<Integer> caloriList = new ArrayList() ; 
	

	  

	   public static void main(String[] args)
       {
          Scanner sc = new Scanner(System.in);
          readIngredients(sc); 
          readReceipe(sc );
          placeOrder(sc); 

       }
	   

	   public static void readIngredients(Scanner sc)
		{
		     

			 int total_products = sc.nextInt();
	

		

			 

			 for (int i= 0 ; i < total_products ;  i++ )
			 {
			

				 ingList.add(sc.next()); 
				 priceList.add(sc.nextDouble());
				 vegNonveg.add(sc.nextBoolean());
				 caloriList.add(sc.nextInt()); 
	

			   

			 }
			 

		}
	   

	   

	   public static void readReceipe(Scanner sc)
	   {
		   HashMap <String, Double> ingList  = new HashMap <String, Double> () ; 
		   String receipeName = "" ; 
		   int numbeOfIngWithinReceipe = 0; 
		   

		  

		   //read number of recipes 
		   int numbeOfReceipes = sc.nextInt() ; 
		   for (int i = 0 ; i < numbeOfReceipes ; i++ )
		   {
			   receipeName = sc.next(); 
			   numbeOfIngWithinReceipe =  sc.nextInt() ; 
			   ingList = new HashMap<String, Double>();  
			   for (int j  = 0 ;  j < numbeOfIngWithinReceipe ;  j++ )
			   {
				   ingList.put(sc.next() ,sc.nextDouble()) ;
				   receipeList.put(receipeName, ingList); 
			   }
		   }
		  

	   }
	   

	   public static void printResult(HashMap <String, Double> resultMap)
	   {
	      
		   System.out.println("The order will require:");
		   for (int i = 0 ; i < ingList.size() ; i++ )
		   {
			   

		    String key = ingList.get(i) ; 
		    if (resultMap.get(key) == null)
		    {
		    	resultMap.put(key, 0.0);
		    }
		    

		    String value= String.format("%.02f",  resultMap.get(key) ); 
	        
		
	        System.out.println(value + " ounces of" +  " " + key); 
	        

	      }
	   }
	        		

	   public static void placeOrder(Scanner sc)
	   {
		   String orderItem = "" ; 
		   HashMap <String, Double> ingList  = new HashMap <String, Double> () ;
		   HashMap<String, Double> result = new HashMap<String, Double>();
		   

		   

		   while (sc.hasNext()) 
		   {
			  orderItem = sc.next();
			  

			  if ( orderItem.equals("EndOrder")) break ; 
			  

			  

			  ingList = receipeList.get(orderItem) ; 
			 

			

			    Iterator iterator  = ingList.entrySet().iterator();
			    while (iterator.hasNext()) 
			    {
			        HashMap.Entry<String, Double> pair = (HashMap.Entry)iterator.next();
			        String key =  pair.getKey();
			        Double value =  pair.getValue() ; 
			        

			        if ( result.containsKey(key))
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
		  printResult(result); 
	   }
}

