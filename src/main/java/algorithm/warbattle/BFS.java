package algorithm.warbattle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
    static int N; // 가로
    static int M; // 세로
    static int count;
    static int white;
    static int black;

    static class Node {
        int x;
        int y;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    static Queue<Node> q = new LinkedList<>();
    static int dy[] = {-1, 1, 0, 0};
    static int dx[] = {0, 0, -1, 1};
    static boolean visited[][];
    static char board[][];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        visited = new boolean[M][N];
        board = new char[M][N];
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            
            for(int j = 0; j < N; j++) {
                char ch = temp.charAt(j);
                board[i][j] = ch;
            }
        }
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    if(board[i][j] == 'W') {
                        int count = BFS(i, j, 'W');
                        white += count * count;
                    } else {
                        int count = BFS(i, j, 'B');
                        black += count * count;
                    }
                }
            }
        }
        System.out.println(white + " " + black);
    }
    static int BFS(int y, int x, char ch) {
        q.offer(new Node(y, x)); // 큐 추가
        count = 1;
        visited[y][x] = true;
        
        while(!q.isEmpty()) {
            find(ch);
        }
        return count;
    }
    
    static void find(char ch) {
        Node now = q.poll(); // 꺼냄
        
        for(int i = 0; i < 4; i++) {
            int ny = now.y + dy[i];
            int nx = now.x + dx[i];
            
            if(valid(nx, ny) && board[ny][nx] == ch) {
                q.offer(new Node(ny, nx));
                visited[ny][nx] = true;
                count ++;
            }
        }
    }
    static boolean valid(int nx, int ny) {
        return ny >= 0 && nx >= 0 && ny < M && nx < N && !visited[ny][nx];
    }
}


