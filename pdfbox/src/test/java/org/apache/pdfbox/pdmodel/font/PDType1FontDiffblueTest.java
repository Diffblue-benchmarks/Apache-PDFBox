package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.geom.Rectangle2D.Float;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.type1.Type1Font;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.Type1Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDType1FontDiffblueTest {
  /**
   * Test {@link PDType1Font#PDType1Font(FontName)}.
   *
   * <ul>
   *   <li>When {@code TIMES_ROMAN}.
   *   <li>Then FontBoxFont return {@link TrueTypeFont}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#PDType1Font(FontName)}
   */
  @Test
  @DisplayName(
      "Test new PDType1Font(FontName); when 'TIMES_ROMAN'; then FontBoxFont return TrueTypeFont")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDType1Font.<init>(FontName)"})
  void testNewPDType1Font_whenTimesRoman_thenFontBoxFontReturnTrueTypeFont() {
    // Arrange and Act
    PDType1Font actualPdType1Font = new PDType1Font(FontName.TIMES_ROMAN);

    // Assert
    assertTrue(actualPdType1Font.getFontBoxFont() instanceof TrueTypeFont);
    assertTrue(actualPdType1Font.getEncoding() instanceof WinAnsiEncoding);
    assertEquals("Font", actualPdType1Font.getType());
    assertEquals("Times-Roman", actualPdType1Font.getBaseFont());
    assertEquals("Times-Roman", actualPdType1Font.getName());
    assertEquals("Type1", actualPdType1Font.getSubType());
    assertNull(actualPdType1Font.getToUnicodeCMap());
    assertNull(actualPdType1Font.getType1Font());
    assertEquals(250.0f, actualPdType1Font.getSpaceWidth());
    assertEquals(518.0603f, actualPdType1Font.getAverageFontWidth());
    assertFalse(actualPdType1Font.getSymbolicFlag());
    assertFalse(actualPdType1Font.isVertical());
    assertFalse(actualPdType1Font.isDamaged());
    assertFalse(actualPdType1Font.isEmbedded());
    assertTrue(actualPdType1Font.getWidths().isEmpty());
  }

  /**
   * Test {@link PDType1Font#getBaseFont()}.
   *
   * <p>Method under test: {@link PDType1Font#getBaseFont()}
   */
  @Test
  @DisplayName("Test getBaseFont()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDType1Font.getBaseFont()"})
  void testGetBaseFont() {
    // Arrange, Act and Assert
    assertEquals("Times-Roman", new PDType1Font(FontName.TIMES_ROMAN).getBaseFont());
  }

  /**
   * Test {@link PDType1Font#getHeight(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType1Font.getHeight(int)"})
  void testGetHeight_whenOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDType1Font(FontName.TIMES_ROMAN).getHeight(1));
  }

  /**
   * Test {@link PDType1Font#getHeight(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); when SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType1Font.getHeight(int)"})
  void testGetHeight_whenSize() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDType1Font(FontName.TIMES_ROMAN).getHeight(Integer.SIZE));
  }

  /**
   * Test {@link PDType1Font#encode(int)} with {@code unicode}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'; when one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDType1Font.encode(int)"})
  void testEncodeWithUnicode_whenOne_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new PDType1Font(FontName.TIMES_ROMAN).encode(1));
  }

  /**
   * Test {@link PDType1Font#encode(int)} with {@code unicode}.
   *
   * <ul>
   *   <li>When {@link Integer#SIZE}.
   *   <li>Then return array of {@code byte} with space.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'; when SIZE; then return array of byte with space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDType1Font.encode(int)"})
  void testEncodeWithUnicode_whenSize_thenReturnArrayOfByteWithSpace() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {' '}, new PDType1Font(FontName.TIMES_ROMAN).encode(Integer.SIZE));
  }

  /**
   * Test {@link PDType1Font#encode(int)} with {@code unicode}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'; when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDType1Font.encode(int)"})
  void testEncodeWithUnicode_whenZero_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new PDType1Font(FontName.TIMES_ROMAN).encode(0));
  }

  /**
   * Test {@link PDType1Font#getWidthFromFont(int)}.
   *
   * <ul>
   *   <li>When forty-six.
   *   <li>Then return five hundred twelve.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int); when forty-six; then return five hundred twelve")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType1Font.getWidthFromFont(int)"})
  void testGetWidthFromFont_whenFortySix_thenReturnFiveHundredTwelve() throws IOException {
    // Arrange, Act and Assert
    assertEquals(512.0f, new PDType1Font(FontName.TIMES_ROMAN).getWidthFromFont(46));
  }

  /**
   * Test {@link PDType1Font#getWidthFromFont(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return two hundred fifty.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int); when one; then return two hundred fifty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType1Font.getWidthFromFont(int)"})
  void testGetWidthFromFont_whenOne_thenReturnTwoHundredFifty() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250.0f, new PDType1Font(FontName.TIMES_ROMAN).getWidthFromFont(1));
  }

  /**
   * Test {@link PDType1Font#getWidthFromFont(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#SIZE}.
   *   <li>Then return five hundred twelve.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int); when SIZE; then return five hundred twelve")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType1Font.getWidthFromFont(int)"})
  void testGetWidthFromFont_whenSize_thenReturnFiveHundredTwelve() throws IOException {
    // Arrange, Act and Assert
    assertEquals(512.0f, new PDType1Font(FontName.TIMES_ROMAN).getWidthFromFont(Integer.SIZE));
  }

  /**
   * Test {@link PDType1Font#getAverageFontWidth()}.
   *
   * <p>Method under test: {@link PDType1Font#getAverageFontWidth()}
   */
  @Test
  @DisplayName("Test getAverageFontWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType1Font.getAverageFontWidth()"})
  void testGetAverageFontWidth() {
    // Arrange, Act and Assert
    assertEquals(518.0603f, new PDType1Font(FontName.TIMES_ROMAN).getAverageFontWidth());
  }

  /**
   * Test {@link PDType1Font#readCode(InputStream)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#readCode(InputStream)}
   */
  @Test
  @DisplayName("Test readCode(InputStream); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDType1Font.readCode(InputStream)"})
  void testReadCode_givenIOException_thenThrowIOException() throws IOException {
    // Arrange
    PDType1Font pdType1Font = new PDType1Font(FontName.TIMES_ROMAN);

    DataInputStream in = mock(DataInputStream.class);
    when(in.read()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(IOException.class, () -> pdType1Font.readCode(in));
    verify(in).read();
  }

  /**
   * Test {@link PDType1Font#readCode(InputStream)}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#readCode(InputStream)}
   */
  @Test
  @DisplayName(
      "Test readCode(InputStream); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDType1Font.readCode(InputStream)"})
  void testReadCode_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnSixtyFive()
      throws IOException {
    // Arrange
    PDType1Font pdType1Font = new PDType1Font(FontName.TIMES_ROMAN);
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualReadCodeResult = pdType1Font.readCode(in);

    // Assert
    assertEquals(65, actualReadCodeResult);
    byte[] byteArray = new byte[7];
    assertEquals(7, in.read(byteArray));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDType1Font#readEncodingFromFont()}.
   *
   * <p>Method under test: {@link PDType1Font#readEncodingFromFont()}
   */
  @Test
  @DisplayName("Test readEncodingFromFont()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Encoding PDType1Font.readEncodingFromFont()"})
  void testReadEncodingFromFont() throws IOException {
    // Arrange and Act
    Encoding actualReadEncodingFromFontResult =
        new PDType1Font(FontName.TIMES_ROMAN).readEncodingFromFont();

    // Assert
    assertTrue(actualReadEncodingFromFontResult instanceof Type1Encoding);
    Map<Integer, String> codeToNameMap = actualReadEncodingFromFontResult.getCodeToNameMap();
    assertEquals(150, codeToNameMap.size());
    assertEquals("Euro", codeToNameMap.get(-1));
    assertEquals("built-in (Type 1)", actualReadEncodingFromFontResult.getEncodingName());
    assertEquals("dollar", codeToNameMap.get(36));
    assertEquals("exclam", codeToNameMap.get(33));
    assertEquals("numbersign", codeToNameMap.get(35));
    assertEquals("quotedbl", codeToNameMap.get(34));
    assertEquals("space", codeToNameMap.get(Integer.SIZE));
    assertNull(actualReadEncodingFromFontResult.getCOSObject());
    Map<String, Integer> nameToCodeMap = actualReadEncodingFromFontResult.getNameToCodeMap();
    assertEquals(315, nameToCodeMap.size());
    assertEquals(-1, nameToCodeMap.get("Ncommaaccent").intValue());
    assertEquals(-1, nameToCodeMap.get("omacron").intValue());
    assertEquals(-1, nameToCodeMap.get("registered").intValue());
    assertEquals(202, nameToCodeMap.get("ring").intValue());
    assertEquals(41, nameToCodeMap.get("parenright").intValue());
    assertEquals(42, nameToCodeMap.get("asterisk").intValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDType1Font#getFontBoxFont()}
   *   <li>{@link PDType1Font#getType1Font()}
   *   <li>{@link PDType1Font#isDamaged()}
   *   <li>{@link PDType1Font#isEmbedded()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FontBoxFont PDType1Font.getFontBoxFont()",
    "Type1Font PDType1Font.getType1Font()",
    "boolean PDType1Font.isDamaged()",
    "boolean PDType1Font.isEmbedded()"
  })
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
   *
   * <p>Method under test: {@link PDType1Font#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDType1Font.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("Times-Roman", new PDType1Font(FontName.TIMES_ROMAN).getName());
  }

  /**
   * Test {@link PDType1Font#getBoundingBox()}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} FontBoundingBox is {@link
   *       PDRectangle#PDRectangle()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); given PDFontDescriptor() FontBoundingBox is PDRectangle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link PDType1Font#PDType1Font(FontName)} with baseFont is {@code TIMES_ROMAN}
   *       FontDescriptor is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getBoundingBox()}
   */
  @Test
  @DisplayName(
      "Test getBoundingBox(); given PDType1Font(FontName) with baseFont is 'TIMES_ROMAN' FontDescriptor is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDType1Font.getBoundingBox()"})
  void testGetBoundingBox_givenPDType1FontWithBaseFontIsTimesRomanFontDescriptorIsNull()
      throws IOException {
    // Arrange
    PDType1Font pdType1Font = new PDType1Font(FontName.TIMES_ROMAN);
    pdType1Font.setFontDescriptor(null);

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
   *
   * <ul>
   *   <li>Then return LowerLeftX is {@code -176.75781}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return LowerLeftX is '-176.75781'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return LowerLeftX is {@code 2.14748365E9}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return LowerLeftX is '2.14748365E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDType1Font.getBoundingBox()"})
  void testGetBoundingBox_thenReturnLowerLeftXIs214748365e9() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    PDRectangle rect = new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    fontDescriptor.setFontBoundingBox(rect);

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
   *
   * <ul>
   *   <li>Then return LowerLeftX is minus one hundred sixty-eight.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return LowerLeftX is minus one hundred sixty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDType1Font.getBoundingBox()"})
  void testGetBoundingBox_thenReturnLowerLeftXIsMinusOneHundredSixtyEight() throws IOException {
    // Arrange and Act
    BoundingBox actualBoundingBox = new PDType1Font(FontName.TIMES_ROMAN).getBoundingBox();

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
   *
   * <ul>
   *   <li>Then return LowerLeftY is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return LowerLeftY is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return UpperRightX is {@code 2383.937}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return UpperRightX is '2383.937'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then return Width is {@code 2.14748365E9}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return Width is '2.14748365E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDType1Font.getBoundingBox()"})
  void testGetBoundingBox_thenReturnWidthIs214748365e9() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    PDRectangle rect = new PDRectangle(0.0f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    fontDescriptor.setFontBoundingBox(rect);

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
   *
   * <ul>
   *   <li>When forty-six.
   *   <li>Then return {@code period}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#codeToName(int)}
   */
  @Test
  @DisplayName("Test codeToName(int); when forty-six; then return 'period'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDType1Font.codeToName(int)"})
  void testCodeToName_whenFortySix_thenReturnPeriod() throws IOException {
    // Arrange, Act and Assert
    assertEquals("period", new PDType1Font(FontName.TIMES_ROMAN).codeToName(46));
  }

  /**
   * Test {@link PDType1Font#codeToName(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code .notdef}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#codeToName(int)}
   */
  @Test
  @DisplayName("Test codeToName(int); when one; then return '.notdef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDType1Font.codeToName(int)"})
  void testCodeToName_whenOne_thenReturnNotdef() throws IOException {
    // Arrange, Act and Assert
    assertEquals(".notdef", new PDType1Font(FontName.TIMES_ROMAN).codeToName(1));
  }

  /**
   * Test {@link PDType1Font#codeToName(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#SIZE}.
   *   <li>Then return {@code uni0020}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#codeToName(int)}
   */
  @Test
  @DisplayName("Test codeToName(int); when SIZE; then return 'uni0020'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDType1Font.codeToName(int)"})
  void testCodeToName_whenSize_thenReturnUni0020() throws IOException {
    // Arrange, Act and Assert
    assertEquals("uni0020", new PDType1Font(FontName.TIMES_ROMAN).codeToName(Integer.SIZE));
  }

  /**
   * Test {@link PDType1Font#getPath(int)} with {@code code}.
   *
   * <ul>
   *   <li>When ninety-nine.
   *   <li>Then CurrentPoint return {@link Point2D.Float}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; when ninety-nine; then CurrentPoint return Float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1Font.getPath(int)"})
  void testGetPathWithCode_whenNinetyNine_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = new PDType1Font(FontName.TIMES_ROMAN).getPath(99);

    // Assert
    assertTrue(actualPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualPath.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link PDType1Font#getPath(int)} with {@code code}.
   *
   * <ul>
   *   <li>When one hundred one.
   *   <li>Then CurrentPoint return {@link Point2D.Float}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getPath(int)}
   */
  @Test
  @DisplayName(
      "Test getPath(int) with 'code'; when one hundred one; then CurrentPoint return Float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1Font.getPath(int)"})
  void testGetPathWithCode_whenOneHundredOne_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = new PDType1Font(FontName.TIMES_ROMAN).getPath(101);

    // Assert
    assertTrue(actualPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualPath.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link PDType1Font#getPath(int)} with {@code code}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; when one; then Bounds Bounds2D return Rectangle")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1Font.getPath(int)"})
  void testGetPathWithCode_whenOne_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = new PDType1Font(FontName.TIMES_ROMAN).getPath(1);

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(int)} with {@code code}.
   *
   * <ul>
   *   <li>When {@link Integer#SIZE}.
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; when SIZE; then Bounds Bounds2D return Rectangle")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1Font.getPath(int)"})
  void testGetPathWithCode_whenSize_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = new PDType1Font(FontName.TIMES_ROMAN).getPath(Integer.SIZE);

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   *
   * <ul>
   *   <li>When {@code g9}.
   *   <li>Then CurrentPoint return {@link Point2D.Float}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when 'g9'; then CurrentPoint return Float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1Font.getPath(String)"})
  void testGetPathWithName_whenG9_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = new PDType1Font(FontName.TIMES_ROMAN).getPath("g9");

    // Assert
    assertTrue(actualPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualPath.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   *
   * <ul>
   *   <li>When {@code Integer}.
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName(
      "Test getPath(String) with 'name'; when 'java.lang.Integer'; then Bounds Bounds2D return Rectangle")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1Font.getPath(String)"})
  void testGetPathWithName_whenJavaLangInteger_thenBoundsBounds2DReturnRectangle()
      throws IOException {
    // Arrange and Act
    GeneralPath actualPath = new PDType1Font(FontName.TIMES_ROMAN).getPath("java.lang.Integer");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName(
      "Test getPath(String) with 'name'; when 'Name'; then Bounds Bounds2D return Rectangle")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1Font.getPath(String)"})
  void testGetPathWithName_whenName_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = new PDType1Font(FontName.TIMES_ROMAN).getPath("Name");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   *
   * <ul>
   *   <li>When {@code .notdef}.
   *   <li>Then return CurrentPoint is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName(
      "Test getPath(String) with 'name'; when '.notdef'; then return CurrentPoint is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1Font.getPath(String)"})
  void testGetPathWithName_whenNotdef_thenReturnCurrentPointIsNull() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = new PDType1Font(FontName.TIMES_ROMAN).getPath(".notdef");

    // Assert
    assertTrue(actualPath.getBounds2D() instanceof Float);
    assertNull(actualPath.getCurrentPoint());
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   *
   * <ul>
   *   <li>When {@code u}.
   *   <li>Then CurrentPoint return {@link Point2D.Float}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when 'u'; then CurrentPoint return Float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1Font.getPath(String)"})
  void testGetPathWithName_whenU_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = new PDType1Font(FontName.TIMES_ROMAN).getPath("u");

    // Assert
    assertTrue(actualPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualPath.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link PDType1Font#getPath(String)} with {@code name}.
   *
   * <ul>
   *   <li>When {@code uni}.
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getPath(String)}
   */
  @Test
  @DisplayName(
      "Test getPath(String) with 'name'; when 'uni'; then Bounds Bounds2D return Rectangle")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1Font.getPath(String)"})
  void testGetPathWithName_whenUni_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = new PDType1Font(FontName.TIMES_ROMAN).getPath("uni");

    // Assert
    Rectangle bounds = actualPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getNormalizedPath(int)}.
   *
   * <p>Method under test: {@link PDType1Font#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1Font.getNormalizedPath(int)"})
  void testGetNormalizedPath() throws IOException {
    // Arrange
    PDType1Font pdType1Font = new PDType1Font(FontName.TIMES_ROMAN);
    pdType1Font.setFontDescriptor(new PDFontDescriptor());

    // Act
    GeneralPath actualNormalizedPath = pdType1Font.getNormalizedPath(Integer.SIZE);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getNormalizedPath(int)}.
   *
   * <ul>
   *   <li>When ninety-nine.
   *   <li>Then CurrentPoint return {@link Point2D.Float}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); when ninety-nine; then CurrentPoint return Float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1Font.getNormalizedPath(int)"})
  void testGetNormalizedPath_whenNinetyNine_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = new PDType1Font(FontName.TIMES_ROMAN).getNormalizedPath(99);

    // Assert
    assertTrue(actualNormalizedPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualNormalizedPath.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link PDType1Font#getNormalizedPath(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); when one; then Bounds Bounds2D return Rectangle")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1Font.getNormalizedPath(int)"})
  void testGetNormalizedPath_whenOne_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = new PDType1Font(FontName.TIMES_ROMAN).getNormalizedPath(1);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#getNormalizedPath(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#SIZE}.
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); when SIZE; then Bounds Bounds2D return Rectangle")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDType1Font.getNormalizedPath(int)"})
  void testGetNormalizedPath_whenSize_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath =
        new PDType1Font(FontName.TIMES_ROMAN).getNormalizedPath(Integer.SIZE);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
    assertTrue(bounds2D2 instanceof Float);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDType1Font#hasGlyph(int)} with {@code code}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#hasGlyph(int)}
   */
  @Test
  @DisplayName("Test hasGlyph(int) with 'code'; when one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDType1Font.hasGlyph(int)"})
  void testHasGlyphWithCode_whenOne_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse(new PDType1Font(FontName.TIMES_ROMAN).hasGlyph(1));
  }

  /**
   * Test {@link PDType1Font#hasGlyph(int)} with {@code code}.
   *
   * <ul>
   *   <li>When {@link Integer#SIZE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#hasGlyph(int)}
   */
  @Test
  @DisplayName("Test hasGlyph(int) with 'code'; when SIZE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDType1Font.hasGlyph(int)"})
  void testHasGlyphWithCode_whenSize_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue(new PDType1Font(FontName.TIMES_ROMAN).hasGlyph(Integer.SIZE));
  }

  /**
   * Test {@link PDType1Font#hasGlyph(String)} with {@code name}.
   *
   * <ul>
   *   <li>When {@code g9}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'g9'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDType1Font.hasGlyph(String)"})
  void testHasGlyphWithName_whenG9_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue(new PDType1Font(FontName.TIMES_ROMAN).hasGlyph("g9"));
  }

  /**
   * Test {@link PDType1Font#hasGlyph(String)} with {@code name}.
   *
   * <ul>
   *   <li>When {@code Integer}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'java.lang.Integer'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDType1Font.hasGlyph(String)"})
  void testHasGlyphWithName_whenJavaLangInteger_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse(new PDType1Font(FontName.TIMES_ROMAN).hasGlyph("java.lang.Integer"));
  }

  /**
   * Test {@link PDType1Font#hasGlyph(String)} with {@code name}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'Name'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDType1Font.hasGlyph(String)"})
  void testHasGlyphWithName_whenName_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse(new PDType1Font(FontName.TIMES_ROMAN).hasGlyph("Name"));
  }

  /**
   * Test {@link PDType1Font#hasGlyph(String)} with {@code name}.
   *
   * <ul>
   *   <li>When {@code u}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'u'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDType1Font.hasGlyph(String)"})
  void testHasGlyphWithName_whenU_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue(new PDType1Font(FontName.TIMES_ROMAN).hasGlyph("u"));
  }

  /**
   * Test {@link PDType1Font#hasGlyph(String)} with {@code name}.
   *
   * <ul>
   *   <li>When {@code uni}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDType1Font#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'uni'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDType1Font.hasGlyph(String)"})
  void testHasGlyphWithName_whenUni_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse(new PDType1Font(FontName.TIMES_ROMAN).hasGlyph("uni"));
  }

  /**
   * Test {@link PDType1Font#getFontMatrix()}.
   *
   * <p>Method under test: {@link PDType1Font#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix PDType1Font.getFontMatrix()"})
  void testGetFontMatrix() {
    // Arrange and Act
    Matrix actualFontMatrix = new PDType1Font(FontName.TIMES_ROMAN).getFontMatrix();

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
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 4.8828125E-4f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {4.8828125E-4f, 0.0f, 0.0f}, values[0], 0.0f);
  }
}
