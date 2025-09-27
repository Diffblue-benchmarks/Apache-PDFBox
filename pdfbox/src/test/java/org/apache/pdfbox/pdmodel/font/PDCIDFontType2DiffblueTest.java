package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDCIDFontType2DiffblueTest {
  /**
   * Test {@link PDCIDFontType2#PDCIDFontType2(COSDictionary, PDType0Font, TrueTypeFont)}.
   *
   * <ul>
   *   <li>Given {@link CmapSubtable} (default constructor).
   *   <li>Then return BaseFont is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType2#PDCIDFontType2(COSDictionary, PDType0Font,
   * TrueTypeFont)}
   */
  @Test
  @DisplayName(
      "Test new PDCIDFontType2(COSDictionary, PDType0Font, TrueTypeFont); given CmapSubtable (default constructor); then return BaseFont is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCIDFontType2.<init>(COSDictionary, PDType0Font, TrueTypeFont)"})
  void testNewPDCIDFontType2_givenCmapSubtable_thenReturnBaseFontIsNull() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    TrueTypeFont trueTypeFont = mock(TrueTypeFont.class);
    when(trueTypeFont.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());

    // Act
    PDCIDFontType2 actualPdcidFontType2 = new PDCIDFontType2(fontDictionary, null, trueTypeFont);

    // Assert
    verify(trueTypeFont).getUnicodeCmapLookup(false);
    assertNull(actualPdcidFontType2.getBaseFont());
    assertNull(actualPdcidFontType2.getName());
    assertNull(actualPdcidFontType2.getBoundingBox());
    assertNull(actualPdcidFontType2.getCIDSystemInfo());
    assertNull(actualPdcidFontType2.getFontDescriptor());
    assertNull(actualPdcidFontType2.getParent());
    assertEquals(1000.0f, actualPdcidFontType2.getAverageFontWidth());
    assertFalse(actualPdcidFontType2.isDamaged());
    assertTrue(actualPdcidFontType2.isEmbedded());
    assertSame(fontDictionary, actualPdcidFontType2.getCOSObject());
    assertSame(trueTypeFont, actualPdcidFontType2.getTrueTypeFont());
  }

  /**
   * Test {@link PDCIDFontType2#PDCIDFontType2(COSDictionary, PDType0Font, TrueTypeFont)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType2#PDCIDFontType2(COSDictionary, PDType0Font,
   * TrueTypeFont)}
   */
  @Test
  @DisplayName(
      "Test new PDCIDFontType2(COSDictionary, PDType0Font, TrueTypeFont); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCIDFontType2.<init>(COSDictionary, PDType0Font, TrueTypeFont)"})
  void testNewPDCIDFontType2_givenIOException_thenThrowIOException() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    TrueTypeFont trueTypeFont = mock(TrueTypeFont.class);
    when(trueTypeFont.getUnicodeCmapLookup(anyBoolean())).thenThrow(new IOException());

    // Act and Assert
    assertThrows(IOException.class, () -> new PDCIDFontType2(fontDictionary, null, trueTypeFont));
    verify(trueTypeFont).getUnicodeCmapLookup(false);
  }

  /**
   * Test {@link PDCIDFontType2#PDCIDFontType2(COSDictionary, PDType0Font)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return BaseFont is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType2#PDCIDFontType2(COSDictionary, PDType0Font)}
   */
  @Test
  @DisplayName(
      "Test new PDCIDFontType2(COSDictionary, PDType0Font); when COSDictionary(); then return BaseFont is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCIDFontType2.<init>(COSDictionary, PDType0Font)"})
  void testNewPDCIDFontType2_whenCOSDictionary_thenReturnBaseFontIsNull() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    // Act
    PDCIDFontType2 actualPdcidFontType2 = new PDCIDFontType2(fontDictionary, null);

    // Assert
    assertNull(actualPdcidFontType2.getBaseFont());
    assertNull(actualPdcidFontType2.getName());
    assertNull(actualPdcidFontType2.getCIDSystemInfo());
    assertNull(actualPdcidFontType2.getFontDescriptor());
    assertNull(actualPdcidFontType2.getParent());
    assertEquals(1000.0f, actualPdcidFontType2.getAverageFontWidth());
    assertFalse(actualPdcidFontType2.isDamaged());
    assertFalse(actualPdcidFontType2.isEmbedded());
    assertSame(fontDictionary, actualPdcidFontType2.getCOSObject());
  }

  /**
   * Test {@link PDCIDFontType2#getFontMatrix()}.
   *
   * <ul>
   *   <li>Then return ScaleX is {@code 0.001}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType2#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix(); then return ScaleX is '0.001'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix PDCIDFontType2.getFontMatrix()"})
  void testGetFontMatrix_thenReturnScaleXIs0001() throws IOException {
    // Arrange
    PDCIDFontType2 pdcidFontType2 = new PDCIDFontType2(new COSDictionary(), null);

    // Act
    Matrix actualFontMatrix = pdcidFontType2.getFontMatrix();

    // Assert
    assertEquals(0.001f, actualFontMatrix.getScaleX());
    assertEquals(0.001f, actualFontMatrix.getScaleY());
    assertEquals(0.001f, actualFontMatrix.getScalingFactorX());
    assertEquals(0.001f, actualFontMatrix.getScalingFactorY());
    assertEquals(0.0f, actualFontMatrix.getShearX());
    assertEquals(0.0f, actualFontMatrix.getShearY());
    assertEquals(0.0f, actualFontMatrix.getTranslateX());
    assertEquals(0.0f, actualFontMatrix.getTranslateY());
    float[][] values = actualFontMatrix.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDCIDFontType2#getBoundingBox()}.
   *
   * <ul>
   *   <li>Then return LowerLeftY is {@code -303.22266}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType2#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return LowerLeftY is '-303.22266'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDCIDFontType2.getBoundingBox()"})
  void testGetBoundingBox_thenReturnLowerLeftYIs30322266() throws IOException {
    // Arrange
    PDCIDFontType2 pdcidFontType2 = new PDCIDFontType2(new COSDictionary(), null);

    // Act
    BoundingBox actualBoundingBox = pdcidFontType2.getBoundingBox();

    // Assert
    assertEquals(-303.22266f, actualBoundingBox.getLowerLeftY());
    assertEquals(-543.9453f, actualBoundingBox.getLowerLeftX());
    assertEquals(1283.2031f, actualBoundingBox.getHeight());
    assertEquals(1301.7578f, actualBoundingBox.getUpperRightX());
    assertEquals(1845.7031f, actualBoundingBox.getWidth());
    assertEquals(979.98047f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Test {@link PDCIDFontType2#codeToCID(int)}.
   *
   * <ul>
   *   <li>Given {@link CMap} {@link CMap#hasCIDMappings()} return {@code true}.
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType2#codeToCID(int)}
   */
  @Test
  @DisplayName(
      "Test codeToCID(int); given CMap hasCIDMappings() return 'true'; when one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDCIDFontType2.codeToCID(int)"})
  void testCodeToCID_givenCMapHasCIDMappingsReturnTrue_whenOne_thenReturnOne() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.hasCIDMappings()).thenReturn(true);
    when(cMap.toCID(anyInt())).thenReturn(1);

    PDType0Font parent = mock(PDType0Font.class);
    when(parent.getCMap()).thenReturn(cMap);
    PDCIDFontType2 pdcidFontType2 = new PDCIDFontType2(new COSDictionary(), parent);

    // Act
    int actualCodeToCIDResult = pdcidFontType2.codeToCID(1);

    // Assert
    verify(cMap).hasCIDMappings();
    verify(cMap).toCID(1);
    verify(parent).getCMap();
    assertEquals(1, actualCodeToCIDResult);
  }

  /**
   * Test {@link PDCIDFontType2#codeToCID(int)}.
   *
   * <ul>
   *   <li>Given {@link CMap} {@link CMap#hasUnicodeMappings()} return {@code false}.
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType2#codeToCID(int)}
   */
  @Test
  @DisplayName(
      "Test codeToCID(int); given CMap hasUnicodeMappings() return 'false'; when one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDCIDFontType2.codeToCID(int)"})
  void testCodeToCID_givenCMapHasUnicodeMappingsReturnFalse_whenOne_thenReturnOne()
      throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.hasCIDMappings()).thenReturn(false);
    when(cMap.hasUnicodeMappings()).thenReturn(false);
    when(cMap.toCID(anyInt())).thenReturn(1);

    PDType0Font parent = mock(PDType0Font.class);
    when(parent.getCMap()).thenReturn(cMap);
    PDCIDFontType2 pdcidFontType2 = new PDCIDFontType2(new COSDictionary(), parent);

    // Act
    int actualCodeToCIDResult = pdcidFontType2.codeToCID(1);

    // Assert
    verify(cMap).hasCIDMappings();
    verify(cMap).hasUnicodeMappings();
    verify(cMap).toCID(1);
    verify(parent).getCMap();
    assertEquals(1, actualCodeToCIDResult);
  }

  /**
   * Test {@link PDCIDFontType2#codeToCID(int)}.
   *
   * <ul>
   *   <li>Given {@link CMap} {@link CMap#toUnicode(int)} return {@code null}.
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType2#codeToCID(int)}
   */
  @Test
  @DisplayName(
      "Test codeToCID(int); given CMap toUnicode(int) return 'null'; when one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDCIDFontType2.codeToCID(int)"})
  void testCodeToCID_givenCMapToUnicodeReturnNull_whenOne_thenReturnOne() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toUnicode(anyInt())).thenReturn(null);
    when(cMap.hasCIDMappings()).thenReturn(false);
    when(cMap.hasUnicodeMappings()).thenReturn(true);
    when(cMap.toCID(anyInt())).thenReturn(1);

    PDType0Font parent = mock(PDType0Font.class);
    when(parent.getCMap()).thenReturn(cMap);
    PDCIDFontType2 pdcidFontType2 = new PDCIDFontType2(new COSDictionary(), parent);

    // Act
    int actualCodeToCIDResult = pdcidFontType2.codeToCID(1);

    // Assert
    verify(cMap).hasCIDMappings();
    verify(cMap).hasUnicodeMappings();
    verify(cMap).toCID(1);
    verify(cMap).toUnicode(1);
    verify(parent).getCMap();
    assertEquals(1, actualCodeToCIDResult);
  }

  /**
   * Test {@link PDCIDFontType2#codeToCID(int)}.
   *
   * <ul>
   *   <li>Given {@link CMap} {@link CMap#toUnicode(int)} return {@code Unicode}.
   *   <li>When one.
   *   <li>Then return eighty-five.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType2#codeToCID(int)}
   */
  @Test
  @DisplayName(
      "Test codeToCID(int); given CMap toUnicode(int) return 'Unicode'; when one; then return eighty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDCIDFontType2.codeToCID(int)"})
  void testCodeToCID_givenCMapToUnicodeReturnUnicode_whenOne_thenReturnEightyFive()
      throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toUnicode(anyInt())).thenReturn("Unicode");
    when(cMap.hasCIDMappings()).thenReturn(false);
    when(cMap.hasUnicodeMappings()).thenReturn(true);

    PDType0Font parent = mock(PDType0Font.class);
    when(parent.getCMap()).thenReturn(cMap);
    PDCIDFontType2 pdcidFontType2 = new PDCIDFontType2(new COSDictionary(), parent);

    // Act
    int actualCodeToCIDResult = pdcidFontType2.codeToCID(1);

    // Assert
    verify(cMap).hasCIDMappings();
    verify(cMap).hasUnicodeMappings();
    verify(cMap).toUnicode(1);
    verify(parent).getCMap();
    assertEquals(85, actualCodeToCIDResult);
  }

  /**
   * Test {@link PDCIDFontType2#codeToCID(int)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType2#codeToCID(int)}
   */
  @Test
  @DisplayName("Test codeToCID(int); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDCIDFontType2.codeToCID(int)"})
  void testCodeToCID_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toUnicode(anyInt())).thenThrow(new IllegalArgumentException());
    when(cMap.hasCIDMappings()).thenReturn(false);
    when(cMap.hasUnicodeMappings()).thenReturn(true);

    PDType0Font parent = mock(PDType0Font.class);
    when(parent.getCMap()).thenReturn(cMap);
    PDCIDFontType2 pdcidFontType2 = new PDCIDFontType2(new COSDictionary(), parent);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdcidFontType2.codeToCID(1));
    verify(cMap).hasCIDMappings();
    verify(cMap).hasUnicodeMappings();
    verify(cMap).toUnicode(1);
    verify(parent).getCMap();
  }

  /**
   * Test {@link PDCIDFontType2#codeToGID(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#toUnicode(int)} return {@code Unicode}.
   *   <li>When one.
   *   <li>Then return fifty-six.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType2#codeToGID(int)}
   */
  @Test
  @DisplayName(
      "Test codeToGID(int); given PDType0Font toUnicode(int) return 'Unicode'; when one; then return fifty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDCIDFontType2.codeToGID(int)"})
  void testCodeToGID_givenPDType0FontToUnicodeReturnUnicode_whenOne_thenReturnFiftySix()
      throws IOException {
    // Arrange
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn("Unicode");
    PDCIDFontType2 pdcidFontType2 = new PDCIDFontType2(new COSDictionary(), parent);

    // Act
    int actualCodeToGIDResult = pdcidFontType2.codeToGID(1);

    // Assert
    verify(parent).toUnicode(1);
    assertEquals(56, actualCodeToGIDResult);
  }

  /**
   * Test {@link PDCIDFontType2#getHeight(int)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType2#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDCIDFontType2.getHeight(int)"})
  void testGetHeight_thenReturnOne() throws IOException {
    // Arrange
    PDCIDFontType2 pdcidFontType2 = new PDCIDFontType2(new COSDictionary(), null);

    // Act and Assert
    assertEquals(1.0f, pdcidFontType2.getHeight(1));
  }

  /**
   * Test {@link PDCIDFontType2#getWidthFromFont(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#toUnicode(int)} return {@code Unicode}.
   *   <li>Then return {@code 722.16797}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType2#getWidthFromFont(int)}
   */
  @Test
  @DisplayName(
      "Test getWidthFromFont(int); given PDType0Font toUnicode(int) return 'Unicode'; then return '722.16797'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDCIDFontType2.getWidthFromFont(int)"})
  void testGetWidthFromFont_givenPDType0FontToUnicodeReturnUnicode_thenReturn72216797()
      throws IOException {
    // Arrange
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn("Unicode");
    PDCIDFontType2 pdcidFontType2 = new PDCIDFontType2(new COSDictionary(), parent);

    // Act
    float actualWidthFromFont = pdcidFontType2.getWidthFromFont(1);

    // Assert
    verify(parent).toUnicode(1);
    assertEquals(722.16797f, actualWidthFromFont);
  }

  /**
   * Test {@link PDCIDFontType2#encode(int)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with three and minus one hundred three.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType2#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int); then return array of byte with three and minus one hundred three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDCIDFontType2.encode(int)"})
  void testEncode_thenReturnArrayOfByteWithThreeAndMinusOneHundredThree() throws IOException {
    // Arrange
    PDCIDFontType2 pdcidFontType2 = new PDCIDFontType2(new COSDictionary(), null);

    // Act and Assert
    assertArrayEquals(new byte[] {3, -103}, pdcidFontType2.encode(1000));
  }

  /**
   * Test {@link PDCIDFontType2#encode(int)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType2#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDCIDFontType2.encode(int)"})
  void testEncode_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    PDCIDFontType2 pdcidFontType2 = new PDCIDFontType2(new COSDictionary(), null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdcidFontType2.encode(1));
  }

  /**
   * Test {@link PDCIDFontType2#encodeGlyphId(int)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with zero and one.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType2#encodeGlyphId(int)}
   */
  @Test
  @DisplayName("Test encodeGlyphId(int); then return array of byte with zero and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDCIDFontType2.encodeGlyphId(int)"})
  void testEncodeGlyphId_thenReturnArrayOfByteWithZeroAndOne() throws IOException {
    // Arrange
    PDCIDFontType2 pdcidFontType2 = new PDCIDFontType2(new COSDictionary(), null);

    // Act and Assert
    assertArrayEquals(new byte[] {0, 1}, pdcidFontType2.encodeGlyphId(1));
  }

  /**
   * Test {@link PDCIDFontType2#getPath(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#toUnicode(int)} return {@code Unicode}.
   *   <li>Then CurrentPoint return {@link Float}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType2#getPath(int)}
   */
  @Test
  @DisplayName(
      "Test getPath(int); given PDType0Font toUnicode(int) return 'Unicode'; then CurrentPoint return Float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDCIDFontType2.getPath(int)"})
  void testGetPath_givenPDType0FontToUnicodeReturnUnicode_thenCurrentPointReturnFloat()
      throws IOException {
    // Arrange
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn("Unicode");
    PDCIDFontType2 pdcidFontType2 = new PDCIDFontType2(new COSDictionary(), parent);

    // Act
    GeneralPath actualPath = pdcidFontType2.getPath(1);

    // Assert
    verify(parent).toUnicode(1);
    assertTrue(actualPath.getCurrentPoint() instanceof Float);
    assertTrue(actualPath.getBounds2D() instanceof Rectangle2D.Float);
    assertEquals(1, actualPath.getWindingRule());
  }

  /**
   * Test {@link PDCIDFontType2#getNormalizedPath(int)}.
   *
   * <ul>
   *   <li>Then CurrentPoint return {@link Float}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType2#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); then CurrentPoint return Float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDCIDFontType2.getNormalizedPath(int)"})
  void testGetNormalizedPath_thenCurrentPointReturnFloat() throws IOException {
    // Arrange
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn("Unicode");
    PDCIDFontType2 pdcidFontType2 = new PDCIDFontType2(new COSDictionary(), parent);

    // Act
    GeneralPath actualNormalizedPath = pdcidFontType2.getNormalizedPath(1);

    // Assert
    verify(parent, atLeast(1)).toUnicode(1);
    assertTrue(actualNormalizedPath.getCurrentPoint() instanceof Float);
    assertTrue(actualNormalizedPath.getBounds2D() instanceof Rectangle2D.Float);
    assertEquals(1, actualNormalizedPath.getWindingRule());
  }
}
