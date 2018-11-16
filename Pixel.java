/**
 * Creates a pixel which stores a colour and location
 * 
 * @author Michael Booth
 */
public class Pixel {

	private Location locationKey; // Location of the pixel
	private int pColour; // Colour of the pixel

	/*
	 * Constructor sets the location and colour
	 */
	public Pixel(Location p, int color) {
		locationKey = p;
		pColour = color;
	}

	/*
	 * Returns the location
	 */
	public Location getLocation() {
		return locationKey;
	}

	/*
	 * Returns the colour
	 */
	public int getColor() {
		return pColour;
	}
}
