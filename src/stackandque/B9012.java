package stackandque;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class B9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());

        StringBuilder result = new StringBuilder(); // 결과를 저장

        for (int i = 0; i < T; i++) {
            String vpc = bufferedReader.readLine();

            Stack<Character> stack = new Stack<>(); // 각 테스트 케이스마다 새로운 스택 생성
            boolean isTrue = true;

            for (int j = 0; j < vpc.length(); j++) {
                char currentCh = vpc.charAt(j);

                if (currentCh == '(') {
                    stack.push(currentCh);  // '('는 스택에 추가
                } else if (currentCh == ')') {
                    if (!stack.isEmpty()) {
                        stack.pop();  // 스택에 '('가 있으면 pop
                    } else {
                        isTrue= false;  // 스택이 비어 있는데 ')'가 나오면 불균형
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                isTrue = false;
            }

            // 결과를 StringBuilder에 추가
            if (isTrue) {
                result.append("YES\n");
            } else {
                result.append("NO\n");
            }
        }
        System.out.print(result.toString());
    }
}




