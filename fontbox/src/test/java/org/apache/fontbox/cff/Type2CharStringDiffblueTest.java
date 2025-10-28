package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import org.apache.fontbox.type1.Type1CharStringReader;
import org.junit.jupiter.api.Test;

class Type2CharStringDiffblueTest {
  /**
   * Method under test: {@link Type2CharString#getGID()}
   */
  @Test
  void testGetGID() {
    // Arrange
    Type1CharStringReader font = mock(Type1CharStringReader.class);

    // Act and Assert
    assertEquals(1, (new Type2CharString(font, "Font Name", "Glyph Name", 1, new ArrayList<>(), 1, 1)).getGID());
  }

  /**
   * Method under test:
   * {@link Type2CharString#Type2CharString(Type1CharStringReader, String, String, int, List, int, int)}
   */
  @Test
  void testNewType2CharString() {
    // Arrange
    Type1CharStringReader font = mock(Type1CharStringReader.class);

    // Act
    Type2CharString actualType2CharString = new Type2CharString(font, "Font Name", "Glyph Name", 1, new ArrayList<>(),
        1, 1);

    // Assert
    Rectangle2D bounds = actualType2CharString.getBounds();
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    GeneralPath path = actualType2CharString.getPath();
    Rectangle2D bounds2D = path.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    Rectangle2D bounds2D2 = bounds.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertTrue(bounds instanceof Rectangle2D.Float);
    assertEquals("Glyph Name", actualType2CharString.getName());
    assertNull(path.getCurrentPoint());
    assertNull(actualType2CharString.getLastSequenceEntry());
    assertEquals(0, actualType2CharString.getWidth());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0f, ((Rectangle2D.Float) bounds).height);
    assertEquals(0.0f, ((Rectangle2D.Float) bounds).width);
    assertEquals(0.0f, ((Rectangle2D.Float) bounds).x);
    assertEquals(0.0f, ((Rectangle2D.Float) bounds).y);
    assertEquals(1, path.getWindingRule());
    assertEquals(1, actualType2CharString.getGID());
    assertTrue(bounds.isEmpty());
    assertTrue(actualType2CharString.isSequenceEmpty());
    assertEquals(bounds, path.getBounds());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, bounds2D2);
  }
}
