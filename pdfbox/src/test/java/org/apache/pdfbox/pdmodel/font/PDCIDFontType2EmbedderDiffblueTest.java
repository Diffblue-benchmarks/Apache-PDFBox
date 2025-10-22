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
import java.io.ByteArrayInputStream;
import java.io.IOException;
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
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDCIDFontType2EmbedderDiffblueTest {
  /**
   * Test {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <p>
   * Method under test: {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDCIDFontType2Embedder.<init>(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)"})
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
   * Test {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <p>
   * Method under test: {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDCIDFontType2Embedder.<init>(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)"})
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
    PDCIDFont cIDFont = actualPdcidFontType2Embedder.getCIDFont();
    assertTrue(cIDFont instanceof PDCIDFontType2);
    COSDictionary cOSObject = actualPdcidFontType2Embedder.getFontDescriptor().getCOSObject();
    assertEquals(11, cOSObject.getValues().size());
    assertEquals(11, cOSObject.size());
    float[][] values = cIDFont.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(4, dict.getValues().size());
    assertEquals(4, dict.size());
    assertArrayEquals(new float[]{0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <p>
   * Method under test: {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDCIDFontType2Embedder.<init>(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)"})
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
   * Test {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Given {@link GlyphTable} {@link GlyphTable#getGlyph(int)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); given GlyphTable getGlyph(int) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDCIDFontType2Embedder.<init>(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)"})
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
        .thenReturn(Standard14Fonts.getGlyphPath(FontName.TIMES_ROMAN, "Glyph Name"));
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
    float[][] values = cIDFont.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Given one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); given one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDCIDFontType2Embedder.<init>(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)"})
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
        .thenReturn(Standard14Fonts.getGlyphPath(FontName.TIMES_ROMAN, "Glyph Name"));
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
    float[][] values = cIDFont.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Given {@code x}.</li>
   *   <li>Then return CIDFont BaseFont is {@code x}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); given 'x'; then return CIDFont BaseFont is 'x'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDCIDFontType2Embedder.<init>(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)"})
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
    float[][] values = cIDFont.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Given zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); given zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDCIDFontType2Embedder.<init>(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)"})
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
        .thenReturn(Standard14Fonts.getGlyphPath(FontName.TIMES_ROMAN, "Glyph Name"));
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
   * Test {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Then return CIDFont AverageFontWidth is {@code 2.14748365E9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); then return CIDFont AverageFontWidth is '2.14748365E9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDCIDFontType2Embedder.<init>(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)"})
  void testNewPDCIDFontType2Embedder_thenReturnCIDFontAverageFontWidthIs214748365e9() throws IOException {
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
    assertEquals(2.14748365E9f, cIDFont.getAverageFontWidth());
    PDFontDescriptor fontDescriptor = actualPdcidFontType2Embedder.getFontDescriptor();
    assertEquals(Float.POSITIVE_INFINITY, fontDescriptor.getAscent());
    assertEquals(Float.POSITIVE_INFINITY, fontDescriptor.getCapHeight());
    assertEquals(Float.POSITIVE_INFINITY, fontDescriptor.getDescent());
    assertEquals(Float.POSITIVE_INFINITY, fontDescriptor.getXHeight());
  }

  /**
   * Test {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Then return CIDFont BaseFont is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); then return CIDFont BaseFont is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDCIDFontType2Embedder.<init>(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)"})
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
   * Test {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Then return CIDFont FontDescriptor CapHeight is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); then return CIDFont FontDescriptor CapHeight is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDCIDFontType2Embedder.<init>(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)"})
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
        .thenReturn(Standard14Fonts.getGlyphPath(FontName.TIMES_ROMAN, "Glyph Name"));
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
    float[][] values = cIDFont.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Then return CIDFont FontDescriptor Flags is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); then return CIDFont FontDescriptor Flags is seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDCIDFontType2Embedder.<init>(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)"})
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
    float[][] values = cIDFont.getFontMatrix().getValues();
    assertEquals(3, values.length);
    PDFontDescriptor fontDescriptor = cIDFont.getFontDescriptor();
    assertEquals(7, fontDescriptor.getFlags());
    PDFontDescriptor fontDescriptor2 = actualPdcidFontType2Embedder.getFontDescriptor();
    assertEquals(7, fontDescriptor2.getFlags());
    assertFalse(fontDescriptor.isItalic());
    assertFalse(fontDescriptor2.isItalic());
    assertArrayEquals(new float[]{0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Then return CIDFont FontDescriptor Flags is seventy.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); then return CIDFont FontDescriptor Flags is seventy")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDCIDFontType2Embedder.<init>(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)"})
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
    float[][] values = cIDFont.getFontMatrix().getValues();
    assertEquals(3, values.length);
    PDFontDescriptor fontDescriptor = cIDFont.getFontDescriptor();
    assertEquals(70, fontDescriptor.getFlags());
    PDFontDescriptor fontDescriptor2 = actualPdcidFontType2Embedder.getFontDescriptor();
    assertEquals(70, fontDescriptor2.getFlags());
    assertFalse(fontDescriptor.isFixedPitch());
    assertFalse(fontDescriptor2.isFixedPitch());
    assertArrayEquals(new float[]{0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Then return CIDFont FontDescriptor Flags is sixty-nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); then return CIDFont FontDescriptor Flags is sixty-nine")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDCIDFontType2Embedder.<init>(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)"})
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
    float[][] values = cIDFont.getFontMatrix().getValues();
    assertEquals(3, values.length);
    PDFontDescriptor fontDescriptor = cIDFont.getFontDescriptor();
    assertEquals(69, fontDescriptor.getFlags());
    PDFontDescriptor fontDescriptor2 = actualPdcidFontType2Embedder.getFontDescriptor();
    assertEquals(69, fontDescriptor2.getFlags());
    assertFalse(fontDescriptor.isSerif());
    assertFalse(fontDescriptor2.isSerif());
    assertArrayEquals(new float[]{0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}.
   * <ul>
   *   <li>Then return FontDescriptor FontFile2 Filters size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCIDFontType2Embedder#PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)}
   */
  @Test
  @DisplayName("Test new PDCIDFontType2Embedder(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean); then return FontDescriptor FontFile2 Filters size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDCIDFontType2Embedder.<init>(PDDocument, COSDictionary, TrueTypeFont, boolean, PDType0Font, boolean)"})
  void testNewPDCIDFontType2Embedder_thenReturnFontDescriptorFontFile2FiltersSizeIsOne() throws IOException {
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
    PDCIDFont cIDFont = actualPdcidFontType2Embedder.getCIDFont();
    assertTrue(cIDFont instanceof PDCIDFontType2);
    PDFontDescriptor fontDescriptor = actualPdcidFontType2Embedder.getFontDescriptor();
    List<COSName> filters = fontDescriptor.getFontFile2().getFilters();
    assertEquals(1, filters.size());
    float[][] values = cIDFont.getFontMatrix().getValues();
    assertEquals(3, values.length);
    PDRectangle fontBoundingBox = fontDescriptor.getFontBoundingBox();
    COSArray cOSArray = fontBoundingBox.getCOSArray();
    assertEquals(4, cOSArray.toList().size());
    assertEquals(filters, cIDFont.getFontDescriptor().getFontFile2().getFilters());
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    TrueTypeFont expectedTrueTypeFont = actualPdcidFontType2Embedder.ttf;
    assertSame(expectedTrueTypeFont, ((PDCIDFontType2) cIDFont).getTrueTypeFont());
    assertArrayEquals(new float[]{0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }
}
