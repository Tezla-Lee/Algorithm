package _2021_카카오블라인드채용.신규아이디추천;

class Solution {
    public String solution(String new_id) {
        return new ID(new_id.toLowerCase())
                .removeSpecialLetter()
                .replacePointsToPoint()
                .removeFirstAndLastPoint()
                .appendA()
                .splitLength15AndRemoveLastPoint()
                .appendRepeat()
                .id;
    }

    static class ID {
        private String id;

        public ID(String id) {
            this.id = id;
        }

        private boolean filter(char c) {
            return Character.isLetterOrDigit(c) || c == '-' || c == '_' || c == '.';
        }

        private ID removeSpecialLetter() {
            StringBuilder sb = new StringBuilder();

            for (char c : id.toCharArray()) {
                if (filter(c)) {
                    sb.append(c);
                }
            }

            id = sb.toString();

            return this;
        }

        private ID replacePointsToPoint() {
            while (!id.equals(id.replace("..", "."))) {
                id = id.replace("..", ".");
            }

            return this;
        }

        private ID removeFirstAndLastPoint() {
            if (id.charAt(0) == '.') {
                id = id.replaceFirst(".", "");
            }

            if (!id.isEmpty() && id.charAt(id.length() - 1) == '.') {
                id = id.substring(0, id.length() - 1);
            }

            return this;
        }

        private ID splitLength15AndRemoveLastPoint() {
            if (id.length() < 16) {
                return this;
            }

            id = id.substring(0, 15);

            if (id.charAt(id.length() - 1) == '.') {
                id = id.substring(0, 14);
            }

            return this;
        }

        private ID appendRepeat() {
            StringBuilder sb = new StringBuilder(id);
            char last = id.charAt(id.length() - 1);

            while (sb.length() < 3) {
                sb.append(last);
            }

            id = sb.toString();

            return this;
        }

        private ID appendA() {
            if (id == null || id.equals("")) {
                id = "a";
            }

            return this;
        }
    }
}