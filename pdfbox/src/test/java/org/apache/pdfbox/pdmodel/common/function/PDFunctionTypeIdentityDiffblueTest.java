package org.apache.pdfbox.pdmodel.common.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.Test;

class PDFunctionTypeIdentityDiffblueTest {
  /**
   * Method under test: {@link PDFunctionTypeIdentity#getFunctionType()}
   */
  @Test
  void testGetFunctionType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDFunctionTypeIdentity(COSBoolean.FALSE)).getFunctionType());
  }

  /**
   * Method under test: {@link PDFunctionTypeIdentity#eval(float[])}
   */
  @Test
  void testEval() throws IOException {
    // Arrange
    float[] input = new float[]{10.0f, 0.5f, 10.0f, 0.5f};

    // Act and Assert
    assertSame(input, (new PDFunctionTypeIdentity(COSBoolean.FALSE)).eval(input));
  }

  /**
   * Method under test: {@link PDFunctionTypeIdentity#eval(float[])}
   */
  @Test
  void testEval2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    float[] input = new float[]{10.0f, 0.5f, 10.0f, 0.5f};

    // Act
    float[] actualEvalResult = (new PDFunctionTypeIdentity(new COSDocument(streamCacheCreateFunction))).eval(input);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(input, actualEvalResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDFunctionTypeIdentity#toString()}
   *   <li>{@link PDFunctionTypeIdentity#getRangeValues()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDFunctionTypeIdentity pdFunctionTypeIdentity = new PDFunctionTypeIdentity(COSBoolean.FALSE);

    // Act
    String actualToStringResult = pdFunctionTypeIdentity.toString();

    // Assert
    assertEquals("FunctionTypeIdentity", actualToStringResult);
    assertNull(pdFunctionTypeIdentity.getRangeValues());
  }

  /**
   * Method under test:
   * {@link PDFunctionTypeIdentity#PDFunctionTypeIdentity(COSBase)}
   */
  @Test
  void testNewPDFunctionTypeIdentity() {
    // Arrange and Act
    PDFunctionTypeIdentity actualPdFunctionTypeIdentity = new PDFunctionTypeIdentity(COSBoolean.FALSE);

    // Assert
    assertNull(actualPdFunctionTypeIdentity.getRangeValues());
    assertNull(actualPdFunctionTypeIdentity.getCOSObject());
    assertNull(actualPdFunctionTypeIdentity.getPDStream());
    assertEquals(0, actualPdFunctionTypeIdentity.getNumberOfOutputParameters());
  }
}
