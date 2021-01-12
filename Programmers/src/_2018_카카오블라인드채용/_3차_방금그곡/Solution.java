package _2018_카카오블라인드채용._3차_방금그곡;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public String solution(String m, String[] musicinfos) {
        String[] music;
        StringBuilder sb;
        int playTime;
        int index = 0;
        int count;
        List<Music> musicList = new ArrayList<>();
        for (String musicInfo : musicinfos) {
            count = 0;
            sb = new StringBuilder();
            music = musicInfo.split(",");
            playTime = Integer.parseInt(music[1].split(":")[0]) * 60 - Integer.parseInt(music[0].split(":")[0]) * 60 + Integer.parseInt(music[1].split(":")[1]) - Integer.parseInt(music[0].split(":")[1]);
            if (playTime < 0) {
                playTime += 60;
            }
            for (int i = 0; i < music[3].length(); i++) {
                if (music[3].charAt(i) == '#') {
                    count++;
                }
            }

            for (int i = 0; i < playTime / (music[3].length() - count); i++) {
                sb.append(music[3]);
            }

            int count2;
            int temp = 0;
            while (true) {
                count2 = 0;
                String s = music[3].substring(0, playTime % (music[3].length() - count) + temp);
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '#') {
                        count2++;
                    }
                }
                if (count2 == temp) {
                    break;
                }
                temp = count2;
            }
            sb.append(music[3], 0, playTime % (music[3].length() - count) + count2);

//            for (int i = 0; i < sb.toString().length(); i++) {
//                Boolean check = true;
//                if (sb.toString().charAt(i) == m.charAt(0)) {
//                    for (int j = 0; j < m.length(); j++) {
//                        if (i + j > sb.toString().length() - 1 || m.charAt(j) != sb.toString().charAt(i + j)) {
//                            check = false;
//                            break;
//                        }
//                    }
//                    if (check && i + m.length() <= sb.toString().length() - 1 && sb.toString().charAt(i + m.length()) != '#') {
//                        musicList.add(new Music(playTime, music[2], index++));
//                    }
//                }
//            }

            int count3 = 0;
            while (sb.toString().indexOf(m, count3) + m.length() < sb.length()) {
                if (sb.toString().indexOf(m, count3) != -1) {
                    if (sb.toString().charAt(sb.toString().indexOf(m, count3) + m.length()) != '#') {
                        musicList.add(new Music(playTime, music[2], index++));
                        break;
                    } else {
                        count3 += m.length();
                    }
                } else {
                    break;
                }
            }
//            if (sb.toString().contains(m) && sb.toString().split(m).length > sb.toString().split(m + "#").length) {
//                musicList.add(new Music(playTime, music[2], index++));
//            }

//            if (!sb.toString().contains(m + "#") && sb.toString().contains(m)) {
//            musicList.add(new Music(playTime, music[2], index++));
//            }
        }
        Collections.sort(musicList);
        if (musicList.isEmpty()) {
            return "(None)";
        } else {
            return musicList.get(0).name;
        }
    }
}

class Music implements Comparable<Music> {
    int playTIme;
    int index;
    String name;

    public Music(int playTIme, String name, int index) {
        this.index = index;
        this.playTIme = playTIme;
        this.name = name;
    }

//    @Override
//    public String toString() {
//        return "playTIme=" + playTIme +
//                ", name='" + name + ", " + index + '\'' +
//                '}';
//    }

    @Override
    public int compareTo(Music o) {
        if (playTIme == o.playTIme) {
            return index - o.index;
        }
        return o.playTIme - playTIme;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("ABCDEFG", new String[]{"13:00,13:23,GOOD,CDEFGABCDEFG#AB", "12:00,12:12,HELLO,CDEFGAB", "13:00,13:03,WORLD,ABCDEF", "12:00,12:14,BYE,CDEFGAB"}));
        System.out.println(new Solution().solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(new Solution().solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(new Solution().solution("CCB", new String[]{"03:00,03:10,FOO,CCB#CCB", "04:00,04:08,BAR,ABC"}));
//        System.out.println(Arrays.toString("BCA#".split("BCA")));
//        System.out.println(Arrays.toString("BCA#".split("BCA#")));
    }
}