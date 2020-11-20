package b4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int small = 0;
            int big = 0;
            boolean flag = false;
            int count = 0;
            String[] sentence = br.readLine().split("");
            if (sentence.length == 1 && sentence[0].equals(".")) {
                break;
            }
            for (String value : sentence) {
                if (value.equals("(")) {
                    count++;
                }
            }
            int[] smallInBig = new int[count + 1];
            label:
            for (String s : sentence) {
                switch (s) {
                    case "(":
                        small++;
                        break;
                    case ")":
                        if (smallInBig[small] != 0) {
                            flag = true;
                            break label;
                        }
                        small--;
                        break;
                    case "[":
                        big++;
                        smallInBig[small]++;
                        break;
                    case "]":
                        big--;
                        smallInBig[small]--;
                        break;
                }

                if (small < 0 || big < 0 || smallInBig[small] < 0) {
                    flag = true;
                    break;
                }
            }
            if (flag || small != 0 || big != 0) {
                sb.append("no");
            } else {
                sb.append("yes");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
