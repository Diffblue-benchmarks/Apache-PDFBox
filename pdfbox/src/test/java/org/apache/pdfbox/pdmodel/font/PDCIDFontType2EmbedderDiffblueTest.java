package org.apache.pdfbox.pdmodel.font;

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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.OutputStream;
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
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDCIDFontType2EmbedderDiffblueTest {
  /**
   * Test
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <p>
   * Method under test:
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)")
  void testNewPDCIDFontType2Embedder() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    COSDictionary dict = new COSDictionary();
    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getFsSelection()).thenThrow(new IllegalArgumentException("foo"));
    PostScriptTable postScriptTable = mock(PostScriptTable.class);
    when(postScriptTable.getIsFixedPitch()).thenReturn(1L);
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getHorizontalHeader()).thenReturn(mock(HorizontalHeaderTable.class));
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new PDCIDFontType2Embedder(document, dict, ttf, true, null, true));

    verify(os2WindowsMetricsTable).getFsSelection();
    verify(postScriptTable).getIsFixedPitch();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getName();
    verify(ttf).getOS2Windows();
    verify(ttf).getPostScript();
  }

  /**
   * Test
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <p>
   * Method under test:
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)")
  void testNewPDCIDFontType2Embedder2() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    COSDictionary dict = new COSDictionary();
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
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDCIDFontType2Embedder actualPdcidFontType2Embedder = new PDCIDFontType2Embedder(document, dict, ttf, true, null,
        true);

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
    verify(ttf).getGlyph();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf).getUnicodeCmapLookup();
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    COSDictionary cOSObject = actualPdcidFontType2Embedder.getFontDescriptor().getCOSObject();
    assertEquals(11, cOSObject.getValues().size());
    assertEquals(11, cOSObject.size());
    assertEquals(4, dict.getValues().size());
    assertEquals(4, dict.size());
  }

  /**
   * Test
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <p>
   * Method under test:
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)")
  void testNewPDCIDFontType2Embedder3() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    COSDictionary dict = new COSDictionary();
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
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDCIDFontType2Embedder actualPdcidFontType2Embedder = new PDCIDFontType2Embedder(document, dict, ttf, true, null,
        true);

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
    verify(ttf).getGlyph();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf).getUnicodeCmapLookup();
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    PDCIDFont cIDFont = actualPdcidFontType2Embedder.getCIDFont();
    assertTrue(cIDFont instanceof PDCIDFontType2);
    BoundingBox boundingBox = cIDFont.getBoundingBox();
    assertEquals(2.14748365E9f, boundingBox.getLowerLeftX());
    assertEquals(2.14748365E9f, boundingBox.getLowerLeftY());
    assertEquals(2.14748365E9f, boundingBox.getUpperRightX());
    assertEquals(2.14748365E9f, boundingBox.getUpperRightY());
    PDFontDescriptor fontDescriptor = cIDFont.getFontDescriptor();
    PDRectangle fontBoundingBox = fontDescriptor.getFontBoundingBox();
    assertEquals(2.14748365E9f, fontBoundingBox.getLowerLeftX());
    PDFontDescriptor fontDescriptor2 = actualPdcidFontType2Embedder.getFontDescriptor();
    PDRectangle fontBoundingBox2 = fontDescriptor2.getFontBoundingBox();
    assertEquals(2.14748365E9f, fontBoundingBox2.getLowerLeftX());
    assertEquals(2.14748365E9f, fontBoundingBox.getLowerLeftY());
    assertEquals(2.14748365E9f, fontBoundingBox2.getLowerLeftY());
    assertEquals(2.14748365E9f, fontBoundingBox.getUpperRightX());
    assertEquals(2.14748365E9f, fontBoundingBox2.getUpperRightX());
    assertEquals(2.14748365E9f, fontBoundingBox.getUpperRightY());
    assertEquals(2.14748365E9f, fontBoundingBox2.getUpperRightY());
    assertEquals(2.14748365E9f, cIDFont.getAverageFontWidth());
    assertEquals(Float.POSITIVE_INFINITY, fontDescriptor.getAscent());
    assertEquals(Float.POSITIVE_INFINITY, fontDescriptor2.getAscent());
    assertEquals(Float.POSITIVE_INFINITY, fontDescriptor.getCapHeight());
    assertEquals(Float.POSITIVE_INFINITY, fontDescriptor2.getCapHeight());
    assertEquals(Float.POSITIVE_INFINITY, fontDescriptor.getDescent());
    assertEquals(Float.POSITIVE_INFINITY, fontDescriptor2.getDescent());
    assertEquals(Float.POSITIVE_INFINITY, fontDescriptor.getXHeight());
    assertEquals(Float.POSITIVE_INFINITY, fontDescriptor2.getXHeight());
  }

  /**
   * Test
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <p>
   * Method under test:
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)")
  void testNewPDCIDFontType2Embedder4() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    COSDictionary dict = new COSDictionary();
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
    when(maximumProfileTable.getNumGlyphs()).thenThrow(new IllegalArgumentException("H"));
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getMaximumProfile()).thenReturn(maximumProfileTable);
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getGlyph()).thenReturn(glyphTable);
    when(ttf.getVerticalMetrics()).thenReturn(verticalMetricsTable);
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new PDCIDFontType2Embedder(document, dict, ttf, false, null, true));

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
    verify(ttf).getGlyph();
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
    verify(ttf).getUnicodeCmapLookup();
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
  }

  /**
   * Test
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  void testNewPDCIDFontType2Embedder_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    COSDictionary dict = new COSDictionary();
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
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDCIDFontType2Embedder actualPdcidFontType2Embedder = new PDCIDFontType2Embedder(document, dict, ttf, false, null,
        true);

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
    verify(ttf).getGlyph();
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
    verify(ttf).getUnicodeCmapLookup();
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    PDFontDescriptor fontDescriptor = actualPdcidFontType2Embedder.getFontDescriptor();
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
    PDCIDFont cIDFont = actualPdcidFontType2Embedder.getCIDFont();
    assertTrue(cIDFont instanceof PDCIDFontType2);
    List<COSName> filters = fontDescriptor.getFontFile2().getFilters();
    assertEquals(1, filters.size());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    PDFontDescriptor fontDescriptor2 = cIDFont.getFontDescriptor();
    PDRectangle fontBoundingBox2 = fontDescriptor2.getFontBoundingBox();
    COSArray cOSArray2 = fontBoundingBox2.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    assertEquals(filters, fontDescriptor2.getFontFile2().getFilters());
    assertSame(cOSArray2, fontBoundingBox2.getCOSObject());
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    TrueTypeFont expectedTrueTypeFont = actualPdcidFontType2Embedder.ttf;
    assertSame(expectedTrueTypeFont, ((PDCIDFontType2) cIDFont).getTrueTypeFont());
  }

  /**
   * Test
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); given ByteArrayInputStream(byte[]) with empty array of byte")
  void testNewPDCIDFontType2Embedder_givenByteArrayInputStreamWithEmptyArrayOfByte() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    COSDictionary dict = new COSDictionary();
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
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDCIDFontType2Embedder actualPdcidFontType2Embedder = new PDCIDFontType2Embedder(document, dict, ttf, false, null,
        true);

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
    verify(ttf).getGlyph();
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
    verify(ttf).getUnicodeCmapLookup();
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    verify(streamCacheCreateFunction).create();
    PDFontDescriptor fontDescriptor = actualPdcidFontType2Embedder.getFontDescriptor();
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
    PDCIDFont cIDFont = actualPdcidFontType2Embedder.getCIDFont();
    assertTrue(cIDFont instanceof PDCIDFontType2);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    List<COSName> filters = fontFile2.getFilters();
    assertEquals(1, filters.size());
    PDFontDescriptor fontDescriptor2 = cIDFont.getFontDescriptor();
    PDStream fontFile22 = fontDescriptor2.getFontFile2();
    assertEquals(8, fontFile22.getLength());
    assertEquals(8, fontFile2.getLength());
    COSStream cOSObject = fontFile2.getCOSObject();
    assertEquals(8L, cOSObject.getLength());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    PDRectangle fontBoundingBox2 = fontDescriptor2.getFontBoundingBox();
    COSArray cOSArray2 = fontBoundingBox2.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    assertEquals(filters, fontFile22.getFilters());
    assertSame(cOSArray2, fontBoundingBox2.getCOSObject());
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    assertSame(cOSObject, fontFile22.getCOSObject());
    TrueTypeFont expectedTrueTypeFont = actualPdcidFontType2Embedder.ttf;
    assertSame(expectedTrueTypeFont, ((PDCIDFontType2) cIDFont).getTrueTypeFont());
  }

  /**
   * Test
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Given {@link DataInputStream} {@link FilterInputStream#markSupported()}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); given DataInputStream markSupported() return 'false'")
  void testNewPDCIDFontType2Embedder_givenDataInputStreamMarkSupportedReturnFalse() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    COSDictionary dict = new COSDictionary();
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
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDCIDFontType2Embedder actualPdcidFontType2Embedder = new PDCIDFontType2Embedder(document, dict, ttf, false, null,
        true);

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
    verify(ttf).getGlyph();
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
    verify(ttf).getUnicodeCmapLookup();
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    verify(streamCacheCreateFunction).create();
    PDFontDescriptor fontDescriptor = actualPdcidFontType2Embedder.getFontDescriptor();
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
    PDCIDFont cIDFont = actualPdcidFontType2Embedder.getCIDFont();
    assertTrue(cIDFont instanceof PDCIDFontType2);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    List<COSName> filters = fontFile2.getFilters();
    assertEquals(1, filters.size());
    PDFontDescriptor fontDescriptor2 = cIDFont.getFontDescriptor();
    PDStream fontFile22 = fontDescriptor2.getFontFile2();
    assertEquals(8, fontFile22.getLength());
    assertEquals(8, fontFile2.getLength());
    COSStream cOSObject = fontFile2.getCOSObject();
    assertEquals(8L, cOSObject.getLength());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    PDRectangle fontBoundingBox2 = fontDescriptor2.getFontBoundingBox();
    COSArray cOSArray2 = fontBoundingBox2.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    assertEquals(filters, fontFile22.getFilters());
    assertSame(cOSArray2, fontBoundingBox2.getCOSObject());
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    assertSame(cOSObject, fontFile22.getCOSObject());
    TrueTypeFont expectedTrueTypeFont = actualPdcidFontType2Embedder.ttf;
    assertSame(expectedTrueTypeFont, ((PDCIDFontType2) cIDFont).getTrueTypeFont());
  }

  /**
   * Test
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Given {@link GlyphTable} {@link GlyphTable#getGlyph(int)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); given GlyphTable getGlyph(int) return 'null'")
  void testNewPDCIDFontType2Embedder_givenGlyphTableGetGlyphReturnNull() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    COSDictionary dict = new COSDictionary();
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
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.TIMES_ROMAN, "Glyph Name"));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDCIDFontType2Embedder actualPdcidFontType2Embedder = new PDCIDFontType2Embedder(document, dict, ttf, true, null,
        true);

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
    verify(ttf).getGlyph();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf).getUnicodeCmapLookup();
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    PDCIDFont cIDFont = actualPdcidFontType2Embedder.getCIDFont();
    assertTrue(cIDFont instanceof PDCIDFontType2);
    PDFontDescriptor fontDescriptor = cIDFont.getFontDescriptor();
    assertEquals(0.0f, fontDescriptor.getCapHeight());
    PDFontDescriptor fontDescriptor2 = actualPdcidFontType2Embedder.getFontDescriptor();
    assertEquals(0.0f, fontDescriptor2.getCapHeight());
    assertEquals(0.0f, fontDescriptor.getXHeight());
    assertEquals(0.0f, fontDescriptor2.getXHeight());
  }

  /**
   * Test
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Given one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); given one")
  void testNewPDCIDFontType2Embedder_givenOne() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    COSDictionary dict = new COSDictionary();
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
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(1);
    when(ttf.getPath(Mockito.<String>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.TIMES_ROMAN, "Glyph Name"));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDCIDFontType2Embedder actualPdcidFontType2Embedder = new PDCIDFontType2Embedder(document, dict, ttf, true, null,
        true);

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
    verify(ttf).getGlyph();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf).getUnicodeCmapLookup();
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable).getAdvanceHeight(eq(0));
    verify(verticalMetricsTable).getTopSideBearing(eq(0));
    PDCIDFont cIDFont = actualPdcidFontType2Embedder.getCIDFont();
    assertTrue(cIDFont instanceof PDCIDFontType2);
    PDFontDescriptor fontDescriptor = cIDFont.getFontDescriptor();
    assertEquals(0.0f, fontDescriptor.getCapHeight());
    PDFontDescriptor fontDescriptor2 = actualPdcidFontType2Embedder.getFontDescriptor();
    assertEquals(0.0f, fontDescriptor2.getCapHeight());
    assertEquals(0.0f, fontDescriptor.getXHeight());
    assertEquals(0.0f, fontDescriptor2.getXHeight());
  }

  /**
   * Test
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); given PDPage()")
  void testNewPDCIDFontType2Embedder_givenPDPage() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    COSDictionary dict = new COSDictionary();
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
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDCIDFontType2Embedder actualPdcidFontType2Embedder = new PDCIDFontType2Embedder(document, dict, ttf, false, null,
        true);

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
    verify(ttf).getGlyph();
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
    verify(ttf).getUnicodeCmapLookup();
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    verify(streamCacheCreateFunction).create();
    PDFontDescriptor fontDescriptor = actualPdcidFontType2Embedder.getFontDescriptor();
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
    PDCIDFont cIDFont = actualPdcidFontType2Embedder.getCIDFont();
    assertTrue(cIDFont instanceof PDCIDFontType2);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    List<COSName> filters = fontFile2.getFilters();
    assertEquals(1, filters.size());
    COSStream cOSObject = fontFile2.getCOSObject();
    assertEquals(12L, cOSObject.getLength());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    PDFontDescriptor fontDescriptor2 = cIDFont.getFontDescriptor();
    PDRectangle fontBoundingBox2 = fontDescriptor2.getFontBoundingBox();
    COSArray cOSArray2 = fontBoundingBox2.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    PDStream fontFile22 = fontDescriptor2.getFontFile2();
    assertEquals(filters, fontFile22.getFilters());
    assertEquals(PDPanose.LENGTH, fontFile22.getLength());
    assertEquals(PDPanose.LENGTH, fontFile2.getLength());
    assertSame(cOSArray2, fontBoundingBox2.getCOSObject());
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    assertSame(cOSObject, fontFile22.getCOSObject());
    TrueTypeFont expectedTrueTypeFont = actualPdcidFontType2Embedder.ttf;
    assertSame(expectedTrueTypeFont, ((PDCIDFontType2) cIDFont).getTrueTypeFont());
  }

  /**
   * Test
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Given {@code x}.</li>
   *   <li>Then return CIDFont BaseFont is {@code x}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); given 'x'; then return CIDFont BaseFont is 'x'")
  void testNewPDCIDFontType2Embedder_givenX_thenReturnCIDFontBaseFontIsX() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    COSDictionary dict = new COSDictionary();
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
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("x");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDCIDFontType2Embedder actualPdcidFontType2Embedder = new PDCIDFontType2Embedder(document, dict, ttf, true, null,
        true);

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
    verify(ttf).getGlyph();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf).getUnicodeCmapLookup();
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    PDCIDFont cIDFont = actualPdcidFontType2Embedder.getCIDFont();
    assertTrue(cIDFont instanceof PDCIDFontType2);
    assertEquals("x", cIDFont.getBaseFont());
    assertEquals("x", cIDFont.getName());
    assertEquals("x", cIDFont.getFontDescriptor().getFontName());
    assertEquals("x", actualPdcidFontType2Embedder.getFontDescriptor().getFontName());
  }

  /**
   * Test
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); given zero")
  void testNewPDCIDFontType2Embedder_givenZero() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    COSDictionary dict = new COSDictionary();
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
    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getNumberOfGlyphs()).thenReturn(0);
    when(ttf.getPath(Mockito.<String>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.TIMES_ROMAN, "Glyph Name"));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(mock(HorizontalMetricsTable.class));
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new PDCIDFontType2Embedder(document, dict, ttf, true, null, true));

    verify(headerTable).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(os2WindowsMetricsTable).getFamilyClass();
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(os2WindowsMetricsTable).getFsType();
    verify(os2WindowsMetricsTable).getVersion();
    verify(os2WindowsMetricsTable).getWeightClass();
    verify(postScriptTable).getIsFixedPitch();
    verify(postScriptTable).getItalicAngle();
    verify(ttf).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf).getUnicodeCmapLookup();
  }

  /**
   * Test
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Then calls {@link FilterInputStream#reset()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); then calls reset()")
  void testNewPDCIDFontType2Embedder_thenCallsReset() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    COSDictionary dict = new COSDictionary();
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
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDCIDFontType2Embedder actualPdcidFontType2Embedder = new PDCIDFontType2Embedder(document, dict, ttf, false, null,
        true);

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
    verify(ttf).getGlyph();
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
    verify(ttf).getUnicodeCmapLookup();
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    verify(streamCacheCreateFunction).create();
    PDFontDescriptor fontDescriptor = actualPdcidFontType2Embedder.getFontDescriptor();
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
    PDCIDFont cIDFont = actualPdcidFontType2Embedder.getCIDFont();
    assertTrue(cIDFont instanceof PDCIDFontType2);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    List<COSName> filters = fontFile2.getFilters();
    assertEquals(1, filters.size());
    PDFontDescriptor fontDescriptor2 = cIDFont.getFontDescriptor();
    PDStream fontFile22 = fontDescriptor2.getFontFile2();
    assertEquals(8, fontFile22.getLength());
    assertEquals(8, fontFile2.getLength());
    COSStream cOSObject = fontFile2.getCOSObject();
    assertEquals(8L, cOSObject.getLength());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    PDRectangle fontBoundingBox2 = fontDescriptor2.getFontBoundingBox();
    COSArray cOSArray2 = fontBoundingBox2.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    assertEquals(filters, fontFile22.getFilters());
    assertSame(cOSArray2, fontBoundingBox2.getCOSObject());
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    assertSame(cOSObject, fontFile22.getCOSObject());
    TrueTypeFont expectedTrueTypeFont = actualPdcidFontType2Embedder.ttf;
    assertSame(expectedTrueTypeFont, ((PDCIDFontType2) cIDFont).getTrueTypeFont());
  }

  /**
   * Test
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Then return CIDFont BaseFont is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); then return CIDFont BaseFont is 'null'")
  void testNewPDCIDFontType2Embedder_thenReturnCIDFontBaseFontIsNull() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    COSDictionary dict = new COSDictionary();
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
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn(null);
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDCIDFontType2Embedder actualPdcidFontType2Embedder = new PDCIDFontType2Embedder(document, dict, ttf, true, null,
        true);

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
    verify(ttf).getGlyph();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf).getUnicodeCmapLookup();
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    PDCIDFont cIDFont = actualPdcidFontType2Embedder.getCIDFont();
    assertTrue(cIDFont instanceof PDCIDFontType2);
    assertNull(cIDFont.getBaseFont());
    assertNull(cIDFont.getName());
    assertNull(cIDFont.getFontDescriptor().getFontName());
    PDFontDescriptor fontDescriptor = actualPdcidFontType2Embedder.getFontDescriptor();
    assertNull(fontDescriptor.getFontName());
    assertEquals(3, dict.getValues().size());
    assertEquals(3, dict.size());
    COSDictionary cOSObject = cIDFont.getCOSObject();
    assertEquals(8, cOSObject.getValues().size());
    assertEquals(8, cOSObject.size());
    COSDictionary cOSObject2 = fontDescriptor.getCOSObject();
    assertEquals(PDPanoseClassification.LENGTH, cOSObject2.getValues().size());
    assertEquals(PDPanoseClassification.LENGTH, cOSObject2.size());
  }

  /**
   * Test
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Then return CIDFont COSObject Values size is seven.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); then return CIDFont COSObject Values size is seven")
  void testNewPDCIDFontType2Embedder_thenReturnCIDFontCOSObjectValuesSizeIsSeven() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    COSDictionary dict = new COSDictionary();
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
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDCIDFontType2Embedder actualPdcidFontType2Embedder = new PDCIDFontType2Embedder(document, dict, ttf, false, null,
        false);

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
    verify(ttf).getUnicodeCmapLookup();
    verify(streamCacheCreateFunction).create();
    PDFontDescriptor fontDescriptor = actualPdcidFontType2Embedder.getFontDescriptor();
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
    PDCIDFont cIDFont = actualPdcidFontType2Embedder.getCIDFont();
    assertTrue(cIDFont instanceof PDCIDFontType2);
    List<COSName> filters = fontDescriptor.getFontFile2().getFilters();
    assertEquals(1, filters.size());
    COSDictionary cOSObject = cIDFont.getCOSObject();
    assertEquals(7, cOSObject.getValues().size());
    assertEquals(7, cOSObject.size());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    PDFontDescriptor fontDescriptor2 = cIDFont.getFontDescriptor();
    PDRectangle fontBoundingBox2 = fontDescriptor2.getFontBoundingBox();
    COSArray cOSArray2 = fontBoundingBox2.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    assertEquals(filters, fontDescriptor2.getFontFile2().getFilters());
    assertSame(cOSArray2, fontBoundingBox2.getCOSObject());
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    TrueTypeFont expectedTrueTypeFont = actualPdcidFontType2Embedder.ttf;
    assertSame(expectedTrueTypeFont, ((PDCIDFontType2) cIDFont).getTrueTypeFont());
  }

  /**
   * Test
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Then return CIDFont FontDescriptor CapHeight is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); then return CIDFont FontDescriptor CapHeight is zero")
  void testNewPDCIDFontType2Embedder_thenReturnCIDFontFontDescriptorCapHeightIsZero() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    COSDictionary dict = new COSDictionary();
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
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(Standard14Fonts.FontName.TIMES_ROMAN, "Glyph Name"));
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDCIDFontType2Embedder actualPdcidFontType2Embedder = new PDCIDFontType2Embedder(document, dict, ttf, true, null,
        true);

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
    verify(ttf).getGlyph();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf).getUnicodeCmapLookup();
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    PDCIDFont cIDFont = actualPdcidFontType2Embedder.getCIDFont();
    assertTrue(cIDFont instanceof PDCIDFontType2);
    PDFontDescriptor fontDescriptor = cIDFont.getFontDescriptor();
    assertEquals(0.0f, fontDescriptor.getCapHeight());
    PDFontDescriptor fontDescriptor2 = actualPdcidFontType2Embedder.getFontDescriptor();
    assertEquals(0.0f, fontDescriptor2.getCapHeight());
    assertEquals(0.0f, fontDescriptor.getXHeight());
    assertEquals(0.0f, fontDescriptor2.getXHeight());
  }

  /**
   * Test
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Then return CIDFont FontDescriptor Flags is seven.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); then return CIDFont FontDescriptor Flags is seven")
  void testNewPDCIDFontType2Embedder_thenReturnCIDFontFontDescriptorFlagsIsSeven() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    COSDictionary dict = new COSDictionary();
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
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDCIDFontType2Embedder actualPdcidFontType2Embedder = new PDCIDFontType2Embedder(document, dict, ttf, true, null,
        true);

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
    verify(ttf).getGlyph();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf).getUnicodeCmapLookup();
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    PDCIDFont cIDFont = actualPdcidFontType2Embedder.getCIDFont();
    assertTrue(cIDFont instanceof PDCIDFontType2);
    PDFontDescriptor fontDescriptor = cIDFont.getFontDescriptor();
    assertEquals(7, fontDescriptor.getFlags());
    PDFontDescriptor fontDescriptor2 = actualPdcidFontType2Embedder.getFontDescriptor();
    assertEquals(7, fontDescriptor2.getFlags());
    assertFalse(fontDescriptor.isItalic());
    assertFalse(fontDescriptor2.isItalic());
  }

  /**
   * Test
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Then return CIDFont FontDescriptor Flags is seventy.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); then return CIDFont FontDescriptor Flags is seventy")
  void testNewPDCIDFontType2Embedder_thenReturnCIDFontFontDescriptorFlagsIsSeventy() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    COSDictionary dict = new COSDictionary();
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
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDCIDFontType2Embedder actualPdcidFontType2Embedder = new PDCIDFontType2Embedder(document, dict, ttf, true, null,
        true);

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
    verify(ttf).getGlyph();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf).getUnicodeCmapLookup();
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    PDCIDFont cIDFont = actualPdcidFontType2Embedder.getCIDFont();
    assertTrue(cIDFont instanceof PDCIDFontType2);
    PDFontDescriptor fontDescriptor = cIDFont.getFontDescriptor();
    assertEquals(70, fontDescriptor.getFlags());
    PDFontDescriptor fontDescriptor2 = actualPdcidFontType2Embedder.getFontDescriptor();
    assertEquals(70, fontDescriptor2.getFlags());
    assertFalse(fontDescriptor.isFixedPitch());
    assertFalse(fontDescriptor2.isFixedPitch());
  }

  /**
   * Test
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Then return CIDFont FontDescriptor Flags is sixty-nine.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); then return CIDFont FontDescriptor Flags is sixty-nine")
  void testNewPDCIDFontType2Embedder_thenReturnCIDFontFontDescriptorFlagsIsSixtyNine() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    COSDictionary dict = new COSDictionary();
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
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDCIDFontType2Embedder actualPdcidFontType2Embedder = new PDCIDFontType2Embedder(document, dict, ttf, true, null,
        true);

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
    verify(ttf).getGlyph();
    verify(ttf, atLeast(1)).getHeader();
    verify(ttf).getHorizontalHeader();
    verify(ttf, atLeast(1)).getHorizontalMetrics();
    verify(ttf, atLeast(1)).getName();
    verify(ttf, atLeast(1)).getNumberOfGlyphs();
    verify(ttf, atLeast(1)).getOS2Windows();
    verify(ttf, atLeast(1)).getPath(Mockito.<String>any());
    verify(ttf).getPostScript();
    verify(ttf).getUnicodeCmapLookup();
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    PDCIDFont cIDFont = actualPdcidFontType2Embedder.getCIDFont();
    assertTrue(cIDFont instanceof PDCIDFontType2);
    PDFontDescriptor fontDescriptor = cIDFont.getFontDescriptor();
    assertEquals(69, fontDescriptor.getFlags());
    PDFontDescriptor fontDescriptor2 = actualPdcidFontType2Embedder.getFontDescriptor();
    assertEquals(69, fontDescriptor2.getFlags());
    assertFalse(fontDescriptor.isSerif());
    assertFalse(fontDescriptor2.isSerif());
  }

  /**
   * Test
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>When {@link StreamCacheCreateFunction}
   * {@link StreamCacheCreateFunction#create()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); when StreamCacheCreateFunction create() return 'null'")
  void testNewPDCIDFontType2Embedder_whenStreamCacheCreateFunctionCreateReturnNull() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    COSDictionary dict = new COSDictionary();
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
    when(ttf.getVerticalHeader()).thenReturn(verticalHeaderTable);
    when(ttf.getNumberOfGlyphs()).thenReturn(PDPanoseClassification.LENGTH);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    when(ttf.getUnicodeCmapLookup()).thenReturn(new CmapSubtable());
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act
    PDCIDFontType2Embedder actualPdcidFontType2Embedder = new PDCIDFontType2Embedder(document, dict, ttf, false, null,
        true);

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
    verify(ttf).getGlyph();
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
    verify(ttf).getUnicodeCmapLookup();
    verify(ttf).getVerticalHeader();
    verify(ttf).getVerticalMetrics();
    verify(verticalHeaderTable).getAdvanceHeightMax();
    verify(verticalHeaderTable).getAscender();
    verify(verticalMetricsTable, atLeast(1)).getAdvanceHeight(anyInt());
    verify(verticalMetricsTable, atLeast(1)).getTopSideBearing(anyInt());
    verify(streamCacheCreateFunction).create();
    PDFontDescriptor fontDescriptor = actualPdcidFontType2Embedder.getFontDescriptor();
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
    PDCIDFont cIDFont = actualPdcidFontType2Embedder.getCIDFont();
    assertTrue(cIDFont instanceof PDCIDFontType2);
    PDStream fontFile2 = fontDescriptor.getFontFile2();
    List<COSName> filters = fontFile2.getFilters();
    assertEquals(1, filters.size());
    COSStream cOSObject = fontFile2.getCOSObject();
    assertEquals(12L, cOSObject.getLength());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    PDFontDescriptor fontDescriptor2 = cIDFont.getFontDescriptor();
    PDRectangle fontBoundingBox2 = fontDescriptor2.getFontBoundingBox();
    COSArray cOSArray2 = fontBoundingBox2.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    PDStream fontFile22 = fontDescriptor2.getFontFile2();
    assertEquals(filters, fontFile22.getFilters());
    assertEquals(PDPanose.LENGTH, fontFile22.getLength());
    assertEquals(PDPanose.LENGTH, fontFile2.getLength());
    assertSame(cOSArray2, fontBoundingBox2.getCOSObject());
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    assertSame(cOSObject, fontFile22.getCOSObject());
    TrueTypeFont expectedTrueTypeFont = actualPdcidFontType2Embedder.ttf;
    assertSame(expectedTrueTypeFont, ((PDCIDFontType2) cIDFont).getTrueTypeFont());
  }
}
