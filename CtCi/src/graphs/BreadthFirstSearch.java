package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void bfs(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			System.out.print(curr.val + "-> ");
			if(curr.left != null) {
				q.add(curr.left);
			} 
			if(curr.right != null) {
				q.add(curr.right);
			} 
		}
	}
	public static void main(String[] args) {
			BreadthFirstSearch x = new BreadthFirstSearch();
			TreeNode test = x.new TreeNode(10);
			test.left = x.new TreeNode(5);
			test.right = x.new TreeNode(15);
			test.right.left = x.new TreeNode(6);
			test.right.right = x.new TreeNode(20);
			bfs(test);
	}
}
