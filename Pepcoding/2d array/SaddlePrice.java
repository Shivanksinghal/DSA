import java.io.*;
import java.util.*;

public class SaddlePrice {

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
        for(int i = 0; i < n; ++i) {
            int min = 0;
            for(int j = 1; j < n; ++j) {
                if(a[i][j] < a[i][min]) min = j;
            }
            int max = 0;
            for(int j = 1; j < n; ++j) {
                if(a[j][min] > a[max][min]) max = j;
            }
            if(max == i) {
                System.out.println(a[max][min]);
                return;
            }
        }
        System.out.println("Invalid input");
    }

}