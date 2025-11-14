package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.ttf.OS2WindowsMetricsTable;
import org.apache.fontbox.ttf.OpenTypeFont;
import org.apache.fontbox.ttf.TTFTable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FontMapperImplDiffblueTest {
  @InjectMocks private FontMapperImpl fontMapperImpl;

  @Mock private FontProvider fontProvider;

  @Mock private Map<String, FontInfo> map;

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
   * Test {@link FontMapperImpl#setProvider(FontProvider)}.
   *
   * <ul>
   *   <li>Given {@link FontProvider} {@link FontProvider#getFontInfo()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#setProvider(FontProvider)}
   */
  @Test
  @DisplayName(
      "Test setProvider(FontProvider); given FontProvider getFontInfo() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FontMapperImpl.setProvider(FontProvider)"})
  void testSetProvider_givenFontProviderGetFontInfoThrowRuntimeException() {
    // Arrange
    Mockito.<List<? extends FontInfo>>when(fontProvider.getFontInfo())
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> fontMapperImpl.setProvider(fontProvider));
    verify(fontProvider).getFontInfo();
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
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, font.getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@link FontInfo} {@link FontInfo#getFont()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getTrueTypeFont(String, PDFontDescriptor); given FontInfo getFont() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_givenFontInfoGetFontReturnNull() throws IOException {
    // Arrange
    FontInfo fontInfo = mock(FontInfo.class);
    when(fontInfo.getFont()).thenReturn(null);
    when(fontInfo.getFormat()).thenReturn(FontFormat.TTF);
    when(map.get(Mockito.<Object>any())).thenReturn(fontInfo);

    // Act
    FontMapping<TrueTypeFont> actualTrueTypeFont =
        fontMapperImpl.getTrueTypeFont("Base Font", new PDFontDescriptor());

    // Assert
    verify(map, atLeast(1)).get(Mockito.<Object>any());
    verify(fontInfo, atLeast(1)).getFont();
    verify(fontInfo, atLeast(1)).getFormat();
    TrueTypeFont font = actualTrueTypeFont.getFont();
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, font.getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
    OS2WindowsMetricsTable oS2Windows = font.getOS2Windows();
    assertSame(oS2Windows, tableMap.get("OS/2"));
    assertArrayEquals(new byte[] {2, 11, 6, 4, 2, 2, 2, 2, 2, 4}, oS2Windows.getPanose());
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@link FontInfo} {@link FontInfo#getFont()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getTrueTypeFont(String, PDFontDescriptor); given FontInfo getFont() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_givenFontInfoGetFontThrowRuntimeException() {
    // Arrange
    FontInfo fontInfo = mock(FontInfo.class);
    when(fontInfo.getFont()).thenThrow(new RuntimeException());
    when(fontInfo.getFormat()).thenReturn(FontFormat.TTF);
    when(map.get(Mockito.<Object>any())).thenReturn(fontInfo);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> fontMapperImpl.getTrueTypeFont("Base Font", new PDFontDescriptor()));
    verify(map).get(isA(Object.class));
    verify(fontInfo).getFont();
    verify(fontInfo).getFormat();
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@link FontInfo} {@link FontInfo#getFont()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getTrueTypeFont(String, PDFontDescriptor); given FontInfo getFont() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_givenFontInfoGetFontThrowRuntimeException2() {
    // Arrange
    FontInfo fontInfo = mock(FontInfo.class);
    when(fontInfo.getFont()).thenThrow(new RuntimeException());
    when(fontInfo.getFormat()).thenReturn(FontFormat.TTF);
    when(map.get(Mockito.<Object>any())).thenReturn(fontInfo);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> fontMapperImpl.getTrueTypeFont(null, new PDFontDescriptor()));
    verify(map).get(isA(Object.class));
    verify(fontInfo).getFont();
    verify(fontInfo).getFormat();
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@link FontInfo} {@link FontInfo#getFormat()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getTrueTypeFont(String, PDFontDescriptor); given FontInfo getFormat() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_givenFontInfoGetFormatReturnNull() throws IOException {
    // Arrange
    FontInfo fontInfo = mock(FontInfo.class);
    when(fontInfo.getFormat()).thenReturn(null);
    when(map.get(Mockito.<Object>any())).thenReturn(fontInfo);

    // Act
    FontMapping<TrueTypeFont> actualTrueTypeFont =
        fontMapperImpl.getTrueTypeFont("Base Font", new PDFontDescriptor());

    // Assert
    verify(map, atLeast(1)).get(Mockito.<Object>any());
    verify(fontInfo, atLeast(1)).getFormat();
    TrueTypeFont font = actualTrueTypeFont.getFont();
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, font.getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
    OS2WindowsMetricsTable oS2Windows = font.getOS2Windows();
    assertSame(oS2Windows, tableMap.get("OS/2"));
    assertArrayEquals(new byte[] {2, 11, 6, 4, 2, 2, 2, 2, 2, 4}, oS2Windows.getPanose());
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@link FontInfo} {@link FontInfo#getFormat()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getTrueTypeFont(String, PDFontDescriptor); given FontInfo getFormat() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_givenFontInfoGetFormatThrowRuntimeException() {
    // Arrange
    FontInfo fontInfo = mock(FontInfo.class);
    when(fontInfo.getFormat()).thenThrow(new RuntimeException());
    when(map.get(Mockito.<Object>any())).thenReturn(fontInfo);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> fontMapperImpl.getTrueTypeFont("Base Font", new PDFontDescriptor()));
    verify(map).get(isA(Object.class));
    verify(fontInfo).getFormat();
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor).
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getTrueTypeFont(String, PDFontDescriptor); given FontMapperImpl (default constructor); then return array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_givenFontMapperImpl_thenReturnArrayLengthIsThree() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    TrueTypeFont font =
        fontMapperImpl.getTrueTypeFont("Base Font", new PDFontDescriptor()).getFont();
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, font.getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor).
   *   <li>When {@code ,}.
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getTrueTypeFont(String, PDFontDescriptor); given FontMapperImpl (default constructor); when ','; then return array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_givenFontMapperImpl_whenComma_thenReturnArrayLengthIsThree()
      throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont(",", new PDFontDescriptor()).getFont();
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, font.getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor).
   *   <li>When {@code Helvetica}.
   *   <li>Then return not Fallback.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getTrueTypeFont(String, PDFontDescriptor); given FontMapperImpl (default constructor); when 'Helvetica'; then return not Fallback")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_givenFontMapperImpl_whenHelvetica_thenReturnNotFallback()
      throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act
    FontMapping<TrueTypeFont> actualTrueTypeFont =
        fontMapperImpl.getTrueTypeFont("Helvetica", new PDFontDescriptor());

    // Assert
    TrueTypeFont font = actualTrueTypeFont.getFont();
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
   *   <li>Given {@link FontMapperImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getTrueTypeFont(String, PDFontDescriptor); given FontMapperImpl (default constructor); when 'null'; then return array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_givenFontMapperImpl_whenNull_thenReturnArrayLengthIsThree()
      throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont(null, new PDFontDescriptor()).getFont();
    Map<String, TTFTable> tableMap = font.getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, font.getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
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
   *   <li>Then return Font Name is {@code LiberationSerif}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getTrueTypeFont(String, PDFontDescriptor); when ','; then return Font Name is 'LiberationSerif'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_whenComma_thenReturnFontNameIsLiberationSerif() throws IOException {
    // Arrange, Act and Assert
    TrueTypeFont font = new FontMapperImpl().getTrueTypeFont(",", null).getFont();
    assertEquals("LiberationSerif", font.getName());
    assertEquals(152408L, font.getOriginalDataSize());
    byte[] byteArray = new byte[51];
    assertEquals(51, font.getOriginalData().read(byteArray));
    assertEquals(673, font.getNumberOfGlyphs());
    assertArrayEquals(
        new byte[] {
          0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', '0', 18, '{', 0, 2, 'S',
          '<', 0, 0, 0, 28, 'G', 'D', 'E', 'F', 0, '\'', 2, -57, 0, 2, 'B', -96, 0, 0, 0, '&', 'G',
          'P', 'O', 'S', '\b', -35, -11
        },
        byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>When {@code +}.
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getTrueTypeFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getTrueTypeFont(String, PDFontDescriptor); when '+'; then return array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getTrueTypeFont(String, PDFontDescriptor)"})
  void testGetTrueTypeFont_whenPlusSign_thenReturnArrayLengthIsThree() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    TrueTypeFont font = fontMapperImpl.getTrueTypeFont("+", new PDFontDescriptor()).getFont();
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
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) font).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@link FontInfo} {@link FontInfo#getFont()} return {@link OpenTypeFont}.
   *   <li>Then return not Fallback.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getFontBoxFont(String, PDFontDescriptor); given FontInfo getFont() return OpenTypeFont; then return not Fallback")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_givenFontInfoGetFontReturnOpenTypeFont_thenReturnNotFallback() {
    // Arrange
    FontInfo fontInfo = mock(FontInfo.class);
    when(fontInfo.getFont()).thenReturn(mock(OpenTypeFont.class));
    when(fontInfo.getFormat()).thenReturn(FontFormat.OTF);
    when(map.get(Mockito.<Object>any())).thenReturn(fontInfo);

    // Act
    FontMapping<FontBoxFont> actualFontBoxFont =
        fontMapperImpl.getFontBoxFont(",", new PDFontDescriptor());

    // Assert
    verify(map, atLeast(1)).get(Mockito.<Object>any());
    verify(fontInfo).getFont();
    verify(fontInfo, atLeast(1)).getFormat();
    assertFalse(actualFontBoxFont.isFallback());
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@link FontInfo} {@link FontInfo#getFont()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getFontBoxFont(String, PDFontDescriptor); given FontInfo getFont() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_givenFontInfoGetFontThrowRuntimeException() {
    // Arrange
    FontInfo fontInfo = mock(FontInfo.class);
    when(fontInfo.getFont()).thenThrow(new RuntimeException());
    when(fontInfo.getFormat()).thenReturn(FontFormat.TTF);
    when(map.get(Mockito.<Object>any())).thenReturn(fontInfo);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> fontMapperImpl.getFontBoxFont("Base Font", new PDFontDescriptor()));
    verify(map, atLeast(1)).get(Mockito.<Object>any());
    verify(fontInfo).getFont();
    verify(fontInfo, atLeast(1)).getFormat();
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@link FontInfo} {@link FontInfo#getFormat()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getFontBoxFont(String, PDFontDescriptor); given FontInfo getFormat() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_givenFontInfoGetFormatThrowRuntimeException() {
    // Arrange
    FontInfo fontInfo = mock(FontInfo.class);
    when(fontInfo.getFormat()).thenThrow(new RuntimeException());
    when(map.get(Mockito.<Object>any())).thenReturn(fontInfo);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> fontMapperImpl.getFontBoxFont("Base Font", new PDFontDescriptor()));
    verify(map).get(isA(Object.class));
    verify(fontInfo).getFormat();
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>Given {@link FontMapperImpl} (default constructor) addSubstitute {@code Helvetica} and
   *       {@code +}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getFontBoxFont(String, PDFontDescriptor); given FontMapperImpl (default constructor) addSubstitute 'Helvetica' and '+'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_givenFontMapperImplAddSubstituteHelveticaAndPlusSign_whenNull()
      throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    fontMapperImpl.addSubstitute("Helvetica", "+");

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont(null, new PDFontDescriptor()).getFont();
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
   *   <li>When {@code Base Font}.
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getFontBoxFont(String, PDFontDescriptor); given FontMapperImpl (default constructor); when 'Base Font'; then return array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_givenFontMapperImpl_whenBaseFont_thenReturnArrayLengthIsThree()
      throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont("Base Font", new PDFontDescriptor()).getFont();
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
   *   <li>When {@code ,}.
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getFontBoxFont(String, PDFontDescriptor); given FontMapperImpl (default constructor); when ','; then return array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_givenFontMapperImpl_whenComma_thenReturnArrayLengthIsThree()
      throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont(",", new PDFontDescriptor()).getFont();
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
   *   <li>Given {@link FontMapperImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getFontBoxFont(String, PDFontDescriptor); given FontMapperImpl (default constructor); when 'null'; then return array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_givenFontMapperImpl_whenNull_thenReturnArrayLengthIsThree()
      throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    FontBoxFont font = fontMapperImpl.getFontBoxFont(null, new PDFontDescriptor()).getFont();
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
   *   <li>Then return Font TableMap {@code OS/2} is Font OS2Windows.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getFontBoxFont(String, PDFontDescriptor); then return Font TableMap 'OS/2' is Font OS2Windows")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_thenReturnFontTableMapOs2IsFontOS2Windows() throws IOException {
    // Arrange
    FontInfo fontInfo = mock(FontInfo.class);
    when(fontInfo.getFont()).thenReturn(null);
    when(fontInfo.getFormat()).thenReturn(FontFormat.TTF);
    when(map.get(Mockito.<Object>any())).thenReturn(fontInfo);

    // Act
    FontMapping<FontBoxFont> actualFontBoxFont =
        fontMapperImpl.getFontBoxFont("Base Font", new PDFontDescriptor());

    // Assert
    verify(map, atLeast(1)).get(Mockito.<Object>any());
    verify(fontInfo, atLeast(1)).getFont();
    verify(fontInfo, atLeast(1)).getFormat();
    FontBoxFont font = actualFontBoxFont.getFont();
    assertTrue(font instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) font).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) font).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) font).getOS2Windows();
    assertSame(oS2Windows, tableMap.get("OS/2"));
    assertArrayEquals(new byte[] {2, 11, 6, 4, 2, 2, 2, 2, 2, 4}, oS2Windows.getPanose());
  }

  /**
   * Test {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}.
   *
   * <ul>
   *   <li>When {@code ,}.
   *   <li>Then return Font Name is {@code LiberationSerif}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getFontBoxFont(String, PDFontDescriptor)}
   */
  @Test
  @DisplayName(
      "Test getFontBoxFont(String, PDFontDescriptor); when ','; then return Font Name is 'LiberationSerif'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontMapping FontMapperImpl.getFontBoxFont(String, PDFontDescriptor)"})
  void testGetFontBoxFont_whenComma_thenReturnFontNameIsLiberationSerif() throws IOException {
    // Arrange, Act and Assert
    FontBoxFont font = new FontMapperImpl().getFontBoxFont(",", null).getFont();
    assertTrue(font instanceof TrueTypeFont);
    assertEquals("LiberationSerif", font.getName());
    assertEquals(152408L, ((TrueTypeFont) font).getOriginalDataSize());
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) font).getOriginalData().read(byteArray));
    assertEquals(673, ((TrueTypeFont) font).getNumberOfGlyphs());
    assertArrayEquals(
        new byte[] {
          0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', '0', 18, '{', 0, 2, 'S',
          '<', 0, 0, 0, 28, 'G', 'D', 'E', 'F', 0, '\'', 2, -57, 0, 2, 'B', -96, 0, 0, 0, '&', 'G',
          'P', 'O', 'S', '\b', -35, -11
        },
        byteArray);
  }

  /**
   * Test {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   *
   * <ul>
   *   <li>Given {@link FontInfo} {@link FontInfo#getFont()} return {@code null}.
   *   <li>When {@code Base Font}.
   *   <li>Then calls {@link FontInfo#getFont()}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor,
   * PDCIDSystemInfo)}
   */
  @Test
  @DisplayName(
      "Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontInfo getFont() return 'null'; when 'Base Font'; then calls getFont()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"
  })
  void testGetCIDFont_givenFontInfoGetFontReturnNull_whenBaseFont_thenCallsGetFont()
      throws IOException {
    // Arrange
    FontInfo fontInfo = mock(FontInfo.class);
    when(fontInfo.getFont()).thenReturn(null);
    when(fontInfo.getFormat()).thenReturn(FontFormat.TTF);
    when(map.get(Mockito.<Object>any())).thenReturn(fontInfo);
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    PDCIDSystemInfo cidSystemInfo = new PDCIDSystemInfo("Registry", "Ordering", 1);

    // Act
    CIDFontMapping actualCIDFont =
        fontMapperImpl.getCIDFont("Base Font", fontDescriptor, cidSystemInfo);

    // Assert
    verify(map, atLeast(1)).get(Mockito.<Object>any());
    verify(fontInfo).getFont();
    verify(fontInfo, atLeast(1)).getFormat();
    FontBoxFont trueTypeFont = actualCIDFont.getTrueTypeFont();
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
   *   <li>Given {@link FontInfo} {@link FontInfo#getFont()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor,
   * PDCIDSystemInfo)}
   */
  @Test
  @DisplayName(
      "Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontInfo getFont() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"
  })
  void testGetCIDFont_givenFontInfoGetFontThrowRuntimeException() {
    // Arrange
    FontInfo fontInfo = mock(FontInfo.class);
    when(fontInfo.getFont()).thenThrow(new RuntimeException());
    when(fontInfo.getFormat()).thenReturn(FontFormat.TTF);
    when(map.get(Mockito.<Object>any())).thenReturn(fontInfo);
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    PDCIDSystemInfo cidSystemInfo = new PDCIDSystemInfo("Registry", "Ordering", 1);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> fontMapperImpl.getCIDFont("Base Font", fontDescriptor, cidSystemInfo));
    verify(map, atLeast(1)).get(Mockito.<Object>any());
    verify(fontInfo).getFont();
    verify(fontInfo, atLeast(1)).getFormat();
  }

  /**
   * Test {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)}.
   *
   * <ul>
   *   <li>Given {@link FontInfo} {@link FontInfo#getFormat()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor,
   * PDCIDSystemInfo)}
   */
  @Test
  @DisplayName(
      "Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontInfo getFormat() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"
  })
  void testGetCIDFont_givenFontInfoGetFormatThrowRuntimeException() {
    // Arrange
    FontInfo fontInfo = mock(FontInfo.class);
    when(fontInfo.getFormat()).thenThrow(new RuntimeException());
    when(map.get(Mockito.<Object>any())).thenReturn(fontInfo);
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    PDCIDSystemInfo cidSystemInfo = new PDCIDSystemInfo("Registry", "Ordering", 1);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> fontMapperImpl.getCIDFont("Base Font", fontDescriptor, cidSystemInfo));
    verify(map).get(isA(Object.class));
    verify(fontInfo).getFormat();
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
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    PDCIDSystemInfo cidSystemInfo = new PDCIDSystemInfo("Registry", "Ordering", 1);

    // Act and Assert
    FontBoxFont trueTypeFont =
        fontMapperImpl.getCIDFont(",", fontDescriptor, cidSystemInfo).getTrueTypeFont();
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
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    PDCIDSystemInfo cidSystemInfo = new PDCIDSystemInfo("Registry", "Ordering", 1);

    // Act and Assert
    FontBoxFont trueTypeFont =
        fontMapperImpl.getCIDFont(",", fontDescriptor, cidSystemInfo).getTrueTypeFont();
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
   *   <li>Given {@link FontMapperImpl} (default constructor).
   *   <li>When {@code Base Font}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor,
   * PDCIDSystemInfo)}
   */
  @Test
  @DisplayName(
      "Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontMapperImpl (default constructor); when 'Base Font'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"
  })
  void testGetCIDFont_givenFontMapperImpl_whenBaseFont() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    PDCIDSystemInfo cidSystemInfo = new PDCIDSystemInfo("Registry", "Ordering", 1);

    // Act and Assert
    FontBoxFont trueTypeFont =
        fontMapperImpl.getCIDFont("Base Font", fontDescriptor, cidSystemInfo).getTrueTypeFont();
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
   *   <li>Given {@link FontMapperImpl} (default constructor).
   *   <li>When {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor,
   * PDCIDSystemInfo)}
   */
  @Test
  @DisplayName(
      "Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontMapperImpl (default constructor); when ','")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"
  })
  void testGetCIDFont_givenFontMapperImpl_whenComma() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    PDCIDSystemInfo cidSystemInfo = new PDCIDSystemInfo("Registry", "Ordering", 1);

    // Act and Assert
    FontBoxFont trueTypeFont =
        fontMapperImpl.getCIDFont(",", fontDescriptor, cidSystemInfo).getTrueTypeFont();
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
   *   <li>Given {@link FontMapperImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor,
   * PDCIDSystemInfo)}
   */
  @Test
  @DisplayName(
      "Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontMapperImpl (default constructor); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"
  })
  void testGetCIDFont_givenFontMapperImpl_whenNull() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    FontBoxFont trueTypeFont =
        fontMapperImpl.getCIDFont(",", new PDFontDescriptor(), null).getTrueTypeFont();
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
   *   <li>Given {@link FontMapperImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor,
   * PDCIDSystemInfo)}
   */
  @Test
  @DisplayName(
      "Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); given FontMapperImpl (default constructor); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"
  })
  void testGetCIDFont_givenFontMapperImpl_whenNull2() throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    PDCIDSystemInfo cidSystemInfo = new PDCIDSystemInfo("Registry", "Ordering", 1);

    // Act and Assert
    FontBoxFont trueTypeFont =
        fontMapperImpl.getCIDFont(null, fontDescriptor, cidSystemInfo).getTrueTypeFont();
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
   *   <li>When {@code Courier-Bold}.
   *   <li>Then return TrueTypeFont Name is {@code LiberationMono-Bold}.
   * </ul>
   *
   * <p>Method under test: {@link FontMapperImpl#getCIDFont(String, PDFontDescriptor,
   * PDCIDSystemInfo)}
   */
  @Test
  @DisplayName(
      "Test getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo); when 'Courier-Bold'; then return TrueTypeFont Name is 'LiberationMono-Bold'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CIDFontMapping FontMapperImpl.getCIDFont(String, PDFontDescriptor, PDCIDSystemInfo)"
  })
  void testGetCIDFont_whenCourierBold_thenReturnTrueTypeFontNameIsLiberationMonoBold()
      throws IOException {
    // Arrange
    FontMapperImpl fontMapperImpl = new FontMapperImpl();

    // Act and Assert
    FontBoxFont trueTypeFont =
        fontMapperImpl.getCIDFont("Courier-Bold", new PDFontDescriptor(), null).getTrueTypeFont();
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    assertEquals("LiberationMono-Bold", trueTypeFont.getName());
    assertEquals(105460L, ((TrueTypeFont) trueTypeFont).getOriginalDataSize());
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) trueTypeFont).getOriginalData().read(byteArray));
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(Short.SIZE, tableMap.size());
    assertTrue(tableMap.containsKey("OS/2"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("gasp"));
    assertTrue(tableMap.containsKey("glyf"));
    assertArrayEquals(
        new byte[] {
          0, 1, 0, 0, 0, 16, 1, 0, 0, 4, 0, 0, 'F', 'F', 'T', 'M', 'g', 'Z', 'A', 29, 0, 1, -101,
          -40, 0, 0, 0, 28, 'G', 'D', 'E', 'F', 0, '\'', 2, -56, 0, 1, -101, -80, 0, 0, 0, '&', 'O',
          'S', '/', '2', -6, '"', 'y'
        },
        byteArray);
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

    // Act and Assert
    FontBoxFont trueTypeFont =
        fontMapperImpl.getCIDFont("Courier", fontDescriptor, cidSystemInfo).getTrueTypeFont();
    assertTrue(trueTypeFont instanceof TrueTypeFont);
    assertEquals("LiberationMono", trueTypeFont.getName());
    assertEquals(108172L, ((TrueTypeFont) trueTypeFont).getOriginalDataSize());
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) trueTypeFont).getOriginalData().read(byteArray));
    Map<String, TTFTable> tableMap = ((TrueTypeFont) trueTypeFont).getTableMap();
    assertEquals(Short.SIZE, tableMap.size());
    assertTrue(tableMap.containsKey("OS/2"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("gasp"));
    assertTrue(tableMap.containsKey("glyf"));
    assertArrayEquals(
        new byte[] {
          0, 1, 0, 0, 0, 16, 1, 0, 0, 4, 0, 0, 'F', 'F', 'T', 'M', 'g', 'Z', ';', -71, 0, 1, -90,
          'p', 0, 0, 0, 28, 'G', 'D', 'E', 'F', 0, '\'', 2, -56, 0, 1, -90, 'H', 0, 0, 0, '&', 'O',
          'S', '/', '2', -7, ' ', 'w'
        },
        byteArray);
  }
}
