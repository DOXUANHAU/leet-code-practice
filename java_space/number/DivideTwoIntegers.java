package number;

public class  DivideTwoIntegers {
    public int divide(int dividend, int divisor) {

    if (divisor == 0) return Integer.MAX_VALUE;

    // overflow case
    if (dividend == Integer.MIN_VALUE && divisor == -1)
        return Integer.MAX_VALUE;

    // convert to long to avoid overflow
    long a = Math.abs((long) dividend);
    long b = Math.abs((long) divisor);

    int result = getQuotient(a, b);

    // determine sign
    boolean negative = (dividend < 0) ^ (divisor < 0);

    return negative ? -result : result;
}

public int getQuotient(long dividend, long divisor) {

    if (dividend < divisor)
        return 0;

    int bitCount = 0;

    // find largest divisor * 2^k <= dividend
    while ((divisor << (bitCount + 1)) <= dividend) {
        bitCount++;
    }

    int quotient = 1 << bitCount;

    long remainder = dividend - (divisor << bitCount);

    return quotient + getQuotient(remainder, divisor);
}
    public static void main(String[] args) {
        DivideTwoIntegers di = new DivideTwoIntegers();
        System.out.println(di.divide(2147483647, -1));
    }
}
