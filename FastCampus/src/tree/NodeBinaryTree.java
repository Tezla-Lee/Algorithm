package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

class NodeBinaryTree {
    private Node root;
    private boolean isFound;
    private StringBuilder sb;

    public NodeBinaryTree(int[] array) {
        Node[] nodeArray = new Node[array.length];
        for (int i = 0; i < array.length; i++) {
            nodeArray[i] = new Node(array[i], null, null);
        }

        for (int i = 0; i < array.length; i++) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;

            if (left < array.length) {
                nodeArray[i].left = nodeArray[left];
            }
            if (right < array.length) {
                nodeArray[i].right = nodeArray[right];
            }
        }
        root = nodeArray[0];
    }

    public void preorder() {
        Stack<Node> stack = new Stack<>();
        sb = new StringBuilder();

        if (root != null) {
            stack.add(root);
        }

        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            sb.append(temp.value + 1).append(" ");

            if (temp.right != null) {
                stack.add(temp.right);
            }

            if (temp.left != null) {
                stack.add(temp.left);
            }
        }

        System.out.println(sb);
    }

    public void inorder() {
        sb = new StringBuilder();

        if (root != null) {
            inorderHelper(root);
        }

        System.out.println(sb);
    }

    public void inorderHelper(Node node) {
        if (node.left != null) {
            inorderHelper(node.left);
        }

        sb.append(node.value + 1).append(" ");

        if (node.right != null) {
            inorderHelper(node.right);
        }

    }

    public void postorder() {
        sb = new StringBuilder();

        if (root != null) {
            postorderHelper(root);
        }

        System.out.println(sb);
    }

    public void postorderHelper(Node node) {
        if (node.left != null) {
            postorderHelper(node.left);
        }

        if (node.right != null) {
            postorderHelper(node.right);
        }

        sb.append(node.value + 1).append(" ");
    }

    public boolean bfs(int value) {
        Queue<Node> queue = new LinkedList<>();
        sb = new StringBuilder();

        if (root != null) {
            queue.add(root);
        }

        Node target = null;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.value + 1 == value) {
                target = temp;
                break;
            }

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

        if (target == null) {
            return false;
        }

        queue = new LinkedList<>();
        queue.add(target);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            sb.append(temp.value + 1).append(" ");

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

        System.out.println(sb);
        return true;
    }

    public boolean dfs(int value) {
        Stack<Node> stack = new Stack<>();
        sb = new StringBuilder();

        if (root != null) {
            stack.add(root);
        }

        Node target = null;

        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            if (temp.value + 1 == value) {
                target = temp;
                break;
            }

            if (temp.left != null) {
                stack.add(temp.left);
            }

            if (temp.right != null) {
                stack.add(temp.right);
            }
        }

        if (target == null) {
            return false;
        }

        stack = new Stack<>();
        stack.add(target);

        while (!stack.isEmpty()) {
            Node temp = stack.pop();

            sb.append(temp.value + 1).append(" ");

            if (temp.right != null) {
                stack.add(temp.right);
            }

            if (temp.left != null) {
                stack.add(temp.left);
            }

        }

        System.out.println(sb);
        return true;
    }

}


class NodeBinaryTreeTest {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        NodeBinaryTree tree = new NodeBinaryTree(array);

        tree.preorder();
        tree.inorder();
        tree.postorder();

        System.out.println(tree.bfs(2));
        System.out.println(tree.bfs(10));

        System.out.println(tree.dfs(5));
        System.out.println(tree.dfs(14));
    }
}