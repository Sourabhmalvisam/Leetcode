class Solution {
     public static int[] SlidingWindowMaximum(int arr[], int k) {
         int i = 0;
        int j = 0;
        int n = arr.length;

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        while (j < n) {
            while (list.size() != 0 && list.get(list.size() - 1) < arr[j]) {
                list.remove(list.size() - 1);
            }
            list.add(arr[j]);
            if (j - i + 1 == k) {
                ans.add(list.get(0));
                if (arr[i] == list.get(0)) {
                    list.remove(0);
                }
                i++;
            }
            j++;
        }
           int[] ansArr = new int[ans.size()];
 for(int p=0;p<ans.size();p++){
     ansArr[p]= ans.get(p);}
     return ansArr;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        return SlidingWindowMaximum(nums, k);
    }
}