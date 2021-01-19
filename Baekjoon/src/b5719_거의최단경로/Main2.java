package b5719_거의최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 장소 수
            int m = Integer.parseInt(st.nextToken()); // 도로 수

            if (n == 0 && m == 0) {
                break;
            }

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 시작점
            int d = Integer.parseInt(st.nextToken()); // 도착점

            lists = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                lists[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                lists[u].add(new Road(u, v, p));
            }

            // 최단거리 찾는다
            int shortestDistance = SearchBestRouteAndDistance(n, s, d);

            if (shortestDistance == Integer.MAX_VALUE) {
                sb.append("-1").append("\n");
                continue;
            }

            // 최단 거리 경로 삭제
            deleteBestRoute();

            int distance = SearchBestDistance(n, s, d);

            if (distance == Integer.MAX_VALUE) {
                sb.append("-1");
            } else {
                sb.append(distance);
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }

    static ArrayList<Road>[] lists; // 각 노드에 연결된 로드 저장
    static ArrayList<Road> endRoads;

    // 최단 거리와 최단 경로를 찾음
    static int SearchBestRouteAndDistance(int n, int start, int destination) {
        int[] d = new int[n];

        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;

        PriorityQueue<Road> priorityQueue = new PriorityQueue<>();

        for (Road road : lists[start]) {
            priorityQueue.add(road);
        }

        while (!priorityQueue.isEmpty()) {
            Road temp = priorityQueue.poll();

            if (d[temp.destination] > temp.distance + d[temp.start]) {
                d[temp.destination] = temp.distance + d[temp.start];

                if (temp.destination == destination) {
                    endRoads = new ArrayList<>();
                    endRoads.add(temp);
                }

                for (Road road : lists[temp.destination]) {
                    road.prev = new ArrayList<>();
                    road.prev.add(temp);
                    priorityQueue.add(road);
                }

            } else if (d[temp.destination] == temp.distance + d[temp.start]) {

                if (temp.destination == destination) {
                    endRoads.add(temp);
                }
                for (Road road : lists[temp.destination]) {
                    road.prev.add(temp);
                    priorityQueue.add(road);
                }
            }
        }

        return d[destination];
    }

    // 최단 거리만 찾음
    static int SearchBestDistance(int n, int start, int destination) {
        int[] d = new int[n];

        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;

        PriorityQueue<Road> priorityQueue = new PriorityQueue<>();

        for (Road road : lists[start]) {
            priorityQueue.add(road);
        }

        while (!priorityQueue.isEmpty()) {
            Road temp = priorityQueue.poll();

            if (d[temp.destination] > temp.distance + d[temp.start]) {
                d[temp.destination] = temp.distance + d[temp.start];

                for (Road road : lists[temp.destination]) {
                    priorityQueue.add(road);
                }
            }
        }
        return d[destination];
    }

    // 최단거리 루트의 로드 삭제
    static void deleteBestRoute() {
        Queue<Road> queue = new LinkedList<>();
        for (Road road : endRoads) {
            queue.add(road);
        }

        while (!queue.isEmpty()) {
            Road temp = queue.poll();
            for (Road road : temp.prev) {
                queue.add(road);
            }
            lists[temp.start].remove(temp);
        }
    }
}

class Road implements Comparable<Road> {
    List<Road> prev;
    int start;
    int destination;
    int distance;

    public Road(int start, int destination, int distance) {
        this.start = start;
        this.destination = destination;
        this.distance = distance;
        prev = new ArrayList<>();
    }

    @Override
    public int compareTo(Road o) {
        return distance - o.distance;
    }
}