package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.geom.AffineTransform;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDCaretAppearanceHandlerDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDCaretAppearanceHandler#PDCaretAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDCaretAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDCaretAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDCaretAppearanceHandler actualPdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);
    actualPdCaretAppearanceHandler.generateDownAppearance();
    actualPdCaretAppearanceHandler.generateRolloverAppearance();

    // Assert that nothing has changed
    assertTrue(actualPdCaretAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdCaretAppearanceHandler.getAnnotation());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance() {
    // Arrange
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
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
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream5.getStream().getLength());
    assertEquals(149, appearanceStream.getContentStream().getLength());
    assertEquals(149, appearanceStream2.getContentStream().getLength());
    assertEquals(149, appearanceStream3.getContentStream().getLength());
    assertEquals(149, appearanceStream4.getContentStream().getLength());
    assertEquals(149, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance2() {
    // Arrange
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(-9.223372E18f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
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
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(157, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(157, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(157, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(157, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(157, appearanceStream5.getStream().getLength());
    assertEquals(157, appearanceStream.getContentStream().getLength());
    assertEquals(157, appearanceStream2.getContentStream().getLength());
    assertEquals(157, appearanceStream3.getContentStream().getLength());
    assertEquals(157, appearanceStream4.getContentStream().getLength());
    assertEquals(157, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance3() {
    // Arrange
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
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream5.getStream().getLength());
    assertEquals(149, appearanceStream.getContentStream().getLength());
    assertEquals(149, appearanceStream2.getContentStream().getLength());
    assertEquals(149, appearanceStream3.getContentStream().getLength());
    assertEquals(149, appearanceStream4.getContentStream().getLength());
    assertEquals(149, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance4() {
    // Arrange
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
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceRGB.INSTANCE));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(155, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(155, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(155, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(155, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(155, appearanceStream5.getStream().getLength());
    assertEquals(155, appearanceStream.getContentStream().getLength());
    assertEquals(155, appearanceStream2.getContentStream().getLength());
    assertEquals(155, appearanceStream3.getContentStream().getLength());
    assertEquals(155, appearanceStream4.getContentStream().getLength());
    assertEquals(155, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance5() {
    // Arrange
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
    COSArray array = new COSArray();
    when(annotation.getColor()).thenReturn(new PDColor(array, new PDCalGray()));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(135, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(135, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(135, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(135, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(135, appearanceStream5.getStream().getLength());
    assertEquals(135, appearanceStream.getContentStream().getLength());
    assertEquals(135, appearanceStream2.getContentStream().getLength());
    assertEquals(135, appearanceStream3.getContentStream().getLength());
    assertEquals(135, appearanceStream4.getContentStream().getLength());
    assertEquals(135, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance6() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(256);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

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
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(1155, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(1155, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(1155, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(1155, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(1155, appearanceStream5.getStream().getLength());
    assertEquals(1155, appearanceStream.getContentStream().getLength());
    assertEquals(1155, appearanceStream2.getContentStream().getLength());
    assertEquals(1155, appearanceStream3.getContentStream().getLength());
    assertEquals(1155, appearanceStream4.getContentStream().getLength());
    assertEquals(1155, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance7() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(null);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

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
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
    PDAppearanceStream appearanceStream = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> colorSpaceNames = resources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream4.getStream().getLength());
    assertEquals(171, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream5.getStream().getLength());
    assertEquals(171, appearanceStream2.getContentStream().getLength());
    assertEquals(171, appearanceStream3.getContentStream().getLength());
    assertEquals(171, appearanceStream4.getContentStream().getLength());
    assertEquals(171, appearanceStream.getContentStream().getLength());
    assertEquals(171, appearanceStream5.getContentStream().getLength());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertEquals(colorSpaceNames, resources.getExtGStateNames());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance8() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosArray);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

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
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream5.getStream().getLength());
    assertEquals(171, appearanceStream.getContentStream().getLength());
    assertEquals(171, appearanceStream2.getContentStream().getLength());
    assertEquals(171, appearanceStream3.getContentStream().getLength());
    assertEquals(171, appearanceStream4.getContentStream().getLength());
    assertEquals(171, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance9() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(false);
    when(cosArray.getKey()).thenReturn(new COSObjectKey(1L, 1));
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosArray);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

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
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray, atLeast(1)).getKey();
    verify(cosArray, atLeast(1)).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
    PDAppearanceStream appearanceStream = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    Iterable<COSName> colorSpaceNames = appearanceStream.getResources().getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream4.getStream().getLength());
    assertEquals(171, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream5.getStream().getLength());
    assertEquals(171, appearanceStream2.getContentStream().getLength());
    assertEquals(171, appearanceStream3.getContentStream().getLength());
    assertEquals(171, appearanceStream4.getContentStream().getLength());
    assertEquals(171, appearanceStream.getContentStream().getLength());
    assertEquals(171, appearanceStream5.getContentStream().getLength());
    assertEquals(2, ((Set<COSName>) colorSpaceNames).size());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance10() {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosArray);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

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
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream5.getStream().getLength());
    assertEquals(171, appearanceStream.getContentStream().getLength());
    assertEquals(171, appearanceStream2.getContentStream().getLength());
    assertEquals(171, appearanceStream3.getContentStream().getLength());
    assertEquals(171, appearanceStream4.getContentStream().getLength());
    assertEquals(171, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance11() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(new COSArray());
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosArray);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

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
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle, atLeast(1)).getWidth();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(1.0f));
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(102, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(102, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(102, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(102, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(102, appearanceStream5.getStream().getLength());
    assertEquals(102, appearanceStream.getContentStream().getLength());
    assertEquals(102, appearanceStream2.getContentStream().getLength());
    assertEquals(102, appearanceStream3.getContentStream().getLength());
    assertEquals(102, appearanceStream4.getContentStream().getLength());
    assertEquals(102, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance12() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(new COSArray());
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosArray);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(false);
    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    when(pdAppearanceStream.getMatrix()).thenReturn(new Matrix());
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(-9.223372E18f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle, atLeast(1)).getWidth();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(1.0f));
    verify(annotation).getConstantOpacity();
    PDAppearanceStream appearanceStream = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> fontNames = resources.getFontNames();
    assertTrue(fontNames instanceof Set);
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(110, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(110, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(110, appearanceStream4.getStream().getLength());
    assertEquals(110, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(110, appearanceStream5.getStream().getLength());
    assertEquals(110, appearanceStream2.getContentStream().getLength());
    assertEquals(110, appearanceStream3.getContentStream().getLength());
    assertEquals(110, appearanceStream4.getContentStream().getLength());
    assertEquals(110, appearanceStream.getContentStream().getLength());
    assertEquals(110, appearanceStream5.getContentStream().getLength());
    COSDictionary cOSObject = resources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(((Set<COSName>) fontNames).isEmpty());
    PDResources resources2 = appearanceStream2.getResources();
    assertSame(fontNames, resources2.getFontNames());
    PDResources resources3 = appearanceStream3.getResources();
    assertSame(fontNames, resources3.getFontNames());
    PDResources resources4 = appearanceStream4.getResources();
    assertSame(fontNames, resources4.getFontNames());
    PDResources resources5 = appearanceStream5.getResources();
    assertSame(fontNames, resources5.getFontNames());
    assertSame(fontNames, resources2.getPatternNames());
    assertSame(fontNames, resources3.getPatternNames());
    assertSame(fontNames, resources4.getPatternNames());
    assertSame(fontNames, resources.getPatternNames());
    assertSame(fontNames, resources5.getPatternNames());
    assertSame(fontNames, resources2.getPropertiesNames());
    assertSame(fontNames, resources3.getPropertiesNames());
    assertSame(fontNames, resources4.getPropertiesNames());
    assertSame(fontNames, resources.getPropertiesNames());
    assertSame(fontNames, resources5.getPropertiesNames());
    assertSame(fontNames, resources2.getShadingNames());
    assertSame(fontNames, resources3.getShadingNames());
    assertSame(fontNames, resources4.getShadingNames());
    assertSame(fontNames, resources.getShadingNames());
    assertSame(fontNames, resources5.getShadingNames());
    assertSame(fontNames, resources2.getXObjectNames());
    assertSame(fontNames, resources3.getXObjectNames());
    assertSame(fontNames, resources4.getXObjectNames());
    assertSame(fontNames, resources.getXObjectNames());
    assertSame(fontNames, resources5.getXObjectNames());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance13() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(-9.223372E18f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(new COSArray());
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosArray);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

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
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle, atLeast(1)).getWidth();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(-9.2233722E17f));
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(158, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(158, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(158, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(158, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(158, appearanceStream5.getStream().getLength());
    assertEquals(158, appearanceStream.getContentStream().getLength());
    assertEquals(158, appearanceStream2.getContentStream().getLength());
    assertEquals(158, appearanceStream3.getContentStream().getLength());
    assertEquals(158, appearanceStream4.getContentStream().getLength());
    assertEquals(158, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance14() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(new COSArray());
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosArray);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

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
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle, atLeast(1)).getWidth();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(1.0f));
    verify(annotation).getConstantOpacity();
    PDAppearanceStream appearanceStream = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(0, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(0, appearanceStream2.getStream().getLength());
    assertEquals(0, appearanceStream.getContentStream().getLength());
    assertEquals(0, appearanceStream2.getContentStream().getLength());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance15() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(new COSArray());
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(new COSStream()));
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosArray);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

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
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    (new PDCaretAppearanceHandler(annotation)).generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle, atLeast(1)).getWidth();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(1.0f));
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#containsKey(COSName)}
   * return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given COSDictionary containsKey(COSName) return 'true'")
  void testGenerateNormalAppearance_givenCOSDictionaryContainsKeyReturnTrue() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
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
    PDAppearanceStream appearanceStream4 = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream5.getStream().getLength());
    assertEquals(149, appearanceStream.getContentStream().getLength());
    assertEquals(149, appearanceStream2.getContentStream().getLength());
    assertEquals(149, appearanceStream3.getContentStream().getLength());
    assertEquals(149, appearanceStream4.getContentStream().getLength());
    assertEquals(149, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#containsKey(COSName)}
   * return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given COSDictionary containsKey(COSName) return 'true'")
  void testGenerateNormalAppearance_givenCOSDictionaryContainsKeyReturnTrue2() {
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
    PDAppearanceStream appearanceStream4 = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(149, appearanceStream5.getStream().getLength());
    assertEquals(149, appearanceStream.getContentStream().getLength());
    assertEquals(149, appearanceStream2.getContentStream().getLength());
    assertEquals(149, appearanceStream3.getContentStream().getLength());
    assertEquals(149, appearanceStream4.getContentStream().getLength());
    assertEquals(149, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given COSObjectKey(long, int) with num is one and gen is one")
  void testGenerateNormalAppearance_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

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
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream5.getStream().getLength());
    assertEquals(171, appearanceStream.getContentStream().getLength());
    assertEquals(171, appearanceStream2.getContentStream().getLength());
    assertEquals(171, appearanceStream3.getContentStream().getLength());
    assertEquals(171, appearanceStream4.getContentStream().getLength());
    assertEquals(171, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link COSStream} {@link COSDictionary#getCOSDictionary(COSName)}
   * return {@link COSStream}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given COSStream getCOSDictionary(COSName) return COSStream")
  void testGenerateNormalAppearance_givenCOSStreamGetCOSDictionaryReturnCOSStream() throws IOException {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(new COSArray());
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(cosStream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSStream entry = mock(COSStream.class);
    when(entry.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosStream);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosArray);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

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
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    (new PDCaretAppearanceHandler(annotation)).generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosStream, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle, atLeast(1)).getWidth();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(1.0f));
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link COSStream} {@link COSDictionary#getCOSDictionary(COSName)}
   * return {@link COSStream}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given COSStream getCOSDictionary(COSName) return COSStream")
  void testGenerateNormalAppearance_givenCOSStreamGetCOSDictionaryReturnCOSStream2() throws IOException {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(new COSArray());
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(cosStream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSStream entry = mock(COSStream.class);
    when(entry.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosStream);
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosArray);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(false);
    PDAppearanceStream pdAppearanceStream = mock(PDAppearanceStream.class);
    doNothing().when(pdAppearanceStream).setMatrix(Mockito.<AffineTransform>any());
    when(pdAppearanceStream.getMatrix()).thenReturn(new Matrix());
    doNothing().when(pdAppearanceStream).setBBox(Mockito.<PDRectangle>any());
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(-9.223372E18f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    (new PDCaretAppearanceHandler(annotation)).generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosStream, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle, atLeast(1)).getWidth();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(1.0f));
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return
   * {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDColorSpace getCOSObject() return A")
  void testGenerateNormalAppearance_givenPDColorSpaceGetCOSObjectReturnA() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSName.A);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

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
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream5.getStream().getLength());
    assertEquals(171, appearanceStream.getContentStream().getLength());
    assertEquals(171, appearanceStream2.getContentStream().getLength());
    assertEquals(171, appearanceStream3.getContentStream().getLength());
    assertEquals(171, appearanceStream4.getContentStream().getLength());
    assertEquals(171, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return
   * {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDColorSpace getCOSObject() return FALSE")
  void testGenerateNormalAppearance_givenPDColorSpaceGetCOSObjectReturnFalse() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

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
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream5.getStream().getLength());
    assertEquals(171, appearanceStream.getContentStream().getLength());
    assertEquals(171, appearanceStream2.getContentStream().getLength());
    assertEquals(171, appearanceStream3.getContentStream().getLength());
    assertEquals(171, appearanceStream4.getContentStream().getLength());
    assertEquals(171, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return
   * {@link COSInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDColorSpace getCOSObject() return ONE")
  void testGenerateNormalAppearance_givenPDColorSpaceGetCOSObjectReturnOne() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSInteger.ONE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

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
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
    PDAppearanceDictionary appearance = pdCaretAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdCaretAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(171, appearanceStream5.getStream().getLength());
    assertEquals(171, appearanceStream.getContentStream().getLength());
    assertEquals(171, appearanceStream2.getContentStream().getLength());
    assertEquals(171, appearanceStream3.getContentStream().getLength());
    assertEquals(171, appearanceStream4.getContentStream().getLength());
    assertEquals(171, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls getCOSDictionary(COSName)")
  void testGenerateNormalAppearance_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(new COSArray());
    COSStream entry = mock(COSStream.class);
    when(entry.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(entry.createOutputStream(Mockito.<COSBase>any())).thenReturn(new ByteArrayOutputStream(1));
    when(entry.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(entry).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(entry).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(entry));
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosArray);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

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
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    (new PDCaretAppearanceHandler(annotation)).generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle, atLeast(1)).getWidth();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(1.0f));
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDCaretAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Then calls
   * {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDCaretAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls setNormalAppearance(PDAppearanceEntry)")
  void testGenerateNormalAppearance_thenCallsSetNormalAppearance() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(new COSArray());
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosArray);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

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
    when(annotation.getRectangle()).thenReturn(pdRectangle);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    (new PDCaretAppearanceHandler(annotation)).generateNormalAppearance();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle, atLeast(1)).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle, atLeast(1)).getWidth();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(pdAppearanceStream).getMatrix();
    verify(pdAppearanceStream).setBBox(isA(PDRectangle.class));
    verify(pdAppearanceStream).setMatrix(isA(AffineTransform.class));
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(1.0f));
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }
}
