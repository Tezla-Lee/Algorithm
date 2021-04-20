package linked_list_cycle_ii;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();

        ListNode curr = head;

        while (curr != null) {
            if (nodes.contains(curr)) {
                return curr;
            }

            nodes.add(curr);
            curr = curr.next;
        }

        return null;
    }

    static private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
