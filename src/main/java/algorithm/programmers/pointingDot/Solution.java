package algorithm.programmers.pointingDot;

public class Solution {
    public static void main(String[] args) {
        int[][] testCases = {{2, 4}, {1, 5}};
        System.out.println("정답: 6, 로직 결과: " + solution(testCases[0][0], testCases[0][1]));
        System.out.println("정답: 26, 로직 결과: " + solution(testCases[1][0], testCases[1][1]));
    }

    public static long solution(int k, int d) {
        long answer = 0;
        double dSquare = Math.pow(d, 2);
        for(int x = 0; x <= d; x += k) {
            double yLimit = Math.sqrt(dSquare - Math.pow(x, 2));
            answer += (long) (yLimit / k) + 1;
        }
        return answer;
    }
}
