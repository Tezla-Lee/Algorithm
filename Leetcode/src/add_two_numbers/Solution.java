package add_two_numbers;

 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode node = root;
        int prev = 0;

        while (l1 != null || l2 != null) {
            int sum = prev;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            node.next = new ListNode(sum % 10);
            node = node.next;
            prev = sum / 10;
        }

        if (prev != 0) {
            node.next = new ListNode(prev);
        }

        return root.next;
    }
}