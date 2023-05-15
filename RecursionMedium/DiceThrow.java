package RecursionMedium;

import java.util.ArrayList;

public class DiceThrow {

    // 6 faces Dice
    static void dice(String s, int target) {
        if (target == 0) {
            System.out.println(s);
            return;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(s + i, target - i);
        }
    }

    // 6 faces Dice with ArrayList return type
    static ArrayList<String> diceRet(String s, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(s);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            list.addAll(diceRet(s + i, target - i));
        }
        return list;
    }

    // Dice with custom number of faces
    static void diceCustom(String s, int target, int face) {
        if (target == 0) {
            System.out.println(s);
            return;
        }
        for (int i = 1; i <= face && i <= target; i++) {
            diceCustom(s + i, target - i, face);
        }
    }

    // Dice with custom number of faces with ArrayList return type
    static ArrayList<String> diceCustomRet(String s, int target, int face) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(s);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= face && i <= target; i++) {
            list.addAll(diceCustomRet(s + i, target - i, face));
        }

        return list;
    }

    public static void main(String[] args) {
//        dice("", 4);
//        System.out.println(diceRet("", 4));
//        diceCustom("", 5, 8);
        System.out.println(diceCustomRet("", 4, 5));
    }

}
