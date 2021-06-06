package valid_anagram;

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            counts[c - 'a']--;
        }

        for (int c : counts) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }
}