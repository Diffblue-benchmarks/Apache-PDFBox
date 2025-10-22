package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
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
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#PDFreeTextAppearanceHandler(PDAnnotation)}
   */
  @Test
  @DisplayName("Test new PDFreeTextAppearanceHandler(PDAnnotation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.<init>(PDAnnotation)"})
  void testNewPDFreeTextAppearanceHandler() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDFreeTextAppearanceHandler actualPdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

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
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#PDFreeTextAppearanceHandler(PDAnnotation, PDDocument)}
   */
  @Test
  @DisplayName("Test new PDFreeTextAppearanceHandler(PDAnnotation, PDDocument)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.<init>(PDAnnotation, PDDocument)"})
  void testNewPDFreeTextAppearanceHandler2() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDFreeTextAppearanceHandler actualPdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation,
        new PDDocument());

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
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance() {
    // Arrange
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(160, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(160, appearanceStream5.getStream().getLength());
    assertEquals(160, appearanceStream.getContentStream().getLength());
    assertEquals(160, appearanceStream2.getContentStream().getLength());
    assertEquals(160, appearanceStream3.getContentStream().getLength());
    assertEquals(160, appearanceStream4.getContentStream().getLength());
    assertEquals(160, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance2() {
    // Arrange
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Ucolor: #999999U");
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

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
    assertEquals(132, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(132, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(132, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(132, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(132, appearanceStream5.getStream().getLength());
    assertEquals(132, appearanceStream.getContentStream().getLength());
    assertEquals(132, appearanceStream2.getContentStream().getLength());
    assertEquals(132, appearanceStream3.getContentStream().getLength());
    assertEquals(132, appearanceStream4.getContentStream().getLength());
    assertEquals(132, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance3() {
    // Arrange
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn(null);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

    // Act
    pdFreeTextAppearanceHandler.generateNormalAppearance();

    // Assert
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
    PDAppearanceStream appearanceStream = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(78, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(78, appearanceStream2.getStream().getLength());
    assertEquals(78, appearanceStream.getContentStream().getLength());
    assertEquals(78, appearanceStream2.getContentStream().getLength());
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance4() {
    // Arrange
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("");
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

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
    assertEquals(104, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(104, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(104, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(104, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(104, appearanceStream5.getStream().getLength());
    assertEquals(104, appearanceStream.getContentStream().getLength());
    assertEquals(104, appearanceStream2.getContentStream().getLength());
    assertEquals(104, appearanceStream3.getContentStream().getLength());
    assertEquals(104, appearanceStream4.getContentStream().getLength());
    assertEquals(104, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance5() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream5.getStream().getLength());
    assertEquals(170, appearanceStream.getContentStream().getLength());
    assertEquals(170, appearanceStream2.getContentStream().getLength());
    assertEquals(170, appearanceStream3.getContentStream().getLength());
    assertEquals(170, appearanceStream4.getContentStream().getLength());
    assertEquals(170, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance6() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(-9.223372E18f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    Iterable<COSName> extGStateNames = appearanceStream.getResources().getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals(1, ((Set<COSName>) extGStateNames).size());
    assertEquals(175, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(175, appearanceStream2.getStream().getLength());
    assertEquals(175, appearanceStream.getContentStream().getLength());
    assertEquals(175, appearanceStream2.getContentStream().getLength());
    assertSame(extGStateNames, appearanceStream2.getResources().getExtGStateNames());
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance7() {
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
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(169, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(169, appearanceStream5.getStream().getLength());
    assertEquals(169, appearanceStream.getContentStream().getLength());
    assertEquals(169, appearanceStream2.getContentStream().getLength());
    assertEquals(169, appearanceStream3.getContentStream().getLength());
    assertEquals(169, appearanceStream4.getContentStream().getLength());
    assertEquals(169, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance8() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Ucolor: #999999U");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream5.getStream().getLength());
    assertEquals(170, appearanceStream.getContentStream().getLength());
    assertEquals(170, appearanceStream2.getContentStream().getLength());
    assertEquals(170, appearanceStream3.getContentStream().getLength());
    assertEquals(170, appearanceStream4.getContentStream().getLength());
    assertEquals(170, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance9() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Intent");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream5.getStream().getLength());
    assertEquals(170, appearanceStream.getContentStream().getLength());
    assertEquals(170, appearanceStream2.getContentStream().getLength());
    assertEquals(170, appearanceStream3.getContentStream().getLength());
    assertEquals(170, appearanceStream4.getContentStream().getLength());
    assertEquals(170, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance10() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("foo");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream5.getStream().getLength());
    assertEquals(170, appearanceStream.getContentStream().getLength());
    assertEquals(170, appearanceStream2.getContentStream().getLength());
    assertEquals(170, appearanceStream3.getContentStream().getLength());
    assertEquals(170, appearanceStream4.getContentStream().getLength());
    assertEquals(170, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance11() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("g");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream5.getStream().getLength());
    assertEquals(170, appearanceStream.getContentStream().getLength());
    assertEquals(170, appearanceStream2.getContentStream().getLength());
    assertEquals(170, appearanceStream3.getContentStream().getLength());
    assertEquals(170, appearanceStream4.getContentStream().getLength());
    assertEquals(170, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance12() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn(null);
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream5.getStream().getLength());
    assertEquals(170, appearanceStream.getContentStream().getLength());
    assertEquals(170, appearanceStream2.getContentStream().getLength());
    assertEquals(170, appearanceStream3.getContentStream().getLength());
    assertEquals(170, appearanceStream4.getContentStream().getLength());
    assertEquals(170, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance13() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("ID");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream5.getStream().getLength());
    assertEquals(170, appearanceStream.getContentStream().getLength());
    assertEquals(170, appearanceStream2.getContentStream().getLength());
    assertEquals(170, appearanceStream3.getContentStream().getLength());
    assertEquals(170, appearanceStream4.getContentStream().getLength());
    assertEquals(170, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance14() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Ucolor: #999999U");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

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
    assertEquals(174, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(174, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(174, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(174, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(174, appearanceStream5.getStream().getLength());
    assertEquals(174, appearanceStream.getContentStream().getLength());
    assertEquals(174, appearanceStream2.getContentStream().getLength());
    assertEquals(174, appearanceStream3.getContentStream().getLength());
    assertEquals(174, appearanceStream4.getContentStream().getLength());
    assertEquals(174, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance15() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn(null);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(170, appearanceStream5.getStream().getLength());
    assertEquals(170, appearanceStream.getContentStream().getLength());
    assertEquals(170, appearanceStream2.getContentStream().getLength());
    assertEquals(170, appearanceStream3.getContentStream().getLength());
    assertEquals(170, appearanceStream4.getContentStream().getLength());
    assertEquals(170, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance16() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), null));
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream5.getStream().getLength());
    assertEquals(167, appearanceStream.getContentStream().getLength());
    assertEquals(167, appearanceStream2.getContentStream().getLength());
    assertEquals(167, appearanceStream3.getContentStream().getLength());
    assertEquals(167, appearanceStream4.getContentStream().getLength());
    assertEquals(167, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance17() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

    // Act
    pdFreeTextAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(colorSpace).getNumberOfComponents();
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
    assertEquals(171, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream5.getStream().getLength());
    assertEquals(171, appearanceStream.getContentStream().getLength());
    assertEquals(171, appearanceStream2.getContentStream().getLength());
    assertEquals(171, appearanceStream3.getContentStream().getLength());
    assertEquals(171, appearanceStream4.getContentStream().getLength());
    assertEquals(171, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance18() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("BI");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

    // Act
    pdFreeTextAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(colorSpace).getNumberOfComponents();
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
    assertEquals(171, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream5.getStream().getLength());
    assertEquals(171, appearanceStream.getContentStream().getLength());
    assertEquals(171, appearanceStream2.getContentStream().getLength());
    assertEquals(171, appearanceStream3.getContentStream().getLength());
    assertEquals(171, appearanceStream4.getContentStream().getLength());
    assertEquals(171, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance19() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

    // Act
    pdFreeTextAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(colorSpace).getNumberOfComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
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
    assertEquals(171, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream5.getStream().getLength());
    assertEquals(171, appearanceStream.getContentStream().getLength());
    assertEquals(171, appearanceStream2.getContentStream().getLength());
    assertEquals(171, appearanceStream3.getContentStream().getLength());
    assertEquals(171, appearanceStream4.getContentStream().getLength());
    assertEquals(171, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance20() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("Style");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

    // Act
    pdFreeTextAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(colorSpace).getNumberOfComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
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
    verify(pdBorderEffectDictionary).getStyle();
    PDAppearanceDictionary appearance = pdFreeTextAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream5.getStream().getLength());
    assertEquals(171, appearanceStream.getContentStream().getLength());
    assertEquals(171, appearanceStream2.getContentStream().getLength());
    assertEquals(171, appearanceStream3.getContentStream().getLength());
    assertEquals(171, appearanceStream4.getContentStream().getLength());
    assertEquals(171, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance21() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(new COSArray());
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("Style");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(null);
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

    // Act
    pdFreeTextAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle, atLeast(1)).getWidth();
    verify(colorSpace).getNumberOfComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
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
    verify(pdBorderEffectDictionary).getStyle();
    PDRectangle bBox = pdFreeTextAppearanceHandler.getAppearance().getDownAppearance().getAppearanceStream().getBBox();
    assertEquals(0.0f, bBox.getHeight());
    PDAppearanceStream appearanceStream = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
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
    List<? extends COSBase> toListResult = bBox2.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertEquals(toListResult,
        pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream().getBBox().getCOSArray().toList());
    assertArrayEquals(new float[]{-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance22() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(new COSArray());
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("Style");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Intent");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(null);
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

    // Act
    pdFreeTextAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle, atLeast(1)).getWidth();
    verify(colorSpace).getNumberOfComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
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
    verify(pdBorderEffectDictionary).getStyle();
    PDAppearanceDictionary appearance = pdFreeTextAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(119, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(119, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(119, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(119, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(119, appearanceStream5.getStream().getLength());
    assertEquals(119, appearanceStream.getContentStream().getLength());
    assertEquals(119, appearanceStream2.getContentStream().getLength());
    assertEquals(119, appearanceStream3.getContentStream().getLength());
    assertEquals(119, appearanceStream4.getContentStream().getLength());
    assertEquals(119, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance23() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(null);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("Style");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(null);
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

    // Act
    pdFreeTextAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle, atLeast(1)).getWidth();
    verify(colorSpace).getNumberOfComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
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
    verify(pdBorderEffectDictionary).getStyle();
    PDAppearanceEntry downAppearance = pdFreeTextAppearanceHandler.getDownAppearance();
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    assertEquals(88, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(88, appearanceStream2.getStream().getLength());
    assertEquals(88, appearanceStream.getContentStream().getLength());
    assertEquals(88, appearanceStream2.getContentStream().getLength());
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance24() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    PDBorderEffectDictionary pdBorderEffectDictionary = mock(PDBorderEffectDictionary.class);
    when(pdBorderEffectDictionary.getStyle()).thenReturn("Style");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(null);
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getBorderEffect()).thenReturn(pdBorderEffectDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

    // Act
    pdFreeTextAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle, atLeast(1)).getWidth();
    verify(colorSpace).getNumberOfComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
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
    verify(pdBorderEffectDictionary).getStyle();
    float[][] values = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream().getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdFreeTextAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(88, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(88, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(88, appearanceStream3.getStream().getLength());
    assertEquals(88, appearanceStream.getContentStream().getLength());
    assertEquals(88, appearanceStream2.getContentStream().getLength());
    assertEquals(88, appearanceStream3.getContentStream().getLength());
    assertArrayEquals(new float[]{-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link PDAnnotationFreeText} {@link PDAnnotationFreeText#getBorderEffect()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDAnnotationFreeText getBorderEffect() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAnnotationFreeTextGetBorderEffectReturnNull() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getBorderEffect()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

    // Act
    pdFreeTextAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).getInt(isA(COSName.class), eq(0));
    verify(colorSpace).getNumberOfComponents();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
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
    assertEquals(171, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream5.getStream().getLength());
    assertEquals(171, appearanceStream.getContentStream().getLength());
    assertEquals(171, appearanceStream2.getContentStream().getLength());
    assertEquals(171, appearanceStream3.getContentStream().getLength());
    assertEquals(171, appearanceStream4.getContentStream().getLength());
    assertEquals(171, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link PDAnnotationFreeText} {@link PDAnnotation#getColor()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFreeTextAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDAnnotationFreeText getColor() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFreeTextAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAnnotationFreeTextGetColorReturnNull() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    PDAnnotationFreeText annotation = mock(PDAnnotationFreeText.class);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getRectDifferences()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getDefaultAppearance()).thenReturn("Default Appearance");
    when(annotation.getDefaultStyleString()).thenReturn("Default Style String");
    when(annotation.getColor()).thenReturn(null);
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getBorderEffect()).thenReturn(new PDBorderEffectDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getIntent()).thenReturn("Intent");
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    PDFreeTextAppearanceHandler pdFreeTextAppearanceHandler = new PDFreeTextAppearanceHandler(annotation);

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
    PDAppearanceStream appearanceStream4 = pdFreeTextAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdFreeTextAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream5.getStream().getLength());
    assertEquals(167, appearanceStream.getContentStream().getLength());
    assertEquals(167, appearanceStream2.getContentStream().getLength());
    assertEquals(167, appearanceStream3.getContentStream().getLength());
    assertEquals(167, appearanceStream4.getContentStream().getLength());
    assertEquals(167, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }
}
