package a1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;


public class A1Jedi {

	public static void main(String[] args) 
	{

	            Scanner sc = new Scanner(System.in);
	            TreeMap<String, Double> priceMap = new TreeMap<String, Double>();
	            createProductMap(sc, priceMap) ; 
	            createCustomerAndProductMap(sc, priceMap);
	            

	}
	

	public static void createProductMap(Scanner sc, TreeMap<String, Double> map )
	{
        

        int total_products = sc.nextInt();
        for (int i = 0; i < total_products ; i++) 
        {
           if (sc.hasNext()) 
           {
            map.put(sc.next(), sc.nextDouble());
           }
        }
	}
	

	

	public static void printOutput(TreeMap<String, Integer> customerMap, TreeMap<String, Integer> productMap, TreeMap<String,Double> priceMap) 
	{
		String productName = "" ; 
		Integer customerCount = 0 ; 
		Integer productCount = 0 ; 
		

	    //print not sold items ...I started removing items from price Catalog as and when customer
        // buys items and remaining items in catalog means few items not sold 
		

	    Iterator iterator  = priceMap.entrySet().iterator();
	    while (iterator.hasNext()) 
	    {
	        HashMap.Entry<String, Double> pair = (HashMap.Entry)iterator.next();
	        System.out.println("No customers bought " + pair.getKey());
	   

	    }
	    

	    //print sold items
	    

	    Iterator it = customerMap.entrySet().iterator();
	    while (it.hasNext()) 
	    {
	    	customerCount = 0 ; 
	    	productCount = 0 ;
	    	

	        HashMap.Entry<String, Integer> pair = (HashMap.Entry)it.next();
	        productName  = pair.getKey() ;
	        customerCount = pair.getValue();
	       

	        productCount = productMap.get(productName); 
	        		

	       System.out.println(customerCount + " customers bought " + productCount + " "+ productName) ;  ;
	        

	        

	    }
	}
	

	public static void createCustomerAndProductMap(Scanner sc, TreeMap<String, Double> priceMap )
	{
		TreeMap<String, Integer> customerMap = new TreeMap<>();
        TreeMap<String, Integer> productMap = new TreeMap<>();
        

        int total_customer =  sc.nextInt();
       

        int total_items = 0 ;
        int item_count = 0 ;
        double item_price = 0 ;
        String item_name = "" ;
        Integer customer_count = 0 ; 
        Integer count = 0 ; 
       
        

        String customer_key ="" ;
        

        for (int i = 0 ; i < total_customer ; i++)
        {
            String fName = sc.next();   //first name
            String lName = sc.next();   //last name
            customer_count =  0; 
            count = 0 ; 
            
             

            total_items = sc.nextInt();
            ArrayList<String> list = new ArrayList() ; 
            

            for (int j = 0 ; j < total_items; j++)
            {
                item_count = sc.nextInt();
                item_name =  sc.next() ;
                count = 0 ;
                

                

                

                // customerCounted =  false ; 
                count = productMap.get(item_name);
                if (count == null) 
                {
                    productMap.put(item_name,item_count);
                    priceMap.remove(item_name ) ; 
                    

                }
                else 
                {
                    productMap.put(item_name, count + item_count);
                    priceMap.remove(item_name ) ; 
                    

                }
                customer_count = customerMap.get(item_name);
                if (customer_count == null) 
                {
                	//adding a new customer for item
                    customerMap.put(item_name, 1);
                   
                   

                }
                else 
                {
                	if ((list.indexOf(fName+lName+item_name) == -1) ) 
                	{
                        customerMap.put(item_name, customer_count + 1);
                        
                	} 
             

                }
               list.add(fName+lName+item_name);           

            }
            

        } 
        

        printOutput(customerMap, productMap, priceMap); 
        

	}
}