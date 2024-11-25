package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DecodeOptionsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DecodeOptions#DecodeOptions()}
   *   <li>{@link DecodeOptions#setFilterSubsampled(boolean)}
   *   <li>{@link DecodeOptions#setSourceRegion(Rectangle)}
   *   <li>{@link DecodeOptions#setSubsamplingOffsetX(int)}
   *   <li>{@link DecodeOptions#setSubsamplingOffsetY(int)}
   *   <li>{@link DecodeOptions#setSubsamplingX(int)}
   *   <li>{@link DecodeOptions#setSubsamplingY(int)}
   *   <li>{@link DecodeOptions#getSourceRegion()}
   *   <li>{@link DecodeOptions#getSubsamplingOffsetX()}
   *   <li>{@link DecodeOptions#getSubsamplingOffsetY()}
   *   <li>{@link DecodeOptions#getSubsamplingX()}
   *   <li>{@link DecodeOptions#getSubsamplingY()}
   *   <li>{@link DecodeOptions#isFilterSubsampled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    DecodeOptions actualDecodeOptions = new DecodeOptions();
    actualDecodeOptions.setFilterSubsampled(true);
    Rectangle sourceRegion = new Rectangle(1, 1);

    actualDecodeOptions.setSourceRegion(sourceRegion);
    actualDecodeOptions.setSubsamplingOffsetX(1);
    actualDecodeOptions.setSubsamplingOffsetY(1);
    actualDecodeOptions.setSubsamplingX(1);
    actualDecodeOptions.setSubsamplingY(1);
    Rectangle actualSourceRegion = actualDecodeOptions.getSourceRegion();
    int actualSubsamplingOffsetX = actualDecodeOptions.getSubsamplingOffsetX();
    int actualSubsamplingOffsetY = actualDecodeOptions.getSubsamplingOffsetY();
    int actualSubsamplingX = actualDecodeOptions.getSubsamplingX();
    int actualSubsamplingY = actualDecodeOptions.getSubsamplingY();

    // Assert that nothing has changed
    assertEquals(1, actualSubsamplingOffsetX);
    assertEquals(1, actualSubsamplingOffsetY);
    assertEquals(1, actualSubsamplingX);
    assertEquals(1, actualSubsamplingY);
    assertTrue(actualDecodeOptions.isFilterSubsampled());
    assertSame(sourceRegion, actualSourceRegion);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DecodeOptions#DecodeOptions(int)}
   *   <li>{@link DecodeOptions#setFilterSubsampled(boolean)}
   *   <li>{@link DecodeOptions#setSourceRegion(Rectangle)}
   *   <li>{@link DecodeOptions#setSubsamplingOffsetX(int)}
   *   <li>{@link DecodeOptions#setSubsamplingOffsetY(int)}
   *   <li>{@link DecodeOptions#setSubsamplingX(int)}
   *   <li>{@link DecodeOptions#setSubsamplingY(int)}
   *   <li>{@link DecodeOptions#getSourceRegion()}
   *   <li>{@link DecodeOptions#getSubsamplingOffsetX()}
   *   <li>{@link DecodeOptions#getSubsamplingOffsetY()}
   *   <li>{@link DecodeOptions#getSubsamplingX()}
   *   <li>{@link DecodeOptions#getSubsamplingY()}
   *   <li>{@link DecodeOptions#isFilterSubsampled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one")
  void testGettersAndSetters_whenOne() {
    // Arrange and Act
    DecodeOptions actualDecodeOptions = new DecodeOptions(1);
    actualDecodeOptions.setFilterSubsampled(true);
    Rectangle sourceRegion = new Rectangle(1, 1);

    actualDecodeOptions.setSourceRegion(sourceRegion);
    actualDecodeOptions.setSubsamplingOffsetX(1);
    actualDecodeOptions.setSubsamplingOffsetY(1);
    actualDecodeOptions.setSubsamplingX(1);
    actualDecodeOptions.setSubsamplingY(1);
    Rectangle actualSourceRegion = actualDecodeOptions.getSourceRegion();
    int actualSubsamplingOffsetX = actualDecodeOptions.getSubsamplingOffsetX();
    int actualSubsamplingOffsetY = actualDecodeOptions.getSubsamplingOffsetY();
    int actualSubsamplingX = actualDecodeOptions.getSubsamplingX();
    int actualSubsamplingY = actualDecodeOptions.getSubsamplingY();

    // Assert that nothing has changed
    assertEquals(1, actualSubsamplingOffsetX);
    assertEquals(1, actualSubsamplingOffsetY);
    assertEquals(1, actualSubsamplingX);
    assertEquals(1, actualSubsamplingY);
    assertTrue(actualDecodeOptions.isFilterSubsampled());
    assertSame(sourceRegion, actualSourceRegion);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link Rectangle#Rectangle(int, int)} with one and one.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DecodeOptions#DecodeOptions(Rectangle)}
   *   <li>{@link DecodeOptions#setFilterSubsampled(boolean)}
   *   <li>{@link DecodeOptions#setSourceRegion(Rectangle)}
   *   <li>{@link DecodeOptions#setSubsamplingOffsetX(int)}
   *   <li>{@link DecodeOptions#setSubsamplingOffsetY(int)}
   *   <li>{@link DecodeOptions#setSubsamplingX(int)}
   *   <li>{@link DecodeOptions#setSubsamplingY(int)}
   *   <li>{@link DecodeOptions#getSourceRegion()}
   *   <li>{@link DecodeOptions#getSubsamplingOffsetX()}
   *   <li>{@link DecodeOptions#getSubsamplingOffsetY()}
   *   <li>{@link DecodeOptions#getSubsamplingX()}
   *   <li>{@link DecodeOptions#getSubsamplingY()}
   *   <li>{@link DecodeOptions#isFilterSubsampled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Rectangle(int, int) with one and one")
  void testGettersAndSetters_whenRectangleWithOneAndOne() {
    // Arrange and Act
    DecodeOptions actualDecodeOptions = new DecodeOptions(new Rectangle(1, 1));
    actualDecodeOptions.setFilterSubsampled(true);
    Rectangle sourceRegion = new Rectangle(1, 1);

    actualDecodeOptions.setSourceRegion(sourceRegion);
    actualDecodeOptions.setSubsamplingOffsetX(1);
    actualDecodeOptions.setSubsamplingOffsetY(1);
    actualDecodeOptions.setSubsamplingX(1);
    actualDecodeOptions.setSubsamplingY(1);
    Rectangle actualSourceRegion = actualDecodeOptions.getSourceRegion();
    int actualSubsamplingOffsetX = actualDecodeOptions.getSubsamplingOffsetX();
    int actualSubsamplingOffsetY = actualDecodeOptions.getSubsamplingOffsetY();
    int actualSubsamplingX = actualDecodeOptions.getSubsamplingX();
    int actualSubsamplingY = actualDecodeOptions.getSubsamplingY();

    // Assert that nothing has changed
    assertEquals(1, actualSubsamplingOffsetX);
    assertEquals(1, actualSubsamplingOffsetY);
    assertEquals(1, actualSubsamplingX);
    assertEquals(1, actualSubsamplingY);
    assertTrue(actualDecodeOptions.isFilterSubsampled());
    assertSame(sourceRegion, actualSourceRegion);
  }

  /**
   * Test {@link DecodeOptions#DecodeOptions(int, int, int, int)}.
   * <p>
   * Method under test: {@link DecodeOptions#DecodeOptions(int, int, int, int)}
   */
  @Test
  @DisplayName("Test new DecodeOptions(int, int, int, int)")
  void testNewDecodeOptions() {
    // Arrange and Act
    DecodeOptions actualDecodeOptions = new DecodeOptions(2, 3, 1, 1);

    // Assert
    Rectangle sourceRegion = actualDecodeOptions.getSourceRegion();
    Rectangle2D bounds2D = sourceRegion.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = sourceRegion.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    assertEquals(0, actualDecodeOptions.getSubsamplingOffsetX());
    assertEquals(0, actualDecodeOptions.getSubsamplingOffsetY());
    assertEquals(1, actualDecodeOptions.getSubsamplingX());
    assertEquals(1, actualDecodeOptions.getSubsamplingY());
    Dimension size = sourceRegion.getSize();
    assertEquals(1, size.height);
    assertEquals(1, size.width);
    assertEquals(1, sourceRegion.height);
    assertEquals(1, sourceRegion.width);
    assertEquals(1.0d, size.getHeight());
    assertEquals(1.0d, size.getWidth());
    assertEquals(1.0d, sourceRegion.getHeight());
    assertEquals(1.0d, sourceRegion.getWidth());
    Point location = sourceRegion.getLocation();
    assertEquals(2, location.x);
    assertEquals(2, sourceRegion.x);
    assertEquals(2.0d, location.getX());
    assertEquals(2.0d, sourceRegion.getX());
    assertEquals(2.0d, sourceRegion.getMinX());
    assertEquals(2.5d, sourceRegion.getCenterX());
    assertEquals(3, location.y);
    assertEquals(3, sourceRegion.y);
    assertEquals(3.0d, location.getY());
    assertEquals(3.0d, sourceRegion.getY());
    assertEquals(3.0d, sourceRegion.getMaxX());
    assertEquals(3.0d, sourceRegion.getMinY());
    assertEquals(3.5d, sourceRegion.getCenterY());
    assertEquals(4.0d, sourceRegion.getMaxY());
    assertFalse(sourceRegion.isEmpty());
    assertFalse(actualDecodeOptions.isFilterSubsampled());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(sourceRegion, sourceRegion.getBounds());
    assertEquals(sourceRegion, bounds2D);
    assertEquals(sourceRegion, frame);
  }
}
