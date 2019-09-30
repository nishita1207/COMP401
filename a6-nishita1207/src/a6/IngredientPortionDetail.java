package a6;

public class IngredientPortionDetail implements IngredientPortion {

    IngredientDetail ingredient;
    double amount;

    IngredientPortionDetail(double amount) {
        if(amount <= 0){
            throw new RuntimeException("Amount should be greater than 0.");
        }
        this.amount = amount;
    }

    @Override
    public Ingredient getIngredient() {
        return ingredient;
    }

    @Override
    public String getName() {
        return ingredient.getName();
    }

    @Override
    public double getAmount() {
        return ingredient.getCaloriesPerDollar();
    }

    @Override
    public double getCalories() {
        return ingredient.getCaloriesPerOunce() * this.amount;
    }

    @Override
    public double getCost() {
    	
        return ingredient.getPricePerOunce()  * this.amount;
    }

    @Override
    public boolean getIsVegetarian() {
        return ingredient.getIsVegetarian();
    }

    @Override
    public boolean getIsRice() {
        return ingredient.getIsRice();
    }

    @Override
    public boolean getIsShellfish() {
        return ingredient.getIsShellfish();
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
                return new IngredientPortionDetail(combinedWeight);
            }
        }
    }
}