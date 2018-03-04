/**
 * You could simply convert to negative number, then find Base7 rep, then prepend "-".
 * Below, I'm handling neg num case in-line.
 **/
class Solution {
    public String convertToBase7(int n) {
        if(n == 0) return "0";
        
        StringBuilder sb = new StringBuilder("");
        
        while(n!=0){
            if(n < 0 && n/7 != 0)  //For negative numbers, only need sign for MSB
                sb.insert(0, -(n%7));
            else 
                sb.insert(0, n%7);
            n/=7;
        }
        
        return sb.toString();
    }
}
