package math;

import java.util.ArrayList;

public class Factors {

    public static void main(String[] args) {
        factors3(20);
    }

    // Brute force approach  O(n)
    static void factors1(int n) {
        for(int i=1; i<=n; i++) {
            if(n%i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    // Optimised approach  O(sqrt(n))
    static void factors2(int n) {
        for(int i=1; i*i<=n; i++) {
            if(n%i == 0) {
                if(n/i == i) {
                    System.out.print(i+ " ");
                }
                else {
                    System.out.print(i + " " + n/i + " ");
                }
            }
        }   // This doesn't give the ans in sorted order
    }    // The below function is the same as this one. The difference is below function will give ans in sorted order.

    // Optimised approach =>  Time and Space = O(sqrt(n))
    static void factors3(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i*i<=n; i++) {
            if(n%i == 0) {
                if(n/i == i) {
                    System.out.print(i+ " ");
                }
                else {
                    System.out.print(i + " ");
                    list.add(n/i);
                }
            }
        }
        for(int i=list.size()-1; i>=0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }

}
