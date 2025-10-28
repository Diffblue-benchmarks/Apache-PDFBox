package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDImmutableRectangle;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDPattern;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLine;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDLineAppearanceHandlerDiffblueTest {
  /**
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getLeaderLineLength()).thenThrow(new IllegalArgumentException("S"));
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDLineAppearanceHandler(annotation)).generateNormalAppearance());
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLine();
    verify(annotation).getBorderStyle();
  }

  /**
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance2() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    COSArray array = new COSArray();
    when(annotation.getColor()).thenReturn(new PDColor(array, new PDPattern(new PDResources())));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getLine();
    verify(annotation).getBorderStyle();
    PDAppearanceEntry downAppearance = pdLineAppearanceHandler.getDownAppearance();
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceEntry rolloverAppearance = pdLineAppearanceHandler.getRolloverAppearance();
    COSDictionary cOSObject2 = rolloverAppearance.getCOSObject();
    assertTrue(cOSObject2 instanceof COSStream);
    PDRectangle rectangle = pdLineAppearanceHandler.getRectangle();
    assertTrue(rectangle instanceof PDImmutableRectangle);
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
    assertEquals(0.0f, rectangle.getLowerLeftX());
    assertEquals(0.0f, rectangle.getLowerLeftY());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(0.0f, floatArray[0]);
    assertEquals(0.0f, floatArray[1]);
    COSDictionary cOSObject3 = pdLineAppearanceHandler.getAppearance().getCOSObject();
    assertEquals(1, cOSObject3.getValues().size());
    assertEquals(1, cOSObject3.size());
    assertEquals(2383.937f, rectangle.getUpperRightX());
    assertEquals(2383.937f, rectangle.getWidth());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(3370.3938f, rectangle.getHeight());
    assertEquals(3370.3938f, rectangle.getUpperRightY());
    assertFalse(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(cOSObject2, stream.getCOSObject());
    assertSame(cOSObject2, contentStream.getCOSObject());
    assertSame(cOSObject2, appearanceStream2.getCOSObject());
  }

  /**
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance3() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getColor()).thenReturn(null);
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getLine();
    verify(annotation).getBorderStyle();
    PDAppearanceEntry downAppearance = pdLineAppearanceHandler.getDownAppearance();
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceEntry rolloverAppearance = pdLineAppearanceHandler.getRolloverAppearance();
    COSDictionary cOSObject2 = rolloverAppearance.getCOSObject();
    assertTrue(cOSObject2 instanceof COSStream);
    PDRectangle rectangle = pdLineAppearanceHandler.getRectangle();
    assertTrue(rectangle instanceof PDImmutableRectangle);
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
    assertEquals(0.0f, rectangle.getLowerLeftX());
    assertEquals(0.0f, rectangle.getLowerLeftY());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(0.0f, floatArray[0]);
    assertEquals(0.0f, floatArray[1]);
    COSDictionary cOSObject3 = pdLineAppearanceHandler.getAppearance().getCOSObject();
    assertEquals(1, cOSObject3.getValues().size());
    assertEquals(1, cOSObject3.size());
    assertEquals(2383.937f, rectangle.getUpperRightX());
    assertEquals(2383.937f, rectangle.getWidth());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(3370.3938f, rectangle.getHeight());
    assertEquals(3370.3938f, rectangle.getUpperRightY());
    assertFalse(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(cOSObject2, stream.getCOSObject());
    assertSame(cOSObject2, contentStream.getCOSObject());
    assertSame(cOSObject2, appearanceStream2.getCOSObject());
  }

  /**
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance4() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getLine()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert that nothing has changed
    verify(annotation).getRectangle();
    verify(annotation).getLine();
    PDAppearanceEntry downAppearance = pdLineAppearanceHandler.getDownAppearance();
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceEntry rolloverAppearance = pdLineAppearanceHandler.getRolloverAppearance();
    COSDictionary cOSObject2 = rolloverAppearance.getCOSObject();
    assertTrue(cOSObject2 instanceof COSStream);
    PDRectangle rectangle = pdLineAppearanceHandler.getRectangle();
    assertTrue(rectangle instanceof PDImmutableRectangle);
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    assertEquals(0, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDStream stream = appearanceStream2.getStream();
    assertEquals(0, stream.getLength());
    assertEquals(0, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(0, contentStream.getLength());
    assertEquals(0.0f, rectangle.getLowerLeftX());
    assertEquals(0.0f, rectangle.getLowerLeftY());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(0.0f, floatArray[0]);
    assertEquals(0.0f, floatArray[1]);
    COSDictionary cOSObject3 = pdLineAppearanceHandler.getAppearance().getCOSObject();
    assertEquals(1, cOSObject3.getValues().size());
    assertEquals(1, cOSObject3.size());
    assertEquals(2383.937f, rectangle.getUpperRightX());
    assertEquals(2383.937f, rectangle.getWidth());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(3370.3938f, rectangle.getHeight());
    assertEquals(3370.3938f, rectangle.getUpperRightY());
    assertFalse(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(cOSObject2, stream.getCOSObject());
    assertSame(cOSObject2, contentStream.getCOSObject());
    assertSame(cOSObject2, appearanceStream2.getCOSObject());
  }

  /**
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance5() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdLineAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> fontNames = resources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(resources.getResourceCache());
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-100.0f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdLineAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-100.0f, bBox2.getLowerLeftY());
    assertEquals(-90.0f, bBox.getLowerLeftX());
    assertEquals(-90.0f, bBox2.getLowerLeftX());
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject2.size());
    assertEquals(100.0f, bBox.getUpperRightY());
    assertEquals(100.0f, bBox2.getUpperRightY());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(100.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(100.0f, floatArray[1]);
    assertEquals(110.0f, bBox.getUpperRightX());
    assertEquals(110.0f, bBox2.getUpperRightX());
    assertEquals(183, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(183, stream.getLength());
    assertEquals(183, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(183, contentStream.getLength());
    assertEquals(200.0f, bBox.getHeight());
    assertEquals(200.0f, bBox2.getHeight());
    assertEquals(200.0f, bBox.getWidth());
    assertEquals(200.0f, bBox2.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(90.0f, matrix.getTranslateX());
    assertEquals(90.0f, floatArray[0]);
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdRectangle, pdLineAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdLineAppearanceHandler.getAppearance());
    PDResources resources2 = appearanceStream2.getResources();
    assertSame(cOSObject2, resources2.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(fontNames, resources2.getFontNames());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance6() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenThrow(new IllegalArgumentException("D"));
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDLineAppearanceHandler(annotation)).generateNormalAppearance());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getEndPointEndingStyle();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance7() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(Float.MAX_VALUE);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdLineAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> fontNames = resources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(resources.getResourceCache());
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-100.0f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdLineAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-100.0f, bBox2.getLowerLeftY());
    assertEquals(-90.0f, bBox.getLowerLeftX());
    assertEquals(-90.0f, bBox2.getLowerLeftX());
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject2.size());
    assertEquals(100.0f, bBox.getUpperRightY());
    assertEquals(100.0f, bBox2.getUpperRightY());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(100.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(100.0f, floatArray[1]);
    assertEquals(110.0f, bBox.getUpperRightX());
    assertEquals(110.0f, bBox2.getUpperRightX());
    assertEquals(200.0f, bBox.getHeight());
    assertEquals(200.0f, bBox2.getHeight());
    assertEquals(200.0f, bBox.getWidth());
    assertEquals(200.0f, bBox2.getWidth());
    assertEquals(216, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(216, stream.getLength());
    assertEquals(216, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(216, contentStream.getLength());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(90.0f, matrix.getTranslateX());
    assertEquals(90.0f, floatArray[0]);
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdRectangle, pdLineAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdLineAppearanceHandler.getAppearance());
    PDResources resources2 = appearanceStream2.getResources();
    assertSame(cOSObject2, resources2.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(fontNames, resources2.getFontNames());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance8() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(0.0f);
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdLineAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> fontNames = resources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(resources.getResourceCache());
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-100.0f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdLineAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-100.0f, bBox2.getLowerLeftY());
    assertEquals(-90.0f, bBox.getLowerLeftX());
    assertEquals(-90.0f, bBox2.getLowerLeftX());
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject2.size());
    assertEquals(100.0f, bBox.getUpperRightY());
    assertEquals(100.0f, bBox2.getUpperRightY());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(100.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(100.0f, floatArray[1]);
    assertEquals(110.0f, bBox.getUpperRightX());
    assertEquals(110.0f, bBox2.getUpperRightX());
    assertEquals(167, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(167, stream.getLength());
    assertEquals(167, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(167, contentStream.getLength());
    assertEquals(200.0f, bBox.getHeight());
    assertEquals(200.0f, bBox2.getHeight());
    assertEquals(200.0f, bBox.getWidth());
    assertEquals(200.0f, bBox2.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(90.0f, matrix.getTranslateX());
    assertEquals(90.0f, floatArray[0]);
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdRectangle, pdLineAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdLineAppearanceHandler.getAppearance());
    PDResources resources2 = appearanceStream2.getResources();
    assertSame(cOSObject2, resources2.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(fontNames, resources2.getFontNames());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance9() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceRGB.INSTANCE));
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdLineAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> fontNames = resources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(resources.getResourceCache());
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-100.0f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdLineAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-100.0f, bBox2.getLowerLeftY());
    assertEquals(-90.0f, bBox.getLowerLeftX());
    assertEquals(-90.0f, bBox2.getLowerLeftX());
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject2.size());
    assertEquals(100.0f, bBox.getUpperRightY());
    assertEquals(100.0f, bBox2.getUpperRightY());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(100.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(100.0f, floatArray[1]);
    assertEquals(110.0f, bBox.getUpperRightX());
    assertEquals(110.0f, bBox2.getUpperRightX());
    assertEquals(188, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(188, stream.getLength());
    assertEquals(188, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(188, contentStream.getLength());
    assertEquals(200.0f, bBox.getHeight());
    assertEquals(200.0f, bBox2.getHeight());
    assertEquals(200.0f, bBox.getWidth());
    assertEquals(200.0f, bBox2.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(90.0f, matrix.getTranslateX());
    assertEquals(90.0f, floatArray[0]);
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdRectangle, pdLineAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdLineAppearanceHandler.getAppearance());
    PDResources resources2 = appearanceStream2.getResources();
    assertSame(cOSObject2, resources2.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(fontNames, resources2.getFontNames());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance10() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    COSArray array = new COSArray();
    when(annotation.getInteriorColor()).thenReturn(new PDColor(array, new PDPattern(new PDResources())));
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdLineAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> fontNames = resources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(resources.getResourceCache());
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-100.0f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdLineAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-100.0f, bBox2.getLowerLeftY());
    assertEquals(-90.0f, bBox.getLowerLeftX());
    assertEquals(-90.0f, bBox2.getLowerLeftX());
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject2.size());
    assertEquals(100.0f, bBox.getUpperRightY());
    assertEquals(100.0f, bBox2.getUpperRightY());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(100.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(100.0f, floatArray[1]);
    assertEquals(110.0f, bBox.getUpperRightX());
    assertEquals(110.0f, bBox2.getUpperRightX());
    assertEquals(179, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(179, stream.getLength());
    assertEquals(179, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(179, contentStream.getLength());
    assertEquals(200.0f, bBox.getHeight());
    assertEquals(200.0f, bBox2.getHeight());
    assertEquals(200.0f, bBox.getWidth());
    assertEquals(200.0f, bBox2.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(90.0f, matrix.getTranslateX());
    assertEquals(90.0f, floatArray[0]);
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdRectangle, pdLineAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdLineAppearanceHandler.getAppearance());
    PDResources resources2 = appearanceStream2.getResources();
    assertSame(cOSObject2, resources2.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(fontNames, resources2.getFontNames());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance11() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdLineAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> fontNames = resources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(resources.getResourceCache());
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-100.0f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdLineAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-100.0f, bBox2.getLowerLeftY());
    assertEquals(-90.0f, bBox.getLowerLeftX());
    assertEquals(-90.0f, bBox2.getLowerLeftX());
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject2.size());
    assertEquals(100.0f, bBox.getUpperRightY());
    assertEquals(100.0f, bBox2.getUpperRightY());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(100.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(100.0f, floatArray[1]);
    assertEquals(110.0f, bBox.getUpperRightX());
    assertEquals(110.0f, bBox2.getUpperRightX());
    assertEquals(199, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(199, stream.getLength());
    assertEquals(199, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(199, contentStream.getLength());
    assertEquals(200.0f, bBox.getHeight());
    assertEquals(200.0f, bBox2.getHeight());
    assertEquals(200.0f, bBox.getWidth());
    assertEquals(200.0f, bBox2.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(90.0f, matrix.getTranslateX());
    assertEquals(90.0f, floatArray[0]);
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdRectangle, pdLineAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdLineAppearanceHandler.getAppearance());
    PDResources resources2 = appearanceStream2.getResources();
    assertSame(cOSObject2, resources2.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(fontNames, resources2.getFontNames());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance12() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(null);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdLineAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> fontNames = resources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(resources.getResourceCache());
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-100.0f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdLineAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-100.0f, bBox2.getLowerLeftY());
    assertEquals(-90.0f, bBox.getLowerLeftX());
    assertEquals(-90.0f, bBox2.getLowerLeftX());
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(1, cOSObject2.size());
    assertEquals(100.0f, bBox.getUpperRightY());
    assertEquals(100.0f, bBox2.getUpperRightY());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(100.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(100.0f, floatArray[1]);
    assertEquals(110.0f, bBox.getUpperRightX());
    assertEquals(110.0f, bBox2.getUpperRightX());
    assertEquals(179, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(179, stream.getLength());
    assertEquals(179, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(179, contentStream.getLength());
    assertEquals(200.0f, bBox.getHeight());
    assertEquals(200.0f, bBox2.getHeight());
    assertEquals(200.0f, bBox.getWidth());
    assertEquals(200.0f, bBox2.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(90.0f, matrix.getTranslateX());
    assertEquals(90.0f, floatArray[0]);
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdRectangle, pdLineAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdLineAppearanceHandler.getAppearance());
    PDResources resources2 = appearanceStream2.getResources();
    assertSame(cOSObject2, resources2.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(fontNames, resources2.getFontNames());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance13() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), colorSpace));
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(false);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdLineAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(resources.getResourceCache());
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-100.0f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdLineAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-100.0f, bBox2.getLowerLeftY());
    assertEquals(-90.0f, bBox.getLowerLeftX());
    assertEquals(-90.0f, bBox2.getLowerLeftX());
    assertEquals(0, cOSObject2.size());
    assertEquals(100.0f, bBox.getUpperRightY());
    assertEquals(100.0f, bBox2.getUpperRightY());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(100.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(100.0f, floatArray[1]);
    assertEquals(110.0f, bBox.getUpperRightX());
    assertEquals(110.0f, bBox2.getUpperRightX());
    assertEquals(200.0f, bBox.getHeight());
    assertEquals(200.0f, bBox2.getHeight());
    assertEquals(200.0f, bBox.getWidth());
    assertEquals(200.0f, bBox2.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(90.0f, matrix.getTranslateX());
    assertEquals(90.0f, floatArray[0]);
    assertEquals(97, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(97, stream.getLength());
    assertEquals(97, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(97, contentStream.getLength());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdRectangle, pdLineAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdLineAppearanceHandler.getAppearance());
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
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance14() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(Float.MIN_VALUE);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdLineAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = resources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    Iterable<COSName> fontNames = resources.getFontNames();
    assertTrue(fontNames instanceof Set);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(resources.getResourceCache());
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-100.0f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdLineAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-100.0f, bBox2.getLowerLeftY());
    assertEquals(-90.0f, bBox.getLowerLeftX());
    assertEquals(-90.0f, bBox2.getLowerLeftX());
    assertEquals(1, ((Set<COSName>) extGStateNames).size());
    assertEquals(1, ((Set<COSName>) fontNames).size());
    assertEquals(100.0f, bBox.getUpperRightY());
    assertEquals(100.0f, bBox2.getUpperRightY());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(100.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(100.0f, floatArray[1]);
    assertEquals(110.0f, bBox.getUpperRightX());
    assertEquals(110.0f, bBox2.getUpperRightX());
    assertEquals(2, cOSObject2.getValues().size());
    assertEquals(2, cOSObject2.size());
    assertEquals(200.0f, bBox.getHeight());
    assertEquals(200.0f, bBox2.getHeight());
    assertEquals(200.0f, bBox.getWidth());
    assertEquals(200.0f, bBox2.getWidth());
    assertEquals(207, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(207, stream.getLength());
    assertEquals(207, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(207, contentStream.getLength());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(90.0f, matrix.getTranslateX());
    assertEquals(90.0f, floatArray[0]);
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdRectangle, pdLineAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdLineAppearanceHandler.getAppearance());
    PDResources resources2 = appearanceStream2.getResources();
    assertSame(cOSObject2, resources2.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(extGStateNames, resources2.getExtGStateNames());
    assertSame(fontNames, resources2.getFontNames());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream2.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance15() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), colorSpace));
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn(null);
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdLineAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    assertNull(resources.getResourceCache());
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-100.0f, bBox.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = pdLineAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(-100.0f, bBox2.getLowerLeftY());
    assertEquals(-90.0f, bBox.getLowerLeftX());
    assertEquals(-90.0f, bBox2.getLowerLeftX());
    assertEquals(0, cOSObject2.size());
    assertEquals(100.0f, bBox.getUpperRightY());
    assertEquals(100.0f, bBox2.getUpperRightY());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(100.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(100.0f, floatArray[1]);
    assertEquals(110.0f, bBox.getUpperRightX());
    assertEquals(110.0f, bBox2.getUpperRightX());
    assertEquals(200.0f, bBox.getHeight());
    assertEquals(200.0f, bBox2.getHeight());
    assertEquals(200.0f, bBox.getWidth());
    assertEquals(200.0f, bBox2.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(90.0f, matrix.getTranslateX());
    assertEquals(90.0f, floatArray[0]);
    assertEquals(97, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(97, stream.getLength());
    assertEquals(97, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(97, contentStream.getLength());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdRectangle, pdLineAppearanceHandler.getRectangle());
    assertSame(pdAppearanceDictionary, pdLineAppearanceHandler.getAppearance());
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
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance16() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdLineAppearanceHandler.getDownAppearance();
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceEntry rolloverAppearance = pdLineAppearanceHandler.getRolloverAppearance();
    COSDictionary cOSObject2 = rolloverAppearance.getCOSObject();
    assertTrue(cOSObject2 instanceof COSStream);
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
    COSDictionary cOSObject3 = pdLineAppearanceHandler.getAppearance().getCOSObject();
    assertEquals(1, cOSObject3.getValues().size());
    assertEquals(1, cOSObject3.size());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertFalse(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(pdRectangle, pdLineAppearanceHandler.getRectangle());
    assertSame(cOSObject2, stream.getCOSObject());
    assertSame(cOSObject2, contentStream.getCOSObject());
    assertSame(cOSObject2, appearanceStream2.getCOSObject());
  }

  /**
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance17() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    assertSame(pdRectangle, pdLineAppearanceHandler.getRectangle());
  }

  /**
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance18() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(new COSStream()));
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    assertSame(pdRectangle, pdLineAppearanceHandler.getRectangle());
  }

  /**
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance19() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    assertSame(pdRectangle, pdLineAppearanceHandler.getRectangle());
  }

  /**
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance20() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    assertSame(pdRectangle, pdLineAppearanceHandler.getRectangle());
  }

  /**
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance21() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(Float.MIN_VALUE);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    PDRectangle pdRectangle = new PDRectangle();
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    assertSame(pdRectangle, pdLineAppearanceHandler.getRectangle());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDLineAppearanceHandler#PDLineAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDLineAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDLineAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDLineAppearanceHandler actualPdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);
    actualPdLineAppearanceHandler.generateDownAppearance();
    actualPdLineAppearanceHandler.generateRolloverAppearance();

    // Assert that nothing has changed
    assertTrue(actualPdLineAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdLineAppearanceHandler.getAnnotation());
  }
}
