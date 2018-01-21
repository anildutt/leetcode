package leetcode;
import java.util.*;

public class MissingRanges {
	
	public static void main(String[] args) {
		int[] vals = {1, 99};
		List<String> res = findMissingRanges(vals);
		for(String r : res)	System.out.println(r);
	}
	
	public static List<String> findMissingRanges(int[] vals) {
		List<String> result = new ArrayList<String>();
		int lastFound = -1, i;
		
		for(i=0; i<vals.length; i++){
			if(vals[i] == lastFound + 1) 
				lastFound = vals[i];
			else{ //gap found => Add range from lastFound + 1 --> cur - 1
				result.add(range(lastFound+1, vals[i]-1));
				lastFound = vals[i];
			}
		}
		
		if(vals[i-1] != 99)	result.add(range(lastFound+1, 99));
		return result;
	}
	
	private static String range(int lo, int hi){
		if(lo == hi) return String.valueOf(lo);
		else return lo+ "->" + hi;
	}
}
