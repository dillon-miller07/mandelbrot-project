
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageGenerator {
	
			public static void main(String[] args) {
		        int width = 800;   // image width
		        int height = 800;  // image height

		        // Complex plane boundaries
		        double xMin = -2.0;
		        double xMax = 1.0;
		        double yMin = -1.5;
		        double yMax = 1.5;

		        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		        // Loop over every pixel
		        for (int x = 0; x < width; x++) {
		            for (int y = 0; y < height; y++) {

		                // Map pixel to complex number
		                double real = xMin + x * (xMax - xMin) / (width - 1);
		                double imaginary = yMax - y * (yMax - yMin) / (height - 1);

		                ComplexNumber c = new ComplexNumber(real, imaginary);
		                int iterations = Mandelbrot.escapeTime(c);

		                int color = getColor(iterations);
		                image.setRGB(x, y, color);
		            }
		        }

		        saveImage(image, "mandelbrot.png");
		        System.out.println("Mandelbrot image saved as mandelbrot.png");
		    }

		    // Converts iterations to RGB color using HSB
		    private static int getColor(int iterations) {
		        if (iterations == Mandelbrot.MAX_ITERATIONS) {
		            return Color.BLACK.getRGB();  // Points inside the set
		        }

		        // Hue cycles through 0..1 depending on iterations
		        float hue = iterations / (float) Mandelbrot.MAX_ITERATIONS;
		        return Color.HSBtoRGB(hue, 1.0f, 1.0f);
		    }

		    // Saves the BufferedImage as a PNG
		    private static void saveImage(BufferedImage image, String filename) {
		        try {
		            ImageIO.write(image, "png", new File(filename));
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		}

