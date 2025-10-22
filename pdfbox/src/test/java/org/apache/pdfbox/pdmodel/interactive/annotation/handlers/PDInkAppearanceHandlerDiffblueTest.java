package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDInkAppearanceHandlerDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDInkAppearanceHandler#PDInkAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDInkAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDInkAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInkAppearanceHandler.<init>(PDAnnotation)",
      "void PDInkAppearanceHandler.<init>(PDAnnotation, org.apache.pdfbox.pdmodel.PDDocument)",
      "void PDInkAppearanceHandler.generateDownAppearance()",
      "void PDInkAppearanceHandler.generateRolloverAppearance()"})
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDInkAppearanceHandler actualPdInkAppearanceHandler = new PDInkAppearanceHandler(annotation);
    actualPdInkAppearanceHandler.generateDownAppearance();
    actualPdInkAppearanceHandler.generateRolloverAppearance();

    // Assert
    assertTrue(actualPdInkAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdInkAppearanceHandler.getAnnotation());
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance() {
    // Arrange
    PDInkAppearanceHandler pdInkAppearanceHandler = new PDInkAppearanceHandler(new PDAnnotationInk());

    // Act
    pdInkAppearanceHandler.generateNormalAppearance();

    // Assert that nothing has changed
    assertTrue(pdInkAppearanceHandler.getDownAppearance().getCOSObject() instanceof COSStream);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance2() {
    // Arrange
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
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
    PDAppearanceStream appearanceStream = pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-1.5f, bBox.getLowerLeftY());
    PDRectangle bBox2 = pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream().getBBox();
    assertEquals(-1.5f, bBox2.getLowerLeftY());
    assertEquals(1.5f, matrix.getTranslateY());
    assertEquals(12.0f, bBox.getUpperRightX());
    assertEquals(12.0f, bBox2.getUpperRightX());
    assertEquals(12.0f, bBox.getWidth());
    assertEquals(12.0f, bBox2.getWidth());
    assertEquals(2.5f, bBox.getUpperRightY());
    assertEquals(2.5f, bBox2.getUpperRightY());
    assertEquals(4.0f, bBox.getHeight());
    assertEquals(4.0f, bBox2.getHeight());
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance3() {
    // Arrange
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(Float.MIN_VALUE);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
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
    PDAppearanceStream appearanceStream = pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    Iterable<COSName> extGStateNames = appearanceStream.getResources().getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals(1, ((Set<COSName>) extGStateNames).size());
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(52, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(52, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(52, appearanceStream4.getStream().getLength());
    assertEquals(52, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(52, appearanceStream5.getStream().getLength());
    assertEquals(52, appearanceStream2.getContentStream().getLength());
    assertEquals(52, appearanceStream3.getContentStream().getLength());
    assertEquals(52, appearanceStream4.getContentStream().getLength());
    assertEquals(52, appearanceStream.getContentStream().getLength());
    assertEquals(52, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-0.0f, 1.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance4() {
    // Arrange
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
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
    PDRectangle rectangle = pdInkAppearanceHandler.getRectangle();
    assertEquals(-1.5f, rectangle.getLowerLeftY());
    assertEquals(12.0f, rectangle.getUpperRightX());
    assertEquals(12.0f, rectangle.getWidth());
    assertEquals(2.5f, rectangle.getUpperRightY());
    assertEquals(4.0f, rectangle.getHeight());
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance5() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
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
    PDRectangle bBox = pdInkAppearanceHandler.getAppearance().getDownAppearance().getAppearanceStream().getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDAppearanceStream appearanceStream = pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getHeight());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(0.0f, bBox2.getLowerLeftY());
    assertEquals(0.0f, bBox.getUpperRightX());
    assertEquals(0.0f, bBox2.getUpperRightX());
    assertEquals(0.0f, bBox.getUpperRightY());
    assertEquals(0.0f, bBox2.getUpperRightY());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bBox2.getWidth());
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    List<? extends COSBase> toListResult = bBox2.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertEquals(toListResult,
        pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream().getBBox().getCOSArray().toList());
    assertArrayEquals(new float[]{-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance6() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
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
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream4.getStream().getLength());
    assertEquals(44, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream5.getStream().getLength());
    assertEquals(44, appearanceStream2.getContentStream().getLength());
    assertEquals(44, appearanceStream3.getContentStream().getLength());
    assertEquals(44, appearanceStream4.getContentStream().getLength());
    assertEquals(44, appearanceStream.getContentStream().getLength());
    assertEquals(44, appearanceStream5.getContentStream().getLength());
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    assertArrayEquals(new float[]{-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance7() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
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
    PDAppearanceStream appearanceStream = pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(45, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(45, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(45, appearanceStream4.getStream().getLength());
    assertEquals(45, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(45, appearanceStream5.getStream().getLength());
    assertEquals(45, appearanceStream2.getContentStream().getLength());
    assertEquals(45, appearanceStream3.getContentStream().getLength());
    assertEquals(45, appearanceStream4.getContentStream().getLength());
    assertEquals(45, appearanceStream.getContentStream().getLength());
    assertEquals(45, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance8() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{Float.MAX_VALUE, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
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
    PDAppearanceStream appearanceStream = pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(82, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(82, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(82, appearanceStream4.getStream().getLength());
    assertEquals(82, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(82, appearanceStream5.getStream().getLength());
    assertEquals(82, appearanceStream2.getContentStream().getLength());
    assertEquals(82, appearanceStream3.getContentStream().getLength());
    assertEquals(82, appearanceStream4.getContentStream().getLength());
    assertEquals(82, appearanceStream.getContentStream().getLength());
    assertEquals(82, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance9() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
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
    PDAppearanceStream appearanceStream = pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(45, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(45, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(45, appearanceStream4.getStream().getLength());
    assertEquals(45, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(45, appearanceStream5.getStream().getLength());
    assertEquals(45, appearanceStream2.getContentStream().getLength());
    assertEquals(45, appearanceStream3.getContentStream().getLength());
    assertEquals(45, appearanceStream4.getContentStream().getLength());
    assertEquals(45, appearanceStream.getContentStream().getLength());
    assertEquals(45, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance10() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceRGB.INSTANCE));
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
    PDAppearanceStream appearanceStream = pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(48, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(48, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(48, appearanceStream4.getStream().getLength());
    assertEquals(48, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(48, appearanceStream5.getStream().getLength());
    assertEquals(48, appearanceStream2.getContentStream().getLength());
    assertEquals(48, appearanceStream3.getContentStream().getLength());
    assertEquals(48, appearanceStream4.getContentStream().getLength());
    assertEquals(48, appearanceStream.getContentStream().getLength());
    assertEquals(48, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance11() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    COSArray array = new COSArray();
    when(annotation.getColor()).thenReturn(new PDColor(array, new PDCalGray()));
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
    PDAppearanceStream appearanceStream = pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(38, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(38, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(38, appearanceStream4.getStream().getLength());
    assertEquals(38, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(38, appearanceStream5.getStream().getLength());
    assertEquals(38, appearanceStream2.getContentStream().getLength());
    assertEquals(38, appearanceStream3.getContentStream().getLength());
    assertEquals(38, appearanceStream4.getContentStream().getLength());
    assertEquals(38, appearanceStream.getContentStream().getLength());
    assertEquals(38, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance12() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    COSArray array = new COSArray();
    when(annotation.getColor()).thenReturn(new PDColor(array, new PDSeparation()));
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
    PDAppearanceStream appearanceStream = pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream4.getStream().getLength());
    assertEquals(39, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream5.getStream().getLength());
    assertEquals(39, appearanceStream2.getContentStream().getLength());
    assertEquals(39, appearanceStream3.getContentStream().getLength());
    assertEquals(39, appearanceStream4.getContentStream().getLength());
    assertEquals(39, appearanceStream.getContentStream().getLength());
    assertEquals(39, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSBase#isDirect()} return {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given COSArray isDirect() return 'false'; then calls getKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSArrayIsDirectReturnFalse_thenCallsGetKey() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
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
    PDAppearanceStream appearanceStream = pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream4.getStream().getLength());
    assertEquals(44, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream5.getStream().getLength());
    assertEquals(44, appearanceStream2.getContentStream().getLength());
    assertEquals(44, appearanceStream3.getContentStream().getLength());
    assertEquals(44, appearanceStream4.getContentStream().getLength());
    assertEquals(44, appearanceStream.getContentStream().getLength());
    assertEquals(44, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link PDBorderStyleDictionary} {@link PDBorderStyleDictionary#getStyle()} return {@code U}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDBorderStyleDictionary getStyle() return 'U'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDBorderStyleDictionaryGetStyleReturnU() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
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
    PDAppearanceStream appearanceStream = pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(45, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(45, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(45, appearanceStream4.getStream().getLength());
    assertEquals(45, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(45, appearanceStream5.getStream().getLength());
    assertEquals(45, appearanceStream2.getContentStream().getLength());
    assertEquals(45, appearanceStream3.getContentStream().getLength());
    assertEquals(45, appearanceStream4.getContentStream().getLength());
    assertEquals(45, appearanceStream.getContentStream().getLength());
    assertEquals(45, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }
}
