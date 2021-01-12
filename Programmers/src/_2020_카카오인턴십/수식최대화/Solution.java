package _2020_카카오인턴십.수식최대화;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public long solution(String expression) {
        long answer = Long.MIN_VALUE;
        ArrayList<String> marks = new ArrayList<>(Arrays.asList(expression.split("\\d+")));
        ArrayList<String> numbers = new ArrayList<>(Arrays.asList(expression.split("[*,+,-]")));
        calculate(marks, numbers, "+");
        calculate(marks, numbers, "-");
        calculate(marks, numbers, "*");
        answer = Math.max(answer, Math.abs(Long.parseLong(numbers.get(0))));
        marks = new ArrayList<>(Arrays.asList(expression.split("\\d+")));
        numbers = new ArrayList<>(Arrays.asList(expression.split("[*,+,-]")));
        calculate(marks, numbers, "+");
        calculate(marks, numbers, "*");
        calculate(marks, numbers, "-");
        answer = Math.max(answer, Math.abs(Long.parseLong(numbers.get(0))));
        marks = new ArrayList<>(Arrays.asList(expression.split("\\d+")));
        numbers = new ArrayList<>(Arrays.asList(expression.split("[*,+,-]")));
        calculate(marks, numbers, "-");
        calculate(marks, numbers, "+");
        calculate(marks, numbers, "*");
        answer = Math.max(answer, Math.abs(Long.parseLong(numbers.get(0))));
        marks = new ArrayList<>(Arrays.asList(expression.split("\\d+")));
        numbers = new ArrayList<>(Arrays.asList(expression.split("[*,+,-]")));
        calculate(marks, numbers, "-");
        calculate(marks, numbers, "*");
        calculate(marks, numbers, "+");
        answer = Math.max(answer, Math.abs(Long.parseLong(numbers.get(0))));
        marks = new ArrayList<>(Arrays.asList(expression.split("\\d+")));
        numbers = new ArrayList<>(Arrays.asList(expression.split("[*,+,-]")));
        calculate(marks, numbers, "*");
        calculate(marks, numbers, "+");
        calculate(marks, numbers, "-");
        answer = Math.max(answer, Math.abs(Long.parseLong(numbers.get(0))));
        marks = new ArrayList<>(Arrays.asList(expression.split("\\d+")));
        numbers = new ArrayList<>(Arrays.asList(expression.split("[*,+,-]")));
        calculate(marks, numbers, "*");
        calculate(marks, numbers, "-");
        calculate(marks, numbers, "+");
        answer = Math.max(answer, Math.abs(Long.parseLong(numbers.get(0))));
        return answer;
    }

    public static void main(String[] args) {
//        String s = "100-200*300-500+20";
//        ArrayList<String> marks = new ArrayList<>(Arrays.asList(s.split("\\d+")));
//        ArrayList<String> numbers = new ArrayList<>(Arrays.asList(s.split("[*,+,-]")));
//        calculate(marks, numbers, "*");
//        calculate(marks, numbers, "+");
//        calculate(marks, numbers, "-");
//        System.out.println(marks);
//        System.out.println(numbers);
        System.out.println(new Solution().solution("100-200*300-500+20"));
        System.out.println(new Solution().solution("100-200"));
    }

    public static void calculate(List<String> marks, List<String> numbers, String mark) {
        while (marks.contains(mark)) {
            for (int i = 0; i < marks.size(); i++) {
                if (marks.get(i).equals(mark)) {
                    if (mark.equals("+")) {
                        numbers.add(i + 1, String.valueOf(Long.parseLong(numbers.get(i - 1)) + Long.parseLong(numbers.get(i))));
                        marks.remove(i);
                        numbers.remove(i - 1);
                        numbers.remove(i - 1);
                        break;
                    }
                    if (mark.equals("-")) {
                        numbers.add(i + 1, String.valueOf(Long.parseLong(numbers.get(i - 1)) - Long.parseLong(numbers.get(i))));
                        marks.remove(i);
                        numbers.remove(i - 1);
                        numbers.remove(i - 1);
                        break;
                    }
                    if (mark.equals("*")) {
                        numbers.add(i + 1, String.valueOf(Long.parseLong(numbers.get(i - 1)) * Long.parseLong(numbers.get(i))));
                        marks.remove(i);
                        numbers.remove(i - 1);
                        numbers.remove(i - 1);
                        break;
                    }
                }
            }
        }
    }
}
