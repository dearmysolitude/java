package algorithm.etc.warbattle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS {
    static int N; // 가로
    static int M; // 세로
    static int currentX;
    static int currentY;
    static int count = 0;
    
    static int white = 0;
    static int black = 0;
    static char[][] board;
    static boolean[][] visit;
    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 가로 
        M = Integer.parseInt(st.nextToken()); // 세로
        
        board = new char[M][N];
        visit = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                char ch = str.charAt(j);
                board[i][j]= ch;
            }
        }

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!visit[i][j]) {
                    char color = board[i][j];
                    count = 0;
                    
                    DFS(j, i, color);
                    
                    if(color == 'W') {
                        white += (count * count);
                    } else {
                        black += (count * count);
                    }
                }
            }
        }
        
        System.out.println(white + " " + black);
    }
    
    static void DFS(int x, int y, char color) {
        visit[y][x] = true;
        count += 1;
        
        for(int i = 0; i < 4; i++) {
            currentY = y + dy[i];
            currentX = x + dx[i];
            
            if(valid() && board[currentY][currentX] == color && !visit[currentY][currentX]) {
                DFS(currentX, currentY, color);
            }
        }
    }
    static boolean valid() {
        return currentX >= 0 && currentY >= 0 && currentY < M && currentX < N;
    }
}