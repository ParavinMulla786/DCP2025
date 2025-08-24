public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        // Edge case: empty array
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Assume the first string as the prefix
        String prefix = strs[0];

        // Compare with each string
        for (int i = 1; i < strs.length; i++) {
            // Shrink prefix until it matches the current string
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        // Test Cases
        String[] test1 = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(test1)); // Output: "fl"

        String[] test2 = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(test2)); // Output: ""

        String[] test3 = {"apple", "ape", "april"};
        System.out.println(longestCommonPrefix(test3)); // Output: "ap"

        String[] test4 = {""};
        System.out.println(longestCommonPrefix(test4)); // Output: ""

        String[] test5 = {"alone"};
        System.out.println(longestCommonPrefix(test5)); // Output: "alone"

        String[] test6 = {}; 
        System.out.println(longestCommonPrefix(test6)); // Output: ""
    }
}
