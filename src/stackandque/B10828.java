package stackandque;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class B10828 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String m = st.nextToken();
            
            if(m.equals("push")){
                int stacknum = Integer.parseInt(st.nextToken());
                stack.push(stacknum);
            } else if(m.equals("pop")){
                if(stack.isEmpty()){
                    System.out.println("-1");
                } else {
                    System.out.println(stack.pop());
                }
            } else if(m.equals("size")){
                System.out.println(stack.size());
            }else if(m.equals("empty")){
                if(stack.isEmpty()){
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }
            }else if(m.equals("top")){
                if(stack.isEmpty()){
                    System.out.println("-1");
                }else {
                    System.out.println(stack.peek());
                }
            }
        }
    }
}
