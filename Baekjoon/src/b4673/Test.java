package b4673;

import java.util.HashSet;
import java.util.Iterator;

public class Test {
    static int d(int n) {
        int sum = n;
        while (true) {
            sum += n % 10;
            if (n / 10 == 0) break;
            n /= 10;
        }
        return sum;
    }

    static void selfNumber() {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= 10000 ; i++) {
            set.add(i);
        }
        for (int i = 1; i <= 10000 ; i++) {
            set.remove(d(i));
        }
        Iterator<Integer> it =  set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        selfNumber();
    }
}