public class TreeNode {

	private String computerName;
	private int[] malwareAnalyses; // This instance variable belongs to detector work that lies outside the scope of the project.
	private TreeNode parent;
	private TreeNode leftChild;
	private TreeNode rightChild;

	private boolean inOrder = false;
	private boolean preOrder = false;
	private boolean postOrder = false;

	public TreeNode(String computerNameValue, TreeNode parentValue, TreeNode leftChildValue, TreeNode rightChildValue) {
		this.computerName = computerNameValue;
		this.parent = parentValue;
		this.leftChild = leftChildValue;
		this.rightChild = rightChildValue;
	}

	public String getComputerName() {
		return computerName;
	}

	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public void insertNewNode(TreeNode currentNode, TreeNode newNode) {
		if (newNode.getComputerName().compareTo(currentNode.getComputerName()) < 0) {
			if (currentNode.getLeftChild() == null) {
				currentNode.setLeftChild(newNode);
				newNode.setParent(currentNode);
			} else {
				insertNewNode(currentNode.getLeftChild(), newNode);
			}
		} else if (newNode.getComputerName().compareTo(currentNode.getComputerName()) > 0) {
			if (currentNode.getRightChild() == null) {
				currentNode.setRightChild(newNode);
				newNode.setParent(currentNode);
			} else {
				insertNewNode(currentNode.getRightChild(), newNode);
			}
		}
	}

	public void analyzeInOrder(TreeNode currentNode) {
		if (!inOrder){
			System.out.println("-------------------------------------------------------------");
			System.out.println("Walking the binary search tree in order.");
			this.inOrder = true;
		}
		if (currentNode != null) {
			analyzeInOrder(currentNode.getLeftChild());
			System.out.println("Analyzing: " + currentNode.getComputerName());
			analyzeInOrder(currentNode.getRightChild());
		}
	}

	public void analyzeInPreOrder(TreeNode currentNode) {
		if (!preOrder){
			System.out.println("-------------------------------------------------------------");
			System.out.println("Walking the binary search tree in pre-order.");
			this.preOrder = true;
		}
		if (currentNode != null) {
			System.out.println("Analyzing: " + currentNode.getComputerName());
			analyzeInPreOrder(currentNode.getLeftChild());
			analyzeInPreOrder(currentNode.getRightChild());
		}
	}

	public void analyzeInPostOrder(TreeNode currentNode) {
		if (!postOrder){
			System.out.println("-------------------------------------------------------------");
			System.out.println("Walking the binary search tree in post-order.");
			this.postOrder = true;
		}
		if (currentNode != null) {
			analyzeInPostOrder(currentNode.getLeftChild());
			analyzeInPostOrder(currentNode.getRightChild());
			System.out.println("Analyzing: " + currentNode.getComputerName());
		}
	}
}