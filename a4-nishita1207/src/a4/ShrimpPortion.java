
package a4;

public class ShrimpPortion extends IngredientPortionDetail{
    
    public ShrimpPortion(double amount){
        super(amount);
        ingredient = new Shrimp();
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
                ShrimpPortion ing = new ShrimpPortion(combinedWeight);
                ing.ingredient = new Shrimp();
                return ing;
            }
        }
    }

}