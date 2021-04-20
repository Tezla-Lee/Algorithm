package _2020_카카오블라인드채용.괄호변환;

public class Solution {
    public String solution(String p) {
        return translateToCorrectString(p);
    }

    private String translateToCorrectString(String p) {
        if (p.equals("")) {
            return p;
        }

        String[] uv = splitBalancedString(p);
        String u = uv[0];
        String v = uv[1];

        if (isCorrectString(u)) {
            if (!v.equals("")) {
                v = translateToCorrectString(v);
            }
            return u + v;
        } else {
            char[] chars = u.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < chars.length - 1; i++) {
                if (chars[i] == '(') {
                    sb.append(")");
                } else {
                    sb.append("(");
                }
            }
            return "(" + translateToCorrectString(v) + ")" + sb;
        }
    }

    private String[] splitBalancedString(String p) {
        String[] result = new String[2];
        char[] chars = p.toCharArray();
        int count = 0;
        int index = 0;

        while (index < chars.length) {
            if (chars[index++] == '(') {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                break;
            }
        }
        result[0] = p.substring(0, index);
        result[1] = p.substring(index);

        return result;
    }

    private boolean isCorrectString(String p) {
        char[] chars = p.toCharArray();
        int count = 0;

        for (char c : chars) {
            if (c == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }
        return true;
    }
}
