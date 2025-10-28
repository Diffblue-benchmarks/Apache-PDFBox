package org.apache.pdfbox.pdmodel;

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
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
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
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.encoding.MacExpertEncoding;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.blend.BlendMode;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDAbstractPattern;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDShadingPattern;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShading;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType1;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType2;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType3;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType4;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType5;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType6;
import org.apache.pdfbox.pdmodel.graphics.shading.PDShadingType7;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDResourcesDiffblueTest {
  /**
   * Method under test: {@link PDResources#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDResources()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDResources#getCOSObject()}
   */
  @Test
  void testGetCOSObject2() throws IOException {
    // Arrange
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
    PDTrueTypeFont font = PDTrueTypeFont.load(new PDDocument(), ttf, MacExpertEncoding.INSTANCE);

    PDResources pdResources = new PDResources();
    pdResources.add(font);

    // Act
    COSDictionary actualCOSObject = pdResources.getCOSObject();

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
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  void testGetFont() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDResources()).getFont(COSName.A));
    assertNull((new PDResources()).getFont(null));
  }

  /**
   * Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  void testGetFont2() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    // Act and Assert
    assertNull((new PDResources(resourceDictionary, new DefaultResourceCache())).getFont(COSName.A));
  }

  /**
   * Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  void testGetFont3() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act and Assert
    assertNull(pdResources.getFont(COSName.A));
  }

  /**
   * Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  void testGetFont4() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    PDMMType1Font font = new PDMMType1Font(new COSDictionary());
    pdResources.put(COSName.A, font);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    PDFont actualFont = pdResources.getFont(COSName.A);

    // Assert
    assertTrue(actualFont instanceof PDType1Font);
    assertEquals(font, actualFont);
  }

  /**
   * Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  void testGetFont5() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    PDMMType1Font font = new PDMMType1Font(new COSDictionary());
    pdResources.put(COSName.A, font);

    // Act
    PDFont actualFont = pdResources.getFont(COSName.A);

    // Assert
    assertTrue(actualFont instanceof PDType1Font);
    assertEquals(font, actualFont);
  }

  /**
   * Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  void testGetFont6() throws IOException {
    // Arrange
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
    PDTrueTypeFont font = PDTrueTypeFont.load(new PDDocument(), ttf, MacExpertEncoding.INSTANCE);

    PDResources pdResources = new PDResources();
    pdResources.add(font);

    // Act
    PDFont actualFont = pdResources.getFont(COSName.A);

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
    assertNull(actualFont);
  }

  /**
   * Method under test: {@link PDResources#getFont(COSName)}
   */
  @Test
  void testGetFont7() throws IOException {
    // Arrange
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
    PDTrueTypeFont font = PDTrueTypeFont.load(new PDDocument(), ttf, MacExpertEncoding.INSTANCE);

    PDResources pdResources = new PDResources();
    pdResources.add(font);

    // Act
    PDFont actualFont = pdResources.getFont(null);

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
    assertNull(actualFont);
  }

  /**
   * Method under test: {@link PDResources#getColorSpace(COSName)}
   */
  @Test
  void testGetColorSpace() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Method under test: {@link PDResources#getColorSpace(COSName)}
   */
  @Test
  void testGetColorSpace2() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    PDResources pdResources = new PDResources(resourceDictionary, new DefaultResourceCache());
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Method under test: {@link PDResources#getColorSpace(COSName)}
   */
  @Test
  void testGetColorSpace3() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(null, PDDeviceGray.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Method under test: {@link PDResources#getColorSpace(COSName)}
   */
  @Test
  void testGetColorSpace4() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, PDDeviceRGB.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A);

    // Assert
    assertSame(((PDDeviceRGB) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  void testGetColorSpace5() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A, true);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  void testGetColorSpace6() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    PDResources pdResources = new PDResources(resourceDictionary, new DefaultResourceCache());
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A, true);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  void testGetColorSpace7() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, PDDeviceRGB.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A, true);

    // Assert
    assertSame(((PDDeviceRGB) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Method under test: {@link PDResources#getColorSpace(COSName, boolean)}
   */
  @Test
  void testGetColorSpace8() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(null, PDDeviceGray.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = pdResources.getColorSpace(COSName.A, false);

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Method under test: {@link PDResources#hasColorSpace(COSName)}
   */
  @Test
  void testHasColorSpace() {
    // Arrange, Act and Assert
    assertFalse((new PDResources()).hasColorSpace(COSName.A));
  }

  /**
   * Method under test: {@link PDResources#hasColorSpace(COSName)}
   */
  @Test
  void testHasColorSpace2() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceGray.INSTANCE);

    // Act and Assert
    assertFalse(pdResources.hasColorSpace(COSName.A));
  }

  /**
   * Method under test: {@link PDResources#hasColorSpace(COSName)}
   */
  @Test
  void testHasColorSpace3() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);

    // Act and Assert
    assertTrue(pdResources.hasColorSpace(COSName.A));
  }

  /**
   * Method under test: {@link PDResources#hasColorSpace(COSName)}
   */
  @Test
  void testHasColorSpace4() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceGray.INSTANCE);

    // Act and Assert
    assertFalse(pdResources.hasColorSpace(null));
  }

  /**
   * Method under test: {@link PDResources#getExtGState(COSName)}
   */
  @Test
  void testGetExtGState() {
    // Arrange, Act and Assert
    assertNull((new PDResources()).getExtGState(COSName.A));
  }

  /**
   * Method under test: {@link PDResources#getExtGState(COSName)}
   */
  @Test
  void testGetExtGState2() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    // Act and Assert
    assertNull((new PDResources(resourceDictionary, new DefaultResourceCache())).getExtGState(COSName.A));
  }

  /**
   * Method under test: {@link PDResources#getExtGState(COSName)}
   */
  @Test
  void testGetExtGState3() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDExtendedGraphicsState());

    // Act and Assert
    assertNull(pdResources.getExtGState(COSName.A));
  }

  /**
   * Method under test: {@link PDResources#getExtGState(COSName)}
   */
  @Test
  void testGetExtGState4() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDExtendedGraphicsState());
    COSName name = COSName.A;

    // Act
    PDExtendedGraphicsState actualExtGState = pdResources.getExtGState(name);

    // Assert
    assertNull(actualExtGState.getFlatnessTolerance());
    assertNull(actualExtGState.getLineWidth());
    assertNull(actualExtGState.getMiterLimit());
    assertNull(actualExtGState.getNonStrokingAlphaConstant());
    assertNull(actualExtGState.getSmoothnessTolerance());
    assertNull(actualExtGState.getStrokingAlphaConstant());
    assertNull(actualExtGState.getOverprintMode());
    assertNull(actualExtGState.getTransfer());
    assertNull(actualExtGState.getTransfer2());
    COSDictionary cOSObject = actualExtGState.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualExtGState.getFontSetting());
    assertNull(actualExtGState.getLineDashPattern());
    BlendMode blendMode = actualExtGState.getBlendMode();
    assertNull(blendMode.getBlendFunction());
    assertNull(actualExtGState.getSoftMask());
    assertNull(actualExtGState.getRenderingIntent());
    assertEquals(-1, actualExtGState.getLineCapStyle());
    assertEquals(-1, actualExtGState.getLineJoinStyle());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualExtGState.getAlphaSourceFlag());
    assertFalse(actualExtGState.getAutomaticStrokeAdjustment());
    assertFalse(actualExtGState.getNonStrokingOverprintControl());
    assertFalse(actualExtGState.getStrokingOverprintControl());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(blendMode.isSeparableBlendMode());
    assertTrue(actualExtGState.getTextKnockoutFlag());
    COSName expectedCOSName = name.NORMAL;
    assertSame(expectedCOSName, blendMode.getCOSName());
  }

  /**
   * Method under test: {@link PDResources#getExtGState(COSName)}
   */
  @Test
  void testGetExtGState5() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDExtendedGraphicsState());

    // Act and Assert
    assertNull(pdResources.getExtGState(null));
  }

  /**
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  void testGetShading() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDResources()).getShading(COSName.A));
  }

  /**
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  void testGetShading2() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    // Act and Assert
    assertNull((new PDResources(resourceDictionary, new DefaultResourceCache())).getShading(COSName.A));
  }

  /**
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  void testGetShading3() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingType1(new COSDictionary()));

    // Act and Assert
    assertNull(pdResources.getShading(COSName.A));
  }

  /**
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  void testGetShading4() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingType1(new COSDictionary()));

    // Act and Assert
    assertNull(pdResources.getShading(null));
  }

  /**
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  void testGetShading5() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    PDShadingType1 shading = new PDShadingType1(shadingDictionary);
    shading.setShadingType(1);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);

    // Act
    PDShading actualShading = pdResources.getShading(COSName.A);

    // Assert
    assertTrue(actualShading instanceof PDShadingType1);
    assertEquals("Shading", actualShading.getType());
    assertNull(actualShading.getBackground());
    assertNull(((PDShadingType1) actualShading).getDomain());
    assertNull(actualShading.getBBox());
    assertNull(actualShading.getFunction());
    Matrix matrix = ((PDShadingType1) actualShading).getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(1, actualShading.getShadingType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertFalse(actualShading.getAntiAlias());
    assertSame(shadingDictionary, actualShading.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  void testGetShading6() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    PDShadingType1 shading = new PDShadingType1(shadingDictionary);
    shading.setShadingType(2);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);

    // Act
    PDShading actualShading = pdResources.getShading(COSName.A);

    // Assert
    assertTrue(actualShading instanceof PDShadingType2);
    assertEquals("Shading", actualShading.getType());
    assertNull(actualShading.getBackground());
    assertNull(((PDShadingType2) actualShading).getCoords());
    assertNull(((PDShadingType2) actualShading).getDomain());
    assertNull(((PDShadingType2) actualShading).getExtend());
    assertNull(actualShading.getBBox());
    assertNull(actualShading.getFunction());
    assertEquals(2, actualShading.getShadingType());
    assertFalse(actualShading.getAntiAlias());
    assertSame(shadingDictionary, actualShading.getCOSObject());
  }

  /**
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  void testGetShading7() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    PDShadingType1 shading = new PDShadingType1(shadingDictionary);
    shading.setShadingType(3);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);

    // Act
    PDShading actualShading = pdResources.getShading(COSName.A);

    // Assert
    assertTrue(actualShading instanceof PDShadingType3);
    assertEquals("Shading", actualShading.getType());
    assertNull(actualShading.getBackground());
    assertNull(((PDShadingType3) actualShading).getCoords());
    assertNull(((PDShadingType3) actualShading).getDomain());
    assertNull(((PDShadingType3) actualShading).getExtend());
    assertNull(actualShading.getBBox());
    assertNull(actualShading.getFunction());
    assertEquals(3, actualShading.getShadingType());
    assertFalse(actualShading.getAntiAlias());
    assertSame(shadingDictionary, actualShading.getCOSObject());
  }

  /**
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  void testGetShading8() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    PDShadingType1 shading = new PDShadingType1(shadingDictionary);
    shading.setShadingType(4);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);

    // Act
    PDShading actualShading = pdResources.getShading(COSName.A);

    // Assert
    assertTrue(actualShading instanceof PDShadingType4);
    assertEquals("Shading", actualShading.getType());
    assertNull(actualShading.getBackground());
    assertNull(actualShading.getBBox());
    assertNull(actualShading.getFunction());
    assertEquals(-1, ((PDShadingType4) actualShading).getBitsPerFlag());
    assertEquals(4, actualShading.getShadingType());
    assertFalse(actualShading.getAntiAlias());
    assertSame(shadingDictionary, actualShading.getCOSObject());
  }

  /**
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  void testGetShading9() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    PDShadingType1 shading = new PDShadingType1(shadingDictionary);
    shading.setShadingType(5);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);

    // Act
    PDShading actualShading = pdResources.getShading(COSName.A);

    // Assert
    assertTrue(actualShading instanceof PDShadingType5);
    assertEquals("Shading", actualShading.getType());
    assertNull(actualShading.getBackground());
    assertNull(actualShading.getBBox());
    assertNull(actualShading.getFunction());
    assertEquals(-1, ((PDShadingType5) actualShading).getVerticesPerRow());
    assertEquals(5, actualShading.getShadingType());
    assertFalse(actualShading.getAntiAlias());
    assertSame(shadingDictionary, actualShading.getCOSObject());
  }

  /**
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  void testGetShading10() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    PDShadingType1 shading = new PDShadingType1(shadingDictionary);
    shading.setShadingType(6);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);

    // Act
    PDShading actualShading = pdResources.getShading(COSName.A);

    // Assert
    assertTrue(actualShading instanceof PDShadingType6);
    assertEquals("Shading", actualShading.getType());
    assertNull(actualShading.getBackground());
    assertNull(actualShading.getBBox());
    assertNull(actualShading.getFunction());
    assertEquals(-1, ((PDShadingType6) actualShading).getBitsPerFlag());
    assertEquals(6, actualShading.getShadingType());
    assertFalse(actualShading.getAntiAlias());
    assertSame(shadingDictionary, actualShading.getCOSObject());
  }

  /**
   * Method under test: {@link PDResources#getShading(COSName)}
   */
  @Test
  void testGetShading11() throws IOException {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    PDShadingType1 shading = new PDShadingType1(shadingDictionary);
    shading.setShadingType(7);

    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, shading);

    // Act
    PDShading actualShading = pdResources.getShading(COSName.A);

    // Assert
    assertTrue(actualShading instanceof PDShadingType7);
    assertEquals("Shading", actualShading.getType());
    assertNull(actualShading.getBackground());
    assertNull(actualShading.getBBox());
    assertNull(actualShading.getFunction());
    assertEquals(-1, ((PDShadingType7) actualShading).getBitsPerFlag());
    assertEquals(7, actualShading.getShadingType());
    assertFalse(actualShading.getAntiAlias());
    assertSame(shadingDictionary, actualShading.getCOSObject());
  }

  /**
   * Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  void testGetPattern() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDResources()).getPattern(COSName.A));
  }

  /**
   * Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  void testGetPattern2() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    // Act and Assert
    assertNull((new PDResources(resourceDictionary, new DefaultResourceCache())).getPattern(COSName.A));
  }

  /**
   * Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  void testGetPattern3() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingPattern());

    // Act and Assert
    assertNull(pdResources.getPattern(COSName.A));
  }

  /**
   * Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  void testGetPattern4() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDShadingPattern());

    // Act
    PDAbstractPattern actualPattern = pdResources.getPattern(COSName.A);

    // Assert
    assertTrue(actualPattern instanceof PDShadingPattern);
    assertEquals("Pattern", actualPattern.getType());
    COSDictionary cOSObject = actualPattern.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDShadingPattern) actualPattern).getShading());
    assertNull(((PDShadingPattern) actualPattern).getExtendedGraphicsState());
    Matrix matrix = actualPattern.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(2, actualPattern.getPatternType());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  void testGetPattern5() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingPattern());

    // Act and Assert
    assertNull(pdResources.getPattern(null));
  }

  /**
   * Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  void testGetPattern6() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.put(COSName.A, new PDTilingPattern());

    // Act
    PDAbstractPattern actualPattern = pdResources.getPattern(COSName.A);

    // Assert
    PDResources resources = ((PDTilingPattern) actualPattern).getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSDictionary cOSObject = actualPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertTrue(actualPattern instanceof PDTilingPattern);
    assertEquals("Pattern", actualPattern.getType());
    PDStream contentStream = ((PDTilingPattern) actualPattern).getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(((COSStream) cOSObject).getFilters());
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSUpdateState updateState2 = cOSObject.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(resources.getResourceCache());
    assertNull(contentStream.getMetadata());
    assertNull(((PDTilingPattern) actualPattern).getBBox());
    assertNull(contentStream.getFile());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(0, cOSObject2.size());
    assertEquals(0, contentStream.getLength());
    assertEquals(0, ((PDTilingPattern) actualPattern).getPaintType());
    assertEquals(0, ((PDTilingPattern) actualPattern).getTilingType());
    assertEquals(0.0f, ((PDTilingPattern) actualPattern).getXStep());
    assertEquals(0.0f, ((PDTilingPattern) actualPattern).getYStep());
    Matrix matrix = actualPattern.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(0L, ((COSStream) cOSObject).getLength());
    assertEquals(1, actualPattern.getPatternType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSStream) cOSObject).hasData());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertTrue(cOSObject2.getValues().isEmpty());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDResources#getPattern(COSName)}
   */
  @Test
  void testGetPattern7() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();
    resourceDictionary.setKey(new COSObjectKey(1L, 1));

    PDShadingPattern pattern = new PDShadingPattern(resourceDictionary);
    pattern.setPatternType(1);
    COSDictionary resourceDictionary2 = new COSDictionary();

    PDResources pdResources = new PDResources(resourceDictionary2, new DefaultResourceCache());
    pdResources.put(COSName.A, pattern);

    // Act
    PDAbstractPattern actualPattern = pdResources.getPattern(COSName.A);

    // Assert
    assertTrue(actualPattern instanceof PDTilingPattern);
    assertEquals("Pattern", actualPattern.getType());
    assertNull(((PDTilingPattern) actualPattern).getContents());
    assertNull(((PDTilingPattern) actualPattern).getContentsForStreamParsing());
    assertNull(((PDTilingPattern) actualPattern).getContentsForRandomAccess());
    assertNull(((PDTilingPattern) actualPattern).getResources());
    assertNull(((PDTilingPattern) actualPattern).getBBox());
    assertEquals(0, ((PDTilingPattern) actualPattern).getPaintType());
    assertEquals(0, ((PDTilingPattern) actualPattern).getTilingType());
    assertEquals(0.0f, ((PDTilingPattern) actualPattern).getXStep());
    assertEquals(0.0f, ((PDTilingPattern) actualPattern).getYStep());
    Matrix matrix = actualPattern.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(1, actualPattern.getPatternType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertSame(resourceDictionary, actualPattern.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDResources#getProperties(COSName)}
   */
  @Test
  void testGetProperties() {
    // Arrange
    PDResources pdResources = new PDResources();
    COSDictionary dict = new COSDictionary();
    pdResources.put(COSName.A, PDPropertyList.create(dict));

    // Act and Assert
    assertSame(dict, pdResources.getProperties(COSName.A).getCOSObject());
  }

  /**
   * Method under test: {@link PDResources#isImageXObject(COSName)}
   */
  @Test
  void testIsImageXObject() {
    // Arrange, Act and Assert
    assertFalse((new PDResources()).isImageXObject(COSName.A));
  }

  /**
   * Method under test: {@link PDResources#isImageXObject(COSName)}
   */
  @Test
  void testIsImageXObject2() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Act and Assert
    assertFalse(pdResources.isImageXObject(COSName.A));
  }

  /**
   * Method under test: {@link PDResources#isImageXObject(COSName)}
   */
  @Test
  void testIsImageXObject3() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Act and Assert
    assertFalse(pdResources.isImageXObject(null));
  }

  /**
   * Method under test: {@link PDResources#getXObject(COSName)}
   */
  @Test
  void testGetXObject() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDResources()).getXObject(COSName.A));
  }

  /**
   * Method under test: {@link PDResources#getXObject(COSName)}
   */
  @Test
  void testGetXObject2() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    // Act and Assert
    assertNull((new PDResources(resourceDictionary, new DefaultResourceCache())).getXObject(COSName.A));
  }

  /**
   * Method under test: {@link PDResources#getXObject(COSName)}
   */
  @Test
  void testGetXObject3() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Act and Assert
    assertNull(pdResources.getXObject(COSName.A));
  }

  /**
   * Method under test: {@link PDResources#getXObject(COSName)}
   */
  @Test
  void testGetXObject4() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Act and Assert
    assertNull(pdResources.getXObject(null));
  }

  /**
   * Method under test: {@link PDResources#getColorSpaceNames()}
   */
  @Test
  void testGetColorSpaceNames() {
    // Arrange and Act
    Iterable<COSName> actualColorSpaceNames = (new PDResources()).getColorSpaceNames();

    // Assert
    assertTrue(actualColorSpaceNames instanceof Set);
    assertFalse(actualColorSpaceNames.iterator().hasNext());
    assertTrue(((Set<COSName>) actualColorSpaceNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#getColorSpaceNames()}
   */
  @Test
  void testGetColorSpaceNames2() throws IOException {
    // Arrange
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
    PDTrueTypeFont font = PDTrueTypeFont.load(new PDDocument(), ttf, MacExpertEncoding.INSTANCE);

    PDResources pdResources = new PDResources();
    pdResources.add(font);

    // Act
    Iterable<COSName> actualColorSpaceNames = pdResources.getColorSpaceNames();
    Iterator<COSName> actualIteratorResult = actualColorSpaceNames.iterator();

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
    assertTrue(actualColorSpaceNames instanceof Set);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((Set<COSName>) actualColorSpaceNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#getXObjectNames()}
   */
  @Test
  void testGetXObjectNames() {
    // Arrange and Act
    Iterable<COSName> actualXObjectNames = (new PDResources()).getXObjectNames();

    // Assert
    assertTrue(actualXObjectNames instanceof Set);
    assertFalse(actualXObjectNames.iterator().hasNext());
    assertTrue(((Set<COSName>) actualXObjectNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#getXObjectNames()}
   */
  @Test
  void testGetXObjectNames2() throws IOException {
    // Arrange
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
    PDTrueTypeFont font = PDTrueTypeFont.load(new PDDocument(), ttf, MacExpertEncoding.INSTANCE);

    PDResources pdResources = new PDResources();
    pdResources.add(font);

    // Act
    Iterable<COSName> actualXObjectNames = pdResources.getXObjectNames();
    Iterator<COSName> actualIteratorResult = actualXObjectNames.iterator();

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
    assertTrue(actualXObjectNames instanceof Set);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((Set<COSName>) actualXObjectNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#getFontNames()}
   */
  @Test
  void testGetFontNames() {
    // Arrange and Act
    Iterable<COSName> actualFontNames = (new PDResources()).getFontNames();

    // Assert
    assertTrue(actualFontNames instanceof Set);
    assertFalse(actualFontNames.iterator().hasNext());
    assertTrue(((Set<COSName>) actualFontNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#getPropertiesNames()}
   */
  @Test
  void testGetPropertiesNames() {
    // Arrange and Act
    Iterable<COSName> actualPropertiesNames = (new PDResources()).getPropertiesNames();

    // Assert
    assertTrue(actualPropertiesNames instanceof Set);
    assertFalse(actualPropertiesNames.iterator().hasNext());
    assertTrue(((Set<COSName>) actualPropertiesNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#getPropertiesNames()}
   */
  @Test
  void testGetPropertiesNames2() throws IOException {
    // Arrange
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
    PDTrueTypeFont font = PDTrueTypeFont.load(new PDDocument(), ttf, MacExpertEncoding.INSTANCE);

    PDResources pdResources = new PDResources();
    pdResources.add(font);

    // Act
    Iterable<COSName> actualPropertiesNames = pdResources.getPropertiesNames();
    Iterator<COSName> actualIteratorResult = actualPropertiesNames.iterator();

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
    assertTrue(actualPropertiesNames instanceof Set);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((Set<COSName>) actualPropertiesNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#getShadingNames()}
   */
  @Test
  void testGetShadingNames() {
    // Arrange and Act
    Iterable<COSName> actualShadingNames = (new PDResources()).getShadingNames();

    // Assert
    assertTrue(actualShadingNames instanceof Set);
    assertFalse(actualShadingNames.iterator().hasNext());
    assertTrue(((Set<COSName>) actualShadingNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#getShadingNames()}
   */
  @Test
  void testGetShadingNames2() throws IOException {
    // Arrange
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
    PDTrueTypeFont font = PDTrueTypeFont.load(new PDDocument(), ttf, MacExpertEncoding.INSTANCE);

    PDResources pdResources = new PDResources();
    pdResources.add(font);

    // Act
    Iterable<COSName> actualShadingNames = pdResources.getShadingNames();
    Iterator<COSName> actualIteratorResult = actualShadingNames.iterator();

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
    assertTrue(actualShadingNames instanceof Set);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((Set<COSName>) actualShadingNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#getPatternNames()}
   */
  @Test
  void testGetPatternNames() {
    // Arrange and Act
    Iterable<COSName> actualPatternNames = (new PDResources()).getPatternNames();

    // Assert
    assertTrue(actualPatternNames instanceof Set);
    assertFalse(actualPatternNames.iterator().hasNext());
    assertTrue(((Set<COSName>) actualPatternNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#getPatternNames()}
   */
  @Test
  void testGetPatternNames2() throws IOException {
    // Arrange
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
    PDTrueTypeFont font = PDTrueTypeFont.load(new PDDocument(), ttf, MacExpertEncoding.INSTANCE);

    PDResources pdResources = new PDResources();
    pdResources.add(font);

    // Act
    Iterable<COSName> actualPatternNames = pdResources.getPatternNames();
    Iterator<COSName> actualIteratorResult = actualPatternNames.iterator();

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
    assertTrue(actualPatternNames instanceof Set);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((Set<COSName>) actualPatternNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#getExtGStateNames()}
   */
  @Test
  void testGetExtGStateNames() {
    // Arrange and Act
    Iterable<COSName> actualExtGStateNames = (new PDResources()).getExtGStateNames();

    // Assert
    assertTrue(actualExtGStateNames instanceof Set);
    assertFalse(actualExtGStateNames.iterator().hasNext());
    assertTrue(((Set<COSName>) actualExtGStateNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#getExtGStateNames()}
   */
  @Test
  void testGetExtGStateNames2() throws IOException {
    // Arrange
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
    PDTrueTypeFont font = PDTrueTypeFont.load(new PDDocument(), ttf, MacExpertEncoding.INSTANCE);

    PDResources pdResources = new PDResources();
    pdResources.add(font);

    // Act
    Iterable<COSName> actualExtGStateNames = pdResources.getExtGStateNames();
    Iterator<COSName> actualIteratorResult = actualExtGStateNames.iterator();

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
    assertTrue(actualExtGStateNames instanceof Set);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((Set<COSName>) actualExtGStateNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  void testAdd() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add(PDPropertyList.create(new COSDictionary()));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals("Prop1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  void testAdd2() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();
    PDResources pdResources = new PDResources(resourceDictionary);

    // Act
    COSName actualAddResult = pdResources.add(PDPropertyList.create(new COSDictionary()));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals("Prop1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
    assertSame(resourceDictionary, pdResources.getCOSObject());
  }

  /**
   * Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  void testAdd3() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDPropertyList.create(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(PDPropertyList.create(new COSDictionary()));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals("Prop2", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) propertiesNames).size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  void testAdd4() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add(new PDOptionalContentGroup("Prop"));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals("oc1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  void testAdd5() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add((PDPropertyList) null);

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals("Prop1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
    assertTrue(((Set<COSName>) propertiesNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  void testAdd6() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    COSName actualAddResult = pdResources.add(PDPropertyList.create(dict));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals("Prop1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDPropertyList)}
   */
  @Test
  void testAdd7() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    COSName actualAddResult = pdResources.add(PDPropertyList.create(dict));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    assertEquals("Prop1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  void testAdd8() {
    // Arrange
    PDResources pdResources = new PDResources();
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(new COSStream());

    // Act
    COSName actualAddResult = pdResources.add(xobject, "Prefix");

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Prefix1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  void testAdd9() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(new COSStream());

    // Act
    COSName actualAddResult = pdResources.add(xobject, "Prefix");

    // Assert
    verify(xobject, atLeast(1)).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Prefix2", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) xObjectNames).size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  void testAdd10() {
    // Arrange
    PDResources pdResources = new PDResources();
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(null);

    // Act
    COSName actualAddResult = pdResources.add(xobject, "Prefix");

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Prefix1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
    assertTrue(((Set<COSName>) xObjectNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  void testAdd11() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSStream cosStream = new COSStream();
    cosStream.setDirect(true);
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);

    // Act
    COSName actualAddResult = pdResources.add(xobject, "Prefix");

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Prefix1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  void testAdd12() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSStream cosStream = new COSStream();
    cosStream.setKey(new COSObjectKey(1L, 1));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);

    // Act
    COSName actualAddResult = pdResources.add(xobject, "Prefix");

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Prefix1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  void testAdd13() {
    // Arrange
    PDResources pdResources = new PDResources();
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdResources.add(xobject, "Prefix"));
    verify(xobject).getCOSObject();
  }

  /**
   * Method under test: {@link PDResources#add(PDXObject, String)}
   */
  @Test
  void testAdd14() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdResources.add(xobject, "Prefix"));
    verify(xobject).getCOSObject();
  }

  /**
   * Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  void testAdd15() {
    // Arrange
    PDResources pdResources = new PDResources();
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    COSName actualAddResult = pdResources.add(colorSpace);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertEquals("cs1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject2 = pdResources.getCOSObject();
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, ((Set<COSName>) colorSpaceNames).size());
    assertEquals(1, cOSObject2.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
    assertTrue(cOSObject2.toIncrement().getObjects().isEmpty());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(actualAddResult.DEVICEGRAY, cOSObject);
    assertSame(extGStateNames, pdResources.getFontNames());
    assertSame(extGStateNames, pdResources.getPatternNames());
    assertSame(extGStateNames, pdResources.getPropertiesNames());
    assertSame(extGStateNames, pdResources.getShadingNames());
    assertSame(extGStateNames, pdResources.getXObjectNames());
  }

  /**
   * Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  void testAdd16() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceGray.INSTANCE);
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    COSName actualAddResult = pdResources.add(colorSpace);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertEquals("cs1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject2 = pdResources.getCOSObject();
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, ((Set<COSName>) colorSpaceNames).size());
    assertEquals(1, cOSObject2.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
    assertTrue(cOSObject2.toIncrement().getObjects().isEmpty());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(actualAddResult.DEVICEGRAY, cOSObject);
    assertSame(extGStateNames, pdResources.getFontNames());
    assertSame(extGStateNames, pdResources.getPatternNames());
    assertSame(extGStateNames, pdResources.getPropertiesNames());
    assertSame(extGStateNames, pdResources.getShadingNames());
    assertSame(extGStateNames, pdResources.getXObjectNames());
  }

  /**
   * Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  void testAdd17() {
    // Arrange
    PDResources pdResources = new PDResources();
    PDCalGray colorSpace = new PDCalGray();

    // Act
    COSName actualAddResult = pdResources.add(colorSpace);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    assertEquals("cs1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject2 = pdResources.getCOSObject();
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, ((Set<COSName>) colorSpaceNames).size());
    assertEquals(1, cOSObject2.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
    assertTrue(cOSObject2.toIncrement().getObjects().isEmpty());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(actualAddResult.CALGRAY, getResult);
    assertSame(extGStateNames, pdResources.getFontNames());
    assertSame(extGStateNames, pdResources.getPatternNames());
    assertSame(extGStateNames, pdResources.getPropertiesNames());
    assertSame(extGStateNames, pdResources.getShadingNames());
    assertSame(extGStateNames, pdResources.getXObjectNames());
  }

  /**
   * Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  void testAdd18() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add((PDColorSpace) null);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals("cs1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
    assertTrue(cOSObject.toIncrement().getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(extGStateNames, pdResources.getFontNames());
    assertSame(extGStateNames, pdResources.getPatternNames());
    assertSame(extGStateNames, pdResources.getPropertiesNames());
    assertSame(extGStateNames, pdResources.getShadingNames());
    assertSame(extGStateNames, pdResources.getXObjectNames());
  }

  /**
   * Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  void testAdd19() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceRGB.INSTANCE);
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    COSName actualAddResult = pdResources.add(colorSpace);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertEquals("cs2", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject2 = pdResources.getCOSObject();
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, cOSObject2.size());
    assertEquals(2, ((Set<COSName>) colorSpaceNames).size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
    assertTrue(cOSObject2.toIncrement().getObjects().isEmpty());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(actualAddResult.DEVICEGRAY, cOSObject);
    assertSame(extGStateNames, pdResources.getFontNames());
    assertSame(extGStateNames, pdResources.getPatternNames());
    assertSame(extGStateNames, pdResources.getPropertiesNames());
    assertSame(extGStateNames, pdResources.getShadingNames());
    assertSame(extGStateNames, pdResources.getXObjectNames());
  }

  /**
   * Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  void testAdd20() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDCalGray());
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    COSName actualAddResult = pdResources.add(colorSpace);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertEquals("cs2", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject2 = pdResources.getCOSObject();
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, cOSObject2.size());
    assertEquals(2, ((Set<COSName>) colorSpaceNames).size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
    assertTrue(cOSObject2.toIncrement().getObjects().isEmpty());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(actualAddResult.DEVICEGRAY, cOSObject);
    assertSame(extGStateNames, pdResources.getFontNames());
    assertSame(extGStateNames, pdResources.getPatternNames());
    assertSame(extGStateNames, pdResources.getPropertiesNames());
    assertSame(extGStateNames, pdResources.getShadingNames());
    assertSame(extGStateNames, pdResources.getXObjectNames());
  }

  /**
   * Method under test: {@link PDResources#add(PDColorSpace)}
   */
  @Test
  void testAdd21() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceGray.INSTANCE);
    PDCalGray colorSpace = new PDCalGray();

    // Act
    COSName actualAddResult = pdResources.add(colorSpace);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    assertEquals("cs2", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject2 = pdResources.getCOSObject();
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, cOSObject2.size());
    assertEquals(2, ((Set<COSName>) colorSpaceNames).size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
    assertTrue(cOSObject2.toIncrement().getObjects().isEmpty());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(actualAddResult.CALGRAY, getResult);
    assertSame(extGStateNames, pdResources.getFontNames());
    assertSame(extGStateNames, pdResources.getPatternNames());
    assertSame(extGStateNames, pdResources.getPropertiesNames());
    assertSame(extGStateNames, pdResources.getShadingNames());
    assertSame(extGStateNames, pdResources.getXObjectNames());
  }

  /**
   * Method under test: {@link PDResources#add(PDFormXObject)}
   */
  @Test
  void testAdd22() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add(new PDFormXObject(new COSStream()));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Form1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDFormXObject)}
   */
  @Test
  void testAdd23() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Act
    COSName actualAddResult = pdResources.add(new PDFormXObject(new COSStream()));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Form2", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) xObjectNames).size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDFormXObject)}
   */
  @Test
  void testAdd24() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add((PDFormXObject) null);

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Form1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
    assertTrue(((Set<COSName>) xObjectNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDFormXObject)}
   */
  @Test
  void testAdd25() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSStream stream = new COSStream();
    stream.setDirect(true);

    // Act
    COSName actualAddResult = pdResources.add(new PDFormXObject(stream));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Form1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDFormXObject)}
   */
  @Test
  void testAdd26() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSStream stream = new COSStream();
    stream.setKey(new COSObjectKey(1L, 1));

    // Act
    COSName actualAddResult = pdResources.add(new PDFormXObject(stream));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Form1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDImageXObject)}
   */
  @Test
  void testAdd27() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Im1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDImageXObject)}
   */
  @Test
  void testAdd28() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Act
    COSName actualAddResult = pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Im2", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) xObjectNames).size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDImageXObject)}
   */
  @Test
  void testAdd29() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add((PDImageXObject) null);

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Im1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
    assertTrue(((Set<COSName>) xObjectNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDImageXObject)}
   */
  @Test
  void testAdd30() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSStream cosStream = new COSStream();
    cosStream.setDirect(true);

    // Act
    COSName actualAddResult = pdResources.add(PDImageXObject.createThumbnail(cosStream));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Im1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDImageXObject)}
   */
  @Test
  void testAdd31() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSStream cosStream = new COSStream();
    cosStream.setKey(new COSObjectKey(1L, 1));

    // Act
    COSName actualAddResult = pdResources.add(PDImageXObject.createThumbnail(cosStream));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Im1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDImageXObject)}
   */
  @Test
  void testAdd32() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Act
    COSName actualAddResult = pdResources.add(PDImageXObject.createThumbnail(new COSStream()));

    // Assert
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("Im4", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(4, ((Set<COSName>) xObjectNames).size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDAbstractPattern)}
   */
  @Test
  void testAdd33() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingPattern());

    // Assert
    Iterable<COSName> patternNames = pdResources.getPatternNames();
    assertTrue(patternNames instanceof Set);
    assertEquals("p1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) patternNames).size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDAbstractPattern)}
   */
  @Test
  void testAdd34() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingPattern());

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingPattern());

    // Assert
    Iterable<COSName> patternNames = pdResources.getPatternNames();
    assertTrue(patternNames instanceof Set);
    assertEquals("p2", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) patternNames).size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDAbstractPattern)}
   */
  @Test
  void testAdd35() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingPattern());
    pdResources.add(new PDShadingPattern());

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingPattern());

    // Assert
    Iterable<COSName> patternNames = pdResources.getPatternNames();
    assertTrue(patternNames instanceof Set);
    assertEquals("p3", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(3, ((Set<COSName>) patternNames).size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDAbstractPattern)}
   */
  @Test
  void testAdd36() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add((PDAbstractPattern) null);

    // Assert
    Iterable<COSName> patternNames = pdResources.getPatternNames();
    assertTrue(patternNames instanceof Set);
    assertEquals("p1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
    assertTrue(((Set<COSName>) patternNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  void testAdd37() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingType1(new COSDictionary()));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    assertEquals("sh1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) shadingNames).size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  void testAdd38() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingType1(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingType1(new COSDictionary()));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    assertEquals("sh2", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) shadingNames).size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  void testAdd39() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingType1(new COSDictionary()));
    pdResources.add(new PDShadingType1(new COSDictionary()));

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingType1(new COSDictionary()));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    assertEquals("sh3", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(3, ((Set<COSName>) shadingNames).size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  void testAdd40() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingType1(null));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    assertEquals("sh1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
    assertTrue(((Set<COSName>) shadingNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  void testAdd41() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add((PDShading) null);

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    assertEquals("sh1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
    assertTrue(((Set<COSName>) shadingNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  void testAdd42() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary shadingDictionary = new COSDictionary();
    shadingDictionary.setDirect(true);

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingType1(shadingDictionary));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    assertEquals("sh1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) shadingNames).size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDShading)}
   */
  @Test
  void testAdd43() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary shadingDictionary = new COSDictionary();
    shadingDictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    COSName actualAddResult = pdResources.add(new PDShadingType1(shadingDictionary));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    assertEquals("sh1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) shadingNames).size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
  }

  /**
   * Method under test: {@link PDResources#add(PDExtendedGraphicsState)}
   */
  @Test
  void testAdd44() {
    // Arrange
    PDResources pdResources = new PDResources();
    PDExtendedGraphicsState extGState = new PDExtendedGraphicsState();

    // Act
    COSName actualAddResult = pdResources.add(extGState);

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals("gs1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) extGStateNames).size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
    COSName expectedCOSName = actualAddResult.NORMAL;
    assertSame(expectedCOSName, extGState.getBlendMode().getCOSName());
  }

  /**
   * Method under test: {@link PDResources#add(PDExtendedGraphicsState)}
   */
  @Test
  void testAdd45() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDExtendedGraphicsState());
    PDExtendedGraphicsState extGState = new PDExtendedGraphicsState();

    // Act
    COSName actualAddResult = pdResources.add(extGState);

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals("gs2", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) extGStateNames).size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
    COSName expectedCOSName = actualAddResult.NORMAL;
    assertSame(expectedCOSName, extGState.getBlendMode().getCOSName());
  }

  /**
   * Method under test: {@link PDResources#add(PDExtendedGraphicsState)}
   */
  @Test
  void testAdd46() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDExtendedGraphicsState());
    pdResources.add(new PDExtendedGraphicsState());
    PDExtendedGraphicsState extGState = new PDExtendedGraphicsState();

    // Act
    COSName actualAddResult = pdResources.add(extGState);

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals("gs3", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(3, ((Set<COSName>) extGStateNames).size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
    COSName expectedCOSName = actualAddResult.NORMAL;
    assertSame(expectedCOSName, extGState.getBlendMode().getCOSName());
  }

  /**
   * Method under test: {@link PDResources#add(PDExtendedGraphicsState)}
   */
  @Test
  void testAdd47() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    COSName actualAddResult = pdResources.add((PDExtendedGraphicsState) null);

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals("gs1", actualAddResult.getName());
    assertNull(actualAddResult.getKey());
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(actualAddResult.isDirect());
    assertFalse(actualAddResult.isEmpty());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  void testPut() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, PDPropertyList.create(new COSDictionary()));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  void testPut2() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDPropertyList.create(new COSDictionary()));

    // Act
    pdResources.put(COSName.A, PDPropertyList.create(new COSDictionary()));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) propertiesNames).size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  void testPut3() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, PDPropertyList.create(new COSDictionary()));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  void testPut4() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, (PDPropertyList) null);

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(((Set<COSName>) propertiesNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  void testPut5() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, (PDPropertyList) null);

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(((Set<COSName>) propertiesNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  void testPut6() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    pdResources.put(COSName.A, PDPropertyList.create(dict));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  void testPut7() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdResources.put(COSName.A, PDPropertyList.create(dict));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDPropertyList)}
   */
  @Test
  void testPut8() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdResources.put(null, PDPropertyList.create(dict));

    // Assert
    Iterable<COSName> propertiesNames = pdResources.getPropertiesNames();
    assertTrue(propertiesNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) propertiesNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  void testPut9() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, new PDMMType1Font(new COSDictionary()));

    // Assert
    Iterable<COSName> fontNames = pdResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  void testPut10() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    pdResources.put(COSName.A, new PDMMType1Font(new COSDictionary()));

    // Assert
    Iterable<COSName> fontNames = pdResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) fontNames).size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  void testPut11() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, new PDMMType1Font(new COSDictionary()));

    // Assert
    Iterable<COSName> fontNames = pdResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  void testPut12() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, (PDFont) null);

    // Assert
    Iterable<COSName> fontNames = pdResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(((Set<COSName>) fontNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDFont)}
   */
  @Test
  void testPut13() throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
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
    pdResources.put(COSName.A, PDTrueTypeFont.load(new PDDocument(), ttf, MacExpertEncoding.INSTANCE));

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
    Iterable<COSName> fontNames = pdResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  void testPut14() {
    // Arrange
    PDResources pdResources = new PDResources();
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(new COSStream());

    // Act
    pdResources.put(COSName.A, xobject);

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  void testPut15() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDImageXObject.createThumbnail(new COSStream()));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(new COSStream());

    // Act
    pdResources.put(COSName.A, xobject);

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) xObjectNames).size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  void testPut16() {
    // Arrange
    PDResources pdResources = new PDResources();
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(new COSStream());

    // Act
    pdResources.put(null, xobject);

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  void testPut17() {
    // Arrange
    PDResources pdResources = new PDResources();
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(null);

    // Act
    pdResources.put(COSName.A, xobject);

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(((Set<COSName>) xObjectNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  void testPut18() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSStream cosStream = new COSStream();
    cosStream.setDirect(true);
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);

    // Act
    pdResources.put(COSName.A, xobject);

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  void testPut19() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSStream cosStream = new COSStream();
    cosStream.setKey(new COSObjectKey(1L, 1));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);

    // Act
    pdResources.put(COSName.A, xobject);

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  void testPut20() {
    // Arrange
    PDResources pdResources = new PDResources();
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdResources.put(COSName.A, xobject));
    verify(xobject).getCOSObject();
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  void testPut21() {
    // Arrange
    PDResources pdResources = new PDResources();
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(null);

    // Act
    pdResources.put(null, xobject);

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(((Set<COSName>) xObjectNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDXObject)}
   */
  @Test
  void testPut22() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSStream cosStream = new COSStream();
    cosStream.setKey(new COSObjectKey(1L, 1));
    PDXObject xobject = mock(PDXObject.class);
    when(xobject.getCOSObject()).thenReturn(cosStream);

    // Act
    pdResources.put(null, xobject);

    // Assert
    verify(xobject).getCOSObject();
    Iterable<COSName> xObjectNames = pdResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDColorSpace)}
   */
  @Test
  void testPut23() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) colorSpaceNames).size());
    assertEquals(1, cOSObject.size());
    assertTrue(cOSObject.toIncrement().getObjects().isEmpty());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(extGStateNames, pdResources.getFontNames());
    assertSame(extGStateNames, pdResources.getPatternNames());
    assertSame(extGStateNames, pdResources.getPropertiesNames());
    assertSame(extGStateNames, pdResources.getShadingNames());
    assertSame(extGStateNames, pdResources.getXObjectNames());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDColorSpace)}
   */
  @Test
  void testPut24() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(PDDeviceGray.INSTANCE);

    // Act
    pdResources.put(COSName.A, PDDeviceGray.INSTANCE);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) colorSpaceNames).size());
    assertTrue(cOSObject.toIncrement().getObjects().isEmpty());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(extGStateNames, pdResources.getFontNames());
    assertSame(extGStateNames, pdResources.getPatternNames());
    assertSame(extGStateNames, pdResources.getPropertiesNames());
    assertSame(extGStateNames, pdResources.getShadingNames());
    assertSame(extGStateNames, pdResources.getXObjectNames());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDColorSpace)}
   */
  @Test
  void testPut25() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, PDDeviceGray.INSTANCE);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) colorSpaceNames).size());
    assertEquals(1, cOSObject.size());
    assertTrue(cOSObject.toIncrement().getObjects().isEmpty());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(extGStateNames, pdResources.getFontNames());
    assertSame(extGStateNames, pdResources.getPatternNames());
    assertSame(extGStateNames, pdResources.getPropertiesNames());
    assertSame(extGStateNames, pdResources.getShadingNames());
    assertSame(extGStateNames, pdResources.getXObjectNames());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDColorSpace)}
   */
  @Test
  void testPut26() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, new PDCalGray());

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) colorSpaceNames).size());
    assertEquals(1, cOSObject.size());
    assertTrue(cOSObject.toIncrement().getObjects().isEmpty());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(extGStateNames, pdResources.getFontNames());
    assertSame(extGStateNames, pdResources.getPatternNames());
    assertSame(extGStateNames, pdResources.getPropertiesNames());
    assertSame(extGStateNames, pdResources.getShadingNames());
    assertSame(extGStateNames, pdResources.getXObjectNames());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDColorSpace)}
   */
  @Test
  void testPut27() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, (PDColorSpace) null);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(cOSObject.toIncrement().getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(extGStateNames, pdResources.getFontNames());
    assertSame(extGStateNames, pdResources.getPatternNames());
    assertSame(extGStateNames, pdResources.getPropertiesNames());
    assertSame(extGStateNames, pdResources.getShadingNames());
    assertSame(extGStateNames, pdResources.getXObjectNames());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDColorSpace)}
   */
  @Test
  void testPut28() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, (PDColorSpace) null);

    // Assert
    Iterable<COSName> colorSpaceNames = pdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(cOSObject.toIncrement().getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertSame(extGStateNames, pdResources.getFontNames());
    assertSame(extGStateNames, pdResources.getPatternNames());
    assertSame(extGStateNames, pdResources.getPropertiesNames());
    assertSame(extGStateNames, pdResources.getShadingNames());
    assertSame(extGStateNames, pdResources.getXObjectNames());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDAbstractPattern)}
   */
  @Test
  void testPut29() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, new PDShadingPattern());

    // Assert
    Iterable<COSName> patternNames = pdResources.getPatternNames();
    assertTrue(patternNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) patternNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDAbstractPattern)}
   */
  @Test
  void testPut30() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingPattern());

    // Act
    pdResources.put(COSName.A, new PDShadingPattern());

    // Assert
    Iterable<COSName> patternNames = pdResources.getPatternNames();
    assertTrue(patternNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) patternNames).size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDAbstractPattern)}
   */
  @Test
  void testPut31() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, new PDShadingPattern());

    // Assert
    Iterable<COSName> patternNames = pdResources.getPatternNames();
    assertTrue(patternNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) patternNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDAbstractPattern)}
   */
  @Test
  void testPut32() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, (PDAbstractPattern) null);

    // Assert
    Iterable<COSName> patternNames = pdResources.getPatternNames();
    assertTrue(patternNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(((Set<COSName>) patternNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDAbstractPattern)}
   */
  @Test
  void testPut33() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, (PDAbstractPattern) null);

    // Assert
    Iterable<COSName> patternNames = pdResources.getPatternNames();
    assertTrue(patternNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(((Set<COSName>) patternNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  void testPut34() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, new PDShadingType1(new COSDictionary()));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) shadingNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  void testPut35() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDShadingType1(new COSDictionary()));

    // Act
    pdResources.put(COSName.A, new PDShadingType1(new COSDictionary()));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) shadingNames).size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  void testPut36() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, new PDShadingType1(new COSDictionary()));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) shadingNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  void testPut37() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, new PDShadingType1(null));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(((Set<COSName>) shadingNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  void testPut38() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, (PDShading) null);

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(((Set<COSName>) shadingNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  void testPut39() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, new PDShadingType1(null));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(((Set<COSName>) shadingNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  void testPut40() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary shadingDictionary = new COSDictionary();
    shadingDictionary.setDirect(true);

    // Act
    pdResources.put(COSName.A, new PDShadingType1(shadingDictionary));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) shadingNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  void testPut41() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary shadingDictionary = new COSDictionary();
    shadingDictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    pdResources.put(COSName.A, new PDShadingType1(shadingDictionary));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) shadingNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDShading)}
   */
  @Test
  void testPut42() {
    // Arrange
    PDResources pdResources = new PDResources();

    COSDictionary shadingDictionary = new COSDictionary();
    shadingDictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    pdResources.put(null, new PDShadingType1(shadingDictionary));

    // Assert
    Iterable<COSName> shadingNames = pdResources.getShadingNames();
    assertTrue(shadingNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) shadingNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDExtendedGraphicsState)}
   */
  @Test
  void testPut43() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, new PDExtendedGraphicsState());

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) extGStateNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDExtendedGraphicsState)}
   */
  @Test
  void testPut44() {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDExtendedGraphicsState());

    // Act
    pdResources.put(COSName.A, new PDExtendedGraphicsState());

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) extGStateNames).size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDExtendedGraphicsState)}
   */
  @Test
  void testPut45() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, new PDExtendedGraphicsState());

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) extGStateNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDExtendedGraphicsState)}
   */
  @Test
  void testPut46() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(COSName.A, (PDExtendedGraphicsState) null);

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#put(COSName, PDExtendedGraphicsState)}
   */
  @Test
  void testPut47() {
    // Arrange
    PDResources pdResources = new PDResources();

    // Act
    pdResources.put(null, (PDExtendedGraphicsState) null);

    // Assert
    Iterable<COSName> extGStateNames = pdResources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    COSDictionary cOSObject = pdResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
  }

  /**
   * Method under test: {@link PDResources#getResourceCache()}
   */
  @Test
  void testGetResourceCache() {
    // Arrange, Act and Assert
    assertNull((new PDResources()).getResourceCache());
  }

  /**
   * Method under test: {@link PDResources#PDResources()}
   */
  @Test
  void testNewPDResources() {
    // Arrange and Act
    PDResources actualPdResources = new PDResources();

    // Assert
    Iterable<COSName> colorSpaceNames = actualPdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSDictionary cOSObject = actualPdResources.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdResources.getResourceCache());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, actualPdResources.getExtGStateNames());
    assertSame(colorSpaceNames, actualPdResources.getFontNames());
    assertSame(colorSpaceNames, actualPdResources.getPatternNames());
    assertSame(colorSpaceNames, actualPdResources.getPropertiesNames());
    assertSame(colorSpaceNames, actualPdResources.getShadingNames());
    assertSame(colorSpaceNames, actualPdResources.getXObjectNames());
  }

  /**
   * Method under test: {@link PDResources#PDResources(COSDictionary)}
   */
  @Test
  void testNewPDResources2() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    // Act
    PDResources actualPdResources = new PDResources(resourceDictionary);

    // Assert
    Iterable<COSName> colorSpaceNames = actualPdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    assertNull(actualPdResources.getResourceCache());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(resourceDictionary, actualPdResources.getCOSObject());
    assertSame(colorSpaceNames, actualPdResources.getExtGStateNames());
    assertSame(colorSpaceNames, actualPdResources.getFontNames());
    assertSame(colorSpaceNames, actualPdResources.getPatternNames());
    assertSame(colorSpaceNames, actualPdResources.getPropertiesNames());
    assertSame(colorSpaceNames, actualPdResources.getShadingNames());
    assertSame(colorSpaceNames, actualPdResources.getXObjectNames());
  }

  /**
   * Method under test: {@link PDResources#PDResources(COSDictionary)}
   */
  @Test
  void testNewPDResources3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDResources(null));
  }

  /**
   * Method under test:
   * {@link PDResources#PDResources(COSDictionary, ResourceCache)}
   */
  @Test
  void testNewPDResources4() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();
    DefaultResourceCache resourceCache = new DefaultResourceCache();

    // Act
    PDResources actualPdResources = new PDResources(resourceDictionary, resourceCache);

    // Assert
    Iterable<COSName> colorSpaceNames = actualPdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    ResourceCache resourceCache2 = actualPdResources.getResourceCache();
    assertTrue(resourceCache2 instanceof DefaultResourceCache);
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(resourceDictionary, actualPdResources.getCOSObject());
    assertSame(resourceCache, resourceCache2);
    assertSame(colorSpaceNames, actualPdResources.getExtGStateNames());
    assertSame(colorSpaceNames, actualPdResources.getFontNames());
    assertSame(colorSpaceNames, actualPdResources.getPatternNames());
    assertSame(colorSpaceNames, actualPdResources.getPropertiesNames());
    assertSame(colorSpaceNames, actualPdResources.getShadingNames());
    assertSame(colorSpaceNames, actualPdResources.getXObjectNames());
  }

  /**
   * Method under test:
   * {@link PDResources#PDResources(COSDictionary, ResourceCache)}
   */
  @Test
  void testNewPDResources5() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDResources(null, new DefaultResourceCache()));

  }

  /**
   * Method under test:
   * {@link PDResources#PDResources(COSDictionary, ResourceCache, Map)}
   */
  @Test
  void testNewPDResources6() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();
    DefaultResourceCache resourceCache = new DefaultResourceCache();

    // Act
    PDResources actualPdResources = new PDResources(resourceDictionary, resourceCache, new HashMap<>());

    // Assert
    Iterable<COSName> colorSpaceNames = actualPdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    ResourceCache resourceCache2 = actualPdResources.getResourceCache();
    assertTrue(resourceCache2 instanceof DefaultResourceCache);
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(resourceDictionary, actualPdResources.getCOSObject());
    assertSame(resourceCache, resourceCache2);
    assertSame(colorSpaceNames, actualPdResources.getExtGStateNames());
    assertSame(colorSpaceNames, actualPdResources.getFontNames());
    assertSame(colorSpaceNames, actualPdResources.getPatternNames());
    assertSame(colorSpaceNames, actualPdResources.getPropertiesNames());
    assertSame(colorSpaceNames, actualPdResources.getShadingNames());
    assertSame(colorSpaceNames, actualPdResources.getXObjectNames());
  }

  /**
   * Method under test:
   * {@link PDResources#PDResources(COSDictionary, ResourceCache, Map)}
   */
  @Test
  void testNewPDResources7() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDResources(null, new DefaultResourceCache(), null));

  }

  /**
   * Method under test:
   * {@link PDResources#PDResources(COSDictionary, ResourceCache, Map)}
   */
  @Test
  void testNewPDResources8() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new PDResources(resourceDictionary, new DefaultResourceCache(), null));

  }

  /**
   * Method under test:
   * {@link PDResources#PDResources(COSDictionary, ResourceCache, Map)}
   */
  @Test
  void testNewPDResources9() {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();
    DefaultResourceCache resourceCache = new DefaultResourceCache();

    HashMap<COSName, SoftReference<PDFont>> directFontCache = new HashMap<>();
    directFontCache.computeIfPresent(COSName.A, mock(BiFunction.class));

    // Act
    PDResources actualPdResources = new PDResources(resourceDictionary, resourceCache, directFontCache);

    // Assert
    Iterable<COSName> colorSpaceNames = actualPdResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    ResourceCache resourceCache2 = actualPdResources.getResourceCache();
    assertTrue(resourceCache2 instanceof DefaultResourceCache);
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(resourceDictionary, actualPdResources.getCOSObject());
    assertSame(resourceCache, resourceCache2);
    assertSame(colorSpaceNames, actualPdResources.getExtGStateNames());
    assertSame(colorSpaceNames, actualPdResources.getFontNames());
    assertSame(colorSpaceNames, actualPdResources.getPatternNames());
    assertSame(colorSpaceNames, actualPdResources.getPropertiesNames());
    assertSame(colorSpaceNames, actualPdResources.getShadingNames());
    assertSame(colorSpaceNames, actualPdResources.getXObjectNames());
  }
}
