package dungeongeneration.worldgeneration;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @version 21.08.2017
 * @see dungeongeneration.worldgeneration
 * @since 21.08.2017 , 10:31:57
 *
 */
public class DungeonGenerator implements WorldGenerator {

	/**
	 * Ueberschreiben der Methode createWorld in der Klasse DungeonGenerator. Fuer
	 * Details zur Implementierung siehe:
	 * 
	 * @see dungeongeneration.worldgeneration.WorldGenerator#createWorld(int, int)
	 */
	@Override
	public double[][] createWorld(int width, int height) {
		double[][] world = new double[width][height];

		//Fill all coordinates with floor
		for (int x = 0; x < world.length; x++) {
			for (int y = 0; y < world[x].length; y++) {
				world[x][y] = Room.WALL.getValue();
			}
		}
		
		// Place random room in center
		
		
		
		

		// TODO Auto-generated method stub
		return world;
	}
	
	/**
	 *  Creates a random room at given coordinates
	 * @param x
	 * @param y
	 */
	private void createRoom(int x, int y) {
		
	}

}
