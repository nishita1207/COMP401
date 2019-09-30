package a5;

//Extends parent class and creates a new Crab object

public class CrabPortion extends IngredientPortionDetail{
    
    public CrabPortion(double amount){
        super(amount);
        ingredient = new Crab();
    }
}
