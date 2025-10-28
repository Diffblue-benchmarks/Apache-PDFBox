package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.ttf.model.GsubData;
import org.apache.fontbox.ttf.model.MapBackedGsubData;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDLinkAppearanceHandlerDiffblueTest {
  /**
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance() throws IOException {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    PDFont defaultFont = pdLinkAppearanceHandler.getDefaultFont();
    FontBoxFont fontBoxFont = ((PDType1Font) defaultFont).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    GsubData gsubData = ((TrueTypeFont) fontBoxFont).getGsubData();
    assertTrue(gsubData instanceof MapBackedGsubData);
    PDAppearanceEntry downAppearance = pdLinkAppearanceHandler.getDownAppearance();
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceEntry rolloverAppearance = pdLinkAppearanceHandler.getRolloverAppearance();
    COSDictionary cOSObject2 = rolloverAppearance.getCOSObject();
    assertTrue(cOSObject2 instanceof COSStream);
    assertTrue(defaultFont instanceof PDType1Font);
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    assertNull(appearanceStream.getResources());
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    assertNull(appearanceStream2.getResources());
    assertNull(appearanceStream.getBBox());
    assertNull(appearanceStream2.getBBox());
    assertEquals(0, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(0, stream.getLength());
    assertEquals(0, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(0, contentStream.getLength());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(0.0f, floatArray[0]);
    assertEquals(0.0f, floatArray[1]);
    COSDictionary cOSObject3 = pdLinkAppearanceHandler.getAppearance().getCOSObject();
    assertEquals(1, cOSObject3.getValues().size());
    assertEquals(1, cOSObject3.size());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertFalse(cOSObject3.toIncrement().iterator().hasNext());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(((COSStream) cOSObject).hasData());
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
    assertTrue(defaultFont.getCOSObject().toIncrement().getObjects().isEmpty());
    assertTrue(defaultFont.getFontDescriptor().getCOSObject().toIncrement().getObjects().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(cOSObject2, stream.getCOSObject());
    assertSame(cOSObject2, contentStream.getCOSObject());
    assertSame(cOSObject2, appearanceStream2.getCOSObject());
  }

  /**
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance2() throws IOException {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.contains(anyFloat(), anyFloat())).thenReturn(true);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(new COSArray());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{9.223372E18f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(pdColor);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(pdRectangle, atLeast(1)).contains(anyFloat(), eq(0.5f));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdLinkAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdLinkAppearanceHandler.getDefaultFont();
    FontBoxFont fontBoxFont = ((PDType1Font) defaultFont).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    GsubData gsubData = ((TrueTypeFont) fontBoxFont).getGsubData();
    assertTrue(gsubData instanceof MapBackedGsubData);
    PDRectangle bBox = appearanceStream.getBBox();
    COSArray cOSArray = bBox.getCOSArray();
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
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertTrue(defaultFont instanceof PDType1Font);
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertNull(cOSObject2.getKey());
    assertNull(resources.getResourceCache());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-10.0f, matrix.getTranslateX());
    assertEquals(-10.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-10.0f, floatArray[0]);
    assertEquals(-10.0f, floatArray[1]);
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getHeight());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox.getUpperRightX());
    assertEquals(0.0f, bBox.getUpperRightY());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(34, appearanceStream.getStream().getLength());
    PDAppearanceEntry rolloverAppearance = pdLinkAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDStream stream = appearanceStream2.getStream();
    assertEquals(34, stream.getLength());
    assertEquals(34, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(34, contentStream.getLength());
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(defaultFont.getCOSObject().toIncrement().getObjects().isEmpty());
    assertTrue(defaultFont.getFontDescriptor().getCOSObject().toIncrement().getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertEquals(toListResult, appearanceStream2.getBBox().getCOSArray().toList());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(pdAppearanceDictionary, pdLinkAppearanceHandler.getAppearance());
    PDResources resources2 = appearanceStream2.getResources();
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(cOSArray, bBox.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources2.getFontNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance3() throws IOException {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.contains(anyFloat(), anyFloat())).thenReturn(true);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(null);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{9.223372E18f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(pdColor);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(pdRectangle, atLeast(1)).contains(anyFloat(), eq(0.5f));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdLinkAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdLinkAppearanceHandler.getDefaultFont();
    FontBoxFont fontBoxFont = ((PDType1Font) defaultFont).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    GsubData gsubData = ((TrueTypeFont) fontBoxFont).getGsubData();
    assertTrue(gsubData instanceof MapBackedGsubData);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertTrue(defaultFont instanceof PDType1Font);
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(resources.getResourceCache());
    assertNull(appearanceStream.getBBox());
    PDAppearanceEntry rolloverAppearance = pdLinkAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    assertNull(appearanceStream2.getBBox());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-10.0f, matrix.getTranslateX());
    assertEquals(-10.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-10.0f, floatArray[0]);
    assertEquals(-10.0f, floatArray[1]);
    assertEquals(0, cOSObject2.size());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(34, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(34, stream.getLength());
    assertEquals(34, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(34, contentStream.getLength());
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(defaultFont.getCOSObject().toIncrement().getObjects().isEmpty());
    assertTrue(defaultFont.getFontDescriptor().getCOSObject().toIncrement().getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertSame(pdAppearanceDictionary, pdLinkAppearanceHandler.getAppearance());
    PDResources resources2 = appearanceStream2.getResources();
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources2.getFontNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance4() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.contains(anyFloat(), anyFloat())).thenReturn(true);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{9.223372E18f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(pdColor);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(pdRectangle, atLeast(1)).contains(anyFloat(), eq(0.5f));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdLinkAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdLinkAppearanceHandler.getDefaultFont();
    FontBoxFont fontBoxFont = ((PDType1Font) defaultFont).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    GsubData gsubData = ((TrueTypeFont) fontBoxFont).getGsubData();
    assertTrue(gsubData instanceof MapBackedGsubData);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertTrue(defaultFont instanceof PDType1Font);
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(resources.getResourceCache());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-10.0f, matrix.getTranslateX());
    assertEquals(-10.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-10.0f, floatArray[0]);
    assertEquals(-10.0f, floatArray[1]);
    assertEquals(0, cOSObject2.size());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(34, appearanceStream.getStream().getLength());
    PDAppearanceEntry rolloverAppearance = pdLinkAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDStream stream = appearanceStream2.getStream();
    assertEquals(34, stream.getLength());
    assertEquals(34, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(34, contentStream.getLength());
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(defaultFont.getCOSObject().toIncrement().getObjects().isEmpty());
    assertTrue(defaultFont.getFontDescriptor().getCOSObject().toIncrement().getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertSame(pdAppearanceDictionary, pdLinkAppearanceHandler.getAppearance());
    PDResources resources2 = appearanceStream2.getResources();
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources2.getFontNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance5() throws IOException {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.contains(anyFloat(), anyFloat())).thenReturn(true);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{9.223372E18f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(pdColor);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle, atLeast(1)).contains(anyFloat(), eq(0.5f));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdLinkAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdLinkAppearanceHandler.getDefaultFont();
    FontBoxFont fontBoxFont = ((PDType1Font) defaultFont).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    GsubData gsubData = ((TrueTypeFont) fontBoxFont).getGsubData();
    assertTrue(gsubData instanceof MapBackedGsubData);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertTrue(defaultFont instanceof PDType1Font);
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(resources.getResourceCache());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-10.0f, matrix.getTranslateX());
    assertEquals(-10.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-10.0f, floatArray[0]);
    assertEquals(-10.0f, floatArray[1]);
    assertEquals(0, cOSObject2.size());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(34, appearanceStream.getStream().getLength());
    PDAppearanceEntry rolloverAppearance = pdLinkAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDStream stream = appearanceStream2.getStream();
    assertEquals(34, stream.getLength());
    assertEquals(34, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(34, contentStream.getLength());
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(defaultFont.getCOSObject().toIncrement().getObjects().isEmpty());
    assertTrue(defaultFont.getFontDescriptor().getCOSObject().toIncrement().getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertSame(pdAppearanceDictionary, pdLinkAppearanceHandler.getAppearance());
    PDResources resources2 = appearanceStream2.getResources();
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources2.getFontNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDLinkAppearanceHandler#getLineWidth()}
   */
  @Test
  void testGetLineWidth() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDLinkAppearanceHandler(new PDAnnotationLink())).getLineWidth());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDLinkAppearanceHandler#PDLinkAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDLinkAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDLinkAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDLinkAppearanceHandler actualPdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);
    actualPdLinkAppearanceHandler.generateDownAppearance();
    actualPdLinkAppearanceHandler.generateRolloverAppearance();

    // Assert that nothing has changed
    assertTrue(actualPdLinkAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdLinkAppearanceHandler.getAnnotation());
  }
}
