package LowLevelDesign.DesignPatterns.CreationalPatterns.AbstractFactory;

// Concrete Product - WindowsCheckbox

public class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Windows checkbox");
    }
}
