/*
Deepest Leaves Sum
Given the root of a binary tree, return the sum of values of its deepest leaves.
 

Example 1:


Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
Example 2:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 100
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> sums = new ArrayList<>();
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sums.get(sums.size()-1);
    }
    public void dfs(TreeNode node, int lvl) {
        if (lvl == sums.size()) sums.add(node.val);
        else sums.set(lvl, sums.get(lvl) + node.val);
        if (node.left != null) dfs(node.left, lvl+1);
        if (node.right != null) dfs(node.right, lvl+1);
    }
}