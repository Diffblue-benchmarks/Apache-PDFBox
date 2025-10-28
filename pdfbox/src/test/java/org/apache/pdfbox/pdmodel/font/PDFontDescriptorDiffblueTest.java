package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.Test;

class PDFontDescriptorDiffblueTest {
  /**
   * Method under test: {@link PDFontDescriptor#isFixedPitch()}
   */
  @Test
  void testIsFixedPitch() {
    // Arrange, Act and Assert
    assertFalse((new PDFontDescriptor()).isFixedPitch());
  }

  /**
   * Method under test: {@link PDFontDescriptor#isFixedPitch()}
   */
  @Test
  void testIsFixedPitch2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    boolean actualIsFixedPitchResult = pdFontDescriptor.isFixedPitch();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsFixedPitchResult);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFixedPitch(boolean)}
   */
  @Test
  void testSetFixedPitch() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFixedPitch(true);

    // Assert
    assertEquals(1, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdFontDescriptor.isFixedPitch());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFixedPitch(boolean)}
   */
  @Test
  void testSetFixedPitch2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFixedPitch(false);

    // Assert
    assertEquals(0, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isFixedPitch());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFixedPitch(boolean)}
   */
  @Test
  void testSetFixedPitch3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setFixedPitch(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdFontDescriptor.isFixedPitch());
  }

  /**
   * Method under test: {@link PDFontDescriptor#isSerif()}
   */
  @Test
  void testIsSerif() {
    // Arrange, Act and Assert
    assertFalse((new PDFontDescriptor()).isSerif());
  }

  /**
   * Method under test: {@link PDFontDescriptor#isSerif()}
   */
  @Test
  void testIsSerif2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    boolean actualIsSerifResult = pdFontDescriptor.isSerif();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsSerifResult);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setSerif(boolean)}
   */
  @Test
  void testSetSerif() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setSerif(true);

    // Assert
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(2, pdFontDescriptor.getFlags());
    assertTrue(pdFontDescriptor.isSerif());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setSerif(boolean)}
   */
  @Test
  void testSetSerif2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setSerif(false);

    // Assert
    assertEquals(0, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isSerif());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setSerif(boolean)}
   */
  @Test
  void testSetSerif3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setSerif(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(2, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdFontDescriptor.isSerif());
  }

  /**
   * Method under test: {@link PDFontDescriptor#isSymbolic()}
   */
  @Test
  void testIsSymbolic() {
    // Arrange, Act and Assert
    assertFalse((new PDFontDescriptor()).isSymbolic());
  }

  /**
   * Method under test: {@link PDFontDescriptor#isSymbolic()}
   */
  @Test
  void testIsSymbolic2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    boolean actualIsSymbolicResult = pdFontDescriptor.isSymbolic();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsSymbolicResult);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setSymbolic(boolean)}
   */
  @Test
  void testSetSymbolic() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setSymbolic(true);

    // Assert
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(4, pdFontDescriptor.getFlags());
    assertTrue(pdFontDescriptor.isSymbolic());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setSymbolic(boolean)}
   */
  @Test
  void testSetSymbolic2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setSymbolic(false);

    // Assert
    assertEquals(0, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isSymbolic());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setSymbolic(boolean)}
   */
  @Test
  void testSetSymbolic3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setSymbolic(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(4, pdFontDescriptor.getFlags());
    assertTrue(pdFontDescriptor.isSymbolic());
  }

  /**
   * Method under test: {@link PDFontDescriptor#isScript()}
   */
  @Test
  void testIsScript() {
    // Arrange, Act and Assert
    assertFalse((new PDFontDescriptor()).isScript());
  }

  /**
   * Method under test: {@link PDFontDescriptor#isScript()}
   */
  @Test
  void testIsScript2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    boolean actualIsScriptResult = pdFontDescriptor.isScript();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsScriptResult);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setScript(boolean)}
   */
  @Test
  void testSetScript() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setScript(true);

    // Assert
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(8, pdFontDescriptor.getFlags());
    assertTrue(pdFontDescriptor.isScript());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setScript(boolean)}
   */
  @Test
  void testSetScript2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setScript(false);

    // Assert
    assertEquals(0, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isScript());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setScript(boolean)}
   */
  @Test
  void testSetScript3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setScript(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(8, pdFontDescriptor.getFlags());
    assertTrue(pdFontDescriptor.isScript());
  }

  /**
   * Method under test: {@link PDFontDescriptor#isNonSymbolic()}
   */
  @Test
  void testIsNonSymbolic() {
    // Arrange, Act and Assert
    assertFalse((new PDFontDescriptor()).isNonSymbolic());
  }

  /**
   * Method under test: {@link PDFontDescriptor#isNonSymbolic()}
   */
  @Test
  void testIsNonSymbolic2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    boolean actualIsNonSymbolicResult = pdFontDescriptor.isNonSymbolic();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsNonSymbolicResult);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setNonSymbolic(boolean)}
   */
  @Test
  void testSetNonSymbolic() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setNonSymbolic(true);

    // Assert
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdFontDescriptor.isNonSymbolic());
    assertEquals(Integer.SIZE, pdFontDescriptor.getFlags());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setNonSymbolic(boolean)}
   */
  @Test
  void testSetNonSymbolic2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setNonSymbolic(false);

    // Assert
    assertEquals(0, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isNonSymbolic());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setNonSymbolic(boolean)}
   */
  @Test
  void testSetNonSymbolic3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setNonSymbolic(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdFontDescriptor.isNonSymbolic());
    assertEquals(Integer.SIZE, pdFontDescriptor.getFlags());
  }

  /**
   * Method under test: {@link PDFontDescriptor#isItalic()}
   */
  @Test
  void testIsItalic() {
    // Arrange, Act and Assert
    assertFalse((new PDFontDescriptor()).isItalic());
  }

  /**
   * Method under test: {@link PDFontDescriptor#isItalic()}
   */
  @Test
  void testIsItalic2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    boolean actualIsItalicResult = pdFontDescriptor.isItalic();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsItalicResult);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setItalic(boolean)}
   */
  @Test
  void testSetItalic() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setItalic(true);

    // Assert
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdFontDescriptor.isItalic());
    assertEquals(Double.SIZE, pdFontDescriptor.getFlags());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setItalic(boolean)}
   */
  @Test
  void testSetItalic2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setItalic(false);

    // Assert
    assertEquals(0, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isItalic());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setItalic(boolean)}
   */
  @Test
  void testSetItalic3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setItalic(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdFontDescriptor.isItalic());
    assertEquals(Double.SIZE, pdFontDescriptor.getFlags());
  }

  /**
   * Method under test: {@link PDFontDescriptor#isAllCap()}
   */
  @Test
  void testIsAllCap() {
    // Arrange, Act and Assert
    assertFalse((new PDFontDescriptor()).isAllCap());
  }

  /**
   * Method under test: {@link PDFontDescriptor#isAllCap()}
   */
  @Test
  void testIsAllCap2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    boolean actualIsAllCapResult = pdFontDescriptor.isAllCap();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsAllCapResult);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setAllCap(boolean)}
   */
  @Test
  void testSetAllCap() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setAllCap(true);

    // Assert
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(65536, pdFontDescriptor.getFlags());
    assertTrue(pdFontDescriptor.isAllCap());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setAllCap(boolean)}
   */
  @Test
  void testSetAllCap2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setAllCap(false);

    // Assert
    assertEquals(0, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isAllCap());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setAllCap(boolean)}
   */
  @Test
  void testSetAllCap3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setAllCap(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(65536, pdFontDescriptor.getFlags());
    assertTrue(pdFontDescriptor.isAllCap());
  }

  /**
   * Method under test: {@link PDFontDescriptor#isSmallCap()}
   */
  @Test
  void testIsSmallCap() {
    // Arrange, Act and Assert
    assertFalse((new PDFontDescriptor()).isSmallCap());
  }

  /**
   * Method under test: {@link PDFontDescriptor#isSmallCap()}
   */
  @Test
  void testIsSmallCap2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    boolean actualIsSmallCapResult = pdFontDescriptor.isSmallCap();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsSmallCapResult);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setSmallCap(boolean)}
   */
  @Test
  void testSetSmallCap() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setSmallCap(true);

    // Assert
    assertEquals(131072, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdFontDescriptor.isSmallCap());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setSmallCap(boolean)}
   */
  @Test
  void testSetSmallCap2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setSmallCap(false);

    // Assert
    assertEquals(0, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isSmallCap());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setSmallCap(boolean)}
   */
  @Test
  void testSetSmallCap3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setSmallCap(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(131072, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdFontDescriptor.isSmallCap());
  }

  /**
   * Method under test: {@link PDFontDescriptor#isForceBold()}
   */
  @Test
  void testIsForceBold() {
    // Arrange, Act and Assert
    assertFalse((new PDFontDescriptor()).isForceBold());
  }

  /**
   * Method under test: {@link PDFontDescriptor#isForceBold()}
   */
  @Test
  void testIsForceBold2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    boolean actualIsForceBoldResult = pdFontDescriptor.isForceBold();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsForceBoldResult);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setForceBold(boolean)}
   */
  @Test
  void testSetForceBold() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setForceBold(true);

    // Assert
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(262144, pdFontDescriptor.getFlags());
    assertTrue(pdFontDescriptor.isForceBold());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setForceBold(boolean)}
   */
  @Test
  void testSetForceBold2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setForceBold(false);

    // Assert
    assertEquals(0, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isForceBold());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setForceBold(boolean)}
   */
  @Test
  void testSetForceBold3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setForceBold(true);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(262144, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdFontDescriptor.isForceBold());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDFontDescriptor()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getCOSObject()}
   */
  @Test
  void testGetCOSObject2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    COSDictionary actualCOSObject = pdFontDescriptor.getCOSObject();

    // Assert
    verify(streamCacheCreateFunction).create();
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(2, actualCOSObject.getValues().size());
    assertEquals(2, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontName()}
   */
  @Test
  void testGetFontName() {
    // Arrange, Act and Assert
    assertNull((new PDFontDescriptor()).getFontName());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontName()}
   */
  @Test
  void testGetFontName2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontName("Font Name");

    // Act and Assert
    assertEquals("Font Name", pdFontDescriptor.getFontName());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontName()}
   */
  @Test
  void testGetFontName3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    String actualFontName = pdFontDescriptor.getFontName();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFontName);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontName(String)}
   */
  @Test
  void testSetFontName() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontName("Font Name");

    // Assert
    assertEquals("Font Name", pdFontDescriptor.getFontName());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontName(String)}
   */
  @Test
  void testSetFontName2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontName(null);

    // Assert
    assertNull(pdFontDescriptor.getFontName());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontName(String)}
   */
  @Test
  void testSetFontName3() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontName("42");

    // Assert
    assertEquals("42", pdFontDescriptor.getFontName());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontName(String)}
   */
  @Test
  void testSetFontName4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setFontName("Font Name");

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Font Name", pdFontDescriptor.getFontName());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontFamily()}
   */
  @Test
  void testGetFontFamily() {
    // Arrange, Act and Assert
    assertNull((new PDFontDescriptor()).getFontFamily());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontFamily()}
   */
  @Test
  void testGetFontFamily2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFamily("Font Family");

    // Act and Assert
    assertEquals("Font Family", pdFontDescriptor.getFontFamily());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontFamily()}
   */
  @Test
  void testGetFontFamily3() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFamily("");

    // Act and Assert
    assertEquals("", pdFontDescriptor.getFontFamily());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontFamily()}
   */
  @Test
  void testGetFontFamily4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    String actualFontFamily = pdFontDescriptor.getFontFamily();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFontFamily);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontFamily(String)}
   */
  @Test
  void testSetFontFamily() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontFamily("Font Family");

    // Assert
    assertEquals("Font Family", pdFontDescriptor.getFontFamily());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontFamily(String)}
   */
  @Test
  void testSetFontFamily2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontFamily(null);

    // Assert
    assertNull(pdFontDescriptor.getFontFamily());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontFamily(String)}
   */
  @Test
  void testSetFontFamily3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setFontFamily("Font Family");

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Font Family", pdFontDescriptor.getFontFamily());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontWeight()}
   */
  @Test
  void testGetFontWeight() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDFontDescriptor()).getFontWeight());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontWeight()}
   */
  @Test
  void testGetFontWeight2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontWeight(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdFontDescriptor.getFontWeight());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontWeight()}
   */
  @Test
  void testGetFontWeight3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    float actualFontWeight = pdFontDescriptor.getFontWeight();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0f, actualFontWeight);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontWeight(float)}
   */
  @Test
  void testSetFontWeight() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontWeight(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getFontWeight());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontWeight(float)}
   */
  @Test
  void testSetFontWeight2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setFontWeight(10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(10.0f, pdFontDescriptor.getFontWeight());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontStretch()}
   */
  @Test
  void testGetFontStretch() {
    // Arrange, Act and Assert
    assertNull((new PDFontDescriptor()).getFontStretch());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontStretch()}
   */
  @Test
  void testGetFontStretch2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontStretch("Font Stretch");

    // Act and Assert
    assertEquals("Font Stretch", pdFontDescriptor.getFontStretch());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontStretch()}
   */
  @Test
  void testGetFontStretch3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    String actualFontStretch = pdFontDescriptor.getFontStretch();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFontStretch);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontStretch(String)}
   */
  @Test
  void testSetFontStretch() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontStretch("Font Stretch");

    // Assert
    assertEquals("Font Stretch", pdFontDescriptor.getFontStretch());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontStretch(String)}
   */
  @Test
  void testSetFontStretch2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontStretch(null);

    // Assert
    assertNull(pdFontDescriptor.getFontStretch());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontStretch(String)}
   */
  @Test
  void testSetFontStretch3() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontStretch("Font StretchFont Stretch");

    // Assert
    assertEquals("Font StretchFont Stretch", pdFontDescriptor.getFontStretch());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontStretch(String)}
   */
  @Test
  void testSetFontStretch4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setFontStretch("Font Stretch");

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Font Stretch", pdFontDescriptor.getFontStretch());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFlags()}
   */
  @Test
  void testGetFlags() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDFontDescriptor()).getFlags());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFlags()}
   */
  @Test
  void testGetFlags2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    int actualFlags = pdFontDescriptor.getFlags();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualFlags);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFlags(int)}
   */
  @Test
  void testSetFlags() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFlags(1);

    // Assert
    assertEquals(1, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isAllCap());
    assertTrue(pdFontDescriptor.isFixedPitch());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFlags(int)}
   */
  @Test
  void testSetFlags2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFlags(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdFontDescriptor.isAllCap());
    assertFalse(pdFontDescriptor.isFixedPitch());
    assertEquals(Integer.MIN_VALUE, pdFontDescriptor.getFlags());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFlags(int)}
   */
  @Test
  void testSetFlags3() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFlags(65536);

    // Assert
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(65536, pdFontDescriptor.getFlags());
    assertFalse(pdFontDescriptor.isFixedPitch());
    assertTrue(pdFontDescriptor.isAllCap());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFlags(int)}
   */
  @Test
  void testSetFlags4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setFlags(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, pdFontDescriptor.getFlags());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdFontDescriptor.isAllCap());
    assertTrue(pdFontDescriptor.isFixedPitch());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontBoundingBox()}
   */
  @Test
  void testGetFontBoundingBox() {
    // Arrange, Act and Assert
    assertNull((new PDFontDescriptor()).getFontBoundingBox());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontBoundingBox()}
   */
  @Test
  void testGetFontBoundingBox2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontBoundingBox(PDRectangle.A0);

    // Act
    PDRectangle actualFontBoundingBox = pdFontDescriptor.getFontBoundingBox();

    // Assert
    COSArray cOSArray = actualFontBoundingBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualFontBoundingBox.getLowerLeftX());
    assertEquals(0.0f, actualFontBoundingBox.getLowerLeftY());
    assertEquals(2383.937f, actualFontBoundingBox.getUpperRightX());
    assertEquals(2383.937f, actualFontBoundingBox.getWidth());
    assertEquals(3370.3938f, actualFontBoundingBox.getHeight());
    assertEquals(3370.3938f, actualFontBoundingBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualFontBoundingBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontBoundingBox()}
   */
  @Test
  void testGetFontBoundingBox3() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontBoundingBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualFontBoundingBox = pdFontDescriptor.getFontBoundingBox();

    // Assert
    COSArray cOSArray = actualFontBoundingBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualFontBoundingBox.getHeight());
    assertEquals(0.0f, actualFontBoundingBox.getWidth());
    assertEquals(2.14748365E9f, actualFontBoundingBox.getLowerLeftX());
    assertEquals(2.14748365E9f, actualFontBoundingBox.getLowerLeftY());
    assertEquals(2.14748365E9f, actualFontBoundingBox.getUpperRightX());
    assertEquals(2.14748365E9f, actualFontBoundingBox.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualFontBoundingBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontBoundingBox()}
   */
  @Test
  void testGetFontBoundingBox4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    PDRectangle actualFontBoundingBox = pdFontDescriptor.getFontBoundingBox();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFontBoundingBox);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontBoundingBox(PDRectangle)}
   */
  @Test
  void testSetFontBoundingBox() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontBoundingBox(PDRectangle.A1);

    // Assert
    PDRectangle fontBoundingBox = pdFontDescriptor.getFontBoundingBox();
    assertEquals(0.0f, fontBoundingBox.getLowerLeftX());
    assertEquals(0.0f, fontBoundingBox.getLowerLeftY());
    assertEquals(1683.7795f, fontBoundingBox.getUpperRightX());
    assertEquals(1683.7795f, fontBoundingBox.getWidth());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(2383.937f, fontBoundingBox.getHeight());
    assertEquals(2383.937f, fontBoundingBox.getUpperRightY());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    COSArray expectedCOSObject = fontBoundingBox.getCOSArray();
    assertSame(expectedCOSObject, fontBoundingBox.getCOSObject());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontBoundingBox(PDRectangle)}
   */
  @Test
  void testSetFontBoundingBox2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontBoundingBox(null);

    // Assert
    assertNull(pdFontDescriptor.getFontBoundingBox());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getItalicAngle()}
   */
  @Test
  void testGetItalicAngle() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDFontDescriptor()).getItalicAngle());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getItalicAngle()}
   */
  @Test
  void testGetItalicAngle2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setItalicAngle(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdFontDescriptor.getItalicAngle());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getItalicAngle()}
   */
  @Test
  void testGetItalicAngle3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    float actualItalicAngle = pdFontDescriptor.getItalicAngle();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0f, actualItalicAngle);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setItalicAngle(float)}
   */
  @Test
  void testSetItalicAngle() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setItalicAngle(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getItalicAngle());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setItalicAngle(float)}
   */
  @Test
  void testSetItalicAngle2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setItalicAngle(10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(10.0f, pdFontDescriptor.getItalicAngle());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getAscent()}
   */
  @Test
  void testGetAscent() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDFontDescriptor()).getAscent());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getAscent()}
   */
  @Test
  void testGetAscent2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setAscent(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdFontDescriptor.getAscent());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getAscent()}
   */
  @Test
  void testGetAscent3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    float actualAscent = pdFontDescriptor.getAscent();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0f, actualAscent);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setAscent(float)}
   */
  @Test
  void testSetAscent() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setAscent(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getAscent());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setAscent(float)}
   */
  @Test
  void testSetAscent2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setAscent(10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(10.0f, pdFontDescriptor.getAscent());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getDescent()}
   */
  @Test
  void testGetDescent() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDFontDescriptor()).getDescent());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getDescent()}
   */
  @Test
  void testGetDescent2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setDescent(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdFontDescriptor.getDescent());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getDescent()}
   */
  @Test
  void testGetDescent3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    float actualDescent = pdFontDescriptor.getDescent();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0f, actualDescent);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setDescent(float)}
   */
  @Test
  void testSetDescent() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setDescent(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getDescent());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setDescent(float)}
   */
  @Test
  void testSetDescent2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setDescent(10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(10.0f, pdFontDescriptor.getDescent());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getLeading()}
   */
  @Test
  void testGetLeading() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDFontDescriptor()).getLeading());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getLeading()}
   */
  @Test
  void testGetLeading2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setLeading(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdFontDescriptor.getLeading());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getLeading()}
   */
  @Test
  void testGetLeading3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    float actualLeading = pdFontDescriptor.getLeading();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0f, actualLeading);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setLeading(float)}
   */
  @Test
  void testSetLeading() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setLeading(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getLeading());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setLeading(float)}
   */
  @Test
  void testSetLeading2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setLeading(10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(10.0f, pdFontDescriptor.getLeading());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getCapHeight()}
   */
  @Test
  void testGetCapHeight() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDFontDescriptor()).getCapHeight());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getCapHeight()}
   */
  @Test
  void testGetCapHeight2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    float actualCapHeight = pdFontDescriptor.getCapHeight();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0f, actualCapHeight);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setCapHeight(float)}
   */
  @Test
  void testSetCapHeight() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setCapHeight(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getCapHeight());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setCapHeight(float)}
   */
  @Test
  void testSetCapHeight2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setCapHeight(10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(10.0f, pdFontDescriptor.getCapHeight());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getXHeight()}
   */
  @Test
  void testGetXHeight() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDFontDescriptor()).getXHeight());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getXHeight()}
   */
  @Test
  void testGetXHeight2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    float actualXHeight = pdFontDescriptor.getXHeight();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0f, actualXHeight);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setXHeight(float)}
   */
  @Test
  void testSetXHeight() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setXHeight(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getXHeight());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setXHeight(float)}
   */
  @Test
  void testSetXHeight2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setXHeight(10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(10.0f, pdFontDescriptor.getXHeight());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getStemV()}
   */
  @Test
  void testGetStemV() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDFontDescriptor()).getStemV());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getStemV()}
   */
  @Test
  void testGetStemV2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setStemV(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdFontDescriptor.getStemV());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getStemV()}
   */
  @Test
  void testGetStemV3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    float actualStemV = pdFontDescriptor.getStemV();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0f, actualStemV);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setStemV(float)}
   */
  @Test
  void testSetStemV() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setStemV(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getStemV());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setStemV(float)}
   */
  @Test
  void testSetStemV2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setStemV(10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(10.0f, pdFontDescriptor.getStemV());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getStemH()}
   */
  @Test
  void testGetStemH() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDFontDescriptor()).getStemH());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getStemH()}
   */
  @Test
  void testGetStemH2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setStemH(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdFontDescriptor.getStemH());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getStemH()}
   */
  @Test
  void testGetStemH3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    float actualStemH = pdFontDescriptor.getStemH();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0f, actualStemH);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setStemH(float)}
   */
  @Test
  void testSetStemH() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setStemH(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getStemH());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setStemH(float)}
   */
  @Test
  void testSetStemH2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setStemH(10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(10.0f, pdFontDescriptor.getStemH());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getAverageWidth()}
   */
  @Test
  void testGetAverageWidth() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDFontDescriptor()).getAverageWidth());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getAverageWidth()}
   */
  @Test
  void testGetAverageWidth2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setAverageWidth(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdFontDescriptor.getAverageWidth());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getAverageWidth()}
   */
  @Test
  void testGetAverageWidth3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    float actualAverageWidth = pdFontDescriptor.getAverageWidth();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0f, actualAverageWidth);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setAverageWidth(float)}
   */
  @Test
  void testSetAverageWidth() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setAverageWidth(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getAverageWidth());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setAverageWidth(float)}
   */
  @Test
  void testSetAverageWidth2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setAverageWidth(10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(10.0f, pdFontDescriptor.getAverageWidth());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getMaxWidth()}
   */
  @Test
  void testGetMaxWidth() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDFontDescriptor()).getMaxWidth());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getMaxWidth()}
   */
  @Test
  void testGetMaxWidth2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setMaxWidth(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdFontDescriptor.getMaxWidth());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getMaxWidth()}
   */
  @Test
  void testGetMaxWidth3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    float actualMaxWidth = pdFontDescriptor.getMaxWidth();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0f, actualMaxWidth);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setMaxWidth(float)}
   */
  @Test
  void testSetMaxWidth() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setMaxWidth(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getMaxWidth());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setMaxWidth(float)}
   */
  @Test
  void testSetMaxWidth2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setMaxWidth(10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(10.0f, pdFontDescriptor.getMaxWidth());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#hasWidths()}
   */
  @Test
  void testHasWidths() {
    // Arrange, Act and Assert
    assertFalse((new PDFontDescriptor()).hasWidths());
  }

  /**
   * Method under test: {@link PDFontDescriptor#hasWidths()}
   */
  @Test
  void testHasWidths2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setMissingWidth(10.0f);

    // Act and Assert
    assertTrue(pdFontDescriptor.hasWidths());
  }

  /**
   * Method under test: {@link PDFontDescriptor#hasWidths()}
   */
  @Test
  void testHasWidths3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    boolean actualHasWidthsResult = pdFontDescriptor.hasWidths();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualHasWidthsResult);
  }

  /**
   * Method under test: {@link PDFontDescriptor#hasMissingWidth()}
   */
  @Test
  void testHasMissingWidth() {
    // Arrange, Act and Assert
    assertFalse((new PDFontDescriptor()).hasMissingWidth());
  }

  /**
   * Method under test: {@link PDFontDescriptor#hasMissingWidth()}
   */
  @Test
  void testHasMissingWidth2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setMissingWidth(10.0f);

    // Act and Assert
    assertTrue(pdFontDescriptor.hasMissingWidth());
  }

  /**
   * Method under test: {@link PDFontDescriptor#hasMissingWidth()}
   */
  @Test
  void testHasMissingWidth3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    boolean actualHasMissingWidthResult = pdFontDescriptor.hasMissingWidth();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualHasMissingWidthResult);
  }

  /**
   * Method under test: {@link PDFontDescriptor#getMissingWidth()}
   */
  @Test
  void testGetMissingWidth() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDFontDescriptor()).getMissingWidth());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getMissingWidth()}
   */
  @Test
  void testGetMissingWidth2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setMissingWidth(10.0f);

    // Act and Assert
    assertEquals(10.0f, pdFontDescriptor.getMissingWidth());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getMissingWidth()}
   */
  @Test
  void testGetMissingWidth3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    float actualMissingWidth = pdFontDescriptor.getMissingWidth();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0.0f, actualMissingWidth);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setMissingWidth(float)}
   */
  @Test
  void testSetMissingWidth() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setMissingWidth(10.0f);

    // Assert
    assertEquals(10.0f, pdFontDescriptor.getMissingWidth());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setMissingWidth(float)}
   */
  @Test
  void testSetMissingWidth2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setMissingWidth(10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(10.0f, pdFontDescriptor.getMissingWidth());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getCharSet()}
   */
  @Test
  void testGetCharSet() {
    // Arrange, Act and Assert
    assertNull((new PDFontDescriptor()).getCharSet());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getCharSet()}
   */
  @Test
  void testGetCharSet2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setCharacterSet("Char Set");

    // Act and Assert
    assertEquals("Char Set", pdFontDescriptor.getCharSet());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getCharSet()}
   */
  @Test
  void testGetCharSet3() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setCharacterSet("");

    // Act and Assert
    assertEquals("", pdFontDescriptor.getCharSet());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getCharSet()}
   */
  @Test
  void testGetCharSet4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    String actualCharSet = pdFontDescriptor.getCharSet();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualCharSet);
  }

  /**
   * Method under test: {@link PDFontDescriptor#setCharacterSet(String)}
   */
  @Test
  void testSetCharacterSet() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setCharacterSet("Char Set");

    // Assert
    assertEquals("Char Set", pdFontDescriptor.getCharSet());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setCharacterSet(String)}
   */
  @Test
  void testSetCharacterSet2() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setCharacterSet(null);

    // Assert
    assertNull(pdFontDescriptor.getCharSet());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setCharacterSet(String)}
   */
  @Test
  void testSetCharacterSet3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    pdFontDescriptor.setCharacterSet("Char Set");

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Char Set", pdFontDescriptor.getCharSet());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontFile()}
   */
  @Test
  void testGetFontFile() {
    // Arrange, Act and Assert
    assertNull((new PDFontDescriptor()).getFontFile());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontFile()}
   */
  @Test
  void testGetFontFile2() throws IOException {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(new PDStream(new COSDocument()));

    // Act
    PDStream actualFontFile = pdFontDescriptor.getFontFile();

    // Assert
    assertNull(actualFontFile.getDecodeParms());
    assertNull(actualFontFile.getFileDecodeParams());
    COSStream cOSObject = actualFontFile.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFontFile.getMetadata());
    assertNull(actualFontFile.getFile());
    assertEquals(-1, actualFontFile.getDecodedStreamLength());
    assertEquals(0, actualFontFile.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualFontFile.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, actualFontFile.getFilters());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontFile()}
   */
  @Test
  void testGetFontFile3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    PDStream actualFontFile = pdFontDescriptor.getFontFile();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFontFile.getDecodeParms());
    assertNull(actualFontFile.getFileDecodeParams());
    COSStream cOSObject = actualFontFile.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFontFile.getMetadata());
    assertNull(actualFontFile.getFile());
    assertEquals(-1, actualFontFile.getDecodedStreamLength());
    assertEquals(0, actualFontFile.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualFontFile.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, actualFontFile.getFilters());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontFile(PDStream)}
   */
  @Test
  void testSetFontFile() throws IOException {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontFile(new PDStream(new COSDocument()));

    // Assert
    PDStream fontFile = pdFontDescriptor.getFontFile();
    assertNull(fontFile.getDecodeParms());
    assertNull(fontFile.getFileDecodeParams());
    assertNull(fontFile.getMetadata());
    assertNull(fontFile.getFile());
    assertEquals(-1, fontFile.getDecodedStreamLength());
    assertEquals(0, fontFile.getLength());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontFile(PDStream)}
   */
  @Test
  void testSetFontFile2() throws IOException {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdFontDescriptor.setFontFile(new PDStream(new COSDocument(streamCacheCreateFunction)));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDStream fontFile = pdFontDescriptor.getFontFile();
    assertNull(fontFile.getDecodeParms());
    assertNull(fontFile.getFileDecodeParams());
    assertNull(fontFile.getMetadata());
    assertNull(fontFile.getFile());
    assertEquals(-1, fontFile.getDecodedStreamLength());
    assertEquals(0, fontFile.getLength());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontFile(PDStream)}
   */
  @Test
  void testSetFontFile3() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontFile(null);

    // Assert
    assertNull(pdFontDescriptor.getFontFile());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontFile2()}
   */
  @Test
  void testGetFontFile22() {
    // Arrange, Act and Assert
    assertNull((new PDFontDescriptor()).getFontFile2());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontFile2()}
   */
  @Test
  void testGetFontFile23() throws IOException {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile2(new PDStream(new COSDocument()));

    // Act
    PDStream actualFontFile2 = pdFontDescriptor.getFontFile2();

    // Assert
    assertNull(actualFontFile2.getDecodeParms());
    assertNull(actualFontFile2.getFileDecodeParams());
    COSStream cOSObject = actualFontFile2.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFontFile2.getMetadata());
    assertNull(actualFontFile2.getFile());
    assertEquals(-1, actualFontFile2.getDecodedStreamLength());
    assertEquals(0, actualFontFile2.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualFontFile2.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, actualFontFile2.getFilters());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontFile2()}
   */
  @Test
  void testGetFontFile24() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream ttfStream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile2(ttfStream);

    // Act
    PDStream actualFontFile2 = pdFontDescriptor.getFontFile2();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFontFile2.getDecodeParms());
    assertNull(actualFontFile2.getFileDecodeParams());
    COSStream cOSObject = actualFontFile2.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFontFile2.getMetadata());
    assertNull(actualFontFile2.getFile());
    assertEquals(-1, actualFontFile2.getDecodedStreamLength());
    assertEquals(0, actualFontFile2.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualFontFile2.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, actualFontFile2.getFilters());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontFile2(PDStream)}
   */
  @Test
  void testSetFontFile22() throws IOException {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontFile2(new PDStream(new COSDocument()));

    // Assert
    PDStream fontFile2 = pdFontDescriptor.getFontFile2();
    assertNull(fontFile2.getDecodeParms());
    assertNull(fontFile2.getFileDecodeParams());
    assertNull(fontFile2.getMetadata());
    assertNull(fontFile2.getFile());
    assertEquals(-1, fontFile2.getDecodedStreamLength());
    assertEquals(0, fontFile2.getLength());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontFile2(PDStream)}
   */
  @Test
  void testSetFontFile23() throws IOException {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdFontDescriptor.setFontFile2(new PDStream(new COSDocument(streamCacheCreateFunction)));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDStream fontFile2 = pdFontDescriptor.getFontFile2();
    assertNull(fontFile2.getDecodeParms());
    assertNull(fontFile2.getFileDecodeParams());
    assertNull(fontFile2.getMetadata());
    assertNull(fontFile2.getFile());
    assertEquals(-1, fontFile2.getDecodedStreamLength());
    assertEquals(0, fontFile2.getLength());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontFile2(PDStream)}
   */
  @Test
  void testSetFontFile24() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontFile2(null);

    // Assert
    assertNull(pdFontDescriptor.getFontFile2());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontFile3()}
   */
  @Test
  void testGetFontFile32() {
    // Arrange, Act and Assert
    assertNull((new PDFontDescriptor()).getFontFile3());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontFile3()}
   */
  @Test
  void testGetFontFile33() throws IOException {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile3(new PDStream(new COSDocument()));

    // Act
    PDStream actualFontFile3 = pdFontDescriptor.getFontFile3();

    // Assert
    assertNull(actualFontFile3.getDecodeParms());
    assertNull(actualFontFile3.getFileDecodeParams());
    COSStream cOSObject = actualFontFile3.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFontFile3.getMetadata());
    assertNull(actualFontFile3.getFile());
    assertEquals(-1, actualFontFile3.getDecodedStreamLength());
    assertEquals(0, actualFontFile3.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualFontFile3.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, actualFontFile3.getFilters());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getFontFile3()}
   */
  @Test
  void testGetFontFile34() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile3(stream);

    // Act
    PDStream actualFontFile3 = pdFontDescriptor.getFontFile3();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFontFile3.getDecodeParms());
    assertNull(actualFontFile3.getFileDecodeParams());
    COSStream cOSObject = actualFontFile3.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFontFile3.getMetadata());
    assertNull(actualFontFile3.getFile());
    assertEquals(-1, actualFontFile3.getDecodedStreamLength());
    assertEquals(0, actualFontFile3.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualFontFile3.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, actualFontFile3.getFilters());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontFile3(PDStream)}
   */
  @Test
  void testSetFontFile32() throws IOException {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontFile3(new PDStream(new COSDocument()));

    // Assert
    PDStream fontFile3 = pdFontDescriptor.getFontFile3();
    assertNull(fontFile3.getDecodeParms());
    assertNull(fontFile3.getFileDecodeParams());
    assertNull(fontFile3.getMetadata());
    assertNull(fontFile3.getFile());
    assertEquals(-1, fontFile3.getDecodedStreamLength());
    assertEquals(0, fontFile3.getLength());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontFile3(PDStream)}
   */
  @Test
  void testSetFontFile33() throws IOException {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdFontDescriptor.setFontFile3(new PDStream(new COSDocument(streamCacheCreateFunction)));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDStream fontFile3 = pdFontDescriptor.getFontFile3();
    assertNull(fontFile3.getDecodeParms());
    assertNull(fontFile3.getFileDecodeParams());
    assertNull(fontFile3.getMetadata());
    assertNull(fontFile3.getFile());
    assertEquals(-1, fontFile3.getDecodedStreamLength());
    assertEquals(0, fontFile3.getLength());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setFontFile3(PDStream)}
   */
  @Test
  void testSetFontFile34() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setFontFile3(null);

    // Assert
    assertNull(pdFontDescriptor.getFontFile3());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getCIDSet()}
   */
  @Test
  void testGetCIDSet() {
    // Arrange, Act and Assert
    assertNull((new PDFontDescriptor()).getCIDSet());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getCIDSet()}
   */
  @Test
  void testGetCIDSet2() throws IOException {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setCIDSet(new PDStream(new COSDocument()));

    // Act
    PDStream actualCIDSet = pdFontDescriptor.getCIDSet();

    // Assert
    assertNull(actualCIDSet.getDecodeParms());
    assertNull(actualCIDSet.getFileDecodeParams());
    COSStream cOSObject = actualCIDSet.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualCIDSet.getMetadata());
    assertNull(actualCIDSet.getFile());
    assertEquals(-1, actualCIDSet.getDecodedStreamLength());
    assertEquals(0, actualCIDSet.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualCIDSet.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, actualCIDSet.getFilters());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getCIDSet()}
   */
  @Test
  void testGetCIDSet3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setCIDSet(stream);

    // Act
    PDStream actualCIDSet = pdFontDescriptor.getCIDSet();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualCIDSet.getDecodeParms());
    assertNull(actualCIDSet.getFileDecodeParams());
    COSStream cOSObject = actualCIDSet.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualCIDSet.getMetadata());
    assertNull(actualCIDSet.getFile());
    assertEquals(-1, actualCIDSet.getDecodedStreamLength());
    assertEquals(0, actualCIDSet.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualCIDSet.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, actualCIDSet.getFilters());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setCIDSet(PDStream)}
   */
  @Test
  void testSetCIDSet() throws IOException {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setCIDSet(new PDStream(new COSDocument()));

    // Assert
    PDStream cIDSet = pdFontDescriptor.getCIDSet();
    assertNull(cIDSet.getDecodeParms());
    assertNull(cIDSet.getFileDecodeParams());
    assertNull(cIDSet.getMetadata());
    assertNull(cIDSet.getFile());
    assertEquals(-1, cIDSet.getDecodedStreamLength());
    assertEquals(0, cIDSet.getLength());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setCIDSet(PDStream)}
   */
  @Test
  void testSetCIDSet2() throws IOException {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdFontDescriptor.setCIDSet(new PDStream(new COSDocument(streamCacheCreateFunction)));

    // Assert
    verify(streamCacheCreateFunction).create();
    PDStream cIDSet = pdFontDescriptor.getCIDSet();
    assertNull(cIDSet.getDecodeParms());
    assertNull(cIDSet.getFileDecodeParams());
    assertNull(cIDSet.getMetadata());
    assertNull(cIDSet.getFile());
    assertEquals(-1, cIDSet.getDecodedStreamLength());
    assertEquals(0, cIDSet.getLength());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#setCIDSet(PDStream)}
   */
  @Test
  void testSetCIDSet3() {
    // Arrange
    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();

    // Act
    pdFontDescriptor.setCIDSet(null);

    // Assert
    assertNull(pdFontDescriptor.getCIDSet());
    COSDictionary cOSObject = pdFontDescriptor.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getPanose()}
   */
  @Test
  void testGetPanose() {
    // Arrange, Act and Assert
    assertNull((new PDFontDescriptor()).getPanose());
  }

  /**
   * Method under test: {@link PDFontDescriptor#getPanose()}
   */
  @Test
  void testGetPanose2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream type1Stream = new PDStream(new COSDocument(streamCacheCreateFunction));

    PDFontDescriptor pdFontDescriptor = new PDFontDescriptor();
    pdFontDescriptor.setFontFile(type1Stream);

    // Act
    PDPanose actualPanose = pdFontDescriptor.getPanose();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPanose);
  }

  /**
   * Method under test: {@link PDFontDescriptor#PDFontDescriptor(COSDictionary)}
   */
  @Test
  void testNewPDFontDescriptor() {
    // Arrange
    COSDictionary desc = new COSDictionary();

    // Act and Assert
    assertSame(desc, (new PDFontDescriptor(desc)).getCOSObject());
  }

  /**
   * Method under test: {@link PDFontDescriptor#PDFontDescriptor()}
   */
  @Test
  void testNewPDFontDescriptor2() {
    // Arrange and Act
    PDFontDescriptor actualPdFontDescriptor = new PDFontDescriptor();

    // Assert
    assertNull(actualPdFontDescriptor.getCharSet());
    assertNull(actualPdFontDescriptor.getFontFamily());
    assertNull(actualPdFontDescriptor.getFontName());
    assertNull(actualPdFontDescriptor.getFontStretch());
    COSDictionary cOSObject = actualPdFontDescriptor.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdFontDescriptor.getFontBoundingBox());
    assertNull(actualPdFontDescriptor.getCIDSet());
    assertNull(actualPdFontDescriptor.getFontFile());
    assertNull(actualPdFontDescriptor.getFontFile2());
    assertNull(actualPdFontDescriptor.getFontFile3());
    assertNull(actualPdFontDescriptor.getPanose());
    assertEquals(0, actualPdFontDescriptor.getFlags());
    assertEquals(0.0f, actualPdFontDescriptor.getAscent());
    assertEquals(0.0f, actualPdFontDescriptor.getAverageWidth());
    assertEquals(0.0f, actualPdFontDescriptor.getCapHeight());
    assertEquals(0.0f, actualPdFontDescriptor.getDescent());
    assertEquals(0.0f, actualPdFontDescriptor.getFontWeight());
    assertEquals(0.0f, actualPdFontDescriptor.getItalicAngle());
    assertEquals(0.0f, actualPdFontDescriptor.getLeading());
    assertEquals(0.0f, actualPdFontDescriptor.getMaxWidth());
    assertEquals(0.0f, actualPdFontDescriptor.getMissingWidth());
    assertEquals(0.0f, actualPdFontDescriptor.getStemH());
    assertEquals(0.0f, actualPdFontDescriptor.getStemV());
    assertEquals(0.0f, actualPdFontDescriptor.getXHeight());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdFontDescriptor.isAllCap());
    assertFalse(actualPdFontDescriptor.isFixedPitch());
    assertFalse(actualPdFontDescriptor.isForceBold());
    assertFalse(actualPdFontDescriptor.isItalic());
    assertFalse(actualPdFontDescriptor.isNonSymbolic());
    assertFalse(actualPdFontDescriptor.isScript());
    assertFalse(actualPdFontDescriptor.isSerif());
    assertFalse(actualPdFontDescriptor.isSmallCap());
    assertFalse(actualPdFontDescriptor.isSymbolic());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}
