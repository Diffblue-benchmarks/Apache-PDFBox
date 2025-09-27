package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.ttf.OS2WindowsMetricsTable;
import org.apache.fontbox.ttf.TTFTable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FontMapperImplDiffblueTest {
  /**
   * Test new {@link FontMapperImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link FontMapperImpl}
   */
  @Test
  @DisplayName("Test new FontMapperImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FontMapperImpl.<init>()"})
  void testNewFontMapperImpl() {
    // Arrange, Act and Assert
    FontProvider provider = new FontMapperImpl().getProvider();
    assertTrue(provider instanceof FileSystemFontProvider);
    assertEquals(
        "TTF: DejaVuSans-Bold: /usr/share/fonts/truetype/dejavu/DejaVuSans-Bold.ttf\n"
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
            + "\n"
            + "TTF: LiberationSansNarrow: /usr/share/fonts/truetype/liberation/LiberationSansNarrow-Regular.ttf\n"
            + "TTF: LiberationSerif-Bold: /usr/share/fonts/truetype/liberation/LiberationSerif-Bold.ttf\n"
            + "TTF: LiberationSerif-BoldItalic: /usr/share/fonts/truetype/liberation/LiberationSerif-BoldItalic.ttf"
            + "\n"
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

  /**
   * Test {@link FontMapperImpl#setProvider(FontProvider)}.
   *
   * <p>Method under test: {@link FontMapperImpl#setProvider(FontProvider)}
   */
  @Test
  @DisplayName("Test setProvider(FontProvider)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FontMapperImpl.setProvider(FontProvider)"})
  void testSetProvider() {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    FileSystemFontProvider fontProvider = new FileSystemFontProvider(new FontCache());

    // Act
    fontMapperImpl.setProvider(fontProvider);

    // Assert
    assertSame(fontProvider, fontMapperImpl.getProvider());
  }

  /**
   * Test {@link FontMapperImpl#getProvider()}.
   *
   * <p>Method under test: {@link FontMapperImpl#getProvider()}
   */
  @Test
  @DisplayName("Test getProvider()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontProvider FontMapperImpl.getProvider()"})
  void testGetProvider() {
    // Arrange and Act
    FontProvider actualProvider = new FontMapperImpl().getProvider();

    // Assert
    assertTrue(actualProvider instanceof FileSystemFontProvider);
    assertEquals(
        "TTF: DejaVuSans-Bold: /usr/share/fonts/truetype/dejavu/DejaVuSans-Bold.ttf\n"
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
            + "\n"
            + "TTF: LiberationSansNarrow: /usr/share/fonts/truetype/liberation/LiberationSansNarrow-Regular.ttf\n"
            + "TTF: LiberationSerif-Bold: /usr/share/fonts/truetype/liberation/LiberationSerif-Bold.ttf\n"
            + "TTF: LiberationSerif-BoldItalic: /usr/share/fonts/truetype/liberation/LiberationSerif-BoldItalic.ttf"
            + "\n"
            + "TTF: LiberationSerif-Italic: /usr/share/fonts/truetype/liberation/LiberationSerif-Italic.ttf\n"
            + "TTF: LiberationSerif: /usr/share/fonts/truetype/liberation/LiberationSerif-Regular.ttf\n",
        actualProvider.toDebugString());
    List<? extends FontInfo> fontInfo = actualProvider.getFontInfo();
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
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@code black}.
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is {@code black}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getTrueTypeFont(String, PDFontDescriptor); given 'black'; when PDFontDescriptor() FontName is 'black'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_givenBlack_whenPDFontDescriptorFontNameIsBlack() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontName("black");

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont("Base Font", fontDescriptor).getFont();
    assertEquals("LiberationSans-Bold", font.getName());
    assertEquals(137052L, font.getOriginalDataSize());
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(19, tableMap.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, font.getOriginalData().read(byteArray));
    assertTrue(tableMap.containsKey("OS/2"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("glyf"));
    assertTrue(tableMap.containsKey("kern"));
    assertArrayEquals(
        new byte[] {
          0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', -2, -32, -92, 0, 2, 23,
          '@', 0, 0, 0, 28, 'G', 'D', 'E', 'F', 0, '\'', 2, -49, 0, 2, 6, '|', 0, 0, 0, '&', 'G',
          'P', 'O', 'S', -43, '(', -15
        },
        byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@code bold}.
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is {@code bold}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getTrueTypeFont(String, PDFontDescriptor); given 'bold'; when PDFontDescriptor() FontName is 'bold'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_givenBold_whenPDFontDescriptorFontNameIsBold() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontName("bold");

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont("Base Font", fontDescriptor).getFont();
    assertEquals("LiberationSans-Bold", font.getName());
    assertEquals(137052L, font.getOriginalDataSize());
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(19, tableMap.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, font.getOriginalData().read(byteArray));
    assertTrue(tableMap.containsKey("OS/2"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("glyf"));
    assertTrue(tableMap.containsKey("kern"));
    assertArrayEquals(
        new byte[] {
          0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', -2, -32, -92, 0, 2, 23,
          '@', 0, 0, 0, 28, 'G', 'D', 'E', 'F', 0, '\'', 2, -49, 0, 2, 6, '|', 0, 0, 0, '&', 'G',
          'P', 'O', 'S', -43, '(', -15
        },
        byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@code -}.
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getTrueTypeFont(String, PDFontDescriptor); given '-'; when PDFontDescriptor() FontName is '-'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_givenDash_whenPDFontDescriptorFontNameIsDash() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontName("-");

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont("Base Font", fontDescriptor).getFont();
    assertEquals("LiberationSans", font.getName());
    assertEquals(139512L, font.getOriginalDataSize());
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(19, tableMap.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, font.getOriginalData().read(byteArray));
    assertTrue(tableMap.containsKey("OS/2"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("glyf"));
    assertTrue(tableMap.containsKey("kern"));
    assertArrayEquals(
        new byte[] {
          0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', -2, -32, 'f', 0, 2, ' ',
          -36, 0, 0, 0, 28, 'G', 'D', 'E', 'F', 0, '\'', 2, -49, 0, 2, 15, -84, 0, 0, 0, '&', 'G',
          'P', 'O', 'S', 'j', 'w', -101
        },
        byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@code heavy}.
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is {@code heavy}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getTrueTypeFont(String, PDFontDescriptor); given 'heavy'; when PDFontDescriptor() FontName is 'heavy'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_givenHeavy_whenPDFontDescriptorFontNameIsHeavy() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontName("heavy");

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont("Base Font", fontDescriptor).getFont();
    assertEquals("LiberationSans-Bold", font.getName());
    assertEquals(137052L, font.getOriginalDataSize());
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(19, tableMap.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, font.getOriginalData().read(byteArray));
    assertTrue(tableMap.containsKey("OS/2"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("glyf"));
    assertTrue(tableMap.containsKey("kern"));
    assertArrayEquals(
        new byte[] {
          0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', -2, -32, -92, 0, 2, 23,
          '@', 0, 0, 0, 28, 'G', 'D', 'E', 'F', 0, '\'', 2, -49, 0, 2, 6, '|', 0, 0, 0, '&', 'G',
          'P', 'O', 'S', -43, '(', -15
        },
        byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>When {@code ,}.
   *   <li>Then Font Header Modified return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getTrueTypeFont(String, PDFontDescriptor); when ','; then Font Header Modified return GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_whenComma_thenFontHeaderModifiedReturnGregorianCalendar()
      throws IOException {
    // Arrange, Act and Assert
    TrueTypeFont font = new FontMapperImpl().getTrueTypeFont(",", null).getFont();
    assertTrue(font.getHeader().getModified() instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, font.getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>When {@code Helvetica}.
   *   <li>Then return not Fallback.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getTrueTypeFont(String, PDFontDescriptor); when 'Helvetica'; then return not Fallback")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_whenHelvetica_thenReturnNotFallback() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act
    FontMapping<TrueTypeFont> actualTrueTypeFont =
        fontMapperImpl.getTrueTypeFont("Helvetica", new PDFontDescriptor());

    // Assert
    TrueTypeFont font = actualTrueTypeFont.getFont();
    assertTrue(font.getHeader().getModified() instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, font.getCmap().getCmaps().length);
    assertFalse(actualTrueTypeFont.isFallback());
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then Font Header Modified return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getTrueTypeFont(String, PDFontDescriptor); when 'null'; then Font Header Modified return GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_whenNull_thenFontHeaderModifiedReturnGregorianCalendar()
      throws IOException {
    // Arrange, Act and Assert
    TrueTypeFont font = new FontMapperImpl().getTrueTypeFont(null, null).getFont();
    assertTrue(font.getHeader().getModified() instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, font.getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return Font Name is {@code LiberationSans}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getTrueTypeFont(String, PDFontDescriptor); when PDFontDescriptor(); then return Font Name is 'LiberationSans'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_whenPDFontDescriptor_thenReturnFontNameIsLiberationSans()
      throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    TrueTypeFont font =
        fontMapperImpl.getTrueTypeFont("Base Font", new PDFontDescriptor()).getFont();
    assertEquals("LiberationSans", font.getName());
    assertEquals(139512L, font.getOriginalDataSize());
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(19, tableMap.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, font.getOriginalData().read(byteArray));
    assertTrue(tableMap.containsKey("OS/2"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("glyf"));
    assertTrue(tableMap.containsKey("kern"));
    assertArrayEquals(
        new byte[] {
          0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', -2, -32, 'f', 0, 2, ' ',
          -36, 0, 0, 0, 28, 'G', 'D', 'E', 'F', 0, '\'', 2, -49, 0, 2, 15, -84, 0, 0, 0, '&', 'G',
          'P', 'O', 'S', 'j', 'w', -101
        },
        byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>When {@code +}.
   *   <li>Then Font Header Modified return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getTrueTypeFont(String, PDFontDescriptor); when '+'; then Font Header Modified return GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_whenPlusSign_thenFontHeaderModifiedReturnGregorianCalendar()
      throws IOException {
    // Arrange, Act and Assert
    TrueTypeFont font = new FontMapperImpl().getTrueTypeFont("+", null).getFont();
    assertTrue(font.getHeader().getModified() instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, font.getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@code black}.
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is {@code black}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getFontBoxFont(String, PDFontDescriptor); given 'black'; when PDFontDescriptor() FontName is 'black'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_givenBlack_whenPDFontDescriptorFontNameIsBlack() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontName("black");

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont("Base Font", fontDescriptor).getFont();
    assertTrue(font instanceof TrueTypeFont);
    assertEquals("LiberationSans-Bold", font.getName());
    assertEquals(137052L, ((TrueTypeFont) font).getOriginalDataSize());
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(19, tableMap.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) font).getOriginalData().read(byteArray));
    assertTrue(tableMap.containsKey("OS/2"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("glyf"));
    assertTrue(tableMap.containsKey("kern"));
    assertArrayEquals(
        new byte[] {
          0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', -2, -32, -92, 0, 2, 23,
          '@', 0, 0, 0, 28, 'G', 'D', 'E', 'F', 0, '\'', 2, -49, 0, 2, 6, '|', 0, 0, 0, '&', 'G',
          'P', 'O', 'S', -43, '(', -15
        },
        byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@code bold}.
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is {@code bold}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getFontBoxFont(String, PDFontDescriptor); given 'bold'; when PDFontDescriptor() FontName is 'bold'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_givenBold_whenPDFontDescriptorFontNameIsBold() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontName("bold");

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont("Base Font", fontDescriptor).getFont();
    assertTrue(font instanceof TrueTypeFont);
    assertEquals("LiberationSans-Bold", font.getName());
    assertEquals(137052L, ((TrueTypeFont) font).getOriginalDataSize());
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(19, tableMap.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) font).getOriginalData().read(byteArray));
    assertTrue(tableMap.containsKey("OS/2"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("glyf"));
    assertTrue(tableMap.containsKey("kern"));
    assertArrayEquals(
        new byte[] {
          0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', -2, -32, -92, 0, 2, 23,
          '@', 0, 0, 0, 28, 'G', 'D', 'E', 'F', 0, '\'', 2, -49, 0, 2, 6, '|', 0, 0, 0, '&', 'G',
          'P', 'O', 'S', -43, '(', -15
        },
        byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@code -}.
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getFontBoxFont(String, PDFontDescriptor); given '-'; when PDFontDescriptor() FontName is '-'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_givenDash_whenPDFontDescriptorFontNameIsDash() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontName("-");

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont("Base Font", fontDescriptor).getFont();
    assertTrue(font instanceof TrueTypeFont);
    assertEquals("LiberationSans", font.getName());
    assertEquals(139512L, ((TrueTypeFont) font).getOriginalDataSize());
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(19, tableMap.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) font).getOriginalData().read(byteArray));
    assertTrue(tableMap.containsKey("OS/2"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("glyf"));
    assertTrue(tableMap.containsKey("kern"));
    assertArrayEquals(
        new byte[] {
          0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', -2, -32, 'f', 0, 2, ' ',
          -36, 0, 0, 0, 28, 'G', 'D', 'E', 'F', 0, '\'', 2, -49, 0, 2, 15, -84, 0, 0, 0, '&', 'G',
          'P', 'O', 'S', 'j', 'w', -101
        },
        byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor) addSubstitute {@code Times-Roman} and
   *       {@code +}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getFontBoxFont(String, PDFontDescriptor); given FontMapperImpl (default constructor) addSubstitute 'Times-Roman' and '+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_givenFontMapperImplAddSubstituteTimesRomanAndPlusSign()
      throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    fontMapperImpl.addSubstitute("Times-Roman", "+");

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont(null, null).getFont();
    assertTrue(((TrueTypeFont) font).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(font instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) font).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor).
   *   <li>When {@code Helvetica}.
   *   <li>Then return not Fallback.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getFontBoxFont(String, PDFontDescriptor); given FontMapperImpl (default constructor); when 'Helvetica'; then return not Fallback")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_givenFontMapperImpl_whenHelvetica_thenReturnNotFallback()
      throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act
    FontMapping<FontBoxFont> actualFontBoxFont =
        fontMapperImpl.getFontBoxFont("Helvetica", new PDFontDescriptor());

    // Assert
    FontBoxFont font = actualFontBoxFont.getFont();
    assertTrue(((TrueTypeFont) font).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(font instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) font).getCmap().getCmaps().length);
    assertFalse(actualFontBoxFont.isFallback());
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@code heavy}.
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is {@code heavy}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getFontBoxFont(String, PDFontDescriptor); given 'heavy'; when PDFontDescriptor() FontName is 'heavy'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_givenHeavy_whenPDFontDescriptorFontNameIsHeavy() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontName("heavy");

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont("Base Font", fontDescriptor).getFont();
    assertTrue(font instanceof TrueTypeFont);
    assertEquals("LiberationSans-Bold", font.getName());
    assertEquals(137052L, ((TrueTypeFont) font).getOriginalDataSize());
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(19, tableMap.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) font).getOriginalData().read(byteArray));
    assertTrue(tableMap.containsKey("OS/2"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("glyf"));
    assertTrue(tableMap.containsKey("kern"));
    assertArrayEquals(
        new byte[] {
          0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', -2, -32, -92, 0, 2, 23,
          '@', 0, 0, 0, 28, 'G', 'D', 'E', 'F', 0, '\'', 2, -49, 0, 2, 6, '|', 0, 0, 0, '&', 'G',
          'P', 'O', 'S', -43, '(', -15
        },
        byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>When {@code ,}.
   *   <li>Then Font Header Modified return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getFontBoxFont(String, PDFontDescriptor); when ','; then Font Header Modified return GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_whenComma_thenFontHeaderModifiedReturnGregorianCalendar()
      throws IOException {
    // Arrange, Act and Assert
    FontBoxFont font = new FontMapperImpl().getFontBoxFont(",", null).getFont();
    assertTrue(((TrueTypeFont) font).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(font instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) font).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then Font Header Modified return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getFontBoxFont(String, PDFontDescriptor); when 'null'; then Font Header Modified return GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_whenNull_thenFontHeaderModifiedReturnGregorianCalendar()
      throws IOException {
    // Arrange, Act and Assert
    FontBoxFont font = new FontMapperImpl().getFontBoxFont(null, null).getFont();
    assertTrue(((TrueTypeFont) font).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(font instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) font).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()}.
   *   <li>Then return Font Name is {@code LiberationSans}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getFontBoxFont(String, PDFontDescriptor); when PDFontDescriptor(); then return Font Name is 'LiberationSans'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_whenPDFontDescriptor_thenReturnFontNameIsLiberationSans()
      throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont("Base Font", new PDFontDescriptor()).getFont();
    assertTrue(font instanceof TrueTypeFont);
    assertEquals("LiberationSans", font.getName());
    assertEquals(139512L, ((TrueTypeFont) font).getOriginalDataSize());
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(19, tableMap.size());
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) font).getOriginalData().read(byteArray));
    assertTrue(tableMap.containsKey("OS/2"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("glyf"));
    assertTrue(tableMap.containsKey("kern"));
    assertArrayEquals(
        new byte[] {
          0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', -2, -32, 'f', 0, 2, ' ',
          -36, 0, 0, 0, 28, 'G', 'D', 'E', 'F', 0, '\'', 2, -49, 0, 2, 15, -84, 0, 0, 0, '&', 'G',
          'P', 'O', 'S', 'j', 'w', -101
        },
        byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   *
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor) addSubstitute {@code ,} and {@code -}.
   *   <li>When {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor,
   * PDCIDSystemInfo)}
   */
  @Test
  @DisplayName(
      "Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontMapperImpl (default constructor) addSubstitute ',' and '-'; when ','")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"
  })
  void testGetCIDFont_givenFontMapperImplAddSubstituteCommaAndDash_whenComma() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    fontMapperImpl.addSubstitute(",", "-");

    // Act and Assert
    FontBoxFont trueTypeFont =
        fontMapperImpl.getCIDFont(",", new PDFontDescriptor(), null).getTrueTypeFont();
    assertTrue(
        ((TrueTypeFont) trueTypeFont).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) trueTypeFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) trueTypeFont).getOS2Windows();
    assertSame(oS2Windows, tableMap.get("OS/2"));
    assertArrayEquals(new byte[] {2, 11, 6, 4, 2, 2, 2, 2, 2, 4}, oS2Windows.getPanose());
  }

  /**
   * Test {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   *
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor) addSubstitute {@code ,} and {@code +}.
   *   <li>When {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor,
   * PDCIDSystemInfo)}
   */
  @Test
  @DisplayName(
      "Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontMapperImpl (default constructor) addSubstitute ',' and '+'; when ','")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"
  })
  void testGetCIDFont_givenFontMapperImplAddSubstituteCommaAndPlusSign_whenComma()
      throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    fontMapperImpl.addSubstitute(",", "+");
    fontMapperImpl.addSubstitute(",", "-");

    // Act and Assert
    FontBoxFont trueTypeFont =
        fontMapperImpl.getCIDFont(",", new PDFontDescriptor(), null).getTrueTypeFont();
    assertTrue(
        ((TrueTypeFont) trueTypeFont).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) trueTypeFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) trueTypeFont).getOS2Windows();
    assertSame(oS2Windows, tableMap.get("OS/2"));
    assertArrayEquals(new byte[] {2, 11, 6, 4, 2, 2, 2, 2, 2, 4}, oS2Windows.getPanose());
  }

  /**
   * Test {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   *
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor) addSubstitute space and space.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor,
   * PDCIDSystemInfo)}
   */
  @Test
  @DisplayName(
      "Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontMapperImpl (default constructor) addSubstitute space and space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"
  })
  void testGetCIDFont_givenFontMapperImplAddSubstituteSpaceAndSpace() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    fontMapperImpl.addSubstitute(" ", " ");
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    PDCIDSystemInfo cidSystemInfo = new PDCIDSystemInfo("Registry", "Ordering", 1);

    // Act
    CIDFontMapping actualCIDFont =
        fontMapperImpl.getCIDFont("Courier", fontDescriptor, cidSystemInfo);

    // Assert
    FontBoxFont trueTypeFont = actualCIDFont.getTrueTypeFont();
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    assertEquals("LiberationMono", trueTypeFont.getName());
    assertNull(((TrueTypeFont) trueTypeFont).getGsub());
    assertNull(((TrueTypeFont) trueTypeFont).getKerning());
    assertEquals(108172L, ((TrueTypeFont) trueTypeFont).getOriginalDataSize());
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) trueTypeFont).getOriginalData().read(byteArray));
    assertEquals(674, ((TrueTypeFont) trueTypeFont).getNumberOfGlyphs());
    assertFalse(actualCIDFont.isFallback());
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(Short.SIZE, tableMap.size());
    assertTrue(tableMap.containsKey("OS/2"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("gasp"));
    assertTrue(tableMap.containsKey("glyf"));
    assertEquals(Short.SIZE, ((TrueTypeFont) trueTypeFont).getTables().size());
    assertArrayEquals(
        new byte[] {
          0, 1, 0, 0, 0, 16, 1, 0, 0, 4, 0, 0, 'F', 'F', 'T', 'M', 'g', 'Z', ';', -71, 0, 1, -90,
          'p', 0, 0, 0, 28, 'G', 'D', 'E', 'F', 0, '\'', 2, -56, 0, 1, -90, 'H', 0, 0, 0, '&', 'O',
          'S', '/', '2', -7, ' ', 'w'
        },
        byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   *
   * <ul>
   *   <li>Then TrueTypeFont Header Modified return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor,
   * PDCIDSystemInfo)}
   */
  @Test
  @DisplayName(
      "Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); then TrueTypeFont Header Modified return GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"
  })
  void testGetCIDFont_thenTrueTypeFontHeaderModifiedReturnGregorianCalendar() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    FontBoxFont trueTypeFont =
        fontMapperImpl.getCIDFont(null, new PDFontDescriptor(), null).getTrueTypeFont();
    assertTrue(
        ((TrueTypeFont) trueTypeFont).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) trueTypeFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) trueTypeFont).getOS2Windows();
    assertSame(oS2Windows, tableMap.get("OS/2"));
    assertArrayEquals(new byte[] {2, 11, 6, 4, 2, 2, 2, 2, 2, 4}, oS2Windows.getPanose());
  }

  /**
   * Test {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   *
   * <ul>
   *   <li>When {@code Base Font}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor,
   * PDCIDSystemInfo)}
   */
  @Test
  @DisplayName("Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); when 'Base Font'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"
  })
  void testGetCIDFont_whenBaseFont() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    PDCIDSystemInfo cidSystemInfo = new PDCIDSystemInfo("Registry", "Ordering", 1);

    // Act and Assert
    FontBoxFont trueTypeFont =
        fontMapperImpl.getCIDFont("Base Font", fontDescriptor, cidSystemInfo).getTrueTypeFont();
    assertTrue(
        ((TrueTypeFont) trueTypeFont).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) trueTypeFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) trueTypeFont).getOS2Windows();
    assertSame(oS2Windows, tableMap.get("OS/2"));
    assertArrayEquals(new byte[] {2, 11, 6, 4, 2, 2, 2, 2, 2, 4}, oS2Windows.getPanose());
  }

  /**
   * Test {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   *
   * <ul>
   *   <li>When {@code ,}.
   *   <li>Then TrueTypeFont Header Modified return {@link GregorianCalendar}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor,
   * PDCIDSystemInfo)}
   */
  @Test
  @DisplayName(
      "Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); when ','; then TrueTypeFont Header Modified return GregorianCalendar")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"
  })
  void testGetCIDFont_whenComma_thenTrueTypeFontHeaderModifiedReturnGregorianCalendar()
      throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    FontBoxFont trueTypeFont =
        fontMapperImpl.getCIDFont(",", new PDFontDescriptor(), null).getTrueTypeFont();
    assertTrue(
        ((TrueTypeFont) trueTypeFont).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) trueTypeFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) trueTypeFont).getOS2Windows();
    assertSame(oS2Windows, tableMap.get("OS/2"));
    assertArrayEquals(new byte[] {2, 11, 6, 4, 2, 2, 2, 2, 2, 4}, oS2Windows.getPanose());
  }

  /**
   * Test {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   *
   * <ul>
   *   <li>When {@code Courier}.
   *   <li>Then return TrueTypeFont Name is {@code LiberationMono}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor,
   * PDCIDSystemInfo)}
   */
  @Test
  @DisplayName(
      "Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); when 'Courier'; then return TrueTypeFont Name is 'LiberationMono'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"
  })
  void testGetCIDFont_whenCourier_thenReturnTrueTypeFontNameIsLiberationMono() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    PDCIDSystemInfo cidSystemInfo = new PDCIDSystemInfo("Registry", "Ordering", 1);

    // Act
    CIDFontMapping actualCIDFont =
        fontMapperImpl.getCIDFont("Courier", fontDescriptor, cidSystemInfo);

    // Assert
    FontBoxFont trueTypeFont = actualCIDFont.getTrueTypeFont();
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    assertEquals("LiberationMono", trueTypeFont.getName());
    assertNull(((TrueTypeFont) trueTypeFont).getGsub());
    assertNull(((TrueTypeFont) trueTypeFont).getKerning());
    assertEquals(108172L, ((TrueTypeFont) trueTypeFont).getOriginalDataSize());
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) trueTypeFont).getOriginalData().read(byteArray));
    assertEquals(674, ((TrueTypeFont) trueTypeFont).getNumberOfGlyphs());
    assertFalse(actualCIDFont.isFallback());
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(Short.SIZE, tableMap.size());
    assertTrue(tableMap.containsKey("OS/2"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("gasp"));
    assertTrue(tableMap.containsKey("glyf"));
    assertEquals(Short.SIZE, ((TrueTypeFont) trueTypeFont).getTables().size());
    assertArrayEquals(
        new byte[] {
          0, 1, 0, 0, 0, 16, 1, 0, 0, 4, 0, 0, 'F', 'F', 'T', 'M', 'g', 'Z', ';', -71, 0, 1, -90,
          'p', 0, 0, 0, 28, 'G', 'D', 'E', 'F', 0, '\'', 2, -56, 0, 1, -90, 'H', 0, 0, 0, '&', 'O',
          'S', '/', '2', -7, ' ', 'w'
        },
        byteArray);
  }
}
