package Heap.PriorityQueue;

import java.util.PriorityQueue;

public class MinNumberOfRefuelingStops {

    // https://leetcode.com/problems/minimum-number-of-refueling-stops/

    static int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> fuelInStation = new PriorityQueue<>((x, y) -> (y - x));
        int ans = 0;
        int fuel = startFuel;

        for (int[] station : stations) {
            while (fuel < station[0]) {
                if (fuelInStation.isEmpty()) {
                    return -1;
                }
                fuel += fuelInStation.poll();
                ans++;
            }
            fuelInStation.offer(station[1]);
        }

        while (fuel < target) {
            if (fuelInStation.isEmpty()) {
                return -1;
            }
            fuel += fuelInStation.poll();
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int target = 100, startFuel = 10;
        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};

        System.out.println(minRefuelStops(target, startFuel, stations));
    }

}
