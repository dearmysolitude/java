package algorithm.etc.laddergame;

import java.util.*;
class Solution {
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];
        
        // 주의: ladder의 사다리는 1 부터 인덱스가 시작됨!
        for(int i = 0; i < n; i++) { // A 부터 n개의 대문자를
            answer[afterLadder(i, ladder)] = (char)(i + 65); // answer의 새로운 인덱스에 넣어준다.
        }
        
        return answer;
    }

    // 사다리 게임 후 변화된 인덱스를 반환. 
    public static int afterLadder(int index, int[][] ladder) { 
        for(int i = 0; i < ladder.length; i ++) { // 사다리 칸을 내려가면서
            for(int ladderNumber : ladder[i]) { // 그 열의 사다리를 왼쪽부터 오른쪽으로 훑는다.
                if (index + 1 == ladderNumber) { // 오른쪽으로 이동하는 경우
                    index ++;
                    continue;
                }
                if(index + 1 == ladderNumber + 1) { // 왼쪽으로 이동하는 경우
                    index --;
                }
            }
//            System.out.println((char)(index+65)+"의 "+ i + " 줄 통과 후 위치: "+ index);
        }
        return index;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}

