package dungeongeneration.worldgeneration;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Christian Bargmann <christian.bargmann@haw-hamburg.de>
 * @version 21.08.2017
 * @see dungeongeneration.worldgeneration
 * @since 21.08.2017 , 10:08:53
 *
 */
public class MapVisualizer {

	private final int PIXEL_SCALE = 10;

	/**
	 * Visualizes a given Array
	 * 
	 * @param array
	 */
	public void visualize(double[][] array) {
		createMapImage(array, "generatedMap");
	}

	/**
	 * Private Method for viualizing a given array
	 * 
	 * @param array
	 * @param filename
	 */
	private void createMapImage(double[][] array, String filename) {

		System.out.println("Creating MapImage, please wait...");

		int IMAGE_HEIGHT = array.length * PIXEL_SCALE;
		int IMAGE_WIDTH = array[0].length * PIXEL_SCALE;

		System.out.println("Image Width: " + IMAGE_WIDTH + "px");
		System.out.println("Image Height: " + IMAGE_HEIGHT + "px");

		// Constructs a BufferedImage of one of the predefined image types.
		BufferedImage bufferedImage = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
		// Create a graphics which can be used to draw into the buffered image
		Graphics2D g2d = bufferedImage.createGraphics();

		// fill all the image with white
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);

		for (int x = 0; x < array.length; x++) {
			for (int y = 0; y < array[x].length; y++) {

				if (array[x][y] < -0.5) { // Deep Ocean
					g2d.setColor(new Color(1, 38, 119));
					g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);

				} else if (array[x][y] < -0.4) { // Ocean
					g2d.setColor(new Color(0, 91, 197));
					g2d.fillRect(y * PIXEL_SCALE, x * PIXEL_SCALE, PIXEL_SCALE, PIXEL_SCALE);
				}
			}
		}
		// Disposes of this graphics context and releases any system resources
		// that it is using.
		g2d.dispose();

		System.out.printf("Saving MapImage to Disk as %s.png ... \n", filename);
		// Save as PNG
		File file = new File(filename + ".png");
		try {
			ImageIO.write(bufferedImage, "png", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Done! \n");
	}

}
