import java.util.*;

public class StockI {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int res = 0;
        for(int i = 1; i < prices.length; ++i) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        } 
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new StockI().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}