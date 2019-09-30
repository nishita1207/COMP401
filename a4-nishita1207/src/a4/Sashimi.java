package a4;

public class Sashimi implements Sushi {

    private IngredientPortion[] ingredients;
    private final SashimiType sashimiType;

    public enum SashimiType {
        TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP
    };

    public Sashimi(SashimiType type) 
    {
        sashimiType = type;
        
        this.ingredients = new IngredientPortion[1]; 
        
        switch(sashimiType){
        case CRAB:
        	ingredients[0] =  new CrabPortion(.75) ; 
        	 break; 
        case EEL:
        	ingredients[0] =  new EelPortion(.75) ; 
        	break; 
        case SHRIMP:
        	ingredients[0] = new ShrimpPortion(.75) ;
        	break; 
        case TUNA:
        	ingredients[0] = new TunaPortion(.75) ; 
        	break; 
        case YELLOWTAIL:
        	ingredients[0] = new YellowtailPortion(.75) ;
        	break; 
        }
        
      
    }

    @Override
    public String getName() {
        switch(sashimiType){
            case CRAB:
                return "crab sashimi";
            case EEL:
                return "eel sashimi";
            case SHRIMP:
                return "shrimp sashimi";
            case TUNA:
                return "tuna sashimi";
            case YELLOWTAIL:
                return "yellowtail sashimi";
            default:
                return "";
        }
    }

    @Override
    public IngredientPortion[] getIngredients() {
        return ingredients.clone();
    }

    @Override
    public void setIngredients(IngredientPortion[] ingredients) {
        this.ingredients = ingredients.clone() ; 
    }
    
    
    @Override
    public int getCalories() {
        double calories = 0;
        System.out.println("getCalories -Sashimi ");
        if (ingredients != null) {
        for (IngredientPortion ingredient : ingredients) {
        	if (ingredient != null) { 
        		System.out.println(ingredient.getName()); 
        		calories = calories + ingredient.getCalories();
        	}
            
        } 	
        }
        else
        	System.out.println("Null getCalories -Sashimi ");
        	
        return (int) (calories + 0.5);
       
    }

    @Override
    public double getCost() {
        double cost = 0.0;
        for (IngredientPortion ingredient : ingredients)  {
        	if (ingredient != null) 
        		cost = cost + ingredient.getCost() ;
        }
        return Math.round(cost * 100 )/ 100D ;
    }

    @Override
    public boolean getHasRice() {
        boolean hasRice = false;
        for (IngredientPortion ingredient : ingredients) {
            hasRice = ingredient.getIsRice();
        }
        return hasRice;
    }

    @Override
    public boolean getHasShellfish() {
        boolean hasShellfish = false;
        for (IngredientPortion ingredient : ingredients) {
            hasShellfish = ingredient.getIsShellfish();
        }
        return hasShellfish;
    }

    @Override
    public boolean getIsVegetarian() {
        boolean isVegetarian = false;
        for (IngredientPortion ingredient : ingredients) {
            isVegetarian = ingredient.getIsVegetarian();
        }
        return isVegetarian;
    }
}