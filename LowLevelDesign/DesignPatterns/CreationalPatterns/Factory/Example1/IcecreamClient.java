package LowLevelDesign.DesignPatterns.CreationalPatterns.Factory.Example1;

import java.util.Scanner;

public class IcecreamClient {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your choice of ice cream");
        System.out.println("1 - vanilla \n2 - strawberry \n3 - chocolate");
        String type = sc.nextLine();

        System.out.println("\nEnter your choice of toppings");
        String topping = sc.nextLine();

        Icecream icecream = IcecreamFactory.getInstance(type);
        icecream.setToppings(topping);
        icecream.prepare();

        System.out.println("\nThank You :)");
    }

}
