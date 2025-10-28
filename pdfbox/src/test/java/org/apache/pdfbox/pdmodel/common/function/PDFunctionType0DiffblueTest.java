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
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.common.PDRange;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.Test;

class PDFunctionType0DiffblueTest {
  /**
   * Method under test: {@link PDFunctionType0#getFunctionType()}
   */
  @Test
  void testGetFunctionType() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDFunctionType0(COSBoolean.FALSE)).getFunctionType());
  }

  /**
   * Method under test: {@link PDFunctionType0#getSize()}
   */
  @Test
  void testGetSize() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType0(new COSDictionary())).getSize());
    assertNull((new PDFunctionType0(new COSStream())).getSize());
  }

  /**
   * Method under test: {@link PDFunctionType0#getBitsPerSample()}
   */
  @Test
  void testGetBitsPerSample() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDFunctionType0(new COSDictionary())).getBitsPerSample());
    assertEquals(-1, (new PDFunctionType0(new COSStream())).getBitsPerSample());
  }

  /**
   * Method under test: {@link PDFunctionType0#getOrder()}
   */
  @Test
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(1, (new PDFunctionType0(new COSDictionary())).getOrder());
    assertEquals(1, (new PDFunctionType0(new COSStream())).getOrder());
  }

  /**
   * Method under test: {@link PDFunctionType0#setBitsPerSample(int)}
   */
  @Test
  void testSetBitsPerSample() {
    // Arrange
    COSDictionary function = new COSDictionary();
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(function);

    // Act
    pdFunctionType0.setBitsPerSample(1);

    // Assert
    assertEquals(1, pdFunctionType0.getBitsPerSample());
    assertSame(function, pdFunctionType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunctionType0#setBitsPerSample(int)}
   */
  @Test
  void testSetBitsPerSample2() {
    // Arrange
    COSStream function = new COSStream();
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(function);

    // Act
    pdFunctionType0.setBitsPerSample(1);

    // Assert
    assertEquals(1, pdFunctionType0.getBitsPerSample());
    assertSame(function, pdFunctionType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunctionType0#setBitsPerSample(int)}
   */
  @Test
  void testSetBitsPerSample3() {
    // Arrange
    COSStream function = new COSStream();
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(function);

    // Act
    pdFunctionType0.setBitsPerSample(Integer.MIN_VALUE);

    // Assert
    assertEquals(Integer.MIN_VALUE, pdFunctionType0.getBitsPerSample());
    assertSame(function, pdFunctionType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunctionType0#getEncodeForParameter(int)}
   */
  @Test
  void testGetEncodeForParameter() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());
    pdFunctionType0.setEncodeValues(new COSArray());

    // Act and Assert
    assertNull(pdFunctionType0.getEncodeForParameter(10));
  }

  /**
   * Method under test: {@link PDFunctionType0#getEncodeForParameter(int)}
   */
  @Test
  void testGetEncodeForParameter2() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());
    COSArray encodeValues = new COSArray();
    pdFunctionType0.setEncodeValues(encodeValues);

    // Act
    PDRange actualEncodeForParameter = pdFunctionType0.getEncodeForParameter(-1);

    // Assert
    COSArray cOSArray = actualEncodeForParameter.getCOSArray();
    assertTrue(cOSArray.toList().isEmpty());
    assertSame(encodeValues, cOSArray);
    assertSame(encodeValues, actualEncodeForParameter.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunctionType0#setEncodeValues(COSArray)}
   */
  @Test
  void testSetEncodeValues() {
    // Arrange
    COSDictionary function = new COSDictionary();
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(function);

    // Act
    pdFunctionType0.setEncodeValues(new COSArray());

    // Assert
    assertSame(function, pdFunctionType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunctionType0#setEncodeValues(COSArray)}
   */
  @Test
  void testSetEncodeValues2() {
    // Arrange
    COSStream function = new COSStream();
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(function);

    // Act
    pdFunctionType0.setEncodeValues(new COSArray());

    // Assert
    assertSame(function, pdFunctionType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunctionType0#setEncodeValues(COSArray)}
   */
  @Test
  void testSetEncodeValues3() {
    // Arrange
    COSStream function = new COSStream();
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(function);

    // Act
    pdFunctionType0.setEncodeValues(null);

    // Assert
    assertSame(function, pdFunctionType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunctionType0#setEncodeValues(COSArray)}
   */
  @Test
  void testSetEncodeValues4() {
    // Arrange
    COSDictionary function = new COSDictionary();
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(function);

    COSArray encodeValues = new COSArray();
    encodeValues.setDirect(false);
    encodeValues.setKey(null);

    // Act
    pdFunctionType0.setEncodeValues(encodeValues);

    // Assert
    assertSame(function, pdFunctionType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunctionType0#setEncodeValues(COSArray)}
   */
  @Test
  void testSetEncodeValues5() {
    // Arrange
    COSDictionary function = new COSDictionary();
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(function);

    COSArray encodeValues = new COSArray();
    encodeValues.setDirect(false);
    encodeValues.setKey(new COSObjectKey(1L, 1));

    // Act
    pdFunctionType0.setEncodeValues(encodeValues);

    // Assert
    assertSame(function, pdFunctionType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunctionType0#getDecodeForParameter(int)}
   */
  @Test
  void testGetDecodeForParameter() {
    // Arrange, Act and Assert
    assertNull((new PDFunctionType0(new COSDictionary())).getDecodeForParameter(10));
    assertNull((new PDFunctionType0(new COSStream())).getDecodeForParameter(10));
  }

  /**
   * Method under test: {@link PDFunctionType0#getDecodeForParameter(int)}
   */
  @Test
  void testGetDecodeForParameter2() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());
    pdFunctionType0.setDecodeValues(new COSArray());

    // Act and Assert
    assertNull(pdFunctionType0.getDecodeForParameter(10));
  }

  /**
   * Method under test: {@link PDFunctionType0#getDecodeForParameter(int)}
   */
  @Test
  void testGetDecodeForParameter3() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());
    pdFunctionType0.setRangeValues(new COSArray());

    // Act and Assert
    assertNull(pdFunctionType0.getDecodeForParameter(10));
  }

  /**
   * Method under test: {@link PDFunctionType0#getDecodeForParameter(int)}
   */
  @Test
  void testGetDecodeForParameter4() {
    // Arrange
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(new COSStream());
    COSArray decodeValues = new COSArray();
    pdFunctionType0.setDecodeValues(decodeValues);

    // Act
    PDRange actualDecodeForParameter = pdFunctionType0.getDecodeForParameter(-1);

    // Assert
    COSArray cOSArray = actualDecodeForParameter.getCOSArray();
    assertTrue(cOSArray.toList().isEmpty());
    assertSame(decodeValues, cOSArray);
    assertSame(decodeValues, actualDecodeForParameter.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunctionType0#setDecodeValues(COSArray)}
   */
  @Test
  void testSetDecodeValues() {
    // Arrange
    COSDictionary function = new COSDictionary();
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(function);

    // Act
    pdFunctionType0.setDecodeValues(new COSArray());

    // Assert
    assertSame(function, pdFunctionType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunctionType0#setDecodeValues(COSArray)}
   */
  @Test
  void testSetDecodeValues2() {
    // Arrange
    COSStream function = new COSStream();
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(function);

    // Act
    pdFunctionType0.setDecodeValues(new COSArray());

    // Assert
    assertSame(function, pdFunctionType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunctionType0#setDecodeValues(COSArray)}
   */
  @Test
  void testSetDecodeValues3() {
    // Arrange
    COSStream function = new COSStream();
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(function);

    // Act
    pdFunctionType0.setDecodeValues(null);

    // Assert
    assertSame(function, pdFunctionType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunctionType0#setDecodeValues(COSArray)}
   */
  @Test
  void testSetDecodeValues4() {
    // Arrange
    COSDictionary function = new COSDictionary();
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(function);

    COSArray decodeValues = new COSArray();
    decodeValues.setDirect(false);
    decodeValues.setKey(null);

    // Act
    pdFunctionType0.setDecodeValues(decodeValues);

    // Assert
    assertSame(function, pdFunctionType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunctionType0#setDecodeValues(COSArray)}
   */
  @Test
  void testSetDecodeValues5() {
    // Arrange
    COSDictionary function = new COSDictionary();
    PDFunctionType0 pdFunctionType0 = new PDFunctionType0(function);

    COSArray decodeValues = new COSArray();
    decodeValues.setDirect(false);
    decodeValues.setKey(new COSObjectKey(1L, 1));

    // Act
    pdFunctionType0.setDecodeValues(decodeValues);

    // Assert
    assertSame(function, pdFunctionType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunctionType0#PDFunctionType0(COSBase)}
   */
  @Test
  void testNewPDFunctionType0() {
    // Arrange and Act
    PDFunctionType0 actualPdFunctionType0 = new PDFunctionType0(COSBoolean.FALSE);

    // Assert
    assertNull(actualPdFunctionType0.getCOSObject());
    assertNull(actualPdFunctionType0.getPDStream());
    assertEquals(0, actualPdFunctionType0.getFunctionType());
  }

  /**
   * Method under test: {@link PDFunctionType0#PDFunctionType0(COSBase)}
   */
  @Test
  void testNewPDFunctionType02() throws IOException {
    // Arrange
    COSStream function = new COSStream();

    // Act
    PDFunctionType0 actualPdFunctionType0 = new PDFunctionType0(function);

    // Assert
    PDStream pDStream = actualPdFunctionType0.getPDStream();
    assertNull(pDStream.getDecodeParms());
    assertNull(pDStream.getFileDecodeParams());
    assertNull(actualPdFunctionType0.getRangeValues());
    assertNull(actualPdFunctionType0.getSize());
    assertNull(pDStream.getMetadata());
    assertNull(pDStream.getFile());
    assertEquals(-1, pDStream.getDecodedStreamLength());
    assertEquals(-1, actualPdFunctionType0.getBitsPerSample());
    assertEquals(0, pDStream.getLength());
    assertEquals(0, actualPdFunctionType0.getNumberOfOutputParameters());
    assertEquals(0, actualPdFunctionType0.getFunctionType());
    assertEquals(1, actualPdFunctionType0.getOrder());
    assertEquals(2, function.size());
    List<String> fileFilters = pDStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(function, pDStream.getCOSObject());
    assertSame(function, actualPdFunctionType0.getCOSObject());
    assertSame(fileFilters, pDStream.getFilters());
  }

  /**
   * Method under test: {@link PDFunctionType0#PDFunctionType0(COSBase)}
   */
  @Test
  void testNewPDFunctionType03() {
    // Arrange
    COSDictionary function = new COSDictionary();

    // Act
    PDFunctionType0 actualPdFunctionType0 = new PDFunctionType0(function);

    // Assert
    assertNull(actualPdFunctionType0.getRangeValues());
    assertNull(actualPdFunctionType0.getSize());
    assertNull(actualPdFunctionType0.getPDStream());
    assertEquals(-1, actualPdFunctionType0.getBitsPerSample());
    assertEquals(0, actualPdFunctionType0.getNumberOfOutputParameters());
    assertEquals(0, actualPdFunctionType0.getFunctionType());
    assertEquals(1, actualPdFunctionType0.getOrder());
    assertSame(function, actualPdFunctionType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDFunctionType0#PDFunctionType0(COSBase)}
   */
  @Test
  void testNewPDFunctionType04() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDFunctionType0 actualPdFunctionType0 = new PDFunctionType0(new COSDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdFunctionType0.getCOSObject());
    assertNull(actualPdFunctionType0.getPDStream());
    assertEquals(0, actualPdFunctionType0.getFunctionType());
  }
}
