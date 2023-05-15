package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateInFileSystem {

    // https://leetcode.com/problems/find-duplicate-file-in-system/

    static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < paths.length; i++) {
            String s = paths[i];
            String[] str = s.split(" ");
            String prefix = str[0] + "/";

            for (int j = 1; j < str.length; j++) {
                String nc = str[j];
                int t = nc.length() - 1;

                while (t >= 0 && nc.charAt(t) != '(') {
                    t--;
                }
                String name = nc.substring(0, t);
                String content = nc.substring(t + 1, nc.length() - 1);
                map.computeIfAbsent(content, a -> new ArrayList<>());
                map.get(content).add(prefix + name);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                res.add(map.get(key));
            }
        }

        return res;
    }


    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        System.out.println(findDuplicate(paths));
    }

}
