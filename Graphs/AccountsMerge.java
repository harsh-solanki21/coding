package Graphs;

import java.util.*;

public class AccountsMerge {

    // https://leetcode.com/problems/accounts-merge/description/

    static int[] parent, size;

    private static int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        parent[node] = find(parent[node]);
        return parent[node];
    }

    private static void unionBySize(int i, int j) {
        int iLeader = find(i);
        int jLeader = find(j);
        if (iLeader == jLeader) {
            return;
        }
        if (size[iLeader] < size[jLeader]) {
            parent[iLeader] = jLeader;
            size[jLeader] += size[iLeader];
        } else {
            parent[jLeader] = iLeader;
            size[iLeader] += size[jLeader];
        }
    }

    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        HashMap<String, Integer> mailMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!mailMap.containsKey(mail)) {
                    mailMap.put(mail, i);
                } else {
                    unionBySize(i, mailMap.get(mail));
                }
            }
        }

        HashMap<Integer, Set<String>> distinctGroupMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            parent[i] = find(i);
            int accountSize = accounts.get(i).size();
            distinctGroupMap.putIfAbsent(parent[i], new HashSet<>());
            distinctGroupMap.get(parent[i]).addAll(accounts.get(i).subList(1, accountSize));  // removing 0th element i.e. name
        }

        List<List<String>> ans = new ArrayList<>();
        for (int group : distinctGroupMap.keySet()) {
            List<String> emailList = new ArrayList<>(distinctGroupMap.get(group));
            Collections.sort(emailList);
            emailList.addFirst(accounts.get(group).getFirst());  // adding the name to the first element of the merged account
            ans.add(emailList);
        }

        return ans;
    }


    public static void main(String[] args) {
        String[][] accountsArr = {
                {"John", "j1@mail.com", "j2@mail.com", "j3@mail.com"},
                {"John", "j4@mail.com"},
                {"Fern", "f5@m.co", "f1@m.co", "f0@m.co"},
                {"Mary", "m1@mail.com"},
                {"John", "j1@mail.com", "j5@mail.com"},
                {"Fern", "f4@m.co", "f1@m.co"},
        };

        List<List<String>> accounts = new ArrayList<>();
        for (String[] i : accountsArr) {
            accounts.add(Arrays.asList(i));
        }

        System.out.println(accountsMerge(accounts));
    }

}
