package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import org.apache.fontbox.type1.Type1CharStringReader;
import org.junit.jupiter.api.Test;

class Type1CharStringDiffblueTest {
  /**
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  void testGetBounds() {
    // Arrange and Act
    Rectangle2D actualBounds = (new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name"))
        .getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    assertTrue(actualBounds instanceof Rectangle2D.Float);
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getHeight());
    assertEquals(0.0d, actualBounds.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinX());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getWidth());
    assertEquals(0.0d, actualBounds.getX());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).height);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).width);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).x);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).y);
    assertTrue(actualBounds.isEmpty());
    assertEquals(actualBounds, actualBounds.getBounds());
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }

  /**
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  void testGetBounds2() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    assertTrue(actualBounds instanceof Rectangle2D.Float);
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getHeight());
    assertEquals(0.0d, actualBounds.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinX());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getWidth());
    assertEquals(0.0d, actualBounds.getX());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).height);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).width);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).x);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).y);
    assertTrue(actualBounds.isEmpty());
    assertEquals(actualBounds, actualBounds.getBounds());
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }

  /**
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  void testGetBounds3() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VSTEM);
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    assertTrue(actualBounds instanceof Rectangle2D.Float);
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getHeight());
    assertEquals(0.0d, actualBounds.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinX());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getWidth());
    assertEquals(0.0d, actualBounds.getX());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).height);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).width);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).x);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).y);
    assertTrue(actualBounds.isEmpty());
    assertEquals(actualBounds, actualBounds.getBounds());
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }

  /**
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  void testGetBounds4() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), null);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    assertTrue(actualBounds instanceof Rectangle2D.Float);
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getHeight());
    assertEquals(0.0d, actualBounds.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinX());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getWidth());
    assertEquals(0.0d, actualBounds.getX());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).height);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).width);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).x);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).y);
    assertTrue(actualBounds.isEmpty());
    assertEquals(actualBounds, actualBounds.getBounds());
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }

  /**
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  void testGetBounds5() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VMOVETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    assertTrue(actualBounds instanceof Rectangle2D.Float);
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getHeight());
    assertEquals(0.0d, actualBounds.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinX());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getWidth());
    assertEquals(0.0d, actualBounds.getX());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).height);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).width);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).x);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).y);
    assertTrue(actualBounds.isEmpty());
    assertEquals(actualBounds, actualBounds.getBounds());
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }

  /**
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  void testGetBounds6() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.RLINETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    assertTrue(actualBounds instanceof Rectangle2D.Float);
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getHeight());
    assertEquals(0.0d, actualBounds.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinX());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getWidth());
    assertEquals(0.0d, actualBounds.getX());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).height);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).width);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).x);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).y);
    assertTrue(actualBounds.isEmpty());
    assertEquals(actualBounds, actualBounds.getBounds());
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }

  /**
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  void testGetBounds7() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HLINETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    assertTrue(actualBounds instanceof Rectangle2D.Float);
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getHeight());
    assertEquals(0.0d, actualBounds.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinX());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getWidth());
    assertEquals(0.0d, actualBounds.getX());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).height);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).width);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).x);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).y);
    assertTrue(actualBounds.isEmpty());
    assertEquals(actualBounds, actualBounds.getBounds());
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }

  /**
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  void testGetBounds8() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VLINETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    assertTrue(actualBounds instanceof Rectangle2D.Float);
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getHeight());
    assertEquals(0.0d, actualBounds.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinX());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getWidth());
    assertEquals(0.0d, actualBounds.getX());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).height);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).width);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).x);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).y);
    assertTrue(actualBounds.isEmpty());
    assertEquals(actualBounds, actualBounds.getBounds());
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }

  /**
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  void testGetBounds9() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));

    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.VMOVETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    assertTrue(actualBounds instanceof Rectangle2D.Float);
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, actualBounds.getHeight());
    assertEquals(0.0d, actualBounds.getMaxX());
    assertEquals(0.0d, actualBounds.getMinX());
    assertEquals(0.0d, actualBounds.getWidth());
    assertEquals(0.0d, actualBounds.getX());
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).height);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).width);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).x);
    assertEquals(1.0d, actualBounds.getCenterY());
    assertEquals(1.0d, actualBounds.getMaxY());
    assertEquals(1.0d, actualBounds.getMinY());
    assertEquals(1.0d, actualBounds.getY());
    assertEquals(1.0f, ((Rectangle2D.Float) actualBounds).y);
    assertTrue(actualBounds.isEmpty());
    assertEquals(actualBounds, actualBounds.getBounds());
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }

  /**
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  void testGetBounds10() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));

    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.HLINETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    assertTrue(actualBounds instanceof Rectangle2D.Float);
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getHeight());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getWidth());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).height);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).width);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).y);
    assertEquals(1.0d, actualBounds.getCenterX());
    assertEquals(1.0d, actualBounds.getMaxX());
    assertEquals(1.0d, actualBounds.getMinX());
    assertEquals(1.0d, actualBounds.getX());
    assertEquals(1.0f, ((Rectangle2D.Float) actualBounds).x);
    assertTrue(actualBounds.isEmpty());
    assertEquals(actualBounds, actualBounds.getBounds());
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }

  /**
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  void testGetBounds11() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));

    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.VLINETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    assertTrue(actualBounds instanceof Rectangle2D.Float);
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, actualBounds.getHeight());
    assertEquals(0.0d, actualBounds.getMaxX());
    assertEquals(0.0d, actualBounds.getMinX());
    assertEquals(0.0d, actualBounds.getWidth());
    assertEquals(0.0d, actualBounds.getX());
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).height);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).width);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).x);
    assertEquals(1.0d, actualBounds.getCenterY());
    assertEquals(1.0d, actualBounds.getMaxY());
    assertEquals(1.0d, actualBounds.getMinY());
    assertEquals(1.0d, actualBounds.getY());
    assertEquals(1.0f, ((Rectangle2D.Float) actualBounds).y);
    assertTrue(actualBounds.isEmpty());
    assertEquals(actualBounds, actualBounds.getBounds());
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }

  /**
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  void testGetBounds12() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.RRCURVETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    assertTrue(actualBounds instanceof Rectangle2D.Float);
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getHeight());
    assertEquals(0.0d, actualBounds.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinX());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getWidth());
    assertEquals(0.0d, actualBounds.getX());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).height);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).width);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).x);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).y);
    assertTrue(actualBounds.isEmpty());
    assertEquals(actualBounds, actualBounds.getBounds());
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }

  /**
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  void testGetBounds13() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.CLOSEPATH);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    assertTrue(actualBounds instanceof Rectangle2D.Float);
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getHeight());
    assertEquals(0.0d, actualBounds.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinX());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getWidth());
    assertEquals(0.0d, actualBounds.getX());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).height);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).width);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).x);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).y);
    assertTrue(actualBounds.isEmpty());
    assertEquals(actualBounds, actualBounds.getBounds());
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }

  /**
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  void testGetBounds14() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));
    numbers.add(Integer.valueOf(1));

    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.RLINETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    assertTrue(actualBounds instanceof Rectangle2D.Float);
    assertEquals(0.0d, actualBounds.getHeight());
    assertEquals(0.0d, actualBounds.getWidth());
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).height);
    assertEquals(0.0f, ((Rectangle2D.Float) actualBounds).width);
    assertEquals(1.0d, actualBounds.getCenterX());
    assertEquals(1.0d, actualBounds.getCenterY());
    assertEquals(1.0d, actualBounds.getMaxX());
    assertEquals(1.0d, actualBounds.getMaxY());
    assertEquals(1.0d, actualBounds.getMinX());
    assertEquals(1.0d, actualBounds.getMinY());
    assertEquals(1.0d, actualBounds.getX());
    assertEquals(1.0d, actualBounds.getY());
    assertEquals(1.0f, ((Rectangle2D.Float) actualBounds).x);
    assertEquals(1.0f, ((Rectangle2D.Float) actualBounds).y);
    assertTrue(actualBounds.isEmpty());
    assertEquals(actualBounds, actualBounds.getBounds());
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }

  /**
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  void testGetWidth() {
    // Arrange, Act and Assert
    assertEquals(0, (new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name")).getWidth());
  }

  /**
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  void testGetWidth2() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  void testGetWidth3() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VSTEM);
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  void testGetWidth4() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), null);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  void testGetWidth5() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VMOVETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  void testGetWidth6() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.RLINETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  void testGetWidth7() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HLINETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  void testGetWidth8() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VLINETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  void testGetWidth9() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));

    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.VMOVETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  void testGetWidth10() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));

    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.HLINETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  void testGetWidth11() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));

    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.VLINETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  void testGetWidth12() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.RRCURVETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  void testGetWidth13() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.CLOSEPATH);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  void testGetWidth14() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));
    numbers.add(Integer.valueOf(1));

    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.RLINETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  void testGetPath() {
    // Arrange and Act
    GeneralPath actualPath = (new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name"))
        .getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualPath.getCurrentPoint());
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
    assertEquals(1, actualPath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  void testGetPath2() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualPath.getCurrentPoint());
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
    assertEquals(1, actualPath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  void testGetPath3() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VSTEM);
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualPath.getCurrentPoint());
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
    assertEquals(1, actualPath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  void testGetPath4() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), null);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualPath.getCurrentPoint());
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
    assertEquals(1, actualPath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  void testGetPath5() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VMOVETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualPath.getCurrentPoint());
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
    assertEquals(1, actualPath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  void testGetPath6() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.RLINETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualPath.getCurrentPoint());
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
    assertEquals(1, actualPath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  void testGetPath7() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HLINETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualPath.getCurrentPoint());
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
    assertEquals(1, actualPath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  void testGetPath8() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VLINETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualPath.getCurrentPoint());
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
    assertEquals(1, actualPath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  void testGetPath9() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    Integer valueOfResult = Integer.valueOf(1);
    numbers.add(valueOfResult);

    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.VMOVETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, currentPoint.getX());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0f, ((Point2D.Float) currentPoint).x);
    int windingRule = actualPath.getWindingRule();
    assertEquals(1, windingRule);
    assertEquals(1.0d, bounds.getY());
    assertEquals(1.0d, currentPoint.getY());
    assertEquals(1.0d, bounds.getCenterY());
    assertEquals(1.0d, bounds.getMaxY());
    assertEquals(1.0d, bounds.getMinY());
    assertEquals(1.0f, ((Point2D.Float) currentPoint).y);
    assertTrue(bounds.isEmpty());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertEquals(currentPoint, bounds.getLocation());
    assertSame(valueOfResult, windingRule);
    assertSame(valueOfResult, bounds.y);
  }

  /**
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  void testGetPath10() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    Integer valueOfResult = Integer.valueOf(1);
    numbers.add(valueOfResult);

    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.HLINETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, currentPoint.getY());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0f, ((Point2D.Float) currentPoint).y);
    int windingRule = actualPath.getWindingRule();
    assertEquals(1, windingRule);
    assertEquals(1.0d, bounds.getX());
    assertEquals(1.0d, currentPoint.getX());
    assertEquals(1.0d, bounds.getCenterX());
    assertEquals(1.0d, bounds.getMaxX());
    assertEquals(1.0d, bounds.getMinX());
    assertEquals(1.0f, ((Point2D.Float) currentPoint).x);
    assertTrue(bounds.isEmpty());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertEquals(currentPoint, bounds.getLocation());
    assertSame(valueOfResult, windingRule);
    assertSame(valueOfResult, bounds.x);
  }

  /**
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  void testGetPath11() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    Integer valueOfResult = Integer.valueOf(1);
    numbers.add(valueOfResult);

    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.VLINETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, currentPoint.getX());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0f, ((Point2D.Float) currentPoint).x);
    int windingRule = actualPath.getWindingRule();
    assertEquals(1, windingRule);
    assertEquals(1.0d, bounds.getY());
    assertEquals(1.0d, currentPoint.getY());
    assertEquals(1.0d, bounds.getCenterY());
    assertEquals(1.0d, bounds.getMaxY());
    assertEquals(1.0d, bounds.getMinY());
    assertEquals(1.0f, ((Point2D.Float) currentPoint).y);
    assertTrue(bounds.isEmpty());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertEquals(currentPoint, bounds.getLocation());
    assertSame(valueOfResult, windingRule);
    assertSame(valueOfResult, bounds.y);
  }

  /**
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  void testGetPath12() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.RRCURVETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualPath.getCurrentPoint());
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
    assertEquals(1, actualPath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  void testGetPath13() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.CLOSEPATH);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, currentPoint.getX());
    assertEquals(0.0d, currentPoint.getY());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(0.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(1, actualPath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertEquals(currentPoint, bounds.getLocation());
  }

  /**
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  void testGetPath14() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));
    Integer valueOfResult = Integer.valueOf(1);
    numbers.add(valueOfResult);

    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.RLINETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    int windingRule = actualPath.getWindingRule();
    assertEquals(1, windingRule);
    assertEquals(1.0d, bounds.getX());
    assertEquals(1.0d, bounds.getY());
    assertEquals(1.0d, currentPoint.getX());
    assertEquals(1.0d, currentPoint.getY());
    assertEquals(1.0d, bounds.getCenterX());
    assertEquals(1.0d, bounds.getCenterY());
    assertEquals(1.0d, bounds.getMaxX());
    assertEquals(1.0d, bounds.getMaxY());
    assertEquals(1.0d, bounds.getMinX());
    assertEquals(1.0d, bounds.getMinY());
    assertEquals(1.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(1.0f, ((Point2D.Float) currentPoint).y);
    assertTrue(bounds.isEmpty());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertEquals(currentPoint, bounds.getLocation());
    assertSame(valueOfResult, windingRule);
    assertSame(valueOfResult, bounds.x);
    assertSame(valueOfResult, bounds.y);
  }

  /**
   * Method under test:
   * {@link Type1CharString#addCommand(List, CharStringCommand)}
   */
  @Test
  void testAddCommand() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");

    // Act
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Assert
    Object lastSequenceEntry = type1CharString.getLastSequenceEntry();
    assertTrue(lastSequenceEntry instanceof CharStringCommand);
    assertEquals(CharStringCommand.HSTEM, lastSequenceEntry);
    assertFalse(type1CharString.isSequenceEmpty());
  }

  /**
   * Method under test:
   * {@link Type1CharString#addCommand(List, CharStringCommand)}
   */
  @Test
  void testAddCommand2() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");

    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));

    // Act
    type1CharString.addCommand(numbers, CharStringCommand.HSTEM);

    // Assert
    Object lastSequenceEntry = type1CharString.getLastSequenceEntry();
    assertTrue(lastSequenceEntry instanceof CharStringCommand);
    assertEquals(CharStringCommand.HSTEM, lastSequenceEntry);
    assertFalse(type1CharString.isSequenceEmpty());
  }

  /**
   * Method under test:
   * {@link Type1CharString#addCommand(List, CharStringCommand)}
   */
  @Test
  void testAddCommand3() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");

    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));
    numbers.add(Integer.valueOf(1));

    // Act
    type1CharString.addCommand(numbers, CharStringCommand.HSTEM);

    // Assert
    Object lastSequenceEntry = type1CharString.getLastSequenceEntry();
    assertTrue(lastSequenceEntry instanceof CharStringCommand);
    assertEquals(CharStringCommand.HSTEM, lastSequenceEntry);
    assertFalse(type1CharString.isSequenceEmpty());
  }

  /**
   * Method under test: {@link Type1CharString#isSequenceEmpty()}
   */
  @Test
  void testIsSequenceEmpty() {
    // Arrange, Act and Assert
    assertTrue((new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name")).isSequenceEmpty());
  }

  /**
   * Method under test: {@link Type1CharString#isSequenceEmpty()}
   */
  @Test
  void testIsSequenceEmpty2() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act and Assert
    assertFalse(type1CharString.isSequenceEmpty());
  }

  /**
   * Method under test: {@link Type1CharString#getLastSequenceEntry()}
   */
  @Test
  void testGetLastSequenceEntry() {
    // Arrange, Act and Assert
    assertNull(
        (new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name")).getLastSequenceEntry());
  }

  /**
   * Method under test: {@link Type1CharString#getLastSequenceEntry()}
   */
  @Test
  void testGetLastSequenceEntry2() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act
    Object actualLastSequenceEntry = type1CharString.getLastSequenceEntry();

    // Assert
    assertTrue(actualLastSequenceEntry instanceof CharStringCommand);
    assertEquals(CharStringCommand.HSTEM, actualLastSequenceEntry);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Type1CharString#toString()}
   *   <li>{@link Type1CharString#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");

    // Act
    String actualToStringResult = type1CharString.toString();

    // Assert
    assertEquals("Glyph Name", type1CharString.getName());
    assertEquals("[]", actualToStringResult);
  }

  /**
   * Method under test:
   * {@link Type1CharString#Type1CharString(Type1CharStringReader, String, String)}
   */
  @Test
  void testNewType1CharString() {
    // Arrange and Act
    Type1CharString actualType1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name",
        "Glyph Name");

    // Assert
    Rectangle2D bounds = actualType1CharString.getBounds();
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    GeneralPath path = actualType1CharString.getPath();
    Rectangle2D bounds2D = path.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    Rectangle2D bounds2D2 = bounds.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertTrue(bounds instanceof Rectangle2D.Float);
    assertEquals("Glyph Name", actualType1CharString.getName());
    assertNull(path.getCurrentPoint());
    assertNull(actualType1CharString.getLastSequenceEntry());
    assertEquals(0, actualType1CharString.getWidth());
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
    assertTrue(bounds.isEmpty());
    assertTrue(actualType1CharString.isSequenceEmpty());
    assertEquals(bounds, path.getBounds());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, bounds2D2);
  }
}
