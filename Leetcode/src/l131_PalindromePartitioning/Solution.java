package l131_PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        String sub;
        for (int i = 1; i <= s.length(); i++) {
            List<String> list = new ArrayList<>();
            int begin = 0;
            int end = i;
            while (true) {
                sub = s.substring(begin, end);
                if (sub.length() > 0 && checkPalindrome(sub)) {
                    list.add(sub);
                }
                begin += i;
                end += i;

                if (end >= s.length()) {
                    sub = s.substring(begin);
                    if (sub.length() > 0 && checkPalindrome(sub)) {
                        list.add(sub);
                    }
                    break;
                }
            }
            if (list.size() != 0) {
                lists.add(list);
            }
        }

        return lists;
    }

    static boolean checkPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }
}