package a1;

import java.util.*;

public class A1Adept 
{
        public void createProductMap(Scanner sc,HashMap<String, Double> map )
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

                // Read the customer data
          public void createCustomerTreeMap(Scanner sc,HashMap<String, Double> map, double average )
      {
                  int total_customer =  sc.nextInt();
          String first_name  = "";
          String last_name  = "" ;
          int total_items = 0 ;
          int item_count = 0 ;
          double item_price = 0 ;
          String item_name = "" ;

          TreeMap <Double, String>  customerMap = new TreeMap<> ();
          String customer_key ="" ;
          for (int i = 0 ; i < total_customer ; i++)
          {
              first_name =  sc.next();
              last_name = sc.next();
              total_items = sc.nextInt();
              item_price = 0 ;  // reset for next customer
              for (int j = 0 ; j < total_items; j++)
             {
                  item_count = sc.nextInt();
                  item_name =  sc.next() ;
                  item_price = item_price + map.get(item_name) * item_count ;

              }

              customer_key = first_name + " " + last_name ;
              customerMap.put(item_price, customer_key) ;
              average =  average + item_price ; 
          }
            average = average/ total_customer ; 

            printOutPut(customerMap, average);

      }


          public void printOutPut(TreeMap<Double, String> sortedHashMap, double average) {
                  String highestCustomerName = "";
          String lowestCustomerName = "" ;
          Double highestValue = 0.0 ;
          Double lowestValue = 0.0 ;
                lowestCustomerName = sortedHashMap.firstEntry().getValue().toString();

            lowestValue =  (Double) sortedHashMap.firstEntry().getKey(); 

            highestCustomerName = sortedHashMap.lastEntry().getValue().toString();
            highestValue  =  (Double) sortedHashMap.lastEntry().getKey();


            System.out.println("Biggest: "+highestCustomerName+" "+ "("+String.format("%.02f", highestValue)+")") ;
            System.out.println("Smallest: "+ lowestCustomerName+" "+ "("+String.format("%.02f", lowestValue)+")");
            System.out.println("Average: "+ String.format("%.02f" , average)) ;

            }

        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            HashMap<String, Double> ingMap = new HashMap<>();
            Double average  = 0.0 ; 
            A1Adept a1Adept =  new A1Adept() ; 

            a1Adept.createProductMap(sc,ingMap);
            a1Adept.createCustomerTreeMap(sc, ingMap, average) ;


        }               

        }