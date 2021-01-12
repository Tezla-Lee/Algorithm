package _2018_카카오블라인드채용._1차_다트게임;

public class Solution {
    static int tempNum = 0;
    static int answer = 0;

    public int solution(String dartResult) {
        String[] dartResults = dartResult.split("");
        for (int i = 0; i < dartResults.length; i++) {
            if (dartResults[i].equals("S") || dartResults[i].equals("D") || dartResults[i].equals("T")) {
                int temp = calc(dartResults, dartResults[i], i);
                answer += temp;
                System.out.println(temp);
            }
        }
        return answer;
    }

    public static int calc(String[] arr, String c, int i) {
        int index;
        int num;
        switch (c) {
            case "S":
                index = 1;
                break;
            case "D":
                index = 2;
                break;
            case "T":
                index = 3;
                break;
            default:
                index = 0;
        }

        if (i - 1 != 0 && arr[i - 1].equals("0") && arr[i - 2].equals("1")) {
            num = 10;
        } else {
            num = Integer.parseInt(arr[i - 1]);
        }


        if (arr.length - 1 > i && arr[i + 1].equals("*")) {
            answer += tempNum;
            tempNum = (int) (Math.pow(num, index) * 2);
            return tempNum;
        } else if (arr.length - 1 > i && arr[i + 1].equals("#")) {
            tempNum = (int) -Math.pow(num, index);
            return tempNum;
        } else {
            tempNum = (int) Math.pow(num, index);
            return tempNum;
        }
    }
}