package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationHighlight;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDHighlightAppearanceHandlerDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDHighlightAppearanceHandler#PDHighlightAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDHighlightAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDHighlightAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.<init>(PDAnnotation)",
      "void PDHighlightAppearanceHandler.<init>(PDAnnotation, org.apache.pdfbox.pdmodel.PDDocument)",
      "void PDHighlightAppearanceHandler.generateDownAppearance()",
      "void PDHighlightAppearanceHandler.generateRolloverAppearance()"})
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDHighlightAppearanceHandler actualPdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);
    actualPdHighlightAppearanceHandler.generateDownAppearance();
    actualPdHighlightAppearanceHandler.generateRolloverAppearance();

    // Assert
    assertTrue(actualPdHighlightAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdHighlightAppearanceHandler.getAnnotation());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance() {
    // Arrange
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(
        new PDAnnotationHighlight());

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert that nothing has changed
    COSDictionary cOSObject = pdHighlightAppearanceHandler.getDownAppearance().getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceEntry rolloverAppearance = pdHighlightAppearanceHandler.getRolloverAppearance();
    COSDictionary cOSObject2 = rolloverAppearance.getCOSObject();
    assertTrue(cOSObject2 instanceof COSStream);
    assertFalse(((COSStream) cOSObject).hasData());
    assertSame(cOSObject2, rolloverAppearance.getAppearanceStream().getCOSObject());
    assertSame(cOSObject2, pdHighlightAppearanceHandler.getAppearance().getRolloverAppearance().getCOSObject());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance2() {
    // Arrange
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(
        new PDAnnotationHighlight(new COSDictionary()));

    // Act
    pdHighlightAppearanceHandler.generateNormalAppearance();

    // Assert that nothing has changed
    COSDictionary cOSObject = pdHighlightAppearanceHandler.getDownAppearance().getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceEntry rolloverAppearance = pdHighlightAppearanceHandler.getRolloverAppearance();
    COSDictionary cOSObject2 = rolloverAppearance.getCOSObject();
    assertTrue(cOSObject2 instanceof COSStream);
    assertFalse(((COSStream) cOSObject).hasData());
    assertSame(cOSObject2, rolloverAppearance.getAppearanceStream().getCOSObject());
    assertSame(cOSObject2, pdHighlightAppearanceHandler.getAppearance().getRolloverAppearance().getCOSObject());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance3() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

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
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    COSDictionary cOSObject = pdHighlightAppearanceHandler.getDownAppearance().getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceDictionary appearance = pdHighlightAppearanceHandler.getAppearance();
    COSDictionary cOSObject2 = appearance.getCOSObject();
    assertEquals(1, cOSObject2.getValues().size());
    assertEquals(1, cOSObject2.size());
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertTrue(((COSStream) cOSObject).hasData());
    PDAppearanceEntry rolloverAppearance = pdHighlightAppearanceHandler.getRolloverAppearance();
    assertSame(cOSObject, rolloverAppearance.getAppearanceStream().getCOSObject());
    assertSame(cOSObject, appearance.getNormalAppearance().getCOSObject());
    assertSame(cOSObject, appearance.getRolloverAppearance().getCOSObject());
    assertSame(cOSObject, rolloverAppearance.getCOSObject());
  }

  /**
   * Test {@link PDHighlightAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance4() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(new COSStream()));
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

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
    verify(pdBorderStyleDictionary).getDashStyle();
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
   * <p>
   * Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance5() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

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
    verify(pdBorderStyleDictionary).getDashStyle();
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
   * <p>
   * Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance6() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.ADBE_PKCS7_DETACHED);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

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
    verify(pdBorderStyleDictionary).getDashStyle();
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
   * <p>
   * Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance7() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.ADBE_X509_RSA_SHA1);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

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
    verify(pdBorderStyleDictionary).getDashStyle();
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
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given COSDictionary getCOSDictionary(COSName) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSDictionaryGetCOSDictionaryReturnNull() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

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
    verify(pdBorderStyleDictionary).getDashStyle();
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
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getKeyForValue(Object)} return {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given COSDictionary getKeyForValue(Object) return A")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSDictionaryGetKeyForValueReturnA() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.A);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosDictionary2).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

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
    verify(pdBorderStyleDictionary).getDashStyle();
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
   * <ul>
   *   <li>Given {@link COSStream} {@link COSDictionary#getCOSDictionary(COSName)} return {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given COSStream getCOSDictionary(COSName) return COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_givenCOSStreamGetCOSDictionaryReturnCOSDictionary() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    COSStream entry = mock(COSStream.class);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

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
    verify(pdBorderStyleDictionary).getDashStyle();
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
   * <ul>
   *   <li>Then calls {@link COSDictionary#containsKey(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls containsKey(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsContainsKey() throws IOException {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    COSStream entry = mock(COSStream.class);
    when(entry.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

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
    verify(pdBorderStyleDictionary).getDashStyle();
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
   * <ul>
   *   <li>Then calls {@link PDAnnotation#setAppearance(PDAppearanceDictionary)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls setAppearance(PDAppearanceDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsSetAppearance() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

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
    verify(pdBorderStyleDictionary).getDashStyle();
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
   * <ul>
   *   <li>Then calls {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDHighlightAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls setNormalAppearance(PDAppearanceEntry)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDHighlightAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance_thenCallsSetNormalAppearance() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());
    PDAnnotationHighlight annotation = mock(PDAnnotationHighlight.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDHighlightAppearanceHandler pdHighlightAppearanceHandler = new PDHighlightAppearanceHandler(annotation);

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
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDRectangle rectangle = pdHighlightAppearanceHandler.getRectangle();
    assertEquals(-4.5f, rectangle.getLowerLeftY());
    assertEquals(10.5f, rectangle.getUpperRightY());
    assertEquals(15.0f, rectangle.getHeight());
    assertEquals(20.0f, rectangle.getUpperRightX());
    assertEquals(20.0f, rectangle.getWidth());
  }
}
