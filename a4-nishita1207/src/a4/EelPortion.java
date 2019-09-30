package a4;

public class EelPortion extends IngredientPortionDetail{
    
    public EelPortion(double amount){
        super(amount);
        ingredient = new Eel();
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
                EelPortion ing = new EelPortion(combinedWeight);
                ing.ingredient = new Eel();
                return ing;
            }
        }
    }

}
