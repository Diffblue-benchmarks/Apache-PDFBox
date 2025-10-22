package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.geom.Rectangle2D.Float;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.type1.Type1Font;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.StandardEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.SymbolEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.Type1Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.ZapfDingbatsEncoding;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDType1FontDiffblueTest {
  /**
   * Test {@link PDType1Font#PDType1Font(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then FontBoxFont return {@link TrueTypeFont}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#PDType1Font(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDType1Font(COSDictionary); when COSDictionary(); then FontBoxFont return TrueTypeFont")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDType1Font.<init>(COSDictionary)"})
  void testNewPDType1Font_whenCOSDictionary_thenFontBoxFontReturnTrueTypeFont() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    // Act
    PDType1Font actualPdType1Font = new PDType1Font(fontDictionary);

    // Assert
    assertTrue(actualPdType1Font.getFontBoxFont() instanceof TrueTypeFont);
    assertTrue(actualPdType1Font.getEncoding() instanceof StandardEncoding);
    assertNull(actualPdType1Font.getSymbolicFlag());
    assertNull(actualPdType1Font.getSubType());
    assertNull(actualPdType1Font.getType());
    assertNull(actualPdType1Font.getBaseFont());
    assertNull(actualPdType1Font.getName());
    assertNull(actualPdType1Font.getStandard14AFM());
    assertNull(actualPdType1Font.getToUnicodeCMap());
    assertNull(actualPdType1Font.getType1Font());
    assertNull(actualPdType1Font.getFontDescriptor());
    assertEquals(0.0f, actualPdType1Font.getAverageFontWidth());
    assertEquals(250.0f, actualPdType1Font.getSpaceWidth());
    assertFalse(actualPdType1Font.isVertical());
    assertFalse(actualPdType1Font.isDamaged());
    assertFalse(actualPdType1Font.isEmbedded());
    assertTrue(actualPdType1Font.getWidths().isEmpty());
    assertSame(fontDictionary, actualPdType1Font.getCOSObject());
  }

  /**
   * Test {@link PDType1Font#PDType1Font(FontName)}.
   * <ul>
   *   <li>When {@code SYMBOL}.</li>
   *   <li>Then Encoding return {@link SymbolEncoding}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#PDType1Font(FontName)}
   */
  @Test
  @DisplayName("Test new PDType1Font(FontName); when 'SYMBOL'; then Encoding return SymbolEncoding")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDType1Font.<init>(FontName)"})
  void testNewPDType1Font_whenSymbol_thenEncodingReturnSymbolEncoding() {
    // Arrange and Act
    PDType1Font actualPdType1Font = new PDType1Font(FontName.SYMBOL);

    // Assert
    assertTrue(actualPdType1Font.getEncoding() instanceof SymbolEncoding);
    assertEquals("Symbol", actualPdType1Font.getBaseFont());
    assertEquals("Symbol", actualPdType1Font.getName());
    assertEquals(588.03156f, actualPdType1Font.getAverageFontWidth());
  }

  /**
   * Test {@link PDType1Font#PDType1Font(FontName)}.
   * <ul>
   *   <li>When {@code TIMES_ROMAN}.</li>
   *   <li>Then Encoding return {@link WinAnsiEncoding}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#PDType1Font(FontName)}
   */
  @Test
  @DisplayName("Test new PDType1Font(FontName); when 'TIMES_ROMAN'; then Encoding return WinAnsiEncoding")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDType1Font.<init>(FontName)"})
  void testNewPDType1Font_whenTimesRoman_thenEncodingReturnWinAnsiEncoding() {
    // Arrange and Act
    PDType1Font actualPdType1Font = new PDType1Font(FontName.TIMES_ROMAN);

    // Assert
    assertTrue(actualPdType1Font.getEncoding() instanceof WinAnsiEncoding);
    assertEquals("Times-Roman", actualPdType1Font.getBaseFont());
    assertEquals("Times-Roman", actualPdType1Font.getName());
    assertEquals(518.0603f, actualPdType1Font.getAverageFontWidth());
    assertFalse(actualPdType1Font.getSymbolicFlag());
  }

  /**
   * Test {@link PDType1Font#PDType1Font(FontName)}.
   * <ul>
   *   <li>When {@code ZAPF_DINGBATS}.</li>
   *   <li>Then Encoding return {@link ZapfDingbatsEncoding}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#PDType1Font(FontName)}
   */
  @Test
  @DisplayName("Test new PDType1Font(FontName); when 'ZAPF_DINGBATS'; then Encoding return ZapfDingbatsEncoding")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDType1Font.<init>(FontName)"})
  void testNewPDType1Font_whenZapfDingbats_thenEncodingReturnZapfDingbatsEncoding() {
    // Arrange and Act
    PDType1Font actualPdType1Font = new PDType1Font(FontName.ZAPF_DINGBATS);

    // Assert
    assertTrue(actualPdType1Font.getEncoding() instanceof ZapfDingbatsEncoding);
    assertEquals("ZapfDingbats", actualPdType1Font.getBaseFont());
    assertEquals("ZapfDingbats", actualPdType1Font.getName());
    assertEquals(278.0f, actualPdType1Font.getSpaceWidth());
    assertEquals(746.0248f, actualPdType1Font.getAverageFontWidth());
  }

  /**
   * Test {@link PDType1Font#getBaseFont()}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code TIMES_ROMAN}.</li>
   *   <li>Then return {@code Times-Roman}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getBaseFont()}
   */
  @Test
  @DisplayName("Test getBaseFont(); given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; then return 'Times-Roman'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDType1Font.getBaseFont()"})
  void testGetBaseFont_givenPDType1FontWithBaseFontIsTimesRoman_thenReturnTimesRoman() {
    // Arrange, Act and Assert
    assertEquals("Times-Roman", (new PDType1Font(FontName.TIMES_ROMAN)).getBaseFont());
  }

  /**
   * Test {@link PDType1Font#getBaseFont()}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(COSDictionary)} with fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getBaseFont()}
   */
  @Test
  @DisplayName("Test getBaseFont(); given PDType1Font(COSDictionary) with fontDictionary is COSDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDType1Font.getBaseFont()"})
  void testGetBaseFont_givenPDType1FontWithFontDictionaryIsCOSDictionary_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType1Font(new COSDictionary())).getBaseFont());
  }

  /**
   * Test {@link PDType1Font#getHeight(int)}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code TIMES_ROMAN}.</li>
   *   <li>When one.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; when one; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDType1Font.getHeight(int)"})
  void testGetHeight_givenPDType1FontWithBaseFontIsTimesRoman_whenOne_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDType1Font(FontName.TIMES_ROMAN)).getHeight(1));
  }

  /**
   * Test {@link PDType1Font#getHeight(int)}.
   * <ul>
   *   <li>Then return one hundred eleven.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); then return one hundred eleven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDType1Font.getHeight(int)"})
  void testGetHeight_thenReturnOneHundredEleven() throws IOException {
    // Arrange, Act and Assert
    assertEquals(111.0f, (new PDType1Font(FontName.TIMES_ROMAN)).getHeight(46));
  }

  /**
   * Test {@link PDType1Font#getHeight(int)}.
   * <ul>
   *   <li>When forty-six.</li>
   *   <li>Then return two hundred forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); when forty-six; then return two hundred forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDType1Font.getHeight(int)"})
  void testGetHeight_whenFortySix_thenReturnTwoHundredFortyTwo() throws IOException {
    // Arrange, Act and Assert
    assertEquals(242.0f, (new PDType1Font(new COSDictionary())).getHeight(46));
  }

  /**
   * Test {@link PDType1Font#getHeight(int)}.
   * <ul>
   *   <li>When ninety-nine.</li>
   *   <li>Then return nine hundred eighty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); when ninety-nine; then return nine hundred eighty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDType1Font.getHeight(int)"})
  void testGetHeight_whenNinetyNine_thenReturnNineHundredEightyFive() throws IOException {
    // Arrange, Act and Assert
    assertEquals(985.0f, (new PDType1Font(new COSDictionary())).getHeight(99));
  }

  /**
   * Test {@link PDType1Font#getHeight(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code 1365.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); when one; then return '1365.0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDType1Font.getHeight(int)"})
  void testGetHeight_whenOne_thenReturn13650() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1365.0f, (new PDType1Font(new COSDictionary())).getHeight(1));
  }

  /**
   * Test {@link PDType1Font#getHeight(int)}.
   * <ul>
   *   <li>When {@link Integer#SIZE}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); when SIZE; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDType1Font.getHeight(int)"})
  void testGetHeight_whenSize_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDType1Font(new COSDictionary())).getHeight(Integer.SIZE));
  }

  /**
   * Test {@link PDType1Font#encode(int)} with {@code unicode}.
   * <ul>
   *   <li>When ninety-nine.</li>
   *   <li>Then return array of {@code byte} with {@code c}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'; when ninety-nine; then return array of byte with 'c'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDType1Font.encode(int)"})
  void testEncodeWithUnicode_whenNinetyNine_thenReturnArrayOfByteWithC() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'c'}, (new PDType1Font(new COSDictionary())).encode(99));
  }

  /**
   * Test {@link PDType1Font#encode(int)} with {@code unicode}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'; when one; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDType1Font.encode(int)"})
  void testEncodeWithUnicode_whenOne_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDType1Font(FontName.TIMES_ROMAN)).encode(1));
  }

  /**
   * Test {@link PDType1Font#encode(int)} with {@code unicode}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'; when one; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDType1Font.encode(int)"})
  void testEncodeWithUnicode_whenOne_thenThrowIllegalArgumentException2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDType1Font(new COSDictionary())).encode(1));
  }

  /**
   * Test {@link PDType1Font#encode(int)} with {@code unicode}.
   * <ul>
   *   <li>When {@link Integer#SIZE}.</li>
   *   <li>Then return array of {@code byte} with space.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'; when SIZE; then return array of byte with space")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDType1Font.encode(int)"})
  void testEncodeWithUnicode_whenSize_thenReturnArrayOfByteWithSpace() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{' '}, (new PDType1Font(FontName.TIMES_ROMAN)).encode(Integer.SIZE));
  }

  /**
   * Test {@link PDType1Font#encode(int)} with {@code unicode}.
   * <ul>
   *   <li>When {@link Integer#SIZE}.</li>
   *   <li>Then return array of {@code byte} with space.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'; when SIZE; then return array of byte with space")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDType1Font.encode(int)"})
  void testEncodeWithUnicode_whenSize_thenReturnArrayOfByteWithSpace2() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{' '}, (new PDType1Font(new COSDictionary())).encode(Integer.SIZE));
  }

  /**
   * Test {@link PDType1Font#encode(int)} with {@code unicode}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'; when zero; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDType1Font.encode(int)"})
  void testEncodeWithUnicode_whenZero_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDType1Font(FontName.TIMES_ROMAN)).encode(0));
  }

  /**
   * Test {@link PDType1Font#getWidthFromFont(int)}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code ZAPF_DINGBATS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int); given PDType1Font(FontName) with baseFont is 'ZAPF_DINGBATS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDType1Font.getWidthFromFont(int)"})
  void testGetWidthFromFont_givenPDType1FontWithBaseFontIsZapfDingbats() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250.0f, (new PDType1Font(FontName.ZAPF_DINGBATS)).getWidthFromFont(46));
  }

  /**
   * Test {@link PDType1Font#getWidthFromFont(int)}.
   * <ul>
   *   <li>When forty-six.</li>
   *   <li>Then return five hundred twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int); when forty-six; then return five hundred twelve")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDType1Font.getWidthFromFont(int)"})
  void testGetWidthFromFont_whenFortySix_thenReturnFiveHundredTwelve() throws IOException {
    // Arrange, Act and Assert
    assertEquals(512.0f, (new PDType1Font(FontName.TIMES_ROMAN)).getWidthFromFont(46));
  }

  /**
   * Test {@link PDType1Font#getWidthFromFont(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return two hundred fifty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int); when one; then return two hundred fifty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDType1Font.getWidthFromFont(int)"})
  void testGetWidthFromFont_whenOne_thenReturnTwoHundredFifty() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250.0f, (new PDType1Font(FontName.TIMES_ROMAN)).getWidthFromFont(1));
  }

  /**
   * Test {@link PDType1Font#getWidthFromFont(int)}.
   * <ul>
   *   <li>When {@link Integer#SIZE}.</li>
   *   <li>Then return five hundred twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int); when SIZE; then return five hundred twelve")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDType1Font.getWidthFromFont(int)"})
  void testGetWidthFromFont_whenSize_thenReturnFiveHundredTwelve() throws IOException {
    // Arrange, Act and Assert
    assertEquals(512.0f, (new PDType1Font(FontName.TIMES_ROMAN)).getWidthFromFont(Integer.SIZE));
  }

  /**
   * Test {@link PDType1Font#getAverageFontWidth()}.
   * <ul>
   *   <li>Then return {@code 518.0603}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getAverageFontWidth()}
   */
  @Test
  @DisplayName("Test getAverageFontWidth(); then return '518.0603'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDType1Font.getAverageFontWidth()"})
  void testGetAverageFontWidth_thenReturn5180603() {
    // Arrange, Act and Assert
    assertEquals(518.0603f, (new PDType1Font(FontName.TIMES_ROMAN)).getAverageFontWidth());
  }

  /**
   * Test {@link PDType1Font#getAverageFontWidth()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getAverageFontWidth()}
   */
  @Test
  @DisplayName("Test getAverageFontWidth(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDType1Font.getAverageFontWidth()"})
  void testGetAverageFontWidth_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDType1Font(new COSDictionary())).getAverageFontWidth());
  }

  /**
   * Test {@link PDType1Font#readCode(InputStream)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#readCode(InputStream)}
   */
  @Test
  @DisplayName("Test readCode(InputStream); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDType1Font.readCode(InputStream)"})
  void testReadCode_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnSixtyFive() throws IOException {
    // Arrange
    PDType1Font pdType1Font = new PDType1Font(FontName.TIMES_ROMAN);
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(65, pdType1Font.readCode(in));
    byte[] byteArray = new byte[7];
    assertEquals(7, in.read(byteArray));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDType1Font#readEncodingFromFont()}.
   * <p>
   * Method under test: {@link PDType1Font#readEncodingFromFont()}
   */
  @Test
  @DisplayName("Test readEncodingFromFont()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Encoding PDType1Font.readEncodingFromFont()"})
  void testReadEncodingFromFont() throws IOException {
    // Arrange
    PDType1Font pdType1Font = new PDType1Font(new COSDictionary());

    // Act
    Encoding actualReadEncodingFromFontResult = pdType1Font.readEncodingFromFont();

    // Assert
    StandardEncoding standardEncoding = ((StandardEncoding) actualReadEncodingFromFontResult).INSTANCE;
    assertSame(standardEncoding, pdType1Font.getEncoding());
    assertSame(standardEncoding, actualReadEncodingFromFontResult);
  }

  /**
   * Test {@link PDType1Font#readEncodingFromFont()}.
   * <ul>
   *   <li>Then return {@link Type1Encoding}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#readEncodingFromFont()}
   */
  @Test
  @DisplayName("Test readEncodingFromFont(); then return Type1Encoding")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Encoding PDType1Font.readEncodingFromFont()"})
  void testReadEncodingFromFont_thenReturnType1Encoding() throws IOException {
    // Arrange
    PDType1Font pdType1Font = new PDType1Font(FontName.TIMES_ROMAN);

    // Act
    Encoding actualReadEncodingFromFontResult = pdType1Font.readEncodingFromFont();

    // Assert
    assertTrue(actualReadEncodingFromFontResult instanceof Type1Encoding);
    assertTrue(pdType1Font.getEncoding() instanceof WinAnsiEncoding);
    Map<Integer, String> codeToNameMap = actualReadEncodingFromFontResult.getCodeToNameMap();
    assertEquals(150, codeToNameMap.size());
    assertEquals("Euro", codeToNameMap.get(-1));
    assertEquals("built-in (Type 1)", actualReadEncodingFromFontResult.getEncodingName());
    assertNull(actualReadEncodingFromFontResult.getCOSObject());
    Map<String, Integer> nameToCodeMap = actualReadEncodingFromFontResult.getNameToCodeMap();
    assertEquals(315, nameToCodeMap.size());
    assertEquals(-1, nameToCodeMap.get("Ncommaaccent").intValue());
    assertEquals(-1, nameToCodeMap.get("omacron").intValue());
    assertEquals(-1, nameToCodeMap.get("registered").intValue());
    assertTrue(codeToNameMap.containsKey(33));
    assertTrue(codeToNameMap.containsKey(34));
    assertTrue(codeToNameMap.containsKey(35));
    assertTrue(codeToNameMap.containsKey(36));
    assertTrue(codeToNameMap.containsKey(Integer.SIZE));
    assertTrue(nameToCodeMap.containsKey("asterisk"));
    assertTrue(nameToCodeMap.containsKey("parenright"));
    assertTrue(nameToCodeMap.containsKey("ring"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDType1Font#getFontBoxFont()}
   *   <li>{@link PDType1Font#getType1Font()}
   *   <li>{@link PDType1Font#isDamaged()}
   *   <li>{@link PDType1Font#isEmbedded()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontBoxFont PDType1Font.getFontBoxFont()", "Type1Font PDType1Font.getType1Font()",
      "boolean PDType1Font.isDamaged()", "boolean PDType1Font.isEmbedded()"})
  void testGettersAndSetters() {
    // Arrange
    PDType1Font pdType1Font = new PDType1Font(FontName.TIMES_ROMAN);

    // Act
    FontBoxFont actualFontBoxFont = pdType1Font.getFontBoxFont();
    Type1Font actualType1Font = pdType1Font.getType1Font();
    boolean actualIsDamagedResult = pdType1Font.isDamaged();

    // Assert
    assertTrue(actualFontBoxFont instanceof TrueTypeFont);
    assertNull(actualType1Font);
    assertFalse(actualIsDamagedResult);
    assertFalse(pdType1Font.isEmbedded());
  }

  /**
   * Test {@link PDType1Font#getName()}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code TIMES_ROMAN}.</li>
   *   <li>Then return {@code Times-Roman}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; then return 'Times-Roman'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDType1Font.getName()"})
  void testGetName_givenPDType1FontWithBaseFontIsTimesRoman_thenReturnTimesRoman() {
    // Arrange, Act and Assert
    assertEquals("Times-Roman", (new PDType1Font(FontName.TIMES_ROMAN)).getName());
  }

  /**
   * Test {@link PDType1Font#getName()}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(COSDictionary)} with fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDType1Font(COSDictionary) with fontDictionary is COSDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDType1Font.getName()"})
  void testGetName_givenPDType1FontWithFontDictionaryIsCOSDictionary_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType1Font(new COSDictionary())).getName());
  }

  /**
   * Test {@link PDType1Font#getBoundingBox()}.
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} FontBoundingBox is {@link PDRectangle#PDRectangle()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); given PDFontDescriptor() FontBoundingBox is PDRectangle()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BoundingBox PDType1Font.getBoundingBox()"})
  void testGetBoundingBox_givenPDFontDescriptorFontBoundingBoxIsPDRectangle() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(new PDRectangle());

    PDType1Font pdType1Font = new PDType1Font(FontName.TIMES_ROMAN);
    pdType1Font.setFontDescriptor(fontDescriptor);

    // Act
    BoundingBox actualBoundingBox = pdType1Font.getBoundingBox();

    // Assert
    assertEquals(-176.75781f, actualBoundingBox.getLowerLeftX());
    assertEquals(-303.22266f, actualBoundingBox.getLowerLeftY());
    assertEquals(1006.83594f, actualBoundingBox.getUpperRightX());
    assertEquals(1183.5938f, actualBoundingBox.getWidth());
    assertEquals(1284.668f, actualBoundingBox.getHeight());
    assertEquals(981.4453f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Test {@link PDType1Font#getBoundingBox()}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(COSDictionary)} with fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); given PDType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BoundingBox PDType1Font.getBoundingBox()"})
  void testGetBoundingBox_givenPDType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    BoundingBox actualBoundingBox = (new PDType1Font(new COSDictionary())).getBoundingBox();

    // Assert
    assertEquals(-176.75781f, actualBoundingBox.getLowerLeftX());
    assertEquals(-303.22266f, actualBoundingBox.getLowerLeftY());
    assertEquals(1006.83594f, actualBoundingBox.getUpperRightX());
    assertEquals(1183.5938f, actualBoundingBox.getWidth());
    assertEquals(1284.668f, actualBoundingBox.getHeight());
    assertEquals(981.4453f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Test {@link PDType1Font#getBoundingBox()}.
   * <ul>
   *   <li>Then return LowerLeftX is {@code -176.75781}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return LowerLeftX is '-176.75781'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BoundingBox PDType1Font.getBoundingBox()"})
  void testGetBoundingBox_thenReturnLowerLeftXIs17675781() throws IOException {
    // Arrange
    PDType1Font pdType1Font = new PDType1Font(FontName.TIMES_ROMAN);
    pdType1Font.setFontDescriptor(new PDFontDescriptor());

    // Act
    BoundingBox actualBoundingBox = pdType1Font.getBoundingBox();

    // Assert
    assertEquals(-176.75781f, actualBoundingBox.getLowerLeftX());
    assertEquals(-303.22266f, actualBoundingBox.getLowerLeftY());
    assertEquals(1006.83594f, actualBoundingBox.getUpperRightX());
    assertEquals(1183.5938f, actualBoundingBox.getWidth());
    assertEquals(1284.668f, actualBoundingBox.getHeight());
    assertEquals(981.4453f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Test {@link PDType1Font#getBoundingBox()}.
   * <ul>
   *   <li>Then return LowerLeftX is {@code 2.14748365E9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return LowerLeftX is '2.14748365E9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BoundingBox PDType1Font.getBoundingBox()"})
  void testGetBoundingBox_thenReturnLowerLeftXIs214748365e9() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    PDType1Font pdType1Font = new PDType1Font(FontName.TIMES_ROMAN);
    pdType1Font.setFontDescriptor(fontDescriptor);

    // Act
    BoundingBox actualBoundingBox = pdType1Font.getBoundingBox();

    // Assert
    assertEquals(0.0f, actualBoundingBox.getHeight());
    assertEquals(0.0f, actualBoundingBox.getWidth());
    assertEquals(2.14748365E9f, actualBoundingBox.getLowerLeftX());
    assertEquals(2.14748365E9f, actualBoundingBox.getLowerLeftY());
    assertEquals(2.14748365E9f, actualBoundingBox.getUpperRightX());
  }

  /**
   * Test {@link PDType1Font#getBoundingBox()}.
   * <ul>
   *   <li>Then return LowerLeftX is minus one hundred sixty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return LowerLeftX is minus one hundred sixty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BoundingBox PDType1Font.getBoundingBox()"})
  void testGetBoundingBox_thenReturnLowerLeftXIsMinusOneHundredSixtyEight() throws IOException {
    // Arrange and Act
    BoundingBox actualBoundingBox = (new PDType1Font(FontName.TIMES_ROMAN)).getBoundingBox();

    // Assert
    assertEquals(-168.0f, actualBoundingBox.getLowerLeftX());
    assertEquals(-218.0f, actualBoundingBox.getLowerLeftY());
    assertEquals(1000.0f, actualBoundingBox.getUpperRightX());
    assertEquals(1116.0f, actualBoundingBox.getHeight());
    assertEquals(1168.0f, actualBoundingBox.getWidth());
    assertEquals(898.0f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Test {@link PDType1Font#getBoundingBox()}.
   * <ul>
   *   <li>Then return LowerLeftY is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return LowerLeftY is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BoundingBox PDType1Font.getBoundingBox()"})
  void testGetBoundingBox_thenReturnLowerLeftYIsZero() throws IOException {
    // Arrange
    PDRectangle rect = new PDRectangle();
    rect.setLowerLeftY(2.14748365E9f);

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(rect);

    PDType1Font pdType1Font = new PDType1Font(FontName.TIMES_ROMAN);
    pdType1Font.setFontDescriptor(fontDescriptor);

    // Act
    BoundingBox actualBoundingBox = pdType1Font.getBoundingBox();

    // Assert
    assertEquals(0.0f, actualBoundingBox.getLowerLeftY());
    assertEquals(0.0f, actualBoundingBox.getUpperRightX());
    assertEquals(0.0f, actualBoundingBox.getWidth());
    assertEquals(2.14748365E9f, actualBoundingBox.getHeight());
  }

  /**
   * Test {@link PDType1Font#getBoundingBox()}.
   * <ul>
   *   <li>Then return UpperRightX is {@code 2383.937}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return UpperRightX is '2383.937'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BoundingBox PDType1Font.getBoundingBox()"})
  void testGetBoundingBox_thenReturnUpperRightXIs2383937() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(PDRectangle.A0);

    PDType1Font pdType1Font = new PDType1Font(FontName.TIMES_ROMAN);
    pdType1Font.setFontDescriptor(fontDescriptor);

    // Act
    BoundingBox actualBoundingBox = pdType1Font.getBoundingBox();

    // Assert
    assertEquals(2383.937f, actualBoundingBox.getUpperRightX());
    assertEquals(2383.937f, actualBoundingBox.getWidth());
    assertEquals(3370.3938f, actualBoundingBox.getHeight());
    assertEquals(3370.3938f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Test {@link PDType1Font#getBoundingBox()}.
   * <ul>
   *   <li>Then return Width is {@code 2.14748365E9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return Width is '2.14748365E9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BoundingBox PDType1Font.getBoundingBox()"})
  void testGetBoundingBox_thenReturnWidthIs214748365e9() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(new PDRectangle(0.0f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    PDType1Font pdType1Font = new PDType1Font(FontName.TIMES_ROMAN);
    pdType1Font.setFontDescriptor(fontDescriptor);

    // Act
    BoundingBox actualBoundingBox = pdType1Font.getBoundingBox();

    // Assert
    assertEquals(0.0f, actualBoundingBox.getHeight());
    assertEquals(2.14748365E9f, actualBoundingBox.getLowerLeftY());
    assertEquals(2.14748365E9f, actualBoundingBox.getUpperRightX());
    assertEquals(2.14748365E9f, actualBoundingBox.getWidth());
  }

  /**
   * Test {@link PDType1Font#codeToName(int)}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code TIMES_ROMAN}.</li>
   *   <li>When one.</li>
   *   <li>Then return {@code .notdef}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#codeToName(int)}
   */
  @Test
  @DisplayName("Test codeToName(int); given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; when one; then return '.notdef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDType1Font.codeToName(int)"})
  void testCodeToName_givenPDType1FontWithBaseFontIsTimesRoman_whenOne_thenReturnNotdef() throws IOException {
    // Arrange, Act and Assert
    assertEquals(".notdef", (new PDType1Font(FontName.TIMES_ROMAN)).codeToName(1));
  }

  /**
   * Test {@link PDType1Font#codeToName(int)}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code ZAPF_DINGBATS}.</li>
   *   <li>Then return {@code .notdef}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#codeToName(int)}
   */
  @Test
  @DisplayName("Test codeToName(int); given PDType1Font(FontName) with baseFont is 'ZAPF_DINGBATS'; then return '.notdef'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDType1Font.codeToName(int)"})
  void testCodeToName_givenPDType1FontWithBaseFontIsZapfDingbats_thenReturnNotdef() throws IOException {
    // Arrange, Act and Assert
    assertEquals(".notdef", (new PDType1Font(FontName.ZAPF_DINGBATS)).codeToName(46));
  }

  /**
   * Test {@link PDType1Font#codeToName(int)}.
   * <ul>
   *   <li>When forty-six.</li>
   *   <li>Then return {@code period}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#codeToName(int)}
   */
  @Test
  @DisplayName("Test codeToName(int); when forty-six; then return 'period'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDType1Font.codeToName(int)"})
  void testCodeToName_whenFortySix_thenReturnPeriod() throws IOException {
    // Arrange, Act and Assert
    assertEquals("period", (new PDType1Font(FontName.TIMES_ROMAN)).codeToName(46));
  }

  /**
   * Test {@link PDType1Font#codeToName(int)}.
   * <ul>
   *   <li>When {@link Integer#SIZE}.</li>
   *   <li>Then return {@code uni0020}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#codeToName(int)}
   */
  @Test
  @DisplayName("Test codeToName(int); when SIZE; then return 'uni0020'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDType1Font.codeToName(int)"})
  void testCodeToName_whenSize_thenReturnUni0020() throws IOException {
    // Arrange, Act and Assert
    assertEquals("uni0020", (new PDType1Font(FontName.TIMES_ROMAN)).codeToName(Integer.SIZE));
  }

  /**
   * Test {@link PDType1Font#getPath(int)} with {@code code}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code ZAPF_DINGBATS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; given PDType1Font(FontName) with baseFont is 'ZAPF_DINGBATS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDType1Font.getPath(int)"})
  void testGetPathWithCode_givenPDType1FontWithBaseFontIsZapfDingbats() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(FontName.ZAPF_DINGBATS)).getPath(99);

    // Assert
    assertTrue(actualPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualPath.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link PDType1Font#getPath(int)} with {@code code}.
   * <ul>
   *   <li>When ninety-nine.</li>
   *   <li>Then CurrentPoint return {@link Point2D.Float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; when ninety-nine; then CurrentPoint return Float")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDType1Font.getPath(int)"})
  void testGetPathWithCode_whenNinetyNine_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(FontName.TIMES_ROMAN)).getPath(99);

    // Assert
    assertTrue(actualPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualPath.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link PDType1Font#getPath(int)} with {@code code}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; when one; then Bounds Bounds2D return Rectangle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDType1Font.getPath(int)"})
  void testGetPathWithCode_whenOne_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(FontName.TIMES_ROMAN)).getPath(1);

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(int)} with {@code code}.
   * <ul>
   *   <li>When {@link Integer#SIZE}.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; when SIZE; then Bounds Bounds2D return Rectangle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDType1Font.getPath(int)"})
  void testGetPathWithCode_whenSize_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(FontName.TIMES_ROMAN)).getPath(Integer.SIZE);

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code TIMES_BOLD}.</li>
   *   <li>When {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; given PDType1Font(FontName) with baseFont is 'TIMES_BOLD'; when 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDType1Font.getPath(String)"})
  void testGetPathWithName_givenPDType1FontWithBaseFontIsTimesBold_whenName() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(FontName.TIMES_BOLD)).getPath("Name");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   * <ul>
   *   <li>When {@code g9}.</li>
   *   <li>Then CurrentPoint return {@link Point2D.Float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when 'g9'; then CurrentPoint return Float")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDType1Font.getPath(String)"})
  void testGetPathWithName_whenG9_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(FontName.TIMES_ROMAN)).getPath("g9");

    // Assert
    assertTrue(actualPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualPath.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   * <ul>
   *   <li>When {@code Integer}.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when 'java.lang.Integer'; then Bounds Bounds2D return Rectangle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDType1Font.getPath(String)"})
  void testGetPathWithName_whenJavaLangInteger_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(FontName.TIMES_ROMAN)).getPath("java.lang.Integer");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when 'Name'; then Bounds Bounds2D return Rectangle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDType1Font.getPath(String)"})
  void testGetPathWithName_whenName_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(FontName.TIMES_ROMAN)).getPath("Name");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   * <ul>
   *   <li>When {@code .notdef}.</li>
   *   <li>Then return CurrentPoint is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when '.notdef'; then return CurrentPoint is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDType1Font.getPath(String)"})
  void testGetPathWithName_whenNotdef_thenReturnCurrentPointIsNull() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(FontName.TIMES_ROMAN)).getPath(".notdef");

    // Assert
    assertTrue(actualPath.getBounds2D() instanceof Float);
    assertNull(actualPath.getCurrentPoint());
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   * <ul>
   *   <li>When {@code uni}.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when 'uni'; then Bounds Bounds2D return Rectangle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDType1Font.getPath(String)"})
  void testGetPathWithName_whenUni_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(FontName.TIMES_ROMAN)).getPath("uni");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getNormalizedPath(int)}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code TIMES_BOLD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); given PDType1Font(FontName) with baseFont is 'TIMES_BOLD'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDType1Font.getNormalizedPath(int)"})
  void testGetNormalizedPath_givenPDType1FontWithBaseFontIsTimesBold() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDType1Font(FontName.TIMES_BOLD)).getNormalizedPath(99);

    // Assert
    assertTrue(actualNormalizedPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualNormalizedPath.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link PDType1Font#getNormalizedPath(int)}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code TIMES_BOLD}.</li>
   *   <li>When {@link Integer#SIZE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); given PDType1Font(FontName) with baseFont is 'TIMES_BOLD'; when SIZE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDType1Font.getNormalizedPath(int)"})
  void testGetNormalizedPath_givenPDType1FontWithBaseFontIsTimesBold_whenSize() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDType1Font(FontName.TIMES_BOLD)).getNormalizedPath(Integer.SIZE);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getNormalizedPath(int)}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code ZAPF_DINGBATS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); given PDType1Font(FontName) with baseFont is 'ZAPF_DINGBATS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDType1Font.getNormalizedPath(int)"})
  void testGetNormalizedPath_givenPDType1FontWithBaseFontIsZapfDingbats() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDType1Font(FontName.ZAPF_DINGBATS)).getNormalizedPath(99);

    // Assert
    assertTrue(actualNormalizedPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualNormalizedPath.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link PDType1Font#getNormalizedPath(int)}.
   * <ul>
   *   <li>Then CurrentPoint return {@link Point2D.Float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); then CurrentPoint return Float")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDType1Font.getNormalizedPath(int)"})
  void testGetNormalizedPath_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDType1Font(FontName.TIMES_ROMAN)).getNormalizedPath(99);

    // Assert
    assertTrue(actualNormalizedPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualNormalizedPath.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link PDType1Font#getNormalizedPath(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); when one; then Bounds Bounds2D return Rectangle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDType1Font.getNormalizedPath(int)"})
  void testGetNormalizedPath_whenOne_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDType1Font(FontName.TIMES_ROMAN)).getNormalizedPath(1);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getNormalizedPath(int)}.
   * <ul>
   *   <li>When {@link Integer#SIZE}.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); when SIZE; then Bounds Bounds2D return Rectangle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDType1Font.getNormalizedPath(int)"})
  void testGetNormalizedPath_whenSize_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDType1Font(FontName.TIMES_ROMAN)).getNormalizedPath(Integer.SIZE);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#hasGlyph(int)} with {@code code}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#hasGlyph(int)}
   */
  @Test
  @DisplayName("Test hasGlyph(int) with 'code'; when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDType1Font.hasGlyph(int)"})
  void testHasGlyphWithCode_whenOne_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDType1Font(FontName.TIMES_ROMAN)).hasGlyph(1));
  }

  /**
   * Test {@link PDType1Font#hasGlyph(int)} with {@code code}.
   * <ul>
   *   <li>When {@link Integer#SIZE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#hasGlyph(int)}
   */
  @Test
  @DisplayName("Test hasGlyph(int) with 'code'; when SIZE; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDType1Font.hasGlyph(int)"})
  void testHasGlyphWithCode_whenSize_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDType1Font(FontName.TIMES_ROMAN)).hasGlyph(Integer.SIZE));
  }

  /**
   * Test {@link PDType1Font#hasGlyph(String)} with {@code name}.
   * <ul>
   *   <li>When {@code g9}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'g9'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDType1Font.hasGlyph(String)"})
  void testHasGlyphWithName_whenG9_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDType1Font(FontName.TIMES_ROMAN)).hasGlyph("g9"));
  }

  /**
   * Test {@link PDType1Font#hasGlyph(String)} with {@code name}.
   * <ul>
   *   <li>When {@code g942}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'g942'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDType1Font.hasGlyph(String)"})
  void testHasGlyphWithName_whenG942_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDType1Font(FontName.TIMES_ROMAN)).hasGlyph("g942"));
  }

  /**
   * Test {@link PDType1Font#hasGlyph(String)} with {@code name}.
   * <ul>
   *   <li>When {@code Integer}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'java.lang.Integer'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDType1Font.hasGlyph(String)"})
  void testHasGlyphWithName_whenJavaLangInteger_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDType1Font(FontName.TIMES_ROMAN)).hasGlyph("java.lang.Integer"));
  }

  /**
   * Test {@link PDType1Font#hasGlyph(String)} with {@code name}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'Name'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDType1Font.hasGlyph(String)"})
  void testHasGlyphWithName_whenName_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDType1Font(FontName.TIMES_ROMAN)).hasGlyph("Name"));
  }

  /**
   * Test {@link PDType1Font#hasGlyph(String)} with {@code name}.
   * <ul>
   *   <li>When {@code uni}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'uni'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDType1Font.hasGlyph(String)"})
  void testHasGlyphWithName_whenUni_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDType1Font(FontName.TIMES_ROMAN)).hasGlyph("uni"));
  }

  /**
   * Test {@link PDType1Font#getFontMatrix()}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code TIMES_ROMAN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix(); given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Matrix PDType1Font.getFontMatrix()"})
  void testGetFontMatrix_givenPDType1FontWithBaseFontIsTimesRoman() {
    // Arrange and Act
    Matrix actualFontMatrix = (new PDType1Font(FontName.TIMES_ROMAN)).getFontMatrix();

    // Assert
    assertEquals(0.0f, actualFontMatrix.getShearX());
    assertEquals(0.0f, actualFontMatrix.getShearY());
    assertEquals(0.0f, actualFontMatrix.getTranslateX());
    assertEquals(0.0f, actualFontMatrix.getTranslateY());
    float[][] values = actualFontMatrix.getValues();
    assertEquals(3, values.length);
    assertEquals(4.8828125E-4f, actualFontMatrix.getScaleX());
    assertEquals(4.8828125E-4f, actualFontMatrix.getScaleY());
    assertEquals(4.8828125E-4f, actualFontMatrix.getScalingFactorX());
    assertEquals(4.8828125E-4f, actualFontMatrix.getScalingFactorY());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 4.8828125E-4f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{4.8828125E-4f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDType1Font#getFontMatrix()}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(COSDictionary)} with fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix(); given PDType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Matrix PDType1Font.getFontMatrix()"})
  void testGetFontMatrix_givenPDType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    Matrix actualFontMatrix = (new PDType1Font(new COSDictionary())).getFontMatrix();

    // Assert
    assertEquals(0.0f, actualFontMatrix.getShearX());
    assertEquals(0.0f, actualFontMatrix.getShearY());
    assertEquals(0.0f, actualFontMatrix.getTranslateX());
    assertEquals(0.0f, actualFontMatrix.getTranslateY());
    float[][] values = actualFontMatrix.getValues();
    assertEquals(3, values.length);
    assertEquals(4.8828125E-4f, actualFontMatrix.getScaleX());
    assertEquals(4.8828125E-4f, actualFontMatrix.getScaleY());
    assertEquals(4.8828125E-4f, actualFontMatrix.getScalingFactorX());
    assertEquals(4.8828125E-4f, actualFontMatrix.getScalingFactorY());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 4.8828125E-4f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{4.8828125E-4f, 0.0f, 0.0f}, values[0], 0.0f);
  }
}
