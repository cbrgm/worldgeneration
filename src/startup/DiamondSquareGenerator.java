package startup;

import java.util.Random;

import worldgeneration.WorldGenerator;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @version 04.07.2017
 * @see startup
 * @since 04.07.2017 , 23:09:51
 *
 */
public class DiamondSquareGenerator implements WorldGenerator {

	private int size;
	private int initialCorner;
	private int initialVariance;
	private int varianceDivisor;
	private Random random;

	private int[][] map;

	/**
	 * Konstruktor fuer neue Exemplare der Klasse DiamondSquareGenerator.
	 */
	public DiamondSquareGenerator(int size, int initialCorner, int initialVariance, int varianceDivisor, long seed) {
		this.size = size;
		this.initialCorner = initialCorner;
		this.initialVariance = initialVariance;
		this.varianceDivisor = varianceDivisor;
		this.random = new Random(seed);
	}

	/**
	 * Ueberschreiben der Methode createWorld in der Klasse
	 * DiamondSquareGenerator. Fuer Details zur Implementierung siehe:
	 * 
	 * @see worldgeneration.WorldGenerator#createWorld(int, int)
	 */
	@Override
	public int[][] createWorld(int width, int height) {
		map = new int[size][size];

		// Initialize 4 MapCorners
		map[0][0] = initialCorner; // Top Left
		map[0][size - 1] = initialCorner; // Top Right
		map[size - 1][0] = initialCorner; // Bottom Left
		map[size - 1][size - 1] = initialCorner; // Bottom Right

		// Generate recursively
		// the actual generation
		generateRecursive(0, 0, size - 1, size - 1, initialVariance);

		return map;
	}

	/**
	 * Recursive map generation on the square of genArray specified by startX,
	 * startY, endX, endY
	 * 
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 * @param variance
	 */
	private void generateRecursive(int startX, int startY, int endX, int endY, int variance) {

		// return if square is too small to operate on (algorithm is finished)
		if (endX - startX < 2) {
			return;
		}

		// calculate center coordinates
		int centerX = startX + ((endX - startX) / 2);
		int centerY = startY + ((endY - startY) / 2);

		// set center cell to average of four corners
		int centerAverage = average(getGenArray(startX, startY), getGenArray(startX, endY), getGenArray(endX, startY),
				getGenArray(endX, endY));

		// augment center cell by random between +variance and -variance
		map[centerX][centerY] = centerAverage + ((random.nextInt(20) * variance * 2) - variance);

		int halfDistance = centerX - startX;

		// set the midpoint of each side of the square to an average of the
		// points around it
		averageAround(centerX, startY, halfDistance);
		averageAround(centerX, endY, halfDistance);
		averageAround(startX, centerY, halfDistance);
		averageAround(endX, centerY, halfDistance);

		int newVariance = variance / varianceDivisor;

		// recurse for the 4 quadrants of this square
		generateRecursive(startX, startY, centerX, centerY, newVariance);
		generateRecursive(centerX, startY, endX, centerY, newVariance);
		generateRecursive(startX, centerY, centerX, endY, newVariance);
		generateRecursive(centerX, centerY, endX, endY, newVariance);
	}

	/**
	 * sets the point x,y to the average of the points around it (in diamond
	 * arrangement)
	 */
	private void averageAround(int x, int y, int distanceAway) {
		map[x][y] = average(getGenArray(x + distanceAway, y), getGenArray(x - distanceAway, y),
				getGenArray(x, y + distanceAway), getGenArray(x, y - distanceAway));
	}

	/**
	 * @return the genArray at x,y or initialCorner if out of bounds
	 */
	private int getGenArray(int x, int y) {
		// use same tests for x and y because genArray is assumed to be square
		if ((x > 0) && (y > 0) && (x < map.length) && (y < map.length)) {
			// in bounds
			return map[x][y];
		} else {
			// out of bounds
			// set to corner value
			return initialCorner;
		}
	}

	/**
	 * averages passed in numbers
	 */
	private int average(int... numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum = sum + number;
		}
		return (sum / numbers.length);
	}

}
