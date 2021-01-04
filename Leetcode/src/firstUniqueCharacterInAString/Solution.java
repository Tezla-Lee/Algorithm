package firstUniqueCharacterInAString;

class Solution {
    public int firstUniqChar(String s) {
        char[] c = s.toCharArray();
        char[] chars = new char[123];

        for (int i = 0; i < s.length(); i++) {
            chars[c[i]]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (chars[c[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}