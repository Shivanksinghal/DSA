import java.io.*;
import java.util.*;

public class GetSubsequence {

    public static void main(String[] args) throws Exception {   
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(gss(s));
    }

    public static ArrayList<String> gss(String str) {
        if(str.equals("")) return new ArrayList<String>(Arrays.asList(str));
        
        ArrayList<String> res = gss(str.substring(1));
        int len = res.size();
        for(int i = 0; i < len; ++i) {
            res.add(str.charAt(0) + res.get(i));
        }
        return res;
    }

}