package 극비문제.리눅스쉘;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String solution(String[] directory, String[] command) {
        root = new Directory(null, "/");

        for (String dir : directory) {
            mkdir(dir);
        }

        for (String com : command) {
            run(com);
        }

        return print();
    }

    static Directory root;

    static void mkdir(String dir) {
        String[] dirs = dir.split("/");

        if (dirs.length == 0) {
            return;
        }

        Directory currDir = root;

        for (String d : dirs) {
            boolean flag = true;

            for (Directory child : currDir.children) {
                if (child.name.equals(d)) {
                    currDir = child;
                    flag = false;
                    break;
                }
            }

            if (flag) {
                Directory newDir = new Directory(currDir, d);
                currDir.children.add(newDir);
                currDir = newDir;
            }
        }
    }

    static void rm(String dir) {
        String[] dirs = dir.split("/");

        if (dirs.length == 0) {
            return;
        }

        Directory currDir = root;

        for (String d : dirs) {
            for (Directory child : currDir.children) {
                if (child.name.equals(d)) {
                    currDir = child;
                    break;
                }
            }
        }

        Directory parent = currDir.parent;
        parent.children.remove(currDir);
        currDir.parent = null;
    }

    static void cp(String source, String dest) {
        String dir = dest + source;

        mkdir(dir);
    }

    static void run(String command) {
        String[] com = command.split(" ");

        if (com[0].equals("mkdir")) {
            mkdir(com[1]);
        } else if (com[0].equals("rm")) {
            rm(com[1]);
        } else {
            cp(com[1], com[2]);
        }
    }

    static String print() {
        StringBuilder sb = new StringBuilder();

        dfs(root, sb, "");

        return sb.toString();
    }

    static void dfs(Directory directory, StringBuilder sb, String fullDir) {
        fullDir += "/" + directory.name;
        sb.append(fullDir).append("\n");

        for (Directory child : directory.children) {
            dfs(child, sb, fullDir);
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().solution(new String[]{"/", "/hello", "/hello/tmp"}, new String[]{"mkdir /abc"}));
        String s = "/hello/tmp";
        System.out.println(Arrays.toString(s.split("/")));
    }
}

class Directory implements Comparator<Directory> {
    Directory parent;
    List<Directory> children;
    String name;

    public Directory(Directory parent, String name) {
        this.parent = parent;
        this.name = name;
        this.children = new LinkedList<>();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compare(Directory o1, Directory o2) {
        return o1.name.compareTo(o2.name);
    }
}