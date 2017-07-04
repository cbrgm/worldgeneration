package startup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @version 04.07.2017
 * @see startup
 * @since 04.07.2017 , 17:19:01
 *
 */
public class Coordinate {

	private int x;
	private int y;

	/**
	 * Konstruktor fuer neue Exemplare der Klasse Coordinate.
	 */
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * 
	 * @param xBorder
	 */
	public static Coordinate random(int xBorder, int yBorder) {
		Random r = new Random();
		return new Coordinate(r.nextInt(xBorder), r.nextInt(yBorder));
	}

	/**
	 * Getter-Methode zu x. Ermöglicht es einem Klienten, den Wert der
	 * Exemplarvariablen x abzufragen.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Setter-Methode zu x. Ermöglicht es dem Klienten, den Wert der
	 * Exemplarvariablen x zu setzen.
	 *
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {

		this.x = x;
	}

	/**
	 * Getter-Methode zu y. Ermöglicht es einem Klienten, den Wert der
	 * Exemplarvariablen y abzufragen.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Setter-Methode zu y. Ermöglicht es dem Klienten, den Wert der
	 * Exemplarvariablen y zu setzen.
	 *
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {

		this.y = y;
	}

	/**
	 * Returns a List of all eight neigbour coordinates of this coordinate
	 * 
	 * @return
	 */
	public List<Coordinate> getNeighbours() {

		List<Coordinate> result = new ArrayList<Coordinate>();

		result.add(new Coordinate(x, y - 1));
		result.add(new Coordinate(x, y + 1));
		result.add(new Coordinate(x - 1, y));
		result.add(new Coordinate(x + 1, y));

		result.add(new Coordinate(x - 1, y + 1));
		result.add(new Coordinate(x + 1, y - 1));
		result.add(new Coordinate(x - 1, y - 1));
		result.add(new Coordinate(x + 1, y - 1));

		return result;
	}

}
