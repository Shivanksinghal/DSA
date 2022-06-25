import java.io.*;
import java.util.*;

public class GetMazePathWithJumps {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(getMazePaths(1, 1, n, m));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr > dr || sc > dc) return new ArrayList<>();
        if(sr == dr && sc == dc) return new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        int vd = dc - sc;
        for(int i = 1; i <= vd; ++i) {
            ArrayList<String> res = getMazePaths(sr, sc + i, dr, dc);
            if(res.size() == 0) {
                res.add("h" + i);
            } else {
                for(int j = 0; j < res.size(); ++j) {
                    res.set(j, "h" + i + res.get(j));
                }
            }
            ans.addAll(res);
        }
        int hd = dr - sr;
        for(int j = 1; j <= hd; ++j) {
            ArrayList<String> res = getMazePaths(sr + j, sc, dr, dc);
            if(res.size() == 0) {
                res.add("v" + j);
            } else {
                for(int i = 0; i < res.size(); ++i) {
                    res.set(i, "v" + j + res.get(i));
                }
            }
            ans.addAll(res);
        }
        

        for(int i = 1; i <= Math.min(hd, vd); ++i) {
            ArrayList<String> res = getMazePaths(sr + i, sc + i, dr, dc);
            if(res.size() == 0) {
                res.add("d" + i);
            } else {
                for(int j = 0; j < res.size(); ++j) {
                    res.set(j, "d" + i + res.get(j));
                }
            }
            ans.addAll(res);
        }
        return ans;
    }

}