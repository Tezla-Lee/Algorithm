package remove_nth_node;

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getNodeCount(head);

        if (size - n == 0) {
            head = head.next;
        } else {
            removeNthNode(size - n, head);
        }
        return head;
    }

    private int getNodeCount(ListNode head) {
        if (head == null) {
            return 0;
        }

        int count = 0;

        ListNode curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        return count;
    }

    private void removeNthNode(int n, ListNode head) {
        ListNode curr = head;

        while (n-- > 1) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
    }
}