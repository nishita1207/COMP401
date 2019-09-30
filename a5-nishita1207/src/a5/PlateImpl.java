package a5;

//Implements parent interface Plate

public class PlateImpl implements Plate {

	// Using protected instance variables allows subclasses to access them
	
    protected Sushi contents;
    protected Plate.Color color;
    protected double profit;
    protected double price;

    
  /*Override methods are used to allow the child class to assign unique inputs different
    from the original parent interface*/
    
    @Override
    public Sushi getContents() {
        return contents;
    }

    @Override
    public Sushi removeContents() {
    	System.out.println("remove Contents" ) ;
        if (!hasContents()) {
            return null;
        } else {
            Sushi s = contents;
            contents = null;
            return s;
        }
    }

    @Override
    public void setContents(Sushi s) throws PlatePriceException ,IllegalArgumentException {
        
    	
    	if (s == null) {
            throw new IllegalArgumentException("Contents cannot be null.");
        } else if (price < s.getCost()) {
        	
            throw new PlatePriceException();
        } else {
        	
            this.contents = s;
        }
    }

    @Override
    public boolean hasContents() {
        return contents instanceof Sushi;
    }

    @Override
    public double getPrice() {
    	System.out.println("get Profit" + price) ; 
        return price;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public double getProfit() {
        if (contents == null) {
            return 0.0;
        } else {
        	
        	double profit =  price - contents.getCost(); 
        	 
            return Math.round(profit * 100 )/ 100D ;
        }
    }
}
