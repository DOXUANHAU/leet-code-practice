package string;

public class AddBinaryString {
    public String addBinary(String a,String b){
        StringBuilder builder = new StringBuilder();
         int num1 = a.length() -1;
        int num2 = b.length() -1;
        int carry = 0 ;
        while(num1 >=  0 || num2 >= 0 || carry == 1){
            int sum = carry;
            if(num1 >= 0) sum += a.charAt(num1--) - '0';
            if(num2 >= 0) sum+=b.charAt(num2--) - '0'; 

        builder.append(sum % 2);
        carry = sum / 2;
        }
        return builder.reverse().toString();
    }

    public String recursionAddBinary(String a,String b){

        return helper(a,a.length() -1 , b,b.length() -1 , 0);
    }
    private String helper (String a,int i , String b,int j, int carry ){
        if(i < 0 && j < 0 && carry == 0) return "";
        int sum = carry;
         if (i >= 0) sum += a.charAt(i) - '0';
        if (j >= 0) sum += b.charAt(j) - '0';

        char currentBit = (char) ((sum % 2) + '0');

        return helper(a, i -1, b, j -1, sum /2) + currentBit;
    }
    public static void main(String[] args) {
        AddBinaryString addBinaryString = new AddBinaryString();
        System.out.println(addBinaryString.recursionAddBinary("111", "11"));
    }
}
