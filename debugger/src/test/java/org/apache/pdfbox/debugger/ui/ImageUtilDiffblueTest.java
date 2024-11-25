package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ImageUtilDiffblueTest {
  /**
   * Test {@link ImageUtil#getRotatedImage(BufferedImage, int)}.
   * <ul>
   *   <li>When ninety.</li>
   *   <li>Then Data Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtil#getRotatedImage(BufferedImage, int)}
   */
  @Test
  @DisplayName("Test getRotatedImage(BufferedImage, int); when ninety; then Data Bounds Bounds2D return Rectangle")
  void testGetRotatedImage_whenNinety_thenDataBoundsBounds2DReturnRectangle() {
    // Arrange and Act
    BufferedImage actualRotatedImage = ImageUtil.getRotatedImage(new BufferedImage(1, 1, 1), 90);

    // Assert
    Raster data = actualRotatedImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualRotatedImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualRotatedImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link ImageUtil#getRotatedImage(BufferedImage, int)}.
   * <ul>
   *   <li>When one hundred eighty.</li>
   *   <li>Then Data Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtil#getRotatedImage(BufferedImage, int)}
   */
  @Test
  @DisplayName("Test getRotatedImage(BufferedImage, int); when one hundred eighty; then Data Bounds Bounds2D return Rectangle")
  void testGetRotatedImage_whenOneHundredEighty_thenDataBoundsBounds2DReturnRectangle() {
    // Arrange and Act
    BufferedImage actualRotatedImage = ImageUtil.getRotatedImage(new BufferedImage(1, 1, 1), 180);

    // Assert
    Raster data = actualRotatedImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualRotatedImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualRotatedImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link ImageUtil#getRotatedImage(BufferedImage, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtil#getRotatedImage(BufferedImage, int)}
   */
  @Test
  @DisplayName("Test getRotatedImage(BufferedImage, int); when one; then throw IllegalArgumentException")
  void testGetRotatedImage_whenOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ImageUtil.getRotatedImage(new BufferedImage(1, 1, 1), 1));
  }

  /**
   * Test {@link ImageUtil#getRotatedImage(BufferedImage, int)}.
   * <ul>
   *   <li>When three hundred sixty.</li>
   *   <li>Then Data Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtil#getRotatedImage(BufferedImage, int)}
   */
  @Test
  @DisplayName("Test getRotatedImage(BufferedImage, int); when three hundred sixty; then Data Bounds Bounds2D return Rectangle")
  void testGetRotatedImage_whenThreeHundredSixty_thenDataBoundsBounds2DReturnRectangle() {
    // Arrange and Act
    BufferedImage actualRotatedImage = ImageUtil.getRotatedImage(new BufferedImage(1, 1, 1), 360);

    // Assert
    Raster data = actualRotatedImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualRotatedImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualRotatedImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link ImageUtil#getRotatedImage(BufferedImage, int)}.
   * <ul>
   *   <li>When two hundred seventy.</li>
   *   <li>Then Data Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtil#getRotatedImage(BufferedImage, int)}
   */
  @Test
  @DisplayName("Test getRotatedImage(BufferedImage, int); when two hundred seventy; then Data Bounds Bounds2D return Rectangle")
  void testGetRotatedImage_whenTwoHundredSeventy_thenDataBoundsBounds2DReturnRectangle() {
    // Arrange and Act
    BufferedImage actualRotatedImage = ImageUtil.getRotatedImage(new BufferedImage(1, 1, 1), 270);

    // Assert
    Raster data = actualRotatedImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualRotatedImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualRotatedImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }
}
