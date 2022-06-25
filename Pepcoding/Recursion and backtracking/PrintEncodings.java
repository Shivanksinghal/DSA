import java.io.*;
import java.util.*;

public class PrintEncodings {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printEncodings(str, "");
    }

    public static void printEncodings(String str, String res) {
        if(str.length() == 0) {
            System.out.println(res);
            return;
        }
        if(str.length() <= 1 || str.charAt(1) != '0')
            printEncodings(str.substring(1), res + (char)('a' + (str.charAt(0) - '0') - 1));
        if(str.length() > 1 && ((str.charAt(0) == '1') || (str.charAt(0) == '2' && str.charAt(1) <= '6'))) {
            printEncodings(str.substring(2), res + (char)('a' + ((str.charAt(0) - '0')*10 + str.charAt(1) - '0') - 1));
        }
    }

}