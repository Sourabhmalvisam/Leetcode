class Solution {
    public int lengthOfLongestSubstring(String str) {
         HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int maxLen = 0;
        for (int j = 0; j < str.length(); j++) {
            char ch = str.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.size() == j - i + 1) {
                maxLen = Math.max(maxLen, j - i + 1);
            } else if (map.size() < j - i + 1) {
                while (map.size() < j - i + 1) {
                    char ss = str.charAt(i);
                    map.put(ss, map.get(ss) - 1);
                    if (map.get(ss) == 0) {
                        map.remove(ss);
                    }
                    i++;
                }
            }

        }

        return maxLen;
    }
}