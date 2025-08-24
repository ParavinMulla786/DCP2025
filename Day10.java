import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] test1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(test1));

        String[] test2 = {""};
        System.out.println(groupAnagrams(test2));

        String[] test3 = {"a"};
        System.out.println(groupAnagrams(test3));

        String[] test4 = {"abc", "bca", "cab", "xyz", "zyx", "yxz"};
        System.out.println(groupAnagrams(test4));

        String[] test5 = {"abc", "def", "ghi"};
        System.out.println(groupAnagrams(test5));
    }
}
