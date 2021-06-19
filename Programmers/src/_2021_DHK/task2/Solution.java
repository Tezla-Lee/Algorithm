package _2021_DHK.task2;

class Solution {
    private final int MIN_FILE_SIZE = 245760;

    public String solution(String S) {
        int count = 0;
        String[] fileInfos = S.split("\n");

        for (String fileInfo : fileInfos) {
            String[] file = fileInfo.trim().split(" ");
            int year = Integer.parseInt(file[3]);
            String month = file[2];
            int size = Integer.parseInt(file[0]);

            if (size >= MIN_FILE_SIZE && ((year == 1990 && !month.equals("Jan")) || year >= 1991)) {
                count++;
            }
        }

        return count == 0 ? "NO FILES" : String.valueOf(count);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(" 779091968 23 Sep 2009 system.zip\n" +
                " 284164096 14 Aug 2013 to-do-list.xml\n" +
                " 714080256 19 Jun 2013 blockbuster.mpeg\n" +
                "       329 12 Dec 2010 notes.html\n" +
                " 444596224 17 Jan 1950 delete-this.zip\n" +
                "       641 24 May 1987 setup.png\n" +
                "    245760 16 Jul 2005 archive.zip\n" +
                " 839909376 31 Jan 1990 library.dll"));
    }
}
