package org.apache.pdfbox.rendering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.junit.jupiter.api.Test;

class GlyphCacheDiffblueTest {
  /**
   * Method under test: {@link GlyphCache#getPathForCharacterCode(int)}
   */
  @Test
  void testGetPathForCharacterCode() throws IOException {
    // Arrange and Act
    GeneralPath actualPathForCharacterCode = (new GlyphCache(new PDMMType1Font(new COSDictionary())))
        .getPathForCharacterCode(1);

    // Assert
    Rectangle bounds = actualPathForCharacterCode.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPathForCharacterCode.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualPathForCharacterCode.getCurrentPoint());
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(1, actualPathForCharacterCode.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link GlyphCache#getPathForCharacterCode(int)}
   */
  @Test
  void testGetPathForCharacterCode2() throws IOException {
    // Arrange and Act
    GeneralPath actualPathForCharacterCode = (new GlyphCache(new PDTrueTypeFont(new COSDictionary())))
        .getPathForCharacterCode(1);

    // Assert
    Rectangle bounds = actualPathForCharacterCode.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPathForCharacterCode.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualPathForCharacterCode.getCurrentPoint());
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(1, actualPathForCharacterCode.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link GlyphCache#getPathForCharacterCode(int)}
   */
  @Test
  void testGetPathForCharacterCode3() throws IOException {
    // Arrange and Act
    GeneralPath actualPathForCharacterCode = (new GlyphCache(new PDType1CFont(new COSDictionary())))
        .getPathForCharacterCode(1);

    // Assert
    Rectangle bounds = actualPathForCharacterCode.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPathForCharacterCode.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualPathForCharacterCode.getCurrentPoint());
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(1, actualPathForCharacterCode.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }
}
