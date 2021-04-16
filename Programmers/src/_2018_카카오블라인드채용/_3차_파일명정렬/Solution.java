package _2018_카카오블라인드채용._3차_파일명정렬;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public String[] solution(String[] files) {
        Queue<File> pq = new PriorityQueue<>();
        String[] answer = new String[files.length];

        for (int i = 0; i < files.length; i++) {
            pq.add(convertToFile(files[i], i));
        }

        int index = 0;
        while (!pq.isEmpty()) {
            answer[index++] = pq.poll().fullName;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        System.out.println(Arrays.toString(new Solution().solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
    }

    private File convertToFile(String file, int order) {
        StringBuilder sb = new StringBuilder();
        char[] chars = file.toCharArray();

        int index = 0;

        // Head
        while (index < chars.length && !Character.isDigit(chars[index])) {
            sb.append(chars[index++]);
        }
        String head = sb.toString();

        // Number
        sb = new StringBuilder();
        while (index < chars.length && Character.isDigit(chars[index])) {
            sb.append(chars[index++]);
        }
        int number = Integer.parseInt(sb.toString());

        return new File(file, head, number, order);
    }

    static class File implements Comparable<File> {
        String fullName;
        String head;
        int number;
        int inputOrder;

        public File(String fullName, String head, int number, int inputOrder) {
            this.fullName = fullName;
            this.head = head;
            this.number = number;
            this.inputOrder = inputOrder;
        }

        @Override
        public int compareTo(File o) {
            return head.equalsIgnoreCase(o.head) ? (number == o.number ? inputOrder - o.inputOrder : number - o.number)
                    : head.toLowerCase().compareTo(o.head.toLowerCase());
        }
    }
}
