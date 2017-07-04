package startup;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @version 03.07.2017
 * @see
 * @since 03.07.2017 , 22:10:55
 *
 */
public class Startup {

	public static void main(String[] args) {

		WorldGenerator worldgen = new RandomIslands();
		MapImage mi = new MapImage();

		for (int i = 0; i < 5; i++) {
			int[][] array = worldgen.createWorld(500, 500);
			mi.visualize(array, "generatedMap" + i);
		}

	}
}
