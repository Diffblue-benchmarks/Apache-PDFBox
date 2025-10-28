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
import java.util.List;
import java.util.Set;
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
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFileAttachment;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFileAttachmentAppearanceHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(new COSArray());
    doNothing().when(pdRectangle).setLowerLeftY(anyFloat());
    doNothing().when(pdRectangle).setUpperRightX(anyFloat());
    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    PDAnnotationFileAttachment annotation = mock(PDAnnotationFileAttachment.class);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDFileAttachmentAppearanceHandler pdFileAttachmentAppearanceHandler = new PDFileAttachmentAppearanceHandler(
        annotation);

    // Act
    pdFileAttachmentAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle).getLowerLeftY();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftY(eq(-8.0f));
    verify(pdRectangle).setUpperRightX(eq(28.0f));
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getConstantOpacity();
    PDAppearanceEntry downAppearance = pdFileAttachmentAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
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
    PDAppearanceEntry rolloverAppearance = pdFileAttachmentAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox2.getHeight());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    assertEquals(0.0f, bBox.getUpperRightX());
    assertEquals(0.0f, bBox2.getUpperRightX());
    assertEquals(0.0f, bBox.getUpperRightY());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bBox2.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertEquals(804, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(804, stream.getLength());
    assertEquals(804, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(804, contentStream.getLength());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertEquals(toListResult, bBox2.getCOSArray().toList());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(pdAppearanceDictionary, pdFileAttachmentAppearanceHandler.getAppearance());
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
   * {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance2() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(null);
    doNothing().when(pdRectangle).setLowerLeftY(anyFloat());
    doNothing().when(pdRectangle).setUpperRightX(anyFloat());
    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    PDAnnotationFileAttachment annotation = mock(PDAnnotationFileAttachment.class);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDFileAttachmentAppearanceHandler pdFileAttachmentAppearanceHandler = new PDFileAttachmentAppearanceHandler(
        annotation);

    // Act
    pdFileAttachmentAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle).getLowerLeftY();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftY(eq(-8.0f));
    verify(pdRectangle).setUpperRightX(eq(28.0f));
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getConstantOpacity();
    PDAppearanceEntry downAppearance = pdFileAttachmentAppearanceHandler.getDownAppearance();
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
    assertNull(appearanceStream.getBBox());
    PDAppearanceEntry rolloverAppearance = pdFileAttachmentAppearanceHandler.getRolloverAppearance();
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
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    assertEquals(804, appearanceStream.getStream().getLength());
    PDStream stream = appearanceStream2.getStream();
    assertEquals(804, stream.getLength());
    assertEquals(804, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(804, contentStream.getLength());
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
    assertSame(pdAppearanceDictionary, pdFileAttachmentAppearanceHandler.getAppearance());
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
   * {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  void testGenerateNormalAppearance3() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(false);
    when(cosArray.getKey()).thenReturn(new COSObjectKey(1L, 1));
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);
    doNothing().when(pdRectangle).setLowerLeftY(anyFloat());
    doNothing().when(pdRectangle).setUpperRightX(anyFloat());
    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    PDAnnotationFileAttachment annotation = mock(PDAnnotationFileAttachment.class);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDFileAttachmentAppearanceHandler pdFileAttachmentAppearanceHandler = new PDFileAttachmentAppearanceHandler(
        annotation);

    // Act
    pdFileAttachmentAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray, atLeast(1)).getKey();
    verify(cosArray).isDirect();
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle).getLowerLeftY();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftY(eq(-8.0f));
    verify(pdRectangle).setUpperRightX(eq(28.0f));
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getConstantOpacity();
    PDAppearanceEntry downAppearance = pdFileAttachmentAppearanceHandler.getDownAppearance();
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
    assertEquals(804, appearanceStream.getStream().getLength());
    PDAppearanceEntry rolloverAppearance = pdFileAttachmentAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
    PDStream stream = appearanceStream2.getStream();
    assertEquals(804, stream.getLength());
    assertEquals(804, appearanceStream.getContentStream().getLength());
    PDStream contentStream = appearanceStream2.getContentStream();
    assertEquals(804, contentStream.getLength());
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
    assertSame(pdAppearanceDictionary, pdFileAttachmentAppearanceHandler.getAppearance());
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
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PDFileAttachmentAppearanceHandler#PDFileAttachmentAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDFileAttachmentAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDFileAttachmentAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDFileAttachmentAppearanceHandler actualPdFileAttachmentAppearanceHandler = new PDFileAttachmentAppearanceHandler(
        annotation);
    actualPdFileAttachmentAppearanceHandler.generateDownAppearance();
    actualPdFileAttachmentAppearanceHandler.generateRolloverAppearance();

    // Assert that nothing has changed
    assertTrue(actualPdFileAttachmentAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdFileAttachmentAppearanceHandler.getAnnotation());
  }
}
