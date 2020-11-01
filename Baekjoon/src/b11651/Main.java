package b11651;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Location[] locations = new Location[n];
        for (int i = 0; i < n; i++) {
            String[] location = br.readLine().split(" ");
            locations[i] = new Location(Integer.parseInt(location[0]), Integer.parseInt(location[1]));
        }
        Arrays.sort(locations);
        for (int i = 0; i < n; i++) {
            bw.write(String.valueOf(locations[i]));
        }
        bw.flush();
        bw.close();
    }

    static class Location implements Comparable<Location> {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y + "\n";
        }

        @Override
        public int compareTo(Location o) {
            if (o.y == this.y) {
                return this.x - o.x;
            }
            return this.y - o.y;
        }
    }
}