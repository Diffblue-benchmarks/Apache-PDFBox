package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GlyfCompositeCompDiffblueTest {
  @Mock private TTFDataStream tTFDataStream;

  /**
   * Test {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}.
   *
   * <ul>
   *   <li>Then return Argument1 is minus one.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}
   */
  @Test
  @DisplayName("Test new GlyfCompositeComp(TTFDataStream); then return Argument1 is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfCompositeComp.<init>(TTFDataStream)"})
  void testNewGlyfCompositeComp_thenReturnArgument1IsMinusOne() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', 'X', 'A', 'X', -1, 'X', 'A', 'X'});
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(inputStream);

    // Act
    GlyfCompositeComp actualGlyfCompositeComp = new GlyfCompositeComp(bais);

    // Assert
    assertEquals((short) -1, actualGlyfCompositeComp.getArgument1());
    assertEquals(1.02099609375d, actualGlyfCompositeComp.getXScale());
    assertEquals(1.02099609375d, actualGlyfCompositeComp.getYScale());
    assertEquals((short) 16728, actualGlyfCompositeComp.getFlags());
  }

  /**
   * Test {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}.
   *
   * <ul>
   *   <li>Then return Flags is {@code 16641}.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}
   */
  @Test
  @DisplayName("Test new GlyfCompositeComp(TTFDataStream); then return Flags is '16641'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfCompositeComp.<init>(TTFDataStream)"})
  void testNewGlyfCompositeComp_thenReturnFlagsIs16641() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(
            new byte[] {'A', GlyfDescript.ON_CURVE, 'A', 'X', 'A', 'X', 'A', 'X'});
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(inputStream);

    // Act
    GlyfCompositeComp actualGlyfCompositeComp = new GlyfCompositeComp(bais);

    // Assert
    assertEquals(1.0d, actualGlyfCompositeComp.getXScale());
    assertEquals(1.0d, actualGlyfCompositeComp.getYScale());
    assertEquals((short) 16641, actualGlyfCompositeComp.getFlags());
    assertEquals((short) 16728, actualGlyfCompositeComp.getArgument1());
    assertEquals((short) 16728, actualGlyfCompositeComp.getArgument2());
  }

  /**
   * Test {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}.
   *
   * <ul>
   *   <li>Then return Flags is {@code 16642}.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}
   */
  @Test
  @DisplayName("Test new GlyfCompositeComp(TTFDataStream); then return Flags is '16642'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfCompositeComp.<init>(TTFDataStream)"})
  void testNewGlyfCompositeComp_thenReturnFlagsIs16642() throws IOException {
    // Arrange
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(
            new byte[] {'A', GlyfDescript.X_SHORT_VECTOR, 'A', 'X', 'A', 'X', 'A', 'X'});
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(inputStream);

    // Act
    GlyfCompositeComp actualGlyfCompositeComp = new GlyfCompositeComp(bais);

    // Assert
    assertEquals(1.0d, actualGlyfCompositeComp.getXScale());
    assertEquals(1.0d, actualGlyfCompositeComp.getYScale());
    assertEquals((short) 16642, actualGlyfCompositeComp.getFlags());
    assertEquals(65, actualGlyfCompositeComp.getXTranslate());
    assertEquals((short) 65, actualGlyfCompositeComp.getArgument1());
    assertEquals(88, actualGlyfCompositeComp.getYTranslate());
  }

  /**
   * Test {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}.
   *
   * <ul>
   *   <li>Then return Scale01 is {@code 0.0078125}.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}
   */
  @Test
  @DisplayName("Test new GlyfCompositeComp(TTFDataStream); then return Scale01 is '0.0078125'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfCompositeComp.<init>(TTFDataStream)"})
  void testNewGlyfCompositeComp_thenReturnScale01Is00078125() throws IOException {
    // Arrange
    when(tTFDataStream.readSignedByte()).thenReturn(1);
    when(tTFDataStream.readUnsignedShort()).thenReturn(1);
    when(tTFDataStream.readSignedShort()).thenReturn((short) 128);
    when(tTFDataStream.readSignedByte()).thenReturn(1);

    // Act
    GlyfCompositeComp actualGlyfCompositeComp = new GlyfCompositeComp(tTFDataStream);

    // Assert
    verify(tTFDataStream, atLeast(1)).readSignedByte();
    verify(tTFDataStream, atLeast(1)).readSignedShort();
    verify(tTFDataStream).readUnsignedShort();
    assertEquals(0.0078125d, actualGlyfCompositeComp.getScale01());
    assertEquals(0.0078125d, actualGlyfCompositeComp.getScale10());
    assertEquals(0.0078125d, actualGlyfCompositeComp.getXScale());
    assertEquals(0.0078125d, actualGlyfCompositeComp.getYScale());
    assertEquals((short) 128, actualGlyfCompositeComp.getFlags());
  }

  /**
   * Test {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}.
   *
   * <ul>
   *   <li>Then return XScale is {@code 0.00390625}.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}
   */
  @Test
  @DisplayName("Test new GlyfCompositeComp(TTFDataStream); then return XScale is '0.00390625'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfCompositeComp.<init>(TTFDataStream)"})
  void testNewGlyfCompositeComp_thenReturnXScaleIs000390625() throws IOException {
    // Arrange
    when(tTFDataStream.readSignedByte()).thenReturn(1);
    when(tTFDataStream.readUnsignedShort()).thenReturn(1);
    when(tTFDataStream.readSignedShort()).thenReturn((short) 64);
    when(tTFDataStream.readSignedByte()).thenReturn(1);

    // Act
    GlyfCompositeComp actualGlyfCompositeComp = new GlyfCompositeComp(tTFDataStream);

    // Assert
    verify(tTFDataStream, atLeast(1)).readSignedByte();
    verify(tTFDataStream, atLeast(1)).readSignedShort();
    verify(tTFDataStream).readUnsignedShort();
    assertEquals(0, actualGlyfCompositeComp.getXTranslate());
    assertEquals(0, actualGlyfCompositeComp.getYTranslate());
    assertEquals(0.00390625d, actualGlyfCompositeComp.getXScale());
    assertEquals(0.00390625d, actualGlyfCompositeComp.getYScale());
    assertEquals(0.0d, actualGlyfCompositeComp.getScale01());
    assertEquals(0.0d, actualGlyfCompositeComp.getScale10());
    assertEquals((short) 64, actualGlyfCompositeComp.getFlags());
  }

  /**
   * Test {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}.
   *
   * <ul>
   *   <li>Then return XScale is {@code 4.8828125E-4}.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}
   */
  @Test
  @DisplayName("Test new GlyfCompositeComp(TTFDataStream); then return XScale is '4.8828125E-4'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfCompositeComp.<init>(TTFDataStream)"})
  void testNewGlyfCompositeComp_thenReturnXScaleIs48828125e4() throws IOException {
    // Arrange
    when(tTFDataStream.readSignedByte()).thenReturn(1);
    when(tTFDataStream.readUnsignedShort()).thenReturn(1);
    when(tTFDataStream.readSignedShort()).thenReturn(OS2WindowsMetricsTable.FSTYPE_EDITIBLE);
    when(tTFDataStream.readSignedByte()).thenReturn(1);

    // Act
    GlyfCompositeComp actualGlyfCompositeComp = new GlyfCompositeComp(tTFDataStream);

    // Assert
    verify(tTFDataStream, atLeast(1)).readSignedByte();
    verify(tTFDataStream, atLeast(1)).readSignedShort();
    verify(tTFDataStream).readUnsignedShort();
    assertEquals(0, actualGlyfCompositeComp.getXTranslate());
    assertEquals(0, actualGlyfCompositeComp.getYTranslate());
    assertEquals(0.0d, actualGlyfCompositeComp.getScale01());
    assertEquals(0.0d, actualGlyfCompositeComp.getScale10());
    assertEquals(4.8828125E-4d, actualGlyfCompositeComp.getXScale());
    assertEquals(4.8828125E-4d, actualGlyfCompositeComp.getYScale());
    assertEquals(OS2WindowsMetricsTable.FSTYPE_EDITIBLE, actualGlyfCompositeComp.getFlags());
  }

  /**
   * Test {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}.
   *
   * <ul>
   *   <li>Then return XTranslate is one.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}
   */
  @Test
  @DisplayName("Test new GlyfCompositeComp(TTFDataStream); then return XTranslate is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfCompositeComp.<init>(TTFDataStream)"})
  void testNewGlyfCompositeComp_thenReturnXTranslateIsOne() throws IOException {
    // Arrange
    when(tTFDataStream.readSignedByte()).thenReturn(1);
    when(tTFDataStream.readUnsignedShort()).thenReturn(1);
    when(tTFDataStream.readSignedShort()).thenReturn(OS2WindowsMetricsTable.FSTYPE_RESTRICTED);
    when(tTFDataStream.readSignedByte()).thenReturn(1);

    // Act
    GlyfCompositeComp actualGlyfCompositeComp = new GlyfCompositeComp(tTFDataStream);

    // Assert
    verify(tTFDataStream, atLeast(1)).readSignedByte();
    verify(tTFDataStream).readSignedShort();
    verify(tTFDataStream).readUnsignedShort();
    assertEquals(1, actualGlyfCompositeComp.getXTranslate());
    assertEquals(1, actualGlyfCompositeComp.getYTranslate());
    assertEquals(1.0d, actualGlyfCompositeComp.getXScale());
    assertEquals(1.0d, actualGlyfCompositeComp.getYScale());
    assertEquals(OS2WindowsMetricsTable.FSTYPE_RESTRICTED, actualGlyfCompositeComp.getFlags());
  }

  /**
   * Test {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}
   */
  @Test
  @DisplayName("Test new GlyfCompositeComp(TTFDataStream); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfCompositeComp.<init>(TTFDataStream)"})
  void testNewGlyfCompositeComp_thenThrowIOException() throws IOException {
    // Arrange
    when(tTFDataStream.readSignedByte()).thenReturn(1);
    when(tTFDataStream.readUnsignedShort()).thenReturn(1);
    when(tTFDataStream.readSignedShort()).thenReturn(Short.MIN_VALUE);
    when(tTFDataStream.readSignedByte()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(IOException.class, () -> new GlyfCompositeComp(tTFDataStream));
    verify(tTFDataStream, atLeast(1)).readSignedByte();
    verify(tTFDataStream).readSignedShort();
    verify(tTFDataStream).readUnsignedShort();
  }

  /**
   * Test {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}
   */
  @Test
  @DisplayName(
      "Test new GlyfCompositeComp(TTFDataStream); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlyfCompositeComp.<init>(TTFDataStream)"})
  void testNewGlyfCompositeComp_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8()
      throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    GlyfCompositeComp actualGlyfCompositeComp = new GlyfCompositeComp(bais);

    // Assert
    assertEquals(1.02099609375d, actualGlyfCompositeComp.getXScale());
    assertEquals(1.02099609375d, actualGlyfCompositeComp.getYScale());
    assertEquals((short) 16728, actualGlyfCompositeComp.getFlags());
    assertEquals((short) 65, actualGlyfCompositeComp.getArgument1());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "short GlyfCompositeComp.getArgument1()",
    "short GlyfCompositeComp.getArgument2()",
    "int GlyfCompositeComp.getFirstContour()",
    "int GlyfCompositeComp.getFirstIndex()",
    "short GlyfCompositeComp.getFlags()",
    "int GlyfCompositeComp.getGlyphIndex()",
    "double GlyfCompositeComp.getScale01()",
    "double GlyfCompositeComp.getScale10()",
    "double GlyfCompositeComp.getXScale()",
    "int GlyfCompositeComp.getXTranslate()",
    "double GlyfCompositeComp.getYScale()",
    "int GlyfCompositeComp.getYTranslate()",
    "void GlyfCompositeComp.setFirstContour(int)",
    "void GlyfCompositeComp.setFirstIndex(int)"
  })
  void testGettersAndSetters() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    GlyfCompositeComp glyfCompositeComp = new GlyfCompositeComp(bais);

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
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeComp#scaleX(int, int)}
   */
  @Test
  @DisplayName("Test scaleX(int, int); when one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyfCompositeComp.scaleX(int, int)"})
  void testScaleX_whenOne_thenReturnOne() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(1, new GlyfCompositeComp(bais).scaleX(1, 3));
  }

  /**
   * Test {@link GlyfCompositeComp#scaleX(int, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeComp#scaleX(int, int)}
   */
  @Test
  @DisplayName("Test scaleX(int, int); when three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyfCompositeComp.scaleX(int, int)"})
  void testScaleX_whenThree_thenReturnThree() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(3, new GlyfCompositeComp(bais).scaleX(3, 3));
  }

  /**
   * Test {@link GlyfCompositeComp#scaleX(int, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeComp#scaleX(int, int)}
   */
  @Test
  @DisplayName("Test scaleX(int, int); when two; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyfCompositeComp.scaleX(int, int)"})
  void testScaleX_whenTwo_thenReturnTwo() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(2, new GlyfCompositeComp(bais).scaleX(2, 3));
  }

  /**
   * Test {@link GlyfCompositeComp#scaleX(int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeComp#scaleX(int, int)}
   */
  @Test
  @DisplayName("Test scaleX(int, int); when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyfCompositeComp.scaleX(int, int)"})
  void testScaleX_whenZero_thenReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(0, new GlyfCompositeComp(bais).scaleX(0, 3));
  }

  /**
   * Test {@link GlyfCompositeComp#scaleY(int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeComp#scaleY(int, int)}
   */
  @Test
  @DisplayName("Test scaleY(int, int); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyfCompositeComp.scaleY(int, int)"})
  void testScaleY_whenOne() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(3, new GlyfCompositeComp(bais).scaleY(1, 3));
  }

  /**
   * Test {@link GlyfCompositeComp#scaleY(int, int)}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeComp#scaleY(int, int)}
   */
  @Test
  @DisplayName("Test scaleY(int, int); when three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyfCompositeComp.scaleY(int, int)"})
  void testScaleY_whenThree() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(3, new GlyfCompositeComp(bais).scaleY(3, 3));
  }

  /**
   * Test {@link GlyfCompositeComp#scaleY(int, int)}.
   *
   * <ul>
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeComp#scaleY(int, int)}
   */
  @Test
  @DisplayName("Test scaleY(int, int); when two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyfCompositeComp.scaleY(int, int)"})
  void testScaleY_whenTwo() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(3, new GlyfCompositeComp(bais).scaleY(2, 3));
  }

  /**
   * Test {@link GlyfCompositeComp#scaleY(int, int)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link GlyfCompositeComp#scaleY(int, int)}
   */
  @Test
  @DisplayName("Test scaleY(int, int); when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GlyfCompositeComp.scaleY(int, int)"})
  void testScaleY_whenZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais =
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(3, new GlyfCompositeComp(bais).scaleY(0, 3));
  }
}
