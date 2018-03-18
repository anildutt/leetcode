class Solution {
    /**
     Algo - For each element of nums1, maintian last nums2's index already considered for min_sum.
        The indexIn2 from num2 spans from 0 -> nums2.length-1;
        
        Start with a PQ containing all nodes from nums1, order by sum(nums1[current] + nums2[0]).
        PQ is ordered by min_sum of curElement + indexIn2(=last_index considered from nums2).
        Keep removing min element and add to result, and increment its indexIn2, and insert back.
        If all indexIn2 > nums2.length-1, all sums are already considered for nums1[current] => do not add to PQ.
        
        Repeat this k times.
    **/
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<int[]> result = new ArrayList<int[]>();
        if(nums1.length == 0 || nums2.length == 0) return result;
        PriorityQueue<Node> PQ = new PriorityQueue<Node>();
        for(int i=0; i<nums1.length; i++){
            Node n = new Node(i, nums1, nums2);
            PQ.add(n);
        }
        
        while(PQ.isEmpty() == false && result.size() < k){
            Node n = PQ.remove(); //get min sum element
            result.add(new int[]{nums1[n.indexIn1], nums2[n.indexIn2]});
            if(n.indexIn2 == nums2.length-1) continue; //done with this nums1[curIndex]
            else {
                n.indexIn2++;
                PQ.add(n);
            }
        }
        
        return result;
    }
    
}

class Node implements Comparable<Node>{
    int indexIn1;
    int indexIn2;
    int key;
    int[] nums1;
    int[] nums2;
    
    public Node(int i, int[] n1, int n2[]){ 
        indexIn1 = i; indexIn2 = 0; 
        nums1 = n1;
        nums2 = n2;
    }
    
    public int compareTo(Node o){
        return (nums1[indexIn1] + nums2[indexIn2]) - (nums1[o.indexIn1] + nums2[o.indexIn2]);
    }
}
