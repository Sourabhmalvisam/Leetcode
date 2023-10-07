class Solution {
    public int searchInsert(int[] arr, int x) {
        int n = arr.length; // Length of the array
        int low = 0;
        int high = n - 1;
        int ans = n; // Default answer: if not found, insert at the end.

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                ans = mid; // Update the potential answer.
                high = mid - 1; // Search in the left half.
            } else {
                low = mid + 1; // Search in the right half.
            }
        }
        return ans;
    }
}
