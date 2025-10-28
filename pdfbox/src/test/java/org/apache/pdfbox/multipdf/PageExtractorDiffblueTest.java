package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.Test;

class PageExtractorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PageExtractor#PageExtractor(PDDocument, int, int)}
   *   <li>{@link PageExtractor#setEndPage(int)}
   *   <li>{@link PageExtractor#setStartPage(int)}
   *   <li>{@link PageExtractor#getEndPage()}
   *   <li>{@link PageExtractor#getStartPage()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    PageExtractor actualPageExtractor = new PageExtractor(new PDDocument(), 1, 3);
    actualPageExtractor.setEndPage(3);
    actualPageExtractor.setStartPage(1);
    int actualEndPage = actualPageExtractor.getEndPage();

    // Assert that nothing has changed
    assertEquals(1, actualPageExtractor.getStartPage());
    assertEquals(3, actualEndPage);
  }

  /**
   * Method under test: {@link PageExtractor#PageExtractor(PDDocument)}
   */
  @Test
  void testNewPageExtractor() {
    // Arrange and Act
    PageExtractor actualPageExtractor = new PageExtractor(new PDDocument());

    // Assert
    assertEquals(0, actualPageExtractor.getEndPage());
    assertEquals(1, actualPageExtractor.getStartPage());
  }

  /**
   * Method under test: {@link PageExtractor#PageExtractor(PDDocument)}
   */
  @Test
  void testNewPageExtractor2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PageExtractor actualPageExtractor = new PageExtractor(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualPageExtractor.getEndPage());
    assertEquals(1, actualPageExtractor.getStartPage());
  }

  /**
   * Method under test: {@link PageExtractor#PageExtractor(PDDocument)}
   */
  @Test
  void testNewPageExtractor3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument sourceDocument = new PDDocument(streamCacheCreateFunction);
    sourceDocument.addPage(new PDPage());

    // Act
    PageExtractor actualPageExtractor = new PageExtractor(sourceDocument);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualPageExtractor.getEndPage());
    assertEquals(1, actualPageExtractor.getStartPage());
  }
}
