package a5;

// Extends built in java class exception

public class PlatePriceException extends Exception{
    PlatePriceException(){
    	
    	//calls parent constructor
        super("Illegal Plate Price");
    }
}
