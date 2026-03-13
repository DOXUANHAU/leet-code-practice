package string ;

class LengthOfLastWord {
     public int lengthOfLastWord(String s) {
        if(s == "" || s == null  ) return 0;
        if(s.trim().length() == 1) return 1;
        int index = s.trim().length() - 1  ;

        while(s.trim().charAt(index) != ' '   ){
            index -- ;

            if(index < 0) break;
        }

        return s.trim().length() - (index + 1) ;
    }
}
