package LowLevelDesign.DesignPatterns.StructuralPatterns.Adapter.Example2;

public class Socket {

    public Volt getVolt() {
        return new Volt(120);
    }

}
