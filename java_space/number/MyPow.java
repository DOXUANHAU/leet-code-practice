package number;

import java.math.BigDecimal;

public class MyPow {
    public double myPow(double x , int n){
    long p = n;
    return n < 0 ? 1 / helper(x, p * -1) : helper(x, p);
        
    }
    private double helper(double x , long n){
        if(n == 0 ) return 1.0;
        if(n == 1 ) return x;
        if(n % 2 == 0){
        double result = helper(x, n / 2);
        return result * result;
       }else{
        double result = helper(x, (n -1 )/2);
        return x * result * result;
        }
    }
    public static void main(String[] args) {
        MyPow  myPow = new MyPow();
        BigDecimal bigDecimal = new BigDecimal(myPow.myPow(100,Integer.MAX_VALUE));
        System.out.println(bigDecimal.longValue());
}
}