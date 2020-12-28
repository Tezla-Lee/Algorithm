package palindromePartitioning;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return lists;
    }

    static List<List<String>> lists;
    static List<String> list;

    static void dfs(String s, int depth) {
        if (depth == 0) {
            lists = new ArrayList<>();
            list = new ArrayList<>();
        } else
            if (s.length() == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (isPalindrome(sub)) {
                list.add(sub);
                dfs(s.substring(i), depth + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition("AAAC"));
    }
}