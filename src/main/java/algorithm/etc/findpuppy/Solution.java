package algorithm.etc.findpuppy;

class Solution {
    public int solution(int[][] board){
        int answer = 0;
        
        int time = 0;
        int TIME_LIMIT = 10000;
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[] humanPos = new int[3]; // 사람의 최초 위치 + 방향
        int[] dogPos = new int[3]; // 개의 최초 위치 + 방향
        
        for(int i = 0; i < board.length; i++) { // 위치값 초기화
            for(int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 3) {// 개 초기 위치
                    dogPos[0] = i;
                    dogPos[1] = j;
                    dogPos[2] = 0;
                }
                if (board[i][j] == 2) {// 사람 초기 위치
                    humanPos[0] = i;
                    humanPos[1] = j;
                    humanPos[2] = 0;
                }
            }
        }
        
        while(time < TIME_LIMIT) {
            time++;

            humanPos = move(board, humanPos, dx, dy);
            dogPos = move(board, dogPos, dx, dy);

            if (humanPos[0] == dogPos[0] && humanPos[1] == dogPos[1]) {
                return time;
            }
        }
        return answer;
    }
    
    public static int[] move(int[][] board, int[] currentPos, int[] dx, int[] dy) {
        int nx = currentPos[0] + dx[currentPos[2]];
        int ny = currentPos[1] + dy[currentPos[2]];
        if(invalid(nx, ny, board)) { // 새로운 좌표를 갈 수 없다면
            currentPos[2] = (currentPos[2] + 1) % 4; 
            return currentPos; // 방향을 변환, 위치는 그대로하여 반환
        }
        return new int[]{nx, ny, currentPos[2]}; // 새로운 좌표에 방향은 그대로 하여 반환
    }
    
    public static boolean invalid(int nx, int ny, int[][] board) {
        if(nx == board.length || nx == -1 || ny == board.length || ny == -1 || board[nx][ny] == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
