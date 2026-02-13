public class RegularExpression{

    public RegularExpression() {
    }

    
    public boolean isMatch(String s,String p){
        if(s.length() == 0 && p.length() == 0) return true;
        if(s.length() == 0 || p.length() == 0) return false;
        return s.matches(p);
    }

    public static void main(String[] args) {
        RegularExpression regularExpression = new RegularExpression();
        System.out.println(regularExpression.isMatch("aa", "a."));
    }

}