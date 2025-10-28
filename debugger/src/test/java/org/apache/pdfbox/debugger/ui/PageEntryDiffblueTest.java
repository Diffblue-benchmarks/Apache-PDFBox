package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

class PageEntryDiffblueTest {
  /**
   * Method under test: {@link PageEntry#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("Page: 10 - Page Label", (new PageEntry(new COSDictionary(), 10, "Page Label")).toString());
    assertEquals("Page: 10", (new PageEntry(new COSDictionary(), 10, null)).toString());
  }

  /**
   * Method under test: {@link PageEntry#getPath()}
   */
  @Test
  void testGetPath() {
    // Arrange, Act and Assert
    assertEquals("Root/Pages", (new PageEntry(new COSDictionary(), 10, "Page Label")).getPath());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PageEntry#PageEntry(COSDictionary, int, String)}
   *   <li>{@link PageEntry#getDict()}
   *   <li>{@link PageEntry#getPageNum()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSDictionary page = new COSDictionary();

    // Act
    PageEntry actualPageEntry = new PageEntry(page, 10, "Page Label");
    COSDictionary actualDict = actualPageEntry.getDict();

    // Assert
    assertEquals(10, actualPageEntry.getPageNum());
    assertSame(page, actualDict);
  }
}
