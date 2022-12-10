
public class SortColors {

    public void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int z = 0, t = nums.length - 1, cur = 0;
        while(cur <= t) {
            if(nums[cur] == 0) {
                swap(nums, z, cur);
                z ++;
                cur ++;
            } else if(nums[cur] == 2) {
                swap(nums, t, cur);
                t --;
            } else {
                cur ++;
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = {2,0,2,1,1,0};
        new SortColors().sortColors(nums);
        for(int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + " ");
        }    
    }    
}
