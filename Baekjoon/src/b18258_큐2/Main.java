package b18258_큐2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Queue2 qu = new Queue2();

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.equals("pop")) {
                sb.append(qu.pop()).append("\n");
            } else if (command.equals("size")) {
                sb.append(qu.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(qu.empty()).append("\n");
            } else if (command.equals("front")) {
                sb.append(qu.front()).append("\n");
            } else if (command.equals("back")) {
                sb.append(qu.back()).append("\n");
            } else {
                qu.push(Integer.parseInt(command.split(" ")[1]));
            }
        }

        System.out.println(sb);
    }
}

class Queue2 {
    Queue<Integer> queue;
    int back = -1;

    public Queue2() {
        queue = new LinkedList<>();
    }

    public void push(int n) {
        back = n;
        queue.offer(n);
    }

    public int pop() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.poll();
    }

    public int empty() {
        if (queue.isEmpty()) {
            return 1;
        }
        return 0;
    }

    public int front() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.peek();
    }

    public int back() {
        if (queue.isEmpty()) {
            return -1;
        }
        return back;
    }

    public int size() {
        return queue.size();
    }
}