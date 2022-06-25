import java.io.*;
import java.util.*;

public class GetKPC {
    static Map<Integer, String> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        map.put(0,".;");
        map.put(1,"abc");
        map.put(2,"def");
        map.put(3,"ghi");
        map.put(4,"jkl");
        map.put(5,"mno");
        map.put(6,"pqrs");
        map.put(7,"tu");
        map.put(8,"vwx");
        map.put(9,"yz");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(getKPC(str));
    }

    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0) return new ArrayList<String>(Arrays.asList(""));
        ArrayList<String> res = getKPC(str.substring(1));
        ArrayList<String> result = new ArrayList<>();
        for(char ch: map.get(str.charAt(0) - '0').toCharArray()) {
            for(String s: res) {
                result.add(ch + s);
            }
        }
        return result;
    }

}