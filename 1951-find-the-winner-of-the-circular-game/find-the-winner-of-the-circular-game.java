class Solution {
    // Function to find the winner in a Josephus-like game.
    public int findTheWinner(int n, int k) {
        // Create a list representing the circle of people.
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        // Start the Josephus game with initial index 0 and counting interval k.
        solve(0, k, list);
        // Return the position of the winner.
        return list.get(0);
    }
    
    // Recursive function to simulate the Josephus game.
    public static void solve(int idx, int k, ArrayList<Integer> list) {
        // Base case: If there is only one person left, return.
        if (list.size() == 1) {
            return;
        }
        // Calculate the index of the person to be removed.
        idx = (idx + k - 1) % list.size();
        
        // Remove the person at the calculated index.
        list.remove(idx);
        
        // Recursively call the solve function with the updated index and list.
        solve(idx, k, list);
    }
}
