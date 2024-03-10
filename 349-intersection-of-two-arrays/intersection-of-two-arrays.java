class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        for(int num: nums1){
            set.add(num);
        }
        List<Integer> ans = new ArrayList<>();
        for(int num: nums2){
            if(set.contains(num))
            {ans.add(num);
            set.remove(num);}
        }

        int arr[] = new int[ans.size()];
        int i=0;
       for(int ele: ans){
           arr[i++]=ele;
       }
        return arr;
    }
}