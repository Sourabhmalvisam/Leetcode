class Solution {
    public class Pair implements Comparable<Pair>{
        int ele;
        int freq;
        Pair(int e, int f){
            ele=e;
            freq=f;
        }
        @Override
        public int compareTo(Pair o){
            return this.freq-o.freq;
        }
    }
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int ele: arr){
            int count=map.getOrDefault(ele,0);
            map.put(ele,count+1);

        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
      
          
            while(!pq.isEmpty()&&k>0){
                  Pair p=pq.poll();
                    if(p.freq>k){
                        return map.size();
                    }
                    else{
                        k=k-p.freq;
                        map.remove(p.ele);

                    }
            }
           
        
        return map.size();

    }
}