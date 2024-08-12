package algorithm.bj.no_2339;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = Integer.parseInt(sc.nextLine());

        Integer[][] board = new Integer[max][max];

        for(int i = 0; i < max; i ++) {
            String[] line = sc.nextLine().split(" ");
            int j = 0;
            for (String number: line) {
                board[i][j] = Integer.parseInt(number);
                j ++;
            }
        }


    }
}
