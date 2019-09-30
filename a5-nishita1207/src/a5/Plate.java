package a5;

/* Collection of abstract methods that can be implemented by classes to inherit the methods to create unique
Plate objects */

public interface Plate {
	
	// Using enumeration allows certain standard colors of Plate objects to be created

    public enum Color {
        RED, GREEN, BLUE, GOLD
    };

    Sushi getContents();

    Sushi removeContents();

    void setContents(Sushi s) throws PlatePriceException;

    boolean hasContents();

    double getPrice();

    Plate.Color getColor();

    double getProfit();
}
