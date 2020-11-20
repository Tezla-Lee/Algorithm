package b5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testNum = Integer.parseInt(br.readLine());
        while (testNum != 0) {
            testNum--;
            char[] command = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String numbers = br.readLine();
            numbers = numbers.substring(1, numbers.length() - 1);
            Deque<String> list = new LinkedList<>(Arrays.asList(numbers.split(",")));
            int rCount = 0;
            int dCount = 0;
            boolean flag = false;
            for (char c : command) {
                if (c == 'R') {
                    if (dCount > n) {
                        flag = true;
                        break;
                    }
                    if (rCount % 2 == 0) {
                        for (int i = 0; i < dCount; i++) {
                            list.pollFirst();
                            n--;
                        }
                    } else {
                        for (int i = 0; i < dCount; i++) {
                            list.pollLast();
                            n--;
                        }
                    }
                    rCount++;
                    dCount = 0;
                }
                if (c == 'D') {
                    dCount++;
                }
            }
            if (dCount > n) {
                flag = true;
            }
            if (dCount != 0) {
                if (rCount % 2 == 0) {
                    for (int i = 0; i < dCount; i++) {
                        list.pollFirst();
                        n--;
                    }
                } else {
                    for (int i = 0; i < dCount; i++) {
                        list.pollLast();
                        n--;
                    }
                }
            }
            if (flag) {
                sb.append("error");
            } else if (n == 0) {
                sb.append("[]");
            } else {
                sb.append("[");
                if (rCount % 2 == 0) {
                    while (!list.isEmpty()) {
                        sb.append(list.pollFirst()).append(",");
                    }
                } else {
                    while (!list.isEmpty()) {
                        sb.append(list.pollLast()).append(",");
                    }
                }
                sb.deleteCharAt(sb.length() - 1).append("]");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}