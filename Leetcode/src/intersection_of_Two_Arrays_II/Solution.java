package intersection_of_Two_Arrays_II;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] count = new int[1001];
        List<Integer> list = new ArrayList<>();

        for (int num : nums1) {
            count[num]++;
        }

        for (int num : nums2) {
            if (count[num] > 0) {
                count[num]--;
                list.add(num);
            }
        }

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}