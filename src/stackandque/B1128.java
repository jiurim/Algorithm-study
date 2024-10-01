package stackandque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1128{
    public static void main(String[] args) throws IOException{
    
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        
        Queue<Integer> queue = new LinkedList<>();

        LinkedList<Integer> linkedList = new LinkedList<>();
        
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        
        while (!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }
            linkedList.add(queue.poll());
        }
        
        System.out.print("<");
        for (int i = 0; i < linkedList.size(); i++) {
            if (i == linkedList.size() - 1) {
                System.out.print(linkedList.get(i));
            } else {
                System.out.print(linkedList.get(i) + ", ");
            }
        }
        System.out.print(">");
    }
}
