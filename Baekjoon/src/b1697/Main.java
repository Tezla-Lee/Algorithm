package b1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if (n == m) {
            System.out.println(0);
        } else {
            System.out.println(bfs(n, m));
        }
    }

    static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        int[] check = new int[100001];
        check[start] = 1;
        queue.offer(start);
        int temp;
        int num;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    num = temp * 2;
                } else if (i == 1) {
                    num = temp + 1;
                } else {
                    num = temp - 1;
                }
                if (num == end) {
                    return check[temp];
                }
                if (num >= 0 && num < check.length && check[num] == 0) {
                    check[num] = check[temp] + 1;
                    queue.offer(num);
                }
            }
        }
        return -1;
    }
}
