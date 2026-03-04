public class FirstOccurrence {

      public int strStr(String haystack, String needle) {
        if(haystack == null || haystack.length() == 0 || needle == null || haystack.length() < needle.length()) return -1;
        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();
        int result = -1;
       loop: for (int i = 0; i < haystackArr.length; i++) {
            if(haystackArr.length - i < needleArr.length) break loop;
            if(haystackArr[i] == needleArr[0] && checkMatchArr(haystackArr, i, needleArr)){
                    result = i;
                    break loop;
            }
        }

      return result;
    }
    public boolean checkMatchArr(char[] first ,int atIndex, char[] second){
        boolean result = true;
        for (int i = 0; i < second.length; i++) {
            if(first[atIndex + i] != second[i]){
                result = false;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String a = "sadbutsad";
        String b = "sad";
        FirstOccurrence aFirstOccurrence = new FirstOccurrence();
        System.out.println(aFirstOccurrence.strStr(a, b));
    }
}