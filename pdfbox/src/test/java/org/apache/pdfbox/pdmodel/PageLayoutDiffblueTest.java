package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class PageLayoutDiffblueTest {
  /**
   * Method under test: {@link PageLayout#fromString(String)}
   */
  @Test
  void testFromString() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PageLayout.fromString("42"));
    assertEquals(PageLayout.SINGLE_PAGE, PageLayout.fromString("SinglePage"));
  }

  /**
   * Method under test: {@link PageLayout#stringValue()}
   */
  @Test
  void testStringValue() {
    // Arrange, Act and Assert
    assertEquals("SinglePage", PageLayout.SINGLE_PAGE.stringValue());
  }
}
