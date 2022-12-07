import java.io.*;
import java.util.*;

public class NextSmallerElementToTheRight {
    public static void display(int[] a) {
    StringBuilder sb = new StringBuilder();

    for (int val : a) {
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
  }

  public static int[] solve(int[] arr) {
  
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> res = new Stack<>();
    for(int i = arr.length - 1; i >= 0; i--) {
      while(!stack.isEmpty() && stack.peek() > arr[i]) {
        stack.pop();
      }
      if(stack.isEmpty()) {
        res.push(-1);
      } else {
        res.push(stack.peek());
      }
      stack.push(arr[i]);
    }
    int[] ans = new int[arr.length];
    for(int i = 0; i < arr.length; ++i) {
      ans[i] = res.pop();
    }
    return ans;
  }
}