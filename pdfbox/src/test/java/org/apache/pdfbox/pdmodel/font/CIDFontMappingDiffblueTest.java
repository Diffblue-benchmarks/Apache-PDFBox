package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.cff.CFFCIDFont;
import org.apache.fontbox.ttf.OpenTypeFont;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CIDFontMappingDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CIDFontMapping#CIDFontMapping(OpenTypeFont, FontBoxFont, boolean)}
   *   <li>{@link CIDFontMapping#getTrueTypeFont()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    CFFCIDFont fontBoxFont = new CFFCIDFont();

    // Act
    CIDFontMapping actualCidFontMapping = new CIDFontMapping(null, fontBoxFont, true);
    FontBoxFont actualTrueTypeFont = actualCidFontMapping.getTrueTypeFont();

    // Assert
    assertNull(actualCidFontMapping.getFont());
    assertTrue(actualCidFontMapping.isFallback());
    assertSame(fontBoxFont, actualTrueTypeFont);
  }

  /**
   * Test {@link CIDFontMapping#isCIDFont()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CIDFontMapping#isCIDFont()}
   */
  @Test
  @DisplayName("Test isCIDFont(); then return 'false'")
  void testIsCIDFont_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new CIDFontMapping(null, new CFFCIDFont(), true)).isCIDFont());
  }

  /**
   * Test {@link CIDFontMapping#isCIDFont()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CIDFontMapping#isCIDFont()}
   */
  @Test
  @DisplayName("Test isCIDFont(); then return 'true'")
  void testIsCIDFont_thenReturnTrue() {
    // Arrange
    OpenTypeFont font = mock(OpenTypeFont.class);

    // Act and Assert
    assertTrue((new CIDFontMapping(font, new CFFCIDFont(), true)).isCIDFont());
  }
}
