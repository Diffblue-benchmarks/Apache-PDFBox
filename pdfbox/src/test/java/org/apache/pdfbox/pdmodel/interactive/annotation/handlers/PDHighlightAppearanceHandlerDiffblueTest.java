package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

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
import java.util.ArrayList;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDPattern;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationHighlight;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDHighlightAppearanceHandlerDiffblueTest {
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
   *   <li>{@link PDHighlightAppearanceHandler#PDHighlightAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDHighlightAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDHighlightAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDHighlightAppearanceHandler.<init>(PDAnnotation)",
    "void PDHighlightAppearanceHandler.<init>(PDAnnotation, org.apache.pdfbox.pdmodel.PDDocument)",
    "void PDHighlightAppearanceHandler.generateDownAppearance()",
    "void PDHighlightAppearanceHandler.generateRolloverAppearance()"
  })
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDHighlightAppearanceHandler actualPdHighlightAppearanceHandler =
        new PDHighlightAppearanceHandler(annotation);
    actualPdHighlightAppearanceHandler.generateDownAppearance();
    actualPdHighlightAppearanceHandler.generateRolloverAppearance();

    // Assert
    assertTrue(actualPdHighlightAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdHighlightAppearanceHandler.getAnnotation());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance() {
    // Arrange
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler =
        new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    PDRectangle bBox =
        pdHighlightAppearanceHandler.getDownAppearance().getAppearanceStream().getBBox();
    assertEquals(1.5f, bBox.getHeight());
    PDRectangle bBox2 =
        pdHighlightAppearanceHandler.getRolloverAppearance().getAppearanceStream().getBBox();
    assertEquals(1.5f, bBox2.getHeight());
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(11.0f, bBox.getUpperRightX());
    assertEquals(11.0f, bBox2.getUpperRightX());
    assertEquals(11.0f, bBox.getWidth());
    assertEquals(11.0f, bBox2.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance2() {
    // Arrange
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler =
        new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    PDRectangle bBox =
        pdHighlightAppearanceHandler.getDownAppearance().getAppearanceStream().getBBox();
    assertEquals(0.5f, bBox.getHeight());
    PDRectangle bBox2 =
        pdHighlightAppearanceHandler.getRolloverAppearance().getAppearanceStream().getBBox();
    assertEquals(0.5f, bBox2.getHeight());
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(0.5f, rectangle.getHeight());
    assertEquals(0.5f, bBox.getUpperRightY());
    assertEquals(0.5f, bBox2.getUpperRightY());
    assertEquals(0.5f, rectangle.getUpperRightY());
    assertEquals(10.0f, bBox.getUpperRightX());
    assertEquals(10.0f, bBox2.getUpperRightX());
    assertEquals(10.0f, rectangle.getUpperRightX());
    assertEquals(10.0f, bBox.getWidth());
    assertEquals(10.0f, bBox2.getWidth());
    assertEquals(10.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance3() {
    // Arrange
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceRGB.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler =
        new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    PDRectangle bBox =
        pdHighlightAppearanceHandler.getDownAppearance().getAppearanceStream().getBBox();
    assertEquals(1.5f, bBox.getHeight());
    PDRectangle bBox2 =
        pdHighlightAppearanceHandler.getRolloverAppearance().getAppearanceStream().getBBox();
    assertEquals(1.5f, bBox2.getHeight());
    assertEquals(1.5f, bBox.getUpperRightY());
    assertEquals(1.5f, bBox2.getUpperRightY());
    assertEquals(11.0f, bBox.getUpperRightX());
    assertEquals(11.0f, bBox2.getUpperRightX());
    assertEquals(11.0f, bBox.getWidth());
    assertEquals(11.0f, bBox2.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance4() {
    // Arrange
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    COSArray array = new COSArray();
    PDColor pdColor = new PDColor(array, new PDPattern(new PDResources()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler =
        new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert that nothing has changed
    verify(annotation).getColor();
    verify(annotation).getQuadPoints();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(0.0f, rectangle.getHeight());
    assertEquals(0.0f, rectangle.getUpperRightX());
    assertEquals(0.0f, rectangle.getUpperRightY());
    assertEquals(0.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance5() {
    // Arrange
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints())
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
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler =
        new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    PDRectangle bBox =
        pdHighlightAppearanceHandler.getDownAppearance().getAppearanceStream().getBBox();
    assertEquals(2.0f, bBox.getUpperRightX());
    PDRectangle bBox2 =
        pdHighlightAppearanceHandler.getRolloverAppearance().getAppearanceStream().getBBox();
    assertEquals(2.0f, bBox2.getUpperRightX());
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
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
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance6() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler =
        new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(1.5f, rectangle.getHeight());
    assertEquals(1.5f, rectangle.getUpperRightY());
    assertEquals(11.0f, rectangle.getUpperRightX());
    assertEquals(11.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance7() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSStream()));

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler =
        new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(1.5f, rectangle.getHeight());
    assertEquals(1.5f, rectangle.getUpperRightY());
    assertEquals(11.0f, rectangle.getUpperRightX());
    assertEquals(11.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance8() throws IOException {
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

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler =
        new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(1.5f, rectangle.getHeight());
    assertEquals(1.5f, rectangle.getUpperRightY());
    assertEquals(11.0f, rectangle.getUpperRightX());
    assertEquals(11.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance9() throws IOException {
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

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler =
        new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary, atLeast(1)).containsValue(Mockito.<Object>any());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getKeyForValue(Mockito.<Object>any());
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(1.5f, rectangle.getHeight());
    assertEquals(1.5f, rectangle.getUpperRightY());
    assertEquals(11.0f, rectangle.getUpperRightX());
    assertEquals(11.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance10() throws IOException {
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

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler =
        new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary, atLeast(1)).containsValue(Mockito.<Object>any());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getKeyForValue(Mockito.<Object>any());
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(1.5f, rectangle.getHeight());
    assertEquals(1.5f, rectangle.getUpperRightY());
    assertEquals(11.0f, rectangle.getUpperRightX());
    assertEquals(11.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance11() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDAppearanceEntry pdAppearanceEntry = mock(PDAppearanceEntry.class);
    when(pdAppearanceEntry.isSubDictionary()).thenReturn(true);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(pdAppearanceEntry);
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler =
        new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
    verify(pdAppearanceEntry).isSubDictionary();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(-4.5f, rectangle.getLowerLeftY());
    assertEquals(10.5f, rectangle.getUpperRightY());
    assertEquals(15.0f, rectangle.getHeight());
    assertEquals(20.0f, rectangle.getUpperRightX());
    assertEquals(20.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance12() {
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

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDAppearanceEntry pdAppearanceEntry = mock(PDAppearanceEntry.class);
    when(pdAppearanceEntry.isSubDictionary()).thenReturn(true);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(pdAppearanceEntry);
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    new PDHighlightAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosArray, atLeast(1)).getUpdateState();
    verify(cosArray, atLeast(1)).isDirect();
    verify(pdRectangle, atLeast(1)).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(5.0f);
    verify(pdRectangle).setLowerLeftY(-4.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
    verify(pdAppearanceEntry).isSubDictionary();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance13() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDAppearanceEntry pdAppearanceEntry = mock(PDAppearanceEntry.class);
    when(pdAppearanceEntry.isSubDictionary()).thenReturn(false);
    when(pdAppearanceEntry.getAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(pdAppearanceEntry);

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    new PDHighlightAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosArray, atLeast(1)).getUpdateState();
    verify(cosArray, atLeast(1)).isDirect();
    verify(cosUpdateState, atLeast(1)).setOriginDocumentState(isNull());
    verify(pdRectangle, atLeast(1)).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(5.0f);
    verify(pdRectangle).setLowerLeftY(-4.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceEntry).getAppearanceStream();
    verify(pdAppearanceEntry).isSubDictionary();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance14() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getStream()).thenReturn(new PDStream(new COSDocument()));
    when(pdAppearanceStream.getResources()).thenReturn(new PDResources());
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());

    PDAppearanceEntry pdAppearanceEntry = mock(PDAppearanceEntry.class);
    when(pdAppearanceEntry.isSubDictionary()).thenReturn(false);
    when(pdAppearanceEntry.getAppearanceStream()).thenReturn(pdAppearanceStream);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(pdAppearanceEntry);

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    new PDHighlightAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosArray, atLeast(1)).getUpdateState();
    verify(cosArray, atLeast(1)).isDirect();
    verify(cosUpdateState, atLeast(1)).setOriginDocumentState(isNull());
    verify(pdRectangle, atLeast(1)).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(5.0f);
    verify(pdRectangle).setLowerLeftY(-4.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdAppearanceStream).getStream();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdAppearanceStream, atLeast(1)).getResources();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceEntry).getAppearanceStream();
    verify(pdAppearanceEntry).isSubDictionary();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance15() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(pdColor.getComponents())
        .thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f, 10.0f, 0.5f});

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

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getStream()).thenReturn(new PDStream(new COSDocument()));
    when(pdAppearanceStream.getResources()).thenReturn(new PDResources());
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());

    PDAppearanceEntry pdAppearanceEntry = mock(PDAppearanceEntry.class);
    when(pdAppearanceEntry.isSubDictionary()).thenReturn(false);
    when(pdAppearanceEntry.getAppearanceStream()).thenReturn(pdAppearanceStream);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(pdAppearanceEntry);

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    new PDHighlightAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosArray, atLeast(1)).getUpdateState();
    verify(cosArray, atLeast(1)).isDirect();
    verify(cosUpdateState, atLeast(1)).setOriginDocumentState(isNull());
    verify(pdRectangle, atLeast(1)).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(5.0f);
    verify(pdRectangle).setLowerLeftY(-4.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdAppearanceStream).getStream();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdAppearanceStream, atLeast(1)).getResources();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceEntry).getAppearanceStream();
    verify(pdAppearanceEntry).isSubDictionary();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance16() {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFilters(new ArrayList<>());

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getStream()).thenReturn(pdStream);
    when(pdAppearanceStream.getResources()).thenReturn(new PDResources());
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());

    PDAppearanceEntry pdAppearanceEntry = mock(PDAppearanceEntry.class);
    when(pdAppearanceEntry.isSubDictionary()).thenReturn(false);
    when(pdAppearanceEntry.getAppearanceStream()).thenReturn(pdAppearanceStream);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(pdAppearanceEntry);

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    new PDHighlightAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosArray, atLeast(1)).getUpdateState();
    verify(cosArray, atLeast(1)).isDirect();
    verify(cosUpdateState, atLeast(1)).setOriginDocumentState(isNull());
    verify(pdRectangle, atLeast(1)).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(5.0f);
    verify(pdRectangle).setLowerLeftY(-4.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdAppearanceStream).getStream();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdAppearanceStream, atLeast(1)).getResources();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceEntry).getAppearanceStream();
    verify(pdAppearanceEntry).isSubDictionary();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance17() throws IOException {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");

    PDStream pdStream = mock(PDStream.class);
    when(pdStream.createOutputStream(Mockito.<COSName>any()))
        .thenReturn(new ByteArrayOutputStream());

    COSName cosName = mock(COSName.class);
    doThrow(new IOException()).when(cosName).writePDF(Mockito.<OutputStream>any());

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDFormXObject>any())).thenReturn(cosName);
    when(pdResources.add(Mockito.<PDExtendedGraphicsState>any())).thenReturn(COSName.A);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getStream()).thenReturn(pdStream);
    when(pdAppearanceStream.getResources()).thenReturn(pdResources);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());

    PDAppearanceEntry pdAppearanceEntry = mock(PDAppearanceEntry.class);
    when(pdAppearanceEntry.isSubDictionary()).thenReturn(false);
    when(pdAppearanceEntry.getAppearanceStream()).thenReturn(pdAppearanceStream);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(pdAppearanceEntry);

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    new PDHighlightAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosName).writePDF(isA(OutputStream.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdResources).add(isA(PDFormXObject.class));
    verify(pdResources, atLeast(1)).add(Mockito.<PDExtendedGraphicsState>any());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(5.0f);
    verify(pdRectangle).setLowerLeftY(-4.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdStream).createOutputStream(isNull());
    verify(pdAppearanceStream).getStream();
    verify(pdColor).getComponents();
    verify(pdAppearanceStream, atLeast(1)).getResources();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceEntry).getAppearanceStream();
    verify(pdAppearanceEntry).isSubDictionary();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance18() throws IOException {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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

    PDLineDashPattern pdLineDashPattern = mock(PDLineDashPattern.class);
    when(pdLineDashPattern.getDashArray()).thenReturn(new float[] {0.0f, 0.0f, 10.0f, 0.0f});

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(pdLineDashPattern);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");

    PDStream pdStream = mock(PDStream.class);
    when(pdStream.createOutputStream(Mockito.<COSName>any()))
        .thenReturn(new ByteArrayOutputStream());

    COSName cosName = mock(COSName.class);
    doThrow(new IOException()).when(cosName).writePDF(Mockito.<OutputStream>any());

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDFormXObject>any())).thenReturn(cosName);
    when(pdResources.add(Mockito.<PDExtendedGraphicsState>any())).thenReturn(COSName.A);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getStream()).thenReturn(pdStream);
    when(pdAppearanceStream.getResources()).thenReturn(pdResources);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());

    PDAppearanceEntry pdAppearanceEntry = mock(PDAppearanceEntry.class);
    when(pdAppearanceEntry.isSubDictionary()).thenReturn(false);
    when(pdAppearanceEntry.getAppearanceStream()).thenReturn(pdAppearanceStream);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(pdAppearanceEntry);

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    new PDHighlightAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosName).writePDF(isA(OutputStream.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdResources).add(isA(PDFormXObject.class));
    verify(pdResources, atLeast(1)).add(Mockito.<PDExtendedGraphicsState>any());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(5.0f);
    verify(pdRectangle).setLowerLeftY(-4.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdStream).createOutputStream(isNull());
    verify(pdLineDashPattern).getDashArray();
    verify(pdAppearanceStream).getStream();
    verify(pdColor).getComponents();
    verify(pdAppearanceStream, atLeast(1)).getResources();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceEntry).getAppearanceStream();
    verify(pdAppearanceEntry).isSubDictionary();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#isDirect()} return {@code false}.
   *   <li>Then calls {@link COSArray#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given COSArray isDirect() return 'false'; then calls getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSArrayIsDirectReturnFalse_thenCallsGetKey()
      throws IOException {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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

    PDLineDashPattern pdLineDashPattern = mock(PDLineDashPattern.class);
    when(pdLineDashPattern.getDashArray()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(pdLineDashPattern);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");

    PDStream pdStream = mock(PDStream.class);
    when(pdStream.createOutputStream(Mockito.<COSName>any()))
        .thenReturn(new ByteArrayOutputStream());

    COSName cosName = mock(COSName.class);
    doThrow(new IOException()).when(cosName).writePDF(Mockito.<OutputStream>any());

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDFormXObject>any())).thenReturn(cosName);
    when(pdResources.add(Mockito.<PDExtendedGraphicsState>any())).thenReturn(COSName.A);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getStream()).thenReturn(pdStream);
    when(pdAppearanceStream.getResources()).thenReturn(pdResources);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());

    PDAppearanceEntry pdAppearanceEntry = mock(PDAppearanceEntry.class);
    when(pdAppearanceEntry.isSubDictionary()).thenReturn(false);
    when(pdAppearanceEntry.getAppearanceStream()).thenReturn(pdAppearanceStream);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(pdAppearanceEntry);

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    new PDHighlightAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosArray, atLeast(1)).getKey();
    verify(cosArray).isDirect();
    verify(cosName).writePDF(isA(OutputStream.class));
    verify(pdResources).add(isA(PDFormXObject.class));
    verify(pdResources, atLeast(1)).add(Mockito.<PDExtendedGraphicsState>any());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(5.0f);
    verify(pdRectangle).setLowerLeftY(-4.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdStream).createOutputStream(isNull());
    verify(pdLineDashPattern).getDashArray();
    verify(pdAppearanceStream).getStream();
    verify(pdColor).getComponents();
    verify(pdAppearanceStream, atLeast(1)).getResources();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceEntry).getAppearanceStream();
    verify(pdAppearanceEntry).isSubDictionary();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getKeyForValue(Object)} return {@link
   *       COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given COSDictionary getKeyForValue(Object) return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
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

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler =
        new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary, atLeast(1)).containsValue(Mockito.<Object>any());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getKeyForValue(Mockito.<Object>any());
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(1.5f, rectangle.getHeight());
    assertEquals(1.5f, rectangle.getUpperRightY());
    assertEquals(11.0f, rectangle.getUpperRightX());
    assertEquals(11.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getKeyForValue(Object)} return {@link
   *       COSName}.
   * </ul>
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given COSDictionary getKeyForValue(Object) return COSName")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSDictionaryGetKeyForValueReturnCOSName()
      throws IOException {
    // Arrange
    COSName cosName = mock(COSName.class);
    doThrow(new IOException()).when(cosName).writePDF(Mockito.<OutputStream>any());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(cosName);
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

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler =
        new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(cosName).writePDF(isA(OutputStream.class));
    verify(entry).createOutputStream(isNull());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(1.5f, rectangle.getHeight());
    assertEquals(1.5f, rectangle.getUpperRightY());
    assertEquals(11.0f, rectangle.getUpperRightX());
    assertEquals(11.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSName} {@link COSName#writePDF(OutputStream)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given COSName writePDF(OutputStream) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSNameWritePDFDoesNothing() throws IOException {
    // Arrange
    COSName cosName = mock(COSName.class);
    doNothing().when(cosName).writePDF(Mockito.<OutputStream>any());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(cosName);
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

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler =
        new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary, atLeast(1)).containsValue(Mockito.<Object>any());
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getKeyForValue(Mockito.<Object>any());
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(cosName, atLeast(1)).writePDF(isA(OutputStream.class));
    verify(entry).createOutputStream(isNull());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(1.5f, rectangle.getHeight());
    assertEquals(1.5f, rectangle.getUpperRightY());
    assertEquals(11.0f, rectangle.getUpperRightX());
    assertEquals(11.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSStream} {@link COSStream#createOutputStream(COSBase)} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given COSStream createOutputStream(COSBase) throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSStreamCreateOutputStreamThrowIOException()
      throws IOException {
    // Arrange
    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenThrow(new IOException());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler =
        new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(entry).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(1.5f, rectangle.getHeight());
    assertEquals(1.5f, rectangle.getUpperRightY());
    assertEquals(11.0f, rectangle.getUpperRightX());
    assertEquals(11.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSStream} {@link COSStream#getCOSDictionary(COSName)} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given COSStream getCOSDictionary(COSName) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
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

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler =
        new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(1.5f, rectangle.getHeight());
    assertEquals(1.5f, rectangle.getUpperRightY());
    assertEquals(11.0f, rectangle.getUpperRightX());
    assertEquals(11.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationHighlight} {@link PDAnnotationHighlight#getRectangle()} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDAnnotationHighlight getRectangle() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDAnnotationHighlightGetRectangleReturnNull() {
    // Arrange
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getRectangle()).thenReturn(null);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    new PDHighlightAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getQuadPoints();
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDBorderStyleDictionary} {@link PDBorderStyleDictionary#getStyle()} return
   *       {@code U}.
   * </ul>
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDBorderStyleDictionary getStyle() return 'U'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDBorderStyleDictionaryGetStyleReturnU()
      throws IOException {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("U");

    PDStream pdStream = mock(PDStream.class);
    when(pdStream.createOutputStream(Mockito.<COSName>any()))
        .thenReturn(new ByteArrayOutputStream());

    COSName cosName = mock(COSName.class);
    doThrow(new IOException()).when(cosName).writePDF(Mockito.<OutputStream>any());

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDFormXObject>any())).thenReturn(cosName);
    when(pdResources.add(Mockito.<PDExtendedGraphicsState>any())).thenReturn(COSName.A);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getStream()).thenReturn(pdStream);
    when(pdAppearanceStream.getResources()).thenReturn(pdResources);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());

    PDAppearanceEntry pdAppearanceEntry = mock(PDAppearanceEntry.class);
    when(pdAppearanceEntry.isSubDictionary()).thenReturn(false);
    when(pdAppearanceEntry.getAppearanceStream()).thenReturn(pdAppearanceStream);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(pdAppearanceEntry);

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    new PDHighlightAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosName).writePDF(isA(OutputStream.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdResources).add(isA(PDFormXObject.class));
    verify(pdResources, atLeast(1)).add(Mockito.<PDExtendedGraphicsState>any());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(5.0f);
    verify(pdRectangle).setLowerLeftY(-4.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdStream).createOutputStream(isNull());
    verify(pdAppearanceStream).getStream();
    verify(pdColor).getComponents();
    verify(pdAppearanceStream, atLeast(1)).getResources();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceEntry).getAppearanceStream();
    verify(pdAppearanceEntry).isSubDictionary();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getCOSArray()} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDRectangle getCOSArray() return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDRectangleGetCOSArrayReturnCOSArray() {
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

    PDAppearanceEntry pdAppearanceEntry = mock(PDAppearanceEntry.class);
    when(pdAppearanceEntry.isSubDictionary()).thenReturn(true);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(pdAppearanceEntry);
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    new PDHighlightAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(pdRectangle, atLeast(1)).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(5.0f);
    verify(pdRectangle).setLowerLeftY(-4.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
    verify(pdAppearanceEntry).isSubDictionary();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getCOSArray()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDRectangle getCOSArray() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDRectangleGetCOSArrayReturnNull() {
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

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDAppearanceEntry pdAppearanceEntry = mock(PDAppearanceEntry.class);
    when(pdAppearanceEntry.isSubDictionary()).thenReturn(true);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(pdAppearanceEntry);
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    new PDHighlightAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(pdRectangle, atLeast(1)).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(5.0f);
    verify(pdRectangle).setLowerLeftY(-4.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
    verify(pdAppearanceEntry).isSubDictionary();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDResources} {@link PDResources#add(PDFormXObject)} return {@link
   *       COSName#A}.
   *   <li>Then calls {@link PDColor#getColorSpace()}.
   * </ul>
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDResources add(PDFormXObject) return A; then calls getColorSpace()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDResourcesAddReturnA_thenCallsGetColorSpace()
      throws IOException {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDStream pdStream = mock(PDStream.class);
    when(pdStream.createOutputStream(Mockito.<COSName>any()))
        .thenReturn(new ByteArrayOutputStream());

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDFormXObject>any())).thenReturn(COSName.A);
    when(pdResources.add(Mockito.<PDExtendedGraphicsState>any())).thenReturn(COSName.A);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getStream()).thenReturn(pdStream);
    when(pdAppearanceStream.getResources()).thenReturn(pdResources);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());

    PDAppearanceEntry pdAppearanceEntry = mock(PDAppearanceEntry.class);
    when(pdAppearanceEntry.isSubDictionary()).thenReturn(false);
    when(pdAppearanceEntry.getAppearanceStream()).thenReturn(pdAppearanceStream);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(pdAppearanceEntry);

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    new PDHighlightAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosArray, atLeast(1)).getUpdateState();
    verify(cosArray, atLeast(1)).isDirect();
    verify(cosUpdateState, atLeast(1)).setOriginDocumentState(isNull());
    verify(pdResources).add(isA(PDFormXObject.class));
    verify(pdResources, atLeast(1)).add(Mockito.<PDExtendedGraphicsState>any());
    verify(pdRectangle, atLeast(1)).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(5.0f);
    verify(pdRectangle).setLowerLeftY(-4.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdStream).createOutputStream(isNull());
    verify(pdAppearanceStream).getStream();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdAppearanceStream, atLeast(1)).getResources();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceEntry).getAppearanceStream();
    verify(pdAppearanceEntry).isSubDictionary();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDResources} {@link PDResources#add(PDFormXObject)} return {@link COSName}.
   *   <li>Then calls {@link PDResources#add(PDFormXObject)}.
   * </ul>
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDResources add(PDFormXObject) return COSName; then calls add(PDFormXObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDResourcesAddReturnCOSName_thenCallsAdd()
      throws IOException {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDStream pdStream = mock(PDStream.class);
    when(pdStream.createOutputStream(Mockito.<COSName>any()))
        .thenReturn(new ByteArrayOutputStream());

    COSName cosName = mock(COSName.class);
    doThrow(new IOException()).when(cosName).writePDF(Mockito.<OutputStream>any());

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDFormXObject>any())).thenReturn(cosName);
    when(pdResources.add(Mockito.<PDExtendedGraphicsState>any())).thenReturn(COSName.A);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getStream()).thenReturn(pdStream);
    when(pdAppearanceStream.getResources()).thenReturn(pdResources);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());

    PDAppearanceEntry pdAppearanceEntry = mock(PDAppearanceEntry.class);
    when(pdAppearanceEntry.isSubDictionary()).thenReturn(false);
    when(pdAppearanceEntry.getAppearanceStream()).thenReturn(pdAppearanceStream);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(pdAppearanceEntry);

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    new PDHighlightAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosName).writePDF(isA(OutputStream.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdResources).add(isA(PDFormXObject.class));
    verify(pdResources, atLeast(1)).add(Mockito.<PDExtendedGraphicsState>any());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(5.0f);
    verify(pdRectangle).setLowerLeftY(-4.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdStream).createOutputStream(isNull());
    verify(pdAppearanceStream).getStream();
    verify(pdColor).getComponents();
    verify(pdAppearanceStream, atLeast(1)).getResources();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceEntry).getAppearanceStream();
    verify(pdAppearanceEntry).isSubDictionary();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDStream} {@link PDStream#createOutputStream(COSName)} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName(
      "Test generateNormalAppearance(); given PDStream createOutputStream(COSName) throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenPDStreamCreateOutputStreamThrowIOException()
      throws IOException {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightX()).thenReturn(10.0f);
    when(pdRectangle.getUpperRightY()).thenReturn(10.0f);
    doNothing().when(pdRectangle).setLowerLeftX(anyFloat());
    doNothing().when(pdRectangle).setLowerLeftY(anyFloat());
    doNothing().when(pdRectangle).setUpperRightX(anyFloat());
    doNothing().when(pdRectangle).setUpperRightY(anyFloat());

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDStream pdStream = mock(PDStream.class);
    when(pdStream.createOutputStream(Mockito.<COSName>any())).thenThrow(new IOException());

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getStream()).thenReturn(pdStream);
    when(pdAppearanceStream.getResources()).thenReturn(new PDResources());
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());

    PDAppearanceEntry pdAppearanceEntry = mock(PDAppearanceEntry.class);
    when(pdAppearanceEntry.isSubDictionary()).thenReturn(false);
    when(pdAppearanceEntry.getAppearanceStream()).thenReturn(pdAppearanceStream);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(pdAppearanceEntry);

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    new PDHighlightAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(5.0f);
    verify(pdRectangle).setLowerLeftY(-4.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdStream).createOutputStream(isNull());
    verify(pdAppearanceStream).getStream();
    verify(pdColor).getComponents();
    verify(pdAppearanceStream).getResources();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceEntry).getAppearanceStream();
    verify(pdAppearanceEntry).isSubDictionary();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Then calls {@link COSStream#containsKey(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls containsKey(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsContainsKey() throws IOException {
    // Arrange
    COSStream entry = mock(COSStream.class);
    when(entry.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream());
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler =
        new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(entry, atLeast(1)).containsKey(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(1.5f, rectangle.getHeight());
    assertEquals(1.5f, rectangle.getUpperRightY());
    assertEquals(11.0f, rectangle.getUpperRightX());
    assertEquals(11.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Then calls {@link PDColor#getColorSpace()}.
   * </ul>
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls getColorSpace()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsGetColorSpace() throws IOException {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDStream pdStream = mock(PDStream.class);
    when(pdStream.createOutputStream(Mockito.<COSName>any()))
        .thenReturn(new ByteArrayOutputStream());

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getStream()).thenReturn(pdStream);
    when(pdAppearanceStream.getResources()).thenReturn(new PDResources());
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());

    PDAppearanceEntry pdAppearanceEntry = mock(PDAppearanceEntry.class);
    when(pdAppearanceEntry.isSubDictionary()).thenReturn(false);
    when(pdAppearanceEntry.getAppearanceStream()).thenReturn(pdAppearanceStream);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(pdAppearanceEntry);

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    new PDHighlightAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosArray, atLeast(1)).getUpdateState();
    verify(cosArray, atLeast(1)).isDirect();
    verify(cosUpdateState, atLeast(1)).setOriginDocumentState(isNull());
    verify(pdRectangle, atLeast(1)).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(5.0f);
    verify(pdRectangle).setLowerLeftY(-4.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdStream).createOutputStream(isNull());
    verify(pdAppearanceStream).getStream();
    verify(pdColor, atLeast(1)).getColorSpace();
    verify(pdColor, atLeast(1)).getComponents();
    verify(pdAppearanceStream, atLeast(1)).getResources();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceEntry).getAppearanceStream();
    verify(pdAppearanceEntry).isSubDictionary();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Then calls {@link PDLineDashPattern#getDashArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls getDashArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsGetDashArray() throws IOException {
    // Arrange
    PDColor pdColor = mock(PDColor.class);
    when(pdColor.getComponents()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

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

    PDLineDashPattern pdLineDashPattern = mock(PDLineDashPattern.class);
    when(pdLineDashPattern.getDashArray()).thenReturn(new float[] {10.0f, 0.0f, 10.0f, 0.0f});

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(pdLineDashPattern);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");

    PDStream pdStream = mock(PDStream.class);
    when(pdStream.createOutputStream(Mockito.<COSName>any()))
        .thenReturn(new ByteArrayOutputStream());

    COSName cosName = mock(COSName.class);
    doThrow(new IOException()).when(cosName).writePDF(Mockito.<OutputStream>any());

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.add(Mockito.<PDFormXObject>any())).thenReturn(cosName);
    when(pdResources.add(Mockito.<PDExtendedGraphicsState>any())).thenReturn(COSName.A);

    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    when(pdAppearanceStream.getStream()).thenReturn(pdStream);
    when(pdAppearanceStream.getResources()).thenReturn(pdResources);
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());

    PDAppearanceEntry pdAppearanceEntry = mock(PDAppearanceEntry.class);
    when(pdAppearanceEntry.isSubDictionary()).thenReturn(false);
    when(pdAppearanceEntry.getAppearanceStream()).thenReturn(pdAppearanceStream);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(pdAppearanceEntry);

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    new PDHighlightAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosName).writePDF(isA(OutputStream.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdResources).add(isA(PDFormXObject.class));
    verify(pdResources, atLeast(1)).add(Mockito.<PDExtendedGraphicsState>any());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(5.0f);
    verify(pdRectangle).setLowerLeftY(-4.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(pdStream).createOutputStream(isNull());
    verify(pdLineDashPattern).getDashArray();
    verify(pdAppearanceStream).getStream();
    verify(pdColor).getComponents();
    verify(pdAppearanceStream, atLeast(1)).getResources();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceEntry).getAppearanceStream();
    verify(pdAppearanceEntry).isSubDictionary();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAnnotationHighlight#setAppearance(PDAppearanceDictionary)}.
   * </ul>
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls setAppearance(PDAppearanceDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsSetAppearance() {
    // Arrange
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler =
        new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(1.5f, rectangle.getHeight());
    assertEquals(1.5f, rectangle.getUpperRightY());
    assertEquals(11.0f, rectangle.getUpperRightX());
    assertEquals(11.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls setItem(COSName, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
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

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler =
        new PDHighlightAppearanceHandler(annotation);

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(cosDictionary, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(1.5f, rectangle.getHeight());
    assertEquals(1.5f, rectangle.getUpperRightY());
    assertEquals(11.0f, rectangle.getUpperRightX());
    assertEquals(11.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls setNormalAppearance(PDAppearanceEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsSetNormalAppearance() {
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

    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");

    PDAppearanceEntry pdAppearanceEntry = mock(PDAppearanceEntry.class);
    when(pdAppearanceEntry.isSubDictionary()).thenReturn(true);

    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(pdAppearanceEntry);
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Act
    new PDHighlightAppearanceHandler(annotation).generateNormalAppearance();

    // Assert
    verify(cosArray, atLeast(1)).getUpdateState();
    verify(cosArray, atLeast(1)).isDirect();
    verify(cosUpdateState, atLeast(1)).setOriginDocumentState(isNull());
    verify(pdRectangle, atLeast(1)).getCOSArray();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getUpperRightX();
    verify(pdRectangle).getUpperRightY();
    verify(pdRectangle).setLowerLeftX(5.0f);
    verify(pdRectangle).setLowerLeftY(-4.5f);
    verify(pdRectangle).setUpperRightX(20.0f);
    verify(pdRectangle).setUpperRightY(10.5f);
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).getBorderStyle();
    verify(annotation, atLeast(1)).getConstantOpacity();
    verify(annotation).getQuadPoints();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
    verify(pdAppearanceEntry).isSubDictionary();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }
}
