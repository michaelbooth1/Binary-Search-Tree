/**
 * Class that creates a binary search tree to store the storing binary nodes
 * 
 * @author Michael Booth
 */

public class BinarySearchTree implements BinarySearchTreeADT {
	private BinaryNode root; // Holds the root of the tree

	/*
	 * Constructor creates the tree
	 */
	public BinarySearchTree() {
		root = new BinaryNode();
	}

	/*
	 * Returns the node storing the given location, returns null if not in
	 */
	public Pixel get(BinaryNode r, Location key) {
		if (r.getData() == null) {
			return null;
		} else if (r.getData().getLocation().compareTo(key) == 0) {
			return r.getData();
		}

		if (r.getData().getLocation().compareTo(key) == 1) {
			return get(r.getLeft(), key);
		} else {
			return get(r.getRight(), key);
		}
	}

	/*
	 * Puts the given node in the tree, throws exception if already in
	 */
	public void put(BinaryNode r, Pixel data) throws DuplicatedKeyException {
		BinaryNode returnNode = recursivePut(r, data);
		if (returnNode == null) {
			throw new DuplicatedKeyException();
		}
	}

	/*
	 * Recursive method to put the node in the tree
	 */
	private BinaryNode recursivePut(BinaryNode r, Pixel data) {
		if (r.getData() == null) {
			r.setData(data);

			BinaryNode emptyNode1 = new BinaryNode(null, null, null, r);
			r.setLeft(emptyNode1);

			BinaryNode emptyNode2 = new BinaryNode(null, null, null, r);
			r.setRight(emptyNode2);
			return r;
		} else if (r.getData().getLocation().compareTo(data.getLocation()) == 0) {
			return null;
		}

		if (data.getLocation().compareTo(r.getData().getLocation()) == 1) {
			return recursivePut(r.getRight(), data);
		} else {
			return recursivePut(r.getLeft(), data);
		}

	}

	/*
	 * Removes the given node, throws an exception if not in the tree
	 */
	public void remove(BinaryNode r, Location key) throws InexistentKeyException {
		BinaryNode returnNode = recursiveRemove(r, key);
		if (returnNode == null) {
			throw new InexistentKeyException();
		}
	}

	/*
	 * Recursive method to assist the remove method
	 */
	private BinaryNode recursiveRemove(BinaryNode r, Location key) {
		if (r.getData() == null) {
			return null;
		} else if (r.getData().getLocation().compareTo(key) == 0) {
			BinaryNode parentNode = r.getParent();
			if (r.getLeft().getData() == null && r.getRight().getData() != null) {
				BinaryNode rightNode = r.getRight();
				if (parentNode.getLeft().getData().getLocation().compareTo(r.getData().getLocation()) == 0) {
					parentNode.setLeft(rightNode);
				} else {
					parentNode.setRight(rightNode);
				}
				rightNode.setParent(parentNode);

			} else if (r.getRight().getData() == null && r.getLeft().getData() != null) {
				BinaryNode leftNode = r.getLeft();
				if (parentNode.getLeft().getData().getLocation().compareTo(r.getData().getLocation()) == 0) {
					parentNode.setLeft(leftNode);
				} else {
					parentNode.setRight(leftNode);
				}

				leftNode.setParent(parentNode);

			} else if (r.isLeaf()) {
				r.setData(null);
			} else {
				Pixel successorNode = successor(getRoot(), r.getData().getLocation());

				r.setData(successorNode);
				successorNode = null;
			}
			return r;
		}

		if (key.compareTo(r.getData().getLocation()) == 1) {
			return recursiveRemove(r.getRight(), key);
		} else {
			return recursiveRemove(r.getLeft(), key);
		}

	}

	/*
	 * Returns the next node in an inorder traversal
	 */
	public Pixel successor(BinaryNode r, Location key) {
		if (r.getData() == null) {
			r = r.getParent();
			BinaryNode p = r.getParent();
			while (p.getData() != null
					&& r.getData().getLocation().compareTo(p.getRight().getData().getLocation()) == 0) {
				r = p;
				p = p.getParent();
			}
			return p.getData();
		}
		if (key.compareTo(r.getData().getLocation()) == 0) {
			if (r.getRight().getData() != null) {
				r = r.getRight();
				while (r.getLeft().getData() != null) {
					r = r.getLeft();
				}
				return r.getData();
			}
			BinaryNode p = r.getParent();
			while (p.getData() != null
					&& r.getData().getLocation().compareTo(p.getRight().getData().getLocation()) == 0) {
				r = p;
				p = p.getParent();
			}
			return p.getData();
		}

		if (key.compareTo(r.getData().getLocation()) == 1) {
			return successor(r.getRight(), key);
		} else {
			return successor(r.getLeft(), key);
		}

	}

	/*
	 * Returns the previous node in an inorder traversal
	 */
	public Pixel predecessor(BinaryNode r, Location key) {

		if (key.compareTo(r.getData().getLocation()) == 0) {
			if (r.getLeft().getData() != null) {
				r = r.getLeft();
				while (r.getRight().getData() != null) {
					r = r.getRight();
				}
				return r.getData();
			}
			BinaryNode p = r.getParent();

			if (p.getRight().getData() != null) {
				if (p.getRight().getData().getLocation().compareTo(r.getData().getLocation()) == 0) {
					return p.getData();
				}
			}

			while (p.getData() != null
					&& r.getData().getLocation().compareTo(p.getLeft().getData().getLocation()) == 0) {
				r = p;
				p = p.getParent();
			}
			return p.getData();
		}

		if (key.compareTo(r.getData().getLocation()) == 1) {
			return predecessor(r.getRight(), key);
		} else {
			return predecessor(r.getLeft(), key);
		}

	}

	/*
	 * Returns the smallest node in the tree
	 */
	public Pixel smallest(BinaryNode r) throws EmptyTreeException {
		if (r.getData() == null) {
			throw new EmptyTreeException();
		} else if (r.getLeft().getData() == null) {
			return r.getData();
		}

		return smallest(r.getLeft());
	}

	/*
	 * Returns the largest node in the tree
	 */
	public Pixel largest(BinaryNode r) throws EmptyTreeException {
		if (r.getData() == null) {
			throw new EmptyTreeException();
		} else if (r.getRight().getData() == null) {
			return r.getData();
		}

		return largest(r.getRight());
	}

	/*
	 * Returns the root of the tree
	 */
	public BinaryNode getRoot() {
		return root;
	}
}
