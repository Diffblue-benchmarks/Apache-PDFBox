package org.apache.pdfbox.tools.imageio;

import static org.junit.jupiter.api.Assertions.assertFalse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ImageIOUtilDiffblueTest {
  /**
   * Test
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float, String)}
   * with {@code image}, {@code formatName}, {@code output}, {@code dpi},
   * {@code compressionQuality}, {@code compressionType}.
   * <p>
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float, String)}
   */
  @Test
  @DisplayName("Test writeImage(BufferedImage, String, OutputStream, int, float, String) with 'image', 'formatName', 'output', 'dpi', 'compressionQuality', 'compressionType'")
  void testWriteImageWithImageFormatNameOutputDpiCompressionQualityCompressionType() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    // Act and Assert
    assertFalse(ImageIOUtil.writeImage(image, "Format Name", new ByteArrayOutputStream(1), 19088743, 10.0f,
        "Compression Type"));
  }

  /**
   * Test
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float)}
   * with {@code image}, {@code formatName}, {@code output}, {@code dpi},
   * {@code compressionQuality}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float)}
   */
  @Test
  @DisplayName("Test writeImage(BufferedImage, String, OutputStream, int, float) with 'image', 'formatName', 'output', 'dpi', 'compressionQuality'; then return 'false'")
  void testWriteImageWithImageFormatNameOutputDpiCompressionQuality_thenReturnFalse() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    // Act and Assert
    assertFalse(ImageIOUtil.writeImage(image, "Format Name", new ByteArrayOutputStream(1), 19088743, 10.0f));
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int)}
   * with {@code image}, {@code formatName}, {@code output}, {@code dpi}.
   * <ul>
   *   <li>When {@code Format Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int)}
   */
  @Test
  @DisplayName("Test writeImage(BufferedImage, String, OutputStream, int) with 'image', 'formatName', 'output', 'dpi'; when 'Format Name'; then return 'false'")
  void testWriteImageWithImageFormatNameOutputDpi_whenFormatName_thenReturnFalse() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    // Act and Assert
    assertFalse(ImageIOUtil.writeImage(image, "Format Name", new ByteArrayOutputStream(1), 19088743));
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)} with
   * {@code image}, {@code formatName}, {@code output}.
   * <ul>
   *   <li>When {@code Format Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)}
   */
  @Test
  @DisplayName("Test writeImage(BufferedImage, String, OutputStream) with 'image', 'formatName', 'output'; when 'Format Name'; then return 'false'")
  void testWriteImageWithImageFormatNameOutput_whenFormatName_thenReturnFalse() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);

    // Act and Assert
    assertFalse(ImageIOUtil.writeImage(image, "Format Name", new ByteArrayOutputStream(1)));
  }
}
