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
import java.awt.geom.AffineTransform;
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
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationPolygon;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderEffectDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDPolygonAppearanceHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance() throws IOException {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.5f, matrix.getTranslateY());
    assertEquals(0.5f, floatArray[1]);
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(11.0f, bBox.getUpperRightX());
    assertEquals(11.0f, bBox2.getUpperRightX());
    assertEquals(11.0f, bBox.getWidth());
    assertEquals(11.0f, bBox2.getWidth());
    assertEquals(12, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(12, stream.getLength());
    assertEquals(12, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(12, contentStream.getLength());
    assertEquals(2.0f, bBox.getHeight());
    assertEquals(2.0f, bBox2.getHeight());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance2() throws IOException {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(Float.MIN_VALUE);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = resources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.5f, matrix.getTranslateY());
    assertEquals(0.5f, floatArray[1]);
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, ((Set<COSName>) extGStateNames).size());
    assertEquals(1, cOSObject2.size());
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(11.0f, bBox.getUpperRightX());
    assertEquals(11.0f, bBox2.getUpperRightX());
    assertEquals(11.0f, bBox.getWidth());
    assertEquals(11.0f, bBox2.getWidth());
    assertEquals(2.0f, bBox.getHeight());
    assertEquals(2.0f, bBox2.getHeight());
    assertEquals(20, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(20, stream.getLength());
    assertEquals(20, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(20, contentStream.getLength());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance3() throws IOException {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceRGB.INSTANCE));
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.5f, matrix.getTranslateY());
    assertEquals(0.5f, floatArray[1]);
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(11.0f, bBox.getUpperRightX());
    assertEquals(11.0f, bBox2.getUpperRightX());
    assertEquals(11.0f, bBox.getWidth());
    assertEquals(11.0f, bBox2.getWidth());
    assertEquals(17, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(17, stream.getLength());
    assertEquals(17, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(17, contentStream.getLength());
    assertEquals(2.0f, bBox.getHeight());
    assertEquals(2.0f, bBox2.getHeight());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance4() throws IOException {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), null));
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.5f, matrix.getTranslateY());
    assertEquals(0.5f, floatArray[1]);
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(11.0f, bBox.getUpperRightX());
    assertEquals(11.0f, bBox2.getUpperRightX());
    assertEquals(11.0f, bBox.getWidth());
    assertEquals(11.0f, bBox2.getWidth());
    assertEquals(2.0f, bBox.getHeight());
    assertEquals(2.0f, bBox2.getHeight());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(8, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(8, stream.getLength());
    assertEquals(8, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(8, contentStream.getLength());
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance5() throws IOException {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.5f, matrix.getTranslateY());
    assertEquals(0.5f, floatArray[1]);
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(11.0f, bBox.getUpperRightX());
    assertEquals(11.0f, bBox2.getUpperRightX());
    assertEquals(11.0f, bBox.getWidth());
    assertEquals(11.0f, bBox2.getWidth());
    assertEquals(2.0f, bBox.getHeight());
    assertEquals(2.0f, bBox2.getHeight());
    assertEquals(28, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(28, stream.getLength());
    assertEquals(28, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(28, contentStream.getLength());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance6() throws IOException {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(null);
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.5f, matrix.getTranslateY());
    assertEquals(0.5f, floatArray[1]);
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(11.0f, bBox.getUpperRightX());
    assertEquals(11.0f, bBox2.getUpperRightX());
    assertEquals(11.0f, bBox.getWidth());
    assertEquals(11.0f, bBox2.getWidth());
    assertEquals(2.0f, bBox.getHeight());
    assertEquals(2.0f, bBox2.getHeight());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(8, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(8, stream.getLength());
    assertEquals(8, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(8, contentStream.getLength());
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance7() throws IOException {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, PDDeviceGray.INSTANCE));
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.5f, matrix.getTranslateY());
    assertEquals(0.5f, floatArray[1]);
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(11.0f, bBox.getUpperRightX());
    assertEquals(11.0f, bBox2.getUpperRightX());
    assertEquals(11.0f, bBox.getWidth());
    assertEquals(11.0f, bBox2.getWidth());
    assertEquals(13, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(13, stream.getLength());
    assertEquals(13, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(13, contentStream.getLength());
    assertEquals(2.0f, bBox.getHeight());
    assertEquals(2.0f, bBox2.getHeight());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance8() throws IOException {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceRGB.INSTANCE));
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.5f, matrix.getTranslateY());
    assertEquals(0.5f, floatArray[1]);
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(11.0f, bBox.getUpperRightX());
    assertEquals(11.0f, bBox2.getUpperRightX());
    assertEquals(11.0f, bBox.getWidth());
    assertEquals(11.0f, bBox2.getWidth());
    assertEquals(2.0f, bBox.getHeight());
    assertEquals(2.0f, bBox2.getHeight());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(33, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(33, stream.getLength());
    assertEquals(33, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(33, contentStream.getLength());
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance9() throws IOException {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), null));
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.5f, matrix.getTranslateY());
    assertEquals(0.5f, floatArray[1]);
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(11.0f, bBox.getUpperRightX());
    assertEquals(11.0f, bBox2.getUpperRightX());
    assertEquals(11.0f, bBox.getWidth());
    assertEquals(11.0f, bBox2.getWidth());
    assertEquals(2.0f, bBox.getHeight());
    assertEquals(2.0f, bBox2.getHeight());
    assertEquals(24, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(24, stream.getLength());
    assertEquals(24, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(24, contentStream.getLength());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance10() throws IOException {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDColorSpace colorSpace2 = mock(PDColorSpace.class);
    when(colorSpace2.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor2 = new PDColor(new COSArray(), colorSpace2);

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(colorSpace2).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.5f, matrix.getTranslateY());
    assertEquals(0.5f, floatArray[1]);
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(11.0f, bBox.getUpperRightX());
    assertEquals(11.0f, bBox2.getUpperRightX());
    assertEquals(11.0f, bBox.getWidth());
    assertEquals(11.0f, bBox2.getWidth());
    assertEquals(2.0f, bBox.getHeight());
    assertEquals(2.0f, bBox2.getHeight());
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance11() throws IOException {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(null);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.5f, matrix.getTranslateY());
    assertEquals(0.5f, floatArray[1]);
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(11.0f, bBox.getUpperRightX());
    assertEquals(11.0f, bBox2.getUpperRightX());
    assertEquals(11.0f, bBox.getWidth());
    assertEquals(11.0f, bBox2.getWidth());
    assertEquals(2.0f, bBox.getHeight());
    assertEquals(2.0f, bBox2.getHeight());
    assertEquals(24, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(24, stream.getLength());
    assertEquals(24, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(24, contentStream.getLength());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance12() throws IOException {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDColorSpace colorSpace2 = mock(PDColorSpace.class);
    when(colorSpace2.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor2 = new PDColor(new COSArray(), colorSpace2);

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    when(annotation.getAppearance()).thenReturn(null);
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(colorSpace2).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
    FontBoxFont fontBoxFont = ((PDType1Font) defaultFont).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    GsubData gsubData = ((TrueTypeFont) fontBoxFont).getGsubData();
    assertTrue(gsubData instanceof MapBackedGsubData);
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
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
    COSDictionary cOSObject3 = pdPolygonAppearanceHandler.getAppearance().getCOSObject();
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(cOSObject2, stream.getCOSObject());
    assertSame(cOSObject2, contentStream.getCOSObject());
    assertSame(cOSObject2, appearanceStream2.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance13() throws IOException {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDColorSpace colorSpace2 = mock(PDColorSpace.class);
    when(colorSpace2.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor2 = new PDColor(new COSArray(), colorSpace2);

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(null);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(colorSpace2).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.5f, matrix.getTranslateY());
    assertEquals(0.5f, floatArray[1]);
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(11.0f, bBox.getUpperRightX());
    assertEquals(11.0f, bBox2.getUpperRightX());
    assertEquals(11.0f, bBox.getWidth());
    assertEquals(11.0f, bBox2.getWidth());
    assertEquals(2.0f, bBox.getHeight());
    assertEquals(2.0f, bBox2.getHeight());
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance14() throws IOException {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDColorSpace colorSpace2 = mock(PDColorSpace.class);
    when(colorSpace2.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor2 = new PDColor(new COSArray(), colorSpace2);

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("Style");
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(colorSpace2).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    verify(pdBorderEffectDictionary).getStyle();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.5f, matrix.getTranslateY());
    assertEquals(0.5f, floatArray[1]);
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(11.0f, bBox.getUpperRightX());
    assertEquals(11.0f, bBox2.getUpperRightX());
    assertEquals(11.0f, bBox.getWidth());
    assertEquals(11.0f, bBox2.getWidth());
    assertEquals(2.0f, bBox.getHeight());
    assertEquals(2.0f, bBox2.getHeight());
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance15() throws IOException {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDColorSpace colorSpace2 = mock(PDColorSpace.class);
    when(colorSpace2.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor2 = new PDColor(new COSArray(), colorSpace2);

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getIntensity()).thenReturn(10.0f);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("C");
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(colorSpace2).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).setRectangle(Mockito.<PDRectangle>any());
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    verify(annotation).getVertices();
    verify(pdBorderEffectDictionary).getIntensity();
    verify(pdBorderEffectDictionary).getStyle();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.5f, matrix.getTranslateY());
    assertEquals(0.5f, floatArray[1]);
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(11.0f, bBox.getUpperRightX());
    assertEquals(11.0f, bBox2.getUpperRightX());
    assertEquals(11.0f, bBox.getWidth());
    assertEquals(11.0f, bBox2.getWidth());
    assertEquals(2.0f, bBox.getHeight());
    assertEquals(2.0f, bBox2.getHeight());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(42, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(42, stream.getLength());
    assertEquals(42, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(42, contentStream.getLength());
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance16() throws IOException {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDColorSpace colorSpace2 = mock(PDColorSpace.class);
    when(colorSpace2.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor2 = new PDColor(new COSArray(), colorSpace2);

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getIntensity()).thenReturn(10.0f);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("C");
    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(colorSpace2).getNumberOfComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).setRectangle(Mockito.<PDRectangle>any());
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    verify(annotation).getVertices();
    verify(pdBorderEffectDictionary).getIntensity();
    verify(pdBorderEffectDictionary).getStyle();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.5f, matrix.getTranslateY());
    assertEquals(0.5f, floatArray[1]);
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(11.0f, bBox.getUpperRightX());
    assertEquals(11.0f, bBox2.getUpperRightX());
    assertEquals(11.0f, bBox.getWidth());
    assertEquals(11.0f, bBox2.getWidth());
    assertEquals(2.0f, bBox.getHeight());
    assertEquals(2.0f, bBox2.getHeight());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(42, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(42, stream.getLength());
    assertEquals(42, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(42, contentStream.getLength());
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance17() throws IOException {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDColorSpace colorSpace2 = mock(PDColorSpace.class);
    when(colorSpace2.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor2 = new PDColor(new COSArray(), colorSpace2);

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getIntensity()).thenReturn(-9.223372E18f);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("C");
    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(colorSpace2).getNumberOfComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).setRectangle(Mockito.<PDRectangle>any());
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    verify(annotation).getVertices();
    verify(pdBorderEffectDictionary).getIntensity();
    verify(pdBorderEffectDictionary).getStyle();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.5f, matrix.getTranslateY());
    assertEquals(0.5f, floatArray[1]);
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(11.0f, bBox.getUpperRightX());
    assertEquals(11.0f, bBox2.getUpperRightX());
    assertEquals(11.0f, bBox.getWidth());
    assertEquals(11.0f, bBox2.getWidth());
    assertEquals(2.0f, bBox.getHeight());
    assertEquals(2.0f, bBox2.getHeight());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(66, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(66, stream.getLength());
    assertEquals(66, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(66, contentStream.getLength());
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance18() throws IOException {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDColorSpace colorSpace2 = mock(PDColorSpace.class);
    when(colorSpace2.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor2 = new PDColor(new COSArray(), colorSpace2);

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("B");
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(colorSpace2).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    verify(annotation).getVertices();
    verify(pdBorderEffectDictionary).getStyle();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.5f, matrix.getTranslateY());
    assertEquals(0.5f, floatArray[1]);
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(11.0f, bBox.getUpperRightX());
    assertEquals(11.0f, bBox2.getUpperRightX());
    assertEquals(11.0f, bBox.getWidth());
    assertEquals(11.0f, bBox2.getWidth());
    assertEquals(2.0f, bBox.getHeight());
    assertEquals(2.0f, bBox2.getHeight());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(62, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(62, stream.getLength());
    assertEquals(62, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(62, contentStream.getLength());
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance19() throws IOException {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDColorSpace colorSpace2 = mock(PDColorSpace.class);
    when(colorSpace2.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor2 = new PDColor(new COSArray(), colorSpace2);

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getIntensity()).thenReturn(10.0f);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("C");
    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[]{1.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(colorSpace2).getNumberOfComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).setRectangle(Mockito.<PDRectangle>any());
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    verify(annotation).getVertices();
    verify(pdBorderEffectDictionary).getIntensity();
    verify(pdBorderEffectDictionary).getStyle();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.5f, matrix.getTranslateY());
    assertEquals(0.5f, floatArray[1]);
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(11.0f, bBox.getUpperRightX());
    assertEquals(11.0f, bBox2.getUpperRightX());
    assertEquals(11.0f, bBox.getWidth());
    assertEquals(11.0f, bBox2.getWidth());
    assertEquals(172, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(172, stream.getLength());
    assertEquals(172, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(172, contentStream.getLength());
    assertEquals(2.0f, bBox.getHeight());
    assertEquals(2.0f, bBox2.getHeight());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance20() throws IOException {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDColorSpace colorSpace2 = mock(PDColorSpace.class);
    when(colorSpace2.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor2 = new PDColor(new COSArray(), colorSpace2);

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getIntensity()).thenReturn(10.0f);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("C");
    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[]{10.0f, 0.5f, Float.NaN, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(colorSpace2).getNumberOfComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).setRectangle(Mockito.<PDRectangle>any());
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    verify(annotation).getVertices();
    verify(pdBorderEffectDictionary).getIntensity();
    verify(pdBorderEffectDictionary).getStyle();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-0.5f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-0.5f, bBox2.getLowerLeftY());
    assertEquals(0, cOSObject2.size());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(0.5f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(0.5f, floatArray[1]);
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(121, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(121, stream.getLength());
    assertEquals(121, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(121, contentStream.getLength());
    assertEquals(2.0f, bBox.getHeight());
    assertEquals(2.0f, bBox2.getHeight());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
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
    assertEquals(Float.NaN, bBox.getLowerLeftX());
    assertEquals(Float.NaN, bBox2.getLowerLeftX());
    assertEquals(Float.NaN, bBox.getUpperRightX());
    assertEquals(Float.NaN, bBox2.getUpperRightX());
    assertEquals(Float.NaN, bBox.getWidth());
    assertEquals(Float.NaN, bBox2.getWidth());
    assertEquals(Float.NaN, matrix.getTranslateX());
    assertEquals(Float.NaN, floatArray[0]);
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance21() throws IOException {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDColorSpace colorSpace2 = mock(PDColorSpace.class);
    when(colorSpace2.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor2 = new PDColor(new COSArray(), colorSpace2);

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getIntensity()).thenReturn(10.0f);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("C");
    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[]{});
    when(annotation.getPath()).thenReturn(null);
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(colorSpace2).getNumberOfComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).setRectangle(Mockito.<PDRectangle>any());
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    verify(annotation).getVertices();
    verify(pdBorderEffectDictionary).getIntensity();
    verify(pdBorderEffectDictionary).getStyle();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    assertEquals(-0.0f, matrix.getTranslateX());
    assertEquals(-0.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    assertEquals(-0.0f, floatArray[1]);
    assertEquals(0, cOSObject2.size());
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(0.0f, bBox.getLowerLeftX());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    assertEquals(1.0f, bBox.getHeight());
    assertEquals(1.0f, bBox2.getHeight());
    assertEquals(1.0f, bBox.getUpperRightX());
    assertEquals(1.0f, bBox2.getUpperRightX());
    assertEquals(1.0f, bBox.getUpperRightY());
    assertEquals(1.0f, bBox2.getUpperRightY());
    assertEquals(1.0f, bBox.getWidth());
    assertEquals(1.0f, bBox2.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(42, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(42, stream.getLength());
    assertEquals(42, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(42, contentStream.getLength());
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance22() throws IOException {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDColorSpace colorSpace2 = mock(PDColorSpace.class);
    when(colorSpace2.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor2 = new PDColor(new COSArray(), colorSpace2);

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getIntensity()).thenReturn(10.0f);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("C");
    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(
        new float[]{1.0f, Float.MAX_VALUE, 1.0f, Float.MAX_VALUE, 1.0f, Float.MAX_VALUE, 1.0f, Float.MAX_VALUE});
    when(annotation.getPath()).thenReturn(null);
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(colorSpace2).getNumberOfComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).setRectangle(Mockito.<PDRectangle>any());
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    verify(annotation).getVertices();
    verify(pdBorderEffectDictionary).getIntensity();
    verify(pdBorderEffectDictionary).getStyle();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
    FontBoxFont fontBoxFont = ((PDType1Font) defaultFont).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    GsubData gsubData = ((TrueTypeFont) fontBoxFont).getGsubData();
    assertTrue(gsubData instanceof MapBackedGsubData);
    PDRectangle bBox = appearanceStream.getBBox();
    COSArray cOSArray = bBox.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSFloat);
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
    assertEquals(-0.0f, matrix.getTranslateX());
    assertEquals(-0.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    assertEquals(-0.0f, floatArray[1]);
    assertEquals(0, cOSObject2.size());
    assertEquals(0.0f, bBox.getLowerLeftX());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    assertEquals(2.0f, bBox.getUpperRightX());
    assertEquals(2.0f, bBox2.getUpperRightX());
    assertEquals(2.0f, bBox.getWidth());
    assertEquals(2.0f, bBox2.getWidth());
    assertEquals(2.14748365E9f, bBox.getHeight());
    assertEquals(2.14748365E9f, bBox2.getHeight());
    assertEquals(2.14748365E9f, bBox.getUpperRightY());
    assertEquals(2.14748365E9f, bBox2.getUpperRightY());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(42, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(42, stream.getLength());
    assertEquals(42, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(42, contentStream.getLength());
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
    assertSame(pdRectangle, pdPolygonAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance23() throws IOException {
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
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDColorSpace colorSpace2 = mock(PDColorSpace.class);
    when(colorSpace2.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor2 = new PDColor(new COSArray(), colorSpace2);

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getIntensity()).thenReturn(10.0f);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("C");
    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(eq(9.0f));
    verify(pdRectangle).setLowerLeftY(eq(-0.5f));
    verify(pdRectangle).setUpperRightX(eq(11.0f));
    verify(pdRectangle).setUpperRightY(eq(10.0f));
    verify(colorSpace).getNumberOfComponents();
    verify(colorSpace2).getNumberOfComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).setRectangle(Mockito.<PDRectangle>any());
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    verify(annotation).getVertices();
    verify(pdBorderEffectDictionary).getIntensity();
    verify(pdBorderEffectDictionary).getStyle();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox2.getHeight());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox2.getLowerLeftX());
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
    assertEquals(42, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(42, stream.getLength());
    assertEquals(42, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(42, contentStream.getLength());
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
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance24() throws IOException {
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
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDColorSpace colorSpace2 = mock(PDColorSpace.class);
    when(colorSpace2.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor2 = new PDColor(new COSArray(), colorSpace2);

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getIntensity()).thenReturn(10.0f);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("C");
    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(eq(9.0f));
    verify(pdRectangle).setLowerLeftY(eq(-0.5f));
    verify(pdRectangle).setUpperRightX(eq(11.0f));
    verify(pdRectangle).setUpperRightY(eq(10.0f));
    verify(colorSpace).getNumberOfComponents();
    verify(colorSpace2).getNumberOfComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).setRectangle(Mockito.<PDRectangle>any());
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    verify(annotation).getVertices();
    verify(pdBorderEffectDictionary).getIntensity();
    verify(pdBorderEffectDictionary).getStyle();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
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
    assertEquals(42, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(42, stream.getLength());
    assertEquals(42, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(42, contentStream.getLength());
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
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test:
   * {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance25() throws IOException {
    // Arrange
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
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDColorSpace colorSpace2 = mock(PDColorSpace.class);
    when(colorSpace2.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor2 = new PDColor(new COSArray(), colorSpace2);

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getIntensity()).thenReturn(10.0f);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("C");
    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(eq(9.0f));
    verify(pdRectangle).setLowerLeftY(eq(-0.5f));
    verify(pdRectangle).setUpperRightX(eq(11.0f));
    verify(pdRectangle).setUpperRightY(eq(10.0f));
    verify(colorSpace).getNumberOfComponents();
    verify(colorSpace2).getNumberOfComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).setRectangle(Mockito.<PDRectangle>any());
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation).getBorderEffect();
    verify(annotation).getInteriorColor();
    verify(annotation).getPath();
    verify(annotation).getVertices();
    verify(pdBorderEffectDictionary).getIntensity();
    verify(pdBorderEffectDictionary).getStyle();
    PDAppearanceEntry downAppearance = pdPolygonAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDFont defaultFont = pdPolygonAppearanceHandler.getDefaultFont();
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
    assertEquals(42, appearanceStream.getStream().getLength());
    PDAppearanceEntry rolloverAppearance = pdPolygonAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDStream stream = appearanceStream2.getStream();
    assertEquals(42, stream.getLength());
    assertEquals(42, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(42, contentStream.getLength());
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
    assertSame(pdAppearanceDictionary, pdPolygonAppearanceHandler.getAppearance());
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
   * Method under test: {@link PDPolygonAppearanceHandler#getLineWidth()}
   */
  @Test
  void testGetLineWidth() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDPolygonAppearanceHandler(new PDAnnotationCaret())).getLineWidth());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PDPolygonAppearanceHandler#PDPolygonAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDPolygonAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDPolygonAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDPolygonAppearanceHandler actualPdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);
    actualPdPolygonAppearanceHandler.generateDownAppearance();
    actualPdPolygonAppearanceHandler.generateRolloverAppearance();

    // Assert that nothing has changed
    assertTrue(actualPdPolygonAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdPolygonAppearanceHandler.getAnnotation());
  }
}
