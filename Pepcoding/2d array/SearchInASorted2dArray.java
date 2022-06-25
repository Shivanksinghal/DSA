import java.io.*;
import java.util.*;

public class SearchInASorted2dArray {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                a[i][j] = sc.nextInt();
            }
        }
        int x = sc.nextInt();

        int i = 0, j = n-1;
        while(i < n && j >= 0) {
            if(a[i][j] == x) {
                System.out.println(i);
                System.out.println(j);
                return;
            } else if(a[i][j] < x) {
                i++;
            } else {
                j --;
            }
        }
        System.out.println("Not Found");
    }

}