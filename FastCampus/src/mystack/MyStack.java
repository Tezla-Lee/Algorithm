package mystack;

public class MyStack {
    private int capacity;
    private int top;
    private int[] array;

    public MyStack(int capacity) {
        this.capacity = capacity;
        this.top = 0;
        this.array = new int[capacity];
    }

    public boolean push(int value) {
//        if (top + 1 == capacity) {
//            capacity *= 2;
//            int[] newArray = new int[capacity];
//            for (int i = 0; i < array.length; i++) {
//                newArray[i] = array[i];
//            }
//            array = newArray;
//        }
        if (top == capacity) {
            return false;
        }

        array[++top] = value;

        return true;
    }

    public int pop() {
        if (top == 0) {
            return -1;
        }
        return array[top--];
    }

    public int peek() {
        if (top == 0) {
            return -1;
        }
        return array[top];
    }

    public boolean isEmpty() {
        return top == 0;
    }
}

class StackTest {
    public static void main(String[] args) {
        MyStack stack = new MyStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println((stack.pop()));
        System.out.println((stack.pop()));

        System.out.println((stack.peek()));

        System.out.println((stack.pop()));
        System.out.println((stack.pop()));
        System.out.println((stack.pop()));
    }
}