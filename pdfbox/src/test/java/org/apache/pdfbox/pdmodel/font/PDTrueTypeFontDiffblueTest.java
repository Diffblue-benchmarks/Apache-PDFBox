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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import java.util.List;
import java.util.Map;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.HeaderTable;
import org.apache.fontbox.ttf.HorizontalHeaderTable;
import org.apache.fontbox.ttf.HorizontalMetricsTable;
import org.apache.fontbox.ttf.OS2WindowsMetricsTable;
import org.apache.fontbox.ttf.PostScriptTable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.apache.pdfbox.pdmodel.font.encoding.BuiltInEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.MacExpertEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.StandardEncoding;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDTrueTypeFontDiffblueTest {
  /**
   * Test {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then FontBoxFont return {@link TrueTypeFont}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDTrueTypeFont(COSDictionary); when COSDictionary(); then FontBoxFont return TrueTypeFont")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTrueTypeFont.<init>(COSDictionary)"})
  void testNewPDTrueTypeFont_whenCOSDictionary_thenFontBoxFontReturnTrueTypeFont() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    // Act
    PDTrueTypeFont actualPdTrueTypeFont = new PDTrueTypeFont(fontDictionary);

    // Assert
    FontBoxFont fontBoxFont = actualPdTrueTypeFont.getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    assertTrue(actualPdTrueTypeFont.getEncoding() instanceof BuiltInEncoding);
    assertNull(actualPdTrueTypeFont.getSymbolicFlag());
    assertNull(actualPdTrueTypeFont.getSubType());
    assertNull(actualPdTrueTypeFont.getType());
    assertNull(actualPdTrueTypeFont.getBaseFont());
    assertNull(actualPdTrueTypeFont.getName());
    assertNull(actualPdTrueTypeFont.getStandard14AFM());
    assertNull(actualPdTrueTypeFont.getToUnicodeCMap());
    assertNull(actualPdTrueTypeFont.getFontDescriptor());
    assertEquals(0.0f, actualPdTrueTypeFont.getAverageFontWidth());
    Map<Integer, Integer> gIDToCode = actualPdTrueTypeFont.getGIDToCode();
    assertEquals(192, gIDToCode.size());
    assertEquals(250.0f, actualPdTrueTypeFont.getSpaceWidth());
    assertFalse(actualPdTrueTypeFont.isVertical());
    assertFalse(actualPdTrueTypeFont.isDamaged());
    assertFalse(actualPdTrueTypeFont.isEmbedded());
    assertTrue(actualPdTrueTypeFont.getWidths().isEmpty());
    assertTrue(gIDToCode.containsKey(0));
    assertTrue(gIDToCode.containsKey(1));
    assertTrue(gIDToCode.containsKey(2));
    assertTrue(gIDToCode.containsKey(3));
    assertTrue(gIDToCode.containsKey(4));
    assertTrue(gIDToCode.containsKey(5));
    assertSame(fontDictionary, actualPdTrueTypeFont.getCOSObject());
    Matrix expectedFontMatrix = actualPdTrueTypeFont.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualPdTrueTypeFont.getFontMatrix());
    assertSame(fontBoxFont, actualPdTrueTypeFont.getTrueTypeFont());
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code ttf}, {@code encoding}.
   * <p>
   * Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getFsSelection()).thenThrow(new NumberFormatException("foo"));
    PostScriptTable postScriptTable = mock(PostScriptTable.class);
    when(postScriptTable.getIsFixedPitch()).thenReturn(1L);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getHorizontalHeader()).thenReturn(mock(HorizontalHeaderTable.class));
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> PDTrueTypeFont.load(doc, ttf, MacExpertEncoding.INSTANCE));
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(postScriptTable).getIsFixedPitch();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getName();
    verify(ttf).getOS2Windows();
    verify(ttf).getPostScript();
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code ttf}, {@code encoding}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; when PDDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding_whenPDDocument() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getFamilyClass()).thenReturn(1);
    when(os2WindowsMetricsTable.getFsSelection()).thenReturn(1);
    when(os2WindowsMetricsTable.getVersion()).thenReturn(1);
    when(os2WindowsMetricsTable.getWeightClass()).thenReturn(3);
    when(os2WindowsMetricsTable.getFsType()).thenReturn((short) 1);
    PostScriptTable postScriptTable = mock(PostScriptTable.class);
    when(postScriptTable.getItalicAngle()).thenReturn(10.0f);
    when(postScriptTable.getIsFixedPitch()).thenReturn(1L);
    HorizontalHeaderTable horizontalHeaderTable = mock(HorizontalHeaderTable.class);
    when(horizontalHeaderTable.getAscender()).thenReturn((short) 1);
    when(horizontalHeaderTable.getDescender()).thenReturn((short) 1);
    HeaderTable headerTable = mock(HeaderTable.class);
    when(headerTable.getUnitsPerEm()).thenReturn(1);
    when(headerTable.getXMax()).thenReturn((short) 1);
    when(headerTable.getXMin()).thenReturn((short) 1);
    when(headerTable.getYMax()).thenReturn((short) 1);
    when(headerTable.getYMin()).thenReturn((short) 1);
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getPath(Mockito.<String>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(FontName.TIMES_ROMAN, "Glyph Name"));
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, MacExpertEncoding.INSTANCE);

    // Assert
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(eq(0));
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable).getVersion();
    verify(os2WindowsMetricsTable).getWeightClass();
    verify(postScriptTable).getIsFixedPitch();
    verify(postScriptTable).getItalicAngle();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf).getOriginalData();
    verify(ttf).getOriginalDataSize();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf).getUnicodeCmapLookup();
    PDFontDescriptor fontDescriptor = actualLoadResult.getFontDescriptor();
    PDRectangle fontBoundingBox = fontDescriptor.getFontBoundingBox();
    COSArray cOSArray = fontBoundingBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(3);
    assertTrue(getResult3 instanceof COSFloat);
    assertEquals(1, fontDescriptor.getFontFile2().getFilters().size());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualLoadResult.getFontMatrix());
  }

  /**
   * Test {@link PDTrueTypeFont#getBaseFont()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getBaseFont()}
   */
  @Test
  @DisplayName("Test getBaseFont(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDTrueTypeFont.getBaseFont()"})
  void testGetBaseFont_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDTrueTypeFont(new COSDictionary())).getBaseFont());
  }

  /**
   * Test {@link PDTrueTypeFont#readEncodingFromFont()}.
   * <ul>
   *   <li>Then return {@link BuiltInEncoding}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#readEncodingFromFont()}
   */
  @Test
  @DisplayName("Test readEncodingFromFont(); then return BuiltInEncoding")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Encoding PDTrueTypeFont.readEncodingFromFont()"})
  void testReadEncodingFromFont_thenReturnBuiltInEncoding() throws IOException {
    // Arrange and Act
    Encoding actualReadEncodingFromFontResult = (new PDTrueTypeFont(new COSDictionary())).readEncodingFromFont();

    // Assert
    assertTrue(actualReadEncodingFromFontResult instanceof BuiltInEncoding);
    Map<Integer, String> codeToNameMap = actualReadEncodingFromFontResult.getCodeToNameMap();
    assertEquals(229, codeToNameMap.size());
    assertEquals(".null", codeToNameMap.get(0));
    assertEquals(".null", codeToNameMap.get(29));
    assertEquals(".null", codeToNameMap.get(8));
    assertEquals("built-in (TTF)", actualReadEncodingFromFontResult.getEncodingName());
    assertEquals("nonmarkingreturn", codeToNameMap.get(13));
    assertEquals("nonmarkingreturn", codeToNameMap.get(9));
    assertEquals("uni00A0", codeToNameMap.get(Integer.SIZE));
    Map<String, Integer> nameToCodeMap = actualReadEncodingFromFontResult.getNameToCodeMap();
    assertEquals(192, nameToCodeMap.size());
    assertEquals(169, nameToCodeMap.get("copyright").intValue());
    assertEquals(172, nameToCodeMap.get("logicalnot").intValue());
    assertEquals(211, nameToCodeMap.get("Oacute").intValue());
    assertEquals(222, nameToCodeMap.get("Thorn").intValue());
    assertTrue(nameToCodeMap.containsKey("asterisk"));
    assertTrue(nameToCodeMap.containsKey("parenright"));
  }

  /**
   * Test {@link PDTrueTypeFont#readEncodingFromFont()}.
   * <ul>
   *   <li>Then return {@link StandardEncoding#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#readEncodingFromFont()}
   */
  @Test
  @DisplayName("Test readEncodingFromFont(); then return INSTANCE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Encoding PDTrueTypeFont.readEncodingFromFont()"})
  void testReadEncodingFromFont_thenReturnInstance() throws IOException {
    // Arrange
    PDTrueTypeFont pdTrueTypeFont = new PDTrueTypeFont(new COSDictionary());
    pdTrueTypeFont.setFontDescriptor(new PDFontDescriptor());

    // Act
    Encoding actualReadEncodingFromFontResult = pdTrueTypeFont.readEncodingFromFont();

    // Assert
    assertSame(((StandardEncoding) actualReadEncodingFromFontResult).INSTANCE, actualReadEncodingFromFontResult);
  }

  /**
   * Test {@link PDTrueTypeFont#readCode(InputStream)}.
   * <ul>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#readCode(InputStream)}
   */
  @Test
  @DisplayName("Test readCode(InputStream); then return sixty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDTrueTypeFont.readCode(InputStream)"})
  void testReadCode_thenReturnSixtyFive() throws IOException {
    // Arrange
    PDTrueTypeFont pdTrueTypeFont = new PDTrueTypeFont(new COSDictionary());
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(65, pdTrueTypeFont.readCode(in));
    byte[] byteArray = new byte[7];
    assertEquals(7, in.read(byteArray));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDTrueTypeFont#getName()}.
   * <ul>
   *   <li>Given {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDTrueTypeFont(COSDictionary) with fontDictionary is COSDictionary(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDTrueTypeFont.getName()"})
  void testGetName_givenPDTrueTypeFontWithFontDictionaryIsCOSDictionary_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDTrueTypeFont(new COSDictionary())).getName());
  }

  /**
   * Test {@link PDTrueTypeFont#getBoundingBox()}.
   * <ul>
   *   <li>Given {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); given PDTrueTypeFont(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BoundingBox PDTrueTypeFont.getBoundingBox()"})
  void testGetBoundingBox_givenPDTrueTypeFontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    BoundingBox actualBoundingBox = (new PDTrueTypeFont(new COSDictionary())).getBoundingBox();

    // Assert
    assertEquals(-176.75781f, actualBoundingBox.getLowerLeftX());
    assertEquals(-303.22266f, actualBoundingBox.getLowerLeftY());
    assertEquals(1006.83594f, actualBoundingBox.getUpperRightX());
    assertEquals(1183.5938f, actualBoundingBox.getWidth());
    assertEquals(1284.668f, actualBoundingBox.getHeight());
    assertEquals(981.4453f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Test {@link PDTrueTypeFont#getBoundingBox()}.
   * <ul>
   *   <li>Then return LowerLeftX is {@code -176.75781}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return LowerLeftX is '-176.75781'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BoundingBox PDTrueTypeFont.getBoundingBox()"})
  void testGetBoundingBox_thenReturnLowerLeftXIs17675781() throws IOException {
    // Arrange
    PDTrueTypeFont pdTrueTypeFont = new PDTrueTypeFont(new COSDictionary());
    pdTrueTypeFont.setFontDescriptor(new PDFontDescriptor());

    // Act
    BoundingBox actualBoundingBox = pdTrueTypeFont.getBoundingBox();

    // Assert
    assertEquals(-176.75781f, actualBoundingBox.getLowerLeftX());
    assertEquals(-303.22266f, actualBoundingBox.getLowerLeftY());
    assertEquals(1006.83594f, actualBoundingBox.getUpperRightX());
    assertEquals(1183.5938f, actualBoundingBox.getWidth());
    assertEquals(1284.668f, actualBoundingBox.getHeight());
    assertEquals(981.4453f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Test {@link PDTrueTypeFont#getBoundingBox()}.
   * <ul>
   *   <li>Then return LowerLeftX is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return LowerLeftX is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BoundingBox PDTrueTypeFont.getBoundingBox()"})
  void testGetBoundingBox_thenReturnLowerLeftXIsZero() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(PDRectangle.A0);

    PDTrueTypeFont pdTrueTypeFont = new PDTrueTypeFont(new COSDictionary());
    pdTrueTypeFont.setFontDescriptor(fontDescriptor);

    // Act
    BoundingBox actualBoundingBox = pdTrueTypeFont.getBoundingBox();

    // Assert
    assertEquals(0.0f, actualBoundingBox.getLowerLeftX());
    assertEquals(0.0f, actualBoundingBox.getLowerLeftY());
    assertEquals(2383.937f, actualBoundingBox.getUpperRightX());
    assertEquals(2383.937f, actualBoundingBox.getWidth());
    assertEquals(3370.3938f, actualBoundingBox.getHeight());
    assertEquals(3370.3938f, actualBoundingBox.getUpperRightY());
  }

  /**
   * Test {@link PDTrueTypeFont#getWidthFromFont(int)}.
   * <ul>
   *   <li>Then return {@code 365.23438}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int); then return '365.23438'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDTrueTypeFont.getWidthFromFont(int)"})
  void testGetWidthFromFont_thenReturn36523438() throws IOException {
    // Arrange, Act and Assert
    assertEquals(365.23438f, (new PDTrueTypeFont(new COSDictionary())).getWidthFromFont(1));
  }

  /**
   * Test {@link PDTrueTypeFont#getWidthFromFont(int)}.
   * <ul>
   *   <li>When two hundred fifty-five.</li>
   *   <li>Then return five hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int); when two hundred fifty-five; then return five hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDTrueTypeFont.getWidthFromFont(int)"})
  void testGetWidthFromFont_whenTwoHundredFiftyFive_thenReturnFiveHundred() throws IOException {
    // Arrange, Act and Assert
    assertEquals(500.0f, (new PDTrueTypeFont(new COSDictionary())).getWidthFromFont(255));
  }

  /**
   * Test {@link PDTrueTypeFont#getHeight(int)}.
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException(String)} with {@code foo}.</li>
   *   <li>When one.</li>
   *   <li>Then return {@code 1365.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); given NumberFormatException(String) with 'foo'; when one; then return '1365.0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDTrueTypeFont.getHeight(int)"})
  void testGetHeight_givenNumberFormatExceptionWithFoo_whenOne_thenReturn13650() throws IOException {
    // Arrange
    new NumberFormatException("foo");
    new NumberFormatException("foo");

    // Act and Assert
    assertEquals(1365.0f, (new PDTrueTypeFont(new COSDictionary())).getHeight(1));
  }

  /**
   * Test {@link PDTrueTypeFont#getHeight(int)}.
   * <ul>
   *   <li>When eighty-eight.</li>
   *   <li>Then return {@code 1341.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); when eighty-eight; then return '1341.0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDTrueTypeFont.getHeight(int)"})
  void testGetHeight_whenEightyEight_thenReturn13410() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1341.0f, (new PDTrueTypeFont(new COSDictionary())).getHeight(88));
  }

  /**
   * Test {@link PDTrueTypeFont#getHeight(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code 1365.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); when one; then return '1365.0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDTrueTypeFont.getHeight(int)"})
  void testGetHeight_whenOne_thenReturn13650() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1365.0f, (new PDTrueTypeFont(new COSDictionary())).getHeight(1));
  }

  /**
   * Test {@link PDTrueTypeFont#getHeight(int)}.
   * <ul>
   *   <li>When two hundred fifty-five.</li>
   *   <li>Then return {@code 1736.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); when two hundred fifty-five; then return '1736.0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDTrueTypeFont.getHeight(int)"})
  void testGetHeight_whenTwoHundredFiftyFive_thenReturn17360() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1736.0f, (new PDTrueTypeFont(new COSDictionary())).getHeight(255));
  }

  /**
   * Test {@link PDTrueTypeFont#getHeight(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); when zero; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDTrueTypeFont.getHeight(int)"})
  void testGetHeight_whenZero_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDTrueTypeFont(new COSDictionary())).getHeight(0));
  }

  /**
   * Test {@link PDTrueTypeFont#encode(int)} with {@code unicode}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus one hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'; then return array of byte with minus one hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDTrueTypeFont.encode(int)"})
  void testEncodeWithUnicode_thenReturnArrayOfByteWithMinusOneHundred() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-100}, (new PDTrueTypeFont(new COSDictionary())).encode(250));
  }

  /**
   * Test {@link PDTrueTypeFont#encode(int)} with {@code unicode}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'; when one; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDTrueTypeFont.encode(int)"})
  void testEncodeWithUnicode_whenOne_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDTrueTypeFont(new COSDictionary())).encode(1));
  }

  /**
   * Test {@link PDTrueTypeFont#encode(int)} with {@code unicode}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'; when zero; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] PDTrueTypeFont.encode(int)"})
  void testEncodeWithUnicode_whenZero_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDTrueTypeFont(new COSDictionary())).encode(0));
  }

  /**
   * Test {@link PDTrueTypeFont#getGIDToCode()}.
   * <ul>
   *   <li>Then return size is one hundred ninety-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getGIDToCode()}
   */
  @Test
  @DisplayName("Test getGIDToCode(); then return size is one hundred ninety-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map PDTrueTypeFont.getGIDToCode()"})
  void testGetGIDToCode_thenReturnSizeIsOneHundredNinetyTwo() throws IOException {
    // Arrange and Act
    Map<Integer, Integer> actualGIDToCode = (new PDTrueTypeFont(new COSDictionary())).getGIDToCode();

    // Assert
    assertEquals(192, actualGIDToCode.size());
    assertEquals(0, actualGIDToCode.get(1).intValue());
    assertEquals(1, actualGIDToCode.get(0).intValue());
    assertEquals(33, actualGIDToCode.get(4).intValue());
    assertEquals(34, actualGIDToCode.get(5).intValue());
    assertEquals(35, actualGIDToCode.get(6).intValue());
    assertEquals(36, actualGIDToCode.get(7).intValue());
    assertEquals(37, actualGIDToCode.get(8).intValue());
    assertEquals(38, actualGIDToCode.get(9).intValue());
    assertEquals(39, actualGIDToCode.get(PDPanoseClassification.LENGTH).intValue());
    assertEquals(9, actualGIDToCode.get(2).intValue());
    assertEquals(Integer.SIZE, actualGIDToCode.get(3).intValue());
  }

  /**
   * Test {@link PDTrueTypeFont#getPath(int)} with {@code code}.
   * <ul>
   *   <li>Then CurrentPoint return {@link Point2D.Float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; then CurrentPoint return Float")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDTrueTypeFont.getPath(int)"})
  void testGetPathWithCode_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary())).getPath(1);

    // Assert
    assertTrue(actualPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualPath.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link PDTrueTypeFont#getPath(int)} with {@code code}.
   * <ul>
   *   <li>When two hundred fifty-five.</li>
   *   <li>Then CurrentPoint return {@link Point2D.Float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; when two hundred fifty-five; then CurrentPoint return Float")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDTrueTypeFont.getPath(int)"})
  void testGetPathWithCode_whenTwoHundredFiftyFive_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary())).getPath(255);

    // Assert
    assertTrue(actualPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualPath.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link PDTrueTypeFont#getPath(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code g9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; given COSDictionary(COSDictionary) with dict is COSDictionary(); when 'g9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDTrueTypeFont.getPath(String)"})
  void testGetPathWithName_givenCOSDictionaryWithDictIsCOSDictionary_whenG9() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary(new COSDictionary()))).getPath("g9");

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
   * Test {@link PDTrueTypeFont#getPath(String)} with {@code name}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then CurrentPoint return {@link Point2D.Float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when '42'; then CurrentPoint return Float")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDTrueTypeFont.getPath(String)"})
  void testGetPathWithName_when42_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary())).getPath("42");

    // Assert
    assertTrue(actualPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualPath.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link PDTrueTypeFont#getPath(String)} with {@code name}.
   * <ul>
   *   <li>When {@code g9}.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when 'g9'; then Bounds Bounds2D return Rectangle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDTrueTypeFont.getPath(String)"})
  void testGetPathWithName_whenG9_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary())).getPath("g9");

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
   * Test {@link PDTrueTypeFont#getPath(String)} with {@code name}.
   * <ul>
   *   <li>When {@code g942}.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when 'g942'; then Bounds Bounds2D return Rectangle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDTrueTypeFont.getPath(String)"})
  void testGetPathWithName_whenG942_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary())).getPath("g942");

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
   * Test {@link PDTrueTypeFont#getPath(String)} with {@code name}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when 'Name'; then Bounds Bounds2D return Rectangle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDTrueTypeFont.getPath(String)"})
  void testGetPathWithName_whenName_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary())).getPath("Name");

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
   * Test {@link PDTrueTypeFont#getPath(String)} with {@code name}.
   * <ul>
   *   <li>When {@code .notdef}.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when '.notdef'; then Bounds Bounds2D return Rectangle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDTrueTypeFont.getPath(String)"})
  void testGetPathWithName_whenNotdef_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary())).getPath(".notdef");

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
   * Test {@link PDTrueTypeFont#getPath(String)} with {@code name}.
   * <ul>
   *   <li>When {@code uni}.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when 'uni'; then Bounds Bounds2D return Rectangle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDTrueTypeFont.getPath(String)"})
  void testGetPathWithName_whenUni_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary())).getPath("uni");

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
   * Test {@link PDTrueTypeFont#getNormalizedPath(int)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); when eight; then Bounds Bounds2D return Rectangle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDTrueTypeFont.getNormalizedPath(int)"})
  void testGetNormalizedPath_whenEight_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDTrueTypeFont(new COSDictionary())).getNormalizedPath(8);

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
   * Test {@link PDTrueTypeFont#getNormalizedPath(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); when one; then Bounds Bounds2D return Rectangle")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDTrueTypeFont.getNormalizedPath(int)"})
  void testGetNormalizedPath_whenOne_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDTrueTypeFont(new COSDictionary())).getNormalizedPath(1);

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
   * Test {@link PDTrueTypeFont#getNormalizedPath(int)}.
   * <ul>
   *   <li>When two hundred fifty-five.</li>
   *   <li>Then CurrentPoint return {@link Point2D.Float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); when two hundred fifty-five; then CurrentPoint return Float")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GeneralPath PDTrueTypeFont.getNormalizedPath(int)"})
  void testGetNormalizedPath_whenTwoHundredFiftyFive_thenCurrentPointReturnFloat() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDTrueTypeFont(new COSDictionary())).getNormalizedPath(255);

    // Assert
    assertTrue(actualNormalizedPath.getCurrentPoint() instanceof Point2D.Float);
    assertTrue(actualNormalizedPath.getBounds2D() instanceof Float);
  }

  /**
   * Test {@link PDTrueTypeFont#hasGlyph(int)} with {@code code}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#hasGlyph(int)}
   */
  @Test
  @DisplayName("Test hasGlyph(int) with 'code'; when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTrueTypeFont.hasGlyph(int)"})
  void testHasGlyphWithCode_whenOne_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDTrueTypeFont(new COSDictionary())).hasGlyph(1));
  }

  /**
   * Test {@link PDTrueTypeFont#hasGlyph(int)} with {@code code}.
   * <ul>
   *   <li>When two hundred fifty-five.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#hasGlyph(int)}
   */
  @Test
  @DisplayName("Test hasGlyph(int) with 'code'; when two hundred fifty-five; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTrueTypeFont.hasGlyph(int)"})
  void testHasGlyphWithCode_whenTwoHundredFiftyFive_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDTrueTypeFont(new COSDictionary())).hasGlyph(255));
  }

  /**
   * Test {@link PDTrueTypeFont#hasGlyph(int)} with {@code code}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#hasGlyph(int)}
   */
  @Test
  @DisplayName("Test hasGlyph(int) with 'code'; when zero; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTrueTypeFont.hasGlyph(int)"})
  void testHasGlyphWithCode_whenZero_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDTrueTypeFont(new COSDictionary())).hasGlyph(0));
  }

  /**
   * Test {@link PDTrueTypeFont#hasGlyph(String)} with {@code name}.
   * <ul>
   *   <li>When {@code g9}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'g9'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTrueTypeFont.hasGlyph(String)"})
  void testHasGlyphWithName_whenG9_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDTrueTypeFont(new COSDictionary())).hasGlyph("g9"));
  }

  /**
   * Test {@link PDTrueTypeFont#hasGlyph(String)} with {@code name}.
   * <ul>
   *   <li>When {@code g942}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'g942'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTrueTypeFont.hasGlyph(String)"})
  void testHasGlyphWithName_whenG942_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDTrueTypeFont(new COSDictionary())).hasGlyph("g942"));
  }

  /**
   * Test {@link PDTrueTypeFont#hasGlyph(String)} with {@code name}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'Name'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTrueTypeFont.hasGlyph(String)"})
  void testHasGlyphWithName_whenName_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDTrueTypeFont(new COSDictionary())).hasGlyph("Name"));
  }

  /**
   * Test {@link PDTrueTypeFont#hasGlyph(String)} with {@code name}.
   * <ul>
   *   <li>When {@code .notdef}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when '.notdef'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTrueTypeFont.hasGlyph(String)"})
  void testHasGlyphWithName_whenNotdef_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDTrueTypeFont(new COSDictionary())).hasGlyph(".notdef"));
  }

  /**
   * Test {@link PDTrueTypeFont#hasGlyph(String)} with {@code name}.
   * <ul>
   *   <li>When {@code uni}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'uni'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDTrueTypeFont.hasGlyph(String)"})
  void testHasGlyphWithName_whenUni_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDTrueTypeFont(new COSDictionary())).hasGlyph("uni"));
  }

  /**
   * Test {@link PDTrueTypeFont#codeToGID(int)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#codeToGID(int)}
   */
  @Test
  @DisplayName("Test codeToGID(int); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDTrueTypeFont.codeToGID(int)"})
  void testCodeToGID_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, (new PDTrueTypeFont(new COSDictionary())).codeToGID(1));
  }

  /**
   * Test {@link PDTrueTypeFont#codeToGID(int)}.
   * <ul>
   *   <li>When two hundred fifty-five.</li>
   *   <li>Then return one hundred ninety-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#codeToGID(int)}
   */
  @Test
  @DisplayName("Test codeToGID(int); when two hundred fifty-five; then return one hundred ninety-one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDTrueTypeFont.codeToGID(int)"})
  void testCodeToGID_whenTwoHundredFiftyFive_thenReturnOneHundredNinetyOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(191, (new PDTrueTypeFont(new COSDictionary())).codeToGID(255));
  }
}
