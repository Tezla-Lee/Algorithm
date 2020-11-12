package b9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int studentNum = Integer.parseInt(br.readLine());
            arr = new int[studentNum + 1];
            isVisited = new boolean[studentNum + 1];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            count = 0;
            for (int j = 1; j < arr.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(arr));
            for (int j = 1; j < studentNum + 1; j++) {
                if (!isVisited[j]) {
                    System.out.print("start: " + j + ", ");
                    team = new ArrayList<>();
                    dfs(j, team);
                    System.out.println();
                }
            }
            System.out.println();
            System.out.println(studentNum - count);
        }
    }

    static int[] arr;
    static boolean[] isVisited;
    static int count = 0;
    static ArrayList<Integer> team;

    public static boolean dfs(int student, ArrayList<Integer> team) {
        isVisited[student] = true;
        team.add(student);
        System.out.print(student + " ");
        if (student == arr[student]) {
            count += 1;
            System.out.println("count : " + count);
            return true;
        }
        if (team.contains(arr[student])) {
            isVisited[arr[student]] = true;
            count += team.size() - team.indexOf(arr[student]);
            System.out.println("count : " + count);
            return true;
        } else {
            if (!isVisited[arr[student]]) {
                dfs(arr[student], team);
            }
        }
//        isVisited[student] = false;
        return true;
    }
}
