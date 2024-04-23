package LowLevelDesign.DesignPatterns.BehavioralPatterns.Observer.Example2;

public class Subscriber implements Observer {

    String name;

    Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void notified(String title) {
        System.out.println("Hello " + name + ", New video uploaded :: " + title);
    }

}
