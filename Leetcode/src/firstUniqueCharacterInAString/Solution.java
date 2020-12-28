package firstUniqueCharacterInAString;

class Solution {
    public int firstUniqChar(String s) {
        char[] chars = new char[123];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}