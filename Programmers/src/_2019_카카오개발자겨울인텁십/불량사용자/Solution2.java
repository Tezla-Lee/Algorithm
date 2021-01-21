package _2019_카카오개발자겨울인텁십.불량사용자;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public int solution(String[] user_id, String[] banned_id) {
        count = 0;
        isVisited = new boolean[user_id.length];
        checkedId = new int[banned_id.length];
        set = new HashSet<>();

        dfs(user_id, banned_id, 0);

        return count;
    }

    static boolean checkId(String ban, String user) {
        char[] chars1 = ban.toCharArray();
        char[] chars2 = user.toCharArray();

        if (chars2.length != chars1.length) {
            return false;
        }

        for (int j = 0; j < chars2.length; j++) {
            if (chars1[j] != '*' && chars1[j] != chars2[j]) {
                return false;
            }
        }
        return true;
    }

    static boolean[] isVisited;
    static int count;
    static int[] checkedId;
    static Set<Integer> set;

    static void dfs(String[] user_id, String[] banned_id, int index) {
        if (index == banned_id.length) {
            StringBuilder sb = new StringBuilder();
            int[] temp = checkedId.clone();

            Arrays.sort(temp);

            for (int num : temp) {
                sb.append(num);
            }

            int s = Integer.parseInt(sb.toString());

            if (!set.contains(s)) {
                set.add(s);
                count++;
            }
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!isVisited[i] && checkId(banned_id[index], user_id[i])) {
                isVisited[i] = true;
                checkedId[index] = i;
                dfs(user_id, banned_id, index + 1);
                isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
        System.out.println(new Solution2().solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
        System.out.println(new Solution2().solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
    }
}