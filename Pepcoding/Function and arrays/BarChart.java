import java.io.*;
import java.util.*;

public class BarChart{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a[] = new int[n];
    for(int i = 0; i < n; ++i) {
        a[i] = sc.nextInt();
    }
    int max = Integer.MIN_VALUE;
    for(int i = 0; i < n; ++i) {
        max = Math.max(max, a[i]);
    }
    int m = max;
    for(int i = 0; i < m; ++i) {    
        for(int j = 0; j < n; ++j) {
            if(a[j] >= max) {
                System.out.print("*\t");
            } else {
                System.out.print("\t");
            }
        }
        max --;
        System.out.println();
    }
 }

}