package org.example;

public class StringUtils {
    public String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public boolean isPalindrome(String str){
        String rev = reverse(str);
        return str.equals(rev);
    }

    public String toUpperCase(String str){
        String res = "";
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                res += (char)(ch - 32);
            }else{
                res += ch;
            }
        }
        return res;
    }
}
