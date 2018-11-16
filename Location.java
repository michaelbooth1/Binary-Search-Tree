/**
 * Location object stores a x and y coordinate
 * 
 * @author Michael Booth
 */
public class Location {
	private int xCo; // X coordinate of the object
	private int yCo; // Y coordinate of the object

	/*
	 * Constructor sets the x and y coordinates
	 */
	public Location(int x, int y) {
		xCo = x;
		yCo = y;
	}

	/*
	 * Returns the x coordinate
	 */
	public int xCoord() {
		return xCo;
	}

	/*
	 * Returns the y coordinate
	 */
	public int yCoord() {
		return yCo;
	}

	/*
	 * Compares p to this object Returns 1 if this is greater than p object, 0
	 * if equal, -1 if p is greater than this
	 */
	public int compareTo(Location p) {
		if (this.xCoord() < p.xCoord() || (this.xCoord() == p.xCoord() && this.yCoord() < p.yCoord())) {
			return -1;
		} else if (this.xCoord() == p.xCoord() && this.yCoord() == p.yCoord()) {
			return 0;
		} else {
			return 1;
		}
	}
}
