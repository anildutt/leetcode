class Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) return true;
            if(nums[mid] < nums[hi]){
                if(target < nums[mid] || target > nums[hi]) hi = mid - 1;
                else lo = mid + 1;
            }else if(nums[mid] > nums[hi]){
                if(target > nums[mid] || target < nums[lo]) lo = mid + 1;
                else hi = mid - 1;
            }else
                hi--;
        }
        
        return false;
    }
}
