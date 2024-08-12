package algorithm.bj.no_13430;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().split(" ");
        int k = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);

        System.out.println(S(k, n));
    }

    public static int S(int k, int n) {
        if(k == 0) {
            return n;
        }

        int retSum = 0;
        for(int i = 1; i < n + 1; i++) {
            retSum = retSum + S(k-1, i);
        }
        return retSum % 1000000007;
    }
}
