package 월간코드챌린지시즌1;

import java.util.ArrayList;

public class QuadCompression {
    public static int count = 0;
    public static ArrayList<int[][]> arr = new ArrayList<>();

    public int[] solution(int[][] arr) {
        int[] answer = {};

        return answer;
    }

    public void quarter(ArrayList<int[][]> list) {
        int n = list.get(0).length;
        if (n == 2) {
            boolean isCheck;
            for (int[][] arr : list) {
                count = 0;
                isCheck = false;
                int start = arr[0][0];
                loop:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (arr[i][j] != start) {
                            isCheck = true;
                            break loop;
                        }
                    }
                }
                if (!isCheck) {
                    count++;
                } else {
                    int m = n / 2;
                    int[][] arr1 = new int[m][m];
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            arr1[i][j] = arr[i][j];
                        }
                    }
                    int[][] arr2 = new int[m][m];
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            arr2[i][j] = arr[i + m][j];
                        }
                    }
                    int[][] arr3 = new int[m][m];
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            arr3[i][j] = arr[i][j + m];
                        }
                    }
                    int[][] arr4 = new int[m][m];
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            arr4[i][j] = arr[i + m][j + m];
                        }
                    }
                    list.add(arr1);
                    list.add(arr2);
                    list.add(arr3);
                    list.add(arr4);
                    list.remove(0);
                    quarter(list);
                }
            }
        } else {
            quarter(list);
        }
    }

    public static void main(String[] args) {
//        QuadCompression quadCompression = new QuadCompression();
//        arr.add(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}});
//        quadCompression.quarter(arr);
//        System.out.println(count);
    }
}
