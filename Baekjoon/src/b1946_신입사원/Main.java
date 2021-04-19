package b1946_신입사원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            Queue<Student> students = new PriorityQueue<>((a, b) -> a.aRank - b.aRank);
            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                students.add(new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            Student prev = students.poll();
            int count = 1;

            while (!students.isEmpty()) {
                Student curr = students.poll();
                if (curr.bRank < prev.bRank) {
                    count++;
                    prev = curr;
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static class Student {
        int aRank;
        int bRank;

        public Student(int aRank, int bRank) {
            this.aRank = aRank;
            this.bRank = bRank;
        }

        @Override
        public String toString() {
            return aRank + " " + bRank;
        }
    }
}