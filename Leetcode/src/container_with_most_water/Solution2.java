package container_with_most_water;

public class Solution2 {
    public int maxArea(int[] height) {
        int water = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            if (height[left] == height[right]) {
                water = Math.max(water, (right - left) * height[left]);
                left++;
                right--;
            } else if (height[left] > height[right]) {
                water = Math.max(water, (right - left) * height[right]);
                right--;
            } else {
                water = Math.max(water, (right - left) * height[left]);
                left++;
            }
        }
        return water;
    }
}
