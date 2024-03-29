package LowLevelDesign.OOP.Inheritance;

class Electronics {
    public Electronics() {
        System.out.println("Class Electronics");
    }

    public void deviceType() {
        System.out.println("Device Type: Electronics");
    }
}

class Grinder extends Electronics {
    public Grinder() {
        System.out.println("Class Grinder");
    }

    public void category() {
        System.out.println("Category - Grinder");
    }
}

class WetGrinder extends Grinder {
    public WetGrinder() {
        System.out.println("Class WetGrinder");
    }

    public void grindingTech() {
        System.out.println("Grinding Technology - WetGrinder");
    }
}


public class MultiLevel {

    public static void main(String[] arguments) {
        WetGrinder wt = new WetGrinder();
        wt.deviceType();
        wt.category();
        wt.grindingTech();
    }

}
