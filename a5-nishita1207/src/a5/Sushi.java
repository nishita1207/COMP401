package a5;

// Interface creates an outline of methods that can be implemented by classes

public interface Sushi {
    String getName();
    IngredientPortion[] getIngredients();
    int getCalories();
    double getCost();
    boolean getHasRice();
    boolean getHasShellfish();
    boolean getIsVegetarian();
}