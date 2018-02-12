package javaStuff;

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
	/**
	 * Question: insert newInterval at correct position 
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.size() == 0){
            List<Interval> res = new ArrayList<Interval>();
            res.add(newInterval); 
            return res;
        }
        
        int start = -1, end = -1;
        for(int i=0; i<intervals.size();i++){
            if(overlaps(intervals.get(i), newInterval)){
                if(start == -1)
                    start = i;
                end = i;
            }else {
                if(i+1 < intervals.size() && 
                   between(intervals.get(i), intervals.get(i+1), newInterval))
                {
                    intervals.add(i+1, newInterval);
                    return intervals;
                }
               if(end != -1) break;
            }
        }
        
        if(start == -1){
            if(newInterval.end < intervals.get(0).start)
                intervals.add(0, newInterval);
            else if(newInterval.start > intervals.get(intervals.size()-1).end)
                intervals.add(newInterval);
            return intervals;
        }
        
        List<Interval> subList = intervals.subList(start, end+1);
        Interval res = merge(subList, newInterval);
        intervals.subList(start, end+1).clear();
        intervals.add(start, res);
        return intervals;
    }
    
    /**
     * If overlaps 
     * 
     * @param i1
     * @param i2
     * @return
     */
    private boolean overlaps(Interval i1, Interval i2){
        return ((i2.start >= i1.start && i2.start <= i1.end) 
           || (i2.end >= i1.start && i2.end <= i1.end)
            || (i1.start >= i2.start && i1.end <= i2.end)
                || (i2.start >= i1.start && i2.end <= i1.end)
          );
    }
    
    /**
     * Merge a list of intervals(overlapping) with given interval, into 
     * one summarized interval
     *  
     * @param intervals
     * @param newInterval
     * @return
     */
    public Interval merge(List<Interval> intervals, Interval newInterval){
        Interval result = new Interval();
        result.start = Math.min(intervals.get(0).start, newInterval.start);
        result.end = Math.max(intervals.get(intervals.size()-1).end, newInterval.end);
        return result;
    }
    
    /**
     * If inp is completely in between i1 & i2 
     * @param i1
     * @param i2
     * @param inp
     * @return
     */
    private boolean between(Interval i1, Interval i2, Interval inp){
        return (inp.start > i1.end && inp.end < i2.start);
    }
}
