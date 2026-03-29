package node;
// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
public class IsSymmetricTree {

     public boolean isSymmetric(TreeNode root) {

        if(root == null) return false;

        return helper(root.left,root.right);
    }

     private boolean helper(TreeNode left, TreeNode right) {
      
      if(left == null && right == null) return true;

      if(left == null || right == null ) return false;
        
      if(left.val != right.val) return false;
        
        return helper(left.left, right.right) && helper(left.right, right.left);
     }
     public static void main(String[] args) {
      TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(3), new TreeNode(4)), new TreeNode(2,new TreeNode(4), new TreeNode(3)));
      IsSymmetricTree symmetricTree = new IsSymmetricTree();
      System.out.println(symmetricTree.isSymmetric(root));
     }
}