package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.fontbox.encoding.StandardEncoding;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.GlyphSubstitutionTable;
import org.apache.fontbox.ttf.HeaderTable;
import org.apache.fontbox.ttf.HorizontalHeaderTable;
import org.apache.fontbox.ttf.HorizontalMetricsTable;
import org.apache.fontbox.ttf.OS2WindowsMetricsTable;
import org.apache.fontbox.ttf.PostScriptTable;
import org.apache.fontbox.ttf.SubstitutingCmapLookup;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.apache.pdfbox.pdmodel.font.encoding.DictionaryEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.MacExpertEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.MacOSRomanEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.SymbolEncoding;
import org.apache.pdfbox.pdmodel.font.encoding.Type1Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.ZapfDingbatsEncoding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDTrueTypeFontDiffblueTest {
  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code
   * ttf}, {@code encoding}.
   *
   * <p>Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    PostScriptTable postScriptTable = mock(PostScriptTable.class);
    when(postScriptTable.getIsFixedPitch()).thenThrow(new IllegalArgumentException());

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getHorizontalHeader()).thenReturn(mock(HorizontalHeaderTable.class));
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(mock(OS2WindowsMetricsTable.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> PDTrueTypeFont.load(doc, ttf, MacExpertEncoding.INSTANCE));
    verify(postScriptTable).getIsFixedPitch();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getName();
    verify(ttf).getOS2Windows();
    verify(ttf).getPostScript();
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code
   * ttf}, {@code encoding}.
   *
   * <p>Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding2() throws IOException {
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
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(0);
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
    float[][] values = actualLoadResult.getFontMatrix().getValues();
    assertEquals(3, values.length);
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
    assertSame(cOSArray, fontBoundingBox.getCOSObject());
    assertArrayEquals(new float[] {0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code
   * ttf}, {@code encoding}.
   *
   * <p>Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding3() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getFsSelection()).thenThrow(new IllegalArgumentException());

    PostScriptTable postScriptTable = mock(PostScriptTable.class);
    when(postScriptTable.getIsFixedPitch()).thenReturn(1L);

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getHorizontalHeader()).thenReturn(mock(HorizontalHeaderTable.class));
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> PDTrueTypeFont.load(doc, ttf, MacExpertEncoding.INSTANCE));
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(postScriptTable).getIsFixedPitch();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getName();
    verify(ttf).getOS2Windows();
    verify(ttf).getPostScript();
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code
   * ttf}, {@code encoding}.
   *
   * <p>Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding4() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
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

    CmapSubtable cmap = new CmapSubtable();
    cmap.setPlatformEncodingId(1);
    cmap.setPlatformId(1);

    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any()))
        .thenReturn(1);

    SubstitutingCmapLookup substitutingCmapLookup =
        new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getUnicodeCmapLookup()).thenReturn(substitutingCmapLookup);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getPath(Mockito.<String>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(FontName.TIMES_ROMAN, "Glyph Name"));
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    DictionaryEncoding encoding =
        new DictionaryEncoding(new COSDictionary(), true, MacExpertEncoding.INSTANCE);

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
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(1);
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
    assertSame(encoding, actualLoadResult.getEncoding());
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code
   * ttf}, {@code encoding}.
   *
   * <p>Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding5() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getTypoAscender()).thenThrow(new IllegalArgumentException());
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
    assertThrows(
        IllegalArgumentException.class,
        () -> PDTrueTypeFont.load(doc, ttf, MacExpertEncoding.INSTANCE));
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
    verify(ttf).getPath("H");
    verify(ttf).getPostScript();
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code
   * ttf}, {@code encoding}.
   *
   * <ul>
   *   <li>Given {@link OS2WindowsMetricsTable} {@link OS2WindowsMetricsTable#getVersion()} return
   *       minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName(
      "Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; given OS2WindowsMetricsTable getVersion() return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding_givenOS2WindowsMetricsTableGetVersionReturnMinusOne()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getTypoAscender()).thenReturn(3);
    when(os2WindowsMetricsTable.getTypoDescender()).thenReturn(3);
    when(os2WindowsMetricsTable.getFamilyClass()).thenReturn(1);
    when(os2WindowsMetricsTable.getFsSelection()).thenReturn(1);
    when(os2WindowsMetricsTable.getVersion()).thenReturn(-1);
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

    CmapSubtable cmap = new CmapSubtable();
    cmap.setPlatformEncodingId(1);
    cmap.setPlatformId(1);

    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any()))
        .thenReturn(1);

    SubstitutingCmapLookup substitutingCmapLookup =
        new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

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
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(1);
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
    assertEquals(1500.0f, fontDescriptor.getXHeight());
    float[][] values = actualLoadResult.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(6000.0f, fontDescriptor.getCapHeight());
    assertArrayEquals(new float[] {0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code
   * ttf}, {@code encoding}.
   *
   * <ul>
   *   <li>Given {@link PostScriptTable}.
   * </ul>
   *
   * <p>Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName(
      "Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; given PostScriptTable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding_givenPostScriptTable() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getHorizontalHeader()).thenThrow(new IOException());
    when(ttf.getPostScript()).thenReturn(mock(PostScriptTable.class));
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(mock(OS2WindowsMetricsTable.class));

    // Act and Assert
    assertThrows(
        IOException.class, () -> PDTrueTypeFont.load(doc, ttf, MacExpertEncoding.INSTANCE));
    verify(ttf).getHorizontalHeader();
    verify(ttf).getName();
    verify(ttf).getOS2Windows();
    verify(ttf).getPostScript();
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code
   * ttf}, {@code encoding}.
   *
   * <ul>
   *   <li>Then return Encoding is fromFontBox {@link StandardEncoding} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName(
      "Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; then return Encoding is fromFontBox StandardEncoding (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding_thenReturnEncodingIsFromFontBoxStandardEncoding()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
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

    CmapSubtable cmap = new CmapSubtable();
    cmap.setPlatformEncodingId(1);
    cmap.setPlatformId(1);

    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any()))
        .thenReturn(1);

    SubstitutingCmapLookup substitutingCmapLookup =
        new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getUnicodeCmapLookup()).thenReturn(substitutingCmapLookup);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getPath(Mockito.<String>any()))
        .thenReturn(Standard14Fonts.getGlyphPath(FontName.TIMES_ROMAN, "Glyph Name"));
    when(ttf.getOriginalData()).thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(ttf.getHeader()).thenReturn(headerTable);
    when(ttf.getHorizontalHeader()).thenReturn(horizontalHeaderTable);
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);
    Type1Encoding encoding = Type1Encoding.fromFontBox(new StandardEncoding());

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
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(1);
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
    assertEquals(1, actualLoadResult.getFontDescriptor().getFontFile2().getFilters().size());
    float[][] values = actualLoadResult.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertSame(encoding, actualLoadResult.getEncoding());
    assertArrayEquals(new float[] {0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code
   * ttf}, {@code encoding}.
   *
   * <ul>
   *   <li>Then return FontDescriptor CapHeight is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName(
      "Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; then return FontDescriptor CapHeight is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding_thenReturnFontDescriptorCapHeightIsZero() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
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

    CmapSubtable cmap = new CmapSubtable();
    cmap.setPlatformEncodingId(1);
    cmap.setPlatformId(1);

    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any()))
        .thenReturn(1);

    SubstitutingCmapLookup substitutingCmapLookup =
        new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getUnicodeCmapLookup()).thenReturn(substitutingCmapLookup);
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
    verify(gsub, atLeast(1)).getSubstitution(eq(0), Mockito.<String[]>any(), isA(List.class));
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(1);
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
    assertEquals(0.0f, fontDescriptor.getCapHeight());
    assertEquals(0.0f, fontDescriptor.getXHeight());
    assertEquals(1, fontDescriptor.getFontFile2().getFilters().size());
    float[][] values = actualLoadResult.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code
   * ttf}, {@code encoding}.
   *
   * <ul>
   *   <li>Then return FontDescriptor Flags is ninety-eight.
   * </ul>
   *
   * <p>Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName(
      "Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; then return FontDescriptor Flags is ninety-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding_thenReturnFontDescriptorFlagsIsNinetyEight() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
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

    CmapSubtable cmap = new CmapSubtable();
    cmap.setPlatformEncodingId(1);
    cmap.setPlatformId(1);

    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any()))
        .thenReturn(1);

    SubstitutingCmapLookup substitutingCmapLookup =
        new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

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
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(1);
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
    float[][] values = actualLoadResult.getFontMatrix().getValues();
    assertEquals(3, values.length);
    PDFontDescriptor fontDescriptor = actualLoadResult.getFontDescriptor();
    assertEquals(98, fontDescriptor.getFlags());
    assertFalse(fontDescriptor.isFixedPitch());
    assertArrayEquals(new float[] {0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code
   * ttf}, {@code encoding}.
   *
   * <ul>
   *   <li>Then return FontDescriptor Flags is ninety-seven.
   * </ul>
   *
   * <p>Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName(
      "Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; then return FontDescriptor Flags is ninety-seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding_thenReturnFontDescriptorFlagsIsNinetySeven() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
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

    CmapSubtable cmap = new CmapSubtable();
    cmap.setPlatformEncodingId(1);
    cmap.setPlatformId(1);

    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any()))
        .thenReturn(1);

    SubstitutingCmapLookup substitutingCmapLookup =
        new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

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
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(1);
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
    float[][] values = actualLoadResult.getFontMatrix().getValues();
    assertEquals(3, values.length);
    PDFontDescriptor fontDescriptor = actualLoadResult.getFontDescriptor();
    assertEquals(97, fontDescriptor.getFlags());
    assertFalse(fontDescriptor.isSerif());
    assertArrayEquals(new float[] {0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code
   * ttf}, {@code encoding}.
   *
   * <ul>
   *   <li>Then return FontDescriptor Flags is thirty-five.
   * </ul>
   *
   * <p>Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName(
      "Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; then return FontDescriptor Flags is thirty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding_thenReturnFontDescriptorFlagsIsThirtyFive() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
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

    CmapSubtable cmap = new CmapSubtable();
    cmap.setPlatformEncodingId(1);
    cmap.setPlatformId(1);

    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any()))
        .thenReturn(1);

    SubstitutingCmapLookup substitutingCmapLookup =
        new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

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
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(1);
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
    float[][] values = actualLoadResult.getFontMatrix().getValues();
    assertEquals(3, values.length);
    PDFontDescriptor fontDescriptor = actualLoadResult.getFontDescriptor();
    assertEquals(35, fontDescriptor.getFlags());
    assertFalse(fontDescriptor.isItalic());
    assertArrayEquals(new float[] {0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code
   * ttf}, {@code encoding}.
   *
   * <ul>
   *   <li>Then return FontDescriptor FontFile2 Length is eight.
   * </ul>
   *
   * <p>Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName(
      "Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; then return FontDescriptor FontFile2 Length is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding_thenReturnFontDescriptorFontFile2LengthIsEight()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
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

    CmapSubtable cmap = new CmapSubtable();
    cmap.setPlatformEncodingId(1);
    cmap.setPlatformId(1);

    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any()))
        .thenReturn(1);

    SubstitutingCmapLookup substitutingCmapLookup =
        new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getUnicodeCmapLookup()).thenReturn(substitutingCmapLookup);
    when(ttf.getHorizontalMetrics()).thenReturn(horizontalMetricsTable);
    when(ttf.getPath(Mockito.<String>any())).thenReturn(null);
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[] {});
    when(ttf.getOriginalData()).thenReturn(byteArrayInputStream);
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
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(1);
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
    float[][] values = actualLoadResult.getFontMatrix().getValues();
    assertEquals(3, values.length);
    PDStream fontFile2 = actualLoadResult.getFontDescriptor().getFontFile2();
    assertEquals(8, fontFile2.getLength());
    assertEquals(8L, fontFile2.getCOSObject().getLength());
    assertArrayEquals(new float[] {0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code
   * ttf}, {@code encoding}.
   *
   * <ul>
   *   <li>Then return FontDescriptor XHeight is {@code 1500.0}.
   * </ul>
   *
   * <p>Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName(
      "Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; then return FontDescriptor XHeight is '1500.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding_thenReturnFontDescriptorXHeightIs15000() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
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

    CmapSubtable cmap = new CmapSubtable();
    cmap.setPlatformEncodingId(1);
    cmap.setPlatformId(1);

    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any()))
        .thenReturn(1);

    SubstitutingCmapLookup substitutingCmapLookup =
        new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

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
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(1);
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
    assertEquals(1500.0f, fontDescriptor.getXHeight());
    float[][] values = actualLoadResult.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(6000.0f, fontDescriptor.getCapHeight());
    assertArrayEquals(new float[] {0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code
   * ttf}, {@code encoding}.
   *
   * <ul>
   *   <li>Then return Widths size is two hundred twenty.
   * </ul>
   *
   * <p>Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName(
      "Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; then return Widths size is two hundred twenty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding_thenReturnWidthsSizeIsTwoHundredTwenty() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
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

    CmapSubtable cmap = new CmapSubtable();
    cmap.setPlatformEncodingId(1);
    cmap.setPlatformId(1);

    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any()))
        .thenReturn(1);

    SubstitutingCmapLookup substitutingCmapLookup =
        new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(-1);

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getUnicodeCmapLookup()).thenReturn(substitutingCmapLookup);
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
    verify(gsub, atLeast(1)).getSubstitution(eq(0), Mockito.<String[]>any(), isA(List.class));
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(1);
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
    List<Float> widths = actualLoadResult.getWidths();
    assertEquals(220, widths.size());
    assertEquals(-1000.0f, widths.get(0).floatValue());
    assertEquals(-1000.0f, widths.get(1).floatValue());
    assertEquals(-1000.0f, widths.get(2).floatValue());
    assertEquals(-1000.0f, widths.get(217).floatValue());
    assertEquals(-1000.0f, widths.get(218).floatValue());
    assertEquals(-1000.0f, widths.get(219).floatValue());
    assertEquals(0.0f, actualLoadResult.getAverageFontWidth());
    float[][] values = actualLoadResult.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(Float.NaN, actualLoadResult.getSpaceWidth());
    assertArrayEquals(new float[] {0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code
   * ttf}, {@code encoding}.
   *
   * <ul>
   *   <li>Then return Widths size is two hundred twenty-four.
   * </ul>
   *
   * <p>Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName(
      "Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; then return Widths size is two hundred twenty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding_thenReturnWidthsSizeIsTwoHundredTwentyFour() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
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

    CmapSubtable cmap = new CmapSubtable();
    cmap.setPlatformEncodingId(1);
    cmap.setPlatformId(1);

    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any()))
        .thenReturn(1);

    SubstitutingCmapLookup substitutingCmapLookup =
        new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getUnicodeCmapLookup()).thenReturn(substitutingCmapLookup);
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
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, MacOSRomanEncoding.INSTANCE);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(1);
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
    List<Float> widths = actualLoadResult.getWidths();
    assertEquals(224, widths.size());
    assertEquals(1000.0f, widths.get(223).floatValue());
    assertSame(MacOSRomanEncoding.INSTANCE, actualLoadResult.getEncoding());
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code
   * ttf}, {@code encoding}.
   *
   * <ul>
   *   <li>When {@link SymbolEncoding#INSTANCE}.
   *   <li>Then return Encoding is {@link SymbolEncoding#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName(
      "Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; when INSTANCE; then return Encoding is INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding_whenInstance_thenReturnEncodingIsInstance() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
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

    CmapSubtable cmap = new CmapSubtable();
    cmap.setPlatformEncodingId(1);
    cmap.setPlatformId(1);

    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any()))
        .thenReturn(1);

    SubstitutingCmapLookup substitutingCmapLookup =
        new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getUnicodeCmapLookup()).thenReturn(substitutingCmapLookup);
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
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, SymbolEncoding.INSTANCE);

    // Assert
    verify(gsub, atLeast(1)).getSubstitution(eq(0), isA(String[].class), isA(List.class));
    verify(headerTable, atLeast(1)).getUnitsPerEm();
    verify(headerTable).getXMax();
    verify(headerTable).getXMin();
    verify(headerTable).getYMax();
    verify(headerTable).getYMin();
    verify(horizontalHeaderTable).getAscender();
    verify(horizontalHeaderTable).getDescender();
    verify(horizontalMetricsTable, atLeast(1)).getAdvanceWidth(1);
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
    assertSame(SymbolEncoding.INSTANCE, actualLoadResult.getEncoding());
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code
   * ttf}, {@code encoding}.
   *
   * <ul>
   *   <li>When {@link ZapfDingbatsEncoding#INSTANCE}.
   *   <li>Then return Encoding is {@link ZapfDingbatsEncoding#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName(
      "Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; when INSTANCE; then return Encoding is INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding_whenInstance_thenReturnEncodingIsInstance2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
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

    CmapSubtable cmap = new CmapSubtable();
    cmap.setPlatformEncodingId(1);
    cmap.setPlatformId(1);

    GlyphSubstitutionTable gsub = mock(GlyphSubstitutionTable.class);
    when(gsub.getSubstitution(anyInt(), Mockito.<String[]>any(), Mockito.<List<String>>any()))
        .thenReturn(1);

    SubstitutingCmapLookup substitutingCmapLookup =
        new SubstitutingCmapLookup(cmap, gsub, new ArrayList<>());

    HorizontalMetricsTable horizontalMetricsTable = mock(HorizontalMetricsTable.class);
    when(horizontalMetricsTable.getAdvanceWidth(anyInt())).thenReturn(1);

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getOriginalDataSize()).thenReturn(3L);
    when(ttf.getUnicodeCmapLookup()).thenReturn(substitutingCmapLookup);
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
    PDTrueTypeFont actualLoadResult = PDTrueTypeFont.load(doc, ttf, ZapfDingbatsEncoding.INSTANCE);

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
    assertSame(ZapfDingbatsEncoding.INSTANCE, actualLoadResult.getEncoding());
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code
   * ttf}, {@code encoding}.
   *
   * <ul>
   *   <li>When {@link TrueTypeFont} {@link TrueTypeFont#getName()} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName(
      "Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; when TrueTypeFont getName() throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding_whenTrueTypeFontGetNameThrowIOException() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getName()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(
        IOException.class, () -> PDTrueTypeFont.load(doc, ttf, MacExpertEncoding.INSTANCE));
    verify(ttf).getName();
  }

  /**
   * Test {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)} with {@code doc}, {@code
   * ttf}, {@code encoding}.
   *
   * <ul>
   *   <li>When {@link TrueTypeFont} {@link TrueTypeFont#getPostScript()} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTrueTypeFont#load(PDDocument, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName(
      "Test load(PDDocument, TrueTypeFont, Encoding) with 'doc', 'ttf', 'encoding'; when TrueTypeFont getPostScript() throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDTrueTypeFont PDTrueTypeFont.load(PDDocument, TrueTypeFont, Encoding)"})
  void testLoadWithDocTtfEncoding_whenTrueTypeFontGetPostScriptThrowIOException()
      throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getPostScript()).thenThrow(new IOException());
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(mock(OS2WindowsMetricsTable.class));

    // Act and Assert
    assertThrows(
        IOException.class, () -> PDTrueTypeFont.load(doc, ttf, MacExpertEncoding.INSTANCE));
    verify(ttf).getName();
    verify(ttf).getOS2Windows();
    verify(ttf).getPostScript();
  }
}
