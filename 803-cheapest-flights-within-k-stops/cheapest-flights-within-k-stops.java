class Solution {
    // Pair class to represent an edge in the graph
    class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Triple class to represent a step, node, and distance during BFS
    class Triple {
        int steps;
        int node;
        int distance;

        public Triple(int steps, int node, int distance) {
            this.steps = steps;
            this.node = node;
            this.distance = distance;
        }
    }

    public int findCheapestPrice(int n, int[][] edges, int src, int dst, int k) {
        // Adjacency list to represent the graph
        ArrayList<ArrayList<Edge>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Adding edges to the adjacency list
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(new Edge(edge[1], edge[2]));
        }

        // Array to store minimum distances from source to each node
        int[] minDistances = new int[n];
        Arrays.fill(minDistances, Integer.MAX_VALUE);
        minDistances[src] = 0;

        // Queue for BFS traversal
        Queue<Triple> queue = new LinkedList<>();
        queue.offer(new Triple(0, src, 0));

        // BFS traversal
        while (!queue.isEmpty()) {
            Triple front = queue.poll();

            // Check if steps exceed the limit
            if (front.steps > k) {
                continue;
            }

            // Explore neighbors and update minimum distances
            for (Edge neighbor : adjacencyList.get(front.node)) {
                int totalDistance = front.distance + neighbor.weight;

                // Update if the new distance is smaller
                if (totalDistance < minDistances[neighbor.destination] && front.steps <= k) {
                    minDistances[neighbor.destination] = totalDistance;
                    queue.offer(new Triple(front.steps + 1, neighbor.destination, totalDistance));
                }
            }
        }

        // If destination is not reachable, return -1; otherwise, return the minimum distance
        return minDistances[dst] == Integer.MAX_VALUE ? -1 : minDistances[dst];
    }
}
