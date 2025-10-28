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

class CIDKeyedType2CharStringDiffblueTest {
  /**
   * Method under test: {@link CIDKeyedType2CharString#getCID()}
   */
  @Test
  void testGetCID() {
    // Arrange
    Type1CharStringReader font = mock(Type1CharStringReader.class);

    // Act and Assert
    assertEquals(1, (new CIDKeyedType2CharString(font, "Font Name", 1, 1, new ArrayList<>(), 1, 1)).getCID());
  }

  /**
   * Method under test:
   * {@link CIDKeyedType2CharString#CIDKeyedType2CharString(Type1CharStringReader, String, int, int, List, int, int)}
   */
  @Test
  void testNewCIDKeyedType2CharString() {
    // Arrange
    Type1CharStringReader font = mock(Type1CharStringReader.class);

    // Act
    CIDKeyedType2CharString actualCidKeyedType2CharString = new CIDKeyedType2CharString(font, "Font Name", 1, 1,
        new ArrayList<>(), 1, 1);

    // Assert
    Rectangle2D bounds = actualCidKeyedType2CharString.getBounds();
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    GeneralPath path = actualCidKeyedType2CharString.getPath();
    Rectangle2D bounds2D = path.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    Rectangle2D bounds2D2 = bounds.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertTrue(bounds instanceof Rectangle2D.Float);
    assertEquals("0001", actualCidKeyedType2CharString.getName());
    assertNull(path.getCurrentPoint());
    assertNull(actualCidKeyedType2CharString.getLastSequenceEntry());
    assertEquals(0, actualCidKeyedType2CharString.getWidth());
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
    assertEquals(1, actualCidKeyedType2CharString.getCID());
    assertEquals(1, actualCidKeyedType2CharString.getGID());
    assertTrue(bounds.isEmpty());
    assertTrue(actualCidKeyedType2CharString.isSequenceEmpty());
    assertEquals(bounds, path.getBounds());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, bounds2D2);
  }
}
