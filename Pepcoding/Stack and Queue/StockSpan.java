import java.io.*;
import java.util.*;

public class StockSpan {
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] span = solve(a);
    display(span);
 }

  // static class Pair {
  //   int first, second;
  //   Pair(int first, int second) {
  //     this.first = first;
  //     this.second = second;
  //   }
  // }
 public static int[] solve(int[] arr){
   // solve
   Stack<Integer> st = new Stack<>();
   int res[] = new int[arr.length];
   res[0] = 1;
   st.push(0);
   for(int i = 1; i < arr.length; ++i) {
     while(!st.isEmpty() && arr[st.peek()] <= arr[i]) {
       st.pop();
     }
     if(st.isEmpty()) {
       res[i] = i + 1;
     } else {
       res[i] = i - st.peek();
     }
     st.push(i);
   }
   return res;
 }

}