import java.util.Arrays;
import java.util.Scanner;

public class NextGreaterElementIII {
    public static void swap(char arr[], int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static String nextGreaterElement(String str) {
        char[] num = str.toCharArray();
        int i = num.length - 1;
        while(i > 0 && num[i-1] >= num[i]) {
            i --;
        } 
        if(i == 0) return new String("-1");
        int next = Integer.MAX_VALUE;
        int ind = -1;
        for(int j = num.length - 1; j >= i; --j) {
            if(num[j] < next && num[j] > num[i-1]) {
                next = num[j];
                ind = j;
            }
        }
        swap(num, i-1, ind);
        Arrays.sort(num, i, num.length);
        return new String(num);
    }

    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String num = scn.next();
        String res = nextGreaterElement(num);

        System.out.println(res);
    }
}
