package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.GlyphSubstitutionTable;
import org.apache.fontbox.ttf.HeaderTable;
import org.apache.fontbox.ttf.HorizontalHeaderTable;
import org.apache.fontbox.ttf.HorizontalMetricsTable;
import org.apache.fontbox.ttf.OS2WindowsMetricsTable;
import org.apache.fontbox.ttf.PostScriptTable;
import org.apache.fontbox.ttf.SubstitutingCmapLookup;
import org.apache.fontbox.ttf.TTFTable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.encoding.BuiltInEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.MacExpertEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.MacOSRomanEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.StandardEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.SymbolEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.ZapfDingbatsEncoding;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDTrueTypeFontDiffblueTest {
  /**
   * Test {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDTrueTypeFont(COSDictionary); when COSDictionary(); then return COSObject is COSDictionary()")
  void testNewPDTrueTypeFont_whenCOSDictionary_thenReturnCOSObjectIsCOSDictionary() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    // Act
    PDTrueTypeFont actualPdTrueTypeFont = new PDTrueTypeFont(fontDictionary);

    // Assert
    FontBoxFont fontBoxFont = actualPdTrueTypeFont.getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) fontBoxFont).getTableMap();
    assertEquals(25, tableMap.size());
    assertEquals(3, ((TrueTypeFont) fontBoxFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("DSIG"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("gasp"));
    assertSame(fontDictionary, actualPdTrueTypeFont.getCOSObject());
    Matrix expectedFontMatrix = actualPdTrueTypeFont.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualPdTrueTypeFont.getFontMatrix());
    assertSame(fontBoxFont, actualPdTrueTypeFont.getTrueTypeFont());
  }

  /**
   * Test {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDTrueTypeFont(COSDictionary); when COSStream(); then return COSObject is COSStream()")
  void testNewPDTrueTypeFont_whenCOSStream_thenReturnCOSObjectIsCOSStream() throws IOException {
    // Arrange
    COSStream fontDictionary = new COSStream();

    // Act
    PDTrueTypeFont actualPdTrueTypeFont = new PDTrueTypeFont(fontDictionary);

    // Assert
    FontBoxFont fontBoxFont = actualPdTrueTypeFont.getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) fontBoxFont).getTableMap();
    assertEquals(25, tableMap.size());
    assertEquals(3, ((TrueTypeFont) fontBoxFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("DSIG"));
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("gasp"));
    assertSame(fontDictionary, actualPdTrueTypeFont.getCOSObject());
    Matrix expectedFontMatrix = actualPdTrueTypeFont.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualPdTrueTypeFont.getFontMatrix());
    assertSame(fontBoxFont, actualPdTrueTypeFont.getTrueTypeFont());
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with
   * {@code doc}, {@code ttf}, {@code encoding}.
   * <p>
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'")
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
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with
   * {@code doc}, {@code ttf}, {@code encoding}.
   * <p>
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'")
  void testLoadWithDocTtfEncoding2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getTypoAscender()).thenThrow(new NumberFormatException("H"));
    when(os2WindowsMetricsTable.getFamilyClass()).thenReturn(1);
    when(os2WindowsMetricsTable.getFsSelection()).thenReturn(1);
    when(os2WindowsMetricsTable.getVersion()).thenReturn(1);
    when(os2WindowsMetricsTable.getWeightClass()).thenReturn(3);
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
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> PDTrueTypeFont.load(doc, ttf, MacExpertEncoding.INSTANCE));
    verify(headerTable).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getTypoAscender();
    verify(os2WindowsMetricsTable).getVersion();
    verify(os2WindowsMetricsTable).getWeightClass();
    verify(postScriptTable).getIsFixedPitch();
    verify(postScriptTable).getItalicAngle();
    verify(ttf).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getName();
    verify(ttf).getOS2Windows();
    verify(ttf).getPath(eq("H"));
    verify(ttf).getPostScript();
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with
   * {@code doc}, {@code ttf}, {@code encoding}.
   * <ul>
   *   <li>Given {@link CmapSubtable} (default constructor).</li>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; given CmapSubtable (default constructor); when PDDocument()")
  void testLoadWithDocTtfEncoding_givenCmapSubtable_whenPDDocument() throws IOException {
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
        .thenReturn(Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.TIMES_ROMAN, "Glyph Name"));
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
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with
   * {@code doc}, {@code ttf}, {@code encoding}.
   * <ul>
   *   <li>Given {@link Long#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; given MIN_VALUE")
  void testLoadWithDocTtfEncoding_givenMin_value() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
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
    when(ttf.getOriginalDataSize()).thenReturn(Long.MIN_VALUE);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getPath(Mockito.<String>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.TIMES_ROMAN, "Glyph Name"));
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
    verify(streamCacheCreateFunction).create();
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
    assertEquals(0.0f, fontDescriptor.getCapHeight());
    assertEquals(0.0f, fontDescriptor.getXHeight());
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
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with
   * {@code doc}, {@code ttf}, {@code encoding}.
   * <ul>
   *   <li>Given {@code x}.</li>
   *   <li>Then return FontDescriptor FontName is {@code x}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; given 'x'; then return FontDescriptor FontName is 'x'")
  void testLoadWithDocTtfEncoding_givenX_thenReturnFontDescriptorFontNameIsX() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getTypoAscender()).thenReturn(3);
    when(os2WindowsMetricsTable.getTypoDescender()).thenReturn(3);
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
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup substitutingCmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getUnicodeCmapLookup()).thenReturn(substitutingCmapLookup);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("x");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, MacExpertEncoding.INSTANCE);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), Mockito.<String[]>any(), isA(List.class));
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(eq(1));
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
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
    verify(streamCacheCreateFunction).create();
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
    assertEquals("x", fontDescriptor.getFontName());
    assertEquals("x", actualLoadResult.getBaseFont());
    assertEquals("x", actualLoadResult.getName());
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
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with
   * {@code doc}, {@code ttf}, {@code encoding}.
   * <ul>
   *   <li>Then calls
   * {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; then calls getSubstitution(int, String[], List)")
  void testLoadWithDocTtfEncoding_thenCallsGetSubstitution() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getTypoAscender()).thenReturn(3);
    when(os2WindowsMetricsTable.getTypoDescender()).thenReturn(3);
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
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup substitutingCmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getUnicodeCmapLookup()).thenReturn(substitutingCmapLookup);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, MacExpertEncoding.INSTANCE);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), Mockito.<String[]>any(), isA(List.class));
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(eq(1));
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
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
    verify(streamCacheCreateFunction).create();
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
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with
   * {@code doc}, {@code ttf}, {@code encoding}.
   * <ul>
   *   <li>Then return FontDescriptor Flags is ninety-eight.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; then return FontDescriptor Flags is ninety-eight")
  void testLoadWithDocTtfEncoding_thenReturnFontDescriptorFlagsIsNinetyEight() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getTypoAscender()).thenReturn(3);
    when(os2WindowsMetricsTable.getTypoDescender()).thenReturn(3);
    when(os2WindowsMetricsTable.getFamilyClass()).thenReturn(1);
    when(os2WindowsMetricsTable.getFsSelection()).thenReturn(1);
    when(os2WindowsMetricsTable.getVersion()).thenReturn(1);
    when(os2WindowsMetricsTable.getWeightClass()).thenReturn(3);
    when(os2WindowsMetricsTable.getFsType()).thenReturn((short) 1);
    PostScriptTable postScriptTable = mock(PostScriptTable.class);
    when(postScriptTable.getItalicAngle()).thenReturn(10.0f);
    when(postScriptTable.getIsFixedPitch()).thenReturn(-1L);
    HorizontalHeaderTable horizontalHeaderTable = mock(HorizontalHeaderTable.class);
    when(horizontalHeaderTable.getNumberOfHMetrics()).thenReturn(PDPanoseClassification.LENGTH);
    when(horizontalHeaderTable.getAscender()).thenReturn((short) 1);
    when(horizontalHeaderTable.getDescender()).thenReturn((short) 1);
    HeaderTable headerTable = mock(HeaderTable.class);
    when(headerTable.getUnitsPerEm()).thenReturn(1);
    when(headerTable.getXMax()).thenReturn((short) 1);
    when(headerTable.getXMin()).thenReturn((short) 1);
    when(headerTable.getYMax()).thenReturn((short) 1);
    when(headerTable.getYMin()).thenReturn((short) 1);
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup substitutingCmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getUnicodeCmapLookup()).thenReturn(substitutingCmapLookup);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, MacExpertEncoding.INSTANCE);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), Mockito.<String[]>any(), isA(List.class));
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalHeaderTable).getNumberOfHMetrics();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(eq(1));
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
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
    verify(streamCacheCreateFunction).create();
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
    assertEquals(98, fontDescriptor.getFlags());
    assertFalse(fontDescriptor.isFixedPitch());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualLoadResult.getFontMatrix());
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with
   * {@code doc}, {@code ttf}, {@code encoding}.
   * <ul>
   *   <li>Then return FontDescriptor Flags is ninety-seven.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; then return FontDescriptor Flags is ninety-seven")
  void testLoadWithDocTtfEncoding_thenReturnFontDescriptorFlagsIsNinetySeven() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getTypoAscender()).thenReturn(3);
    when(os2WindowsMetricsTable.getTypoDescender()).thenReturn(3);
    when(os2WindowsMetricsTable.getFamilyClass()).thenReturn(-1);
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
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup substitutingCmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getUnicodeCmapLookup()).thenReturn(substitutingCmapLookup);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, MacExpertEncoding.INSTANCE);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), Mockito.<String[]>any(), isA(List.class));
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(eq(1));
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
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
    verify(streamCacheCreateFunction).create();
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
    assertEquals(97, fontDescriptor.getFlags());
    assertFalse(fontDescriptor.isSerif());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualLoadResult.getFontMatrix());
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with
   * {@code doc}, {@code ttf}, {@code encoding}.
   * <ul>
   *   <li>Then return FontDescriptor Flags is thirty-five.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; then return FontDescriptor Flags is thirty-five")
  void testLoadWithDocTtfEncoding_thenReturnFontDescriptorFlagsIsThirtyFive() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getTypoAscender()).thenReturn(3);
    when(os2WindowsMetricsTable.getTypoDescender()).thenReturn(3);
    when(os2WindowsMetricsTable.getFamilyClass()).thenReturn(1);
    when(os2WindowsMetricsTable.getFsSelection()).thenReturn(0);
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
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup substitutingCmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getUnicodeCmapLookup()).thenReturn(substitutingCmapLookup);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, MacExpertEncoding.INSTANCE);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), Mockito.<String[]>any(), isA(List.class));
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(eq(1));
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
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
    verify(streamCacheCreateFunction).create();
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
    assertEquals(35, fontDescriptor.getFlags());
    assertFalse(fontDescriptor.isItalic());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualLoadResult.getFontMatrix());
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with
   * {@code doc}, {@code ttf}, {@code encoding}.
   * <ul>
   *   <li>Then return FontDescriptor FontFile2 Length is eight.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; then return FontDescriptor FontFile2 Length is eight")
  void testLoadWithDocTtfEncoding_thenReturnFontDescriptorFontFile2LengthIsEight() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getTypoAscender()).thenReturn(3);
    when(os2WindowsMetricsTable.getTypoDescender()).thenReturn(3);
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
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup substitutingCmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getUnicodeCmapLookup()).thenReturn(substitutingCmapLookup);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream(new byte[]{}));
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, MacExpertEncoding.INSTANCE);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), Mockito.<String[]>any(), isA(List.class));
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(eq(1));
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
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
    verify(streamCacheCreateFunction).create();
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
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    assertEquals(1, fontFile2.getFilters().size());
    assertEquals(8, fontFile2.getLength());
    assertEquals(8L, fontFile2.getCOSObject().getLength());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualLoadResult.getFontMatrix());
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with
   * {@code doc}, {@code ttf}, {@code encoding}.
   * <ul>
   *   <li>Then return Widths size is two hundred twenty-four.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; then return Widths size is two hundred twenty-four")
  void testLoadWithDocTtfEncoding_thenReturnWidthsSizeIsTwoHundredTwentyFour() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getTypoAscender()).thenReturn(3);
    when(os2WindowsMetricsTable.getTypoDescender()).thenReturn(3);
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
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup substitutingCmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getUnicodeCmapLookup()).thenReturn(substitutingCmapLookup);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    MacOSRomanEncoding encoding = MacOSRomanEncoding.INSTANCE;

    // Act
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, encoding);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(eq(1));
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
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
    verify(streamCacheCreateFunction).create();
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
    List<Float> widths = actualLoadResult.getWidths();
    assertEquals(224, widths.size());
    assertEquals(1000.0f, widths.get(223).floatValue());
    COSDictionary cOSObject = actualLoadResult.getCOSObject();
    assertEquals(7, cOSObject.getValues().size());
    assertEquals(7, cOSObject.size());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualLoadResult.getFontMatrix());
    MacOSRomanEncoding expectedEncoding = encoding.INSTANCE;
    assertSame(expectedEncoding, actualLoadResult.getEncoding());
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with
   * {@code doc}, {@code ttf}, {@code encoding}.
   * <ul>
   *   <li>When {@link SymbolEncoding#INSTANCE}.</li>
   *   <li>Then return Encoding is {@link SymbolEncoding#INSTANCE}
   * {@link SymbolEncoding#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; when INSTANCE; then return Encoding is INSTANCE INSTANCE")
  void testLoadWithDocTtfEncoding_whenInstance_thenReturnEncodingIsInstanceInstance() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getTypoAscender()).thenReturn(3);
    when(os2WindowsMetricsTable.getTypoDescender()).thenReturn(3);
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
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup substitutingCmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getUnicodeCmapLookup()).thenReturn(substitutingCmapLookup);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    SymbolEncoding encoding = SymbolEncoding.INSTANCE;

    // Act
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, encoding);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(eq(1));
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
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
    verify(streamCacheCreateFunction).create();
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
    SymbolEncoding expectedEncoding = encoding.INSTANCE;
    assertSame(expectedEncoding, actualLoadResult.getEncoding());
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with
   * {@code doc}, {@code ttf}, {@code encoding}.
   * <ul>
   *   <li>When {@link ZapfDingbatsEncoding#INSTANCE}.</li>
   *   <li>Then return Encoding is {@link ZapfDingbatsEncoding#INSTANCE}
   * {@link ZapfDingbatsEncoding#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; when INSTANCE; then return Encoding is INSTANCE INSTANCE")
  void testLoadWithDocTtfEncoding_whenInstance_thenReturnEncodingIsInstanceInstance2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getTypoAscender()).thenReturn(3);
    when(os2WindowsMetricsTable.getTypoDescender()).thenReturn(3);
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
    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any())).thenReturn(1);
    CmapSubtable cmap = new CmapSubtable();
    SubstitutingCmapLookup substitutingCmapLookup = new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getUnicodeCmapLookup()).thenReturn(substitutingCmapLookup);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    ZapfDingbatsEncoding encoding = ZapfDingbatsEncoding.INSTANCE;

    // Act
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, encoding);

    // Assert
    verify(gsub).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(anyInt());
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
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
    verify(streamCacheCreateFunction).create();
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
    ZapfDingbatsEncoding expectedEncoding = encoding.INSTANCE;
    assertSame(expectedEncoding, actualLoadResult.getEncoding());
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with
   * {@code doc}, {@code ttf}, {@code encoding}.
   * <ul>
   *   <li>When {@link StreamCacheCreateFunction}
   * {@link StreamCacheCreateFunction#create()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; when StreamCacheCreateFunction create() return 'null'")
  void testLoadWithDocTtfEncoding_whenStreamCacheCreateFunctionCreateReturnNull() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
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
        .thenReturn(Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.TIMES_ROMAN, "Glyph Name"));
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
    verify(streamCacheCreateFunction).create();
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
    assertEquals(0.0f, fontDescriptor.getCapHeight());
    assertEquals(0.0f, fontDescriptor.getXHeight());
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
   *   <li>Given {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getBaseFont()}
   */
  @Test
  @DisplayName("Test getBaseFont(); given PDTrueTypeFont(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetBaseFont_givenPDTrueTypeFontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDTrueTypeFont(new COSDictionary())).getBaseFont());
  }

  /**
   * Test {@link PDTrueTypeFont#getBaseFont()}.
   * <ul>
   *   <li>Given {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getBaseFont()}
   */
  @Test
  @DisplayName("Test getBaseFont(); given PDTrueTypeFont(COSDictionary) with fontDictionary is COSStream(); then return 'null'")
  void testGetBaseFont_givenPDTrueTypeFontWithFontDictionaryIsCOSStream_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDTrueTypeFont(new COSStream())).getBaseFont());
  }

  /**
   * Test {@link PDTrueTypeFont#readEncodingFromFont()}.
   * <ul>
   *   <li>Given {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#readEncodingFromFont()}
   */
  @Test
  @DisplayName("Test readEncodingFromFont(); given PDTrueTypeFont(COSDictionary) with fontDictionary is COSDictionary()")
  void testReadEncodingFromFont_givenPDTrueTypeFontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    Encoding actualReadEncodingFromFontResult = (new PDTrueTypeFont(new COSDictionary())).readEncodingFromFont();

    // Assert
    assertTrue(actualReadEncodingFromFontResult instanceof BuiltInEncoding);
    Map<Integer, String> codeToNameMap = actualReadEncodingFromFontResult.getCodeToNameMap();
    assertEquals(230, codeToNameMap.size());
    assertEquals("1", codeToNameMap.get(0));
    assertEquals("1", codeToNameMap.get(29));
    assertEquals("1", codeToNameMap.get(8));
    assertEquals("2", codeToNameMap.get(13));
    assertEquals("2", codeToNameMap.get(9));
    assertEquals("2", codeToNameMap.get(PDPanoseClassification.LENGTH));
    assertEquals("built-in (TTF)", actualReadEncodingFromFontResult.getEncodingName());
    Map<String, Integer> nameToCodeMap = actualReadEncodingFromFontResult.getNameToCodeMap();
    assertEquals(192, nameToCodeMap.size());
    assertEquals(117, nameToCodeMap.get("88").intValue());
    assertEquals(118, nameToCodeMap.get("89").intValue());
    assertEquals(140, nameToCodeMap.get("110").intValue());
    assertEquals(166, nameToCodeMap.get("230").intValue());
    assertEquals(194, nameToCodeMap.get("198").intValue());
    assertEquals(208, nameToCodeMap.get("231").intValue());
  }

  /**
   * Test {@link PDTrueTypeFont#readEncodingFromFont()}.
   * <ul>
   *   <li>Given {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#readEncodingFromFont()}
   */
  @Test
  @DisplayName("Test readEncodingFromFont(); given PDTrueTypeFont(COSDictionary) with fontDictionary is COSStream()")
  void testReadEncodingFromFont_givenPDTrueTypeFontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange and Act
    Encoding actualReadEncodingFromFontResult = (new PDTrueTypeFont(new COSStream())).readEncodingFromFont();

    // Assert
    assertTrue(actualReadEncodingFromFontResult instanceof BuiltInEncoding);
    Map<Integer, String> codeToNameMap = actualReadEncodingFromFontResult.getCodeToNameMap();
    assertEquals(230, codeToNameMap.size());
    assertEquals("1", codeToNameMap.get(0));
    assertEquals("1", codeToNameMap.get(29));
    assertEquals("1", codeToNameMap.get(8));
    assertEquals("2", codeToNameMap.get(13));
    assertEquals("2", codeToNameMap.get(9));
    assertEquals("2", codeToNameMap.get(PDPanoseClassification.LENGTH));
    assertEquals("built-in (TTF)", actualReadEncodingFromFontResult.getEncodingName());
    Map<String, Integer> nameToCodeMap = actualReadEncodingFromFontResult.getNameToCodeMap();
    assertEquals(192, nameToCodeMap.size());
    assertEquals(117, nameToCodeMap.get("88").intValue());
    assertEquals(118, nameToCodeMap.get("89").intValue());
    assertEquals(140, nameToCodeMap.get("110").intValue());
    assertEquals(166, nameToCodeMap.get("230").intValue());
    assertEquals(194, nameToCodeMap.get("198").intValue());
    assertEquals(208, nameToCodeMap.get("231").intValue());
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
   *   <li>Given {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDTrueTypeFont(COSDictionary) with fontDictionary is COSDictionary(); then return 'null'")
  void testGetName_givenPDTrueTypeFontWithFontDictionaryIsCOSDictionary_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDTrueTypeFont(new COSDictionary())).getName());
  }

  /**
   * Test {@link PDTrueTypeFont#getName()}.
   * <ul>
   *   <li>Given {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDTrueTypeFont(COSDictionary) with fontDictionary is COSStream(); then return 'null'")
  void testGetName_givenPDTrueTypeFontWithFontDictionaryIsCOSStream_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDTrueTypeFont(new COSStream())).getName());
  }

  /**
   * Test {@link PDTrueTypeFont#getBoundingBox()}.
   * <ul>
   *   <li>Given {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); given PDTrueTypeFont(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetBoundingBox_givenPDTrueTypeFontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    BoundingBox actualBoundingBox = (new PDTrueTypeFont(new COSDictionary())).getBoundingBox();

    // Assert
    assertEquals(-306.64062f, actualBoundingBox.getLowerLeftY());
    assertEquals(-568.3594f, actualBoundingBox.getLowerLeftX());
    assertEquals(1039.5508f, actualBoundingBox.getUpperRightY());
    assertEquals(1346.1914f, actualBoundingBox.getHeight());
    assertEquals(2045.8984f, actualBoundingBox.getUpperRightX());
    assertEquals(2614.2578f, actualBoundingBox.getWidth());
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
   * Test {@link PDTrueTypeFont#getBoundingBox()}.
   * <ul>
   *   <li>Then return LowerLeftY is {@code -306.64062}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); then return LowerLeftY is '-306.64062'")
  void testGetBoundingBox_thenReturnLowerLeftYIs30664062() throws IOException {
    // Arrange
    PDTrueTypeFont pdTrueTypeFont = new PDTrueTypeFont(new COSDictionary());
    pdTrueTypeFont.setFontDescriptor(new PDFontDescriptor());

    // Act
    BoundingBox actualBoundingBox = pdTrueTypeFont.getBoundingBox();

    // Assert
    assertEquals(-306.64062f, actualBoundingBox.getLowerLeftY());
    assertEquals(-568.3594f, actualBoundingBox.getLowerLeftX());
    assertEquals(1039.5508f, actualBoundingBox.getUpperRightY());
    assertEquals(1346.1914f, actualBoundingBox.getHeight());
    assertEquals(2045.8984f, actualBoundingBox.getUpperRightX());
    assertEquals(2614.2578f, actualBoundingBox.getWidth());
  }

  /**
   * Test {@link PDTrueTypeFont#getWidthFromFont(int)}.
   * <ul>
   *   <li>Then return {@code 777.83203}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int); then return '777.83203'")
  void testGetWidthFromFont_thenReturn77783203() throws IOException {
    // Arrange, Act and Assert
    assertEquals(777.83203f, (new PDTrueTypeFont(new COSDictionary())).getWidthFromFont(1));
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
  void testGetWidthFromFont_whenTwoHundredFiftyFive_thenReturnFiveHundred() throws IOException {
    // Arrange, Act and Assert
    assertEquals(500.0f, (new PDTrueTypeFont(new COSDictionary())).getWidthFromFont(255));
  }

  /**
   * Test {@link PDTrueTypeFont#getHeight(int)}.
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException(String)} with
   * {@code foo}.</li>
   *   <li>When one.</li>
   *   <li>Then return {@code 1280.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); given NumberFormatException(String) with 'foo'; when one; then return '1280.0'")
  void testGetHeight_givenNumberFormatExceptionWithFoo_whenOne_thenReturn12800() throws IOException {
    // Arrange
    new NumberFormatException("foo");
    new NumberFormatException("foo");

    // Act and Assert
    assertEquals(1280.0f, (new PDTrueTypeFont(new COSDictionary())).getHeight(1));
  }

  /**
   * Test {@link PDTrueTypeFont#getHeight(int)}.
   * <ul>
   *   <li>When one hundred fifty.</li>
   *   <li>Then return {@code 1356.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); when one hundred fifty; then return '1356.0'")
  void testGetHeight_whenOneHundredFifty_thenReturn13560() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1356.0f, (new PDTrueTypeFont(new COSDictionary())).getHeight(150));
  }

  /**
   * Test {@link PDTrueTypeFont#getHeight(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code 1280.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); when one; then return '1280.0'")
  void testGetHeight_whenOne_thenReturn12800() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1280.0f, (new PDTrueTypeFont(new COSDictionary())).getHeight(1));
  }

  /**
   * Test {@link PDTrueTypeFont#getHeight(int)}.
   * <ul>
   *   <li>When two hundred fifty-five.</li>
   *   <li>Then return {@code 1779.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); when two hundred fifty-five; then return '1779.0'")
  void testGetHeight_whenTwoHundredFiftyFive_thenReturn17790() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1779.0f, (new PDTrueTypeFont(new COSDictionary())).getHeight(255));
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
  void testGetHeight_whenZero_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDTrueTypeFont(new COSDictionary())).getHeight(0));
  }

  /**
   * Test {@link PDTrueTypeFont#encode(int)} with {@code unicode}.
   * <ul>
   *   <li>Given {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'; given PDTrueTypeFont(COSDictionary) with fontDictionary is COSStream()")
  void testEncodeWithUnicode_givenPDTrueTypeFontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDTrueTypeFont(new COSStream())).encode(1));
  }

  /**
   * Test {@link PDTrueTypeFont#encode(int)} with {@code unicode}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'; then throw IllegalArgumentException")
  void testEncodeWithUnicode_thenThrowIllegalArgumentException() throws IOException {
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
  void testGetGIDToCode_thenReturnSizeIsOneHundredNinetyTwo() throws IOException {
    // Arrange and Act
    Map<Integer, Integer> actualGIDToCode = (new PDTrueTypeFont(new COSDictionary())).getGIDToCode();

    // Assert
    assertEquals(192, actualGIDToCode.size());
    assertEquals(0, actualGIDToCode.get(1).intValue());
    assertEquals(1, actualGIDToCode.get(0).intValue());
    assertEquals(175, actualGIDToCode.get(256).intValue());
    assertEquals(183, actualGIDToCode.get(257).intValue());
    assertEquals(33, actualGIDToCode.get(4).intValue());
    assertEquals(34, actualGIDToCode.get(5).intValue());
    assertEquals(35, actualGIDToCode.get(6).intValue());
    assertEquals(36, actualGIDToCode.get(7).intValue());
    assertEquals(37, actualGIDToCode.get(8).intValue());
    assertEquals(9, actualGIDToCode.get(2).intValue());
    assertEquals(Integer.SIZE, actualGIDToCode.get(3).intValue());
  }

  /**
   * Test {@link PDTrueTypeFont#getPath(int)} with {@code code}.
   * <ul>
   *   <li>Then return Bounds Location {@link Point#y} is minus four hundred
   * forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; then return Bounds Location y is minus four hundred forty-two")
  void testGetPathWithCode_thenReturnBoundsLocationYIsMinusFourHundredFortyTwo() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary())).getPath(255);

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
    Dimension size = bounds.getSize();
    assertEquals(1000, size.width);
    assertEquals(1000, bounds.width);
    assertEquals(1000.0d, size.getWidth());
    assertEquals(1000.0d, bounds.getWidth());
    assertEquals(1012.0d, bounds.getMaxX());
    assertEquals(12.0d, location.getX());
    assertEquals(12.0d, bounds.getX());
    assertEquals(12.0d, bounds.getMinX());
    assertEquals(1337.0d, currentPoint.getY());
    assertEquals(1337.0d, bounds.getMaxY());
    assertEquals(1337.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(1779, size.height);
    assertEquals(1779, bounds.height);
    assertEquals(1779.0d, size.getHeight());
    assertEquals(1779.0d, bounds.getHeight());
    assertEquals(372.0d, currentPoint.getX());
    assertEquals(372.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(447.5d, bounds.getCenterY());
    assertEquals(512.0d, bounds.getCenterX());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertEquals(PDPanose.LENGTH, location.x);
    assertEquals(PDPanose.LENGTH, bounds.x);
  }

  /**
   * Test {@link PDTrueTypeFont#getPath(int)} with {@code code}.
   * <ul>
   *   <li>Then return Bounds Location {@link Point#y} is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getPath(int)}
   */
  @Test
  @DisplayName("Test getPath(int) with 'code'; then return Bounds Location y is zero")
  void testGetPathWithCode_thenReturnBoundsLocationYIsZero() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary())).getPath(1);

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
    assertEquals(0, location.y);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getMinY());
    Dimension size = bounds.getSize();
    assertEquals(1024, size.width);
    assertEquals(1024, bounds.width);
    assertEquals(1024.0d, size.getWidth());
    assertEquals(1024.0d, bounds.getWidth());
    assertEquals(1280, size.height);
    assertEquals(1280, bounds.height);
    assertEquals(1280.0d, size.getHeight());
    assertEquals(1280.0d, bounds.getHeight());
    assertEquals(1280.0d, bounds.getMaxY());
    assertEquals(1308.0d, bounds.getMaxX());
    assertEquals(284, location.x);
    assertEquals(284, bounds.x);
    assertEquals(284.0d, location.getX());
    assertEquals(284.0d, bounds.getX());
    assertEquals(284.0d, bounds.getMinX());
    assertEquals(316.0d, currentPoint.getX());
    assertEquals(316.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(32.0d, currentPoint.getY());
    assertEquals(32.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(640.0d, bounds.getCenterY());
    assertEquals(796.0d, bounds.getCenterX());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Test {@link PDTrueTypeFont#getPath(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code g9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; given COSDictionary(COSDictionary) with dict is COSDictionary(); when 'g9'")
  void testGetPathWithName_givenCOSDictionaryWithDictIsCOSDictionary_whenG9() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary(new COSDictionary()))).getPath("g9");

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
   * Test {@link PDTrueTypeFont#getPath(String)} with {@code name}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return CurrentPoint X is {@code 1257.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when '42'; then return CurrentPoint X is '1257.0'")
  void testGetPathWithName_when42_thenReturnCurrentPointXIs12570() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary())).getPath("42");

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
    assertEquals(1257.0d, currentPoint.getX());
    assertEquals(1257.0f, ((Point2D.Float) currentPoint).x);
    Dimension size = bounds.getSize();
    assertEquals(1378, size.width);
    assertEquals(1378, bounds.width);
    assertEquals(1378.0d, size.getWidth());
    assertEquals(1378.0d, bounds.getWidth());
    assertEquals(1387.0d, currentPoint.getY());
    assertEquals(1387.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(1450.0d, bounds.getMaxX());
    Point location = bounds.getLocation();
    assertEquals(72, location.x);
    assertEquals(72, bounds.x);
    assertEquals(72.0d, location.getX());
    assertEquals(72.0d, bounds.getX());
    assertEquals(72.0d, bounds.getMinX());
    assertEquals(761.0d, bounds.getCenterX());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
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
  void testGetPathWithName_whenG9_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary())).getPath("g9");

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
   * Test {@link PDTrueTypeFont#getPath(String)} with {@code name}.
   * <ul>
   *   <li>When {@code g942}.</li>
   *   <li>Then return Bounds Location {@link Point#y} is minus one hundred
   * eighty-six.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String) with 'name'; when 'g942'; then return Bounds Location y is minus one hundred eighty-six")
  void testGetPathWithName_whenG942_thenReturnBoundsLocationYIsMinusOneHundredEightySix() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary())).getPath("g942");

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
    assertEquals(-186, location.y);
    assertEquals(-186, bounds.y);
    assertEquals(-186.0d, location.getY());
    assertEquals(-186.0d, bounds.getY());
    assertEquals(-186.0d, bounds.getMinY());
    assertEquals(1001.0d, currentPoint.getX());
    assertEquals(1001.0d, bounds.getMaxX());
    assertEquals(1001.0f, ((Point2D.Float) currentPoint).x);
    Dimension size = bounds.getSize();
    assertEquals(1066, size.height);
    assertEquals(1066, bounds.height);
    assertEquals(1066.0d, size.getHeight());
    assertEquals(1066.0d, bounds.getHeight());
    assertEquals(293.0d, currentPoint.getY());
    assertEquals(293.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(347.0d, bounds.getCenterY());
    assertEquals(537.5d, bounds.getCenterX());
    assertEquals(74, location.x);
    assertEquals(74, bounds.x);
    assertEquals(74.0d, location.getX());
    assertEquals(74.0d, bounds.getX());
    assertEquals(74.0d, bounds.getMinX());
    assertEquals(880.0d, bounds.getMaxY());
    assertEquals(927, size.width);
    assertEquals(927, bounds.width);
    assertEquals(927.0d, size.getWidth());
    assertEquals(927.0d, bounds.getWidth());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
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
  void testGetPathWithName_whenName_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary())).getPath("Name");

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
  void testGetPathWithName_whenUni_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary())).getPath("uni");

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
   * Test {@link PDTrueTypeFont#getNormalizedPath(int)}.
   * <ul>
   *   <li>Given {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); given PDTrueTypeFont(COSDictionary) with fontDictionary is COSStream()")
  void testGetNormalizedPath_givenPDTrueTypeFontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDTrueTypeFont(new COSStream())).getNormalizedPath(1);

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
   * Test {@link PDTrueTypeFont#getNormalizedPath(int)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return Bounds2D is Bounds.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); when eight; then return Bounds2D is Bounds")
  void testGetNormalizedPath_whenEight_thenReturnBounds2DIsBounds() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDTrueTypeFont(new COSDictionary())).getNormalizedPath(8);

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
   * Test {@link PDTrueTypeFont#getNormalizedPath(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Bounds2D is Bounds.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); when one; then return Bounds2D is Bounds")
  void testGetNormalizedPath_whenOne_thenReturnBounds2DIsBounds() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDTrueTypeFont(new COSDictionary())).getNormalizedPath(1);

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
   * Test {@link PDTrueTypeFont#getNormalizedPath(int)}.
   * <ul>
   *   <li>When seventy-five.</li>
   *   <li>Then return Bounds Location X is sixteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); when seventy-five; then return Bounds Location X is sixteen")
  void testGetNormalizedPath_whenSeventyFive_thenReturnBoundsLocationXIsSixteen() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDTrueTypeFont(new COSDictionary())).getNormalizedPath(75);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualNormalizedPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
    Rectangle2D frame2 = bounds2D2.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Rectangle2D bounds2D3 = bounds2D2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle2D.Float);
    Point location = bounds.getLocation();
    assertEquals(16.0d, location.getX());
    assertEquals(16.0d, bounds.getX());
    assertEquals(16.0d, bounds.getMinX());
    assertEquals(16.6015625d, bounds2D2.getMinX());
    assertEquals(16.6015625d, bounds2D2.getX());
    assertEquals(16.601562f, ((Rectangle2D.Float) bounds2D2).x);
    assertEquals(298.828125d, currentPoint.getX());
    assertEquals(298.82812f, ((Point2D.Float) currentPoint).x);
    assertEquals(331.0546875d, bounds2D2.getCenterY());
    assertEquals(331.5d, bounds.getCenterY());
    assertEquals(367.1875d, currentPoint.getY());
    assertEquals(367.1875f, ((Point2D.Float) currentPoint).y);
    assertEquals(373.53515625d, bounds2D2.getCenterX());
    assertEquals(373.5d, bounds.getCenterX());
    assertEquals(662.109375d, bounds2D2.getHeight());
    assertEquals(662.109375d, bounds2D2.getMaxY());
    assertEquals(662.1094f, ((Rectangle2D.Float) bounds2D2).height);
    Dimension size = bounds.getSize();
    assertEquals(663, size.height);
    assertEquals(663, bounds.height);
    assertEquals(663.0d, size.getHeight());
    assertEquals(663.0d, bounds.getHeight());
    assertEquals(663.0d, bounds.getMaxY());
    assertEquals(713.8671875d, bounds2D2.getWidth());
    assertEquals(713.8672f, ((Rectangle2D.Float) bounds2D2).width);
    assertEquals(715, size.width);
    assertEquals(715, bounds.width);
    assertEquals(715.0d, size.getWidth());
    assertEquals(715.0d, bounds.getWidth());
    assertEquals(730.46875d, bounds2D2.getMaxX());
    assertEquals(731.0d, bounds.getMaxX());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(Short.SIZE, location.x);
    assertEquals(Short.SIZE, bounds.x);
    assertEquals(bounds2D2, frame2);
    assertEquals(bounds2D2, bounds2D3);
  }

  /**
   * Test {@link PDTrueTypeFont#getNormalizedPath(int)}.
   * <ul>
   *   <li>When two hundred fifty-five.</li>
   *   <li>Then return Bounds2D MinY is {@code -215.8203125}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#getNormalizedPath(int)}
   */
  @Test
  @DisplayName("Test getNormalizedPath(int); when two hundred fifty-five; then return Bounds2D MinY is '-215.8203125'")
  void testGetNormalizedPath_whenTwoHundredFiftyFive_thenReturnBounds2DMinYIs2158203125() throws IOException {
    // Arrange and Act
    GeneralPath actualNormalizedPath = (new PDTrueTypeFont(new COSDictionary())).getNormalizedPath(255);

    // Assert
    Rectangle bounds = actualNormalizedPath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Point2D currentPoint = actualNormalizedPath.getCurrentPoint();
    assertTrue(currentPoint instanceof Point2D.Float);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = actualNormalizedPath.getBounds2D();
    Rectangle2D frame2 = bounds2D2.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    Rectangle2D bounds2D3 = bounds2D2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle2D.Float);
    assertEquals(-215.8203125d, bounds2D2.getMinY());
    assertEquals(-215.8203125d, bounds2D2.getY());
    assertEquals(-215.82031f, ((Rectangle2D.Float) bounds2D2).y);
    Point location = bounds.getLocation();
    assertEquals(-216, location.y);
    assertEquals(-216, bounds.y);
    assertEquals(-216.0d, location.getY());
    assertEquals(-216.0d, bounds.getY());
    assertEquals(-216.0d, bounds.getMinY());
    assertEquals(181.640625d, currentPoint.getX());
    assertEquals(181.64062f, ((Point2D.Float) currentPoint).x);
    assertEquals(218.505859375d, bounds2D2.getCenterY());
    assertEquals(218.5d, bounds.getCenterY());
    assertEquals(250.0d, bounds.getCenterX());
    assertEquals(250.0d, bounds2D2.getCenterX());
    assertEquals(488.28125d, bounds2D2.getWidth());
    assertEquals(488.28125f, ((Rectangle2D.Float) bounds2D2).width);
    Dimension size = bounds.getSize();
    assertEquals(490, size.width);
    assertEquals(490, bounds.width);
    assertEquals(490.0d, size.getWidth());
    assertEquals(490.0d, bounds.getWidth());
    assertEquals(494.140625d, bounds2D2.getMaxX());
    assertEquals(495.0d, bounds.getMaxX());
    assertEquals(5, location.x);
    assertEquals(5, bounds.x);
    assertEquals(5.0d, location.getX());
    assertEquals(5.0d, bounds.getX());
    assertEquals(5.0d, bounds.getMinX());
    assertEquals(5.859375d, bounds2D2.getMinX());
    assertEquals(5.859375d, bounds2D2.getX());
    assertEquals(5.859375f, ((Rectangle2D.Float) bounds2D2).x);
    assertEquals(652.83203125d, currentPoint.getY());
    assertEquals(652.83203125d, bounds2D2.getMaxY());
    assertEquals(652.83203f, ((Point2D.Float) currentPoint).y);
    assertEquals(653.0d, bounds.getMaxY());
    assertEquals(868.65234375d, bounds2D2.getHeight());
    assertEquals(868.65234f, ((Rectangle2D.Float) bounds2D2).height);
    assertEquals(869, size.height);
    assertEquals(869, bounds.height);
    assertEquals(869.0d, size.getHeight());
    assertEquals(869.0d, bounds.getHeight());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds2D2, frame2);
    assertEquals(bounds2D2, bounds2D3);
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
  void testHasGlyphWithName_whenG9_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDTrueTypeFont(new COSDictionary())).hasGlyph("g9"));
  }

  /**
   * Test {@link PDTrueTypeFont#hasGlyph(String)} with {@code name}.
   * <ul>
   *   <li>When {@code g942}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String) with 'name'; when 'g942'; then return 'true'")
  void testHasGlyphWithName_whenG942_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDTrueTypeFont(new COSDictionary())).hasGlyph("g942"));
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
  void testHasGlyphWithName_whenName_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDTrueTypeFont(new COSDictionary())).hasGlyph("Name"));
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
  void testCodeToGID_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, (new PDTrueTypeFont(new COSDictionary())).codeToGID(1));
  }

  /**
   * Test {@link PDTrueTypeFont#codeToGID(int)}.
   * <ul>
   *   <li>When two hundred fifty-five.</li>
   *   <li>Then return one hundred eighty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTrueTypeFont#codeToGID(int)}
   */
  @Test
  @DisplayName("Test codeToGID(int); when two hundred fifty-five; then return one hundred eighty-five")
  void testCodeToGID_whenTwoHundredFiftyFive_thenReturnOneHundredEightyFive() throws IOException {
    // Arrange, Act and Assert
    assertEquals(185, (new PDTrueTypeFont(new COSDictionary())).codeToGID(255));
  }
}
