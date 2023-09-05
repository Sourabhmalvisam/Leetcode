public class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        helper(s, "", ans);
        return ans; // Return the list of letter case permutations.
    }

    public static void helper(String input, String output, List<String> ans) {
        if (input.length() == 0) {
            ans.add(output); // Add the current permutation to the result list.
            return;
        }

        char ch = input.charAt(0);
        input = input.substring(1);

        if (Character.isLetter(ch)) {
            // If the character is a letter, consider both upper and lower case versions.
            char upper = Character.toUpperCase(ch);
            char lower = Character.toLowerCase(ch);
            helper(input, output + upper, ans);
            helper(input, output + lower, ans);
        } else {
            // If the character is not a letter, simply add it to the output.
            helper(input, output + ch, ans);
        }
    }
}