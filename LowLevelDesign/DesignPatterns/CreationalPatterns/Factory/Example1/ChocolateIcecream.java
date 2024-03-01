package LowLevelDesign.DesignPatterns.CreationalPatterns.Factory.Example1;

public class ChocolateIcecream implements Icecream {

    private final String ingredient;
    private String toppings;

    public ChocolateIcecream() {
        ingredient = "heavy whipping cream \nsweetened condensed milk \nunsweetened cocoa powder \nvanilla extract \n";
    }

    @Override
    public void prepare() {
        System.out.println("\nChocolate Ice Cream is prepared with following ingredient: \n" + ingredient
                + (this.toppings != null && !this.toppings.isEmpty() ? ("with toppings " + this.toppings)
                : "without toppings"));

    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

}
