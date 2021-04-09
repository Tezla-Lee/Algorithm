package b20055_컨베이어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static Conveyor[] conveyorBelt;
    static List<Robot> robots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        conveyorBelt = new Conveyor[2 * n];
        robots = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n * 2; i++) {
            conveyorBelt[i] = new Conveyor(Integer.parseInt(st.nextToken()), false);
        }

        System.out.println(move());
    }

    static int move() {
        int count = 0;
        int grade = 0;

        while (count < k) {

            Conveyor[] tempConveyors = new Conveyor[2 * n];

            tempConveyors[0] = conveyorBelt[2 * n - 1];
            for (int i = 1; i < 2 * n; i++) {
                tempConveyors[i] = conveyorBelt[i - 1];
            }
            conveyorBelt = tempConveyors;

            List<Robot> removeList = new ArrayList<>();
            for (Robot robot : robots) {
                if (robot.location == n - 1) {
                    removeList.add(robot);
                    conveyorBelt[robot.location + 1].existRobot = false;
                    continue;
                }

                robot.location = (robot.location + 1) % (2 * n);

                if (robot.location == n - 1) {
                    removeList.add(robot);
                    conveyorBelt[robot.location].existRobot = false;
                }

                if (robot.location != n - 1 && !conveyorBelt[(robot.location + 1) % (2 * n)].existRobot && conveyorBelt[(robot.location + 1) % (2 * n)].durability > 0) {
                    conveyorBelt[robot.location].existRobot = false;
                    robot.location = (robot.location + 1) % (2 * n);
                    conveyorBelt[robot.location].existRobot = true;
                    conveyorBelt[robot.location].durability--;
                }
            }

            if (!removeList.isEmpty()) {
                for (Robot robot : removeList) {
                    robots.remove(robot);
                }
            }

            if (!conveyorBelt[0].existRobot && conveyorBelt[0].durability > 0) {
                robots.add(new Robot(0));
                conveyorBelt[0].durability--;
                conveyorBelt[0].existRobot = true;
            }

            count = 0;
            for (Conveyor conveyor : conveyorBelt) {
                if (conveyor.durability == 0) {
                    count++;
                }
            }

            grade++;
        }

        return grade;
    }
}

class Conveyor {
    int durability;
    boolean existRobot;

    public Conveyor(int durability, boolean existRobot) {
        this.durability = durability;
        this.existRobot = existRobot;
    }

    @Override
    public String toString() {
        return durability + " " + existRobot;
    }
}

class Robot {
    int location;

    public Robot(int location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return String.valueOf(location);
    }
}
