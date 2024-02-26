package LowLevelDesign.SOLID.LiskovSubstitution.bad;

abstract class Apartment {
    int squareFootage;
    int numberOfBedrooms;

    abstract void setSquareFootage(int sqft);
}
