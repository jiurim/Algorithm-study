package stackandque;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class P주식가격 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       
        String prices = bufferedReader.readLine();
        
        StringTokenizer stringTokenizer = new StringTokenizer(prices," ");

        int index = stringTokenizer.countTokens();

        int [] pricesArray = new int[index];

        for(int i=0;i<index;i++){
            pricesArray[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int [] answer = solution(pricesArray);

        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i]+" ");
        }   
    }

    public static int[] solution(int [] prices){
        int n = prices.length;
        int [] answer = new int[n];

        for(int i=0;i<n;i++){
            int time = 0;

            for(int j =i+1;j<n;j++){
                time++;
                if(prices[i]>prices[j]){
                    break;
                }
            }

            answer[i] = time;
        }
        return answer;
    }
    
}
