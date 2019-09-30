package a4;

public class Nigiri implements Sushi {

    private IngredientPortion[] ingredients;

    private final NigiriType nigiriType;

    public enum NigiriType {
        TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP
    };

    public Nigiri(NigiriType type) {
        nigiriType = type;
        

        
        this.ingredients = new IngredientPortion[2]; 
        
        ingredients[1] = new RicePortion(.5) ;
        
        switch(nigiriType){
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
        switch(nigiriType){
            case CRAB:
                return "crab nigiri";
            case EEL:
                return "eel nigiri";
            case SHRIMP:
                return "shrimp nigiri";
            case TUNA:
                return "tuna nigiri";
            case YELLOWTAIL:
                return "yellowtail nigiri";
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
        for (IngredientPortion ingredient : ingredients) {
        	if (ingredient != null) 
        		calories = calories + ingredient.getCalories() ;
        	else
        		System.out.println("Getting null somehow");
        }
        return (int) (calories + .5);
    }

    @Override
    public double getCost() {
        double cost = 0.0;
        for (IngredientPortion ingredient : ingredients) {
        	if (ingredient != null) 
        		cost = cost + ingredient.getCost() ;
        }
        return Math.round(cost * 100) /100D ;
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
        for (IngredientPortion ingredient : ingredients)  {
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

