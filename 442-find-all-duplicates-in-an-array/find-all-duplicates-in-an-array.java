class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(map.containsKey(num)){
                int freq= map.get(num);
                map.put(num, freq+1);
            }
            else map.put(num, 1);
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()==2) list.add(entry.getKey());
        }
        System.out.print(list);
        return list;
    }
}