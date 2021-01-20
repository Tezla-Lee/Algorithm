package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Vertex {
    public int value;
    List<Integer> adjList;

    public Vertex(int value, List<Integer> adjList) {
        this.value = value;
        this.adjList = adjList;
    }
}

class Graph {
    List<Vertex> vertexList = new ArrayList<>();

    public void insert(int value, int[] adjVertices) {
        int vInd = vertexList.size();
        List<Integer> adjList = new ArrayList<>();

        for (int idx : adjVertices) {
            adjList.add(idx);
        }
        Vertex v = new Vertex(value, adjList);

        for (int adjV : v.adjList) {
            vertexList.get(adjV).adjList.add(vInd);
        }

        vertexList.add(v);
    }

    public boolean bfs(int ind, int value) {
        boolean[] isVisited = new boolean[vertexList.size()];
        StringBuilder sb = new StringBuilder();

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(vertexList.get(ind));
        isVisited[ind] = true;

        while (!queue.isEmpty()) {
            Vertex temp = queue.poll();
            sb.append(temp.value).append(" ");

            if (temp.value == value) {
                System.out.print(sb + " ");
                return true;
            }

            for (int i : temp.adjList) {
                if (!isVisited[i]) {
                    queue.add(vertexList.get(i));
                    isVisited[i] = true;
                }
            }
        }

        System.out.print(sb + " ");
        return false;
    }

    public boolean dfs(int ind, int value) {
        boolean[] isVisited = new boolean[vertexList.size()];
        StringBuilder sb = new StringBuilder();

        Stack<Vertex> stack = new Stack<>();
        stack.add(vertexList.get(ind));
        isVisited[ind] = true;

        while (!stack.isEmpty()) {
            Vertex temp = stack.pop();
            sb.append(temp.value).append(" ");

            if (temp.value == value) {
                System.out.print(sb + " ");
                return true;
            }

            for (int i : temp.adjList) {
                if (!isVisited[i]) {
                    stack.add(vertexList.get(i));
                    isVisited[i] = true;
                }
            }
        }

        System.out.print(sb + " ");
        return false;
    }
}

class GraphTest {
    public static void main(String[] args) {
        Graph g = new Graph();

        int[] array1 = {};
        g.insert(0, array1);

        int[] array2 = {0};
        g.insert(1, array2);

        int[] array3 = {1};
        g.insert(2, array3);

        int[] array4 = {0, 2};
        g.insert(3, array4);

        int[] array5 = {3};
        g.insert(4, array5);

        System.out.println(g.bfs(0, 2));
        System.out.println(g.bfs(0, 6));
        System.out.println(g.dfs(0, 2));
        System.out.println(g.dfs(0, 6));
    }
}