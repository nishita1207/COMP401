package a4;

public class RicePortion extends IngredientPortionDetail{
    
    public RicePortion(double amount){
        super(amount);
        ingredient = new Rice();
    }
}
