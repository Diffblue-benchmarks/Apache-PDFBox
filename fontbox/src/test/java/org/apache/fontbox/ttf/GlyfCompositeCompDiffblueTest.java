package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class GlyfCompositeCompDiffblueTest {
  /**
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

    // Assert that nothing has changed
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
   * Method under test: {@link GlyfCompositeComp#scaleX(int, int)}
   */
  @Test
  void testScaleX() throws IOException {
    // Arrange, Act and Assert
    assertEquals(2,
        (new GlyfCompositeComp(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .scaleX(2, 3));
  }

  /**
   * Method under test: {@link GlyfCompositeComp#scaleX(int, int)}
   */
  @Test
  void testScaleX2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualScaleXResult = (new GlyfCompositeComp(new RandomAccessReadDataStream(inputStream))).scaleX(2, 3);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(2, actualScaleXResult);
  }

  /**
   * Method under test: {@link GlyfCompositeComp#scaleX(int, int)}
   */
  @Test
  void testScaleX3() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualScaleXResult = (new GlyfCompositeComp(new RandomAccessReadDataStream(inputStream))).scaleX(3, 3);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(3, actualScaleXResult);
  }

  /**
   * Method under test: {@link GlyfCompositeComp#scaleX(int, int)}
   */
  @Test
  void testScaleX4() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualScaleXResult = (new GlyfCompositeComp(new RandomAccessReadDataStream(inputStream))).scaleX(1, 3);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(1, actualScaleXResult);
  }

  /**
   * Method under test: {@link GlyfCompositeComp#scaleX(int, int)}
   */
  @Test
  void testScaleX5() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualScaleXResult = (new GlyfCompositeComp(new RandomAccessReadDataStream(inputStream))).scaleX(0, 3);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(0, actualScaleXResult);
  }

  /**
   * Method under test: {@link GlyfCompositeComp#scaleY(int, int)}
   */
  @Test
  void testScaleY() throws IOException {
    // Arrange, Act and Assert
    assertEquals(3,
        (new GlyfCompositeComp(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .scaleY(2, 3));
  }

  /**
   * Method under test: {@link GlyfCompositeComp#scaleY(int, int)}
   */
  @Test
  void testScaleY2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualScaleYResult = (new GlyfCompositeComp(new RandomAccessReadDataStream(inputStream))).scaleY(2, 3);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(3, actualScaleYResult);
  }

  /**
   * Method under test: {@link GlyfCompositeComp#scaleY(int, int)}
   */
  @Test
  void testScaleY3() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualScaleYResult = (new GlyfCompositeComp(new RandomAccessReadDataStream(inputStream))).scaleY(3, 3);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(3, actualScaleYResult);
  }

  /**
   * Method under test: {@link GlyfCompositeComp#scaleY(int, int)}
   */
  @Test
  void testScaleY4() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualScaleYResult = (new GlyfCompositeComp(new RandomAccessReadDataStream(inputStream))).scaleY(1, 3);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(3, actualScaleYResult);
  }

  /**
   * Method under test: {@link GlyfCompositeComp#scaleY(int, int)}
   */
  @Test
  void testScaleY5() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualScaleYResult = (new GlyfCompositeComp(new RandomAccessReadDataStream(inputStream))).scaleY(0, 3);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(3, actualScaleYResult);
  }

  /**
   * Method under test: {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}
   */
  @Test
  void testNewGlyfCompositeComp() throws IOException {
    // Arrange and Act
    GlyfCompositeComp actualGlyfCompositeComp = new GlyfCompositeComp(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    assertEquals(0, actualGlyfCompositeComp.getFirstContour());
    assertEquals(0, actualGlyfCompositeComp.getFirstIndex());
    assertEquals(0, actualGlyfCompositeComp.getXTranslate());
    assertEquals(0, actualGlyfCompositeComp.getYTranslate());
    assertEquals(0.0d, actualGlyfCompositeComp.getScale01());
    assertEquals(0.0d, actualGlyfCompositeComp.getScale10());
    assertEquals(1.02099609375d, actualGlyfCompositeComp.getXScale());
    assertEquals(1.02099609375d, actualGlyfCompositeComp.getYScale());
    assertEquals(16728, actualGlyfCompositeComp.getGlyphIndex());
    assertEquals((short) 16728, actualGlyfCompositeComp.getFlags());
    assertEquals((short) 65, actualGlyfCompositeComp.getArgument1());
    assertEquals((short) 88, actualGlyfCompositeComp.getArgument2());
  }

  /**
   * Method under test: {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}
   */
  @Test
  void testNewGlyfCompositeComp2() throws IOException {
    // Arrange and Act
    GlyfCompositeComp actualGlyfCompositeComp = new GlyfCompositeComp(new RandomAccessReadDataStream(
        new ByteArrayInputStream(new byte[]{'A', GlyfDescript.ON_CURVE, 'A', 'X', 'A', 'X', 'A', 'X'})));

    // Assert
    assertEquals(0, actualGlyfCompositeComp.getFirstContour());
    assertEquals(0, actualGlyfCompositeComp.getFirstIndex());
    assertEquals(0, actualGlyfCompositeComp.getXTranslate());
    assertEquals(0, actualGlyfCompositeComp.getYTranslate());
    assertEquals(0.0d, actualGlyfCompositeComp.getScale01());
    assertEquals(0.0d, actualGlyfCompositeComp.getScale10());
    assertEquals(1.0d, actualGlyfCompositeComp.getXScale());
    assertEquals(1.0d, actualGlyfCompositeComp.getYScale());
    assertEquals((short) 16641, actualGlyfCompositeComp.getFlags());
    assertEquals(16728, actualGlyfCompositeComp.getGlyphIndex());
    assertEquals((short) 16728, actualGlyfCompositeComp.getArgument1());
    assertEquals((short) 16728, actualGlyfCompositeComp.getArgument2());
  }

  /**
   * Method under test: {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}
   */
  @Test
  void testNewGlyfCompositeComp3() throws IOException {
    // Arrange and Act
    GlyfCompositeComp actualGlyfCompositeComp = new GlyfCompositeComp(
        new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', -1, 'X', 'A', 'X'})));

    // Assert
    assertEquals((short) -1, actualGlyfCompositeComp.getArgument1());
    assertEquals(0, actualGlyfCompositeComp.getFirstContour());
    assertEquals(0, actualGlyfCompositeComp.getFirstIndex());
    assertEquals(0, actualGlyfCompositeComp.getXTranslate());
    assertEquals(0, actualGlyfCompositeComp.getYTranslate());
    assertEquals(0.0d, actualGlyfCompositeComp.getScale01());
    assertEquals(0.0d, actualGlyfCompositeComp.getScale10());
    assertEquals(1.02099609375d, actualGlyfCompositeComp.getXScale());
    assertEquals(1.02099609375d, actualGlyfCompositeComp.getYScale());
    assertEquals(16728, actualGlyfCompositeComp.getGlyphIndex());
    assertEquals((short) 16728, actualGlyfCompositeComp.getFlags());
    assertEquals((short) 88, actualGlyfCompositeComp.getArgument2());
  }

  /**
   * Method under test: {@link GlyfCompositeComp#GlyfCompositeComp(TTFDataStream)}
   */
  @Test
  void testNewGlyfCompositeComp4() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    GlyfCompositeComp actualGlyfCompositeComp = new GlyfCompositeComp(new RandomAccessReadDataStream(inputStream));

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(0, actualGlyfCompositeComp.getFirstContour());
    assertEquals(0, actualGlyfCompositeComp.getFirstIndex());
    assertEquals(0, actualGlyfCompositeComp.getXTranslate());
    assertEquals(0, actualGlyfCompositeComp.getYTranslate());
    assertEquals(0.0d, actualGlyfCompositeComp.getScale01());
    assertEquals(0.0d, actualGlyfCompositeComp.getScale10());
    assertEquals(1.02099609375d, actualGlyfCompositeComp.getXScale());
    assertEquals(1.02099609375d, actualGlyfCompositeComp.getYScale());
    assertEquals(16728, actualGlyfCompositeComp.getGlyphIndex());
    assertEquals((short) 16728, actualGlyfCompositeComp.getFlags());
    assertEquals((short) 65, actualGlyfCompositeComp.getArgument1());
    assertEquals((short) 88, actualGlyfCompositeComp.getArgument2());
  }
}
