
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = m + n - 1, fi = m - 1, si = n - 1;
        while(si >= 0 && fi >= 0) {
            if(nums1[fi] < nums2[si]) {
                nums1[cur--] = nums2[si--];
            } else {
                nums1[cur--] = nums1[fi--];
            }
        }
        while(fi >= 0) {
            nums1[cur--] = nums1[fi--];
        }
        while(si >= 0) {
            nums1[cur--] = nums2[si--];
        }
    }

    public static void main(String[] args) {
        int nums1[] = {1,2,3,0,0,0};
        int nums2[] = {2,5,6};
        new MergeSortedArray().merge(nums1, 3, nums2, 3);
        for(int i = 0; i < nums1.length; ++i) {
            System.out.print(nums1[i] + " ");
        }
    }
}
