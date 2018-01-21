package leetcode;

import java.util.*;

public class Factors {
	static List<List<Integer>> res;

	public static void main(String[] args) {
		res = getFactors(17);
		print(res);
	}

	private static void print(List<List<Integer>> res) {
		for (List<Integer> list : res) {
			for (int l : list)
				System.out.print(l + ", ");
			System.out.println();
		}
	}

	public static List<List<Integer>> getFactors(int n) {
		res = new ArrayList<List<Integer>>();
		DFS(new ArrayList<Integer>(), 2, n);
		return res;
	}

	private static void DFS(List<Integer> curSol, int start, int n) {
		if (n <= 1) {
			res.add(new ArrayList<Integer>(curSol));
			return;
		}

		for (int i = start; i <= n; i++) {
			if (n % i == 0) {
				curSol.add(i);
				DFS(curSol, i, n / i);
				curSol.remove(curSol.size() - 1);
			}
		}
	}
}
