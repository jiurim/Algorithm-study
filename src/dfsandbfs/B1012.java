package dfsandbfs;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1012 {

    static int T,M,N,K;
    static int cnt;
    static int [][] cabbageField; //배추밭 2중배옆
    static boolean [][] visited; // 방문 여부를 체크 할 배열
    static int [] dx = {-1,1,0,0}; // x축
    static int [] dy = {0,0,-1,1}; //y축

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(bufferedReader.readLine());

        for(int t=0;t<T;t++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        
            M = Integer.parseInt(stringTokenizer.nextToken());
            N = Integer.parseInt(stringTokenizer.nextToken());
            K = Integer.parseInt(stringTokenizer.nextToken());

            cabbageField = new int[M][N];
            visited = new boolean[M][N];

            for(int i = 0; i < K; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                
                int X = Integer.parseInt(stringTokenizer.nextToken());
                int Y = Integer.parseInt(stringTokenizer.nextToken());

                cabbageField[X][Y] = 1;
            }

            int wormCnt = 0;

            for(int i = 0;i<M;i++){
                for(int j=0;j<N;j++){
                    if(cabbageField[i][j]==1 && !visited[i][j]){
                        dfs(i,j);
                        wormCnt++;
                    }
                }
            }

            System.out.println(wormCnt);
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true; // 현재 위치 방문 처리

        // 상하좌우 네 방향 탐색
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            // 새로운 좌표가 배추밭 범위 내에 있고, 배추가 있으며 방문하지 않았다면
            if (newX >= 0 && newX < M && newY >= 0 && newY < N && cabbageField[newX][newY] == 1 && !visited[newX][newY]) {
                dfs(newX, newY); // 재귀적으로 탐색
            }
        }
    }
}



    