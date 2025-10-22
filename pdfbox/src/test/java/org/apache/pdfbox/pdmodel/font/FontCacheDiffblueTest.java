package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FontCacheDiffblueTest {
  /**
   * Test {@link FontCache#getFont(FontInfo)}.
   * <ul>
   *   <li>When {@link FontInfo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontCache#getFont(FontInfo)}
   */
  @Test
  @DisplayName("Test getFont(FontInfo); when FontInfo; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.FontBoxFont FontCache.getFont(FontInfo)"})
  void testGetFont_whenFontInfo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new FontCache()).getFont(mock(FontInfo.class)));
  }
}
