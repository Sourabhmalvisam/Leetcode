class Solution {
      public static int binarySearch(int arr[], int ele, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == ele) {
                return mid; // 'ele' found at index 'mid'.
            } else if (ele > arr[mid]) {
                start = mid + 1; // Adjust the search range to the right.
            } else {
                end = mid - 1; // Adjust the search range to the left.
            }
        }
        return -1; // 'ele' not found in the 'arr'.
    }

    // Function to find the index of the minimum element in the rotated array.
    // Returns the index of the minimum element.
    static int findMinElementIndex(int[] arr) {
        int n = arr.length;
        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int next = (mid + 1) % n;
            int prev = (mid + n - 1) % n;

            // Check if the current element is the minimum element in the rotated array.
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid; // Index of the minimum element.
            } else if (arr[mid] <= arr[end]) { // Note: Bhai ye wala if pehle likhna wrna ans nahi ayega.
                end = mid - 1; // Adjust the search range to the left.
            } else if (arr[start] <= arr[mid]) {
                start = mid + 1; // Adjust the search range to the right.
            }
        }
        return -1; // If no rotations are found (unlikely scenario).
    }

    // Function to find an element 'target' in the rotated and sorted array.
    // Returns the index of 'target' if found, otherwise -1.
    public static int findElement(int arr[], int target) {
        int n = arr.length;
        int minIdx = findMinElementIndex(arr); // Find the index of the minimum element.
        int ans1 = binarySearch(arr, target, 0, minIdx - 1); // Search in the left half.
        int ans2 = binarySearch(arr, target, minIdx, n - 1); // minIdx ko inculde karna hai bhai function call me.
        return (ans1 == -1) ? ans2 : ans1; // Return the first valid index found.
    }
    public int search(int[] nums, int target) {
        return findElement(nums, target);
    }
}