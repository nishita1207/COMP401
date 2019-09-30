
package a6;

public class ShrimpPortion extends IngredientPortionDetail{
    
    public ShrimpPortion(double amount){
        super(amount);
        ingredient = new Shrimp();
    }
}
