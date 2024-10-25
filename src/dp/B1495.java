package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1495 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");

        int N = Integer.parseInt(stringTokenizer.nextToken()); //곡 수
        int S = Integer.parseInt(stringTokenizer.nextToken()); // 시작볼륨
        int M = Integer.parseInt(stringTokenizer.nextToken()); // 최대볼륨

        int vol[] = new int[N];

        StringTokenizer sttokenizer = new StringTokenizer(bufferedReader.readLine()," ");

        for(int i=0;i<N;i++){
            vol[i] = Integer.parseInt(sttokenizer.nextToken());
        }

        boolean dp [][] = new boolean[N+1][M+1];

        dp[0][S] = true;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j]) { // 이전 곡에서 볼륨이 j였을 경우
                    int plus = j + vol[i - 1];
                    int minus = j - vol[i - 1];

                    if (plus <= M) dp[i][plus] = true; // 볼륨을 올릴 수 있는 경우
                    if (minus >= 0) dp[i][minus] = true; // 볼륨을 내릴 수 있는 경우
                }
            }
        }
        
        int answer = -1;
        for (int i = M; i >= 0; i--) {
            if (dp[N][i]) {
                answer = i;
                break;
            }
        }
        System.out.print(answer);
    }
}