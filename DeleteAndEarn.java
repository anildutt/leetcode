/**
 * Given an array nums of integers, you can perform operations on the array.
 * In each operation, you pick any nums[i] and delete it to earn nums[i] points. 
 * After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
 * 
 * You start with 0 points. Return the maximum number of points you can earn by 
 * applying such operations.
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0) return 0;
        
        Map<Integer, Integer> numToSum = buildSumMap(nums);
        
        int dp[] = new int[nums.length];
        Arrays.sort(nums);
        dp[0] = numToSum.get(nums[0]);
        
        int lastIncl=dp[0];
        int lastExcl=0;
        int max = Integer.MIN_VALUE;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]) continue;
            if(nums[i] == nums[i-1] + 1){
                max = Math.max(lastIncl, lastExcl+numToSum.get(nums[i]));
            }else{
                max = lastIncl+numToSum.get(nums[i]);
            }
            lastExcl = lastIncl;
            lastIncl = max;
        }
        
        return Math.max(lastIncl, lastExcl);
    }
    
    /** Build map with number -> sum of all array elements with that value */
    private Map<Integer, Integer> buildSumMap(int[] nums){
        Map<Integer, Integer> numToSum = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(numToSum.containsKey(nums[i])) numToSum.put(nums[i], nums[i] + numToSum.get(nums[i]));
            else numToSum.put(nums[i], nums[i]);
        }
        return numToSum;
    }
}
