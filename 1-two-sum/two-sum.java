class Solution { //Blind75 //Striver //LeetcodePatterns //Arrays & Hashing
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<>(); // HashMap to store numbers and their indices.
        
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int diff = target - val; // Calculate the difference.
            
            if (hashmap.containsKey(diff)) {
                return new int[] { hashmap.get(diff), i }; // Return indices if difference is found
            }
            
            hashmap.put(val, i); // Add current value to the HashMap
        }
        
        return new int[0]; // Return empty array if no solution is found
    }
}
