package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> levelOrder = new ArrayList<>();
		if (root == null) {
			return levelOrder;
		}
		Queue<TreeNode> q = new LinkedList<>();
		int level = 0;

		levelOrder.add(new ArrayList<Integer>());
		levelOrder.get(level).add(root.val);
		q.add(root);
		q.add(null);

		levelOrder.add(new ArrayList<Integer>());
		level++;

		while (!q.isEmpty()) {
			TreeNode node = q.poll();

			if (node == null) {
				level++;
				q.add(null);
				if (q.peek() == null) {
					break;
				} else {
					levelOrder.add(new ArrayList<Integer>());
					continue;
				}
			}

			// levelOrder.get(level).add(node.val);

			if (node.left != null) {
				levelOrder.get(level).add(node.left.val);
				q.add(node.left);
			}

			if (node.right != null) {
				levelOrder.get(level).add(node.right.val);
				q.add(node.right);
			}

		}
		levelOrder.remove(levelOrder.size() - 1);
		return levelOrder;
	}

	public static void main(String[] args) {
		TreeNode test = new TreeNode(3);
		test.left = new TreeNode(9);
		test.right = new TreeNode(20);
		test.right.left = new TreeNode(15);
		test.right.right = new TreeNode(7);

		System.out.println(levelOrder(test));
	}

}
