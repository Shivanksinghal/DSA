import java.io.*;
import java.util.*;

public class SmallestNumberFollowingPattern {
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    // code
    int count = 0;
    String res = "";
    int val = 1;
    for(int i = 0; i < str.length(); ++i) {
        String ans = "";
        if(str.charAt(i) == 'i') {
            while(count > 0) {
                ans = val + ans;
                count --;
                val ++;
            }
            ans = val + ans;
            val ++;
        } else {
            count ++;
        }
        res += ans;
    }
    String ans = "";
    while(count > 0) {
        ans = val + ans;
        count --;
        val ++;
    }
    System.out.print(res + val+ ans);
 }
}