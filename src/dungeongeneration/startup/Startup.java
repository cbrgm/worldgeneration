package dungeongeneration.startup;

import dungeongeneration.worldgeneration.MapVisualizer;
import dungeongeneration.worldgeneration.WorldGenerator;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @version 21.08.2017
 * @see dungeongeneration.startup
 * @since 21.08.2017 , 10:03:52
 *
 */
public class Startup {
	
	/**
	 * Main Method for application startup
	 * @param args
	 */
	public static void main(String[] args) {
		WorldGenerator gen = new worldgen();
	    MapVisualizer visualizer = new MapVisualizer();
		
	}

}
