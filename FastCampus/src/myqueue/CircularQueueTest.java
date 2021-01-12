package myqueue;

class MyCircularQueue {
    private int capacity;
    private int front;
    private int rear;
    private int[] array;
    private boolean isFull;

    public MyCircularQueue(int capacity) {
        this.capacity = capacity;
        this.front = 0;
        this.rear = 0;
        this.array = new int[capacity];
        this.isFull = false;
    }

    public boolean put(int value) {
        if (isFull) {
            return false;
        }

        array[rear] = value;
        rear = (rear + 1) % capacity;

        if (front == rear) {
            isFull = true;
        }

        return true;
    }

    public int get() {
        if (front == rear & !isFull) {
            return Integer.MIN_VALUE;
        }

        if (isFull) {
            isFull = false;
        }

        if (front == capacity - 1) {
            front = 0;
            return array[capacity - 1];
        } else {
            return array[front++];
        }
    }

    public int peek() {
        if (front == rear && !isFull) {
            return Integer.MIN_VALUE;
        }
        return array[front];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[ ");
        if (rear > front) {
            for (int i = front; i < rear; i++) {
                sb.append(array[i]).append(" ");
            }
        } else if (rear < front) {
            for (int i = front; i < capacity; i++) {
                sb.append(array[i]).append(" ");
            }
            for (int i = 0; i < rear; i++) {
                sb.append(array[i]).append(" ");
            }
        }
            sb.append("]");

        return sb.toString();
    }
}

class CircularQueueTest {
    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(5);
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