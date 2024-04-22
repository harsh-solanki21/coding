package LowLevelDesign.DesignPatterns.CreationalPatterns.AbstractFactory;

// Concrete Product - MacCheckbox

public class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Mac checkbox");
    }
}
