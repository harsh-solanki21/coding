package Cloning;

public class Human implements Cloneable{
    int age;
    String name;
    int[] arr;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
        this.arr = new int[]{3, 4, 5, 6, 9, 1};
    }

//    @Override
//    public Object clone() throws CloneNotSupportedException{
//        // this is shallow copy
          // if you change data in the copy object then change will also reflect in the original object
//        return super.clone();
//    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        // this is deep copy
        Human twin = (Human)super.clone(); // this is actually shallow copy

        // make a deep copy
        // if you change data in the copy object then change won't reflect in the original object like shallow copy
        twin.arr = new int[twin.arr.length];
        for (int i = 0; i < twin.arr.length; i++) {
            twin.arr[i] = this.arr[i];
        }
        return twin;
    }

}
