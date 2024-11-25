package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationHighlight;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDHighlightAppearanceHandlerDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PDHighlightAppearanceHandler#PDHighlightAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDHighlightAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDHighlightAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDHighlightAppearanceHandler actualPdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);
    actualPdHighlightAppearanceHandler.generateDownAppearance();
    actualPdHighlightAppearanceHandler.generateRolloverAppearance();

    // Assert that nothing has changed
    assertTrue(actualPdHighlightAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdHighlightAppearanceHandler.getAnnotation());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance() {
    // Arrange
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(
        new PDAnnotationHighlight());

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert that nothing has changed
    PDAppearanceEntry downAppearance = pdHighlightAppearanceHandler.getDownAppearance();
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceEntry rolloverAppearance = pdHighlightAppearanceHandler.getRolloverAppearance();
    COSDictionary cOSObject2 = rolloverAppearance.getCOSObject();
    assertTrue(cOSObject2 instanceof COSStream);
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    assertEquals(0, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
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
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertFalse(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(cOSObject2, stream.getCOSObject());
    assertSame(cOSObject2, contentStream.getCOSObject());
    assertSame(cOSObject2, appearanceStream2.getCOSObject());
    assertSame(cOSObject2, pdHighlightAppearanceHandler.getAppearance().getRolloverAppearance().getCOSObject());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance2() {
    // Arrange
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(
        new PDAnnotationHighlight(new COSDictionary()));

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert that nothing has changed
    PDAppearanceEntry downAppearance = pdHighlightAppearanceHandler.getDownAppearance();
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceEntry rolloverAppearance = pdHighlightAppearanceHandler.getRolloverAppearance();
    COSDictionary cOSObject2 = rolloverAppearance.getCOSObject();
    assertTrue(cOSObject2 instanceof COSStream);
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    assertEquals(0, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = rolloverAppearance.getAppearanceStream();
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
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertFalse(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream2.getMatrix());
    assertSame(cOSObject2, stream.getCOSObject());
    assertSame(cOSObject2, contentStream.getCOSObject());
    assertSame(cOSObject2, appearanceStream2.getCOSObject());
    assertSame(cOSObject2, pdHighlightAppearanceHandler.getAppearance().getRolloverAppearance().getCOSObject());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance3() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdHighlightAppearanceHandler.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> extGStateNames = resources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    Iterable<COSName> xObjectNames = resources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    COSDictionary cOSObject2 = resources.getCOSObject();
    COSUpdateState updateState = cOSObject2.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject2.getKey());
    PDAppearanceDictionary appearance = pdHighlightAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    PDResources resources2 = appearanceStream2.getResources();
    assertNull(resources2.getResourceCache());
    assertNull(resources.getResourceCache());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    PDRectangle bBox = appearanceStream2.getBBox();
    assertEquals(-4.5f, bBox.getLowerLeftY());
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    PDAppearanceStream appearanceStream3 = normalAppearance.getAppearanceStream();
    PDRectangle bBox2 = appearanceStream3.getBBox();
    assertEquals(-4.5f, bBox2.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    PDAppearanceStream appearanceStream4 = rolloverAppearance.getAppearanceStream();
    PDRectangle bBox3 = appearanceStream4.getBBox();
    assertEquals(-4.5f, bBox3.getLowerLeftY());
    PDRectangle bBox4 = appearanceStream.getBBox();
    assertEquals(-4.5f, bBox4.getLowerLeftY());
    PDAppearanceEntry rolloverAppearance2 = pdHighlightAppearanceHandler.getRolloverAppearance();
    PDAppearanceStream appearanceStream5 = rolloverAppearance2.getAppearanceStream();
    PDRectangle bBox5 = appearanceStream5.getBBox();
    assertEquals(-4.5f, bBox5.getLowerLeftY());
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox4.getLowerLeftX());
    COSDictionary cOSObject3 = appearance.getCOSObject();
    assertEquals(1, cOSObject3.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject3.size());
    assertEquals(10.5f, bBox.getUpperRightY());
    assertEquals(10.5f, bBox2.getUpperRightY());
    assertEquals(10.5f, bBox3.getUpperRightY());
    assertEquals(10.5f, bBox4.getUpperRightY());
    assertEquals(10.5f, bBox5.getUpperRightY());
    assertEquals(15.0f, bBox.getHeight());
    assertEquals(15.0f, bBox2.getHeight());
    assertEquals(15.0f, bBox3.getHeight());
    assertEquals(15.0f, bBox4.getHeight());
    assertEquals(15.0f, bBox5.getHeight());
    assertEquals(2, cOSObject2.getValues().size());
    assertEquals(2, ((Set<COSName>) extGStateNames).size());
    assertEquals(2, cOSObject2.size());
    assertEquals(20.0f, bBox.getUpperRightX());
    assertEquals(20.0f, bBox2.getUpperRightX());
    assertEquals(20.0f, bBox3.getUpperRightX());
    assertEquals(20.0f, bBox4.getUpperRightX());
    assertEquals(20.0f, bBox5.getUpperRightX());
    assertEquals(20.0f, bBox.getWidth());
    assertEquals(20.0f, bBox2.getWidth());
    assertEquals(20.0f, bBox3.getWidth());
    assertEquals(20.0f, bBox4.getWidth());
    assertEquals(20.0f, bBox5.getWidth());
    assertEquals(26, appearanceStream2.getStream().getLength());
    PDStream stream = appearanceStream3.getStream();
    assertEquals(26, stream.getLength());
    PDStream stream2 = appearanceStream4.getStream();
    assertEquals(26, stream2.getLength());
    assertEquals(26, appearanceStream.getStream().getLength());
    PDStream stream3 = appearanceStream5.getStream();
    assertEquals(26, stream3.getLength());
    assertEquals(26, appearanceStream2.getContentStream().getLength());
    PDStream contentStream = appearanceStream3.getContentStream();
    assertEquals(26, contentStream.getLength());
    PDStream contentStream2 = appearanceStream4.getContentStream();
    assertEquals(26, contentStream2.getLength());
    assertEquals(26, appearanceStream.getContentStream().getLength());
    PDStream contentStream3 = appearanceStream5.getContentStream();
    assertEquals(26, contentStream3.getLength());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(4.5f, matrix.getTranslateY());
    assertEquals(4.5f, floatArray[1]);
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject2.isDirect());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(((COSStream) cOSObject).hasData());
    assertEquals(matrix, appearanceStream3.getMatrix());
    assertEquals(matrix, appearanceStream4.getMatrix());
    assertEquals(matrix, appearanceStream5.getMatrix());
    assertSame(cOSObject2, resources2.getCOSObject());
    PDResources resources3 = appearanceStream3.getResources();
    assertSame(cOSObject2, resources3.getCOSObject());
    PDResources resources4 = appearanceStream4.getResources();
    assertSame(cOSObject2, resources4.getCOSObject());
    PDResources resources5 = appearanceStream5.getResources();
    assertSame(cOSObject2, resources5.getCOSObject());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
    COSArray expectedCOSObject2 = bBox4.getCOSArray();
    assertSame(expectedCOSObject2, bBox4.getCOSObject());
    assertSame(colorSpaceNames, resources2.getColorSpaceNames());
    assertSame(colorSpaceNames, resources3.getColorSpaceNames());
    assertSame(colorSpaceNames, resources4.getColorSpaceNames());
    assertSame(colorSpaceNames, resources5.getColorSpaceNames());
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
    assertSame(extGStateNames, resources2.getExtGStateNames());
    assertSame(extGStateNames, resources3.getExtGStateNames());
    assertSame(extGStateNames, resources4.getExtGStateNames());
    assertSame(extGStateNames, resources5.getExtGStateNames());
    assertSame(xObjectNames, resources2.getXObjectNames());
    assertSame(xObjectNames, resources3.getXObjectNames());
    assertSame(xObjectNames, resources4.getXObjectNames());
    assertSame(xObjectNames, resources5.getXObjectNames());
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
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance4() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(new COSStream()));
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(-4.5f, rectangle.getLowerLeftY());
    assertEquals(10.5f, rectangle.getUpperRightY());
    assertEquals(15.0f, rectangle.getHeight());
    assertEquals(20.0f, rectangle.getUpperRightX());
    assertEquals(20.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance5() throws IOException {
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
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(-4.5f, rectangle.getLowerLeftY());
    assertEquals(10.5f, rectangle.getUpperRightY());
    assertEquals(15.0f, rectangle.getHeight());
    assertEquals(20.0f, rectangle.getUpperRightX());
    assertEquals(20.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance6() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.ADBE_PKCS7_DETACHED);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary, atLeast(1)).containsValue(Mockito.<Object>any());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getKeyForValue(Mockito.<Object>any());
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(-4.5f, rectangle.getLowerLeftY());
    assertEquals(10.5f, rectangle.getUpperRightY());
    assertEquals(15.0f, rectangle.getHeight());
    assertEquals(20.0f, rectangle.getUpperRightX());
    assertEquals(20.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance7() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.ADBE_X509_RSA_SHA1);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary, atLeast(1)).containsValue(Mockito.<Object>any());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getKeyForValue(Mockito.<Object>any());
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(-4.5f, rectangle.getLowerLeftY());
    assertEquals(10.5f, rectangle.getUpperRightY());
    assertEquals(15.0f, rectangle.getHeight());
    assertEquals(20.0f, rectangle.getUpperRightX());
    assertEquals(20.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getCOSDictionary(COSName)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given COSDictionary getCOSDictionary(COSName) return 'null'")
  void testGenerateNormalAppearance_givenCOSDictionaryGetCOSDictionaryReturnNull() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(cosDictionary, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(-4.5f, rectangle.getLowerLeftY());
    assertEquals(10.5f, rectangle.getUpperRightY());
    assertEquals(15.0f, rectangle.getHeight());
    assertEquals(20.0f, rectangle.getUpperRightX());
    assertEquals(20.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getKeyForValue(Object)}
   * return {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given COSDictionary getKeyForValue(Object) return A")
  void testGenerateNormalAppearance_givenCOSDictionaryGetKeyForValueReturnA() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.A);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary, atLeast(1)).containsValue(Mockito.<Object>any());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getKeyForValue(Mockito.<Object>any());
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(-4.5f, rectangle.getLowerLeftY());
    assertEquals(10.5f, rectangle.getUpperRightY());
    assertEquals(15.0f, rectangle.getHeight());
    assertEquals(20.0f, rectangle.getUpperRightX());
    assertEquals(20.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link COSStream} {@link COSDictionary#getCOSDictionary(COSName)}
   * return {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given COSStream getCOSDictionary(COSName) return COSDictionary()")
  void testGenerateNormalAppearance_givenCOSStreamGetCOSDictionaryReturnCOSDictionary() throws IOException {
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
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(-4.5f, rectangle.getLowerLeftY());
    assertEquals(10.5f, rectangle.getUpperRightY());
    assertEquals(15.0f, rectangle.getHeight());
    assertEquals(20.0f, rectangle.getUpperRightX());
    assertEquals(20.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#containsKey(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls containsKey(COSName)")
  void testGenerateNormalAppearance_thenCallsContainsKey() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    COSStream entry = mock(COSStream.class);
    when(entry.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(entry, atLeast(1)).containsKey(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(-4.5f, rectangle.getLowerLeftY());
    assertEquals(10.5f, rectangle.getUpperRightY());
    assertEquals(15.0f, rectangle.getHeight());
    assertEquals(20.0f, rectangle.getUpperRightX());
    assertEquals(20.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Then calls
   * {@link PDAnnotation#setAppearance(PDAppearanceDictionary)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls setAppearance(PDAppearanceDictionary)")
  void testGenerateNormalAppearance_thenCallsSetAppearance() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(-4.5f, rectangle.getLowerLeftY());
    assertEquals(10.5f, rectangle.getUpperRightY());
    assertEquals(15.0f, rectangle.getHeight());
    assertEquals(20.0f, rectangle.getUpperRightX());
    assertEquals(20.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Then calls
   * {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls setNormalAppearance(PDAppearanceEntry)")
  void testGenerateNormalAppearance_thenCallsSetNormalAppearance() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(-4.5f, rectangle.getLowerLeftY());
    assertEquals(10.5f, rectangle.getUpperRightY());
    assertEquals(15.0f, rectangle.getHeight());
    assertEquals(20.0f, rectangle.getUpperRightX());
    assertEquals(20.0f, rectangle.getWidth());
  }
}
