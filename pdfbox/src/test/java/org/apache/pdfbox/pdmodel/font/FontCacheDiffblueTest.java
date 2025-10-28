package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class FontCacheDiffblueTest {
  /**
   * Method under test: {@link FontCache#getFont(FontInfo)}
   */
  @Test
  void testGetFont() {
    // Arrange, Act and Assert
    assertNull((new FontCache()).getFont(mock(FontInfo.class)));
  }
}
