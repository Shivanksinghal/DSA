import java.io.*;
import java.util.*;

public class RotateAnArray{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + " ");
    }
    System.out.println(sb);
  }

  static int _gcd(int a, int b) {
    if(b == 0) return a;
    return _gcd(b, a % b);
  }
  public static void rotate(int[] a, int k){
    // write your code here
    int n = a.length;
    k %= n;
    k += n;
    k %= n;
    int gcd = _gcd(n, k);
    for(int i = 0; i < gcd; ++i) {
      int s = i+k;
      int temp = a[i];
      while(s!= i) {
        int t = a[s];
        a[s] = temp;
        temp = t;
        s = (s+k) % n;
      }
      a[i] = temp; 
    }
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    rotate(a, k);
    display(a);
 }

}