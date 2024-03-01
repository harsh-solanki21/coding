package LowLevelDesign.DesignPatterns.CreationalPatterns.Factory.Example1;

public class IcecreamFactory {

    public static Icecream getInstance(String type) {
        switch (type) {
            case "1":
                return new VanillaIcecream();
            case "2":
                return new StrawberryIcecream();
            case "3":
                return new ChocolateIcecream();
        }

        return null;
    }

}
