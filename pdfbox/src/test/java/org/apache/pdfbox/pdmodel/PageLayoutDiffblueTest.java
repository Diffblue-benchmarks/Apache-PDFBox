package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PageLayoutDiffblueTest {
  /**
   * Test {@link PageLayout#fromString(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageLayout#fromString(String)}
   */
  @Test
  @DisplayName("Test fromString(String); when '42'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageLayout PageLayout.fromString(String)"})
  void testFromString_when42_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PageLayout.fromString("42"));
  }

  /**
   * Test {@link PageLayout#fromString(String)}.
   * <ul>
   *   <li>When {@code SinglePage}.</li>
   *   <li>Then return {@code SINGLE_PAGE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageLayout#fromString(String)}
   */
  @Test
  @DisplayName("Test fromString(String); when 'SinglePage'; then return 'SINGLE_PAGE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageLayout PageLayout.fromString(String)"})
  void testFromString_whenSinglePage_thenReturnSinglePage() {
    // Arrange, Act and Assert
    assertEquals(PageLayout.SINGLE_PAGE, PageLayout.fromString("SinglePage"));
  }

  /**
   * Test {@link PageLayout#stringValue()}.
   * <p>
   * Method under test: {@link PageLayout#stringValue()}
   */
  @Test
  @DisplayName("Test stringValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PageLayout.stringValue()"})
  void testStringValue() {
    // Arrange, Act and Assert
    assertEquals("SinglePage", PageLayout.SINGLE_PAGE.stringValue());
  }
}
