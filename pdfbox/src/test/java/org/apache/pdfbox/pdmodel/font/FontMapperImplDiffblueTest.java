package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * <p>
   * Method under test: default or parameterless constructor of {@link FontMapperImpl}
   */
  @Test
  @DisplayName("Test new FontMapperImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FontMapperImpl.<init>()"})
  void testNewFontMapperImpl() {
    // Arrange, Act and Assert
    FontProvider provider = (new FontMapperImpl()).getProvider();
    assertTrue(provider instanceof FileSystemFontProvider);
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

  /**
   * Test {@link FontMapperImpl#setProvider(FontProvider)}.
   * <p>
   * Method under test: {@link FontMapperImpl#setProvider(FontProvider)}
   */
  @Test
  @DisplayName("Test setProvider(FontProvider)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link FontMapperImpl#getProvider()}
   */
  @Test
  @DisplayName("Test getProvider()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontProvider FontMapperImpl.getProvider()"})
  void testGetProvider() {
    // Arrange and Act
    FontProvider actualProvider = (new FontMapperImpl()).getProvider();

    // Assert
    assertTrue(actualProvider instanceof FileSystemFontProvider);
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
   * <ul>
   *   <li>Given {@code black}.</li>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is {@code black}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getTrueTypeFont(String, PDFontDescriptor); given 'black'; when PDFontDescriptor() FontName is 'black'")
  @Tag("MaintainedByDiffblue")
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
        new byte[]{0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', -2, -32, -92, 0, 2, 23, '@', 0, 0, 0,
            28, 'G', 'D', 'E', 'F', 0, '\'', 2, -49, 0, 2, 6, '|', 0, 0, 0, '&', 'G', 'P', 'O', 'S', -43, '(', -15},
        byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>Given {@code bold}.</li>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is {@code bold}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getTrueTypeFont(String, PDFontDescriptor); given 'bold'; when PDFontDescriptor() FontName is 'bold'")
  @Tag("MaintainedByDiffblue")
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
        new byte[]{0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', -2, -32, -92, 0, 2, 23, '@', 0, 0, 0,
            28, 'G', 'D', 'E', 'F', 0, '\'', 2, -49, 0, 2, 6, '|', 0, 0, 0, '&', 'G', 'P', 'O', 'S', -43, '(', -15},
        byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>Given {@code -}.</li>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getTrueTypeFont(String, PDFontDescriptor); given '-'; when PDFontDescriptor() FontName is '-'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_givenDash_whenPDFontDescriptorFontNameIsDash() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontName("-");

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont("Base Font", fontDescriptor).getFont();
    assertTrue(font.getHeader().getModified() instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, font.getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>Given {@code heavy}.</li>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is {@code heavy}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getTrueTypeFont(String, PDFontDescriptor); given 'heavy'; when PDFontDescriptor() FontName is 'heavy'")
  @Tag("MaintainedByDiffblue")
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
        new byte[]{0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', -2, -32, -92, 0, 2, 23, '@', 0, 0, 0,
            28, 'G', 'D', 'E', 'F', 0, '\'', 2, -49, 0, 2, 6, '|', 0, 0, 0, '&', 'G', 'P', 'O', 'S', -43, '(', -15},
        byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>When {@code ,}.</li>
   *   <li>Then Font Header Modified return {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getTrueTypeFont(String, PDFontDescriptor); when ','; then Font Header Modified return GregorianCalendar")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_whenComma_thenFontHeaderModifiedReturnGregorianCalendar() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont(",", new PDFontDescriptor()).getFont();
    assertTrue(font.getHeader().getModified() instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, font.getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>When {@code Helvetica}.</li>
   *   <li>Then return not Fallback.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getTrueTypeFont(String, PDFontDescriptor); when 'Helvetica'; then return not Fallback")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_whenHelvetica_thenReturnNotFallback() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act
    FontMapping<TrueTypeFont> actualTrueTypeFont = fontMapperImpl.getTrueTypeFont("Helvetica", new PDFontDescriptor());

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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then Font Header Modified return {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getTrueTypeFont(String, PDFontDescriptor); when 'null'; then Font Header Modified return GregorianCalendar")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_whenNull_thenFontHeaderModifiedReturnGregorianCalendar() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont(null, new PDFontDescriptor()).getFont();
    assertTrue(font.getHeader().getModified() instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, font.getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Font Name is {@code LiberationSerif}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getTrueTypeFont(String, PDFontDescriptor); when 'null'; then return Font Name is 'LiberationSerif'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_whenNull_thenReturnFontNameIsLiberationSerif() throws IOException {
    // Arrange, Act and Assert
    TrueTypeFont font = (new FontMapperImpl()).getTrueTypeFont("Base Font", null).getFont();
    assertEquals("LiberationSerif", font.getName());
    assertEquals(152408L, font.getOriginalDataSize());
    byte[] byteArray = new byte[51];
    assertEquals(51, font.getOriginalData().read(byteArray));
    assertEquals(673, font.getNumberOfGlyphs());
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', '0', 18, '{', 0, 2,
        'S', '<', 0, 0, 0, 28, 'G', 'D', 'E', 'F', 0, '\'', 2, -57, 0, 2, 'B', -96, 0, 0, 0, '&', 'G', 'P', 'O', 'S',
        '\b', -35, -11}, byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getTrueTypeFont(String, PDFontDescriptor); when PDFontDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_whenPDFontDescriptor() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont("Base Font", new PDFontDescriptor()).getFont();
    assertTrue(font.getHeader().getModified() instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, font.getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>When {@code +}.</li>
   *   <li>Then Font Header Modified return {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getTrueTypeFont(String, PDFontDescriptor); when '+'; then Font Header Modified return GregorianCalendar")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_whenPlusSign_thenFontHeaderModifiedReturnGregorianCalendar() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont("+", new PDFontDescriptor()).getFont();
    assertTrue(font.getHeader().getModified() instanceof GregorianCalendar);
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, font.getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>Given {@code black}.</li>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is {@code black}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getFontBoxFont(String, PDFontDescriptor); given 'black'; when PDFontDescriptor() FontName is 'black'")
  @Tag("MaintainedByDiffblue")
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
        new byte[]{0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', -2, -32, -92, 0, 2, 23, '@', 0, 0, 0,
            28, 'G', 'D', 'E', 'F', 0, '\'', 2, -49, 0, 2, 6, '|', 0, 0, 0, '&', 'G', 'P', 'O', 'S', -43, '(', -15},
        byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>Given {@code bold}.</li>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is {@code bold}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getFontBoxFont(String, PDFontDescriptor); given 'bold'; when PDFontDescriptor() FontName is 'bold'")
  @Tag("MaintainedByDiffblue")
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
        new byte[]{0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', -2, -32, -92, 0, 2, 23, '@', 0, 0, 0,
            28, 'G', 'D', 'E', 'F', 0, '\'', 2, -49, 0, 2, 6, '|', 0, 0, 0, '&', 'G', 'P', 'O', 'S', -43, '(', -15},
        byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>Given {@code -}.</li>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is {@code -}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getFontBoxFont(String, PDFontDescriptor); given '-'; when PDFontDescriptor() FontName is '-'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_givenDash_whenPDFontDescriptorFontNameIsDash() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontName("-");

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont("Base Font", fontDescriptor).getFont();
    assertTrue(((TrueTypeFont) font).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(font instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) font).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>Given {@code heavy}.</li>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()} FontName is {@code heavy}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getFontBoxFont(String, PDFontDescriptor); given 'heavy'; when PDFontDescriptor() FontName is 'heavy'")
  @Tag("MaintainedByDiffblue")
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
        new byte[]{0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', -2, -32, -92, 0, 2, 23, '@', 0, 0, 0,
            28, 'G', 'D', 'E', 'F', 0, '\'', 2, -49, 0, 2, 6, '|', 0, 0, 0, '&', 'G', 'P', 'O', 'S', -43, '(', -15},
        byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>When {@code ,}.</li>
   *   <li>Then Font Header Modified return {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getFontBoxFont(String, PDFontDescriptor); when ','; then Font Header Modified return GregorianCalendar")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_whenComma_thenFontHeaderModifiedReturnGregorianCalendar() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont(",", new PDFontDescriptor()).getFont();
    assertTrue(((TrueTypeFont) font).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(font instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) font).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>When {@code Helvetica}.</li>
   *   <li>Then return not Fallback.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getFontBoxFont(String, PDFontDescriptor); when 'Helvetica'; then return not Fallback")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_whenHelvetica_thenReturnNotFallback() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act
    FontMapping<FontBoxFont> actualFontBoxFont = fontMapperImpl.getFontBoxFont("Helvetica", new PDFontDescriptor());

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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then Font Header Modified return {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getFontBoxFont(String, PDFontDescriptor); when 'null'; then Font Header Modified return GregorianCalendar")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_whenNull_thenFontHeaderModifiedReturnGregorianCalendar() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont(null, new PDFontDescriptor()).getFont();
    assertTrue(((TrueTypeFont) font).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(font instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) font).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Font Name is {@code LiberationSerif}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getFontBoxFont(String, PDFontDescriptor); when 'null'; then return Font Name is 'LiberationSerif'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_whenNull_thenReturnFontNameIsLiberationSerif() throws IOException {
    // Arrange, Act and Assert
    FontBoxFont font = (new FontMapperImpl()).getFontBoxFont("Base Font", null).getFont();
    assertTrue(font instanceof TrueTypeFont);
    assertEquals("LiberationSerif", font.getName());
    assertEquals(152408L, ((TrueTypeFont) font).getOriginalDataSize());
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) font).getOriginalData().read(byteArray));
    assertEquals(673, ((TrueTypeFont) font).getNumberOfGlyphs());
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', '0', 18, '{', 0, 2,
        'S', '<', 0, 0, 0, 28, 'G', 'D', 'E', 'F', 0, '\'', 2, -57, 0, 2, 'B', -96, 0, 0, 0, '&', 'G', 'P', 'O', 'S',
        '\b', -35, -11}, byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>When {@link PDFontDescriptor#PDFontDescriptor()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getFontBoxFont(String, PDFontDescriptor); when PDFontDescriptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_whenPDFontDescriptor() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont("Base Font", new PDFontDescriptor()).getFont();
    assertTrue(((TrueTypeFont) font).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(font instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) font).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   * <ul>
   *   <li>When {@code +}.</li>
   *   <li>Then Font Header Modified return {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test getFontBoxFont(String, PDFontDescriptor); when '+'; then Font Header Modified return GregorianCalendar")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_whenPlusSign_thenFontHeaderModifiedReturnGregorianCalendar() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont("+", new PDFontDescriptor()).getFont();
    assertTrue(((TrueTypeFont) font).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(font instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) font).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor) addSubstitute {@code +} and {@code +}.</li>
   *   <li>When {@code +}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}
   */
  @Test
  @DisplayName("Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontMapperImpl (default constructor) addSubstitute '+' and '+'; when '+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.pdmodel.font.CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"})
  void testGetCIDFont_givenFontMapperImplAddSubstitutePlusSignAndPlusSign_whenPlusSign() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    fontMapperImpl.addSubstitute("+", "+");
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();

    // Act and Assert
    FontBoxFont trueTypeFont = fontMapperImpl
        .getCIDFont("+", fontDescriptor, new PDCIDSystemInfo("Registry", "Ordering", 1))
        .getTrueTypeFont();
    assertTrue(((TrueTypeFont) trueTypeFont).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) trueTypeFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) trueTypeFont).getOS2Windows();
    assertSame(oS2Windows, tableMap.get("OS/2"));
    assertArrayEquals(new byte[]{2, 11, 6, 4, 2, 2, 2, 2, 2, 4}, oS2Windows.getPanose());
  }

  /**
   * Test {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor).</li>
   *   <li>When {@code Base Font}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}
   */
  @Test
  @DisplayName("Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontMapperImpl (default constructor); when 'Base Font'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.pdmodel.font.CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"})
  void testGetCIDFont_givenFontMapperImpl_whenBaseFont() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();

    // Act and Assert
    FontBoxFont trueTypeFont = fontMapperImpl
        .getCIDFont("Base Font", fontDescriptor, new PDCIDSystemInfo("Registry", "Ordering", 1))
        .getTrueTypeFont();
    assertTrue(((TrueTypeFont) trueTypeFont).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) trueTypeFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) trueTypeFont).getOS2Windows();
    assertSame(oS2Windows, tableMap.get("OS/2"));
    assertArrayEquals(new byte[]{2, 11, 6, 4, 2, 2, 2, 2, 2, 4}, oS2Windows.getPanose());
  }

  /**
   * Test {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor).</li>
   *   <li>When {@code Base Font}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}
   */
  @Test
  @DisplayName("Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontMapperImpl (default constructor); when 'Base Font'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.pdmodel.font.CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"})
  void testGetCIDFont_givenFontMapperImpl_whenBaseFont2() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    FontBoxFont trueTypeFont = fontMapperImpl.getCIDFont("Base Font", new PDFontDescriptor(), null).getTrueTypeFont();
    assertTrue(((TrueTypeFont) trueTypeFont).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) trueTypeFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) trueTypeFont).getOS2Windows();
    assertSame(oS2Windows, tableMap.get("OS/2"));
    assertArrayEquals(new byte[]{2, 11, 6, 4, 2, 2, 2, 2, 2, 4}, oS2Windows.getPanose());
  }

  /**
   * Test {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor).</li>
   *   <li>When {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}
   */
  @Test
  @DisplayName("Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontMapperImpl (default constructor); when ','")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.pdmodel.font.CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"})
  void testGetCIDFont_givenFontMapperImpl_whenComma() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();

    // Act and Assert
    FontBoxFont trueTypeFont = fontMapperImpl
        .getCIDFont(",", fontDescriptor, new PDCIDSystemInfo("Registry", "Ordering", 1))
        .getTrueTypeFont();
    assertTrue(((TrueTypeFont) trueTypeFont).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) trueTypeFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) trueTypeFont).getOS2Windows();
    assertSame(oS2Windows, tableMap.get("OS/2"));
    assertArrayEquals(new byte[]{2, 11, 6, 4, 2, 2, 2, 2, 2, 4}, oS2Windows.getPanose());
  }

  /**
   * Test {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor).</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}
   */
  @Test
  @DisplayName("Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontMapperImpl (default constructor); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.pdmodel.font.CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"})
  void testGetCIDFont_givenFontMapperImpl_whenNull() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();

    // Act and Assert
    FontBoxFont trueTypeFont = fontMapperImpl
        .getCIDFont(null, fontDescriptor, new PDCIDSystemInfo("Registry", "Ordering", 1))
        .getTrueTypeFont();
    assertTrue(((TrueTypeFont) trueTypeFont).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) trueTypeFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) trueTypeFont).getOS2Windows();
    assertSame(oS2Windows, tableMap.get("OS/2"));
    assertArrayEquals(new byte[]{2, 11, 6, 4, 2, 2, 2, 2, 2, 4}, oS2Windows.getPanose());
  }

  /**
   * Test {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor).</li>
   *   <li>When {@code +}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}
   */
  @Test
  @DisplayName("Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontMapperImpl (default constructor); when '+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.pdmodel.font.CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"})
  void testGetCIDFont_givenFontMapperImpl_whenPlusSign() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();

    // Act and Assert
    FontBoxFont trueTypeFont = fontMapperImpl
        .getCIDFont("+", fontDescriptor, new PDCIDSystemInfo("Registry", "Ordering", 1))
        .getTrueTypeFont();
    assertTrue(((TrueTypeFont) trueTypeFont).getHeader().getModified() instanceof GregorianCalendar);
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) trueTypeFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) trueTypeFont).getOS2Windows();
    assertSame(oS2Windows, tableMap.get("OS/2"));
    assertArrayEquals(new byte[]{2, 11, 6, 4, 2, 2, 2, 2, 2, 4}, oS2Windows.getPanose());
  }
}
