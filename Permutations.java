package leetcode;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        recur(nums, result, 0);
        return result;
    }
    
    private void recur(int[] nums, List<List<Integer>> result, int index){
        if(index == nums.length){
            List<Integer> sol = new ArrayList<Integer>();
            for(int i=0; i<nums.length; i++)
                sol.add(nums[i]);
            result.add(sol);
        }
        
        for(int i=index; i<nums.length; i++){
            int tmp = nums[i];
            nums[i] = nums[index];
            nums[index] = tmp;
            
            recur(nums, result, index+1);
            
            tmp = nums[i];
            nums[i] = nums[index];
            nums[index] = tmp;
        }
        
    }
}
