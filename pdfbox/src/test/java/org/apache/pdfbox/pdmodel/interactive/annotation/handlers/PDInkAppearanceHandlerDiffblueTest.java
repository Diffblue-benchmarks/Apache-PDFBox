package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceN;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDICCBased;
import org.apache.pdfbox.pdmodel.graphics.color.PDPattern;
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
   *
   * <ul>
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDInkAppearanceHandler#PDInkAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDInkAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDInkAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDInkAppearanceHandler.<init>(PDAnnotation)",
    "void PDInkAppearanceHandler.<init>(PDAnnotation, PDDocument)",
    "void PDInkAppearanceHandler.generateDownAppearance()",
    "void PDInkAppearanceHandler.generateRolloverAppearance()"
  })
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
   *
   * <p>Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance() {
    // Arrange
    PDInkAppearanceHandler pdInkAppearanceHandler =
        new PDInkAppearanceHandler(new PDAnnotationInk());

    // Act
    pdInkAppearanceHandler.generateNormalAppearance();

    // Assert that nothing has changed
    assertTrue(pdInkAppearanceHandler.getDownAppearance().getCOSObject() instanceof COSStream);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance2() {
    // Arrange
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getInkList())
        .thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
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
    PDAppearanceStream appearanceStream =
        pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(-1.5f, bBox.getLowerLeftY());
    PDRectangle bBox2 =
        pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream().getBBox();
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
   *
   * <p>Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance3() {
    // Arrange
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getInkList())
        .thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
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
   *
   * <p>Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance4() {
    // Arrange
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getInkList())
        .thenReturn(
            new float[][] {
              new float[] {
                1.0f,
                Float.MAX_VALUE,
                1.0f,
                Float.MAX_VALUE,
                1.0f,
                Float.MAX_VALUE,
                1.0f,
                Float.MAX_VALUE
              }
            });
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
    PDRectangle rectangle = pdInkAppearanceHandler.getRectangle();
    assertEquals(-1.0f, rectangle.getLowerLeftX());
    assertEquals(3.0f, rectangle.getUpperRightX());
    assertEquals(4.0f, rectangle.getWidth());
    assertEquals(Float.MAX_VALUE, rectangle.getHeight());
    assertEquals(Float.MAX_VALUE, rectangle.getUpperRightY());
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance5() {
    // Arrange
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getInkList())
        .thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceRGB.INSTANCE));
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
    PDAppearanceStream appearanceStream =
        pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(47, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(47, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(47, appearanceStream4.getStream().getLength());
    assertEquals(47, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(47, appearanceStream5.getStream().getLength());
    assertEquals(47, appearanceStream2.getContentStream().getLength());
    assertEquals(47, appearanceStream3.getContentStream().getLength());
    assertEquals(47, appearanceStream4.getContentStream().getLength());
    assertEquals(47, appearanceStream.getContentStream().getLength());
    assertEquals(47, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-0.0f, 1.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance6() {
    // Arrange
    PDAnnotationInk annotation = mock(PDAnnotationInk.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getInkList())
        .thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    COSArray array = new COSArray();
    PDColor pdColor = new PDColor(array, new PDCalGray());
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
    PDAppearanceStream appearanceStream =
        pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(37, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(37, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(37, appearanceStream4.getStream().getLength());
    assertEquals(37, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(37, appearanceStream5.getStream().getLength());
    assertEquals(37, appearanceStream2.getContentStream().getLength());
    assertEquals(37, appearanceStream3.getContentStream().getLength());
    assertEquals(37, appearanceStream4.getContentStream().getLength());
    assertEquals(37, appearanceStream.getContentStream().getLength());
    assertEquals(37, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-0.0f, 1.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance7() {
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
    when(annotation.getInkList())
        .thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
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
    verify(pdRectangle).setLowerLeftX(8.0f);
    verify(pdRectangle).setLowerLeftY(-1.5f);
    verify(pdRectangle).setUpperRightX(12.0f);
    verify(pdRectangle).setUpperRightY(10.0f);
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    PDRectangle bBox =
        pdInkAppearanceHandler.getAppearance().getDownAppearance().getAppearanceStream().getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDAppearanceStream appearanceStream =
        pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    PDRectangle bBox2 = appearanceStream.getBBox();
    assertEquals(0.0f, bBox2.getHeight());
    assertEquals(0.0f, bBox.getUpperRightX());
    assertEquals(0.0f, bBox2.getUpperRightX());
    assertEquals(0.0f, bBox.getUpperRightY());
    assertEquals(0.0f, bBox2.getUpperRightY());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(0.0f, bBox2.getWidth());
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(4, bBox2.getCOSArray().toList().size());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance8() {
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
    when(annotation.getInkList())
        .thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
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
    verify(pdRectangle).setLowerLeftX(8.0f);
    verify(pdRectangle).setLowerLeftY(-1.5f);
    verify(pdRectangle).setUpperRightX(12.0f);
    verify(pdRectangle).setUpperRightY(10.0f);
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
    float[][] values = downAppearance.getAppearanceStream().getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream3.getStream().getLength());
    assertEquals(44, appearanceStream.getContentStream().getLength());
    assertEquals(44, appearanceStream2.getContentStream().getLength());
    assertEquals(44, appearanceStream3.getContentStream().getLength());
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance9() {
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
    when(annotation.getInkList())
        .thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
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
    verify(pdRectangle).setLowerLeftX(-10.0f);
    verify(pdRectangle).setLowerLeftY(-19.5f);
    verify(pdRectangle).setUpperRightX(30.0f);
    verify(pdRectangle).setUpperRightY(20.5f);
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
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
    PDAppearanceStream appearanceStream5 =
        pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(45, appearanceStream5.getStream().getLength());
    assertEquals(45, appearanceStream2.getContentStream().getLength());
    assertEquals(45, appearanceStream3.getContentStream().getLength());
    assertEquals(45, appearanceStream4.getContentStream().getLength());
    assertEquals(45, appearanceStream.getContentStream().getLength());
    assertEquals(45, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance10() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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
    when(annotation.getConstantOpacity()).thenReturn(0.5f);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getInkList())
        .thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
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
    verify(pdRectangle).setLowerLeftX(-10.0f);
    verify(pdRectangle).setLowerLeftY(-19.5f);
    verify(pdRectangle).setUpperRightX(30.0f);
    verify(pdRectangle).setUpperRightY(20.5f);
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    Iterable<COSName> extGStateNames = appearanceStream.getResources().getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals(1, ((Set<COSName>) extGStateNames).size());
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(65, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(65, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(65, appearanceStream4.getStream().getLength());
    assertEquals(65, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(65, appearanceStream5.getStream().getLength());
    assertEquals(65, appearanceStream2.getContentStream().getLength());
    assertEquals(65, appearanceStream3.getContentStream().getLength());
    assertEquals(65, appearanceStream4.getContentStream().getLength());
    assertEquals(65, appearanceStream.getContentStream().getLength());
    assertEquals(65, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance11() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

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
    when(annotation.getInkList())
        .thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
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
    verify(pdRectangle).setLowerLeftX(-10.0f);
    verify(pdRectangle).setLowerLeftY(-19.5f);
    verify(pdRectangle).setUpperRightX(30.0f);
    verify(pdRectangle).setUpperRightY(20.5f);
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(57, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(57, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(57, appearanceStream4.getStream().getLength());
    assertEquals(57, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(57, appearanceStream5.getStream().getLength());
    assertEquals(57, appearanceStream2.getContentStream().getLength());
    assertEquals(57, appearanceStream3.getContentStream().getLength());
    assertEquals(57, appearanceStream4.getContentStream().getLength());
    assertEquals(57, appearanceStream.getContentStream().getLength());
    assertEquals(57, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance12() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getColorSpace()).thenReturn(new PDICCBased(new PDDocument()));
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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
    when(annotation.getInkList())
        .thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
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
    verify(pdRectangle).setLowerLeftX(-10.0f);
    verify(pdRectangle).setLowerLeftY(-19.5f);
    verify(pdRectangle).setUpperRightX(30.0f);
    verify(pdRectangle).setUpperRightY(20.5f);
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(51, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(51, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(51, appearanceStream4.getStream().getLength());
    assertEquals(51, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(51, appearanceStream5.getStream().getLength());
    assertEquals(51, appearanceStream2.getContentStream().getLength());
    assertEquals(51, appearanceStream3.getContentStream().getLength());
    assertEquals(51, appearanceStream4.getContentStream().getLength());
    assertEquals(51, appearanceStream.getContentStream().getLength());
    assertEquals(51, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance13() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getPatternName()).thenReturn(COSName.A);
    when(pdColor.getColorSpace()).thenReturn(new PDPattern(new PDResources()));
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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
    when(annotation.getInkList())
        .thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
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
    verify(pdRectangle).setLowerLeftX(-10.0f);
    verify(pdRectangle).setLowerLeftY(-19.5f);
    verify(pdRectangle).setUpperRightX(30.0f);
    verify(pdRectangle).setUpperRightY(20.5f);
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdColor).getPatternName();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(54, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(54, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(54, appearanceStream4.getStream().getLength());
    assertEquals(54, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(54, appearanceStream5.getStream().getLength());
    assertEquals(54, appearanceStream2.getContentStream().getLength());
    assertEquals(54, appearanceStream3.getContentStream().getLength());
    assertEquals(54, appearanceStream4.getContentStream().getLength());
    assertEquals(54, appearanceStream.getContentStream().getLength());
    assertEquals(54, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance14() throws IOException {
    // Arrange
    COSName cosName = mock(COSName.class);
    doThrow(new IOException()).when(cosName).writePDF(Mockito.<OutputStream>any());

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getPatternName()).thenReturn(cosName);
    when(pdColor.getColorSpace()).thenReturn(new PDPattern(new PDResources()));
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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
    when(annotation.getInkList())
        .thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getColor()).thenReturn(pdColor);
    PDInkAppearanceHandler pdInkAppearanceHandler = new PDInkAppearanceHandler(annotation);

    // Act
    pdInkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosName).writePDF(isA(OutputStream.class));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(-10.0f);
    verify(pdRectangle).setLowerLeftY(-19.5f);
    verify(pdRectangle).setUpperRightX(30.0f);
    verify(pdRectangle).setUpperRightY(20.5f);
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdColor).getPatternName();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream5.getStream().getLength());
    assertEquals(22, appearanceStream.getContentStream().getLength());
    assertEquals(22, appearanceStream2.getContentStream().getLength());
    assertEquals(22, appearanceStream3.getContentStream().getLength());
    assertEquals(22, appearanceStream4.getContentStream().getLength());
    assertEquals(22, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance15() throws IOException {
    // Arrange
    COSName cosName = mock(COSName.class);
    doThrow(new IOException()).when(cosName).writePDF(Mockito.<OutputStream>any());

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getPatternName()).thenReturn(cosName);
    when(pdColor.getColorSpace()).thenReturn(new PDPattern(new PDResources()));
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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
    when(annotation.getInkList())
        .thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getColor()).thenReturn(pdColor);
    PDInkAppearanceHandler pdInkAppearanceHandler = new PDInkAppearanceHandler(annotation);

    // Act
    pdInkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosName).writePDF(isA(OutputStream.class));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(-10.0f);
    verify(pdRectangle).setLowerLeftY(-19.5f);
    verify(pdRectangle).setUpperRightX(30.0f);
    verify(pdRectangle).setUpperRightY(20.5f);
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdColor).getPatternName();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream5.getStream().getLength());
    assertEquals(22, appearanceStream.getContentStream().getLength());
    assertEquals(22, appearanceStream2.getContentStream().getLength());
    assertEquals(22, appearanceStream3.getContentStream().getLength());
    assertEquals(22, appearanceStream4.getContentStream().getLength());
    assertEquals(22, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance16() throws IOException {
    // Arrange
    COSName cosName = mock(COSName.class);
    doThrow(new IOException()).when(cosName).writePDF(Mockito.<OutputStream>any());

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getPatternName()).thenReturn(cosName);
    when(pdColor.getColorSpace()).thenReturn(new PDPattern(new PDResources()));
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDLineDashPattern pdLineDashPattern = mock(PDLineDashPattern.class);
    when(pdLineDashPattern.getDashArray()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(pdLineDashPattern);
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
    when(annotation.getInkList())
        .thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getColor()).thenReturn(pdColor);
    PDInkAppearanceHandler pdInkAppearanceHandler = new PDInkAppearanceHandler(annotation);

    // Act
    pdInkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosName).writePDF(isA(OutputStream.class));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(-10.0f);
    verify(pdRectangle).setLowerLeftY(-19.5f);
    verify(pdRectangle).setUpperRightX(30.0f);
    verify(pdRectangle).setUpperRightY(20.5f);
    verify(pdLineDashPattern).getDashArray();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdColor).getPatternName();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream5.getStream().getLength());
    assertEquals(22, appearanceStream.getContentStream().getLength());
    assertEquals(22, appearanceStream2.getContentStream().getLength());
    assertEquals(22, appearanceStream3.getContentStream().getLength());
    assertEquals(22, appearanceStream4.getContentStream().getLength());
    assertEquals(22, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance17() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDLineDashPattern pdLineDashPattern = mock(PDLineDashPattern.class);
    when(pdLineDashPattern.getDashArray()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(pdLineDashPattern);
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
    when(annotation.getInkList())
        .thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
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
    verify(pdRectangle).setLowerLeftX(-10.0f);
    verify(pdRectangle).setLowerLeftY(-19.5f);
    verify(pdRectangle).setUpperRightX(30.0f);
    verify(pdRectangle).setUpperRightY(20.5f);
    verify(pdLineDashPattern).getDashArray();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
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
    PDAppearanceStream appearanceStream =
        pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(74, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(74, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(74, appearanceStream4.getStream().getLength());
    assertEquals(74, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(74, appearanceStream5.getStream().getLength());
    assertEquals(74, appearanceStream2.getContentStream().getLength());
    assertEquals(74, appearanceStream3.getContentStream().getLength());
    assertEquals(74, appearanceStream4.getContentStream().getLength());
    assertEquals(74, appearanceStream.getContentStream().getLength());
    assertEquals(74, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance18() throws IOException {
    // Arrange
    COSName cosName = mock(COSName.class);
    doThrow(new IOException()).when(cosName).writePDF(Mockito.<OutputStream>any());

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getPatternName()).thenReturn(cosName);
    when(pdColor.getColorSpace()).thenReturn(new PDPattern(new PDResources()));
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDLineDashPattern pdLineDashPattern = mock(PDLineDashPattern.class);
    when(pdLineDashPattern.getDashArray()).thenReturn(new float[] {0.0f, 0.0f, 10.0f, 0.0f});

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(pdLineDashPattern);
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
    when(annotation.getInkList())
        .thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getColor()).thenReturn(pdColor);
    PDInkAppearanceHandler pdInkAppearanceHandler = new PDInkAppearanceHandler(annotation);

    // Act
    pdInkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosName).writePDF(isA(OutputStream.class));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(-10.0f);
    verify(pdRectangle).setLowerLeftY(-19.5f);
    verify(pdRectangle).setUpperRightX(30.0f);
    verify(pdRectangle).setUpperRightY(20.5f);
    verify(pdLineDashPattern).getDashArray();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdColor).getPatternName();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream5.getStream().getLength());
    assertEquals(22, appearanceStream.getContentStream().getLength());
    assertEquals(22, appearanceStream2.getContentStream().getLength());
    assertEquals(22, appearanceStream3.getContentStream().getLength());
    assertEquals(22, appearanceStream4.getContentStream().getLength());
    assertEquals(22, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDInkAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDColor} {@link PDColor#getColorSpace()} return {@link
   *       PDDeviceN#PDDeviceN()}.
   * </ul>
   *
   * <p>Method under test: {@link PDInkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDColor getColorSpace() return PDDeviceN()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDInkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDColorGetColorSpaceReturnPDDeviceN() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getColorSpace()).thenReturn(new PDDeviceN());
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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
    when(annotation.getInkList())
        .thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
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
    verify(pdRectangle).setLowerLeftX(-10.0f);
    verify(pdRectangle).setLowerLeftY(-19.5f);
    verify(pdRectangle).setUpperRightX(30.0f);
    verify(pdRectangle).setUpperRightY(20.5f);
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation, atLeast(1)).getInkList();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdInkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdInkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(51, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(51, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(51, appearanceStream4.getStream().getLength());
    assertEquals(51, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdInkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(51, appearanceStream5.getStream().getLength());
    assertEquals(51, appearanceStream2.getContentStream().getLength());
    assertEquals(51, appearanceStream3.getContentStream().getLength());
    assertEquals(51, appearanceStream4.getContentStream().getLength());
    assertEquals(51, appearanceStream.getContentStream().getLength());
    assertEquals(51, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }
}
