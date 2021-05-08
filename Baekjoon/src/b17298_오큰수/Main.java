package b17298_오큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> indexStack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (indexStack.isEmpty()) {
                indexStack.push(i);
                continue;
            }

            while (!indexStack.isEmpty() && nums[indexStack.peek()] < nums[i]) {
                nums[indexStack.pop()] = nums[i];
            }

            indexStack.push(i);
        }

        while (!indexStack.isEmpty()) {
            nums[indexStack.pop()] = -1;
        }

        for (int num : nums) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
