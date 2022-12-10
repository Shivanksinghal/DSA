import java.io.*;
import java.util.*;

public class NextSmallerElementToTheLeft {
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
    int[] ans = new int[arr.length];
    for(int i = 0; i < arr.length; i++) {
      while(!stack.isEmpty() && stack.peek() > arr[i]) {
        stack.pop();
      }
      if(stack.isEmpty()) {
        ans[i] = -1;
      } else {
        ans[i] = stack.peek();
      }
      stack.push(arr[i]);
    }
    return ans;
  }
}