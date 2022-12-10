public class RotateImage {
    void trans(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    void reverseRow(int[][] matrix, int i) {
        int l = 0, r = matrix[i].length - 1;
        while(l < r) {
            int temp = matrix[i][l]; 
            matrix[i][l] = matrix[i][r];
            matrix[i][r] = temp;
            l ++;
            r --;
        }
    }

    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = i + 1; j < matrix.length; ++j) {
                trans(matrix, i, j);
            }
        }
        for(int i = 0; i < matrix.length; ++i) {
            reverseRow(matrix, i);
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        new RotateImage().rotate(matrix);
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[0].length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }    
    }
}