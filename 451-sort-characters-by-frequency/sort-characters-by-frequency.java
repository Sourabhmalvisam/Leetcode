import java.util.*;

class Solution {
    public class Pair implements Comparable<Pair> {
        char ch;
        int freq;

        Pair(char c, int f) {
            ch = c;
            freq = f;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(other.freq, this.freq);
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
        }

        List<Pair> pairs = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            pairs.add(new Pair(entry.getKey(), entry.getValue()));
        }

        Collections.sort(pairs);

        StringBuilder ans = new StringBuilder();
        for (Pair pair : pairs) {
            for (int i = 0; i < pair.freq; i++) {
                ans.append(pair.ch);
            }
        }
        return ans.toString();
    }
}
