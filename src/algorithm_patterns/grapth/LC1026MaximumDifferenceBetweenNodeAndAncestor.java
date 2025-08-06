package algorithm_patterns.grapth;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
public class LC1026MaximumDifferenceBetweenNodeAndAncestor {
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

    private class State {
        TreeNode node;
        int currentMax;
        int currentMin;

        public State(TreeNode node, int currentMax, int currentMin) {
            this.node = node;
            this.currentMax = currentMax;
            this.currentMin = currentMin;
        }
    }

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        Deque<State> stack = new LinkedList<>();
        stack.push(new State(root, root.val, root.val));
        int maxDiff = 0;
        while (!stack.isEmpty()) {
            var currentState = stack.pop();
            var currentNode = currentState.node;

            var currentMax = currentState.currentMax;
            var currentMin = currentState.currentMin;

            currentMax = Math.max(currentMax, currentNode.val);
            currentMin = Math.min(currentMin, currentNode.val);

            if (currentNode.left == null && currentNode.right == null) {
                maxDiff = Math.max(maxDiff, currentMax - currentMin);
            }

            if (currentNode.left != null) {
                stack.push(new State(currentNode.left, currentMax, currentMin));
            }
            if (currentNode.right != null) {
                stack.push(new State(currentNode.right, currentMax, currentMin));
            }

        }
        return maxDiff;
    }
}
