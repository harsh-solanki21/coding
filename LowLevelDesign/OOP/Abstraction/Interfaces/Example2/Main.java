package LowLevelDesign.OOP.Abstraction.Interfaces.Example2;

public class Main {
    public static void main(String[] args) {
//        Engine car = new Car();
//        car.a;
//        car.acc();
//        car.start();
//        car.stop();

//        Media carMedia = new Car();
//        carMedia.stop();

        NiceCar car = new NiceCar();
        car.start();
        car.startMusic();
        car.stopMusic();
        car.stop();
        car.upgradeEngine();
    }
}
