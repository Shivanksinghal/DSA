
public class NextPermutation {
    public void reverse(int num[], int s) {
       int r = num.length - 1; 
        while(s < r) {
            swap(num, s, r);
            s ++;
            r --;
        }
    }

    public void swap(int num[], int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public int find(int num[], int l, int r, int x) {
        while(l < r) {
            int m = l + (r - l) / 2;
            if(num[m] <= x) r = m - 1;
            else  l = m + 1;
        }
        return (num[l] <= x) ? l - 1 : l;
    }

    public void nextPermutation(int[] num) {
        int i = num.length - 1;
        while(i > 0 && num[i-1] >= num[i]) i--;
        if(i == 0) {
            reverse(num, 0);
            return;
        }

        int ind = find(num, i, num.length - 1, num[i-1]);
        swap(num, i - 1, ind);
        reverse(num, i);
    }
    
    public static void main(String[] args) {
        int num[] = {1, 4, 3, 2};
        new NextPermutation().nextPermutation(num);
        for(int i = 0; i < num.length; ++i) {
            System.out.print(num[i] + " ");
        }
    }
}
