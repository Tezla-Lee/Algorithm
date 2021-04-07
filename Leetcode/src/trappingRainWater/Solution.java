package trappingRainWater;

class Solution {
    public int trap(int[] height) {
        int prevMax = 0;
        int prevIndex = 0;
        int water = 0;

        int i = 0;
        while (i < height.length - 1) {
            if (height[i] >= prevMax) {
                for (int j = prevIndex; j < i; j++) {
                    water += prevMax - height[j];
                }
                prevMax = height[i];
                prevIndex = i;
            }
            i++;
        }

        while (prevIndex < height.length - 1) {
            prevMax = height[++prevIndex];
            for (int j = prevIndex; j < height.length; j++) {
                water += prevMax - height[j];
            }
            prevMax = height[i];
            prevIndex = i;
        }

        return water;
    }
}
