class Solution {
    class Pair implements Comparable<Pair> {
        char ch;
        int freq;
        Pair (char c, int f){
            ch=c;
            freq=f;
        }
        @Override
        public int compareTo(Pair o){
            return this.freq-o.freq;
        }
    }
    public String frequencySort(String s) {
        Map<Character,Integer> map=new HashMap<>();
        char [] charArr=s.toCharArray();
        for(char ch: charArr){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }


        List<Pair> pq= new ArrayList<>();
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        Collections.sort(pq);
        String ans="";
        while(!pq.isEmpty()){
            Pair p=pq.removeLast();
            char ch=p.ch;
            int freq=p.freq;
            while(freq>0){
                ans+=ch;
                freq--;
            }

        }
        return ans;

    }
}