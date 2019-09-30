package a2;

import java.util.*;

public class A2Adept {

	

		// TODO Auto-generated method stub
		public static ArrayList<String> ingList =  new ArrayList() ;
		public static ArrayList<Double> priceList =new ArrayList() ;
		public static ArrayList<Boolean> vegNonveg = new ArrayList() ; 
		public static ArrayList<Integer> caloriList = new ArrayList() ; 
		

		  

		   public static void main(String[] args)
	       {
	          Scanner sc = new Scanner(System.in);
	          readIngredients(sc) ;
	          readReceipes(sc) ;

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
		   

		   public static void readReceipes(Scanner sc)
			{
			     StringBuffer buff = new StringBuffer("");
				 int totalReceipes = sc.nextInt();
		         int totalIng = 0 ; 
			     String receipeName = "" ; 
			     String IngName = "" ; 
			     Double totalCal =  0.0; 
			     Double totalPrice = 0.0 ; 
			     Double ingWeight = 0.0 ;
			     String recipeType = "Vegetarian"; 
				 

				 for (int i= 0 ; i < totalReceipes ;  i++ )
				 {
					 recipeType = "Vegetarian"; 
					 totalCal =  0.0; 
					 totalPrice = 0.0 ;
				     receipeName =  sc.next(); 
					 totalIng = sc.nextInt();
					 for (int j= 0 ; j < totalIng ;  j++ )
					 {
						 IngName = sc.next(); 
						 ingWeight =  sc.nextDouble(); 
						 totalCal = totalCal +  ( caloriList.get(ingList.indexOf(IngName)) * ingWeight); 
						 totalPrice = totalPrice + (priceList.get(ingList.indexOf(IngName)) * ingWeight);
						 if ( vegNonveg.get(ingList.indexOf(IngName)) == false)
						 {
							 recipeType = "Non-Vegetarian" ;
						 }
						

					 }
					 buff.append(receipeName+":" + "\n") ;
					 buff.append("  " + Math.round(totalCal) + " calories"+ "\n") ;
					 buff.append("  $" + String.format("%.02f", totalPrice) +    "\n") ;
					 buff.append("  " + recipeType + "\n") ; 
				 }
				 

				 

				 System.out.println(buff.toString()) ;
				

			}

}



