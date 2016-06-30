class Node{
	int data;
	Node left,right;
	public Node(int value){
		data = value; 
		left = null;
		right = null;
	}
}
public class BTtoSumTree {
	Node root;
	public static void main(String[] args){
		BTtoSumTree tree = new BTtoSumTree();
		tree.root = new Node(10);
		tree.root.left = new Node(4);
        tree.root.right = new Node(-12);
        tree.root.left.left = new Node(-2);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(8);
        tree.root.right.right = new Node(6);
        
        tree.inorderTraversal(tree.root);
        System.out.println();
        tree.convertToSumTree(tree.root);
        tree.inorderTraversal(tree.root);
	}
	private int convertToSumTree(Node root) {
		if(root==null)
			return 0;
		int oldValue = root.data;
		root.data = convertToSumTree(root.left) + convertToSumTree(root.right);
		return oldValue+root.data;
	}
	private void inorderTraversal(Node root) {
		if(root==null)
			return;
		inorderTraversal(root.left);
		System.out.print(root.data+" ");
		inorderTraversal(root.right);
	}

}
