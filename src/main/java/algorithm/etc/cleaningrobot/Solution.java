package algorithm.etc.cleaningrobot;

import java.util.*;

class Solution {
    public int[] solution(int[][] board, int k){
        int[] answer = new int[2]; // 행, 렬 순서임

        int count = 0;
        int flag= 0;

        while(count < k) {
            if(!move(flag, board.length, answer, board)) {
                flag++;
                if(flag == 4) {
                    flag = 0;
                }
            }
            count ++;
//            System.out.println("시간: "+ count +"현위치 - 행: " + answer[0] + ", 열:" + answer[1]);
        }

        return answer;
    }

    private boolean move(int flag, int n, int[] coordinate, int[][] board) {
        switch(flag) {
            case 0:
                if(coordinate[1] == n - 1 || !valid(board, coordinate[0], coordinate[1] + 1)) {
                    return false;
                }
                coordinate[1]++;
                return true;
            case 1:
                if(coordinate[0] == n - 1 || !valid(board, coordinate[0] + 1, coordinate[1])) {
                    return false;
                }
                coordinate[0] ++;
                return true;
            case 2:
                if(coordinate[1] == 0 || !valid(board, coordinate[0], coordinate[1] - 1)) {
                    return false;
                }
                coordinate[1] --;
                return true;
            case 3:
                if(coordinate[0] == 0|| !valid(board, coordinate[0] - 1, coordinate[1])) {
                    return false;
                }
                coordinate[0] --;
                return true;
            default:
                return false;
        }
    }

    private boolean valid(int[][] board, int row, int column) {
        if(board[row][column] == 1){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}
