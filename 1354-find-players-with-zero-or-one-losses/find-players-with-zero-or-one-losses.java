class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
      Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<matches.length;i++){
            int loser=matches[i][1];
            int timesLost=map.getOrDefault(loser,0);
            map.put(loser,timesLost+1);
            

        }
        List<Integer> winners=new ArrayList<>();
        List<Integer> losers=new ArrayList<>();
       for(int i=0;i<matches.length;i++){
           int winner=matches[i][0];
           int loser=matches[i][1];
           if(!map.containsKey(winner)) {winners.add(winner);
           map.put(winner,0);}
           if(map.get(loser)==1) losers.add(loser);
       }
        Collections.sort(winners);
        Collections.sort(losers);
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(winners);
        ans.add(losers);
        return ans;
    }
}