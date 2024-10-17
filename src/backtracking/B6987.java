package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B6987 {

    static int[][] team; // 팀별 승, 무, 패 기록
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        StringBuilder stringBuilder = new StringBuilder();

        team = new int[6][3];

        for (int i = 0; i < 4; i++) { // 테스트 케이스가 4개
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

            for (int j = 0; j < 6; j++) {
                for (int a = 0; a < 3; a++) {
                    if (stringTokenizer.hasMoreTokens()) {
                        team[j][a] = Integer.parseInt(stringTokenizer.nextToken());
                    }
                }
            }

            answer = 0;

            // 각 팀의 경기 수 체크
            boolean valid = true;
            for (int j = 0; j < 6; j++) {
                if (team[j][0] + team[j][1] + team[j][2] != 5) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                backtracking(0, 1); // 백트래킹 시작
            }

            // 결과 저장
            stringBuilder.append(answer > 0 ? "1 " : "0 ");
        }

        // 결과 출력
        System.out.print(stringBuilder.toString().trim()); // StringBuilder의 내용을 출력
    }

    static void backtracking(int current, int rival) {
        // 15경기가 진행되면 가능한 경우의 수 증가
        if (answer == 1) // 해당 결과가 올바른 것일 때 재귀 종료!
            return;

        // F국가까지 올바르게 경기가 진행되었을 때
        if (current == 5) {
            answer = 1;
            return;
        }

        // 현재 가능한 팀 쌍 탐색
        if (rival == 6) { // rival이 6이 되면 다음 팀으로 넘어감
            backtracking(current + 1, current + 2);
            return;
        }

        // 현재 팀 승, 상대팀 패
        if (team[current][0] > 0 && team[rival][2] > 0) {
            team[current][0]--;
            team[rival][2]--;
            backtracking(current, rival + 1); // 다음 팀으로 이동
            team[current][0]++;
            team[rival][2]++;
        }

        // 무승부
        if (team[current][1] > 0 && team[rival][1] > 0) {
            team[current][1]--;
            team[rival][1]--;
            backtracking(current, rival + 1); // 다음 팀으로 이동
            team[current][1]++;
            team[rival][1]++;
        }

        // 현재 팀 패, 상대팀 승
        if (team[current][2] > 0 && team[rival][0] > 0) {
            team[current][2]--;
            team[rival][0]--;
            backtracking(current, rival + 1); // 다음 팀으로 이동
            team[current][2]++;
            team[rival][0]++;
        }
    }
}
