package _2019카카오블라인드채용.후보키;

import java.util.ArrayList;

public class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        ArrayList<String> candidateKey;
        ArrayList<Integer> notCandidate = new ArrayList<>();
        ArrayList<Integer> notCandidate2 = new ArrayList<>();
        for (int i = 0; i < relation[0].length; i++) {
            candidateKey = new ArrayList<>();
            for (int j = 0; j < relation.length; j++) {
                if (candidateKey.contains(relation[j][i])) {
                    notCandidate.add(i);
                    break;
                } else {
                    candidateKey.add(relation[j][i]);
                }
            }
//            System.out.println(candidateKey);
            if (candidateKey.size() == relation.length) {
                answer++;
            }
        }
//        System.out.println(notCandidate);
        Boolean check = true;
        if (notCandidate.size() > 1) {
            for (int i = 0; i < notCandidate.size(); i++) {
                for (int j = i + 1; j < notCandidate.size(); j++) {
                    candidateKey = new ArrayList<>();
                    for (int k = 0; k < relation.length; k++) {
                        if (candidateKey.contains(relation[k][notCandidate.get(i)] + relation[k][notCandidate.get(j)])) {
                            if (!notCandidate2.contains(notCandidate.get(i))) {
                                notCandidate2.add(notCandidate.get(i));
                            }
                            if (!notCandidate2.contains(notCandidate.get(j))) {
                                notCandidate2.add(notCandidate.get(j));
                            }
//                            System.out.println(candidateKey);
                            break;
                        }
                        candidateKey.add(relation[k][notCandidate.get(i)] + relation[k][notCandidate.get(j)]);
                    }
//                System.out.println(candidateKey);
                    if (candidateKey.size() == relation.length) {
//                        System.out.println(candidateKey);
                        check = false;
                        answer++;
                    }
                }
            }
        }
//        System.out.println(notCandidate2);
        if (check) {
            for (int i = 0; i < notCandidate2.size(); i++) {
                for (int j = i + 1; j < notCandidate2.size(); j++) {
                    for (int k = j + 1; k < notCandidate2.size(); k++) {
                        candidateKey = new ArrayList<>();
                        for (int l = 0; l < relation.length; l++) {
                            if (candidateKey.contains(relation[l][notCandidate2.get(i)] + relation[l][notCandidate2.get(j)] + relation[l][notCandidate2.get(k)])) {
                                break;
                            }
                            candidateKey.add(relation[l][notCandidate2.get(i)] + relation[l][notCandidate2.get(j)] + relation[l][notCandidate2.get(k)]);
                        }
                        if (candidateKey.size() == relation.length) {
                            System.out.println(candidateKey);
                            answer++;
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}}));
    }
}
