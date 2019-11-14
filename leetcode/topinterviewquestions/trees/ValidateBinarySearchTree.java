package trees;

public class ValidateBinarySearchTree {
	// Definition for a binary tree node.
	public static boolean isValidBST(TreeNode root) {
		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean helper(TreeNode root, int min, int max) {
		if(root == null) {
			return true;
		}
		
		if(root.val <= min || root.val >= max) {
			return false;
		}
		if(helper(root.left, min, root.val) == false) return false;
		if(helper(root.right, root.val, max) == false) return false;
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
