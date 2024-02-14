class Solution {
    public int[] rearrangeArray(int[] nums) {
        int i=0;
        int j=0;
        int k=0;
        int ans[] = new int[nums.length];
        while(i<nums.length&&j<nums.length){
           while(nums[i]<0&&i<nums.length){
               i++;
           }
           while(nums[j]>0&&j<nums.length){
               j++;
           }
           if(k<nums.length)
            ans[k++]=nums[i++];
            if(k<nums.length)
            ans[k++]=nums[j++];

        }
        return ans;
    }
}