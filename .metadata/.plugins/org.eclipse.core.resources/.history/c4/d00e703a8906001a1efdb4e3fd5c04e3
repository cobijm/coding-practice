package trees;

public class ValidateBinarySearchTree {
	// Definition for a binary tree node.
    public static boolean isValidBST(TreeNode root) {
    	
        return helper(root);
    }
    
    public static boolean helper(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.right != null && root.right.val > root.val) {
            helper(root.right);
        }
        if(root.left != null && root.left.val < root.val) {
            helper(root.left);
        }

        return true;
    }
	public static void main(String[] args) {
		TreeNode test = new TreeNode(10);
		test.left = new TreeNode(5);
		test.right = new TreeNode(15);
		test.right.left = new TreeNode(6);
		test.right.right = new TreeNode(20);

		System.out.println(isValidBST(test));
	}

}
