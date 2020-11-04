package Level1.문자열내p와y의개수;

public class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String[] strings = s.split("");
        int[] arr = new int[2];
        for (String string : strings) {
            if (string.equals("p") || string.equals("P")) {
                arr[0]++;
            }
            if (string.equals("y") || string.equals("Y")) {
                arr[1]++;
            }
        }
        return arr[0] == arr[1];
    }
}
