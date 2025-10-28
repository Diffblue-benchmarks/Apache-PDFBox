package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

class SplitterDiffblueTest {
  /**
   * Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  void testSplit() throws IOException {
    // Arrange
    Splitter splitter = new Splitter();
    PDDocument document = new PDDocument();

    // Act and Assert
    assertTrue(splitter.split(document).isEmpty());
    assertSame(document, splitter.getSourceDocument());
  }

  /**
   * Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  void testSplit2() throws IOException {
    // Arrange
    Splitter splitter = new Splitter();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    List<PDDocument> actualSplitResult = splitter.split(document);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualSplitResult.isEmpty());
    assertSame(document, splitter.getSourceDocument());
  }

  /**
   * Method under test: {@link Splitter#setSplitAtPage(int)}
   */
  @Test
  void testSetSplitAtPage() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Splitter()).setSplitAtPage(0));
  }

  /**
   * Method under test: {@link Splitter#setStartPage(int)}
   */
  @Test
  void testSetStartPage() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Splitter()).setStartPage(0));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Splitter}
   *   <li>
   * {@link Splitter#setStreamCacheCreateFunction(RandomAccessStreamCache.StreamCacheCreateFunction)}
   *   <li>{@link Splitter#getDestinationDocument()}
   *   <li>{@link Splitter#getSourceDocument()}
   *   <li>{@link Splitter#getStreamCacheCreateFunction()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Splitter actualSplitter = new Splitter();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    actualSplitter.setStreamCacheCreateFunction(streamCacheCreateFunction);
    actualSplitter.getDestinationDocument();
    actualSplitter.getSourceDocument();

    // Assert that nothing has changed
    assertSame(streamCacheCreateFunction, actualSplitter.getStreamCacheCreateFunction());
  }

  /**
   * Method under test: {@link Splitter#setEndPage(int)}
   */
  @Test
  void testSetEndPage() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Splitter()).setEndPage(0));
  }

  /**
   * Method under test: {@link Splitter#splitAtPage(int)}
   */
  @Test
  void testSplitAtPage() {
    // Arrange, Act and Assert
    assertTrue((new Splitter()).splitAtPage(10));
  }

  /**
   * Method under test: {@link Splitter#splitAtPage(int)}
   */
  @Test
  void testSplitAtPage2() {
    // Arrange
    Splitter splitter = new Splitter();
    splitter.setStreamCacheCreateFunction(mock(RandomAccessStreamCache.StreamCacheCreateFunction.class));

    // Act and Assert
    assertTrue(splitter.splitAtPage(10));
  }
}
