package 월간코드챌린지시즌1;

import java.util.ArrayList;

public class BeautifulString {
    public static long solution(String s) {
        long answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i);
            if (maxLDIAndRDI(temp) == 0) {
                break;
            }
            int count = 0;
            for (int j = s.length(); j >= i + 1; j--) {
                temp = s.substring(i, j);
                int l = temp.length();
//                System.out.print(temp + " ");
                if (temp.charAt(0) != temp.charAt(l - 1)) {
                    answer += l - 1;
//                    System.out.println(l - 1);
                } else {
                    count = maxLDIAndRDI(temp);
//                    System.out.println(count);
                    answer += count;
                    if (count == 0 && l != 1) {
                        break;
                    }
                }
            }
        }
        return answer;
    }

    public static int maxLDIAndRDI(String s) {
        String[] character = s.split("");
        int l = character.length;
        for (int i = l - 1; i >= 0; i--) {
            if (!character[0].equals(character[i]) || !character[i].equals(character[l - i - 1])) {
                return i;
            }
        }
        return 0;
    }

    public static int LDI(String s) {
        String[] character = s.split("");
        for (int i = character.length - 1; i >= 0; i--) {
            if (!character[0].equals(character[i])) {
                return i;
            }
        }
        return 0;
    }

    public static int RDI(String s) {
        String[] character = s.split("");
        for (int i = 0; i < character.length; i++) {
            if (!character[character.length - 1].equals(character[i])) {
                return character.length - i - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(solution("bbbaaaabbbbyyyyyyyyyyyy"));
//        System.out.println(solution("oo"));
//        System.out.println(solution("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
//        System.out.println(solution2("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbccccccccccaaaaaaabccccccccaaaffffg"));
//        System.out.println(solution("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbccccccccccaaaaaaabccccccccaaaffffg"));
        System.out.println(solution("baby"));
        System.out.println(solution2("baby"));
    }

    public static class AlphabetDummy {
        int numberOfAlphabet;
        char alphabet;

        public AlphabetDummy(int numberOfAlphabet, char alphabet) {
            this.numberOfAlphabet = numberOfAlphabet;
            this.alphabet = alphabet;
        }

        @Override
        public String toString() {
            return "(" + numberOfAlphabet + ", " + alphabet + ")";
        }
    }

    public static long solution2(String s) {
        int answer = 0;
        char[] alphabets = s.toCharArray();
        ArrayList<AlphabetDummy> arr = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < alphabets.length; i++) {
            if (i == alphabets.length - 1) {
                if (count > 1) {
                    arr.add(new AlphabetDummy(++count, alphabets[i]));
                } else {
                    arr.add(new AlphabetDummy(1, alphabets[i]));
                }
            } else if (alphabets[i] == alphabets[i + 1]) {
                count++;
            } else {
                arr.add(new AlphabetDummy(count, alphabets[i]));
                count = 1;
            }
//            if (i == 0) {
//                if (alphabets[i] != alphabets[i + 1]) {
//                    arr.add(new AlphabetDummy(count, alphabets[i]));
//                }
//            } else if (alphabets[i] == alphabets[i - 1] && i != alphabets.length - 1) {
//                count++;
//            } else if (i == alphabets.length - 1) {
//                if (alphabets[i] == alphabets[i - 1]) {
//                    count++;
//                    arr.add(new AlphabetDummy(count, alphabets[i - 1]));
//                } else {
//                    arr.add(new AlphabetDummy(count, alphabets[i - 1]));
//                    arr.add(new AlphabetDummy(1, alphabets[i]));
//                }
//            } else {
//                arr.add(new AlphabetDummy(count, alphabets[i - 1]));
//                count = 1;
//            }
        }
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(i).alphabet != arr.get(j).alphabet) {
                    int sum = 0;
                    for (int k = i + 1; k < j; k++) {
                        sum += arr.get(k).numberOfAlphabet;
                        System.out.println(arr.get(k).alphabet);
                    }
                    int n = arr.get(i).numberOfAlphabet;
                    int m = arr.get(j).numberOfAlphabet;
                    answer += sum * n * m;
                    answer += (m * (n * (n + 1) + m - 1)) / 2;
                    System.out.println(arr.get(i).alphabet + ", " + arr.get(j).alphabet + "  " + sum + " " + (sum * n * m + (m * (n * (n + 1) + m - 1)) / 2));
                } else {
                    int sum = 0;
                    for (int k = i + 1; k < j; k++) {
                        sum += arr.get(k).numberOfAlphabet;
                        System.out.println(arr.get(k).alphabet);
                    }
                    int n = arr.get(i).numberOfAlphabet;
                    int m = arr.get(j).numberOfAlphabet;
                    answer += sum * n * m;
                    answer += (m * (n * (n - 1))) / 2;
                    System.out.println(arr.get(i).alphabet + ", " + arr.get(j).alphabet + "  " + sum + " " + (sum * n * m + (m * (n * (n + 1))) / 2));
                }
            }
        }

//        System.out.println(Arrays.toString(alphabets));
//        System.out.println(arr);
        return answer;
    }
}
