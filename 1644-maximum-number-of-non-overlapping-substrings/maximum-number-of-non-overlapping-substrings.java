class Solution {
      public static List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] left = new int[26];
        int[] right = new int[26];
        
        // Initialize left and right arrays with extreme values
        for (int i = 0; i < 26; i++) {
            left[i] = n;
            right[i] = -1;
        }
        
        // Find the leftmost and rightmost positions of each character
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            left[c] = Math.min(left[c], i);
            right[c] = Math.max(right[c], i);
        }
        
        List<String> result = new ArrayList<>();
        int prev = -1; // The right boundary of the previous substring
        
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (i == left[c]) {
                int newRight = getRightBoundary(s, left, right, i);
                if (newRight != -1) {
                    if (i > prev) {
                        result.add(""); // Add an empty string for non-overlapping substrings
                    }
                    prev = newRight;
                    result.set(result.size() - 1, s.substring(i, newRight + 1));
                }
            }
        }
        
        return result;
    }
    
    private static int getRightBoundary(String s, int[] left, int[] right, int start) {
        int newRight = right[s.charAt(start) - 'a'];
        for (int i = start; i <= newRight; i++) {
            if (left[s.charAt(i) - 'a'] < start) {
                return -1; // Cannot form a valid substring
            }
            newRight = Math.max(newRight, right[s.charAt(i) - 'a']);
        }
        return newRight;
    }
}