import java.io.*;
import java.util.*;

public class SlidingWindowMaximum {
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    // code
    int nge[] = new int[n];
    Stack<Integer> st = new Stack<>();
    nge[n-1] = n;
    st.push(n-1);
    for(int i = n-2; i >= 0; --i) {
       while(!st.isEmpty() && a[st.peek()] <= a[i]) st.pop();
       if(st.isEmpty()) nge[i] = n;
       else nge[i] = st.peek();
       st.push(i); 
    }
   //  for(int i = 0; i < n; ++i) System.out.println(nge[i]);
    int mi = 0;
    for(int i = 0; i <= n - k; ++i) {
       if(mi < i) {
          mi = i;
       }
       while(nge[mi] < i + k) mi = nge[mi];
       System.out.println(a[mi]);
    }
 }
}