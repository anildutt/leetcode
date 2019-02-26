package leetcode;
class Solution {
	public boolean isAdditiveNumber(String num) {
		for (int i = 0; i < num.length() / 2; i++) {
			for (int j = i + 1; j < num.length() - 1; j++) {
				String num1 = num.substring(0,i+1);
				String num2 = num.substring(i + 1, j + 1);
				String rest = num.substring(j + 1);
				
                if(isInvalid(num1) || isInvalid(num2) || isInvalid(rest))
				    continue;
				if (isAdditive(num1, num2, rest))
					return true;
			}
		}

		return false;
	}
    
    private boolean isInvalid(String num){  return num.length() > 1 && num.startsWith("0"); }
	private boolean isAdditive(String num1, String num2, String num) {
		long n1 = Long.valueOf(num1);
		long n2 = Long.valueOf(num2);
		String addition = String.valueOf(n1 + n2);
		if(num.equals(addition)) return true;
		if (num.startsWith(addition) == false)
			return false;
		else
			return isAdditive(num2, addition, num.substring(addition.length()));
	}
}
