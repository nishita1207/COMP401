
package a4;

public interface Sushi {
    String getName();
    IngredientPortion[] getIngredients();
    void setIngredients(IngredientPortion[] ingredients) ; 
    int getCalories();
    double getCost();
    boolean getHasRice();
    boolean getHasShellfish();
    boolean getIsVegetarian();
}
