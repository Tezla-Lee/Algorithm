package 월간코드챌린지시즌1;

import java.util.ArrayList;
import java.util.List;

public class QuarterTest {
    public static List<int[][]> abc = new ArrayList<>();

    public static void main(String[] args) {
        List<int[][]> list = new ArrayList<>();
        list.add(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}});
        quarter(list);
        for (int[][] arr : list) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        for (int[][] arr : abc) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println(abc.size());
    }

    public static void quarter(List<int[][]> arrList) {
        int[][] arr = arrList.get(0);
        int n = arr.length / 2;

        if (arr.length == 1) {
            return;
        }

        arr = arrList.remove(0);
        boolean isCheck = false;
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
        if (isCheck) {
            int[][] arr1 = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr1[i][j] = arr[i][j];
                }
            }
            arrList.add(arr1);
            int[][] arr2 = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr2[i][j] = arr[i + n][j];
                }
            }
            arrList.add(arr2);
            int[][] arr3 = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr3[i][j] = arr[i][j + n];
                }
            }
            arrList.add(arr3);
            int[][] arr4 = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr4[i][j] = arr[i + n][j + n];
                }
            }
            arrList.add(arr4);
            quarter(arrList);
        } else {
            arrList.add(arr);
            abc.add(arr);
        }
    }

//    public static void quarter2(List<int[][]> arrList) {
//        int[][] arr = arrList.get(0);
//        int n = arr.length / 2;
//
//        if (arr.length == 1) {
//            return;
//        }
//
//        boolean isCheck = false;
//        arr = arrList.remove(0);
//        int start = arr[0][0];
//        loop:
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (arr[i][j] != start || n == 1) {
//                    isCheck = true;
//                    break loop;
//                }
//            }
//        }
//        if (isCheck) {
//            int[][] arr1 = new int[n][n];
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    arr1[i][j] = arr[i][j];
//                }
//            }
//            arrList.add(arr1);
//            int[][] arr2 = new int[n][n];
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    arr2[i][j] = arr[i + n][j];
//                }
//            }
//            arrList.add(arr2);
//            int[][] arr3 = new int[n][n];
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    arr3[i][j] = arr[i][j + n];
//                }
//            }
//            arrList.add(arr3);
//            int[][] arr4 = new int[n][n];
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    arr4[i][j] = arr[i + n][j + n];
//                }
//            }
//            arrList.add(arr4);
//            quarter(arrList);
//        } else {
//            arrList.add(arr);
//            abc.add(arr);
//        }
//    }
}
