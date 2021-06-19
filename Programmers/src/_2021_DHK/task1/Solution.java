package _2021_DHK.task1;

import java.util.HashMap;

class Solution {
    public String solution(String S, String C) {
        String[] names = S.split(",");
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> nameCount = new HashMap<>();

        for (int i = 0; i < names.length; i++) {
            String name = convertName(names[i]);
            nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);

            int count = nameCount.get(name);

            sb.append(names[i]).append(" ");

            if (count == 1) {
                sb.append(convertToEmail(name, C));
            } else {
                sb.append(convertToEmail(name + (count), C));
            }

            if (i != names.length - 1) {
                sb.append(",");
            }
        }

        return sb.toString();
    }

    private String convertToEmail(String name, String company) {
        String email = '<' + name + '@' + company + ".com>";

        return email.toLowerCase();
    }

    private String convertName(String name) {
        String[] names = name.trim().replace("-", "").split(" ");

        if (names.length == 3) {
            return (names[0] + "." + names[2]);
        }
        return (names[0] + "." + names[1]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("John Doe, Peter Benjamin Parker, Mary Jane Watson-Parker, John Elvis Doe, John Evan Doe, Jane Doe, Peter Brian Parker", "Example"));
    }
}