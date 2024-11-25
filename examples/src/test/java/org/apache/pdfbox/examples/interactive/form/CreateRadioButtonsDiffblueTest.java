package org.apache.pdfbox.examples.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDAppearanceContentStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CreateRadioButtonsDiffblueTest {
  /**
   * Test {@link CreateRadioButtons#getLineWidth(PDAnnotationWidget)}.
   * <ul>
   *   <li>When {@link PDAnnotationWidget#PDAnnotationWidget()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CreateRadioButtons#getLineWidth(PDAnnotationWidget)}
   */
  @Test
  @DisplayName("Test getLineWidth(PDAnnotationWidget); when PDAnnotationWidget(); then return one")
  void testGetLineWidth_whenPDAnnotationWidget_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, CreateRadioButtons.getLineWidth(new PDAnnotationWidget()));
  }

  /**
   * Test
   * {@link CreateRadioButtons#drawCircle(PDAppearanceContentStream, float, float, float)}.
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with
   * one.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CreateRadioButtons#drawCircle(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  @DisplayName("Test drawCircle(PDAppearanceContentStream, float, float, float); given ByteArrayOutputStream(int) with one; then calls getCOSDictionary(COSName)")
  void testDrawCircle_givenByteArrayOutputStreamWithOne_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    CreateRadioButtons.drawCircle(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f, 10.0f, 10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test
   * {@link CreateRadioButtons#drawCircle(PDAppearanceContentStream, float, float, float)}.
   * <ul>
   *   <li>When {@code -9.223372E18}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CreateRadioButtons#drawCircle(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  @DisplayName("Test drawCircle(PDAppearanceContentStream, float, float, float); when '-9.223372E18'; then calls getCOSDictionary(COSName)")
  void testDrawCircle_when9223372e18_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    CreateRadioButtons.drawCircle(new PDAppearanceContentStream(new PDAppearanceStream(stream)), -9.223372E18f, 10.0f,
        10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }
}
