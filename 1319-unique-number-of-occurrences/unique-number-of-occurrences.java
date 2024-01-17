class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int ele: arr){
            map.put(ele, map.getOrDefault(ele,0)+1);
        }
        Set<Integer> set= new HashSet<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            set.add(entry.getValue());
        }
        return map.size()==set.size();

    }
}