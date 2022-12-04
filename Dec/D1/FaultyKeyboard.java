import java.util.Scanner;

public class FaultyKeyboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        if(s2.length() < s1.length()) {
            System.out.println(false);
        } else {
            int i = 0, j = 0;
            while(i < s1.length() && j < s2.length()) {
                if(s1.charAt(i) != s2.charAt(j)) {
                    System.out.println(false);
                    return;
                }
                char ch = s1.charAt(i);
                int count1 = 0;
                while(i < s1.length() && s1.charAt(i) == ch) {
                    i++;
                    count1 ++;
                }
                int count2 = 0;
                while(j < s2.length() && s2.charAt(j) == ch) {
                    j++;
                    count2 ++;
                }
                if(count1 > count2) {
                    System.out.println(false);
                    return;
                }
            }
            if(i != s1.length() || j != s2.length()) {
                System.out.println(false);
            } else {
                System.out.println(true);
            }
        }
    }
}