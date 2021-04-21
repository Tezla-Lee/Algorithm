package 연습문제.스택큐.printer;

import java.util.*;

public class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Doc> qu = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            qu.add(new Doc(priorities[i], i));
        }

        int count = 0;

        while(!qu.isEmpty()) {
            Doc currDoc = qu.poll();
            boolean flag = true;

            for (Doc doc : qu) {
                if (doc.priority > currDoc.priority) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count++;
                if (currDoc.index == location) {
                    return count;
                }
            } else {
                qu.add(currDoc);
            }
        }
        return count;
    }
}

class Doc {
    int priority;
    int index;

    public Doc(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }
}