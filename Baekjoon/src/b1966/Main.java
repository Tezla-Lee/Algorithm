package b1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int want = Integer.parseInt(st.nextToken());
            String[] importance = br.readLine().split(" ");
            ArrayList<Document> list = new ArrayList<>();
            boolean flag;
            for (int j = 0; j < n; j++) {
                list.add(new Document(j, Integer.parseInt(importance[j])));
            }
            while (!list.isEmpty()) {
                flag = false;
                count++;
                Document temp = list.remove(0);
                for (int j = 0; j < list.size(); j++) {
                    if (temp.importance < list.get(j).importance) {
                        list.add(temp);
                        count--;
                        flag = true;
                        break;
                    }
                }
                if (!flag && temp.order == want) {
                    sb.append(count).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}

class Document {
    int order;
    int importance;

    public Document(int order, int importance) {
        this.order = order;
        this.importance = importance;
    }
}
