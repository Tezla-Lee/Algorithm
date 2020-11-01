package b10814;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] ageAndName;
//        Info[] infos = new Info[n];
//
//        for (int i = 0; i < n; i++) {
//            ageAndName = br.readLine().split(" ");
//            infos[i] = new Info(i, Integer.parseInt(ageAndName[0]), ageAndName[1]);
//        }
//        Arrays.sort(infos, (a, b) -> {
//            if (a.age == b.age) {
//                return a.id - b.id;
//            }
//            return a.age - b.age;
//        });
//        for (int i = 0; i < n; i++) {
//            bw.write(infos[i].age + " " + infos[i].name + "\n");
//        }
//        bw.flush();
//        bw.close();

        // 방법 2
        StringBuilder[] sb = new StringBuilder[1000];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        for (int i = 0; i < n; i++) {
            ageAndName = br.readLine().split(" ");
            int age = Integer.parseInt(ageAndName[0]);
            String name = ageAndName[1];
            sb[age].append(age).append(" ").append(name).append("\n");
        }
        for (int i = 0; i < sb.length; i++) {
            bw.write(String.valueOf(sb[i]));
        }
        bw.flush();
        bw.close();
    }
}

class Info {
    int id;
    int age;
    String name;

    public Info(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
}
