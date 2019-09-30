package a6;

public class RedPlate extends PlateImpl {

    public RedPlate(Sushi contents) throws PlatePriceException {
        this.color = Plate.Color.RED;
        this.price = 1.0f;

        if (contents != null) {
            if (contents.getCost() > this.price) {
                throw new PlatePriceException();
            } else {
                this.contents = contents;
            }
        } 
    }
}
