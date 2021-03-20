package _2021_공채.코딩테스트.프로그래밍4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String[] solution(String[] data, String word) {
        HashMap<Integer, Node> map = new HashMap<>();

        List<Node> leafNodes = new ArrayList<>();

        for (String nodeInfo : data) {
            String[] nodeInfos = nodeInfo.split(" ");

            Node node = new Node(nodeInfos[1], Integer.parseInt(nodeInfos[2]));

            map.put(Integer.parseInt(nodeInfos[0]), node);

            leafNodes.add(node); // 일단 리프노드 리스트에 추가

            // node의 부모 id를 갖는 노드를 리스트에서 제거
            if (node.parentId != 0) {
                leafNodes.remove(map.get(node.parentId));
            }
        }

        List<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (Node leafNode : leafNodes) {
            Node curr = leafNode;

            if (curr.name.contains(word)) {
                sb = new StringBuilder();

                while (true) {
                    sb.insert(0, curr.name + "/");

                    if (curr.parentId == 0) {
                        break;
                    } else {
                        curr = map.get(curr.parentId);
                    }
                }

                sb.deleteCharAt(sb.length() - 1);

                answer.add(sb.toString());
            }

        }

        answer.sort((a, b) -> {

            if (a.equals(word)) {
                return -1;
            }

            if (b.equals(word)) {
                return 1;
            }

            return b.split(word).length - a.split(word).length;
        });

        if (answer.isEmpty()) {
            answer.add("Your search for (" + word + ") didn't return any results");
        }

        return answer.toArray(new String[0]);
    }
}

class Node {
    String name;
    int parentId;

    public Node(String name, int parentId) {
        this.name = name;
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return name;
    }
}