import java.io.*;
import java.util.*;

public class LastIndex {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; ++i) a[i] = sc.nextInt();
        int x = sc.nextInt();
        System.out.println(lastIndex(a, a.length-1, x));
    }

    public static int lastIndex(int[] arr, int idx, int x){
        if(idx < 0) return -1;
        if(arr[idx] == x) return idx;
        return lastIndex(arr, idx - 1, x);
    }

}