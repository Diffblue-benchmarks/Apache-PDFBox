package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.geom.Rectangle2D.Float;
import java.util.ArrayList;
import java.util.List;
import org.apache.fontbox.type1.Type1CharStringReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Type1CharStringDiffblueTest {
  /**
   * Test {@link Type1CharString#Type1CharString(Type1CharStringReader, String, String)}.
   *
   * <p>Method under test: {@link Type1CharString#Type1CharString(Type1CharStringReader, String,
   * String)}
   */
  @Test
  @DisplayName("Test new Type1CharString(Type1CharStringReader, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1CharString.<init>(Type1CharStringReader, String, String)"})
  void testNewType1CharString() {
    // Arrange and Act
    Type1CharString actualType1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");

    // Assert
    assertTrue(actualType1CharString.getBounds() instanceof Float);
    assertEquals("Glyph Name", actualType1CharString.getName());
    assertNull(actualType1CharString.getLastSequenceEntry());
    assertEquals(0, actualType1CharString.getWidth());
    assertTrue(actualType1CharString.isSequenceEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Type1CharString#toString()}
   *   <li>{@link Type1CharString#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Type1CharString.getName()", "String Type1CharString.toString()"})
  void testGettersAndSetters() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");

    // Act
    String actualToStringResult = type1CharString.toString();

    // Assert
    assertEquals("Glyph Name", type1CharString.getName());
    assertEquals("[]", actualToStringResult);
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   *
   * <p>Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Float);
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.0d, bounds2D.getCenterX());
    Rectangle bounds = actualBounds.getBounds();
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, frame.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, bounds2D.getMaxX());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, frame.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxX());
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   *
   * <p>Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds2() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Float);
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.0d, bounds2D.getCenterX());
    Rectangle bounds = actualBounds.getBounds();
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, frame.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, bounds2D.getMaxX());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, frame.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxX());
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   *
   * <p>Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds3() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VSTEM);
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Float);
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.0d, bounds2D.getCenterX());
    Rectangle bounds = actualBounds.getBounds();
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, frame.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, bounds2D.getMaxX());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, frame.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxX());
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   *
   * <p>Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds4() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), null);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Float);
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.0d, bounds2D.getCenterX());
    Rectangle bounds = actualBounds.getBounds();
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, frame.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, bounds2D.getMaxX());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, frame.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxX());
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   *
   * <p>Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds5() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VMOVETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Float);
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.0d, bounds2D.getCenterX());
    Rectangle bounds = actualBounds.getBounds();
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, frame.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, bounds2D.getMaxX());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, frame.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxX());
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   *
   * <p>Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds6() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.RLINETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Float);
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.0d, bounds2D.getCenterX());
    Rectangle bounds = actualBounds.getBounds();
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, frame.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, bounds2D.getMaxX());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, frame.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxX());
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   *
   * <p>Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds7() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HLINETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Float);
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.0d, bounds2D.getCenterX());
    Rectangle bounds = actualBounds.getBounds();
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, frame.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, bounds2D.getMaxX());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, frame.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxX());
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   *
   * <p>Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds8() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VLINETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Float);
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.0d, bounds2D.getCenterX());
    Rectangle bounds = actualBounds.getBounds();
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, frame.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, bounds2D.getMaxX());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, frame.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxX());
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   *
   * <p>Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds9() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.RRCURVETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Float);
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.0d, bounds2D.getCenterX());
    Rectangle bounds = actualBounds.getBounds();
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, frame.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, bounds2D.getMaxX());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, frame.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxX());
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   *
   * <p>Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds10() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));

    Type1CharString type1CharString =
        new Type1CharString(
            mock(Type1CharStringReader.class),
            "rlineTo without initial moveTo in font {}, glyph {}",
            "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.HLINETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Float);
    assertTrue(actualBounds instanceof Float);
    Rectangle actualBounds2 = actualBounds.getBounds();
    assertEquals(actualBounds, actualBounds2);
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   *
   * <p>Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds11() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.CLOSEPATH);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Float);
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.0d, bounds2D.getCenterX());
    Rectangle bounds = actualBounds.getBounds();
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, frame.getCenterX());
    assertEquals(0.0d, actualBounds.getCenterX());
    assertEquals(0.0d, bounds2D.getMaxX());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, frame.getMaxX());
    assertEquals(0.0d, actualBounds.getMaxX());
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   *
   * <ul>
   *   <li>Then Bounds Bounds Bounds Bounds2D return {@link Rectangle}.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds(); then Bounds Bounds Bounds Bounds2D return Rectangle")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds_thenBoundsBoundsBoundsBounds2DReturnRectangle() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));

    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.HLINETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle bounds = actualBounds.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    assertTrue(bounds2.getBounds().getBounds2D() instanceof Rectangle);
    assertTrue(bounds2.getBounds2D() instanceof Rectangle);
    assertTrue(bounds.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2.getFrame() instanceof Double);
    assertTrue(actualBounds.getFrame() instanceof Double);
    assertTrue(actualBounds.getBounds2D() instanceof Float);
    assertTrue(actualBounds instanceof Float);
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   *
   * <ul>
   *   <li>Then return CenterX is {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds(); then return CenterX is '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds_thenReturnCenterXIs05() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));

    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.CLOSEPATH);
    type1CharString.addCommand(numbers, CharStringCommand.HLINETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    assertTrue(actualBounds.getFrame() instanceof Double);
    assertTrue(actualBounds.getBounds2D() instanceof Float);
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.5d, actualBounds.getCenterX());
    assertEquals(1.0d, actualBounds.getWidth());
    assertEquals(1.0f, ((Float) actualBounds).width);
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   *
   * <ul>
   *   <li>Then return CenterY is one.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds(); then return CenterY is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds_thenReturnCenterYIsOne() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));

    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.VMOVETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    assertTrue(actualBounds instanceof Float);
    assertEquals(1.0d, actualBounds.getCenterY());
    assertEquals(1.0d, actualBounds.getMaxY());
    assertEquals(1.0d, actualBounds.getMinY());
    assertEquals(1.0d, actualBounds.getY());
    assertEquals(1.0f, ((Float) actualBounds).y);
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   *
   * <ul>
   *   <li>Then return CenterY is one.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds(); then return CenterY is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds_thenReturnCenterYIsOne2() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));

    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.VLINETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    assertTrue(actualBounds instanceof Float);
    assertEquals(1.0d, actualBounds.getCenterY());
    assertEquals(1.0d, actualBounds.getMaxY());
    assertEquals(1.0d, actualBounds.getMinY());
    assertEquals(1.0d, actualBounds.getY());
    assertEquals(1.0f, ((Float) actualBounds).y);
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   *
   * <p>Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   *
   * <p>Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth2() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   *
   * <p>Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth3() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VSTEM);
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   *
   * <p>Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth4() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), null);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   *
   * <p>Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth5() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VMOVETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   *
   * <p>Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth6() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.RLINETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   *
   * <p>Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth7() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HLINETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   *
   * <p>Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth8() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VLINETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   *
   * <p>Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth9() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.RRCURVETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   *
   * <p>Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth10() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));

    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.VMOVETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   *
   * <p>Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth11() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));

    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.VLINETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   *
   * <p>Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth12() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.CLOSEPATH);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   *
   * <p>Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth13() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));

    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.CLOSEPATH);
    type1CharString.addCommand(numbers, CharStringCommand.HLINETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   *
   * <p>Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth14() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.CLOSEPATH);
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.CLOSEPATH);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   *
   * <p>Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth15() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.CALLSUBR);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add valueOf one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth(); given ArrayList() add valueOf one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth_givenArrayListAddValueOfOne_thenReturnZero() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));

    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.HLINETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   *
   * <p>Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    assertNull(actualPath.getCurrentPoint());
    Dimension size = actualPath.getBounds().getBounds().getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   *
   * <p>Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath2() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    assertNull(actualPath.getCurrentPoint());
    Dimension size = actualPath.getBounds().getBounds().getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   *
   * <p>Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath3() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VSTEM);
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    assertNull(actualPath.getCurrentPoint());
    Dimension size = actualPath.getBounds().getBounds().getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   *
   * <p>Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath4() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), null);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    assertNull(actualPath.getCurrentPoint());
    Dimension size = actualPath.getBounds().getBounds().getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   *
   * <p>Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath5() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VMOVETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    assertNull(actualPath.getCurrentPoint());
    Dimension size = actualPath.getBounds().getBounds().getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   *
   * <p>Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath6() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.RLINETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    assertNull(actualPath.getCurrentPoint());
    Dimension size = actualPath.getBounds().getBounds().getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   *
   * <p>Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath7() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HLINETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    assertNull(actualPath.getCurrentPoint());
    Dimension size = actualPath.getBounds().getBounds().getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   *
   * <p>Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath8() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VLINETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    assertNull(actualPath.getCurrentPoint());
    Dimension size = actualPath.getBounds().getBounds().getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   *
   * <p>Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath9() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.RRCURVETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    assertNull(actualPath.getCurrentPoint());
    Dimension size = actualPath.getBounds().getBounds().getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   *
   * <p>Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath10() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.CALLSUBR);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    assertNull(actualPath.getCurrentPoint());
    Dimension size = actualPath.getBounds().getBounds().getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add valueOf one.
   *   <li>Then return Bounds X is one.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); given ArrayList() add valueOf one; then return Bounds X is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath_givenArrayListAddValueOfOne_thenReturnBoundsXIsOne() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    Integer valueOfResult = Integer.valueOf(1);
    numbers.add(valueOfResult);

    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.HLINETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle2D bounds2D = actualPath.getBounds2D();
    assertTrue(bounds2D instanceof Float);
    Rectangle bounds = actualPath.getBounds();
    assertEquals(1.0d, bounds.getX());
    assertEquals(1.0d, bounds.getCenterX());
    assertEquals(1.0d, bounds2D.getCenterX());
    assertEquals(1.0d, bounds.getMinX());
    assertEquals(1.0d, bounds2D.getMinX());
    assertEquals(1.0d, bounds2D.getX());
    assertEquals(1.0f, ((Float) bounds2D).x);
    assertSame(valueOfResult, bounds.x);
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   *
   * <ul>
   *   <li>Then return Bounds CenterX is {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); then return Bounds CenterX is '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath_thenReturnBoundsCenterXIs05() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    Integer valueOfResult = Integer.valueOf(1);
    numbers.add(valueOfResult);

    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.CLOSEPATH);
    type1CharString.addCommand(numbers, CharStringCommand.HLINETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle2D bounds2D = actualPath.getBounds2D();
    assertTrue(bounds2D instanceof Float);
    Rectangle bounds = actualPath.getBounds();
    assertEquals(0.5d, bounds.getCenterX());
    assertEquals(0.5d, bounds2D.getCenterX());
    assertEquals(1.0d, bounds.getWidth());
    assertEquals(1.0d, bounds2D.getWidth());
    assertEquals(1.0f, ((Float) bounds2D).width);
    assertSame(valueOfResult, bounds.width);
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   *
   * <ul>
   *   <li>Then return Bounds Y is one.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); then return Bounds Y is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath_thenReturnBoundsYIsOne() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    Integer valueOfResult = Integer.valueOf(1);
    numbers.add(valueOfResult);

    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.VMOVETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D bounds2D = actualPath.getBounds2D();
    assertTrue(bounds2D instanceof Float);
    Rectangle bounds = actualPath.getBounds();
    assertEquals(1.0d, bounds.getY());
    assertEquals(1.0d, currentPoint.getY());
    assertEquals(1.0d, bounds.getCenterY());
    assertEquals(1.0d, bounds2D.getCenterY());
    assertEquals(1.0d, bounds.getMaxY());
    assertEquals(1.0d, bounds2D.getMaxY());
    assertEquals(1.0d, bounds.getMinY());
    assertEquals(1.0d, bounds2D.getMinY());
    assertEquals(1.0d, bounds2D.getY());
    assertEquals(1.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(1.0f, ((Float) bounds2D).y);
    assertSame(valueOfResult, bounds.y);
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   *
   * <ul>
   *   <li>Then return Bounds Y is one.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); then return Bounds Y is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath_thenReturnBoundsYIsOne2() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    Integer valueOfResult = Integer.valueOf(1);
    numbers.add(valueOfResult);

    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.VLINETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D bounds2D = actualPath.getBounds2D();
    assertTrue(bounds2D instanceof Float);
    Rectangle bounds = actualPath.getBounds();
    assertEquals(1.0d, bounds.getY());
    assertEquals(1.0d, currentPoint.getY());
    assertEquals(1.0d, bounds.getCenterY());
    assertEquals(1.0d, bounds2D.getCenterY());
    assertEquals(1.0d, bounds.getMaxY());
    assertEquals(1.0d, bounds2D.getMaxY());
    assertEquals(1.0d, bounds.getMinY());
    assertEquals(1.0d, bounds2D.getMinY());
    assertEquals(1.0d, bounds2D.getY());
    assertEquals(1.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(1.0f, ((Float) bounds2D).y);
    assertSame(valueOfResult, bounds.y);
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   *
   * <ul>
   *   <li>Then return CurrentPoint X is zero.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); then return CurrentPoint X is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath_thenReturnCurrentPointXIsZero() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.CLOSEPATH);

    // Act and Assert
    Point2D currentPoint = type1CharString.getPath().getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    assertEquals(0.0d, currentPoint.getX());
    assertEquals(0.0d, currentPoint.getY());
    assertEquals(0.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(0.0f, ((Point2D.Float) currentPoint).y);
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   *
   * <ul>
   *   <li>Then return CurrentPoint X is zero.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); then return CurrentPoint X is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath_thenReturnCurrentPointXIsZero2() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.CLOSEPATH);
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.CLOSEPATH);

    // Act and Assert
    Point2D currentPoint = type1CharString.getPath().getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    assertEquals(0.0d, currentPoint.getX());
    assertEquals(0.0d, currentPoint.getY());
    assertEquals(0.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(0.0f, ((Point2D.Float) currentPoint).y);
  }

  /**
   * Test {@link Type1CharString#addCommand(List, CharStringCommand)}.
   *
   * <ul>
   *   <li>Given valueOf one.
   *   <li>When {@link ArrayList#ArrayList()} add valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharString#addCommand(List, CharStringCommand)}
   */
  @Test
  @DisplayName(
      "Test addCommand(List, CharStringCommand); given valueOf one; when ArrayList() add valueOf one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1CharString.addCommand(List, CharStringCommand)"})
  void testAddCommand_givenValueOfOne_whenArrayListAddValueOfOne() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");

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
   * Test {@link Type1CharString#addCommand(List, CharStringCommand)}.
   *
   * <ul>
   *   <li>Given valueOf one.
   *   <li>When {@link ArrayList#ArrayList()} add valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharString#addCommand(List, CharStringCommand)}
   */
  @Test
  @DisplayName(
      "Test addCommand(List, CharStringCommand); given valueOf one; when ArrayList() add valueOf one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1CharString.addCommand(List, CharStringCommand)"})
  void testAddCommand_givenValueOfOne_whenArrayListAddValueOfOne2() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");

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
   * Test {@link Type1CharString#addCommand(List, CharStringCommand)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharString#addCommand(List, CharStringCommand)}
   */
  @Test
  @DisplayName("Test addCommand(List, CharStringCommand); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1CharString.addCommand(List, CharStringCommand)"})
  void testAddCommand_whenArrayList() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");

    // Act
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Assert
    Object lastSequenceEntry = type1CharString.getLastSequenceEntry();
    assertTrue(lastSequenceEntry instanceof CharStringCommand);
    assertEquals(CharStringCommand.HSTEM, lastSequenceEntry);
    assertFalse(type1CharString.isSequenceEmpty());
  }

  /**
   * Test {@link Type1CharString#isSequenceEmpty()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharString#isSequenceEmpty()}
   */
  @Test
  @DisplayName("Test isSequenceEmpty(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Type1CharString.isSequenceEmpty()"})
  void testIsSequenceEmpty_thenReturnFalse() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act and Assert
    assertFalse(type1CharString.isSequenceEmpty());
  }

  /**
   * Test {@link Type1CharString#isSequenceEmpty()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharString#isSequenceEmpty()}
   */
  @Test
  @DisplayName("Test isSequenceEmpty(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Type1CharString.isSequenceEmpty()"})
  void testIsSequenceEmpty_thenReturnTrue() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");

    // Act and Assert
    assertTrue(type1CharString.isSequenceEmpty());
  }

  /**
   * Test {@link Type1CharString#getLastSequenceEntry()}.
   *
   * <ul>
   *   <li>Then return {@link CharStringCommand}.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharString#getLastSequenceEntry()}
   */
  @Test
  @DisplayName("Test getLastSequenceEntry(); then return CharStringCommand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Type1CharString.getLastSequenceEntry()"})
  void testGetLastSequenceEntry_thenReturnCharStringCommand() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act
    Object actualLastSequenceEntry = type1CharString.getLastSequenceEntry();

    // Assert
    assertTrue(actualLastSequenceEntry instanceof CharStringCommand);
    assertEquals(CharStringCommand.HSTEM, actualLastSequenceEntry);
  }

  /**
   * Test {@link Type1CharString#getLastSequenceEntry()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Type1CharString#getLastSequenceEntry()}
   */
  @Test
  @DisplayName("Test getLastSequenceEntry(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Type1CharString.getLastSequenceEntry()"})
  void testGetLastSequenceEntry_thenReturnNull() {
    // Arrange
    Type1CharString type1CharString =
        new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");

    // Act and Assert
    assertNull(type1CharString.getLastSequenceEntry());
  }
}
