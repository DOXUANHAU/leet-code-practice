public class Solution{


    // Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer
    public int myAtoi(String s){
        char[] chars = s.trim().toCharArray();
        if(chars.length == 0) return 0;
        long result = 0;
        boolean  isPositive = true;
        // if the first char is digit then add into the result 
        if(isNumber(chars[0])) result = ( result * 10 ) + (int) (chars[0] - '0');   
        
        // when char is not digit and char is one of '-' or '+' set non-positive or positive number 
        if(!isNumber(chars[0]) && (chars[0] == '-' || chars[0] == '+')) isPositive = chars[0] == '+'; 

        //  last case not digit and not one of '-' or '+' then return 0 
        if(!isNumber(chars[0]) && !(chars[0] == '-' || chars[0] == '+')) return 0;

        int index =  1;

        
        while(index < chars.length && isNumber(chars[index]) ){
            // check value if non-digit then increase the value if not break
                int digit = chars[index] - '0';
                result = ( result * 10 ) + digit;
                index++;
                // check value bigger or smaller than MIN MAX value of Integer 
                if(result > Integer.MAX_VALUE && isPositive) return Integer.MAX_VALUE;
                if(result > Integer.MAX_VALUE && !isPositive) return Integer.MIN_VALUE;
        }

    return (int) (isPositive ? result : -1 * result); 
    }
    private boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }
    

    public static void main(String[] args) {
        String string = "-42";
        Solution solution = new Solution();
        System.out.println(solution.myAtoi(string));
    }
}   