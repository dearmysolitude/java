package algorithm.programmers.distantNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.printf("답은 3, 산출 결과는: %d", solution(n, vertex));
    }

    public static int solution(int n, int[][] edges) {
        int answer = 0;
        int[] validNode = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        validNode[1] = 1;
        while(true) {
            int changedNum = 0;
            Queue<Integer> tempQueue = new LinkedList<>();
            while(!queue.isEmpty()) {
                int now = queue.poll();
                for(int[] edge: edges) {
                    if(edge[0] == now && validNode[edge[1]] == 0) {
                        validNode[edge[1]] = 1;
                        changedNum ++;
                        tempQueue.add(edge[1]);
                    } else if(edge[1] == now && validNode[edge[0]] == 0) {
                        validNode[edge[0]] = 1;
                        changedNum ++;
                        tempQueue.add(edge[0]);
                    }
                }

            }

            if(changedNum == 0) {
                break;
            }
            answer = changedNum;
            queue = tempQueue;
        }
        return answer;
    }
}
