package myarraylist;

public class MyArrayList {
    private int capacity;
    private int length;
    private int[] array;

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        length = 0;
        array = new int[capacity];
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean prepend(int value) {
        if (capacity == length) {
            capacity *= 2;
            int[] newArray = new int[capacity];
            newArray[0] = value;
            System.arraycopy(array, 0, newArray, 1, length);
            array = newArray;
        } else {
            System.arraycopy(array, 0, array, 1, length);
            array[0] = value;
        }

        length++;

        return true;
    }

    public boolean append(int value) {
        if (capacity == length) {
            capacity *= 2;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, length);
            newArray[length] = value;
            this.array = newArray;
        } else {
            System.arraycopy(array, 0, array, 0, length);
            array[length] = value;
        }

        length++;

        return true;
    }

    public boolean setHead(int index) {
        if (index >= 0 && index < length) {
            System.arraycopy(array, index, array, 0, length - index);
            length -= index;
            return true;
        }
        return false;
    }

    public int access(int index) {
        if (index >= 0  && index < length) {
            return array[index];
        }
        return -1; // 원래는 Exception 던져줘야 함.
    }

    public boolean insert(int index, int value) {
        if (index >= 0 && index <= length) {
            if (capacity == length) {
                capacity *= 2;
                int[] newArray = new int[capacity];
                System.arraycopy(array, 0, newArray, 0, index);
                newArray[index] = value;
                System.arraycopy(array, index, newArray, index + 1, length - index);
                this.array = newArray;
            } else {
                System.arraycopy(array, index, array, index + 1, length - index);
                array[index] = value;
            }

            length++;

            return true;
        }
        return false;
    }

    public boolean remove(int index) {
        if (index >= 0 && index <= length) {
            if (capacity == length) {
                int[] newArray = new int[capacity * 2];
                System.arraycopy(array, 0, newArray, 0, index - 1);
                System.arraycopy(array, index + 1, newArray, index, length - index - 1);
                this.array = newArray;
            } else {
                System.arraycopy(array, index + 1, array, index, length - index - 1);
            }

            length--;

            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < length; i++) {
            sb.append(array[i]);
            if (i < length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList myList = new MyArrayList(8);
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
