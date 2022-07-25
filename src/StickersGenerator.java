import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickersGenerator {
  
  public void create(InputStream inputStream, String fileName) throws IOException {
    // Reading image
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
    ImageIO.write(newImage, "png", new File(fileName));

  }
}
