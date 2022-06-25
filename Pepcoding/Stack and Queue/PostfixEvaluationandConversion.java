import java.io.*;
import java.util.*;

public class PostfixEvaluationandConversion {

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<String> in = new Stack<>();
    Stack<String> res = new Stack<>();
    Stack<Integer> ans = new Stack<>();
    for(int i = 0; i < exp.length(); ++i) {
        if(exp.charAt(i) == '+' || exp.charAt(i) == '-' || exp.charAt(i) == '/' || exp.charAt(i) == '*') {
            String s2 = res.pop();
            String s1 = res.pop();
            res.push(exp.charAt(i) + s1 + s2);
            s2 = in.pop();
            s1 = in.pop();
            in.push("(" + s1 + exp.charAt(i) + s2 + ")");
            int v2 = ans.pop();
            int v1 = ans.pop();
            switch(exp.charAt(i)) {
                case '+':
                    ans.push(v1 + v2);
                    break;
                case '*':
                    ans.push(v1*v2);
                    break;
                case '/':
                    ans.push(v1/v2);
                    break;
                case '-':
                    ans.push(v1-v2);
                    break;

            }
        } else {
            res.push(""+exp.charAt(i));
            in.push(""+exp.charAt(i));
            ans.push(exp.charAt(i) - '0');
        }
    }
    System.out.println(ans.peek());
    System.out.println(in.peek());
    System.out.println(res.peek());
 }
}