package trees;

public class MaximumDepthBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;

		int currDepth = 0;
		int max = 0;
		return dfsUtil(root, currDepth, max);
	}

	public int dfsUtil(TreeNode root, int currDepth, int max) {
		if (root == null) {
			if (currDepth > max) {
				max = currDepth;
			}
			currDepth = 0;
			return max;
		}
		currDepth++;

		return Math.max(dfsUtil(root.left, currDepth, max), dfsUtil(root.right, currDepth, max));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
