package a1;

import java.util.Scanner;

public class A1Novice
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String output = "\n" ;
		
		// Your code goes here.
		int totalPeople = scan.nextInt();
		   for (int i=0; i < totalPeople; i++ ) 
		   {
	 		   String customerInfo = scan.next();
			   char first_name = customerInfo.charAt(0);
			   String last_name = scan.next();
			   int total_quantity = scan.nextInt();
			   double price_of_item = 0; 
			   
			   
			   for (int j=0 ; j < total_quantity ; j++)
			   {
				   int quantity_of_item = scan.nextInt();
				   scan.next();
				   price_of_item =  price_of_item + scan.nextDouble() * quantity_of_item;
				  // price_of_item = (double) Math.round(price_of_item * 100 / 100);
				   String str = String.format("%.02f", price_of_item ); 
				   //System.out.println(str);
				   
				   
			   }
			   
			   output = output+ first_name + ". " + last_name + ": "  + String.format("%.02f", price_of_item ) + "\n" ;
			  
		   }
		   System.out.println(output); 
		
		   if (scan != null )
			   scan.close();
		  
		  // Double.toString(price_of_item)
	}
}
	