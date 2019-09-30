
package a6;


public class SeaweedPortion extends IngredientPortionDetail{
    
    public SeaweedPortion(double amount){
        super(amount);
        ingredient = new Seaweed();
    }
}
