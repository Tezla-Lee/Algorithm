package _2021_카카오블라인드채용.신규아이디추천;

class Solution {
    public String solution(String new_id) {
        // 1단계
        new_id = new_id.toLowerCase();

        // 2단계
        new_id = removeSpecialLetter(new_id);

        // 3단계
        new_id = replacePointsToPoint(new_id);

        // 4단계
        new_id = removeFirstAndLastPoint(new_id);

        // 5단계
        if (new_id.equals("")) {
            new_id = "a";
        }

        // 6단계
        new_id = splitLength15AndRemoveLastPoint(new_id);

        // 7단계
        new_id = appendRepeat(new_id);

        return new_id;
    }

    private boolean filter(char c) {
        return Character.isLetterOrDigit(c) || c == '-' || c == '_' || c == '.';
    }

    private String removeSpecialLetter(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (filter(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private String replacePointsToPoint(String s) {
        while (!s.equals(s.replace("..", "."))) {
            s = s.replace("..", ".");
        }

        return s;
    }

    private String removeFirstAndLastPoint(String s) {
        if (s.charAt(0) == '.') {
            s = s.replaceFirst(".", "");
        }

        if (!s.isEmpty() && s.charAt(s.length() - 1) == '.') {
            s = s.substring(0, s.length() - 1);
        }

        return s;
    }

    private String splitLength15AndRemoveLastPoint(String s) {
        if (s.length() < 16) {
            return s;
        }

        s = s.substring(0, 15);

        if (s.charAt(s.length() - 1) == '.') {
            s = s.substring(0, 14);
        }

        return s;
    }

    private String appendRepeat(String s) {
        StringBuilder sb = new StringBuilder(s);
        char last = s.charAt(s.length() - 1);

        while (sb.length() < 3) {
            sb.append(last);
        }

        return sb.toString();
    }
}
