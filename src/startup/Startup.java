package startup;

import java.util.Random;

import worldgeneration.WorldGenerator;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @version 03.07.2017
 * @see
 * @since 03.07.2017 , 22:10:55
 *
 */
public class Startup {

	public static void main(String[] args) {
		Random r = new Random();
		WorldGenerator worldgen = new DiamondSquareGenerator(1000, 0, 20, 4, r.nextLong());
		MapImage mi = new MapImage();

		for (int i = 0; i < 1; i++) {
			int[][] array = worldgen.createWorld(100, 100);
			mi.visualize(array, "generatedMap" + i);
		}

	}
}
