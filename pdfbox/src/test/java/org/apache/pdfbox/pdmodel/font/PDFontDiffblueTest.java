package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.encoding.GlyphList;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFontDiffblueTest {
  /**
   * Method under test: {@link PDFont#getStandard14AFM()}
   */
  @Test
  void testGetStandard14AFM() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSDictionary())).getStandard14AFM());
  }

  /**
   * Method under test: {@link PDFont#getFontDescriptor()}
   */
  @Test
  void testGetFontDescriptor() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSDictionary())).getFontDescriptor());
  }

  /**
   * Method under test: {@link PDFont#setFontDescriptor(PDFontDescriptor)}
   */
  @Test
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
   * Method under test: {@link PDFont#readCMap(COSBase)}
   */
  @Test
  void testReadCMap() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDMMType1Font(new COSDictionary())).readCMap(COSBoolean.FALSE));
  }

  /**
   * Method under test: {@link PDFont#getCOSObject()}
   */
  @Test
  void testGetCOSObject() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());

    // Act and Assert
    assertSame(pdmmType1Font.dict, pdmmType1Font.getCOSObject());
  }

  /**
   * Method under test: {@link PDFont#getPositionVector(int)}
   */
  @Test
  void testGetPositionVector() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDMMType1Font(new COSDictionary())).getPositionVector(1));
  }

  /**
   * Method under test: {@link PDFont#getDisplacement(int)}
   */
  @Test
  void testGetDisplacement() throws IOException {
    // Arrange and Act
    Vector actualDisplacement = (new PDMMType1Font(new COSDictionary())).getDisplacement(1);

    // Assert
    assertEquals(0.0f, actualDisplacement.getY());
    assertEquals(0.25f, actualDisplacement.getX());
  }

  /**
   * Method under test: {@link PDFont#getDisplacement(int)}
   */
  @Test
  void testGetDisplacement2() throws IOException {
    // Arrange and Act
    Vector actualDisplacement = (new PDMMType1Font(new COSDictionary())).getDisplacement(Integer.SIZE);

    // Assert
    assertEquals(0.0f, actualDisplacement.getY());
    assertEquals(0.25f, actualDisplacement.getX());
  }

  /**
   * Method under test: {@link PDFont#getWidth(int)}
   */
  @Test
  void testGetWidth() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250.0f, (new PDMMType1Font(new COSDictionary())).getWidth(1));
    assertEquals(250.0f, (new PDMMType1Font(new COSDictionary())).getWidth(Integer.SIZE));
  }

  /**
   * Method under test: {@link PDFont#encode(String)}
   */
  @Test
  void testEncode() throws IOException {
    // Arrange and Act
    byte[] actualEncodeResult = (new PDMMType1Font(new COSDictionary())).encode("Text");

    // Assert
    assertArrayEquals("Text".getBytes("UTF-8"), actualEncodeResult);
  }

  /**
   * Method under test: {@link PDFont#encode(String)}
   */
  @Test
  void testEncode2() throws IOException {
    // Arrange and Act
    byte[] actualEncodeResult = (new PDMMType1Font(new COSDictionary())).encode("Identity");

    // Assert
    assertArrayEquals("Identity".getBytes("UTF-8"), actualEncodeResult);
  }

  /**
   * Method under test: {@link PDFont#encode(String)}
   */
  @Test
  void testEncode3() throws IOException {
    // Arrange and Act
    byte[] actualEncodeResult = (new PDMMType1Font(new COSDictionary())).encode("Identity-");

    // Assert
    assertArrayEquals("Identity-".getBytes("UTF-8"), actualEncodeResult);
  }

  /**
   * Method under test: {@link PDFont#getStringWidth(String)}
   */
  @Test
  void testGetStringWidth() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1832.5195f, (new PDMMType1Font(new COSDictionary())).getStringWidth("Text"));
    assertEquals(3110.3516f, (new PDMMType1Font(new COSDictionary())).getStringWidth("Identity"));
    assertEquals(3443.3594f, (new PDMMType1Font(new COSDictionary())).getStringWidth("Identity-"));
  }

  /**
   * Method under test: {@link PDFont#getAverageFontWidth()}
   */
  @Test
  void testGetAverageFontWidth() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDTrueTypeFont(new COSDictionary())).getAverageFontWidth());
  }

  /**
   * Method under test: {@link PDFont#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());

    // Act and Assert
    assertNotEquals(pdmmType1Font, new PDMMType1Font(new COSDictionary()));
  }

  /**
   * Method under test: {@link PDFont#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDMMType1Font pdmmType1Font = new PDMMType1Font(fontDictionary);

    // Act and Assert
    assertNotEquals(pdmmType1Font, new PDMMType1Font(new COSDictionary()));
  }

  /**
   * Method under test: {@link PDFont#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDMMType1Font pdmmType1Font = new PDMMType1Font(fontDictionary);
    PDTrueTypeFont pdTrueTypeFont = mock(PDTrueTypeFont.class);
    when(pdTrueTypeFont.getCOSObject()).thenReturn(new COSDictionary());

    // Act and Assert
    assertNotEquals(pdmmType1Font, pdTrueTypeFont);
  }

  /**
   * Method under test: {@link PDFont#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() throws IOException {
    // Arrange, Act and Assert
    assertNotEquals(new PDMMType1Font(new COSDictionary()), null);
  }

  /**
   * Method under test: {@link PDFont#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() throws IOException {
    // Arrange, Act and Assert
    assertNotEquals(new PDMMType1Font(new COSDictionary()), "Different type to PDFont");
  }

  /**
   * Method under test: {@link PDFont#toUnicode(int)}
   */
  @Test
  void testToUnicode() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSDictionary())).toUnicode(1));
    assertEquals(".", (new PDMMType1Font(new COSDictionary())).toUnicode(46));
  }

  /**
   * Method under test: {@link PDFont#toUnicode(int, GlyphList)}
   */
  @Test
  void testToUnicode2() throws IOException {
    // Arrange
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
    PDType0Font loadResult = PDType0Font.load(doc, ttf, true);

    // Act
    String actualToUnicodeResult = loadResult.toUnicode(1, GlyphList.getAdobeGlyphList());

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
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup(eq(false));
    verify(streamCacheCreateFunction).create();
    assertNull(actualToUnicodeResult);
  }

  /**
   * Method under test: {@link PDFont#toUnicode(int, GlyphList)}
   */
  @Test
  void testToUnicode3() throws IOException {
    // Arrange
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
    when(ttf.getName()).thenReturn(null);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    when(ttf.getGsubData()).thenReturn(new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));
    PDType0Font loadResult = PDType0Font.load(doc, ttf, true);

    // Act
    String actualToUnicodeResult = loadResult.toUnicode(1, GlyphList.getAdobeGlyphList());

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
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup(eq(false));
    verify(streamCacheCreateFunction).create();
    assertNull(actualToUnicodeResult);
  }

  /**
   * Method under test: {@link PDFont#toUnicode(int, GlyphList)}
   */
  @Test
  void testToUnicode4() throws IOException {
    // Arrange
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
    PDType0Font loadResult = PDType0Font.load(doc, ttf, true);

    // Act
    String actualToUnicodeResult = loadResult.toUnicode(0, GlyphList.getAdobeGlyphList());

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
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup(eq(false));
    verify(streamCacheCreateFunction).create();
    assertNull(actualToUnicodeResult);
  }

  /**
   * Method under test: {@link PDFont#toUnicode(int, GlyphList)}
   */
  @Test
  void testToUnicode5() throws IOException {
    // Arrange
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
    PDType0Font loadResult = PDType0Font.load(doc, ttf, true);

    // Act
    String actualToUnicodeResult = loadResult.toUnicode(-1, GlyphList.getAdobeGlyphList());

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
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup();
    verify(ttf, atLeast(1)).getUnicodeCmapLookup(eq(false));
    verify(streamCacheCreateFunction).create();
    assertNull(actualToUnicodeResult);
  }

  /**
   * Method under test: {@link PDFont#getType()}
   */
  @Test
  void testGetType() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSDictionary())).getType());
  }

  /**
   * Method under test: {@link PDFont#getSubType()}
   */
  @Test
  void testGetSubType() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSDictionary())).getSubType());
  }

  /**
   * Method under test: {@link PDFont#getWidths()}
   */
  @Test
  void testGetWidths() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDMMType1Font(new COSDictionary())).getWidths().isEmpty());
  }

  /**
   * Method under test: {@link PDFont#getFontMatrix()}
   */
  @Test
  void testGetFontMatrix() throws IOException {
    // Arrange and Act
    Matrix actualFontMatrix = (new PDMMType1Font(new COSDictionary())).getFontMatrix();

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
   * Method under test: {@link PDFont#getFontMatrix()}
   */
  @Test
  void testGetFontMatrix2() throws IOException {
    // Arrange
    PDTrueTypeFont pdTrueTypeFont = new PDTrueTypeFont(new COSDictionary());

    // Act and Assert
    assertSame(pdTrueTypeFont.DEFAULT_FONT_MATRIX, pdTrueTypeFont.getFontMatrix());
  }

  /**
   * Method under test: {@link PDFont#getSpaceWidth()}
   */
  @Test
  void testGetSpaceWidth() throws IOException {
    // Arrange, Act and Assert
    assertEquals(250.0f, (new PDMMType1Font(new COSDictionary())).getSpaceWidth());
  }

  /**
   * Method under test: {@link PDFont#isStandard14()}
   */
  @Test
  void testIsStandard14() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSDictionary())).isStandard14());
  }

  /**
   * Method under test: {@link PDFont#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenThrowException() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDMMType1Font pdmmType1Font = new PDMMType1Font(fontDictionary);
    PDTrueTypeFont pdTrueTypeFont = mock(PDTrueTypeFont.class);
    when(pdTrueTypeFont.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdmmType1Font.equals(pdTrueTypeFont));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDFont#equals(Object)}
   *   <li>{@link PDFont#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());

    // Act and Assert
    assertEquals(pdmmType1Font, pdmmType1Font);
    int expectedHashCodeResult = pdmmType1Font.hashCode();
    assertEquals(expectedHashCodeResult, pdmmType1Font.hashCode());
  }

  /**
   * Method under test: {@link PDFont#toString()}
   */
  @Test
  void testToString() throws IOException {
    // Arrange, Act and Assert
    assertEquals("PDMMType1Font null", (new PDMMType1Font(new COSDictionary())).toString());
  }

  /**
   * Method under test: {@link PDFont#getToUnicodeCMap()}
   */
  @Test
  void testGetToUnicodeCMap() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSDictionary())).getToUnicodeCMap());
  }
}
