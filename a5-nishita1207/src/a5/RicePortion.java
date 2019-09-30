package a5;

//Extends parent class and creates a new Rice object

public class RicePortion extends IngredientPortionDetail{
    
    public RicePortion(double amount){
        super(amount);
        ingredient = new Rice();
    }
}
