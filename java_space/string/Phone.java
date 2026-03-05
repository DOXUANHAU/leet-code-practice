package string;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Phone {
    public List<String> letterCombinations(String digits) {
        Hashtable<Character, String> table = new Hashtable<>();
        table.put('2', "abc");
        table.put('3', "def");
        table.put('4', "ghi");
        table.put('5', "jkl");
        table.put('6', "mno");
        table.put('7', "pqrs");
        table.put('8', "tuv");
        table.put('9', "wxyz");




        int k = digits.length();
        List<String> result = new ArrayList<>();

        backtrack(digits, k, 0, "", result, table);
        
        return result;
    }
   public void backtrack(String digits, int k, int start,
                                 String temp,
                                 List<String> result, Hashtable<Character, String> table) {

        if (temp.length() == k) {
            result.add(temp);
            return;
        }

        for (int i = start; i < digits.length(); i++) {
            char digit = digits.charAt(i);
            String letters = table.get(digit);
            for (char letter : letters.toCharArray()) {
                backtrack(digits, k, i + 1, temp + letter, result, table);
            }
        }
    }
    public static void main(String[] args) {
        Phone solution = new Phone();
        String digits = "234";
        List<String> combinations = solution.letterCombinations(digits);
        System.out.println(combinations);
    }
}
