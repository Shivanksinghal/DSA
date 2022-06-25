import java.io.*;
import java.util.*;

public class PrintStairPath {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printStairPaths(n, "");
    }

    public static void printStairPaths(int n, String path) {
        if(n == 0) {
            System.out.println(path);
            return;
        }
        if(n >= 1)
            printStairPaths(n-1, path + "1");
        if(n >= 2) 
            printStairPaths(n-2, path + "2");
        if(n >= 3)
            printStairPaths(n-3, path + "3");
    }

}