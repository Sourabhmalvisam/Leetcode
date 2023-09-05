class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        helper(0,nums, list, new ArrayList<>());
        return list;
    }
    public static void helper(int idx, int[]nums,List<List<Integer>>list, List<Integer> tempList){
        if(idx==nums.length){
            list.add(new ArrayList<>(tempList));
            return;
        }
        int ele=nums[idx];
       
        helper(idx+1,nums , list, tempList);
         tempList.add(ele);
         helper(idx+1,nums, list, tempList);
         tempList.remove(tempList.size()-1);
       

    }
}