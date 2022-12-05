import java.util.*;

public class StockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int sp = 0, bp = -prices[0];
        for(int i = 1; i < prices.length; ++i) {
            sp = Math.max(sp, prices[i] + bp - fee);
            bp = Math.max(bp, sp - prices[i]);
        } 
        return sp;
    }

    public static void main(String[] args) {
        System.out.println(new StockWithTransactionFee().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}