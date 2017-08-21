package dungeongeneration.worldgeneration;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @version 21.08.2017
 * @see dungeongeneration.worldgeneration
 * @since 21.08.2017 , 13:16:35
 *
 */
public class Room {

	private int left, right, top, bottom;

	/**
	 * Konstruktor fuer neue Exemplare der Klasse Room.
	 * 
	 * @param left
	 * @param right
	 * @param width
	 * @param height
	 */
	public Room(int left, int right, int width, int height) {

	}

	/**
	 * Returns true if room is intersecting another room, false if not
	 * @param room
	 * @return
	 */
	public boolean touches(Room room) {
		return false;
	}

	/**
	 * Returns true if room is intersecting another room, false if not
	 * 
	 * @param room
	 * @param padding
	 * @return
	 */
	public boolean touches(Room room, int padding) {
		return false;
	}

	/**
	 * Getter-Methode zu left. Ermöglicht es einem Klienten, den Wert der
	 * Exemplarvariablen left abzufragen.
	 *
	 * @return the left
	 */
	public int getLeft() {
		return left;
	}

	/**
	 * Getter-Methode zu right. Ermöglicht es einem Klienten, den Wert der
	 * Exemplarvariablen right abzufragen.
	 *
	 * @return the right
	 */
	public int getRight() {
		return right;
	}

	/**
	 * Getter-Methode zu top. Ermöglicht es einem Klienten, den Wert der
	 * Exemplarvariablen top abzufragen.
	 *
	 * @return the top
	 */
	public int getTop() {
		return top;
	}

	/**
	 * Getter-Methode zu bottom. Ermöglicht es einem Klienten, den Wert der
	 * Exemplarvariablen bottom abzufragen.
	 *
	 * @return the bottom
	 */
	public int getBottom() {
		return bottom;
	}

}
