package node;
// Given the root of a binary tree, return the inorder traversal of its nodes' values.
import java.util.*;
public class InorderTraversal {
     public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list; 
    }
    private void helper(TreeNode node , List<Integer> list){
        if(node == null) return ;
        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);

    }
}
