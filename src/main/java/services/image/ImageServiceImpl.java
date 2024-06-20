package services.image;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ImageServiceImpl implements ImageService {

  private static final double ASPECT_RATIO_CORRECTION = 2.0;
  private static final double SCALE_FACTOR = 1.0 / 2.0;

  @Override
  public String convertToASCII(BufferedImage image) {
    StringBuilder stringBuilder = new StringBuilder();
    BufferedImage resized = resizeImage(image);

    for (int y = 0; y < resized.getHeight(); y++) {
      for (int x = 0; x < resized.getWidth(); x++) {
        int pixel = resized.getRGB(x, y);
        int r = (pixel >> 16) & 0xff;
        int g = (pixel >> 8) & 0xff;
        int b = (pixel) & 0xff;
        int brightness = (int) (0.2126 * r + 0.7152 * g + 0.0722 * b);
        char asciiChar = mapBrightnessToASCII(brightness);
        stringBuilder.append(asciiChar);
      }
      stringBuilder.append("\n");
    }
    return stringBuilder.toString();
  }

  @Override
  public void saveToFile(String asciiOutput, File directory) {
    File outputFile = new File(directory, "ascii_art.txt");
    try (FileWriter writer = new FileWriter(outputFile)) {
      writer.write(asciiOutput);
    } catch (IOException exception) {
      System.out.println(exception.getMessage());
    }
  }

  private BufferedImage resizeImage(BufferedImage originalImage) {
    int originalWidth = originalImage.getWidth();
    int originalHeight = originalImage.getHeight();

    int newWidth = (int) (originalWidth * SCALE_FACTOR);
    int newHeight = (int) (originalHeight * SCALE_FACTOR / ASPECT_RATIO_CORRECTION);

    Image resultingImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
    BufferedImage outputImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
    Graphics2D g2d = outputImage.createGraphics();
    g2d.drawImage(resultingImage, 0, 0, null);
    g2d.dispose();

    return outputImage;
  }

  private char mapBrightnessToASCII(int brightness) {
    if (brightness >= 230) {
      return ' '; // Very bright (white)
    } else if (brightness >= 200) {
      return '.'; // Bright
    } else if (brightness >= 150) {
      return ','; // Medium brightness
    } else if (brightness >= 100) {
      return ':'; // Darker
    } else {
      return '@'; // Very dark (black)
    }
  }

}
