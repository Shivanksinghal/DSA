import java.io.*;
import java.util.*;

public class StringCompression {

	public static String compression1(String str){
		// write your code here
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < str.length(); ++i) {
			if(i == 0 || str.charAt(i) != str.charAt(i-1)) {
				res.append(str.charAt(i));
			}
		}
		return res.toString();
	}

	public static String compression2(String str){
		// write your code here
		StringBuilder res = new StringBuilder();
		int count = 1;
		for(int i = 0; i < str.length(); ++i) {
			if(i == str.length() - 1 || str.charAt(i) != str.charAt(i+1)) {
				res.append(str.charAt(i));
				if(count > 1) res.append(count);
				count = 1;
			} else {
				count ++;
			}
		}
		return res.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

}