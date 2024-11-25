package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.Map;
import org.apache.fontbox.cmap.CMap;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.TTFTable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDCIDFontType2DiffblueTest {
  /**
   * Test
   * {@link PDCIDFontType2#PDCIDFontType2(COSDictionary, PDType0Font, TrueTypeFont)}.
   * <ul>
   *   <li>Given {@link CmapSubtable} (default constructor).</li>
   *   <li>Then return BaseFont is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2#PDCIDFontType2(COSDictionary, PDType0Font, TrueTypeFont)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2(COSDictionary, PDType0Font, TrueTypeFont); given CmapSubtable (default constructor); then return BaseFont is 'null'")
  void testNewPDCIDFontType2_givenCmapSubtable_thenReturnBaseFontIsNull() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();
    TrueTypeFont trueTypeFont = mock(TrueTypeFont.class);
    when(trueTypeFont.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());

    // Act
    PDCIDFontType2 actualPdcidFontType2 = new PDCIDFontType2(fontDictionary, null, trueTypeFont);

    // Assert
    verify(trueTypeFont).getUnicodeCmapLookup(eq(false));
    assertNull(actualPdcidFontType2.getBaseFont());
    assertNull(actualPdcidFontType2.getName());
    assertNull(actualPdcidFontType2.getBoundingBox());
    assertNull(actualPdcidFontType2.getCIDSystemInfo());
    assertNull(actualPdcidFontType2.getFontDescriptor());
    assertNull(actualPdcidFontType2.getParent());
    Matrix fontMatrix = actualPdcidFontType2.getFontMatrix();
    assertEquals(0.001f, fontMatrix.getScaleX());
    assertEquals(0.001f, fontMatrix.getScaleY());
    assertEquals(0.001f, fontMatrix.getScalingFactorX());
    assertEquals(0.001f, fontMatrix.getScalingFactorY());
    assertEquals(0.0f, fontMatrix.getShearX());
    assertEquals(0.0f, fontMatrix.getShearY());
    assertEquals(0.0f, fontMatrix.getTranslateX());
    assertEquals(0.0f, fontMatrix.getTranslateY());
    assertEquals(1000.0f, actualPdcidFontType2.getAverageFontWidth());
    float[][] values = fontMatrix.getValues();
    assertEquals(3, values.length);
    assertFalse(actualPdcidFontType2.isDamaged());
    assertTrue(actualPdcidFontType2.isEmbedded());
    assertSame(fontDictionary, actualPdcidFontType2.getCOSObject());
    assertSame(trueTypeFont, actualPdcidFontType2.getTrueTypeFont());
    assertArrayEquals(new float[]{0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test
   * {@link PDCIDFontType2#PDCIDFontType2(COSDictionary, PDType0Font, TrueTypeFont)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2#PDCIDFontType2(COSDictionary, PDType0Font, TrueTypeFont)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2(COSDictionary, PDType0Font, TrueTypeFont); given IOException(String) with 'foo'; then throw IOException")
  void testNewPDCIDFontType2_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();
    TrueTypeFont trueTypeFont = mock(TrueTypeFont.class);
    when(trueTypeFont.getUnicodeCmapLookup(anyBoolean())).thenThrow(new IOException("foo"));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDCIDFontType2(fontDictionary, null, trueTypeFont));

    verify(trueTypeFont).getUnicodeCmapLookup(eq(false));
  }

  /**
   * Test {@link PDCIDFontType2#PDCIDFontType2(COSDictionary, PDType0Font)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2#PDCIDFontType2(COSDictionary, PDType0Font)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2(COSDictionary, PDType0Font); when COSDictionary(); then return COSObject is COSDictionary()")
  void testNewPDCIDFontType2_whenCOSDictionary_thenReturnCOSObjectIsCOSDictionary() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    // Act
    PDCIDFontType2 actualPdcidFontType2 = new PDCIDFontType2(fontDictionary, null);

    // Assert
    TrueTypeFont trueTypeFont = actualPdcidFontType2.getTrueTypeFont();
    Map<String, TTFTable> tableMap = trueTypeFont.getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, trueTypeFont.getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
    assertSame(fontDictionary, actualPdcidFontType2.getCOSObject());
  }

  /**
   * Test {@link PDCIDFontType2#PDCIDFontType2(COSDictionary, PDType0Font)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2#PDCIDFontType2(COSDictionary, PDType0Font)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2(COSDictionary, PDType0Font); when COSStream(); then return COSObject is COSStream()")
  void testNewPDCIDFontType2_whenCOSStream_thenReturnCOSObjectIsCOSStream() throws IOException {
    // Arrange
    COSStream fontDictionary = new COSStream();

    // Act
    PDCIDFontType2 actualPdcidFontType2 = new PDCIDFontType2(fontDictionary, null);

    // Assert
    TrueTypeFont trueTypeFont = actualPdcidFontType2.getTrueTypeFont();
    Map<String, TTFTable> tableMap = trueTypeFont.getTableMap();
    assertEquals(19, tableMap.size());
    assertEquals(3, trueTypeFont.getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
    assertSame(fontDictionary, actualPdcidFontType2.getCOSObject());
  }

  /**
   * Test
   * {@link PDCIDFontType2#PDCIDFontType2(COSDictionary, PDType0Font, TrueTypeFont)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2#PDCIDFontType2(COSDictionary, PDType0Font, TrueTypeFont)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2(COSDictionary, PDType0Font, TrueTypeFont); when COSStream(); then return COSObject is COSStream()")
  void testNewPDCIDFontType2_whenCOSStream_thenReturnCOSObjectIsCOSStream2() throws IOException {
    // Arrange
    COSStream fontDictionary = new COSStream();
    TrueTypeFont trueTypeFont = mock(TrueTypeFont.class);
    when(trueTypeFont.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());

    // Act
    PDCIDFontType2 actualPdcidFontType2 = new PDCIDFontType2(fontDictionary, null, trueTypeFont);

    // Assert
    verify(trueTypeFont).getUnicodeCmapLookup(eq(false));
    assertSame(fontDictionary, actualPdcidFontType2.getCOSObject());
  }

  /**
   * Test {@link PDCIDFontType2#getFontMatrix()}.
   * <ul>
   *   <li>Then return ScaleX is {@code 0.001}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix(); then return ScaleX is '0.001'")
  void testGetFontMatrix_thenReturnScaleXIs0001() throws IOException {
    // Arrange and Act
    Matrix actualFontMatrix = (new PDCIDFontType2(new COSDictionary(), null)).getFontMatrix();

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
    assertArrayEquals(new float[]{0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDCIDFontType2#getBoundingBox()}.
   * <p>
   * Method under test: {@link PDCIDFontType2#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox()")
  void testGetBoundingBox() throws IOException {
    // Arrange and Act
    BoundingBox actualBoundingBox = (new PDCIDFontType2(new COSDictionary(), null)).getBoundingBox();

    // Assert
    assertEquals(-303.22266f, actualBoundingBox.getLowerLeftY());
    assertEquals(-543.9453f, actualBoundingBox.getLowerLeftX());
    assertEquals(1283.2031f, actualBoundingBox.getHeight());
    assertEquals(1301.7578f, actualBoundingBox.getUpperRightX());
    assertEquals(1845.7031f, actualBoundingBox.getWidth());
    assertEquals(979.98047f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Test {@link PDCIDFontType2#getBoundingBox()}.
   * <p>
   * Method under test: {@link PDCIDFontType2#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox()")
  void testGetBoundingBox2() throws IOException {
    // Arrange and Act
    BoundingBox actualBoundingBox = (new PDCIDFontType2(new COSStream(), null)).getBoundingBox();

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
   * <ul>
   *   <li>Given {@link CMap} {@link CMap#hasCIDMappings()} return
   * {@code true}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2#codeToCID(int)}
   */
  @Test
  @DisplayName("Test codeToCID(int); given CMap hasCIDMappings() return 'true'; then return one")
  void testCodeToCID_givenCMapHasCIDMappingsReturnTrue_thenReturnOne() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.hasCIDMappings()).thenReturn(true);
    when(cMap.toCID(anyInt())).thenReturn(1);
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.getCMap()).thenReturn(cMap);

    // Act
    int actualCodeToCIDResult = (new PDCIDFontType2(new COSDictionary(), parent)).codeToCID(1);

    // Assert
    verify(cMap).hasCIDMappings();
    verify(cMap).toCID(eq(1));
    verify(parent).getCMap();
    assertEquals(1, actualCodeToCIDResult);
  }

  /**
   * Test {@link PDCIDFontType2#codeToCID(int)}.
   * <ul>
   *   <li>Given {@link CMap} {@link CMap#hasUnicodeMappings()} return
   * {@code false}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2#codeToCID(int)}
   */
  @Test
  @DisplayName("Test codeToCID(int); given CMap hasUnicodeMappings() return 'false'; then return one")
  void testCodeToCID_givenCMapHasUnicodeMappingsReturnFalse_thenReturnOne() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.hasCIDMappings()).thenReturn(false);
    when(cMap.hasUnicodeMappings()).thenReturn(false);
    when(cMap.toCID(anyInt())).thenReturn(1);
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.getCMap()).thenReturn(cMap);

    // Act
    int actualCodeToCIDResult = (new PDCIDFontType2(new COSDictionary(), parent)).codeToCID(1);

    // Assert
    verify(cMap).hasCIDMappings();
    verify(cMap).hasUnicodeMappings();
    verify(cMap).toCID(eq(1));
    verify(parent).getCMap();
    assertEquals(1, actualCodeToCIDResult);
  }

  /**
   * Test {@link PDCIDFontType2#codeToCID(int)}.
   * <ul>
   *   <li>Given {@link CMap} {@link CMap#toUnicode(int)} return {@code null}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2#codeToCID(int)}
   */
  @Test
  @DisplayName("Test codeToCID(int); given CMap toUnicode(int) return 'null'; then return one")
  void testCodeToCID_givenCMapToUnicodeReturnNull_thenReturnOne() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toUnicode(anyInt())).thenReturn(null);
    when(cMap.hasCIDMappings()).thenReturn(false);
    when(cMap.hasUnicodeMappings()).thenReturn(true);
    when(cMap.toCID(anyInt())).thenReturn(1);
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.getCMap()).thenReturn(cMap);

    // Act
    int actualCodeToCIDResult = (new PDCIDFontType2(new COSDictionary(), parent)).codeToCID(1);

    // Assert
    verify(cMap).hasCIDMappings();
    verify(cMap).hasUnicodeMappings();
    verify(cMap).toCID(eq(1));
    verify(cMap).toUnicode(eq(1));
    verify(parent).getCMap();
    assertEquals(1, actualCodeToCIDResult);
  }

  /**
   * Test {@link PDCIDFontType2#codeToCID(int)}.
   * <ul>
   *   <li>Given {@link CMap} {@link CMap#toUnicode(int)} return
   * {@code Unicode}.</li>
   *   <li>Then return eighty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2#codeToCID(int)}
   */
  @Test
  @DisplayName("Test codeToCID(int); given CMap toUnicode(int) return 'Unicode'; then return eighty-five")
  void testCodeToCID_givenCMapToUnicodeReturnUnicode_thenReturnEightyFive() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toUnicode(anyInt())).thenReturn("Unicode");
    when(cMap.hasCIDMappings()).thenReturn(false);
    when(cMap.hasUnicodeMappings()).thenReturn(true);
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.getCMap()).thenReturn(cMap);

    // Act
    int actualCodeToCIDResult = (new PDCIDFontType2(new COSDictionary(), parent)).codeToCID(1);

    // Assert
    verify(cMap).hasCIDMappings();
    verify(cMap).hasUnicodeMappings();
    verify(cMap).toUnicode(eq(1));
    verify(parent).getCMap();
    assertEquals(85, actualCodeToCIDResult);
  }

  /**
   * Test {@link PDCIDFontType2#codeToCID(int)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2#codeToCID(int)}
   */
  @Test
  @DisplayName("Test codeToCID(int); then throw IllegalArgumentException")
  void testCodeToCID_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toUnicode(anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(cMap.hasCIDMappings()).thenReturn(false);
    when(cMap.hasUnicodeMappings()).thenReturn(true);
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.getCMap()).thenReturn(cMap);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDCIDFontType2(new COSDictionary(), parent)).codeToCID(1));
    verify(cMap).hasCIDMappings();
    verify(cMap).hasUnicodeMappings();
    verify(cMap).toUnicode(eq(1));
    verify(parent).getCMap();
  }

  /**
   * Test {@link PDCIDFontType2#codeToGID(int)}.
   * <p>
   * Method under test: {@link PDCIDFontType2#codeToGID(int)}
   */
  @Test
  @DisplayName("Test codeToGID(int)")
  void testCodeToGID() throws IOException {
    // Arrange
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn("Unicode");

    // Act
    int actualCodeToGIDResult = (new PDCIDFontType2(new COSDictionary(), parent)).codeToGID(1);

    // Assert
    verify(parent).toUnicode(eq(1));
    assertEquals(56, actualCodeToGIDResult);
  }

  /**
   * Test {@link PDCIDFontType2#codeToGID(int)}.
   * <p>
   * Method under test: {@link PDCIDFontType2#codeToGID(int)}
   */
  @Test
  @DisplayName("Test codeToGID(int)")
  void testCodeToGID2() throws IOException {
    // Arrange
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn("Unicode");

    // Act
    int actualCodeToGIDResult = (new PDCIDFontType2(new COSStream(), parent)).codeToGID(1);

    // Assert
    verify(parent).toUnicode(eq(1));
    assertEquals(56, actualCodeToGIDResult);
  }

  /**
   * Test {@link PDCIDFontType2#getHeight(int)}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); then return one")
  void testGetHeight_thenReturnOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDCIDFontType2(new COSDictionary(), null)).getHeight(1));
  }

  /**
   * Test {@link PDCIDFontType2#getWidthFromFont(int)}.
   * <p>
   * Method under test: {@link PDCIDFontType2#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int)")
  void testGetWidthFromFont() throws IOException {
    // Arrange
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn("Unicode");

    // Act
    float actualWidthFromFont = (new PDCIDFontType2(new COSDictionary(), parent)).getWidthFromFont(1);

    // Assert
    verify(parent).toUnicode(eq(1));
    assertEquals(722.16797f, actualWidthFromFont);
  }

  /**
   * Test {@link PDCIDFontType2#getWidthFromFont(int)}.
   * <p>
   * Method under test: {@link PDCIDFontType2#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int)")
  void testGetWidthFromFont2() throws IOException {
    // Arrange
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn("Unicode");

    // Act
    float actualWidthFromFont = (new PDCIDFontType2(new COSStream(), parent)).getWidthFromFont(1);

    // Assert
    verify(parent).toUnicode(eq(1));
    assertEquals(722.16797f, actualWidthFromFont);
  }

  /**
   * Test {@link PDCIDFontType2#encode(int)}.
   * <ul>
   *   <li>Given {@link PDCIDFontType2#PDCIDFontType2(COSDictionary, PDType0Font)}
   * with fontDictionary is {@link COSStream#COSStream()} and parent is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int); given PDCIDFontType2(COSDictionary, PDType0Font) with fontDictionary is COSStream() and parent is 'null'")
  void testEncode_givenPDCIDFontType2WithFontDictionaryIsCOSStreamAndParentIsNull() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDCIDFontType2(new COSStream(), null)).encode(1));
  }

  /**
   * Test {@link PDCIDFontType2#encode(int)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int); then throw IllegalArgumentException")
  void testEncode_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDCIDFontType2(new COSDictionary(), null)).encode(1));
  }

  /**
   * Test {@link PDCIDFontType2#encode(int)}.
   * <ul>
   *   <li>When one thousand.</li>
   *   <li>Then return array of {@code byte} with three and minus one hundred
   * three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int); when one thousand; then return array of byte with three and minus one hundred three")
  void testEncode_whenOneThousand_thenReturnArrayOfByteWithThreeAndMinusOneHundredThree() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{3, -103}, (new PDCIDFontType2(new COSDictionary(), null)).encode(1000));
  }

  /**
   * Test {@link PDCIDFontType2#encodeGlyphId(int)}.
   * <ul>
   *   <li>Then return array of {@code byte} with zero and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2#encodeGlyphId(int)}
   */
  @Test
  @DisplayName("Test encodeGlyphId(int); then return array of byte with zero and one")
  void testEncodeGlyphId_thenReturnArrayOfByteWithZeroAndOne() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{0, 1}, (new PDCIDFontType2(new COSDictionary(), null)).encodeGlyphId(1));
  }

  /**
   * Test {@link PDCIDFontType2#getPath(int)}.
   * <p>
   * Method under test: {@link PDCIDFontType2#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int)")
  void testGetPath() throws IOException {
    // Arrange
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn("Unicode");

    // Act
    GeneralPath actualPath = (new PDCIDFontType2(new COSDictionary(), parent)).getPath(1);

    // Assert
    verify(parent).toUnicode(eq(1));
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
   * Test {@link PDCIDFontType2#getPath(int)}.
   * <p>
   * Method under test: {@link PDCIDFontType2#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int)")
  void testGetPath2() throws IOException {
    // Arrange
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn("Unicode");

    // Act
    GeneralPath actualPath = (new PDCIDFontType2(new COSStream(), parent)).getPath(1);

    // Assert
    verify(parent).toUnicode(eq(1));
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
   * Test {@link PDCIDFontType2#getNormalizedPath(int)}.
   * <p>
   * Method under test: {@link PDCIDFontType2#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int)")
  void testGetNormalizedPath() throws IOException {
    // Arrange
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn("Unicode");

    // Act
    GeneralPath actualNormalizedPath = (new PDCIDFontType2(new COSDictionary(), parent)).getNormalizedPath(1);

    // Assert
    verify(parent, atLeast(1)).toUnicode(eq(1));
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
    Rectangle2D frame2 = bounds2D2.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Rectangle2D bounds2D3 = bounds2D2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds2D2, frame2);
    assertEquals(bounds2D2, bounds2D3);
  }

  /**
   * Test {@link PDCIDFontType2#getNormalizedPath(int)}.
   * <p>
   * Method under test: {@link PDCIDFontType2#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int)")
  void testGetNormalizedPath2() throws IOException {
    // Arrange
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn("Unicode");

    // Act
    GeneralPath actualNormalizedPath = (new PDCIDFontType2(new COSStream(), parent)).getNormalizedPath(1);

    // Assert
    verify(parent, atLeast(1)).toUnicode(eq(1));
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
    Rectangle2D frame2 = bounds2D2.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Rectangle2D bounds2D3 = bounds2D2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds2D2, frame2);
    assertEquals(bounds2D2, bounds2D3);
  }

  /**
   * Test {@link PDCIDFontType2#hasGlyph(int)}.
   * <p>
   * Method under test: {@link PDCIDFontType2#hasGlyph(int)}
   */
  @Test
  @DisplayName("Test hasGlyph(int)")
  void testHasGlyph() throws IOException {
    // Arrange
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn("Unicode");

    // Act
    boolean actualHasGlyphResult = (new PDCIDFontType2(new COSDictionary(), parent)).hasGlyph(1);

    // Assert
    verify(parent).toUnicode(eq(1));
    assertTrue(actualHasGlyphResult);
  }

  /**
   * Test {@link PDCIDFontType2#hasGlyph(int)}.
   * <p>
   * Method under test: {@link PDCIDFontType2#hasGlyph(int)}
   */
  @Test
  @DisplayName("Test hasGlyph(int)")
  void testHasGlyph2() throws IOException {
    // Arrange
    PDType0Font parent = mock(PDType0Font.class);
    when(parent.toUnicode(anyInt())).thenReturn("Unicode");

    // Act
    boolean actualHasGlyphResult = (new PDCIDFontType2(new COSStream(), parent)).hasGlyph(1);

    // Assert
    verify(parent).toUnicode(eq(1));
    assertTrue(actualHasGlyphResult);
  }
}
