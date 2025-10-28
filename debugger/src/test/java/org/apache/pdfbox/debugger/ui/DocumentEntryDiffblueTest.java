package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.Test;

class DocumentEntryDiffblueTest {
  /**
   * Method under test: {@link DocumentEntry#getPageCount()}
   */
  @Test
  void testGetPageCount() {
    // Arrange, Act and Assert
    assertEquals(0, (new DocumentEntry(new PDDocument(), "foo.txt")).getPageCount());
  }

  /**
   * Method under test: {@link DocumentEntry#getPageCount()}
   */
  @Test
  void testGetPageCount2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    int actualPageCount = (new DocumentEntry(new PDDocument(streamCacheCreateFunction), "foo.txt")).getPageCount();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualPageCount);
  }

  /**
   * Method under test: {@link DocumentEntry#getPageCount()}
   */
  @Test
  void testGetPageCount3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.addPage(new PDPage());

    // Act
    int actualPageCount = (new DocumentEntry(doc, "foo.txt")).getPageCount();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualPageCount);
  }

  /**
   * Method under test: {@link DocumentEntry#getPage(int)}
   */
  @Test
  void testGetPage() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    doc.addPage(new PDPage());
    COSDictionary pageDictionary = new COSDictionary();
    doc.addPage(new PDPage(pageDictionary));

    // Act
    PageEntry actualPage = (new DocumentEntry(doc, "foo.txt")).getPage(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Root/Pages/Kids/[1]", actualPage.getPath());
    assertEquals(2, actualPage.getPageNum());
    assertSame(pageDictionary, actualPage.getDict());
  }

  /**
   * Method under test: {@link DocumentEntry#indexOf(PageEntry)}
   */
  @Test
  void testIndexOf() {
    // Arrange
    DocumentEntry documentEntry = new DocumentEntry(new PDDocument(), "foo.txt");

    // Act and Assert
    assertEquals(9, documentEntry.indexOf(new PageEntry(new COSDictionary(), 10, "Page Label")));
  }

  /**
   * Method under test: {@link DocumentEntry#indexOf(PageEntry)}
   */
  @Test
  void testIndexOf2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    DocumentEntry documentEntry = new DocumentEntry(new PDDocument(streamCacheCreateFunction), "foo.txt");

    // Act
    int actualIndexOfResult = documentEntry.indexOf(new PageEntry(new COSDictionary(), 10, "Page Label"));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(9, actualIndexOfResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DocumentEntry#DocumentEntry(PDDocument, String)}
   *   <li>{@link DocumentEntry#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("foo.txt", (new DocumentEntry(new PDDocument(), "foo.txt")).toString());
  }
}
