package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1182 {
    static int N,S;
    static int[] array;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        S = Integer.parseInt(stringTokenizer.nextToken());

        array = new int[N];
        count=0;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");

        for(int i=0;i<N;i++){
        
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        
        backtrack(0,0,true);

        System.out.println(count);

    }

    static void backtrack(int depth,int sum, boolean emptySet){
        if(depth==N){
            if(sum==S && !emptySet){
                count++;
            }
            return;
        }

        backtrack(depth+1, sum, emptySet);
        backtrack(depth+1, sum+=array[depth], false);
    }
    
}
