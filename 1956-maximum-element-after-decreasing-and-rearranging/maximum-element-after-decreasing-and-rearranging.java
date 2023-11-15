class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if(arr[0]!=1) arr[0]=1;
        int ans=arr[0];
        for(int i=1;i<arr.length;i++){
            int diff=Math.abs(arr[i]-arr[i-1]);
            if(diff>1){
                arr[i]=arr[i-1]+1;
            }
            ans=Math.max(ans,arr[i]);
        }
        return ans;
    }
}