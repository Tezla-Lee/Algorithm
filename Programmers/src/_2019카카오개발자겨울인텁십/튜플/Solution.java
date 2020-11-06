package _2019카카오개발자겨울인텁십.튜플;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int[] solution(String s) {
        String[] tuples = s.substring(2, s.length() - 2).split("},\\{");
        List<String[]> list = new ArrayList<>();
        List<String> checkList = new ArrayList<>();
        for (String tuple : tuples) {
            list.add(tuple.split(","));
        }
        Collections.sort(list, (a,b) -> a.length - b.length);
        checkList.add(list.get(0)[0]);
        for (String[] st : list) {
            for (String str : st) {
                if (!checkList.contains(str)) {
                    checkList.add(str);
                    break;
                }
            }
        }
        int[] answer = new int[checkList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(checkList.get(i));
        }
        return answer;
    }

}
