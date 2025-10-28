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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CreateRadioButtonsDiffblueTest {
  /**
   * Method under test:
   * {@link CreateRadioButtons#getLineWidth(PDAnnotationWidget)}
   */
  @Test
  void testGetLineWidth() {
    // Arrange, Act and Assert
    assertEquals(1.0f, CreateRadioButtons.getLineWidth(new PDAnnotationWidget()));
  }

  /**
   * Method under test:
   * {@link CreateRadioButtons#drawCircle(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  void testDrawCircle() throws IOException {
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
   * Method under test:
   * {@link CreateRadioButtons#drawCircle(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  void testDrawCircle2() throws IOException {
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
