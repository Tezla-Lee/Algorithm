package level1._제일작은수제거하기;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int[] answer = new int[arr.length - 1];

        int min = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                index = i;
            }
        }

        System.arraycopy(arr, 0, answer, 0, index);

        if (index < answer.length) {
            System.arraycopy(arr, index + 1, answer, index, answer.length - index);
        }

        return answer;
    }
}
