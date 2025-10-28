package org.apache.pdfbox.pdmodel.common.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.Test;

class PDFunctionType3DiffblueTest {
  /**
   * Method under test: {@link PDFunctionType3#getFunctionType()}
   */
  @Test
  void testGetFunctionType() {
    // Arrange, Act and Assert
    assertEquals(3, (new PDFunctionType3(COSBoolean.FALSE)).getFunctionType());
  }

  /**
   * Method under test: {@link PDFunctionType3#getFunctions()}
   */
  @Test
  void testGetFunctions() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType3(new COSDictionary())).getFunctions());
    assertNull((new PDFunctionType3(new COSStream())).getFunctions());
  }

  /**
   * Method under test: {@link PDFunctionType3#getBounds()}
   */
  @Test
  void testGetBounds() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType3(new COSDictionary())).getBounds());
    assertNull((new PDFunctionType3(new COSStream())).getBounds());
  }

  /**
   * Method under test: {@link PDFunctionType3#getEncode()}
   */
  @Test
  void testGetEncode() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType3(new COSDictionary())).getEncode());
    assertNull((new PDFunctionType3(new COSStream())).getEncode());
  }

  /**
   * Method under test: {@link PDFunctionType3#PDFunctionType3(COSBase)}
   */
  @Test
  void testNewPDFunctionType3() {
    // Arrange and Act
    PDFunctionType3 actualPdFunctionType3 = new PDFunctionType3(COSBoolean.FALSE);

    // Assert
    assertNull(actualPdFunctionType3.getCOSObject());
    assertNull(actualPdFunctionType3.getPDStream());
    assertEquals(3, actualPdFunctionType3.getFunctionType());
  }

  /**
   * Method under test: {@link PDFunctionType3#PDFunctionType3(COSBase)}
   */
  @Test
  void testNewPDFunctionType32() throws IOException {
    // Arrange
    COSStream functionStream = new COSStream();

    // Act
    PDFunctionType3 actualPdFunctionType3 = new PDFunctionType3(functionStream);

    // Assert
    PDStream pDStream = actualPdFunctionType3.getPDStream();
    assertNull(pDStream.getDecodeParms());
    assertNull(pDStream.getFileDecodeParams());
    assertNull(actualPdFunctionType3.getRangeValues());
    assertNull(actualPdFunctionType3.getBounds());
    assertNull(actualPdFunctionType3.getEncode());
    assertNull(actualPdFunctionType3.getFunctions());
    assertNull(pDStream.getMetadata());
    assertNull(pDStream.getFile());
    assertEquals(-1, pDStream.getDecodedStreamLength());
    assertEquals(0, pDStream.getLength());
    assertEquals(0, actualPdFunctionType3.getNumberOfOutputParameters());
    assertEquals(2, functionStream.size());
    assertEquals(3, actualPdFunctionType3.getFunctionType());
    List<String> fileFilters = pDStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(functionStream, pDStream.getCOSObject());
    assertSame(functionStream, actualPdFunctionType3.getCOSObject());
    assertSame(fileFilters, pDStream.getFilters());
  }

  /**
   * Method under test: {@link PDFunctionType3#PDFunctionType3(COSBase)}
   */
  @Test
  void testNewPDFunctionType33() {
    // Arrange
    COSDictionary functionStream = new COSDictionary();

    // Act
    PDFunctionType3 actualPdFunctionType3 = new PDFunctionType3(functionStream);

    // Assert
    assertNull(actualPdFunctionType3.getRangeValues());
    assertNull(actualPdFunctionType3.getBounds());
    assertNull(actualPdFunctionType3.getEncode());
    assertNull(actualPdFunctionType3.getFunctions());
    assertNull(actualPdFunctionType3.getPDStream());
    assertEquals(0, actualPdFunctionType3.getNumberOfOutputParameters());
    assertEquals(3, actualPdFunctionType3.getFunctionType());
    assertSame(functionStream, actualPdFunctionType3.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunctionType3#PDFunctionType3(COSBase)}
   */
  @Test
  void testNewPDFunctionType34() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDFunctionType3 actualPdFunctionType3 = new PDFunctionType3(new COSDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdFunctionType3.getCOSObject());
    assertNull(actualPdFunctionType3.getPDStream());
    assertEquals(3, actualPdFunctionType3.getFunctionType());
  }
}
