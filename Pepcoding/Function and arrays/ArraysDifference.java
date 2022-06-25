import java.io.*;
import java.util.*;

public class ArraysDifference{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner sc = new Scanner(System.in);
    int n1 = sc.nextInt();
    int a[] = new int[n1];
    for(int i = 0; i < n1; ++i) {
        a[i] = sc.nextInt();
    }

    int n2 = sc.nextInt();
    int b[] = new int[n2];
    for(int i = 0; i < n2; ++i) {
        b[i] = sc.nextInt();
    }
    
    int n3 = n2;
    int res[] = new int[n3];
    
    int i = n2-1, j = n1-1, k = n3 - 1;
    int carry = 0;
    while(i >= 0 || j >= 0 || carry > 0) {
        int val = 0;
        if(i >= 0 && j >= 0 && b[i] - a[j] - carry < 0) {
            val = b[i] - a[j] - carry + 10;
            carry = 1;
        } else {
            val = ((i >= 0) ? b[i] : 0) - ((j >= 0) ? a[j] : 0) - carry;
            carry = 0;
        }
        res[k--] = val % 10;
        i--;
        j--;
    }
    if(res[0] != 0) System.out.println(res[0]);
    for(int x = 1; x < n3; ++x) {
        System.out.println(res[x]);
    }
 }

}