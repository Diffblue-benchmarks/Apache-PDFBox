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
import java.awt.geom.AffineTransform;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
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
import org.apache.pdfbox.pdmodel.PDAppearanceContentStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquareCircle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAbstractAppearanceHandlerDiffblueTest {
  /**
   * Test {@link PDAbstractAppearanceHandler#getAnnotation()}.
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getAnnotation()}
   */
  @Test
  @DisplayName("Test getAnnotation()")
  void testGetAnnotation() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act and Assert
    assertSame(annotation, (new PDCaretAppearanceHandler(annotation)).getAnnotation());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getColor()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getColor()}
   */
  @Test
  @DisplayName("Test getColor(); then return 'null'")
  void testGetColor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDCaretAppearanceHandler(new PDAnnotationCaret())).getColor());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getRectangle()}.
   * <ul>
   *   <li>Then return COSArray toList third Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); then return COSArray toList third Key is 'null'")
  void testGetRectangle_thenReturnCOSArrayToListThirdKeyIsNull() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);

    // Act
    PDRectangle actualRectangle = (new PDCaretAppearanceHandler(annotation)).getRectangle();

    // Assert
    List<? extends COSBase> toListResult = actualRectangle.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertEquals(0.0f, actualRectangle.getLowerLeftX());
    assertEquals(0.0f, actualRectangle.getLowerLeftY());
    assertEquals(2383.937f, actualRectangle.getUpperRightX());
    assertEquals(2383.937f, actualRectangle.getWidth());
    assertEquals(3370.3938f, actualRectangle.getHeight());
    assertEquals(3370.3938f, actualRectangle.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getRectangle()}.
   * <ul>
   *   <li>Then return Height is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); then return Height is zero")
  void testGetRectangle_thenReturnHeightIsZero() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualRectangle = (new PDCaretAppearanceHandler(annotation)).getRectangle();

    // Assert
    List<? extends COSBase> toListResult = actualRectangle.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(0.0f, actualRectangle.getHeight());
    assertEquals(0.0f, actualRectangle.getWidth());
    assertEquals(2.14748365E9f, actualRectangle.getLowerLeftX());
    assertEquals(2.14748365E9f, actualRectangle.getLowerLeftY());
    assertEquals(2.14748365E9f, actualRectangle.getUpperRightX());
    assertEquals(2.14748365E9f, actualRectangle.getUpperRightY());
    COSBase getResult3 = toListResult.get(0);
    assertEquals(getResult3, getResult);
    assertEquals(getResult3, getResult2);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getRectangle()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); then return 'null'")
  void testGetRectangle_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDCaretAppearanceHandler(new PDAnnotationCaret())).getRectangle());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#createCOSStream()}.
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#createCOSStream()}
   */
  @Test
  @DisplayName("Test createCOSStream()")
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
   * Test {@link PDAbstractAppearanceHandler#createCOSStream()}.
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#createCOSStream()}
   */
  @Test
  @DisplayName("Test createCOSStream()")
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
   * Test {@link PDAbstractAppearanceHandler#getAppearance()}.
   * <ul>
   *   <li>Then return DownAppearance COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getAppearance()}
   */
  @Test
  @DisplayName("Test getAppearance(); then return DownAppearance COSObject size is zero")
  void testGetAppearance_thenReturnDownAppearanceCOSObjectSizeIsZero() {
    // Arrange
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());

    // Act
    PDAppearanceDictionary actualAppearance = (new PDCaretAppearanceHandler(annotation)).getAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    PDAppearanceEntry downAppearance = actualAppearance.getDownAppearance();
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertEquals(0, cOSObject.size());
    COSDictionary cOSObject2 = actualAppearance.getCOSObject();
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, cOSObject2.size());
    assertFalse(downAppearance.isStream());
    PDAppearanceEntry normalAppearance = actualAppearance.getNormalAppearance();
    assertFalse(normalAppearance.isStream());
    PDAppearanceEntry rolloverAppearance = actualAppearance.getRolloverAppearance();
    assertFalse(rolloverAppearance.isStream());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(downAppearance.getSubDictionary().isEmpty());
    assertTrue(normalAppearance.getSubDictionary().isEmpty());
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(downAppearance.isSubDictionary());
    assertTrue(normalAppearance.isSubDictionary());
    assertTrue(rolloverAppearance.isSubDictionary());
    assertSame(cOSObject, normalAppearance.getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getAppearance()}.
   * <ul>
   *   <li>Then return {@link PDAppearanceDictionary#PDAppearanceDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getAppearance()}
   */
  @Test
  @DisplayName("Test getAppearance(); then return PDAppearanceDictionary()")
  void testGetAppearance_thenReturnPDAppearanceDictionary() {
    // Arrange
    PDAnnotation annotation = mock(PDAnnotation.class);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    PDAppearanceDictionary actualAppearance = (new PDCaretAppearanceHandler(annotation)).getAppearance();

    // Assert
    verify(annotation).getAppearance();
    assertSame(pdAppearanceDictionary, actualAppearance);
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}.
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream()")
  void testGetNormalAppearanceAsContentStream() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream();

    // Assert
    PDAnnotation annotation2 = pdCaretAppearanceHandler.getAnnotation();
    assertTrue(annotation2 instanceof PDAnnotationCaret);
    PDAppearanceStream appearanceStream = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    assertEquals(-0.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    assertEquals(-0.0f, floatArray[1]);
    PDRectangle bBox = annotation2.getAppearance().getDownAppearance().getAppearanceStream().getBBox();
    assertEquals(0.0f, bBox.getLowerLeftX());
    PDRectangle bBox2 = pdCaretAppearanceHandler.getAppearance().getDownAppearance().getAppearanceStream().getBBox();
    assertEquals(0.0f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox3.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    assertEquals(0.0f, bBox3.getLowerLeftY());
    assertEquals(2383.937f, bBox.getUpperRightX());
    assertEquals(2383.937f, bBox2.getUpperRightX());
    assertEquals(2383.937f, bBox3.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    assertEquals(2383.937f, bBox2.getWidth());
    assertEquals(2383.937f, bBox3.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox2.getHeight());
    assertEquals(3370.3938f, bBox3.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    assertEquals(3370.3938f, bBox2.getUpperRightY());
    assertEquals(3370.3938f, bBox3.getUpperRightY());
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}.
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream()")
  void testGetNormalAppearanceAsContentStream2() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream();

    // Assert
    PDAnnotation annotation2 = pdCaretAppearanceHandler.getAnnotation();
    assertTrue(annotation2 instanceof PDAnnotationCaret);
    PDAppearanceStream appearanceStream = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-2.14748365E9f, matrix.getTranslateX());
    assertEquals(-2.14748365E9f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-2.14748365E9f, floatArray[0]);
    assertEquals(-2.14748365E9f, floatArray[1]);
    PDRectangle bBox = annotation2.getAppearance().getDownAppearance().getAppearanceStream().getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDRectangle bBox2 = pdCaretAppearanceHandler.getAppearance().getDownAppearance().getAppearanceStream().getBBox();
    assertEquals(0.0f, bBox2.getHeight());
    PDRectangle bBox3 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox3.getHeight());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bBox2.getWidth());
    assertEquals(0.0f, bBox3.getWidth());
    assertEquals(2.14748365E9f, bBox.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox3.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox3.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox.getUpperRightX());
    assertEquals(2.14748365E9f, bBox2.getUpperRightX());
    assertEquals(2.14748365E9f, bBox3.getUpperRightX());
    assertEquals(2.14748365E9f, bBox.getUpperRightY());
    assertEquals(2.14748365E9f, bBox2.getUpperRightY());
    assertEquals(2.14748365E9f, bBox3.getUpperRightY());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)}
   * with {@code boolean}.
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream(boolean) with 'boolean'")
  void testGetNormalAppearanceAsContentStreamWithBoolean() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream(true);

    // Assert
    PDAppearanceEntry downAppearance = pdCaretAppearanceHandler.getDownAppearance();
    COSDictionary cOSObject = downAppearance.getCOSObject();
    COSBase filters = ((COSStream) cOSObject).getFilters();
    assertTrue(filters instanceof COSName);
    assertTrue(cOSObject instanceof COSStream);
    PDAnnotation annotation2 = pdCaretAppearanceHandler.getAnnotation();
    assertTrue(annotation2 instanceof PDAnnotationCaret);
    assertEquals("FlateDecode", ((COSName) filters).getName());
    assertNull(filters.getKey());
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    assertEquals(-0.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-0.0f, floatArray[0]);
    assertEquals(-0.0f, floatArray[1]);
    PDAppearanceDictionary appearance = annotation2.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    PDRectangle bBox = appearanceStream2.getBBox();
    assertEquals(0.0f, bBox.getLowerLeftX());
    PDAppearanceDictionary appearance2 = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream3 = appearance2.getDownAppearance().getAppearanceStream();
    PDRectangle bBox2 = appearanceStream3.getBBox();
    assertEquals(0.0f, bBox2.getLowerLeftX());
    PDRectangle bBox3 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox3.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    assertEquals(0.0f, bBox3.getLowerLeftY());
    List<COSName> filters2 = appearanceStream.getContentStream().getFilters();
    assertEquals(1, filters2.size());
    assertEquals(2383.937f, bBox.getUpperRightX());
    assertEquals(2383.937f, bBox2.getUpperRightX());
    assertEquals(2383.937f, bBox3.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    assertEquals(2383.937f, bBox2.getWidth());
    assertEquals(2383.937f, bBox3.getWidth());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox2.getHeight());
    assertEquals(3370.3938f, bBox3.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    assertEquals(3370.3938f, bBox2.getUpperRightY());
    assertEquals(3370.3938f, bBox3.getUpperRightY());
    assertEquals(7, cOSObject.getValues().size());
    assertEquals(7, cOSObject.size());
    assertFalse(((COSName) filters).isEmpty());
    assertTrue(filters.isDirect());
    PDAppearanceStream normalAppearanceStream = annotation2.getNormalAppearanceStream();
    assertEquals(filters2, normalAppearanceStream.getStream().getFilters());
    assertEquals(filters2, appearanceStream2.getStream().getFilters());
    assertEquals(filters2, appearanceStream3.getStream().getFilters());
    PDAppearanceStream appearanceStream4 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(filters2, appearanceStream4.getStream().getFilters());
    PDAppearanceStream appearanceStream5 = appearance2.getNormalAppearance().getAppearanceStream();
    assertEquals(filters2, appearanceStream5.getStream().getFilters());
    PDAppearanceStream appearanceStream6 = appearance2.getRolloverAppearance().getAppearanceStream();
    assertEquals(filters2, appearanceStream6.getStream().getFilters());
    assertEquals(filters2, appearanceStream.getStream().getFilters());
    PDAppearanceStream appearanceStream7 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(filters2, appearanceStream7.getStream().getFilters());
    assertEquals(filters2, normalAppearanceStream.getContentStream().getFilters());
    assertEquals(filters2, appearanceStream2.getContentStream().getFilters());
    assertEquals(filters2, appearanceStream3.getContentStream().getFilters());
    assertEquals(filters2, appearanceStream4.getContentStream().getFilters());
    assertEquals(filters2, appearanceStream5.getContentStream().getFilters());
    assertEquals(filters2, appearance.getRolloverAppearance().getAppearanceStream().getContentStream().getFilters());
    assertEquals(filters2, appearanceStream6.getContentStream().getFilters());
    assertEquals(filters2, appearanceStream7.getContentStream().getFilters());
    assertSame(filters, filters2.get(0));
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)}
   * with {@code boolean}.
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream(boolean) with 'boolean'")
  void testGetNormalAppearanceAsContentStreamWithBoolean2() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream(true);

    // Assert
    PDAnnotation annotation2 = pdCaretAppearanceHandler.getAnnotation();
    assertTrue(annotation2 instanceof PDAnnotationCaret);
    PDAppearanceStream appearanceStream = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-2.14748365E9f, matrix.getTranslateX());
    assertEquals(-2.14748365E9f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-2.14748365E9f, floatArray[0]);
    assertEquals(-2.14748365E9f, floatArray[1]);
    PDRectangle bBox = annotation2.getAppearance().getDownAppearance().getAppearanceStream().getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDRectangle bBox2 = pdCaretAppearanceHandler.getAppearance().getDownAppearance().getAppearanceStream().getBBox();
    assertEquals(0.0f, bBox2.getHeight());
    PDRectangle bBox3 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox3.getHeight());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bBox2.getWidth());
    assertEquals(0.0f, bBox3.getWidth());
    assertEquals(2.14748365E9f, bBox.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox3.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox2.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox3.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox.getUpperRightX());
    assertEquals(2.14748365E9f, bBox2.getUpperRightX());
    assertEquals(2.14748365E9f, bBox3.getUpperRightX());
    assertEquals(2.14748365E9f, bBox.getUpperRightY());
    assertEquals(2.14748365E9f, bBox2.getUpperRightY());
    assertEquals(2.14748365E9f, bBox3.getUpperRightY());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)}
   * with {@code boolean}.
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream(boolean) with 'boolean'")
  void testGetNormalAppearanceAsContentStreamWithBoolean3() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream(false);

    // Assert
    COSDictionary cOSObject = pdCaretAppearanceHandler.getDownAppearance().getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAnnotation annotation2 = pdCaretAppearanceHandler.getAnnotation();
    assertTrue(annotation2 instanceof PDAnnotationCaret);
    assertNull(((COSStream) cOSObject).getFilters());
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertSame(cOSObject,
        annotation2.getAppearance().getRolloverAppearance().getAppearanceStream().getStream().getCOSObject());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getDownAppearance()}.
   * <ul>
   *   <li>Then return AppearanceStream Stream COSObject is
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getDownAppearance()}
   */
  @Test
  @DisplayName("Test getDownAppearance(); then return AppearanceStream Stream COSObject is COSStream()")
  void testGetDownAppearance_thenReturnAppearanceStreamStreamCOSObjectIsCOSStream() {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    COSStream stream = new COSStream();
    appearance.setNormalAppearance(new PDAppearanceStream(stream));

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(appearance);

    // Act
    PDAppearanceEntry actualDownAppearance = (new PDCaretAppearanceHandler(annotation)).getDownAppearance();

    // Assert
    PDAppearanceStream appearanceStream = actualDownAppearance.getAppearanceStream();
    assertSame(stream, appearanceStream.getStream().getCOSObject());
    assertSame(stream, appearanceStream.getContentStream().getCOSObject());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(stream, actualDownAppearance.getCOSObject());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getRolloverAppearance()}.
   * <ul>
   *   <li>Then return AppearanceStream Stream COSObject is
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#getRolloverAppearance()}
   */
  @Test
  @DisplayName("Test getRolloverAppearance(); then return AppearanceStream Stream COSObject is COSStream()")
  void testGetRolloverAppearance_thenReturnAppearanceStreamStreamCOSObjectIsCOSStream() {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    COSStream stream = new COSStream();
    appearance.setNormalAppearance(new PDAppearanceStream(stream));

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(appearance);

    // Act
    PDAppearanceEntry actualRolloverAppearance = (new PDCaretAppearanceHandler(annotation)).getRolloverAppearance();

    // Assert
    PDAppearanceStream appearanceStream = actualRolloverAppearance.getAppearanceStream();
    assertSame(stream, appearanceStream.getStream().getCOSObject());
    assertSame(stream, appearanceStream.getContentStream().getCOSObject());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(stream, actualRolloverAppearance.getCOSObject());
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#getPaddedRectangle(PDRectangle, float)}.
   * <ul>
   *   <li>When {@link PDRectangle#A0}.</li>
   *   <li>Then return COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#getPaddedRectangle(PDRectangle, float)}
   */
  @Test
  @DisplayName("Test getPaddedRectangle(PDRectangle, float); when A0; then return COSArray toList size is four")
  void testGetPaddedRectangle_whenA0_thenReturnCOSArrayToListSizeIsFour() {
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
   * Test
   * {@link PDAbstractAppearanceHandler#addRectDifferences(PDRectangle, float[])}.
   * <ul>
   *   <li>Then return COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#addRectDifferences(PDRectangle, float[])}
   */
  @Test
  @DisplayName("Test addRectDifferences(PDRectangle, float[]); then return COSArray toList size is four")
  void testAddRectDifferences_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange and Act
    PDRectangle actualAddRectDifferencesResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .addRectDifferences(PDRectangle.A0, new float[]{10.0f, 1.0f, 10.0f, 1.0f});

    // Assert
    List<? extends COSBase> toListResult = actualAddRectDifferencesResult.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(-1.0f, actualAddRectDifferencesResult.getLowerLeftY());
    assertEquals(-10.0f, actualAddRectDifferencesResult.getLowerLeftX());
    assertEquals(2393.937f, actualAddRectDifferencesResult.getUpperRightX());
    assertEquals(2403.937f, actualAddRectDifferencesResult.getWidth());
    assertEquals(3371.3938f, actualAddRectDifferencesResult.getUpperRightY());
    assertEquals(3372.3938f, actualAddRectDifferencesResult.getHeight());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#addRectDifferences(PDRectangle, float[])}.
   * <ul>
   *   <li>When empty array of {@code float}.</li>
   *   <li>Then return {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#addRectDifferences(PDRectangle, float[])}
   */
  @Test
  @DisplayName("Test addRectDifferences(PDRectangle, float[]); when empty array of float; then return A0")
  void testAddRectDifferences_whenEmptyArrayOfFloat_thenReturnA0() {
    // Arrange and Act
    PDRectangle actualAddRectDifferencesResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .addRectDifferences(PDRectangle.A0, new float[]{});

    // Assert
    assertSame(actualAddRectDifferencesResult.A0, actualAddRectDifferencesResult);
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#addRectDifferences(PDRectangle, float[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#addRectDifferences(PDRectangle, float[])}
   */
  @Test
  @DisplayName("Test addRectDifferences(PDRectangle, float[]); when 'null'; then return A0")
  void testAddRectDifferences_whenNull_thenReturnA0() {
    // Arrange and Act
    PDRectangle actualAddRectDifferencesResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .addRectDifferences(PDRectangle.A0, null);

    // Assert
    assertSame(actualAddRectDifferencesResult.A0, actualAddRectDifferencesResult);
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle, float[])}.
   * <ul>
   *   <li>Then return COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle, float[])}
   */
  @Test
  @DisplayName("Test applyRectDifferences(PDRectangle, float[]); then return COSArray toList size is four")
  void testApplyRectDifferences_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange and Act
    PDRectangle actualApplyRectDifferencesResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .applyRectDifferences(PDRectangle.A0, new float[]{10.0f, 1.0f, 10.0f, 1.0f});

    // Assert
    List<? extends COSBase> toListResult = actualApplyRectDifferencesResult.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(1.0f, actualApplyRectDifferencesResult.getLowerLeftY());
    assertEquals(10.0f, actualApplyRectDifferencesResult.getLowerLeftX());
    assertEquals(2363.937f, actualApplyRectDifferencesResult.getWidth());
    assertEquals(2373.937f, actualApplyRectDifferencesResult.getUpperRightX());
    assertEquals(3368.3938f, actualApplyRectDifferencesResult.getHeight());
    assertEquals(3369.3938f, actualApplyRectDifferencesResult.getUpperRightY());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle, float[])}.
   * <ul>
   *   <li>When empty array of {@code float}.</li>
   *   <li>Then return {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle, float[])}
   */
  @Test
  @DisplayName("Test applyRectDifferences(PDRectangle, float[]); when empty array of float; then return A0")
  void testApplyRectDifferences_whenEmptyArrayOfFloat_thenReturnA0() {
    // Arrange and Act
    PDRectangle actualApplyRectDifferencesResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .applyRectDifferences(PDRectangle.A0, new float[]{});

    // Assert
    assertSame(actualApplyRectDifferencesResult.A0, actualApplyRectDifferencesResult);
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle, float[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle, float[])}
   */
  @Test
  @DisplayName("Test applyRectDifferences(PDRectangle, float[]); when 'null'; then return A0")
  void testApplyRectDifferences_whenNull_thenReturnA0() {
    // Arrange and Act
    PDRectangle actualApplyRectDifferencesResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .applyRectDifferences(PDRectangle.A0, null);

    // Assert
    assertSame(actualApplyRectDifferencesResult.A0, actualApplyRectDifferencesResult);
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test setOpacity(PDAppearanceContentStream, float); given COSDictionary()")
  void testSetOpacity_givenCOSDictionary() throws IOException {
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
   * Test
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getCOSDictionary(COSName)} return
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test setOpacity(PDAppearanceContentStream, float); given COSDictionary getCOSDictionary(COSName) return COSDictionary()")
  void testSetOpacity_givenCOSDictionaryGetCOSDictionaryReturnCOSDictionary() throws IOException {
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
   * Test
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getCOSDictionary(COSName)} return
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test setOpacity(PDAppearanceContentStream, float); given COSDictionary getCOSDictionary(COSName) return COSStream()")
  void testSetOpacity_givenCOSDictionaryGetCOSDictionaryReturnCOSStream() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSStream());
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
   * Test
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getCOSDictionary(COSName)} return {@code null}.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test setOpacity(PDAppearanceContentStream, float); given COSDictionary getCOSDictionary(COSName) return 'null'; then calls setItem(COSName, COSBase)")
  void testSetOpacity_givenCOSDictionaryGetCOSDictionaryReturnNull_thenCallsSetItem() throws IOException {
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
   * Test
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getKeyForValue(Object)}
   * return {@link COSName#A}.</li>
   *   <li>Then calls {@link COSDictionary#containsValue(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test setOpacity(PDAppearanceContentStream, float); given COSDictionary getKeyForValue(Object) return A; then calls containsValue(Object)")
  void testSetOpacity_givenCOSDictionaryGetKeyForValueReturnA_thenCallsContainsValue() throws IOException {
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
   * Test
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getKeyForValue(Object)}
   * return {@link COSName#ADBE_PKCS7_DETACHED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test setOpacity(PDAppearanceContentStream, float); given COSDictionary getKeyForValue(Object) return ADBE_PKCS7_DETACHED")
  void testSetOpacity_givenCOSDictionaryGetKeyForValueReturnAdbe_pkcs7_detached() throws IOException {
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
   * Test
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getKeyForValue(Object)}
   * return {@link COSName#ADBE_X509_RSA_SHA1}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test setOpacity(PDAppearanceContentStream, float); given COSDictionary getKeyForValue(Object) return ADBE_X509_RSA_SHA1")
  void testSetOpacity_givenCOSDictionaryGetKeyForValueReturnAdbe_x509_rsa_sha1() throws IOException {
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
   * Test
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@link COSStream} {@link COSDictionary#getCOSDictionary(COSName)}
   * return {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test setOpacity(PDAppearanceContentStream, float); given COSStream(); when COSStream getCOSDictionary(COSName) return COSStream()")
  void testSetOpacity_givenCOSStream_whenCOSStreamGetCOSDictionaryReturnCOSStream() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSStream());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 0.5f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret(COSDictionary)} with
   * field is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test setOpacity(PDAppearanceContentStream, float); given PDAnnotationCaret(COSDictionary) with field is COSDictionary()")
  void testSetOpacity_givenPDAnnotationCaretWithFieldIsCOSDictionary() throws IOException {
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
   * Test
   * {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}.
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with
   * one.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName("Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); given ByteArrayOutputStream(int) with one; then calls getCOSDictionary(COSName)")
  void testDrawStyle_givenByteArrayOutputStreamWithOne_thenCallsGetCOSDictionary() throws IOException {
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
   * Test
   * {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code -9.223372E18}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName("Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when '-9.223372E18'; then calls getCOSDictionary(COSName)")
  void testDrawStyle_when9223372e18_thenCallsGetCOSDictionary() throws IOException {
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
   * Test
   * {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code -9.223372E18}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName("Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when '-9.223372E18'; then calls getCOSDictionary(COSName)")
  void testDrawStyle_when9223372e18_thenCallsGetCOSDictionary2() throws IOException {
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
   * Test
   * {@link PDAbstractAppearanceHandler#drawArrow(PDAppearanceContentStream, float, float, float)}.
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with
   * one.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawArrow(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  @DisplayName("Test drawArrow(PDAppearanceContentStream, float, float, float); given ByteArrayOutputStream(int) with one; then calls getCOSDictionary(COSName)")
  void testDrawArrow_givenByteArrayOutputStreamWithOne_thenCallsGetCOSDictionary() throws IOException {
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
   * Test
   * {@link PDAbstractAppearanceHandler#drawArrow(PDAppearanceContentStream, float, float, float)}.
   * <ul>
   *   <li>When {@code -9.223372E18}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawArrow(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  @DisplayName("Test drawArrow(PDAppearanceContentStream, float, float, float); when '-9.223372E18'; then calls getCOSDictionary(COSName)")
  void testDrawArrow_when9223372e18_thenCallsGetCOSDictionary() throws IOException {
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
   * Test
   * {@link PDAbstractAppearanceHandler#drawDiamond(PDAppearanceContentStream, float, float, float)}.
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with
   * one.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawDiamond(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  @DisplayName("Test drawDiamond(PDAppearanceContentStream, float, float, float); given ByteArrayOutputStream(int) with one; then calls getCOSDictionary(COSName)")
  void testDrawDiamond_givenByteArrayOutputStreamWithOne_thenCallsGetCOSDictionary() throws IOException {
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
   * Test
   * {@link PDAbstractAppearanceHandler#drawDiamond(PDAppearanceContentStream, float, float, float)}.
   * <ul>
   *   <li>When {@code -9.223372E18}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawDiamond(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  @DisplayName("Test drawDiamond(PDAppearanceContentStream, float, float, float); when '-9.223372E18'; then calls getCOSDictionary(COSName)")
  void testDrawDiamond_when9223372e18_thenCallsGetCOSDictionary() throws IOException {
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
   * Test
   * {@link PDAbstractAppearanceHandler#drawCircle(PDAppearanceContentStream, float, float, float)}.
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with
   * one.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawCircle(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  @DisplayName("Test drawCircle(PDAppearanceContentStream, float, float, float); given ByteArrayOutputStream(int) with one; then calls getCOSDictionary(COSName)")
  void testDrawCircle_givenByteArrayOutputStreamWithOne_thenCallsGetCOSDictionary() throws IOException {
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
   * Test
   * {@link PDAbstractAppearanceHandler#drawCircle(PDAppearanceContentStream, float, float, float)}.
   * <ul>
   *   <li>When {@code -9.223372E18}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawCircle(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  @DisplayName("Test drawCircle(PDAppearanceContentStream, float, float, float); when '-9.223372E18'; then calls getCOSDictionary(COSName)")
  void testDrawCircle_when9223372e18_thenCallsGetCOSDictionary() throws IOException {
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
   * Test
   * {@link PDAbstractAppearanceHandler#drawCircle2(PDAppearanceContentStream, float, float, float)}.
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with
   * one.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawCircle2(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  @DisplayName("Test drawCircle2(PDAppearanceContentStream, float, float, float); given ByteArrayOutputStream(int) with one; then calls getCOSDictionary(COSName)")
  void testDrawCircle2_givenByteArrayOutputStreamWithOne_thenCallsGetCOSDictionary() throws IOException {
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
   * Test
   * {@link PDAbstractAppearanceHandler#drawCircle2(PDAppearanceContentStream, float, float, float)}.
   * <ul>
   *   <li>When {@code -9.223372E18}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#drawCircle2(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  @DisplayName("Test drawCircle2(PDAppearanceContentStream, float, float, float); when '-9.223372E18'; then calls getCOSDictionary(COSName)")
  void testDrawCircle2_when9223372e18_thenCallsGetCOSDictionary() throws IOException {
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
   * Test
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}.
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  @DisplayName("Test handleBorderBox(PDAnnotationSquareCircle, float)")
  void testHandleBorderBox() {
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
    List<? extends COSBase> toListResult = actualHandleBorderBoxResult.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(3);
    assertTrue(getResult3 instanceof COSFloat);
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftY());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightY());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}.
   * <ul>
   *   <li>Given array of {@code float} with two and ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  @DisplayName("Test handleBorderBox(PDAnnotationSquareCircle, float); given array of float with two and ten")
  void testHandleBorderBox_givenArrayOfFloatWithTwoAndTen() {
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
    List<? extends COSBase> toListResult = actualHandleBorderBoxResult.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(3);
    assertTrue(getResult3 instanceof COSFloat);
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftY());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightY());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSBase#isDirect()} return
   * {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  @DisplayName("Test handleBorderBox(PDAnnotationSquareCircle, float); given COSArray isDirect() return 'false'; then calls getKey()")
  void testHandleBorderBox_givenCOSArrayIsDirectReturnFalse_thenCallsGetKey() {
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
    List<? extends COSBase> toListResult = actualHandleBorderBoxResult.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(3);
    assertTrue(getResult3 instanceof COSFloat);
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftY());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightY());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}.
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()} Rectangle is
   * {@link PDRectangle#A0}.</li>
   *   <li>Then return Width is {@code 2373.937}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  @DisplayName("Test handleBorderBox(PDAnnotationSquareCircle, float); given PDAnnotationCaret() Rectangle is A0; then return Width is '2373.937'")
  void testHandleBorderBox_givenPDAnnotationCaretRectangleIsA0_thenReturnWidthIs2373937() {
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
    assertEquals(2373.937f, actualHandleBorderBoxResult.getWidth());
    assertEquals(2378.937f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(3360.3938f, actualHandleBorderBoxResult.getHeight());
    assertEquals(3365.3938f, actualHandleBorderBoxResult.getUpperRightY());
    assertEquals(5.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(5.0f, actualHandleBorderBoxResult.getLowerLeftY());
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}.
   * <ul>
   *   <li>Given {@link PDAppearanceStream}
   * {@link PDFormXObject#setBBox(PDRectangle)} does nothing.</li>
   *   <li>Then calls {@link PDFormXObject#setBBox(PDRectangle)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  @DisplayName("Test handleBorderBox(PDAnnotationSquareCircle, float); given PDAppearanceStream setBBox(PDRectangle) does nothing; then calls setBBox(PDRectangle)")
  void testHandleBorderBox_givenPDAppearanceStreamSetBBoxDoesNothing_thenCallsSetBBox() {
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
    List<? extends COSBase> toListResult = actualHandleBorderBoxResult.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(3);
    assertTrue(getResult3 instanceof COSFloat);
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftY());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightY());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}.
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getCOSArray()} return
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  @DisplayName("Test handleBorderBox(PDAnnotationSquareCircle, float); given PDRectangle getCOSArray() return COSArray()")
  void testHandleBorderBox_givenPDRectangleGetCOSArrayReturnCOSArray() {
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
    List<? extends COSBase> toListResult = actualHandleBorderBoxResult.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(3);
    assertTrue(getResult3 instanceof COSFloat);
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftY());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightY());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}.
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getCOSArray()} return
   * {@code null}.</li>
   *   <li>Then calls {@link PDRectangle#getCOSArray()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  @DisplayName("Test handleBorderBox(PDAnnotationSquareCircle, float); given PDRectangle getCOSArray() return 'null'; then calls getCOSArray()")
  void testHandleBorderBox_givenPDRectangleGetCOSArrayReturnNull_thenCallsGetCOSArray() {
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
    List<? extends COSBase> toListResult = actualHandleBorderBoxResult.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(3);
    assertTrue(getResult3 instanceof COSFloat);
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftY());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightY());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}.
   * <ul>
   *   <li>Then calls
   * {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  @DisplayName("Test handleBorderBox(PDAnnotationSquareCircle, float); then calls setOriginDocumentState(COSDocumentState)")
  void testHandleBorderBox_thenCallsSetOriginDocumentState() {
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
    List<? extends COSBase> toListResult = actualHandleBorderBoxResult.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(3);
    assertTrue(getResult3 instanceof COSFloat);
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getLowerLeftY());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(15.0f, actualHandleBorderBoxResult.getUpperRightY());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}.
   * <ul>
   *   <li>Then return COSArray toList second Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  @DisplayName("Test handleBorderBox(PDAnnotationSquareCircle, float); then return COSArray toList second Key is 'null'")
  void testHandleBorderBox_thenReturnCOSArrayToListSecondKeyIsNull() {
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
    List<? extends COSBase> toListResult = actualHandleBorderBoxResult.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(-1.0f, actualHandleBorderBoxResult.getHeight());
    assertEquals(-20.0f, actualHandleBorderBoxResult.getWidth());
    assertEquals(14.5f, actualHandleBorderBoxResult.getUpperRightY());
    assertEquals(15.5f, actualHandleBorderBoxResult.getLowerLeftY());
    assertEquals(25.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(5.0f, actualHandleBorderBoxResult.getUpperRightX());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}.
   * <ul>
   *   <li>Then return LowerLeftX is {@code 2.14748365E9}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  @DisplayName("Test handleBorderBox(PDAnnotationSquareCircle, float); then return LowerLeftX is '2.14748365E9'")
  void testHandleBorderBox_thenReturnLowerLeftXIs214748365e9() {
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
    List<? extends COSBase> toListResult = actualHandleBorderBoxResult.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(2.14748365E9f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(2.14748365E9f, actualHandleBorderBoxResult.getLowerLeftY());
    assertEquals(2.14748365E9f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(2.14748365E9f, actualHandleBorderBoxResult.getUpperRightY());
    COSBase getResult3 = toListResult.get(0);
    assertEquals(getResult3, getResult);
    assertEquals(getResult3, getResult2);
  }
}
