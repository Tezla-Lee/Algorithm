# 이진 트리 구현하기
## 배열 기반 완전 이진 트리 구현하기
```java
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
```

## 노드 기반 완전 이진 트리 구현하기
```java
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
```