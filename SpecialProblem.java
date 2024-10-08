// TC: O(n) for the helper function and 2*O(n) for finding the path, we are doing twice.
// SC: O(n) for recursive stack and O(h) for path strings which will be height of the tree.

/**
Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 */
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lAnc = helper(root, startValue, destValue);
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();
        path(lAnc, startValue, pathToStart);
        path(lAnc, destValue, pathToDest);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pathToStart.length(); i++) {
            result.append('U');
        }
        result.append(pathToDest);
        return result.toString();
    }
    private boolean path(TreeNode root, int target, StringBuilder subPath){
        if(root == null){
            return false;
        }
        if(root.val == target){
            return true;
        }
        //Left subtree
        subPath.append('L');
        if(path(root.left,target,subPath)){
            return true;
        }
        subPath.deleteCharAt(subPath.length()-1);
        //Right subtree
        subPath.append('R');
        if(path(root.right,target,subPath)){
            return true;
        }
        subPath.deleteCharAt(subPath.length()-1);
        return false;
    }
    private TreeNode helper(TreeNode root, int start, int end){
        if(root == null || root.val == start || root.val == end){
            return root;
        }
        TreeNode left = helper(root.left,start,end);
        TreeNode right = helper(root.right, start, end);
        if(left!=null && right!=null) return root;
        else{
            if(left!=null) return left;
            else return right;
        }
    }
}
