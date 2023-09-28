class Solution {

	public int[] sortArrayByParity(int[] nums) {
		int left = 0; // Pointer for even elements
		int right = nums.length - 1; // Pointer for odd elements
		while (left < right) {
			if (nums[left] % 2 == 1 && nums[right] % 2 == 0) {
				// Swap even and odd elements
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
			}

			// Move pointers
			if (nums[left] % 2 == 0) {
				left++;
			}

			if (nums[right] % 2 == 1) {
				right--;
			}
		}

		return nums;
	}

}