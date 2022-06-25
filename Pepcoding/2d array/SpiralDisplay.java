import java.io.*;
import java.util.*;

public class SpiralDisplay {

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
        int minRow = 0, minCol = 0, maxRow = n-1, maxCol = m-1;
        int cnt = m*n;
        while(cnt > 0) {
            for(int j = minRow; j <= maxRow && cnt > 0; ++ j) {
                System.out.println(a[j][minCol]);
                cnt --;
            }
            minCol ++;
            for(int j = minCol; j <= maxCol && cnt > 0; ++ j) {
                System.out.println(a[maxRow][j]);
                cnt --;
            }
            maxRow --;
            for(int j = maxRow; j >= minRow && cnt > 0; -- j) {
                System.out.println(a[j][maxCol]);
                cnt --;
            }
            maxCol --;
            for(int j = maxCol; j >= minCol && cnt > 0; -- j) {
                System.out.println(a[minRow][j]);
                cnt --;
            }
            minRow ++;
        }
    }

}