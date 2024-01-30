class Solution {
    class Pair{
        String word;
        int step;
        Pair(String w, int s){
            word=w;
            step=s;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        Set<String> set=new HashSet<>();
        for(String s: wordList){
            set.add(s);
        }
        set.remove(beginWord);
        q.add(new Pair(beginWord,1));

        while(!q.isEmpty()){
            Pair curr=q.poll();
            String word=curr.word;
            int steps=curr.step;
            if(word.equals(endWord)) return steps;
           
           for(int i=0;i<word.length();i++){
                
              for(char ch='a';ch<='z';ch++){
                  char[] wordArr=word.toCharArray();
                  wordArr[i]=ch;
                  String newWord=new String(wordArr);
                  if(set.contains(newWord)){
                      set.remove(newWord);
                      q.add(new Pair(newWord,steps+1));
                  }
              }
               
           }
        }
        return 0;
        
    }
}