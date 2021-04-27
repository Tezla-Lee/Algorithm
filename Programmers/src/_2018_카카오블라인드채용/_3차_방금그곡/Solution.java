package _2018_카카오블라인드채용._3차_방금그곡;

import java.util.*;

public class Solution {
    public String solution(String m, String[] musicinfos) {
        Queue<Music> pq = new PriorityQueue<>();

        for (int i = 0; i < musicinfos.length; i++) {
            pq.offer(convertToMusic(musicinfos[i], i));
        }

        m = convertSharpToInt(m);

        while (!pq.isEmpty()) {
            Music music = pq.poll();

            if (music.melody.contains(m)) {
                return music.name;
            }
        }

        return "(None)";
    }

    private Music convertToMusic(String music, int order) {
        String[] info = music.split(",");
        String[] startTime = info[0].split(":");
        String[] endTime = info[1].split(":");

        String name = info[2];
        int playTime = (Integer.parseInt(endTime[0]) - Integer.parseInt(startTime[0])) * 60 + (Integer.parseInt(endTime[1]) - Integer.parseInt(startTime[1]));
        String melody = getPlayingMelody(convertSharpToInt(info[3]), playTime);

        return new Music(name, playTime, order, melody);
    }

    private String getPlayingMelody(String melody, int playTime) {
        StringBuilder sb = new StringBuilder();
        char[] chars = melody.toCharArray();

        for (int i = 0; i < playTime / melody.length(); i++) {
            sb.append(melody);
        }

        for (int i = 0; i < playTime % melody.length(); i++) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }

    private String convertSharpToInt(String s) {
        return s.replaceAll("C#", "1")
                .replaceAll("D#", "2")
                .replaceAll("F#", "3")
                .replaceAll("G#", "4")
                .replaceAll("A#", "5");
    }

    static private class Music implements Comparable<Music> {
        String name;
        int playTime;
        int order;
        String melody;

        public Music(String name, int playTime, int order, String melody) {
            this.name = name;
            this.playTime = playTime;
            this.order = order;
            this.melody = melody;
        }

        public int compareTo(Music o) {
            return o.playTime == playTime ? order - o.order : o.playTime - playTime;
        }
    }
}