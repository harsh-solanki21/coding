package LowLevelDesign.SOLID.LiskovSubstitution.good;

public class BedroomAdder {

    public void addBedroom(PenthouseSuite penthouse) {
        penthouse.numberOfBedrooms += 1;
    }

}
