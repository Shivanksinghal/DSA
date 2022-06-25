import java.io.*;
import java.util.*;

public class InfixConversion {

public static int prio(char ch) {
    if(ch == '+' || ch == '-') return 0;
    return 1;
}

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<String> pre = new Stack<>();
    Stack<String> post = new Stack<>();
    Stack<Character> op = new Stack<>();

    for(int i = 0; i < exp.length(); ++i) {
        if(exp.charAt(i) == '(') {
            op.push('(');
        } else if(exp.charAt(i) == '+' || exp.charAt(i) == '-' || exp.charAt(i) == '/' || exp.charAt(i) == '*') {
            while(!op.empty() && op.peek() != '(' && prio(op.peek()) >= prio(exp.charAt(i))) {
                char oper = op.pop();
                String v2 = pre.pop();
                String v1 = pre.pop();
                pre.push(oper + v1 + v2);
                v2 = post.pop();
                v1 = post.pop();
                post.push(v1 + v2 + oper);
            }
            op.push(exp.charAt(i));
        } else if(exp.charAt(i) == ')') {
            while(op.peek() != '(') {
                char oper = op.pop();
                String v2 = pre.pop();
                String v1 = pre.pop();
                pre.push(oper + v1 + v2);
                v2 = post.pop();
                v1 = post.pop();
                post.push(v1 + v2 + oper);
            }
            op.pop();
        } else {
            pre.push("" + exp.charAt(i));
            post.push("" + exp.charAt(i));
        }
    }
    while(op.size() > 0) {
        char oper = op.pop();
                String v2 = pre.pop();
                String v1 = pre.pop();
                pre.push(oper + v1 + v2);
                v2 = post.pop();
                v1 = post.pop();
                post.push(v1 + v2 + oper);
    }
    System.out.println(post.peek());
    System.out.println(pre.peek());
 }
}