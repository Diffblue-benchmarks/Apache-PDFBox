package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FileSystemFontProviderDiffblueTest {
  /**
   * Test {@link FileSystemFontProvider#getFontInfo()}.
   * <p>
   * Method under test: {@link FileSystemFontProvider#getFontInfo()}
   */
  @Test
  @DisplayName("Test getFontInfo()")
  void testGetFontInfo() {
    // Arrange and Act
    List<? extends FontInfo> actualFontInfo = (new FileSystemFontProvider(new FontCache())).getFontInfo();

    // Assert
    assertEquals(366, actualFontInfo.size());
    FontInfo getResult = actualFontInfo.get(3);
    assertEquals(-2317383482721959777L, getResult.getCodePageRange());
    FontInfo getResult2 = actualFontInfo.get(4);
    assertEquals(-2317383482721959777L, getResult2.getCodePageRange());
    FontInfo getResult3 = actualFontInfo.get(5);
    assertEquals(-2317383482721959777L, getResult3.getCodePageRange());
    FontInfo getResult4 = actualFontInfo.get(362);
    assertEquals(4, getResult4.getWeightClassAsPanose());
    FontInfo getResult5 = actualFontInfo.get(1);
    assertEquals(5, getResult5.getWeightClassAsPanose());
    FontInfo getResult6 = actualFontInfo.get(2);
    assertEquals(5, getResult6.getWeightClassAsPanose());
    FontInfo getResult7 = actualFontInfo.get(360);
    assertEquals(5, getResult7.getWeightClassAsPanose());
    FontInfo getResult8 = actualFontInfo.get(364);
    assertEquals(5, getResult8.getWeightClassAsPanose());
    assertEquals(5, getResult3.getWeightClassAsPanose());
    FontInfo getResult9 = actualFontInfo.get(0);
    assertEquals(536870913L, getResult9.getCodePageRange());
    assertEquals(536870913L, getResult5.getCodePageRange());
    assertEquals(536870913L, getResult6.getCodePageRange());
    assertEquals(536871315L, getResult7.getCodePageRange());
    FontInfo getResult10 = actualFontInfo.get(361);
    assertEquals(536871315L, getResult10.getCodePageRange());
    assertEquals(536871315L, getResult4.getCodePageRange());
    FontInfo getResult11 = actualFontInfo.get(363);
    assertEquals(536871315L, getResult11.getCodePageRange());
    assertEquals(536871315L, getResult8.getCodePageRange());
    FontInfo getResult12 = actualFontInfo.get(365);
    assertEquals(536871315L, getResult12.getCodePageRange());
    assertEquals(6, getResult11.getWeightClassAsPanose());
    assertEquals(7, getResult12.getWeightClassAsPanose());
    assertEquals(8, getResult9.getWeightClassAsPanose());
    assertEquals(8, getResult.getWeightClassAsPanose());
    assertEquals(8, getResult10.getWeightClassAsPanose());
    assertEquals(8, getResult2.getWeightClassAsPanose());
  }
}
