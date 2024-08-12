package algorithm.bj.basic.smallerthanx_10871;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputOne = br.readLine().split(" ");
        String[] inputTwo = br.readLine().split(" ");

        int N = Integer.parseInt(inputOne[0]);
        int X = Integer.parseInt(inputOne[1]);

        for(String strNum: inputTwo) {
            int num = Integer.parseInt(strNum);

            if(num < X) {
                System.out.print(num + " ");
            }
        }
    }
}
