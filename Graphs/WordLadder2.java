package Graphs;

import java.util.*;

public class WordLadder2 {

    static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord))
            return new ArrayList<>();

        // adjacent words for each word
        Map<String, List<String>> adjacency = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        // does path exist?
        boolean found = false;

        // BFS for shortest path, keep removing visited words
        queue.offer(beginWord);
        dict.remove(beginWord);

        while (!found && !queue.isEmpty()) {
            int size = queue.size();
            // adjacent words in current level
            HashSet<String> explored = new HashSet<>();

            while (size-- > 0) {
                String word = queue.poll();

                if (adjacency.containsKey(word))
                    continue;

                // remove current word from dict, and search for adjacent words
                dict.remove(word);
                List<String> adjacents = getAdjacents(word, dict);
                adjacency.put(word, adjacents);

                for (String adj : adjacents) {
                    if (!found && adj.equals(endWord))
                        found = true;

                    explored.add(adj);
                    queue.offer(adj);
                }
            }
            // remove words explored in current level from dict
            for (String word : explored) {
                dict.remove(word);
            }

        }

        // if a path exist, dfs to find all the paths
        if (found)
            return dfs(beginWord, endWord, adjacency, new HashMap<>());
        else
            return new ArrayList<>();
    }

    private static List<String> getAdjacents(String word, Set<String> dict) {
        List<String> adjs = new ArrayList<>();
        char[] wordChars = word.toCharArray();

        for (int i = 0; i < wordChars.length; i++)
            for (char c = 'a'; c <= 'z'; c++) {
                char temp = wordChars[i];
                wordChars[i] = c;

                String newAdj = new String(wordChars);
                if (dict.contains(newAdj))
                    adjs.add(newAdj);

                wordChars[i] = temp;
            }

        return adjs;
    }

    private static List<List<String>> dfs(String src, String dest, Map<String, List<String>> adjacency, Map<String, List<List<String>>> dp) {
        if (dp.containsKey(src))
            return dp.get(src);

        List<List<String>> paths = new ArrayList<>();

        // reached dest? return list with dest word
        if (src.equals(dest)) {
            paths.add(new ArrayList<>() {{
                add(dest);
            }});
            return paths;
        }

        // no adjacent for curr word? return empty list
        List<String> adjacents = adjacency.get(src);
        if (adjacents == null || adjacents.isEmpty())
            return paths;

        for (String adj : adjacents) {
            List<List<String>> adjPaths = dfs(adj, dest, adjacency, dp);

            for (List<String> path : adjPaths) {
                if (path.isEmpty()) continue;

                List<String> newPath = new ArrayList<>() {{
                    add(src);
                }};
                newPath.addAll(path);

                paths.add(newPath);
            }
        }

        dp.put(src, paths);
        return paths;
    }


    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

        System.out.println(findLadders(beginWord, endWord, wordList));
    }

}
