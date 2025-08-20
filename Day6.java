import java.util.*;

public class ZeroSumSubarrays {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Long, List<Integer>> prefixMap = new HashMap<>();
        long prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            
            if (prefixSum == 0) {
                result.add(new int[]{0, i});
            }

            
            if (prefixMap.containsKey(prefixSum)) {
                for (int startIndex : prefixMap.get(prefixSum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }

            
            prefixMap.computeIfAbsent(prefixSum, k -> new ArrayList<>()).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        
        int[] arr1 = {1, 2, -3, 3, -1, 2};
        int[] arr2 = {4, -1, -3, 1, 2, -1};
        int[] arr3 = {1, 2, 3, 4};
        int[] arr4 = {0, 0, 0};
        int[] arr5 = {-3, 1, 2, -3, 4, 0};

        System.out.println(printResult(findZeroSumSubarrays(arr1))); 
        System.out.println(printResult(findZeroSumSubarrays(arr2))); 
        System.out.println(printResult(findZeroSumSubarrays(arr3))); 
        System.out.println(printResult(findZeroSumSubarrays(arr4))); 
        System.out.println(printResult(findZeroSumSubarrays(arr5))); 
    }

    private static String printResult(List<int[]> result) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int[] sub : result) {
            sb.append("(").append(sub[0]).append(", ").append(sub[1]).append("), ");
        }
        if (!result.isEmpty()) sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}
