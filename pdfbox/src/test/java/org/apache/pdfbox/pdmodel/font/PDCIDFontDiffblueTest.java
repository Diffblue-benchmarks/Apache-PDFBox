package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.HashMap;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.HeaderTable;
import org.apache.fontbox.ttf.HorizontalHeaderTable;
import org.apache.fontbox.ttf.HorizontalMetricsTable;
import org.apache.fontbox.ttf.OS2WindowsMetricsTable;
import org.apache.fontbox.ttf.PostScriptTable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.ttf.model.Language;
import org.apache.fontbox.ttf.model.MapBackedGsubData;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.Vector;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDCIDFontDiffblueTest {
  /**
   * Method under test: {@link PDCIDFont#getCOSObject()}
   */
  @Test
  void testGetCOSObject() throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSDictionary(), null);

    // Act and Assert
    assertSame(pdcidFontType0.dict, pdcidFontType0.getCOSObject());
  }

  /**
   * Method under test: {@link PDCIDFont#getBaseFont()}
   */
  @Test
  void testGetBaseFont() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSDictionary(), null)).getBaseFont());
  }

  /**
   * Method under test: {@link PDCIDFont#getName()}
   */
  @Test
  void testGetName() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSDictionary(), null)).getName());
  }

  /**
   * Method under test: {@link PDCIDFont#getFontDescriptor()}
   */
  @Test
  void testGetFontDescriptor() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSDictionary(), null)).getFontDescriptor());
  }

  /**
   * Method under test: {@link PDCIDFont#getParent()}
   */
  @Test
  void testGetParent() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSDictionary(), null)).getParent());
  }

  /**
   * Method under test: {@link PDCIDFont#hasExplicitWidth(int)}
   */
  @Test
  void testHasExplicitWidth() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getTypoAscender()).thenReturn(3);
    when(os2WindowsMetricsTable.getTypoDescender()).thenReturn(3);
    when(os2WindowsMetricsTable.getVersion()).thenReturn(1);
    when(os2WindowsMetricsTable.getFsType()).thenReturn((short) 1);
    when(os2WindowsMetricsTable.getFamilyClass()).thenReturn(1);
    when(os2WindowsMetricsTable.getFsSelection()).thenReturn(1);
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
    boolean actualHasExplicitWidthResult = (new PDCIDFontType0(fontDictionary, PDType0Font.load(doc, ttf, true)))
        .hasExplicitWidth(1);

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
    verify(fontDictionary, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(streamCacheCreateFunction).create();
    assertFalse(actualHasExplicitWidthResult);
  }

  /**
   * Method under test: {@link PDCIDFont#getPositionVector(int)}
   */
  @Test
  void testGetPositionVector() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getTypoAscender()).thenReturn(3);
    when(os2WindowsMetricsTable.getTypoDescender()).thenReturn(3);
    when(os2WindowsMetricsTable.getVersion()).thenReturn(1);
    when(os2WindowsMetricsTable.getFsType()).thenReturn((short) 1);
    when(os2WindowsMetricsTable.getFamilyClass()).thenReturn(1);
    when(os2WindowsMetricsTable.getFsSelection()).thenReturn(1);
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
    Vector actualPositionVector = (new PDCIDFontType0(fontDictionary, PDType0Font.load(doc, ttf, true)))
        .getPositionVector(1);

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
    verify(fontDictionary, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(fontDictionary).getDictionaryObject(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(streamCacheCreateFunction).create();
    assertEquals(500.0f, actualPositionVector.getX());
    assertEquals(880.0f, actualPositionVector.getY());
  }

  /**
   * Method under test: {@link PDCIDFont#getVerticalDisplacementVectorY(int)}
   */
  @Test
  void testGetVerticalDisplacementVectorY() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getTypoAscender()).thenReturn(3);
    when(os2WindowsMetricsTable.getTypoDescender()).thenReturn(3);
    when(os2WindowsMetricsTable.getVersion()).thenReturn(1);
    when(os2WindowsMetricsTable.getFsType()).thenReturn((short) 1);
    when(os2WindowsMetricsTable.getFamilyClass()).thenReturn(1);
    when(os2WindowsMetricsTable.getFsSelection()).thenReturn(1);
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
    float actualVerticalDisplacementVectorY = (new PDCIDFontType0(fontDictionary, PDType0Font.load(doc, ttf, true)))
        .getVerticalDisplacementVectorY(1);

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
    verify(fontDictionary, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(streamCacheCreateFunction).create();
    assertEquals(-1000.0f, actualVerticalDisplacementVectorY);
  }

  /**
   * Method under test: {@link PDCIDFont#getWidth(int)}
   */
  @Test
  void testGetWidth() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getTypoAscender()).thenReturn(3);
    when(os2WindowsMetricsTable.getTypoDescender()).thenReturn(3);
    when(os2WindowsMetricsTable.getVersion()).thenReturn(1);
    when(os2WindowsMetricsTable.getFsType()).thenReturn((short) 1);
    when(os2WindowsMetricsTable.getFamilyClass()).thenReturn(1);
    when(os2WindowsMetricsTable.getFsSelection()).thenReturn(1);
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
    float actualWidth = (new PDCIDFontType0(fontDictionary, PDType0Font.load(doc, ttf, true))).getWidth(1);

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
    verify(fontDictionary, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(fontDictionary).getDictionaryObject(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    verify(streamCacheCreateFunction).create();
    assertEquals(1000.0f, actualWidth);
  }

  /**
   * Method under test: {@link PDCIDFont#getAverageFontWidth()}
   */
  @Test
  void testGetAverageFontWidth() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1000.0f, (new PDCIDFontType2(new COSDictionary(), null)).getAverageFontWidth());
  }

  /**
   * Method under test: {@link PDCIDFont#getCIDSystemInfo()}
   */
  @Test
  void testGetCIDSystemInfo() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSDictionary(), null)).getCIDSystemInfo());
  }

  /**
   * Method under test: {@link PDCIDFont#readCIDToGIDMap()}
   */
  @Test
  void testReadCIDToGIDMap() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDCIDFontType0(new COSDictionary(), null)).readCIDToGIDMap());
  }
}
