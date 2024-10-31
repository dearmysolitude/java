package algorithm.programmers.parentheses;

public class Solution {
    public static void main(String[] args) {
        String example = "()()()()";

        if(solution(example)) {
            System.out.println("옳은 문자열");
        } else{
            System.out.println("틀린 문자열");
        }
        System.out.println("Done");
    }

    public static boolean solution(String s) {
        int stack = 0;
        for(char a: s.toCharArray()) {
            if(a == '(') {
                stack ++;
            } else {
                stack --;
            }
            if(stack < 0) {
                return false;
            }
        }
        return (stack == 0);
    }
}
