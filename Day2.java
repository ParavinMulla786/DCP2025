public class MissingNumber {

    
    public static int findMissing(int[] arr) {
        int n = arr.length + 1; 
        long expectedSum = (long) n * (n + 1) / 2; 
        long actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return (int)(expectedSum - actualSum);
    }

    public static void main(String[] args) {
        
        System.out.println("Missing number: " + findMissing(new int[]{1, 2, 4, 5})); 
        System.out.println("Missing number: " + findMissing(new int[]{2, 3, 4, 5})); 
        System.out.println("Missing number: " + findMissing(new int[]{1, 2, 3, 4})); 
        System.out.println("Missing number: " + findMissing(new int[]{1}));          

        
        int n = 1000000;
        int[] bigArr = new int[n - 1];
        for (int i = 1; i < n; i++) {
            bigArr[i - 1] = i; // Missing 1,000,000
        }
        System.out.println("Missing number: " + findMissing(bigArr)); // 1000000
    }
}
