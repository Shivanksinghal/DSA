public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int cur = 0;
        for(int i = 0; i < nums.length; ++i) {
            cur += nums[i];
            res = Math.max(res, cur);
            if(cur < 0) cur = 0;
        }
        return res;
    }   

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));    
    } 
}
