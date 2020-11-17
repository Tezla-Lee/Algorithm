package b2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 방법1
//        Deque<Integer> deque = new LinkedList<>();
//        for (int i = 1; i <= n; i++) {
//            deque.push(i);
//        }
//        while (deque.size() != 1) {
//            deque.pollLast();
//            if (deque.size() == 1) {
//                break;
//            }
//            deque.offerFirst(deque.pollLast());
//        }
//        System.out.println(deque.poll());

        // 방법2
        int count = 0;
        int temp = n;
        while (temp != 1) {
            temp /= 2;
            count++;
        }
        if (n == Math.pow(2, count)) {
            System.out.println(n);
        } else {
            System.out.println((int) (n % Math.pow(2, count)) * 2);
        }
    }
}
