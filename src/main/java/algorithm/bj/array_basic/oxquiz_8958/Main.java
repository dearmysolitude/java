package algorithm.bj.array_basic.oxquiz_8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split("");
            int[] score = new int[input.length];
            int totalScore = 0;

            for(int j = 0; j < input.length; j++) {
                if(input[j].equals("X")) {
                    score[j] = 0;
                } else {
                    if(j == 0) {
                        score[j] = 1;
                        totalScore += score[j];
                        continue;
                    }
                    score[j] = score[j-1] + 1;
                }
                totalScore += score[j];
            }
            System.out.println(totalScore);
        }
    }
}
