package backtracking;

import java.util.Arrays;

public class P입국심사 {

    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long left = 0;
        long right = (long)times[times.length-1]*n;

        while(left<=right){
            long mid = (left+right)/2;
            long sum = 0;

            for(int i=0; i<times.length;i++){
                sum += mid/times[i];
            }
            if(sum<n){
                left = mid + 1;
            }else {
                right = mid - 1;
                answer = mid; // 모두 검사받았으나, 더 최솟값이 있을 수 있다.
            }
        }  
        return answer;
    }
}
