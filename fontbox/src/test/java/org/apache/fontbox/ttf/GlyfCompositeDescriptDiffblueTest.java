package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GlyfCompositeDescriptDiffblueTest {
  /**
   * Test {@link GlyfCompositeDescript#GlyfCompositeDescript(TTFDataStream, GlyphTable, int)}.
   * <ul>
   *   <li>Then return Instructions is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeDescript#GlyfCompositeDescript(TTFDataStream, GlyphTable, int)}
   */
  @Test
  @DisplayName("Test new GlyfCompositeDescript(TTFDataStream, GlyphTable, int); then return Instructions is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GlyfCompositeDescript.<init>(TTFDataStream, GlyphTable, int)"})
  void testNewGlyfCompositeDescript_thenReturnInstructionsIsNull() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream("\bXAXAXAX".getBytes("UTF-8")));

    // Act
    GlyfCompositeDescript actualGlyfCompositeDescript = new GlyfCompositeDescript(bais, new GlyphTable(), 1);

    // Assert
    assertNull(actualGlyfCompositeDescript.getInstructions());
    List<GlyfCompositeComp> components = actualGlyfCompositeDescript.getComponents();
    assertEquals(1, components.size());
    GlyfCompositeComp getResult = components.get(0);
    assertEquals(1.02099609375d, getResult.getXScale());
    assertEquals(1.02099609375d, getResult.getYScale());
    assertEquals((short) 2136, getResult.getFlags());
  }

  /**
   * Test {@link GlyfCompositeDescript#GlyfCompositeDescript(TTFDataStream, GlyphTable, int)}.
   * <ul>
   *   <li>When backspace.</li>
   *   <li>Then return array length is {@code 2136}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeDescript#GlyfCompositeDescript(TTFDataStream, GlyphTable, int)}
   */
  @Test
  @DisplayName("Test new GlyfCompositeDescript(TTFDataStream, GlyphTable, int); when backspace; then return array length is '2136'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GlyfCompositeDescript.<init>(TTFDataStream, GlyphTable, int)"})
  void testNewGlyfCompositeDescript_whenBackspace_thenReturnArrayLengthIs2136() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream(new byte[]{'A', 0, 'A', 'X', 'A', 'X', '\b', 'X'}));

    // Act
    GlyfCompositeDescript actualGlyfCompositeDescript = new GlyfCompositeDescript(bais, new GlyphTable(), 1);

    // Assert
    assertEquals(1, actualGlyfCompositeDescript.getComponents().size());
    assertEquals(2136, actualGlyfCompositeDescript.getInstructions().length);
  }

  /**
   * Test {@link GlyfCompositeDescript#getEndPtOfContours(int)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeDescript#getEndPtOfContours(int)}
   */
  @Test
  @DisplayName("Test getEndPtOfContours(int); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GlyfCompositeDescript.getEndPtOfContours(int)"})
  void testGetEndPtOfContours_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(0, (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getEndPtOfContours(1));
  }

  /**
   * Test {@link GlyfCompositeDescript#getEndPtOfContours(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeDescript#getEndPtOfContours(int)}
   */
  @Test
  @DisplayName("Test getEndPtOfContours(int); when minus one; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GlyfCompositeDescript.getEndPtOfContours(int)"})
  void testGetEndPtOfContours_whenMinusOne_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(0, (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getEndPtOfContours(-1));
  }

  /**
   * Test {@link GlyfCompositeDescript#getFlags(int)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeDescript#getFlags(int)}
   */
  @Test
  @DisplayName("Test getFlags(int); given ByteArrayInputStream(byte[]) with 'XXAXAXAX' Bytes is 'UTF-8'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte GlyfCompositeDescript.getFlags(int)"})
  void testGetFlags_givenByteArrayInputStreamWithXxaxaxaxBytesIsUtf8_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals((byte) 0, (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getFlags(1));
  }

  /**
   * Test {@link GlyfCompositeDescript#getFlags(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeDescript#getFlags(int)}
   */
  @Test
  @DisplayName("Test getFlags(int); when minus one; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte GlyfCompositeDescript.getFlags(int)"})
  void testGetFlags_whenMinusOne_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals((byte) 0, (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getFlags(-1));
  }

  /**
   * Test {@link GlyfCompositeDescript#getXCoordinate(int)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeDescript#getXCoordinate(int)}
   */
  @Test
  @DisplayName("Test getXCoordinate(int); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"short GlyfCompositeDescript.getXCoordinate(int)"})
  void testGetXCoordinate_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals((short) 0, (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getXCoordinate(1));
  }

  /**
   * Test {@link GlyfCompositeDescript#getXCoordinate(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeDescript#getXCoordinate(int)}
   */
  @Test
  @DisplayName("Test getXCoordinate(int); when minus one; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"short GlyfCompositeDescript.getXCoordinate(int)"})
  void testGetXCoordinate_whenMinusOne_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals((short) 0, (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getXCoordinate(-1));
  }

  /**
   * Test {@link GlyfCompositeDescript#getYCoordinate(int)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeDescript#getYCoordinate(int)}
   */
  @Test
  @DisplayName("Test getYCoordinate(int); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"short GlyfCompositeDescript.getYCoordinate(int)"})
  void testGetYCoordinate_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals((short) 0, (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getYCoordinate(1));
  }

  /**
   * Test {@link GlyfCompositeDescript#getYCoordinate(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeDescript#getYCoordinate(int)}
   */
  @Test
  @DisplayName("Test getYCoordinate(int); when minus one; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"short GlyfCompositeDescript.getYCoordinate(int)"})
  void testGetYCoordinate_whenMinusOne_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals((short) 0, (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getYCoordinate(-1));
  }

  /**
   * Test {@link GlyfCompositeDescript#getPointCount()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeDescript#getPointCount()}
   */
  @Test
  @DisplayName("Test getPointCount(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GlyfCompositeDescript.getPointCount()"})
  void testGetPointCount_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(0, (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getPointCount());
  }

  /**
   * Test {@link GlyfCompositeDescript#getContourCount()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeDescript#getContourCount()}
   */
  @Test
  @DisplayName("Test getContourCount(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GlyfCompositeDescript.getContourCount()"})
  void testGetContourCount_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(0, (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getContourCount());
  }

  /**
   * Test {@link GlyfCompositeDescript#getComponentCount()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeDescript#getComponentCount()}
   */
  @Test
  @DisplayName("Test getComponentCount(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int GlyfCompositeDescript.getComponentCount()"})
  void testGetComponentCount_thenReturnOne() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(1, (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getComponentCount());
  }

  /**
   * Test {@link GlyfCompositeDescript#getComponents()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyfCompositeDescript#getComponents()}
   */
  @Test
  @DisplayName("Test getComponents(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List GlyfCompositeDescript.getComponents()"})
  void testGetComponents_thenReturnSizeIsOne() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));

    // Act
    List<GlyfCompositeComp> actualComponents = (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getComponents();

    // Assert
    assertEquals(1, actualComponents.size());
    GlyfCompositeComp getResult = actualComponents.get(0);
    assertEquals(0, getResult.getFirstContour());
    assertEquals(0, getResult.getFirstIndex());
    assertEquals(0, getResult.getXTranslate());
    assertEquals(0, getResult.getYTranslate());
    assertEquals(0.0d, getResult.getScale01());
    assertEquals(0.0d, getResult.getScale10());
    assertEquals(1.02099609375d, getResult.getXScale());
    assertEquals(1.02099609375d, getResult.getYScale());
    assertEquals(16728, getResult.getGlyphIndex());
    assertEquals((short) 22616, getResult.getFlags());
    assertEquals((short) 65, getResult.getArgument1());
    assertEquals((short) 88, getResult.getArgument2());
  }
}
