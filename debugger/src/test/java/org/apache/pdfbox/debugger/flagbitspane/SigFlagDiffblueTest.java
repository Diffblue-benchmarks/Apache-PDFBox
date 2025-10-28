package org.apache.pdfbox.debugger.flagbitspane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

class SigFlagDiffblueTest {
  /**
   * Method under test: {@link SigFlag#getFlagValue()}
   */
  @Test
  void testGetFlagValue() {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertEquals("Flag value: -1", (new SigFlag(document, new COSDictionary())).getFlagValue());
  }

  /**
   * Method under test: {@link SigFlag#getFlagValue()}
   */
  @Test
  void testGetFlagValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    String actualFlagValue = (new SigFlag(document, new COSDictionary())).getFlagValue();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Flag value: -1", actualFlagValue);
  }

  /**
   * Method under test: {@link SigFlag#getFlagBits()}
   */
  @Test
  void testGetFlagBits() {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    Object[][] actualFlagBits = (new SigFlag(document, new COSDictionary())).getFlagBits();

    // Assert
    Object[] objectArray = actualFlagBits[1];
    assertEquals("AppendOnly", objectArray[1]);
    Object[] objectArray2 = actualFlagBits[0];
    assertEquals("SignaturesExist", objectArray2[1]);
    assertEquals(2, actualFlagBits.length);
    assertEquals(3, objectArray2.length);
    assertEquals(3, objectArray.length);
  }

  /**
   * Method under test: {@link SigFlag#getFlagBits()}
   */
  @Test
  void testGetFlagBits2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    Object[][] actualFlagBits = (new SigFlag(document, new COSDictionary())).getFlagBits();

    // Assert
    verify(streamCacheCreateFunction).create();
    Object[] objectArray = actualFlagBits[1];
    assertEquals("AppendOnly", objectArray[1]);
    Object[] objectArray2 = actualFlagBits[0];
    assertEquals("SignaturesExist", objectArray2[1]);
    assertEquals(2, actualFlagBits.length);
    assertEquals(3, objectArray2.length);
    assertEquals(3, objectArray.length);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SigFlag#SigFlag(PDDocument, COSDictionary)}
   *   <li>{@link SigFlag#getFlagType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertEquals("Signature flag", (new SigFlag(document, new COSDictionary())).getFlagType());
  }
}
