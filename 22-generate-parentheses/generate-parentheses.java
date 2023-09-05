class Solution { //Neetcode //LeetcodePatterns //Aditya Verma
    
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        // Start the backtrack process with an empty string and equal open and close counts.
        backtrack(list, "", n, n);
        return list;
    }

    // Backtracking helper function.
    public void backtrack(List<String> list, String str, int open, int close) {
        // Base case: If both open and close counts are zero, add the generated string to the list.
        if (open == 0 && close == 0) {
            list.add(str);
            return;
        }

        // Add an opening parenthesis if there are remaining open parentheses to use.
        if (open > 0)
            backtrack(list, str + "(", open - 1, close);

        // Add a closing parenthesis if there are more open than close parentheses in the current string.
        if (close > open)
            backtrack(list, str + ")", open, close - 1);
    }
}
