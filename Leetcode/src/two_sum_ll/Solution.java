package two_sum_ll;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        int size = numbers[numbers.length - 1] - numbers[0] + 1;
        int[][] index = new int[size][2];

        for (int i = 0; i < numbers.length; i++) {
            if (index[numbers[i] - numbers[0]][0] != 0) {
                index[numbers[i] - numbers[0]][1] = i + 1;
            } else {
                index[numbers[i] - numbers[0]][0] = i + 1;
            }
        }

        for (int number : numbers) {
            if (target - number - numbers[0] < size && index[target - number - numbers[0]][0] > 0) {
                if (number == target - number) {
                    answer[0] = index[number - numbers[0]][0];
                    answer[1] = index[target - number - numbers[0]][1];
                } else {
                    answer[0] = index[number - numbers[0]][0];
                    answer[1] = index[target - number - numbers[0]][0];
                }
                break;
            }
        }

        return answer;
    }
}