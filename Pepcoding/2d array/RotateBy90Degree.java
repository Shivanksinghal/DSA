import java.io.*;
import java.util.*;

public class RotateBy90Degree {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                a[i][j]=sc.nextInt();
            }
        }
        for(int i = 0; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
                int temp = a[i][j]; 
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n/2; ++j) {
                int temp = a[i][j];
                a[i][j]=a[i][n-j-1];
                a[i][n-j-1] = temp;
            }
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