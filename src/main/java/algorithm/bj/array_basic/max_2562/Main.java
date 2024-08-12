package algorithm.bj.array_basic.max_2562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int maxIndex = -1;
        for(int i = 0; i < 9; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input > max) {
                max = input;
                maxIndex = i;
            }
        }
        System.out.println(max);
        System.out.println(maxIndex + 1);
    }
}
