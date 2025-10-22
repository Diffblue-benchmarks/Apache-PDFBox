package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageEntry.<init>(COSDictionary, int, String)", "COSDictionary PageEntry.getDict()",
      "int PageEntry.getPageNum()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PageEntry.toString()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PageEntry.toString()"})
  void testToString_thenReturnPage10PageLabel() {
    // Arrange, Act and Assert
    assertEquals("Page: 10 - Page Label", (new PageEntry(new COSDictionary(), 10, "Page Label")).toString());
  }

  /**
   * Test {@link PageEntry#getPath()}.
   * <ul>
   *   <li>Then return {@code Root/Pages}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageEntry#getPath()}
   */
  @Test
  @DisplayName("Test getPath(); then return 'Root/Pages'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PageEntry.getPath()"})
  void testGetPath_thenReturnRootPages() {
    // Arrange, Act and Assert
    assertEquals("Root/Pages", (new PageEntry(new COSDictionary(), 10, "Page Label")).getPath());
  }
}
