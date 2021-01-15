package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class ArrayBinaryTree {
    private int[] array;
    private StringBuilder sb;

    public ArrayBinaryTree(int[] array) {
        this.array = array;
    }

    public void preorder() { // node -> left -> right
        sb = new StringBuilder();

        preorderHelper(1);

        System.out.println(sb);
    }

    public void preorderHelper(int index) {
        sb.append(index).append(" ");

        int left = index * 2;
        int right = index * 2 + 1;

        if (left <= array.length) {
            preorderHelper(left);
        }

        if (right <= array.length) {
            preorderHelper(right);
        }
    }

    public void inorder() { // left -> node -> right
        sb = new StringBuilder();

        inorderHelper(1);

        System.out.println(sb);
    }

    public void inorderHelper(int index) {
        int left = index * 2;
        int right = index * 2 + 1;

        if (left <= array.length) {
            inorderHelper(left);
        }

        sb.append(index).append(" ");

        if (right <= array.length) {
            inorderHelper(right);
        }
    }

    public void postorder() {  // left -> right -> node
        sb = new StringBuilder();

        postorderHelper(1);

        System.out.println(sb);
    }

    public void postorderHelper(int index) {
        int left = index * 2;
        int right = index * 2 + 1;

        if (left <= array.length) {
            postorderHelper(left);
        }

        if (right <= array.length) {
            postorderHelper(right);
        }

        sb.append(index).append(" ");
    }

    public boolean bfs(int value) {
        Queue<Integer> queue = new LinkedList<>();
        sb = new StringBuilder();
        if (value <= array.length) {
            queue.add(value);
        } else {
            return false;
        }

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            int left = temp * 2;
            int right = temp * 2 + 1;
            sb.append(temp).append(" ");

            if (left <= array.length) {
                queue.add(left);
            }
            if (right <= array.length) {
                queue.add(right);
            }
        }

        System.out.println(sb);
        return true;
    }

    public boolean dfs(int value) {
        Stack<Integer> stack = new Stack<>();
        sb = new StringBuilder();

        if (value <= array.length) {
            stack.add(value);
        } else {
            return false;
        }

        while (!stack.isEmpty()) {
            int temp = stack.pop();
            int left = temp * 2;
            int right = temp * 2 + 1;

            sb.append(temp).append(" ");

            if (right <= array.length) {
                stack.add(right);
            }

            if (left <= array.length) {
                stack.add(left);
            }
        }

        System.out.println(sb);
        return true;
    }
}


class ArrayBinaryTreeTest {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayBinaryTree tree = new ArrayBinaryTree(array);

        tree.preorder();
        tree.inorder();
        tree.postorder();

        System.out.println(tree.bfs(1));
        System.out.println(tree.bfs(2));
        System.out.println(tree.bfs(10));

        System.out.println(tree.dfs(1));
        System.out.println(tree.dfs(5));
        System.out.println(tree.dfs(14));
    }
}
