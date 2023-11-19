class Solution {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int num: nums) {
			pq.add(num);
		}
		int n = nums.length - k;
		for (int i = 0; i<n; i++) {
			pq.poll();
		}
		return pq.peek();
	}
}