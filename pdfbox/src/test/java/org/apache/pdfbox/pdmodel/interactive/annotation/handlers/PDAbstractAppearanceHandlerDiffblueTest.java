package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import java.awt.geom.AffineTransform;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDAppearanceContentStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquareCircle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAbstractAppearanceHandlerDiffblueTest {
  /**
   * Method under test: {@link PDAbstractAppearanceHandler#getAnnotation()}
   */
  @Test
  void testGetAnnotation() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act and Assert
    assertSame(annotation, (new PDCaretAppearanceHandler(annotation)).getAnnotation());
  }

  /**
   * Method under test: {@link PDAbstractAppearanceHandler#getAnnotation()}
   */
  @Test
  void testGetAnnotation2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDAnnotation actualAnnotation = (new PDCaretAppearanceHandler(annotation, document)).getAnnotation();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(annotation, actualAnnotation);
  }

  /**
   * Method under test: {@link PDAbstractAppearanceHandler#getColor()}
   */
  @Test
  void testGetColor() {
    // Arrange, Act and Assert
    assertNull((new PDCaretAppearanceHandler(new PDAnnotationCaret())).getColor());
  }

  /**
   * Method under test: {@link PDAbstractAppearanceHandler#getRectangle()}
   */
  @Test
  void testGetRectangle() {
    // Arrange, Act and Assert
    assertNull((new PDCaretAppearanceHandler(new PDAnnotationCaret())).getRectangle());
  }

  /**
   * Method under test: {@link PDAbstractAppearanceHandler#getRectangle()}
   */
  @Test
  void testGetRectangle2() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);

    // Act
    PDRectangle actualRectangle = (new PDCaretAppearanceHandler(annotation)).getRectangle();

    // Assert
    COSArray cOSArray = actualRectangle.getCOSArray();
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
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualRectangle.getLowerLeftX());
    assertEquals(0.0f, actualRectangle.getLowerLeftY());
    assertEquals(2383.937f, actualRectangle.getUpperRightX());
    assertEquals(2383.937f, actualRectangle.getWidth());
    assertEquals(3370.3938f, actualRectangle.getHeight());
    assertEquals(3370.3938f, actualRectangle.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualRectangle.getCOSObject());
  }

  /**
   * Method under test: {@link PDAbstractAppearanceHandler#getRectangle()}
   */
  @Test
  void testGetRectangle3() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualRectangle = (new PDCaretAppearanceHandler(annotation)).getRectangle();

    // Assert
    COSArray cOSArray = actualRectangle.getCOSArray();
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
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualRectangle.getHeight());
    assertEquals(0.0f, actualRectangle.getWidth());
    assertEquals(2.14748365E9f, actualRectangle.getLowerLeftX());
    assertEquals(2.14748365E9f, actualRectangle.getLowerLeftY());
    assertEquals(2.14748365E9f, actualRectangle.getUpperRightX());
    assertEquals(2.14748365E9f, actualRectangle.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualRectangle.getCOSObject());
  }

  /**
   * Method under test: {@link PDAbstractAppearanceHandler#createCOSStream()}
   */
  @Test
  void testCreateCOSStream() {
    // Arrange and Act
    COSStream actualCreateCOSStreamResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret())).createCOSStream();

    // Assert
    assertNull(actualCreateCOSStreamResult.getFilters());
    COSUpdateState updateState = actualCreateCOSStreamResult.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCreateCOSStreamResult.getKey());
    assertEquals(0L, actualCreateCOSStreamResult.getLength());
    assertEquals(1, actualCreateCOSStreamResult.getValues().size());
    assertEquals(1, actualCreateCOSStreamResult.size());
    COSIncrement toIncrementResult = actualCreateCOSStreamResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCreateCOSStreamResult.isDirect());
    assertFalse(actualCreateCOSStreamResult.hasData());
    assertFalse(actualCreateCOSStreamResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDAbstractAppearanceHandler#createCOSStream()}
   */
  @Test
  void testCreateCOSStream2() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    COSStream actualCreateCOSStreamResult = (new PDCaretAppearanceHandler(annotation, new PDDocument()))
        .createCOSStream();

    // Assert
    assertNull(actualCreateCOSStreamResult.getFilters());
    COSUpdateState updateState = actualCreateCOSStreamResult.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCreateCOSStreamResult.getKey());
    assertEquals(0L, actualCreateCOSStreamResult.getLength());
    assertEquals(1, actualCreateCOSStreamResult.getValues().size());
    assertEquals(1, actualCreateCOSStreamResult.size());
    COSIncrement toIncrementResult = actualCreateCOSStreamResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCreateCOSStreamResult.isDirect());
    assertFalse(actualCreateCOSStreamResult.hasData());
    assertFalse(actualCreateCOSStreamResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDAbstractAppearanceHandler#createCOSStream()}
   */
  @Test
  void testCreateCOSStream3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    COSStream actualCreateCOSStreamResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret(), document))
        .createCOSStream();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualCreateCOSStreamResult.getFilters());
    COSUpdateState updateState = actualCreateCOSStreamResult.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCreateCOSStreamResult.getKey());
    assertEquals(0L, actualCreateCOSStreamResult.getLength());
    assertEquals(1, actualCreateCOSStreamResult.getValues().size());
    assertEquals(1, actualCreateCOSStreamResult.size());
    COSIncrement toIncrementResult = actualCreateCOSStreamResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCreateCOSStreamResult.isDirect());
    assertFalse(actualCreateCOSStreamResult.hasData());
    assertFalse(actualCreateCOSStreamResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}
   */
  @Test
  void testGetNormalAppearanceAsContentStream() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    PDAppearanceContentStream actualNormalAppearanceAsContentStream = pdCaretAppearanceHandler
        .getNormalAppearanceAsContentStream();

    // Assert
    PDAppearanceEntry downAppearance = pdCaretAppearanceHandler.getDownAppearance();
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
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    PDResources resources2 = appearanceStream2.getResources();
    assertNull(resources2.getResourceCache());
    assertNull(resources.getResourceCache());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    assertEquals(-0.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    assertEquals(-0.0f, floatArray[1]);
    assertEquals(0, cOSObject2.size());
    PDRectangle bBox = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    COSDictionary cOSObject3 = appearance.getCOSObject();
    assertEquals(1, cOSObject3.getValues().size());
    assertEquals(1, cOSObject3.size());
    assertEquals(2383.937f, bBox.getUpperRightX());
    assertEquals(2383.937f, bBox2.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    assertEquals(2383.937f, bBox2.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox2.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    assertEquals(3370.3938f, bBox2.getUpperRightY());
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertFalse(cOSObject2.toIncrement().iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualNormalAppearanceAsContentStream.setNonStrokingColorOnDemand(null));
    assertFalse(actualNormalAppearanceAsContentStream.setStrokingColorOnDemand(null));
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(annotation, pdCaretAppearanceHandler.getAnnotation());
    assertSame(cOSObject2, resources2.getCOSObject());
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    PDAppearanceStream appearanceStream3 = normalAppearance.getAppearanceStream();
    PDResources resources3 = appearanceStream3.getResources();
    assertSame(cOSObject2, resources3.getCOSObject());
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    PDAppearanceStream appearanceStream4 = rolloverAppearance.getAppearanceStream();
    PDResources resources4 = appearanceStream4.getResources();
    assertSame(cOSObject2, resources4.getCOSObject());
    PDAppearanceEntry rolloverAppearance2 = pdCaretAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream5 = rolloverAppearance2.getAppearanceStream();
    PDResources resources5 = appearanceStream5.getResources();
    assertSame(cOSObject2, resources5.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    COSArray expectedCOSObject2 = bBox2.getCOSArray();
    assertSame(expectedCOSObject2, bBox2.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources3.getColorSpaceNames());
    assertSame(colorSpaceNames, resources4.getColorSpaceNames());
    assertSame(colorSpaceNames, resources5.getColorSpaceNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources3.getExtGStateNames());
    assertSame(colorSpaceNames, resources4.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources5.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getFontNames());
    assertSame(colorSpaceNames, resources3.getFontNames());
    assertSame(colorSpaceNames, resources4.getFontNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources5.getFontNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources3.getPatternNames());
    assertSame(colorSpaceNames, resources4.getPatternNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources5.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources3.getPropertiesNames());
    assertSame(colorSpaceNames, resources4.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources5.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources3.getShadingNames());
    assertSame(colorSpaceNames, resources4.getShadingNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources5.getShadingNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(colorSpaceNames, resources3.getXObjectNames());
    assertSame(colorSpaceNames, resources4.getXObjectNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources5.getXObjectNames());
    assertSame(cOSObject, appearanceStream3.getStream().getCOSObject());
    assertSame(cOSObject, appearanceStream4.getStream().getCOSObject());
    assertSame(cOSObject, appearanceStream5.getStream().getCOSObject());
    assertSame(cOSObject, appearanceStream3.getContentStream().getCOSObject());
    assertSame(cOSObject, appearanceStream4.getContentStream().getCOSObject());
    assertSame(cOSObject, appearanceStream5.getContentStream().getCOSObject());
    assertSame(cOSObject, appearanceStream3.getCOSObject());
    assertSame(cOSObject, appearanceStream4.getCOSObject());
    assertSame(cOSObject, appearanceStream5.getCOSObject());
    assertSame(cOSObject, normalAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance2.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)}
   */
  @Test
  void testGetNormalAppearanceAsContentStream2() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    PDAppearanceContentStream actualNormalAppearanceAsContentStream = pdCaretAppearanceHandler
        .getNormalAppearanceAsContentStream(true);

    // Assert
    PDAppearanceEntry downAppearance = pdCaretAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    COSBase filters = ((COSStream) cOSObject).getFilters();
    assertTrue(filters instanceof COSName);
    assertTrue(cOSObject instanceof COSStream);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(filters.getKey());
    assertNull(cOSObject2.getKey());
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    PDResources resources2 = appearanceStream2.getResources();
    assertNull(resources2.getResourceCache());
    assertNull(resources.getResourceCache());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    assertEquals(-0.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    assertEquals(-0.0f, floatArray[1]);
    assertEquals(0, cOSObject2.size());
    PDRectangle bBox = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    COSDictionary cOSObject3 = appearance.getCOSObject();
    assertEquals(1, cOSObject3.getValues().size());
    List<COSName> filters2 = appearanceStream2.getStream().getFilters();
    assertEquals(1, filters2.size());
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    PDAppearanceStream appearanceStream3 = normalAppearance.getAppearanceStream();
    PDStream stream = appearanceStream3.getStream();
    List<COSName> filters3 = stream.getFilters();
    assertEquals(1, filters3.size());
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    PDAppearanceStream appearanceStream4 = rolloverAppearance.getAppearanceStream();
    PDStream stream2 = appearanceStream4.getStream();
    List<COSName> filters4 = stream2.getFilters();
    assertEquals(1, filters4.size());
    List<COSName> filters5 = appearanceStream.getStream().getFilters();
    assertEquals(1, filters5.size());
    PDAppearanceEntry rolloverAppearance2 = pdCaretAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream5 = rolloverAppearance2.getAppearanceStream();
    PDStream stream3 = appearanceStream5.getStream();
    List<COSName> filters6 = stream3.getFilters();
    assertEquals(1, filters6.size());
    List<COSName> filters7 = appearanceStream2.getContentStream().getFilters();
    assertEquals(1, filters7.size());
    PDStream contentStream = appearanceStream3.getContentStream();
    List<COSName> filters8 = contentStream.getFilters();
    assertEquals(1, filters8.size());
    PDStream contentStream2 = appearanceStream4.getContentStream();
    List<COSName> filters9 = contentStream2.getFilters();
    assertEquals(1, filters9.size());
    List<COSName> filters10 = appearanceStream.getContentStream().getFilters();
    assertEquals(1, filters10.size());
    PDStream contentStream3 = appearanceStream5.getContentStream();
    List<COSName> filters11 = contentStream3.getFilters();
    assertEquals(1, filters11.size());
    assertEquals(1, cOSObject3.size());
    assertEquals(2383.937f, bBox.getUpperRightX());
    assertEquals(2383.937f, bBox2.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    assertEquals(2383.937f, bBox2.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox2.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    assertEquals(3370.3938f, bBox2.getUpperRightY());
    assertEquals(7, cOSObject.getValues().size());
    assertEquals(7, cOSObject.size());
    assertFalse(cOSObject2.toIncrement().iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(((COSName) filters).isEmpty());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualNormalAppearanceAsContentStream.setNonStrokingColorOnDemand(null));
    assertFalse(actualNormalAppearanceAsContentStream.setStrokingColorOnDemand(null));
    assertTrue(cOSObject2.getValues().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(filters.isDirect());
    assertTrue(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(annotation, pdCaretAppearanceHandler.getAnnotation());
    assertSame(cOSObject2, resources2.getCOSObject());
    PDResources resources3 = appearanceStream3.getResources();
    assertSame(cOSObject2, resources3.getCOSObject());
    PDResources resources4 = appearanceStream4.getResources();
    assertSame(cOSObject2, resources4.getCOSObject());
    PDResources resources5 = appearanceStream5.getResources();
    assertSame(cOSObject2, resources5.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    COSArray expectedCOSObject2 = bBox2.getCOSArray();
    assertSame(expectedCOSObject2, bBox2.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources3.getColorSpaceNames());
    assertSame(colorSpaceNames, resources4.getColorSpaceNames());
    assertSame(colorSpaceNames, resources5.getColorSpaceNames());
    assertSame(colorSpaceNames, resources2.getExtGStateNames());
    assertSame(colorSpaceNames, resources3.getExtGStateNames());
    assertSame(colorSpaceNames, resources4.getExtGStateNames());
    assertSame(colorSpaceNames, resources.getExtGStateNames());
    assertSame(colorSpaceNames, resources5.getExtGStateNames());
    assertSame(colorSpaceNames, resources2.getFontNames());
    assertSame(colorSpaceNames, resources3.getFontNames());
    assertSame(colorSpaceNames, resources4.getFontNames());
    assertSame(colorSpaceNames, resources.getFontNames());
    assertSame(colorSpaceNames, resources5.getFontNames());
    assertSame(colorSpaceNames, resources2.getPatternNames());
    assertSame(colorSpaceNames, resources3.getPatternNames());
    assertSame(colorSpaceNames, resources4.getPatternNames());
    assertSame(colorSpaceNames, resources.getPatternNames());
    assertSame(colorSpaceNames, resources5.getPatternNames());
    assertSame(colorSpaceNames, resources2.getPropertiesNames());
    assertSame(colorSpaceNames, resources3.getPropertiesNames());
    assertSame(colorSpaceNames, resources4.getPropertiesNames());
    assertSame(colorSpaceNames, resources.getPropertiesNames());
    assertSame(colorSpaceNames, resources5.getPropertiesNames());
    assertSame(colorSpaceNames, resources2.getShadingNames());
    assertSame(colorSpaceNames, resources3.getShadingNames());
    assertSame(colorSpaceNames, resources4.getShadingNames());
    assertSame(colorSpaceNames, resources.getShadingNames());
    assertSame(colorSpaceNames, resources5.getShadingNames());
    assertSame(colorSpaceNames, resources2.getXObjectNames());
    assertSame(colorSpaceNames, resources3.getXObjectNames());
    assertSame(colorSpaceNames, resources4.getXObjectNames());
    assertSame(colorSpaceNames, resources.getXObjectNames());
    assertSame(colorSpaceNames, resources5.getXObjectNames());
    assertSame(filters, filters2.get(0));
    assertSame(filters, filters3.get(0));
    assertSame(filters, filters4.get(0));
    assertSame(filters, filters5.get(0));
    assertSame(filters, filters6.get(0));
    assertSame(filters, filters7.get(0));
    assertSame(filters, filters8.get(0));
    assertSame(filters, filters9.get(0));
    assertSame(filters, filters10.get(0));
    assertSame(filters, filters11.get(0));
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, stream2.getCOSObject());
    assertSame(cOSObject, stream3.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, contentStream2.getCOSObject());
    assertSame(cOSObject, contentStream3.getCOSObject());
    assertSame(cOSObject, appearanceStream3.getCOSObject());
    assertSame(cOSObject, appearanceStream4.getCOSObject());
    assertSame(cOSObject, appearanceStream5.getCOSObject());
    assertSame(cOSObject, normalAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance2.getCOSObject());
  }

  /**
   * Method under test: {@link PDAbstractAppearanceHandler#getDownAppearance()}
   */
  @Test
  void testGetDownAppearance() throws IOException {
    // Arrange and Act
    PDAppearanceEntry actualDownAppearance = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .getDownAppearance();

    // Assert
    COSDictionary cOSObject = actualDownAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceStream appearanceStream = actualDownAppearance.getAppearanceStream();
    PDStream stream = appearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDStream contentStream = appearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(((COSStream) cOSObject).getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(appearanceStream.getResources());
    assertNull(stream.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(appearanceStream.getBBox());
    assertNull(stream.getFile());
    assertNull(contentStream.getFile());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream.getGroup());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(0, stream.getLength());
    assertEquals(0, contentStream.getLength());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(0L, ((COSStream) cOSObject).getLength());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSStream) cOSObject).hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualDownAppearance.isSubDictionary());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualDownAppearance.isStream());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDAbstractAppearanceHandler#getDownAppearance()}
   */
  @Test
  void testGetDownAppearance2() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDAppearanceEntry actualDownAppearance = (new PDCaretAppearanceHandler(annotation, new PDDocument()))
        .getDownAppearance();

    // Assert
    COSDictionary cOSObject = actualDownAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceStream appearanceStream = actualDownAppearance.getAppearanceStream();
    PDStream stream = appearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDStream contentStream = appearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(((COSStream) cOSObject).getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(appearanceStream.getResources());
    assertNull(stream.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(appearanceStream.getBBox());
    assertNull(stream.getFile());
    assertNull(contentStream.getFile());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream.getGroup());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(0, stream.getLength());
    assertEquals(0, contentStream.getLength());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(0L, ((COSStream) cOSObject).getLength());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSStream) cOSObject).hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualDownAppearance.isSubDictionary());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualDownAppearance.isStream());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDAbstractAppearanceHandler#getDownAppearance()}
   */
  @Test
  void testGetDownAppearance3() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(new PDAppearanceDictionary());

    // Act
    PDAppearanceEntry actualDownAppearance = (new PDCaretAppearanceHandler(annotation)).getDownAppearance();

    // Assert
    COSDictionary cOSObject = actualDownAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceStream appearanceStream = actualDownAppearance.getAppearanceStream();
    PDStream stream = appearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDStream contentStream = appearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(((COSStream) cOSObject).getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(appearanceStream.getResources());
    assertNull(stream.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(appearanceStream.getBBox());
    assertNull(stream.getFile());
    assertNull(contentStream.getFile());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream.getGroup());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(0, stream.getLength());
    assertEquals(0, contentStream.getLength());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(0L, ((COSStream) cOSObject).getLength());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSStream) cOSObject).hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualDownAppearance.isSubDictionary());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualDownAppearance.isStream());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test: {@link PDAbstractAppearanceHandler#getDownAppearance()}
   */
  @Test
  void testGetDownAppearance4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDAppearanceEntry actualDownAppearance = (new PDCaretAppearanceHandler(new PDAnnotationCaret(), document))
        .getDownAppearance();

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = actualDownAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceStream appearanceStream = actualDownAppearance.getAppearanceStream();
    PDStream stream = appearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDStream contentStream = appearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(((COSStream) cOSObject).getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(appearanceStream.getResources());
    assertNull(stream.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(appearanceStream.getBBox());
    assertNull(stream.getFile());
    assertNull(contentStream.getFile());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream.getGroup());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(0, stream.getLength());
    assertEquals(0, contentStream.getLength());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(0L, ((COSStream) cOSObject).getLength());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSStream) cOSObject).hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualDownAppearance.isSubDictionary());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualDownAppearance.isStream());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#getRolloverAppearance()}
   */
  @Test
  void testGetRolloverAppearance() throws IOException {
    // Arrange
    PDAnnotation annotation = mock(PDAnnotation.class);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    PDAppearanceEntry actualRolloverAppearance = pdCaretAppearanceHandler.getRolloverAppearance();

    // Assert
    verify(annotation).getAppearance();
    COSDictionary cOSObject = actualRolloverAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceStream appearanceStream = actualRolloverAppearance.getAppearanceStream();
    PDStream stream = appearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDStream contentStream = appearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(((COSStream) cOSObject).getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(appearanceStream.getResources());
    assertNull(stream.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(appearanceStream.getBBox());
    assertNull(stream.getFile());
    assertNull(contentStream.getFile());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream.getGroup());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(0, stream.getLength());
    assertEquals(0, contentStream.getLength());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(0L, ((COSStream) cOSObject).getLength());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSStream) cOSObject).hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualRolloverAppearance.isSubDictionary());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualRolloverAppearance.isStream());
    assertSame(pdAppearanceDictionary, pdCaretAppearanceHandler.getAppearance());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#getRolloverAppearance()}
   */
  @Test
  void testGetRolloverAppearance2() throws IOException {
    // Arrange
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    PDAppearanceEntry actualRolloverAppearance = pdCaretAppearanceHandler.getRolloverAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    COSDictionary cOSObject = actualRolloverAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceStream appearanceStream = actualRolloverAppearance.getAppearanceStream();
    PDStream stream = appearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDStream contentStream = appearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(((COSStream) cOSObject).getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(appearanceStream.getResources());
    assertNull(stream.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(appearanceStream.getBBox());
    assertNull(stream.getFile());
    assertNull(contentStream.getFile());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream.getGroup());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(0, stream.getLength());
    assertEquals(0, contentStream.getLength());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(0L, ((COSStream) cOSObject).getLength());
    COSDictionary cOSObject2 = pdCaretAppearanceHandler.getAppearance().getCOSObject();
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, cOSObject2.size());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSStream) cOSObject).hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualRolloverAppearance.isSubDictionary());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualRolloverAppearance.isStream());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#getRolloverAppearance()}
   */
  @Test
  void testGetRolloverAppearance3() throws IOException {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    doNothing().when(pdAppearanceDictionary).setRolloverAppearance(Mockito.<PDAppearanceEntry>any());
    when(pdAppearanceDictionary.getRolloverAppearance()).thenReturn(new PDAppearanceEntry(new COSDictionary()));
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    PDAppearanceEntry actualRolloverAppearance = (new PDCaretAppearanceHandler(annotation)).getRolloverAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(pdAppearanceDictionary).getRolloverAppearance();
    verify(pdAppearanceDictionary).setRolloverAppearance(isA(PDAppearanceEntry.class));
    COSDictionary cOSObject = actualRolloverAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceStream appearanceStream = actualRolloverAppearance.getAppearanceStream();
    PDStream stream = appearanceStream.getStream();
    assertNull(stream.getDecodeParms());
    PDStream contentStream = appearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(((COSStream) cOSObject).getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(appearanceStream.getResources());
    assertNull(stream.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(appearanceStream.getBBox());
    assertNull(stream.getFile());
    assertNull(contentStream.getFile());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream.getGroup());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(0, stream.getLength());
    assertEquals(0, contentStream.getLength());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(0L, ((COSStream) cOSObject).getLength());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSStream) cOSObject).hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualRolloverAppearance.isSubDictionary());
    List<String> fileFilters = contentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualRolloverAppearance.isStream());
    assertSame(fileFilters, stream.getFileFilters());
    assertSame(fileFilters, stream.getFilters());
    assertSame(fileFilters, contentStream.getFilters());
    assertSame(cOSObject, stream.getCOSObject());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, appearanceStream.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#getRolloverAppearance()}
   */
  @Test
  void testGetRolloverAppearance4() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    PDAppearanceEntry pdAppearanceEntry = new PDAppearanceEntry(new COSStream());
    when(pdAppearanceDictionary.getRolloverAppearance()).thenReturn(pdAppearanceEntry);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    PDAppearanceEntry actualRolloverAppearance = (new PDCaretAppearanceHandler(annotation)).getRolloverAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(pdAppearanceDictionary).getRolloverAppearance();
    assertSame(pdAppearanceEntry, actualRolloverAppearance);
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#getPaddedRectangle(PDRectangle, float)}
   */
  @Test
  void testGetPaddedRectangle() {
    // Arrange and Act
    PDRectangle actualPaddedRectangle = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .getPaddedRectangle(PDRectangle.A0, 10.0f);

    // Assert
    COSArray cOSArray = actualPaddedRectangle.getCOSArray();
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
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(10.0f, actualPaddedRectangle.getLowerLeftX());
    assertEquals(10.0f, actualPaddedRectangle.getLowerLeftY());
    assertEquals(2363.937f, actualPaddedRectangle.getWidth());
    assertEquals(2373.937f, actualPaddedRectangle.getUpperRightX());
    assertEquals(3350.3938f, actualPaddedRectangle.getHeight());
    assertEquals(3360.3938f, actualPaddedRectangle.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualPaddedRectangle.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#getPaddedRectangle(PDRectangle, float)}
   */
  @Test
  void testGetPaddedRectangle2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDRectangle actualPaddedRectangle = (new PDCaretAppearanceHandler(new PDAnnotationCaret(), document))
        .getPaddedRectangle(PDRectangle.A0, 10.0f);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSArray cOSArray = actualPaddedRectangle.getCOSArray();
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
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(10.0f, actualPaddedRectangle.getLowerLeftX());
    assertEquals(10.0f, actualPaddedRectangle.getLowerLeftY());
    assertEquals(2363.937f, actualPaddedRectangle.getWidth());
    assertEquals(2373.937f, actualPaddedRectangle.getUpperRightX());
    assertEquals(3350.3938f, actualPaddedRectangle.getHeight());
    assertEquals(3360.3938f, actualPaddedRectangle.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualPaddedRectangle.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#addRectDifferences(PDRectangle, float[])}
   */
  @Test
  void testAddRectDifferences() {
    // Arrange and Act
    PDRectangle actualAddRectDifferencesResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .addRectDifferences(PDRectangle.A0, new float[]{10.0f, 1.0f, 10.0f, 1.0f});

    // Assert
    COSArray cOSArray = actualAddRectDifferencesResult.getCOSArray();
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
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(-1.0f, actualAddRectDifferencesResult.getLowerLeftY());
    assertEquals(-10.0f, actualAddRectDifferencesResult.getLowerLeftX());
    assertEquals(2393.937f, actualAddRectDifferencesResult.getUpperRightX());
    assertEquals(2403.937f, actualAddRectDifferencesResult.getWidth());
    assertEquals(3371.3938f, actualAddRectDifferencesResult.getUpperRightY());
    assertEquals(3372.3938f, actualAddRectDifferencesResult.getHeight());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertSame(cOSArray, actualAddRectDifferencesResult.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#addRectDifferences(PDRectangle, float[])}
   */
  @Test
  void testAddRectDifferences2() {
    // Arrange and Act
    PDRectangle actualAddRectDifferencesResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .addRectDifferences(PDRectangle.A0, null);

    // Assert
    assertSame(actualAddRectDifferencesResult.A0, actualAddRectDifferencesResult);
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#addRectDifferences(PDRectangle, float[])}
   */
  @Test
  void testAddRectDifferences3() {
    // Arrange and Act
    PDRectangle actualAddRectDifferencesResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .addRectDifferences(PDRectangle.A0, new float[]{});

    // Assert
    assertSame(actualAddRectDifferencesResult.A0, actualAddRectDifferencesResult);
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle, float[])}
   */
  @Test
  void testApplyRectDifferences() {
    // Arrange and Act
    PDRectangle actualApplyRectDifferencesResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .applyRectDifferences(PDRectangle.A0, new float[]{10.0f, 1.0f, 10.0f, 1.0f});

    // Assert
    COSArray cOSArray = actualApplyRectDifferencesResult.getCOSArray();
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
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(1.0f, actualApplyRectDifferencesResult.getLowerLeftY());
    assertEquals(10.0f, actualApplyRectDifferencesResult.getLowerLeftX());
    assertEquals(2363.937f, actualApplyRectDifferencesResult.getWidth());
    assertEquals(2373.937f, actualApplyRectDifferencesResult.getUpperRightX());
    assertEquals(3368.3938f, actualApplyRectDifferencesResult.getHeight());
    assertEquals(3369.3938f, actualApplyRectDifferencesResult.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertSame(cOSArray, actualApplyRectDifferencesResult.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle, float[])}
   */
  @Test
  void testApplyRectDifferences2() {
    // Arrange and Act
    PDRectangle actualApplyRectDifferencesResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .applyRectDifferences(PDRectangle.A0, null);

    // Assert
    assertSame(actualApplyRectDifferencesResult.A0, actualApplyRectDifferencesResult);
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle, float[])}
   */
  @Test
  void testApplyRectDifferences3() {
    // Arrange and Act
    PDRectangle actualApplyRectDifferencesResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .applyRectDifferences(PDRectangle.A0, new float[]{});

    // Assert
    assertSame(actualApplyRectDifferencesResult.A0, actualApplyRectDifferencesResult);
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  void testSetOpacity() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 0.5f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  void testSetOpacity2() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(
        new PDAnnotationCaret(new COSDictionary()));
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 0.5f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  void testSetOpacity3() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 0.5f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  void testSetOpacity4() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 0.5f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  void testSetOpacity5() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.A);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 0.5f);

    // Assert
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  void testSetOpacity6() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.ADBE_PKCS7_DETACHED);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 0.5f);

    // Assert
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  void testSetOpacity7() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.ADBE_X509_RSA_SHA1);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 0.5f);

    // Assert
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  void testDrawStyle() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawStyle("Butt", new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f,
        10.0f, 10.0f, true, true, true);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  void testDrawStyle2() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawStyle("Butt", new PDAppearanceContentStream(new PDAppearanceStream(stream)),
        -9.223372E18f, 10.0f, 10.0f, true, true, true);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  void testDrawStyle3() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawStyle("Butt", new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f,
        10.0f, -9.223372E18f, true, true, true);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawArrow(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  void testDrawArrow() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawArrow(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f, 10.0f,
        10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawArrow(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  void testDrawArrow2() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawArrow(new PDAppearanceContentStream(new PDAppearanceStream(stream)), -9.223372E18f,
        10.0f, 10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawDiamond(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  void testDrawDiamond() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawDiamond(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f, 10.0f,
        10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawDiamond(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  void testDrawDiamond2() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawDiamond(new PDAppearanceContentStream(new PDAppearanceStream(stream)), -9.223372E18f,
        10.0f, 10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawCircle(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  void testDrawCircle() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawCircle(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f, 10.0f,
        10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawCircle(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  void testDrawCircle2() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawCircle(new PDAppearanceContentStream(new PDAppearanceStream(stream)), -9.223372E18f,
        10.0f, 10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawCircle2(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  void testDrawCircle22() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawCircle2(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f, 10.0f,
        10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawCircle2(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  void testDrawCircle23() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawCircle2(new PDAppearanceContentStream(new PDAppearanceStream(stream)), -9.223372E18f,
        10.0f, 10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  void testHandleBorderBox() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);
    PDAnnotationSquareCircle annotation2 = mock(PDAnnotationSquareCircle.class);
    when(annotation2.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    PDRectangle actualHandleBorderBoxResult = pdCaretAppearanceHandler.handleBorderBox(annotation2, 10.0f);

    // Assert
    verify(pdRectangle).getHeight();
    verify(pdRectangle).getLowerLeftX();
    verify(pdRectangle).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(annotation).getRectangle();
    verify(annotation2).getRectDifferences();
    COSArray cOSArray = actualHandleBorderBoxResult.getCOSArray();
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
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(-1.0f, actualHandleBorderBoxResult.getHeight());
    assertEquals(-20.0f, actualHandleBorderBoxResult.getWidth());
    assertEquals(14.5f, actualHandleBorderBoxResult.getUpperRightY());
    assertEquals(15.5f, actualHandleBorderBoxResult.getLowerLeftY());
    assertEquals(25.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(5.0f, actualHandleBorderBoxResult.getUpperRightX());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertSame(cOSArray, actualHandleBorderBoxResult.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  void testHandleBorderBox2() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getCOSArray()).thenReturn(new COSArray());
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);
    PDAnnotationSquareCircle annotation2 = mock(PDAnnotationSquareCircle.class);
    when(annotation2.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    doNothing().when(annotation2).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation2).setRectDifferences(anyFloat());
    when(annotation2.getRectDifferences()).thenReturn(new float[]{});

    // Act
    PDRectangle actualHandleBorderBoxResult = pdCaretAppearanceHandler.handleBorderBox(annotation2, 10.0f);

    // Assert
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(annotation2).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation2).setRectangle(isA(PDRectangle.class));
    verify(annotation2, atLeast(1)).getRectDifferences();
    verify(annotation2).setRectDifferences(eq(5.0f));
    COSArray cOSArray = actualHandleBorderBoxResult.getCOSArray();
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
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualHandleBorderBoxResult.getHeight());
    assertEquals(0.0f, actualHandleBorderBoxResult.getWidth());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftY());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualHandleBorderBoxResult.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  void testHandleBorderBox3() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getCOSArray()).thenReturn(null);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);
    PDAnnotationSquareCircle annotation2 = mock(PDAnnotationSquareCircle.class);
    when(annotation2.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    doNothing().when(annotation2).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation2).setRectDifferences(anyFloat());
    when(annotation2.getRectDifferences()).thenReturn(new float[]{});

    // Act
    PDRectangle actualHandleBorderBoxResult = pdCaretAppearanceHandler.handleBorderBox(annotation2, 10.0f);

    // Assert
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(annotation2).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation2).setRectangle(isA(PDRectangle.class));
    verify(annotation2, atLeast(1)).getRectDifferences();
    verify(annotation2).setRectDifferences(eq(5.0f));
    COSArray cOSArray = actualHandleBorderBoxResult.getCOSArray();
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
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualHandleBorderBoxResult.getHeight());
    assertEquals(0.0f, actualHandleBorderBoxResult.getWidth());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftY());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualHandleBorderBoxResult.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  void testHandleBorderBox4() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);
    PDAnnotationSquareCircle annotation2 = mock(PDAnnotationSquareCircle.class);
    when(annotation2.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    doNothing().when(annotation2).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation2).setRectDifferences(anyFloat());
    when(annotation2.getRectDifferences()).thenReturn(new float[]{});

    // Act
    PDRectangle actualHandleBorderBoxResult = pdCaretAppearanceHandler.handleBorderBox(annotation2, 10.0f);

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(annotation2).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation2).setRectangle(isA(PDRectangle.class));
    verify(annotation2, atLeast(1)).getRectDifferences();
    verify(annotation2).setRectDifferences(eq(5.0f));
    COSArray cOSArray = actualHandleBorderBoxResult.getCOSArray();
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
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualHandleBorderBoxResult.getHeight());
    assertEquals(0.0f, actualHandleBorderBoxResult.getWidth());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftY());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualHandleBorderBoxResult.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  void testHandleBorderBox5() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(false);
    when(cosArray.getKey()).thenReturn(new COSObjectKey(1L, 1));
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);
    PDAnnotationSquareCircle annotation2 = mock(PDAnnotationSquareCircle.class);
    when(annotation2.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    doNothing().when(annotation2).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation2).setRectDifferences(anyFloat());
    when(annotation2.getRectDifferences()).thenReturn(new float[]{});

    // Act
    PDRectangle actualHandleBorderBoxResult = pdCaretAppearanceHandler.handleBorderBox(annotation2, 10.0f);

    // Assert
    verify(cosArray, atLeast(1)).getKey();
    verify(cosArray).isDirect();
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(annotation2).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation2).setRectangle(isA(PDRectangle.class));
    verify(annotation2, atLeast(1)).getRectDifferences();
    verify(annotation2).setRectDifferences(eq(5.0f));
    COSArray cOSArray = actualHandleBorderBoxResult.getCOSArray();
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
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualHandleBorderBoxResult.getHeight());
    assertEquals(0.0f, actualHandleBorderBoxResult.getWidth());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftY());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualHandleBorderBoxResult.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  void testHandleBorderBox6() {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);
    PDAnnotationSquareCircle annotation2 = mock(PDAnnotationSquareCircle.class);
    when(annotation2.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    doNothing().when(annotation2).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation2).setRectDifferences(anyFloat());
    when(annotation2.getRectDifferences()).thenReturn(new float[]{});

    // Act
    PDRectangle actualHandleBorderBoxResult = pdCaretAppearanceHandler.handleBorderBox(annotation2, 10.0f);

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(annotation2).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation2).setRectangle(isA(PDRectangle.class));
    verify(annotation2, atLeast(1)).getRectDifferences();
    verify(annotation2).setRectDifferences(eq(5.0f));
    COSArray cOSArray = actualHandleBorderBoxResult.getCOSArray();
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
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualHandleBorderBoxResult.getHeight());
    assertEquals(0.0f, actualHandleBorderBoxResult.getWidth());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftY());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualHandleBorderBoxResult.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  void testHandleBorderBox7() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);
    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    PDAnnotationSquareCircle annotation2 = mock(PDAnnotationSquareCircle.class);
    when(annotation2.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    doNothing().when(annotation2).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation2).setRectDifferences(anyFloat());
    when(annotation2.getRectDifferences()).thenReturn(new float[]{});

    // Act
    PDRectangle actualHandleBorderBoxResult = pdCaretAppearanceHandler.handleBorderBox(annotation2, 10.0f);

    // Assert
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation2).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation2).setRectangle(isA(PDRectangle.class));
    verify(annotation2, atLeast(1)).getRectDifferences();
    verify(annotation2).setRectDifferences(eq(5.0f));
    COSArray cOSArray = actualHandleBorderBoxResult.getCOSArray();
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
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualHandleBorderBoxResult.getHeight());
    assertEquals(0.0f, actualHandleBorderBoxResult.getWidth());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftY());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualHandleBorderBoxResult.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  void testHandleBorderBox8() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);
    PDAnnotationSquareCircle annotation2 = mock(PDAnnotationSquareCircle.class);
    when(annotation2.getRectDifferences()).thenReturn(new float[]{2.0f, 10.0f, 2.0f, 10.0f, 2.0f, 10.0f, 2.0f, 10.0f});

    // Act
    PDRectangle actualHandleBorderBoxResult = pdCaretAppearanceHandler.handleBorderBox(annotation2, 10.0f);

    // Assert
    verify(pdRectangle).getHeight();
    verify(pdRectangle).getLowerLeftX();
    verify(pdRectangle).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(annotation).getRectangle();
    verify(annotation2).getRectDifferences();
    COSArray cOSArray = actualHandleBorderBoxResult.getCOSArray();
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
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualHandleBorderBoxResult.getHeight());
    assertEquals(0.0f, actualHandleBorderBoxResult.getWidth());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftY());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualHandleBorderBoxResult.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  void testHandleBorderBox9() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation, new PDDocument());
    PDAnnotationSquareCircle annotation2 = mock(PDAnnotationSquareCircle.class);
    when(annotation2.getRectDifferences()).thenReturn(new float[]{2.0f, 10.0f, 2.0f, 10.0f, 2.0f, 10.0f, 2.0f, 10.0f});

    // Act
    PDRectangle actualHandleBorderBoxResult = pdCaretAppearanceHandler.handleBorderBox(annotation2, 10.0f);

    // Assert
    verify(annotation2).getRectDifferences();
    COSArray cOSArray = actualHandleBorderBoxResult.getCOSArray();
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
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(2373.937f, actualHandleBorderBoxResult.getWidth());
    assertEquals(2378.937f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(3360.3938f, actualHandleBorderBoxResult.getHeight());
    assertEquals(3365.3938f, actualHandleBorderBoxResult.getUpperRightY());
    assertEquals(5.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(5.0f, actualHandleBorderBoxResult.getLowerLeftY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualHandleBorderBoxResult.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  void testHandleBorderBox10() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation, new PDDocument());
    PDAnnotationSquareCircle annotation2 = mock(PDAnnotationSquareCircle.class);
    when(annotation2.getRectDifferences()).thenReturn(new float[]{2.0f, 10.0f, 2.0f, 10.0f, 2.0f, 10.0f, 2.0f, 10.0f});

    // Act
    PDRectangle actualHandleBorderBoxResult = pdCaretAppearanceHandler.handleBorderBox(annotation2, 10.0f);

    // Assert
    verify(annotation2).getRectDifferences();
    COSArray cOSArray = actualHandleBorderBoxResult.getCOSArray();
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
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualHandleBorderBoxResult.getHeight());
    assertEquals(0.0f, actualHandleBorderBoxResult.getWidth());
    assertEquals(2.14748365E9f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(2.14748365E9f, actualHandleBorderBoxResult.getLowerLeftY());
    assertEquals(2.14748365E9f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(2.14748365E9f, actualHandleBorderBoxResult.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualHandleBorderBoxResult.getCOSObject());
  }
}
