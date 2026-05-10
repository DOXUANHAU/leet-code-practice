package string;
public class MinimumWindowSubString {
	  public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int[] need = new int[128];

        // count chars in t
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int right = 0;

        int required = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char r = s.charAt(right);

            // useful char
            if (need[r] > 0) {
                required--;
            }

            need[r]--;

            right++;

            // valid window
            while (required == 0) {

                // update answer
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char l = s.charAt(left);

                need[l]++;

                // window becomes invalid
                if (need[l] > 0) {
                    required++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }

	public static void main(String[] args){
		MinimumWindowSubString varName = new MinimumWindowSubString ();
	       System.out.println(varName.minWindow("allllllllllllooooooo","lo"));	
	}
}

