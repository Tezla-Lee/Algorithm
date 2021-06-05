package _2021_라핀인.프로그래밍2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public int[] solution(int endingTime, int[][] jobs) {
        Queue<Job> queue = new LinkedList<>();
        List<Integer> completeJobs = new ArrayList<>();
        int currentTime = 0;

        for (int[] job : jobs) {
            queue.add(new Job(job[0], job[1], job[2], job[3]));
        }

        while (!queue.isEmpty()) {
            Job job = queue.poll();

            // 입력 시간이 시스템 종료시간이상이면 pass
            if (job.inputTime >= endingTime) {
                continue;
            }

            // 현재시간이 Job 입력시간보다 작으면 현재 시간을 Job 입력시간으로
            if (job.inputTime > currentTime) {
                currentTime = job.inputTime;
            }

            // 현재 시간을 작업 완료시간으로 변경
            currentTime += job.workingTime;

            // 유효시간과 시스템 종료시간 이내에 완료된 작업이면 완료 list에 추가
            if (currentTime <= job.validTime && currentTime <= endingTime) {
                completeJobs.add(job.id);
            }
        }

        int[] result = new int[completeJobs.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = completeJobs.get(i);
        }

        return result;
    }

    private static class Job {
        int id;
        int inputTime;
        int validTime;
        int workingTime;

        public Job(int id, int inputTime, int validTime, int workingTime) {
            this.id = id;
            this.inputTime = inputTime;
            this.validTime = validTime;
            this.workingTime = workingTime;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "id=" + id +
                    ", inputTime=" + inputTime +
                    ", validTime=" + validTime +
                    ", workingTime=" + workingTime +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(0, new int[][]{{1, 10, 20, 4}, {2, 12, 20, 2}})));
        System.out.println(Arrays.toString(new Solution().solution(30, new int[][]{{1, 10, 20, 6}, {2, 12, 20, 8}, {3, 20, 30, 2},
                {4, 25, 40, 10}})));
        System.out.println(Arrays.toString(new Solution().solution(40, new int[][]{{1, 10, 20, 3}, {2, 14, 20, 9},
                {3, 18, 24, 2}, {4, 25, 40, 5}, {5, 28, 40, 1}})));
    }
}