package graphs;

public class MaxDepthBinaryTree {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        int currDepth = 0;
        int max = 0;
        return dfsUtil(root, currDepth, max);
    }
    
    public static int dfsUtil(TreeNode root, int currDepth, int max) {
        if(root == null) {
            if(currDepth > max) {
                max = currDepth;
            }
            currDepth = 0;
            return max;
        }
        currDepth++;

        return Math.max(dfsUtil(root.left, currDepth, max), dfsUtil(root.right, currDepth, max));
    }
    
	public static void main(String[] args) {
		MaxDepthBinaryTree x = new MaxDepthBinaryTree();
		TreeNode test = x.new TreeNode(3);
		test.left = x.new TreeNode(9);
		test.right = x.new TreeNode(20);
		test.right.left = x.new TreeNode(15);
		test.right.right = x.new TreeNode(7);
		
		System.out.println(maxDepth(test));

	}

}
