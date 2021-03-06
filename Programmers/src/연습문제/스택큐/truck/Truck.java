package 연습문제.스택큐.truck;

import java.util.LinkedList;

// https://programmers.co.kr/learn/courses/30/lessons/42583

public class Truck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        int num = 0;
        int total = 0;
        LinkedList<Integer> bridge = new LinkedList<>();
        LinkedList<Integer> count = new LinkedList<>();

        for (int i = 1; i < 1000000; i++) {

            if (!count.isEmpty() && count.peek() + bridge_length == i) {
                total -= bridge.peek();
//                System.out.println(i + "s: " + bridge.peek() + " out");
                bridge.remove();
                count.remove();
            }

            if (num != truck_weights.length && total + truck_weights[num] <= weight) {
                bridge.add(truck_weights[num]);
//                System.out.println(i + "s: " + bridge.getLast() + " in");
                total += truck_weights[num];
                count.add(i);
                num++;
            }

//            if (total == 0 && num == truck_weights.length) {
//                return i;
//            }

            // 더 빠름
            if (num == truck_weights.length) {
                return i + bridge_length;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Truck().solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(new Truck().solution(3, 10, new int[]{7, 4, 5, 6,1,2,5,9,10}));
        System.out.println(new Truck().solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }
}
