package LowLevelDesign.DesignPatterns.CreationalPatterns.AbstractFactory;

// Concrete Factory - MacFactory

public class MacFactory implements AbstractFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
