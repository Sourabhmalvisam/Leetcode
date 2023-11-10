class Solution {
    public int ladderLength(String startWord, String targetWord, List<String> wordList) {
        // Creating a queue ds of type {word, transitions to reach ‘word’}.
        Queue<Pair> q = new LinkedList<>();

        // BFS traversal with pushing values in queue
        // when after a transformation, a word is found in wordList.
        q.add(new Pair(startWord, 1));

        // Push all values of wordList into a set
        // to make deletion from it easier and in less time complexity.
        Set<String> st = new HashSet<>();
        st.addAll(wordList);

        st.remove(startWord);
        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();

            // we return the steps as soon as
            // the first occurrence of targetWord is found.
            if (word.equals(targetWord)) {
                return steps;
            }

            // Now, replace each character of ‘word’ with char
            // from a-z then check if ‘word’ exists in wordList.
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    // check if it exists in the set and push it in the queue.
                    if (st.contains(replacedWord)) {
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        // If there is no transformation sequence possible
        return 0;
    }
}
class Pair {
    String first;
    int second;

    Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}


