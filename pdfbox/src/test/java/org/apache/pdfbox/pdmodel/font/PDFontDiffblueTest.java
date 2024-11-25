package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFontDiffblueTest {
  /**
   * Test {@link PDFont#getStandard14AFM()}.
   * <p>
   * Method under test: {@link PDFont#getStandard14AFM()}
   */
  @Test
  @DisplayName("Test getStandard14AFM()")
  void testGetStandard14AFM() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSDictionary())).getStandard14AFM());
  }

  /**
   * Test {@link PDFont#getFontDescriptor()}.
   * <p>
   * Method under test: {@link PDFont#getFontDescriptor()}
   */
  @Test
  @DisplayName("Test getFontDescriptor()")
  void testGetFontDescriptor() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSDictionary())).getFontDescriptor());
  }

  /**
   * Test {@link PDFont#setFontDescriptor(PDFontDescriptor)}.
   * <p>
   * Method under test: {@link PDFont#setFontDescriptor(PDFontDescriptor)}
   */
  @Test
  @DisplayName("Test setFontDescriptor(PDFontDescriptor)")
  void testSetFontDescriptor() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();

    // Act
    pdmmType1Font.setFontDescriptor(fontDescriptor);

    // Assert
    assertFalse(pdmmType1Font.getSymbolicFlag());
    assertSame(fontDescriptor, pdmmType1Font.getFontDescriptor());
  }

  /**
   * Test {@link PDFont#readCMap(COSBase)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#readCMap(COSBase)}
   */
  @Test
  @DisplayName("Test readCMap(COSBase); when FALSE; then throw IOException")
  void testReadCMap_whenFalse_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDMMType1Font(new COSDictionary())).readCMap(COSBoolean.FALSE));
  }

  /**
   * Test {@link PDFont#getCOSObject()}.
   * <p>
   * Method under test: {@link PDFont#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());

    // Act and Assert
    assertSame(pdmmType1Font.dict, pdmmType1Font.getCOSObject());
  }

  /**
   * Test {@link PDFont#getPositionVector(int)}.
   * <p>
   * Method under test: {@link PDFont#getPositionVector(int)}
   */
  @Test
  @DisplayName("Test getPositionVector(int)")
  void testGetPositionVector() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDMMType1Font(new COSDictionary())).getPositionVector(1));
  }

  /**
   * Test {@link PDFont#getDisplacement(int)}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getDisplacement(int)}
   */
  @Test
  @DisplayName("Test getDisplacement(int); given PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary(); when one")
  void testGetDisplacement_givenPDMMType1FontWithFontDictionaryIsCOSDictionary_whenOne() throws IOException {
    // Arrange and Act
    Vector actualDisplacement = (new PDMMType1Font(new COSDictionary())).getDisplacement(1);

    // Assert
    assertEquals(0.0f, actualDisplacement.getY());
    assertEquals(0.25f, actualDisplacement.getX());
  }

  /**
   * Test {@link PDFont#getDisplacement(int)}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@link Integer#SIZE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getDisplacement(int)}
   */
  @Test
  @DisplayName("Test getDisplacement(int); given PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary(); when SIZE")
  void testGetDisplacement_givenPDMMType1FontWithFontDictionaryIsCOSDictionary_whenSize() throws IOException {
    // Arrange and Act
    Vector actualDisplacement = (new PDMMType1Font(new COSDictionary())).getDisplacement(Integer.SIZE);

    // Assert
    assertEquals(0.0f, actualDisplacement.getY());
    assertEquals(0.25f, actualDisplacement.getX());
  }

  /**
   * Test {@link PDFont#getDisplacement(int)}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getDisplacement(int)}
   */
  @Test
  @DisplayName("Test getDisplacement(int); given PDMMType1Font(COSDictionary) with fontDictionary is COSStream(); when one")
  void testGetDisplacement_givenPDMMType1FontWithFontDictionaryIsCOSStream_whenOne() throws IOException {
    // Arrange and Act
    Vector actualDisplacement = (new PDMMType1Font(new COSStream())).getDisplacement(1);

    // Assert
    assertEquals(0.0f, actualDisplacement.getY());
    assertEquals(0.25f, actualDisplacement.getX());
  }

  /**
   * Test {@link PDFont#getWidth(int)}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getWidth(int)}
   */
  @Test
  @DisplayName("Test getWidth(int); given PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary(); when one")
  void testGetWidth_givenPDMMType1FontWithFontDictionaryIsCOSDictionary_whenOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250.0f, (new PDMMType1Font(new COSDictionary())).getWidth(1));
  }

  /**
   * Test {@link PDFont#getWidth(int)}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@link Integer#SIZE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getWidth(int)}
   */
  @Test
  @DisplayName("Test getWidth(int); given PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary(); when SIZE")
  void testGetWidth_givenPDMMType1FontWithFontDictionaryIsCOSDictionary_whenSize() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250.0f, (new PDMMType1Font(new COSDictionary())).getWidth(Integer.SIZE));
  }

  /**
   * Test {@link PDFont#getWidth(int)}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getWidth(int)}
   */
  @Test
  @DisplayName("Test getWidth(int); given PDMMType1Font(COSDictionary) with fontDictionary is COSStream(); when one")
  void testGetWidth_givenPDMMType1FontWithFontDictionaryIsCOSStream_whenOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250.0f, (new PDMMType1Font(new COSStream())).getWidth(1));
  }

  /**
   * Test {@link PDFont#encode(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#encode(String)}
   */
  @Test
  @DisplayName("Test encode(String) with 'String'; given PDMMType1Font(COSDictionary) with fontDictionary is COSStream()")
  void testEncodeWithString_givenPDMMType1FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange and Act
    byte[] actualEncodeResult = (new PDMMType1Font(new COSStream())).encode("Text");

    // Assert
    assertArrayEquals("Text".getBytes("UTF-8"), actualEncodeResult);
  }

  /**
   * Test {@link PDFont#encode(String)} with {@code String}.
   * <ul>
   *   <li>Then return {@code Text} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#encode(String)}
   */
  @Test
  @DisplayName("Test encode(String) with 'String'; then return 'Text' Bytes is 'UTF-8'")
  void testEncodeWithString_thenReturnTextBytesIsUtf8() throws IOException {
    // Arrange and Act
    byte[] actualEncodeResult = (new PDMMType1Font(new COSDictionary())).encode("Text");

    // Assert
    assertArrayEquals("Text".getBytes("UTF-8"), actualEncodeResult);
  }

  /**
   * Test {@link PDFont#encode(String)} with {@code String}.
   * <ul>
   *   <li>When {@code uni0054}.</li>
   *   <li>Then return {@code uni0054} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#encode(String)}
   */
  @Test
  @DisplayName("Test encode(String) with 'String'; when 'uni0054'; then return 'uni0054' Bytes is 'UTF-8'")
  void testEncodeWithString_whenUni0054_thenReturnUni0054BytesIsUtf8() throws IOException {
    // Arrange and Act
    byte[] actualEncodeResult = (new PDMMType1Font(new COSDictionary())).encode("uni0054");

    // Assert
    assertArrayEquals("uni0054".getBytes("UTF-8"), actualEncodeResult);
  }

  /**
   * Test {@link PDFont#getStringWidth(String)}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getStringWidth(String)}
   */
  @Test
  @DisplayName("Test getStringWidth(String); given PDMMType1Font(COSDictionary) with fontDictionary is COSStream()")
  void testGetStringWidth_givenPDMMType1FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1832.5195f, (new PDMMType1Font(new COSStream())).getStringWidth("Text"));
  }

  /**
   * Test {@link PDFont#getStringWidth(String)}.
   * <ul>
   *   <li>When {@code Text}.</li>
   *   <li>Then return {@code 1832.5195}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getStringWidth(String)}
   */
  @Test
  @DisplayName("Test getStringWidth(String); when 'Text'; then return '1832.5195'")
  void testGetStringWidth_whenText_thenReturn18325195() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1832.5195f, (new PDMMType1Font(new COSDictionary())).getStringWidth("Text"));
  }

  /**
   * Test {@link PDFont#getStringWidth(String)}.
   * <ul>
   *   <li>When {@code uni0054}.</li>
   *   <li>Then return {@code 3277.832}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getStringWidth(String)}
   */
  @Test
  @DisplayName("Test getStringWidth(String); when 'uni0054'; then return '3277.832'")
  void testGetStringWidth_whenUni0054_thenReturn3277832() throws IOException {
    // Arrange, Act and Assert
    assertEquals(3277.832f, (new PDMMType1Font(new COSDictionary())).getStringWidth("uni0054"));
  }

  /**
   * Test {@link PDFont#getAverageFontWidth()}.
   * <ul>
   *   <li>Given {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getAverageFontWidth()}
   */
  @Test
  @DisplayName("Test getAverageFontWidth(); given PDTrueTypeFont(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetAverageFontWidth_givenPDTrueTypeFontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDTrueTypeFont(new COSDictionary())).getAverageFontWidth());
  }

  /**
   * Test {@link PDFont#getAverageFontWidth()}.
   * <ul>
   *   <li>Given {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getAverageFontWidth()}
   */
  @Test
  @DisplayName("Test getAverageFontWidth(); given PDTrueTypeFont(COSDictionary) with fontDictionary is COSStream()")
  void testGetAverageFontWidth_givenPDTrueTypeFontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDTrueTypeFont(new COSStream())).getAverageFontWidth());
  }

  /**
   * Test {@link PDFont#toUnicode(int)} with {@code code}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#toUnicode(int)}
   */
  @Test
  @DisplayName("Test toUnicode(int) with 'code'; given PDMMType1Font(COSDictionary) with fontDictionary is COSStream()")
  void testToUnicodeWithCode_givenPDMMType1FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSStream())).toUnicode(1));
  }

  /**
   * Test {@link PDFont#toUnicode(int)} with {@code code}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#toUnicode(int)}
   */
  @Test
  @DisplayName("Test toUnicode(int) with 'code'; then return 'null'")
  void testToUnicodeWithCode_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSDictionary())).toUnicode(1));
  }

  /**
   * Test {@link PDFont#toUnicode(int)} with {@code code}.
   * <ul>
   *   <li>When forty-six.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#toUnicode(int)}
   */
  @Test
  @DisplayName("Test toUnicode(int) with 'code'; when forty-six; then return '.'")
  void testToUnicodeWithCode_whenFortySix_thenReturnDot() throws IOException {
    // Arrange, Act and Assert
    assertEquals(".", (new PDMMType1Font(new COSDictionary())).toUnicode(46));
  }

  /**
   * Test {@link PDFont#getType()}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getType()}
   */
  @Test
  @DisplayName("Test getType(); given PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetType_givenPDMMType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSDictionary())).getType());
  }

  /**
   * Test {@link PDFont#getType()}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getType()}
   */
  @Test
  @DisplayName("Test getType(); given PDMMType1Font(COSDictionary) with fontDictionary is COSStream()")
  void testGetType_givenPDMMType1FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSStream())).getType());
  }

  /**
   * Test {@link PDFont#getSubType()}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getSubType()}
   */
  @Test
  @DisplayName("Test getSubType(); given PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetSubType_givenPDMMType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSDictionary())).getSubType());
  }

  /**
   * Test {@link PDFont#getSubType()}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getSubType()}
   */
  @Test
  @DisplayName("Test getSubType(); given PDMMType1Font(COSDictionary) with fontDictionary is COSStream()")
  void testGetSubType_givenPDMMType1FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSStream())).getSubType());
  }

  /**
   * Test {@link PDFont#getWidths()}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getWidths()}
   */
  @Test
  @DisplayName("Test getWidths(); given PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetWidths_givenPDMMType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDMMType1Font(new COSDictionary())).getWidths().isEmpty());
  }

  /**
   * Test {@link PDFont#getWidths()}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getWidths()}
   */
  @Test
  @DisplayName("Test getWidths(); given PDMMType1Font(COSDictionary) with fontDictionary is COSStream()")
  void testGetWidths_givenPDMMType1FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDMMType1Font(new COSStream())).getWidths().isEmpty());
  }

  /**
   * Test {@link PDFont#getFontMatrix()}.
   * <p>
   * Method under test: {@link PDFont#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix()")
  void testGetFontMatrix() throws IOException {
    // Arrange
    PDTrueTypeFont pdTrueTypeFont = new PDTrueTypeFont(new COSDictionary());

    // Act and Assert
    assertSame(pdTrueTypeFont.DEFAULT_FONT_MATRIX, pdTrueTypeFont.getFontMatrix());
  }

  /**
   * Test {@link PDFont#getFontMatrix()}.
   * <ul>
   *   <li>Then return array length is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix(); then return array length is three")
  void testGetFontMatrix_thenReturnArrayLengthIsThree() throws IOException {
    // Arrange and Act
    Matrix actualFontMatrix = (new PDMMType1Font(new COSDictionary())).getFontMatrix();

    // Assert
    float[][] values = actualFontMatrix.getValues();
    assertEquals(3, values.length);
    float[] floatArray = values[0];
    assertEquals(3, floatArray.length);
    float[] floatArray2 = values[1];
    assertEquals(3, floatArray2.length);
    assertEquals(4.8828125E-4f, actualFontMatrix.getScaleX());
    assertEquals(4.8828125E-4f, actualFontMatrix.getScaleY());
    assertEquals(4.8828125E-4f, actualFontMatrix.getScalingFactorX());
    assertEquals(4.8828125E-4f, actualFontMatrix.getScalingFactorY());
    assertEquals(4.8828125E-4f, floatArray[0]);
    assertEquals(4.8828125E-4f, floatArray2[1]);
  }

  /**
   * Test {@link PDFont#getSpaceWidth()}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getSpaceWidth()}
   */
  @Test
  @DisplayName("Test getSpaceWidth(); given PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetSpaceWidth_givenPDMMType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250.0f, (new PDMMType1Font(new COSDictionary())).getSpaceWidth());
  }

  /**
   * Test {@link PDFont#getSpaceWidth()}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getSpaceWidth()}
   */
  @Test
  @DisplayName("Test getSpaceWidth(); given PDMMType1Font(COSDictionary) with fontDictionary is COSStream()")
  void testGetSpaceWidth_givenPDMMType1FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250.0f, (new PDMMType1Font(new COSStream())).getSpaceWidth());
  }

  /**
   * Test {@link PDFont#isStandard14()}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#isStandard14()}
   */
  @Test
  @DisplayName("Test isStandard14(); given PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testIsStandard14_givenPDMMType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSDictionary())).isStandard14());
  }

  /**
   * Test {@link PDFont#isStandard14()}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#isStandard14()}
   */
  @Test
  @DisplayName("Test isStandard14(); given PDMMType1Font(COSDictionary) with fontDictionary is COSStream()")
  void testIsStandard14_givenPDMMType1FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSStream())).isStandard14());
  }

  /**
   * Test {@link PDFont#equals(Object)}, and {@link PDFont#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDFont#equals(Object)}
   *   <li>{@link PDFont#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());

    // Act and Assert
    assertEquals(pdmmType1Font, pdmmType1Font);
    int expectedHashCodeResult = pdmmType1Font.hashCode();
    assertEquals(expectedHashCodeResult, pdmmType1Font.hashCode());
  }

  /**
   * Test {@link PDFont#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());

    // Act and Assert
    assertNotEquals(pdmmType1Font, new PDMMType1Font(new COSDictionary()));
  }

  /**
   * Test {@link PDFont#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());
    PDTrueTypeFont pdTrueTypeFont = mock(PDTrueTypeFont.class);
    when(pdTrueTypeFont.getCOSObject()).thenReturn(new COSDictionary());

    // Act and Assert
    assertNotEquals(pdmmType1Font, pdTrueTypeFont);
  }

  /**
   * Test {@link PDFont#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then throw exception.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then throw exception")
  void testEquals_whenOtherIsDifferent_thenThrowException() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());
    PDTrueTypeFont pdTrueTypeFont = mock(PDTrueTypeFont.class);
    when(pdTrueTypeFont.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdmmType1Font.equals(pdTrueTypeFont));
  }

  /**
   * Test {@link PDFont#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() throws IOException {
    // Arrange, Act and Assert
    assertNotEquals(new PDMMType1Font(new COSDictionary()), null);
  }

  /**
   * Test {@link PDFont#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() throws IOException {
    // Arrange, Act and Assert
    assertNotEquals(new PDMMType1Font(new COSDictionary()), "Different type to PDFont");
  }

  /**
   * Test {@link PDFont#toString()}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#toString()}
   */
  @Test
  @DisplayName("Test toString(); given PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testToString_givenPDMMType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertEquals("PDMMType1Font null", (new PDMMType1Font(new COSDictionary())).toString());
  }

  /**
   * Test {@link PDFont#toString()}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#toString()}
   */
  @Test
  @DisplayName("Test toString(); given PDMMType1Font(COSDictionary) with fontDictionary is COSStream()")
  void testToString_givenPDMMType1FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertEquals("PDMMType1Font null", (new PDMMType1Font(new COSStream())).toString());
  }

  /**
   * Test {@link PDFont#getToUnicodeCMap()}.
   * <p>
   * Method under test: {@link PDFont#getToUnicodeCMap()}
   */
  @Test
  @DisplayName("Test getToUnicodeCMap()")
  void testGetToUnicodeCMap() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSDictionary())).getToUnicodeCMap());
  }
}
