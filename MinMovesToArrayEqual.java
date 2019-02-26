package leetcode;

class Solution {
    /*
     Algo: incrementing n-1 elements == decremeting 1 element.
     Just bring all elements to least element one decrement at a time.
    */
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++)
            min = Math.min(min, nums[i]);
        
        int val = 0;
        for(int i=0; i<nums.length; i++)
            val += Math.abs(nums[i]-min);
        return val;
        
    }
}
