package _2019_카카오개발자겨울인텁십.불량사용자;

public class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 1;

        int[] counts = new int[banned_id.length];

        for (int i = 0; i < banned_id.length; i++) {
            char[] banIdToChar = banned_id[i].toCharArray();
            for (String userId : user_id) {
                char[] userIdToChar = userId.toCharArray();
                if (userIdToChar.length != banIdToChar.length) {
                    continue;
                }
                boolean flag = true;
                for (int j = 0; j < userIdToChar.length; j++) {
                    if (banIdToChar[j] != '*' && banIdToChar[j] != userIdToChar[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    counts[i]++;
                }
            }
        }

        boolean flag = false;

        for (int count : counts) {
            if (count != 0) {
                flag = true;
                answer *= count;
            }
        }

        if (flag) {
            return answer;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
        System.out.println(new Solution().solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
    }
}