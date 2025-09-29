package algorithm_patterns.tree;


import java.util.ArrayDeque;
import java.util.Deque;

public class LC98ValidateBinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Long> mins = new ArrayDeque<>();
        Deque<Long> maxs = new ArrayDeque<>();

        nodes.offer(root);
        mins.offer(Long.MIN_VALUE);
        maxs.offer(Long.MAX_VALUE);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            long min = mins.poll();
            long max = maxs.poll();

            if (node.val <= min || node.val >= max) {
                return false;
            }

            if (node.left != null) {
                nodes.offer(node.left);
                mins.offer(min);
                maxs.offer((long) node.val);
            }

            if (node.right != null) {
                nodes.offer(node.right);
                mins.offer((long) node.val);
                maxs.offer(max);
            }
        }

        return true;
    }

}
