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
import java.awt.geom.AffineTransform;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDPolygonAppearanceHandlerDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDPolygonAppearanceHandler#PDPolygonAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDPolygonAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDPolygonAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.<init>(PDAnnotation)",
      "void PDPolygonAppearanceHandler.<init>(PDAnnotation, org.apache.pdfbox.pdmodel.PDDocument)",
      "void PDPolygonAppearanceHandler.generateDownAppearance()",
      "void PDPolygonAppearanceHandler.generateRolloverAppearance()"})
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDPolygonAppearanceHandler actualPdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(annotation);
    actualPdPolygonAppearanceHandler.generateDownAppearance();
    actualPdPolygonAppearanceHandler.generateRolloverAppearance();

    // Assert
    assertTrue(actualPdPolygonAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdPolygonAppearanceHandler.getAnnotation());
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance() {
    // Arrange
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler = new PDPolygonAppearanceHandler(new PDAnnotationPolygon());

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert that nothing has changed
    assertTrue(pdPolygonAppearanceHandler.getDownAppearance().getCOSObject() instanceof COSStream);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance2() {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(12, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(12, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(12, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(12, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(12, appearanceStream5.getStream().getLength());
    assertEquals(12, appearanceStream.getContentStream().getLength());
    assertEquals(12, appearanceStream2.getContentStream().getLength());
    assertEquals(12, appearanceStream3.getContentStream().getLength());
    assertEquals(12, appearanceStream4.getContentStream().getLength());
    assertEquals(12, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance3() {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(Float.MIN_VALUE);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(20, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(20, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(20, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(20, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(20, appearanceStream5.getStream().getLength());
    assertEquals(20, appearanceStream.getContentStream().getLength());
    assertEquals(20, appearanceStream2.getContentStream().getLength());
    assertEquals(20, appearanceStream3.getContentStream().getLength());
    assertEquals(20, appearanceStream4.getContentStream().getLength());
    assertEquals(20, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance4() {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceRGB.INSTANCE));
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(17, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(17, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(17, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(17, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(17, appearanceStream5.getStream().getLength());
    assertEquals(17, appearanceStream.getContentStream().getLength());
    assertEquals(17, appearanceStream2.getContentStream().getLength());
    assertEquals(17, appearanceStream3.getContentStream().getLength());
    assertEquals(17, appearanceStream4.getContentStream().getLength());
    assertEquals(17, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance5() {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), null));
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDAppearanceStream appearanceStream = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(8, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(8, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(8, appearanceStream4.getStream().getLength());
    assertEquals(8, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(8, appearanceStream5.getStream().getLength());
    assertEquals(8, appearanceStream2.getContentStream().getLength());
    assertEquals(8, appearanceStream3.getContentStream().getLength());
    assertEquals(8, appearanceStream4.getContentStream().getLength());
    assertEquals(8, appearanceStream.getContentStream().getLength());
    assertEquals(8, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance6() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(28, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(28, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(28, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(28, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(28, appearanceStream5.getStream().getLength());
    assertEquals(28, appearanceStream.getContentStream().getLength());
    assertEquals(28, appearanceStream2.getContentStream().getLength());
    assertEquals(28, appearanceStream3.getContentStream().getLength());
    assertEquals(28, appearanceStream4.getContentStream().getLength());
    assertEquals(28, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance7() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceRGB.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDAppearanceStream appearanceStream = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(33, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(33, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(33, appearanceStream4.getStream().getLength());
    assertEquals(33, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(33, appearanceStream5.getStream().getLength());
    assertEquals(33, appearanceStream2.getContentStream().getLength());
    assertEquals(33, appearanceStream3.getContentStream().getLength());
    assertEquals(33, appearanceStream4.getContentStream().getLength());
    assertEquals(33, appearanceStream.getContentStream().getLength());
    assertEquals(33, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance8() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), null));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(24, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(24, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(24, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(24, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(24, appearanceStream5.getStream().getLength());
    assertEquals(24, appearanceStream.getContentStream().getLength());
    assertEquals(24, appearanceStream2.getContentStream().getLength());
    assertEquals(24, appearanceStream3.getContentStream().getLength());
    assertEquals(24, appearanceStream4.getContentStream().getLength());
    assertEquals(24, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance9() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDAppearanceStream appearanceStream = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream4.getStream().getLength());
    assertEquals(44, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream5.getStream().getLength());
    assertEquals(44, appearanceStream2.getContentStream().getLength());
    assertEquals(44, appearanceStream3.getContentStream().getLength());
    assertEquals(44, appearanceStream4.getContentStream().getLength());
    assertEquals(44, appearanceStream.getContentStream().getLength());
    assertEquals(44, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance10() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDAppearanceStream appearanceStream = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(42, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(42, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(42, appearanceStream4.getStream().getLength());
    assertEquals(42, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(42, appearanceStream5.getStream().getLength());
    assertEquals(42, appearanceStream2.getContentStream().getLength());
    assertEquals(42, appearanceStream3.getContentStream().getLength());
    assertEquals(42, appearanceStream4.getContentStream().getLength());
    assertEquals(42, appearanceStream.getContentStream().getLength());
    assertEquals(42, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance11() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDAppearanceStream appearanceStream = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(42, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(42, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(42, appearanceStream4.getStream().getLength());
    assertEquals(42, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(42, appearanceStream5.getStream().getLength());
    assertEquals(42, appearanceStream2.getContentStream().getLength());
    assertEquals(42, appearanceStream3.getContentStream().getLength());
    assertEquals(42, appearanceStream4.getContentStream().getLength());
    assertEquals(42, appearanceStream.getContentStream().getLength());
    assertEquals(42, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance12() {
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
    when(annotation.getConstantOpacity()).thenReturn(Float.MIN_VALUE);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDAppearanceStream appearanceStream = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(50, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(50, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(50, appearanceStream4.getStream().getLength());
    assertEquals(50, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(50, appearanceStream5.getStream().getLength());
    assertEquals(50, appearanceStream2.getContentStream().getLength());
    assertEquals(50, appearanceStream3.getContentStream().getLength());
    assertEquals(50, appearanceStream4.getContentStream().getLength());
    assertEquals(50, appearanceStream.getContentStream().getLength());
    assertEquals(50, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance13() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDAppearanceStream appearanceStream = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(66, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(66, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(66, appearanceStream4.getStream().getLength());
    assertEquals(66, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(66, appearanceStream5.getStream().getLength());
    assertEquals(66, appearanceStream2.getContentStream().getLength());
    assertEquals(66, appearanceStream3.getContentStream().getLength());
    assertEquals(66, appearanceStream4.getContentStream().getLength());
    assertEquals(66, appearanceStream.getContentStream().getLength());
    assertEquals(66, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance14() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDAppearanceStream appearanceStream = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(62, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(62, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(62, appearanceStream4.getStream().getLength());
    assertEquals(62, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(62, appearanceStream5.getStream().getLength());
    assertEquals(62, appearanceStream2.getContentStream().getLength());
    assertEquals(62, appearanceStream3.getContentStream().getLength());
    assertEquals(62, appearanceStream4.getContentStream().getLength());
    assertEquals(62, appearanceStream.getContentStream().getLength());
    assertEquals(62, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance15() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[]{1.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(172, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(172, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(172, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(172, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(172, appearanceStream5.getStream().getLength());
    assertEquals(172, appearanceStream.getContentStream().getLength());
    assertEquals(172, appearanceStream2.getContentStream().getLength());
    assertEquals(172, appearanceStream3.getContentStream().getLength());
    assertEquals(172, appearanceStream4.getContentStream().getLength());
    assertEquals(172, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance16() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[]{10.0f, 0.5f, Float.NaN, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDAppearanceStream appearanceStream = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(121, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(121, appearanceStream2.getStream().getLength());
    assertEquals(121, appearanceStream.getContentStream().getLength());
    assertEquals(121, appearanceStream2.getContentStream().getLength());
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(Float.NaN, bBox.getLowerLeftX());
    PDRectangle bBox2 = appearanceStream2.getBBox();
    assertEquals(Float.NaN, bBox2.getLowerLeftX());
    PDRectangle rectangle = pdPolygonAppearanceHandler.getRectangle();
    assertEquals(Float.NaN, rectangle.getLowerLeftX());
    assertEquals(Float.NaN, bBox.getUpperRightX());
    assertEquals(Float.NaN, bBox2.getUpperRightX());
    assertEquals(Float.NaN, rectangle.getUpperRightX());
    assertEquals(Float.NaN, bBox.getWidth());
    assertEquals(Float.NaN, bBox2.getWidth());
    assertEquals(Float.NaN, rectangle.getWidth());
    assertEquals(Float.NaN, appearanceStream.getMatrix().getTranslateX());
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance17() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[]{});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDRectangle rectangle = pdPolygonAppearanceHandler.getRectangle();
    List<? extends COSBase> toListResult = rectangle.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSFloat);
    PDRectangle bBox = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream().getBBox();
    assertEquals(1.0f, bBox.getHeight());
    PDRectangle bBox2 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream().getBBox();
    assertEquals(1.0f, bBox2.getHeight());
    assertEquals(1.0f, rectangle.getHeight());
    assertEquals(1.0f, bBox.getUpperRightX());
    assertEquals(1.0f, bBox2.getUpperRightX());
    assertEquals(1.0f, rectangle.getUpperRightX());
    assertEquals(1.0f, bBox.getUpperRightY());
    assertEquals(1.0f, bBox2.getUpperRightY());
    assertEquals(1.0f, rectangle.getUpperRightY());
    assertEquals(1.0f, bBox.getWidth());
    assertEquals(1.0f, bBox2.getWidth());
    assertEquals(1.0f, rectangle.getWidth());
    assertEquals(toListResult.get(2), getResult);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance18() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(
        new float[]{1.0f, Float.MAX_VALUE, 1.0f, Float.MAX_VALUE, 1.0f, Float.MAX_VALUE, 1.0f, Float.MAX_VALUE});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDRectangle bBox = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream().getBBox();
    assertEquals(2.0f, bBox.getUpperRightX());
    PDRectangle bBox2 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream().getBBox();
    assertEquals(2.0f, bBox2.getUpperRightX());
    PDRectangle rectangle = pdPolygonAppearanceHandler.getRectangle();
    assertEquals(2.0f, rectangle.getUpperRightX());
    assertEquals(2.0f, bBox.getWidth());
    assertEquals(2.0f, bBox2.getWidth());
    assertEquals(2.0f, rectangle.getWidth());
    assertEquals(2.14748365E9f, bBox.getHeight());
    assertEquals(2.14748365E9f, bBox2.getHeight());
    assertEquals(2.14748365E9f, bBox.getUpperRightY());
    assertEquals(2.14748365E9f, bBox2.getUpperRightY());
    assertEquals(Float.MAX_VALUE, rectangle.getHeight());
    assertEquals(Float.MAX_VALUE, rectangle.getUpperRightY());
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance19() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
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
    PDRectangle bBox = pdPolygonAppearanceHandler.getAppearance().getDownAppearance().getAppearanceStream().getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDAppearanceStream appearanceStream = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
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
    assertArrayEquals(new float[]{-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance20() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
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
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    Matrix matrix = downAppearance.getAppearanceStream().getMatrix();
    assertEquals(-10.0f, matrix.getTranslateX());
    assertEquals(-10.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    assertArrayEquals(new float[]{-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link PDAnnotationPolygon} {@link PDAnnotationPolygon#getBorderEffect()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDAnnotationPolygon getBorderEffect() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAnnotationPolygonGetBorderEffectReturnNull() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(null);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDAppearanceStream appearanceStream = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream4.getStream().getLength());
    assertEquals(44, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream5.getStream().getLength());
    assertEquals(44, appearanceStream2.getContentStream().getLength());
    assertEquals(44, appearanceStream3.getContentStream().getLength());
    assertEquals(44, appearanceStream4.getContentStream().getLength());
    assertEquals(44, appearanceStream.getContentStream().getLength());
    assertEquals(44, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link PDAnnotationPolygon} {@link PDAnnotation#getColor()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDAnnotationPolygon getColor() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAnnotationPolygonGetColorReturnNull() {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(null);
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDAppearanceStream appearanceStream = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(8, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(8, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(8, appearanceStream4.getStream().getLength());
    assertEquals(8, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(8, appearanceStream5.getStream().getLength());
    assertEquals(8, appearanceStream2.getContentStream().getLength());
    assertEquals(8, appearanceStream3.getContentStream().getLength());
    assertEquals(8, appearanceStream4.getContentStream().getLength());
    assertEquals(8, appearanceStream.getContentStream().getLength());
    assertEquals(8, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link PDAnnotationPolygon} {@link PDAnnotationPolygon#getInteriorColor()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDAnnotationPolygon getInteriorColor() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAnnotationPolygonGetInteriorColorReturnNull() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(null);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(24, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(24, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(24, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(24, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(24, appearanceStream5.getStream().getLength());
    assertEquals(24, appearanceStream.getContentStream().getLength());
    assertEquals(24, appearanceStream2.getContentStream().getLength());
    assertEquals(24, appearanceStream3.getContentStream().getLength());
    assertEquals(24, appearanceStream4.getContentStream().getLength());
    assertEquals(24, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link PDBorderEffectDictionary} {@link PDBorderEffectDictionary#getStyle()} return {@code Style}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDBorderEffectDictionary getStyle() return 'Style'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDBorderEffectDictionaryGetStyleReturnStyle() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
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
    PDAppearanceStream appearanceStream = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream4.getStream().getLength());
    assertEquals(44, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(44, appearanceStream5.getStream().getLength());
    assertEquals(44, appearanceStream2.getContentStream().getLength());
    assertEquals(44, appearanceStream3.getContentStream().getLength());
    assertEquals(44, appearanceStream4.getContentStream().getLength());
    assertEquals(44, appearanceStream.getContentStream().getLength());
    assertEquals(44, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Then calls {@link COSArray#getUpdateState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls getUpdateState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsGetUpdateState() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
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
    PDAppearanceStream appearanceStream = pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-10.0f, matrix.getTranslateX());
    assertEquals(-10.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(42, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(42, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(42, appearanceStream4.getStream().getLength());
    assertEquals(42, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(42, appearanceStream5.getStream().getLength());
    assertEquals(42, appearanceStream2.getContentStream().getLength());
    assertEquals(42, appearanceStream3.getContentStream().getLength());
    assertEquals(42, appearanceStream4.getContentStream().getLength());
    assertEquals(42, appearanceStream.getContentStream().getLength());
    assertEquals(42, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[]{-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#getLineWidth()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPolygonAppearanceHandler#getLineWidth()}
   */
  @Test
  @DisplayName("Test getLineWidth(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDPolygonAppearanceHandler.getLineWidth()"})
  void testGetLineWidth_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDPolygonAppearanceHandler(new PDAnnotationCaret())).getLineWidth());
  }
}
