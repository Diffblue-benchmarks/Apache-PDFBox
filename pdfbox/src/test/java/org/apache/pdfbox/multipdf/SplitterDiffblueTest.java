package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SplitterDiffblueTest {
  /**
   * Test {@link Splitter#split(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Splitter#split(PDDocument)}
   */
  @Test
  @DisplayName("Test split(PDDocument); when PDDocument(); then return Empty")
  void testSplit_whenPDDocument_thenReturnEmpty() throws IOException {
    // Arrange
    Splitter splitter = new Splitter();
    PDDocument document = new PDDocument();

    // Act and Assert
    assertTrue(splitter.split(document).isEmpty());
    assertSame(document, splitter.getSourceDocument());
  }

  /**
   * Test {@link Splitter#setSplitAtPage(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Splitter#setSplitAtPage(int)}
   */
  @Test
  @DisplayName("Test setSplitAtPage(int); when zero; then throw IllegalArgumentException")
  void testSetSplitAtPage_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Splitter()).setSplitAtPage(0));
  }

  /**
   * Test {@link Splitter#setStartPage(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Splitter#setStartPage(int)}
   */
  @Test
  @DisplayName("Test setStartPage(int); when zero; then throw IllegalArgumentException")
  void testSetStartPage_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Splitter()).setStartPage(0));
  }

  /**
   * Test {@link Splitter#setEndPage(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Splitter#setEndPage(int)}
   */
  @Test
  @DisplayName("Test setEndPage(int); when zero; then throw IllegalArgumentException")
  void testSetEndPage_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new Splitter()).setEndPage(0));
  }

  /**
   * Test {@link Splitter#splitAtPage(int)}.
   * <p>
   * Method under test: {@link Splitter#splitAtPage(int)}
   */
  @Test
  @DisplayName("Test splitAtPage(int)")
  void testSplitAtPage() {
    // Arrange, Act and Assert
    assertTrue((new Splitter()).splitAtPage(10));
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
}
