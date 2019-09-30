
package a4;

public class SeaweedPortion extends IngredientPortionDetail{
    
    public SeaweedPortion(double amount){
        super(amount);
        ingredient = new Seaweed();
    }
   
    @Override
    public IngredientPortion combine(IngredientPortion other) {
        if (other == null) {
            return this;
        } else {
            if (!this.ingredient.equals(other.getIngredient())) {
                throw new RuntimeException("Ingredients are not same.");
            } else {
                double combinedWeight = this.amount + other.getAmount();
                SeaweedPortion ing = new SeaweedPortion(combinedWeight);
                ing.ingredient = new Seaweed();
                return ing;
            }
        }
    }

}
