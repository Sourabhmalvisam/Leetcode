class Solution {
    public int minEatingSpeed(int[] arr, int h) {
         int low = 1;
        int high = findMax(arr);
        int ans = Integer.MAX_VALUE;
        // Apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalHr = calculateTotalHours(arr, mid);
            if (totalHr <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans; 
    }
      public static int findMax(int[] arr) {
        int maxi = Integer.MIN_VALUE;

        int n = arr.length;
        // Find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        return maxi;
    }

    public static int calculateTotalHours(int[] arr, int hourly) {
        int totalHr = 0;
        int n = arr.length;
        // Find total hours:
        for (int i = 0; i < n; i++) {
            totalHr += Math.ceil((double) arr[i] / hourly); // You have to put (double) else ans will be wrong.
        }
        return totalHr;
    }
}