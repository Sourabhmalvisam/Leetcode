class Solution {
    public int[] rearrangeArray(int[] nums) {
        int posIdx=0;
        int negIdx=1;
        int n=nums.length;
        int [] ans=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                if(posIdx<n)
                ans[posIdx]=nums[i];
                posIdx+=2;
            }
           else if(nums[i]<0){
               if(negIdx<n)
               ans[negIdx]=nums[i];
               negIdx+=2;
            }
        }
        return ans;
    }
}