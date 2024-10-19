package backtracking;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2661 {

    static int N;
    static int start =1;
    static int end = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());

        backtracking("");
    }

    public static void backtracking(String str){
        if(str.length()==N){
            System.out.println(str);
            System.exit(0);
        }
        // 현재 문자열의 길이가 N에 도달하면 해당 수열을 출력한다.
        // 좋은 수열을 찾으면 바로 프로그램 종료
        
        for(int i=start;i<=end;i++){
            if(isGood(str+i)){
                backtracking(str+i);
            }
        }
        // 1,2,3을 각각 순서대로 수열에 추가해서 새로운 수열을 만든다.
        // 이때 새로 만든 수열이 좋은 수열인지 확인하기 위해 isGood 메소드를 사용하며
        // 좋은 수열이라면 그 수열을 이어서 다시 백트래킹 한다.
    }

    public static boolean isGood(String str){
        int len = str.length()/2; 
        // 비교해야 할 최대 수열의 부분 길이 설정
        // 예를들어 수열의 길이가 6이라면 두 부분으로 나누면 최대 길이는 3
        // 또 다른 예로는 str 이 1212 라면 비교할 부분의 최대 길이는 2로 12 와 12를 비교하게 된다.
    

        for(int i=1;i<=len; i++){ 
            //i는 비교할 부분 수열의 길이로 1부터 시작해 최대 len까지 비교한다.
            // 즉, 수열이 1212라면 부분 문자열의 길이 i =1 과 i=2를 차례로 비교한다.

            if(str.substring(str.length()-i).equals(str.substring(str.length() -2 * i , str.length() - i))){
                return false;
            }

            // substring 메소드는 수열 뒷 부분에 있는 2개의 부분 문자열을 추출하기에 비교하기 위해 사용
            // 예를들어, str이 1212, i = 1이라고 한다면 str.lenght는 4가 된다. 
            // 이때 str.substring(4 - 1) 즉 3번째 인덱스인 2를 반환한다.

            // str.substring(str.length() - 2 * i, str.length() - i) 에서는 수열의 끝에서 두번째 부분을 가져온다.
            // 즉, 시작 인덱스부터 마지막 인덱스 직전까지의 부분 문자열을 반환한다.
            // str = 1212 , i=1일 때 str.substring(4-2*1, 4-1)가 되므로 시작 인덱스는 2가 되고 끝 인덱스는 3이다.
            // 따라서 str.substring(2,3)이 된다.
            // 2번 인덱스부터 3번 인덱스 직전까지의 문자열을 추출하므로 2번 인덱스 1이 반환된다
            // i=2일 때 str.substring(4 -2*2, 4-2)는 12를 반환한다.
            // 이렇게 두 부분을 비교해서 같으면 false를 반환해 좋은 수열이 아님을 표시한다.
        }
        return true;
    }
    
}
