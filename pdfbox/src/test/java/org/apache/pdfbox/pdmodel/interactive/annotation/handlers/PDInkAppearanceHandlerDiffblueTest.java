package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDSeparation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationInk;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDInkAppearanceHandlerDiffblueTest {
  /**
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance() throws IOException {
    // Arrange
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDColor pdColor = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    when(annotation.getColor()).thenReturn(pdColor);
    PDInkAppearanceHandler pdInkAppearanceHandler = new PDInkAppearanceHandler(annotation);

    // Act
    pdInkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    PDAppearanceEntry downAppearance = pdInkAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdInkAppearanceHandler.getDefaultFont();
    FontBoxFont fontBoxFont = ((PDType1Font) defaultFont).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    GsubData gsubData = ((TrueTypeFont) fontBoxFont).getGsubData();
    assertTrue(gsubData instanceof MapBackedGsubData);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertTrue(defaultFont instanceof PDType1Font);
    PDColor color = pdInkAppearanceHandler.getColor();
    assertTrue(color.getColorSpace() instanceof PDDeviceGray);
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(resources.getResourceCache());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-1.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdInkAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-1.5f, bBox2.getLowerLeftY());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(1.5f, matrix.getTranslateY());
    assertEquals(1.5f, floatArray[1]);
    assertEquals(12.0f, bBox.getUpperRightX());
    assertEquals(12.0f, bBox2.getUpperRightX());
    assertEquals(12.0f, bBox.getWidth());
    assertEquals(12.0f, bBox2.getWidth());
    assertEquals(2.5f, bBox.getUpperRightY());
    assertEquals(2.5f, bBox2.getUpperRightY());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(4.0f, bBox.getHeight());
    assertEquals(4.0f, bBox2.getHeight());
    assertEquals(44, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(44, stream.getLength());
    assertEquals(44, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(44, contentStream.getLength());
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
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdRectangle, pdInkAppearanceHandler.getRectangle());
    assertSame(pdColor, color);
    assertSame(pdAppearanceDictionary, pdInkAppearanceHandler.getAppearance());
    PDResources resources2 = appearanceStream2.getResources();
    assertSame(cOSObject2, resources2.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
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
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance2() throws IOException {
    // Arrange
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(Float.MIN_VALUE);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDColor pdColor = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    when(annotation.getColor()).thenReturn(pdColor);
    PDInkAppearanceHandler pdInkAppearanceHandler = new PDInkAppearanceHandler(annotation);

    // Act
    pdInkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    PDAppearanceEntry downAppearance = pdInkAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = resources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    PDFont defaultFont = pdInkAppearanceHandler.getDefaultFont();
    FontBoxFont fontBoxFont = ((PDType1Font) defaultFont).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    GsubData gsubData = ((TrueTypeFont) fontBoxFont).getGsubData();
    assertTrue(gsubData instanceof MapBackedGsubData);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertTrue(defaultFont instanceof PDType1Font);
    PDColor color = pdInkAppearanceHandler.getColor();
    assertTrue(color.getColorSpace() instanceof PDDeviceGray);
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(resources.getResourceCache());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-1.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdInkAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-1.5f, bBox2.getLowerLeftY());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, ((Set<COSName>) extGStateNames).size());
    assertEquals(1, cOSObject2.size());
    assertEquals(1.5f, matrix.getTranslateY());
    assertEquals(1.5f, floatArray[1]);
    assertEquals(12.0f, bBox.getUpperRightX());
    assertEquals(12.0f, bBox2.getUpperRightX());
    assertEquals(12.0f, bBox.getWidth());
    assertEquals(12.0f, bBox2.getWidth());
    assertEquals(2.5f, bBox.getUpperRightY());
    assertEquals(2.5f, bBox2.getUpperRightY());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(4.0f, bBox.getHeight());
    assertEquals(4.0f, bBox2.getHeight());
    assertEquals(52, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(52, stream.getLength());
    assertEquals(52, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(52, contentStream.getLength());
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(defaultFont.getCOSObject().toIncrement().getObjects().isEmpty());
    assertTrue(defaultFont.getFontDescriptor().getCOSObject().toIncrement().getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdRectangle, pdInkAppearanceHandler.getRectangle());
    assertSame(pdColor, color);
    assertSame(pdAppearanceDictionary, pdInkAppearanceHandler.getAppearance());
    PDResources resources2 = appearanceStream2.getResources();
    assertSame(cOSObject2, resources2.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
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
    assertSame(extGStateNames, resources2.getExtGStateNames());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance3() throws IOException {
    // Arrange
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDColor pdColor = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    when(annotation.getColor()).thenReturn(pdColor);
    PDInkAppearanceHandler pdInkAppearanceHandler = new PDInkAppearanceHandler(annotation);

    // Act
    pdInkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    PDFont defaultFont = pdInkAppearanceHandler.getDefaultFont();
    FontBoxFont fontBoxFont = ((PDType1Font) defaultFont).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    GsubData gsubData = ((TrueTypeFont) fontBoxFont).getGsubData();
    assertTrue(gsubData instanceof MapBackedGsubData);
    PDAppearanceEntry downAppearance = pdInkAppearanceHandler.getDownAppearance();
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceEntry rolloverAppearance = pdInkAppearanceHandler.getRolloverAppearance();
    COSDictionary cOSObject2 = rolloverAppearance.getCOSObject();
    assertTrue(cOSObject2 instanceof COSStream);
    assertTrue(defaultFont instanceof PDType1Font);
    PDColor color = pdInkAppearanceHandler.getColor();
    assertTrue(color.getColorSpace() instanceof PDDeviceGray);
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
    COSDictionary cOSObject3 = pdInkAppearanceHandler.getAppearance().getCOSObject();
    assertEquals(1, cOSObject3.getValues().size());
    assertEquals(1, cOSObject3.size());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertFalse(((COSStream) cOSObject).hasData());
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
    assertTrue(defaultFont.getCOSObject().toIncrement().getObjects().isEmpty());
    assertTrue(defaultFont.getFontDescriptor().getCOSObject().toIncrement().getObjects().isEmpty());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdRectangle, pdInkAppearanceHandler.getRectangle());
    assertSame(pdColor, color);
    assertSame(cOSObject2, stream.getCOSObject());
    assertSame(cOSObject2, contentStream.getCOSObject());
    assertSame(cOSObject2, appearanceStream2.getCOSObject());
  }

  /**
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance4() throws IOException {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightX()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(new COSArray());
    doNothing().when(pdRectangle).setLowerLeftX(anyFloat());
    doNothing().when(pdRectangle).setLowerLeftY(anyFloat());
    doNothing().when(pdRectangle).setUpperRightX(anyFloat());
    doNothing().when(pdRectangle).setUpperRightY(anyFloat());
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDColor pdColor = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    when(annotation.getColor()).thenReturn(pdColor);
    PDInkAppearanceHandler pdInkAppearanceHandler = new PDInkAppearanceHandler(annotation);

    // Act
    pdInkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(eq(8.0f));
    verify(pdRectangle).setLowerLeftY(eq(-1.5f));
    verify(pdRectangle).setUpperRightX(eq(12.0f));
    verify(pdRectangle).setUpperRightY(eq(10.0f));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    PDAppearanceEntry downAppearance = pdInkAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdInkAppearanceHandler.getDefaultFont();
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
    PDColor color = pdInkAppearanceHandler.getColor();
    assertTrue(color.getColorSpace() instanceof PDDeviceGray);
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
    PDAppearanceEntry rolloverAppearance = pdInkAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox2.getHeight());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    assertEquals(0.0f, bBox.getUpperRightX());
    assertEquals(0.0f, bBox2.getUpperRightX());
    assertEquals(0.0f, bBox.getUpperRightY());
    assertEquals(0.0f, bBox2.getUpperRightY());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bBox2.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(44, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(44, stream.getLength());
    assertEquals(44, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(44, contentStream.getLength());
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
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
    assertEquals(toListResult, bBox2.getCOSArray().toList());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(pdColor, color);
    assertSame(pdAppearanceDictionary, pdInkAppearanceHandler.getAppearance());
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
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance5() throws IOException {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightX()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(null);
    doNothing().when(pdRectangle).setLowerLeftX(anyFloat());
    doNothing().when(pdRectangle).setLowerLeftY(anyFloat());
    doNothing().when(pdRectangle).setUpperRightX(anyFloat());
    doNothing().when(pdRectangle).setUpperRightY(anyFloat());
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDColor pdColor = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    when(annotation.getColor()).thenReturn(pdColor);
    PDInkAppearanceHandler pdInkAppearanceHandler = new PDInkAppearanceHandler(annotation);

    // Act
    pdInkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(eq(8.0f));
    verify(pdRectangle).setLowerLeftY(eq(-1.5f));
    verify(pdRectangle).setUpperRightX(eq(12.0f));
    verify(pdRectangle).setUpperRightY(eq(10.0f));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    PDAppearanceEntry downAppearance = pdInkAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdInkAppearanceHandler.getDefaultFont();
    FontBoxFont fontBoxFont = ((PDType1Font) defaultFont).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    GsubData gsubData = ((TrueTypeFont) fontBoxFont).getGsubData();
    assertTrue(gsubData instanceof MapBackedGsubData);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertTrue(defaultFont instanceof PDType1Font);
    PDColor color = pdInkAppearanceHandler.getColor();
    assertTrue(color.getColorSpace() instanceof PDDeviceGray);
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(resources.getResourceCache());
    assertNull(appearanceStream.getBBox());
    PDAppearanceEntry rolloverAppearance = pdInkAppearanceHandler.getRolloverAppearance();
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
    assertEquals(44, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(44, stream.getLength());
    assertEquals(44, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(44, contentStream.getLength());
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
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
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdColor, color);
    assertSame(pdAppearanceDictionary, pdInkAppearanceHandler.getAppearance());
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
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance6() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(false);
    when(cosArray.getKey()).thenReturn(new COSObjectKey(1L, 1));
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightX()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);
    doNothing().when(pdRectangle).setLowerLeftX(anyFloat());
    doNothing().when(pdRectangle).setLowerLeftY(anyFloat());
    doNothing().when(pdRectangle).setUpperRightX(anyFloat());
    doNothing().when(pdRectangle).setUpperRightY(anyFloat());
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDColor pdColor = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    when(annotation.getColor()).thenReturn(pdColor);
    PDInkAppearanceHandler pdInkAppearanceHandler = new PDInkAppearanceHandler(annotation);

    // Act
    pdInkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray, atLeast(1)).getKey();
    verify(cosArray).isDirect();
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(eq(8.0f));
    verify(pdRectangle).setLowerLeftY(eq(-1.5f));
    verify(pdRectangle).setUpperRightX(eq(12.0f));
    verify(pdRectangle).setUpperRightY(eq(10.0f));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    PDAppearanceEntry downAppearance = pdInkAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdInkAppearanceHandler.getDefaultFont();
    FontBoxFont fontBoxFont = ((PDType1Font) defaultFont).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    GsubData gsubData = ((TrueTypeFont) fontBoxFont).getGsubData();
    assertTrue(gsubData instanceof MapBackedGsubData);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertTrue(defaultFont instanceof PDType1Font);
    PDColor color = pdInkAppearanceHandler.getColor();
    assertTrue(color.getColorSpace() instanceof PDDeviceGray);
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
    assertEquals(44, appearanceStream.getStream().getLength());
    PDAppearanceEntry rolloverAppearance = pdInkAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDStream stream = appearanceStream2.getStream();
    assertEquals(44, stream.getLength());
    assertEquals(44, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(44, contentStream.getLength());
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
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdColor, color);
    assertSame(pdAppearanceDictionary, pdInkAppearanceHandler.getAppearance());
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
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance7() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightX()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);
    doNothing().when(pdRectangle).setLowerLeftX(anyFloat());
    doNothing().when(pdRectangle).setLowerLeftY(anyFloat());
    doNothing().when(pdRectangle).setUpperRightX(anyFloat());
    doNothing().when(pdRectangle).setUpperRightY(anyFloat());
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    PDColor pdColor = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    when(annotation.getColor()).thenReturn(pdColor);
    PDInkAppearanceHandler pdInkAppearanceHandler = new PDInkAppearanceHandler(annotation);

    // Act
    pdInkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(eq(-10.0f));
    verify(pdRectangle).setLowerLeftY(eq(-19.5f));
    verify(pdRectangle).setUpperRightX(eq(30.0f));
    verify(pdRectangle).setUpperRightY(eq(20.5f));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdInkAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdInkAppearanceHandler.getDefaultFont();
    FontBoxFont fontBoxFont = ((PDType1Font) defaultFont).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    GsubData gsubData = ((TrueTypeFont) fontBoxFont).getGsubData();
    assertTrue(gsubData instanceof MapBackedGsubData);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertTrue(defaultFont instanceof PDType1Font);
    PDColor color = pdInkAppearanceHandler.getColor();
    assertTrue(color.getColorSpace() instanceof PDDeviceGray);
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
    assertEquals(45, appearanceStream.getStream().getLength());
    PDAppearanceEntry rolloverAppearance = pdInkAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDStream stream = appearanceStream2.getStream();
    assertEquals(45, stream.getLength());
    assertEquals(45, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(45, contentStream.getLength());
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
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdColor, color);
    assertSame(pdAppearanceDictionary, pdInkAppearanceHandler.getAppearance());
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
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance8() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightX()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);
    doNothing().when(pdRectangle).setLowerLeftX(anyFloat());
    doNothing().when(pdRectangle).setLowerLeftY(anyFloat());
    doNothing().when(pdRectangle).setUpperRightX(anyFloat());
    doNothing().when(pdRectangle).setUpperRightY(anyFloat());
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{Float.MAX_VALUE, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    PDColor pdColor = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    when(annotation.getColor()).thenReturn(pdColor);
    PDInkAppearanceHandler pdInkAppearanceHandler = new PDInkAppearanceHandler(annotation);

    // Act
    pdInkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(eq(-10.0f));
    verify(pdRectangle).setLowerLeftY(eq(-19.5f));
    verify(pdRectangle).setUpperRightX(eq(3.4028235E38f));
    verify(pdRectangle).setUpperRightY(eq(20.5f));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdInkAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdInkAppearanceHandler.getDefaultFont();
    FontBoxFont fontBoxFont = ((PDType1Font) defaultFont).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    GsubData gsubData = ((TrueTypeFont) fontBoxFont).getGsubData();
    assertTrue(gsubData instanceof MapBackedGsubData);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertTrue(defaultFont instanceof PDType1Font);
    PDColor color = pdInkAppearanceHandler.getColor();
    assertTrue(color.getColorSpace() instanceof PDDeviceGray);
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
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(82, appearanceStream.getStream().getLength());
    PDAppearanceEntry rolloverAppearance = pdInkAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDStream stream = appearanceStream2.getStream();
    assertEquals(82, stream.getLength());
    assertEquals(82, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(82, contentStream.getLength());
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
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdColor, color);
    assertSame(pdAppearanceDictionary, pdInkAppearanceHandler.getAppearance());
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
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance9() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightX()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);
    doNothing().when(pdRectangle).setLowerLeftX(anyFloat());
    doNothing().when(pdRectangle).setLowerLeftY(anyFloat());
    doNothing().when(pdRectangle).setUpperRightX(anyFloat());
    doNothing().when(pdRectangle).setUpperRightY(anyFloat());
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    PDColor pdColor = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    when(annotation.getColor()).thenReturn(pdColor);
    PDInkAppearanceHandler pdInkAppearanceHandler = new PDInkAppearanceHandler(annotation);

    // Act
    pdInkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(eq(-10.0f));
    verify(pdRectangle).setLowerLeftY(eq(-19.5f));
    verify(pdRectangle).setUpperRightX(eq(30.0f));
    verify(pdRectangle).setUpperRightY(eq(20.5f));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdInkAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdInkAppearanceHandler.getDefaultFont();
    FontBoxFont fontBoxFont = ((PDType1Font) defaultFont).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    GsubData gsubData = ((TrueTypeFont) fontBoxFont).getGsubData();
    assertTrue(gsubData instanceof MapBackedGsubData);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertTrue(defaultFont instanceof PDType1Font);
    PDColor color = pdInkAppearanceHandler.getColor();
    assertTrue(color.getColorSpace() instanceof PDDeviceGray);
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
    assertEquals(45, appearanceStream.getStream().getLength());
    PDAppearanceEntry rolloverAppearance = pdInkAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDStream stream = appearanceStream2.getStream();
    assertEquals(45, stream.getLength());
    assertEquals(45, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(45, contentStream.getLength());
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
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdColor, color);
    assertSame(pdAppearanceDictionary, pdInkAppearanceHandler.getAppearance());
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
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance10() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("U");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightX()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);
    doNothing().when(pdRectangle).setLowerLeftX(anyFloat());
    doNothing().when(pdRectangle).setLowerLeftY(anyFloat());
    doNothing().when(pdRectangle).setUpperRightX(anyFloat());
    doNothing().when(pdRectangle).setUpperRightY(anyFloat());
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    PDColor pdColor = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    when(annotation.getColor()).thenReturn(pdColor);
    PDInkAppearanceHandler pdInkAppearanceHandler = new PDInkAppearanceHandler(annotation);

    // Act
    pdInkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(eq(-10.0f));
    verify(pdRectangle).setLowerLeftY(eq(-19.5f));
    verify(pdRectangle).setUpperRightX(eq(30.0f));
    verify(pdRectangle).setUpperRightY(eq(20.5f));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdInkAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdInkAppearanceHandler.getDefaultFont();
    FontBoxFont fontBoxFont = ((PDType1Font) defaultFont).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    GsubData gsubData = ((TrueTypeFont) fontBoxFont).getGsubData();
    assertTrue(gsubData instanceof MapBackedGsubData);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertTrue(defaultFont instanceof PDType1Font);
    PDColor color = pdInkAppearanceHandler.getColor();
    assertTrue(color.getColorSpace() instanceof PDDeviceGray);
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
    assertEquals(45, appearanceStream.getStream().getLength());
    PDAppearanceEntry rolloverAppearance = pdInkAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDStream stream = appearanceStream2.getStream();
    assertEquals(45, stream.getLength());
    assertEquals(45, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(45, contentStream.getLength());
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
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdColor, color);
    assertSame(pdAppearanceDictionary, pdInkAppearanceHandler.getAppearance());
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
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance11() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightX()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);
    doNothing().when(pdRectangle).setLowerLeftX(anyFloat());
    doNothing().when(pdRectangle).setLowerLeftY(anyFloat());
    doNothing().when(pdRectangle).setUpperRightX(anyFloat());
    doNothing().when(pdRectangle).setUpperRightY(anyFloat());
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    PDColor pdColor = new PDColor(new COSArray(), PDDeviceRGB.INSTANCE);

    when(annotation.getColor()).thenReturn(pdColor);
    PDInkAppearanceHandler pdInkAppearanceHandler = new PDInkAppearanceHandler(annotation);

    // Act
    pdInkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(eq(-10.0f));
    verify(pdRectangle).setLowerLeftY(eq(-19.5f));
    verify(pdRectangle).setUpperRightX(eq(30.0f));
    verify(pdRectangle).setUpperRightY(eq(20.5f));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdInkAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdInkAppearanceHandler.getDefaultFont();
    FontBoxFont fontBoxFont = ((PDType1Font) defaultFont).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    GsubData gsubData = ((TrueTypeFont) fontBoxFont).getGsubData();
    assertTrue(gsubData instanceof MapBackedGsubData);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertTrue(defaultFont instanceof PDType1Font);
    PDColor color = pdInkAppearanceHandler.getColor();
    assertTrue(color.getColorSpace() instanceof PDDeviceRGB);
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
    assertEquals(48, appearanceStream.getStream().getLength());
    PDAppearanceEntry rolloverAppearance = pdInkAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDStream stream = appearanceStream2.getStream();
    assertEquals(48, stream.getLength());
    assertEquals(48, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(48, contentStream.getLength());
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
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdColor, color);
    assertSame(pdAppearanceDictionary, pdInkAppearanceHandler.getAppearance());
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
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance12() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightX()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);
    doNothing().when(pdRectangle).setLowerLeftX(anyFloat());
    doNothing().when(pdRectangle).setLowerLeftY(anyFloat());
    doNothing().when(pdRectangle).setUpperRightX(anyFloat());
    doNothing().when(pdRectangle).setUpperRightY(anyFloat());
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    COSArray array = new COSArray();
    PDColor pdColor = new PDColor(array, new PDCalGray());

    when(annotation.getColor()).thenReturn(pdColor);
    PDInkAppearanceHandler pdInkAppearanceHandler = new PDInkAppearanceHandler(annotation);

    // Act
    pdInkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(eq(-10.0f));
    verify(pdRectangle).setLowerLeftY(eq(-19.5f));
    verify(pdRectangle).setUpperRightX(eq(30.0f));
    verify(pdRectangle).setUpperRightY(eq(20.5f));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdInkAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = resources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    PDFont defaultFont = pdInkAppearanceHandler.getDefaultFont();
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
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, ((Set<COSName>) colorSpaceNames).size());
    assertEquals(1, cOSObject2.size());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(38, appearanceStream.getStream().getLength());
    PDAppearanceEntry rolloverAppearance = pdInkAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDStream stream = appearanceStream2.getStream();
    assertEquals(38, stream.getLength());
    assertEquals(38, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(38, contentStream.getLength());
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(defaultFont.getCOSObject().toIncrement().getObjects().isEmpty());
    assertTrue(defaultFont.getFontDescriptor().getCOSObject().toIncrement().getObjects().isEmpty());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdColor, pdInkAppearanceHandler.getColor());
    assertSame(pdAppearanceDictionary, pdInkAppearanceHandler.getAppearance());
    PDResources resources2 = appearanceStream2.getResources();
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(extGStateNames, resources2.getExtGStateNames());
    assertSame(extGStateNames, resources.getFontNames());
    assertSame(extGStateNames, resources2.getFontNames());
    assertSame(extGStateNames, resources.getPatternNames());
    assertSame(extGStateNames, resources2.getPatternNames());
    assertSame(extGStateNames, resources.getPropertiesNames());
    assertSame(extGStateNames, resources2.getPropertiesNames());
    assertSame(extGStateNames, resources.getShadingNames());
    assertSame(extGStateNames, resources2.getShadingNames());
    assertSame(extGStateNames, resources.getXObjectNames());
    assertSame(extGStateNames, resources2.getXObjectNames());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance13() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightX()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);
    doNothing().when(pdRectangle).setLowerLeftX(anyFloat());
    doNothing().when(pdRectangle).setLowerLeftY(anyFloat());
    doNothing().when(pdRectangle).setUpperRightX(anyFloat());
    doNothing().when(pdRectangle).setUpperRightY(anyFloat());
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    COSArray array = new COSArray();
    PDColor pdColor = new PDColor(array, new PDSeparation());

    when(annotation.getColor()).thenReturn(pdColor);
    PDInkAppearanceHandler pdInkAppearanceHandler = new PDInkAppearanceHandler(annotation);

    // Act
    pdInkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(eq(-10.0f));
    verify(pdRectangle).setLowerLeftY(eq(-19.5f));
    verify(pdRectangle).setUpperRightX(eq(30.0f));
    verify(pdRectangle).setUpperRightY(eq(20.5f));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdInkAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = resources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    PDFont defaultFont = pdInkAppearanceHandler.getDefaultFont();
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
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, ((Set<COSName>) colorSpaceNames).size());
    assertEquals(1, cOSObject2.size());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(39, appearanceStream.getStream().getLength());
    PDAppearanceEntry rolloverAppearance = pdInkAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDStream stream = appearanceStream2.getStream();
    assertEquals(39, stream.getLength());
    assertEquals(39, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(39, contentStream.getLength());
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(gsubData.getSupportedFeatures().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(defaultFont.getCOSObject().toIncrement().getObjects().isEmpty());
    assertTrue(defaultFont.getFontDescriptor().getCOSObject().toIncrement().getObjects().isEmpty());
    assertTrue(((Set<COSName>) extGStateNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdColor, pdInkAppearanceHandler.getColor());
    assertSame(pdAppearanceDictionary, pdInkAppearanceHandler.getAppearance());
    PDResources resources2 = appearanceStream2.getResources();
    assertSame(cOSObject2, resources2.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(extGStateNames, resources2.getExtGStateNames());
    assertSame(extGStateNames, resources.getFontNames());
    assertSame(extGStateNames, resources2.getFontNames());
    assertSame(extGStateNames, resources.getPatternNames());
    assertSame(extGStateNames, resources2.getPatternNames());
    assertSame(extGStateNames, resources.getPropertiesNames());
    assertSame(extGStateNames, resources2.getPropertiesNames());
    assertSame(extGStateNames, resources.getShadingNames());
    assertSame(extGStateNames, resources2.getShadingNames());
    assertSame(extGStateNames, resources.getXObjectNames());
    assertSame(extGStateNames, resources2.getXObjectNames());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDInkAppearanceHandler#PDInkAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDInkAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDInkAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDInkAppearanceHandler actualPdInkAppearanceHandler = new PDInkAppearanceHandler(annotation);
    actualPdInkAppearanceHandler.generateDownAppearance();
    actualPdInkAppearanceHandler.generateRolloverAppearance();

    // Assert that nothing has changed
    assertTrue(actualPdInkAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdInkAppearanceHandler.getAnnotation());
  }
}
