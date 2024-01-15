class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
      Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<matches.length;i++){
            int winner=matches[i][0];
            map.put(winner,map.getOrDefault(winner,0));
            int loser=matches[i][1];
            int timesLost=map.getOrDefault(loser,0);
            map.put(loser,timesLost+1);
            

        }
        List<Integer> winner=new ArrayList<>();
        List<Integer> losers=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int key=entry.getKey();
            int value=entry.getValue();
            if(value==0) winner.add(key);
            if(value==1) losers.add(key);
        }
        Collections.sort(winner);
        Collections.sort(losers);
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(winner);
        ans.add(losers);
        return ans;
    }
}