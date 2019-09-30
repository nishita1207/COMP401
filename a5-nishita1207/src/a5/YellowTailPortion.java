package a5;

//Extends parent class and creates a new YellowTail object

public class YellowTailPortion extends IngredientPortionDetail{
    
    public YellowTailPortion(double amount){
        super(amount);
        ingredient = new Yellowtail();
    }
}
