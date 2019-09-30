package a5;

/* Collection of abstract methods that can be implemented by classes to inherit the methods to create unique
ingredient portion objects */

public interface IngredientPortion {

    Ingredient getIngredient();

    String getName();

    double getAmount();

    double getCalories();

    double getCost();

    boolean getIsVegetarian();

    boolean getIsRice();

    boolean getIsShellfish();

    IngredientPortion combine(IngredientPortion other);
}
