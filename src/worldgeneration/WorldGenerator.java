package worldgeneration;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @version 03.07.2017
 * @see startup
 * @since 03.07.2017 , 22:47:13
 *
 */
public interface WorldGenerator {

	public int[][] createWorld(int width, int height);

}
