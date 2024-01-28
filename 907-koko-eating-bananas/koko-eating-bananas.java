class Solution {
    public int timeToEat(int []piles, int rate){
        int hours=0;
        for(int i=0;i<piles.length;i++){
            hours+=Math.ceil(piles[i]/(double)rate);
        }
        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max=(int)-10e8;
        for(int i=0;i<piles.length;i++){
            max=Math.max(max,piles[i]);
        }

        int low=1;
        int high=max;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;

            int timeToEat=timeToEat(piles,mid);
            if(timeToEat<=h){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}