package LowLevelDesign.DesignPatterns.CreationalPatterns.AbstractFactory;

// Concrete Product - MacButton

public class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Mac button");
    }
}
