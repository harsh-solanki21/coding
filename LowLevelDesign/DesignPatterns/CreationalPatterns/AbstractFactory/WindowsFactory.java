package LowLevelDesign.DesignPatterns.CreationalPatterns.AbstractFactory;

// Concrete Factory - WindowsFactory

public class WindowsFactory implements AbstractFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
