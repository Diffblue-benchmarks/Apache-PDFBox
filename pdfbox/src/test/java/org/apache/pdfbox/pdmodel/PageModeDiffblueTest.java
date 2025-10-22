package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PageModeDiffblueTest {
  /**
   * Test {@link PageMode#fromString(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageMode#fromString(String)}
   */
  @Test
  @DisplayName("Test fromString(String); when '42'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageMode PageMode.fromString(String)"})
  void testFromString_when42_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PageMode.fromString("42"));
  }

  /**
   * Test {@link PageMode#fromString(String)}.
   * <ul>
   *   <li>When {@code UseNone}.</li>
   *   <li>Then return {@code USE_NONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageMode#fromString(String)}
   */
  @Test
  @DisplayName("Test fromString(String); when 'UseNone'; then return 'USE_NONE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageMode PageMode.fromString(String)"})
  void testFromString_whenUseNone_thenReturnUseNone() {
    // Arrange, Act and Assert
    assertEquals(PageMode.USE_NONE, PageMode.fromString("UseNone"));
  }

  /**
   * Test {@link PageMode#stringValue()}.
   * <p>
   * Method under test: {@link PageMode#stringValue()}
   */
  @Test
  @DisplayName("Test stringValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PageMode.stringValue()"})
  void testStringValue() {
    // Arrange, Act and Assert
    assertEquals("UseNone", PageMode.USE_NONE.stringValue());
  }
}
