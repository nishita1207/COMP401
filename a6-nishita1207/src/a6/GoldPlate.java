
package a6;

public class GoldPlate extends PlateImpl {

	
    public GoldPlate(Sushi contents, double price) throws PlatePriceException , IllegalArgumentException{
        this.color = Plate.Color.GOLD;


        
        if (price < 5.0) {
            throw new IllegalArgumentException("Price cannot be less than 5.0");
        } else {
            if (contents != null) 
            {
          
                if ( contents.getCost() > price) 
                	
                {
                	
                    throw new PlatePriceException();
                } else 
                {
                	
                	
                    this.price = price;
                    this.contents = contents;
                }
                
            }
            else
            	if (contents == null) 
            	{
            		
            		this.price = price;
            	}
            
        }
        
    }
}

