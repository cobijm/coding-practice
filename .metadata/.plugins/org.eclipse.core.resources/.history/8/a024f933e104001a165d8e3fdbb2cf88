package trees;

public class ValidateBinarySearchTree {
	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
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
		ValidateBinarySearchTree x = new ValidateBinarySearchTree();
		TreeNode test = x.new TreeNode(10);
		test.left = x.new TreeNode(5);
		test.right = x.new TreeNode(15);
		test.right.left = x.new TreeNode(6);
		test.right.right = x.new TreeNode(20);

		System.out.println(isValidBST(test));
	}

}
