/**
 * Class that creates a node to store pixel values and be used in a BST
 * 
 * @author Michael Booth
 */

public class BinaryNode {
	private Pixel pixelValue; // Pixel value the node stores
	private BinaryNode leftNode; // Nodes left child
	private BinaryNode rightNode; // Nodes right child
	private BinaryNode parentNode; // Nodes parent

	/*
	 * Constructor creates the node and sets the pixel, children and parent
	 */
	public BinaryNode(Pixel value, BinaryNode left, BinaryNode right, BinaryNode parent) {
		pixelValue = value;
		leftNode = left;
		rightNode = right;
		parentNode = parent;
	}

	/*
	 * Constructor creates an empty node
	 */
	public BinaryNode() {
		pixelValue = null;
		leftNode = null;
		rightNode = null;
		parentNode = null;
	}

	/*
	 * Returns the parent node
	 */
	public BinaryNode getParent() {
		return parentNode;
	}

	/*
	 * Sets the parent node
	 */
	public void setParent(BinaryNode parent) {
		parentNode = parent;
	}

	/*
	 * Sets the left child
	 */
	public void setLeft(BinaryNode p) {
		leftNode = p;
	}

	/*
	 * Sets the right child
	 */
	public void setRight(BinaryNode p) {
		rightNode = p;
	}

	/*
	 * Sets the pixel value
	 */
	public void setData(Pixel value) {
		pixelValue = value;
	}

	/*
	 * Checks if the node is a leaf
	 */
	public boolean isLeaf() {
		return (leftNode.getData() == null && rightNode.getData() == null);
	}

	/*
	 * Returns the pixel value
	 */
	public Pixel getData() {
		return pixelValue;
	}

	/*
	 * Returns the left child node
	 */
	public BinaryNode getLeft() {
		return leftNode;
	}

	/*
	 * Returns the right child node
	 */
	public BinaryNode getRight() {
		return rightNode;
	}

}
