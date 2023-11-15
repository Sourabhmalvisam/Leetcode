class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ansList = new ArrayList<>();

        if (root == null)
            return ansList;

        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);

                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);

                subList.add(queue.poll().val);
            }
            ansList.add(subList);

        }
        return ansList;
    }
}