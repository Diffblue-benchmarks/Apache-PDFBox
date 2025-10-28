package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

class GlyfCompositeDescriptDiffblueTest {
  /**
   * Method under test: {@link GlyfCompositeDescript#resolve()}
   */
  @Test
  void testResolve() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("XXAXAXAX".getBytes("UTF-8"));
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(inputStream);

    // Act
    (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).resolve();

    // Assert
    verify(inputStream).readAllBytes();
  }

  /**
   * Method under test: {@link GlyfCompositeDescript#getEndPtOfContours(int)}
   */
  @Test
  void testGetEndPtOfContours() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(0, (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getEndPtOfContours(1));
  }

  /**
   * Method under test: {@link GlyfCompositeDescript#getEndPtOfContours(int)}
   */
  @Test
  void testGetEndPtOfContours2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("XXAXAXAX".getBytes("UTF-8"));
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(inputStream);

    // Act
    int actualEndPtOfContours = (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getEndPtOfContours(1);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(0, actualEndPtOfContours);
  }

  /**
   * Method under test: {@link GlyfCompositeDescript#getEndPtOfContours(int)}
   */
  @Test
  void testGetEndPtOfContours3() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("XXAXAXAX".getBytes("UTF-8"));
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(inputStream);

    // Act
    int actualEndPtOfContours = (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getEndPtOfContours(-1);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(0, actualEndPtOfContours);
  }

  /**
   * Method under test: {@link GlyfCompositeDescript#getFlags(int)}
   */
  @Test
  void testGetFlags() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals((byte) 0, (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getFlags(1));
  }

  /**
   * Method under test: {@link GlyfCompositeDescript#getFlags(int)}
   */
  @Test
  void testGetFlags2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("XXAXAXAX".getBytes("UTF-8"));
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(inputStream);

    // Act
    byte actualFlags = (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getFlags(1);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals((byte) 0, actualFlags);
  }

  /**
   * Method under test: {@link GlyfCompositeDescript#getFlags(int)}
   */
  @Test
  void testGetFlags3() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("XXAXAXAX".getBytes("UTF-8"));
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(inputStream);

    // Act
    byte actualFlags = (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getFlags(-1);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals((byte) 0, actualFlags);
  }

  /**
   * Method under test: {@link GlyfCompositeDescript#getXCoordinate(int)}
   */
  @Test
  void testGetXCoordinate() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals((short) 0, (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getXCoordinate(1));
  }

  /**
   * Method under test: {@link GlyfCompositeDescript#getXCoordinate(int)}
   */
  @Test
  void testGetXCoordinate2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("XXAXAXAX".getBytes("UTF-8"));
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(inputStream);

    // Act
    short actualXCoordinate = (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getXCoordinate(1);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals((short) 0, actualXCoordinate);
  }

  /**
   * Method under test: {@link GlyfCompositeDescript#getXCoordinate(int)}
   */
  @Test
  void testGetXCoordinate3() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("XXAXAXAX".getBytes("UTF-8"));
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(inputStream);

    // Act
    short actualXCoordinate = (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getXCoordinate(-1);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals((short) 0, actualXCoordinate);
  }

  /**
   * Method under test: {@link GlyfCompositeDescript#getYCoordinate(int)}
   */
  @Test
  void testGetYCoordinate() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals((short) 0, (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getYCoordinate(1));
  }

  /**
   * Method under test: {@link GlyfCompositeDescript#getYCoordinate(int)}
   */
  @Test
  void testGetYCoordinate2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("XXAXAXAX".getBytes("UTF-8"));
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(inputStream);

    // Act
    short actualYCoordinate = (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getYCoordinate(1);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals((short) 0, actualYCoordinate);
  }

  /**
   * Method under test: {@link GlyfCompositeDescript#getYCoordinate(int)}
   */
  @Test
  void testGetYCoordinate3() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("XXAXAXAX".getBytes("UTF-8"));
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(inputStream);

    // Act
    short actualYCoordinate = (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getYCoordinate(-1);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals((short) 0, actualYCoordinate);
  }

  /**
   * Method under test: {@link GlyfCompositeDescript#getPointCount()}
   */
  @Test
  void testGetPointCount() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(0, (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getPointCount());
  }

  /**
   * Method under test: {@link GlyfCompositeDescript#getPointCount()}
   */
  @Test
  void testGetPointCount2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("XXAXAXAX".getBytes("UTF-8"));
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(inputStream);

    // Act
    int actualPointCount = (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getPointCount();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(0, actualPointCount);
  }

  /**
   * Method under test: {@link GlyfCompositeDescript#getContourCount()}
   */
  @Test
  void testGetContourCount() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(0, (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getContourCount());
  }

  /**
   * Method under test: {@link GlyfCompositeDescript#getContourCount()}
   */
  @Test
  void testGetContourCount2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("XXAXAXAX".getBytes("UTF-8"));
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(inputStream);

    // Act
    int actualContourCount = (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getContourCount();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(0, actualContourCount);
  }

  /**
   * Method under test: {@link GlyfCompositeDescript#getComponentCount()}
   */
  @Test
  void testGetComponentCount() throws IOException {
    // Arrange
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(
        new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertEquals(1, (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getComponentCount());
  }

  /**
   * Method under test: {@link GlyfCompositeDescript#getComponentCount()}
   */
  @Test
  void testGetComponentCount2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("XXAXAXAX".getBytes("UTF-8"));
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(inputStream);

    // Act
    int actualComponentCount = (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getComponentCount();

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(1, actualComponentCount);
  }

  /**
   * Method under test: {@link GlyfCompositeDescript#getComponents()}
   */
  @Test
  void testGetComponents() throws IOException {
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

  /**
   * Method under test: {@link GlyfCompositeDescript#getComponents()}
   */
  @Test
  void testGetComponents2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("XXAXAXAX".getBytes("UTF-8"));
    RandomAccessReadDataStream bais = new RandomAccessReadDataStream(inputStream);

    // Act
    List<GlyfCompositeComp> actualComponents = (new GlyfCompositeDescript(bais, new GlyphTable(), 1)).getComponents();

    // Assert
    verify(inputStream).readAllBytes();
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

  /**
   * Method under test:
   * {@link GlyfCompositeDescript#GlyfCompositeDescript(TTFDataStream, GlyphTable, int)}
   */
  @Test
  void testNewGlyfCompositeDescript() throws IOException {
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
    assertEquals(0, getResult.getFirstContour());
    assertEquals(0, getResult.getFirstIndex());
    assertEquals(0, getResult.getXTranslate());
    assertEquals(0, getResult.getYTranslate());
    assertEquals(0, actualGlyfCompositeDescript.getContourCount());
    assertEquals(0, actualGlyfCompositeDescript.getPointCount());
    assertEquals(0.0d, getResult.getScale01());
    assertEquals(0.0d, getResult.getScale10());
    assertEquals(1, actualGlyfCompositeDescript.getComponentCount());
    assertEquals(1.02099609375d, getResult.getXScale());
    assertEquals(1.02099609375d, getResult.getYScale());
    assertEquals(16728, getResult.getGlyphIndex());
    assertEquals((short) 2136, getResult.getFlags());
    assertEquals((short) 65, getResult.getArgument1());
    assertEquals((short) 88, getResult.getArgument2());
    assertTrue(actualGlyfCompositeDescript.isComposite());
  }
}
