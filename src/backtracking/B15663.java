package backtracking;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class B15663 {

    static int N,M;
    static int[] sequence;
    static int[] inputNum;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");


        if(stringTokenizer.countTokens()==2){
            int first = Integer.parseInt(stringTokenizer.nextToken());
            int second = Integer.parseInt(stringTokenizer.nextToken());

            if(1<=first && first<=8 && second>=1 && first>=second){
                N=first;
                M=second;
            }else {
                System.out.println("입력 조건에 부합하지 않습니다.");
            }
        }else {
            System.out.println("입력조건에 부합하지 않습니다.");
        }

        inputNum = new int[N];
        sequence = new int[M];
        visited = new boolean[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");

        for(int i=0; i<N; i++){
            inputNum[i]=Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(inputNum);

        backtrack(0);
    }

    //백트래킹
    static void backtrack(int depth){
        if(depth==M){
            for(int i=0;i<M;i++){
                System.out.print(sequence[i] + " ");
            }

            System.out.println();
            return;
        }


        //중복 수열 방지
        int lastUsed = -1; //lastUsed는 현재 깊이에서 아무 숫자도 선택하지 않았음을 의미함
        for(int i=0;i<N;i++){
            if (!visited[i] && inputNum[i]!=lastUsed) { //중복된 수가 아니라면
                visited[i] = true; // 방문을 기록하고
                sequence[depth] = inputNum[i]; // 숫자를 배열에 저장
                lastUsed = inputNum[i]; // 만약 i가 3이라면 lastUsed가 3이 됨
                backtrack(depth + 1); // 다음 깊이로 재귀호출
                visited[i] = false; // 백트래킹해서 돌아왔으니 방문 기록을 초기화 (이전 경로에서 사용했던 요소를 다시 사용할 수 있도록 초기화함)
            }
        }
    }
}
