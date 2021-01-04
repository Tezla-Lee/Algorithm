package b1644_소수의연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        boolean[] primeNumbers = new boolean[num + 1];
        CheckPrimeNumber(primeNumbers);
        sumPrimeNumbers(primeNumbers);
        System.out.println(count);
    }

    static void CheckPrimeNumber(boolean[] arr) {
        for (long i = 2; i < arr.length; i++) {
            if (!arr[(int) i]) {
                for (long j = i * i; j < arr.length; j += i) {
                    arr[(int) j] = true;
                }
            }
        }
    }

    static int count;

    static void sumPrimeNumbers(boolean[] arr) {
        for (int i = 2; i < arr.length; i++) {
            if (!arr[i]) {
                int sum = 0;
//                ArrayList<Integer> list = new ArrayList<>();
                for (int j = i; j < arr.length; j++) {
                    if (!arr[j]) {
                        sum += j;
//                        list.add(j);
                        if (sum == arr.length - 1) {
//                            System.out.println(list);
                            count++;
                        } else if (sum > arr.length - 1) {
                            break;
                        }
                    }
                }
            }
        }
    }
}
