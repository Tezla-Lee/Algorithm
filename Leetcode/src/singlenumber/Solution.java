package singlenumber;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0 && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public int singleNumber3(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i : nums) {
            priorityQueue.add(i);
        }

        while (priorityQueue.size() > 1) {
            int temp = priorityQueue.poll();
            if (temp == priorityQueue.peek()) {
                priorityQueue.poll();
            } else {
                return temp;
            }
        }
        return priorityQueue.peek();
    }

    public int singleNumber4(int[] nums) {
        int[] arr = new int[60001];
        for (int i : nums) {
            arr[i + 30000]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                return i - 30000;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        new Solution().singleNumber4(new int[]{4, 1, 2, 1, 2});
    }
}