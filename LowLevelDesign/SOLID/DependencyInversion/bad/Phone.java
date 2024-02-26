package LowLevelDesign.SOLID.DependencyInversion.bad;

public class Phone {

    public String generateWeatherAlert(String weatherConditions) {
        String alert = "It is " + weatherConditions;
        return alert;
    }

}
