package leetcode;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        recur(nums,0,  new ArrayList<Integer>(), result);
        return result;
    }
    
    private void recur(int[] nums, int index, List<Integer> curSol, List<List<Integer>> result){
        if(index == nums.length) { result.add(new ArrayList<Integer>(curSol)); return; }
        
        curSol.add(nums[index]);
        recur(nums, index+1, curSol, result);
        curSol.remove(curSol.size() - 1);
        recur(nums, index+1, curSol, result);
    }
}
