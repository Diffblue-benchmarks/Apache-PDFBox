package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDImmutableRectangle;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDPattern;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLine;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDLineAppearanceHandlerDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDLineAppearanceHandler#PDLineAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDLineAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDLineAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDLineAppearanceHandler actualPdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);
    actualPdLineAppearanceHandler.generateDownAppearance();
    actualPdLineAppearanceHandler.generateRolloverAppearance();

    // Assert that nothing has changed
    assertTrue(actualPdLineAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdLineAppearanceHandler.getAnnotation());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance() {
    // Arrange
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(new PDAnnotationLine());

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert that nothing has changed
    PDAppearanceStream appearanceStream = pdLineAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(0, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = pdLineAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(0, appearanceStream2.getStream().getLength());
    assertEquals(0, appearanceStream.getContentStream().getLength());
    assertEquals(0, appearanceStream2.getContentStream().getLength());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance2() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getLeaderLineLength()).thenThrow(new IllegalArgumentException("S"));
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDLineAppearanceHandler(annotation)).generateNormalAppearance());
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getLeaderLineLength();
    verify(annotation).getLine();
    verify(annotation).getBorderStyle();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance3() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    COSArray array = new COSArray();
    when(annotation.getColor()).thenReturn(new PDColor(array, new PDPattern(new PDResources())));
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getLine();
    verify(annotation).getBorderStyle();
    PDRectangle rectangle = pdLineAppearanceHandler.getRectangle();
    assertTrue(rectangle instanceof PDImmutableRectangle);
    assertEquals(0.0f, rectangle.getLowerLeftX());
    assertEquals(0.0f, rectangle.getLowerLeftY());
    assertEquals(2383.937f, rectangle.getUpperRightX());
    assertEquals(2383.937f, rectangle.getWidth());
    assertEquals(3370.3938f, rectangle.getHeight());
    assertEquals(3370.3938f, rectangle.getUpperRightY());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance4() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
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
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
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
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceDictionary appearance = pdLineAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(183, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(183, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(183, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdLineAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(183, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLineAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(183, appearanceStream5.getStream().getLength());
    assertEquals(183, appearanceStream.getContentStream().getLength());
    assertEquals(183, appearanceStream2.getContentStream().getLength());
    assertEquals(183, appearanceStream3.getContentStream().getLength());
    assertEquals(183, appearanceStream4.getContentStream().getLength());
    assertEquals(183, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance5() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenThrow(new IllegalArgumentException("D"));
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
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDLineAppearanceHandler(annotation)).generateNormalAppearance());
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
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance6() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(Float.MAX_VALUE);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
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
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
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
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceDictionary appearance = pdLineAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(216, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(216, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(216, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdLineAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(216, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLineAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(216, appearanceStream5.getStream().getLength());
    assertEquals(216, appearanceStream.getContentStream().getLength());
    assertEquals(216, appearanceStream2.getContentStream().getLength());
    assertEquals(216, appearanceStream3.getContentStream().getLength());
    assertEquals(216, appearanceStream4.getContentStream().getLength());
    assertEquals(216, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance7() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(0.0f);
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
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
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
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
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceDictionary appearance = pdLineAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdLineAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLineAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(167, appearanceStream5.getStream().getLength());
    assertEquals(167, appearanceStream.getContentStream().getLength());
    assertEquals(167, appearanceStream2.getContentStream().getLength());
    assertEquals(167, appearanceStream3.getContentStream().getLength());
    assertEquals(167, appearanceStream4.getContentStream().getLength());
    assertEquals(167, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance8() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), PDDeviceRGB.INSTANCE));
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
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
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
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceDictionary appearance = pdLineAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(188, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(188, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(188, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdLineAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(188, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLineAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(188, appearanceStream5.getStream().getLength());
    assertEquals(188, appearanceStream.getContentStream().getLength());
    assertEquals(188, appearanceStream2.getContentStream().getLength());
    assertEquals(188, appearanceStream3.getContentStream().getLength());
    assertEquals(188, appearanceStream4.getContentStream().getLength());
    assertEquals(188, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance9() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getCaptionHorizontalOffset()).thenReturn(10.0f);
    when(annotation.getCaptionVerticalOffset()).thenReturn(10.0f);
    COSArray array = new COSArray();
    when(annotation.getInteriorColor()).thenReturn(new PDColor(array, new PDPattern(new PDResources())));
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
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
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
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceDictionary appearance = pdLineAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(179, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(179, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(179, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdLineAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(179, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLineAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(179, appearanceStream5.getStream().getLength());
    assertEquals(179, appearanceStream.getContentStream().getLength());
    assertEquals(179, appearanceStream2.getContentStream().getLength());
    assertEquals(179, appearanceStream3.getContentStream().getLength());
    assertEquals(179, appearanceStream4.getContentStream().getLength());
    assertEquals(179, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance10() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
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
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
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
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceDictionary appearance = pdLineAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(199, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(199, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(199, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdLineAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(199, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLineAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(199, appearanceStream5.getStream().getLength());
    assertEquals(199, appearanceStream.getContentStream().getLength());
    assertEquals(199, appearanceStream2.getContentStream().getLength());
    assertEquals(199, appearanceStream3.getContentStream().getLength());
    assertEquals(199, appearanceStream4.getContentStream().getLength());
    assertEquals(199, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance11() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
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
    when(annotation.getConstantOpacity()).thenReturn(Float.MIN_VALUE);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
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
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream = pdLineAppearanceHandler.getDownAppearance().getAppearanceStream();
    PDResources resources = appearanceStream.getResources();
    Iterable<COSName> extGStateNames = resources.getExtGStateNames();
    assertTrue(extGStateNames instanceof Set);
    assertEquals(1, ((Set<COSName>) extGStateNames).size());
    COSDictionary cOSObject = resources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    PDAppearanceDictionary appearance = pdLineAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(207, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(207, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(207, appearanceStream4.getStream().getLength());
    assertEquals(207, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLineAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(207, appearanceStream5.getStream().getLength());
    assertEquals(207, appearanceStream2.getContentStream().getLength());
    assertEquals(207, appearanceStream3.getContentStream().getLength());
    assertEquals(207, appearanceStream4.getContentStream().getLength());
    assertEquals(207, appearanceStream.getContentStream().getLength());
    assertEquals(207, appearanceStream5.getContentStream().getLength());
    assertSame(extGStateNames, appearanceStream2.getResources().getExtGStateNames());
    assertSame(extGStateNames, appearanceStream3.getResources().getExtGStateNames());
    assertSame(extGStateNames, appearanceStream4.getResources().getExtGStateNames());
    assertSame(extGStateNames, appearanceStream5.getResources().getExtGStateNames());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance12() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
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
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
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
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream = pdLineAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(0, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = pdLineAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(0, appearanceStream2.getStream().getLength());
    assertEquals(0, appearanceStream.getContentStream().getLength());
    assertEquals(0, appearanceStream2.getContentStream().getLength());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance13() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(new COSStream()));
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
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
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
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDRectangle rectangle = pdLineAppearanceHandler.getRectangle();
    assertEquals(-100.0f, rectangle.getLowerLeftY());
    assertEquals(-90.0f, rectangle.getLowerLeftX());
    assertEquals(100.0f, rectangle.getUpperRightY());
    assertEquals(110.0f, rectangle.getUpperRightX());
    assertEquals(200.0f, rectangle.getHeight());
    assertEquals(200.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance14() throws IOException {
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
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
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
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDRectangle rectangle = pdLineAppearanceHandler.getRectangle();
    assertEquals(-100.0f, rectangle.getLowerLeftY());
    assertEquals(-90.0f, rectangle.getLowerLeftX());
    assertEquals(100.0f, rectangle.getUpperRightY());
    assertEquals(110.0f, rectangle.getUpperRightX());
    assertEquals(200.0f, rectangle.getHeight());
    assertEquals(200.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  void testGenerateNormalAppearance15() throws IOException {
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
    when(annotation.getConstantOpacity()).thenReturn(Float.MIN_VALUE);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
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
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDRectangle rectangle = pdLineAppearanceHandler.getRectangle();
    assertEquals(-100.0f, rectangle.getLowerLeftY());
    assertEquals(-90.0f, rectangle.getLowerLeftX());
    assertEquals(100.0f, rectangle.getUpperRightY());
    assertEquals(110.0f, rectangle.getUpperRightX());
    assertEquals(200.0f, rectangle.getHeight());
    assertEquals(200.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link COSStream} {@link COSDictionary#getCOSDictionary(COSName)}
   * return {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given COSStream getCOSDictionary(COSName) return COSDictionary()")
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
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(entry, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(entry, atLeast(1)).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    verify(entry, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(entry).createOutputStream(isNull());
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
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDRectangle rectangle = pdLineAppearanceHandler.getRectangle();
    assertEquals(-100.0f, rectangle.getLowerLeftY());
    assertEquals(-90.0f, rectangle.getLowerLeftX());
    assertEquals(100.0f, rectangle.getUpperRightY());
    assertEquals(110.0f, rectangle.getUpperRightX());
    assertEquals(200.0f, rectangle.getHeight());
    assertEquals(200.0f, rectangle.getWidth());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link PDAnnotationLine} {@link PDAnnotation#getColor()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDAnnotationLine getColor() return 'null'")
  void testGenerateNormalAppearance_givenPDAnnotationLineGetColorReturnNull() {
    // Arrange
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getColor()).thenReturn(null);
    when(annotation.getBorderStyle()).thenReturn(new PDBorderStyleDictionary());
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(annotation).getColor();
    verify(annotation).getRectangle();
    verify(annotation).getLine();
    verify(annotation).getBorderStyle();
    PDRectangle rectangle = pdLineAppearanceHandler.getRectangle();
    assertTrue(rectangle instanceof PDImmutableRectangle);
    assertEquals(0.0f, rectangle.getLowerLeftX());
    assertEquals(0.0f, rectangle.getLowerLeftY());
    assertEquals(2383.937f, rectangle.getUpperRightX());
    assertEquals(2383.937f, rectangle.getWidth());
    assertEquals(3370.3938f, rectangle.getHeight());
    assertEquals(3370.3938f, rectangle.getUpperRightY());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link PDAnnotationLine} {@link PDAnnotation#getContents()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDAnnotationLine getContents() return 'null'")
  void testGenerateNormalAppearance_givenPDAnnotationLineGetContentsReturnNull() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), colorSpace));
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(true);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn(null);
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
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
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream = pdLineAppearanceHandler.getDownAppearance().getAppearanceStream();
    COSDictionary cOSObject = appearanceStream.getResources().getCOSObject();
    assertEquals(0, cOSObject.size());
    PDAppearanceDictionary appearance = pdLineAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(97, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(97, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(97, appearanceStream4.getStream().getLength());
    assertEquals(97, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLineAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(97, appearanceStream5.getStream().getLength());
    assertEquals(97, appearanceStream2.getContentStream().getLength());
    assertEquals(97, appearanceStream3.getContentStream().getLength());
    assertEquals(97, appearanceStream4.getContentStream().getLength());
    assertEquals(97, appearanceStream.getContentStream().getLength());
    assertEquals(97, appearanceStream5.getContentStream().getLength());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link PDAnnotationLine}
   * {@link PDAnnotationLine#getInteriorColor()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDAnnotationLine getInteriorColor() return 'null'")
  void testGenerateNormalAppearance_givenPDAnnotationLineGetInteriorColorReturnNull() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
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
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
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
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceDictionary appearance = pdLineAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(179, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream2 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(179, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(179, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = pdLineAppearanceHandler.getDownAppearance().getAppearanceStream();
    assertEquals(179, appearanceStream4.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLineAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(179, appearanceStream5.getStream().getLength());
    assertEquals(179, appearanceStream.getContentStream().getLength());
    assertEquals(179, appearanceStream2.getContentStream().getLength());
    assertEquals(179, appearanceStream3.getContentStream().getLength());
    assertEquals(179, appearanceStream4.getContentStream().getLength());
    assertEquals(179, appearanceStream5.getContentStream().getLength());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link PDAnnotationLine} {@link PDAnnotationLine#getLine()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDAnnotationLine getLine() return 'null'")
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
    assertEquals(0.0f, rectangle.getLowerLeftY());
    assertEquals(2383.937f, rectangle.getUpperRightX());
    assertEquals(2383.937f, rectangle.getWidth());
    assertEquals(3370.3938f, rectangle.getHeight());
    assertEquals(3370.3938f, rectangle.getUpperRightY());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Given {@link PDAnnotationLine} {@link PDAnnotationLine#hasCaption()}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); given PDAnnotationLine hasCaption() return 'false'")
  void testGenerateNormalAppearance_givenPDAnnotationLineHasCaptionReturnFalse() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    PDAnnotationLine annotation = mock(PDAnnotationLine.class);
    when(annotation.getInteriorColor()).thenReturn(new PDColor(new COSArray(), colorSpace));
    when(annotation.getEndPointEndingStyle()).thenReturn("https://config.us-east-2.amazonaws.com");
    when(annotation.hasCaption()).thenReturn(false);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getContents()).thenReturn("Not all who wander are lost");
    when(annotation.getStartPointEndingStyle()).thenReturn("Start Point Ending Style");
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
    when(annotation.getRectangle()).thenReturn(new PDRectangle());
    PDLineAppearanceHandler pdLineAppearanceHandler = new PDLineAppearanceHandler(annotation);

    // Act
    pdLineAppearanceHandler.generateNormalAppearance();

    // Assert
    verify(colorSpace).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getColor();
    verify(annotation).getContents();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
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
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDAppearanceStream appearanceStream = pdLineAppearanceHandler.getDownAppearance().getAppearanceStream();
    COSDictionary cOSObject = appearanceStream.getResources().getCOSObject();
    assertEquals(0, cOSObject.size());
    PDAppearanceDictionary appearance = pdLineAppearanceHandler.getAppearance();
    PDAppearanceStream appearanceStream2 = appearance.getDownAppearance().getAppearanceStream();
    assertEquals(97, appearanceStream2.getStream().getLength());
    PDAppearanceStream appearanceStream3 = appearance.getNormalAppearance().getAppearanceStream();
    assertEquals(97, appearanceStream3.getStream().getLength());
    PDAppearanceStream appearanceStream4 = appearance.getRolloverAppearance().getAppearanceStream();
    assertEquals(97, appearanceStream4.getStream().getLength());
    assertEquals(97, appearanceStream.getStream().getLength());
    PDAppearanceStream appearanceStream5 = pdLineAppearanceHandler.getRolloverAppearance().getAppearanceStream();
    assertEquals(97, appearanceStream5.getStream().getLength());
    assertEquals(97, appearanceStream2.getContentStream().getLength());
    assertEquals(97, appearanceStream3.getContentStream().getLength());
    assertEquals(97, appearanceStream4.getContentStream().getLength());
    assertEquals(97, appearanceStream.getContentStream().getLength());
    assertEquals(97, appearanceStream5.getContentStream().getLength());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDLineAppearanceHandler#generateNormalAppearance()}.
   * <ul>
   *   <li>Then calls
   * {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDLineAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance(); then calls setNormalAppearance(PDAppearanceEntry)")
  void testGenerateNormalAppearance_thenCallsSetNormalAppearance() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = mock(PDBorderStyleDictionary.class);
    when(pdBorderStyleDictionary.getDashStyle()).thenReturn(new PDLineDashPattern());
    when(pdBorderStyleDictionary.getWidth()).thenReturn(10.0f);
    when(pdBorderStyleDictionary.getStyle()).thenReturn("D");
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());
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
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    when(annotation.getLeaderLineExtensionLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineLength()).thenReturn(10.0f);
    when(annotation.getLeaderLineOffsetLength()).thenReturn(10.0f);
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getBorderStyle()).thenReturn(pdBorderStyleDictionary);
    when(annotation.getLine()).thenReturn(new float[]{10.0f, 0.0f, 10.0f, 0.0f});
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
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
    verify(pdBorderStyleDictionary).getDashStyle();
    verify(pdBorderStyleDictionary, atLeast(1)).getStyle();
    verify(pdBorderStyleDictionary).getWidth();
    PDRectangle rectangle = pdLineAppearanceHandler.getRectangle();
    assertEquals(-100.0f, rectangle.getLowerLeftY());
    assertEquals(-90.0f, rectangle.getLowerLeftX());
    assertEquals(100.0f, rectangle.getUpperRightY());
    assertEquals(110.0f, rectangle.getUpperRightX());
    assertEquals(200.0f, rectangle.getHeight());
    assertEquals(200.0f, rectangle.getWidth());
  }
}
