import java.util.Stack;

public class LevelOrderSpiral {
	Node root;

	public static void main(String[] args) {
		LevelOrderSpiral tree = new LevelOrderSpiral();
		tree.root = new Node(10);
		tree.root.right = new Node(9);
		tree.root.left = new Node(8);
		tree.root.left.left = new Node(7);
		tree.root.left.right = new Node(6);
		// tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(4);
		tree.root.right.right.right = new Node(3);
		tree.root.left.left.left = new Node(2);

		System.out.println("Recursive Method:");
		tree.levelOrderTraversalRecursive(tree.root);

		System.out.println("\nIterative Method:");
		tree.levelOrderTraversalIterative(tree.root);

	}

	private void levelOrderTraversalIterative(Node root) {
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();

		s1.push(root);
		while (!s1.empty() || !s2.empty()) {
			while (!s1.isEmpty()) {
				s1.peek();
				Node top = s1.pop();
				System.out.print(top.data + " ");
				if (top.left != null) {
					s2.push(top.left);
				}
				if (top.right != null) {
					s2.push(top.right);
				}
			}
			while (!s2.isEmpty()) {
				s2.peek();
				Node top = s2.pop();
				System.out.print(top.data + " ");
				if (top.right != null) {
					s1.push(top.right);
				}
				if (top.left != null) {
					s1.push(top.left);
				}
			}
		}

	}

	private void levelOrderTraversalRecursive(Node root) {
		int height = heightOfTree(root);
		boolean leftToRight = true;
		for (int i = 0; i < height; i++) {
			printLevelOrder(root, i, leftToRight);
			leftToRight = !(leftToRight);
		}

	}

	private void printLevelOrder(Node root, int level, boolean leftToRight) {
		if (root == null)
			return;
		if (level == 0)
			System.out.print(root.data + " ");
		else {
			if (leftToRight) {
				printLevelOrder(root.left, level - 1, leftToRight);
				printLevelOrder(root.right, level - 1, leftToRight);
			} else {
				printLevelOrder(root.right, level - 1, leftToRight);
				printLevelOrder(root.left, level - 1, leftToRight);
			}
		}

	}

	private int heightOfTree(Node root) {
		if (root == null) {
			return 0;
		} else
			return Math.max(heightOfTree(root.left) + 1, heightOfTree(root.right) + 1);
	}

}
