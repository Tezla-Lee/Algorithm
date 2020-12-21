package Peak_Index_in_a_Mountain_Array;

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }
}