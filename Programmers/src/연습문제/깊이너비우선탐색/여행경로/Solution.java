package 연습문제.깊이너비우선탐색.여행경로;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String[] solution(String[][] tickets) {

        route = new String[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                isGone = new boolean[tickets.length];
                isGone[i] = true;
                dfs(tickets[i][0], tickets[i][1], tickets, 0);
            }
        }

        return answer;
    }

    static boolean[] isGone;
    static String[] route;
    static String[] answer;

    static void dfs(String departure, String arrival, String[][] tickets, int depth) {
        route[depth] = departure;

        if (depth == isGone.length - 1) {
            route[depth + 1] = arrival;
            if (route[0].equals("ICN")) {
                if (!fasterRoute(route, answer)) {
//                    System.out.println("answer : " + Arrays.toString(answer));
                    answer = new String[route.length];
//                    System.out.println("route  : " + Arrays.toString(route));
                    for (int i = 0; i < answer.length; i++) {
                        answer[i] = new String(route[i]);
                    }
                }
            }
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!isGone[i] && tickets[i][0].equals(arrival)) {
                isGone[i] = true;
                dfs(tickets[i][0], tickets[i][1], tickets, depth + 1);
                isGone[i] = false;
            }
        }
    }

    static boolean fasterRoute(String[] a, String[] b) {
        if (b == null) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i].compareTo(b[i]) < 0) {
                return false;
            } else if (a[i].compareTo(b[i]) > 0) {
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
        System.out.println(Arrays.toString(new Solution().solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}})));
//        System.out.println(Arrays.toString(new Solution().solution(new String[][]{{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "ABC"}, {"ABC", "SFO"}})));
//        System.out.println(Arrays.toString(new Solution().solution(new String[][]{{"ICN", "A"}, {"A", "C"}, {"A", "D"}, {"D", "B"}, {"B", "A"}})));
    }
}


class Solution2 {
    public String[] solution(String[][] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                isGone = new boolean[tickets.length];
                isGone[i] = true;
                dfs(tickets[i][0], tickets[i][1], tickets, 0);
            }
        }

        return answer;
    }

    static boolean[] isGone;
    static ArrayList<String> route = new ArrayList<>();
    static String[] answer;

    static void dfs(String departure, String arrival, String[][] tickets, int depth) {
        route.add(departure);

        if (depth == isGone.length - 1) {
            route.add(arrival);
            if (route.get(0).equals("ICN")) {
                String[] temp = new String[route.size()];
                for (int i = 0; i < route.size(); i++) {
                    temp[i] = route.get(i);
                }
                if (!fasterRoute(temp, answer)) {
                    answer = new String[temp.length];
                    for (int i = 0; i < answer.length; i++) {
                        answer[i] = temp[i];
                    }
                }
            }
            route = new ArrayList<>();
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!isGone[i] && tickets[i][0].equals(arrival)) {
                isGone[i] = true;
                dfs(tickets[i][0], tickets[i][1], tickets, depth + 1);
                isGone[i] = false;
            }
        }
        route = new ArrayList<>();
    }

    static boolean fasterRoute(String[] a, String[] b) {
        if (b == null) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i].compareTo(b[i]) < 0) {
                return false;
            }
        }
        return true;
    }
}