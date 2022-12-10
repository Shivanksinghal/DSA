import java.util.Scanner;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        int i = 0, j = arr.length - 1;
        int water = 0;
        while(i < j) {
            water = Math.max(water,  (j - i) * Math.min(arr[i], arr[j]));
            if(arr[i] < arr[j]) {
                water = Math.max(water,  (j - i) * arr[i]);
                i++;
            } else {
                water = Math.max(water,  (j - i) * arr[j]);
                j --;
            }
        }
        System.out.println(water);
    }
}
