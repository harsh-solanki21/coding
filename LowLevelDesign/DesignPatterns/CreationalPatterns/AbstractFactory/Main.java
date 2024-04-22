package LowLevelDesign.DesignPatterns.CreationalPatterns.AbstractFactory;

// In the below example, we create a WindowsFactory and a MacFactory instance based on the desired operating system.
// We then use these factories to create buttons and checkboxes.
// Calling the render() method on each object outputs the corresponding element being rendered.

public class Main {

    public static void main(String[] args) {
        AbstractFactory windowsFactory = new WindowsFactory();

        Button windowsButton = windowsFactory.createButton();
        windowsButton.render(); // Output: Rendering a Windows button

        Checkbox windowsCheckbox = windowsFactory.createCheckbox();
        windowsCheckbox.render(); // Output: Rendering a Windows checkbox


        AbstractFactory macFactory = new MacFactory();

        Button macButton = macFactory.createButton();
        macButton.render(); // Output: Rendering a Mac button

        Checkbox macCheckbox = macFactory.createCheckbox();
        macCheckbox.render(); // Output: Rendering a Mac checkbox
    }

}
