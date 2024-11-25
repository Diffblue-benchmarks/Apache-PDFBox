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
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFileAttachment;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFileAttachmentAppearanceHandlerDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PDFileAttachmentAppearanceHandler#PDFileAttachmentAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDFileAttachmentAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDFileAttachmentAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  void testGettersAndSetters_whenPDAnnotationCaret() {
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

  /**
   * Test {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance() {
    // Arrange
    PDFileAttachmentAppearanceHandler pdFileAttachmentAppearanceHandler = new PDFileAttachmentAppearanceHandler(
        new PDAnnotationFileAttachment());

    // Act
    pdFileAttachmentAppearanceHandler.generateNormalAppearance();

    // Assert that nothing has changed
    PDAppearanceEntry downAppearance = pdFileAttachmentAppearanceHandler.getDownAppearance();
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    Matrix matrix = downAppearance.getAppearanceStream().getMatrix();
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
  }

  /**
   * Test {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance2() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
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
    PDRectangle bBox = pdFileAttachmentAppearanceHandler.getDownAppearance().getAppearanceStream().getBBox();
    List<? extends COSBase> toListResult = bBox.getCOSArray().toList();
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
    PDAppearanceDictionary appearance = pdFileAttachmentAppearanceHandler.getAppearance();
    PDRectangle bBox2 = appearance.getDownAppearance().getAppearanceStream().getBBox();
    assertEquals(0.0f, bBox2.getHeight());
    assertEquals(0.0f, bBox.getHeight());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getUpperRightX());
    assertEquals(0.0f, bBox.getUpperRightX());
    assertEquals(0.0f, bBox2.getWidth());
    assertEquals(0.0f, bBox.getWidth());
    assertFalse(getResult.isDirect());
    assertEquals(toListResult, bBox2.getCOSArray().toList());
    assertEquals(toListResult, appearance.getNormalAppearance().getAppearanceStream().getBBox().getCOSArray().toList());
    assertEquals(toListResult,
        appearance.getRolloverAppearance().getAppearanceStream().getBBox().getCOSArray().toList());
    assertEquals(toListResult,
        pdFileAttachmentAppearanceHandler.getRolloverAppearance()
            .getAppearanceStream()
            .getBBox()
            .getCOSArray()
            .toList());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
  }

  /**
   * Test {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance3() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
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
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    Matrix matrix = downAppearance.getAppearanceStream().getMatrix();
    assertEquals(-10.0f, matrix.getTranslateX());
    assertEquals(-10.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-10.0f, floatArray[0]);
    assertEquals(-10.0f, floatArray[1]);
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Test {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSBase#isDirect()} return
   * {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFileAttachmentAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given COSArray isDirect() return 'false'; then calls getKey()")
  void testGenerateNormalAppearance_givenCOSArrayIsDirectReturnFalse_thenCallsGetKey() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
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
    Matrix matrix = pdFileAttachmentAppearanceHandler.getDownAppearance().getAppearanceStream().getMatrix();
    assertEquals(-10.0f, matrix.getTranslateX());
    assertEquals(-10.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-10.0f, floatArray[0]);
    assertEquals(-10.0f, floatArray[1]);
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
  }
}
