package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.cff.CFFCIDFont;
import org.junit.jupiter.api.Test;

class FontMappingDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FontMapping#FontMapping(FontBoxFont, boolean)}
   *   <li>{@link FontMapping#getFont()}
   *   <li>{@link FontMapping#isFallback()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();

    // Act
    FontMapping<FontBoxFont> actualFontMapping = new FontMapping<>(cffcidFont, true);
    FontBoxFont actualFont = actualFontMapping.getFont();

    // Assert
    assertTrue(actualFontMapping.isFallback());
    assertSame(cffcidFont, actualFont);
  }
}
