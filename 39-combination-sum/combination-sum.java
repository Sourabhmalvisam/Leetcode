class Solution {

	public List < List<Integer>> combinationSum(int[] candidates, int target) {
		List < List<Integer>> ans = new ArrayList<>();
		findCombinations2(0, candidates, target, ans, new ArrayList<>());
		return ans;
	}

	static void findCombinations2(int ind, int[] arr, int target, List < List<Integer>> ans, List<Integer> ds) {
		if (target == 0) {
			ans.add(new ArrayList<>(ds));
			return;
		}

		for (int i = ind; i < arr.length; i++) {
			if (arr[i] <= target) {
				ds.add(arr[i]);
				findCombinations2(i, arr, target - arr[i], ans, ds);
				ds.remove(ds.size() - 1);
			}
		}
	}
}