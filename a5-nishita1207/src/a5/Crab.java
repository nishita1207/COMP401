package a5;

import a5.IngredientDetail;

//Child class that extends IngredientDetail to initialize parameters of new ingredient object

public class Crab extends IngredientDetail{
    public Crab(){
        super("crab", 37, 0.72, false, false, true);
    }
}