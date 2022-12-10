package Misc;
public class Solution {
    
    public int maxSumSubArray(int arr[], int k) {
        int res = Integer.MIN_VALUE;
        int n = arr.length;
        int sum = 0;

        for(int start = 0; start < n; ++start){
            sum += arr[start];
            if(start >= k - 1) {
                res = Math.max(res, sum);
                sum -= arr[start - k + 1];
            }
        }
        return res;
    }

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
