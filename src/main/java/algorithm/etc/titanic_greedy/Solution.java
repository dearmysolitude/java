package algorithm.titanic_greedy;

import java.util.Arrays;

class Solution {
    public static int solution(int[] nums, int m) {
        Arrays.sort(nums);
        int answer = 0;

        int left = 0, right = nums.length - 1;
        while(left < right) {
            if ((nums[left] + nums[right]) <= m) {
                answer++;
                left++;
                right --;
            } else {
                answer ++;
                right --;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{90, 50, 70, 100, 60}, 140));  // 3
        System.out.println(solution(new int[]{86, 95, 107, 67, 38, 49, 116, 22, 78, 53}, 150));  // 5
        System.out.println(solution(new int[]{68, 72, 30, 105, 55, 115, 35, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));  //14
    }
}
