public class Q100SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //Overall concept: both trees are assumed the same until proven wrong
        //therefore the moment on condition returns false, the entire function returns false

        //1. check current nodes
        //1a. check if the current nodes are not null, if only one is null then return false
        if ( (p == null) ^ (q == null) ) return false;

        //1b. if both are not null, check if their values are the same
        if (p != null) {
            if (p.val != q.val) return false;
        }

        //1c. if both are null, return true (only happens on root node)
        if (p == null) return true;

        //2. check children nodes
        //2a. check if both branches have matching non-null children
        if ( (p.left == null) ^ (q.left == null) ) return false;
        if ( (p.right == null) ^ (q.right == null) ) return false;

        //2b. call the function checker on both their children pairs (left and right)
        if (p.left != null) {
            if (!isSameTree(p.left, q.left)) return false;
        }

        if (p.right != null)   {
            if (!isSameTree(p.right, q.right)) return false;
        }
        return true;
    }
}