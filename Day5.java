import java.util.*;

public class LeadersInArray {

    public static List<Integer> findLeaders(int[] arr) {
        int n = arr.length;
        List<Integer> leaders = new ArrayList<>();

        int maxFromRight = arr[n - 1];
        leaders.add(maxFromRight);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                maxFromRight = arr[i];
                leaders.add(maxFromRight);
            }
        }

      
        Collections.reverse(leaders);
        return leaders;
    }

    public static void main(String[] args) {
       
        int[] arr1 = {16, 17, 4, 3, 5, 2};
        int[] arr2 = {1, 2, 3, 4, 0};
        int[] arr3 = {7, 10, 4, 10, 6, 5, 2};
        int[] arr4 = {5};
        int[] arr5 = {100, 50, 20, 10};
        int[] arr6 = {1, 2, 3, 1000000}; 

        System.out.println("Leaders: " + findLeaders(arr1)); 
        System.out.println("Leaders: " + findLeaders(arr2)); 
        System.out.println("Leaders: " + findLeaders(arr3)); 
        System.out.println("Leaders: " + findLeaders(arr4)); 
        System.out.println("Leaders: " + findLeaders(arr5)); 
        System.out.println("Leaders: " + findLeaders(arr6)); 
    }
}
