public class Solution{


    // Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer
    public int myAtoi(String s){
        char[] chars = s.trim().toCharArray();
        long result = 0;
        boolean  isNegative = true;
        if(chars[0] == '-' ){
            isNegative = false;
        }
        if(isNumber(chars[0])){
            result += (int) (chars[0] - '0');
        }
        int index =  1;
        loop:while(index < chars.length ){
            // if '.' then ignore and continue the loop
            if(chars[index] == '.') {
                index++;
                continue loop;
            }

            // check value if non-digit then increase the value if not break
            if(isNumber(chars[index])){
                int digit = chars[index] - '0';
                result = ( result * 10 ) + digit;
                index++;
                if(result > Integer.MAX_VALUE && isNegative) return Integer.MAX_VALUE;
                if(result > Integer.MAX_VALUE && !isNegative) return Integer.MIN_VALUE;

            }
            else{
                break loop;
            }
        }


    return (int) (isNegative ? result : -1 * result); 
    }
    private boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }
    

    public static void main(String[] args) {
        String string = "         +-3.a14159";
        Solution solution = new Solution();
        System.out.println(solution.myAtoi(string));
    }
}   