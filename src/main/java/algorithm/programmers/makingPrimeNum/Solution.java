package algorithm.programmers.makingPrimeNum;

public class Solution {
    public static void main(String[] args) {
        int[][] testSet = {{1, 2, 3, 4},
                {1, 2, 7, 6, 4}};
        int[] answerSet = {1, 4};

        for(int i = 0; i < 2;i++) {
            System.out.println("답: " + answerSet[i] + ", 로직 결과: " + solution(testSet[i]));
        }
    }

    public static int solution(int[] nums) {
        int answer = 0;

        for(int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    int isItPrime = nums[i] + nums[j] + nums[k];
                    int indicator = (int)Math.sqrt(isItPrime);
                    for (int l = 2; l <= indicator; l++) {
                        if(isItPrime % l == 0) {
                            break;
                        }
                        if(l == indicator) {
                            answer ++;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
