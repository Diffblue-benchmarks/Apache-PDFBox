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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAbstractContentStreamDiffblueTest {
  /**
   * Test {@link PDAbstractContentStream#endText()}.
   *
   * <p>Method under test: {@link PDAbstractContentStream#endText()}
   */
  @Test
  @DisplayName("Test endText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAbstractContentStream.endText()"})
  void testEndText() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())).endText());
  }

  /**
   * Test {@link PDAbstractContentStream#showText(String)}.
   *
   * <p>Method under test: {@link PDAbstractContentStream#showText(String)}
   */
  @Test
  @DisplayName("Test showText(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAbstractContentStream.showText(String)"})
  void testShowText() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .showText("Text"));
  }

  /**
   * Test {@link PDAbstractContentStream#showTextInternal(String)}.
   *
   * <p>Method under test: {@link PDAbstractContentStream#showTextInternal(String)}
   */
  @Test
  @DisplayName("Test showTextInternal(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAbstractContentStream.showTextInternal(String)"})
  void testShowTextInternal() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .showTextInternal("Text"));
  }

  /**
   * Test {@link PDAbstractContentStream#newLine()}.
   *
   * <p>Method under test: {@link PDAbstractContentStream#newLine()}
   */
  @Test
  @DisplayName("Test newLine()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAbstractContentStream.newLine()"})
  void testNewLine() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())).newLine());
  }

  /**
   * Test {@link PDAbstractContentStream#newLineAtOffset(float, float)}.
   *
   * <p>Method under test: {@link PDAbstractContentStream#newLineAtOffset(float, float)}
   */
  @Test
  @DisplayName("Test newLineAtOffset(float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAbstractContentStream.newLineAtOffset(float, float)"})
  void testNewLineAtOffset() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
                .newLineAtOffset(10.0f, 10.0f));
  }

  /**
   * Test {@link PDAbstractContentStream#setTextMatrix(Matrix)}.
   *
   * <p>Method under test: {@link PDAbstractContentStream#setTextMatrix(Matrix)}
   */
  @Test
  @DisplayName("Test setTextMatrix(Matrix)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAbstractContentStream.setTextMatrix(Matrix)"})
  void testSetTextMatrix() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> pdAppearanceContentStream.setTextMatrix(new Matrix()));
  }

  /**
   * Test {@link PDAbstractContentStream#getName(PDColorSpace)}.
   *
   * <ul>
   *   <li>When {@link PDDeviceGray#INSTANCE}.
   *   <li>Then return {@link COSName#DEVICEGRAY}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractContentStream#getName(PDColorSpace)}
   */
  @Test
  @DisplayName("Test getName(PDColorSpace); when INSTANCE; then return DEVICEGRAY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDAbstractContentStream.getName(PDColorSpace)"})
  void testGetName_whenInstance_thenReturnDevicegray() throws IOException {
    // Arrange
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act and Assert
    COSName cosName = COSName.DEVICEGRAY;
    assertSame(
        cosName,
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())).getName(colorSpace));
    assertSame(cosName, colorSpace.getCOSObject());
  }

  /**
   * Test {@link PDAbstractContentStream#getName(PDColorSpace)}.
   *
   * <ul>
   *   <li>When {@link PDDeviceRGB#INSTANCE}.
   *   <li>Then return {@link COSName#DEVICERGB}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractContentStream#getName(PDColorSpace)}
   */
  @Test
  @DisplayName("Test getName(PDColorSpace); when INSTANCE; then return DEVICERGB")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSName PDAbstractContentStream.getName(PDColorSpace)"})
  void testGetName_whenInstance_thenReturnDevicergb() throws IOException {
    // Arrange
    PDDeviceRGB colorSpace = PDDeviceRGB.INSTANCE;

    // Act and Assert
    COSName cosName = COSName.DEVICERGB;
    assertSame(
        cosName,
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())).getName(colorSpace));
    assertSame(cosName, colorSpace.getCOSObject());
  }

  /**
   * Test {@link PDAbstractContentStream#close()}.
   *
   * <ul>
   *   <li>Then calls {@link COSStream#getCOSDictionary(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractContentStream#close()}
   */
  @Test
  @DisplayName("Test close(); then calls getCOSDictionary(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAbstractContentStream.close()"})
  void testClose_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream());
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream appearance = new PDAppearanceStream(stream);
    try (PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(appearance)) {}

    // Act and Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractContentStream#isOutside255Interval(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractContentStream#isOutside255Interval(int)}
   */
  @Test
  @DisplayName("Test isOutside255Interval(int); when forty-two; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAbstractContentStream.isOutside255Interval(int)"})
  void testIsOutside255Interval_whenFortyTwo_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse(
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
            .isOutside255Interval(42));
  }

  /**
   * Test {@link PDAbstractContentStream#isOutside255Interval(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractContentStream#isOutside255Interval(int)}
   */
  @Test
  @DisplayName("Test isOutside255Interval(int); when minus one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAbstractContentStream.isOutside255Interval(int)"})
  void testIsOutside255Interval_whenMinusOne_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue(
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
            .isOutside255Interval(-1));
  }

  /**
   * Test {@link PDAbstractContentStream#isOutside255Interval(int)}.
   *
   * <ul>
   *   <li>When two hundred fifty-six.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractContentStream#isOutside255Interval(int)}
   */
  @Test
  @DisplayName("Test isOutside255Interval(int); when two hundred fifty-six; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAbstractContentStream.isOutside255Interval(int)"})
  void testIsOutside255Interval_whenTwoHundredFiftySix_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue(
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()))
            .isOutside255Interval(256));
  }

  /**
   * Test {@link PDAbstractContentStream#setStrokingColorSpaceStack(PDColorSpace)}.
   *
   * <p>Method under test: {@link PDAbstractContentStream#setStrokingColorSpaceStack(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setStrokingColorSpaceStack(PDColorSpace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAbstractContentStream.setStrokingColorSpaceStack(PDColorSpace)"})
  void testSetStrokingColorSpaceStack() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));

    // Act
    pdAppearanceContentStream.setStrokingColorSpaceStack(PDDeviceGray.INSTANCE);

    // Assert
    assertEquals(1, pdAppearanceContentStream.strokingColorSpaceStack.size());
  }

  /**
   * Test {@link PDAbstractContentStream#setNonStrokingColorSpaceStack(PDColorSpace)}.
   *
   * <p>Method under test: {@link
   * PDAbstractContentStream#setNonStrokingColorSpaceStack(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setNonStrokingColorSpaceStack(PDColorSpace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAbstractContentStream.setNonStrokingColorSpaceStack(PDColorSpace)"})
  void testSetNonStrokingColorSpaceStack() throws IOException {
    // Arrange
    PDAppearanceContentStream pdAppearanceContentStream =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));

    // Act
    pdAppearanceContentStream.setNonStrokingColorSpaceStack(PDDeviceGray.INSTANCE);

    // Assert
    assertEquals(1, pdAppearanceContentStream.nonStrokingColorSpaceStack.size());
  }
}
