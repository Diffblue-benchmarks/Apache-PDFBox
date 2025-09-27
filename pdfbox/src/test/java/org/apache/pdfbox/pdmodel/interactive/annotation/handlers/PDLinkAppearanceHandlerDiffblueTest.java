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
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSFloat;
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
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDLinkAppearanceHandlerDiffblueTest {
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
   *   <li>{@link PDLinkAppearanceHandler#PDLinkAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDLinkAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDLinkAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDLinkAppearanceHandler.<init>(PDAnnotation)",
    "void PDLinkAppearanceHandler.<init>(PDAnnotation, org.apache.pdfbox.pdmodel.PDDocument)",
    "void PDLinkAppearanceHandler.generateDownAppearance()",
    "void PDLinkAppearanceHandler.generateRolloverAppearance()"
  })
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDLinkAppearanceHandler actualPdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);
    actualPdLinkAppearanceHandler.generateDownAppearance();
    actualPdLinkAppearanceHandler.generateRolloverAppearance();

    // Assert
    assertTrue(actualPdLinkAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdLinkAppearanceHandler.getAnnotation());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance() {
    // Arrange
    PDLinkAppearanceHandler pdLinkAppearanceHandler =
        new PDLinkAppearanceHandler(new PDAnnotationLink());

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert that nothing has changed
    assertTrue(pdLinkAppearanceHandler.getDownAppearance().getCOSObject() instanceof COSStream);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance2() {
    // Arrange
    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    PDAppearanceStream appearanceStream =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream4.getStream().getLength());
    assertEquals(6, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream5.getStream().getLength());
    assertEquals(6, appearanceStream2.getContentStream().getLength());
    assertEquals(6, appearanceStream3.getContentStream().getLength());
    assertEquals(6, appearanceStream4.getContentStream().getLength());
    assertEquals(6, appearanceStream.getContentStream().getLength());
    assertEquals(6, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance3() {
    // Arrange
    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(null);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    PDAppearanceStream appearanceStream =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream4.getStream().getLength());
    assertEquals(70, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream5.getStream().getLength());
    assertEquals(70, appearanceStream2.getContentStream().getLength());
    assertEquals(70, appearanceStream3.getContentStream().getLength());
    assertEquals(70, appearanceStream4.getContentStream().getLength());
    assertEquals(70, appearanceStream.getContentStream().getLength());
    assertEquals(70, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance4() {
    // Arrange
    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints())
        .thenReturn(
            new float[] {
              1.0f, 9.223372E18f, 1.0f, 9.223372E18f, 1.0f, 9.223372E18f, 1.0f, 9.223372E18f
            });
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    PDAppearanceStream appearanceStream =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream4.getStream().getLength());
    assertEquals(70, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream5.getStream().getLength());
    assertEquals(70, appearanceStream2.getContentStream().getLength());
    assertEquals(70, appearanceStream3.getContentStream().getLength());
    assertEquals(70, appearanceStream4.getContentStream().getLength());
    assertEquals(70, appearanceStream.getContentStream().getLength());
    assertEquals(70, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance5() {
    // Arrange
    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceRGB.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(11, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(11, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(11, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(11, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(11, appearanceStream5.getStream().getLength());
    assertEquals(11, appearanceStream.getContentStream().getLength());
    assertEquals(11, appearanceStream2.getContentStream().getLength());
    assertEquals(11, appearanceStream3.getContentStream().getLength());
    assertEquals(11, appearanceStream4.getContentStream().getLength());
    assertEquals(11, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance6() {
    // Arrange
    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    PDColor pdColor = new PDColor(new COSArray(), null);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(2, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(2, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(2, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(2, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(2, appearanceStream5.getStream().getLength());
    assertEquals(2, appearanceStream.getContentStream().getLength());
    assertEquals(2, appearanceStream2.getContentStream().getLength());
    assertEquals(2, appearanceStream3.getContentStream().getLength());
    assertEquals(2, appearanceStream4.getContentStream().getLength());
    assertEquals(2, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance7() {
    // Arrange
    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    PDAppearanceStream appearanceStream =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(52, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(52, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(52, appearanceStream4.getStream().getLength());
    assertEquals(52, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(52, appearanceStream5.getStream().getLength());
    assertEquals(52, appearanceStream2.getContentStream().getLength());
    assertEquals(52, appearanceStream3.getContentStream().getLength());
    assertEquals(52, appearanceStream4.getContentStream().getLength());
    assertEquals(52, appearanceStream.getContentStream().getLength());
    assertEquals(52, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance8() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream5.getStream().getLength());
    assertEquals(22, appearanceStream.getContentStream().getLength());
    assertEquals(22, appearanceStream2.getContentStream().getLength());
    assertEquals(22, appearanceStream3.getContentStream().getLength());
    assertEquals(22, appearanceStream4.getContentStream().getLength());
    assertEquals(22, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance9() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(18, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(18, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(18, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(18, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(18, appearanceStream5.getStream().getLength());
    assertEquals(18, appearanceStream.getContentStream().getLength());
    assertEquals(18, appearanceStream2.getContentStream().getLength());
    assertEquals(18, appearanceStream3.getContentStream().getLength());
    assertEquals(18, appearanceStream4.getContentStream().getLength());
    assertEquals(18, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance10() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(new COSDictionary());

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(23, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(23, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(23, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(23, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(23, appearanceStream5.getStream().getLength());
    assertEquals(23, appearanceStream.getContentStream().getLength());
    assertEquals(23, appearanceStream2.getContentStream().getLength());
    assertEquals(23, appearanceStream3.getContentStream().getLength());
    assertEquals(23, appearanceStream4.getContentStream().getLength());
    assertEquals(23, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance11() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(new COSDictionary());

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(null);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(79, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(79, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(79, appearanceStream4.getStream().getLength());
    assertEquals(79, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(79, appearanceStream5.getStream().getLength());
    assertEquals(79, appearanceStream2.getContentStream().getLength());
    assertEquals(79, appearanceStream3.getContentStream().getLength());
    assertEquals(79, appearanceStream4.getContentStream().getLength());
    assertEquals(79, appearanceStream.getContentStream().getLength());
    assertEquals(79, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance12() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(null);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(79, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(79, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(79, appearanceStream4.getStream().getLength());
    assertEquals(79, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(79, appearanceStream5.getStream().getLength());
    assertEquals(79, appearanceStream2.getContentStream().getLength());
    assertEquals(79, appearanceStream3.getContentStream().getLength());
    assertEquals(79, appearanceStream4.getContentStream().getLength());
    assertEquals(79, appearanceStream.getContentStream().getLength());
    assertEquals(79, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance13() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(new COSArray());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(null);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    List<? extends COSBase> toListResult = appearanceStream.getBBox().getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    assertEquals(
        toListResult,
        appearance.getDownAppearance().getAppearanceStream().getBBox().getCOSArray().toList());
    assertEquals(
        toListResult,
        appearance.getNormalAppearance().getAppearanceStream().getBBox().getCOSArray().toList());
    assertEquals(
        toListResult,
        appearance.getRolloverAppearance().getAppearanceStream().getBBox().getCOSArray().toList());
    assertEquals(
        toListResult,
        pdLinkAppearanceHandler
            .getRolloverAppearance()
            .getAppearanceStream()
            .getBBox()
            .getCOSArray()
            .toList());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance14() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(null);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(null);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceEntry downAppearance = pdLinkAppearanceHandler.getDownAppearance();
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    assertEquals(57, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 =
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(57, appearanceStream2.getStream().getLength());
    assertEquals(57, appearanceStream.getContentStream().getLength());
    assertEquals(57, appearanceStream2.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance15() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(null);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    float[][] values =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream().getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(57, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(57, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(57, appearanceStream3.getStream().getLength());
    assertEquals(57, appearanceStream.getContentStream().getLength());
    assertEquals(57, appearanceStream2.getContentStream().getLength());
    assertEquals(57, appearanceStream3.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance16() {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(null);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    float[][] values =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream().getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(57, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(57, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(57, appearanceStream3.getStream().getLength());
    assertEquals(57, appearanceStream.getContentStream().getLength());
    assertEquals(57, appearanceStream2.getContentStream().getLength());
    assertEquals(57, appearanceStream3.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance17() {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.contains(anyFloat(), anyFloat())).thenReturn(true);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints())
        .thenReturn(new float[] {1.0f, 9.223372E18f, 1.0f, 9.223372E18f});
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle, atLeast(1)).contains(1.0f, 9.223372E18f);
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(23, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(23, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(23, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(23, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(23, appearanceStream5.getStream().getLength());
    assertEquals(23, appearanceStream.getContentStream().getLength());
    assertEquals(23, appearanceStream2.getContentStream().getLength());
    assertEquals(23, appearanceStream3.getContentStream().getLength());
    assertEquals(23, appearanceStream4.getContentStream().getLength());
    assertEquals(23, appearanceStream5.getContentStream().getLength());
    float[][] values = appearanceStream4.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance18() {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.contains(anyFloat(), anyFloat())).thenReturn(true);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {-9.223372E18f, 0.5f, 10.0f, 0.5f});

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints())
        .thenReturn(new float[] {1.0f, 9.223372E18f, 1.0f, 9.223372E18f});
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle, atLeast(1)).contains(1.0f, 9.223372E18f);
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(41, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(41, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(41, appearanceStream4.getStream().getLength());
    assertEquals(41, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(41, appearanceStream5.getStream().getLength());
    assertEquals(41, appearanceStream2.getContentStream().getLength());
    assertEquals(41, appearanceStream3.getContentStream().getLength());
    assertEquals(41, appearanceStream4.getContentStream().getLength());
    assertEquals(41, appearanceStream.getContentStream().getLength());
    assertEquals(41, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance19() {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.contains(anyFloat(), anyFloat())).thenReturn(true);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints())
        .thenReturn(new float[] {1.0f, 9.223372E18f, 1.0f, 9.223372E18f});
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle, atLeast(1)).contains(1.0f, 9.223372E18f);
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(30, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(30, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(30, appearanceStream4.getStream().getLength());
    assertEquals(30, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(30, appearanceStream5.getStream().getLength());
    assertEquals(30, appearanceStream2.getContentStream().getLength());
    assertEquals(30, appearanceStream3.getContentStream().getLength());
    assertEquals(30, appearanceStream4.getContentStream().getLength());
    assertEquals(30, appearanceStream.getContentStream().getLength());
    assertEquals(30, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance20() {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.contains(anyFloat(), anyFloat())).thenReturn(true);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDLineDashPattern pdLineDashPattern = mock(PDLineDashPattern.class);
    when(pdLineDashPattern.getDashArray()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(pdLineDashPattern);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints())
        .thenReturn(new float[] {1.0f, 9.223372E18f, 1.0f, 9.223372E18f});
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle, atLeast(1)).contains(1.0f, 9.223372E18f);
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(pdLineDashPattern).getDashArray();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(40, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(40, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(40, appearanceStream4.getStream().getLength());
    assertEquals(40, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(40, appearanceStream5.getStream().getLength());
    assertEquals(40, appearanceStream2.getContentStream().getLength());
    assertEquals(40, appearanceStream3.getContentStream().getLength());
    assertEquals(40, appearanceStream4.getContentStream().getLength());
    assertEquals(40, appearanceStream.getContentStream().getLength());
    assertEquals(40, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance21() {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);

    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.contains(anyFloat(), anyFloat())).thenReturn(true);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDLineDashPattern pdLineDashPattern = mock(PDLineDashPattern.class);
    when(pdLineDashPattern.getDashArray()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(pdLineDashPattern);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(-9.223372E18f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints())
        .thenReturn(new float[] {1.0f, 9.223372E18f, 1.0f, 9.223372E18f});
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle, atLeast(1)).contains(1.0f, 9.223372E18f);
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(pdLineDashPattern).getDashArray();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(58, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(58, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(58, appearanceStream4.getStream().getLength());
    assertEquals(58, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(58, appearanceStream5.getStream().getLength());
    assertEquals(58, appearanceStream2.getContentStream().getLength());
    assertEquals(58, appearanceStream3.getContentStream().getLength());
    assertEquals(58, appearanceStream4.getContentStream().getLength());
    assertEquals(58, appearanceStream.getContentStream().getLength());
    assertEquals(58, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#isDirect()} return {@code false}.
   *   <li>Then calls {@link COSArray#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given COSArray isDirect() return 'false'; then calls getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSArrayIsDirectReturnFalse_thenCallsGetKey() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(false);
    when(cosArray.getKey()).thenReturn(new COSObjectKey(1L, 1));

    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.contains(anyFloat(), anyFloat())).thenReturn(true);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(cosArray);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    PDLineDashPattern pdLineDashPattern = mock(PDLineDashPattern.class);
    when(pdLineDashPattern.getDashArray()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(pdLineDashPattern);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);

    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints())
        .thenReturn(new float[] {1.0f, 9.223372E18f, 1.0f, 9.223372E18f});
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray, atLeast(1)).getKey();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(pdRectangle, atLeast(1)).contains(1.0f, 9.223372E18f);
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(pdLineDashPattern).getDashArray();
    verify(pdColor).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(40, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(40, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(40, appearanceStream4.getStream().getLength());
    assertEquals(40, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(40, appearanceStream5.getStream().getLength());
    assertEquals(40, appearanceStream2.getContentStream().getLength());
    assertEquals(40, appearanceStream3.getContentStream().getLength());
    assertEquals(40, appearanceStream4.getContentStream().getLength());
    assertEquals(40, appearanceStream.getContentStream().getLength());
    assertEquals(40, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-10.0f, -10.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationLink} {@link PDAnnotationLink#getBorderStyle()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDAnnotationLink getBorderStyle() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAnnotationLinkGetBorderStyleReturnNull() {
    // Arrange
    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation, atLeast(1)).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    PDAppearanceStream appearanceStream =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream4.getStream().getLength());
    assertEquals(6, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream5.getStream().getLength());
    assertEquals(6, appearanceStream2.getContentStream().getLength());
    assertEquals(6, appearanceStream3.getContentStream().getLength());
    assertEquals(6, appearanceStream4.getContentStream().getLength());
    assertEquals(6, appearanceStream.getContentStream().getLength());
    assertEquals(6, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationLink} {@link PDAnnotationLink#getColor()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDAnnotationLink getColor() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLinkAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAnnotationLinkGetColorReturnNull() {
    // Arrange
    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(null);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    PDAppearanceStream appearanceStream =
        pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream4.getStream().getLength());
    assertEquals(6, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 =
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream5.getStream().getLength());
    assertEquals(6, appearanceStream2.getContentStream().getLength());
    assertEquals(6, appearanceStream3.getContentStream().getLength());
    assertEquals(6, appearanceStream4.getContentStream().getLength());
    assertEquals(6, appearanceStream.getContentStream().getLength());
    assertEquals(6, appearanceStream5.getContentStream().getLength());
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#getLineWidth()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDLinkAppearanceHandler#getLineWidth()}
   */
  @Test
  @DisplayName("Test getLineWidth(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDLinkAppearanceHandler.getLineWidth()"})
  void testGetLineWidth_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new PDLinkAppearanceHandler(new PDAnnotationLink()).getLineWidth());
  }
}
