package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PageEntryDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageEntry#PageEntry(COSDictionary, int, String)}
   *   <li>{@link PageEntry#getDict()}
   *   <li>{@link PageEntry#getPageNum()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
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

  /**
   * Test {@link PageEntry#toString()}.
   * <ul>
   *   <li>Then return {@code Page: 10}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageEntry#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Page: 10'")
  void testToString_thenReturnPage10() {
    // Arrange, Act and Assert
    assertEquals("Page: 10", (new PageEntry(new COSDictionary(), 10, null)).toString());
  }

  /**
   * Test {@link PageEntry#toString()}.
   * <ul>
   *   <li>Then return {@code Page: 10 - Page Label}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageEntry#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Page: 10 - Page Label'")
  void testToString_thenReturnPage10PageLabel() {
    // Arrange, Act and Assert
    assertEquals("Page: 10 - Page Label", (new PageEntry(new COSDictionary(), 10, "Page Label")).toString());
  }

  /**
   * Test {@link PageEntry#getPath()}.
   * <ul>
   *   <li>Given {@link PageEntry#PageEntry(COSDictionary, int, String)} with page
   * is {@link COSDictionary#COSDictionary()} and pageNum is ten and
   * {@code Page Label}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageEntry#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); given PageEntry(COSDictionary, int, String) with page is COSDictionary() and pageNum is ten and 'Page Label'")
  void testGetPath_givenPageEntryWithPageIsCOSDictionaryAndPageNumIsTenAndPageLabel() {
    // Arrange, Act and Assert
    assertEquals("Root/Pages", (new PageEntry(new COSDictionary(), 10, "Page Label")).getPath());
  }

  /**
   * Test {@link PageEntry#getPath()}.
   * <ul>
   *   <li>Given {@link PageEntry#PageEntry(COSDictionary, int, String)} with page
   * is {@link COSStream#COSStream()} and pageNum is ten and
   * {@code Page Label}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageEntry#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); given PageEntry(COSDictionary, int, String) with page is COSStream() and pageNum is ten and 'Page Label'")
  void testGetPath_givenPageEntryWithPageIsCOSStreamAndPageNumIsTenAndPageLabel() {
    // Arrange, Act and Assert
    assertEquals("Root/Pages", (new PageEntry(new COSStream(), 10, "Page Label")).getPath());
  }
}
