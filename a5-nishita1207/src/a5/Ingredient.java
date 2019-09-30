package a5;

/* Collection of abstract methods that can be implemented by classes to inherit the methods to create unique
ingredient objects */

public interface Ingredient {

    String getName();

    double getCaloriesPerDollar();

    int getCaloriesPerOunce();

    double getPricePerOunce();

    boolean equals(Ingredient other);

    boolean getIsVegetarian();

    boolean getIsRice();

    boolean getIsShellfish();
}
