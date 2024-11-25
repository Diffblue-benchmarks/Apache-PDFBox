package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessInputStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDType3CharProcDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDType3CharProc#PDType3CharProc(PDType3Font, COSStream)}
   *   <li>{@link PDType3CharProc#getFont()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    COSStream charStream = new COSStream();

    // Act
    PDType3CharProc actualPdType3CharProc = new PDType3CharProc(font, charStream);
    PDType3Font actualFont = actualPdType3CharProc.getFont();

    // Assert
    assertSame(charStream, actualPdType3CharProc.getCOSObject());
    assertSame(font, actualFont);
  }

  /**
   * Test {@link PDType3CharProc#getCOSObject()}.
   * <p>
   * Method under test: {@link PDType3CharProc#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    COSStream charStream = new COSStream();

    // Act and Assert
    assertSame(charStream, (new PDType3CharProc(font, charStream)).getCOSObject());
  }

  /**
   * Test {@link PDType3CharProc#getContentStream()}.
   * <p>
   * Method under test: {@link PDType3CharProc#getContentStream()}
   */
  @Test
  @DisplayName("Test getContentStream()")
  void testGetContentStream() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    COSStream charStream = new COSStream();

    // Act
    PDStream actualContentStream = (new PDType3CharProc(font, charStream)).getContentStream();

    // Assert
    assertNull(actualContentStream.getDecodeParms());
    assertNull(actualContentStream.getFileDecodeParams());
    assertNull(actualContentStream.getMetadata());
    assertNull(actualContentStream.getFile());
    assertEquals(-1, actualContentStream.getDecodedStreamLength());
    assertEquals(0, actualContentStream.getLength());
    List<String> fileFilters = actualContentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(charStream, actualContentStream.getCOSObject());
    assertSame(fileFilters, actualContentStream.getFilters());
  }

  /**
   * Test {@link PDType3CharProc#getContents()}.
   * <ul>
   *   <li>Then return {@link RandomAccessInputStream}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3CharProc#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return RandomAccessInputStream")
  void testGetContents_thenReturnRandomAccessInputStream() throws IOException {
    // Arrange
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act
    InputStream actualContents = (new PDType3CharProc(new PDType3Font(new COSDictionary()), charStream)).getContents();

    // Assert
    verify(charStream).createView();
    assertTrue(actualContents instanceof RandomAccessInputStream);
  }

  /**
   * Test {@link PDType3CharProc#getContentsForRandomAccess()}.
   * <ul>
   *   <li>Then return {@link RandomAccessReadBuffer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3CharProc#getContentsForRandomAccess()}
   */
  @Test
  @DisplayName("Test getContentsForRandomAccess(); then return RandomAccessReadBuffer")
  void testGetContentsForRandomAccess_thenReturnRandomAccessReadBuffer() throws IOException {
    // Arrange
    COSStream charStream = mock(COSStream.class);
    RandomAccessReadBuffer randomAccessReadBuffer = new RandomAccessReadBuffer(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(charStream.createView()).thenReturn(randomAccessReadBuffer);

    // Act
    RandomAccessRead actualContentsForRandomAccess = (new PDType3CharProc(new PDType3Font(new COSDictionary()),
        charStream)).getContentsForRandomAccess();

    // Assert
    verify(charStream).createView();
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadBuffer);
    assertSame(randomAccessReadBuffer, actualContentsForRandomAccess);
  }

  /**
   * Test {@link PDType3CharProc#getResources()}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3CharProc#getResources()}
   */
  @Test
  @DisplayName("Test getResources(); given PDType3Font(COSDictionary) with fontDictionary is COSStream(); then return 'null'")
  void testGetResources_givenPDType3FontWithFontDictionaryIsCOSStream_thenReturnNull() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSStream());

    // Act and Assert
    assertNull((new PDType3CharProc(font, new COSStream())).getResources());
  }

  /**
   * Test {@link PDType3CharProc#getResources()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3CharProc#getResources()}
   */
  @Test
  @DisplayName("Test getResources(); then return 'null'")
  void testGetResources_thenReturnNull() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());

    // Act and Assert
    assertNull((new PDType3CharProc(font, new COSStream())).getResources());
  }

  /**
   * Test {@link PDType3CharProc#getBBox()}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3CharProc#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary(); then return 'null'")
  void testGetBBox_givenPDType3FontWithFontDictionaryIsCOSDictionary_thenReturnNull() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());

    // Act and Assert
    assertNull((new PDType3CharProc(font, new COSStream())).getBBox());
  }

  /**
   * Test {@link PDType3CharProc#getBBox()}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3CharProc#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); given PDType3Font(COSDictionary) with fontDictionary is COSStream(); then return 'null'")
  void testGetBBox_givenPDType3FontWithFontDictionaryIsCOSStream_thenReturnNull() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSStream());

    // Act and Assert
    assertNull((new PDType3CharProc(font, new COSStream())).getBBox());
  }

  /**
   * Test {@link PDType3CharProc#getGlyphBBox()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code A AXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3CharProc#getGlyphBBox()}
   */
  @Test
  @DisplayName("Test getGlyphBBox(); given ByteArrayInputStream(byte[]) with 'A AXAXAX' Bytes is 'UTF-8'; then return 'null'")
  void testGetGlyphBBox_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf8_thenReturnNull() throws IOException {
    // Arrange
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("A\nAXAXAX".getBytes("UTF-8"))));

    // Act
    PDRectangle actualGlyphBBox = (new PDType3CharProc(new PDType3Font(new COSDictionary()), charStream))
        .getGlyphBBox();

    // Assert
    verify(charStream).createView();
    assertNull(actualGlyphBBox);
  }

  /**
   * Test {@link PDType3CharProc#getGlyphBBox()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3CharProc#getGlyphBBox()}
   */
  @Test
  @DisplayName("Test getGlyphBBox(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return 'null'")
  void testGetGlyphBBox_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnNull() throws IOException {
    // Arrange
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act
    PDRectangle actualGlyphBBox = (new PDType3CharProc(new PDType3Font(new COSDictionary()), charStream))
        .getGlyphBBox();

    // Assert
    verify(charStream).createView();
    assertNull(actualGlyphBBox);
  }

  /**
   * Test {@link PDType3CharProc#getGlyphBBox()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * empty array of {@code byte}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3CharProc#getGlyphBBox()}
   */
  @Test
  @DisplayName("Test getGlyphBBox(); given ByteArrayInputStream(byte[]) with empty array of byte; then return 'null'")
  void testGetGlyphBBox_givenByteArrayInputStreamWithEmptyArrayOfByte_thenReturnNull() throws IOException {
    // Arrange
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView()).thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{})));

    // Act
    PDRectangle actualGlyphBBox = (new PDType3CharProc(new PDType3Font(new COSDictionary()), charStream))
        .getGlyphBBox();

    // Assert
    verify(charStream).createView();
    assertNull(actualGlyphBBox);
  }

  /**
   * Test {@link PDType3CharProc#getGlyphBBox()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3CharProc#getGlyphBBox()}
   */
  @Test
  @DisplayName("Test getGlyphBBox(); given ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'; then return 'null'")
  void testGetGlyphBBox_givenByteArrayInputStreamWithXaxaxaxBytesIsUtf8_thenReturnNull() throws IOException {
    // Arrange
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("\nXAXAXAX".getBytes("UTF-8"))));

    // Act
    PDRectangle actualGlyphBBox = (new PDType3CharProc(new PDType3Font(new COSDictionary()), charStream))
        .getGlyphBBox();

    // Assert
    verify(charStream).createView();
    assertNull(actualGlyphBBox);
  }

  /**
   * Test {@link PDType3CharProc#getGlyphBBox()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3CharProc#getGlyphBBox()}
   */
  @Test
  @DisplayName("Test getGlyphBBox(); given ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'; then return 'null'")
  void testGetGlyphBBox_givenByteArrayInputStreamWithXaxaxaxBytesIsUtf8_thenReturnNull2() throws IOException {
    // Arrange
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("\bXAXAXAX".getBytes("UTF-8"))));

    // Act
    PDRectangle actualGlyphBBox = (new PDType3CharProc(new PDType3Font(new COSDictionary()), charStream))
        .getGlyphBBox();

    // Assert
    verify(charStream).createView();
    assertNull(actualGlyphBBox);
  }

  /**
   * Test {@link PDType3CharProc#getMatrix()}.
   * <p>
   * Method under test: {@link PDType3CharProc#getMatrix()}
   */
  @Test
  @DisplayName("Test getMatrix()")
  void testGetMatrix() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());

    // Act and Assert
    assertSame(font.DEFAULT_FONT_MATRIX, (new PDType3CharProc(font, new COSStream())).getMatrix());
  }

  /**
   * Test {@link PDType3CharProc#getMatrix()}.
   * <p>
   * Method under test: {@link PDType3CharProc#getMatrix()}
   */
  @Test
  @DisplayName("Test getMatrix()")
  void testGetMatrix2() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSStream());

    // Act and Assert
    assertSame(font.DEFAULT_FONT_MATRIX, (new PDType3CharProc(font, new COSStream())).getMatrix());
  }

  /**
   * Test {@link PDType3CharProc#getWidth()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code A AXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3CharProc#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth(); given ByteArrayInputStream(byte[]) with 'A AXAXAX' Bytes is 'UTF-8'")
  void testGetWidth_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("A\nAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class,
        () -> (new PDType3CharProc(new PDType3Font(new COSDictionary()), charStream)).getWidth());
    verify(charStream).createView();
  }

  /**
   * Test {@link PDType3CharProc#getWidth()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3CharProc#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  void testGetWidth_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class,
        () -> (new PDType3CharProc(new PDType3Font(new COSDictionary()), charStream)).getWidth());
    verify(charStream).createView();
  }

  /**
   * Test {@link PDType3CharProc#getWidth()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * empty array of {@code byte}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3CharProc#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth(); given ByteArrayInputStream(byte[]) with empty array of byte; then throw IOException")
  void testGetWidth_givenByteArrayInputStreamWithEmptyArrayOfByte_thenThrowIOException() throws IOException {
    // Arrange
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView()).thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{})));

    // Act and Assert
    assertThrows(IOException.class,
        () -> (new PDType3CharProc(new PDType3Font(new COSDictionary()), charStream)).getWidth());
    verify(charStream).createView();
  }

  /**
   * Test {@link PDType3CharProc#getWidth()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3CharProc#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth(); given ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'")
  void testGetWidth_givenByteArrayInputStreamWithXaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("\nXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class,
        () -> (new PDType3CharProc(new PDType3Font(new COSDictionary()), charStream)).getWidth());
    verify(charStream).createView();
  }

  /**
   * Test {@link PDType3CharProc#getWidth()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3CharProc#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth(); given ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'")
  void testGetWidth_givenByteArrayInputStreamWithXaxaxaxBytesIsUtf82() throws IOException {
    // Arrange
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("\bXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class,
        () -> (new PDType3CharProc(new PDType3Font(new COSDictionary()), charStream)).getWidth());
    verify(charStream).createView();
  }
}
