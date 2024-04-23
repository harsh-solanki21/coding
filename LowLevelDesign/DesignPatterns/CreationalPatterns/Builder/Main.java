package LowLevelDesign.DesignPatterns.CreationalPatterns.Builder;

public class Main {

    public static void main(String[] args) {
        // using builder to get the object in a single line of code and without any inconsistent state or arguments management issues
        Computer computer = new Computer.ComputerBuilder("500 GB", "2 GB").setBluetoothEnabled(false).setGraphicsCardEnabled(true).build();
        System.out.println(computer);
    }

}
