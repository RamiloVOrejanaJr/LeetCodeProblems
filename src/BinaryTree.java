public class BinaryTree {

    //Problem 100
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

    //Problem 104
    public int maxDepth(TreeNode root) {

        // Overall concept: add 1 for each node reached, return 1 at base case (no child node)

        //Exception case: tree doesn't exist
        if (root == null){
            return 0;
        }

        //4 cases:
        //I. both children exist - return maximum depth of each child node, return which one is bigger
        if ( (root.left != null) && (root.right != null) ){
            return (Math.max( maxDepth(root.left), maxDepth(root.right) )) + 1;
        }

        //II. only left child exist - return max depth
        if ( (root.left != null) && (root.right == null) ){
            return maxDepth(root.left) + 1;
        }

        //III. only right child exists - return max depth
        if ( (root.left == null) && (root.right != null) ){
            return maxDepth(root.right) + 1;
        }

        //IV. no child exists (base case) - return 1
        if ( (root.left == null) && (root.right == null) ){
            return 1;
        }

        return 0;
    }

    //Problem 111
    //--TODO-- NOT beats 100% time complexity
    public int minDepth(TreeNode root) {
        // Overall concept: add 1 for each node reached, return 1 at base case (no child node)

        //Exception case: tree doesn't exist
        if (root == null){
            return 0;
        }

        //4 cases:
        //I. both children exist - return maximum depth of each child node, return which one is bigger
        if ( (root.left != null) && (root.right != null) ){
            return (Math.min( minDepth(root.left), minDepth(root.right) )) + 1;
        }

        //II. only left child exist - return max depth
        if ( (root.left != null) && (root.right == null) ){
            return minDepth(root.left) + 1;
        }

        //III. only right child exists - return max depth
        if ( (root.left == null) && (root.right != null) ){
            return minDepth(root.right) + 1;
        }

        //IV. no child exists (base case) - return 1
        if ( (root.left == null) && (root.right == null) ){
            return 1;
        }

        return 0;

    }

    //Problem 112
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //Overall concept: keep recursing through path until leaf node is reached, if targetSum - root.val
        //is exactly 0 while on a leaf node, the tree hasPathSum

        //Exception case: if tree doesn't exist
        if (root == null){
            return false;
        }

        //3 cases where the node is not a leaf node
        //I. both children exist
        if ( (root.left != null) && (root.right != null) ){
            return ( hasPathSum(root.left, targetSum - root.val)
                    || hasPathSum(root.right, targetSum - root.val));
        }

        //II. only left child exist
        if ( (root.left != null) && (root.right == null) ){
            return (hasPathSum(root.left, targetSum - root.val));
        }

        //III. only right child exists
        if ( (root.left == null) && (root.right != null) ){
            return (hasPathSum(root.right, targetSum - root.val));
        }

        //1 case where node is a leaf node
        //IV. no child exists (base case) - return 1
        if ( (root.left == null) && (root.right == null) ){
            if ((targetSum - root.val) == 0){
                return true;
            }
        }

        return false;
    }
}
