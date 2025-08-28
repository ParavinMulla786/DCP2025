import java.util.HashMap;

public class SubstringsWithKDistinct {

    // Function to count substrings with exactly k distinct characters
    public static int countSubstringsWithKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k > s.length()) {
            return 0;
        }
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    // Helper function to count substrings with at most k distinct characters
    private static int atMostKDistinct(String s, int k) {
        int left = 0, count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Shrink the window if more than k distinct characters
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            // Add substrings ending at 'right'
            count += right - left + 1;
        }
        return count;
    }

    // Main method to test
    public static void main(String[] args) {
        String s1 = "pqpqs";
        int k1 = 2;
        System.out.println(countSubstringsWithKDistinct(s1, k1)); // Output: 7

        String s2 = "aabacbebebe";
        int k2 = 3;
        System.out.println(countSubstringsWithKDistinct(s2, k2)); // Output: 10

        String s3 = "a";
        int k3 = 1;
        System.out.println(countSubstringsWithKDistinct(s3, k3)); // Output: 1

        String s4 = "abc";
        int k4 = 3;
        System.out.println(countSubstringsWithKDistinct(s4, k4)); // Output: 1

        String s5 = "abc";
        int k5 = 2;
        System.out.println(countSubstringsWithKDistinct(s5, k5)); // Output: 2
    }
}
