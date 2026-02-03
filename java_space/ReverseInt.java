

public class ReverseInt{
      public int reverse(int s) {
      
    int result = 0;
    while(s != 0){
        if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) return 0;
        int lastdigit = s % 10 ;
        result = result *10 + lastdigit;
        s /= 10 ;
    }  
    return  result;
    }
    public static void main(String[] args) {
        ReverseInt a = new ReverseInt();
        System.out.println(a.reverse(-2147483412));
        // System.out.println(a.reverse(2 147 483 647));

    }
}
