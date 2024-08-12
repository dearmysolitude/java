package algorithm.bj.array_basic.aboveAve_4344;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++) {
            String[] inputs = br.readLine().split(" ");
            int totalPerson = Integer.parseInt(inputs[0]);

            int[] scores = new int[totalPerson];
            int totalScore = 0;

            for(int j = 1; j < inputs.length; j++) {
                scores[j - 1] = Integer.parseInt(inputs[j]);
                totalScore += scores[j - 1];
            }

            double average = (double) totalScore / (double)totalPerson;
            int count = 0;
            for(int score : scores) {
                if(score > average) {
                    count += 1;
                }
            }
            System.out.printf("%.3f", (double)count/(double)totalPerson*100);
            System.out.println("%");
        }
    }
}
