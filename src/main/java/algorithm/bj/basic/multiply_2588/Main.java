package algorithm.bj.basic.no_2588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int one = Integer.parseInt(br.readLine());
        int two = Integer.parseInt(br.readLine());

        System.out.println(one * (two % 10));
        System.out.println(one * ((two / 10) - two / 100 * 10));
        System.out.println(one * (two / 100));
        System.out.println(one * two);
    }
}
