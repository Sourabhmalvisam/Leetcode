class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int a = nums[i];
            int b= target-nums[i];
            if(map.containsKey(b)){
                return new int[]{i,map.get(b)};
            }
            map.put(a,i);
        }
        return new int[]{};
    }
}