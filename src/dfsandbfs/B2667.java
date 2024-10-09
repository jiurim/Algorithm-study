package dfsandbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class B2667 {
    static int N;
    static int [][] houseMap;
    static boolean [][] visited; // 방문 여부를 체크 할 배열
    static int [] dx = {-1,1,0,0}; // x축
    static int [] dy = {0,0,-1,1}; //y축

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine()); // 첫 줄에서 N을 읽음

        houseMap = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String line = bufferedReader.readLine(); // 각 줄을 읽음
            for(int j = 0; j < N; j++) {
                houseMap[i][j] = line.charAt(j) - '0'; // 문자 '0'과 '1'을 정수로 변환
            }
        }

        ArrayList<Integer> houseCnt = new ArrayList<>(); 

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(houseMap[i][j] == 1 && !visited[i][j]) { // 방문하지 않은 집이면
                    int houseCount = dfs(i, j);
                    houseCnt.add(houseCount);
                }
            }
        }

        Collections.sort(houseCnt);
        System.out.println(houseCnt.size());

        for(int i = 0; i < houseCnt.size(); i++) {
            System.out.println(houseCnt.get(i));
        }
    }

    public static int dfs(int startX, int startY) {
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{startX, startY}); 
        visited[startX][startY] = true;

        int houseCount = 1;

        while(!stack.isEmpty()) {
            int [] currentCoor = stack.pop(); // 현재 탐색하고 있는 집의 좌표를 스택에서 꺼냄

            int x = currentCoor[0];
            int y = currentCoor[1];

            for(int a = 0; a < 4; a++) { // 상하좌우 네 방향 탐색
                int newX = x + dx[a];
                int newY = y + dy[a];

                if (newX >= 0 && newX < N && newY >= 0 && newY < N && houseMap[newX][newY] == 1 && !visited[newX][newY]) {
                    visited[newX][newY] = true; // 방문 표시
                    stack.push(new int[]{newX, newY});
                    houseCount++;
                }
            }
        }

        return houseCount;
    }
}
