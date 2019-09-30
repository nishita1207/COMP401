package a5;

//Extends parent class and creates a new Eel object

public class EelPortion extends IngredientPortionDetail{
	
	// calls parent constructor for amount parameter and creates a new avocado object
    
    public EelPortion(double amount){
        super(amount);
        ingredient = new Eel();
    }
}
