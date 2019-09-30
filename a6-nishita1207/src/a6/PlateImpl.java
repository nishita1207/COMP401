package a6;

public class PlateImpl implements Plate {

    protected Sushi contents;
    protected Plate.Color color;
    protected double profit;
    protected double price;

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
        
    	System.out.println("Set Contents" + " price " +  price ) ;
    	System.out.println("Set Contents" + " cost " +  s.getCost() ) ;
    	System.out.println("Set Contents" + " " +  s.getName() ) ;
    	if (s == null) {
            throw new IllegalArgumentException("Contents cannot be null.");
        } else if (price < s.getCost()) {
        	System.out.println("Set Contents" + " " +  price + s.getCost()) ;
            throw new PlatePriceException();
        } else {
        	System.out.println("price is not less than cost of the plate" ) ;
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
        	System.out.println("get Profit" + " " + profit) ; 
            return Math.round(profit * 100 )/ 100D ;
        }
    }
}
