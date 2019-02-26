package leetcode;

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return canIWin(nums, 0, nums.length - 1, 0, 0);
    }
    
    private boolean canIWin(int[] nums, int left, int right, int myscore, int yourscore){
        if(left==right) return (myscore + nums[left] >= yourscore);
        if(right - left == 1) return (myscore + Math.max(nums[left], nums[right]) >= 
                                     yourscore + Math.min(nums[left], nums[right]));

        //If I should win, you should not win
        return !canIWin(nums, left + 1, right, yourscore, myscore + nums[left]) ||
            !canIWin(nums, left, right-1, yourscore, myscore + nums[right]);
    }
}
