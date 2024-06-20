package services.image;

import java.awt.image.BufferedImage;
import java.io.File;

public interface ImageService {

  String convertToASCII(BufferedImage image);

  void saveToFile(String asciiOutput, File directory);


}
