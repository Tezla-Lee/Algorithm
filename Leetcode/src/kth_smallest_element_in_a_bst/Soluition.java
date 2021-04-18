package kth_smallest_element_in_a_bst;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode2 root, int k) {
        queue = new PriorityQueue<>();

        search(root);

        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }

        return queue.poll();
    }

    static Queue<Integer> queue;

    static void search(TreeNode2 node) {
        queue.add(node.val);

        if (node.left != null) {
            search(node.left);
        }

        if (node.right != null) {
            search(node.right);
        }
    }
}

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2() {
    }

    TreeNode2(int val) {
        this.val = val;
    }

    TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}