package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.Map;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.TTFTable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.ttf.model.MapBackedGsubData;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDCIDFontType0DiffblueTest {
  /**
   * Test {@link PDCIDFontType0#PDCIDFontType0(COSDictionary, PDType0Font)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then FontBoxFont return {@link TrueTypeFont}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType0#PDCIDFontType0(COSDictionary, PDType0Font)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType0(COSDictionary, PDType0Font); when COSDictionary(); then FontBoxFont return TrueTypeFont")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDCIDFontType0.<init>(COSDictionary, PDType0Font)"})
  void testNewPDCIDFontType0_whenCOSDictionary_thenFontBoxFontReturnTrueTypeFont() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    // Act
    PDCIDFontType0 actualPdcidFontType0 = new PDCIDFontType0(fontDictionary, null);

    // Assert
    assertTrue(actualPdcidFontType0.getFontBoxFont() instanceof TrueTypeFont);
    assertNull(actualPdcidFontType0.getBaseFont());
    assertNull(actualPdcidFontType0.getName());
    assertNull(actualPdcidFontType0.getCFFFont());
    assertNull(actualPdcidFontType0.getCIDSystemInfo());
    assertNull(actualPdcidFontType0.getFontDescriptor());
    assertNull(actualPdcidFontType0.getParent());
    assertEquals(500.0f, actualPdcidFontType0.getAverageFontWidth());
    assertFalse(actualPdcidFontType0.isDamaged());
    assertFalse(actualPdcidFontType0.isEmbedded());
    assertSame(fontDictionary, actualPdcidFontType0.getCOSObject());
  }

  /**
   * Test {@link PDCIDFontType0#getFontMatrix()}.
   * <ul>
   *   <li>Then return ShearX is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType0#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix(); then return ShearX is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Matrix PDCIDFontType0.getFontMatrix()"})
  void testGetFontMatrix_thenReturnShearXIsZero() throws IOException {
    // Arrange and Act
    Matrix actualFontMatrix = (new PDCIDFontType0(new COSDictionary(), null)).getFontMatrix();

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
   * Test {@link PDCIDFontType0#getBoundingBox()}.
   * <ul>
   *   <li>Then return LowerLeftY is {@code -303.22266}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType0#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return LowerLeftY is '-303.22266'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BoundingBox PDCIDFontType0.getBoundingBox()"})
  void testGetBoundingBox_thenReturnLowerLeftYIs30322266() throws IOException {
    // Arrange and Act
    BoundingBox actualBoundingBox = (new PDCIDFontType0(new COSDictionary(), null)).getBoundingBox();

    // Assert
    assertEquals(-303.22266f, actualBoundingBox.getLowerLeftY());
    assertEquals(-543.9453f, actualBoundingBox.getLowerLeftX());
    assertEquals(1283.2031f, actualBoundingBox.getHeight());
    assertEquals(1301.7578f, actualBoundingBox.getUpperRightX());
    assertEquals(1845.7031f, actualBoundingBox.getWidth());
    assertEquals(979.98047f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Test {@link PDCIDFontType0#getCFFFont()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType0#getCFFFont()}
   */
  @Test
  @DisplayName("Test getCFFFont(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.cff.CFFFont PDCIDFontType0.getCFFFont()"})
  void testGetCFFFont_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSDictionary(), null)).getCFFFont());
  }

  /**
   * Test {@link PDCIDFontType0#getFontBoxFont()}.
   * <ul>
   *   <li>Then UnicodeCmapLookup return {@link CmapSubtable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType0#getFontBoxFont()}
   */
  @Test
  @DisplayName("Test getFontBoxFont(); then UnicodeCmapLookup return CmapSubtable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FontBoxFont PDCIDFontType0.getFontBoxFont()"})
  void testGetFontBoxFont_thenUnicodeCmapLookupReturnCmapSubtable() throws IOException {
    // Arrange and Act
    FontBoxFont actualFontBoxFont = (new PDCIDFontType0(new COSDictionary(), null)).getFontBoxFont();

    // Assert
    assertTrue(((TrueTypeFont) actualFontBoxFont).getUnicodeCmapLookup() instanceof CmapSubtable);
    assertTrue(actualFontBoxFont instanceof TrueTypeFont);
    assertTrue(((TrueTypeFont) actualFontBoxFont).getGsubData() instanceof MapBackedGsubData);
    assertEquals("LiberationSans", actualFontBoxFont.getName());
    assertNull(((TrueTypeFont) actualFontBoxFont).getVerticalHeader());
    assertNull(((TrueTypeFont) actualFontBoxFont).getVerticalMetrics());
    assertNull(((TrueTypeFont) actualFontBoxFont).getVerticalOrigin());
    assertEquals(1.0f, ((TrueTypeFont) actualFontBoxFont).getVersion());
    assertEquals(19, ((TrueTypeFont) actualFontBoxFont).getTables().size());
    Map<String, TTFTable> tableMap = ((TrueTypeFont) actualFontBoxFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(2048, ((TrueTypeFont) actualFontBoxFont).getUnitsPerEm());
    assertEquals(2620, ((TrueTypeFont) actualFontBoxFont).getNumberOfGlyphs());
    assertEquals(410712L, ((TrueTypeFont) actualFontBoxFont).getOriginalDataSize());
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) actualFontBoxFont).getOriginalData().read(byteArray));
    assertEquals(6, actualFontBoxFont.getFontMatrix().size());
    assertTrue(tableMap.containsKey("GPOS"));
    assertTrue(tableMap.containsKey("OS/2"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("gasp"));
    assertTrue(tableMap.containsKey("glyf"));
    assertTrue(tableMap.containsKey("kern"));
    assertTrue(((TrueTypeFont) actualFontBoxFont).isEnableGsub());
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', -127, -7, 28, -79, 0, 6,
        'D', '<', 0, 0, 0, 28, 'G', 'D', 'E', 'F', -30, '?', -20, 16, 0, 5, 14, 'T', 0, 0, 1, '*', 'G', 'P', 'O', 'S',
        -14, -32, 14}, byteArray);
  }

  /**
   * Test {@link PDCIDFontType0#getType2CharString(int)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType0#getType2CharString(int)}
   */
  @Test
  @DisplayName("Test getType2CharString(int); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.fontbox.cff.Type2CharString PDCIDFontType0.getType2CharString(int)"})
  void testGetType2CharString_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSDictionary(), null)).getType2CharString(1));
  }

  /**
   * Test {@link PDCIDFontType0#getPath(int)}.
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#toUnicode(int)} return {@code null}.</li>
   *   <li>Then CurrentPoint return {@link Point2D.Float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType0#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int); given PDType0Font toUnicode(int) return 'null'; then CurrentPoint return Float")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDCIDFontType0.getPath(int)"})
  void testGetPath_givenPDType0FontToUnicodeReturnNull_thenCurrentPointReturnFloat() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn(null);
    when(parent.getCMap()).thenReturn(cMap);

    // Act
    GeneralPath actualPath = (new PDCIDFontType0(new COSDictionary(), parent)).getPath(1);

    // Assert
    verify(cMap).toCID(eq(1));
    verify(parent).getCMap();
    verify(parent).toUnicode(eq(1));
    assertTrue(actualPath.getCurrentPoint() instanceof Float);
    assertTrue(actualPath.getBounds2D() instanceof Rectangle2D.Float);
  }

  /**
   * Test {@link PDCIDFontType0#getPath(int)}.
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#toUnicode(int)} return {@code Unicode}.</li>
   *   <li>Then CurrentPoint return {@link Point2D.Float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType0#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int); given PDType0Font toUnicode(int) return 'Unicode'; then CurrentPoint return Float")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDCIDFontType0.getPath(int)"})
  void testGetPath_givenPDType0FontToUnicodeReturnUnicode_thenCurrentPointReturnFloat() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn("Unicode");
    when(parent.getCMap()).thenReturn(cMap);

    // Act
    GeneralPath actualPath = (new PDCIDFontType0(new COSDictionary(), parent)).getPath(1);

    // Assert
    verify(cMap).toCID(eq(1));
    verify(parent).getCMap();
    verify(parent).toUnicode(eq(1));
    assertTrue(actualPath.getCurrentPoint() instanceof Float);
    assertTrue(actualPath.getBounds2D() instanceof Rectangle2D.Float);
  }

  /**
   * Test {@link PDCIDFontType0#getNormalizedPath(int)}.
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#toUnicode(int)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType0#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); given PDType0Font toUnicode(int) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDCIDFontType0.getNormalizedPath(int)"})
  void testGetNormalizedPath_givenPDType0FontToUnicodeReturnNull() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn(null);
    when(parent.getCMap()).thenReturn(cMap);

    // Act
    GeneralPath actualNormalizedPath = (new PDCIDFontType0(new COSDictionary(), parent)).getNormalizedPath(1);

    // Assert
    verify(cMap).toCID(eq(1));
    verify(parent).getCMap();
    verify(parent).toUnicode(eq(1));
    assertTrue(actualNormalizedPath.getCurrentPoint() instanceof Float);
    assertTrue(actualNormalizedPath.getBounds2D() instanceof Rectangle2D.Float);
  }

  /**
   * Test {@link PDCIDFontType0#getNormalizedPath(int)}.
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#toUnicode(int)} return {@code Unicode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType0#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); given PDType0Font toUnicode(int) return 'Unicode'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDCIDFontType0.getNormalizedPath(int)"})
  void testGetNormalizedPath_givenPDType0FontToUnicodeReturnUnicode() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn("Unicode");
    when(parent.getCMap()).thenReturn(cMap);

    // Act
    GeneralPath actualNormalizedPath = (new PDCIDFontType0(new COSDictionary(), parent)).getNormalizedPath(1);

    // Assert
    verify(cMap).toCID(eq(1));
    verify(parent).getCMap();
    verify(parent).toUnicode(eq(1));
    assertTrue(actualNormalizedPath.getCurrentPoint() instanceof Float);
    assertTrue(actualNormalizedPath.getBounds2D() instanceof Rectangle2D.Float);
  }

  /**
   * Test {@link PDCIDFontType0#hasGlyph(int)}.
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#toUnicode(int)} return {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType0#hasGlyph(int)}
   */
  @Test
  @DisplayName("Test hasGlyph(int); given PDType0Font toUnicode(int) return 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDCIDFontType0.hasGlyph(int)"})
  void testHasGlyph_givenPDType0FontToUnicodeReturnNull_thenReturnFalse() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn(null);
    when(parent.getCMap()).thenReturn(cMap);

    // Act
    boolean actualHasGlyphResult = (new PDCIDFontType0(new COSDictionary(), parent)).hasGlyph(1);

    // Assert
    verify(cMap).toCID(eq(1));
    verify(parent).getCMap();
    verify(parent).toUnicode(eq(1));
    assertFalse(actualHasGlyphResult);
  }

  /**
   * Test {@link PDCIDFontType0#hasGlyph(int)}.
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#toUnicode(int)} return {@code Unicode}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType0#hasGlyph(int)}
   */
  @Test
  @DisplayName("Test hasGlyph(int); given PDType0Font toUnicode(int) return 'Unicode'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDCIDFontType0.hasGlyph(int)"})
  void testHasGlyph_givenPDType0FontToUnicodeReturnUnicode_thenReturnTrue() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn("Unicode");
    when(parent.getCMap()).thenReturn(cMap);

    // Act
    boolean actualHasGlyphResult = (new PDCIDFontType0(new COSDictionary(), parent)).hasGlyph(1);

    // Assert
    verify(cMap).toCID(eq(1));
    verify(parent).getCMap();
    verify(parent).toUnicode(eq(1));
    assertTrue(actualHasGlyphResult);
  }

  /**
   * Test {@link PDCIDFontType0#codeToCID(int)}.
   * <ul>
   *   <li>Given {@link CMap} {@link CMap#toCID(int)} return one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType0#codeToCID(int)}
   */
  @Test
  @DisplayName("Test codeToCID(int); given CMap toCID(int) return one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDCIDFontType0.codeToCID(int)"})
  void testCodeToCID_givenCMapToCIDReturnOne_thenReturnOne() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.getCMap()).thenReturn(cMap);

    // Act
    int actualCodeToCIDResult = (new PDCIDFontType0(new COSDictionary(), parent)).codeToCID(1);

    // Assert
    verify(cMap).toCID(eq(1));
    verify(parent).getCMap();
    assertEquals(1, actualCodeToCIDResult);
  }

  /**
   * Test {@link PDCIDFontType0#codeToGID(int)}.
   * <ul>
   *   <li>Given {@link CMap} {@link CMap#toCID(int)} return one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType0#codeToGID(int)}
   */
  @Test
  @DisplayName("Test codeToGID(int); given CMap toCID(int) return one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDCIDFontType0.codeToGID(int)"})
  void testCodeToGID_givenCMapToCIDReturnOne_thenReturnOne() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.getCMap()).thenReturn(cMap);

    // Act
    int actualCodeToGIDResult = (new PDCIDFontType0(new COSDictionary(), parent)).codeToGID(1);

    // Assert
    verify(cMap).toCID(eq(1));
    verify(parent).getCMap();
    assertEquals(1, actualCodeToGIDResult);
  }

  /**
   * Test {@link PDCIDFontType0#encode(int)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType0#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDCIDFontType0.encode(int)"})
  void testEncode_thenThrowUnsupportedOperationException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDCIDFontType0(new COSDictionary(), null)).encode(1));
  }

  /**
   * Test {@link PDCIDFontType0#encodeGlyphId(int)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType0#encodeGlyphId(int)}
   */
  @Test
  @DisplayName("Test encodeGlyphId(int); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDCIDFontType0.encodeGlyphId(int)"})
  void testEncodeGlyphId_thenThrowUnsupportedOperationException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDCIDFontType0(new COSDictionary(), null)).encodeGlyphId(1));
  }

  /**
   * Test {@link PDCIDFontType0#getWidthFromFont(int)}.
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#toUnicode(int)} return {@code Unicode}.</li>
   *   <li>Then return {@code 722.16797}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType0#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int); given PDType0Font toUnicode(int) return 'Unicode'; then return '722.16797'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDCIDFontType0.getWidthFromFont(int)"})
  void testGetWidthFromFont_givenPDType0FontToUnicodeReturnUnicode_thenReturn72216797() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn("Unicode");
    when(parent.getCMap()).thenReturn(cMap);

    // Act
    float actualWidthFromFont = (new PDCIDFontType0(new COSDictionary(), parent)).getWidthFromFont(1);

    // Assert
    verify(cMap).toCID(eq(1));
    verify(parent).getCMap();
    verify(parent).toUnicode(eq(1));
    assertEquals(722.16797f, actualWidthFromFont);
  }

  /**
   * Test {@link PDCIDFontType0#getWidthFromFont(int)}.
   * <ul>
   *   <li>Then return seven hundred fifty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType0#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int); then return seven hundred fifty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDCIDFontType0.getWidthFromFont(int)"})
  void testGetWidthFromFont_thenReturnSevenHundredFifty() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn(null);
    when(parent.getCMap()).thenReturn(cMap);

    // Act
    float actualWidthFromFont = (new PDCIDFontType0(new COSDictionary(), parent)).getWidthFromFont(1);

    // Assert
    verify(cMap).toCID(eq(1));
    verify(parent).getCMap();
    verify(parent).toUnicode(eq(1));
    assertEquals(750.0f, actualWidthFromFont);
  }

  /**
   * Test {@link PDCIDFontType0#getAverageFontWidth()}.
   * <ul>
   *   <li>Then return five hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType0#getAverageFontWidth()}
   */
  @Test
  @DisplayName("Test getAverageFontWidth(); then return five hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDCIDFontType0.getAverageFontWidth()"})
  void testGetAverageFontWidth_thenReturnFiveHundred() throws IOException {
    // Arrange, Act and Assert
    assertEquals(500.0f, (new PDCIDFontType0(new COSDictionary(), null)).getAverageFontWidth());
  }
}
