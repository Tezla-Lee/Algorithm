package 월간코드챌린지시즌1.풍선터트리기;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public int solution(int[] a) {
        set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int num : a) {
            list.add(num);
        }

        dfs(list, false);

        return set.size();
    }

    static HashSet<Integer> set;

    static void dfs(List<Integer> list, boolean used) {
        System.out.println(list);

        if (list.size() == 1) {
            set.add(list.get(0));
            return;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            int num1 = list.get(i);
            int num2 = list.get(i + 1);
            int index;
            int removeNum;

            if (num1 > num2) {
                removeNum = list.remove(i);
                index = i;
                dfs(list, used);
                list.add(index, removeNum);
            } else {
                if (!used) {
                    removeNum = list.remove(i);
                    index = i;
                    dfs(list, true);
                    list.add(index, removeNum);
                }

                removeNum = list.remove(i + 1);
                index = i + 1;
                dfs(list, used);
                list.add(index, removeNum);
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().solution(new int[]{9, -1, -5}));
        System.out.println(new Solution().solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33}));
    }
}