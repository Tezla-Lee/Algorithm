package 월간코드챌린지시즌1.프로그래밍2;

public class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        toBinary(s);
        answer[0] = count;
        answer[1] = zero;
        return answer;
    }

    static int count = 0;
    static int zero = 0;

    public static void toBinary(String num) {
        if (num.equals("1")) {
            return;
        } else {
            String[] strings = num.split("");
            int l = 0;
            for (String a : strings) {
                if (a.equals("1")) {
                    l++;
                } else {
                    zero++;
                }
            }
            count++;
            toBinary(Integer.toBinaryString(l));
        }
    }
}
