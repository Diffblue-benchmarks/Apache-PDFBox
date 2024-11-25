package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.GlyphData;
import org.apache.fontbox.ttf.GlyphTable;
import org.apache.fontbox.ttf.HeaderTable;
import org.apache.fontbox.ttf.HorizontalHeaderTable;
import org.apache.fontbox.ttf.HorizontalMetricsTable;
import org.apache.fontbox.ttf.MaximumProfileTable;
import org.apache.fontbox.ttf.OS2WindowsMetricsTable;
import org.apache.fontbox.ttf.PostScriptTable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.ttf.VerticalHeaderTable;
import org.apache.fontbox.ttf.VerticalMetricsTable;
import org.apache.fontbox.ttf.model.Language;
import org.apache.fontbox.ttf.model.MapBackedGsubData;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDType0FontDiffblueTest {
  /**
   * Test {@link PDType0Font#PDType0Font(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType0Font#PDType0Font(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDType0Font(COSDictionary); when COSDictionary(); then throw IOException")
  void testNewPDType0Font_whenCOSDictionary_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PDType0Font(new COSDictionary()));
  }

  /**
   * Test {@link PDType0Font#PDType0Font(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType0Font#PDType0Font(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDType0Font(COSDictionary); when COSStream(); then throw IOException")
  void testNewPDType0Font_whenCOSStream_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PDType0Font(new COSStream()));
  }

  /**
   * Test {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <p>
   * Method under test:
   * {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'")
  void testLoadWithDocTtfEmbedSubset() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act
    PDType0Font actualLoadResult = PDType0Font.load(doc, ttf, true);

    // Assert
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
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    COSDictionary cOSObject = actualLoadResult.getFontDescriptor().getCOSObject();
    assertEquals(11, cOSObject.getValues().size());
    assertEquals(11, cOSObject.size());
    COSDictionary cOSObject2 = actualLoadResult.getCOSObject();
    assertEquals(5, cOSObject2.getValues().size());
    assertEquals(5, cOSObject2.size());
  }

  /**
   * Test {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <p>
   * Method under test:
   * {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'")
  void testLoadWithDocTtfEmbedSubset2() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(-1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act
    PDType0Font actualLoadResult = PDType0Font.load(doc, ttf, true);

    // Assert
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
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    COSDictionary cOSObject = actualLoadResult.getFontDescriptor().getCOSObject();
    assertEquals(11, cOSObject.getValues().size());
    assertEquals(11, cOSObject.size());
    COSDictionary cOSObject2 = actualLoadResult.getCOSObject();
    assertEquals(5, cOSObject2.getValues().size());
    assertEquals(5, cOSObject2.size());
  }

  /**
   * Test {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <p>
   * Method under test:
   * {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'")
  void testLoadWithDocTtfEmbedSubset3() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    MaximumProfileTable maximumProfileTable = mock(MaximumProfileTable.class);
    when(maximumProfileTable.getNumGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getMaximumProfile()).thenReturn(maximumProfileTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act
    PDType0Font actualLoadResult = PDType0Font.load(doc, ttf, false);

    // Assert
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(anyInt());
    verify(maximumProfileTable).getNumGlyphs();
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
    verify(os2WindowsMetricsTable).getVersion();
    verify(os2WindowsMetricsTable).getWeightClass();
    verify(postScriptTable).getIsFixedPitch();
    verify(postScriptTable).getItalicAngle();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf).getMaximumProfile();
    verify(ttf, atLeast(1)).getName();
    verify(ttf).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf).getOriginalData();
    verify(ttf).getOriginalDataSize();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
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
    PDCIDFont descendantFont = actualLoadResult.getDescendantFont();
    assertTrue(descendantFont instanceof PDCIDFontType2);
    assertEquals(1, fontDescriptor.getFontFile2().getFilters().size());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    Matrix fontMatrix = actualLoadResult.getFontMatrix();
    assertEquals(expectedFontMatrix, fontMatrix);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    assertSame(fontDescriptor, descendantFont.getFontDescriptor());
    assertSame(fontMatrix, descendantFont.getFontMatrix());
    assertSame(actualLoadResult, descendantFont.getParent());
  }

  /**
   * Test {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <p>
   * Method under test:
   * {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'")
  void testLoadWithDocTtfEmbedSubset4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    MaximumProfileTable maximumProfileTable = mock(MaximumProfileTable.class);
    when(maximumProfileTable.getNumGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getMaximumProfile()).thenReturn(maximumProfileTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act
    PDType0Font actualLoadResult = PDType0Font.load(doc, ttf, false);

    // Assert
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(anyInt());
    verify(maximumProfileTable).getNumGlyphs();
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
    verify(os2WindowsMetricsTable).getVersion();
    verify(os2WindowsMetricsTable).getWeightClass();
    verify(postScriptTable).getIsFixedPitch();
    verify(postScriptTable).getItalicAngle();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf).getMaximumProfile();
    verify(ttf, atLeast(1)).getName();
    verify(ttf).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf).getOriginalData();
    verify(ttf).getOriginalDataSize();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
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
    PDCIDFont descendantFont = actualLoadResult.getDescendantFont();
    assertTrue(descendantFont instanceof PDCIDFontType2);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    assertEquals(1, fontFile2.getFilters().size());
    assertEquals(12L, fontFile2.getCOSObject().getLength());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    Matrix fontMatrix = actualLoadResult.getFontMatrix();
    assertEquals(expectedFontMatrix, fontMatrix);
    assertEquals(PDPanose.LENGTH, fontFile2.getLength());
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    assertSame(fontDescriptor, descendantFont.getFontDescriptor());
    assertSame(fontMatrix, descendantFont.getFontMatrix());
    assertSame(actualLoadResult, descendantFont.getParent());
  }

  /**
   * Test {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; given ByteArrayInputStream(byte[]) with empty array of byte")
  void testLoadWithDocTtfEmbedSubset_givenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    MaximumProfileTable maximumProfileTable = mock(MaximumProfileTable.class);
    when(maximumProfileTable.getNumGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getMaximumProfile()).thenReturn(maximumProfileTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream(new byte[]{}));
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act
    PDType0Font actualLoadResult = PDType0Font.load(doc, ttf, false);

    // Assert
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(anyInt());
    verify(maximumProfileTable).getNumGlyphs();
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
    verify(os2WindowsMetricsTable).getVersion();
    verify(os2WindowsMetricsTable).getWeightClass();
    verify(postScriptTable).getIsFixedPitch();
    verify(postScriptTable).getItalicAngle();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf).getMaximumProfile();
    verify(ttf, atLeast(1)).getName();
    verify(ttf).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf).getOriginalData();
    verify(ttf).getOriginalDataSize();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
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
    PDCIDFont descendantFont = actualLoadResult.getDescendantFont();
    assertTrue(descendantFont instanceof PDCIDFontType2);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    assertEquals(1, fontFile2.getFilters().size());
    assertEquals(8, fontFile2.getLength());
    assertEquals(8L, fontFile2.getCOSObject().getLength());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    Matrix fontMatrix = actualLoadResult.getFontMatrix();
    assertEquals(expectedFontMatrix, fontMatrix);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    assertSame(fontDescriptor, descendantFont.getFontDescriptor());
    assertSame(fontMatrix, descendantFont.getFontMatrix());
    assertSame(actualLoadResult, descendantFont.getParent());
  }

  /**
   * Test {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#markSupported()}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; given DataInputStream markSupported() return 'false'")
  void testLoadWithDocTtfEmbedSubset_givenDataInputStreamMarkSupportedReturnFalse() throws IOException {
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    DataInputStream dataInputStream = mock(DataInputStream.class);
    when(dataInputStream.markSupported()).thenReturn(false);
    when(dataInputStream.read(Mockito.<byte[]>any())).thenReturn(1);
    when(dataInputStream.transferTo(Mockito.<OutputStream>any())).thenReturn(1L);
    doNothing().when(dataInputStream).mark(anyInt());
    doNothing().when(dataInputStream).close();
    MaximumProfileTable maximumProfileTable = mock(MaximumProfileTable.class);
    when(maximumProfileTable.getNumGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getMaximumProfile()).thenReturn(maximumProfileTable);
    when(ttf.getOriginalData()).thenReturn(dataInputStream);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act
    PDType0Font actualLoadResult = PDType0Font.load(doc, ttf, false);

    // Assert
    verify(dataInputStream).read(isA(byte[].class));
    verify(dataInputStream, atLeast(1)).close();
    verify(dataInputStream).mark(eq(4));
    verify(dataInputStream).markSupported();
    verify(dataInputStream).transferTo(isA(OutputStream.class));
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(anyInt());
    verify(maximumProfileTable).getNumGlyphs();
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
    verify(os2WindowsMetricsTable).getVersion();
    verify(os2WindowsMetricsTable).getWeightClass();
    verify(postScriptTable).getIsFixedPitch();
    verify(postScriptTable).getItalicAngle();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf).getMaximumProfile();
    verify(ttf, atLeast(1)).getName();
    verify(ttf).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getOriginalData();
    verify(ttf).getOriginalDataSize();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
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
    PDCIDFont descendantFont = actualLoadResult.getDescendantFont();
    assertTrue(descendantFont instanceof PDCIDFontType2);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    assertEquals(1, fontFile2.getFilters().size());
    assertEquals(8, fontFile2.getLength());
    assertEquals(8L, fontFile2.getCOSObject().getLength());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    Matrix fontMatrix = actualLoadResult.getFontMatrix();
    assertEquals(expectedFontMatrix, fontMatrix);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    assertSame(fontDescriptor, descendantFont.getFontDescriptor());
    assertSame(fontMatrix, descendantFont.getFontMatrix());
    assertSame(actualLoadResult, descendantFont.getParent());
  }

  /**
   * Test {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Given one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; given one")
  void testLoadWithDocTtfEmbedSubset_givenOne() throws IOException {
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
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getNumberOfGlyphs()).thenReturn(1);
    when(ttf.getPath(Mockito.<String>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.TIMES_ROMAN, "Glyph Name"));
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act
    PDType0Font actualLoadResult = PDType0Font.load(doc, ttf, true);

    // Assert
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable).getAdvanceWidth(eq(0));
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable).getVersion();
    verify(os2WindowsMetricsTable).getWeightClass();
    verify(postScriptTable).getIsFixedPitch();
    verify(postScriptTable).getItalicAngle();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    PDFontDescriptor fontDescriptor = actualLoadResult.getFontDescriptor();
    assertEquals(0.0f, fontDescriptor.getCapHeight());
    assertEquals(0.0f, fontDescriptor.getXHeight());
    COSDictionary cOSObject = fontDescriptor.getCOSObject();
    assertEquals(11, cOSObject.getValues().size());
    assertEquals(11, cOSObject.size());
    COSDictionary cOSObject2 = actualLoadResult.getCOSObject();
    assertEquals(5, cOSObject2.getValues().size());
    assertEquals(5, cOSObject2.size());
  }

  /**
   * Test {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Given {@code x}.</li>
   *   <li>Then return DescendantFont BaseFont is {@code x}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; given 'x'; then return DescendantFont BaseFont is 'x'")
  void testLoadWithDocTtfEmbedSubset_givenX_thenReturnDescendantFontBaseFontIsX() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("x");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act
    PDType0Font actualLoadResult = PDType0Font.load(doc, ttf, true);

    // Assert
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
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    PDCIDFont descendantFont = actualLoadResult.getDescendantFont();
    assertTrue(descendantFont instanceof PDCIDFontType2);
    assertEquals("x", descendantFont.getBaseFont());
    assertEquals("x", descendantFont.getName());
    assertEquals("x", actualLoadResult.getFontDescriptor().getFontName());
    assertEquals("x", actualLoadResult.getBaseFont());
    assertEquals("x", actualLoadResult.getName());
  }

  /**
   * Test {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Then calls {@link FilterInputStream#reset()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; then calls reset()")
  void testLoadWithDocTtfEmbedSubset_thenCallsReset() throws IOException {
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    DataInputStream dataInputStream = mock(DataInputStream.class);
    doNothing().when(dataInputStream).reset();
    when(dataInputStream.markSupported()).thenReturn(true);
    when(dataInputStream.read(Mockito.<byte[]>any())).thenReturn(1);
    when(dataInputStream.transferTo(Mockito.<OutputStream>any())).thenReturn(1L);
    doNothing().when(dataInputStream).mark(anyInt());
    doNothing().when(dataInputStream).close();
    MaximumProfileTable maximumProfileTable = mock(MaximumProfileTable.class);
    when(maximumProfileTable.getNumGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getMaximumProfile()).thenReturn(maximumProfileTable);
    when(ttf.getOriginalData()).thenReturn(dataInputStream);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act
    PDType0Font actualLoadResult = PDType0Font.load(doc, ttf, false);

    // Assert
    verify(dataInputStream).read(isA(byte[].class));
    verify(dataInputStream).close();
    verify(dataInputStream).mark(eq(4));
    verify(dataInputStream).markSupported();
    verify(dataInputStream).reset();
    verify(dataInputStream).transferTo(isA(OutputStream.class));
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(anyInt());
    verify(maximumProfileTable).getNumGlyphs();
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
    verify(os2WindowsMetricsTable).getVersion();
    verify(os2WindowsMetricsTable).getWeightClass();
    verify(postScriptTable).getIsFixedPitch();
    verify(postScriptTable).getItalicAngle();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf).getMaximumProfile();
    verify(ttf, atLeast(1)).getName();
    verify(ttf).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf).getOriginalData();
    verify(ttf).getOriginalDataSize();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
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
    PDCIDFont descendantFont = actualLoadResult.getDescendantFont();
    assertTrue(descendantFont instanceof PDCIDFontType2);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    assertEquals(1, fontFile2.getFilters().size());
    assertEquals(8, fontFile2.getLength());
    assertEquals(8L, fontFile2.getCOSObject().getLength());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    Matrix expectedFontMatrix = actualLoadResult.DEFAULT_FONT_MATRIX;
    Matrix fontMatrix = actualLoadResult.getFontMatrix();
    assertEquals(expectedFontMatrix, fontMatrix);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    assertSame(fontDescriptor, descendantFont.getFontDescriptor());
    assertSame(fontMatrix, descendantFont.getFontMatrix());
    assertSame(actualLoadResult, descendantFont.getParent());
  }

  /**
   * Test {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Then return BoundingBox LowerLeftX is {@code 2.14748365E9}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; then return BoundingBox LowerLeftX is '2.14748365E9'")
  void testLoadWithDocTtfEmbedSubset_thenReturnBoundingBoxLowerLeftXIs214748365e9() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
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
    when(headerTable.getUnitsPerEm()).thenReturn(0);
    when(headerTable.getXMax()).thenReturn((short) 1);
    when(headerTable.getXMin()).thenReturn((short) 1);
    when(headerTable.getYMax()).thenReturn((short) 1);
    when(headerTable.getYMin()).thenReturn((short) 1);
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act
    PDType0Font actualLoadResult = PDType0Font.load(doc, ttf, true);

    // Assert
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
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    PDCIDFont descendantFont = actualLoadResult.getDescendantFont();
    assertTrue(descendantFont instanceof PDCIDFontType2);
    BoundingBox boundingBox = actualLoadResult.getBoundingBox();
    assertEquals(2.14748365E9f, boundingBox.getLowerLeftX());
    assertEquals(2.14748365E9f, boundingBox.getLowerLeftY());
    assertEquals(2.14748365E9f, boundingBox.getUpperRightX());
    assertEquals(2.14748365E9f, boundingBox.getUpperRightY());
    PDFontDescriptor fontDescriptor = actualLoadResult.getFontDescriptor();
    PDRectangle fontBoundingBox = fontDescriptor.getFontBoundingBox();
    assertEquals(2.14748365E9f, fontBoundingBox.getLowerLeftX());
    assertEquals(2.14748365E9f, fontBoundingBox.getLowerLeftY());
    assertEquals(2.14748365E9f, fontBoundingBox.getUpperRightX());
    assertEquals(2.14748365E9f, fontBoundingBox.getUpperRightY());
    assertEquals(2.14748365E9f, descendantFont.getAverageFontWidth());
    assertEquals(2.14748365E9f, actualLoadResult.getAverageFontWidth());
    assertEquals(Float.POSITIVE_INFINITY, fontDescriptor.getAscent());
    assertEquals(Float.POSITIVE_INFINITY, fontDescriptor.getCapHeight());
    assertEquals(Float.POSITIVE_INFINITY, fontDescriptor.getDescent());
    assertEquals(Float.POSITIVE_INFINITY, fontDescriptor.getXHeight());
  }

  /**
   * Test {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Then return DescendantFont BaseFont is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; then return DescendantFont BaseFont is 'null'")
  void testLoadWithDocTtfEmbedSubset_thenReturnDescendantFontBaseFontIsNull() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn(null);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act
    PDType0Font actualLoadResult = PDType0Font.load(doc, ttf, true);

    // Assert
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
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    PDCIDFont descendantFont = actualLoadResult.getDescendantFont();
    assertTrue(descendantFont instanceof PDCIDFontType2);
    assertNull(descendantFont.getBaseFont());
    assertNull(descendantFont.getName());
    PDFontDescriptor fontDescriptor = actualLoadResult.getFontDescriptor();
    assertNull(fontDescriptor.getFontName());
    assertNull(actualLoadResult.getBaseFont());
    assertNull(actualLoadResult.getName());
    COSDictionary cOSObject = actualLoadResult.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    COSDictionary cOSObject2 = descendantFont.getCOSObject();
    assertEquals(6, cOSObject2.getValues().size());
    assertEquals(6, cOSObject2.size());
    COSDictionary cOSObject3 = fontDescriptor.getCOSObject();
    assertEquals(PDPanoseClassification.LENGTH, cOSObject3.getValues().size());
    assertEquals(PDPanoseClassification.LENGTH, cOSObject3.size());
  }

  /**
   * Test {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Then return FontDescriptor CapHeight is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; then return FontDescriptor CapHeight is zero")
  void testLoadWithDocTtfEmbedSubset_thenReturnFontDescriptorCapHeightIsZero() throws IOException {
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
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.TIMES_ROMAN, "Glyph Name"));
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act
    PDType0Font actualLoadResult = PDType0Font.load(doc, ttf, true);

    // Assert
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
    verify(os2WindowsMetricsTable).getVersion();
    verify(os2WindowsMetricsTable).getWeightClass();
    verify(postScriptTable).getIsFixedPitch();
    verify(postScriptTable).getItalicAngle();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    PDFontDescriptor fontDescriptor = actualLoadResult.getFontDescriptor();
    assertEquals(0.0f, fontDescriptor.getCapHeight());
    assertEquals(0.0f, fontDescriptor.getXHeight());
    COSDictionary cOSObject = fontDescriptor.getCOSObject();
    assertEquals(11, cOSObject.getValues().size());
    assertEquals(11, cOSObject.size());
    COSDictionary cOSObject2 = actualLoadResult.getCOSObject();
    assertEquals(5, cOSObject2.getValues().size());
    assertEquals(5, cOSObject2.size());
  }

  /**
   * Test {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Then return FontDescriptor Flags is seven.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; then return FontDescriptor Flags is seven")
  void testLoadWithDocTtfEmbedSubset_thenReturnFontDescriptorFlagsIsSeven() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act
    PDType0Font actualLoadResult = PDType0Font.load(doc, ttf, true);

    // Assert
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
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    PDFontDescriptor fontDescriptor = actualLoadResult.getFontDescriptor();
    COSDictionary cOSObject = fontDescriptor.getCOSObject();
    assertEquals(11, cOSObject.getValues().size());
    assertEquals(11, cOSObject.size());
    COSDictionary cOSObject2 = actualLoadResult.getCOSObject();
    assertEquals(5, cOSObject2.getValues().size());
    assertEquals(5, cOSObject2.size());
    assertEquals(7, fontDescriptor.getFlags());
    assertFalse(fontDescriptor.isItalic());
  }

  /**
   * Test {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Then return FontDescriptor Flags is seventy.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; then return FontDescriptor Flags is seventy")
  void testLoadWithDocTtfEmbedSubset_thenReturnFontDescriptorFlagsIsSeventy() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act
    PDType0Font actualLoadResult = PDType0Font.load(doc, ttf, true);

    // Assert
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalHeaderTable).getNumberOfHMetrics();
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
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    PDFontDescriptor fontDescriptor = actualLoadResult.getFontDescriptor();
    COSDictionary cOSObject = fontDescriptor.getCOSObject();
    assertEquals(11, cOSObject.getValues().size());
    assertEquals(11, cOSObject.size());
    COSDictionary cOSObject2 = actualLoadResult.getCOSObject();
    assertEquals(5, cOSObject2.getValues().size());
    assertEquals(5, cOSObject2.size());
    assertEquals(70, fontDescriptor.getFlags());
    assertFalse(fontDescriptor.isFixedPitch());
  }

  /**
   * Test {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Then return FontDescriptor Flags is sixty-nine.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; then return FontDescriptor Flags is sixty-nine")
  void testLoadWithDocTtfEmbedSubset_thenReturnFontDescriptorFlagsIsSixtyNine() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act
    PDType0Font actualLoadResult = PDType0Font.load(doc, ttf, true);

    // Assert
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
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    PDFontDescriptor fontDescriptor = actualLoadResult.getFontDescriptor();
    COSDictionary cOSObject = fontDescriptor.getCOSObject();
    assertEquals(11, cOSObject.getValues().size());
    assertEquals(11, cOSObject.size());
    COSDictionary cOSObject2 = actualLoadResult.getCOSObject();
    assertEquals(5, cOSObject2.getValues().size());
    assertEquals(5, cOSObject2.size());
    assertEquals(69, fontDescriptor.getFlags());
    assertFalse(fontDescriptor.isSerif());
  }

  /**
   * Test {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; then throw IllegalStateException")
  void testLoadWithDocTtfEmbedSubset_thenThrowIllegalStateException() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    MaximumProfileTable maximumProfileTable = mock(MaximumProfileTable.class);
    when(maximumProfileTable.getNumGlyphs()).thenThrow(new IllegalStateException("H"));
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getMaximumProfile()).thenReturn(maximumProfileTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> PDType0Font.load(doc, ttf, false));
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(anyInt());
    verify(maximumProfileTable).getNumGlyphs();
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
    verify(os2WindowsMetricsTable).getVersion();
    verify(os2WindowsMetricsTable).getWeightClass();
    verify(postScriptTable).getIsFixedPitch();
    verify(postScriptTable).getItalicAngle();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf).getMaximumProfile();
    verify(ttf, atLeast(1)).getName();
    verify(ttf).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf).getOriginalData();
    verify(ttf).getOriginalDataSize();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
  }

  /**
   * Test {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#load(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; then throw UnsupportedOperationException")
  void testLoadWithDocTtfEmbedSubset_thenThrowUnsupportedOperationException() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getFsSelection()).thenThrow(new UnsupportedOperationException("foo"));
    PostScriptTable postScriptTable = mock(PostScriptTable.class);
    when(postScriptTable.getIsFixedPitch()).thenReturn(1L);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getHorizontalHeader()).thenReturn(mock(HorizontalHeaderTable.class));
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> PDType0Font.load(doc, ttf, true));
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(postScriptTable).getIsFixedPitch();
    verify(ttf).getGsubData();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getName();
    verify(ttf).getOS2Windows();
    verify(ttf).getPostScript();
    verify(ttf).getUnicodeCmapLookup();
  }

  /**
   * Test {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <p>
   * Method under test:
   * {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test loadVertical(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'")
  void testLoadVerticalWithDocTtfEmbedSubset() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    VerticalHeaderTable verticalHeaderTable = mock(VerticalHeaderTable.class);
    when(verticalHeaderTable.getAdvanceHeightMax()).thenReturn(1);
    when(verticalHeaderTable.getAscender()).thenReturn((short) 1);
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getGlyph(anyInt())).thenReturn(new GlyphData());
    VerticalMetricsTable verticalMetricsTable = mock(VerticalMetricsTable.class);
    when(verticalMetricsTable.getAdvanceHeight(anyInt())).thenReturn(1);
    when(verticalMetricsTable.getTopSideBearing(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getVerticalMetrics()).thenReturn(verticalMetricsTable);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    doNothing().when(ttf).enableVerticalSubstitutions();

    // Act
    PDType0Font actualLoadVerticalResult = PDType0Font.loadVertical(doc, ttf, true);

    // Assert
    verify(glyphTable, atLeast(1)).getGlyph(anyInt());
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
    verify(ttf).enableVerticalSubstitutions();
    verify(ttf).getGlyph();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    COSDictionary cOSObject = actualLoadVerticalResult.getFontDescriptor().getCOSObject();
    assertEquals(11, cOSObject.getValues().size());
    assertEquals(11, cOSObject.size());
    COSDictionary cOSObject2 = actualLoadVerticalResult.getCOSObject();
    assertEquals(5, cOSObject2.getValues().size());
    assertEquals(5, cOSObject2.size());
  }

  /**
   * Test {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <p>
   * Method under test:
   * {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test loadVertical(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'")
  void testLoadVerticalWithDocTtfEmbedSubset2() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
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
    when(headerTable.getUnitsPerEm()).thenReturn(0);
    when(headerTable.getXMax()).thenReturn((short) 1);
    when(headerTable.getXMin()).thenReturn((short) 1);
    when(headerTable.getYMax()).thenReturn((short) 1);
    when(headerTable.getYMin()).thenReturn((short) 1);
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    VerticalHeaderTable verticalHeaderTable = mock(VerticalHeaderTable.class);
    when(verticalHeaderTable.getAdvanceHeightMax()).thenReturn(1);
    when(verticalHeaderTable.getAscender()).thenReturn((short) 1);
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getGlyph(anyInt())).thenReturn(new GlyphData());
    VerticalMetricsTable verticalMetricsTable = mock(VerticalMetricsTable.class);
    when(verticalMetricsTable.getAdvanceHeight(anyInt())).thenReturn(1);
    when(verticalMetricsTable.getTopSideBearing(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getVerticalMetrics()).thenReturn(verticalMetricsTable);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    doNothing().when(ttf).enableVerticalSubstitutions();

    // Act
    PDType0Font actualLoadVerticalResult = PDType0Font.loadVertical(doc, ttf, true);

    // Assert
    verify(glyphTable, atLeast(1)).getGlyph(anyInt());
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
    verify(ttf).enableVerticalSubstitutions();
    verify(ttf).getGlyph();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    PDCIDFont descendantFont = actualLoadVerticalResult.getDescendantFont();
    assertTrue(descendantFont instanceof PDCIDFontType2);
    BoundingBox boundingBox = actualLoadVerticalResult.getBoundingBox();
    assertEquals(2.14748365E9f, boundingBox.getLowerLeftX());
    assertEquals(2.14748365E9f, boundingBox.getLowerLeftY());
    assertEquals(2.14748365E9f, boundingBox.getUpperRightX());
    assertEquals(2.14748365E9f, boundingBox.getUpperRightY());
    PDFontDescriptor fontDescriptor = actualLoadVerticalResult.getFontDescriptor();
    PDRectangle fontBoundingBox = fontDescriptor.getFontBoundingBox();
    assertEquals(2.14748365E9f, fontBoundingBox.getLowerLeftX());
    assertEquals(2.14748365E9f, fontBoundingBox.getLowerLeftY());
    assertEquals(2.14748365E9f, fontBoundingBox.getUpperRightX());
    assertEquals(2.14748365E9f, fontBoundingBox.getUpperRightY());
    assertEquals(2.14748365E9f, descendantFont.getAverageFontWidth());
    assertEquals(2.14748365E9f, actualLoadVerticalResult.getAverageFontWidth());
    assertEquals(Float.POSITIVE_INFINITY, fontDescriptor.getAscent());
    assertEquals(Float.POSITIVE_INFINITY, fontDescriptor.getCapHeight());
    assertEquals(Float.POSITIVE_INFINITY, fontDescriptor.getDescent());
    assertEquals(Float.POSITIVE_INFINITY, fontDescriptor.getXHeight());
  }

  /**
   * Test {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <p>
   * Method under test:
   * {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test loadVertical(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'")
  void testLoadVerticalWithDocTtfEmbedSubset3() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    VerticalHeaderTable verticalHeaderTable = mock(VerticalHeaderTable.class);
    when(verticalHeaderTable.getAdvanceHeightMax()).thenReturn(1);
    when(verticalHeaderTable.getAscender()).thenReturn((short) 1);
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getGlyph(anyInt())).thenReturn(new GlyphData());
    VerticalMetricsTable verticalMetricsTable = mock(VerticalMetricsTable.class);
    when(verticalMetricsTable.getAdvanceHeight(anyInt())).thenReturn(1);
    when(verticalMetricsTable.getTopSideBearing(anyInt())).thenReturn(1);
    MaximumProfileTable maximumProfileTable = mock(MaximumProfileTable.class);
    when(maximumProfileTable.getNumGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getMaximumProfile()).thenReturn(maximumProfileTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getVerticalMetrics()).thenReturn(verticalMetricsTable);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    doNothing().when(ttf).enableVerticalSubstitutions();

    // Act
    PDType0Font actualLoadVerticalResult = PDType0Font.loadVertical(doc, ttf, false);

    // Assert
    verify(glyphTable, atLeast(1)).getGlyph(anyInt());
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(anyInt());
    verify(maximumProfileTable).getNumGlyphs();
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
    verify(os2WindowsMetricsTable).getVersion();
    verify(os2WindowsMetricsTable).getWeightClass();
    verify(postScriptTable).getIsFixedPitch();
    verify(postScriptTable).getItalicAngle();
    verify(ttf).enableVerticalSubstitutions();
    verify(ttf).getGlyph();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf).getMaximumProfile();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf).getOriginalData();
    verify(ttf).getOriginalDataSize();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    PDFontDescriptor fontDescriptor = actualLoadVerticalResult.getFontDescriptor();
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
    PDCIDFont descendantFont = actualLoadVerticalResult.getDescendantFont();
    assertTrue(descendantFont instanceof PDCIDFontType2);
    assertEquals(1, fontDescriptor.getFontFile2().getFilters().size());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    Matrix expectedFontMatrix = actualLoadVerticalResult.DEFAULT_FONT_MATRIX;
    Matrix fontMatrix = actualLoadVerticalResult.getFontMatrix();
    assertEquals(expectedFontMatrix, fontMatrix);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    assertSame(fontDescriptor, descendantFont.getFontDescriptor());
    assertSame(fontMatrix, descendantFont.getFontMatrix());
    assertSame(actualLoadVerticalResult, descendantFont.getParent());
  }

  /**
   * Test {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <p>
   * Method under test:
   * {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test loadVertical(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'")
  void testLoadVerticalWithDocTtfEmbedSubset4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    VerticalHeaderTable verticalHeaderTable = mock(VerticalHeaderTable.class);
    when(verticalHeaderTable.getAdvanceHeightMax()).thenReturn(1);
    when(verticalHeaderTable.getAscender()).thenReturn((short) 1);
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getGlyph(anyInt())).thenReturn(new GlyphData());
    VerticalMetricsTable verticalMetricsTable = mock(VerticalMetricsTable.class);
    when(verticalMetricsTable.getAdvanceHeight(anyInt())).thenReturn(1);
    when(verticalMetricsTable.getTopSideBearing(anyInt())).thenReturn(1);
    MaximumProfileTable maximumProfileTable = mock(MaximumProfileTable.class);
    when(maximumProfileTable.getNumGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getMaximumProfile()).thenReturn(maximumProfileTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getVerticalMetrics()).thenReturn(verticalMetricsTable);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    doNothing().when(ttf).enableVerticalSubstitutions();

    // Act
    PDType0Font actualLoadVerticalResult = PDType0Font.loadVertical(doc, ttf, false);

    // Assert
    verify(glyphTable, atLeast(1)).getGlyph(anyInt());
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(anyInt());
    verify(maximumProfileTable).getNumGlyphs();
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
    verify(os2WindowsMetricsTable).getVersion();
    verify(os2WindowsMetricsTable).getWeightClass();
    verify(postScriptTable).getIsFixedPitch();
    verify(postScriptTable).getItalicAngle();
    verify(ttf).enableVerticalSubstitutions();
    verify(ttf).getGlyph();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf).getMaximumProfile();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf).getOriginalData();
    verify(ttf).getOriginalDataSize();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    verify(streamCacheCreateFunction).create();
    PDFontDescriptor fontDescriptor = actualLoadVerticalResult.getFontDescriptor();
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
    PDCIDFont descendantFont = actualLoadVerticalResult.getDescendantFont();
    assertTrue(descendantFont instanceof PDCIDFontType2);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    assertEquals(1, fontFile2.getFilters().size());
    assertEquals(12L, fontFile2.getCOSObject().getLength());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    Matrix expectedFontMatrix = actualLoadVerticalResult.DEFAULT_FONT_MATRIX;
    Matrix fontMatrix = actualLoadVerticalResult.getFontMatrix();
    assertEquals(expectedFontMatrix, fontMatrix);
    assertEquals(PDPanose.LENGTH, fontFile2.getLength());
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    assertSame(fontDescriptor, descendantFont.getFontDescriptor());
    assertSame(fontMatrix, descendantFont.getFontMatrix());
    assertSame(actualLoadVerticalResult, descendantFont.getParent());
  }

  /**
   * Test {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <p>
   * Method under test:
   * {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test loadVertical(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'")
  void testLoadVerticalWithDocTtfEmbedSubset5() throws IOException {
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    VerticalHeaderTable verticalHeaderTable = mock(VerticalHeaderTable.class);
    when(verticalHeaderTable.getAdvanceHeightMax()).thenReturn(1);
    when(verticalHeaderTable.getAscender()).thenReturn((short) 1);
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getGlyph(anyInt())).thenReturn(new GlyphData());
    VerticalMetricsTable verticalMetricsTable = mock(VerticalMetricsTable.class);
    when(verticalMetricsTable.getAdvanceHeight(anyInt())).thenReturn(1);
    when(verticalMetricsTable.getTopSideBearing(anyInt())).thenReturn(1);
    MaximumProfileTable maximumProfileTable = mock(MaximumProfileTable.class);
    when(maximumProfileTable.getNumGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getMaximumProfile()).thenReturn(maximumProfileTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream(new byte[]{}));
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getVerticalMetrics()).thenReturn(verticalMetricsTable);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    doNothing().when(ttf).enableVerticalSubstitutions();

    // Act
    PDType0Font actualLoadVerticalResult = PDType0Font.loadVertical(doc, ttf, false);

    // Assert
    verify(glyphTable, atLeast(1)).getGlyph(anyInt());
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(anyInt());
    verify(maximumProfileTable).getNumGlyphs();
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
    verify(os2WindowsMetricsTable).getVersion();
    verify(os2WindowsMetricsTable).getWeightClass();
    verify(postScriptTable).getIsFixedPitch();
    verify(postScriptTable).getItalicAngle();
    verify(ttf).enableVerticalSubstitutions();
    verify(ttf).getGlyph();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf).getMaximumProfile();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf).getOriginalData();
    verify(ttf).getOriginalDataSize();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    verify(streamCacheCreateFunction).create();
    PDFontDescriptor fontDescriptor = actualLoadVerticalResult.getFontDescriptor();
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
    PDCIDFont descendantFont = actualLoadVerticalResult.getDescendantFont();
    assertTrue(descendantFont instanceof PDCIDFontType2);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    assertEquals(1, fontFile2.getFilters().size());
    assertEquals(8, fontFile2.getLength());
    assertEquals(8L, fontFile2.getCOSObject().getLength());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    Matrix expectedFontMatrix = actualLoadVerticalResult.DEFAULT_FONT_MATRIX;
    Matrix fontMatrix = actualLoadVerticalResult.getFontMatrix();
    assertEquals(expectedFontMatrix, fontMatrix);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    assertSame(fontDescriptor, descendantFont.getFontDescriptor());
    assertSame(fontMatrix, descendantFont.getFontMatrix());
    assertSame(actualLoadVerticalResult, descendantFont.getParent());
  }

  /**
   * Test {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <p>
   * Method under test:
   * {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test loadVertical(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'")
  void testLoadVerticalWithDocTtfEmbedSubset6() throws IOException {
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    VerticalHeaderTable verticalHeaderTable = mock(VerticalHeaderTable.class);
    when(verticalHeaderTable.getAdvanceHeightMax()).thenReturn(1);
    when(verticalHeaderTable.getAscender()).thenReturn((short) 1);
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getGlyph(anyInt())).thenReturn(new GlyphData());
    VerticalMetricsTable verticalMetricsTable = mock(VerticalMetricsTable.class);
    when(verticalMetricsTable.getAdvanceHeight(anyInt())).thenReturn(1);
    when(verticalMetricsTable.getTopSideBearing(anyInt())).thenReturn(1);
    DataInputStream dataInputStream = mock(DataInputStream.class);
    when(dataInputStream.markSupported()).thenReturn(false);
    when(dataInputStream.read(Mockito.<byte[]>any())).thenReturn(1);
    when(dataInputStream.transferTo(Mockito.<OutputStream>any())).thenReturn(1L);
    doNothing().when(dataInputStream).mark(anyInt());
    doNothing().when(dataInputStream).close();
    MaximumProfileTable maximumProfileTable = mock(MaximumProfileTable.class);
    when(maximumProfileTable.getNumGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getMaximumProfile()).thenReturn(maximumProfileTable);
    when(ttf.getOriginalData()).thenReturn(dataInputStream);
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getVerticalMetrics()).thenReturn(verticalMetricsTable);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    doNothing().when(ttf).enableVerticalSubstitutions();

    // Act
    PDType0Font actualLoadVerticalResult = PDType0Font.loadVertical(doc, ttf, false);

    // Assert
    verify(dataInputStream).read(isA(byte[].class));
    verify(dataInputStream, atLeast(1)).close();
    verify(dataInputStream).mark(eq(4));
    verify(dataInputStream).markSupported();
    verify(dataInputStream).transferTo(isA(OutputStream.class));
    verify(glyphTable, atLeast(1)).getGlyph(anyInt());
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(anyInt());
    verify(maximumProfileTable).getNumGlyphs();
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
    verify(os2WindowsMetricsTable).getVersion();
    verify(os2WindowsMetricsTable).getWeightClass();
    verify(postScriptTable).getIsFixedPitch();
    verify(postScriptTable).getItalicAngle();
    verify(ttf).enableVerticalSubstitutions();
    verify(ttf).getGlyph();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf).getMaximumProfile();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getOriginalData();
    verify(ttf).getOriginalDataSize();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    verify(streamCacheCreateFunction).create();
    PDFontDescriptor fontDescriptor = actualLoadVerticalResult.getFontDescriptor();
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
    PDCIDFont descendantFont = actualLoadVerticalResult.getDescendantFont();
    assertTrue(descendantFont instanceof PDCIDFontType2);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    assertEquals(1, fontFile2.getFilters().size());
    assertEquals(8, fontFile2.getLength());
    assertEquals(8L, fontFile2.getCOSObject().getLength());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    Matrix expectedFontMatrix = actualLoadVerticalResult.DEFAULT_FONT_MATRIX;
    Matrix fontMatrix = actualLoadVerticalResult.getFontMatrix();
    assertEquals(expectedFontMatrix, fontMatrix);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    assertSame(fontDescriptor, descendantFont.getFontDescriptor());
    assertSame(fontMatrix, descendantFont.getFontMatrix());
    assertSame(actualLoadVerticalResult, descendantFont.getParent());
  }

  /**
   * Test {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Given {@link GlyphTable} {@link GlyphTable#getGlyph(int)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test loadVertical(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; given GlyphTable getGlyph(int) return 'null'")
  void testLoadVerticalWithDocTtfEmbedSubset_givenGlyphTableGetGlyphReturnNull() throws IOException {
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
    VerticalHeaderTable verticalHeaderTable = mock(VerticalHeaderTable.class);
    when(verticalHeaderTable.getAdvanceHeightMax()).thenReturn(1);
    when(verticalHeaderTable.getAscender()).thenReturn((short) 1);
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getGlyph(anyInt())).thenReturn(null);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getVerticalMetrics()).thenReturn(mock(VerticalMetricsTable.class));
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.TIMES_ROMAN, "Glyph Name"));
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    doNothing().when(ttf).enableVerticalSubstitutions();

    // Act
    PDType0Font actualLoadVerticalResult = PDType0Font.loadVertical(doc, ttf, true);

    // Assert
    verify(glyphTable, atLeast(1)).getGlyph(anyInt());
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
    verify(os2WindowsMetricsTable).getVersion();
    verify(os2WindowsMetricsTable).getWeightClass();
    verify(postScriptTable).getIsFixedPitch();
    verify(postScriptTable).getItalicAngle();
    verify(ttf).enableVerticalSubstitutions();
    verify(ttf).getGlyph();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    PDFontDescriptor fontDescriptor = actualLoadVerticalResult.getFontDescriptor();
    assertEquals(0.0f, fontDescriptor.getCapHeight());
    assertEquals(0.0f, fontDescriptor.getXHeight());
    COSDictionary cOSObject = fontDescriptor.getCOSObject();
    assertEquals(11, cOSObject.getValues().size());
    assertEquals(11, cOSObject.size());
    COSDictionary cOSObject2 = actualLoadVerticalResult.getCOSObject();
    assertEquals(5, cOSObject2.getValues().size());
    assertEquals(5, cOSObject2.size());
  }

  /**
   * Test {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Given one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test loadVertical(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; given one")
  void testLoadVerticalWithDocTtfEmbedSubset_givenOne() throws IOException {
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
    VerticalHeaderTable verticalHeaderTable = mock(VerticalHeaderTable.class);
    when(verticalHeaderTable.getAdvanceHeightMax()).thenReturn(1);
    when(verticalHeaderTable.getAscender()).thenReturn((short) 1);
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getGlyph(anyInt())).thenReturn(new GlyphData());
    VerticalMetricsTable verticalMetricsTable = mock(VerticalMetricsTable.class);
    when(verticalMetricsTable.getAdvanceHeight(anyInt())).thenReturn(1);
    when(verticalMetricsTable.getTopSideBearing(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getVerticalMetrics()).thenReturn(verticalMetricsTable);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(1);
    when(ttf.getPath(Mockito.<String>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.TIMES_ROMAN, "Glyph Name"));
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    doNothing().when(ttf).enableVerticalSubstitutions();

    // Act
    PDType0Font actualLoadVerticalResult = PDType0Font.loadVertical(doc, ttf, true);

    // Assert
    verify(glyphTable).getGlyph(eq(0));
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
    verify(ttf).enableVerticalSubstitutions();
    verify(ttf).getGlyph();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable).getAdvanceHeight(eq(0));
    verify(verticalMetricsTable).getTopSideBearing(eq(0));
    PDFontDescriptor fontDescriptor = actualLoadVerticalResult.getFontDescriptor();
    assertEquals(0.0f, fontDescriptor.getCapHeight());
    assertEquals(0.0f, fontDescriptor.getXHeight());
    COSDictionary cOSObject = fontDescriptor.getCOSObject();
    assertEquals(11, cOSObject.getValues().size());
    assertEquals(11, cOSObject.size());
    COSDictionary cOSObject2 = actualLoadVerticalResult.getCOSObject();
    assertEquals(5, cOSObject2.getValues().size());
    assertEquals(5, cOSObject2.size());
  }

  /**
   * Test {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Given {@code x}.</li>
   *   <li>Then return DescendantFont BaseFont is {@code x}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test loadVertical(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; given 'x'; then return DescendantFont BaseFont is 'x'")
  void testLoadVerticalWithDocTtfEmbedSubset_givenX_thenReturnDescendantFontBaseFontIsX() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    VerticalHeaderTable verticalHeaderTable = mock(VerticalHeaderTable.class);
    when(verticalHeaderTable.getAdvanceHeightMax()).thenReturn(1);
    when(verticalHeaderTable.getAscender()).thenReturn((short) 1);
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getGlyph(anyInt())).thenReturn(new GlyphData());
    VerticalMetricsTable verticalMetricsTable = mock(VerticalMetricsTable.class);
    when(verticalMetricsTable.getAdvanceHeight(anyInt())).thenReturn(1);
    when(verticalMetricsTable.getTopSideBearing(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getVerticalMetrics()).thenReturn(verticalMetricsTable);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("x");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    doNothing().when(ttf).enableVerticalSubstitutions();

    // Act
    PDType0Font actualLoadVerticalResult = PDType0Font.loadVertical(doc, ttf, true);

    // Assert
    verify(glyphTable, atLeast(1)).getGlyph(anyInt());
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
    verify(ttf).enableVerticalSubstitutions();
    verify(ttf).getGlyph();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    PDCIDFont descendantFont = actualLoadVerticalResult.getDescendantFont();
    assertTrue(descendantFont instanceof PDCIDFontType2);
    assertEquals("x", descendantFont.getBaseFont());
    assertEquals("x", descendantFont.getName());
    assertEquals("x", actualLoadVerticalResult.getFontDescriptor().getFontName());
    assertEquals("x", actualLoadVerticalResult.getBaseFont());
    assertEquals("x", actualLoadVerticalResult.getName());
  }

  /**
   * Test {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Then calls {@link FilterInputStream#reset()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test loadVertical(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; then calls reset()")
  void testLoadVerticalWithDocTtfEmbedSubset_thenCallsReset() throws IOException {
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    VerticalHeaderTable verticalHeaderTable = mock(VerticalHeaderTable.class);
    when(verticalHeaderTable.getAdvanceHeightMax()).thenReturn(1);
    when(verticalHeaderTable.getAscender()).thenReturn((short) 1);
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getGlyph(anyInt())).thenReturn(new GlyphData());
    VerticalMetricsTable verticalMetricsTable = mock(VerticalMetricsTable.class);
    when(verticalMetricsTable.getAdvanceHeight(anyInt())).thenReturn(1);
    when(verticalMetricsTable.getTopSideBearing(anyInt())).thenReturn(1);
    DataInputStream dataInputStream = mock(DataInputStream.class);
    doNothing().when(dataInputStream).reset();
    when(dataInputStream.markSupported()).thenReturn(true);
    when(dataInputStream.read(Mockito.<byte[]>any())).thenReturn(1);
    when(dataInputStream.transferTo(Mockito.<OutputStream>any())).thenReturn(1L);
    doNothing().when(dataInputStream).mark(anyInt());
    doNothing().when(dataInputStream).close();
    MaximumProfileTable maximumProfileTable = mock(MaximumProfileTable.class);
    when(maximumProfileTable.getNumGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getMaximumProfile()).thenReturn(maximumProfileTable);
    when(ttf.getOriginalData()).thenReturn(dataInputStream);
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getVerticalMetrics()).thenReturn(verticalMetricsTable);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    doNothing().when(ttf).enableVerticalSubstitutions();

    // Act
    PDType0Font actualLoadVerticalResult = PDType0Font.loadVertical(doc, ttf, false);

    // Assert
    verify(dataInputStream).read(isA(byte[].class));
    verify(dataInputStream).close();
    verify(dataInputStream).mark(eq(4));
    verify(dataInputStream).markSupported();
    verify(dataInputStream).reset();
    verify(dataInputStream).transferTo(isA(OutputStream.class));
    verify(glyphTable, atLeast(1)).getGlyph(anyInt());
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(anyInt());
    verify(maximumProfileTable).getNumGlyphs();
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
    verify(os2WindowsMetricsTable).getVersion();
    verify(os2WindowsMetricsTable).getWeightClass();
    verify(postScriptTable).getIsFixedPitch();
    verify(postScriptTable).getItalicAngle();
    verify(ttf).enableVerticalSubstitutions();
    verify(ttf).getGlyph();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf).getMaximumProfile();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf).getOriginalData();
    verify(ttf).getOriginalDataSize();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    verify(streamCacheCreateFunction).create();
    PDFontDescriptor fontDescriptor = actualLoadVerticalResult.getFontDescriptor();
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
    PDCIDFont descendantFont = actualLoadVerticalResult.getDescendantFont();
    assertTrue(descendantFont instanceof PDCIDFontType2);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    assertEquals(1, fontFile2.getFilters().size());
    assertEquals(8, fontFile2.getLength());
    assertEquals(8L, fontFile2.getCOSObject().getLength());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    Matrix expectedFontMatrix = actualLoadVerticalResult.DEFAULT_FONT_MATRIX;
    Matrix fontMatrix = actualLoadVerticalResult.getFontMatrix();
    assertEquals(expectedFontMatrix, fontMatrix);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    assertSame(fontDescriptor, descendantFont.getFontDescriptor());
    assertSame(fontMatrix, descendantFont.getFontMatrix());
    assertSame(actualLoadVerticalResult, descendantFont.getParent());
  }

  /**
   * Test {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Then return DescendantFont BaseFont is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test loadVertical(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; then return DescendantFont BaseFont is 'null'")
  void testLoadVerticalWithDocTtfEmbedSubset_thenReturnDescendantFontBaseFontIsNull() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    VerticalHeaderTable verticalHeaderTable = mock(VerticalHeaderTable.class);
    when(verticalHeaderTable.getAdvanceHeightMax()).thenReturn(1);
    when(verticalHeaderTable.getAscender()).thenReturn((short) 1);
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getGlyph(anyInt())).thenReturn(new GlyphData());
    VerticalMetricsTable verticalMetricsTable = mock(VerticalMetricsTable.class);
    when(verticalMetricsTable.getAdvanceHeight(anyInt())).thenReturn(1);
    when(verticalMetricsTable.getTopSideBearing(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getVerticalMetrics()).thenReturn(verticalMetricsTable);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn(null);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    doNothing().when(ttf).enableVerticalSubstitutions();

    // Act
    PDType0Font actualLoadVerticalResult = PDType0Font.loadVertical(doc, ttf, true);

    // Assert
    verify(glyphTable, atLeast(1)).getGlyph(anyInt());
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
    verify(ttf).enableVerticalSubstitutions();
    verify(ttf).getGlyph();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    PDCIDFont descendantFont = actualLoadVerticalResult.getDescendantFont();
    assertTrue(descendantFont instanceof PDCIDFontType2);
    assertNull(descendantFont.getBaseFont());
    assertNull(descendantFont.getName());
    PDFontDescriptor fontDescriptor = actualLoadVerticalResult.getFontDescriptor();
    assertNull(fontDescriptor.getFontName());
    assertNull(actualLoadVerticalResult.getBaseFont());
    assertNull(actualLoadVerticalResult.getName());
    COSDictionary cOSObject = actualLoadVerticalResult.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    COSDictionary cOSObject2 = descendantFont.getCOSObject();
    assertEquals(8, cOSObject2.getValues().size());
    assertEquals(8, cOSObject2.size());
    COSDictionary cOSObject3 = fontDescriptor.getCOSObject();
    assertEquals(PDPanoseClassification.LENGTH, cOSObject3.getValues().size());
    assertEquals(PDPanoseClassification.LENGTH, cOSObject3.size());
  }

  /**
   * Test {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Then return FontDescriptor CapHeight is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test loadVertical(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; then return FontDescriptor CapHeight is zero")
  void testLoadVerticalWithDocTtfEmbedSubset_thenReturnFontDescriptorCapHeightIsZero() throws IOException {
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
    VerticalHeaderTable verticalHeaderTable = mock(VerticalHeaderTable.class);
    when(verticalHeaderTable.getAdvanceHeightMax()).thenReturn(1);
    when(verticalHeaderTable.getAscender()).thenReturn((short) 1);
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getGlyph(anyInt())).thenReturn(new GlyphData());
    VerticalMetricsTable verticalMetricsTable = mock(VerticalMetricsTable.class);
    when(verticalMetricsTable.getAdvanceHeight(anyInt())).thenReturn(1);
    when(verticalMetricsTable.getTopSideBearing(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getVerticalMetrics()).thenReturn(verticalMetricsTable);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.TIMES_ROMAN, "Glyph Name"));
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    doNothing().when(ttf).enableVerticalSubstitutions();

    // Act
    PDType0Font actualLoadVerticalResult = PDType0Font.loadVertical(doc, ttf, true);

    // Assert
    verify(glyphTable, atLeast(1)).getGlyph(anyInt());
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
    verify(os2WindowsMetricsTable).getVersion();
    verify(os2WindowsMetricsTable).getWeightClass();
    verify(postScriptTable).getIsFixedPitch();
    verify(postScriptTable).getItalicAngle();
    verify(ttf).enableVerticalSubstitutions();
    verify(ttf).getGlyph();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    PDFontDescriptor fontDescriptor = actualLoadVerticalResult.getFontDescriptor();
    assertEquals(0.0f, fontDescriptor.getCapHeight());
    assertEquals(0.0f, fontDescriptor.getXHeight());
    COSDictionary cOSObject = fontDescriptor.getCOSObject();
    assertEquals(11, cOSObject.getValues().size());
    assertEquals(11, cOSObject.size());
    COSDictionary cOSObject2 = actualLoadVerticalResult.getCOSObject();
    assertEquals(5, cOSObject2.getValues().size());
    assertEquals(5, cOSObject2.size());
  }

  /**
   * Test {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Then return FontDescriptor Flags is seven.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test loadVertical(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; then return FontDescriptor Flags is seven")
  void testLoadVerticalWithDocTtfEmbedSubset_thenReturnFontDescriptorFlagsIsSeven() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    VerticalHeaderTable verticalHeaderTable = mock(VerticalHeaderTable.class);
    when(verticalHeaderTable.getAdvanceHeightMax()).thenReturn(1);
    when(verticalHeaderTable.getAscender()).thenReturn((short) 1);
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getGlyph(anyInt())).thenReturn(new GlyphData());
    VerticalMetricsTable verticalMetricsTable = mock(VerticalMetricsTable.class);
    when(verticalMetricsTable.getAdvanceHeight(anyInt())).thenReturn(1);
    when(verticalMetricsTable.getTopSideBearing(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getVerticalMetrics()).thenReturn(verticalMetricsTable);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    doNothing().when(ttf).enableVerticalSubstitutions();

    // Act
    PDType0Font actualLoadVerticalResult = PDType0Font.loadVertical(doc, ttf, true);

    // Assert
    verify(glyphTable, atLeast(1)).getGlyph(anyInt());
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
    verify(ttf).enableVerticalSubstitutions();
    verify(ttf).getGlyph();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    PDFontDescriptor fontDescriptor = actualLoadVerticalResult.getFontDescriptor();
    COSDictionary cOSObject = fontDescriptor.getCOSObject();
    assertEquals(11, cOSObject.getValues().size());
    assertEquals(11, cOSObject.size());
    COSDictionary cOSObject2 = actualLoadVerticalResult.getCOSObject();
    assertEquals(5, cOSObject2.getValues().size());
    assertEquals(5, cOSObject2.size());
    assertEquals(7, fontDescriptor.getFlags());
    assertFalse(fontDescriptor.isItalic());
  }

  /**
   * Test {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Then return FontDescriptor Flags is seventy.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test loadVertical(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; then return FontDescriptor Flags is seventy")
  void testLoadVerticalWithDocTtfEmbedSubset_thenReturnFontDescriptorFlagsIsSeventy() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    VerticalHeaderTable verticalHeaderTable = mock(VerticalHeaderTable.class);
    when(verticalHeaderTable.getAdvanceHeightMax()).thenReturn(1);
    when(verticalHeaderTable.getAscender()).thenReturn((short) 1);
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getGlyph(anyInt())).thenReturn(new GlyphData());
    VerticalMetricsTable verticalMetricsTable = mock(VerticalMetricsTable.class);
    when(verticalMetricsTable.getAdvanceHeight(anyInt())).thenReturn(1);
    when(verticalMetricsTable.getTopSideBearing(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getVerticalMetrics()).thenReturn(verticalMetricsTable);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    doNothing().when(ttf).enableVerticalSubstitutions();

    // Act
    PDType0Font actualLoadVerticalResult = PDType0Font.loadVertical(doc, ttf, true);

    // Assert
    verify(glyphTable, atLeast(1)).getGlyph(anyInt());
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalHeaderTable).getNumberOfHMetrics();
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
    verify(ttf).enableVerticalSubstitutions();
    verify(ttf).getGlyph();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    PDFontDescriptor fontDescriptor = actualLoadVerticalResult.getFontDescriptor();
    COSDictionary cOSObject = fontDescriptor.getCOSObject();
    assertEquals(11, cOSObject.getValues().size());
    assertEquals(11, cOSObject.size());
    COSDictionary cOSObject2 = actualLoadVerticalResult.getCOSObject();
    assertEquals(5, cOSObject2.getValues().size());
    assertEquals(5, cOSObject2.size());
    assertEquals(70, fontDescriptor.getFlags());
    assertFalse(fontDescriptor.isFixedPitch());
  }

  /**
   * Test {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Then return FontDescriptor Flags is sixty-nine.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test loadVertical(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; then return FontDescriptor Flags is sixty-nine")
  void testLoadVerticalWithDocTtfEmbedSubset_thenReturnFontDescriptorFlagsIsSixtyNine() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    VerticalHeaderTable verticalHeaderTable = mock(VerticalHeaderTable.class);
    when(verticalHeaderTable.getAdvanceHeightMax()).thenReturn(1);
    when(verticalHeaderTable.getAscender()).thenReturn((short) 1);
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getGlyph(anyInt())).thenReturn(new GlyphData());
    VerticalMetricsTable verticalMetricsTable = mock(VerticalMetricsTable.class);
    when(verticalMetricsTable.getAdvanceHeight(anyInt())).thenReturn(1);
    when(verticalMetricsTable.getTopSideBearing(anyInt())).thenReturn(1);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getVerticalMetrics()).thenReturn(verticalMetricsTable);
    when(ttf.getUnicodeCmapLookup(anyBoolean())).thenReturn(new CmapSubtable());
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    doNothing().when(ttf).enableVerticalSubstitutions();

    // Act
    PDType0Font actualLoadVerticalResult = PDType0Font.loadVertical(doc, ttf, true);

    // Assert
    verify(glyphTable, atLeast(1)).getGlyph(anyInt());
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
    verify(ttf).enableVerticalSubstitutions();
    verify(ttf).getGlyph();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getUnicodeCmapLookup(eq(false));
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    PDFontDescriptor fontDescriptor = actualLoadVerticalResult.getFontDescriptor();
    COSDictionary cOSObject = fontDescriptor.getCOSObject();
    assertEquals(11, cOSObject.getValues().size());
    assertEquals(11, cOSObject.size());
    COSDictionary cOSObject2 = actualLoadVerticalResult.getCOSObject();
    assertEquals(5, cOSObject2.getValues().size());
    assertEquals(5, cOSObject2.size());
    assertEquals(69, fontDescriptor.getFlags());
    assertFalse(fontDescriptor.isSerif());
  }

  /**
   * Test {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test loadVertical(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; then throw IllegalStateException")
  void testLoadVerticalWithDocTtfEmbedSubset_thenThrowIllegalStateException() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
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
    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);
    VerticalHeaderTable verticalHeaderTable = mock(VerticalHeaderTable.class);
    when(verticalHeaderTable.getAdvanceHeightMax()).thenReturn(1);
    when(verticalHeaderTable.getAscender()).thenReturn((short) 1);
    GlyphTable glyphTable = mock(GlyphTable.class);
    when(glyphTable.getGlyph(anyInt())).thenReturn(new GlyphData());
    VerticalMetricsTable verticalMetricsTable = mock(VerticalMetricsTable.class);
    when(verticalMetricsTable.getAdvanceHeight(anyInt())).thenReturn(1);
    when(verticalMetricsTable.getTopSideBearing(anyInt())).thenReturn(1);
    MaximumProfileTable maximumProfileTable = mock(MaximumProfileTable.class);
    when(maximumProfileTable.getNumGlyphs()).thenThrow(new IllegalStateException("H"));
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getMaximumProfile()).thenReturn(maximumProfileTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getVerticalMetrics()).thenReturn(verticalMetricsTable);
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    doNothing().when(ttf).enableVerticalSubstitutions();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> PDType0Font.loadVertical(doc, ttf, false));
    verify(glyphTable, atLeast(1)).getGlyph(anyInt());
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(anyInt());
    verify(maximumProfileTable).getNumGlyphs();
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable, atLeast(1)).getTypoAscender();
    verify(os2WindowsMetricsTable).getTypoDescender();
    verify(os2WindowsMetricsTable).getVersion();
    verify(os2WindowsMetricsTable).getWeightClass();
    verify(postScriptTable).getIsFixedPitch();
    verify(postScriptTable).getItalicAngle();
    verify(ttf).enableVerticalSubstitutions();
    verify(ttf).getGlyph();
    verify(ttf).getGsubData();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf).getMaximumProfile();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf).getOriginalData();
    verify(ttf).getOriginalDataSize();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
  }

  /**
   * Test {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)} with
   * {@code doc}, {@code ttf}, {@code embedSubset}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType0Font#loadVertical(PDDocument, TrueTypeFont, boolean)}
   */
  @Test
  @DisplayName("Test loadVertical(PDDocument, TrueTypeFont, boolean) with 'doc', 'ttf', 'embedSubset'; then throw UnsupportedOperationException")
  void testLoadVerticalWithDocTtfEmbedSubset_thenThrowUnsupportedOperationException() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getFsSelection()).thenThrow(new UnsupportedOperationException("foo"));
    PostScriptTable postScriptTable = mock(PostScriptTable.class);
    when(postScriptTable.getIsFixedPitch()).thenReturn(1L);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getHorizontalHeader()).thenReturn(mock(HorizontalHeaderTable.class));
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    doNothing().when(ttf).enableVerticalSubstitutions();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> PDType0Font.loadVertical(doc, ttf, true));
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(postScriptTable).getIsFixedPitch();
    verify(ttf).enableVerticalSubstitutions();
    verify(ttf).getGsubData();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getName();
    verify(ttf).getOS2Windows();
    verify(ttf).getPostScript();
    verify(ttf).getUnicodeCmapLookup();
  }
}
