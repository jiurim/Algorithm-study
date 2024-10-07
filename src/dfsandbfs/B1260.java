package dfsandbfs;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B1260 {

    static int N;
    static int M;
    static int [][] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringtokenizer = new StringTokenizer(bufferedReader.readLine());
        
        N = Integer.parseInt(stringtokenizer.nextToken());
        M = Integer.parseInt(stringtokenizer.nextToken());
        int V = Integer.parseInt(stringtokenizer.nextToken());

        graph = new int[N+1][N+1]; // +1은 정점이 1부터 시작하니깐

        for(int i=0;i<M;i++){ //M 만큼 간선 입력
            stringtokenizer = new StringTokenizer(bufferedReader.readLine());

            int trunk1 = Integer.parseInt(stringtokenizer.nextToken()); //간선이 1 2 일 때 1 저장
            int trunk2 = Integer.parseInt(stringtokenizer.nextToken()); //간선이 1 2 일 때 2 저장

            graph[trunk1][trunk2] =1; // 간선 추가
            graph[trunk2][trunk1] =1; // 양방향이므로 간선 추가
        }

        dfs(V);
        bfs(V);

    }

    public static void dfs(int start ){
        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder(); //경로 저장
        
        int [] visited = new int[N+1]; //0과 1로 방문 여부 표시

        stack.add(start); //시작 정점 스택에 추가

        visited[start] = 1; //시작 정점 방문 표시
        sb.append(start).append(" "); // 경로에 추가 즉, 방문한 정점들의 순서 기록

        while(!stack.isEmpty()){
            int index = stack.pop(); // 스택에서 하나 꺼냄
            
            for (int neighbor = 1; neighbor <= N; neighbor++) {
                if (graph[index][neighbor] == 1 && visited[neighbor] == 0) { // 인접하고 미방문 노드라면
                    visited[neighbor] = 1; // 방문했다고 표시
                    stack.push(index); // 현재 인덱스를 다시 stack push
                    stack.push(neighbor); // 새로운 인접 노드를 스택에 넣음
                    sb.append(neighbor).append(" "); // 경로에 추가
                    break; // 깊이 우선이므로, 인접 노드를 하나만 방문 후 반복 종료
                }
            }
        }
        System.out.println(sb.toString().trim());
    }

    public static void bfs(int start){
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        int [] visited = new int[N+1]; //0과 1로 방문 여부 표시

        queue.add(start);

        visited[start] = 1; //시작 정점 방문 표시
        sb.append(start).append(" "); // 경로에 추가 즉, 방문한 정점들의 순서 기록

        while(!queue.isEmpty()){
            int current = queue.poll(); // 큐에서 하나 꺼냄

            for (int neighbor = 1; neighbor <= N; neighbor++) {
                if (graph[current][neighbor] == 1 && visited[neighbor] == 0) { // 인접하고 미방문 노드라면
                    queue.offer(neighbor); // 큐에 추가
                    visited[neighbor] = 1; // 방문했다고 표시
                    sb.append(neighbor).append(" "); // 경로에 추가
                }
            }
        }
        System.out.println(sb.toString().trim()); // 결과 출력
    }
}
