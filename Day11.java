import java.util.*;

public class PermutationsOfString {
    public static List<String> permuteUnique(String s) {
        List<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[chars.length];
        backtrack(chars, new StringBuilder(), used, result);
        return result;
    }

    private static void backtrack(char[] chars, StringBuilder current, boolean[] used, List<String> result) {
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            current.append(chars[i]);
            backtrack(chars, current, used, result);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique("abc"));
        System.out.println(permuteUnique("aab"));
        System.out.println(permuteUnique("aaa"));
        System.out.println(permuteUnique("a"));
        System.out.println(permuteUnique("abcd"));
    }
}
