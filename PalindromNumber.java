package leetcode;

public class PalindromNumber {

    public boolean isPalindrome(int x) {
        if(x < 0 || (x%10 == 0 && x!=0)) return false;
        int reversedX = 0;

        while(reversedX < x) {
            reversedX = (x%10) + 10 * reversedX;
            x /= 10;
        }

        return reversedX == x || reversedX/10 == x;
    }

    public static void main(String[] Args){
        PalindromNumber demo = new PalindromNumber();
        int[] positiveTcs = {0, 121, 232, 234432, 11, 123454321};
        for (int tc : positiveTcs) {
            if(!demo.isPalindrome(tc))
                System.out.println(tc + "Error!");
        }

        int[] negativeTcs = {-1, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for(int tc : negativeTcs) {
            if(demo.isPalindrome(tc))
                System.out.println(tc + "Error!");
        }
    }
}
