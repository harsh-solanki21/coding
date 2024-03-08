package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule1 {

    // https://leetcode.com/problems/course-schedule
    // As we just need to return boolean, we can also use Cycle Detection in Directed Graph using DFS

    // Topological sort (Kahn's Algorithm)
    static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int j : graph.get(i)) {
                indegree[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (int j : graph.get(node)) {
                indegree[j]--;
                if (indegree[j] == 0) {
                    q.offer(j);
                }
            }
        }

        return count == numCourses;
    }


    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};

        System.out.println(canFinish(numCourses, prerequisites));
    }

}
