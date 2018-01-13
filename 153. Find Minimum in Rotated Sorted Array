class Solution {
    public int findMin(int[] arr) {
        int lo = 0, hi = arr.length - 1, mid;
        
        while(lo < hi){
            mid = lo + (hi-lo)/2;
            if ( (mid == 0 || arr[mid] < arr[mid-1]) 
                && (mid == arr.length - 1 || arr[mid] < arr[mid+1])) return arr[mid];
            else if (arr[mid] < arr[hi]){
                if(mid == 0) return arr[mid];
                else
                    hi = mid-1;
            }else{
                lo = mid + 1;
            }
        }
        return arr[lo];
    }
}
