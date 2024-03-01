package LowLevelDesign.DesignPatterns.CreationalPatterns.Factory.Example1;

public class VanillaIcecream implements Icecream {

    private final String ingredient;
    private String toppings;

    public VanillaIcecream() {
        ingredient = "full fat milk \ncorn starch + 2 tablespoon milk \nvanilla extract \nsugar \n";
    }

    @Override
    public void prepare() {
        System.out.println("\nVanilla Ice Cream is prepared with following ingredient: \n" + ingredient
                + (this.toppings != null && !this.toppings.isEmpty() ? ("with toppings " + this.toppings)
                : "without toppings"));

    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

}
