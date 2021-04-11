package containerWithMostWater;

class Solution {
    public int maxArea(int[] height) {
        int maxHeight = 0;
        int water = 0;

        for (int h : height) {
            maxHeight = Math.max(maxHeight, h);
        }

        for (int i = maxHeight; i > 0; i--) {
            int left = 0;
            int right = height.length - 1;

            for (int j = 0; j < height.length; j++) {
                if (i <= height[j]) {
                    left = j;
                    break;
                }
            }

            for (int j = height.length - 1; j >= 0; j--) {
                if (i <= height[j]) {
                    right = j;
                    break;
                }
            }

            if (left < right) {
                water = Math.max(water, (right - left) * i);
            }
        }

        return water;
    }
}
