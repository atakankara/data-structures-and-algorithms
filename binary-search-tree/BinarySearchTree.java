public class BinarySearchTree
{
    Node root;


    // Node structure containing the subtrees
	static class Node
	{
		int item;
		Node left;
		Node right;

		public Node(int data){

			this.item = data;
		}
	}

    // Constructor
    public BinarySearchTree(){}

    // Insert new item into the binary tree
    public void insert(int data)
    {
		if (root == null){
			root = new Node(data);
		}else {
			Node temp = root;
			while (temp != null) {
				if (data == temp.item) return;
				if (data > temp.item) {
					if (temp.right == null){
						temp.right = new Node(data);
						break;
					}
					else{
						temp = temp.right;
					}
				} else {
					if (temp.left == null){
						temp.left = new Node(data);
						break;
					}
					else{
						temp = temp.left;
					}
				}
			}
		}
        
    }

    // Check if the tree is balanced or not
    public boolean isBalanced()
    {
        return isBalanced(root);
    }

    public boolean isBalanced(Node node){
		if (node == null) return true;
		if (Math.abs(findHeight(node.left) - findHeight(node.right)) > 1) return false;
		else return isBalanced(node.left) && isBalanced(node.right);
	}

    public int findHeight(Node node){

    	if (node == null)	return -1;
    	else {
    		return Math.max(findHeight(node.left), findHeight(node.right)) + 1;
		}
    }

	// Remove an item from the tree
	public void remove(int item){
    	remove(root, item);
	}

	public Node remove(Node node, int item){
    	if (node == null) return null;
    	if (item > node.item){
    		node.right = remove(node.right, item);
		}else if (item < node.item){
    		node.left = remove(node.left, item);
		}else{
    		if (node.left == null) return node.right;
    		if (node.right == null) return node.left;

    		Node min = node.right;
    		Node parent = min;
    		while (min.left != null){
    			parent = min;
    			min = min.left;
			}

    		node.item = min.item;
    		if (parent == min){
    			node.right = null;
			}else{
				parent.left = min.right;
			}
		}
    	return node;
	}



	
	// Compare two trees. Return true if both trees are same
	public boolean compareTo(BinarySearchTree tree)
	{
		return compareTo(root, tree.root);
	}

	public boolean compareTo(Node node1, Node node2){
    	if (node1 == null && node2 == null) return true;
		if (node1 == null || node2 == null) return false;

		if (node1.item != node2.item) return false;
    	else return compareTo(node1.left, node2.left) && compareTo(node1.right, node2.right);
	}
	
	// Given function to print the tree
	public void printInOrder(Node node)
	{
		if (node != null)
		{
			printInOrder(node.left);
			System.out.print(node.item + " ");
			printInOrder(node.right);
		}
    }
}
