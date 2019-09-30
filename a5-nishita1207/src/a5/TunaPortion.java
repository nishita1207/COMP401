package a5;

//Extends parent class and creates a new Tuna object

public class TunaPortion extends IngredientPortionDetail{
    
    public TunaPortion(double amount){
        super(amount);
        ingredient = new Tuna();
    }
}
