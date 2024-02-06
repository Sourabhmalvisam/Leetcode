class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character,Integer>,List<String>> bigMap=new HashMap<>();
        for(String str: strs){
           
            Map<Character,Integer> map=new HashMap<>();
            for(char ch: str.toCharArray()){
                map.put(ch, map.getOrDefault(ch,0)+1);
            }
           if(bigMap.containsKey(map)){
               List<String> list=bigMap.get(map);
               list.add(str);
           }
           else {
              List<String> list=new ArrayList<>();
              list.add(str);
              bigMap.put(map,list);
           }



        }
        List<List<String>> ans=new ArrayList<>();
     for(List<String> val: bigMap.values()){
         ans.add(val);
     }
       return ans;
    }
}