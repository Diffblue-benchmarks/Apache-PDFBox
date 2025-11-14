package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.io.NonSeekableRandomAccessReadInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GlyfCompositeDescriptDiffblueTest {
  /**
   * Test {@link GlyfCompositeDescript#GlyfCompositeDescript(TTFDataStream, GlyphTable, int)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeDescript#GlyfCompositeDescript(TTFDataStream,
   * GlyphTable, int)}
   */
  @Test
  @DisplayName(
      "Test new GlyfCompositeDescript(TTFDataStream, GlyphTable, int); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfCompositeDescript.<init>(TTFDataStream, GlyphTable, int)"})
  void testNewGlyfCompositeDescript_givenIOException_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read(Mockito.<byte[]>any())).thenThrow(new IOException());
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(inputStream);
    RandomAccessReadUnbufferedDataStream bais =
        new RandomAccessReadUnbufferedDataStream(randomAccessRead);

    // Act and Assert
    assertThrows(IOException.class, () -> new GlyfCompositeDescript(bais, new GlyphTable(), 1));
    verify(inputStream).read(isA(byte[].class));
  }

  /**
   * Test {@link GlyfCompositeDescript#getEndPtOfContours(int)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeDescript#getEndPtOfContours(int)}
   */
  @Test
  @DisplayName("Test getEndPtOfContours(int); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyfCompositeDescript.getEndPtOfContours(int)"})
  void testGetEndPtOfContours_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));
    GlyfCompositeDescript glyfCompositeDescript =
        new GlyfCompositeDescript(bais, new GlyphTable(), 1);

    // Act and Assert
    assertEquals(0, glyfCompositeDescript.getEndPtOfContours(1));
  }

  /**
   * Test {@link GlyfCompositeDescript#getEndPtOfContours(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeDescript#getEndPtOfContours(int)}
   */
  @Test
  @DisplayName("Test getEndPtOfContours(int); when minus one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyfCompositeDescript.getEndPtOfContours(int)"})
  void testGetEndPtOfContours_whenMinusOne_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));
    GlyfCompositeDescript glyfCompositeDescript =
        new GlyfCompositeDescript(bais, new GlyphTable(), 1);

    // Act and Assert
    assertEquals(0, glyfCompositeDescript.getEndPtOfContours(-1));
  }

  /**
   * Test {@link GlyfCompositeDescript#getFlags(int)}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code XXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeDescript#getFlags(int)}
   */
  @Test
  @DisplayName(
      "Test getFlags(int); given ByteArrayInputStream(byte[]) with 'XXAXAXAX' Bytes is 'UTF-8'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte GlyfCompositeDescript.getFlags(int)"})
  void testGetFlags_givenByteArrayInputStreamWithXxaxaxaxBytesIsUtf8_thenReturnZero()
      throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));
    GlyfCompositeDescript glyfCompositeDescript =
        new GlyfCompositeDescript(bais, new GlyphTable(), 1);

    // Act and Assert
    assertEquals((byte) 0, glyfCompositeDescript.getFlags(1));
  }

  /**
   * Test {@link GlyfCompositeDescript#getFlags(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeDescript#getFlags(int)}
   */
  @Test
  @DisplayName("Test getFlags(int); when minus one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte GlyfCompositeDescript.getFlags(int)"})
  void testGetFlags_whenMinusOne_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));
    GlyfCompositeDescript glyfCompositeDescript =
        new GlyfCompositeDescript(bais, new GlyphTable(), 1);

    // Act and Assert
    assertEquals((byte) 0, glyfCompositeDescript.getFlags(-1));
  }

  /**
   * Test {@link GlyfCompositeDescript#getXCoordinate(int)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeDescript#getXCoordinate(int)}
   */
  @Test
  @DisplayName("Test getXCoordinate(int); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short GlyfCompositeDescript.getXCoordinate(int)"})
  void testGetXCoordinate_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));
    GlyfCompositeDescript glyfCompositeDescript =
        new GlyfCompositeDescript(bais, new GlyphTable(), 1);

    // Act and Assert
    assertEquals((short) 0, glyfCompositeDescript.getXCoordinate(1));
  }

  /**
   * Test {@link GlyfCompositeDescript#getXCoordinate(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeDescript#getXCoordinate(int)}
   */
  @Test
  @DisplayName("Test getXCoordinate(int); when minus one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short GlyfCompositeDescript.getXCoordinate(int)"})
  void testGetXCoordinate_whenMinusOne_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));
    GlyfCompositeDescript glyfCompositeDescript =
        new GlyfCompositeDescript(bais, new GlyphTable(), 1);

    // Act and Assert
    assertEquals((short) 0, glyfCompositeDescript.getXCoordinate(-1));
  }

  /**
   * Test {@link GlyfCompositeDescript#getYCoordinate(int)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeDescript#getYCoordinate(int)}
   */
  @Test
  @DisplayName("Test getYCoordinate(int); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short GlyfCompositeDescript.getYCoordinate(int)"})
  void testGetYCoordinate_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));
    GlyfCompositeDescript glyfCompositeDescript =
        new GlyfCompositeDescript(bais, new GlyphTable(), 1);

    // Act and Assert
    assertEquals((short) 0, glyfCompositeDescript.getYCoordinate(1));
  }

  /**
   * Test {@link GlyfCompositeDescript#getYCoordinate(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeDescript#getYCoordinate(int)}
   */
  @Test
  @DisplayName("Test getYCoordinate(int); when minus one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"short GlyfCompositeDescript.getYCoordinate(int)"})
  void testGetYCoordinate_whenMinusOne_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));
    GlyfCompositeDescript glyfCompositeDescript =
        new GlyfCompositeDescript(bais, new GlyphTable(), 1);

    // Act and Assert
    assertEquals((short) 0, glyfCompositeDescript.getYCoordinate(-1));
  }

  /**
   * Test {@link GlyfCompositeDescript#getPointCount()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeDescript#getPointCount()}
   */
  @Test
  @DisplayName("Test getPointCount(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyfCompositeDescript.getPointCount()"})
  void testGetPointCount_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));
    GlyfCompositeDescript glyfCompositeDescript =
        new GlyfCompositeDescript(bais, new GlyphTable(), 1);

    // Act and Assert
    assertEquals(0, glyfCompositeDescript.getPointCount());
  }

  /**
   * Test {@link GlyfCompositeDescript#getContourCount()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeDescript#getContourCount()}
   */
  @Test
  @DisplayName("Test getContourCount(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyfCompositeDescript.getContourCount()"})
  void testGetContourCount_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));
    GlyfCompositeDescript glyfCompositeDescript =
        new GlyfCompositeDescript(bais, new GlyphTable(), 1);

    // Act and Assert
    assertEquals(0, glyfCompositeDescript.getContourCount());
  }

  /**
   * Test {@link GlyfCompositeDescript#getComponentCount()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeDescript#getComponentCount()}
   */
  @Test
  @DisplayName("Test getComponentCount(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyfCompositeDescript.getComponentCount()"})
  void testGetComponentCount_thenReturnOne() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));
    GlyfCompositeDescript glyfCompositeDescript =
        new GlyfCompositeDescript(bais, new GlyphTable(), 1);

    // Act and Assert
    assertEquals(1, glyfCompositeDescript.getComponentCount());
  }

  /**
   * Test {@link GlyfCompositeDescript#getComponents()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeDescript#getComponents()}
   */
  @Test
  @DisplayName("Test getComponents(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GlyfCompositeDescript.getComponents()"})
  void testGetComponents_thenReturnSizeIsOne() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));
    GlyfCompositeDescript glyfCompositeDescript =
        new GlyfCompositeDescript(bais, new GlyphTable(), 1);

    // Act
    List<GlyfCompositeComp> actualComponents = glyfCompositeDescript.getComponents();

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
