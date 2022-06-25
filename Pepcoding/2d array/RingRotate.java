import java.io.*;
import java.util.*;

public class RingRotate {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int a[][] = new int[n][m];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                a[i][j] = sc.nextInt();
            }
        }
        int s = sc.nextInt(), r = sc.nextInt();
        int sz = 2*n+2*m-8*s+4;
        r = r % sz;
        if(r < 0) {
            r = r + sz;
        }
        int arr[] = new int[sz];
        int k = 0;
        for(int i = s-1; i < n-s+1; ++i) {
            arr[k++] = a[i][s-1];
        }
        for(int j = s; j < m - s + 1; ++j) {
            arr[k++] = a[n-s][j];
        }
        for(int i = n-s-1; i >= s-1; --i) {
            arr[k++] = a[i][m-s];
        }
        for(int j = m-s-1; j >= s; --j) {
            arr[k++] = a[s-1][j];
        }
        // rotate
        // for(int i = sz-1; i >= r; --i) {
        //     int temp = arr[i];
        //     arr[i] = arr[(i+r) % sz];
        //     arr[(i + r) % sz] = temp;
        // }
        int l = 0, rr = sz - r - 1;
        while(l < rr) {
            int temp = arr[l];
            arr[l] = arr[rr];
            arr[rr] = temp; 
            l ++;
            rr --;
        }
        l = sz - r;
        rr = sz - 1;
        while(l < rr) {
            int temp = arr[l];
            arr[l] = arr[rr];
            arr[rr] = temp; 
            l ++;
            rr --;
        }
        l = 0;
        rr = sz - 1;
        while(l < rr) {
            int temp = arr[l];
            arr[l] = arr[rr];
            arr[rr] = temp; 
            l ++;
            rr --;
        }
        
        k = 0;
        for(int i = s-1; i < n-s+1; ++i) {
            a[i][s-1] = arr[k++];
        }
        for(int j = s; j < m - s + 1; ++j) {
            a[n-s][j] = arr[k++];
        }
        for(int i = n-s-1; i >= s-1; --i) {
            a[i][m-s] = arr[k++];
        }
        for(int j = m - s-1; j >= s; --j) {
            a[s-1][j] = arr[k++];
        }
        display(a);
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}