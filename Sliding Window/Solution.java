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
}
