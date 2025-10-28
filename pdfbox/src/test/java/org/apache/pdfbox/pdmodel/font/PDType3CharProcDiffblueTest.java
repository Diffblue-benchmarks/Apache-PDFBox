package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessInputStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDType3CharProcDiffblueTest {
  /**
   * Method under test: {@link PDType3CharProc#getCOSObject()}
   */
  @Test
  void testGetCOSObject() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    COSStream charStream = new COSStream();

    // Act and Assert
    assertSame(charStream, (new PDType3CharProc(font, charStream)).getCOSObject());
  }

  /**
   * Method under test: {@link PDType3CharProc#getContentStream()}
   */
  @Test
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
   * Method under test: {@link PDType3CharProc#getContents()}
   */
  @Test
  void testGetContents() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDType3Font font = new PDType3Font(fontDictionary);
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act
    InputStream actualContents = (new PDType3CharProc(font, charStream)).getContents();

    // Assert
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(charStream).createView();
    assertTrue(actualContents instanceof RandomAccessInputStream);
  }

  /**
   * Method under test: {@link PDType3CharProc#getContentsForRandomAccess()}
   */
  @Test
  void testGetContentsForRandomAccess() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDType3Font font = new PDType3Font(fontDictionary);
    COSStream charStream = mock(COSStream.class);
    RandomAccessReadBuffer randomAccessReadBuffer = new RandomAccessReadBuffer(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(charStream.createView()).thenReturn(randomAccessReadBuffer);

    // Act
    RandomAccessRead actualContentsForRandomAccess = (new PDType3CharProc(font, charStream))
        .getContentsForRandomAccess();

    // Assert
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(charStream).createView();
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadBuffer);
    assertSame(randomAccessReadBuffer, actualContentsForRandomAccess);
  }

  /**
   * Method under test: {@link PDType3CharProc#getResources()}
   */
  @Test
  void testGetResources() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());

    // Act and Assert
    assertNull((new PDType3CharProc(font, new COSStream())).getResources());
  }

  /**
   * Method under test: {@link PDType3CharProc#getBBox()}
   */
  @Test
  void testGetBBox() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());

    // Act and Assert
    assertNull((new PDType3CharProc(font, new COSStream())).getBBox());
  }

  /**
   * Method under test: {@link PDType3CharProc#getGlyphBBox()}
   */
  @Test
  void testGetGlyphBBox() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDType3Font font = new PDType3Font(fontDictionary);
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act
    PDRectangle actualGlyphBBox = (new PDType3CharProc(font, charStream)).getGlyphBBox();

    // Assert
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(charStream).createView();
    assertNull(actualGlyphBBox);
  }

  /**
   * Method under test: {@link PDType3CharProc#getGlyphBBox()}
   */
  @Test
  void testGetGlyphBBox2() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDType3Font font = new PDType3Font(fontDictionary);
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("\nXAXAXAX".getBytes("UTF-8"))));

    // Act
    PDRectangle actualGlyphBBox = (new PDType3CharProc(font, charStream)).getGlyphBBox();

    // Assert
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(charStream).createView();
    assertNull(actualGlyphBBox);
  }

  /**
   * Method under test: {@link PDType3CharProc#getGlyphBBox()}
   */
  @Test
  void testGetGlyphBBox3() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDType3Font font = new PDType3Font(fontDictionary);
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("\bXAXAXAX".getBytes("UTF-8"))));

    // Act
    PDRectangle actualGlyphBBox = (new PDType3CharProc(font, charStream)).getGlyphBBox();

    // Assert
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(charStream).createView();
    assertNull(actualGlyphBBox);
  }

  /**
   * Method under test: {@link PDType3CharProc#getGlyphBBox()}
   */
  @Test
  void testGetGlyphBBox4() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDType3Font font = new PDType3Font(fontDictionary);
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("A\nAXAXAX".getBytes("UTF-8"))));

    // Act
    PDRectangle actualGlyphBBox = (new PDType3CharProc(font, charStream)).getGlyphBBox();

    // Assert
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(charStream).createView();
    assertNull(actualGlyphBBox);
  }

  /**
   * Method under test: {@link PDType3CharProc#getGlyphBBox()}
   */
  @Test
  void testGetGlyphBBox5() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDType3Font font = new PDType3Font(fontDictionary);
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView()).thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{})));

    // Act
    PDRectangle actualGlyphBBox = (new PDType3CharProc(font, charStream)).getGlyphBBox();

    // Assert
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(charStream).createView();
    assertNull(actualGlyphBBox);
  }

  /**
   * Method under test: {@link PDType3CharProc#getMatrix()}
   */
  @Test
  void testGetMatrix() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());

    // Act and Assert
    assertSame(font.DEFAULT_FONT_MATRIX, (new PDType3CharProc(font, new COSStream())).getMatrix());
  }

  /**
   * Method under test: {@link PDType3CharProc#getWidth()}
   */
  @Test
  void testGetWidth() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDType3Font font = new PDType3Font(fontDictionary);
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDType3CharProc(font, charStream)).getWidth());
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(charStream).createView();
  }

  /**
   * Method under test: {@link PDType3CharProc#getWidth()}
   */
  @Test
  void testGetWidth2() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDType3Font font = new PDType3Font(fontDictionary);
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("\nXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDType3CharProc(font, charStream)).getWidth());
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(charStream).createView();
  }

  /**
   * Method under test: {@link PDType3CharProc#getWidth()}
   */
  @Test
  void testGetWidth3() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDType3Font font = new PDType3Font(fontDictionary);
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("\bXAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDType3CharProc(font, charStream)).getWidth());
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(charStream).createView();
  }

  /**
   * Method under test: {@link PDType3CharProc#getWidth()}
   */
  @Test
  void testGetWidth4() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDType3Font font = new PDType3Font(fontDictionary);
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView())
        .thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream("A\nAXAXAX".getBytes("UTF-8"))));

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDType3CharProc(font, charStream)).getWidth());
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(charStream).createView();
  }

  /**
   * Method under test: {@link PDType3CharProc#getWidth()}
   */
  @Test
  void testGetWidth5() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDType3Font font = new PDType3Font(fontDictionary);
    COSStream charStream = mock(COSStream.class);
    when(charStream.createView()).thenReturn(new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{})));

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDType3CharProc(font, charStream)).getWidth());
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(charStream).createView();
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDType3CharProc#PDType3CharProc(PDType3Font, COSStream)}
   *   <li>{@link PDType3CharProc#getFont()}
   * </ul>
   */
  @Test
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
}
