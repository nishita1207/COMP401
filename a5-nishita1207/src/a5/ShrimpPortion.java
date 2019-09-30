package a5;

//Extends parent class and creates a new Shrimp object

public class ShrimpPortion extends IngredientPortionDetail{
    
    public ShrimpPortion(double amount){
        super(amount);
        ingredient = new Shrimp();
    }
}
