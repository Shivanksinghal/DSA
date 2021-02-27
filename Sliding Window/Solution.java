public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        for(; end < nums.length; ++end) {
            sum += nums[end];
            while(sum - nums[start] >= target) {
                sum -= nums[start];
                start ++;
            }
            if(sum >= target)
                len = Math.min(len, end - start + 1);
        }
        if(len == Integer.MAX_VALUE) len = 0;
        return len;
    }

}
