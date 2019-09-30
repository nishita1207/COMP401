package a5;

//Extends parent class and creates a new Seaweed object

public class SeaweedPortion extends IngredientPortionDetail{
    
    public SeaweedPortion(double amount){
        super(amount);
        ingredient = new Seaweed();
    }
}
