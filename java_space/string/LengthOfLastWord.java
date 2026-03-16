package string;

public class LengthOfLastWord {
     public int lengthOfLastWord(String s) {
        if(s == "" || s == null) return 0;
        int index = s.length() - 1  ;

        while(s.trim().charAt(index) != ' '){
            index -- ;
        }

        return s.trim().length() - index ;
    }
}
