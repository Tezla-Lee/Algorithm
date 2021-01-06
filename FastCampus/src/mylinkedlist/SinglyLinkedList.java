package mylinkedlist;

class Node {
    public int value;
    public Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean prepend(int value) {
        return insert(0, value);
    }

    public boolean append(int value) {
        Node curr = head;
        Node prev = null;

        if (curr == null) {
            head = new Node(value, null);
            return true;
        }

        while (curr != null) {
            prev = curr;
            curr = curr.next;
        }


        curr = new Node(value, null);

        if (prev != null) {
            prev.next = curr;
        }

        return true;
    }

    public boolean setHead(int index) {
        Node curr = head;
        int count = 0;

        while (curr != null) {
            count++;
            curr = curr.next;

            if (count == index) {
                break;
            }
        }

        if (count == index) {
            head = curr;
            return true;
        }

        return false;
    }

    public int access(int index) {
        Node curr = head;
        int count = 0;

        while (curr != null) {
            count++;
            curr = curr.next;

            if (count == index) {
                break;
            }
        }

        if (count == index) {
            return curr.value;
        }

        return -1;
    }

    public boolean insert(int index, int value) {
        Node curr = head;
        Node prev = null;
        int count = 0;

        if (index == 0) {
            head = new Node(value, head);
            return true;
        }

        while (curr != null) {
            count++;
            prev = curr;
            curr = curr.next;

            if (count == index) {
                break;
            }
        }

        if (index == count) {
            prev.next = new Node(value, curr);
            return true;
        }
        return false;
    }

    public boolean remove(int index) {
        Node curr = head;
        Node prev = null;
        int count = 0;

        while (curr != null) {
            count++;
            prev = curr;
            curr = curr.next;

            if (count == index) {
                break;
            }
        }

        if (count == index) {
            if (prev != null) {
                prev.next = curr.next;
            }
            return true;
        }
        return false;
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
}


class SinglyLinkedListTest {
    public static void main(String[] args) {
        SinglyLinkedList myList = new SinglyLinkedList();
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
    }
}