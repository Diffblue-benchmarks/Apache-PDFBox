package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Point;
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
   * <p>
   * Method under test: {@link Type1CharString#Type1CharString(Type1CharStringReader, String, String)}
   */
  @Test
  @DisplayName("Test new Type1CharString(Type1CharStringReader, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Type1CharString.<init>(Type1CharStringReader, String, String)"})
  void testNewType1CharString() {
    // Arrange and Act
    Type1CharString actualType1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name",
        "Glyph Name");

    // Assert
    assertTrue(actualType1CharString.getBounds() instanceof Float);
    assertEquals("Glyph Name", actualType1CharString.getName());
    assertNull(actualType1CharString.getLastSequenceEntry());
    assertEquals(0, actualType1CharString.getWidth());
    assertTrue(actualType1CharString.isSequenceEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Type1CharString#toString()}
   *   <li>{@link Type1CharString#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Type1CharString.getName()", "String Type1CharString.toString()"})
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
   * Test {@link Type1CharString#getBounds()}.
   * <p>
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds() {
    // Arrange and Act
    Rectangle2D actualBounds = (new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name"))
        .getBounds();

    // Assert
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Float) actualBounds).y);
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   * <p>
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds2() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Float) actualBounds).y);
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   * <p>
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds3() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VSTEM);
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Float) actualBounds).y);
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   * <p>
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds4() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), null);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Float) actualBounds).y);
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   * <p>
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds5() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VMOVETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Float) actualBounds).y);
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   * <p>
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds6() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.RLINETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Float) actualBounds).y);
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   * <p>
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds7() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HLINETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Float) actualBounds).y);
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   * <p>
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds8() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VLINETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Float) actualBounds).y);
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   * <p>
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds9() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.RRCURVETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Float) actualBounds).y);
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   * <p>
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds10() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.CLOSEPATH);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    assertTrue(actualBounds instanceof Float);
    assertEquals(0.0d, actualBounds.getCenterY());
    assertEquals(0.0d, actualBounds.getMaxY());
    assertEquals(0.0d, actualBounds.getMinY());
    assertEquals(0.0d, actualBounds.getY());
    assertEquals(0.0f, ((Float) actualBounds).y);
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   * <ul>
   *   <li>Then return Bounds {@link Rectangle#y} is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds(); then return Bounds y is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds_thenReturnBoundsYIsOne() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));

    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.VMOVETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle bounds = actualBounds.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    assertTrue(bounds2.getBounds().getBounds2D() instanceof Rectangle);
    assertTrue(bounds2.getBounds2D() instanceof Rectangle);
    assertTrue(bounds.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2.getFrame() instanceof Double);
    assertTrue(bounds.getFrame() instanceof Double);
    assertTrue(actualBounds instanceof Float);
    int resultInt = bounds.y;
    assertEquals(1, resultInt);
    assertSame(resultInt, bounds.getLocation().getLocation().y);
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   * <ul>
   *   <li>Then return Bounds {@link Rectangle#y} is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds(); then return Bounds y is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds_thenReturnBoundsYIsOne2() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));

    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.VLINETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle bounds = actualBounds.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    assertTrue(bounds2.getBounds().getBounds2D() instanceof Rectangle);
    assertTrue(bounds2.getBounds2D() instanceof Rectangle);
    assertTrue(bounds.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2.getFrame() instanceof Double);
    assertTrue(bounds.getFrame() instanceof Double);
    assertTrue(actualBounds instanceof Float);
    int resultInt = bounds.y;
    assertEquals(1, resultInt);
    assertSame(resultInt, bounds.getLocation().getLocation().y);
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   * <ul>
   *   <li>Then return Bounds {@link Rectangle#y} is valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds(); then return Bounds y is valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds_thenReturnBoundsYIsValueOfOne() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));
    Integer valueOfResult = Integer.valueOf(1);
    numbers.add(valueOfResult);

    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.RLINETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    Rectangle bounds = actualBounds.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    assertTrue(bounds2.getBounds().getBounds2D() instanceof Rectangle);
    assertTrue(bounds2.getBounds2D() instanceof Rectangle);
    assertTrue(bounds.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2.getFrame() instanceof Double);
    assertTrue(bounds.getFrame() instanceof Double);
    assertTrue(actualBounds instanceof Float);
    assertSame(valueOfResult, bounds.y);
  }

  /**
   * Test {@link Type1CharString#getBounds()}.
   * <ul>
   *   <li>Then return CenterX is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharString#getBounds()}
   */
  @Test
  @DisplayName("Test getBounds(); then return CenterX is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Rectangle2D Type1CharString.getBounds()"})
  void testGetBounds_thenReturnCenterXIsOne() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    numbers.add(Integer.valueOf(1));

    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.HLINETO);

    // Act
    Rectangle2D actualBounds = type1CharString.getBounds();

    // Assert
    assertTrue(actualBounds instanceof Float);
    assertEquals(1.0d, actualBounds.getCenterX());
    assertEquals(1.0d, actualBounds.getMaxX());
    assertEquals(1.0d, actualBounds.getMinX());
    assertEquals(1.0d, actualBounds.getX());
    assertEquals(1.0f, ((Float) actualBounds).x);
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   * <p>
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth() {
    // Arrange, Act and Assert
    assertEquals(0, (new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name")).getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   * <p>
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth2() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   * <p>
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth3() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VSTEM);
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   * <p>
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth4() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), null);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   * <p>
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth5() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VMOVETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   * <p>
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth6() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.RLINETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   * <p>
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth7() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HLINETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   * <p>
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth8() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VLINETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   * <p>
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
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
   * Test {@link Type1CharString#getWidth()}.
   * <p>
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
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
   * Test {@link Type1CharString#getWidth()}.
   * <p>
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
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
   * Test {@link Type1CharString#getWidth()}.
   * <p>
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth12() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.RRCURVETO);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   * <p>
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
  void testGetWidth13() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.CLOSEPATH);

    // Act and Assert
    assertEquals(0, type1CharString.getWidth());
  }

  /**
   * Test {@link Type1CharString#getWidth()}.
   * <p>
   * Method under test: {@link Type1CharString#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Type1CharString.getWidth()"})
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
   * Test {@link Type1CharString#getPath()}.
   * <p>
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath() {
    // Arrange and Act
    GeneralPath actualPath = (new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name"))
        .getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    assertTrue(bounds2.getBounds2D() instanceof Rectangle);
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2.getFrame() instanceof Double);
    assertNull(actualPath.getCurrentPoint());
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   * <p>
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath2() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    assertTrue(bounds2.getBounds2D() instanceof Rectangle);
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2.getFrame() instanceof Double);
    assertNull(actualPath.getCurrentPoint());
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   * <p>
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath3() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VSTEM);
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    assertTrue(bounds2.getBounds2D() instanceof Rectangle);
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2.getFrame() instanceof Double);
    assertNull(actualPath.getCurrentPoint());
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   * <p>
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath4() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), null);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    assertTrue(bounds2.getBounds2D() instanceof Rectangle);
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2.getFrame() instanceof Double);
    assertNull(actualPath.getCurrentPoint());
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   * <p>
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath5() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VMOVETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    assertTrue(bounds2.getBounds2D() instanceof Rectangle);
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2.getFrame() instanceof Double);
    assertNull(actualPath.getCurrentPoint());
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   * <p>
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath6() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.RLINETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    assertTrue(bounds2.getBounds2D() instanceof Rectangle);
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2.getFrame() instanceof Double);
    assertNull(actualPath.getCurrentPoint());
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   * <p>
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath7() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HLINETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    assertTrue(bounds2.getBounds2D() instanceof Rectangle);
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2.getFrame() instanceof Double);
    assertNull(actualPath.getCurrentPoint());
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   * <p>
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath8() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.VLINETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    assertTrue(bounds2.getBounds2D() instanceof Rectangle);
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2.getFrame() instanceof Double);
    assertNull(actualPath.getCurrentPoint());
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   * <p>
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath9() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.RRCURVETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    assertTrue(bounds2.getBounds2D() instanceof Rectangle);
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2.getFrame() instanceof Double);
    assertNull(actualPath.getCurrentPoint());
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   * <ul>
   *   <li>Then return Bounds X is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); then return Bounds X is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath_thenReturnBoundsXIsOne() {
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
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D bounds2D = actualPath.getBounds2D();
    assertTrue(bounds2D instanceof Float);
    Rectangle bounds = actualPath.getBounds();
    assertEquals(1.0d, bounds.getX());
    assertEquals(1.0d, currentPoint.getX());
    assertEquals(1.0d, bounds.getCenterX());
    assertEquals(1.0d, bounds2D.getCenterX());
    assertEquals(1.0d, bounds.getMaxX());
    assertEquals(1.0d, bounds2D.getMaxX());
    assertEquals(1.0d, bounds.getMinX());
    assertEquals(1.0d, bounds2D.getMinX());
    assertEquals(1.0d, bounds2D.getX());
    assertEquals(1.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(1.0f, ((Float) bounds2D).x);
    assertSame(valueOfResult, bounds.x);
  }

  /**
   * Test {@link Type1CharString#getPath()}.
   * <ul>
   *   <li>Then return Bounds Y is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); then return Bounds Y is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath_thenReturnBoundsYIsOne() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    Integer valueOfResult = Integer.valueOf(1);
    numbers.add(valueOfResult);

    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
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
   * <ul>
   *   <li>Then return Bounds Y is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); then return Bounds Y is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath_thenReturnBoundsYIsOne2() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    Integer valueOfResult = Integer.valueOf(1);
    numbers.add(valueOfResult);

    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
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
   * <ul>
   *   <li>Then return CurrentPoint X is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); then return CurrentPoint X is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath_thenReturnCurrentPointXIsZero() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
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
   * <ul>
   *   <li>Then return CurrentPoint Y is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharString#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); then return CurrentPoint Y is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath Type1CharString.getPath()"})
  void testGetPath_thenReturnCurrentPointYIsZero() {
    // Arrange
    ArrayList<Number> numbers = new ArrayList<>();
    Integer valueOfResult = Integer.valueOf(1);
    numbers.add(valueOfResult);

    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(numbers, CharStringCommand.HLINETO);

    // Act
    GeneralPath actualPath = type1CharString.getPath();

    // Assert
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D bounds2D = actualPath.getBounds2D();
    assertTrue(bounds2D instanceof Float);
    assertEquals(0.0d, currentPoint.getY());
    assertEquals(0.0f, ((Point2D.Float) currentPoint).y);
    Rectangle bounds = actualPath.getBounds();
    assertEquals(1.0d, bounds.getX());
    assertEquals(1.0d, currentPoint.getX());
    assertEquals(1.0d, bounds.getCenterX());
    assertEquals(1.0d, bounds2D.getCenterX());
    assertEquals(1.0d, bounds.getMaxX());
    assertEquals(1.0d, bounds2D.getMaxX());
    assertEquals(1.0d, bounds.getMinX());
    assertEquals(1.0d, bounds2D.getMinX());
    assertEquals(1.0d, bounds2D.getX());
    assertEquals(1.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(1.0f, ((Float) bounds2D).x);
    assertSame(valueOfResult, bounds.x);
  }

  /**
   * Test {@link Type1CharString#addCommand(List, CharStringCommand)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharString#addCommand(List, CharStringCommand)}
   */
  @Test
  @DisplayName("Test addCommand(List, CharStringCommand); given valueOf one; when ArrayList() add valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Type1CharString.addCommand(List, CharStringCommand)"})
  void testAddCommand_givenValueOfOne_whenArrayListAddValueOfOne() {
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
   * Test {@link Type1CharString#addCommand(List, CharStringCommand)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharString#addCommand(List, CharStringCommand)}
   */
  @Test
  @DisplayName("Test addCommand(List, CharStringCommand); given valueOf one; when ArrayList() add valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Type1CharString.addCommand(List, CharStringCommand)"})
  void testAddCommand_givenValueOfOne_whenArrayListAddValueOfOne2() {
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
   * Test {@link Type1CharString#addCommand(List, CharStringCommand)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharString#addCommand(List, CharStringCommand)}
   */
  @Test
  @DisplayName("Test addCommand(List, CharStringCommand); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Type1CharString.addCommand(List, CharStringCommand)"})
  void testAddCommand_whenArrayList() {
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
   * Test {@link Type1CharString#isSequenceEmpty()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharString#isSequenceEmpty()}
   */
  @Test
  @DisplayName("Test isSequenceEmpty(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Type1CharString.isSequenceEmpty()"})
  void testIsSequenceEmpty_thenReturnFalse() {
    // Arrange
    Type1CharString type1CharString = new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name");
    type1CharString.addCommand(new ArrayList<>(), CharStringCommand.HSTEM);

    // Act and Assert
    assertFalse(type1CharString.isSequenceEmpty());
  }

  /**
   * Test {@link Type1CharString#isSequenceEmpty()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharString#isSequenceEmpty()}
   */
  @Test
  @DisplayName("Test isSequenceEmpty(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Type1CharString.isSequenceEmpty()"})
  void testIsSequenceEmpty_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name")).isSequenceEmpty());
  }

  /**
   * Test {@link Type1CharString#getLastSequenceEntry()}.
   * <ul>
   *   <li>Then return {@link CharStringCommand}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharString#getLastSequenceEntry()}
   */
  @Test
  @DisplayName("Test getLastSequenceEntry(); then return CharStringCommand")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Type1CharString.getLastSequenceEntry()"})
  void testGetLastSequenceEntry_thenReturnCharStringCommand() {
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
   * Test {@link Type1CharString#getLastSequenceEntry()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1CharString#getLastSequenceEntry()}
   */
  @Test
  @DisplayName("Test getLastSequenceEntry(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Type1CharString.getLastSequenceEntry()"})
  void testGetLastSequenceEntry_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        (new Type1CharString(mock(Type1CharStringReader.class), "Font Name", "Glyph Name")).getLastSequenceEntry());
  }
}
