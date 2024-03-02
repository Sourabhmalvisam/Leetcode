class Solution {
    public int[] sortedSquares(int[] nums) {
        int i=0;
        int j=nums.length-1;
        Stack<Integer> st=new Stack<>();
        while(i<=j){
       int num1=nums[i]*nums[i];
       int num2=nums[j]*nums[j];
       if(num1>=num2){
           st.push(num1);
           i++;
       }
       else {
           st.push(num2);
           j--;
       }
        }
     int k=0;   
    while(!st.isEmpty()){
      nums[k++]=st.pop();
    }
    return nums;

   
}
  
}