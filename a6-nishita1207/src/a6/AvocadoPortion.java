
package a6;

public class AvocadoPortion extends IngredientPortionDetail{
    
    public AvocadoPortion(double amount){
        super(amount);
        ingredient = new Avocado();
    }
}