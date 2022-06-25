import java.io.*;
import java.util.*;

public class RemovePrimes {

	public static void solution(ArrayList<Integer> al){
		// write your code here
		int n = al.size();
		for(int i = n-1; i >= 0; --i) {
			int val = al.get(i);
			boolean flag = false;
			for(int j = 2; j * j <= val; ++j) {
				if(val % j == 0) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				al.remove(i);
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0 ; i < n; i++){
			al.add(scn.nextInt());
		}
		solution(al);
		System.out.println(al);
	}

}