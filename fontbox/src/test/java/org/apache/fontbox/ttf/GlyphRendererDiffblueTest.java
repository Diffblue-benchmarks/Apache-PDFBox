package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.geom.Rectangle2D.Float;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GlyphRendererDiffblueTest {
  /**
   * Test {@link GlyphRenderer#GlyphRenderer(GlyphDescription)}.
   *
   * <p>Method under test: {@link GlyphRenderer#GlyphRenderer(GlyphDescription)}
   */
  @Test
  @DisplayName("Test new GlyphRenderer(GlyphDescription)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyphRenderer.<init>(GlyphDescription)"})
  void testNewGlyphRenderer() {
    // Arrange, Act and Assert
    GeneralPath path = new GlyphRenderer(new GlyfSimpleDescript()).getPath();
    Rectangle bounds = path.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = path.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    assertNull(path.getCurrentPoint());
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
    assertEquals(1, path.getWindingRule());
    assertTrue(bounds.isEmpty());
    Point actualLocation = location.getLocation();
    assertEquals(location, actualLocation);
    Dimension actualSize = size.getSize();
    assertEquals(size, actualSize);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link GlyphRenderer#getPath()}.
   *
   * <ul>
   *   <li>Then Bounds2D return {@link Rectangle2D.Float}.
   * </ul>
   *
   * <p>Method under test: {@link GlyphRenderer#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); then Bounds2D return Float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath GlyphRenderer.getPath()"})
  void testGetPath_thenBounds2DReturnFloat() {
    // Arrange and Act
    GeneralPath actualPath = new GlyphRenderer(new GlyfSimpleDescript()).getPath();

    // Assert
    assertTrue(actualPath.getBounds2D() instanceof Float);
    assertNull(actualPath.getCurrentPoint());
    assertEquals(1, actualPath.getWindingRule());
  }
}
