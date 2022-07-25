import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import java.io.File;
// import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class StickersGenerator {
  
  public void create() throws IOException {
    // Reading image
    // InputStream inputStream = new FileInputStream(new File("images/image_cover.jpg"));
    InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BZmJjM2YzOWEtOTYxYi00YjhkLTliMzgtMTA2MTc0NDQ1MDM4XkEyXkFqcGdeQXVyODY5OTk4MA@@.jpg").openStream();
    BufferedImage originalImage = ImageIO.read(inputStream);

    // Create new image in memory (transparent and new size)
    int widthImage = originalImage.getWidth();
    int heightImage = originalImage.getHeight();
    int newhHight = heightImage + 200;
    BufferedImage newImage = new BufferedImage(widthImage, newhHight, BufferedImage.TRANSLUCENT);

    // Copy original image to the new one (in memory)
    Graphics2D graphics = (Graphics2D) newImage.getGraphics();
    graphics.drawImage(originalImage, 0, 0, null);

    // Writing phrase in a new image
    var font = new Font(Font.SANS_SERIF, Font.BOLD,  64);
    graphics.setColor(Color.YELLOW);
    graphics.setFont(font);
    graphics.drawString("MAGNIFIC", 250, newhHight - 75);

    // Writing new image in a file
    ImageIO.write(newImage, "png", new File("exit/sticker.png"));

  }

  public static void main(String[] args) throws IOException {
    var generator = new StickersGenerator();
    generator.create();
  }
}
