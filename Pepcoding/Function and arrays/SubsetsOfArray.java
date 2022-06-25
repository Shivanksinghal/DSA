import java.io.*;
import java.util.*;

public class SubsetsOfArray{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a[] = new int[n];
    for(int i = 0; i < n; ++i) {
        a[i] = sc.nextInt();
    }
    for(int i = 0; i < 1<<n; ++i) {
        for(int j = 0; j < n; ++j) {
            int b = i & (1<<n-j-1);
            if(b > 0) {
                System.out.print(a[j] + "\t");
            } else {
                System.out.print("-\t");
            }
        }
        System.out.println();
    }
 }

}