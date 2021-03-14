package 극비문제.리눅스쉘;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String solution(String[] directory, String[] command) {
        root = new Directory(null, "");

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
            if (d.equals("")) {
                continue;
            }

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
        if (directory.parent == root) {
            fullDir += directory.name;
        } else {
            fullDir += "/" + directory.name;
        }

        sb.append(fullDir).append("\n");

        directory.children.sort((a, b) -> a.name.compareTo(b.name));

        for (Directory child : directory.children) {
            dfs(child, sb, fullDir);
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().solution(new String[]{"/", "/hello", "/hello/tmp"}, new String[]{"mkdir /abc"}));
//        System.out.println(new Solution().solution(new String[]{"/", "/hello", "/hello/tmp", "/root", "/root/bcd", "/root/abcd", "/root/abcd/etc", "/root/abcd/hello"},
//                new String[]{"mkdir /root/tmp", "cp /hello /root/tmp", "rm /hello"}));
        // [/, /a, /a/b, /a/b/c, /a/b/c/d, /a/b/e, /a/tt, /tmp, /tmp/a, /tmp/a/b, /tmp/a/b/c, /tmp/a/b/c/d, /tmp/a/c, /tmp2, /tmp2/b, /tmp2/b/e]
        System.out.println(new Solution().solution(new String[]{"/", "/a", "/a/b"}, new String[]{"mkdir /a/c",
                "mkdir /a/b/e",
                "mkdir /tmp",
                "mkdir /a/b/c/d",
                "cp /a /tmp",
                "mkdir /tmp2",
                "cp /tmp/a/b /tmp2",
                "mkdir /a/tt",
//                "rm /tmp/a/b/e",
//                "rm /tmp2/b/c",
//                "rm /a/c"
        }));

    }
}

class Directory {
    Directory parent;
    List<Directory> children;
    String name;

    public Directory(Directory parent, String name) {
        this.parent = parent;
        this.name = name;
        this.children = new ArrayList<>();
    }
}