package stackandque;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
public class B1966 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testTime = Integer.parseInt(bufferedReader.readLine());
        int[] results = new int[testTime];

        for (int i = 0; i < testTime; i++) {
            String[] caseInfo = bufferedReader.readLine().split(" ");
            int documentCnt = Integer.parseInt(caseInfo[0]);
            int targetIndex = Integer.parseInt(caseInfo[1]);
            String[] priorities = bufferedReader.readLine().split(" ");

            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a); // 내림차순 정렬

            // 큐에 문서와 중요도 저장
            for (int j = 0; j < documentCnt; j++) {
                int priority = Integer.parseInt(priorities[j]);
                queue.add(new int[]{j, priority});
                priorityQueue.add(priority); // 우선순위 큐에 중요도 추가
            }

            int cnt = 0; // 인쇄 순서 카운트

            // 인쇄 순서 계산
            while (!queue.isEmpty()) {
                int[] now = queue.poll(); // 현재 문서 꺼내기

                // 현재 문서의 중요도가 가장 높은지 확인
                if (now[1] == priorityQueue.peek()) {
                    cnt++; // 인쇄 순서 증가
                    priorityQueue.poll(); // 인쇄된 문서의 중요도 제거
                    
                    if (now[0] == targetIndex) { // 궁금한 문서가 인쇄되었을 경우
                        results[i] = cnt; // 순서 저장
                        break; // 문서가 인쇄되었으므로 반복 종료
                    }
                } else {
                    queue.add(now); // 현재 문서를 큐의 뒤로 보냄
                }
            }
        }

        // 결과 출력
        for (int result : results) {
            System.out.println(result);
        }

        bufferedReader.close();
    }
}