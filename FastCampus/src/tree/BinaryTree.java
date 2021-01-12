package tree;

import java.util.Stack;

class BinaryTree {
    private int[] array;

    public BinaryTree(int[] array) {
        this.array = array;
    }

    public void preorder() {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        Stack<Integer> stack = new Stack<>();

        while (true) {
            stack.push(index);
            sb.append(array[index]);
            index = index * 2 + 1;
        }

    }

    public void inorder() {

    }

    public void postorder() {

    }

    public boolean bfs(int value) {
        return true;
    }

    public boolean dfs(int value) {
        return true;
    }
}


class BinaryTreeTest {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinaryTree tree = new BinaryTree(array);

        tree.preorder();
        tree.inorder();
        tree.postorder();

        System.out.println(tree.bfs(2));
        System.out.println(tree.bfs(10));

        System.out.println(tree.dfs(5));
        System.out.println(tree.dfs(14));
    }
}
