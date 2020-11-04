package 월간코드챌린지시즌1;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseTernary {
    public int solution(int n) {
        int answer = 0;
        int temp = 1;
        ArrayList<Integer> list = ternary(n);
        Collections.reverse(list);
        for (int i : list) {
            answer += i * temp;
            temp *= 3;
        }
        return answer;
    }

    public ArrayList<Integer> ternary(int value) {
        ArrayList<Integer> ternaryNumbers = new ArrayList<>();
        while (true) {
            ternaryNumbers.add(value % 3);
            value /= 3;
            if (value == 0) {
                break;
            }
        }
        return ternaryNumbers;
    }

    public static void main(String[] args) {
        ReverseTernary reverseTernary = new ReverseTernary();
        ArrayList<Integer> re = reverseTernary.ternary(125);
        System.out.println(reverseTernary.solution(45));
        System.out.println(Integer.toString(45, 3));
    }
}
