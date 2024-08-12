package algorithm.etc.example_dfs;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        int digit = (String.valueOf(n)).length();
        char[] numbers = new char[digit];

        for(int i = 0; i < digit; i++) {
            numbers[i] = String.valueOf(n).charAt(i);
        }

        

        return answer;
    }

//    public static String makeNumber() {
//
//    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}
