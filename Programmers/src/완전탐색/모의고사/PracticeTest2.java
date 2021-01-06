package 완전탐색.모의고사;

// https://programmers.co.kr/learn/courses/30/lessons/42840

public class PracticeTest2 {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int oneNum = 0;
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int twoNum = 0;
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int threeNum = 0;
        int countNum = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % 5]) {
                oneNum++;
            }
            if (answers[i] == two[i % 8]) {
                twoNum++;
            }
            if (answers[i] == three[i % 10]) {
                threeNum++;
            }
        }

        int bigNum = Math.max(oneNum, twoNum);
        int mostBig = Math.max(bigNum, threeNum);
        int[] arr = {oneNum, twoNum, threeNum};

        for (int i = 0; i < 3; i++) {
            if (arr[i] == mostBig) {
                countNum++;
            }
        }

        int[] answer = new int[countNum];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == mostBig) {
                answer[index++] = i + 1;
            }
        }
        return answer;
    }
}