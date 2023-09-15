class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        return Math.max(solve(Arrays.copyOfRange(nums, 1, n)),solve(Arrays.copyOfRange(nums,0,n-1)));
    }
    public static int solve(int arr[]){
        int prev=arr[0];
        int prev2=0;
        for(int i=1;i<arr.length;i++){
            int pick=arr[i];
            if(i>1) pick+=prev2;
            int notPick=prev;
            int cur_i=Math.max(pick,notPick);
            prev2=prev;
            prev=cur_i;
        }
        return prev;
    }
}