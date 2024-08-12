package algorithm.bj.basic.yunneun_2753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        if(input % 4 != 0) {
            System.out.println(0);
            return;
        }
        if(input % 100 == 0 && input % 400 != 0) {
            System.out.println(0);
            return;
        }
        System.out.println(1);
    }
}
