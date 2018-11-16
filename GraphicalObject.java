/**
 * Creates a graphical object
 * 
 * @author Michael Booth
 */

public class GraphicalObject implements GraphicalObjectADT {
	private int objectId, objectWidth, objectHeight; // Stores the ID, width and
														// height of the object
	private String objectType; // Stores the object type
	private Location objectPos; // Stores the object location
	private BinarySearchTree tree; // Stores the binary tree

	/*
	 * Constructor creates the graphical object
	 */
	public GraphicalObject(int id, int width, int height, String type, Location pos) {
		objectId = id;
		objectWidth = width;
		objectHeight = height;
		objectType = type;
		objectPos = pos;
		tree = new BinarySearchTree();
	}

	/*
	 * Sets the type of the object
	 */
	public void setType(String type) {
		objectType = type;
	}

	/*
	 * Returns the width of the object
	 */
	public int getWidth() {
		return objectWidth;
	}

	/*
	 * Returns the height of the object
	 */
	public int getHeight() {
		return objectHeight;
	}

	/*
	 * Returns the type of the object
	 */
	public String getType() {
		return objectType;
	}

	/*
	 * Returns the ID of the object
	 */
	public int getId() {
		return objectId;
	}

	/*
	 * Returns the objects offset
	 */
	public Location getOffset() {
		return objectPos;
	}

	/*
	 * Sets the objects offset
	 */
	public void setOffset(Location value) {
		objectPos = value;
	}

	/*
	 * Add a pixel to the object
	 */
	public void addPixel(Pixel pix) throws DuplicatedKeyException {
		try {
			tree.put(tree.getRoot(), pix);
		} catch (Exception DuplicatedKeyException) {
			throw new DuplicatedKeyException();
		}
	}

	/*
	 * Checks if the argument intersects with this object
	 */
	public boolean intersects(GraphicalObject gobj) {
		int offsetx = gobj.getOffset().xCoord();
		int offsety = gobj.getOffset().yCoord();
		for (int x = offsetx; x < offsetx + gobj.getWidth(); x++) {
			if (findPixel(new Location(x, offsety)) || findPixel(new Location(x, offsety + gobj.getHeight()))) {
				return true;
			}
		}

		for (int y = offsety; y < offsety + gobj.getHeight(); y++) {
			if (findPixel(new Location(offsetx, y)) || findPixel(new Location(offsetx + gobj.getWidth(), y))) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Helper method for intersects
	 */
	private boolean findPixel(Location p) {
		return (p.xCoord() >= objectPos.xCoord() && p.xCoord() <= (objectPos.xCoord() + objectWidth)
				&& p.yCoord() >= objectPos.yCoord() && p.yCoord() <= (objectPos.yCoord() + objectHeight));
	}
}
