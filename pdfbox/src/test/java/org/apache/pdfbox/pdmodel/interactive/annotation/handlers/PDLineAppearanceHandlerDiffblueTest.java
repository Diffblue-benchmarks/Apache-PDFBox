package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import com.github.jaiimageio.impl.common.BogusColorSpace;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDImmutableRectangle;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDJPXColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDPattern;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLine;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDLineAppearanceHandlerDiffblueTest {
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
   *   <li>{@link PDLineAppearanceHandler#PDLineAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDLineAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDLineAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDLineAppearanceHandler.<init>(PDAnnotation)",
    "void PDLineAppearanceHandler.<init>(PDAnnotation, org.apache.pdfbox.pdmodel.PDDocument)",
    "void PDLineAppearanceHandler.generateDownAppearance()",
    "void PDLineAppearanceHandler.generateRolloverAppearance()"
  })
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDLineAppearanceHandler actualPdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);
    actualPdLineAppearanceHandler.generateDownAppearance();
    actualPdLineAppearanceHandler.generateRolloverAppearance();

    // Assert
    assertTrue(actualPdLineAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdLineAppearanceHandler.getAnnotation());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getLine()).thenThrow(new IllegalArgumentException());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(annotation).getRectangle();
    verify(annotation).getLine();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance2() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getBorderStyle()).thenThrow(new IllegalArgumentException());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(annotation).getRectangle();
    verify(annotation).getLine();
    verify(annotation).getBorderStyle();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance3() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getColor()).thenThrow(new IllegalArgumentException());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getLine();
    verify(annotation).getBorderStyle();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance4() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getLeaderLineLength()).thenThrow(new IllegalArgumentException());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLine();
    verify(annotation).getBorderStyle();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance5() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    COSArray array = new COSArray();
    PDColor pdColor = new PDColor(array, new PDPattern(new PDResources()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert that nothing has changed
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getLine();
    verify(annotation).getBorderStyle();
    PDRectangle rectangle = pdLineAppearanceHandler.getRectangle();
    assertTrue(rectangle instanceof PDImmutableRectangle);
    assertEquals(0.0f, rectangle.getLowerLeftX());
    assertEquals(2383.937f, rectangle.getUpperRightX());
    assertEquals(3370.3938f, rectangle.getHeight());
    assertEquals(3370.3938f, rectangle.getUpperRightY());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance6() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    doThrow(new IllegalArgumentException())
        .when(annotation)
        .setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getBorderStyle();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance7() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionPositioning()).thenThrow(new IllegalArgumentException());
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionPositioning();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance8() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor())
        .thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdLineAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(182, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(182, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(182, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdLineAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(182, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLineAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(182, appearanceStream5.getStream().getLength());
    assertEquals(182, appearanceStream.getContentStream().getLength());
    assertEquals(182, appearanceStream2.getContentStream().getLength());
    assertEquals(182, appearanceStream3.getContentStream().getLength());
    assertEquals(182, appearanceStream4.getContentStream().getLength());
    assertEquals(182, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {20.0f, 30.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance9() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenThrow(new IllegalArgumentException());
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getEndPointEndingStyle();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance10() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor())
        .thenReturn(new PDColor(new COSArray(), PDDeviceRGB.INSTANCE));
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdLineAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(187, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(187, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(187, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdLineAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(187, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLineAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(187, appearanceStream5.getStream().getLength());
    assertEquals(187, appearanceStream.getContentStream().getLength());
    assertEquals(187, appearanceStream2.getContentStream().getLength());
    assertEquals(187, appearanceStream3.getContentStream().getLength());
    assertEquals(187, appearanceStream4.getContentStream().getLength());
    assertEquals(187, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {20.0f, 30.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance11() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    COSArray array = new COSArray();
    PDColor pdColor = new PDColor(array, new PDPattern(new PDResources()));
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdLineAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(178, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(178, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(178, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdLineAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(178, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLineAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(178, appearanceStream5.getStream().getLength());
    assertEquals(178, appearanceStream.getContentStream().getLength());
    assertEquals(178, appearanceStream2.getContentStream().getLength());
    assertEquals(178, appearanceStream3.getContentStream().getLength());
    assertEquals(178, appearanceStream4.getContentStream().getLength());
    assertEquals(178, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {20.0f, 30.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance12() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor())
        .thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    PDRectangle rectangle = pdLineAppearanceHandler.getRectangle();
    assertEquals(-20.0f, rectangle.getLowerLeftX());
    assertEquals(-30.0f, rectangle.getLowerLeftY());
    assertEquals(30.0f, rectangle.getUpperRightY());
    assertEquals(40.0f, rectangle.getUpperRightX());
    assertEquals(60.0f, rectangle.getHeight());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance13() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor())
        .thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceRGB.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdLineAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(187, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(187, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(187, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdLineAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(187, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLineAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(187, appearanceStream5.getStream().getLength());
    assertEquals(187, appearanceStream.getContentStream().getLength());
    assertEquals(187, appearanceStream2.getContentStream().getLength());
    assertEquals(187, appearanceStream3.getContentStream().getLength());
    assertEquals(187, appearanceStream4.getContentStream().getLength());
    assertEquals(187, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {20.0f, 30.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance14() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor())
        .thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine())
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
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    PDRectangle rectangle = pdLineAppearanceHandler.getRectangle();
    assertEquals(-29.0f, rectangle.getLowerLeftX());
    assertEquals(31.0f, rectangle.getUpperRightX());
    assertEquals(Float.MAX_VALUE, rectangle.getHeight());
    assertEquals(Float.MAX_VALUE, rectangle.getUpperRightY());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance15() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdLineAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(198, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(198, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(198, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdLineAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(198, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLineAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(198, appearanceStream5.getStream().getLength());
    assertEquals(198, appearanceStream.getContentStream().getLength());
    assertEquals(198, appearanceStream2.getContentStream().getLength());
    assertEquals(198, appearanceStream3.getContentStream().getLength());
    assertEquals(198, appearanceStream4.getContentStream().getLength());
    assertEquals(198, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {20.0f, 30.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance16() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdLineAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(194, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(194, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(194, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdLineAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(194, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLineAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(194, appearanceStream5.getStream().getLength());
    assertEquals(194, appearanceStream.getContentStream().getLength());
    assertEquals(194, appearanceStream2.getContentStream().getLength());
    assertEquals(194, appearanceStream3.getContentStream().getLength());
    assertEquals(194, appearanceStream4.getContentStream().getLength());
    assertEquals(194, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {20.0f, 30.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance17() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenThrow(new IllegalArgumentException());

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getBorderStyle();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance18() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSStream()));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance19() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance20() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any()))
        .thenThrow(new IllegalArgumentException());

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation).getEndPointEndingStyle();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance21() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any()))
        .thenReturn(COSName.ABSOLUTE_COLORIMETRIC);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance22() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any()))
        .thenReturn(COSName.ADBE_PKCS7_DETACHED);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance23() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any()))
        .thenReturn(COSName.ADBE_X509_RSA_SHA1);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance24() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenThrow(new IllegalArgumentException());

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(annotation).getRectangle();
    verify(annotation).getLine();
    verify(annotation).getBorderStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance25() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getLowerLeftX()).thenThrow(new IllegalArgumentException());

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(pdRectangle);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(pdRectangle).getLowerLeftX();
    verify(pdColor).getComponents();
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getBorderStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance26() throws IOException {
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

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getConstantOpacity()).thenReturn(Float.MIN_VALUE);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(pdRectangle);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(-90.0f);
    verify(pdRectangle).setLowerLeftY(-100.0f);
    verify(pdRectangle).setUpperRightX(110.0f);
    verify(pdRectangle).setUpperRightY(100.0f);
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link BogusColorSpace#BogusColorSpace(int)} with numComponents is ten.
   * </ul>
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given BogusColorSpace(int) with numComponents is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenBogusColorSpaceWithNumComponentsIsTen()
      throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    COSArray array = new COSArray();
    PDJPXColorSpace colorSpace = new PDJPXColorSpace(new BogusColorSpace(10));

    PDColor pdColor = new PDColor(array, colorSpace);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation).getEndPointEndingStyle();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given COSDictionary getCOSDictionary(COSName) return COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSDictionaryGetCOSDictionaryReturnCOSStream()
      throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSStream());

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getKeyForValue(Object)} return {@link
   *       COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given COSDictionary getKeyForValue(Object) return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSDictionaryGetKeyForValueReturnA() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.A);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSStream} {@link COSStream#getCOSDictionary(COSName)} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given COSStream getCOSDictionary(COSName) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSStreamGetCOSDictionaryReturnCOSDictionary()
      throws IOException {
    // Arrange
    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationLine} {@link PDAnnotationLine#getColor()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDAnnotationLine getColor() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAnnotationLineGetColorReturnNull() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getColor()).thenReturn(null);
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert that nothing has changed
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getLine();
    verify(annotation).getBorderStyle();
    PDRectangle rectangle = pdLineAppearanceHandler.getRectangle();
    assertTrue(rectangle instanceof PDImmutableRectangle);
    assertEquals(0.0f, rectangle.getLowerLeftX());
    assertEquals(2383.937f, rectangle.getUpperRightX());
    assertEquals(3370.3938f, rectangle.getHeight());
    assertEquals(3370.3938f, rectangle.getUpperRightY());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationLine} {@link PDAnnotationLine#getContents()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDAnnotationLine getContents() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAnnotationLineGetContentsReturnNull()
      throws IOException {
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

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(mock(COSDictionary.class));
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn(null);
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(pdRectangle);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(-90.0f);
    verify(pdRectangle).setLowerLeftY(-100.0f);
    verify(pdRectangle).setUpperRightX(110.0f);
    verify(pdRectangle).setUpperRightY(100.0f);
    verify(pdColor2).getComponents();
    verify(pdColor, atLeast(1)).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationLine} {@link PDAnnotationLine#getInteriorColor()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDAnnotationLine getInteriorColor() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAnnotationLineGetInteriorColorReturnNull() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(null);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdLineAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(178, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(178, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(178, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdLineAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(178, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLineAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(178, appearanceStream5.getStream().getLength());
    assertEquals(178, appearanceStream.getContentStream().getLength());
    assertEquals(178, appearanceStream2.getContentStream().getLength());
    assertEquals(178, appearanceStream3.getContentStream().getLength());
    assertEquals(178, appearanceStream4.getContentStream().getLength());
    assertEquals(178, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {20.0f, 30.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationLine} {@link PDAnnotationLine#getLine()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDAnnotationLine getLine() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAnnotationLineGetLineReturnNull() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getLine()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert that nothing has changed
    verify(annotation).getRectangle();
    verify(annotation).getLine();
    PDRectangle rectangle = pdLineAppearanceHandler.getRectangle();
    assertTrue(rectangle instanceof PDImmutableRectangle);
    assertEquals(0.0f, rectangle.getLowerLeftX());
    assertEquals(2383.937f, rectangle.getUpperRightX());
    assertEquals(3370.3938f, rectangle.getHeight());
    assertEquals(3370.3938f, rectangle.getUpperRightY());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationLine} {@link PDAnnotationLine#hasCaption()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDAnnotationLine hasCaption() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAnnotationLineHasCaptionReturnFalse()
      throws IOException {
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

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(mock(COSDictionary.class));
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDColor pdColor2 = mock(PDColor.class);
    when(pdColor2.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getInteriorColor()).thenReturn(pdColor2);
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(false);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(pdRectangle);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(-90.0f);
    verify(pdRectangle).setLowerLeftY(-100.0f);
    verify(pdRectangle).setUpperRightX(110.0f);
    verify(pdRectangle).setUpperRightY(100.0f);
    verify(pdColor2).getComponents();
    verify(pdColor, atLeast(1)).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAnnotationLine#getBorder()}.
   * </ul>
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls getBorder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsGetBorder() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor())
        .thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(null);
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation, atLeast(1)).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation, atLeast(1)).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdLineAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(182, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(182, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(182, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdLineAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(182, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLineAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(182, appearanceStream5.getStream().getLength());
    assertEquals(182, appearanceStream.getContentStream().getLength());
    assertEquals(182, appearanceStream2.getContentStream().getLength());
    assertEquals(182, appearanceStream3.getContentStream().getLength());
    assertEquals(182, appearanceStream4.getContentStream().getLength());
    assertEquals(182, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {20.0f, 30.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Then calls {@link PDRectangle#getCOSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls getCOSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsGetCOSArray() throws IOException {
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

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(pdRectangle);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(-90.0f);
    verify(pdRectangle).setLowerLeftY(-100.0f);
    verify(pdRectangle).setUpperRightX(110.0f);
    verify(pdRectangle).setUpperRightY(100.0f);
    verify(pdColor, atLeast(1)).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation).getEndPointEndingStyle();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Then calls {@link PDBorderStyleDictionary#getStyle()}.
   * </ul>
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls getStyle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsGetStyle() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation).getEndPointEndingStyle();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Then calls {@link PDBorderStyleDictionary#getStyle()}.
   * </ul>
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls getStyle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsGetStyle2() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException());
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdColor, atLeast(1)).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation).getEndPointEndingStyle();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls setItem(COSName, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsSetItem() throws IOException {
    // Arrange
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

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls setNormalAppearance(PDAppearanceEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsSetNormalAppearance() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenThrow(new IllegalArgumentException());

    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(pdColor);
    when(annotation.getCaptionPositioning()).thenReturn("Caption Positioning");
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDLineAppearanceHandler(annotation).generateNormalAppearance());
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getCaptionHorizontalOffset();
    verify(annotation).getCaptionPositioning();
    verify(annotation).getCaptionVerticalOffset();
    verify(annotation).getEndPointEndingStyle();
    verify(annotation).getInteriorColor();
    verify(annotation).getLeaderLineExtensionLength();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLeaderLineOffsetLength();
    verify(annotation).getLine();
    verify(annotation).getStartPointEndingStyle();
    verify(annotation).hasCaption();
    verify(annotation).getBorderStyle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }
}
