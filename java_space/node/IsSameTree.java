package node;


public class IsSameTree{
    public boolean isSameTree(TreeNode q , TreeNode p){

      // 1. cả 2 null
    if (p == null && q == null) return true;

    // 2. 1 null, 1 không
    if (p == null || q == null) return false;

    // 3. value khác
    if (p.val != q.val) return false;

    // 4. check left + right
    return isSameTree(p.left, q.left) 
        && isSameTree(p.right, q.right);
    }
}