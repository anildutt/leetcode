class Solution {
    Map<Integer, List<Integer>> map;
    int[] nums;
    
    public Solution(int[] nums) {
        //approach 1
        map = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i<nums.length; i++){
            int num = nums[i];
            if(map.containsKey(num))
                map.get(num).add(i);
            else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(num, list);
            }
        }
        
        //aproach 2
        this.nums = nums;
    }
    
    public int pick(int target) {        
        int result = -1;
        Random rand = new Random();
        
        //approach 1 - using Random directly on indices
        List<Integer> indices = map.get(target);
        int randIdx = rand.nextInt(indices.size());
        result = indices.get(randIdx);
        
        //approach 2 - Rervoir Sampling
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                if (rnd.nextInt(++count) == 0)
                    result = i;
        } 

        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
