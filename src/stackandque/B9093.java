package stackandque;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class B9093{
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testTime = Integer.parseInt(bufferedReader.readLine());

        StringBuilder result = new StringBuilder();

        while (testTime-- > 0) {
            Stack<Character> stack = new Stack<>();
            String sentence = bufferedReader.readLine();

            for (int i = 0; i < sentence.length(); i++) {
                char ch = sentence.charAt(i);

                if (ch != ' ') {  
                    stack.push(ch);
                } else { 
                    while (!stack.isEmpty()) {
                        result.append(stack.pop());
                    }
                    result.append(" "); 
                }
            }

            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }
            result.append("\n");
        }

        System.out.print(result.toString());
    }
}