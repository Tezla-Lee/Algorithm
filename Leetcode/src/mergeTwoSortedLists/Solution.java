package mergeTwoSortedLists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<ListNode> list = new ArrayList<>();

        ListNode temp = l1;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        temp = l2;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        list.sort(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }

        if (list.size() == 0) {
            return null;
        }

        return list.get(0);
    }
}
