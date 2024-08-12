package algorithm.bj.basic.escape_1085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int x = Integer.parseInt(inputs[0]);
        int y = Integer.parseInt(inputs[1]);
        int w = Integer.parseInt(inputs[2]);
        int h = Integer.parseInt(inputs[3]);

        int min = 10000;

        if(w - x < min) {
            min = w - x;
        }
        if(x< min) {
            min = x;
        }
        if(h - y < min) {
            min = h - y;
        }
        if(y < min) {
            min = y;
        }
        System.out.println(min);
    }
}
