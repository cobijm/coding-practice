package easy;

import java.util.ArrayList;
import java.util.List;

/*
 * 872. Leaf-Similar Trees
 */

public class LeafSimilar {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> leaves1 = new ArrayList<>();
		List<Integer> leaves2 = new ArrayList<>();
		dfs(root1, leaves1);
		dfs(root2, leaves2);
		return leaves1.equals(leaves2);
	}

	public void dfs(TreeNode node, List<Integer> leafValues) {
		if (node != null) {
			if (node.left == null && node.right == null) {
				leafValues.add(node.val);
			}
			dfs(node.left, leafValues);
			dfs(node.right, leafValues);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeafSimilar x = new LeafSimilar();
		TreeNode test1 = x.new TreeNode(3);
		test1.left = x.new TreeNode(5);
		test1.right = x.new TreeNode(1);
		test1.left.left = x.new TreeNode(6);
		test1.left.right = x.new TreeNode(2);
		test1.right.left = x.new TreeNode(9);
		test1.right.right = x.new TreeNode(8);
		//[3,5,1,6,2,9,8,null,null,7,4]
		//		[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]

	}

}
