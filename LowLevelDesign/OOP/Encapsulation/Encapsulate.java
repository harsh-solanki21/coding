package LowLevelDesign.OOP.Encapsulation;

public class Encapsulate {

    private String name;
    private int rollNo;
    private int age;


    public String getName() {
        return name;
    }

    public int getRoll() {
        return rollNo;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoll(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public static void main(String[] args) {
        Encapsulate obj = new Encapsulate();

        obj.setName("Harsh");
        obj.setAge(24);
        obj.setRoll(59);

        System.out.println("User's name: " + obj.getName());
        System.out.println("User's age : " + obj.getAge());
        System.out.println("User's roll: " + obj.getRoll());
    }

}
