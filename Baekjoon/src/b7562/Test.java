package b7562;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String a = "안녕하세요. ";
        System.out.println(plus(a));

        int b = 5;
        plus(b);
        System.out.println(b);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        plus(list);
        System.out.println(list);

        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        System.out.println(s1 == s2); // heap 에 있는 같은 hello 를 가리킴
        System.out.println(s2 == s3); // s3는 heap 에 새로 생성된 hello 를 가리킴.
    }

    public static String plus(String sb) {
        sb += "안녕히 계세요.";
        return sb;
    }

    public static void plus(int i) {
        i += 10;
    }

    public static void plus(List<Integer> l) {
        l.add(Integer.MAX_VALUE);
    }
}
