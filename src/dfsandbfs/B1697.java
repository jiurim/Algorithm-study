package dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697 {

    static int[] map = new int [100001];
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        if(N==K){
            System.out.println("0");
        }else {
            bfs(N);
        }

        bufferedReader.close();
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        map[start] = 1;
        int next;

        while(!queue.isEmpty()){
            int now = queue.poll(); // 큐에서 하나 꺼냄

            for (int i=0;i<3;i++) {
                if(i==0){
                    next=now-1;
                }else if(i==1){
                    next=now+1;
                }else {
                    next=now*2;
                }

                if (now == K) {
                    System.out.println(map[now]-1);
                    return;
                }

                if (next >= 0 && next < map.length && map[next] == 0) {
                    queue.add(next);
                    map[next] = map[now] + 1;
                }
            }
        }
    }
    
}
