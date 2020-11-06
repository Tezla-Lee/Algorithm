package 월간코드챌린지시즌1.쿼드압축후개수세기;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    static int zero = 0;
    static int one = 0;

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        ArrayList<int[][]> abc = new ArrayList<>();
        abc.add(arr);
        quarter(abc);
        answer[0] = zero;
        answer[1] = one;
        return answer;
    }


    public void quarter(ArrayList<int[][]> list) {
        for (int[][] temp : list) {
            boolean isNotSame = false;
            if (temp.length == 1) {
                for (int[][] a : list) {
                    if (a[0][0] == 0) {
                        zero++;
                    } else {
                        one++;
                    }
                }
                return;
            }
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp.length; j++) {
                    if (temp[0][0] != temp[i][j]) {
                        isNotSame = true;
                        break;
                    }
                }
            }

            if (isNotSame) {
                ArrayList<int[][]> newList = new ArrayList<>();
                int l = temp.length / 2;
                int[] dx = {0, l, 0, l};
                int[] dy = {0, 0, l, l};
                for (int k = 0; k < 4; k++) {
                    int[][] tempArr = new int[l][l];
                    for (int i = 0; i < l; i++) {
                        for (int j = 0; j < l; j++) {
                            tempArr[i][j] = temp[i + dx[k]][j + dy[k]];
                        }
                    }
                    newList.add(tempArr);
                }
                quarter(newList);
            } else {
                if (temp[0][0] == 0) {
                    zero++;
                } else {
                    one++;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
//        System.out.println(Arrays.toString(new Solution().solution(new int[][]{{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}})));
//        for (int[][] a : arr) {
//            for (int[] b : a) {
//                for (int c : b) {
//                    System.out.print(c + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
//        System.out.println();
    }
}
