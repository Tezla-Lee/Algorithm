package b1854_K번째최단경로찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arrayLists = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int arrival = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            arrayLists[arrival].add(new Node(destination, time));
        }
        bfs(k);
    }

    static ArrayList<Node>[] arrayLists;

    static void bfs(int k) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));

        // 여러 경로의 거리를 저장
        Queue<Long>[] d = new PriorityQueue[arrayLists.length];
        for (int i = 0; i < d.length; i++) {
            // 내림차순으로 해야 편함
            d[i] = new PriorityQueue<>(new Comparator<Long>() { // Comparator 를 이용하지 않고 -1를 곱한 값을 넣어서 하는 방법이 더 빠름
                @Override
                public int compare(Long o1, Long o2) {
                    return (int) (o2 - o1);
                }
            });
        }


        d[1].add(0L);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node next : arrayLists[curr.index]) {
                if (d[next.index].size() < k) {
                    d[next.index].add((long) (curr.time + next.time));
                    queue.add(new Node(next.index, curr.time + next.time));
                } else if (d[next.index].peek() > (long) (curr.time + next.time)) { // 다 채워졌고 더 최선의 루트가 있으면,
                    d[next.index].poll();                                           // 가장 큰 값을 빼고
                    d[next.index].add((long) (curr.time + next.time));              // 새로운 값을 넣는다.
                    queue.add(new Node(next.index, curr.time + next.time));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < d.length; i++) {
            if (d[i].size() == k) {
                sb.append(d[i].peek());
            } else {
                sb.append("-1");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

class Node implements Comparable<Node> {
    int index;
    int time;

    public Node(int index, int time) {
        this.index = index;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return time - o.time;
    }
}