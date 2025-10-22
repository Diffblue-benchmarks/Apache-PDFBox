package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FileSystemFontProviderDiffblueTest {
  /**
   * Test {@link FileSystemFontProvider#FileSystemFontProvider(FontCache)}.
   * <p>
   * Method under test: {@link FileSystemFontProvider#FileSystemFontProvider(FontCache)}
   */
  @Test
  @DisplayName("Test new FileSystemFontProvider(FontCache)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FileSystemFontProvider.<init>(FontCache)"})
  void testNewFileSystemFontProvider() {
    // Arrange and Act
    FileSystemFontProvider actualFileSystemFontProvider = new FileSystemFontProvider(new FontCache());

    // Assert
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
        actualFileSystemFontProvider.toDebugString());
    List<? extends FontInfo> fontInfo = actualFileSystemFontProvider.getFontInfo();
    assertEquals(22, fontInfo.size());
    FontInfo getResult = fontInfo.get(1);
    assertEquals(-2306124482579791361L, getResult.getCodePageRange());
    FontInfo getResult2 = fontInfo.get(19);
    assertEquals(-2317383481648217953L, getResult2.getCodePageRange());
    FontInfo getResult3 = fontInfo.get(20);
    assertEquals(-2317383481648217953L, getResult3.getCodePageRange());
    FontInfo getResult4 = fontInfo.get(21);
    assertEquals(-2317383481648217953L, getResult4.getCodePageRange());
    FontInfo getResult5 = fontInfo.get(0);
    assertEquals(-281473366097409L, getResult5.getCodePageRange());
    FontInfo getResult6 = fontInfo.get(2);
    assertEquals(-9288672620838433L, getResult6.getCodePageRange());
    assertEquals(5, getResult.getWeightClassAsPanose());
    assertEquals(5, getResult3.getWeightClassAsPanose());
    assertEquals(5, getResult4.getWeightClassAsPanose());
    assertEquals(8, getResult5.getWeightClassAsPanose());
    assertEquals(8, getResult2.getWeightClassAsPanose());
    assertEquals(8, getResult6.getWeightClassAsPanose());
  }

  /**
   * Test {@link FileSystemFontProvider#toDebugString()}.
   * <p>
   * Method under test: {@link FileSystemFontProvider#toDebugString()}
   */
  @Test
  @DisplayName("Test toDebugString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String FileSystemFontProvider.toDebugString()"})
  void testToDebugString() {
    // Arrange, Act and Assert
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
        (new FileSystemFontProvider(new FontCache())).toDebugString());
  }

  /**
   * Test {@link FileSystemFontProvider#getFontInfo()}.
   * <p>
   * Method under test: {@link FileSystemFontProvider#getFontInfo()}
   */
  @Test
  @DisplayName("Test getFontInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FileSystemFontProvider.getFontInfo()"})
  void testGetFontInfo() {
    // Arrange and Act
    List<? extends FontInfo> actualFontInfo = (new FileSystemFontProvider(new FontCache())).getFontInfo();

    // Assert
    assertEquals(22, actualFontInfo.size());
    FontInfo getResult = actualFontInfo.get(1);
    assertEquals(-2306124482579791361L, getResult.getCodePageRange());
    FontInfo getResult2 = actualFontInfo.get(17);
    assertEquals(-2317383481648217953L, getResult2.getCodePageRange());
    FontInfo getResult3 = actualFontInfo.get(18);
    assertEquals(-2317383481648217953L, getResult3.getCodePageRange());
    FontInfo getResult4 = actualFontInfo.get(19);
    assertEquals(-2317383481648217953L, getResult4.getCodePageRange());
    FontInfo getResult5 = actualFontInfo.get(20);
    assertEquals(-2317383481648217953L, getResult5.getCodePageRange());
    FontInfo getResult6 = actualFontInfo.get(21);
    assertEquals(-2317383481648217953L, getResult6.getCodePageRange());
    FontInfo getResult7 = actualFontInfo.get(4);
    assertEquals(-2317383481648217953L, getResult7.getCodePageRange());
    FontInfo getResult8 = actualFontInfo.get(5);
    assertEquals(-2317383481648217953L, getResult8.getCodePageRange());
    FontInfo getResult9 = actualFontInfo.get(Short.SIZE);
    assertEquals(-2317383481648217953L, getResult9.getCodePageRange());
    FontInfo getResult10 = actualFontInfo.get(0);
    assertEquals(-281473366097409L, getResult10.getCodePageRange());
    FontInfo getResult11 = actualFontInfo.get(2);
    assertEquals(-9288672620838433L, getResult11.getCodePageRange());
    FontInfo getResult12 = actualFontInfo.get(3);
    assertEquals(-9288672620838433L, getResult12.getCodePageRange());
    assertEquals(5, getResult.getWeightClassAsPanose());
    assertEquals(5, getResult2.getWeightClassAsPanose());
    assertEquals(5, getResult5.getWeightClassAsPanose());
    assertEquals(5, getResult6.getWeightClassAsPanose());
    assertEquals(5, getResult12.getWeightClassAsPanose());
    assertEquals(5, getResult8.getWeightClassAsPanose());
    assertEquals(5, getResult9.getWeightClassAsPanose());
    assertEquals(8, getResult10.getWeightClassAsPanose());
    assertEquals(8, getResult3.getWeightClassAsPanose());
    assertEquals(8, getResult4.getWeightClassAsPanose());
    assertEquals(8, getResult11.getWeightClassAsPanose());
    assertEquals(8, getResult7.getWeightClassAsPanose());
  }
}
