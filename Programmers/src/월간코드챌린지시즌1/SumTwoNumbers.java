package 월간코드챌린지시즌1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class SumTwoNumbers {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        HashSet<Integer> sum = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                sum.add(numbers[i] + numbers[j]);
            }
        }

        // 1. Iterator 이용
        Iterator<Integer> it = sum.iterator();
        int[] answer = new int[sum.size()];
        int count = 0;
        while (it.hasNext()) {
            int i = it.next();
            answer[count] = i;
            count++;
        }
        Arrays.sort(answer);
        return answer;

        // 2. stream 을 이용한 방법
//        return sum.stream().sorted().mapToInt(Integer::intValue).toArray(); //
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SumTwoNumbers().solution(new int[]{2, 1, 3, 4, 1})));
        System.out.println(Arrays.toString(new SumTwoNumbers().solution(new int[]{5, 0, 2, 7})));

    }
}
