/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalanced(root, new Height());
    }
    
    private boolean isBalanced(TreeNode root, Height h){
        if(root == null) {
            h.h = 0;
            return true;
        }
        
        if(root.left == null && root.right == null){
            h.h = 1;
            return true;
        }
        
        Height lh=new Height(), rh=new Height();
        boolean bl = isBalanced(root.left, lh);
        boolean br = isBalanced(root.right, rh);
        h.h = 1 + Math.max(lh.h, rh.h);
        return (bl && br && Math.abs(lh.h - rh.h) <= 1);
    }
}

class Height{
    int h;
}
