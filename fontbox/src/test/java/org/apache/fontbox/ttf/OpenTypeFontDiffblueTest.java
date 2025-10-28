package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

class OpenTypeFontDiffblueTest {
  /**
   * Method under test: {@link OpenTypeFont#setVersion(float)}
   */
  @Test
  void testSetVersion() throws IOException {
    // Arrange
    OpenTypeFont openTypeFont = new OpenTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act
    openTypeFont.setVersion(10.0f);

    // Assert
    assertEquals(10.0f, openTypeFont.getVersion());
  }

  /**
   * Method under test: {@link OpenTypeFont#setVersion(float)}
   */
  @Test
  void testSetVersion2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    OpenTypeFont openTypeFont = new OpenTypeFont(new RandomAccessReadDataStream(inputStream));

    // Act
    openTypeFont.setVersion(10.0f);

    // Assert
    verify(inputStream).readAllBytes();
    assertEquals(10.0f, openTypeFont.getVersion());
  }

  /**
   * Method under test: {@link OpenTypeFont#getCFF()}
   */
  @Test
  void testGetCFF() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new OpenTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getCFF());
  }

  /**
   * Method under test: {@link OpenTypeFont#getGlyph()}
   */
  @Test
  void testGetGlyph() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new OpenTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .getGlyph());
  }

  /**
   * Method under test: {@link OpenTypeFont#getGlyph()}
   */
  @Test
  void testGetGlyph2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    GlyphTable actualGlyph = (new OpenTypeFont(new RandomAccessReadDataStream(inputStream))).getGlyph();

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualGlyph);
  }

  /**
   * Method under test: {@link OpenTypeFont#isPostScript()}
   */
  @Test
  void testIsPostScript() throws IOException {
    // Arrange, Act and Assert
    assertFalse(
        (new OpenTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .isPostScript());
  }

  /**
   * Method under test: {@link OpenTypeFont#isPostScript()}
   */
  @Test
  void testIsPostScript2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualIsPostScriptResult = (new OpenTypeFont(new RandomAccessReadDataStream(inputStream))).isPostScript();

    // Assert
    verify(inputStream).readAllBytes();
    assertFalse(actualIsPostScriptResult);
  }

  /**
   * Method under test: {@link OpenTypeFont#isSupportedOTF()}
   */
  @Test
  void testIsSupportedOTF() throws IOException {
    // Arrange, Act and Assert
    assertTrue(
        (new OpenTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .isSupportedOTF());
  }

  /**
   * Method under test: {@link OpenTypeFont#isSupportedOTF()}
   */
  @Test
  void testIsSupportedOTF2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualIsSupportedOTFResult = (new OpenTypeFont(new RandomAccessReadDataStream(inputStream)))
        .isSupportedOTF();

    // Assert
    verify(inputStream).readAllBytes();
    assertTrue(actualIsSupportedOTFResult);
  }

  /**
   * Method under test: {@link OpenTypeFont#hasLayoutTables()}
   */
  @Test
  void testHasLayoutTables() throws IOException {
    // Arrange, Act and Assert
    assertFalse(
        (new OpenTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))))
            .hasLayoutTables());
  }

  /**
   * Method under test: {@link OpenTypeFont#hasLayoutTables()}
   */
  @Test
  void testHasLayoutTables2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    boolean actualHasLayoutTablesResult = (new OpenTypeFont(new RandomAccessReadDataStream(inputStream)))
        .hasLayoutTables();

    // Assert
    verify(inputStream).readAllBytes();
    assertFalse(actualHasLayoutTablesResult);
  }

  /**
   * Method under test: {@link OpenTypeFont#OpenTypeFont(TTFDataStream)}
   */
  @Test
  void testNewOpenTypeFont() throws IOException {
    // Arrange and Act
    OpenTypeFont actualOpenTypeFont = new OpenTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Assert
    assertNull(actualOpenTypeFont.getName());
    assertNull(actualOpenTypeFont.getCmap());
    assertNull(actualOpenTypeFont.getGsub());
    assertNull(actualOpenTypeFont.getGlyph());
    assertNull(actualOpenTypeFont.getHeader());
    assertNull(actualOpenTypeFont.getHorizontalHeader());
    assertNull(actualOpenTypeFont.getHorizontalMetrics());
    assertNull(actualOpenTypeFont.getIndexToLocation());
    assertNull(actualOpenTypeFont.getKerning());
    assertNull(actualOpenTypeFont.getMaximumProfile());
    assertNull(actualOpenTypeFont.getNaming());
    assertNull(actualOpenTypeFont.getOS2Windows());
    assertNull(actualOpenTypeFont.getPostScript());
    assertNull(actualOpenTypeFont.getVerticalHeader());
    assertNull(actualOpenTypeFont.getVerticalMetrics());
    assertNull(actualOpenTypeFont.getVerticalOrigin());
    assertEquals(0, actualOpenTypeFont.getNumberOfGlyphs());
    assertEquals(0, actualOpenTypeFont.getUnitsPerEm());
    assertEquals(0.0f, actualOpenTypeFont.getVersion());
    List<Number> fontMatrix = actualOpenTypeFont.getFontMatrix();
    assertEquals(6, fontMatrix.size());
    byte[] byteArray = new byte[8];
    assertEquals(8, actualOpenTypeFont.getOriginalData().read(byteArray));
    assertEquals(8L, actualOpenTypeFont.getOriginalDataSize());
    assertTrue(actualOpenTypeFont.getTables().isEmpty());
    assertTrue(actualOpenTypeFont.getTableMap().isEmpty());
    assertTrue(actualOpenTypeFont.isEnableGsub());
    assertEquals(Float.POSITIVE_INFINITY, fontMatrix.get(0).floatValue());
    assertEquals(Float.POSITIVE_INFINITY, fontMatrix.get(3).floatValue());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link OpenTypeFont#OpenTypeFont(TTFDataStream)}
   */
  @Test
  void testNewOpenTypeFont2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    OpenTypeFont actualOpenTypeFont = new OpenTypeFont(new RandomAccessReadDataStream(inputStream));

    // Assert
    verify(inputStream).readAllBytes();
    assertNull(actualOpenTypeFont.getName());
    assertNull(actualOpenTypeFont.getCmap());
    assertNull(actualOpenTypeFont.getGsub());
    assertNull(actualOpenTypeFont.getGlyph());
    assertNull(actualOpenTypeFont.getHeader());
    assertNull(actualOpenTypeFont.getHorizontalHeader());
    assertNull(actualOpenTypeFont.getHorizontalMetrics());
    assertNull(actualOpenTypeFont.getIndexToLocation());
    assertNull(actualOpenTypeFont.getKerning());
    assertNull(actualOpenTypeFont.getMaximumProfile());
    assertNull(actualOpenTypeFont.getNaming());
    assertNull(actualOpenTypeFont.getOS2Windows());
    assertNull(actualOpenTypeFont.getPostScript());
    assertNull(actualOpenTypeFont.getVerticalHeader());
    assertNull(actualOpenTypeFont.getVerticalMetrics());
    assertNull(actualOpenTypeFont.getVerticalOrigin());
    assertEquals(0, actualOpenTypeFont.getNumberOfGlyphs());
    assertEquals(0, actualOpenTypeFont.getUnitsPerEm());
    assertEquals(0.0f, actualOpenTypeFont.getVersion());
    List<Number> fontMatrix = actualOpenTypeFont.getFontMatrix();
    assertEquals(6, fontMatrix.size());
    byte[] byteArray = new byte[8];
    assertEquals(8, actualOpenTypeFont.getOriginalData().read(byteArray));
    assertEquals(8L, actualOpenTypeFont.getOriginalDataSize());
    assertTrue(actualOpenTypeFont.getTables().isEmpty());
    assertTrue(actualOpenTypeFont.getTableMap().isEmpty());
    assertTrue(actualOpenTypeFont.isEnableGsub());
    assertEquals(Float.POSITIVE_INFINITY, fontMatrix.get(0).floatValue());
    assertEquals(Float.POSITIVE_INFINITY, fontMatrix.get(3).floatValue());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }
}
