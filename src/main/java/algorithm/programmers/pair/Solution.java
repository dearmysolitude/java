package algorithm.programmers.pair;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[][] cases = {
                {"100", "2345"},
                {"100", "203045"},
                {"100", "123450"},
                {"12321", "42531"},
                {"5525", "1255"}
        };
        String[] answers = {"-1", "0", "10", "321", "552"};

        for(int i = 0; i < cases.length; i++) {
            String isItRight = solution(cases[i][0], cases[i][1]);
            if(isItRight.equals(answers[i])) {
                System.out.println(i + "번 정답: " + answers[i]);
            } else {
                System.out.println(i +"번 오답: " + answers[i] + "(정답), 산출결과: " + isItRight);
            }
        }
    }

    public static String solution(String A, String B) {
        int[] aChars = new int[10];
        int[] bChars = new int[10];
        int[] totalChars = new int[10];

        for(int i = 0; i < 10; i++) {
            aChars[i] = 0;
            bChars[i] = 0;
            totalChars[i] = 0;
        }

        for(char letter: A.toCharArray()) {
            aChars[Character.getNumericValue(letter)] ++;
        }
        for(char letter: B.toCharArray()) {
            bChars[Character.getNumericValue(letter)] ++;
        }

        for (int i = 0; i < 10; i++) {
            totalChars[i] = Math.min(aChars[i], bChars[i]);
        }

        StringBuilder temp = new StringBuilder();
        int notZero = -1;
        for(int i = 9; i >= 0; i--) {
            for(int j = totalChars[i]; j > 0; j--) {
                if(i != 0) {
                    notZero = 1;
                }
                temp.append(i);
            }
        }
        String answer = temp.toString();
        if(answer.isEmpty()) {
            return "-1";
        } else if(notZero != 1) {
            return "0";
        }
        return answer;
    }
}
