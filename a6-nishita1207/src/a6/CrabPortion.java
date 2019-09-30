
package a6;

public class CrabPortion extends IngredientPortionDetail{
    
    public CrabPortion(double amount){
        super(amount);
        ingredient = new Crab();
    }
}
