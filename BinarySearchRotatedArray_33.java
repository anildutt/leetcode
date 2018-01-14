class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        
        while ( lo <= hi ){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) return mid;

            //right of dip 
            if(nums[mid] < nums[hi]){
                if(target < nums[mid] || target > nums[hi]) hi = mid - 1;
                else lo = mid + 1;
            }else { //left of dip
                if(target > nums[mid] || target < nums[lo]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        
        return -1;
    }
}
