# DoublyLinkedList 구현하기

## 소스 코드
```java
class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int value, Node next, Node prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean prepend(int value) {
        head.prev = new Node(value, head, null);

        head = head.prev;
        return true;
    }

    public boolean append(int value) {
        if (head == null) {
            head = new Node(value, null, null);
            tail = head;
            return true;
        }

        Node prev = head.prev;
        Node curr = head;
        Node next = head.next;

        while (curr != null) {
            prev = curr;
            curr = curr.next;
            if (curr != null) {
                next = curr.next;
            }
        }

        curr = new Node(value, null, prev);

        prev.next = curr;

        tail = curr;

        return true;
    }

    public boolean setHead(int index) {
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;

            if (curr == null) {
                return false;
            }
        }

        head = curr;
        curr.prev = null;
        return true;
    }

    public int access(int index) {
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;

            if (curr == null) {
                return -1;
            }
        }

        return curr.value;
    }

    public boolean insert(int index, int value) {
        Node curr = head;
        Node prev = null;
        Node next = null;

        for (int i = 0; i < index; i++) {
            prev = curr;
            curr = curr.next;
            if (curr == null) {
                return false;
            }
            next = curr.next;
        }

        Node newNode = new Node(value, curr, prev);

        if (prev != null) {
            prev.next = newNode;
        }
        if (next != null) {
            next.prev = newNode;
        }

        return true;
    }

    public boolean remove(int index) {
        Node curr = head;
        Node prev = null;
        Node next = null;

        for (int i = 0; i < index; i++) {
            prev = curr;
            curr = curr.next;
            if (curr == null) {
                return false;
            }
            next = curr.next;
        }
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = next;
        }

        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        sb.append("[ ");
        while (curr != null) {
            sb.append(curr.value).append(" ");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public String toStringInv() {
        StringBuilder sb = new StringBuilder();
        Node curr = tail;

        sb.append("[ ");
        while (curr != null) {
            sb.append(curr.value).append(" ");
            curr = curr.prev;
        }
        sb.append("]");

        return sb.toString();
    }
}


class DoublyLinkedListTest {
    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();
        System.out.println(myList);

        for (int i = 0; i < 10; i++) {
            myList.append(i + 1);
        }
        System.out.println(myList);

        for (int i = 0; i < 10; i++) {
            myList.prepend(i + 1);
        }
        System.out.println(myList);

        int value = myList.access(3);
        System.out.println("myList.access(3) = " + value);

        myList.insert(8, 128);
        System.out.println(myList);

        myList.remove(4);
        System.out.println(myList);

        myList.setHead(10);
        System.out.println(myList);
        System.out.println(myList.toStringInv());
    }
}
```

## 출력결과
```text
[ ]
[ 1 2 3 4 5 6 7 8 9 10 ]
[ 10 9 8 7 6 5 4 3 2 1 1 2 3 4 5 6 7 8 9 10 ]
myList.access(3) = 7
[ 10 9 8 7 6 5 4 3 128 2 1 1 2 3 4 5 6 7 8 9 10 ]
[ 10 9 8 7 5 4 3 128 2 1 1 2 3 4 5 6 7 8 9 10 ]
[ 1 2 3 4 5 6 7 8 9 10 ]
[ 10 9 8 7 6 5 4 3 2 1 ]
```
