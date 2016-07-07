
public class BoundaryNodes {
	Node root;

	public static void main(String[] args) {
		BoundaryNodes tree = new BoundaryNodes();
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

		tree.printBoundary(tree.root);

	}

	private void printBoundary(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			printBoundaryLeft(root.left);
			printLeaves(root.left);
			printLeaves(root.right);
			printBoundaryRight(root.right);
		}
	}

	private void printLeaves(Node root) {
		if (root != null) {
			printLeaves(root.left);
			if (root.left == null && root.right == null) {
				System.out.print(root.data + " ");
			}
			printLeaves(root.right);
		}

	}

	private void printBoundaryRight(Node root) {
		if (root != null) {
			if (root.right != null) {
				printBoundaryRight(root.right);
				System.out.print(root.data + " ");
			} else if (root.left != null) {
				printBoundaryLeft(root.left);
				System.out.print(root.data + " ");
			}
		}
	}

	private void printBoundaryLeft(Node root) {
		if (root != null) {
			if (root.left != null) {
				System.out.print(root.data + " ");
				printBoundaryLeft(root.left);
			} else if (root.right != null) {
				System.out.print(root.data + " ");
				printBoundaryRight(root.right);
			}
		}
	}

}
