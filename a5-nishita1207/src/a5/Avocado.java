package a5;

import a5.IngredientDetail;

// Child class that extends IngredientDetail to initialize parameters of new ingredient object

public class Avocado extends IngredientDetail{
    public Avocado(){
        super("avocado", 42, 0.24, true, false, false);
    }
}
