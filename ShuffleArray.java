package leetcode;

class Solution {
    int[] nums;
    int[] shuffled;
    
    public Solution(int[] nums) {
        this.nums = nums;
        shuffled = new int[nums.length];
        for(int i=0; i<shuffled.length; i++)
            shuffled[i] = nums[i];
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    //Approach #1 Drawing one element from a  : O(n)
    public int[] shuffle1() {
        int[] res = new int[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        for(int num : nums) list.add(num);
        
        Random rand = new Random();
        int n = list.size();
        int count = 0;
        
        for(int i=0; i<n; i++){
            int idx = rand.nextInt(list.size());
            res[count++] = list.remove(idx);
        }
        return res;
    }
    
    //Approach #2 Fisher-Yates Algorithm : O(1) memory
    public int[] shuffle(){
        Random rand = new Random();
        
        for(int i=0; i<shuffled.length; i++){
            int rIdx = i + rand.nextInt(shuffled.length - i); //rIdx = random between [i, n)
            
            int tmp = shuffled[rIdx];   //swap( rIdx, i )
            shuffled[rIdx] = shuffled[i];
            shuffled[i] = tmp;
        }
        
        return shuffled;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
