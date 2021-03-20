package _2021_공채.단계별코딩테스트.프로그래밍1;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    static HashMap<String, String> rules; // key: flag_name, value: flag_argument_type
    static boolean[] isChecked; // command를 이루는 각각의 String을 체크했는지 저장

    public boolean[] solution(String program, String[] flag_rules, String[] commands) {
        boolean[] answer = new boolean[commands.length];

        rules = new HashMap<>();

        // rules 에 flag_name과 flag_argument_type을 key, value 쌍으로 저장
        for (String flag_rule : flag_rules) {
            String[] flag_rule_split = flag_rule.split(" ");
            rules.put(flag_rule_split[0], flag_rule_split[1]);
        }

        for (int i = 0; i < commands.length; i++) {
            answer[i] = isCorrectCommand(commands[i], program); // command 를 하나씩 확인하고 answer 배열에 저장
        }

        return answer;
    }

    public boolean isCorrectCommand(String command, String program) {
        String[] command_split = command.split(" ");
        isChecked = new boolean[command_split.length];

        if (!startsWithProgram(command_split, program)) { // command가 program으로 시작하는지 확인
            return false;
        }

        for (int i = 0; i < command_split.length; i++) {
            if (rules.containsKey(command_split[i])) { // rules에 저장 되어 있는 flag이면 체크한다
                if (!validate(command_split, i)) {
                    return false;
                }
            }
        }

        // rules 에 등록 되어 있는 flag에 대해 검증이 모두 되면, command의 모든 String을 검사한건지 확인
        for (boolean check : isChecked) {
            if (!check) {
                return false;
            }
        }

        return true;
    }

    public boolean validate(String[] command_split, int flag_argument_type_index) {
        String flag_argument_type = rules.get(command_split[flag_argument_type_index]);

        switch (flag_argument_type) { // 각각의 flag에 맞는지 확인
            case "STRING":
                return isString(command_split, flag_argument_type_index);
            case "NUMBER":
                return isNumber(command_split, flag_argument_type_index);
            case "NULL":
                return isNull(command_split, flag_argument_type_index);
        }
        return false;
    }

    // 알파벳 소문자 또는 대문자로만 이루어져 있는지 체크하는 메소드
    public boolean isString(String[] command_split, int index) {
        isChecked[index] = true;

        if (command_split.length - 1 == index) {
            return false;
        }

        isChecked[index + 1] = true;

        char[] chars = command_split[index + 1].toCharArray();

        for (char c : chars) {
            // 알파벳 소문자나 대문자가 아니면 false 를 리턴
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                return false;
            }
        }

        // 전부 통과했다면 true 리턴
        return true;
    }

    // 숫자로만 이루어져있는지 체크하는 메소드
    public boolean isNumber(String[] command_split, int index) {
        isChecked[index] = true;

        if (command_split.length - 1 <= index) {
            return false;
        }

        isChecked[index + 1] = true;

        char[] chars = command_split[index + 1].toCharArray();

        for (char c : chars) {
            // 숫자가 아니면 false 를 리턴
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }

        // 전부 통과했다면 true 리턴
        return true;
    }

    // NULL flag_argument_type에 대해 체크하는 메소드
    public boolean isNull(String[] command_split, int index) { // index는 flag의 위치를 나타냄
        isChecked[index] = true;
        if (index == command_split.length - 1) { // flag 가 command 마지막이면 true
            return true;
        }

        return command_split[index + 1].contains("-"); // NULL을 받아야 하는 flag 다음에 다른 flag가 오면 true
    }

    // command가 program으로 시작하는지 체크하는 메소드
    public boolean startsWithProgram(String[] command_split, String program) {
        isChecked[0] = true;
        return command_split[0].equals(program);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution("line", new String[]{"-s STRING", "-n NUMBER", "-e NULL"}, new String[]{"line -n 100 -s hi -e", "lien -s Bye"})));
        System.out.println(Arrays.toString(new Solution().solution("line", new String[]{"-s STRING", "-n NUMBER", "-e NULL"}, new String[]{"line -s 123 -n HI", "line fun"})));
    }
}