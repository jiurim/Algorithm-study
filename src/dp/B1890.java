package dp;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class B1890 {
    static int N;
    static int[][] list;
    static long[][] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        list = new int[N][N];

        dp = new long[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");
            for(int j=0;j<N;j++){
                list[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        dp[0][0] = 1;

        jump();
    }

    static void jump(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(dp[i][j] == 0) continue;
                if(i == N-1 && j == N-1) {
                    break;
                }
                if(list[i][j]+i < N){
                    dp[list[i][j]+i][j] += dp[i][j];
                }
                if(list[i][j]+j < N){
                    dp[i][list[i][j]+j] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N-1][N-1]);
    }
}
