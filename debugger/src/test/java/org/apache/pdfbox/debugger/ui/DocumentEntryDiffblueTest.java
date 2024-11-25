package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DocumentEntryDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DocumentEntry#DocumentEntry(PDDocument, String)}
   *   <li>{@link DocumentEntry#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("foo.txt", (new DocumentEntry(new PDDocument(), "foo.txt")).toString());
  }

  /**
   * Test {@link DocumentEntry#getPageCount()}.
   * <ul>
   *   <li>Given {@link PDDocument#PDDocument()} addPage
   * {@link PDPage#PDPage()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentEntry#getPageCount()}
   */
  @Test
  @DisplayName("Test getPageCount(); given PDDocument() addPage PDPage(); then return one")
  void testGetPageCount_givenPDDocumentAddPagePDPage_thenReturnOne() {
    // Arrange
    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage());

    // Act and Assert
    assertEquals(1, (new DocumentEntry(doc, "foo.txt")).getPageCount());
  }

  /**
   * Test {@link DocumentEntry#getPageCount()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentEntry#getPageCount()}
   */
  @Test
  @DisplayName("Test getPageCount(); then return zero")
  void testGetPageCount_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new DocumentEntry(new PDDocument(), "foo.txt")).getPageCount());
  }

  /**
   * Test {@link DocumentEntry#getPage(int)}.
   * <ul>
   *   <li>Then return Dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentEntry#getPage(int)}
   */
  @Test
  @DisplayName("Test getPage(int); then return Dict is COSDictionary()")
  void testGetPage_thenReturnDictIsCOSDictionary() {
    // Arrange
    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage());
    COSDictionary pageDictionary = new COSDictionary();
    doc.addPage(new PDPage(pageDictionary));

    // Act and Assert
    assertSame(pageDictionary, (new DocumentEntry(doc, "foo.txt")).getPage(1).getDict());
  }

  /**
   * Test {@link DocumentEntry#indexOf(PageEntry)}.
   * <ul>
   *   <li>Then return nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link DocumentEntry#indexOf(PageEntry)}
   */
  @Test
  @DisplayName("Test indexOf(PageEntry); then return nine")
  void testIndexOf_thenReturnNine() {
    // Arrange
    DocumentEntry documentEntry = new DocumentEntry(new PDDocument(), "foo.txt");

    // Act and Assert
    assertEquals(9, documentEntry.indexOf(new PageEntry(new COSDictionary(), 10, "Page Label")));
  }
}
