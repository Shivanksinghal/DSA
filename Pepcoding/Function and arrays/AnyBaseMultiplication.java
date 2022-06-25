import java.util.*;

public class AnyBaseMultiplication{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int b = scn.nextInt();
    int n1 = scn.nextInt();
    int n2 = scn.nextInt();

    int d = getProduct(b, n1, n2);
    System.out.println(d);
 }

    public static int mul(int n, int d, int b) {
        int res = 0, carry = 0, p = 1;
        while(n > 0 || carry > 0) {
            int v = (n % 10)*d + carry;
            carry = v / b;
            v = v % b;
            res += p * v;
            n /= 10;
            p *= 10;
        }
        return res;
    }

    public static int add(int n1, int n2, int b) {
        if(n1 == 0) return n2;
        int res = 0, carry = 0, p = 1;
        while(n1 > 0 || n2 > 0 || carry > 0) {
            int v1 = n1 % 10 + carry;
            int v2 = n2 % 10;
            res += p * ((v1+v2) % b);
            carry = (v1+v2)/b;
            n1 /= 10;
            n2 /= 10;
            p *= 10;
        }
        return res;
    }

 public static int getProduct(int b, int n1, int n2){
     // write your code here
    //  return mul(22, 2 ,3);
     int res = 0, p = 1;;
     while(n2 > 0) {
         int m = mul(n1, n2%10, b);
         res = add(res, m*p, b);
         n2 /= 10;
         p *= 10;
     }
     return res;
 }

}