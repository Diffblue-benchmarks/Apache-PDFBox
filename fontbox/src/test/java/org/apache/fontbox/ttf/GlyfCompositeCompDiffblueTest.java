package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GlyfCompositeCompDiffblueTest {
  /**
   * Test {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}.
   * <ul>
   *   <li>Then return Argument1 is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}
   */
  @Test
  @DisplayName("Test new GlyfCompositeComp(TTFDataStream); then return Argument1 is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GlyfCompositeComp.<init>(TTFDataStream)"})
  void testNewGlyfCompositeComp_thenReturnArgument1IsMinusOne() throws IOException {
    // Arrange and Act
    GlyfCompositeComp actualGlyfCompositeComp = new GlyfCompositeComp(
        new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', -1, 'X', 'A', 'X'})));

    // Assert
    assertEquals((short) -1, actualGlyfCompositeComp.getArgument1());
    assertEquals(1.02099609375d, actualGlyfCompositeComp.getXScale());
    assertEquals(1.02099609375d, actualGlyfCompositeComp.getYScale());
    assertEquals((short) 16728, actualGlyfCompositeComp.getFlags());
    assertEquals((short) 88, actualGlyfCompositeComp.getArgument2());
  }

  /**
   * Test {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}.
   * <ul>
   *   <li>Then return Argument1 is sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}
   */
  @Test
  @DisplayName("Test new GlyfCompositeComp(TTFDataStream); then return Argument1 is sixty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GlyfCompositeComp.<init>(TTFDataStream)"})
  void testNewGlyfCompositeComp_thenReturnArgument1IsSixtyFive() throws IOException {
    // Arrange and Act
    GlyfCompositeComp actualGlyfCompositeComp = new GlyfCompositeComp(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    assertEquals(1.02099609375d, actualGlyfCompositeComp.getXScale());
    assertEquals(1.02099609375d, actualGlyfCompositeComp.getYScale());
    assertEquals((short) 16728, actualGlyfCompositeComp.getFlags());
    assertEquals((short) 65, actualGlyfCompositeComp.getArgument1());
    assertEquals((short) 88, actualGlyfCompositeComp.getArgument2());
  }

  /**
   * Test {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}.
   * <ul>
   *   <li>Then return XScale is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}
   */
  @Test
  @DisplayName("Test new GlyfCompositeComp(TTFDataStream); then return XScale is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GlyfCompositeComp.<init>(TTFDataStream)"})
  void testNewGlyfCompositeComp_thenReturnXScaleIsOne() throws IOException {
    // Arrange and Act
    GlyfCompositeComp actualGlyfCompositeComp = new GlyfCompositeComp(new RandomAccessReadDataStream(
        new ByteArrayInputStream(new byte[]{'A', GlyfDescript.ON_CURVE, 'A', 'X', 'A', 'X', 'A', 'X'})));

    // Assert
    assertEquals(1.0d, actualGlyfCompositeComp.getXScale());
    assertEquals(1.0d, actualGlyfCompositeComp.getYScale());
    assertEquals((short) 16641, actualGlyfCompositeComp.getFlags());
    assertEquals((short) 16728, actualGlyfCompositeComp.getArgument1());
    assertEquals((short) 16728, actualGlyfCompositeComp.getArgument2());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GlyfCompositeComp#setFirstContour(int)}
   *   <li>{@link GlyfCompositeComp#setFirstIndex(int)}
   *   <li>{@link GlyfCompositeComp#getArgument1()}
   *   <li>{@link GlyfCompositeComp#getArgument2()}
   *   <li>{@link GlyfCompositeComp#getFirstContour()}
   *   <li>{@link GlyfCompositeComp#getFirstIndex()}
   *   <li>{@link GlyfCompositeComp#getFlags()}
   *   <li>{@link GlyfCompositeComp#getGlyphIndex()}
   *   <li>{@link GlyfCompositeComp#getScale01()}
   *   <li>{@link GlyfCompositeComp#getScale10()}
   *   <li>{@link GlyfCompositeComp#getXScale()}
   *   <li>{@link GlyfCompositeComp#getXTranslate()}
   *   <li>{@link GlyfCompositeComp#getYScale()}
   *   <li>{@link GlyfCompositeComp#getYTranslate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"short GlyfCompositeComp.getArgument1()", "short GlyfCompositeComp.getArgument2()",
      "int GlyfCompositeComp.getFirstContour()", "int GlyfCompositeComp.getFirstIndex()",
      "short GlyfCompositeComp.getFlags()", "int GlyfCompositeComp.getGlyphIndex()",
      "double GlyfCompositeComp.getScale01()", "double GlyfCompositeComp.getScale10()",
      "double GlyfCompositeComp.getXScale()", "int GlyfCompositeComp.getXTranslate()",
      "double GlyfCompositeComp.getYScale()", "int GlyfCompositeComp.getYTranslate()",
      "void GlyfCompositeComp.setFirstContour(int)", "void GlyfCompositeComp.setFirstIndex(int)"})
  void testGettersAndSetters() throws IOException {
    // Arrange
    GlyfCompositeComp glyfCompositeComp = new GlyfCompositeComp(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act
    glyfCompositeComp.setFirstContour(1);
    glyfCompositeComp.setFirstIndex(1);
    short actualArgument1 = glyfCompositeComp.getArgument1();
    short actualArgument2 = glyfCompositeComp.getArgument2();
    int actualFirstContour = glyfCompositeComp.getFirstContour();
    int actualFirstIndex = glyfCompositeComp.getFirstIndex();
    short actualFlags = glyfCompositeComp.getFlags();
    int actualGlyphIndex = glyfCompositeComp.getGlyphIndex();
    double actualScale01 = glyfCompositeComp.getScale01();
    double actualScale10 = glyfCompositeComp.getScale10();
    double actualXScale = glyfCompositeComp.getXScale();
    int actualXTranslate = glyfCompositeComp.getXTranslate();
    double actualYScale = glyfCompositeComp.getYScale();

    // Assert
    assertEquals(0, actualXTranslate);
    assertEquals(0, glyfCompositeComp.getYTranslate());
    assertEquals(0.0d, actualScale01);
    assertEquals(0.0d, actualScale10);
    assertEquals(1, actualFirstContour);
    assertEquals(1, actualFirstIndex);
    assertEquals(1.02099609375d, actualXScale);
    assertEquals(1.02099609375d, actualYScale);
    assertEquals(16728, actualGlyphIndex);
    assertEquals((short) 16728, actualFlags);
    assertEquals((short) 65, actualArgument1);
    assertEquals((short) 88, actualArgument2);
  }

  /**
   * Test {@link GlyfCompositeComp#scaleX(int, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeComp#scaleX(int, int)}
   */
  @Test
  @DisplayName("Test scaleX(int, int); when one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GlyfCompositeComp.scaleX(int, int)"})
  void testScaleX_whenOne_thenReturnOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1,
        (new GlyfCompositeComp(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .scaleX(1, 3));
  }

  /**
   * Test {@link GlyfCompositeComp#scaleX(int, int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeComp#scaleX(int, int)}
   */
  @Test
  @DisplayName("Test scaleX(int, int); when three; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GlyfCompositeComp.scaleX(int, int)"})
  void testScaleX_whenThree_thenReturnThree() throws IOException {
    // Arrange, Act and Assert
    assertEquals(3,
        (new GlyfCompositeComp(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .scaleX(3, 3));
  }

  /**
   * Test {@link GlyfCompositeComp#scaleX(int, int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeComp#scaleX(int, int)}
   */
  @Test
  @DisplayName("Test scaleX(int, int); when two; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GlyfCompositeComp.scaleX(int, int)"})
  void testScaleX_whenTwo_thenReturnTwo() throws IOException {
    // Arrange, Act and Assert
    assertEquals(2,
        (new GlyfCompositeComp(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .scaleX(2, 3));
  }

  /**
   * Test {@link GlyfCompositeComp#scaleX(int, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeComp#scaleX(int, int)}
   */
  @Test
  @DisplayName("Test scaleX(int, int); when zero; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GlyfCompositeComp.scaleX(int, int)"})
  void testScaleX_whenZero_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0,
        (new GlyfCompositeComp(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .scaleX(0, 3));
  }

  /**
   * Test {@link GlyfCompositeComp#scaleY(int, int)}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeComp#scaleY(int, int)}
   */
  @Test
  @DisplayName("Test scaleY(int, int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GlyfCompositeComp.scaleY(int, int)"})
  void testScaleY_whenOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(3,
        (new GlyfCompositeComp(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .scaleY(1, 3));
  }

  /**
   * Test {@link GlyfCompositeComp#scaleY(int, int)}.
   * <ul>
   *   <li>When three.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeComp#scaleY(int, int)}
   */
  @Test
  @DisplayName("Test scaleY(int, int); when three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GlyfCompositeComp.scaleY(int, int)"})
  void testScaleY_whenThree() throws IOException {
    // Arrange, Act and Assert
    assertEquals(3,
        (new GlyfCompositeComp(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .scaleY(3, 3));
  }

  /**
   * Test {@link GlyfCompositeComp#scaleY(int, int)}.
   * <ul>
   *   <li>When two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeComp#scaleY(int, int)}
   */
  @Test
  @DisplayName("Test scaleY(int, int); when two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GlyfCompositeComp.scaleY(int, int)"})
  void testScaleY_whenTwo() throws IOException {
    // Arrange, Act and Assert
    assertEquals(3,
        (new GlyfCompositeComp(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .scaleY(2, 3));
  }

  /**
   * Test {@link GlyfCompositeComp#scaleY(int, int)}.
   * <ul>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeComp#scaleY(int, int)}
   */
  @Test
  @DisplayName("Test scaleY(int, int); when zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GlyfCompositeComp.scaleY(int, int)"})
  void testScaleY_whenZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(3,
        (new GlyfCompositeComp(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .scaleY(0, 3));
  }
}
