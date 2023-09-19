class Solution {
    public int[] twoSum(int[] arr, int target) {
        for(int i=0;i<arr.length;i++){
            int a=arr[i];
            for(int j=i+1;j<arr.length;j++){
                int b=arr[j];
                if(a+b==target) return new int[]{i,j};
            }
        }
        return new int[2];
        
    }
}