package stackandque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class P다리를지나는트럭 {
    public static void main(String[] args) throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<Integer>();

        int move_time = 0;
        int current_weight = 0;
        int currentTruckIndex = 0;

        int bridge_length = Integer.parseInt(bufferedReader.readLine());
        int weight = Integer.parseInt(bufferedReader.readLine());

        String truck = bufferedReader.readLine();
        truck = truck.replaceAll("\\[", "").replaceAll("\\]", "");  
        String[] tokens = truck.split(",");


         // 트럭이 다리를 건너는 로직
        while (currentTruckIndex < tokens.length) {
            // 다리 길이만큼 트럭이 다 찼을 경우
            if (queue.size() == bridge_length) {
                // 다리에서 가장 앞의 트럭을 제거하고 현재 무게에서 빼기
                current_weight -= queue.poll();
            }

            // 다음 트럭의 무게
            int truckWeight = Integer.parseInt(tokens[currentTruckIndex].trim());

            // 현재 무게와 다음 트럭의 무게 합이 weight 이하이고,
            // 다리 위의 트럭 수가 bridge_length보다 적을 경우
            if (current_weight + truckWeight <= weight) {
                queue.add(truckWeight); // 큐에 트럭 추가
                current_weight += truckWeight; // 현재 무게 업데이트
                currentTruckIndex++; // 다음 트럭으로 이동
            } else {
                // 무게를 초과하면 다리가 비워질 때까지 시간 증가
                queue.add(0); // 다리에서 트럭이 지나간 것으로 처리
            }

            move_time++; // 시간 증가
        }

        // 다리에서 마지막 트럭이 지나가는 시간을 더한다.
        move_time += bridge_length;

        System.out.println(move_time); 
    }
}