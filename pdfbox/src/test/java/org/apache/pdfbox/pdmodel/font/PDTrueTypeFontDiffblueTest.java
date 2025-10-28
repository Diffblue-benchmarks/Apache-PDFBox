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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.ttf.CmapLookup;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.CmapTable;
import org.apache.fontbox.ttf.GlyphSubstitutionTable;
import org.apache.fontbox.ttf.GlyphTable;
import org.apache.fontbox.ttf.HeaderTable;
import org.apache.fontbox.ttf.HorizontalHeaderTable;
import org.apache.fontbox.ttf.HorizontalMetricsTable;
import org.apache.fontbox.ttf.IndexToLocationTable;
import org.apache.fontbox.ttf.KerningTable;
import org.apache.fontbox.ttf.MaximumProfileTable;
import org.apache.fontbox.ttf.NameRecord;
import org.apache.fontbox.ttf.NamingTable;
import org.apache.fontbox.ttf.OS2WindowsMetricsTable;
import org.apache.fontbox.ttf.PostScriptTable;
import org.apache.fontbox.ttf.SubstitutingCmapLookup;
import org.apache.fontbox.ttf.TTFTable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.ttf.model.GsubData;
import org.apache.fontbox.ttf.model.Language;
import org.apache.fontbox.ttf.model.MapBackedGsubData;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDTrueTypeFontDiffblueTest {
  /**
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  void testLoad() throws IOException {
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
    MacExpertEncoding encoding = MacExpertEncoding.INSTANCE;

    // Act
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, encoding);

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
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    COSStream cOSObject = fontFile2.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    assertEquals("Font", actualLoadResult.getType());
    assertEquals("Name", fontDescriptor.getFontName());
    assertEquals("Name", actualLoadResult.getBaseFont());
    assertEquals("Name", actualLoadResult.getName());
    assertEquals("TrueType", actualLoadResult.getSubType());
    assertNull(fontDescriptor.getCharSet());
    assertNull(fontDescriptor.getFontFamily());
    assertNull(fontDescriptor.getFontStretch());
    assertNull(fontFile2.getDecodeParms());
    assertNull(fontFile2.getFileDecodeParams());
    assertNull(actualLoadResult.getStandard14AFM());
    assertNull(actualLoadResult.getToUnicodeCMap());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualLoadResult.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = fontDescriptor.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(filters.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(fontFile2.getMetadata());
    assertNull(fontDescriptor.getCIDSet());
    assertNull(fontDescriptor.getFontFile());
    assertNull(fontDescriptor.getFontFile3());
    assertNull(fontFile2.getFile());
    assertNull(fontDescriptor.getPanose());
    assertEquals(-1, fontFile2.getDecodedStreamLength());
    Map<Integer, Integer> gIDToCode = actualLoadResult.getGIDToCode();
    assertEquals(1, gIDToCode.size());
    assertEquals(0, gIDToCode.get(0).intValue());
    BoundingBox boundingBox = actualLoadResult.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(0.0f, fontBoundingBox.getHeight());
    assertEquals(0.0f, fontBoundingBox.getWidth());
    assertEquals(0.0f, fontDescriptor.getAverageWidth());
    assertEquals(0.0f, fontDescriptor.getCapHeight());
    assertEquals(0.0f, fontDescriptor.getLeading());
    assertEquals(0.0f, fontDescriptor.getMaxWidth());
    assertEquals(0.0f, fontDescriptor.getMissingWidth());
    assertEquals(0.0f, fontDescriptor.getStemH());
    assertEquals(0.0f, fontDescriptor.getStemV());
    assertEquals(0.0f, fontDescriptor.getXHeight());
    List<COSName> filters2 = fontFile2.getFilters();
    assertEquals(1, filters2.size());
    assertEquals(10.0f, fontDescriptor.getItalicAngle());
    List<Float> widths = actualLoadResult.getWidths();
    assertEquals(220, widths.size());
    assertEquals(1000.0f, widths.get(0).floatValue());
    assertEquals(1000.0f, widths.get(1).floatValue());
    assertEquals(1000.0f, widths.get(2).floatValue());
    assertEquals(1000.0f, widths.get(217).floatValue());
    assertEquals(1000.0f, widths.get(218).floatValue());
    assertEquals(1000.0f, widths.get(219).floatValue());
    assertEquals(1000.0f, boundingBox.getLowerLeftX());
    assertEquals(1000.0f, boundingBox.getLowerLeftY());
    assertEquals(1000.0f, boundingBox.getUpperRightX());
    assertEquals(1000.0f, boundingBox.getUpperRightY());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftX());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftY());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightX());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightY());
    assertEquals(1000.0f, actualLoadResult.getAverageFontWidth());
    assertEquals(1000.0f, actualLoadResult.getSpaceWidth());
    assertEquals(1000.0f, fontDescriptor.getAscent());
    assertEquals(1000.0f, fontDescriptor.getDescent());
    assertEquals(12L, cOSObject.getLength());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3.0f, fontDescriptor.getFontWeight());
    assertEquals(8, cOSObject2.getValues().size());
    assertEquals(8, cOSObject2.size());
    assertEquals(99, fontDescriptor.getFlags());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(fontDescriptor.isAllCap());
    assertFalse(fontDescriptor.isForceBold());
    assertFalse(fontDescriptor.isScript());
    assertFalse(fontDescriptor.isSmallCap());
    assertFalse(fontDescriptor.isSymbolic());
    assertFalse(actualLoadResult.getSymbolicFlag());
    assertFalse(actualLoadResult.isVertical());
    assertFalse(actualLoadResult.isDamaged());
    assertTrue(fontFile2.getFileFilters().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(cOSObject.hasData());
    assertTrue(fontDescriptor.isFixedPitch());
    assertTrue(fontDescriptor.isItalic());
    assertTrue(fontDescriptor.isNonSymbolic());
    assertTrue(fontDescriptor.isSerif());
    assertTrue(actualLoadResult.isEmbedded());
    assertEquals(PDPanose.LENGTH, cOSObject3.getValues().size());
    assertEquals(PDPanose.LENGTH, cOSObject3.size());
    assertEquals(PDPanose.LENGTH, fontFile2.getLength());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualLoadResult.getFontMatrix());
    MacExpertEncoding expectedEncoding = encoding.INSTANCE;
    assertSame(expectedEncoding, actualLoadResult.getEncoding());
    assertSame(ttf, actualLoadResult.getFontBoxFont());
    assertSame(ttf, actualLoadResult.getTrueTypeFont());
    assertSame(filters, filters2.get(0));
  }

  /**
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  void testLoad2() throws IOException {
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
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  void testLoad3() throws IOException {
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
    MacExpertEncoding encoding = MacExpertEncoding.INSTANCE;

    // Act
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, encoding);

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
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    COSStream cOSObject = fontFile2.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    assertEquals("Font", actualLoadResult.getType());
    assertEquals("Name", fontDescriptor.getFontName());
    assertEquals("Name", actualLoadResult.getBaseFont());
    assertEquals("Name", actualLoadResult.getName());
    assertEquals("TrueType", actualLoadResult.getSubType());
    assertNull(fontDescriptor.getCharSet());
    assertNull(fontDescriptor.getFontFamily());
    assertNull(fontDescriptor.getFontStretch());
    assertNull(fontFile2.getDecodeParms());
    assertNull(fontFile2.getFileDecodeParams());
    assertNull(actualLoadResult.getStandard14AFM());
    assertNull(actualLoadResult.getToUnicodeCMap());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualLoadResult.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = fontDescriptor.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(filters.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(fontFile2.getMetadata());
    assertNull(fontDescriptor.getCIDSet());
    assertNull(fontDescriptor.getFontFile());
    assertNull(fontDescriptor.getFontFile3());
    assertNull(fontFile2.getFile());
    assertNull(fontDescriptor.getPanose());
    assertEquals(-1, fontFile2.getDecodedStreamLength());
    Map<Integer, Integer> gIDToCode = actualLoadResult.getGIDToCode();
    assertEquals(1, gIDToCode.size());
    assertEquals(0, gIDToCode.get(0).intValue());
    BoundingBox boundingBox = actualLoadResult.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(0.0f, fontBoundingBox.getHeight());
    assertEquals(0.0f, fontBoundingBox.getWidth());
    assertEquals(0.0f, fontDescriptor.getAverageWidth());
    assertEquals(0.0f, fontDescriptor.getCapHeight());
    assertEquals(0.0f, fontDescriptor.getLeading());
    assertEquals(0.0f, fontDescriptor.getMaxWidth());
    assertEquals(0.0f, fontDescriptor.getMissingWidth());
    assertEquals(0.0f, fontDescriptor.getStemH());
    assertEquals(0.0f, fontDescriptor.getStemV());
    assertEquals(0.0f, fontDescriptor.getXHeight());
    List<COSName> filters2 = fontFile2.getFilters();
    assertEquals(1, filters2.size());
    assertEquals(10.0f, fontDescriptor.getItalicAngle());
    List<Float> widths = actualLoadResult.getWidths();
    assertEquals(220, widths.size());
    assertEquals(1000.0f, widths.get(0).floatValue());
    assertEquals(1000.0f, widths.get(1).floatValue());
    assertEquals(1000.0f, widths.get(2).floatValue());
    assertEquals(1000.0f, widths.get(217).floatValue());
    assertEquals(1000.0f, widths.get(218).floatValue());
    assertEquals(1000.0f, widths.get(219).floatValue());
    assertEquals(1000.0f, boundingBox.getLowerLeftX());
    assertEquals(1000.0f, boundingBox.getLowerLeftY());
    assertEquals(1000.0f, boundingBox.getUpperRightX());
    assertEquals(1000.0f, boundingBox.getUpperRightY());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftX());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftY());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightX());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightY());
    assertEquals(1000.0f, actualLoadResult.getAverageFontWidth());
    assertEquals(1000.0f, actualLoadResult.getSpaceWidth());
    assertEquals(1000.0f, fontDescriptor.getAscent());
    assertEquals(1000.0f, fontDescriptor.getDescent());
    assertEquals(12L, cOSObject.getLength());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3.0f, fontDescriptor.getFontWeight());
    assertEquals(8, cOSObject2.getValues().size());
    assertEquals(8, cOSObject2.size());
    assertEquals(99, fontDescriptor.getFlags());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(fontDescriptor.isAllCap());
    assertFalse(fontDescriptor.isForceBold());
    assertFalse(fontDescriptor.isScript());
    assertFalse(fontDescriptor.isSmallCap());
    assertFalse(fontDescriptor.isSymbolic());
    assertFalse(actualLoadResult.getSymbolicFlag());
    assertFalse(actualLoadResult.isVertical());
    assertFalse(actualLoadResult.isDamaged());
    assertTrue(fontFile2.getFileFilters().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(cOSObject.hasData());
    assertTrue(fontDescriptor.isFixedPitch());
    assertTrue(fontDescriptor.isItalic());
    assertTrue(fontDescriptor.isNonSymbolic());
    assertTrue(fontDescriptor.isSerif());
    assertTrue(actualLoadResult.isEmbedded());
    assertEquals(PDPanose.LENGTH, cOSObject3.getValues().size());
    assertEquals(PDPanose.LENGTH, cOSObject3.size());
    assertEquals(PDPanose.LENGTH, fontFile2.getLength());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualLoadResult.getFontMatrix());
    MacExpertEncoding expectedEncoding = encoding.INSTANCE;
    assertSame(expectedEncoding, actualLoadResult.getEncoding());
    assertSame(ttf, actualLoadResult.getFontBoxFont());
    assertSame(ttf, actualLoadResult.getTrueTypeFont());
    assertSame(filters, filters2.get(0));
  }

  /**
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  void testLoad4() throws IOException {
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
    MacExpertEncoding encoding = MacExpertEncoding.INSTANCE;

    // Act
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, encoding);

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
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    COSStream cOSObject = fontFile2.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    assertEquals("Font", actualLoadResult.getType());
    assertEquals("Name", fontDescriptor.getFontName());
    assertEquals("Name", actualLoadResult.getBaseFont());
    assertEquals("Name", actualLoadResult.getName());
    assertEquals("TrueType", actualLoadResult.getSubType());
    assertNull(fontDescriptor.getCharSet());
    assertNull(fontDescriptor.getFontFamily());
    assertNull(fontDescriptor.getFontStretch());
    assertNull(fontFile2.getDecodeParms());
    assertNull(fontFile2.getFileDecodeParams());
    assertNull(actualLoadResult.getStandard14AFM());
    assertNull(actualLoadResult.getToUnicodeCMap());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualLoadResult.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = fontDescriptor.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(filters.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(fontFile2.getMetadata());
    assertNull(fontDescriptor.getCIDSet());
    assertNull(fontDescriptor.getFontFile());
    assertNull(fontDescriptor.getFontFile3());
    assertNull(fontFile2.getFile());
    assertNull(fontDescriptor.getPanose());
    assertEquals(-1, fontFile2.getDecodedStreamLength());
    Map<Integer, Integer> gIDToCode = actualLoadResult.getGIDToCode();
    assertEquals(1, gIDToCode.size());
    assertEquals(0, gIDToCode.get(0).intValue());
    BoundingBox boundingBox = actualLoadResult.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(0.0f, fontBoundingBox.getHeight());
    assertEquals(0.0f, fontBoundingBox.getWidth());
    assertEquals(0.0f, fontDescriptor.getAverageWidth());
    assertEquals(0.0f, fontDescriptor.getCapHeight());
    assertEquals(0.0f, fontDescriptor.getLeading());
    assertEquals(0.0f, fontDescriptor.getMaxWidth());
    assertEquals(0.0f, fontDescriptor.getMissingWidth());
    assertEquals(0.0f, fontDescriptor.getStemH());
    assertEquals(0.0f, fontDescriptor.getStemV());
    assertEquals(0.0f, fontDescriptor.getXHeight());
    List<COSName> filters2 = fontFile2.getFilters();
    assertEquals(1, filters2.size());
    assertEquals(10.0f, fontDescriptor.getItalicAngle());
    List<Float> widths = actualLoadResult.getWidths();
    assertEquals(220, widths.size());
    assertEquals(1000.0f, widths.get(0).floatValue());
    assertEquals(1000.0f, widths.get(1).floatValue());
    assertEquals(1000.0f, widths.get(2).floatValue());
    assertEquals(1000.0f, widths.get(217).floatValue());
    assertEquals(1000.0f, widths.get(218).floatValue());
    assertEquals(1000.0f, widths.get(219).floatValue());
    assertEquals(1000.0f, boundingBox.getLowerLeftX());
    assertEquals(1000.0f, boundingBox.getLowerLeftY());
    assertEquals(1000.0f, boundingBox.getUpperRightX());
    assertEquals(1000.0f, boundingBox.getUpperRightY());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftX());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftY());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightX());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightY());
    assertEquals(1000.0f, actualLoadResult.getAverageFontWidth());
    assertEquals(1000.0f, actualLoadResult.getSpaceWidth());
    assertEquals(1000.0f, fontDescriptor.getAscent());
    assertEquals(1000.0f, fontDescriptor.getDescent());
    assertEquals(12L, cOSObject.getLength());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3.0f, fontDescriptor.getFontWeight());
    assertEquals(8, cOSObject2.getValues().size());
    assertEquals(8, cOSObject2.size());
    assertEquals(99, fontDescriptor.getFlags());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(fontDescriptor.isAllCap());
    assertFalse(fontDescriptor.isForceBold());
    assertFalse(fontDescriptor.isScript());
    assertFalse(fontDescriptor.isSmallCap());
    assertFalse(fontDescriptor.isSymbolic());
    assertFalse(actualLoadResult.getSymbolicFlag());
    assertFalse(actualLoadResult.isVertical());
    assertFalse(actualLoadResult.isDamaged());
    assertTrue(fontFile2.getFileFilters().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(cOSObject.hasData());
    assertTrue(fontDescriptor.isFixedPitch());
    assertTrue(fontDescriptor.isItalic());
    assertTrue(fontDescriptor.isNonSymbolic());
    assertTrue(fontDescriptor.isSerif());
    assertTrue(actualLoadResult.isEmbedded());
    assertEquals(PDPanose.LENGTH, cOSObject3.getValues().size());
    assertEquals(PDPanose.LENGTH, cOSObject3.size());
    assertEquals(PDPanose.LENGTH, fontFile2.getLength());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualLoadResult.getFontMatrix());
    MacExpertEncoding expectedEncoding = encoding.INSTANCE;
    assertSame(expectedEncoding, actualLoadResult.getEncoding());
    assertSame(ttf, actualLoadResult.getFontBoxFont());
    assertSame(ttf, actualLoadResult.getTrueTypeFont());
    assertSame(filters, filters2.get(0));
  }

  /**
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  void testLoad5() throws IOException {
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
    MacExpertEncoding encoding = MacExpertEncoding.INSTANCE;

    // Act
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, encoding);

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
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    COSStream cOSObject = fontFile2.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    assertEquals("Font", actualLoadResult.getType());
    assertEquals("Name", fontDescriptor.getFontName());
    assertEquals("Name", actualLoadResult.getBaseFont());
    assertEquals("Name", actualLoadResult.getName());
    assertEquals("TrueType", actualLoadResult.getSubType());
    assertNull(fontDescriptor.getCharSet());
    assertNull(fontDescriptor.getFontFamily());
    assertNull(fontDescriptor.getFontStretch());
    assertNull(fontFile2.getDecodeParms());
    assertNull(fontFile2.getFileDecodeParams());
    assertNull(actualLoadResult.getStandard14AFM());
    assertNull(actualLoadResult.getToUnicodeCMap());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualLoadResult.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = fontDescriptor.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(filters.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(fontFile2.getMetadata());
    assertNull(fontDescriptor.getCIDSet());
    assertNull(fontDescriptor.getFontFile());
    assertNull(fontDescriptor.getFontFile3());
    assertNull(fontFile2.getFile());
    assertNull(fontDescriptor.getPanose());
    assertEquals(-1, fontFile2.getDecodedStreamLength());
    Map<Integer, Integer> gIDToCode = actualLoadResult.getGIDToCode();
    assertEquals(1, gIDToCode.size());
    assertEquals(0, gIDToCode.get(0).intValue());
    BoundingBox boundingBox = actualLoadResult.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(0.0f, fontBoundingBox.getHeight());
    assertEquals(0.0f, fontBoundingBox.getWidth());
    assertEquals(0.0f, fontDescriptor.getAverageWidth());
    assertEquals(0.0f, fontDescriptor.getLeading());
    assertEquals(0.0f, fontDescriptor.getMaxWidth());
    assertEquals(0.0f, fontDescriptor.getMissingWidth());
    assertEquals(0.0f, fontDescriptor.getStemH());
    assertEquals(0.0f, fontDescriptor.getStemV());
    List<COSName> filters2 = fontFile2.getFilters();
    assertEquals(1, filters2.size());
    assertEquals(10.0f, fontDescriptor.getItalicAngle());
    List<Float> widths = actualLoadResult.getWidths();
    assertEquals(220, widths.size());
    assertEquals(1000.0f, widths.get(0).floatValue());
    assertEquals(1000.0f, widths.get(1).floatValue());
    assertEquals(1000.0f, widths.get(2).floatValue());
    assertEquals(1000.0f, widths.get(217).floatValue());
    assertEquals(1000.0f, widths.get(218).floatValue());
    assertEquals(1000.0f, widths.get(219).floatValue());
    assertEquals(1000.0f, boundingBox.getLowerLeftX());
    assertEquals(1000.0f, boundingBox.getLowerLeftY());
    assertEquals(1000.0f, boundingBox.getUpperRightX());
    assertEquals(1000.0f, boundingBox.getUpperRightY());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftX());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftY());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightX());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightY());
    assertEquals(1000.0f, actualLoadResult.getAverageFontWidth());
    assertEquals(1000.0f, actualLoadResult.getSpaceWidth());
    assertEquals(1000.0f, fontDescriptor.getAscent());
    assertEquals(1000.0f, fontDescriptor.getDescent());
    assertEquals(12L, cOSObject.getLength());
    assertEquals(1500.0f, fontDescriptor.getXHeight());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3.0f, fontDescriptor.getFontWeight());
    assertEquals(6000.0f, fontDescriptor.getCapHeight());
    assertEquals(8, cOSObject2.getValues().size());
    assertEquals(8, cOSObject2.size());
    assertEquals(99, fontDescriptor.getFlags());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(fontDescriptor.isAllCap());
    assertFalse(fontDescriptor.isForceBold());
    assertFalse(fontDescriptor.isScript());
    assertFalse(fontDescriptor.isSmallCap());
    assertFalse(fontDescriptor.isSymbolic());
    assertFalse(actualLoadResult.getSymbolicFlag());
    assertFalse(actualLoadResult.isVertical());
    assertFalse(actualLoadResult.isDamaged());
    assertTrue(fontFile2.getFileFilters().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(cOSObject.hasData());
    assertTrue(fontDescriptor.isFixedPitch());
    assertTrue(fontDescriptor.isItalic());
    assertTrue(fontDescriptor.isNonSymbolic());
    assertTrue(fontDescriptor.isSerif());
    assertTrue(actualLoadResult.isEmbedded());
    assertEquals(PDPanose.LENGTH, cOSObject3.getValues().size());
    assertEquals(PDPanose.LENGTH, cOSObject3.size());
    assertEquals(PDPanose.LENGTH, fontFile2.getLength());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualLoadResult.getFontMatrix());
    MacExpertEncoding expectedEncoding = encoding.INSTANCE;
    assertSame(expectedEncoding, actualLoadResult.getEncoding());
    assertSame(ttf, actualLoadResult.getFontBoxFont());
    assertSame(ttf, actualLoadResult.getTrueTypeFont());
    assertSame(filters, filters2.get(0));
  }

  /**
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  void testLoad6() throws IOException {
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
    MacExpertEncoding encoding = MacExpertEncoding.INSTANCE;

    // Act
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, encoding);

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
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    COSStream cOSObject = fontFile2.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    assertEquals("Font", actualLoadResult.getType());
    assertEquals("Name", fontDescriptor.getFontName());
    assertEquals("Name", actualLoadResult.getBaseFont());
    assertEquals("Name", actualLoadResult.getName());
    assertEquals("TrueType", actualLoadResult.getSubType());
    assertNull(fontDescriptor.getCharSet());
    assertNull(fontDescriptor.getFontFamily());
    assertNull(fontDescriptor.getFontStretch());
    assertNull(fontFile2.getDecodeParms());
    assertNull(fontFile2.getFileDecodeParams());
    assertNull(actualLoadResult.getStandard14AFM());
    assertNull(actualLoadResult.getToUnicodeCMap());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualLoadResult.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = fontDescriptor.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(filters.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(fontFile2.getMetadata());
    assertNull(fontDescriptor.getCIDSet());
    assertNull(fontDescriptor.getFontFile());
    assertNull(fontDescriptor.getFontFile3());
    assertNull(fontFile2.getFile());
    assertNull(fontDescriptor.getPanose());
    assertEquals(-1, fontFile2.getDecodedStreamLength());
    Map<Integer, Integer> gIDToCode = actualLoadResult.getGIDToCode();
    assertEquals(1, gIDToCode.size());
    assertEquals(0, gIDToCode.get(0).intValue());
    BoundingBox boundingBox = actualLoadResult.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(0.0f, fontBoundingBox.getHeight());
    assertEquals(0.0f, fontBoundingBox.getWidth());
    assertEquals(0.0f, fontDescriptor.getAverageWidth());
    assertEquals(0.0f, fontDescriptor.getLeading());
    assertEquals(0.0f, fontDescriptor.getMaxWidth());
    assertEquals(0.0f, fontDescriptor.getMissingWidth());
    assertEquals(0.0f, fontDescriptor.getStemH());
    assertEquals(0.0f, fontDescriptor.getStemV());
    List<COSName> filters2 = fontFile2.getFilters();
    assertEquals(1, filters2.size());
    assertEquals(10.0f, fontDescriptor.getItalicAngle());
    List<Float> widths = actualLoadResult.getWidths();
    assertEquals(220, widths.size());
    assertEquals(1000.0f, widths.get(0).floatValue());
    assertEquals(1000.0f, widths.get(1).floatValue());
    assertEquals(1000.0f, widths.get(2).floatValue());
    assertEquals(1000.0f, widths.get(217).floatValue());
    assertEquals(1000.0f, widths.get(218).floatValue());
    assertEquals(1000.0f, widths.get(219).floatValue());
    assertEquals(1000.0f, boundingBox.getLowerLeftX());
    assertEquals(1000.0f, boundingBox.getLowerLeftY());
    assertEquals(1000.0f, boundingBox.getUpperRightX());
    assertEquals(1000.0f, boundingBox.getUpperRightY());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftX());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftY());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightX());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightY());
    assertEquals(1000.0f, actualLoadResult.getAverageFontWidth());
    assertEquals(1000.0f, actualLoadResult.getSpaceWidth());
    assertEquals(1000.0f, fontDescriptor.getAscent());
    assertEquals(1000.0f, fontDescriptor.getDescent());
    assertEquals(1500.0f, fontDescriptor.getXHeight());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3.0f, fontDescriptor.getFontWeight());
    assertEquals(6000.0f, fontDescriptor.getCapHeight());
    assertEquals(8, cOSObject2.getValues().size());
    assertEquals(8, cOSObject2.size());
    assertEquals(8, fontFile2.getLength());
    assertEquals(8L, cOSObject.getLength());
    assertEquals(99, fontDescriptor.getFlags());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(fontDescriptor.isAllCap());
    assertFalse(fontDescriptor.isForceBold());
    assertFalse(fontDescriptor.isScript());
    assertFalse(fontDescriptor.isSmallCap());
    assertFalse(fontDescriptor.isSymbolic());
    assertFalse(actualLoadResult.getSymbolicFlag());
    assertFalse(actualLoadResult.isVertical());
    assertFalse(actualLoadResult.isDamaged());
    assertTrue(fontFile2.getFileFilters().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(cOSObject.hasData());
    assertTrue(fontDescriptor.isFixedPitch());
    assertTrue(fontDescriptor.isItalic());
    assertTrue(fontDescriptor.isNonSymbolic());
    assertTrue(fontDescriptor.isSerif());
    assertTrue(actualLoadResult.isEmbedded());
    assertEquals(PDPanose.LENGTH, cOSObject3.getValues().size());
    assertEquals(PDPanose.LENGTH, cOSObject3.size());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualLoadResult.getFontMatrix());
    MacExpertEncoding expectedEncoding = encoding.INSTANCE;
    assertSame(expectedEncoding, actualLoadResult.getEncoding());
    assertSame(ttf, actualLoadResult.getFontBoxFont());
    assertSame(ttf, actualLoadResult.getTrueTypeFont());
    assertSame(filters, filters2.get(0));
  }

  /**
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  void testLoad7() throws IOException {
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
    MacExpertEncoding encoding = MacExpertEncoding.INSTANCE;

    // Act
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, encoding);

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
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    COSStream cOSObject = fontFile2.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    assertEquals("Font", actualLoadResult.getType());
    assertEquals("Name", fontDescriptor.getFontName());
    assertEquals("Name", actualLoadResult.getBaseFont());
    assertEquals("Name", actualLoadResult.getName());
    assertEquals("TrueType", actualLoadResult.getSubType());
    assertNull(fontDescriptor.getCharSet());
    assertNull(fontDescriptor.getFontFamily());
    assertNull(fontDescriptor.getFontStretch());
    assertNull(fontFile2.getDecodeParms());
    assertNull(fontFile2.getFileDecodeParams());
    assertNull(actualLoadResult.getStandard14AFM());
    assertNull(actualLoadResult.getToUnicodeCMap());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualLoadResult.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = fontDescriptor.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(filters.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(fontFile2.getMetadata());
    assertNull(fontDescriptor.getCIDSet());
    assertNull(fontDescriptor.getFontFile());
    assertNull(fontDescriptor.getFontFile3());
    assertNull(fontFile2.getFile());
    assertNull(fontDescriptor.getPanose());
    assertEquals(-1, fontFile2.getDecodedStreamLength());
    Map<Integer, Integer> gIDToCode = actualLoadResult.getGIDToCode();
    assertEquals(1, gIDToCode.size());
    assertEquals(0, gIDToCode.get(0).intValue());
    BoundingBox boundingBox = actualLoadResult.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(0.0f, fontBoundingBox.getHeight());
    assertEquals(0.0f, fontBoundingBox.getWidth());
    assertEquals(0.0f, fontDescriptor.getAverageWidth());
    assertEquals(0.0f, fontDescriptor.getLeading());
    assertEquals(0.0f, fontDescriptor.getMaxWidth());
    assertEquals(0.0f, fontDescriptor.getMissingWidth());
    assertEquals(0.0f, fontDescriptor.getStemH());
    assertEquals(0.0f, fontDescriptor.getStemV());
    List<COSName> filters2 = fontFile2.getFilters();
    assertEquals(1, filters2.size());
    assertEquals(10.0f, fontDescriptor.getItalicAngle());
    List<Float> widths = actualLoadResult.getWidths();
    assertEquals(220, widths.size());
    assertEquals(1000.0f, widths.get(0).floatValue());
    assertEquals(1000.0f, widths.get(1).floatValue());
    assertEquals(1000.0f, widths.get(2).floatValue());
    assertEquals(1000.0f, widths.get(217).floatValue());
    assertEquals(1000.0f, widths.get(218).floatValue());
    assertEquals(1000.0f, widths.get(219).floatValue());
    assertEquals(1000.0f, boundingBox.getLowerLeftX());
    assertEquals(1000.0f, boundingBox.getLowerLeftY());
    assertEquals(1000.0f, boundingBox.getUpperRightX());
    assertEquals(1000.0f, boundingBox.getUpperRightY());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftX());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftY());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightX());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightY());
    assertEquals(1000.0f, actualLoadResult.getAverageFontWidth());
    assertEquals(1000.0f, actualLoadResult.getSpaceWidth());
    assertEquals(1000.0f, fontDescriptor.getAscent());
    assertEquals(1000.0f, fontDescriptor.getDescent());
    assertEquals(12L, cOSObject.getLength());
    assertEquals(1500.0f, fontDescriptor.getXHeight());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3.0f, fontDescriptor.getFontWeight());
    assertEquals(6000.0f, fontDescriptor.getCapHeight());
    assertEquals(8, cOSObject2.getValues().size());
    assertEquals(8, cOSObject2.size());
    assertEquals(98, fontDescriptor.getFlags());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(fontDescriptor.isAllCap());
    assertFalse(fontDescriptor.isFixedPitch());
    assertFalse(fontDescriptor.isForceBold());
    assertFalse(fontDescriptor.isScript());
    assertFalse(fontDescriptor.isSmallCap());
    assertFalse(fontDescriptor.isSymbolic());
    assertFalse(actualLoadResult.getSymbolicFlag());
    assertFalse(actualLoadResult.isVertical());
    assertFalse(actualLoadResult.isDamaged());
    assertTrue(fontFile2.getFileFilters().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(cOSObject.hasData());
    assertTrue(fontDescriptor.isItalic());
    assertTrue(fontDescriptor.isNonSymbolic());
    assertTrue(fontDescriptor.isSerif());
    assertTrue(actualLoadResult.isEmbedded());
    assertEquals(PDPanose.LENGTH, cOSObject3.getValues().size());
    assertEquals(PDPanose.LENGTH, cOSObject3.size());
    assertEquals(PDPanose.LENGTH, fontFile2.getLength());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualLoadResult.getFontMatrix());
    MacExpertEncoding expectedEncoding = encoding.INSTANCE;
    assertSame(expectedEncoding, actualLoadResult.getEncoding());
    assertSame(ttf, actualLoadResult.getFontBoxFont());
    assertSame(ttf, actualLoadResult.getTrueTypeFont());
    assertSame(filters, filters2.get(0));
  }

  /**
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  void testLoad8() throws IOException {
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
    MacExpertEncoding encoding = MacExpertEncoding.INSTANCE;

    // Act
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, encoding);

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
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    COSStream cOSObject = fontFile2.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    assertEquals("Font", actualLoadResult.getType());
    assertEquals("TrueType", actualLoadResult.getSubType());
    assertEquals("x", fontDescriptor.getFontName());
    assertEquals("x", actualLoadResult.getBaseFont());
    assertEquals("x", actualLoadResult.getName());
    assertNull(fontDescriptor.getCharSet());
    assertNull(fontDescriptor.getFontFamily());
    assertNull(fontDescriptor.getFontStretch());
    assertNull(fontFile2.getDecodeParms());
    assertNull(fontFile2.getFileDecodeParams());
    assertNull(actualLoadResult.getStandard14AFM());
    assertNull(actualLoadResult.getToUnicodeCMap());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualLoadResult.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = fontDescriptor.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(filters.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(fontFile2.getMetadata());
    assertNull(fontDescriptor.getCIDSet());
    assertNull(fontDescriptor.getFontFile());
    assertNull(fontDescriptor.getFontFile3());
    assertNull(fontFile2.getFile());
    assertNull(fontDescriptor.getPanose());
    assertEquals(-1, fontFile2.getDecodedStreamLength());
    Map<Integer, Integer> gIDToCode = actualLoadResult.getGIDToCode();
    assertEquals(1, gIDToCode.size());
    assertEquals(0, gIDToCode.get(0).intValue());
    BoundingBox boundingBox = actualLoadResult.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(0.0f, fontBoundingBox.getHeight());
    assertEquals(0.0f, fontBoundingBox.getWidth());
    assertEquals(0.0f, fontDescriptor.getAverageWidth());
    assertEquals(0.0f, fontDescriptor.getLeading());
    assertEquals(0.0f, fontDescriptor.getMaxWidth());
    assertEquals(0.0f, fontDescriptor.getMissingWidth());
    assertEquals(0.0f, fontDescriptor.getStemH());
    assertEquals(0.0f, fontDescriptor.getStemV());
    List<COSName> filters2 = fontFile2.getFilters();
    assertEquals(1, filters2.size());
    assertEquals(10.0f, fontDescriptor.getItalicAngle());
    List<Float> widths = actualLoadResult.getWidths();
    assertEquals(220, widths.size());
    assertEquals(1000.0f, widths.get(0).floatValue());
    assertEquals(1000.0f, widths.get(1).floatValue());
    assertEquals(1000.0f, widths.get(2).floatValue());
    assertEquals(1000.0f, widths.get(217).floatValue());
    assertEquals(1000.0f, widths.get(218).floatValue());
    assertEquals(1000.0f, widths.get(219).floatValue());
    assertEquals(1000.0f, boundingBox.getLowerLeftX());
    assertEquals(1000.0f, boundingBox.getLowerLeftY());
    assertEquals(1000.0f, boundingBox.getUpperRightX());
    assertEquals(1000.0f, boundingBox.getUpperRightY());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftX());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftY());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightX());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightY());
    assertEquals(1000.0f, actualLoadResult.getAverageFontWidth());
    assertEquals(1000.0f, actualLoadResult.getSpaceWidth());
    assertEquals(1000.0f, fontDescriptor.getAscent());
    assertEquals(1000.0f, fontDescriptor.getDescent());
    assertEquals(12L, cOSObject.getLength());
    assertEquals(1500.0f, fontDescriptor.getXHeight());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3.0f, fontDescriptor.getFontWeight());
    assertEquals(6000.0f, fontDescriptor.getCapHeight());
    assertEquals(8, cOSObject2.getValues().size());
    assertEquals(8, cOSObject2.size());
    assertEquals(99, fontDescriptor.getFlags());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(fontDescriptor.isAllCap());
    assertFalse(fontDescriptor.isForceBold());
    assertFalse(fontDescriptor.isScript());
    assertFalse(fontDescriptor.isSmallCap());
    assertFalse(fontDescriptor.isSymbolic());
    assertFalse(actualLoadResult.getSymbolicFlag());
    assertFalse(actualLoadResult.isVertical());
    assertFalse(actualLoadResult.isDamaged());
    assertTrue(fontFile2.getFileFilters().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(cOSObject.hasData());
    assertTrue(fontDescriptor.isFixedPitch());
    assertTrue(fontDescriptor.isItalic());
    assertTrue(fontDescriptor.isNonSymbolic());
    assertTrue(fontDescriptor.isSerif());
    assertTrue(actualLoadResult.isEmbedded());
    assertEquals(PDPanose.LENGTH, cOSObject3.getValues().size());
    assertEquals(PDPanose.LENGTH, cOSObject3.size());
    assertEquals(PDPanose.LENGTH, fontFile2.getLength());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualLoadResult.getFontMatrix());
    MacExpertEncoding expectedEncoding = encoding.INSTANCE;
    assertSame(expectedEncoding, actualLoadResult.getEncoding());
    assertSame(ttf, actualLoadResult.getFontBoxFont());
    assertSame(ttf, actualLoadResult.getTrueTypeFont());
    assertSame(filters, filters2.get(0));
  }

  /**
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  void testLoad9() throws IOException {
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
    MacExpertEncoding encoding = MacExpertEncoding.INSTANCE;

    // Act
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, encoding);

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
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    COSStream cOSObject = fontFile2.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    assertEquals("Font", actualLoadResult.getType());
    assertEquals("Name", fontDescriptor.getFontName());
    assertEquals("Name", actualLoadResult.getBaseFont());
    assertEquals("Name", actualLoadResult.getName());
    assertEquals("TrueType", actualLoadResult.getSubType());
    assertNull(fontDescriptor.getCharSet());
    assertNull(fontDescriptor.getFontFamily());
    assertNull(fontDescriptor.getFontStretch());
    assertNull(fontFile2.getDecodeParms());
    assertNull(fontFile2.getFileDecodeParams());
    assertNull(actualLoadResult.getStandard14AFM());
    assertNull(actualLoadResult.getToUnicodeCMap());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualLoadResult.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = fontDescriptor.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(filters.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(fontFile2.getMetadata());
    assertNull(fontDescriptor.getCIDSet());
    assertNull(fontDescriptor.getFontFile());
    assertNull(fontDescriptor.getFontFile3());
    assertNull(fontFile2.getFile());
    assertNull(fontDescriptor.getPanose());
    assertEquals(-1, fontFile2.getDecodedStreamLength());
    Map<Integer, Integer> gIDToCode = actualLoadResult.getGIDToCode();
    assertEquals(1, gIDToCode.size());
    assertEquals(0, gIDToCode.get(0).intValue());
    BoundingBox boundingBox = actualLoadResult.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(0.0f, fontBoundingBox.getHeight());
    assertEquals(0.0f, fontBoundingBox.getWidth());
    assertEquals(0.0f, fontDescriptor.getAverageWidth());
    assertEquals(0.0f, fontDescriptor.getLeading());
    assertEquals(0.0f, fontDescriptor.getMaxWidth());
    assertEquals(0.0f, fontDescriptor.getMissingWidth());
    assertEquals(0.0f, fontDescriptor.getStemH());
    assertEquals(0.0f, fontDescriptor.getStemV());
    List<COSName> filters2 = fontFile2.getFilters();
    assertEquals(1, filters2.size());
    assertEquals(10.0f, fontDescriptor.getItalicAngle());
    List<Float> widths = actualLoadResult.getWidths();
    assertEquals(220, widths.size());
    assertEquals(1000.0f, widths.get(0).floatValue());
    assertEquals(1000.0f, widths.get(1).floatValue());
    assertEquals(1000.0f, widths.get(2).floatValue());
    assertEquals(1000.0f, widths.get(217).floatValue());
    assertEquals(1000.0f, widths.get(218).floatValue());
    assertEquals(1000.0f, widths.get(219).floatValue());
    assertEquals(1000.0f, boundingBox.getLowerLeftX());
    assertEquals(1000.0f, boundingBox.getLowerLeftY());
    assertEquals(1000.0f, boundingBox.getUpperRightX());
    assertEquals(1000.0f, boundingBox.getUpperRightY());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftX());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftY());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightX());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightY());
    assertEquals(1000.0f, actualLoadResult.getAverageFontWidth());
    assertEquals(1000.0f, actualLoadResult.getSpaceWidth());
    assertEquals(1000.0f, fontDescriptor.getAscent());
    assertEquals(1000.0f, fontDescriptor.getDescent());
    assertEquals(12L, cOSObject.getLength());
    assertEquals(1500.0f, fontDescriptor.getXHeight());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3.0f, fontDescriptor.getFontWeight());
    assertEquals(6000.0f, fontDescriptor.getCapHeight());
    assertEquals(8, cOSObject2.getValues().size());
    assertEquals(8, cOSObject2.size());
    assertEquals(97, fontDescriptor.getFlags());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(fontDescriptor.isAllCap());
    assertFalse(fontDescriptor.isForceBold());
    assertFalse(fontDescriptor.isScript());
    assertFalse(fontDescriptor.isSerif());
    assertFalse(fontDescriptor.isSmallCap());
    assertFalse(fontDescriptor.isSymbolic());
    assertFalse(actualLoadResult.getSymbolicFlag());
    assertFalse(actualLoadResult.isVertical());
    assertFalse(actualLoadResult.isDamaged());
    assertTrue(fontFile2.getFileFilters().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(cOSObject.hasData());
    assertTrue(fontDescriptor.isFixedPitch());
    assertTrue(fontDescriptor.isItalic());
    assertTrue(fontDescriptor.isNonSymbolic());
    assertTrue(actualLoadResult.isEmbedded());
    assertEquals(PDPanose.LENGTH, cOSObject3.getValues().size());
    assertEquals(PDPanose.LENGTH, cOSObject3.size());
    assertEquals(PDPanose.LENGTH, fontFile2.getLength());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualLoadResult.getFontMatrix());
    MacExpertEncoding expectedEncoding = encoding.INSTANCE;
    assertSame(expectedEncoding, actualLoadResult.getEncoding());
    assertSame(ttf, actualLoadResult.getFontBoxFont());
    assertSame(ttf, actualLoadResult.getTrueTypeFont());
    assertSame(filters, filters2.get(0));
  }

  /**
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  void testLoad10() throws IOException {
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
    MacExpertEncoding encoding = MacExpertEncoding.INSTANCE;

    // Act
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, encoding);

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
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    COSStream cOSObject = fontFile2.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    assertEquals("Font", actualLoadResult.getType());
    assertEquals("Name", fontDescriptor.getFontName());
    assertEquals("Name", actualLoadResult.getBaseFont());
    assertEquals("Name", actualLoadResult.getName());
    assertEquals("TrueType", actualLoadResult.getSubType());
    assertNull(fontDescriptor.getCharSet());
    assertNull(fontDescriptor.getFontFamily());
    assertNull(fontDescriptor.getFontStretch());
    assertNull(fontFile2.getDecodeParms());
    assertNull(fontFile2.getFileDecodeParams());
    assertNull(actualLoadResult.getStandard14AFM());
    assertNull(actualLoadResult.getToUnicodeCMap());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualLoadResult.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = fontDescriptor.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(filters.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(fontFile2.getMetadata());
    assertNull(fontDescriptor.getCIDSet());
    assertNull(fontDescriptor.getFontFile());
    assertNull(fontDescriptor.getFontFile3());
    assertNull(fontFile2.getFile());
    assertNull(fontDescriptor.getPanose());
    assertEquals(-1, fontFile2.getDecodedStreamLength());
    Map<Integer, Integer> gIDToCode = actualLoadResult.getGIDToCode();
    assertEquals(1, gIDToCode.size());
    assertEquals(0, gIDToCode.get(0).intValue());
    BoundingBox boundingBox = actualLoadResult.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(0.0f, fontBoundingBox.getHeight());
    assertEquals(0.0f, fontBoundingBox.getWidth());
    assertEquals(0.0f, fontDescriptor.getAverageWidth());
    assertEquals(0.0f, fontDescriptor.getLeading());
    assertEquals(0.0f, fontDescriptor.getMaxWidth());
    assertEquals(0.0f, fontDescriptor.getMissingWidth());
    assertEquals(0.0f, fontDescriptor.getStemH());
    assertEquals(0.0f, fontDescriptor.getStemV());
    List<COSName> filters2 = fontFile2.getFilters();
    assertEquals(1, filters2.size());
    assertEquals(10.0f, fontDescriptor.getItalicAngle());
    List<Float> widths = actualLoadResult.getWidths();
    assertEquals(220, widths.size());
    assertEquals(1000.0f, widths.get(0).floatValue());
    assertEquals(1000.0f, widths.get(1).floatValue());
    assertEquals(1000.0f, widths.get(2).floatValue());
    assertEquals(1000.0f, widths.get(217).floatValue());
    assertEquals(1000.0f, widths.get(218).floatValue());
    assertEquals(1000.0f, widths.get(219).floatValue());
    assertEquals(1000.0f, boundingBox.getLowerLeftX());
    assertEquals(1000.0f, boundingBox.getLowerLeftY());
    assertEquals(1000.0f, boundingBox.getUpperRightX());
    assertEquals(1000.0f, boundingBox.getUpperRightY());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftX());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftY());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightX());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightY());
    assertEquals(1000.0f, actualLoadResult.getAverageFontWidth());
    assertEquals(1000.0f, actualLoadResult.getSpaceWidth());
    assertEquals(1000.0f, fontDescriptor.getAscent());
    assertEquals(1000.0f, fontDescriptor.getDescent());
    assertEquals(12L, cOSObject.getLength());
    assertEquals(1500.0f, fontDescriptor.getXHeight());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3.0f, fontDescriptor.getFontWeight());
    assertEquals(35, fontDescriptor.getFlags());
    assertEquals(6000.0f, fontDescriptor.getCapHeight());
    assertEquals(8, cOSObject2.getValues().size());
    assertEquals(8, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(fontDescriptor.isAllCap());
    assertFalse(fontDescriptor.isForceBold());
    assertFalse(fontDescriptor.isItalic());
    assertFalse(fontDescriptor.isScript());
    assertFalse(fontDescriptor.isSmallCap());
    assertFalse(fontDescriptor.isSymbolic());
    assertFalse(actualLoadResult.getSymbolicFlag());
    assertFalse(actualLoadResult.isVertical());
    assertFalse(actualLoadResult.isDamaged());
    assertTrue(fontFile2.getFileFilters().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(cOSObject.hasData());
    assertTrue(fontDescriptor.isFixedPitch());
    assertTrue(fontDescriptor.isNonSymbolic());
    assertTrue(fontDescriptor.isSerif());
    assertTrue(actualLoadResult.isEmbedded());
    assertEquals(PDPanose.LENGTH, cOSObject3.getValues().size());
    assertEquals(PDPanose.LENGTH, cOSObject3.size());
    assertEquals(PDPanose.LENGTH, fontFile2.getLength());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualLoadResult.getFontMatrix());
    MacExpertEncoding expectedEncoding = encoding.INSTANCE;
    assertSame(expectedEncoding, actualLoadResult.getEncoding());
    assertSame(ttf, actualLoadResult.getFontBoxFont());
    assertSame(ttf, actualLoadResult.getTrueTypeFont());
    assertSame(filters, filters2.get(0));
  }

  /**
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  void testLoad11() throws IOException {
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
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    COSStream cOSObject = fontFile2.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    assertEquals("Font", actualLoadResult.getType());
    assertEquals("Name", fontDescriptor.getFontName());
    assertEquals("Name", actualLoadResult.getBaseFont());
    assertEquals("Name", actualLoadResult.getName());
    assertEquals("TrueType", actualLoadResult.getSubType());
    assertNull(fontDescriptor.getCharSet());
    assertNull(fontDescriptor.getFontFamily());
    assertNull(fontDescriptor.getFontStretch());
    assertNull(fontFile2.getDecodeParms());
    assertNull(fontFile2.getFileDecodeParams());
    assertNull(actualLoadResult.getStandard14AFM());
    assertNull(actualLoadResult.getToUnicodeCMap());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualLoadResult.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = fontDescriptor.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(filters.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(fontFile2.getMetadata());
    assertNull(fontDescriptor.getCIDSet());
    assertNull(fontDescriptor.getFontFile());
    assertNull(fontDescriptor.getFontFile3());
    assertNull(fontFile2.getFile());
    assertNull(fontDescriptor.getPanose());
    assertEquals(-1, fontFile2.getDecodedStreamLength());
    Map<Integer, Integer> gIDToCode = actualLoadResult.getGIDToCode();
    assertEquals(1, gIDToCode.size());
    assertEquals(0, gIDToCode.get(0).intValue());
    BoundingBox boundingBox = actualLoadResult.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(0.0f, fontBoundingBox.getHeight());
    assertEquals(0.0f, fontBoundingBox.getWidth());
    assertEquals(0.0f, fontDescriptor.getAverageWidth());
    assertEquals(0.0f, fontDescriptor.getLeading());
    assertEquals(0.0f, fontDescriptor.getMaxWidth());
    assertEquals(0.0f, fontDescriptor.getMissingWidth());
    assertEquals(0.0f, fontDescriptor.getStemH());
    assertEquals(0.0f, fontDescriptor.getStemV());
    List<COSName> filters2 = fontFile2.getFilters();
    assertEquals(1, filters2.size());
    assertEquals(10.0f, fontDescriptor.getItalicAngle());
    List<Float> widths = actualLoadResult.getWidths();
    assertEquals(224, widths.size());
    assertEquals(1000.0f, widths.get(0).floatValue());
    assertEquals(1000.0f, widths.get(1).floatValue());
    assertEquals(1000.0f, widths.get(2).floatValue());
    assertEquals(1000.0f, widths.get(221).floatValue());
    assertEquals(1000.0f, widths.get(222).floatValue());
    assertEquals(1000.0f, widths.get(223).floatValue());
    assertEquals(1000.0f, boundingBox.getLowerLeftX());
    assertEquals(1000.0f, boundingBox.getLowerLeftY());
    assertEquals(1000.0f, boundingBox.getUpperRightX());
    assertEquals(1000.0f, boundingBox.getUpperRightY());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftX());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftY());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightX());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightY());
    assertEquals(1000.0f, actualLoadResult.getAverageFontWidth());
    assertEquals(1000.0f, actualLoadResult.getSpaceWidth());
    assertEquals(1000.0f, fontDescriptor.getAscent());
    assertEquals(1000.0f, fontDescriptor.getDescent());
    assertEquals(12L, cOSObject.getLength());
    assertEquals(1500.0f, fontDescriptor.getXHeight());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3.0f, fontDescriptor.getFontWeight());
    assertEquals(6000.0f, fontDescriptor.getCapHeight());
    assertEquals(7, cOSObject2.getValues().size());
    assertEquals(7, cOSObject2.size());
    assertEquals(99, fontDescriptor.getFlags());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(fontDescriptor.isAllCap());
    assertFalse(fontDescriptor.isForceBold());
    assertFalse(fontDescriptor.isScript());
    assertFalse(fontDescriptor.isSmallCap());
    assertFalse(fontDescriptor.isSymbolic());
    assertFalse(actualLoadResult.getSymbolicFlag());
    assertFalse(actualLoadResult.isVertical());
    assertFalse(actualLoadResult.isDamaged());
    assertTrue(fontFile2.getFileFilters().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(cOSObject.hasData());
    assertTrue(fontDescriptor.isFixedPitch());
    assertTrue(fontDescriptor.isItalic());
    assertTrue(fontDescriptor.isNonSymbolic());
    assertTrue(fontDescriptor.isSerif());
    assertTrue(actualLoadResult.isEmbedded());
    assertEquals(PDPanose.LENGTH, cOSObject3.getValues().size());
    assertEquals(PDPanose.LENGTH, cOSObject3.size());
    assertEquals(PDPanose.LENGTH, fontFile2.getLength());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualLoadResult.getFontMatrix());
    MacOSRomanEncoding expectedEncoding = encoding.INSTANCE;
    assertSame(expectedEncoding, actualLoadResult.getEncoding());
    assertSame(ttf, actualLoadResult.getFontBoxFont());
    assertSame(ttf, actualLoadResult.getTrueTypeFont());
    assertSame(filters, filters2.get(0));
  }

  /**
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  void testLoad12() throws IOException {
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
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    COSStream cOSObject = fontFile2.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    assertEquals("Font", actualLoadResult.getType());
    assertEquals("Name", fontDescriptor.getFontName());
    assertEquals("Name", actualLoadResult.getBaseFont());
    assertEquals("Name", actualLoadResult.getName());
    assertEquals("TrueType", actualLoadResult.getSubType());
    assertNull(fontDescriptor.getCharSet());
    assertNull(fontDescriptor.getFontFamily());
    assertNull(fontDescriptor.getFontStretch());
    assertNull(fontFile2.getDecodeParms());
    assertNull(fontFile2.getFileDecodeParams());
    assertNull(actualLoadResult.getStandard14AFM());
    assertNull(actualLoadResult.getToUnicodeCMap());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualLoadResult.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = fontDescriptor.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(filters.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(fontFile2.getMetadata());
    assertNull(fontDescriptor.getCIDSet());
    assertNull(fontDescriptor.getFontFile());
    assertNull(fontDescriptor.getFontFile3());
    assertNull(fontFile2.getFile());
    assertNull(fontDescriptor.getPanose());
    assertEquals(-1, fontFile2.getDecodedStreamLength());
    Map<Integer, Integer> gIDToCode = actualLoadResult.getGIDToCode();
    assertEquals(1, gIDToCode.size());
    assertEquals(0, gIDToCode.get(0).intValue());
    BoundingBox boundingBox = actualLoadResult.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(0.0f, fontBoundingBox.getHeight());
    assertEquals(0.0f, fontBoundingBox.getWidth());
    assertEquals(0.0f, fontDescriptor.getAverageWidth());
    assertEquals(0.0f, fontDescriptor.getLeading());
    assertEquals(0.0f, fontDescriptor.getMaxWidth());
    assertEquals(0.0f, fontDescriptor.getMissingWidth());
    assertEquals(0.0f, fontDescriptor.getStemH());
    assertEquals(0.0f, fontDescriptor.getStemV());
    List<COSName> filters2 = fontFile2.getFilters();
    assertEquals(1, filters2.size());
    assertEquals(10.0f, fontDescriptor.getItalicAngle());
    List<Float> widths = actualLoadResult.getWidths();
    assertEquals(223, widths.size());
    assertEquals(1000.0f, widths.get(0).floatValue());
    assertEquals(1000.0f, widths.get(1).floatValue());
    assertEquals(1000.0f, widths.get(2).floatValue());
    assertEquals(1000.0f, widths.get(220).floatValue());
    assertEquals(1000.0f, widths.get(221).floatValue());
    assertEquals(1000.0f, widths.get(222).floatValue());
    assertEquals(1000.0f, boundingBox.getLowerLeftX());
    assertEquals(1000.0f, boundingBox.getLowerLeftY());
    assertEquals(1000.0f, boundingBox.getUpperRightX());
    assertEquals(1000.0f, boundingBox.getUpperRightY());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftX());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftY());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightX());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightY());
    assertEquals(1000.0f, actualLoadResult.getAverageFontWidth());
    assertEquals(1000.0f, actualLoadResult.getSpaceWidth());
    assertEquals(1000.0f, fontDescriptor.getAscent());
    assertEquals(1000.0f, fontDescriptor.getDescent());
    assertEquals(12L, cOSObject.getLength());
    assertEquals(1500.0f, fontDescriptor.getXHeight());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3.0f, fontDescriptor.getFontWeight());
    assertEquals(6000.0f, fontDescriptor.getCapHeight());
    assertEquals(8, cOSObject2.getValues().size());
    assertEquals(8, cOSObject2.size());
    assertEquals(99, fontDescriptor.getFlags());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(fontDescriptor.isAllCap());
    assertFalse(fontDescriptor.isForceBold());
    assertFalse(fontDescriptor.isScript());
    assertFalse(fontDescriptor.isSmallCap());
    assertFalse(fontDescriptor.isSymbolic());
    assertFalse(actualLoadResult.getSymbolicFlag());
    assertFalse(actualLoadResult.isVertical());
    assertFalse(actualLoadResult.isDamaged());
    assertTrue(fontFile2.getFileFilters().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(cOSObject.hasData());
    assertTrue(fontDescriptor.isFixedPitch());
    assertTrue(fontDescriptor.isItalic());
    assertTrue(fontDescriptor.isNonSymbolic());
    assertTrue(fontDescriptor.isSerif());
    assertTrue(actualLoadResult.isEmbedded());
    assertEquals(PDPanose.LENGTH, cOSObject3.getValues().size());
    assertEquals(PDPanose.LENGTH, cOSObject3.size());
    assertEquals(PDPanose.LENGTH, fontFile2.getLength());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualLoadResult.getFontMatrix());
    SymbolEncoding expectedEncoding = encoding.INSTANCE;
    assertSame(expectedEncoding, actualLoadResult.getEncoding());
    assertSame(ttf, actualLoadResult.getFontBoxFont());
    assertSame(ttf, actualLoadResult.getTrueTypeFont());
    assertSame(filters, filters2.get(0));
  }

  /**
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  void testLoad13() throws IOException {
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
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    COSStream cOSObject = fontFile2.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    assertEquals("Font", actualLoadResult.getType());
    assertEquals("Name", fontDescriptor.getFontName());
    assertEquals("Name", actualLoadResult.getBaseFont());
    assertEquals("Name", actualLoadResult.getName());
    assertEquals("TrueType", actualLoadResult.getSubType());
    assertNull(fontDescriptor.getCharSet());
    assertNull(fontDescriptor.getFontFamily());
    assertNull(fontDescriptor.getFontStretch());
    assertNull(fontFile2.getDecodeParms());
    assertNull(fontFile2.getFileDecodeParams());
    assertNull(actualLoadResult.getStandard14AFM());
    assertNull(actualLoadResult.getToUnicodeCMap());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualLoadResult.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = fontDescriptor.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(filters.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(fontFile2.getMetadata());
    assertNull(fontDescriptor.getCIDSet());
    assertNull(fontDescriptor.getFontFile());
    assertNull(fontDescriptor.getFontFile3());
    assertNull(fontFile2.getFile());
    assertNull(fontDescriptor.getPanose());
    assertEquals(-1, fontFile2.getDecodedStreamLength());
    Map<Integer, Integer> gIDToCode = actualLoadResult.getGIDToCode();
    assertEquals(1, gIDToCode.size());
    assertEquals(0, gIDToCode.get(0).intValue());
    BoundingBox boundingBox = actualLoadResult.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(0.0f, fontBoundingBox.getHeight());
    assertEquals(0.0f, fontBoundingBox.getWidth());
    assertEquals(0.0f, fontDescriptor.getAverageWidth());
    assertEquals(0.0f, fontDescriptor.getLeading());
    assertEquals(0.0f, fontDescriptor.getMaxWidth());
    assertEquals(0.0f, fontDescriptor.getMissingWidth());
    assertEquals(0.0f, fontDescriptor.getStemH());
    assertEquals(0.0f, fontDescriptor.getStemV());
    List<COSName> filters2 = fontFile2.getFilters();
    assertEquals(1, filters2.size());
    assertEquals(10.0f, fontDescriptor.getItalicAngle());
    List<Float> widths = actualLoadResult.getWidths();
    assertEquals(223, widths.size());
    assertEquals(1000.0f, widths.get(0).floatValue());
    assertEquals(1000.0f, widths.get(1).floatValue());
    assertEquals(1000.0f, widths.get(2).floatValue());
    assertEquals(1000.0f, widths.get(220).floatValue());
    assertEquals(1000.0f, widths.get(221).floatValue());
    assertEquals(1000.0f, widths.get(222).floatValue());
    assertEquals(1000.0f, boundingBox.getLowerLeftX());
    assertEquals(1000.0f, boundingBox.getLowerLeftY());
    assertEquals(1000.0f, boundingBox.getUpperRightX());
    assertEquals(1000.0f, boundingBox.getUpperRightY());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftX());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftY());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightX());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightY());
    assertEquals(1000.0f, actualLoadResult.getAverageFontWidth());
    assertEquals(1000.0f, actualLoadResult.getSpaceWidth());
    assertEquals(1000.0f, fontDescriptor.getAscent());
    assertEquals(1000.0f, fontDescriptor.getDescent());
    assertEquals(12L, cOSObject.getLength());
    assertEquals(1500.0f, fontDescriptor.getXHeight());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3.0f, fontDescriptor.getFontWeight());
    assertEquals(6000.0f, fontDescriptor.getCapHeight());
    assertEquals(8, cOSObject2.getValues().size());
    assertEquals(8, cOSObject2.size());
    assertEquals(99, fontDescriptor.getFlags());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(fontDescriptor.isAllCap());
    assertFalse(fontDescriptor.isForceBold());
    assertFalse(fontDescriptor.isScript());
    assertFalse(fontDescriptor.isSmallCap());
    assertFalse(fontDescriptor.isSymbolic());
    assertFalse(actualLoadResult.getSymbolicFlag());
    assertFalse(actualLoadResult.isVertical());
    assertFalse(actualLoadResult.isDamaged());
    assertTrue(fontFile2.getFileFilters().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(cOSObject.hasData());
    assertTrue(fontDescriptor.isFixedPitch());
    assertTrue(fontDescriptor.isItalic());
    assertTrue(fontDescriptor.isNonSymbolic());
    assertTrue(fontDescriptor.isSerif());
    assertTrue(actualLoadResult.isEmbedded());
    assertEquals(PDPanose.LENGTH, cOSObject3.getValues().size());
    assertEquals(PDPanose.LENGTH, cOSObject3.size());
    assertEquals(PDPanose.LENGTH, fontFile2.getLength());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualLoadResult.getFontMatrix());
    ZapfDingbatsEncoding expectedEncoding = encoding.INSTANCE;
    assertSame(expectedEncoding, actualLoadResult.getEncoding());
    assertSame(ttf, actualLoadResult.getFontBoxFont());
    assertSame(ttf, actualLoadResult.getTrueTypeFont());
    assertSame(filters, filters2.get(0));
  }

  /**
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  void testLoad14() throws IOException {
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
   * Method under test:
   * {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  void testLoad15() throws IOException {
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
    when(headerTable.getXMin()).thenReturn(Short.MIN_VALUE);
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
    MacExpertEncoding encoding = MacExpertEncoding.INSTANCE;

    // Act
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, encoding);

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
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    COSStream cOSObject = fontFile2.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSName);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    assertEquals("Font", actualLoadResult.getType());
    assertEquals("Name", fontDescriptor.getFontName());
    assertEquals("Name", actualLoadResult.getBaseFont());
    assertEquals("Name", actualLoadResult.getName());
    assertEquals("TrueType", actualLoadResult.getSubType());
    assertNull(fontDescriptor.getCharSet());
    assertNull(fontDescriptor.getFontFamily());
    assertNull(fontDescriptor.getFontStretch());
    assertNull(fontFile2.getDecodeParms());
    assertNull(fontFile2.getFileDecodeParams());
    assertNull(actualLoadResult.getStandard14AFM());
    assertNull(actualLoadResult.getToUnicodeCMap());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualLoadResult.getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSDictionary cOSObject3 = fontDescriptor.getCOSObject();
    COSUpdateState updateState3 = cOSObject3.getUpdateState();
    assertNull(updateState3.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(filters.getKey());
    assertNull(cOSObject.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(fontFile2.getMetadata());
    assertNull(fontDescriptor.getCIDSet());
    assertNull(fontDescriptor.getFontFile());
    assertNull(fontDescriptor.getFontFile3());
    assertNull(fontFile2.getFile());
    assertNull(fontDescriptor.getPanose());
    assertEquals(-1, fontFile2.getDecodedStreamLength());
    BoundingBox boundingBox = actualLoadResult.getBoundingBox();
    assertEquals(-3.2768E7f, boundingBox.getLowerLeftX());
    assertEquals(-3.2768E7f, fontBoundingBox.getLowerLeftX());
    Map<Integer, Integer> gIDToCode = actualLoadResult.getGIDToCode();
    assertEquals(1, gIDToCode.size());
    assertEquals(0, gIDToCode.get(0).intValue());
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, fontBoundingBox.getHeight());
    assertEquals(0.0f, fontDescriptor.getAverageWidth());
    assertEquals(0.0f, fontDescriptor.getLeading());
    assertEquals(0.0f, fontDescriptor.getMaxWidth());
    assertEquals(0.0f, fontDescriptor.getMissingWidth());
    assertEquals(0.0f, fontDescriptor.getStemH());
    List<COSName> filters2 = fontFile2.getFilters();
    assertEquals(1, filters2.size());
    assertEquals(10.0f, fontDescriptor.getItalicAngle());
    List<Float> widths = actualLoadResult.getWidths();
    assertEquals(220, widths.size());
    assertEquals(1000.0f, widths.get(0).floatValue());
    assertEquals(1000.0f, widths.get(1).floatValue());
    assertEquals(1000.0f, widths.get(2).floatValue());
    assertEquals(1000.0f, widths.get(217).floatValue());
    assertEquals(1000.0f, widths.get(218).floatValue());
    assertEquals(1000.0f, widths.get(219).floatValue());
    assertEquals(1000.0f, boundingBox.getLowerLeftY());
    assertEquals(1000.0f, boundingBox.getUpperRightX());
    assertEquals(1000.0f, boundingBox.getUpperRightY());
    assertEquals(1000.0f, fontBoundingBox.getLowerLeftY());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightX());
    assertEquals(1000.0f, fontBoundingBox.getUpperRightY());
    assertEquals(1000.0f, actualLoadResult.getAverageFontWidth());
    assertEquals(1000.0f, actualLoadResult.getSpaceWidth());
    assertEquals(1000.0f, fontDescriptor.getAscent());
    assertEquals(1000.0f, fontDescriptor.getDescent());
    assertEquals(1500.0f, fontDescriptor.getXHeight());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3.0f, fontDescriptor.getFontWeight());
    assertEquals(3.2769E7f, boundingBox.getWidth());
    assertEquals(3.2769E7f, fontBoundingBox.getWidth());
    assertEquals(4259970.0f, fontDescriptor.getStemV());
    assertEquals(6000.0f, fontDescriptor.getCapHeight());
    assertEquals(8, cOSObject2.getValues().size());
    assertEquals(8, cOSObject2.size());
    assertEquals(8, fontFile2.getLength());
    assertEquals(8L, cOSObject.getLength());
    assertEquals(99, fontDescriptor.getFlags());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = cOSObject3.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertFalse(updateState3.isUpdated());
    assertFalse(fontDescriptor.isAllCap());
    assertFalse(fontDescriptor.isForceBold());
    assertFalse(fontDescriptor.isScript());
    assertFalse(fontDescriptor.isSmallCap());
    assertFalse(fontDescriptor.isSymbolic());
    assertFalse(actualLoadResult.getSymbolicFlag());
    assertFalse(actualLoadResult.isVertical());
    assertFalse(actualLoadResult.isDamaged());
    assertTrue(fontFile2.getFileFilters().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(cOSObject.hasData());
    assertTrue(fontDescriptor.isFixedPitch());
    assertTrue(fontDescriptor.isItalic());
    assertTrue(fontDescriptor.isNonSymbolic());
    assertTrue(fontDescriptor.isSerif());
    assertTrue(actualLoadResult.isEmbedded());
    assertEquals(PDPanose.LENGTH, cOSObject3.getValues().size());
    assertEquals(PDPanose.LENGTH, cOSObject3.size());
    assertEquals(getResult2, getResult3);
    assertEquals(getResult2, getResult4);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualLoadResult.getFontMatrix());
    MacExpertEncoding expectedEncoding = encoding.INSTANCE;
    assertSame(expectedEncoding, actualLoadResult.getEncoding());
    assertSame(ttf, actualLoadResult.getFontBoxFont());
    assertSame(ttf, actualLoadResult.getTrueTypeFont());
    assertSame(filters, filters2.get(0));
  }

  /**
   * Method under test: {@link PDTrueTypeFont#getBaseFont()}
   */
  @Test
  void testGetBaseFont() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDTrueTypeFont(new COSDictionary())).getBaseFont());
  }

  /**
   * Method under test: {@link PDTrueTypeFont#readEncodingFromFont()}
   */
  @Test
  void testReadEncodingFromFont() throws IOException {
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
    assertEquals(41, nameToCodeMap.get("parenright").intValue());
    assertEquals(42, nameToCodeMap.get("asterisk").intValue());
  }

  /**
   * Method under test: {@link PDTrueTypeFont#readEncodingFromFont()}
   */
  @Test
  void testReadEncodingFromFont2() throws IOException {
    // Arrange
    PDTrueTypeFont pdTrueTypeFont = new PDTrueTypeFont(new COSDictionary());
    pdTrueTypeFont.setFontDescriptor(new PDFontDescriptor());

    // Act
    Encoding actualReadEncodingFromFontResult = pdTrueTypeFont.readEncodingFromFont();

    // Assert
    assertSame(((StandardEncoding) actualReadEncodingFromFontResult).INSTANCE, actualReadEncodingFromFontResult);
  }

  /**
   * Method under test: {@link PDTrueTypeFont#readCode(InputStream)}
   */
  @Test
  void testReadCode() throws IOException {
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
   * Method under test: {@link PDTrueTypeFont#getName()}
   */
  @Test
  void testGetName() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDTrueTypeFont(new COSDictionary())).getName());
  }

  /**
   * Method under test: {@link PDTrueTypeFont#getBoundingBox()}
   */
  @Test
  void testGetBoundingBox() throws IOException {
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
   * Method under test: {@link PDTrueTypeFont#getBoundingBox()}
   */
  @Test
  void testGetBoundingBox2() throws IOException {
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
   * Method under test: {@link PDTrueTypeFont#getBoundingBox()}
   */
  @Test
  void testGetBoundingBox3() throws IOException {
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
   * Method under test: {@link PDTrueTypeFont#getWidthFromFont(int)}
   */
  @Test
  void testGetWidthFromFont() throws IOException {
    // Arrange, Act and Assert
    assertEquals(365.23438f, (new PDTrueTypeFont(new COSDictionary())).getWidthFromFont(1));
    assertEquals(500.0f, (new PDTrueTypeFont(new COSDictionary())).getWidthFromFont(255));
  }

  /**
   * Method under test: {@link PDTrueTypeFont#getHeight(int)}
   */
  @Test
  void testGetHeight() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1365.0f, (new PDTrueTypeFont(new COSDictionary())).getHeight(1));
    assertEquals(1341.0f, (new PDTrueTypeFont(new COSDictionary())).getHeight(88));
    assertEquals(0.0f, (new PDTrueTypeFont(new COSDictionary())).getHeight(0));
    assertEquals(1736.0f, (new PDTrueTypeFont(new COSDictionary())).getHeight(255));
  }

  /**
   * Method under test: {@link PDTrueTypeFont#getHeight(int)}
   */
  @Test
  void testGetHeight2() throws IOException {
    // Arrange
    new NumberFormatException("foo");
    new NumberFormatException("foo");

    // Act and Assert
    assertEquals(1365.0f, (new PDTrueTypeFont(new COSDictionary())).getHeight(1));
  }

  /**
   * Method under test: {@link PDTrueTypeFont#encode(int)}
   */
  @Test
  void testEncode() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDTrueTypeFont(new COSDictionary())).encode(1));
    assertThrows(IllegalArgumentException.class, () -> (new PDTrueTypeFont(new COSDictionary())).encode(0));
    assertArrayEquals(new byte[]{-100}, (new PDTrueTypeFont(new COSDictionary())).encode(250));
  }

  /**
   * Method under test: {@link PDTrueTypeFont#getGIDToCode()}
   */
  @Test
  void testGetGIDToCode() throws IOException {
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
   * Method under test: {@link PDTrueTypeFont#getPath(int)}
   */
  @Test
  void testGetPath() throws IOException {
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
    assertEquals(1, actualPath.getWindingRule());
    assertEquals(136.0d, currentPoint.getX());
    assertEquals(136.0f, ((Point2D.Float) currentPoint).x);
    Dimension size = bounds.getSize();
    assertEquals(1365, size.height);
    assertEquals(1365, bounds.height);
    assertEquals(1365.0d, size.getHeight());
    assertEquals(1365.0d, bounds.getHeight());
    assertEquals(1365.0d, bounds.getMaxY());
    assertEquals(340.0d, bounds.getCenterX());
    assertEquals(544, size.width);
    assertEquals(544, bounds.width);
    assertEquals(544.0d, size.getWidth());
    assertEquals(544.0d, bounds.getWidth());
    assertEquals(612.0d, bounds.getMaxX());
    assertEquals(68, location.x);
    assertEquals(68, bounds.x);
    assertEquals(68.0d, location.getX());
    assertEquals(68.0d, bounds.getX());
    assertEquals(68.0d, currentPoint.getY());
    assertEquals(68.0d, bounds.getMinX());
    assertEquals(68.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(682.5d, bounds.getCenterY());
    assertFalse(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PDTrueTypeFont#getPath(int)}
   */
  @Test
  void testGetPath2() throws IOException {
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
    assertEquals(1, actualPath.getWindingRule());
    assertEquals(1016.0d, bounds.getMaxX());
    assertEquals(1194.0d, currentPoint.getY());
    assertEquals(1194.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(1294.0d, bounds.getMaxY());
    Dimension size = bounds.getSize();
    assertEquals(1736, size.height);
    assertEquals(1736, bounds.height);
    assertEquals(1736.0d, size.getHeight());
    assertEquals(1736.0d, bounds.getHeight());
    assertEquals(25, location.x);
    assertEquals(25, bounds.x);
    assertEquals(25.0d, location.getX());
    assertEquals(25.0d, bounds.getX());
    assertEquals(25.0d, bounds.getMinX());
    assertEquals(426.0d, bounds.getCenterY());
    assertEquals(457.0d, currentPoint.getX());
    assertEquals(457.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(520.5d, bounds.getCenterX());
    assertEquals(991, size.width);
    assertEquals(991, bounds.width);
    assertEquals(991.0d, size.getWidth());
    assertEquals(991.0d, bounds.getWidth());
    assertFalse(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PDTrueTypeFont#getPath(String)}
   */
  @Test
  void testGetPath3() throws IOException {
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
    assertNull(actualPath.getCurrentPoint());
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(1, actualPath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PDTrueTypeFont#getPath(String)}
   */
  @Test
  void testGetPath4() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary())).getPath("g9");

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
    assertEquals(-20, location.y);
    assertEquals(-20, bounds.y);
    assertEquals(-20.0d, location.getY());
    assertEquals(-20.0d, bounds.getY());
    assertEquals(-20.0d, bounds.getMinY());
    assertEquals(1, actualPath.getWindingRule());
    assertEquals(1090.0d, currentPoint.getY());
    assertEquals(1090.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(1362.0d, bounds.getMaxY());
    Dimension size = bounds.getSize();
    assertEquals(1382, size.height);
    assertEquals(1382, bounds.height);
    assertEquals(1382.0d, size.getHeight());
    assertEquals(1382.0d, bounds.getHeight());
    assertEquals(1478, size.width);
    assertEquals(1478, bounds.width);
    assertEquals(1478.0d, size.getWidth());
    assertEquals(1478.0d, bounds.getWidth());
    assertEquals(1556.0d, bounds.getMaxX());
    assertEquals(434.0d, currentPoint.getX());
    assertEquals(434.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(671.0d, bounds.getCenterY());
    assertEquals(78, location.x);
    assertEquals(78, bounds.x);
    assertEquals(78.0d, location.getX());
    assertEquals(78.0d, bounds.getX());
    assertEquals(78.0d, bounds.getMinX());
    assertEquals(817.0d, bounds.getCenterX());
    assertFalse(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PDTrueTypeFont#getPath(String)}
   */
  @Test
  void testGetPath5() throws IOException {
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
    assertNull(actualPath.getCurrentPoint());
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(1, actualPath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PDTrueTypeFont#getPath(String)}
   */
  @Test
  void testGetPath6() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary())).getPath(".notdef");

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
    assertEquals(0, location.y);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(1, actualPath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PDTrueTypeFont#getPath(String)}
   */
  @Test
  void testGetPath7() throws IOException {
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
    Point location = bounds.getLocation();
    assertEquals(-20, location.y);
    assertEquals(-20, bounds.y);
    assertEquals(-20.0d, location.getY());
    assertEquals(-20.0d, bounds.getY());
    assertEquals(-20.0d, bounds.getMinY());
    assertEquals(1, actualPath.getWindingRule());
    assertEquals(1284.0d, currentPoint.getX());
    assertEquals(1284.0f, ((Point2D.Float) currentPoint).x);
    Dimension size = bounds.getSize();
    assertEquals(1331, size.width);
    assertEquals(1331, bounds.width);
    assertEquals(1331.0d, size.getWidth());
    assertEquals(1331.0d, bounds.getWidth());
    assertEquals(1356.0d, bounds.getMaxY());
    assertEquals(1376, size.height);
    assertEquals(1376, bounds.height);
    assertEquals(1376.0d, size.getHeight());
    assertEquals(1376.0d, bounds.getHeight());
    assertEquals(1415.0d, bounds.getMaxX());
    assertEquals(668.0d, bounds.getCenterY());
    assertEquals(70.0d, currentPoint.getY());
    assertEquals(70.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(749.5d, bounds.getCenterX());
    assertEquals(84, location.x);
    assertEquals(84, bounds.x);
    assertEquals(84.0d, location.getX());
    assertEquals(84.0d, bounds.getX());
    assertEquals(84.0d, bounds.getMinX());
    assertFalse(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PDTrueTypeFont#getPath(String)}
   */
  @Test
  void testGetPath8() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary(new COSDictionary()))).getPath("g9");

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
    assertEquals(-20, location.y);
    assertEquals(-20, bounds.y);
    assertEquals(-20.0d, location.getY());
    assertEquals(-20.0d, bounds.getY());
    assertEquals(-20.0d, bounds.getMinY());
    assertEquals(1, actualPath.getWindingRule());
    assertEquals(1090.0d, currentPoint.getY());
    assertEquals(1090.0f, ((Point2D.Float) currentPoint).y);
    assertEquals(1362.0d, bounds.getMaxY());
    Dimension size = bounds.getSize();
    assertEquals(1382, size.height);
    assertEquals(1382, bounds.height);
    assertEquals(1382.0d, size.getHeight());
    assertEquals(1382.0d, bounds.getHeight());
    assertEquals(1478, size.width);
    assertEquals(1478, bounds.width);
    assertEquals(1478.0d, size.getWidth());
    assertEquals(1478.0d, bounds.getWidth());
    assertEquals(1556.0d, bounds.getMaxX());
    assertEquals(434.0d, currentPoint.getX());
    assertEquals(434.0f, ((Point2D.Float) currentPoint).x);
    assertEquals(671.0d, bounds.getCenterY());
    assertEquals(78, location.x);
    assertEquals(78, bounds.x);
    assertEquals(78.0d, location.getX());
    assertEquals(78.0d, bounds.getX());
    assertEquals(78.0d, bounds.getMinX());
    assertEquals(817.0d, bounds.getCenterX());
    assertFalse(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PDTrueTypeFont#getPath(String)}
   */
  @Test
  void testGetPath9() throws IOException {
    // Arrange and Act
    GeneralPath actualPath = (new PDTrueTypeFont(new COSDictionary())).getPath("g942");

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
    assertEquals(0, location.y);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(1, actualPath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PDTrueTypeFont#getNormalizedPath(int)}
   */
  @Test
  void testGetNormalizedPath() throws IOException {
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
    assertNull(actualNormalizedPath.getCurrentPoint());
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(1, actualNormalizedPath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PDTrueTypeFont#getNormalizedPath(int)}
   */
  @Test
  void testGetNormalizedPath2() throws IOException {
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
    assertNull(actualNormalizedPath.getCurrentPoint());
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(1, actualNormalizedPath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
  }

  /**
   * Method under test: {@link PDTrueTypeFont#getNormalizedPath(int)}
   */
  @Test
  void testGetNormalizedPath3() throws IOException {
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
    assertEquals(1, actualNormalizedPath.getWindingRule());
    assertEquals(12.0d, location.getX());
    assertEquals(12.0d, bounds.getX());
    assertEquals(12.0d, bounds.getMinX());
    assertEquals(12.20703125d, bounds2D2.getMinX());
    assertEquals(12.20703125d, bounds2D2.getX());
    assertEquals(12.207031f, ((Rectangle2D.Float) bounds2D2).x);
    assertEquals(208.0078125d, bounds2D2.getCenterY());
    assertEquals(208.0d, bounds.getCenterY());
    assertEquals(223.14453125d, currentPoint.getX());
    assertEquals(223.14453f, ((Point2D.Float) currentPoint).x);
    assertEquals(254.150390625d, bounds2D2.getCenterX());
    assertEquals(254.5d, bounds.getCenterX());
    assertEquals(483.88671875d, bounds2D2.getWidth());
    assertEquals(483.88672f, ((Rectangle2D.Float) bounds2D2).width);
    Dimension size = bounds.getSize();
    assertEquals(485, size.width);
    assertEquals(485, bounds.width);
    assertEquals(485.0d, size.getWidth());
    assertEquals(485.0d, bounds.getWidth());
    assertEquals(496.09375d, bounds2D2.getMaxX());
    assertEquals(497.0d, bounds.getMaxX());
    assertEquals(583.0078125d, currentPoint.getY());
    assertEquals(583.0078f, ((Point2D.Float) currentPoint).y);
    assertEquals(631.8359375d, bounds2D2.getMaxY());
    assertEquals(632.0d, bounds.getMaxY());
    assertEquals(847.65625d, bounds2D2.getHeight());
    assertEquals(847.65625f, ((Rectangle2D.Float) bounds2D2).height);
    assertEquals(848, size.height);
    assertEquals(848, bounds.height);
    assertEquals(848.0d, size.getHeight());
    assertEquals(848.0d, bounds.getHeight());
    assertFalse(bounds.isEmpty());
    assertFalse(bounds2D2.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(PDPanose.LENGTH, location.x);
    assertEquals(PDPanose.LENGTH, bounds.x);
    assertEquals(bounds2D2, frame2);
    assertEquals(bounds2D2, bounds2D3);
  }

  /**
   * Method under test: {@link PDTrueTypeFont#hasGlyph(int)}
   */
  @Test
  void testHasGlyph() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDTrueTypeFont(new COSDictionary())).hasGlyph(1));
    assertTrue((new PDTrueTypeFont(new COSDictionary())).hasGlyph(0));
    assertTrue((new PDTrueTypeFont(new COSDictionary())).hasGlyph(255));
    assertFalse((new PDTrueTypeFont(new COSDictionary())).hasGlyph("Name"));
    assertTrue((new PDTrueTypeFont(new COSDictionary())).hasGlyph("g9"));
    assertFalse((new PDTrueTypeFont(new COSDictionary())).hasGlyph("uni"));
    assertFalse((new PDTrueTypeFont(new COSDictionary())).hasGlyph(".notdef"));
    assertFalse((new PDTrueTypeFont(new COSDictionary())).hasGlyph("g942"));
  }

  /**
   * Method under test: {@link PDTrueTypeFont#codeToGID(int)}
   */
  @Test
  void testCodeToGID() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, (new PDTrueTypeFont(new COSDictionary())).codeToGID(1));
    assertEquals(191, (new PDTrueTypeFont(new COSDictionary())).codeToGID(255));
  }

  /**
   * Method under test: {@link PDTrueTypeFont#PDTrueTypeFont(COSDictionary)}
   */
  @Test
  void testNewPDTrueTypeFont() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    // Act
    PDTrueTypeFont actualPdTrueTypeFont = new PDTrueTypeFont(fontDictionary);

    // Assert
    FontBoxFont fontBoxFont = actualPdTrueTypeFont.getFontBoxFont();
    HeaderTable header = ((TrueTypeFont) fontBoxFont).getHeader();
    Calendar created = header.getCreated();
    assertTrue(created instanceof GregorianCalendar);
    Calendar modified = header.getModified();
    assertTrue(modified instanceof GregorianCalendar);
    CmapLookup unicodeCmapLookup = ((TrueTypeFont) fontBoxFont).getUnicodeCmapLookup();
    assertTrue(unicodeCmapLookup instanceof CmapSubtable);
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    GsubData gsubData = ((TrueTypeFont) fontBoxFont).getGsubData();
    assertTrue(gsubData instanceof MapBackedGsubData);
    Encoding encoding = actualPdTrueTypeFont.getEncoding();
    assertTrue(encoding instanceof BuiltInEncoding);
    PostScriptTable postScript = ((TrueTypeFont) fontBoxFont).getPostScript();
    String[] glyphNames = postScript.getGlyphNames();
    assertEquals(".notdef", glyphNames[0]);
    Map<Integer, String> codeToNameMap = encoding.getCodeToNameMap();
    assertEquals(229, codeToNameMap.size());
    assertEquals(".null", codeToNameMap.get(0));
    assertEquals(".null", codeToNameMap.get(8));
    assertEquals(".null", glyphNames[1]);
    OS2WindowsMetricsTable oS2Windows = ((TrueTypeFont) fontBoxFont).getOS2Windows();
    assertEquals("1ASC", oS2Windows.getAchVendId());
    TimeZone timeZone = created.getTimeZone();
    assertEquals("Coordinated Universal Time", timeZone.getDisplayName());
    NamingTable naming = ((TrueTypeFont) fontBoxFont).getNaming();
    List<NameRecord> nameRecords = naming.getNameRecords();
    assertEquals(28, nameRecords.size());
    NameRecord getResult = nameRecords.get(0);
    assertEquals("Copyright (c) 2007 Red Hat, Inc. All rights reserved. LIBERATION is a trademark of Red Hat, Inc.",
        getResult.getString());
    GlyphSubstitutionTable gsub = ((TrueTypeFont) fontBoxFont).getGsub();
    assertEquals("GSUB", gsub.getTag());
    NameRecord getResult2 = nameRecords.get(1);
    assertEquals("Liberation Serif", getResult2.getString());
    assertEquals("Liberation Serif", naming.getFontFamily());
    assertEquals("LiberationSerif", fontBoxFont.getName());
    assertEquals("LiberationSerif", naming.getPostScriptName());
    NameRecord getResult3 = nameRecords.get(26);
    assertEquals("Licensed under the Liberation Fonts license, see https://fedoraproject.org/wiki/Licensing/Liberation"
        + "FontLicense", getResult3.getString());
    assertEquals("OS/2", oS2Windows.getTag());
    assertEquals("Regular", naming.getFontSubFamily());
    assertEquals("UTC", timeZone.getID());
    assertEquals("afii10066.alt1", glyphNames[663]);
    assertEquals("ampersand", glyphNames[9]);
    assertEquals("asterisk", glyphNames[13]);
    assertEquals("built-in (TTF)", encoding.getEncodingName());
    assertEquals("caroncommaaccent", glyphNames[671]);
    assertEquals("club", glyphNames[653]);
    CmapTable cmap = ((TrueTypeFont) fontBoxFont).getCmap();
    assertEquals("cmap", cmap.getTag());
    assertEquals("comma", glyphNames[15]);
    assertEquals("commaaccentrotate", glyphNames[672]);
    assertEquals("cyrillicbreve", glyphNames[670]);
    assertEquals("diamond", glyphNames[655]);
    assertEquals("dollar", glyphNames[7]);
    assertEquals("eightsuperior", glyphNames[669]);
    assertEquals("exclam", glyphNames[4]);
    assertEquals("female", glyphNames[650]);
    assertEquals("five", glyphNames[24]);
    assertEquals("fivesuperior", glyphNames[667]);
    assertEquals("four", glyphNames[23]);
    assertEquals("foursuperior", glyphNames[666]);
    Map<String, TTFTable> tableMap = ((TrueTypeFont) fontBoxFont).getTableMap();
    assertEquals(19, tableMap.size());
    TTFTable getResult4 = tableMap.get("fpgm");
    assertEquals("fpgm", getResult4.getTag());
    GlyphTable glyph = ((TrueTypeFont) fontBoxFont).getGlyph();
    assertEquals("glyf", glyph.getTag());
    assertEquals("gregory", created.getCalendarType());
    assertEquals("gregory", modified.getCalendarType());
    assertEquals("head", header.getTag());
    assertEquals("heart", glyphNames[654]);
    HorizontalHeaderTable horizontalHeader = ((TrueTypeFont) fontBoxFont).getHorizontalHeader();
    assertEquals("hhea", horizontalHeader.getTag());
    HorizontalMetricsTable horizontalMetrics = ((TrueTypeFont) fontBoxFont).getHorizontalMetrics();
    assertEquals("hmtx", horizontalMetrics.getTag());
    NameRecord getResult5 = nameRecords.get(27);
    assertEquals("https://fedoraproject.org/wiki/Licensing/LiberationFontLicense", getResult5.getString());
    assertEquals("invsmileface", glyphNames[648]);
    KerningTable kerning = ((TrueTypeFont) fontBoxFont).getKerning();
    assertEquals("kern", kerning.getTag());
    assertEquals("latn", gsubData.getActiveScriptName());
    IndexToLocationTable indexToLocation = ((TrueTypeFont) fontBoxFont).getIndexToLocation();
    assertEquals("loca", indexToLocation.getTag());
    assertEquals("male", glyphNames[651]);
    MaximumProfileTable maximumProfile = ((TrueTypeFont) fontBoxFont).getMaximumProfile();
    assertEquals("maxp", maximumProfile.getTag());
    assertEquals("middot", glyphNames[664]);
    assertEquals("musicalnote", glyphNames[656]);
    assertEquals("musicalnotedbl", glyphNames[657]);
    assertEquals("name", naming.getTag());
    assertEquals("nonmarkingreturn", codeToNameMap.get(13));
    assertEquals("nonmarkingreturn", codeToNameMap.get(9));
    assertEquals("nonmarkingreturn", glyphNames[2]);
    assertEquals("numbersign", glyphNames[6]);
    assertEquals("one", glyphNames[20]);
    assertEquals("parenleft", glyphNames[11]);
    assertEquals("parenright", glyphNames[PDPanose.LENGTH]);
    assertEquals("percent", glyphNames[8]);
    assertEquals("period", glyphNames[17]);
    assertEquals("pi1", glyphNames[665]);
    assertEquals("plus", glyphNames[14]);
    assertEquals("post", postScript.getTag());
    assertEquals("quotedbl", glyphNames[5]);
    assertEquals("quotesingle", glyphNames[PDPanoseClassification.LENGTH]);
    assertEquals("sevensuperior", glyphNames[668]);
    assertEquals("slash", glyphNames[18]);
    assertEquals("spade", glyphNames[652]);
    assertEquals("sun", glyphNames[649]);
    assertEquals("three", glyphNames[22]);
    assertEquals("two", glyphNames[21]);
    assertEquals("uni00A0", glyphNames[3]);
    assertEquals("uni00AD", glyphNames[Short.SIZE]);
    assertEquals("uni266C", glyphNames[658]);
    assertEquals("uniF004", glyphNames[661]);
    assertEquals("uniF005", glyphNames[662]);
    assertEquals("uniFB01", glyphNames[659]);
    assertEquals("uniFB02", glyphNames[660]);
    assertEquals("zero", glyphNames[19]);
    assertNull(actualPdTrueTypeFont.getSymbolicFlag());
    assertNull(actualPdTrueTypeFont.getSubType());
    assertNull(actualPdTrueTypeFont.getType());
    assertNull(actualPdTrueTypeFont.getBaseFont());
    assertNull(actualPdTrueTypeFont.getName());
    assertNull(actualPdTrueTypeFont.getStandard14AFM());
    assertNull(actualPdTrueTypeFont.getToUnicodeCMap());
    assertNull(((TrueTypeFont) fontBoxFont).getVerticalHeader());
    assertNull(((TrueTypeFont) fontBoxFont).getVerticalMetrics());
    assertNull(((TrueTypeFont) fontBoxFont).getVerticalOrigin());
    assertNull(actualPdTrueTypeFont.getFontDescriptor());
    assertEquals((short) -123, postScript.getUnderlinePosition());
    BoundingBox fontBBox = fontBoxFont.getFontBBox();
    assertEquals(-176.75781f, fontBBox.getLowerLeftX());
    BoundingBox boundingBox = actualPdTrueTypeFont.getBoundingBox();
    assertEquals(-176.75781f, boundingBox.getLowerLeftX());
    assertEquals(-303.22266f, fontBBox.getLowerLeftY());
    assertEquals(-303.22266f, boundingBox.getLowerLeftY());
    assertEquals((short) -360, horizontalHeader.getMinRightSideBearing());
    assertEquals((short) -362, header.getXMin());
    assertEquals((short) -362, horizontalHeader.getMinLeftSideBearing());
    assertEquals(-442, oS2Windows.getTypoDescender());
    assertEquals((short) -443, horizontalHeader.getDescender());
    assertEquals((short) -621, header.getYMin());
    Map<Integer, Integer> gIDToCode = actualPdTrueTypeFont.getGIDToCode();
    assertEquals(192, gIDToCode.size());
    assertEquals(0, gIDToCode.get(1).intValue());
    assertEquals(0, timeZone.getDSTSavings());
    CmapSubtable[] cmaps = cmap.getCmaps();
    CmapSubtable cmapSubtable = cmaps[1];
    assertEquals(0, cmapSubtable.getPlatformEncodingId());
    assertEquals(0, ((CmapSubtable) unicodeCmapLookup).getPlatformId());
    assertEquals(0, header.getMacStyle());
    assertEquals(0, maximumProfile.getMaxInstructionDefs());
    assertEquals(0, getResult.getLanguageId());
    assertEquals(0, getResult2.getLanguageId());
    assertEquals(0, getResult.getNameId());
    assertEquals(0, getResult.getPlatformEncodingId());
    assertEquals(0, getResult2.getPlatformEncodingId());
    assertEquals(0, oS2Windows.getDefaultChar());
    assertEquals(0.0f, postScript.getItalicAngle());
    assertEquals(0.0f, actualPdTrueTypeFont.getAverageFontWidth());
    assertEquals(0L, oS2Windows.getUnicodeRange3());
    assertEquals(0L, oS2Windows.getUnicodeRange4());
    assertEquals(0L, postScript.getIsFixedPitch());
    assertEquals(0L, postScript.getMaxMemType1());
    assertEquals(0L, postScript.getMaxMemType42());
    assertEquals(0L, postScript.getMinMemType1());
    assertEquals(0L, postScript.getMinMemType42());
    long[] offsets = indexToLocation.getOffsets();
    assertEquals(0L, offsets[0]);
    assertEquals((short) 0, header.getGlyphDataFormat());
    assertEquals((short) 0, header.getIndexToLocFormat());
    assertEquals((short) 0, horizontalHeader.getCaretSlopeRun());
    assertEquals((short) 0, horizontalHeader.getMetricDataFormat());
    assertEquals((short) 0, horizontalHeader.getReserved1());
    assertEquals((short) 0, horizontalHeader.getReserved2());
    assertEquals((short) 0, horizontalHeader.getReserved3());
    assertEquals((short) 0, horizontalHeader.getReserved4());
    assertEquals((short) 0, horizontalHeader.getReserved5());
    assertEquals((short) 0, oS2Windows.getFsType());
    assertEquals((short) 0, oS2Windows.getSubscriptXOffset());
    assertEquals((short) 0, oS2Windows.getSuperscriptXOffset());
    assertEquals(1, gIDToCode.get(0).intValue());
    assertEquals(1, created.getFirstDayOfWeek());
    assertEquals(1, modified.getFirstDayOfWeek());
    assertEquals(1, created.getMinimalDaysInFirstWeek());
    assertEquals(1, modified.getMinimalDaysInFirstWeek());
    CmapSubtable cmapSubtable2 = cmaps[2];
    assertEquals(1, cmapSubtable2.getPlatformEncodingId());
    assertEquals(1, cmapSubtable.getPlatformId());
    assertEquals(1, getResult2.getNameId());
    assertEquals(1, getResult3.getPlatformEncodingId());
    assertEquals(1, getResult5.getPlatformEncodingId());
    assertEquals(1, getResult.getPlatformId());
    assertEquals(1, getResult2.getPlatformId());
    assertEquals(1.0699921f, header.getFontRevision());
    assertEquals(1.0f, header.getVersion());
    assertEquals(1.0f, horizontalHeader.getVersion());
    assertEquals(1.0f, maximumProfile.getVersion());
    assertEquals(1.0f, ((TrueTypeFont) fontBoxFont).getVersion());
    assertEquals(1006.83594f, fontBBox.getUpperRightX());
    assertEquals(1006.83594f, boundingBox.getUpperRightX());
    assertEquals((short) 100, oS2Windows.getStrikeoutSize());
    assertEquals((short) 100, postScript.getUnderlineThickness());
    assertEquals(1033, getResult3.getLanguageId());
    assertEquals(1033, getResult5.getLanguageId());
    assertEquals(1035, maximumProfile.getMaxStackElements());
    assertEquals(1123398000000L, created.getTimeInMillis());
    assertEquals((short) 1163, oS2Windows.getAverageCharWidth());
    assertEquals(1183.5938f, fontBBox.getWidth());
    assertEquals(1183.5938f, boundingBox.getWidth());
    assertEquals(119960L, offsets[649]);
    assertEquals(120312L, offsets[650]);
    assertEquals(1205227863L, kerning.getCheckSum());
    assertEquals(120524L, offsets[651]);
    assertEquals(120820L, offsets[652]);
    assertEquals(121604L, offsets[653]);
    assertEquals(122572L, offsets[654]);
    assertEquals(122740L, offsets[655]);
    assertEquals(122856L, offsets[656]);
    assertEquals(122L, gsub.getLength());
    assertEquals(123008L, offsets[657]);
    assertEquals(123224L, offsets[658]);
    assertEquals(123352L, offsets[659]);
    assertEquals(123732L, offsets[660]);
    assertEquals(124, getResult5.getStringLength());
    assertEquals(124128L, offsets[661]);
    assertEquals(124244L, offsets[662]);
    assertEquals(124380L, offsets[663]);
    assertEquals(124564L, offsets[664]);
    assertEquals(124768L, offsets[665]);
    assertEquals(124979259L, maximumProfile.getCheckSum());
    assertEquals(125, maximumProfile.getMaxCompositePoints());
    assertEquals(125008L, offsets[666]);
    assertEquals(125148L, offsets[667]);
    assertEquals(125356L, offsets[668]);
    assertEquals(125460L, offsets[669]);
    assertEquals(125776L, offsets[670]);
    assertEquals(125912L, offsets[671]);
    assertEquals(126036L, offsets[672]);
    assertEquals(126168L, glyph.getLength());
    assertEquals(126168L, offsets[673]);
    assertEquals(1284.668f, fontBBox.getHeight());
    assertEquals(1284.668f, boundingBox.getHeight());
    assertEquals(1299, getResult3.getStringOffset());
    assertEquals(13, getResult3.getNameId());
    assertEquals((short) 1331, oS2Windows.getSubscriptYSize());
    assertEquals((short) 1331, oS2Windows.getSuperscriptYSize());
    assertEquals(1341, oS2Windows.getCapHeight());
    assertEquals(1342208251L, oS2Windows.getUnicodeRange2());
    assertEquals(1348L, indexToLocation.getLength());
    assertEquals(1352L, offsets[8]);
    assertEquals(135480L, kerning.getOffset());
    assertEquals(1386048774000L, modified.getTimeInMillis());
    assertEquals(14, getResult5.getNameId());
    assertEquals(1404621704L, indexToLocation.getCheckSum());
    assertEquals(140700L, naming.getOffset());
    assertEquals(1420, oS2Windows.getTypoAscender());
    assertEquals(142868L, postScript.getOffset());
    assertEquals((short) 1434, oS2Windows.getSubscriptXSize());
    assertEquals((short) 1434, oS2Windows.getSuperscriptXSize());
    assertEquals(148168L, gsub.getOffset());
    assertEquals(152408L, ((TrueTypeFont) fontBoxFont).getOriginalDataSize());
    assertEquals(1593, maximumProfile.getMaxSizeOfInstructions());
    assertEquals(1594834165L, header.getMagicNumber());
    assertEquals(1610612895L, oS2Windows.getCodePageRange1());
    assertEquals(1635, getResult5.getStringOffset());
    Map<String, Integer> nameToCodeMap = encoding.getNameToCodeMap();
    assertEquals(192, nameToCodeMap.size());
    assertEquals(169, nameToCodeMap.get("copyright").intValue());
    assertEquals(1708L, offsets[9]);
    assertEquals(172, nameToCodeMap.get("logicalnot").intValue());
    assertEquals(1770L, cmap.getLength());
    assertEquals(1797L, getResult4.getLength());
    assertEquals(1804087085L, cmap.getCheckSum());
    assertEquals(1825, oS2Windows.getWinAscent());
    assertEquals((short) 1825, horizontalHeader.getAscender());
    assertEquals(19, ((TrueTypeFont) fontBoxFont).getTables().size());
    assertEquals(194, getResult.getStringOffset());
    assertEquals(1943217072L, getResult4.getCheckSum());
    assertEquals((short) 1, horizontalHeader.getCaretSlopeRise());
    assertEquals(2, maximumProfile.getMaxComponentDepth());
    assertEquals(2, maximumProfile.getMaxZones());
    assertEquals(2, oS2Windows.getMaxContext());
    assertEquals(2.0f, postScript.getFormatType());
    assertEquals(2005, created.getWeekYear());
    assertEquals((short) 2010, header.getYMax());
    assertEquals(2013, modified.getWeekYear());
    assertEquals(2048, header.getUnitsPerEm());
    assertEquals(2048, ((TrueTypeFont) fontBoxFont).getUnitsPerEm());
    assertEquals((short) 2062, header.getXMax());
    assertEquals((short) 2062, horizontalHeader.getXMaxExtent());
    assertEquals(211, nameToCodeMap.get("Oacute").intValue());
    assertEquals(2155, horizontalHeader.getAdvanceWidthMax());
    assertEquals(2166L, naming.getLength());
    assertEquals(222, getResult3.getStringLength());
    assertEquals(236914665L, horizontalHeader.getCheckSum());
    assertEquals(250.0f, actualPdTrueTypeFont.getSpaceWidth());
    assertEquals(2501031757L, header.getCheckSumAdjustment());
    assertEquals(2548L, offsets[PDPanoseClassification.LENGTH]);
    assertEquals(261, oS2Windows.getFamilyClass());
    assertEquals(2684355247L, oS2Windows.getUnicodeRange1());
    assertEquals(2690L, horizontalMetrics.getLength());
    assertEquals(2759005874L, postScript.getCheckSum());
    assertEquals((short) 293, oS2Windows.getSubscriptYOffset());
    assertEquals((short) 2, header.getFontDirectionHint());
    assertEquals(3, ((CmapSubtable) unicodeCmapLookup).getPlatformEncodingId());
    assertEquals(3, cmapSubtable2.getPlatformId());
    assertEquals(3, maximumProfile.getMaxComponentElements());
    assertEquals(3, getResult3.getPlatformId());
    assertEquals(3, getResult5.getPlatformId());
    assertEquals(3, oS2Windows.getVersion());
    assertEquals(3, cmaps.length);
    assertEquals(3000L, offsets[11]);
    assertEquals(307, oS2Windows.getTypoLineGap());
    assertEquals(31, header.getFlags());
    assertEquals(3148L, offsets[PDPanose.LENGTH]);
    assertEquals(316L, header.getOffset());
    assertEquals(3228L, cmap.getOffset());
    assertEquals(325, getResult2.getStringOffset());
    assertEquals(32L, maximumProfile.getLength());
    assertEquals(33, gIDToCode.get(4).intValue());
    assertEquals(33, oS2Windows.getFirstCharIndex());
    assertEquals(3304L, offsets[13]);
    assertEquals(338, maximumProfile.getMaxPoints());
    assertEquals(34, gIDToCode.get(5).intValue());
    assertEquals(344L, offsets[5]);
    assertEquals(3575500291L, horizontalMetrics.getCheckSum());
    assertEquals(3652L, offsets[14]);
    assertEquals(36L, horizontalHeader.getLength());
    assertEquals(372L, horizontalHeader.getOffset());
    assertEquals(3737457882L, naming.getCheckSum());
    assertEquals(3755409408L, oS2Windows.getCodePageRange2());
    assertEquals(3776L, offsets[15]);
    assertEquals(3912L, offsets[Short.SIZE]);
    Set<String> supportedScriptTags = gsub.getSupportedScriptTags();
    assertEquals(4, supportedScriptTags.size());
    List<Number> fontMatrix = fontBoxFont.getFontMatrix();
    assertEquals(6, fontMatrix.size());
    assertEquals(4.8828125E-4f, fontMatrix.get(0).floatValue());
    assertEquals(400, oS2Windows.getWeightClass());
    assertEquals(4036L, offsets[17]);
    assertEquals(4061832304L, glyph.getCheckSum());
    assertEquals(4088781771L, header.getCheckSum());
    assertEquals(408L, maximumProfile.getOffset());
    assertEquals(41, nameToCodeMap.get("parenright").intValue());
    assertEquals(4140L, offsets[18]);
    assertEquals(4193550753L, oS2Windows.getCheckSum());
    assertEquals((short) 420, oS2Windows.getStrikeoutPosition());
    assertEquals(4244L, offsets[19]);
    assertEquals(440L, oS2Windows.getOffset());
    assertEquals(443, oS2Windows.getWinDescent());
    assertEquals(4452L, offsets[20]);
    assertEquals(4564L, offsets[21]);
    assertEquals(47, maximumProfile.getMaxStorage());
    assertEquals(4792L, offsets[22]);
    assertEquals(5, maximumProfile.getMaxCompositeContours());
    assertEquals(5, oS2Windows.getWidthClass());
    assertEquals(5000L, getResult4.getOffset());
    byte[] byteArray = new byte[51];
    assertEquals(51, ((TrueTypeFont) fontBoxFont).getOriginalData().read(byteArray));
    assertEquals(5140L, offsets[23]);
    assertEquals(52, modified.getWeeksInWeekYear());
    assertEquals(5220L, kerning.getLength());
    assertEquals(5244L, postScript.getLength());
    assertEquals(53, created.getWeeksInWeekYear());
    assertEquals(5332L, offsets[24]);
    assertEquals(536L, horizontalMetrics.getOffset());
    assertEquals(54L, header.getLength());
    assertEquals(600L, offsets[6]);
    assertEquals(64258, oS2Windows.getLastCharIndex());
    assertEquals(672, horizontalHeader.getNumberOfHMetrics());
    assertEquals(673, maximumProfile.getNumGlyphs());
    assertEquals(673, ((TrueTypeFont) fontBoxFont).getNumberOfGlyphs());
    assertEquals(673, glyphNames.length);
    assertEquals(674, offsets.length);
    assertEquals(7964L, indexToLocation.getOffset());
    assertEquals(8, header.getLowestRecPPEM());
    assertEquals(84, maximumProfile.getMaxContours());
    assertEquals((short) 87, horizontalHeader.getLineGap());
    assertEquals(880L, offsets[7]);
    assertEquals(88L, offsets[1]);
    assertEquals(88L, offsets[2]);
    assertEquals(88L, offsets[3]);
    assertEquals(88L, offsets[4]);
    assertEquals(9, gIDToCode.get(2).intValue());
    assertEquals(90, maximumProfile.getMaxFunctionDefs());
    assertEquals((short) 928, oS2Windows.getSuperscriptYOffset());
    assertEquals(9312L, glyph.getOffset());
    assertEquals(940, oS2Windows.getHeight());
    assertEquals(96, getResult.getStringLength());
    assertEquals(96L, oS2Windows.getLength());
    assertEquals(981.4453f, fontBBox.getUpperRightY());
    assertEquals(981.4453f, boundingBox.getUpperRightY());
    assertEquals(986333945L, gsub.getCheckSum());
    assertEquals(Language.LATIN, gsubData.getLanguage());
    assertFalse(getResult4.getInitialized());
    assertFalse(actualPdTrueTypeFont.isVertical());
    assertFalse(actualPdTrueTypeFont.isDamaged());
    assertFalse(actualPdTrueTypeFont.isEmbedded());
    assertTrue(created.isLenient());
    assertTrue(modified.isLenient());
    assertTrue(created.isWeekDateSupported());
    assertTrue(modified.isWeekDateSupported());
    assertTrue(actualPdTrueTypeFont.getWidths().isEmpty());
    assertTrue(supportedScriptTags.contains("DFLT"));
    assertTrue(supportedScriptTags.contains("cyrl"));
    assertTrue(supportedScriptTags.contains("grek"));
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
    assertTrue(kerning.getHorizontalKerningSubtable().isHorizontalKerning());
    assertTrue(cmap.getInitialized());
    assertTrue(glyph.getInitialized());
    assertTrue(gsub.getInitialized());
    assertTrue(header.getInitialized());
    assertTrue(horizontalHeader.getInitialized());
    assertTrue(horizontalMetrics.getInitialized());
    assertTrue(indexToLocation.getInitialized());
    assertTrue(kerning.getInitialized());
    assertTrue(maximumProfile.getInitialized());
    assertTrue(naming.getInitialized());
    assertTrue(oS2Windows.getInitialized());
    assertTrue(postScript.getInitialized());
    assertTrue(((TrueTypeFont) fontBoxFont).isEnableGsub());
    assertEquals(timeZone, modified.getTimeZone());
    assertEquals(Double.SIZE, oS2Windows.getFsSelection());
    assertEquals(Integer.SIZE, gIDToCode.get(3).intValue());
    assertEquals(Integer.SIZE, oS2Windows.getBreakChar());
    assertEquals(Short.SIZE, maximumProfile.getMaxTwilightPoints());
    assertEquals(Short.SIZE, getResult2.getStringLength());
    assertSame(fontDictionary, actualPdTrueTypeFont.getCOSObject());
    assertSame(glyph, tableMap.get("glyf"));
    assertSame(kerning, tableMap.get("kern"));
    assertSame(oS2Windows, tableMap.get("OS/2"));
    Matrix expectedFontMatrix = actualPdTrueTypeFont.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualPdTrueTypeFont.getFontMatrix());
    assertSame(unicodeCmapLookup, cmaps[0]);
    assertSame(fontBoxFont, actualPdTrueTypeFont.getTrueTypeFont());
    assertSame(gsubData, gsub.getGsubData());
    assertArrayEquals(new byte[]{2, 2, 6, 3, 5, 4, 5, 2, 3, 4}, oS2Windows.getPanose());
    assertArrayEquals(new byte[]{0, 1, 0, 0, 0, 19, 1, 0, 0, 4, 0, '0', 'F', 'F', 'T', 'M', 'h', '0', 18, '{', 0, 2,
        'S', '<', 0, 0, 0, 28, 'G', 'D', 'E', 'F', 0, '\'', 2, -57, 0, 2, 'B', -96, 0, 0, 0, '&', 'G', 'P', 'O', 'S',
        '\b', -35, -11}, byteArray);
  }
}
