import java.io.*;
import java.util.*;

public class ExitPointOfAMatrix {

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
        int i = 0, j = 0;
        int dir = 0;
        while(i < n && j < m) {
            if(a[i][j] == 1) {
                dir = (dir + 1) % 4;
            }
            if(dir == 0) {
                j++;
            } else if(dir == 1) {
                i++;
            } else if(dir == 2) {
                j--;
            } else {
                i--;
            }
        }
        if(dir == 0) {
            j--;
        } else if(dir == 1) {
            i--;
        } else if(dir == 2) {
            j++;
        } else {
            i++;
        }
        System.out.println(i + "\n" + j);
    }

}