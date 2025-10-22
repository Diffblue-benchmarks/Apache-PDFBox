package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FontMappersDiffblueTest {
  /**
   * Test {@link FontMappers#instance()}.
   * <p>
   * Method under test: {@link FontMappers#instance()}
   */
  @Test
  @DisplayName("Test instance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontMapper FontMappers.instance()"})
  void testInstance() {
    // Arrange and Act
    FontMapper actualInstanceResult = FontMappers.instance();

    // Assert
    FontProvider provider = ((FontMapperImpl) actualInstanceResult).getProvider();
    assertTrue(provider instanceof FileSystemFontProvider);
    assertTrue(actualInstanceResult instanceof FontMapperImpl);
    assertEquals("TTF: DejaVuSans-Bold: /usr/share/fonts/truetype/dejavu/DejaVuSans-Bold.ttf\n"
        + "TTF: DejaVuSans: /usr/share/fonts/truetype/dejavu/DejaVuSans.ttf\n"
        + "TTF: DejaVuSansMono-Bold: /usr/share/fonts/truetype/dejavu/DejaVuSansMono-Bold.ttf\n"
        + "TTF: DejaVuSansMono: /usr/share/fonts/truetype/dejavu/DejaVuSansMono.ttf\n"
        + "TTF: DejaVuSerif-Bold: /usr/share/fonts/truetype/dejavu/DejaVuSerif-Bold.ttf\n"
        + "TTF: DejaVuSerif: /usr/share/fonts/truetype/dejavu/DejaVuSerif.ttf\n"
        + "TTF: LiberationMono-Bold: /usr/share/fonts/truetype/liberation/LiberationMono-Bold.ttf\n"
        + "TTF: LiberationMono-BoldItalic: /usr/share/fonts/truetype/liberation/LiberationMono-BoldItalic.ttf\n"
        + "TTF: LiberationMono-Italic: /usr/share/fonts/truetype/liberation/LiberationMono-Italic.ttf\n"
        + "TTF: LiberationMono: /usr/share/fonts/truetype/liberation/LiberationMono-Regular.ttf\n"
        + "TTF: LiberationSans-Bold: /usr/share/fonts/truetype/liberation/LiberationSans-Bold.ttf\n"
        + "TTF: LiberationSans-BoldItalic: /usr/share/fonts/truetype/liberation/LiberationSans-BoldItalic.ttf\n"
        + "TTF: LiberationSans-Italic: /usr/share/fonts/truetype/liberation/LiberationSans-Italic.ttf\n"
        + "TTF: LiberationSans: /usr/share/fonts/truetype/liberation/LiberationSans-Regular.ttf\n"
        + "TTF: LiberationSansNarrow-Bold: /usr/share/fonts/truetype/liberation/LiberationSansNarrow-Bold.ttf\n"
        + "TTF: LiberationSansNarrow-BoldItalic: /usr/share/fonts/truetype/liberation/LiberationSansNarrow"
        + "-BoldItalic.ttf\n"
        + "TTF: LiberationSansNarrow-Italic: /usr/share/fonts/truetype/liberation/LiberationSansNarrow-Italic.ttf"
        + "\n" + "TTF: LiberationSansNarrow: /usr/share/fonts/truetype/liberation/LiberationSansNarrow-Regular.ttf\n"
        + "TTF: LiberationSerif-Bold: /usr/share/fonts/truetype/liberation/LiberationSerif-Bold.ttf\n"
        + "TTF: LiberationSerif-BoldItalic: /usr/share/fonts/truetype/liberation/LiberationSerif-BoldItalic.ttf" + "\n"
        + "TTF: LiberationSerif-Italic: /usr/share/fonts/truetype/liberation/LiberationSerif-Italic.ttf\n"
        + "TTF: LiberationSerif: /usr/share/fonts/truetype/liberation/LiberationSerif-Regular.ttf\n",
        provider.toDebugString());
    List<? extends FontInfo> fontInfo = provider.getFontInfo();
    assertEquals(22, fontInfo.size());
    FontInfo getResult = fontInfo.get(1);
    assertEquals(-2306124482579791361L, getResult.getCodePageRange());
    FontInfo getResult2 = fontInfo.get(20);
    assertEquals(-2317383481648217953L, getResult2.getCodePageRange());
    FontInfo getResult3 = fontInfo.get(21);
    assertEquals(-2317383481648217953L, getResult3.getCodePageRange());
    FontInfo getResult4 = fontInfo.get(0);
    assertEquals(-281473366097409L, getResult4.getCodePageRange());
    assertEquals(5, getResult.getWeightClassAsPanose());
    assertEquals(5, getResult2.getWeightClassAsPanose());
    assertEquals(5, getResult3.getWeightClassAsPanose());
    assertEquals(8, getResult4.getWeightClassAsPanose());
  }
}
