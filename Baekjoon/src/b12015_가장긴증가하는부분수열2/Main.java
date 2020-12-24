package b12015_가장긴증가하는부분수열2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        arr[0] = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (arr[index] < temp) {
                arr[++index] = temp;
            }
            else {
                binarySearchAdd(arr, temp);
            }
        }
        System.out.println(index);
    }

    static int index = 0;

    static void binarySearchAdd(int[] arr, int k) {
        int left = 0;
        int right = index;

        while (left < right) {
            int mid = (left + right) >> 1;
            int temp = arr[mid];
            if (temp >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        arr[right] = k;
    }
}