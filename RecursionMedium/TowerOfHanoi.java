package RecursionMedium;

public class TowerOfHanoi {

    static void towerOfHanoi(int n, char sourceRod, char destinationRod, char helperRod) {
        if (n == 0)
            return;
        towerOfHanoi(n - 1, sourceRod, helperRod, destinationRod);
        System.out.println("Move disk " + n + " from rod " + sourceRod + " to rod " + destinationRod);
        towerOfHanoi(n - 1, helperRod, destinationRod, sourceRod);
    }

    public static void main(String[] args) {
        int n = 3; // Number of disks
        towerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are names of rods
    }

}
