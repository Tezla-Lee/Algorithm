package reverseLinkedList;

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
    public ListNode reverseList(ListNode head) {
        ListNode parent = null;

        while (head != null) {
            ListNode curr = head;
            head = head.next;
            curr.next = parent;
            parent = curr;
        }
        return parent;
    }
}