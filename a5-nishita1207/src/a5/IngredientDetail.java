package a5;

import a5.Ingredient;

//Implements parent interface Ingredient

public class IngredientDetail implements Ingredient {

    public IngredientDetail(){
        
    }
    
    //Constructor is used to define the initialization for the instance method
    
    public IngredientDetail(String name, int caloriesPerOunce,
            double pricePerOunce, boolean isVegetarian, boolean isRice, 
            boolean isShellfish){
            this.name = name;
            this.caloriesPerOunce = caloriesPerOunce;
            this.pricePerOunce = pricePerOunce;
            this.isVegetarian = isVegetarian;
            this.isRice = isRice;
            this.isShellfish = isShellfish;
    }
    
    private String name; 
    private int caloriesPerOunce;
    private double pricePerOunce;
    private boolean isVegetarian;
    private boolean isRice;
    private boolean isShellfish;
    
    /* Override methods allow child class to set unique getter and setter values, different from
     * the parent class
     * 
     * Void setter methods are used to set new placeholder values
     */
        
    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCaloriesPerDollar() {
        return caloriesPerOunce / getPricePerOunce();
    }

    @Override
    public int getCaloriesPerOunce() {
        return caloriesPerOunce;
    }

    @Override
    public double getPricePerOunce() {
        return pricePerOunce;
    }

    @Override
    public boolean getIsVegetarian() {
        return isVegetarian;
    }

    @Override
    public boolean getIsRice() {
        return isRice;
    }

    @Override
    public boolean getIsShellfish() {
        return isShellfish;
    }
    
    public void setName(String name) {
        this.name = name;
    }
  
    public void setCaloriesPerOunce(int caloriesPerOunce) {
        this.caloriesPerOunce = caloriesPerOunce;
    }

    public void setPricePerOunce(double pricePerOunce) {
        this.pricePerOunce = pricePerOunce;
    }

    public void setIsVegetarian(boolean isVegetarian) {
        this.isVegetarian = isVegetarian;
    }

    public void setIsRice(boolean isRice) {
        this.isRice = isRice;
    }

    public void setIsShellfish(boolean isShellfish) {
        this.isShellfish = isShellfish;
    }
    
    @Override
    public boolean equals(Ingredient other) {
        return this.getName().equals(other.getName()) 
                && this.getCaloriesPerOunce() == other.getCaloriesPerOunce()
                && this.getIsRice() == other.getIsRice()
                && this.getIsShellfish() == other.getIsShellfish()
                && this.getIsVegetarian() == other.getIsVegetarian()
                && this.getPricePerOunce() == other.getPricePerOunce()
                && this.getCaloriesPerDollar() == other.getCaloriesPerDollar();
    }
}
