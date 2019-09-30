
package a6;

public class BluePlate extends PlateImpl {

    public BluePlate(Sushi contents) throws PlatePriceException {
        this.color = Plate.Color.BLUE;
        this.price = 4.0f;
        System.out.println("Calling Consructor - BluePlate") ; 
        if (contents != null) {
            if (contents.getCost() > this.price) {
                throw new PlatePriceException();
            } else {
                this.contents = contents;
            }
        }
    }
}
