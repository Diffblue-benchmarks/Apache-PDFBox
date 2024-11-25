package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDInlineImage;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAbstractContentStreamDiffblueTest {
  /**
   * Test {@link PDAbstractContentStream#endText()}.
   * <p>
   * Method under test: {@link PDAbstractContentStream#endText()}
   */
  @Test
  @DisplayName("Test endText()")
  void testEndText() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))).endText());
  }

  /**
   * Test {@link PDAbstractContentStream#showText(String)}.
   * <p>
   * Method under test: {@link PDAbstractContentStream#showText(String)}
   */
  @Test
  @DisplayName("Test showText(String)")
  void testShowText() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))).showText("Text"));
  }

  /**
   * Test {@link PDAbstractContentStream#showTextInternal(String)}.
   * <p>
   * Method under test: {@link PDAbstractContentStream#showTextInternal(String)}
   */
  @Test
  @DisplayName("Test showTextInternal(String)")
  void testShowTextInternal() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))).showTextInternal("Text"));
  }

  /**
   * Test {@link PDAbstractContentStream#newLine()}.
   * <p>
   * Method under test: {@link PDAbstractContentStream#newLine()}
   */
  @Test
  @DisplayName("Test newLine()")
  void testNewLine() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))).newLine());
  }

  /**
   * Test {@link PDAbstractContentStream#newLineAtOffset(float, float)}.
   * <p>
   * Method under test:
   * {@link PDAbstractContentStream#newLineAtOffset(float, float)}
   */
  @Test
  @DisplayName("Test newLineAtOffset(float, float)")
  void testNewLineAtOffset() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))).newLineAtOffset(10.0f, 10.0f));
  }

  /**
   * Test {@link PDAbstractContentStream#setTextMatrix(Matrix)}.
   * <p>
   * Method under test: {@link PDAbstractContentStream#setTextMatrix(Matrix)}
   */
  @Test
  @DisplayName("Test setTextMatrix(Matrix)")
  void testSetTextMatrix() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream = new PDAppearanceContentStream(
        new PDAppearanceStream(new COSStream()));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> pdAppearanceContentStream.setTextMatrix(new Matrix()));
  }

  /**
   * Test {@link PDAbstractContentStream#drawImage(PDImageXObject, float, float)}
   * with {@code image}, {@code x}, {@code y}.
   * <ul>
   *   <li>When {@link Float#NaN}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractContentStream#drawImage(PDImageXObject, float, float)}
   */
  @Test
  @DisplayName("Test drawImage(PDImageXObject, float, float) with 'image', 'x', 'y'; when NaN; then throw IllegalArgumentException")
  void testDrawImageWithImageXY_whenNaN_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream = new PDAppearanceContentStream(
        new PDAppearanceStream(new COSStream()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> pdAppearanceContentStream.drawImage(PDImageXObject.createThumbnail(new COSStream()), Float.NaN, 10.0f));
  }

  /**
   * Test
   * {@link PDAbstractContentStream#drawImage(PDInlineImage, float, float, float, float)}
   * with {@code inlineImage}, {@code x}, {@code y}, {@code width},
   * {@code height}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractContentStream#drawImage(PDInlineImage, float, float, float, float)}
   */
  @Test
  @DisplayName("Test drawImage(PDInlineImage, float, float, float, float) with 'inlineImage', 'x', 'y', 'width', 'height'; then throw IllegalArgumentException")
  void testDrawImageWithInlineImageXYWidthHeight_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream = new PDAppearanceContentStream(
        new PDAppearanceStream(new COSStream()));
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdAppearanceContentStream
        .drawImage(new PDInlineImage(parameters, data, new PDResources()), Float.NaN, 10.0f, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDAbstractContentStream#drawImage(PDInlineImage, float, float)}
   * with {@code inlineImage}, {@code x}, {@code y}.
   * <ul>
   *   <li>When {@link Float#NaN}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAbstractContentStream#drawImage(PDInlineImage, float, float)}
   */
  @Test
  @DisplayName("Test drawImage(PDInlineImage, float, float) with 'inlineImage', 'x', 'y'; when NaN; then throw IllegalArgumentException")
  void testDrawImageWithInlineImageXY_whenNaN_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream = new PDAppearanceContentStream(
        new PDAppearanceStream(new COSStream()));
    COSDictionary parameters = new COSDictionary();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdAppearanceContentStream
        .drawImage(new PDInlineImage(parameters, data, new PDResources()), Float.NaN, 10.0f));
  }

  /**
   * Test {@link PDAbstractContentStream#getName(PDColorSpace)}.
   * <ul>
   *   <li>When {@link PDDeviceGray#INSTANCE}.</li>
   *   <li>Then return {@link COSName#DEVICEGRAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractContentStream#getName(PDColorSpace)}
   */
  @Test
  @DisplayName("Test getName(PDColorSpace); when INSTANCE; then return DEVICEGRAY")
  void testGetName_whenInstance_thenReturnDevicegray() throws IOException {
    // Arrange
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    COSName actualName = (new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))).getName(colorSpace);

    // Assert
    COSName cosName = actualName.DEVICEGRAY;
    assertSame(cosName, actualName);
    assertSame(cosName, colorSpace.getCOSObject());
  }

  /**
   * Test {@link PDAbstractContentStream#getName(PDColorSpace)}.
   * <ul>
   *   <li>When {@link PDDeviceRGB#INSTANCE}.</li>
   *   <li>Then return {@link COSName#DEVICERGB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractContentStream#getName(PDColorSpace)}
   */
  @Test
  @DisplayName("Test getName(PDColorSpace); when INSTANCE; then return DEVICERGB")
  void testGetName_whenInstance_thenReturnDevicergb() throws IOException {
    // Arrange
    PDDeviceRGB colorSpace = PDDeviceRGB.INSTANCE;

    // Act
    COSName actualName = (new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))).getName(colorSpace);

    // Assert
    COSName cosName = actualName.DEVICERGB;
    assertSame(cosName, actualName);
    assertSame(cosName, colorSpace.getCOSObject());
  }

  /**
   * Test {@link PDAbstractContentStream#close()}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractContentStream#close()}
   */
  @Test
  @DisplayName("Test close(); then calls getCOSDictionary(COSName)")
  void testClose_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    (new PDAppearanceContentStream(new PDAppearanceStream(stream))).close();

    // Assert that nothing has changed
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractContentStream#isOutside255Interval(int)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractContentStream#isOutside255Interval(int)}
   */
  @Test
  @DisplayName("Test isOutside255Interval(int); when forty-two; then return 'false'")
  void testIsOutside255Interval_whenFortyTwo_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))).isOutside255Interval(42));
  }

  /**
   * Test {@link PDAbstractContentStream#isOutside255Interval(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractContentStream#isOutside255Interval(int)}
   */
  @Test
  @DisplayName("Test isOutside255Interval(int); when minus one; then return 'true'")
  void testIsOutside255Interval_whenMinusOne_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))).isOutside255Interval(-1));
  }

  /**
   * Test {@link PDAbstractContentStream#isOutside255Interval(int)}.
   * <ul>
   *   <li>When two hundred fifty-six.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractContentStream#isOutside255Interval(int)}
   */
  @Test
  @DisplayName("Test isOutside255Interval(int); when two hundred fifty-six; then return 'true'")
  void testIsOutside255Interval_whenTwoHundredFiftySix_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))).isOutside255Interval(256));
  }

  /**
   * Test
   * {@link PDAbstractContentStream#setStrokingColorSpaceStack(PDColorSpace)}.
   * <p>
   * Method under test:
   * {@link PDAbstractContentStream#setStrokingColorSpaceStack(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setStrokingColorSpaceStack(PDColorSpace)")
  void testSetStrokingColorSpaceStack() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream = new PDAppearanceContentStream(
        new PDAppearanceStream(new COSStream()));

    // Act
    pdAppearanceContentStream.setStrokingColorSpaceStack(PDDeviceGray.INSTANCE);

    // Assert
    assertEquals(1, pdAppearanceContentStream.strokingColorSpaceStack.size());
  }

  /**
   * Test
   * {@link PDAbstractContentStream#setNonStrokingColorSpaceStack(PDColorSpace)}.
   * <p>
   * Method under test:
   * {@link PDAbstractContentStream#setNonStrokingColorSpaceStack(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setNonStrokingColorSpaceStack(PDColorSpace)")
  void testSetNonStrokingColorSpaceStack() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream = new PDAppearanceContentStream(
        new PDAppearanceStream(new COSStream()));

    // Act
    pdAppearanceContentStream.setNonStrokingColorSpaceStack(PDDeviceGray.INSTANCE);

    // Assert
    assertEquals(1, pdAppearanceContentStream.nonStrokingColorSpaceStack.size());
  }
}
