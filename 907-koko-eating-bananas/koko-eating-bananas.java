class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=findMax(piles);
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(piles,mid,h)) 
                {
                    ans=mid;
                    high=mid-1;
                }
         else low=mid+1;
        }
        return ans;
    }
    public static boolean isPossible(int [] piles, int hourlyRate,int h){
        int timeTaken=0;
        for(int i=0;i<piles.length;i++){
            timeTaken+=Math.ceil(piles[i]/(double)hourlyRate);
        }
        if(timeTaken<=h) return true;
        return false;
    }
    public static int findMax(int [] piles){
        int max=Integer.MIN_VALUE;
        for(int x: piles){
            max=Math.max(x,max);
        }
        return max;
    }
}