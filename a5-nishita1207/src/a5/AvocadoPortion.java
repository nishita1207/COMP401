package a5;

// Extends parent class and creates a new Avocado object

public class AvocadoPortion extends IngredientPortionDetail{
    
    public AvocadoPortion(double amount){
        super(amount);
        ingredient = new Avocado();
    }
}
