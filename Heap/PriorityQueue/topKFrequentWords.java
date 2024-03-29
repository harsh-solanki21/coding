package Heap.PriorityQueue;

import java.util.*;

public class topKFrequentWords {

    // TC - O(n * log k), SC - O(n)
    static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<String>((word1, word2) -> {
            if (countMap.get(word1) == countMap.get(word2)) {
                return word2.compareTo(word1);
            }
            return countMap.get(word1) - countMap.get(word2);
        });

        for (String word : countMap.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }

        Collections.reverse(ans);
        return ans;
    }


    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;

        System.out.println(topKFrequent(words, k));
    }

}
