package DesignPatterns.Creational_Patterns.Builder;

import java.awt.Color;
import java.awt.Dimension;

public interface Builder {

    Builder setCeilingHeight(int ceilingHeight);

    Builder setDimensions(Dimension dimensions);

    Builder setFloorNumber(int floorNumber);

    Builder setNumberOfDoors(int numberOfDoors);

    Builder setNumberOfWindows(int numberOfWindows);
    
    Builder setWallColor(Color wallColor);
    
}
