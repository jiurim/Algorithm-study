package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15651 {

    static int N,M;
    static int[] sequence;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        sequence = new int[M];
        visited = new boolean[N+1];

        backtrack(0);
    }

    static void backtrack(int depth){
        if(depth==M){
            for(int i=0;i<M;i++){
                System.out.print(sequence[i]);
                System.out.print(" ");
            }

            System.out.println();
            return;
        }
        for(int i=1;i<=N;i++){
            if (!visited[i]) { 
                visited[i] = true; 
                sequence[depth] = i;
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }
}
