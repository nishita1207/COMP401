
package a6;

public class GreenPlate extends PlateImpl {

    public GreenPlate(Sushi contents) throws PlatePriceException {
        this.color = Plate.Color.GREEN;
        this.price = 2.0f;
       
        
        if (contents != null) {
            if (contents.getCost() > this.price) {
            	
                throw new PlatePriceException();
            } else {
                this.contents = contents;
            }
        }
        
    }
}