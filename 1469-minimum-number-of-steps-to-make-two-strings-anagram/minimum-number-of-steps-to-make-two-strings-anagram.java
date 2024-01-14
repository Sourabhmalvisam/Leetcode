class Solution {
    public int minSteps(String s, String t) {
      Map<Character,Integer> map=new HashMap<>();
    
      for(int i=0;i<s.length();i++){
         map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
      }  
      
      for(int i=0;i<t.length();i++){
          if(map.containsKey(t.charAt(i))) map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)-1);
      }
      int ans=0;
      for(Map.Entry<Character, Integer> entry:map.entrySet()){
       if(entry.getValue()>0) ans+=entry.getValue();
      }
     return ans;
    
    }
}