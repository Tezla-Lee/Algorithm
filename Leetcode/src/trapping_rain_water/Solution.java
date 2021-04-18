package trapping_rain_water;

class Solution {
    public int trap(int[] height) {
        int water = 0;

        int i = 0;
        while (height[i] == 0) {
            i++;
        }

        while (i < height.length - 1) {
            int j = i + 1;

            while (height[i] > height[j]) {
                j++;
            }

            if (i < j) {
                for (int k = i + 1; k < j; k++) {
                    water += height[k];
                }
            }
            i++;
        }

        return water;
    }
}
