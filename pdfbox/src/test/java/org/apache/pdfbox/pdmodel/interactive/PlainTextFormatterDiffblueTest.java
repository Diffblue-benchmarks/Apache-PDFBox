package org.apache.pdfbox.pdmodel.interactive;

import static org.junit.jupiter.api.Assertions.assertSame;
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
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlainTextFormatterDiffblueTest {
  /**
   * Method under test:
   * {@link PlainTextFormatter.Builder#initialOffset(float, float)}
   */
  @Test
  void testBuilderInitialOffset() throws IOException {
    // Arrange
    PlainTextFormatter.Builder builder = new PlainTextFormatter.Builder(
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())));

    // Act and Assert
    assertSame(builder, builder.initialOffset(10.0f, 10.0f));
  }

  /**
   * Method under test:
   * {@link PlainTextFormatter.Builder#Builder(PDAppearanceContentStream)}
   */
  @Test
  void testBuilderNewBuilder() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    new PlainTextFormatter.Builder(new PDAppearanceContentStream(new PDAppearanceStream(stream)));

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Method under test: {@link PlainTextFormatter.Builder#textAlign(int)}
   */
  @Test
  void testBuilderTextAlign() throws IOException {
    // Arrange
    PlainTextFormatter.Builder builder = new PlainTextFormatter.Builder(
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())));

    // Act and Assert
    assertSame(builder, builder.textAlign(1));
  }

  /**
   * Method under test: {@link PlainTextFormatter.Builder#textAlign(int)}
   */
  @Test
  void testBuilderTextAlign2() throws IOException {
    // Arrange
    PlainTextFormatter.Builder builder = new PlainTextFormatter.Builder(
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())));

    // Act and Assert
    assertSame(builder, builder.textAlign(-1));
  }
}
