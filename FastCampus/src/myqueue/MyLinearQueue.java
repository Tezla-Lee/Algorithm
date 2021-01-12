package myqueue;

class MyLinearQueue {
    private int capacity;
    private int front;
    private int rear;
    private int[] array;

    public MyLinearQueue(int capacity) {
        this.capacity = capacity;
        this.front = 0;
        this.rear = 0;
        this.array = new int[capacity];
    }

    public boolean put(int value) {
        if (rear >= capacity) {
            if (front == 0) {
                capacity *= 2;
                int[] newArray = new int[capacity];

                for (int i = front; i < rear; i++) {
                    newArray[i - front] = array[i];
                }

                array = newArray;
                rear -= front;
            } else {
                for (int i = front; i < rear; i++) {
                    array[i - front] = array[i];
                }
                rear -= front;
                front = 0;
            }
        }
        array[rear++] = value;
        return true;
    }

    public int get() {
        if (front == rear) {
            return Integer.MIN_VALUE;
        }
        return array[front++];
    }

    public int peek() {
        if (front == rear) {
            return Integer.MIN_VALUE;
        }
        return array[front];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[ ");
        for (int i = front; i < rear; i++) {
            sb.append(array[i]).append(" ");
        }
        sb.append("]");

        return sb.toString();
    }
}

class LinearQueueTest {
    public static void main(String[] args) {
        MyLinearQueue queue = new MyLinearQueue(5);
        System.out.println(queue);

        queue.put(1);
        queue.put(2);
        queue.put(3);
        System.out.println(queue);

        System.out.println((queue.get()));
        System.out.println((queue.get()));
        System.out.println((queue.get()));
        System.out.println((queue.get()));
        System.out.println(queue);

        queue.put(4);
        queue.put(5);
        queue.put(6);
        System.out.println(queue);

        System.out.println((queue.get()));
        System.out.println((queue.get()));
        System.out.println((queue.peek()));
        System.out.println((queue.peek()));
        System.out.println((queue.get()));
        System.out.println(queue);
    }
}