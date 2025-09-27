package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.AffineTransform;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDPolygonAppearanceHandlerDiffblueTest {
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
   *   <li>{@link PDPolygonAppearanceHandler#PDPolygonAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDPolygonAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDPolygonAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDPolygonAppearanceHandler.<init>(PDAnnotation)",
    "void PDPolygonAppearanceHandler.<init>(PDAnnotation, org.apache.pdfbox.pdmodel.PDDocument)",
    "void PDPolygonAppearanceHandler.generateDownAppearance()",
    "void PDPolygonAppearanceHandler.generateRolloverAppearance()"
  })
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDPolygonAppearanceHandler actualPdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);
    actualPdPolygonAppearanceHandler.generateDownAppearance();
    actualPdPolygonAppearanceHandler.generateRolloverAppearance();

    // Assert
    assertTrue(actualPdPolygonAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdPolygonAppearanceHandler.getAnnotation());
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance() {
    // Arrange
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(new PDAnnotationPolygon());

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert that nothing has changed
    assertTrue(pdPolygonAppearanceHandler.getDownAppearance().getCOSObject() instanceof COSStream);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance2() {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getInteriorColor())
        .thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream4 =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(12, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(12, appearanceStream5.getStream().getLength());
    assertEquals(12, appearanceStream.getContentStream().getLength());
    assertEquals(12, appearanceStream2.getContentStream().getLength());
    assertEquals(12, appearanceStream3.getContentStream().getLength());
    assertEquals(12, appearanceStream4.getContentStream().getLength());
    assertEquals(12, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance3() {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceRGB.INSTANCE));
    when(annotation.getInteriorColor())
        .thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream4 =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(17, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(17, appearanceStream5.getStream().getLength());
    assertEquals(17, appearanceStream.getContentStream().getLength());
    assertEquals(17, appearanceStream2.getContentStream().getLength());
    assertEquals(17, appearanceStream3.getContentStream().getLength());
    assertEquals(17, appearanceStream4.getContentStream().getLength());
    assertEquals(17, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance4() {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    PDColor pdColor = new PDColor(new COSArray(), null);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor())
        .thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
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
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(8, appearanceStream5.getStream().getLength());
    assertEquals(8, appearanceStream2.getContentStream().getLength());
    assertEquals(8, appearanceStream3.getContentStream().getLength());
    assertEquals(8, appearanceStream4.getContentStream().getLength());
    assertEquals(8, appearanceStream.getContentStream().getLength());
    assertEquals(8, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance5() {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getInteriorColor())
        .thenReturn(new PDColor(new COSArray(), PDDeviceRGB.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream4 =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(17, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(17, appearanceStream5.getStream().getLength());
    assertEquals(17, appearanceStream.getContentStream().getLength());
    assertEquals(17, appearanceStream2.getContentStream().getLength());
    assertEquals(17, appearanceStream3.getContentStream().getLength());
    assertEquals(17, appearanceStream4.getContentStream().getLength());
    assertEquals(17, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance6() {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    PDColor pdColor = new PDColor(new COSArray(), null);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
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
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(8, appearanceStream5.getStream().getLength());
    assertEquals(8, appearanceStream2.getContentStream().getLength());
    assertEquals(8, appearanceStream3.getContentStream().getLength());
    assertEquals(8, appearanceStream4.getContentStream().getLength());
    assertEquals(8, appearanceStream.getContentStream().getLength());
    assertEquals(8, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance7() {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getInteriorColor())
        .thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

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
    verify(annotation).getVertices();
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(30, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(30, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(30, appearanceStream4.getStream().getLength());
    assertEquals(30, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(30, appearanceStream5.getStream().getLength());
    assertEquals(30, appearanceStream2.getContentStream().getLength());
    assertEquals(30, appearanceStream3.getContentStream().getLength());
    assertEquals(30, appearanceStream4.getContentStream().getLength());
    assertEquals(30, appearanceStream.getContentStream().getLength());
    assertEquals(30, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance8() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor())
        .thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream4 =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(28, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(28, appearanceStream5.getStream().getLength());
    assertEquals(28, appearanceStream.getContentStream().getLength());
    assertEquals(28, appearanceStream2.getContentStream().getLength());
    assertEquals(28, appearanceStream3.getContentStream().getLength());
    assertEquals(28, appearanceStream4.getContentStream().getLength());
    assertEquals(28, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance9() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor())
        .thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(pdColor).getComponents();
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
    PDAppearanceStream appearanceStream4 =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(24, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(24, appearanceStream5.getStream().getLength());
    assertEquals(24, appearanceStream.getContentStream().getLength());
    assertEquals(24, appearanceStream2.getContentStream().getLength());
    assertEquals(24, appearanceStream3.getContentStream().getLength());
    assertEquals(24, appearanceStream4.getContentStream().getLength());
    assertEquals(24, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance10() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents())
        .thenReturn(
            new float[] {
              1.0f,
              Float.MAX_VALUE,
              1.0f,
              Float.MAX_VALUE,
              1.0f,
              Float.MAX_VALUE,
              1.0f,
              Float.MAX_VALUE
            });

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor())
        .thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(pdColor).getComponents();
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
    assertEquals(176, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(176, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(176, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(176, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(176, appearanceStream5.getStream().getLength());
    assertEquals(176, appearanceStream.getContentStream().getLength());
    assertEquals(176, appearanceStream2.getContentStream().getLength());
    assertEquals(176, appearanceStream3.getContentStream().getLength());
    assertEquals(176, appearanceStream4.getContentStream().getLength());
    assertEquals(176, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance11() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents())
        .thenReturn(
            new float[] {
              1.0f,
              Float.MAX_VALUE,
              1.0f,
              Float.MAX_VALUE,
              1.0f,
              Float.MAX_VALUE,
              1.0f,
              Float.MAX_VALUE,
              1.0f,
              Float.MAX_VALUE,
              1.0f,
              Float.MAX_VALUE
            });

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor())
        .thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(pdColor).getComponents();
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
    assertEquals(260, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(260, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(260, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(260, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(260, appearanceStream5.getStream().getLength());
    assertEquals(260, appearanceStream.getContentStream().getLength());
    assertEquals(260, appearanceStream2.getContentStream().getLength());
    assertEquals(260, appearanceStream3.getContentStream().getLength());
    assertEquals(260, appearanceStream4.getContentStream().getLength());
    assertEquals(260, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance12() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor2 = new PDColor(new COSArray(), colorSpace);

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(pdColor).getComponents();
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
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(40, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(40, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(40, appearanceStream4.getStream().getLength());
    assertEquals(40, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(40, appearanceStream5.getStream().getLength());
    assertEquals(40, appearanceStream2.getContentStream().getLength());
    assertEquals(40, appearanceStream3.getContentStream().getLength());
    assertEquals(40, appearanceStream4.getContentStream().getLength());
    assertEquals(40, appearanceStream.getContentStream().getLength());
    assertEquals(40, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance13() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(pdColor).getComponents();
    verify(pdColor2).getComponents();
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
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(36, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(36, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(36, appearanceStream4.getStream().getLength());
    assertEquals(36, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(36, appearanceStream5.getStream().getLength());
    assertEquals(36, appearanceStream2.getContentStream().getLength());
    assertEquals(36, appearanceStream3.getContentStream().getLength());
    assertEquals(36, appearanceStream4.getContentStream().getLength());
    assertEquals(36, appearanceStream.getContentStream().getLength());
    assertEquals(36, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance14() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("Style");

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(pdColor).getComponents();
    verify(pdColor2).getComponents();
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
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(36, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(36, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(36, appearanceStream4.getStream().getLength());
    assertEquals(36, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(36, appearanceStream5.getStream().getLength());
    assertEquals(36, appearanceStream2.getContentStream().getLength());
    assertEquals(36, appearanceStream3.getContentStream().getLength());
    assertEquals(36, appearanceStream4.getContentStream().getLength());
    assertEquals(36, appearanceStream.getContentStream().getLength());
    assertEquals(36, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance15() {
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

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("Style");

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(9.0f);
    verify(pdRectangle).setLowerLeftY(-0.5f);
    verify(pdRectangle).setUpperRightX(11.0f);
    verify(pdRectangle).setUpperRightY(10.0f);
    verify(pdColor).getComponents();
    verify(pdColor2).getComponents();
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
    PDRectangle bBox =
        pdPolygonAppearanceHandler
            .getAppearance()
            .getDownAppearance()
            .getAppearanceStream()
            .getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
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
    assertEquals(
        toListResult,
        pdPolygonAppearanceHandler
            .getRolloverAppearance()
            .getAppearanceStream()
            .getBBox()
            .getCOSArray()
            .toList());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance16() {
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

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("Style");

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(9.0f);
    verify(pdRectangle).setLowerLeftY(-0.5f);
    verify(pdRectangle).setUpperRightX(11.0f);
    verify(pdRectangle).setUpperRightY(10.0f);
    verify(pdColor).getComponents();
    verify(pdColor2).getComponents();
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
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(36, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(36, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(36, appearanceStream4.getStream().getLength());
    assertEquals(36, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(36, appearanceStream5.getStream().getLength());
    assertEquals(36, appearanceStream2.getContentStream().getLength());
    assertEquals(36, appearanceStream3.getContentStream().getLength());
    assertEquals(36, appearanceStream4.getContentStream().getLength());
    assertEquals(36, appearanceStream.getContentStream().getLength());
    assertEquals(36, appearanceStream5.getContentStream().getLength());
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance17() {
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

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("Style");

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

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
    verify(pdRectangle).setLowerLeftX(9.0f);
    verify(pdRectangle).setLowerLeftY(-0.5f);
    verify(pdRectangle).setUpperRightX(11.0f);
    verify(pdRectangle).setUpperRightY(10.0f);
    verify(pdColor).getComponents();
    verify(pdColor2).getComponents();
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
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(36, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(36, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(36, appearanceStream4.getStream().getLength());
    assertEquals(36, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(36, appearanceStream5.getStream().getLength());
    assertEquals(36, appearanceStream2.getContentStream().getLength());
    assertEquals(36, appearanceStream3.getContentStream().getLength());
    assertEquals(36, appearanceStream4.getContentStream().getLength());
    assertEquals(36, appearanceStream.getContentStream().getLength());
    assertEquals(36, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance18() {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

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

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("Style");

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(9.0f);
    verify(pdRectangle).setLowerLeftY(-0.5f);
    verify(pdRectangle).setUpperRightX(11.0f);
    verify(pdRectangle).setUpperRightY(10.0f);
    verify(pdColor).getComponents();
    verify(pdColor2).getComponents();
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
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(36, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(36, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(36, appearanceStream4.getStream().getLength());
    assertEquals(36, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(36, appearanceStream5.getStream().getLength());
    assertEquals(36, appearanceStream2.getContentStream().getLength());
    assertEquals(36, appearanceStream3.getContentStream().getLength());
    assertEquals(36, appearanceStream4.getContentStream().getLength());
    assertEquals(36, appearanceStream.getContentStream().getLength());
    assertEquals(36, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance19() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(new COSDictionary());

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

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

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("Style");

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(0.0f);
    verify(pdRectangle).setLowerLeftY(-9.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdColor).getComponents();
    verify(pdColor2).getComponents();
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
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(41, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(41, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(41, appearanceStream4.getStream().getLength());
    assertEquals(41, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(41, appearanceStream5.getStream().getLength());
    assertEquals(41, appearanceStream2.getContentStream().getLength());
    assertEquals(41, appearanceStream3.getContentStream().getLength());
    assertEquals(41, appearanceStream4.getContentStream().getLength());
    assertEquals(41, appearanceStream.getContentStream().getLength());
    assertEquals(41, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance20() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

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

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("Style");

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(0.0f);
    verify(pdRectangle).setLowerLeftY(-9.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdColor).getComponents();
    verify(pdColor2).getComponents();
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
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(41, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(41, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(41, appearanceStream4.getStream().getLength());
    assertEquals(41, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(41, appearanceStream5.getStream().getLength());
    assertEquals(41, appearanceStream2.getContentStream().getLength());
    assertEquals(41, appearanceStream3.getContentStream().getLength());
    assertEquals(41, appearanceStream4.getContentStream().getLength());
    assertEquals(41, appearanceStream.getContentStream().getLength());
    assertEquals(41, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance21() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

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

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("Style");

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(Float.MIN_VALUE);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(0.0f);
    verify(pdRectangle).setLowerLeftY(-9.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdColor).getComponents();
    verify(pdColor2).getComponents();
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
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    Iterable<COSName> extGStateNames = appearanceStream.getResources().getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals(1, ((Set<COSName>) extGStateNames).size());
    assertEquals(49, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(49, appearanceStream2.getStream().getLength());
    assertEquals(49, appearanceStream.getContentStream().getLength());
    assertEquals(49, appearanceStream2.getContentStream().getLength());
    assertSame(extGStateNames, appearanceStream2.getResources().getExtGStateNames());
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance22() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

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

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getIntensity()).thenReturn(10.0f);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("C");

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(0.0f);
    verify(pdRectangle).setLowerLeftY(-9.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdColor).getComponents();
    verify(pdColor2).getComponents();
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
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream4.getStream().getLength());
    assertEquals(39, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream5.getStream().getLength());
    assertEquals(39, appearanceStream2.getContentStream().getLength());
    assertEquals(39, appearanceStream3.getContentStream().getLength());
    assertEquals(39, appearanceStream4.getContentStream().getLength());
    assertEquals(39, appearanceStream.getContentStream().getLength());
    assertEquals(39, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance23() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

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

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getIntensity()).thenReturn(10.0f);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("C");

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices()).thenReturn(new float[] {});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(10.0f);
    verify(pdRectangle).setLowerLeftY(10.0f);
    verify(pdRectangle).setUpperRightX(10.0f);
    verify(pdRectangle).setUpperRightY(10.0f);
    verify(pdColor).getComponents();
    verify(pdColor2).getComponents();
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
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream4.getStream().getLength());
    assertEquals(39, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream5.getStream().getLength());
    assertEquals(39, appearanceStream2.getContentStream().getLength());
    assertEquals(39, appearanceStream3.getContentStream().getLength());
    assertEquals(39, appearanceStream4.getContentStream().getLength());
    assertEquals(39, appearanceStream.getContentStream().getLength());
    assertEquals(39, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance24() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

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

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getIntensity()).thenReturn(10.0f);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("C");

    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getVertices())
        .thenReturn(
            new float[] {
              Float.MAX_VALUE,
              Float.MIN_VALUE,
              Float.MAX_VALUE,
              Float.MIN_VALUE,
              Float.MAX_VALUE,
              Float.MIN_VALUE,
              Float.MAX_VALUE,
              Float.MIN_VALUE
            });
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(10.0f);
    verify(pdRectangle).setLowerLeftY(-10.0f);
    verify(pdRectangle).setUpperRightX(3.4028235E38f);
    verify(pdRectangle).setUpperRightY(10.0f);
    verify(pdColor).getComponents();
    verify(pdColor2).getComponents();
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
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream4.getStream().getLength());
    assertEquals(39, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream5.getStream().getLength());
    assertEquals(39, appearanceStream2.getContentStream().getLength());
    assertEquals(39, appearanceStream3.getContentStream().getLength());
    assertEquals(39, appearanceStream4.getContentStream().getLength());
    assertEquals(39, appearanceStream.getContentStream().getLength());
    assertEquals(39, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance25() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

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

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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
    when(annotation.getVertices()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(0.0f);
    verify(pdRectangle).setLowerLeftY(-9.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdColor).getComponents();
    verify(pdColor2).getComponents();
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
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream4.getStream().getLength());
    assertEquals(39, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream5.getStream().getLength());
    assertEquals(39, appearanceStream2.getContentStream().getLength());
    assertEquals(39, appearanceStream3.getContentStream().getLength());
    assertEquals(39, appearanceStream4.getContentStream().getLength());
    assertEquals(39, appearanceStream.getContentStream().getLength());
    assertEquals(39, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance26() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

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

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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
    when(annotation.getVertices()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(0.0f);
    verify(pdRectangle).setLowerLeftY(-9.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdColor).getComponents();
    verify(pdColor2).getComponents();
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
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(63, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(63, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(63, appearanceStream4.getStream().getLength());
    assertEquals(63, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(63, appearanceStream5.getStream().getLength());
    assertEquals(63, appearanceStream2.getContentStream().getLength());
    assertEquals(63, appearanceStream3.getContentStream().getLength());
    assertEquals(63, appearanceStream4.getContentStream().getLength());
    assertEquals(63, appearanceStream.getContentStream().getLength());
    assertEquals(63, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance27() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

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

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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
    when(annotation.getVertices()).thenReturn(new float[] {Float.MIN_VALUE, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(-10.0f);
    verify(pdRectangle).setLowerLeftY(-9.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdColor).getComponents();
    verify(pdColor2).getComponents();
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
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream5.getStream().getLength());
    assertEquals(167, appearanceStream.getContentStream().getLength());
    assertEquals(167, appearanceStream2.getContentStream().getLength());
    assertEquals(167, appearanceStream3.getContentStream().getLength());
    assertEquals(167, appearanceStream4.getContentStream().getLength());
    assertEquals(167, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance28() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

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

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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
    when(annotation.getVertices()).thenReturn(new float[] {10.0f, Float.MIN_VALUE, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(0.0f);
    verify(pdRectangle).setLowerLeftY(-10.0f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdColor).getComponents();
    verify(pdColor2).getComponents();
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
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(220, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(220, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(220, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(220, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(220, appearanceStream5.getStream().getLength());
    assertEquals(220, appearanceStream.getContentStream().getLength());
    assertEquals(220, appearanceStream2.getContentStream().getLength());
    assertEquals(220, appearanceStream3.getContentStream().getLength());
    assertEquals(220, appearanceStream4.getContentStream().getLength());
    assertEquals(220, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance29() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

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

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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
    when(annotation.getVertices()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(0.0f);
    verify(pdRectangle).setLowerLeftY(-9.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdColor).getComponents();
    verify(pdColor2).getComponents();
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
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(46, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(46, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(46, appearanceStream4.getStream().getLength());
    assertEquals(46, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(46, appearanceStream5.getStream().getLength());
    assertEquals(46, appearanceStream2.getContentStream().getLength());
    assertEquals(46, appearanceStream3.getContentStream().getLength());
    assertEquals(46, appearanceStream4.getContentStream().getLength());
    assertEquals(46, appearanceStream.getContentStream().getLength());
    assertEquals(46, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance30() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDLineDashPattern pdLineDashPattern = mock(PDLineDashPattern.class);
    when(pdLineDashPattern.getDashArray()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(pdLineDashPattern);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

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

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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
    when(annotation.getVertices()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(0.0f);
    verify(pdRectangle).setLowerLeftY(-9.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdLineDashPattern).getDashArray();
    verify(pdColor).getComponents();
    verify(pdColor2).getComponents();
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
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(56, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(56, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(56, appearanceStream4.getStream().getLength());
    assertEquals(56, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(56, appearanceStream5.getStream().getLength());
    assertEquals(56, appearanceStream2.getContentStream().getLength());
    assertEquals(56, appearanceStream3.getContentStream().getLength());
    assertEquals(56, appearanceStream4.getContentStream().getLength());
    assertEquals(56, appearanceStream.getContentStream().getLength());
    assertEquals(56, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#isDirect()} return {@code false}.
   *   <li>Then calls {@link COSArray#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given COSArray isDirect() return 'false'; then calls getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSArrayIsDirectReturnFalse_thenCallsGetKey() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

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

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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
    when(annotation.getVertices()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getPath()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray, atLeast(1)).getKey();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(0.0f);
    verify(pdRectangle).setLowerLeftY(-9.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdColor).getComponents();
    verify(pdColor2).getComponents();
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
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdPolygonAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream4.getStream().getLength());
    assertEquals(39, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(39, appearanceStream5.getStream().getLength());
    assertEquals(39, appearanceStream2.getContentStream().getLength());
    assertEquals(39, appearanceStream3.getContentStream().getLength());
    assertEquals(39, appearanceStream4.getContentStream().getLength());
    assertEquals(39, appearanceStream.getContentStream().getLength());
    assertEquals(39, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationPolygon} {@link PDAnnotationPolygon#getBorderEffect()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDAnnotationPolygon getBorderEffect() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAnnotationPolygonGetBorderEffectReturnNull() {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getInteriorColor())
        .thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(null);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream4 =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(12, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(12, appearanceStream5.getStream().getLength());
    assertEquals(12, appearanceStream.getContentStream().getLength());
    assertEquals(12, appearanceStream2.getContentStream().getLength());
    assertEquals(12, appearanceStream3.getContentStream().getLength());
    assertEquals(12, appearanceStream4.getContentStream().getLength());
    assertEquals(12, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationPolygon} {@link PDAnnotationPolygon#getBorderStyle()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDAnnotationPolygon getBorderStyle() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAnnotationPolygonGetBorderStyleReturnNull() {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getInteriorColor())
        .thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(null);
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

    // Act
    pdPolygonAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation, atLeast(1)).getBorder();
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
    PDAppearanceStream appearanceStream4 =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(12, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(12, appearanceStream5.getStream().getLength());
    assertEquals(12, appearanceStream.getContentStream().getLength());
    assertEquals(12, appearanceStream2.getContentStream().getLength());
    assertEquals(12, appearanceStream3.getContentStream().getLength());
    assertEquals(12, appearanceStream4.getContentStream().getLength());
    assertEquals(12, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationPolygon} {@link PDAnnotationPolygon#getColor()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDAnnotationPolygon getColor() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAnnotationPolygonGetColorReturnNull() {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(null);
    when(annotation.getInteriorColor())
        .thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
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
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(8, appearanceStream5.getStream().getLength());
    assertEquals(8, appearanceStream2.getContentStream().getLength());
    assertEquals(8, appearanceStream3.getContentStream().getLength());
    assertEquals(8, appearanceStream4.getContentStream().getLength());
    assertEquals(8, appearanceStream.getContentStream().getLength());
    assertEquals(8, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationPolygon} {@link PDAnnotationPolygon#getInteriorColor()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDAnnotationPolygon getInteriorColor() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPolygonAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAnnotationPolygonGetInteriorColorReturnNull() {
    // Arrange
    PDAnnotationPolygon annotation = mock(PDAnnotationPolygon.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getInteriorColor()).thenReturn(null);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getPath()).thenReturn(new float[][] {new float[] {10.0f, 0.5f, 10.0f, 0.5f}});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDPolygonAppearanceHandler pdPolygonAppearanceHandler =
        new PDPolygonAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream =
        pdPolygonAppearanceHandler.getDownAppearance().getAppearanceStream();
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
    PDAppearanceStream appearanceStream5 =
        pdPolygonAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(8, appearanceStream5.getStream().getLength());
    assertEquals(8, appearanceStream2.getContentStream().getLength());
    assertEquals(8, appearanceStream3.getContentStream().getLength());
    assertEquals(8, appearanceStream4.getContentStream().getLength());
    assertEquals(8, appearanceStream.getContentStream().getLength());
    assertEquals(8, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-0.0f, 0.5f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDPolygonAppearanceHandler#getLineWidth()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDPolygonAppearanceHandler#getLineWidth()}
   */
  @Test
  @DisplayName("Test getLineWidth(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDPolygonAppearanceHandler.getLineWidth()"})
  void testGetLineWidth_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new PDPolygonAppearanceHandler(new PDAnnotationCaret()).getLineWidth());
  }
}
