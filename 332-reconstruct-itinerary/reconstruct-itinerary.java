import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        List<String> res = new ArrayList<>();
        
        for (List<String> ticket : tickets) {
            adj.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            adj.get(ticket.get(0)).offer(ticket.get(1));
        }

        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String cur = stack.peek();
            if (adj.containsKey(cur) && !adj.get(cur).isEmpty()) {
                stack.push(adj.get(cur).poll());
            } else {
                res.add(0, stack.pop());
            }
        }

        return res;
    }
}
