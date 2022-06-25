import java.io.*;
import java.util.*;

public class CelebrityProblem {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);
    }

    public static boolean knows(int [][]arr, int i, int j) {
        return arr[i][j] == 1;
    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it''s index (not position), if there is not then print "none"
        int cel = 0;
        for(int i = 1; i < arr.length; ++i) {
            if(knows(arr, cel, i)) {
                cel = i;
            }
        }
        boolean flag = false;
        for(int i = 0; i < arr.length; ++i) {
            if(i != cel && (knows(arr, cel, i) || !knows(arr, i, cel))) flag = true;
        }
        if(flag) System.out.println("none");
        else System.out.println(cel);
    }

}