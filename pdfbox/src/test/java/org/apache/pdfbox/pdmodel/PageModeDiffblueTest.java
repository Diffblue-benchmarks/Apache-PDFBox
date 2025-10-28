package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class PageModeDiffblueTest {
  /**
   * Method under test: {@link PageMode#fromString(String)}
   */
  @Test
  void testFromString() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PageMode.fromString("42"));
    assertEquals(PageMode.USE_NONE, PageMode.fromString("UseNone"));
  }

  /**
   * Method under test: {@link PageMode#stringValue()}
   */
  @Test
  void testStringValue() {
    // Arrange, Act and Assert
    assertEquals("UseNone", PageMode.USE_NONE.stringValue());
  }
}
