class Nodes{
	int data;
	Nodes left,right;
	
	public Nodes(int value){
		data=value;
		left=null;
		right=null;
	}
}
public class BalancedTree {
	Nodes root;
	public static void main(String args[]){
		BalancedTree bt = new BalancedTree();
		bt.root = new Nodes(10);
		bt.root.left = new Nodes(4);
		bt.root.right = new Nodes(6);
		bt.root.right.right = new Nodes(-6);
		bt.root.left.right = new Nodes(-6);
		bt.root.left.left = new Nodes(-4);
		bt.root.left.right.right = new Nodes(-2);
		System.out.println(bt.isBalanced(bt.root));
	}
	private boolean isBalanced(Nodes root) {
		//boolean isB = false;
		if(root==null)
			return true;
		int leftHeight = findHeight(root.left);
		int rightHeight = findHeight(root.right);
		
		return (Math.abs(rightHeight-leftHeight)<=1 && isBalanced(root.left) && isBalanced(root.right));
		
	}
	private int findHeight(Nodes root) {
		if(root==null)
			return 0;
		else return Math.max(findHeight(root.left)+1, findHeight(root.left)+1);
	}
}
