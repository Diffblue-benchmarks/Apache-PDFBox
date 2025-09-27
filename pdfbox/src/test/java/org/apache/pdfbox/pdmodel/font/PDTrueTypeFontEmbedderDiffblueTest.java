package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.HeaderTable;
import org.apache.fontbox.ttf.HorizontalHeaderTable;
import org.apache.fontbox.ttf.HorizontalMetricsTable;
import org.apache.fontbox.ttf.OS2WindowsMetricsTable;
import org.apache.fontbox.ttf.PostScriptTable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.MacExpertEncoding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDTrueTypeFontEmbedderDiffblueTest {
  /**
   * Test {@link PDTrueTypeFontEmbedder#PDTrueTypeFontEmbedder(PDDocument, COSDictionary,
   * TrueTypeFont, Encoding)}.
   *
   * <p>Method under test: {@link PDTrueTypeFontEmbedder#PDTrueTypeFontEmbedder(PDDocument,
   * COSDictionary, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test new PDTrueTypeFontEmbedder(PDDocument, COSDictionary, TrueTypeFont, Encoding)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDTrueTypeFontEmbedder.<init>(PDDocument, COSDictionary, TrueTypeFont, Encoding)"
  })
  void testNewPDTrueTypeFontEmbedder() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    COSDictionary dict = new COSDictionary();

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getName()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PDTrueTypeFontEmbedder(document, dict, ttf, MacExpertEncoding.INSTANCE));
    verify(ttf).getName();
  }

  /**
   * Test {@link PDTrueTypeFontEmbedder#PDTrueTypeFontEmbedder(PDDocument, COSDictionary,
   * TrueTypeFont, Encoding)}.
   *
   * <p>Method under test: {@link PDTrueTypeFontEmbedder#PDTrueTypeFontEmbedder(PDDocument,
   * COSDictionary, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test new PDTrueTypeFontEmbedder(PDDocument, COSDictionary, TrueTypeFont, Encoding)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDTrueTypeFontEmbedder.<init>(PDDocument, COSDictionary, TrueTypeFont, Encoding)"
  })
  void testNewPDTrueTypeFontEmbedder2() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    COSDictionary dict = new COSDictionary();

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getPostScript()).thenThrow(new UnsupportedOperationException());
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(mock(OS2WindowsMetricsTable.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PDTrueTypeFontEmbedder(document, dict, ttf, MacExpertEncoding.INSTANCE));
    verify(ttf).getName();
    verify(ttf).getOS2Windows();
    verify(ttf).getPostScript();
  }

  /**
   * Test {@link PDTrueTypeFontEmbedder#PDTrueTypeFontEmbedder(PDDocument, COSDictionary,
   * TrueTypeFont, Encoding)}.
   *
   * <p>Method under test: {@link PDTrueTypeFontEmbedder#PDTrueTypeFontEmbedder(PDDocument,
   * COSDictionary, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test new PDTrueTypeFontEmbedder(PDDocument, COSDictionary, TrueTypeFont, Encoding)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDTrueTypeFontEmbedder.<init>(PDDocument, COSDictionary, TrueTypeFont, Encoding)"
  })
  void testNewPDTrueTypeFontEmbedder3() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    COSDictionary dict = new COSDictionary();

    PostScriptTable postScriptTable = mock(PostScriptTable.class);
    when(postScriptTable.getIsFixedPitch()).thenThrow(new UnsupportedOperationException());

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getHorizontalHeader()).thenReturn(mock(HorizontalHeaderTable.class));
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(mock(OS2WindowsMetricsTable.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PDTrueTypeFontEmbedder(document, dict, ttf, MacExpertEncoding.INSTANCE));
    verify(postScriptTable).getIsFixedPitch();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getName();
    verify(ttf).getOS2Windows();
    verify(ttf).getPostScript();
  }

  /**
   * Test {@link PDTrueTypeFontEmbedder#PDTrueTypeFontEmbedder(PDDocument, COSDictionary,
   * TrueTypeFont, Encoding)}.
   *
   * <p>Method under test: {@link PDTrueTypeFontEmbedder#PDTrueTypeFontEmbedder(PDDocument,
   * COSDictionary, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test new PDTrueTypeFontEmbedder(PDDocument, COSDictionary, TrueTypeFont, Encoding)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDTrueTypeFontEmbedder.<init>(PDDocument, COSDictionary, TrueTypeFont, Encoding)"
  })
  void testNewPDTrueTypeFontEmbedder4() throws IOException {
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
    PDTrueTypeFontEmbedder actualPdTrueTypeFontEmbedder =
        new PDTrueTypeFontEmbedder(document, dict, ttf, MacExpertEncoding.INSTANCE);

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
    PDFontDescriptor fontDescriptor = actualPdTrueTypeFontEmbedder.getFontDescriptor();
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
  }

  /**
   * Test {@link PDTrueTypeFontEmbedder#PDTrueTypeFontEmbedder(PDDocument, COSDictionary,
   * TrueTypeFont, Encoding)}.
   *
   * <p>Method under test: {@link PDTrueTypeFontEmbedder#PDTrueTypeFontEmbedder(PDDocument,
   * COSDictionary, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName("Test new PDTrueTypeFontEmbedder(PDDocument, COSDictionary, TrueTypeFont, Encoding)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDTrueTypeFontEmbedder.<init>(PDDocument, COSDictionary, TrueTypeFont, Encoding)"
  })
  void testNewPDTrueTypeFontEmbedder5() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    COSDictionary dict = new COSDictionary();

    OS2WindowsMetricsTable os2WindowsMetricsTable = mock(OS2WindowsMetricsTable.class);
    when(os2WindowsMetricsTable.getFsSelection()).thenThrow(new UnsupportedOperationException());

    PostScriptTable postScriptTable = mock(PostScriptTable.class);
    when(postScriptTable.getIsFixedPitch()).thenReturn(1L);

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getHorizontalHeader()).thenReturn(mock(HorizontalHeaderTable.class));
    when(ttf.getPostScript()).thenReturn(postScriptTable);
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(os2WindowsMetricsTable);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PDTrueTypeFontEmbedder(document, dict, ttf, MacExpertEncoding.INSTANCE));
    verify(os2WindowsMetricsTable).getFsSelection();
    verify(postScriptTable).getIsFixedPitch();
    verify(ttf).getHorizontalHeader();
    verify(ttf).getName();
    verify(ttf).getOS2Windows();
    verify(ttf).getPostScript();
  }

  /**
   * Test {@link PDTrueTypeFontEmbedder#PDTrueTypeFontEmbedder(PDDocument, COSDictionary,
   * TrueTypeFont, Encoding)}.
   *
   * <ul>
   *   <li>Given {@link PostScriptTable}.
   * </ul>
   *
   * <p>Method under test: {@link PDTrueTypeFontEmbedder#PDTrueTypeFontEmbedder(PDDocument,
   * COSDictionary, TrueTypeFont, Encoding)}
   */
  @Test
  @DisplayName(
      "Test new PDTrueTypeFontEmbedder(PDDocument, COSDictionary, TrueTypeFont, Encoding); given PostScriptTable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDTrueTypeFontEmbedder.<init>(PDDocument, COSDictionary, TrueTypeFont, Encoding)"
  })
  void testNewPDTrueTypeFontEmbedder_givenPostScriptTable() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    COSDictionary dict = new COSDictionary();

    TrueTypeFont ttf = mock(TrueTypeFont.class);
    when(ttf.getHorizontalHeader()).thenThrow(new UnsupportedOperationException());
    when(ttf.getPostScript()).thenReturn(mock(PostScriptTable.class));
    when(ttf.getName()).thenReturn("Name");
    when(ttf.getOS2Windows()).thenReturn(mock(OS2WindowsMetricsTable.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PDTrueTypeFontEmbedder(document, dict, ttf, MacExpertEncoding.INSTANCE));
    verify(ttf).getHorizontalHeader();
    verify(ttf).getName();
    verify(ttf).getOS2Windows();
    verify(ttf).getPostScript();
  }
}
