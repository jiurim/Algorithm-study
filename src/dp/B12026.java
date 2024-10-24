package dp;

import java.io.*;
import java.util.Arrays;

public class B12026 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] dp = new int[N];
        char[] block = bufferedReader.readLine().toCharArray();

        final int MAX_VALUE = Integer.MAX_VALUE; // MAX_VALUE 상수 정의
        Arrays.fill(dp, MAX_VALUE); // 애초에 도달할 수 없다고 가정하고 최대값으로 초기화
        dp[0] = 0; // 첫 번째는 무조건 0부터 시작

        for (int i = 0; i < N; i++) {
            if (dp[i] == MAX_VALUE) continue; // 현재 블록에 도달할 수 없는 경우 넘어감

            char currentBlock = block[i];
            char nextBlock = getNextBlock(currentBlock); // 다음으로 이동할 수 있는 블록을 계산

            for (int j = i + 1; j < N; j++) {
                if (block[j] == nextBlock) { // 다음 올바른 블록일 때만 이동 가능
                    int energy = (j - i) * (j - i); // 이동 거리는 거리의 제곱
                    dp[j] = Math.min(dp[j], dp[i] + energy); // 최소 에너지로 갱신
                }
            }
        }

        if (dp[N - 1] == MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N - 1]);
        }
    }

    static char getNextBlock(char currentBlock) {
        if (currentBlock == 'B') return 'O';
        if (currentBlock == 'O') return 'J';
        if (currentBlock == 'J') return 'B';
        return ' '; 
    }
}
