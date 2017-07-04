package startup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @version 04.07.2017
 * @see startup
 * @since 04.07.2017 , 16:03:11
 *
 */
public class RandomIslands implements WorldGenerator {

	/**
	 * Ueberschreiben der Methode createWorld in der Klasse RandomIslands. Fuer
	 * Details zur Implementierung siehe:
	 * 
	 * @see startup.WorldGenerator#createWorld(int, int)
	 */
	@Override
	public int[][] createWorld(int width, int height) {
		int[][] map = new int[width][height];
		List<Coordinate> sparklist = new ArrayList<Coordinate>();

		// Fill the whole map with water
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				map[x][y] = 0;
			}
		}

		Random random = new Random();
		// Create random starting points
		for (int i = 0; i < 1; i++) {
			Coordinate spark = Coordinate.random(width, height);
			map[spark.getX()][spark.getY()] = 1;
			sparklist.add(spark);
		}

		while (!sparklist.isEmpty()) {
			Coordinate c = sparklist.get(random.nextInt(sparklist.size()));
			List<Coordinate> neighbours = c.getNeighbours();

			for (Coordinate neighbour : neighbours) {
				if (!collidesWithBorder(neighbour, width, height))
					if (map[neighbour.getX()][neighbour.getY()] != 1) {
						if (random.nextInt(20) < 5) {
							map[neighbour.getX()][neighbour.getY()] = 1;
							sparklist.add(neighbour);
						}
					}
			}

			sparklist.remove(c);
		}
		
		return map;
	}

	private boolean collidesWithBorder(Coordinate coordinate, int mapwidth, int mapheight) {
		if (coordinate.getX() < 0 || coordinate.getX() >= mapwidth)
			return true;

		if (coordinate.getY() < 0 || coordinate.getY() >= mapheight)
			return true;

		return false;

	}

}
