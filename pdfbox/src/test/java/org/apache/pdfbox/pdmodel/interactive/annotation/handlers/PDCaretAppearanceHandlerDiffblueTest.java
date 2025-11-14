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
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.AffineTransform;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDImmutableRectangle;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDPattern;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDCaretAppearanceHandlerDiffblueTest {
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
   *   <li>{@link PDCaretAppearanceHandler#PDCaretAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDCaretAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDCaretAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDCaretAppearanceHandler.<init>(PDAnnotation)",
    "void PDCaretAppearanceHandler.<init>(PDAnnotation, org.apache.pdfbox.pdmodel.PDDocument)",
    "void PDCaretAppearanceHandler.generateDownAppearance()",
    "void PDCaretAppearanceHandler.generateRolloverAppearance()"
  })
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDCaretAppearanceHandler actualPdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(annotation);
    actualPdCaretAppearanceHandler.generateDownAppearance();
    actualPdCaretAppearanceHandler.generateRolloverAppearance();

    // Assert
    assertTrue(actualPdCaretAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdCaretAppearanceHandler.getAnnotation());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance() {
    // Arrange
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream5.getStream().getLength());
    assertEquals(149, appearanceStream.getContentStream().getLength());
    assertEquals(149, appearanceStream2.getContentStream().getLength());
    assertEquals(149, appearanceStream3.getContentStream().getLength());
    assertEquals(149, appearanceStream4.getContentStream().getLength());
    assertEquals(149, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance2() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream5.getStream().getLength());
    assertEquals(149, appearanceStream.getContentStream().getLength());
    assertEquals(149, appearanceStream2.getContentStream().getLength());
    assertEquals(149, appearanceStream3.getContentStream().getLength());
    assertEquals(149, appearanceStream4.getContentStream().getLength());
    assertEquals(149, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance3() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream5.getStream().getLength());
    assertEquals(149, appearanceStream.getContentStream().getLength());
    assertEquals(149, appearanceStream2.getContentStream().getLength());
    assertEquals(149, appearanceStream3.getContentStream().getLength());
    assertEquals(149, appearanceStream4.getContentStream().getLength());
    assertEquals(149, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance4() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceRGB.INSTANCE));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(155, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(155, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(155, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(155, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(155, appearanceStream5.getStream().getLength());
    assertEquals(155, appearanceStream.getContentStream().getLength());
    assertEquals(155, appearanceStream2.getContentStream().getLength());
    assertEquals(155, appearanceStream3.getContentStream().getLength());
    assertEquals(155, appearanceStream4.getContentStream().getLength());
    assertEquals(155, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance5() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    COSArray array = new COSArray();
    PDColor pdColor = new PDColor(array, new PDCalGray());
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(135, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(135, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(135, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(135, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(135, appearanceStream5.getStream().getLength());
    assertEquals(135, appearanceStream.getContentStream().getLength());
    assertEquals(135, appearanceStream2.getContentStream().getLength());
    assertEquals(135, appearanceStream3.getContentStream().getLength());
    assertEquals(135, appearanceStream4.getContentStream().getLength());
    assertEquals(135, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance6() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream5.getStream().getLength());
    assertEquals(171, appearanceStream.getContentStream().getLength());
    assertEquals(171, appearanceStream2.getContentStream().getLength());
    assertEquals(171, appearanceStream3.getContentStream().getLength());
    assertEquals(171, appearanceStream4.getContentStream().getLength());
    assertEquals(171, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance7() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(new PDRectangle(9.223372E18f, 9.223372E18f));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    PDAppearanceStream appearanceStream =
        pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(2.14748365E9f, bBox.getHeight());
    assertEquals(2.14748365E9f, bBox.getUpperRightX());
    assertEquals(2.14748365E9f, bBox.getUpperRightY());
    assertEquals(2.14748365E9f, bBox.getWidth());
    assertEquals(262, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 =
        pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(262, appearanceStream2.getStream().getLength());
    assertEquals(262, appearanceStream.getContentStream().getLength());
    assertEquals(262, appearanceStream2.getContentStream().getLength());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance8() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents())
        .thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(201, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(201, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(201, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(201, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(201, appearanceStream5.getStream().getLength());
    assertEquals(201, appearanceStream.getContentStream().getLength());
    assertEquals(201, appearanceStream2.getContentStream().getLength());
    assertEquals(201, appearanceStream3.getContentStream().getLength());
    assertEquals(201, appearanceStream4.getContentStream().getLength());
    assertEquals(201, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance9() {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(new COSArray());

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle, atLeast(1)).getHeight();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdImmutableRectangle, atLeast(1)).getWidth();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    PDRectangle bBox =
        pdCaretAppearanceHandler
            .getAppearance()
            .getDownAppearance()
            .getAppearanceStream()
            .getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDAppearanceStream appearanceStream =
        pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
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
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance10() {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(null);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle, atLeast(1)).getHeight();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdImmutableRectangle, atLeast(1)).getWidth();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    PDAppearanceEntry downAppearance = pdCaretAppearanceHandler.getDownAppearance();
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    float[][] values = downAppearance.getAppearanceStream().getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance11() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(cosArray);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle, atLeast(1)).getHeight();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdImmutableRectangle, atLeast(1)).getWidth();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    PDAppearanceStream appearanceStream =
        pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-10.0f, matrix.getTranslateX());
    assertEquals(-10.0f, matrix.getTranslateY());
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(104, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(104, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(104, appearanceStream4.getStream().getLength());
    assertEquals(104, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(104, appearanceStream5.getStream().getLength());
    assertEquals(104, appearanceStream2.getContentStream().getLength());
    assertEquals(104, appearanceStream3.getContentStream().getLength());
    assertEquals(104, appearanceStream4.getContentStream().getLength());
    assertEquals(104, appearanceStream.getContentStream().getLength());
    assertEquals(104, appearanceStream5.getContentStream().getLength());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance12() {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(cosArray);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle, atLeast(1)).getHeight();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdImmutableRectangle, atLeast(1)).getWidth();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    PDAppearanceStream appearanceStream =
        pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-10.0f, matrix.getTranslateX());
    assertEquals(-10.0f, matrix.getTranslateY());
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(104, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(104, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(104, appearanceStream4.getStream().getLength());
    assertEquals(104, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(104, appearanceStream5.getStream().getLength());
    assertEquals(104, appearanceStream2.getContentStream().getLength());
    assertEquals(104, appearanceStream3.getContentStream().getLength());
    assertEquals(104, appearanceStream4.getContentStream().getLength());
    assertEquals(104, appearanceStream.getContentStream().getLength());
    assertEquals(104, appearanceStream5.getContentStream().getLength());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance13() {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(cosArray);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSStream()));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    new PDCaretAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle, atLeast(1)).getHeight();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdImmutableRectangle, atLeast(1)).getWidth();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance14() throws IOException {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(-9.223372E18f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    new PDCaretAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle, atLeast(1)).getHeight();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdImmutableRectangle, atLeast(1)).getWidth();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance15() throws IOException {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {-9.223372E18f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(false);

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    when(pdAppearanceStream.getMatrix()).thenReturn(matrix);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    new PDCaretAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle, atLeast(1)).getHeight();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftX();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftY();
    verify(pdImmutableRectangle, atLeast(1)).getWidth();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(1.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(matrix).createAffineTransform();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance16() throws IOException {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getPatternName()).thenReturn(COSName.A);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(new PDPattern(new PDResources()));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(false);

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    when(pdAppearanceStream.getMatrix()).thenReturn(matrix);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    new PDCaretAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle, atLeast(1)).getHeight();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftX();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftY();
    verify(pdImmutableRectangle, atLeast(1)).getWidth();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdColor, atLeast(1)).getPatternName();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(1.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(matrix).createAffineTransform();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance17() throws IOException {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDPattern pdPattern = mock(PDPattern.class);
    when(pdPattern.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getPatternName()).thenReturn(COSName.A);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(pdPattern);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(false);

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    when(pdAppearanceStream.getMatrix()).thenReturn(matrix);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary2);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    new PDCaretAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosDictionary2).containsKey(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle, atLeast(1)).getHeight();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftX();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftY();
    verify(pdImmutableRectangle, atLeast(1)).getWidth();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdColor, atLeast(1)).getPatternName();
    verify(pdPattern, atLeast(1)).getCOSObject();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(1.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(matrix).createAffineTransform();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given COSDictionary getCOSDictionary(COSName) return COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSDictionaryGetCOSDictionaryReturnCOSStream()
      throws IOException {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSStream());

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDPattern pdPattern = mock(PDPattern.class);
    when(pdPattern.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getPatternName()).thenReturn(COSName.A);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(pdPattern);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(false);

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    when(pdAppearanceStream.getMatrix()).thenReturn(matrix);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary2);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    new PDCaretAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosDictionary2).containsKey(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle, atLeast(1)).getHeight();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftX();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftY();
    verify(pdImmutableRectangle, atLeast(1)).getWidth();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdColor, atLeast(1)).getPatternName();
    verify(pdPattern, atLeast(1)).getCOSObject();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(1.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(matrix).createAffineTransform();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSName} {@link COSName#writePDF(OutputStream)} does nothing.
   *   <li>Then calls {@link COSName#writePDF(OutputStream)}.
   * </ul>
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given COSName writePDF(OutputStream) does nothing; then calls writePDF(OutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSNameWritePDFDoesNothing_thenCallsWritePDF()
      throws IOException {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSStream cosStream = mock(COSStream.class);
    when(cosStream.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.A);
    when(cosStream.containsValue(Mockito.<Object>any())).thenReturn(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosStream);

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDPattern pdPattern = mock(PDPattern.class);
    when(pdPattern.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSName cosName = mock(COSName.class);
    doNothing().when(cosName).writePDF(Mockito.<OutputStream>any());

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getPatternName()).thenReturn(cosName);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(pdPattern);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(false);

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    when(pdAppearanceStream.getMatrix()).thenReturn(matrix);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary2);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    new PDCaretAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosDictionary2).containsKey(isA(COSName.class));
    verify(cosStream, atLeast(1)).containsValue(isA(Object.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosStream, atLeast(1)).getKeyForValue(isA(Object.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(cosName, atLeast(1)).writePDF(isA(OutputStream.class));
    verify(entry).createOutputStream(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle, atLeast(1)).getHeight();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftX();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftY();
    verify(pdImmutableRectangle, atLeast(1)).getWidth();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdColor, atLeast(1)).getPatternName();
    verify(pdPattern, atLeast(1)).getCOSObject();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(1.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(matrix).createAffineTransform();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSStream} {@link COSStream#createOutputStream(COSBase)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given COSStream createOutputStream(COSBase) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSStreamCreateOutputStreamReturnNull()
      throws IOException {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSName cosName = mock(COSName.class);
    doThrow(new IOException()).when(cosName).writePDF(Mockito.<OutputStream>any());

    COSStream cosStream = mock(COSStream.class);
    when(cosStream.getKeyForValue(Mockito.<Object>any())).thenReturn(cosName);
    when(cosStream.containsValue(Mockito.<Object>any())).thenReturn(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosStream);

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(null);
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDPattern pdPattern = mock(PDPattern.class);
    when(pdPattern.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getColorSpace()).thenReturn(pdPattern);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    new PDCaretAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosStream).containsValue(isA(Object.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosStream).getKeyForValue(isA(Object.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(cosName).writePDF(isNull());
    verify(entry).createOutputStream(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdColor).getColorSpace();
    verify(pdPattern, atLeast(1)).getCOSObject();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSStream} {@link COSStream#createOutputStream(COSBase)} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given COSStream createOutputStream(COSBase) throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSStreamCreateOutputStreamThrowIOException()
      throws IOException {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenThrow(new IOException());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    new PDCaretAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(entry).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(annotation).getAppearance();
    verify(annotation).getRectangle();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSStream} {@link COSStream#getCOSDictionary(COSName)} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given COSStream getCOSDictionary(COSName) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSStreamGetCOSDictionaryReturnCOSDictionary()
      throws IOException {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    new PDCaretAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle, atLeast(1)).getHeight();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdImmutableRectangle, atLeast(1)).getWidth();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSStream} {@link COSStream#getKeyForValue(Object)} return {@link
   *       COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given COSStream getKeyForValue(Object) return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSStreamGetKeyForValueReturnA() throws IOException {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSStream cosStream = mock(COSStream.class);
    when(cosStream.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.A);
    when(cosStream.containsValue(Mockito.<Object>any())).thenReturn(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosStream);

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDPattern pdPattern = mock(PDPattern.class);
    when(pdPattern.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getPatternName()).thenReturn(COSName.A);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(pdPattern);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(false);

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    when(pdAppearanceStream.getMatrix()).thenReturn(matrix);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary2);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    new PDCaretAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosDictionary2).containsKey(isA(COSName.class));
    verify(cosStream, atLeast(1)).containsValue(isA(Object.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosStream, atLeast(1)).getKeyForValue(isA(Object.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle, atLeast(1)).getHeight();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftX();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftY();
    verify(pdImmutableRectangle, atLeast(1)).getWidth();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdColor, atLeast(1)).getPatternName();
    verify(pdPattern, atLeast(1)).getCOSObject();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(1.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(matrix).createAffineTransform();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSStream} {@link COSStream#getKeyForValue(Object)} return {@link COSName}.
   * </ul>
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given COSStream getKeyForValue(Object) return COSName")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSStreamGetKeyForValueReturnCOSName() throws IOException {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSName cosName = mock(COSName.class);
    doThrow(new IOException()).when(cosName).writePDF(Mockito.<OutputStream>any());

    COSStream cosStream = mock(COSStream.class);
    when(cosStream.getKeyForValue(Mockito.<Object>any())).thenReturn(cosName);
    when(cosStream.containsValue(Mockito.<Object>any())).thenReturn(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosStream);

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDPattern pdPattern = mock(PDPattern.class);
    when(pdPattern.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getColorSpace()).thenReturn(pdPattern);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    new PDCaretAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosStream).containsValue(isA(Object.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosStream).getKeyForValue(isA(Object.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(cosName).writePDF(isA(OutputStream.class));
    verify(entry).createOutputStream(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdColor).getColorSpace();
    verify(pdPattern, atLeast(1)).getCOSObject();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDAppearanceStream} {@link PDAppearanceStream#getMatrix()} return {@link
   *       Matrix#Matrix()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDAppearanceStream getMatrix() return Matrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAppearanceStreamGetMatrixReturnMatrix()
      throws IOException {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(false);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    when(pdAppearanceStream.getMatrix()).thenReturn(new Matrix());
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    new PDCaretAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle, atLeast(1)).getHeight();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftX();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftY();
    verify(pdImmutableRectangle, atLeast(1)).getWidth();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(1.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDColor} {@link PDColor#getPatternName()} return {@link
   *       COSName#ADBE_PKCS7_DETACHED}.
   * </ul>
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDColor getPatternName() return ADBE_PKCS7_DETACHED")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDColorGetPatternNameReturnAdbe_pkcs7_detached()
      throws IOException {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getPatternName()).thenReturn(COSName.ADBE_PKCS7_DETACHED);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(new PDPattern(new PDResources()));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(false);

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    when(pdAppearanceStream.getMatrix()).thenReturn(matrix);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    new PDCaretAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle, atLeast(1)).getHeight();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftX();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftY();
    verify(pdImmutableRectangle, atLeast(1)).getWidth();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdColor, atLeast(1)).getPatternName();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(1.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(matrix).createAffineTransform();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDColor} {@link PDColor#getPatternName()} return {@link
   *       COSName#ADBE_X509_RSA_SHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDColor getPatternName() return ADBE_X509_RSA_SHA1")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDColorGetPatternNameReturnAdbe_x509_rsa_sha1()
      throws IOException {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getPatternName()).thenReturn(COSName.ADBE_X509_RSA_SHA1);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(new PDPattern(new PDResources()));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(false);

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    when(pdAppearanceStream.getMatrix()).thenReturn(matrix);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    new PDCaretAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle, atLeast(1)).getHeight();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftX();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftY();
    verify(pdImmutableRectangle, atLeast(1)).getWidth();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdColor, atLeast(1)).getPatternName();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(1.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(matrix).createAffineTransform();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDColor} {@link PDColor#getPatternName()} return {@link COSName}.
   * </ul>
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDColor getPatternName() return COSName")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDColorGetPatternNameReturnCOSName() throws IOException {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSStream cosStream = mock(COSStream.class);
    when(cosStream.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.A);
    when(cosStream.containsValue(Mockito.<Object>any())).thenReturn(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosStream);

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDPattern pdPattern = mock(PDPattern.class);
    when(pdPattern.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSName cosName = mock(COSName.class);
    doThrow(new IOException()).when(cosName).writePDF(Mockito.<OutputStream>any());

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getPatternName()).thenReturn(cosName);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(pdPattern);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    new PDCaretAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosStream).containsValue(isA(Object.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosStream).getKeyForValue(isA(Object.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(cosName).writePDF(isA(OutputStream.class));
    verify(entry).createOutputStream(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor).getComponents();
    verify(pdColor).getPatternName();
    verify(pdPattern, atLeast(1)).getCOSObject();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Then calls {@link Matrix#createAffineTransform()}.
   * </ul>
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls createAffineTransform()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsCreateAffineTransform() throws IOException {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(false);

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    when(pdAppearanceStream.getMatrix()).thenReturn(matrix);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    new PDCaretAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle, atLeast(1)).getHeight();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftX();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftY();
    verify(pdImmutableRectangle, atLeast(1)).getWidth();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(1.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(matrix).createAffineTransform();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls setItem(COSName, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsSetItem() throws IOException {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDPattern pdPattern = mock(PDPattern.class);
    when(pdPattern.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getPatternName()).thenReturn(COSName.A);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(pdPattern);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(false);

    Matrix matrix = mock(Matrix.class);
    when(matrix.createAffineTransform()).thenReturn(new AffineTransform());

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    when(pdAppearanceStream.getMatrix()).thenReturn(matrix);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary2);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    new PDCaretAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosDictionary2).containsKey(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).setItem(isA(COSName.class), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle, atLeast(1)).getHeight();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftX();
    verify(pdImmutableRectangle, atLeast(1)).getLowerLeftY();
    verify(pdImmutableRectangle, atLeast(1)).getWidth();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdColor, atLeast(1)).getPatternName();
    verify(pdPattern, atLeast(1)).getCOSObject();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(1.0f);
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(matrix).createAffineTransform();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls setNormalAppearance(PDAppearanceEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCaretAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsSetNormalAppearance() {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getHeight()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getWidth()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(cosArray);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    new PDCaretAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle, atLeast(1)).getHeight();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdImmutableRectangle, atLeast(1)).getWidth();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }
}
