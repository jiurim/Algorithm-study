package dfsandbfs;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class B2178 {

    static int N,M;
    static int [][] map;
    static int [][] dist; // 방문 여부를 체크 할 배열
    static int [] dx = {-1,1,0,0}; // x축
    static int [] dy = {0,0,-1,1}; //y축

    public static void main(String[] args) throws IOException {
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

       StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String arr = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = arr.charAt(j) - '0'; // 미로 입력
            }
        }

        // BFS로 최단 경로 탐색 시작
        bfs(0, 0);

        // 도착 지점의 이동 칸 수 출력
        System.out.println(dist[N - 1][M - 1]);
    }

    public static void  bfs(int x,int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        dist[x][y]=1;

        while(!queue.isEmpty()){
            int [] current = queue.poll();
            int currentX =current[0];
            int currentY = current[1];

            for(int i =0; i<4;i++){ //상하좌우 4방향
                int nextX = currentX+dx[i];
                int nextY = currentY+dy[i];

                if(nextX>=0 && nextY>=0 && nextX<N && nextY<M && map[nextX][nextY]==1 && dist[nextX][nextY]==0){
                    dist[nextX][nextY] = dist[currentX][currentY]+1;
                    queue.offer(new int[]{nextX,nextY});
                }
            }
            
        }
    }

}
