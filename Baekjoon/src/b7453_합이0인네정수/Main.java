package b7453_합이0인네정수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long answer = 0;
        A = new int[n];
        B = new int[n];
        C = new int[n];
        D = new int[n];
        AB = new int[n * n];
        CD = new int[n * n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[index] = A[i] + B[j];
                CD[index++] = C[i] + D[j];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

//        System.out.println(Arrays.toString(AB));
//        System.out.println(Arrays.toString(CD));

//        for (long num : AB) {
//            answer += binarySearch(num);
//        }
//
//        System.out.println(answer);

        // 투 포인터
        int cdIndex = CD.length - 1;

        for (int i = 0; i < AB.length && cdIndex >= 0; ) {
            long abCnt = 0;
            long cdCnt = 0;
            int tempAB = AB[i];
            int tempCD = CD[cdIndex];
            int total = AB[i] + CD[cdIndex];
            if (total == 0) {
//                System.out.println(AB[i] + " " + CD[cdIndex] + " " + total);
                while (i < AB.length && tempAB == AB[i]) {
                    i++;
                    abCnt++;
                }
                while (cdIndex >= 0 && tempCD == CD[cdIndex]) {
                    cdIndex--;
                    cdCnt++;
                }
                answer += abCnt * cdCnt;
            } else if (total > 0) {
                cdIndex--;
            } else {
                i++;
            }
        }

        System.out.println(answer);

    }

    static int[] A;
    static int[] B;
    static int[] C;
    static int[] D;
    static int[] AB;
    static int[] CD;

//    static int binarySearch(long value) {
//        int left = 0;
//        int right = CD.length - 1;
//        int count = 0;
//
//        while (left <= right) {
//            int mid = (left + right) >> 1;
//            if (value + CD[mid] >= 0) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//
//        while (left < CD.length && CD[left] + value == 0) {
//            count++;
//            left++;
//        }
//        return count;
//    }
}