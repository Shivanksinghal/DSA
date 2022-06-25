import java.io.*;
import java.util.*;

public class LargestAreaHistogram {
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    // code
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    int left[] = new int[n];
    int right[] = new int[n];
    left[0] = -1;
    right[n-1] = n;
    s1.push(0);
    s2.push(n-1);
    for(int i = 1; i < n; ++i) {
       while(!s1.isEmpty() && a[s1.peek()] >= a[i]) {
          s1.pop();
       }
       if(s1.isEmpty()) {
          left[i] = -1;
       } else {
          left[i] = s1.peek();
       }
       s1.push(i);

       while(!s2.isEmpty() && a[s2.peek()] >= a[n - i - 1]) {
          s2.pop();
       }
       if(s2.isEmpty()) {
          right[n - i - 1] = n;
       } else {
          right[n - i - 1] = s2.peek();
       }
       s2.push(n-i-1);
    }
       
    int res = Integer.MIN_VALUE;
    for(int i = 0; i < n; ++i) {
      //  System.out.println(left[i] + " " + right[i]);
       res = Math.max(res, (right[i] - left[i] - 1) * a[i]);
    } 
    System.out.println(res);
}
}