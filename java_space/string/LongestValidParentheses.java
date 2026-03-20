 package string;

import java.util.Stack;

public class LongestValidParentheses {
     public int longestValidParentheses(String s) {
        if(s.length() == 0 || s.length() == 1 || s == null ) return 0;
       Stack<Character> stack = new Stack<>();
        int max = 0;
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length() ; i++) {
            if(s.charAt(i) == '(') stack.add(s.charAt(i));
            if(s.charAt(i) == ')' && stack.isEmpty()) continue;
            if(s.charAt(i) == ')' && stack.pop() == '(') max+=2;
        }
        return max;        
    }
public static void main(String[] args) {
    String s = "(()";
    LongestValidParentheses  longestValidParentheses= new LongestValidParentheses();
    System.out.println(longestValidParentheses.longestValidParentheses(s));
}
    
}