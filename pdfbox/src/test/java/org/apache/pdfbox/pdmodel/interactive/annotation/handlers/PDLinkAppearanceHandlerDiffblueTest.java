package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDLinkAppearanceHandlerDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDLinkAppearanceHandler#PDLinkAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDLinkAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDLinkAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDLinkAppearanceHandler actualPdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);
    actualPdLinkAppearanceHandler.generateDownAppearance();
    actualPdLinkAppearanceHandler.generateRolloverAppearance();

    // Assert that nothing has changed
    assertTrue(actualPdLinkAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdLinkAppearanceHandler.getAnnotation());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance() {
    // Arrange
    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
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
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream5.getStream().getLength());
    assertEquals(6, appearanceStream.getContentStream().getLength());
    assertEquals(6, appearanceStream2.getContentStream().getLength());
    assertEquals(6, appearanceStream3.getContentStream().getLength());
    assertEquals(6, appearanceStream4.getContentStream().getLength());
    assertEquals(6, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance2() {
    // Arrange
    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{9.223372E18f, 0.5f, 10.0f, 0.5f});
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
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream5.getStream().getLength());
    assertEquals(70, appearanceStream.getContentStream().getLength());
    assertEquals(70, appearanceStream2.getContentStream().getLength());
    assertEquals(70, appearanceStream3.getContentStream().getLength());
    assertEquals(70, appearanceStream4.getContentStream().getLength());
    assertEquals(70, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance3() {
    // Arrange
    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{-9.223372E18f, 0.5f, 10.0f, 0.5f});
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
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream5.getStream().getLength());
    assertEquals(70, appearanceStream.getContentStream().getLength());
    assertEquals(70, appearanceStream2.getContentStream().getLength());
    assertEquals(70, appearanceStream3.getContentStream().getLength());
    assertEquals(70, appearanceStream4.getContentStream().getLength());
    assertEquals(70, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance4() {
    // Arrange
    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 9.223372E18f, 10.0f, 0.5f});
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
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream5.getStream().getLength());
    assertEquals(70, appearanceStream.getContentStream().getLength());
    assertEquals(70, appearanceStream2.getContentStream().getLength());
    assertEquals(70, appearanceStream3.getContentStream().getLength());
    assertEquals(70, appearanceStream4.getContentStream().getLength());
    assertEquals(70, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance5() {
    // Arrange
    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, -9.223372E18f, 10.0f, 0.5f});
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
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream5.getStream().getLength());
    assertEquals(70, appearanceStream.getContentStream().getLength());
    assertEquals(70, appearanceStream2.getContentStream().getLength());
    assertEquals(70, appearanceStream3.getContentStream().getLength());
    assertEquals(70, appearanceStream4.getContentStream().getLength());
    assertEquals(70, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance6() {
    // Arrange
    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
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
    PDAppearanceStream appearanceStream4 = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(11, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(11, appearanceStream5.getStream().getLength());
    assertEquals(11, appearanceStream.getContentStream().getLength());
    assertEquals(11, appearanceStream2.getContentStream().getLength());
    assertEquals(11, appearanceStream3.getContentStream().getLength());
    assertEquals(11, appearanceStream4.getContentStream().getLength());
    assertEquals(11, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance7() {
    // Arrange
    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), null));
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
    PDAppearanceStream appearanceStream4 = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(2, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(2, appearanceStream5.getStream().getLength());
    assertEquals(2, appearanceStream.getContentStream().getLength());
    assertEquals(2, appearanceStream2.getContentStream().getLength());
    assertEquals(2, appearanceStream3.getContentStream().getLength());
    assertEquals(2, appearanceStream4.getContentStream().getLength());
    assertEquals(2, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance8() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
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
    PDAppearanceStream appearanceStream4 = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream5.getStream().getLength());
    assertEquals(22, appearanceStream.getContentStream().getLength());
    assertEquals(22, appearanceStream2.getContentStream().getLength());
    assertEquals(22, appearanceStream3.getContentStream().getLength());
    assertEquals(22, appearanceStream4.getContentStream().getLength());
    assertEquals(22, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance9() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(256);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
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
    assertEquals(514, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(514, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(514, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(514, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(514, appearanceStream5.getStream().getLength());
    assertEquals(514, appearanceStream.getContentStream().getLength());
    assertEquals(514, appearanceStream2.getContentStream().getLength());
    assertEquals(514, appearanceStream3.getContentStream().getLength());
    assertEquals(514, appearanceStream4.getContentStream().getLength());
    assertEquals(514, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance10() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
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
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    PDAppearanceEntry downAppearance = pdLinkAppearanceHandler.getDownAppearance();
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    assertEquals(0, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(0, appearanceStream2.getStream().getLength());
    assertEquals(0, appearanceStream.getContentStream().getLength());
    assertEquals(0, appearanceStream2.getContentStream().getLength());
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(0.0f, floatArray[0]);
    assertEquals(0.0f, floatArray[1]);
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance11() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(new COSDictionary());
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
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
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(27, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(27, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(27, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(27, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(27, appearanceStream5.getStream().getLength());
    assertEquals(27, appearanceStream.getContentStream().getLength());
    assertEquals(27, appearanceStream2.getContentStream().getLength());
    assertEquals(27, appearanceStream3.getContentStream().getLength());
    assertEquals(27, appearanceStream4.getContentStream().getLength());
    assertEquals(27, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance12() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(new COSDictionary());
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{9.223372E18f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
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
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(83, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(83, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(83, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(83, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(83, appearanceStream5.getStream().getLength());
    assertEquals(83, appearanceStream.getContentStream().getLength());
    assertEquals(83, appearanceStream2.getContentStream().getLength());
    assertEquals(83, appearanceStream3.getContentStream().getLength());
    assertEquals(83, appearanceStream4.getContentStream().getLength());
    assertEquals(83, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance13() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(-9.223372E18f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(new COSDictionary());
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{9.223372E18f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
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
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(219, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(219, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(219, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(219, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(219, appearanceStream5.getStream().getLength());
    assertEquals(219, appearanceStream.getContentStream().getLength());
    assertEquals(219, appearanceStream2.getContentStream().getLength());
    assertEquals(219, appearanceStream3.getContentStream().getLength());
    assertEquals(219, appearanceStream4.getContentStream().getLength());
    assertEquals(219, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance14() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("Style");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{9.223372E18f, 0.5f, 10.0f, 0.5f});
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
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(83, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(83, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(83, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(83, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(83, appearanceStream5.getStream().getLength());
    assertEquals(83, appearanceStream.getContentStream().getLength());
    assertEquals(83, appearanceStream2.getContentStream().getLength());
    assertEquals(83, appearanceStream3.getContentStream().getLength());
    assertEquals(83, appearanceStream4.getContentStream().getLength());
    assertEquals(83, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance15() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{9.223372E18f, 0.5f, 10.0f, 0.5f});
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
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getBorder();
    verify(annotation).getColor();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation, atLeast(1)).getBorderStyle();
    verify(annotation).getQuadPoints();
    verify(pdBorderStyleDictionary).getCOSObject();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(90, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(90, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(90, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(90, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(90, appearanceStream5.getStream().getLength());
    assertEquals(90, appearanceStream.getContentStream().getLength());
    assertEquals(90, appearanceStream2.getContentStream().getLength());
    assertEquals(90, appearanceStream3.getContentStream().getLength());
    assertEquals(90, appearanceStream4.getContentStream().getLength());
    assertEquals(90, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance16() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.contains(anyFloat(), anyFloat())).thenReturn(true);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(new COSArray());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{9.223372E18f, 0.5f, 10.0f, 0.5f});
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
    verify(pdRectangle, atLeast(1)).contains(anyFloat(), eq(0.5f));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(colorSpace).getNumberOfComponents();
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
    PDRectangle bBox = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream().getBBox();
    List<? extends COSBase> toListResult = bBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDRectangle bBox2 = appearance.getDownAppearance().getAppearanceStream().getBBox();
    assertEquals(0.0f, bBox2.getHeight());
    assertEquals(0.0f, bBox.getHeight());
    assertEquals(0.0f, bBox2.getUpperRightX());
    assertEquals(0.0f, bBox.getUpperRightX());
    assertEquals(0.0f, bBox2.getUpperRightY());
    assertEquals(0.0f, bBox.getUpperRightY());
    assertEquals(0.0f, bBox2.getWidth());
    assertEquals(0.0f, bBox.getWidth());
    assertFalse(getResult.isDirect());
    assertEquals(toListResult, bBox2.getCOSArray().toList());
    assertEquals(toListResult, appearance.getNormalAppearance().getAppearanceStream().getBBox().getCOSArray().toList());
    assertEquals(toListResult,
        appearance.getRolloverAppearance().getAppearanceStream().getBBox().getCOSArray().toList());
    assertEquals(toListResult,
        pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream().getBBox().getCOSArray().toList());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance17() {
    // Arrange
    PDRectangle pdRectangle = mock(PDRectangle.class);
    when(pdRectangle.contains(anyFloat(), anyFloat())).thenReturn(true);
    when(pdRectangle.getHeight()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftX()).thenReturn(10.0f);
    when(pdRectangle.getLowerLeftY()).thenReturn(10.0f);
    when(pdRectangle.getWidth()).thenReturn(10.0f);
    when(pdRectangle.getCOSArray()).thenReturn(null);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{9.223372E18f, 0.5f, 10.0f, 0.5f});
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
    verify(pdRectangle, atLeast(1)).contains(anyFloat(), eq(0.5f));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(colorSpace).getNumberOfComponents();
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
    PDAppearanceEntry downAppearance = pdLinkAppearanceHandler.getDownAppearance();
    COSDictionary cOSObject = downAppearance.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-10.0f, matrix.getTranslateX());
    assertEquals(-10.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-10.0f, floatArray[0]);
    assertEquals(-10.0f, floatArray[1]);
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(34, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(34, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(34, appearanceStream4.getStream().getLength());
    assertEquals(34, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(34, appearanceStream5.getStream().getLength());
    assertEquals(34, appearanceStream2.getContentStream().getLength());
    assertEquals(34, appearanceStream3.getContentStream().getLength());
    assertEquals(34, appearanceStream4.getContentStream().getLength());
    assertEquals(34, appearanceStream.getContentStream().getLength());
    assertEquals(34, appearanceStream5.getContentStream().getLength());
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance18() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
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
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{9.223372E18f, 0.5f, 10.0f, 0.5f});
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
    verify(pdRectangle, atLeast(1)).contains(anyFloat(), eq(0.5f));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(colorSpace).getNumberOfComponents();
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
    PDAppearanceStream appearanceStream = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-10.0f, matrix.getTranslateX());
    assertEquals(-10.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-10.0f, floatArray[0]);
    assertEquals(-10.0f, floatArray[1]);
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(34, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(34, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(34, appearanceStream4.getStream().getLength());
    assertEquals(34, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(34, appearanceStream5.getStream().getLength());
    assertEquals(34, appearanceStream2.getContentStream().getLength());
    assertEquals(34, appearanceStream3.getContentStream().getLength());
    assertEquals(34, appearanceStream4.getContentStream().getLength());
    assertEquals(34, appearanceStream.getContentStream().getLength());
    assertEquals(34, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSBase#isDirect()} return
   * {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given COSArray isDirect() return 'false'; then calls getKey()")
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
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getCOSObject()).thenReturn(cosDictionary);
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{9.223372E18f, 0.5f, 10.0f, 0.5f});
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
    verify(pdRectangle, atLeast(1)).contains(anyFloat(), eq(0.5f));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(colorSpace).getNumberOfComponents();
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
    PDAppearanceStream appearanceStream = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-10.0f, matrix.getTranslateX());
    assertEquals(-10.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-10.0f, floatArray[0]);
    assertEquals(-10.0f, floatArray[1]);
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(34, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(34, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(34, appearanceStream4.getStream().getLength());
    assertEquals(34, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(34, appearanceStream5.getStream().getLength());
    assertEquals(34, appearanceStream2.getContentStream().getLength());
    assertEquals(34, appearanceStream3.getContentStream().getLength());
    assertEquals(34, appearanceStream4.getContentStream().getLength());
    assertEquals(34, appearanceStream.getContentStream().getLength());
    assertEquals(34, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link PDAnnotationLink} {@link PDAnnotationLink#getBorderStyle()}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDAnnotationLink getBorderStyle() return 'null'")
  void testGenerateNormalAppearance_givenPDAnnotationLinkGetBorderStyleReturnNull() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    when(annotation.getBorder()).thenReturn(new COSArray());
    when(annotation.getBorderStyle()).thenReturn(null);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLinkAppearanceHandler pdLinkAppearanceHandler = new PDLinkAppearanceHandler(annotation);

    // Act
    pdLinkAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation, atLeast(1)).getBorder();
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
    PDAppearanceStream appearanceStream4 = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(22, appearanceStream5.getStream().getLength());
    assertEquals(22, appearanceStream.getContentStream().getLength());
    assertEquals(22, appearanceStream2.getContentStream().getLength());
    assertEquals(22, appearanceStream3.getContentStream().getLength());
    assertEquals(22, appearanceStream4.getContentStream().getLength());
    assertEquals(22, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link PDAnnotationLink} {@link PDAnnotation#getColor()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDAnnotationLink getColor() return 'null'")
  void testGenerateNormalAppearance_givenPDAnnotationLinkGetColorReturnNull() {
    // Arrange
    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
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
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(6, appearanceStream5.getStream().getLength());
    assertEquals(6, appearanceStream.getContentStream().getLength());
    assertEquals(6, appearanceStream2.getContentStream().getLength());
    assertEquals(6, appearanceStream3.getContentStream().getLength());
    assertEquals(6, appearanceStream4.getContentStream().getLength());
    assertEquals(6, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link PDAnnotationLink} {@link PDAnnotationLink#getQuadPoints()}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDAnnotationLink getQuadPoints() return 'null'")
  void testGenerateNormalAppearance_givenPDAnnotationLinkGetQuadPointsReturnNull() {
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
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(70, appearanceStream5.getStream().getLength());
    assertEquals(70, appearanceStream.getContentStream().getLength());
    assertEquals(70, appearanceStream2.getContentStream().getLength());
    assertEquals(70, appearanceStream3.getContentStream().getLength());
    assertEquals(70, appearanceStream4.getContentStream().getLength());
    assertEquals(70, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Then calls
   * {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls setOriginDocumentState(COSDocumentState)")
  void testGenerateNormalAppearance_thenCallsSetOriginDocumentState() {
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
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationLink annotation = mock(PDAnnotationLink.class);
    when(annotation.getQuadPoints()).thenReturn(new float[]{9.223372E18f, 0.5f, 10.0f, 0.5f});
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
    verify(pdRectangle, atLeast(1)).contains(anyFloat(), eq(0.5f));
    verify(pdRectangle).getCOSArray();
    verify(pdRectangle).getHeight();
    verify(pdRectangle, atLeast(1)).getLowerLeftX();
    verify(pdRectangle, atLeast(1)).getLowerLeftY();
    verify(pdRectangle).getWidth();
    verify(colorSpace).getNumberOfComponents();
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
    PDAppearanceStream appearanceStream = pdLinkAppearanceHandler.getDownAppearance().getAppearanceStream();
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-10.0f, matrix.getTranslateX());
    assertEquals(-10.0f, matrix.getTranslateY());
    float[][] values = matrix.getValues();
    float[] floatArray = values[2];
    assertEquals(-10.0f, floatArray[0]);
    assertEquals(-10.0f, floatArray[1]);
    assertEquals(3, values.length);
    assertEquals(3, floatArray.length);
    PDAppearanceDictionary appearance = pdLinkAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(34, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(34, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(34, appearanceStream4.getStream().getLength());
    assertEquals(34, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLinkAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(34, appearanceStream5.getStream().getLength());
    assertEquals(34, appearanceStream2.getContentStream().getLength());
    assertEquals(34, appearanceStream3.getContentStream().getLength());
    assertEquals(34, appearanceStream4.getContentStream().getLength());
    assertEquals(34, appearanceStream.getContentStream().getLength());
    assertEquals(34, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLinkAppearanceHandler#getLineWidth()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDLinkAppearanceHandler#getLineWidth()}
   */
  @Test
  @DisplayName("Test getLineWidth(); then return one")
  void testGetLineWidth_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDLinkAppearanceHandler(new PDAnnotationLink())).getLineWidth());
  }
}
