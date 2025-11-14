package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
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
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PDCIDFontType0DiffblueTest {
  @Mock private BoundingBox boundingBox;

  @Mock private COSDictionary cOSDictionary;

  @Mock private Map<Integer, Float> map;

  @Mock private Matrix matrix;

  @InjectMocks private PDCIDFontType0 pDCIDFontType0;

  @Mock private PDFontDescriptor pDFontDescriptor;

  @Mock private PDType0Font pDType0Font;

  /**
   * Test {@link PDCIDFontType0#PDCIDFontType0(COSDictionary, PDType0Font)}.
   *
   * <ul>
   *   <li>Then return BaseFont is {@code Name As String}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#PDCIDFontType0(COSDictionary, PDType0Font)}
   */
  @Test
  @DisplayName(
      "Test new PDCIDFontType0(COSDictionary, PDType0Font); then return BaseFont is 'Name As String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCIDFontType0.<init>(COSDictionary, PDType0Font)"})
  void testNewPDCIDFontType0_thenReturnBaseFontIsNameAsString() throws IOException {
    // Arrange
    when(cOSDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(cOSDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    PDCIDFontType0 actualPdcidFontType0 = new PDCIDFontType0(cOSDictionary, pDType0Font);

    // Assert
    verify(cOSDictionary, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(cOSDictionary, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cOSDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    assertTrue(actualPdcidFontType0.getFontBoxFont() instanceof TrueTypeFont);
    assertEquals("Name As String", actualPdcidFontType0.getBaseFont());
    assertEquals("Name As String", actualPdcidFontType0.getName());
    assertNull(actualPdcidFontType0.getCFFFont());
    assertEquals(500.0f, actualPdcidFontType0.getAverageFontWidth());
    assertFalse(actualPdcidFontType0.isDamaged());
    assertFalse(actualPdcidFontType0.isEmbedded());
    assertSame(cOSDictionary, actualPdcidFontType0.getCOSObject());
    assertSame(pDType0Font, actualPdcidFontType0.getParent());
  }

  /**
   * Test {@link PDCIDFontType0#PDCIDFontType0(COSDictionary, PDType0Font)}.
   *
   * <ul>
   *   <li>Then return FontBoxFont TableMap size is nineteen.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#PDCIDFontType0(COSDictionary, PDType0Font)}
   */
  @Test
  @DisplayName(
      "Test new PDCIDFontType0(COSDictionary, PDType0Font); then return FontBoxFont TableMap size is nineteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCIDFontType0.<init>(COSDictionary, PDType0Font)"})
  void testNewPDCIDFontType0_thenReturnFontBoxFontTableMapSizeIsNineteen() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    // Act
    PDCIDFontType0 actualPdcidFontType0 = new PDCIDFontType0(fontDictionary, null);

    // Assert
    FontBoxFont fontBoxFont = actualPdcidFontType0.getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) fontBoxFont).getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, ((TrueTypeFont) fontBoxFont).getCmap().getCmaps().length);
    float[][] values = actualPdcidFontType0.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertTrue(tableMap.containsKey("fpgm"));
    assertSame(fontDictionary, actualPdcidFontType0.getCOSObject());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 4.8828125E-4f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {4.8828125E-4f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDCIDFontType0#PDCIDFontType0(COSDictionary, PDType0Font)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#PDCIDFontType0(COSDictionary, PDType0Font)}
   */
  @Test
  @DisplayName(
      "Test new PDCIDFontType0(COSDictionary, PDType0Font); when COSStream(); then return COSObject is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCIDFontType0.<init>(COSDictionary, PDType0Font)"})
  void testNewPDCIDFontType0_whenCOSStream_thenReturnCOSObjectIsCOSStream() throws IOException {
    // Arrange
    COSStream fontDictionary = new COSStream();

    // Act
    PDCIDFontType0 actualPdcidFontType0 = new PDCIDFontType0(fontDictionary, null);

    // Assert
    assertSame(fontDictionary, actualPdcidFontType0.getCOSObject());
  }

  /**
   * Test {@link PDCIDFontType0#getFontMatrix()}.
   *
   * <p>Method under test: {@link PDCIDFontType0#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix PDCIDFontType0.getFontMatrix()"})
  void testGetFontMatrix() throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSDictionary(), null);

    // Act
    Matrix actualFontMatrix = pdcidFontType0.getFontMatrix();

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

  /**
   * Test {@link PDCIDFontType0#getBoundingBox()}.
   *
   * <p>Method under test: {@link PDCIDFontType0#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDCIDFontType0.getBoundingBox()"})
  void testGetBoundingBox() throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSDictionary(), null);

    // Act
    BoundingBox actualBoundingBox = pdcidFontType0.getBoundingBox();

    // Assert
    assertEquals(-303.22266f, actualBoundingBox.getLowerLeftY());
    assertEquals(-543.9453f, actualBoundingBox.getLowerLeftX());
    assertEquals(1283.2031f, actualBoundingBox.getHeight());
    assertEquals(1301.7578f, actualBoundingBox.getUpperRightX());
    assertEquals(1845.7031f, actualBoundingBox.getWidth());
    assertEquals(979.98047f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Test {@link PDCIDFontType0#getBoundingBox()}.
   *
   * <p>Method under test: {@link PDCIDFontType0#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDCIDFontType0.getBoundingBox()"})
  void testGetBoundingBox2() throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSStream(), null);

    // Act
    BoundingBox actualBoundingBox = pdcidFontType0.getBoundingBox();

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
   *
   * <p>Method under test: {@link PDCIDFontType0#getCFFFont()}
   */
  @Test
  @DisplayName("Test getCFFFont()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.cff.CFFFont PDCIDFontType0.getCFFFont()"})
  void testGetCFFFont() throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSDictionary(), null);

    // Act and Assert
    assertNull(pdcidFontType0.getCFFFont());
  }

  /**
   * Test {@link PDCIDFontType0#getFontBoxFont()}.
   *
   * <p>Method under test: {@link PDCIDFontType0#getFontBoxFont()}
   */
  @Test
  @DisplayName("Test getFontBoxFont()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FontBoxFont PDCIDFontType0.getFontBoxFont()"})
  void testGetFontBoxFont() throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSDictionary(), null);

    // Act
    FontBoxFont actualFontBoxFont = pdcidFontType0.getFontBoxFont();

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
    assertArrayEquals(
        new byte[] {
          0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', -127, -7, 28, -79, 0, 6, 'D',
          '<', 0, 0, 0, 28, 'G', 'D', 'E', 'F', -30, '?', -20, 16, 0, 5, 14, 'T', 0, 0, 1, '*', 'G',
          'P', 'O', 'S', -14, -32, 14
        },
        byteArray);
  }

  /**
   * Test {@link PDCIDFontType0#getType2CharString(int)}.
   *
   * <p>Method under test: {@link PDCIDFontType0#getType2CharString(int)}
   */
  @Test
  @DisplayName("Test getType2CharString(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.fontbox.cff.Type2CharString PDCIDFontType0.getType2CharString(int)"
  })
  void testGetType2CharString() throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSDictionary(), null);

    // Act and Assert
    assertNull(pdcidFontType0.getType2CharString(1));
  }

  /**
   * Test {@link PDCIDFontType0#getPath(int)}.
   *
   * <ul>
   *   <li>Given {@link CMap} {@link CMap#toCID(int)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int); given CMap toCID(int) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDCIDFontType0.getPath(int)"})
  void testGetPath_givenCMapToCIDThrowUnsupportedOperationException() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenThrow(new UnsupportedOperationException());
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDCIDFontType0.getPath(1));
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
  }

  /**
   * Test {@link PDCIDFontType0#getPath(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#getCMap()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#getPath(int)}
   */
  @Test
  @DisplayName(
      "Test getPath(int); given PDType0Font getCMap() throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDCIDFontType0.getPath(int)"})
  void testGetPath_givenPDType0FontGetCMapThrowUnsupportedOperationException() throws IOException {
    // Arrange
    when(pDType0Font.getCMap()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDCIDFontType0.getPath(1));
    verify(pDType0Font).getCMap();
  }

  /**
   * Test {@link PDCIDFontType0#getPath(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#toUnicode(int)} return {@code null}.
   *   <li>Then CurrentPoint return {@link Point2D.Float}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#getPath(int)}
   */
  @Test
  @DisplayName(
      "Test getPath(int); given PDType0Font toUnicode(int) return 'null'; then CurrentPoint return Float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDCIDFontType0.getPath(int)"})
  void testGetPath_givenPDType0FontToUnicodeReturnNull_thenCurrentPointReturnFloat()
      throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.toUnicode(anyInt())).thenReturn(null);
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act
    GeneralPath actualPath = pDCIDFontType0.getPath(1);

    // Assert
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
    verify(pDType0Font).toUnicode(1);
    assertTrue(actualPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualPath.getBounds2D() instanceof Rectangle2D.Float);
  }

  /**
   * Test {@link PDCIDFontType0#getPath(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#toUnicode(int)} return {@code Unicode}.
   *   <li>Then CurrentPoint return {@link Point2D.Float}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#getPath(int)}
   */
  @Test
  @DisplayName(
      "Test getPath(int); given PDType0Font toUnicode(int) return 'Unicode'; then CurrentPoint return Float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDCIDFontType0.getPath(int)"})
  void testGetPath_givenPDType0FontToUnicodeReturnUnicode_thenCurrentPointReturnFloat()
      throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.toUnicode(anyInt())).thenReturn("Unicode");
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act
    GeneralPath actualPath = pDCIDFontType0.getPath(1);

    // Assert
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
    verify(pDType0Font).toUnicode(1);
    assertTrue(actualPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualPath.getBounds2D() instanceof Rectangle2D.Float);
  }

  /**
   * Test {@link PDCIDFontType0#getPath(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#toUnicode(int)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#getPath(int)}
   */
  @Test
  @DisplayName(
      "Test getPath(int); given PDType0Font toUnicode(int) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDCIDFontType0.getPath(int)"})
  void testGetPath_givenPDType0FontToUnicodeThrowUnsupportedOperationException()
      throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.toUnicode(anyInt())).thenThrow(new UnsupportedOperationException());
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDCIDFontType0.getPath(1));
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
    verify(pDType0Font).toUnicode(1);
  }

  /**
   * Test {@link PDCIDFontType0#getNormalizedPath(int)}.
   *
   * <p>Method under test: {@link PDCIDFontType0#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDCIDFontType0.getNormalizedPath(int)"})
  void testGetNormalizedPath() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.toUnicode(anyInt())).thenThrow(new UnsupportedOperationException());
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDCIDFontType0.getNormalizedPath(1));
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
    verify(pDType0Font).toUnicode(1);
  }

  /**
   * Test {@link PDCIDFontType0#getNormalizedPath(int)}.
   *
   * <ul>
   *   <li>Given {@link CMap} {@link CMap#toCID(int)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#getNormalizedPath(int)}
   */
  @Test
  @DisplayName(
      "Test getNormalizedPath(int); given CMap toCID(int) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDCIDFontType0.getNormalizedPath(int)"})
  void testGetNormalizedPath_givenCMapToCIDThrowUnsupportedOperationException() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenThrow(new UnsupportedOperationException());
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDCIDFontType0.getNormalizedPath(1));
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
  }

  /**
   * Test {@link PDCIDFontType0#getNormalizedPath(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#getCMap()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#getNormalizedPath(int)}
   */
  @Test
  @DisplayName(
      "Test getNormalizedPath(int); given PDType0Font getCMap() throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDCIDFontType0.getNormalizedPath(int)"})
  void testGetNormalizedPath_givenPDType0FontGetCMapThrowUnsupportedOperationException()
      throws IOException {
    // Arrange
    when(pDType0Font.getCMap()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDCIDFontType0.getNormalizedPath(1));
    verify(pDType0Font).getCMap();
  }

  /**
   * Test {@link PDCIDFontType0#getNormalizedPath(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#toUnicode(int)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); given PDType0Font toUnicode(int) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDCIDFontType0.getNormalizedPath(int)"})
  void testGetNormalizedPath_givenPDType0FontToUnicodeReturnNull() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.toUnicode(anyInt())).thenReturn(null);
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act
    GeneralPath actualNormalizedPath = pDCIDFontType0.getNormalizedPath(1);

    // Assert
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
    verify(pDType0Font).toUnicode(1);
    assertTrue(actualNormalizedPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualNormalizedPath.getBounds2D() instanceof Rectangle2D.Float);
  }

  /**
   * Test {@link PDCIDFontType0#getNormalizedPath(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#toUnicode(int)} return {@code Unicode}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); given PDType0Font toUnicode(int) return 'Unicode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GeneralPath PDCIDFontType0.getNormalizedPath(int)"})
  void testGetNormalizedPath_givenPDType0FontToUnicodeReturnUnicode() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.toUnicode(anyInt())).thenReturn("Unicode");
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act
    GeneralPath actualNormalizedPath = pDCIDFontType0.getNormalizedPath(1);

    // Assert
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
    verify(pDType0Font).toUnicode(1);
    assertTrue(actualNormalizedPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualNormalizedPath.getBounds2D() instanceof Rectangle2D.Float);
  }

  /**
   * Test {@link PDCIDFontType0#hasGlyph(int)}.
   *
   * <ul>
   *   <li>Given {@link CMap} {@link CMap#toCID(int)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#hasGlyph(int)}
   */
  @Test
  @DisplayName("Test hasGlyph(int); given CMap toCID(int) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDCIDFontType0.hasGlyph(int)"})
  void testHasGlyph_givenCMapToCIDThrowUnsupportedOperationException() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenThrow(new UnsupportedOperationException());
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDCIDFontType0.hasGlyph(1));
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
  }

  /**
   * Test {@link PDCIDFontType0#hasGlyph(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#getCMap()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#hasGlyph(int)}
   */
  @Test
  @DisplayName(
      "Test hasGlyph(int); given PDType0Font getCMap() throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDCIDFontType0.hasGlyph(int)"})
  void testHasGlyph_givenPDType0FontGetCMapThrowUnsupportedOperationException() throws IOException {
    // Arrange
    when(pDType0Font.getCMap()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDCIDFontType0.hasGlyph(1));
    verify(pDType0Font).getCMap();
  }

  /**
   * Test {@link PDCIDFontType0#hasGlyph(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#toUnicode(int)} return {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#hasGlyph(int)}
   */
  @Test
  @DisplayName(
      "Test hasGlyph(int); given PDType0Font toUnicode(int) return 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDCIDFontType0.hasGlyph(int)"})
  void testHasGlyph_givenPDType0FontToUnicodeReturnNull_thenReturnFalse() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.toUnicode(anyInt())).thenReturn(null);
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act
    boolean actualHasGlyphResult = pDCIDFontType0.hasGlyph(1);

    // Assert
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
    verify(pDType0Font).toUnicode(1);
    assertFalse(actualHasGlyphResult);
  }

  /**
   * Test {@link PDCIDFontType0#hasGlyph(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#toUnicode(int)} return {@code Unicode}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#hasGlyph(int)}
   */
  @Test
  @DisplayName(
      "Test hasGlyph(int); given PDType0Font toUnicode(int) return 'Unicode'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDCIDFontType0.hasGlyph(int)"})
  void testHasGlyph_givenPDType0FontToUnicodeReturnUnicode_thenReturnTrue() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.toUnicode(anyInt())).thenReturn("Unicode");
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act
    boolean actualHasGlyphResult = pDCIDFontType0.hasGlyph(1);

    // Assert
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
    verify(pDType0Font).toUnicode(1);
    assertTrue(actualHasGlyphResult);
  }

  /**
   * Test {@link PDCIDFontType0#hasGlyph(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#toUnicode(int)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#hasGlyph(int)}
   */
  @Test
  @DisplayName(
      "Test hasGlyph(int); given PDType0Font toUnicode(int) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDCIDFontType0.hasGlyph(int)"})
  void testHasGlyph_givenPDType0FontToUnicodeThrowUnsupportedOperationException()
      throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.toUnicode(anyInt())).thenThrow(new UnsupportedOperationException());
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDCIDFontType0.hasGlyph(1));
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
    verify(pDType0Font).toUnicode(1);
  }

  /**
   * Test {@link PDCIDFontType0#codeToCID(int)}.
   *
   * <ul>
   *   <li>Given {@link CMap} {@link CMap#toCID(int)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#codeToCID(int)}
   */
  @Test
  @DisplayName("Test codeToCID(int); given CMap toCID(int) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDCIDFontType0.codeToCID(int)"})
  void testCodeToCID_givenCMapToCIDReturnOne_thenReturnOne() {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act
    int actualCodeToCIDResult = pDCIDFontType0.codeToCID(1);

    // Assert
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
    assertEquals(1, actualCodeToCIDResult);
  }

  /**
   * Test {@link PDCIDFontType0#codeToCID(int)}.
   *
   * <ul>
   *   <li>Given {@link CMap} {@link CMap#toCID(int)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#codeToCID(int)}
   */
  @Test
  @DisplayName("Test codeToCID(int); given CMap toCID(int) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDCIDFontType0.codeToCID(int)"})
  void testCodeToCID_givenCMapToCIDThrowUnsupportedOperationException() {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenThrow(new UnsupportedOperationException());
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDCIDFontType0.codeToCID(1));
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
  }

  /**
   * Test {@link PDCIDFontType0#codeToCID(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#getCMap()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#codeToCID(int)}
   */
  @Test
  @DisplayName(
      "Test codeToCID(int); given PDType0Font getCMap() throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDCIDFontType0.codeToCID(int)"})
  void testCodeToCID_givenPDType0FontGetCMapThrowUnsupportedOperationException() {
    // Arrange
    when(pDType0Font.getCMap()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDCIDFontType0.codeToCID(1));
    verify(pDType0Font).getCMap();
  }

  /**
   * Test {@link PDCIDFontType0#codeToGID(int)}.
   *
   * <ul>
   *   <li>Given {@link CMap} {@link CMap#toCID(int)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#codeToGID(int)}
   */
  @Test
  @DisplayName("Test codeToGID(int); given CMap toCID(int) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDCIDFontType0.codeToGID(int)"})
  void testCodeToGID_givenCMapToCIDReturnOne_thenReturnOne() {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act
    int actualCodeToGIDResult = pDCIDFontType0.codeToGID(1);

    // Assert
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
    assertEquals(1, actualCodeToGIDResult);
  }

  /**
   * Test {@link PDCIDFontType0#codeToGID(int)}.
   *
   * <ul>
   *   <li>Given {@link CMap} {@link CMap#toCID(int)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#codeToGID(int)}
   */
  @Test
  @DisplayName("Test codeToGID(int); given CMap toCID(int) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDCIDFontType0.codeToGID(int)"})
  void testCodeToGID_givenCMapToCIDThrowUnsupportedOperationException() {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenThrow(new UnsupportedOperationException());
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDCIDFontType0.codeToGID(1));
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
  }

  /**
   * Test {@link PDCIDFontType0#codeToGID(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#getCMap()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#codeToGID(int)}
   */
  @Test
  @DisplayName(
      "Test codeToGID(int); given PDType0Font getCMap() throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDCIDFontType0.codeToGID(int)"})
  void testCodeToGID_givenPDType0FontGetCMapThrowUnsupportedOperationException() {
    // Arrange
    when(pDType0Font.getCMap()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDCIDFontType0.codeToGID(1));
    verify(pDType0Font).getCMap();
  }

  /**
   * Test {@link PDCIDFontType0#encode(int)}.
   *
   * <p>Method under test: {@link PDCIDFontType0#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDCIDFontType0.encode(int)"})
  void testEncode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDCIDFontType0.encode(1));
  }

  /**
   * Test {@link PDCIDFontType0#encodeGlyphId(int)}.
   *
   * <p>Method under test: {@link PDCIDFontType0#encodeGlyphId(int)}
   */
  @Test
  @DisplayName("Test encodeGlyphId(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDCIDFontType0.encodeGlyphId(int)"})
  void testEncodeGlyphId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDCIDFontType0.encodeGlyphId(1));
  }

  /**
   * Test {@link PDCIDFontType0#getWidthFromFont(int)}.
   *
   * <ul>
   *   <li>Given {@link CMap} {@link CMap#toCID(int)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#getWidthFromFont(int)}
   */
  @Test
  @DisplayName(
      "Test getWidthFromFont(int); given CMap toCID(int) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDCIDFontType0.getWidthFromFont(int)"})
  void testGetWidthFromFont_givenCMapToCIDThrowUnsupportedOperationException() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenThrow(new UnsupportedOperationException());
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDCIDFontType0.getWidthFromFont(1));
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
  }

  /**
   * Test {@link PDCIDFontType0#getWidthFromFont(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#getCMap()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#getWidthFromFont(int)}
   */
  @Test
  @DisplayName(
      "Test getWidthFromFont(int); given PDType0Font getCMap() throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDCIDFontType0.getWidthFromFont(int)"})
  void testGetWidthFromFont_givenPDType0FontGetCMapThrowUnsupportedOperationException()
      throws IOException {
    // Arrange
    when(pDType0Font.getCMap()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDCIDFontType0.getWidthFromFont(1));
    verify(pDType0Font).getCMap();
  }

  /**
   * Test {@link PDCIDFontType0#getWidthFromFont(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#toUnicode(int)} return {@code Unicode}.
   *   <li>Then return {@code 722.16797}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#getWidthFromFont(int)}
   */
  @Test
  @DisplayName(
      "Test getWidthFromFont(int); given PDType0Font toUnicode(int) return 'Unicode'; then return '722.16797'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDCIDFontType0.getWidthFromFont(int)"})
  void testGetWidthFromFont_givenPDType0FontToUnicodeReturnUnicode_thenReturn72216797()
      throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.toUnicode(anyInt())).thenReturn("Unicode");
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act
    float actualWidthFromFont = pDCIDFontType0.getWidthFromFont(1);

    // Assert
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
    verify(pDType0Font).toUnicode(1);
    assertEquals(722.16797f, actualWidthFromFont);
  }

  /**
   * Test {@link PDCIDFontType0#getWidthFromFont(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#toUnicode(int)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#getWidthFromFont(int)}
   */
  @Test
  @DisplayName(
      "Test getWidthFromFont(int); given PDType0Font toUnicode(int) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDCIDFontType0.getWidthFromFont(int)"})
  void testGetWidthFromFont_givenPDType0FontToUnicodeThrowUnsupportedOperationException()
      throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.toUnicode(anyInt())).thenThrow(new UnsupportedOperationException());
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDCIDFontType0.getWidthFromFont(1));
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
    verify(pDType0Font).toUnicode(1);
  }

  /**
   * Test {@link PDCIDFontType0#getWidthFromFont(int)}.
   *
   * <ul>
   *   <li>Then return seven hundred fifty.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int); then return seven hundred fifty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDCIDFontType0.getWidthFromFont(int)"})
  void testGetWidthFromFont_thenReturnSevenHundredFifty() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.toUnicode(anyInt())).thenReturn(null);
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act
    float actualWidthFromFont = pDCIDFontType0.getWidthFromFont(1);

    // Assert
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
    verify(pDType0Font).toUnicode(1);
    assertEquals(750.0f, actualWidthFromFont);
  }

  /**
   * Test {@link PDCIDFontType0#getHeight(int)}.
   *
   * <ul>
   *   <li>Given {@link CMap} {@link CMap#toCID(int)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   *   <li>Then calls {@link CMap#toCID(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#getHeight(int)}
   */
  @Test
  @DisplayName(
      "Test getHeight(int); given CMap toCID(int) throw UnsupportedOperationException(); then calls toCID(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDCIDFontType0.getHeight(int)"})
  void testGetHeight_givenCMapToCIDThrowUnsupportedOperationException_thenCallsToCID()
      throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenThrow(new UnsupportedOperationException());
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDCIDFontType0.getHeight(1));
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
  }

  /**
   * Test {@link PDCIDFontType0#getHeight(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType0Font} {@link PDType0Font#getCMap()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFontType0#getHeight(int)}
   */
  @Test
  @DisplayName(
      "Test getHeight(int); given PDType0Font getCMap() throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDCIDFontType0.getHeight(int)"})
  void testGetHeight_givenPDType0FontGetCMapThrowUnsupportedOperationException()
      throws IOException {
    // Arrange
    when(pDType0Font.getCMap()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDCIDFontType0.getHeight(1));
    verify(pDType0Font).getCMap();
  }

  /**
   * Test {@link PDCIDFontType0#getAverageFontWidth()}.
   *
   * <p>Method under test: {@link PDCIDFontType0#getAverageFontWidth()}
   */
  @Test
  @DisplayName("Test getAverageFontWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDCIDFontType0.getAverageFontWidth()"})
  void testGetAverageFontWidth() throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSDictionary(), null);

    // Act and Assert
    assertEquals(500.0f, pdcidFontType0.getAverageFontWidth());
  }
}
