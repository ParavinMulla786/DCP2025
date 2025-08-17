public class FindDuplicateNumber {
    public static int findDuplicate(int[] arr) {
        
        int slow = arr[0];
        int fast = arr[0];
        
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);
        
        
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        
        return slow; 
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 2, 2};
        System.out.println("Duplicate: " + findDuplicate(arr1)); 

        int[] arr2 = {3, 1, 3, 4, 2};
        System.out.println("Duplicate: " + findDuplicate(arr2)); 

        int[] arr3 = {1, 1};
        System.out.println("Duplicate: " + findDuplicate(arr3)); 

        int[] arr4 = {1, 4, 4, 2, 3};
        System.out.println("Duplicate: " + findDuplicate(arr4)); 
    }
}
