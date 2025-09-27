package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.github.jaiimageio.impl.common.BogusColorSpace;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDImmutableRectangle;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDJPXColorSpace;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFreeText;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderEffectDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFreeTextAppearanceHandlerDiffblueTest {
  /**
   * Test {@link PDFreeTextAppearanceHandler#PDFreeTextAppearanceHandler(PDAnnotation)}.
   *
   * <p>Method under test: {@link
   * PDFreeTextAppearanceHandler#PDFreeTextAppearanceHandler(PDAnnotation)}
   */
  @Test
  @DisplayName("Test new PDFreeTextAppearanceHandler(PDAnnotation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.<init>(PDAnnotation)"})
  void testNewPDFreeTextAppearanceHandler() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDFreeTextAppearanceHandler actualPdFreeTextAppearanceHandler =
        new PDFreeTextAppearanceHandler(annotation);

    // Assert
    assertTrue(actualPdFreeTextAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    PDAnnotation annotation2 = actualPdFreeTextAppearanceHandler.getAnnotation();
    assertTrue(annotation2 instanceof PDAnnotationCaret);
    assertNull(actualPdFreeTextAppearanceHandler.document);
    assertNull(actualPdFreeTextAppearanceHandler.getRectangle());
    assertNull(actualPdFreeTextAppearanceHandler.getColor());
    assertSame(annotation, annotation2);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#PDFreeTextAppearanceHandler(PDAnnotation, PDDocument)}.
   *
   * <p>Method under test: {@link
   * PDFreeTextAppearanceHandler#PDFreeTextAppearanceHandler(PDAnnotation, PDDocument)}
   */
  @Test
  @DisplayName("Test new PDFreeTextAppearanceHandler(PDAnnotation, PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.<init>(PDAnnotation, PDDocument)"})
  void testNewPDFreeTextAppearanceHandler2() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDFreeTextAppearanceHandler actualPdFreeTextAppearanceHandler =
        new PDFreeTextAppearanceHandler(annotation, new PDDocument());

    // Assert
    assertTrue(actualPdFreeTextAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    PDAnnotation annotation2 = actualPdFreeTextAppearanceHandler.getAnnotation();
    assertTrue(annotation2 instanceof PDAnnotationCaret);
    assertNull(actualPdFreeTextAppearanceHandler.getRectangle());
    assertNull(actualPdFreeTextAppearanceHandler.getColor());
    assertSame(annotation, annotation2);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance() {
    // Arrange
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getAppearance()).thenThrow(new IllegalArgumentException());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(annotation).getAppearance();
    verify(annotation).getBorderStyle();
    verify(annotation).getIntent();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance2() {
    // Arrange
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getColor()).thenThrow(new IllegalArgumentException());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getBorderStyle();
    verify(annotation).getIntent();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance3() {
    // Arrange
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getCOSObject()).thenThrow(new IllegalArgumentException());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getBorderEffect();
    verify(annotation).getDefaultAppearance();
    verify(annotation).getDefaultStyleString();
    verify(annotation).getRectDifferences();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation, atLeast(1)).getIntent();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance4() {
    // Arrange
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler =
        new PDFreeTextAppearanceHandler(annotation);

    // Act
    pdFreeTextAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getBorderEffect();
    verify(annotation, atLeast(1)).getDefaultAppearance();
    verify(annotation).getDefaultStyleString();
    verify(annotation).getRectDifferences();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation, atLeast(1)).getIntent();
    PDAppearanceDictionary appearance = pdFreeTextAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(160, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(160, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(160, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(160, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(160, appearanceStream5.getStream().getLength());
    assertEquals(160, appearanceStream.getContentStream().getLength());
    assertEquals(160, appearanceStream2.getContentStream().getLength());
    assertEquals(160, appearanceStream3.getContentStream().getLength());
    assertEquals(160, appearanceStream4.getContentStream().getLength());
    assertEquals(160, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance5() {
    // Arrange
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenThrow(new IllegalArgumentException());
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation).getColor();
    verify(annotation).getContents();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getBorderEffect();
    verify(annotation, atLeast(1)).getDefaultAppearance();
    verify(annotation).getDefaultStyleString();
    verify(annotation).getRectDifferences();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation, atLeast(1)).getIntent();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance6() {
    // Arrange
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(new COSStream());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler =
        new PDFreeTextAppearanceHandler(annotation);

    // Act
    pdFreeTextAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getBorderEffect();
    verify(annotation, atLeast(1)).getDefaultAppearance();
    verify(annotation).getDefaultStyleString();
    verify(annotation).getRectDifferences();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation, atLeast(1)).getIntent();
    PDAppearanceDictionary appearance = pdFreeTextAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(160, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(160, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(160, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(160, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(160, appearanceStream5.getStream().getLength());
    assertEquals(160, appearanceStream.getContentStream().getLength());
    assertEquals(160, appearanceStream2.getContentStream().getLength());
    assertEquals(160, appearanceStream3.getContentStream().getLength());
    assertEquals(160, appearanceStream4.getContentStream().getLength());
    assertEquals(160, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance7() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler =
        new PDFreeTextAppearanceHandler(annotation);

    // Act
    pdFreeTextAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getBorderEffect();
    verify(annotation, atLeast(1)).getDefaultAppearance();
    verify(annotation).getDefaultStyleString();
    verify(annotation).getRectDifferences();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation, atLeast(1)).getIntent();
    PDAppearanceDictionary appearance = pdFreeTextAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream5.getStream().getLength());
    assertEquals(170, appearanceStream.getContentStream().getLength());
    assertEquals(170, appearanceStream2.getContentStream().getLength());
    assertEquals(170, appearanceStream3.getContentStream().getLength());
    assertEquals(170, appearanceStream4.getContentStream().getLength());
    assertEquals(170, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance8() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(null);
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler =
        new PDFreeTextAppearanceHandler(annotation);

    // Act
    pdFreeTextAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getBorderEffect();
    verify(annotation, atLeast(1)).getDefaultAppearance();
    verify(annotation).getDefaultStyleString();
    verify(annotation).getRectDifferences();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation, atLeast(1)).getIntent();
    PDAppearanceDictionary appearance = pdFreeTextAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(169, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(169, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(169, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(169, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(169, appearanceStream5.getStream().getLength());
    assertEquals(169, appearanceStream.getContentStream().getLength());
    assertEquals(169, appearanceStream2.getContentStream().getLength());
    assertEquals(169, appearanceStream3.getContentStream().getLength());
    assertEquals(169, appearanceStream4.getContentStream().getLength());
    assertEquals(169, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance9() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceRGB.INSTANCE));
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler =
        new PDFreeTextAppearanceHandler(annotation);

    // Act
    pdFreeTextAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getBorderEffect();
    verify(annotation, atLeast(1)).getDefaultAppearance();
    verify(annotation).getDefaultStyleString();
    verify(annotation).getRectDifferences();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation, atLeast(1)).getIntent();
    PDAppearanceDictionary appearance = pdFreeTextAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(172, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(172, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(172, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(172, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(172, appearanceStream5.getStream().getLength());
    assertEquals(172, appearanceStream.getContentStream().getLength());
    assertEquals(172, appearanceStream2.getContentStream().getLength());
    assertEquals(172, appearanceStream3.getContentStream().getLength());
    assertEquals(172, appearanceStream4.getContentStream().getLength());
    assertEquals(172, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance10() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    PDColor pdColor = new PDColor(new COSArray(), null);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler =
        new PDFreeTextAppearanceHandler(annotation);

    // Act
    pdFreeTextAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getBorderEffect();
    verify(annotation, atLeast(1)).getDefaultAppearance();
    verify(annotation).getDefaultStyleString();
    verify(annotation).getRectDifferences();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation, atLeast(1)).getIntent();
    PDAppearanceDictionary appearance = pdFreeTextAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream5.getStream().getLength());
    assertEquals(167, appearanceStream.getContentStream().getLength());
    assertEquals(167, appearanceStream2.getContentStream().getLength());
    assertEquals(167, appearanceStream3.getContentStream().getLength());
    assertEquals(167, appearanceStream4.getContentStream().getLength());
    assertEquals(167, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance11() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(null);
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler =
        new PDFreeTextAppearanceHandler(annotation);

    // Act
    pdFreeTextAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getCOSObject();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getBorderEffect();
    verify(annotation, atLeast(1)).getDefaultAppearance();
    verify(annotation).getDefaultStyleString();
    verify(annotation).getRectDifferences();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation, atLeast(1)).getIntent();
    PDAppearanceDictionary appearance = pdFreeTextAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(161, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(161, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(161, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(161, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(161, appearanceStream5.getStream().getLength());
    assertEquals(161, appearanceStream.getContentStream().getLength());
    assertEquals(161, appearanceStream2.getContentStream().getLength());
    assertEquals(161, appearanceStream3.getContentStream().getLength());
    assertEquals(161, appearanceStream4.getContentStream().getLength());
    assertEquals(161, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance12() {
    // Arrange
    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getStyle()).thenThrow(new IllegalArgumentException());

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getBorderEffect();
    verify(annotation).getDefaultAppearance();
    verify(annotation).getDefaultStyleString();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation, atLeast(1)).getIntent();
    verify(pdBorderEffectDictionary).getStyle();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance13() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doThrow(new IllegalArgumentException())
        .when(pdAppearanceStream)
        .setBBox(Mockito.<PDRectangle>any());

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("Style");

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(pdColor).getComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getBorderEffect();
    verify(annotation).getDefaultAppearance();
    verify(annotation).getDefaultStyleString();
    verify(annotation).getRectDifferences();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation, atLeast(1)).getIntent();
    verify(pdBorderEffectDictionary).getStyle();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance14() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(cosArray);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getBorderStyle();
    verify(annotation).getIntent();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance15() {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(cosArray);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getBorderStyle();
    verify(annotation).getIntent();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance16() {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doThrow(new IllegalArgumentException())
        .when(cosUpdateState)
        .setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(cosArray);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSStream()));

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(annotation).getAppearance();
    verify(annotation).getRectangle();
    verify(annotation).getBorderStyle();
    verify(annotation).getIntent();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance17() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenThrow(new IllegalArgumentException());

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(annotation).getBorderStyle();
    verify(annotation).getIntent();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance18() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getCallout()).thenReturn(new float[] {});
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getIntent()).thenReturn("FreeTextCallout");
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isA(COSBase.class));
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getCallout();
    verify(annotation).getBorderStyle();
    verify(annotation).getIntent();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance19() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getCallout()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getIntent()).thenReturn("FreeTextCallout");
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isA(COSBase.class));
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getCallout();
    verify(annotation).getBorderStyle();
    verify(annotation).getIntent();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance20() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenThrow(new IllegalArgumentException());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getCallout()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getIntent()).thenReturn("FreeTextCallout");
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(annotation).getCallout();
    verify(annotation).getBorderStyle();
    verify(annotation).getIntent();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link BogusColorSpace#BogusColorSpace(int)} with numComponents is ten.
   * </ul>
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given BogusColorSpace(int) with numComponents is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenBogusColorSpaceWithNumComponentsIsTen() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt()))
        .thenThrow(new IllegalArgumentException());

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    COSArray array = new COSArray();
    PDJPXColorSpace colorSpace = new PDJPXColorSpace(new BogusColorSpace(10));

    PDColor pdColor = new PDColor(array, colorSpace);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getBorderEffect();
    verify(annotation).getDefaultAppearance();
    verify(annotation).getDefaultStyleString();
    verify(annotation).getRectDifferences();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation, atLeast(1)).getIntent();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#isDirect()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given COSArray isDirect() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSArrayIsDirectThrowIllegalArgumentException() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenThrow(new IllegalArgumentException());

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(cosArray).isDirect();
    verify(pdImmutableRectangle).getCOSArray();
    verify(annotation).getAppearance();
    verify(annotation).getRectangle();
    verify(annotation).getBorderStyle();
    verify(annotation).getIntent();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSStream} {@link COSStream#createOutputStream(COSBase)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given COSStream createOutputStream(COSBase) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSStreamCreateOutputStreamReturnNull()
      throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(null);
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isA(COSBase.class));
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getBorderStyle();
    verify(annotation).getIntent();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSStream} {@link COSStream#setName(COSName, String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given COSStream setName(COSName, String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSStreamSetNameThrowIllegalArgumentException() {
    // Arrange
    COSStream entry = mock(COSStream.class);
    doThrow(new IllegalArgumentException())
        .when(entry)
        .setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(entry).setName(isA(COSName.class), eq("XObject"));
    verify(annotation).getAppearance();
    verify(annotation).getBorderStyle();
    verify(annotation).getIntent();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationFreeText} {@link PDAnnotationFreeText#getBorderEffect()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDAnnotationFreeText getBorderEffect() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAnnotationFreeTextGetBorderEffectReturnNull() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler =
        new PDFreeTextAppearanceHandler(annotation);

    // Act
    pdFreeTextAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getBorderEffect();
    verify(annotation, atLeast(1)).getDefaultAppearance();
    verify(annotation).getDefaultStyleString();
    verify(annotation).getRectDifferences();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation, atLeast(1)).getIntent();
    PDAppearanceDictionary appearance = pdFreeTextAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream5.getStream().getLength());
    assertEquals(170, appearanceStream.getContentStream().getLength());
    assertEquals(170, appearanceStream2.getContentStream().getLength());
    assertEquals(170, appearanceStream3.getContentStream().getLength());
    assertEquals(170, appearanceStream4.getContentStream().getLength());
    assertEquals(170, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationFreeText} {@link PDAnnotationFreeText#getCallout()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDAnnotationFreeText getCallout() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAnnotationFreeTextGetCalloutReturnNull()
      throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getCallout()).thenReturn(null);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getIntent()).thenReturn("FreeTextCallout");
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isA(COSBase.class));
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getCallout();
    verify(annotation).getBorderStyle();
    verify(annotation).getIntent();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationFreeText} {@link PDAnnotationFreeText#getColor()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDAnnotationFreeText getColor() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAnnotationFreeTextGetColorReturnNull() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(null);
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler =
        new PDFreeTextAppearanceHandler(annotation);

    // Act
    pdFreeTextAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getBorderEffect();
    verify(annotation, atLeast(1)).getDefaultAppearance();
    verify(annotation).getDefaultStyleString();
    verify(annotation).getRectDifferences();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation, atLeast(1)).getIntent();
    PDAppearanceDictionary appearance = pdFreeTextAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream5.getStream().getLength());
    assertEquals(167, appearanceStream.getContentStream().getLength());
    assertEquals(167, appearanceStream2.getContentStream().getLength());
    assertEquals(167, appearanceStream3.getContentStream().getLength());
    assertEquals(167, appearanceStream4.getContentStream().getLength());
    assertEquals(167, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDAppearanceStream} {@link PDAppearanceStream#setBBox(PDRectangle)} does
   *       nothing.
   * </ul>
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDAppearanceStream setBBox(PDRectangle) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAppearanceStreamSetBBoxDoesNothing() {
    // Arrange
    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt()))
        .thenThrow(new IllegalArgumentException());

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getBorderEffect();
    verify(annotation).getDefaultAppearance();
    verify(annotation).getDefaultStyleString();
    verify(annotation).getRectDifferences();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation, atLeast(1)).getIntent();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDBorderStyleDictionary} {@link PDBorderStyleDictionary#getStyle()} return
   *       {@code Style}.
   * </ul>
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDBorderStyleDictionary getStyle() return 'Style'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDBorderStyleDictionaryGetStyleReturnStyle()
      throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isA(COSBase.class));
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getBorderStyle();
    verify(annotation).getIntent();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDBorderStyleDictionary} {@link PDBorderStyleDictionary#getStyle()} return
   *       {@code Style}.
   * </ul>
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDBorderStyleDictionary getStyle() return 'Style'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDBorderStyleDictionaryGetStyleReturnStyle2()
      throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getCallout()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getIntent()).thenReturn("FreeTextCallout");
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isA(COSBase.class));
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getCallout();
    verify(annotation).getBorderStyle();
    verify(annotation).getIntent();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDImmutableRectangle} {@link PDImmutableRectangle#getCOSArray()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDImmutableRectangle getCOSArray() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDImmutableRectangleGetCOSArrayReturnNull() {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(null);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getBorderStyle();
    verify(annotation).getIntent();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Then calls {@link COSStream#getCOSDictionary(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls getCOSDictionary(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isA(COSBase.class));
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getBorderStyle();
    verify(annotation).getIntent();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Then calls {@link PDLineDashPattern#getDashArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls getDashArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsGetDashArray() throws IOException {
    // Arrange
    PDLineDashPattern pdLineDashPattern = mock(PDLineDashPattern.class);
    when(pdLineDashPattern.getDashArray()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(pdLineDashPattern);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdImmutableRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getCallout()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getIntent()).thenReturn("FreeTextCallout");
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isA(COSBase.class));
    verify(pdImmutableRectangle).getCOSArray();
    verify(pdImmutableRectangle).getLowerLeftX();
    verify(pdImmutableRectangle).getLowerLeftY();
    verify(pdLineDashPattern).getDashArray();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getCallout();
    verify(annotation).getBorderStyle();
    verify(annotation).getIntent();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAnnotationFreeText#setAppearance(PDAppearanceDictionary)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls setAppearance(PDAppearanceDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsSetAppearance() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());

    // Act
    new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    verify(annotation).getBorderEffect();
    verify(annotation, atLeast(1)).getDefaultAppearance();
    verify(annotation).getDefaultStyleString();
    verify(annotation).getRectDifferences();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation, atLeast(1)).getIntent();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAppearanceStream#setBBox(PDRectangle)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls setBBox(PDRectangle)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsSetBBox() {
    // Arrange
    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doThrow(new IllegalArgumentException())
        .when(pdAppearanceStream)
        .setBBox(Mockito.<PDRectangle>any());

    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("Style");

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getBorderEffect();
    verify(annotation).getDefaultAppearance();
    verify(annotation).getDefaultStyleString();
    verify(annotation).getRectDifferences();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(annotation, atLeast(1)).getIntent();
    verify(pdBorderEffectDictionary).getStyle();
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls setNormalAppearance(PDAppearanceEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsSetNormalAppearance() {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doThrow(new IllegalArgumentException())
        .when(cosUpdateState)
        .setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

    PDImmutableRectangle pdImmutableRectangle = mock(PDImmutableRectangle.class);
    when(pdImmutableRectangle.getCOSArray()).thenReturn(cosArray);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getRectangle()).thenReturn(pdImmutableRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFreeTextAppearanceHandler(annotation).generateNormalAppearance());
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdImmutableRectangle).getCOSArray();
    verify(annotation).getAppearance();
    verify(annotation).getRectangle();
    verify(annotation).getBorderStyle();
    verify(annotation).getIntent();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }
}
