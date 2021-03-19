package _2021_카카오블라인드채용.광고삽입;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int play_time_sec = convertTimeToSec(play_time);
        int adv_time_sec = convertTimeToSec(adv_time);

        int[] playTimeCount = new int[play_time_sec];

        for (String log : logs) {
            String[] logSplit = log.split("-");
            int startTime = convertTimeToSec(logSplit[0]);
            int endTime = convertTimeToSec(logSplit[1]);

            for (int i = startTime; i < endTime; i++) {
                playTimeCount[i]++;
            }
        }

        long totalAdvPlaySec = 0;

        for (int i = 0; i < adv_time_sec; i++) {
            totalAdvPlaySec += playTimeCount[i];
        }

        long max = totalAdvPlaySec;
        int start = 0;

        for (int i = adv_time_sec; i < play_time_sec; i++) {
            totalAdvPlaySec += playTimeCount[i] - playTimeCount[i - adv_time_sec];
            if (max < totalAdvPlaySec) {
                start = i - adv_time_sec + 1;
                max = totalAdvPlaySec;
            }
        }

        return convertSecToTime(start);
    }

    static int convertTimeToSec(String time) {
        String[] timeSplit = time.split(":");

        return Integer.parseInt(timeSplit[0]) * 3600 + Integer.parseInt(timeSplit[1]) * 60 + Integer.parseInt(timeSplit[2]);
    }

    static String convertSecToTime(int seconds) {
        int time = seconds / 3600;
        int min = (seconds % 3600) / 60;
        int sec = seconds % 60;

        return String.format("%02d:%02d:%02d", time, min, sec);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("02:03:55", "00:14:15", new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"}));
    }
}