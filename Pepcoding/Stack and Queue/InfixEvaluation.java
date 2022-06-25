import java.io.*;
import java.util.*;

public class InfixEvaluation {
  
public static boolean isOperator(char ch) {
    return ch == '(' || ch == ')' || ch == '+' || ch == '*' || ch == '-' || ch == '/';
}

public static int priority(char ch) {
    if(ch == '+' || ch == '-') return 0;
    else if(ch == '*' || ch == '/') return 1;
    return 2;
}

public static void solve(Stack<Character> operators, Stack<Integer> operands) {
    char op = operators.pop();
    int num1 = operands.pop();
    int num2 = operands.pop();
    if(op == '+') operands.push(num2+num1);
    else if (op == '-') operands.push(num2-num1);
    else if (op == '*') operands.push(num2*num1);
    else operands.push(num2/num1);
}

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Character> operators = new Stack<>();
    Stack<Integer> operands = new Stack<>();

    for(int i = 0; i < exp.length(); ++i) {
        // System.out.println(operands.size() > 0 ? operands.peek(): "-");
        if(exp.charAt(i) == ' ') continue;
        if(isOperator(exp.charAt(i))) {
            if(exp.charAt(i) == '(') {
                operators.push('(');
            }
            else {
                while(!operators.isEmpty() && operators.peek() != '(' && (priority(operators.peek()) >= priority(exp.charAt(i)) || exp.charAt(i) == ')')) {
                    solve(operators, operands); 
                }
                if(exp.charAt(i) == ')') operators.pop();
                else operators.push(exp.charAt(i));
            }
        } else {
            operands.push(Integer.parseInt("" + exp.charAt(i)));
        }
    }
    while(operators.size() > 0) {
        solve(operators, operands);
    }
    System.out.println(operands.peek());
 }
}