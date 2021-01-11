package 정렬.hindex;

import java.util.ArrayList;

public class HIndex {
    public int solution(int[] citations) {
        int index = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int citation : citations) {
            list.add(citation);
        }
        list.sort(((o1, o2) -> o2 - o1));
        System.out.println(list);
        while (true) {
            if (list.get(index) < index + 1) {
                return index;
            } else {
                index++;
                if (index == list.size()) {
                    return index;
                }
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(new HIndex().solution(new int[]{3,3,3}));
        System.out.println(new HIndex().solution(new int[]{2, 0, 6, 1, 5}));
        System.out.println(new HIndex().solution(new int[]{0,1,2,3,4}));
        System.out.println(new HIndex().solution(new int[]{0,0,0,0,0}));
        System.out.println(new HIndex().solution(new int[]{3, 0, 6, 1, 5, 6, 6, 6, 6, 6, 6, 7, 7}));
        System.out.println(new HIndex().solution(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(new HIndex().solution(new int[]{12,11,10,9,8,1}));
    }
}
