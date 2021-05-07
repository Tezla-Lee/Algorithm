package b1967_트리의지름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static Node[] nodes;
    private static int[] distances;
    private static int diameterMax;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        nodes = new Node[n + 1];
        distances = new int[n + 1];

        nodes[1] = new Node(1, 0);

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            nodes[child] = new Node(child, distance);
            nodes[parent].children.add(nodes[child]);
        }
        getDistance(nodes[1]);

        System.out.println(diameterMax);
    }

    static int getDistance(Node node) {
        int firstMax = 0;
        int secondMax = 0;

        for (Node child : node.children) {
            int distance = getDistance(child) + child.distance;

            if (firstMax < distance) {
                secondMax = Math.max(firstMax, secondMax);
                firstMax = distance;
            } else {
                secondMax = Math.max(secondMax, distance);
            }
        }

        int diameter = firstMax + secondMax;
        distances[node.number] = diameter;
        diameterMax = Math.max(diameterMax, diameter);

        return firstMax;
    }

    private static class Node {
        int number;
        int distance;
        List<Node> children;

        public Node(int number, int distance) {
            this.number = number;
            this.distance = distance;
            children = new ArrayList<>();
        }
    }
}
