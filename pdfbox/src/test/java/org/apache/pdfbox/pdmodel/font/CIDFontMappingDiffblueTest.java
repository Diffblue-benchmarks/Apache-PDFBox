package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.cff.CFFCIDFont;
import org.apache.fontbox.ttf.OpenTypeFont;
import org.junit.jupiter.api.Test;

class CIDFontMappingDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CIDFontMapping#CIDFontMapping(OpenTypeFont, FontBoxFont, boolean)}
   *   <li>{@link CIDFontMapping#getTrueTypeFont()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link CIDFontMapping#isCIDFont()}
   */
  @Test
  void testIsCIDFont() {
    // Arrange
    OpenTypeFont font = mock(OpenTypeFont.class);

    // Act and Assert
    assertTrue((new CIDFontMapping(font, new CFFCIDFont(), true)).isCIDFont());
  }

  /**
   * Method under test: {@link CIDFontMapping#isCIDFont()}
   */
  @Test
  void testIsCIDFont2() {
    // Arrange, Act and Assert
    assertFalse((new CIDFontMapping(null, new CFFCIDFont(), true)).isCIDFont());
  }
}
