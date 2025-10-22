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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFontDiffblueTest {
  /**
   * Test {@link PDFont#getStandard14AFM()}.
   * <p>
   * Method under test: {@link PDFont#getStandard14AFM()}
   */
  @Test
  @DisplayName("Test getStandard14AFM()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.afm.FontMetrics PDFont.getStandard14AFM()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFontDescriptor PDFont.getFontDescriptor()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFont.setFontDescriptor(PDFontDescriptor)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.cmap.CMap PDFont.readCMap(COSBase)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary PDFont.getCOSObject()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Vector PDFont.getPositionVector(int)"})
  void testGetPositionVector() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDMMType1Font(new COSDictionary())).getPositionVector(1));
  }

  /**
   * Test {@link PDFont#getDisplacement(int)}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getDisplacement(int)}
   */
  @Test
  @DisplayName("Test getDisplacement(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Vector PDFont.getDisplacement(int)"})
  void testGetDisplacement_whenOne() throws IOException {
    // Arrange and Act
    Vector actualDisplacement = (new PDMMType1Font(new COSDictionary())).getDisplacement(1);

    // Assert
    assertEquals(0.0f, actualDisplacement.getY());
    assertEquals(0.25f, actualDisplacement.getX());
  }

  /**
   * Test {@link PDFont#getDisplacement(int)}.
   * <ul>
   *   <li>When {@link Integer#SIZE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getDisplacement(int)}
   */
  @Test
  @DisplayName("Test getDisplacement(int); when SIZE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Vector PDFont.getDisplacement(int)"})
  void testGetDisplacement_whenSize() throws IOException {
    // Arrange and Act
    Vector actualDisplacement = (new PDMMType1Font(new COSDictionary())).getDisplacement(Integer.SIZE);

    // Assert
    assertEquals(0.0f, actualDisplacement.getY());
    assertEquals(0.25f, actualDisplacement.getX());
  }

  /**
   * Test {@link PDFont#getWidth(int)}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getWidth(int)}
   */
  @Test
  @DisplayName("Test getWidth(int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDFont.getWidth(int)"})
  void testGetWidth_whenOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250.0f, (new PDMMType1Font(new COSDictionary())).getWidth(1));
  }

  /**
   * Test {@link PDFont#getWidth(int)}.
   * <ul>
   *   <li>When {@link Integer#SIZE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getWidth(int)}
   */
  @Test
  @DisplayName("Test getWidth(int); when SIZE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDFont.getWidth(int)"})
  void testGetWidth_whenSize() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250.0f, (new PDMMType1Font(new COSDictionary())).getWidth(Integer.SIZE));
  }

  /**
   * Test {@link PDFont#encode(String)} with {@code String}.
   * <ul>
   *   <li>When {@code Identity}.</li>
   *   <li>Then return {@code Identity} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#encode(String)}
   */
  @Test
  @DisplayName("Test encode(String) with 'String'; when 'Identity'; then return 'Identity' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDFont.encode(String)"})
  void testEncodeWithString_whenIdentity_thenReturnIdentityBytesIsUtf8() throws IOException {
    // Arrange and Act
    byte[] actualEncodeResult = (new PDMMType1Font(new COSDictionary())).encode("Identity");

    // Assert
    assertArrayEquals("Identity".getBytes("UTF-8"), actualEncodeResult);
  }

  /**
   * Test {@link PDFont#encode(String)} with {@code String}.
   * <ul>
   *   <li>When {@code Identity-}.</li>
   *   <li>Then return {@code Identity-} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#encode(String)}
   */
  @Test
  @DisplayName("Test encode(String) with 'String'; when 'Identity-'; then return 'Identity-' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDFont.encode(String)"})
  void testEncodeWithString_whenIdentity_thenReturnIdentityBytesIsUtf82() throws IOException {
    // Arrange and Act
    byte[] actualEncodeResult = (new PDMMType1Font(new COSDictionary())).encode("Identity-");

    // Assert
    assertArrayEquals("Identity-".getBytes("UTF-8"), actualEncodeResult);
  }

  /**
   * Test {@link PDFont#encode(String)} with {@code String}.
   * <ul>
   *   <li>When {@code Text}.</li>
   *   <li>Then return {@code Text} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#encode(String)}
   */
  @Test
  @DisplayName("Test encode(String) with 'String'; when 'Text'; then return 'Text' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDFont.encode(String)"})
  void testEncodeWithString_whenText_thenReturnTextBytesIsUtf8() throws IOException {
    // Arrange and Act
    byte[] actualEncodeResult = (new PDMMType1Font(new COSDictionary())).encode("Text");

    // Assert
    assertArrayEquals("Text".getBytes("UTF-8"), actualEncodeResult);
  }

  /**
   * Test {@link PDFont#getStringWidth(String)}.
   * <ul>
   *   <li>When {@code Identity}.</li>
   *   <li>Then return {@code 3110.3516}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getStringWidth(String)}
   */
  @Test
  @DisplayName("Test getStringWidth(String); when 'Identity'; then return '3110.3516'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDFont.getStringWidth(String)"})
  void testGetStringWidth_whenIdentity_thenReturn31103516() throws IOException {
    // Arrange, Act and Assert
    assertEquals(3110.3516f, (new PDMMType1Font(new COSDictionary())).getStringWidth("Identity"));
  }

  /**
   * Test {@link PDFont#getStringWidth(String)}.
   * <ul>
   *   <li>When {@code Identity-}.</li>
   *   <li>Then return {@code 3443.3594}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getStringWidth(String)}
   */
  @Test
  @DisplayName("Test getStringWidth(String); when 'Identity-'; then return '3443.3594'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDFont.getStringWidth(String)"})
  void testGetStringWidth_whenIdentity_thenReturn34433594() throws IOException {
    // Arrange, Act and Assert
    assertEquals(3443.3594f, (new PDMMType1Font(new COSDictionary())).getStringWidth("Identity-"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDFont.getStringWidth(String)"})
  void testGetStringWidth_whenText_thenReturn18325195() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1832.5195f, (new PDMMType1Font(new COSDictionary())).getStringWidth("Text"));
  }

  /**
   * Test {@link PDFont#getAverageFontWidth()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#getAverageFontWidth()}
   */
  @Test
  @DisplayName("Test getAverageFontWidth(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDFont.getAverageFontWidth()"})
  void testGetAverageFontWidth_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDTrueTypeFont(new COSDictionary())).getAverageFontWidth());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDFont.toUnicode(int)"})
  void testToUnicodeWithCode_whenFortySix_thenReturnDot() throws IOException {
    // Arrange, Act and Assert
    assertEquals(".", (new PDMMType1Font(new COSDictionary())).toUnicode(46));
  }

  /**
   * Test {@link PDFont#toUnicode(int)} with {@code code}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFont#toUnicode(int)}
   */
  @Test
  @DisplayName("Test toUnicode(int) with 'code'; when one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDFont.toUnicode(int)"})
  void testToUnicodeWithCode_whenOne_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSDictionary())).toUnicode(1));
  }

  /**
   * Test {@link PDFont#getType()}.
   * <p>
   * Method under test: {@link PDFont#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDFont.getType()"})
  void testGetType() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSDictionary())).getType());
  }

  /**
   * Test {@link PDFont#getSubType()}.
   * <p>
   * Method under test: {@link PDFont#getSubType()}
   */
  @Test
  @DisplayName("Test getSubType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDFont.getSubType()"})
  void testGetSubType() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSDictionary())).getSubType());
  }

  /**
   * Test {@link PDFont#getWidths()}.
   * <p>
   * Method under test: {@link PDFont#getWidths()}
   */
  @Test
  @DisplayName("Test getWidths()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List PDFont.getWidths()"})
  void testGetWidths() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDMMType1Font(new COSDictionary())).getWidths().isEmpty());
  }

  /**
   * Test {@link PDFont#getFontMatrix()}.
   * <p>
   * Method under test: {@link PDFont#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Matrix PDFont.getFontMatrix()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Matrix PDFont.getFontMatrix()"})
  void testGetFontMatrix_thenReturnArrayLengthIsThree() throws IOException {
    // Arrange and Act
    Matrix actualFontMatrix = (new PDMMType1Font(new COSDictionary())).getFontMatrix();

    // Assert
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
   * Test {@link PDFont#getSpaceWidth()}.
   * <p>
   * Method under test: {@link PDFont#getSpaceWidth()}
   */
  @Test
  @DisplayName("Test getSpaceWidth()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDFont.getSpaceWidth()"})
  void testGetSpaceWidth() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250.0f, (new PDMMType1Font(new COSDictionary())).getSpaceWidth());
  }

  /**
   * Test {@link PDFont#isStandard14()}.
   * <p>
   * Method under test: {@link PDFont#isStandard14()}
   */
  @Test
  @DisplayName("Test isStandard14()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDFont.isStandard14()"})
  void testIsStandard14() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSDictionary())).isStandard14());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDFont.equals(Object)", "int PDFont.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDFont.equals(Object)", "int PDFont.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDFont.equals(Object)", "int PDFont.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDFont.equals(Object)", "int PDFont.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDFont.equals(Object)", "int PDFont.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDFont.equals(Object)", "int PDFont.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() throws IOException {
    // Arrange, Act and Assert
    assertNotEquals(new PDMMType1Font(new COSDictionary()), "Different type to PDFont");
  }

  /**
   * Test {@link PDFont#toString()}.
   * <p>
   * Method under test: {@link PDFont#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDFont.toString()"})
  void testToString() throws IOException {
    // Arrange, Act and Assert
    assertEquals("PDMMType1Font null", (new PDMMType1Font(new COSDictionary())).toString());
  }

  /**
   * Test {@link PDFont#getToUnicodeCMap()}.
   * <p>
   * Method under test: {@link PDFont#getToUnicodeCMap()}
   */
  @Test
  @DisplayName("Test getToUnicodeCMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.cmap.CMap PDFont.getToUnicodeCMap()"})
  void testGetToUnicodeCMap() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSDictionary())).getToUnicodeCMap());
  }
}
