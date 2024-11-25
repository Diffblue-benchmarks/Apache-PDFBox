package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.ttf.TTFTable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.type1.Type1Font;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.StandardEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.Type1Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDType1FontDiffblueTest {
  /**
   * Test {@link PDType1Font#PDType1Font(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#PDType1Font(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDType1Font(COSDictionary); when COSDictionary(); then return COSObject is COSDictionary()")
  void testNewPDType1Font_whenCOSDictionary_thenReturnCOSObjectIsCOSDictionary() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    // Act
    PDType1Font actualPdType1Font = new PDType1Font(fontDictionary);

    // Assert
    FontBoxFont fontBoxFont = actualPdType1Font.getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) fontBoxFont).getTableMap();
    assertEquals(25, tableMap.size());
    assertEquals(3, ((TrueTypeFont) fontBoxFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("DSIG"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("gasp"));
    assertSame(fontDictionary, actualPdType1Font.getCOSObject());
  }

  /**
   * Test {@link PDType1Font#PDType1Font(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#PDType1Font(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDType1Font(COSDictionary); when COSStream(); then return COSObject is COSStream()")
  void testNewPDType1Font_whenCOSStream_thenReturnCOSObjectIsCOSStream() throws IOException {
    // Arrange
    COSStream fontDictionary = new COSStream();

    // Act
    PDType1Font actualPdType1Font = new PDType1Font(fontDictionary);

    // Assert
    FontBoxFont fontBoxFont = actualPdType1Font.getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) fontBoxFont).getTableMap();
    assertEquals(25, tableMap.size());
    assertEquals(3, ((TrueTypeFont) fontBoxFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("DSIG"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("gasp"));
    assertSame(fontDictionary, actualPdType1Font.getCOSObject());
  }

  /**
   * Test {@link PDType1Font#getBaseFont()}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code TIMES_ROMAN}.</li>
   *   <li>Then return {@code Times-Roman}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getBaseFont()}
   */
  @Test
  @DisplayName("Test getBaseFont(); given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; then return 'Times-Roman'")
  void testGetBaseFont_givenPDType1FontWithBaseFontIsTimesRoman_thenReturnTimesRoman() {
    // Arrange, Act and Assert
    assertEquals("Times-Roman", (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).getBaseFont());
  }

  /**
   * Test {@link PDType1Font#getBaseFont()}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(COSDictionary)} with fontDictionary
   * is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getBaseFont()}
   */
  @Test
  @DisplayName("Test getBaseFont(); given PDType1Font(COSDictionary) with fontDictionary is COSDictionary(); then return 'null'")
  void testGetBaseFont_givenPDType1FontWithFontDictionaryIsCOSDictionary_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType1Font(new COSDictionary())).getBaseFont());
  }

  /**
   * Test {@link PDType1Font#getHeight(int)}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code TIMES_ROMAN}.</li>
   *   <li>When one.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; when one; then return zero")
  void testGetHeight_givenPDType1FontWithBaseFontIsTimesRoman_whenOne_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).getHeight(1));
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
  void testGetHeight_thenReturnOneHundredEleven() throws IOException {
    // Arrange, Act and Assert
    assertEquals(111.0f, (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).getHeight(46));
  }

  /**
   * Test {@link PDType1Font#getHeight(int)}.
   * <ul>
   *   <li>When forty-six.</li>
   *   <li>Then return two hundred twenty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); when forty-six; then return two hundred twenty-two")
  void testGetHeight_whenFortySix_thenReturnTwoHundredTwentyTwo() throws IOException {
    // Arrange, Act and Assert
    assertEquals(222.0f, (new PDType1Font(new COSDictionary())).getHeight(46));
  }

  /**
   * Test {@link PDType1Font#getHeight(int)}.
   * <ul>
   *   <li>When ninety-nine.</li>
   *   <li>Then return nine hundred seventy-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); when ninety-nine; then return nine hundred seventy-one")
  void testGetHeight_whenNinetyNine_thenReturnNineHundredSeventyOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(971.0f, (new PDType1Font(new COSDictionary())).getHeight(99));
  }

  /**
   * Test {@link PDType1Font#getHeight(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code 1280.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); when one; then return '1280.0'")
  void testGetHeight_whenOne_thenReturn12800() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1280.0f, (new PDType1Font(new COSDictionary())).getHeight(1));
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
  void testGetHeight_whenSize_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDType1Font(new COSDictionary())).getHeight(Integer.SIZE));
  }

  /**
   * Test {@link PDType1Font#encode(int)} with {@code unicode}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(COSDictionary)} with fontDictionary
   * is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'; given PDType1Font(COSDictionary) with fontDictionary is COSDictionary(); when one")
  void testEncodeWithUnicode_givenPDType1FontWithFontDictionaryIsCOSDictionary_whenOne() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDType1Font(new COSDictionary())).encode(1));
  }

  /**
   * Test {@link PDType1Font#encode(int)} with {@code unicode}.
   * <ul>
   *   <li>Then return array of {@code byte} with space.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'; then return array of byte with space")
  void testEncodeWithUnicode_thenReturnArrayOfByteWithSpace() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{' '}, (new PDType1Font(new COSDictionary())).encode(Integer.SIZE));
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
  void testEncodeWithUnicode_whenOne_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).encode(1));
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
  void testEncodeWithUnicode_whenSize_thenReturnArrayOfByteWithSpace() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{' '}, (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).encode(Integer.SIZE));
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
  void testEncodeWithUnicode_whenZero_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).encode(0));
  }

  /**
   * Test {@link PDType1Font#getWidthFromFont(int)}.
   * <ul>
   *   <li>Then return five hundred twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int); then return five hundred twelve")
  void testGetWidthFromFont_thenReturnFiveHundredTwelve() throws IOException {
    // Arrange, Act and Assert
    assertEquals(512.0f, (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).getWidthFromFont(46));
    assertEquals(512.0f, (new PDType1Font(Standard14Fonts.FontName.SYMBOL)).getWidthFromFont(46));
  }

  /**
   * Test {@link PDType1Font#getWidthFromFont(int)}.
   * <ul>
   *   <li>Then return two hundred fifty-six.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int); then return two hundred fifty-six")
  void testGetWidthFromFont_thenReturnTwoHundredFiftySix() throws IOException {
    // Arrange, Act and Assert
    assertEquals(256.0f, (new PDType1Font(Standard14Fonts.FontName.ZAPF_DINGBATS)).getWidthFromFont(46));
  }

  /**
   * Test {@link PDType1Font#getWidthFromFont(int)}.
   * <ul>
   *   <li>When ninety-nine.</li>
   *   <li>Then return {@code 1124.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int); when ninety-nine; then return '1124.0'")
  void testGetWidthFromFont_whenNinetyNine_thenReturn11240() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1124.0f, (new PDType1Font(Standard14Fonts.FontName.SYMBOL)).getWidthFromFont(99));
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
  void testGetWidthFromFont_whenOne_thenReturnTwoHundredFifty() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250.0f, (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).getWidthFromFont(1));
  }

  /**
   * Test {@link PDType1Font#getAverageFontWidth()}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(COSDictionary)} with fontDictionary
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getAverageFontWidth()}
   */
  @Test
  @DisplayName("Test getAverageFontWidth(); given PDType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetAverageFontWidth_givenPDType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDType1Font(new COSDictionary())).getAverageFontWidth());
  }

  /**
   * Test {@link PDType1Font#getAverageFontWidth()}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(COSDictionary)} with fontDictionary
   * is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getAverageFontWidth()}
   */
  @Test
  @DisplayName("Test getAverageFontWidth(); given PDType1Font(COSDictionary) with fontDictionary is COSStream()")
  void testGetAverageFontWidth_givenPDType1FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDType1Font(new COSStream())).getAverageFontWidth());
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
  void testGetAverageFontWidth_thenReturn5180603() {
    // Arrange, Act and Assert
    assertEquals(518.0603f, (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).getAverageFontWidth());
  }

  /**
   * Test {@link PDType1Font#readCode(InputStream)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#readCode(InputStream)}
   */
  @Test
  @DisplayName("Test readCode(InputStream); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  void testReadCode_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnSixtyFive() throws IOException {
    // Arrange
    PDType1Font pdType1Font = new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN);
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
  void testReadEncodingFromFont_thenReturnType1Encoding() throws IOException {
    // Arrange
    PDType1Font pdType1Font = new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN);

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
  void testGettersAndSetters() {
    // Arrange
    PDType1Font pdType1Font = new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN);

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
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code TIMES_ROMAN}.</li>
   *   <li>Then return {@code Times-Roman}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; then return 'Times-Roman'")
  void testGetName_givenPDType1FontWithBaseFontIsTimesRoman_thenReturnTimesRoman() {
    // Arrange, Act and Assert
    assertEquals("Times-Roman", (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).getName());
  }

  /**
   * Test {@link PDType1Font#getName()}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(COSDictionary)} with fontDictionary
   * is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDType1Font(COSDictionary) with fontDictionary is COSDictionary(); then return 'null'")
  void testGetName_givenPDType1FontWithFontDictionaryIsCOSDictionary_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType1Font(new COSDictionary())).getName());
  }

  /**
   * Test {@link PDType1Font#getBoundingBox()}.
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} FontBoundingBox is
   * {@link PDRectangle#PDRectangle()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); given PDFontDescriptor() FontBoundingBox is PDRectangle()")
  void testGetBoundingBox_givenPDFontDescriptorFontBoundingBoxIsPDRectangle() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(new PDRectangle());

    PDType1Font pdType1Font = new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN);
    pdType1Font.setFontDescriptor(fontDescriptor);

    // Act
    BoundingBox actualBoundingBox = pdType1Font.getBoundingBox();

    // Assert
    assertEquals(-306.64062f, actualBoundingBox.getLowerLeftY());
    assertEquals(-568.3594f, actualBoundingBox.getLowerLeftX());
    assertEquals(1039.5508f, actualBoundingBox.getUpperRightY());
    assertEquals(1346.1914f, actualBoundingBox.getHeight());
    assertEquals(2045.8984f, actualBoundingBox.getUpperRightX());
    assertEquals(2614.2578f, actualBoundingBox.getWidth());
  }

  /**
   * Test {@link PDType1Font#getBoundingBox()}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(COSDictionary)} with fontDictionary
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); given PDType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetBoundingBox_givenPDType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    BoundingBox actualBoundingBox = (new PDType1Font(new COSDictionary())).getBoundingBox();

    // Assert
    assertEquals(-306.64062f, actualBoundingBox.getLowerLeftY());
    assertEquals(-568.3594f, actualBoundingBox.getLowerLeftX());
    assertEquals(1039.5508f, actualBoundingBox.getUpperRightY());
    assertEquals(1346.1914f, actualBoundingBox.getHeight());
    assertEquals(2045.8984f, actualBoundingBox.getUpperRightX());
    assertEquals(2614.2578f, actualBoundingBox.getWidth());
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
  void testGetBoundingBox_thenReturnLowerLeftXIs214748365e9() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    PDType1Font pdType1Font = new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN);
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
  void testGetBoundingBox_thenReturnLowerLeftXIsMinusOneHundredSixtyEight() throws IOException {
    // Arrange and Act
    BoundingBox actualBoundingBox = (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).getBoundingBox();

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
   *   <li>Then return LowerLeftY is {@code -306.64062}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return LowerLeftY is '-306.64062'")
  void testGetBoundingBox_thenReturnLowerLeftYIs30664062() throws IOException {
    // Arrange
    PDType1Font pdType1Font = new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN);
    pdType1Font.setFontDescriptor(new PDFontDescriptor());

    // Act
    BoundingBox actualBoundingBox = pdType1Font.getBoundingBox();

    // Assert
    assertEquals(-306.64062f, actualBoundingBox.getLowerLeftY());
    assertEquals(-568.3594f, actualBoundingBox.getLowerLeftX());
    assertEquals(1039.5508f, actualBoundingBox.getUpperRightY());
    assertEquals(1346.1914f, actualBoundingBox.getHeight());
    assertEquals(2045.8984f, actualBoundingBox.getUpperRightX());
    assertEquals(2614.2578f, actualBoundingBox.getWidth());
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
  void testGetBoundingBox_thenReturnLowerLeftYIsZero() throws IOException {
    // Arrange
    PDRectangle rect = new PDRectangle();
    rect.setLowerLeftY(2.14748365E9f);

    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(rect);

    PDType1Font pdType1Font = new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN);
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
  void testGetBoundingBox_thenReturnUpperRightXIs2383937() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(PDRectangle.A0);

    PDType1Font pdType1Font = new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN);
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
  void testGetBoundingBox_thenReturnWidthIs214748365e9() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(new PDRectangle(0.0f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    PDType1Font pdType1Font = new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN);
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
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code SYMBOL}.</li>
   *   <li>Then return {@code uniF02E}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#codeToName(int)}
   */
  @Test
  @DisplayName("Test codeToName(int); given PDType1Font(FontName) with baseFont is 'SYMBOL'; then return 'uniF02E'")
  void testCodeToName_givenPDType1FontWithBaseFontIsSymbol_thenReturnUniF02E() throws IOException {
    // Arrange, Act and Assert
    assertEquals("uniF02E", (new PDType1Font(Standard14Fonts.FontName.SYMBOL)).codeToName(46));
  }

  /**
   * Test {@link PDType1Font#codeToName(int)}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code TIMES_ROMAN}.</li>
   *   <li>Then return {@code uni002E}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#codeToName(int)}
   */
  @Test
  @DisplayName("Test codeToName(int); given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; then return 'uni002E'")
  void testCodeToName_givenPDType1FontWithBaseFontIsTimesRoman_thenReturnUni002E() throws IOException {
    // Arrange, Act and Assert
    assertEquals("uni002E", (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).codeToName(46));
  }

  /**
   * Test {@link PDType1Font#codeToName(int)}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code TIMES_ROMAN}.</li>
   *   <li>When one.</li>
   *   <li>Then return {@code .notdef}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#codeToName(int)}
   */
  @Test
  @DisplayName("Test codeToName(int); given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; when one; then return '.notdef'")
  void testCodeToName_givenPDType1FontWithBaseFontIsTimesRoman_whenOne_thenReturnNotdef() throws IOException {
    // Arrange, Act and Assert
    assertEquals(".notdef", (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).codeToName(1));
  }

  /**
   * Test {@link PDType1Font#codeToName(int)}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code ZAPF_DINGBATS}.</li>
   *   <li>Then return {@code uni270E}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#codeToName(int)}
   */
  @Test
  @DisplayName("Test codeToName(int); given PDType1Font(FontName) with baseFont is 'ZAPF_DINGBATS'; then return 'uni270E'")
  void testCodeToName_givenPDType1FontWithBaseFontIsZapfDingbats_thenReturnUni270E() throws IOException {
    // Arrange, Act and Assert
    assertEquals("uni270E", (new PDType1Font(Standard14Fonts.FontName.ZAPF_DINGBATS)).codeToName(46));
  }

  /**
   * Test {@link PDType1Font#codeToName(int)}.
   * <ul>
   *   <li>When ninety-nine.</li>
   *   <li>Then return {@code uniF063}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#codeToName(int)}
   */
  @Test
  @DisplayName("Test codeToName(int); when ninety-nine; then return 'uniF063'")
  void testCodeToName_whenNinetyNine_thenReturnUniF063() throws IOException {
    // Arrange, Act and Assert
    assertEquals("uniF063", (new PDType1Font(Standard14Fonts.FontName.SYMBOL)).codeToName(99));
  }

  /**
   * Test {@link PDType1Font#getPath(int)} with {@code code}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code SYMBOL}.</li>
   *   <li>When {@link Integer#SIZE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; given PDType1Font(FontName) with baseFont is 'SYMBOL'; when SIZE")
  void testGetPathWithCode_givenPDType1FontWithBaseFontIsSymbol_whenSize() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(Standard14Fonts.FontName.SYMBOL)).getPath(Integer.SIZE);

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(int)} with {@code code}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code TIMES_ROMAN}.</li>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; when one")
  void testGetPathWithCode_givenPDType1FontWithBaseFontIsTimesRoman_whenOne() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).getPath(1);

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(int)} with {@code code}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code TIMES_ROMAN}.</li>
   *   <li>When {@link Integer#SIZE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; when SIZE")
  void testGetPathWithCode_givenPDType1FontWithBaseFontIsTimesRoman_whenSize() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).getPath(Integer.SIZE);

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(int)} with {@code code}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code ZAPF_DINGBATS}.</li>
   *   <li>When {@link Integer#SIZE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; given PDType1Font(FontName) with baseFont is 'ZAPF_DINGBATS'; when SIZE")
  void testGetPathWithCode_givenPDType1FontWithBaseFontIsZapfDingbats_whenSize() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(Standard14Fonts.FontName.ZAPF_DINGBATS)).getPath(Integer.SIZE);

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(int)} with {@code code}.
   * <ul>
   *   <li>Then return Bounds Location {@link Point#y} is minus four hundred
   * forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; then return Bounds Location y is minus four hundred forty-two")
  void testGetPathWithCode_thenReturnBoundsLocationYIsMinusFourHundredFortyTwo() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(Standard14Fonts.FontName.SYMBOL)).getPath(99);

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(-442, location.y);
    assertEquals(-442, bounds.y);
    assertEquals(-442.0d, location.getY());
    assertEquals(-442.0d, bounds.getY());
    assertEquals(-442.0d, bounds.getMinY());
    assertEquals(1049.0d, bounds.getMaxX());
    Dimension size = bounds.getSize();
    assertEquals(1375, size.height);
    assertEquals(1375, bounds.height);
    assertEquals(1375.0d, size.getHeight());
    assertEquals(1375.0d, bounds.getHeight());
    assertEquals(245.5d, bounds.getCenterY());
    assertEquals(559.5d, bounds.getCenterX());
    assertEquals(70, location.x);
    assertEquals(70, bounds.x);
    assertEquals(70.0d, location.getX());
    assertEquals(70.0d, bounds.getX());
    assertEquals(70.0d, bounds.getMinX());
    assertEquals(916.0d, currentPoint.getY());
    assertEquals(916.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(933.0d, bounds.getMaxY());
    assertEquals(966.0d, currentPoint.getX());
    assertEquals(966.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(979, size.width);
    assertEquals(979, bounds.width);
    assertEquals(979.0d, size.getWidth());
    assertEquals(979.0d, bounds.getWidth());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(int)} with {@code code}.
   * <ul>
   *   <li>Then return Bounds Location {@link Point#y} is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; then return Bounds Location y is minus one")
  void testGetPathWithCode_thenReturnBoundsLocationYIsMinusOne() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(Standard14Fonts.FontName.ZAPF_DINGBATS)).getPath(99);

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(-1, location.y);
    assertEquals(-1, bounds.y);
    assertEquals(-1.0d, location.getY());
    assertEquals(-1.0d, bounds.getY());
    assertEquals(-1.0d, bounds.getMinY());
    assertEquals(127.5d, bounds.getCenterX());
    Dimension size = bounds.getSize();
    assertEquals(165, size.width);
    assertEquals(165, bounds.width);
    assertEquals(165.0d, size.getWidth());
    assertEquals(165.0d, bounds.getWidth());
    assertEquals(185.0d, bounds.getMaxY());
    assertEquals(186, size.height);
    assertEquals(186, bounds.height);
    assertEquals(186.0d, size.getHeight());
    assertEquals(186.0d, bounds.getHeight());
    assertEquals(203.0d, currentPoint.getX());
    assertEquals(203.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(210.0d, bounds.getMaxX());
    assertEquals(45, location.x);
    assertEquals(45, bounds.x);
    assertEquals(45.0d, location.getX());
    assertEquals(45.0d, bounds.getX());
    assertEquals(45.0d, bounds.getMinX());
    assertEquals(49.0d, currentPoint.getY());
    assertEquals(49.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(92.0d, bounds.getCenterY());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code TIMES_BOLD}.</li>
   *   <li>When {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; given PDType1Font(FontName) with baseFont is 'TIMES_BOLD'; when 'Name'")
  void testGetPathWithName_givenPDType1FontWithBaseFontIsTimesBold_whenName() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD)).getPath("Name");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code TIMES_ROMAN}.</li>
   *   <li>When {@code java.lang.Integer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; when 'java.lang.Integer'")
  void testGetPathWithName_givenPDType1FontWithBaseFontIsTimesRoman_whenJavaLangInteger() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).getPath("java.lang.Integer");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code TIMES_ROMAN}.</li>
   *   <li>When {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; when 'Name'")
  void testGetPathWithName_givenPDType1FontWithBaseFontIsTimesRoman_whenName() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).getPath("Name");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code TIMES_ROMAN}.</li>
   *   <li>When {@code uni}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; when 'uni'")
  void testGetPathWithName_givenPDType1FontWithBaseFontIsTimesRoman_whenUni() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).getPath("uni");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   * <ul>
   *   <li>Then return Bounds Location {@link Point#x} is one hundred three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; then return Bounds Location x is one hundred three")
  void testGetPathWithName_thenReturnBoundsLocationXIsOneHundredThree() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(Standard14Fonts.FontName.SYMBOL)).getPath("u");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(103, location.x);
    assertEquals(103, bounds.x);
    assertEquals(103.0d, location.getX());
    assertEquals(103.0d, bounds.getX());
    assertEquals(103.0d, bounds.getMinX());
    assertEquals(1127.0d, bounds.getMaxX());
    assertEquals(135.0d, currentPoint.getX());
    assertEquals(135.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(615.0d, bounds.getCenterX());
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   * <ul>
   *   <li>Then return Bounds Location {@link Point#y} is minus twenty-nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; then return Bounds Location y is minus twenty-nine")
  void testGetPathWithName_thenReturnBoundsLocationYIsMinusTwentyNine() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(Standard14Fonts.FontName.SYMBOL)).getPath("ellipsis");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(-29, location.y);
    assertEquals(-29, bounds.y);
    assertEquals(-29.0d, location.getY());
    assertEquals(-29.0d, bounds.getY());
    assertEquals(-29.0d, bounds.getMinY());
    assertEquals(1818.0d, currentPoint.getX());
    assertEquals(1818.0f, ((Point2D.Float) currentPoint).x);
    Dimension size = bounds.getSize();
    assertEquals(223, size.height);
    assertEquals(223, bounds.height);
    assertEquals(223.0d, size.getHeight());
    assertEquals(223.0d, bounds.getHeight());
    assertEquals(82.5d, bounds.getCenterY());
    assertEquals(83.0d, currentPoint.getY());
    assertEquals(83.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   * <ul>
   *   <li>When {@code ellipsis}.</li>
   *   <li>Then return CurrentPoint X is {@code 1707.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when 'ellipsis'; then return CurrentPoint X is '1707.0'")
  void testGetPathWithName_whenEllipsis_thenReturnCurrentPointXIs17070() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).getPath("ellipsis");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertEquals(1707.0d, currentPoint.getX());
    assertEquals(1707.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(194.0d, currentPoint.getY());
    assertEquals(194.0f, ((Point2D.Float) currentPoint).y);
    Dimension size = bounds.getSize();
    assertEquals(222, size.height);
    assertEquals(222, bounds.height);
    assertEquals(222.0d, size.getHeight());
    assertEquals(222.0d, bounds.getHeight());
    assertEquals(83.0d, bounds.getCenterY());
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   * <ul>
   *   <li>When {@code g9}.</li>
   *   <li>Then return Bounds Location {@link Point#y} is minus thirty-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when 'g9'; then return Bounds Location y is minus thirty-one")
  void testGetPathWithName_whenG9_thenReturnBoundsLocationYIsMinusThirtyOne() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).getPath("g9");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(-31, location.y);
    assertEquals(-31, bounds.y);
    assertEquals(-31.0d, location.getY());
    assertEquals(-31.0d, bounds.getY());
    assertEquals(-31.0d, bounds.getMinY());
    assertEquals(1387.0d, bounds.getMaxY());
    Dimension size = bounds.getSize();
    assertEquals(1418, size.height);
    assertEquals(1418, bounds.height);
    assertEquals(1418.0d, size.getHeight());
    assertEquals(1418.0d, bounds.getHeight());
    assertEquals(1456, size.width);
    assertEquals(1456, bounds.width);
    assertEquals(1456.0d, size.getWidth());
    assertEquals(1456.0d, bounds.getWidth());
    assertEquals(1531.0d, bounds.getMaxX());
    assertEquals(222.0d, currentPoint.getY());
    assertEquals(222.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(678.0d, bounds.getCenterY());
    assertEquals(75, location.x);
    assertEquals(75, bounds.x);
    assertEquals(75.0d, location.getX());
    assertEquals(75.0d, bounds.getX());
    assertEquals(75.0d, bounds.getMinX());
    assertEquals(803.0d, bounds.getCenterX());
    assertEquals(818.0d, currentPoint.getX());
    assertEquals(818.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
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
  void testGetPathWithName_whenNotdef_thenReturnCurrentPointIsNull() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).getPath(".notdef");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualPath.getCurrentPoint());
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   * <ul>
   *   <li>When {@code u}.</li>
   *   <li>Then return Bounds Size {@link Dimension#width} is {@code 1019}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when 'u'; then return Bounds Size width is '1019'")
  void testGetPathWithName_whenU_thenReturnBoundsSizeWidthIs1019() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).getPath("u");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Dimension size = bounds.getSize();
    assertEquals(1019, size.width);
    assertEquals(1019, bounds.width);
    assertEquals(1019.0d, size.getWidth());
    assertEquals(1019.0d, bounds.getWidth());
    assertEquals(1021.0d, bounds.getMaxX());
    Point location = bounds.getLocation();
    assertEquals(2, location.x);
    assertEquals(2, bounds.x);
    assertEquals(2.0d, location.getX());
    assertEquals(2.0d, bounds.getX());
    assertEquals(2.0d, bounds.getMinX());
    assertEquals(444.0d, bounds.getCenterY());
    assertEquals(511.5d, bounds.getCenterX());
    assertEquals(867.0d, currentPoint.getX());
    assertEquals(867.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(916.0d, currentPoint.getY());
    assertEquals(916.0d, bounds.getMaxY());
    assertEquals(916.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(944, size.height);
    assertEquals(944, bounds.height);
    assertEquals(944.0d, size.getHeight());
    assertEquals(944.0d, bounds.getHeight());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getNormalizedPath(int)}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code SYMBOL}.</li>
   *   <li>When {@link Integer#SIZE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); given PDType1Font(FontName) with baseFont is 'SYMBOL'; when SIZE")
  void testGetNormalizedPath_givenPDType1FontWithBaseFontIsSymbol_whenSize() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDType1Font(Standard14Fonts.FontName.SYMBOL))
        .getNormalizedPath(Integer.SIZE);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getNormalizedPath(int)}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code TIMES_BOLD}.</li>
   *   <li>When {@link Integer#SIZE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); given PDType1Font(FontName) with baseFont is 'TIMES_BOLD'; when SIZE")
  void testGetNormalizedPath_givenPDType1FontWithBaseFontIsTimesBold_whenSize() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD))
        .getNormalizedPath(Integer.SIZE);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getNormalizedPath(int)}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code TIMES_ROMAN}.</li>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; when one")
  void testGetNormalizedPath_givenPDType1FontWithBaseFontIsTimesRoman_whenOne() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).getNormalizedPath(1);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getNormalizedPath(int)}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code TIMES_ROMAN}.</li>
   *   <li>When {@link Integer#SIZE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'; when SIZE")
  void testGetNormalizedPath_givenPDType1FontWithBaseFontIsTimesRoman_whenSize() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN))
        .getNormalizedPath(Integer.SIZE);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getNormalizedPath(int)}.
   * <ul>
   *   <li>Then return Bounds Location {@link Point#y} is minus four hundred
   * forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); then return Bounds Location y is minus four hundred forty-two")
  void testGetNormalizedPath_thenReturnBoundsLocationYIsMinusFourHundredFortyTwo() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDType1Font(Standard14Fonts.FontName.SYMBOL)).getNormalizedPath(99);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualNormalizedPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(-442, location.y);
    assertEquals(-442, bounds.y);
    assertEquals(-442.0d, location.getY());
    assertEquals(-442.0d, bounds.getY());
    assertEquals(-442.0d, bounds.getMinY());
    assertEquals(1049.0d, bounds.getMaxX());
    Dimension size = bounds.getSize();
    assertEquals(1375, size.height);
    assertEquals(1375, bounds.height);
    assertEquals(1375.0d, size.getHeight());
    assertEquals(1375.0d, bounds.getHeight());
    assertEquals(245.5d, bounds.getCenterY());
    assertEquals(559.5d, bounds.getCenterX());
    assertEquals(70, location.x);
    assertEquals(70, bounds.x);
    assertEquals(70.0d, location.getX());
    assertEquals(70.0d, bounds.getX());
    assertEquals(70.0d, bounds.getMinX());
    assertEquals(916.0d, currentPoint.getY());
    assertEquals(916.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(933.0d, bounds.getMaxY());
    assertEquals(966.0d, currentPoint.getX());
    assertEquals(966.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(979, size.width);
    assertEquals(979, bounds.width);
    assertEquals(979.0d, size.getWidth());
    assertEquals(979.0d, bounds.getWidth());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getNormalizedPath(int)}.
   * <ul>
   *   <li>Then return Bounds Location {@link Point#y} is minus twenty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); then return Bounds Location y is minus twenty-eight")
  void testGetNormalizedPath_thenReturnBoundsLocationYIsMinusTwentyEight() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDType1Font(Standard14Fonts.FontName.TIMES_BOLD)).getNormalizedPath(99);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualNormalizedPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(-28, location.y);
    assertEquals(-28, bounds.y);
    assertEquals(-28.0d, location.getY());
    assertEquals(-28.0d, bounds.getY());
    assertEquals(-28.0d, bounds.getMinY());
    assertEquals(241.0d, currentPoint.getY());
    assertEquals(241.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(467.5d, bounds.getCenterY());
    assertEquals(470.5d, bounds.getCenterX());
    assertEquals(78, location.x);
    assertEquals(78, bounds.x);
    assertEquals(78.0d, location.getX());
    assertEquals(78.0d, bounds.getX());
    assertEquals(78.0d, bounds.getMinX());
    Dimension size = bounds.getSize();
    assertEquals(785, size.width);
    assertEquals(785, bounds.width);
    assertEquals(785.0d, size.getWidth());
    assertEquals(785.0d, bounds.getWidth());
    assertEquals(832.0d, currentPoint.getX());
    assertEquals(832.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(863.0d, bounds.getMaxX());
    assertEquals(963.0d, bounds.getMaxY());
    assertEquals(991, size.height);
    assertEquals(991, bounds.height);
    assertEquals(991.0d, size.getHeight());
    assertEquals(991.0d, bounds.getHeight());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
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
  void testHasGlyphWithCode_whenOne_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).hasGlyph(1));
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
  void testHasGlyphWithCode_whenSize_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).hasGlyph(Integer.SIZE));
  }

  /**
   * Test {@link PDType1Font#hasGlyph(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code SYMBOL}.</li>
   *   <li>When {@code ellipsis}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; given PDType1Font(FontName) with baseFont is 'SYMBOL'; when 'ellipsis'")
  void testHasGlyphWithName_givenPDType1FontWithBaseFontIsSymbol_whenEllipsis() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDType1Font(Standard14Fonts.FontName.SYMBOL)).hasGlyph("ellipsis"));
  }

  /**
   * Test {@link PDType1Font#hasGlyph(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code SYMBOL}.</li>
   *   <li>When {@code u}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; given PDType1Font(FontName) with baseFont is 'SYMBOL'; when 'u'; then return 'false'")
  void testHasGlyphWithName_givenPDType1FontWithBaseFontIsSymbol_whenU_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDType1Font(Standard14Fonts.FontName.SYMBOL)).hasGlyph("u"));
  }

  /**
   * Test {@link PDType1Font#hasGlyph(String)} with {@code name}.
   * <ul>
   *   <li>When {@code ellipsis}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'ellipsis'; then return 'true'")
  void testHasGlyphWithName_whenEllipsis_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).hasGlyph("ellipsis"));
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
  void testHasGlyphWithName_whenG9_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).hasGlyph("g9"));
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
  void testHasGlyphWithName_whenG942_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).hasGlyph("g942"));
  }

  /**
   * Test {@link PDType1Font#hasGlyph(String)} with {@code name}.
   * <ul>
   *   <li>When {@code java.lang.Integer}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'java.lang.Integer'; then return 'false'")
  void testHasGlyphWithName_whenJavaLangInteger_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).hasGlyph("java.lang.Integer"));
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
  void testHasGlyphWithName_whenName_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).hasGlyph("Name"));
  }

  /**
   * Test {@link PDType1Font#hasGlyph(String)} with {@code name}.
   * <ul>
   *   <li>When {@code u}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'u'; then return 'true'")
  void testHasGlyphWithName_whenU_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).hasGlyph("u"));
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
  void testHasGlyphWithName_whenUni_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).hasGlyph("uni"));
  }

  /**
   * Test {@link PDType1Font#getFontMatrix()}.
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is
   * {@code TIMES_ROMAN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix(); given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN'")
  void testGetFontMatrix_givenPDType1FontWithBaseFontIsTimesRoman() {
    // Arrange and Act
    Matrix actualFontMatrix = (new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN)).getFontMatrix();

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
   *   <li>Given {@link PDType1Font#PDType1Font(COSDictionary)} with fontDictionary
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType1Font#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix(); given PDType1Font(COSDictionary) with fontDictionary is COSDictionary()")
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
