import java.util.LinkedList;
import java.util.Queue;

public class SumLeavesMultiplySums {
	Node root;

	public static void main(String[] args) {
		SumLeavesMultiplySums tree = new SumLeavesMultiplySums();
		tree.root = new Node(2);
		tree.root.left = new Node(7);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(8);
		tree.root.left.right = new Node(6);
		tree.root.left.right.left = new Node(1);
		tree.root.left.right.right = new Node(11);
		tree.root.right.right = new Node(9);
		tree.root.right.right.left = new Node(4);
		tree.root.right.right.right = new Node(10);

		tree.sumAndMultiplyLevelData(tree.root);

	}

	private void sumAndMultiplyLevelData(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int res = 1;
		while (true) {
			int nodeCount = q.size();
			if (nodeCount == 0)
				break;

			boolean leafFound = false;
			int sum = 0;
			while (nodeCount > 0) {
				Node top = q.poll();
				if (isLeaf(top)) {
					leafFound = true;
					sum += top.data;
				}
				if (top.left != null) {
					q.add(top.left);
				}
				if (top.right != null) {
					q.add(top.right);
				}
				nodeCount--;
			}
			if (leafFound) {
				res *= sum;
			}
		}
		System.out.println(res);
	}

	private boolean isLeaf(Node top) {
		if (top.left == null && top.right == null)
			return true;
		else
			return false;
	}

}
