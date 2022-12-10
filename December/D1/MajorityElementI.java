import java.util.Scanner;

public class MajorityElementI {
    public static void printMajorityElement(int[] arr) {
        int count = 1, val = arr[0];
        for(int i = 1; i < arr.length; ++i) {
            if(arr[i] != val) {
                count --;
            }
            if(count == 0) {
                val = arr[i];
                count = 1;
            }

        }
        System.out.println(val); 
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        printMajorityElement(arr);
    }
}
