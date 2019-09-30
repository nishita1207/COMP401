
package a6;

public class TunaPortion extends IngredientPortionDetail{
    
    public TunaPortion(double amount){
        super(amount);
        ingredient = new Tuna();
    }
}