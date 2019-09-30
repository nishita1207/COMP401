
package a6;

public class EelPortion extends IngredientPortionDetail{
    
    public EelPortion(double amount){
        super(amount);
        ingredient = new Eel();
    }
}
