import java.io.*;
import java.util.*;

public class PrefixEvaluationandConversion {
  
  public static int eval(int v1, int v2, char op) {
      switch(op) {
          case '-':
            return v1 - v2;
          case '+':
            return v1 + v2;
          case '*':
            return v1 * v2;
          default:
            return v1/v2; 
      }
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<String> post = new Stack<>();
    Stack<String> in = new Stack<>();
    Stack<Integer> res = new Stack<>();
    for(int i = exp.length() - 1; i >= 0; --i) {
        if(exp.charAt(i) == '+' || exp.charAt(i) == '-' || exp.charAt(i) == '/' || exp.charAt(i) == '*') {
            post.push(post.pop() + post.pop() + exp.charAt(i));
            in.push("(" + in.pop() + exp.charAt(i) + in.pop() + ")");
            res.push(eval(res.pop(), res.pop(), exp.charAt(i)));
        } else {
            post.push("" + exp.charAt(i));
            in.push("" + exp.charAt(i));
            res.push(exp.charAt(i) - '0');
        }
    }
    System.out.println(res.peek());
    System.out.println(in.peek());
    System.out.println(post.peek());
 }
}