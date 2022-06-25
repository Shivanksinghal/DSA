import java.io.*;
import java.util.*;

public class NQueens {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int chess[][] = new int[n][n];
        printNQueens(chess, "", 0);
    }

    // public static boolean placed(int[][] chess) {
    //     int count = 0;
    //     for(int i = 0; i < chess.length; ++i) {
    //         for(int j = 0; j < chess[0].length; ++j) {
    //             count += chess[i][j];
    //         }
    //     }
    //     return count == chess.length;
    // }

    public static boolean isValid(int chess[][], int row, int col) {
        for(int c = 0; c < chess.length; ++c) if(chess[row][c] == 1) return false;
        for(int r = 0; r < chess.length; ++r) if(chess[r][col] == 1) return false; 
        for(int r = row - Math.min(row, col), c = col - Math.min(row, col); r < chess.length && c < chess.length; ++r, ++c) {
            if(chess[r][c] == 1) return false;
        }
        for(int r = row - Math.min(row, chess.length - col - 1), c = col + Math.min(row, chess.length - col - 1); r < chess.length && c >= 0; ++r, --c) {
            if(chess[r][c] == 1) return false;
        }
        return true;
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        if(row == chess.length) {
            System.out.println(qsf + ".");
            return;
        }
        for(int i = 0; i < chess[row].length; ++i) {
            if(isValid(chess, row, i)) {
                chess[row][i] = 1;
                printNQueens(chess, qsf + row + "-" + i + ", ", row + 1);
            }
            chess[row][i] = 0;
        }
    }
}