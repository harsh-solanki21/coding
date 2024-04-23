package LowLevelDesign.DesignPatterns.StructuralPatterns.Adapter.Example2;

public interface SocketAdapter {

    Volt get120Volt();

    Volt get12Volt();

    Volt get3Volt();

}
