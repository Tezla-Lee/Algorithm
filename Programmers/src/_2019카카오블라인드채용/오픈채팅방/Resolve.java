package _2019카카오블라인드채용.오픈채팅방;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Resolve {
    public String[] solution(String[] record) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String s : record) {
            String[] temp = s.split(" ");
            if (temp.length == 3) {
                hashMap.put(temp[1], temp[2]);
            }
        }

        ArrayList<String> arrayList = new ArrayList<>();

        for (String s : record) {
            String[] temp = s.split(" ");
            if (temp[0].equals("Enter")) {
                arrayList.add(hashMap.get(temp[1]) + "님이 들어왔습니다.");
            } else if (temp[0].equals("Leave")) {
                arrayList.add(hashMap.get(temp[1]) + "님이 나갔습니다.");
            }
        }

        return arrayList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Resolve().solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
    }
}