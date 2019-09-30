package a5;
import a5.Nigiri;
import a5.Nigiri.NigiriType;

public class GoldPlate extends PlateImpl {

	public static void main(String[] args)
	{
		System.out.println("Main Gold Plate") ; 
		/*
		NigiriType type = NigiriType.CRAB ; 
		Sushi s = new Nigiri(type); 
		try
		{
		  GoldPlate gp = new GoldPlate(s, 6); 
		}
		catch(Exception ex)
		{
			System.out.print("exception" );
		}
		*/
	}
	
    public GoldPlate(Sushi contents, double price) throws PlatePriceException , IllegalArgumentException{
        this.color = Plate.Color.GOLD;

        System.out.println("Price of the plate " +  price) ;
        
        if (price < 5.0) {
            throw new IllegalArgumentException("Price cannot be less than 5.0");
        } else {
            if (contents != null) {
                if (contents.getCost() > this.price) {
                	System.out.println("Throwing Exception" + contents.getCost() + price ) ;
                    throw new PlatePriceException();
                } else {
                	
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
