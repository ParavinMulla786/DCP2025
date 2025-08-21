public class TrappingRainWater {

    public static int trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0; 

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        
        int[] h1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Output: " + trap(h1)); // 6

        int[] h2 = {4, 2, 0, 3, 2, 5};
        System.out.println("Output: " + trap(h2)); // 9

        int[] h3 = {1, 1, 1};
        System.out.println("Output: " + trap(h3)); // 0

        int[] h4 = {5};
        System.out.println("Output: " + trap(h4)); // 0

        int[] h5 = {2, 0, 2};
        System.out.println("Output: " + trap(h5)); // 2

        int[] h6 = {0, 0, 0, 0};
        System.out.println("Output: " + trap(h6)); // 0
    }
}
