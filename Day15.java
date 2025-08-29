public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int[] index = new int[128];
        int maxLength = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            left = Math.max(index[s.charAt(right)], left);
            maxLength = Math.max(maxLength, right - left + 1);
            index[s.charAt(right)] = right + 1;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String[] testCases = {"abcabcbb", "bbbbb", "pwwkew", "abcdefgh", "a"};
        for (String s : testCases) {
            System.out.println(lengthOfLongestSubstring(s));
        }
    }
}
