/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        Map<Integer, Integer> startToIndex = new HashMap<Integer, Integer>();
         //remember the original positions of intervals
        for(int i = 0; i< intervals.length; i++)
            startToIndex.put(intervals[i].start, i);
        
        //Sort by "start", then by "end"
        Arrays.sort(intervals, new IntervalComparator());
        
        //Binary search for element e, with e.start >= cur.end
        int[] result = new int[intervals.length];
        for(int i=0; i<result.length-1; i++){
            int idx = binarySearch(intervals, //array
                                     i+1, intervals.length - 1,   //lo, hi
                                     intervals[i].end); //element
            
            //Convert back to original indices & put into "result"
            result[startToIndex.get(intervals[i].start)] = 
                (idx == -1) ? -1 : startToIndex.get(intervals[idx].start);
        }
        
        //result
        result[startToIndex.get(intervals[intervals.length - 1].start)] = -1;
        return result;
    }
    
    /* Find first index >= e, given element */
    private int binarySearch(Interval[] intervals, 
                             int lo, int hi,
                             int e){
        //if(intervals[lo].start >= e) return lo;
        if(intervals[hi].start < e) return -1;
        
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(intervals[mid].start >= e 
               && (mid == lo || intervals[mid-1].start < e)
              )
                return mid;
            else if(intervals[mid].start >= e){
                hi = mid;
            }else if(intervals[mid].start < e)
                lo = mid + 1;
        }
        
        return (intervals[lo].start >= e) ? lo : -1;
    }
}

class IntervalComparator implements Comparator<Interval>{
    public int compare(Interval i1, Interval i2){
        if(i1.start != i2.start) return i1.start - i2.start;
        return i1.end - i2.end;
    }
}
