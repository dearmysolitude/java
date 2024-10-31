package algorithm.programmers.diskController;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        int[][] jobsOne= {{2, 6}, {1, 9}, {0, 3}};

        int[][][] examples = {jobsOne};
        int count = 0;
        try {
            for(int[][]example : examples) {
                count ++;
                int answer = solution(example);
                assert answer == 9 : "틀림";
            }
        } catch(AssertionError ae) {
            System.out.printf("Catch: %d 번 %s\n", count,ae.getMessage());
        }
        System.out.println("Done");
    }

    public static int solution(int[][] jobs) {
        int answer = 0;

        int currentTime = 0;
        Arrays.sort(jobs, Comparator.comparingInt(job -> job[0]));
        currentTime = jobs[0][0] + jobs[0][1];



        for(int[] job: jobs) {
            System.out.printf("도착 시간: %d, 필요 시간: %d\n", job[0], job[1]);
        }
        return answer;
    }
}
