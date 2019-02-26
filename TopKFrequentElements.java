package leetcode;

import java.util.*;

public class TopKFrequentElements {
	public static void main(String[] args) {
		TopKFrequentElements dem = new TopKFrequentElements();
		int[] nums = {4,1,-1,2,-1,2,3};
		int k = 2;
		List<Integer> list = dem.topKFrequent(nums, k);
		System.out.println(list);
	}
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();

		// Build frequency map
		for (int i = 0; i < nums.length; i++)
			freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);

		// Define PQ
		PriorityQueue<ValFreqNode> pq = new PriorityQueue<ValFreqNode>(new Comparator<ValFreqNode>() {
			public int compare(ValFreqNode n1, ValFreqNode n2) {
				return n1.frequency - n2.frequency;
			}
		});

		// Retain elements with top k frequency into PQ
		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			if (pq.size() < k) {
				pq.add(new ValFreqNode(entry.getKey(), entry.getValue()));
			} else {
				if (pq.peek().frequency < entry.getValue()) {
					pq.remove();
					pq.add(new ValFreqNode(entry.getKey(), entry.getValue()));
				}
			}
		}

		// Convert PQ to List
		List<Integer> result = new ArrayList<Integer>();
		while (pq.isEmpty() == false)
			result.add(pq.remove().val);
		return result;
	}
}

class ValFreqNode {
	int val, frequency;

	ValFreqNode(int v, int f) {
		val = v;
		frequency = f;
	}
}
