import java.util.*;
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(1));
        if(numRows == 1) {  
            return ans;
        }
        for(int i = 1; i < numRows; ++i) {
            List<Integer> res = new ArrayList<>();
            res.add(1);
            int sz = ans.get(i - 1).size();
            for(int j = 0; j < sz - 1; ++j) {
                res.add(ans.get(i - 1).get(j) + ans.get(i - 1).get(j+1));
            }
            res.add(1);
            ans.add(res);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangle().generate(5));
    }    
}
