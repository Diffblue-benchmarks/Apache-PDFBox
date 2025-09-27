package org.apache.pdfbox.tools.imageio;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImageIOUtilDiffblueTest {
  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int)} with {@code
   * image}, {@code formatName}, {@code output}, {@code dpi}.
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream, int) with 'image', 'formatName', 'output', 'dpi'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream, int)"})
  void testWriteImageWithImageFormatNameOutputDpi() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "tif", output, 19088743);

    // Assert
    assertEquals(187, output.toByteArray().length);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int)} with {@code
   * image}, {@code formatName}, {@code output}, {@code dpi}.
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream, int) with 'image', 'formatName', 'output', 'dpi'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream, int)"})
  void testWriteImageWithImageFormatNameOutputDpi2() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "jpeg", output, 1);

    // Assert
    assertEquals(633, output.toByteArray().length);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int)} with {@code
   * image}, {@code formatName}, {@code output}, {@code dpi}.
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream, int) with 'image', 'formatName', 'output', 'dpi'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream, int)"})
  void testWriteImageWithImageFormatNameOutputDpi3() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "jpg", output, 1);

    // Assert
    assertEquals(633, output.toByteArray().length);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float)} with
   * {@code image}, {@code formatName}, {@code output}, {@code dpi}, {@code compressionQuality}.
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int,
   * float)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream, int, float) with 'image', 'formatName', 'output', 'dpi', 'compressionQuality'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream, int, float)"
  })
  void testWriteImageWithImageFormatNameOutputDpiCompressionQuality() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "tif", output, 19088743, 10.0f);

    // Assert
    assertEquals(208, output.toByteArray().length);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float)} with
   * {@code image}, {@code formatName}, {@code output}, {@code dpi}, {@code compressionQuality}.
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int,
   * float)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream, int, float) with 'image', 'formatName', 'output', 'dpi', 'compressionQuality'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream, int, float)"
  })
  void testWriteImageWithImageFormatNameOutputDpiCompressionQuality2() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "png", output, 19088743, 0.0f);

    // Assert
    assertEquals(90, output.toByteArray().length);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float)} with
   * {@code image}, {@code formatName}, {@code output}, {@code dpi}, {@code compressionQuality}.
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int,
   * float)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream, int, float) with 'image', 'formatName', 'output', 'dpi', 'compressionQuality'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream, int, float)"
  })
  void testWriteImageWithImageFormatNameOutputDpiCompressionQuality3() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "tif", output, 19088743, 10.0f);

    // Assert
    assertEquals(187, output.toByteArray().length);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float)} with
   * {@code image}, {@code formatName}, {@code output}, {@code dpi}, {@code compressionQuality}.
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int,
   * float)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream, int, float) with 'image', 'formatName', 'output', 'dpi', 'compressionQuality'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream, int, float)"
  })
  void testWriteImageWithImageFormatNameOutputDpiCompressionQuality4() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "jpeg", output, 1, 0.0f);

    // Assert
    assertEquals(630, output.toByteArray().length);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float)} with
   * {@code image}, {@code formatName}, {@code output}, {@code dpi}, {@code compressionQuality}.
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int,
   * float)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream, int, float) with 'image', 'formatName', 'output', 'dpi', 'compressionQuality'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream, int, float)"
  })
  void testWriteImageWithImageFormatNameOutputDpiCompressionQuality5() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "jpg", output, 1, 0.0f);

    // Assert
    assertEquals(630, output.toByteArray().length);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float, String)}
   * with {@code image}, {@code formatName}, {@code output}, {@code dpi}, {@code
   * compressionQuality}, {@code compressionType}.
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int,
   * float, String)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream, int, float, String) with 'image', 'formatName', 'output', 'dpi', 'compressionQuality', 'compressionType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream, int, float, String)"
  })
  void testWriteImageWithImageFormatNameOutputDpiCompressionQualityCompressionType()
      throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    boolean actualWriteImageResult =
        ImageIOUtil.writeImage(image, "Format Name", output, 19088743, 10.0f, "Compression Type");

    // Assert
    assertFalse(actualWriteImageResult);
    assertArrayEquals(new byte[] {}, output.toByteArray());
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float, String)}
   * with {@code image}, {@code formatName}, {@code output}, {@code dpi}, {@code
   * compressionQuality}, {@code compressionType}.
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int,
   * float, String)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream, int, float, String) with 'image', 'formatName', 'output', 'dpi', 'compressionQuality', 'compressionType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream, int, float, String)"
  })
  void testWriteImageWithImageFormatNameOutputDpiCompressionQualityCompressionType2()
      throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "png", output, 19088743, 0.0f, "Compression Type");

    // Assert
    assertEquals(90, output.toByteArray().length);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float, String)}
   * with {@code image}, {@code formatName}, {@code output}, {@code dpi}, {@code
   * compressionQuality}, {@code compressionType}.
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int,
   * float, String)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream, int, float, String) with 'image', 'formatName', 'output', 'dpi', 'compressionQuality', 'compressionType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream, int, float, String)"
  })
  void testWriteImageWithImageFormatNameOutputDpiCompressionQualityCompressionType3()
      throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "tif", output, 19088743, 10.0f, "");

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) 16, toByteArrayResult[207]);
    assertEquals(208, toByteArrayResult.length);
    assertEquals(Byte.MIN_VALUE, toByteArrayResult[203]);
    assertEquals(' ', toByteArrayResult[205]);
    assertEquals('P', toByteArrayResult[206]);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float, String)}
   * with {@code image}, {@code formatName}, {@code output}, {@code dpi}, {@code
   * compressionQuality}, {@code compressionType}.
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int,
   * float, String)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream, int, float, String) with 'image', 'formatName', 'output', 'dpi', 'compressionQuality', 'compressionType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream, int, float, String)"
  })
  void testWriteImageWithImageFormatNameOutputDpiCompressionQualityCompressionType4()
      throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "tif", output, 19088743, 10.0f, null);

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) 0, toByteArrayResult[203]);
    assertEquals((byte) 0, toByteArrayResult[205]);
    assertEquals(206, toByteArrayResult.length);
    assertEquals('#', toByteArrayResult[181]);
    assertEquals('E', toByteArrayResult[182]);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float, String)}
   * with {@code image}, {@code formatName}, {@code output}, {@code dpi}, {@code
   * compressionQuality}, {@code compressionType}.
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int,
   * float, String)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream, int, float, String) with 'image', 'formatName', 'output', 'dpi', 'compressionQuality', 'compressionType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream, int, float, String)"
  })
  void testWriteImageWithImageFormatNameOutputDpiCompressionQualityCompressionType5()
      throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "tif", output, 19088743, 10.0f, "");

    // Assert
    assertEquals(187, output.toByteArray().length);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float, String)}
   * with {@code image}, {@code formatName}, {@code output}, {@code dpi}, {@code
   * compressionQuality}, {@code compressionType}.
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int,
   * float, String)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream, int, float, String) with 'image', 'formatName', 'output', 'dpi', 'compressionQuality', 'compressionType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream, int, float, String)"
  })
  void testWriteImageWithImageFormatNameOutputDpiCompressionQualityCompressionType6()
      throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "jpeg", output, 1, 0.0f, "Compression Type");

    // Assert
    assertEquals(630, output.toByteArray().length);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float, String)}
   * with {@code image}, {@code formatName}, {@code output}, {@code dpi}, {@code
   * compressionQuality}, {@code compressionType}.
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int,
   * float, String)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream, int, float, String) with 'image', 'formatName', 'output', 'dpi', 'compressionQuality', 'compressionType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream, int, float, String)"
  })
  void testWriteImageWithImageFormatNameOutputDpiCompressionQualityCompressionType7()
      throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "jpg", output, 1, 0.0f, "Compression Type");

    // Assert
    assertEquals(630, output.toByteArray().length);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int, float)} with
   * {@code image}, {@code formatName}, {@code output}, {@code dpi}, {@code compressionQuality}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int,
   * float)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream, int, float) with 'image', 'formatName', 'output', 'dpi', 'compressionQuality'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream, int, float)"
  })
  void testWriteImageWithImageFormatNameOutputDpiCompressionQuality_thenReturnFalse()
      throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    boolean actualWriteImageResult =
        ImageIOUtil.writeImage(image, "Format Name", output, 19088743, 10.0f);

    // Assert
    assertFalse(actualWriteImageResult);
    assertArrayEquals(new byte[] {}, output.toByteArray());
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int)} with {@code
   * image}, {@code formatName}, {@code output}, {@code dpi}.
   *
   * <ul>
   *   <li>Then array length is two hundred eight.
   * </ul>
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream, int) with 'image', 'formatName', 'output', 'dpi'; then array length is two hundred eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream, int)"})
  void testWriteImageWithImageFormatNameOutputDpi_thenArrayLengthIsTwoHundredEight()
      throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "tif", output, 19088743);

    // Assert
    assertEquals(208, output.toByteArray().length);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int)} with {@code
   * image}, {@code formatName}, {@code output}, {@code dpi}.
   *
   * <ul>
   *   <li>When {@code Format Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream, int) with 'image', 'formatName', 'output', 'dpi'; when 'Format Name'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream, int)"})
  void testWriteImageWithImageFormatNameOutputDpi_whenFormatName_thenReturnFalse()
      throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "Format Name", output, 19088743);

    // Assert
    assertFalse(actualWriteImageResult);
    assertArrayEquals(new byte[] {}, output.toByteArray());
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int)} with {@code
   * image}, {@code formatName}, {@code output}, {@code dpi}.
   *
   * <ul>
   *   <li>When {@code png}.
   *   <li>Then array length is ninety.
   * </ul>
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream, int)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream, int) with 'image', 'formatName', 'output', 'dpi'; when 'png'; then array length is ninety")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream, int)"})
  void testWriteImageWithImageFormatNameOutputDpi_whenPng_thenArrayLengthIsNinety()
      throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "png", output, 19088743);

    // Assert
    assertEquals(90, output.toByteArray().length);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)} with {@code image},
   * {@code formatName}, {@code output}.
   *
   * <ul>
   *   <li>Then array length is one hundred ninety.
   * </ul>
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream) with 'image', 'formatName', 'output'; then array length is one hundred ninety")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream)"})
  void testWriteImageWithImageFormatNameOutput_thenArrayLengthIsOneHundredNinety()
      throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(72, 1, BufferedImage.TYPE_BYTE_BINARY);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "tif", output);

    // Assert
    assertEquals(190, output.toByteArray().length);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)} with {@code image},
   * {@code formatName}, {@code output}.
   *
   * <ul>
   *   <li>Then array length is six hundred thirty-three.
   * </ul>
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream) with 'image', 'formatName', 'output'; then array length is six hundred thirty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream)"})
  void testWriteImageWithImageFormatNameOutput_thenArrayLengthIsSixHundredThirtyThree()
      throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "jpeg", output);

    // Assert
    assertEquals(633, output.toByteArray().length);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)} with {@code image},
   * {@code formatName}, {@code output}.
   *
   * <ul>
   *   <li>Then array length is two hundred twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream) with 'image', 'formatName', 'output'; then array length is two hundred twenty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream)"})
  void testWriteImageWithImageFormatNameOutput_thenArrayLengthIsTwoHundredTwentyNine()
      throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(72, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "tif", output);

    // Assert
    assertEquals(229, output.toByteArray().length);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)} with {@code image},
   * {@code formatName}, {@code output}.
   *
   * <ul>
   *   <li>Then one hundred eighty-fifth element is zero.
   * </ul>
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream) with 'image', 'formatName', 'output'; then one hundred eighty-fifth element is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream)"})
  void testWriteImageWithImageFormatNameOutput_thenOneHundredEightyFifthElementIsZero()
      throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "tif", output);

    // Assert
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals((byte) 0, toByteArrayResult[184]);
    assertEquals((byte) 0, toByteArrayResult[185]);
    assertEquals((byte) 0, toByteArrayResult[186]);
    assertEquals((byte) 0, toByteArrayResult[189]);
    assertEquals((byte) 0, toByteArrayResult[190]);
    assertEquals((byte) 0, toByteArrayResult[192]);
    assertEquals((byte) 0, toByteArrayResult[193]);
    assertEquals((byte) 0, toByteArrayResult[194]);
    assertEquals((byte) 0, toByteArrayResult[202]);
    assertEquals((byte) 16, toByteArrayResult[207]);
    assertEquals((byte) 1, toByteArrayResult[187]);
    assertEquals((byte) 1, toByteArrayResult[195]);
    assertEquals(208, toByteArrayResult.length);
    assertEquals(Byte.MIN_VALUE, toByteArrayResult[203]);
    assertEquals('B', toByteArrayResult[199]);
    assertEquals('D', toByteArrayResult[197]);
    assertEquals('F', toByteArrayResult[198]);
    assertEquals('H', toByteArrayResult[183]);
    assertEquals('H', toByteArrayResult[191]);
    assertEquals('O', toByteArrayResult[200]);
    assertEquals('P', toByteArrayResult[196]);
    assertEquals('X', toByteArrayResult[201]);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)} with {@code image},
   * {@code formatName}, {@code output}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream) with 'image', 'formatName', 'output'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream)"})
  void testWriteImageWithImageFormatNameOutput_thenReturnFalse() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(72, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "Format Name", output);

    // Assert
    assertFalse(actualWriteImageResult);
    assertArrayEquals(new byte[] {}, output.toByteArray());
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)} with {@code image},
   * {@code formatName}, {@code output}.
   *
   * <ul>
   *   <li>When {@code Format Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream) with 'image', 'formatName', 'output'; when 'Format Name'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream)"})
  void testWriteImageWithImageFormatNameOutput_whenFormatName_thenReturnFalse() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    boolean actualWriteImageResult = ImageIOUtil.writeImage(image, "Format Name", output);

    // Assert
    assertFalse(actualWriteImageResult);
    assertArrayEquals(new byte[] {}, output.toByteArray());
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)} with {@code image},
   * {@code formatName}, {@code output}.
   *
   * <ul>
   *   <li>When {@code jpg}.
   * </ul>
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream) with 'image', 'formatName', 'output'; when 'jpg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream)"})
  void testWriteImageWithImageFormatNameOutput_whenJpg() throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "jpg", output);

    // Assert
    assertEquals(633, output.toByteArray().length);
  }

  /**
   * Test {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)} with {@code image},
   * {@code formatName}, {@code output}.
   *
   * <ul>
   *   <li>When {@code png}.
   *   <li>Then array length is ninety.
   * </ul>
   *
   * <p>Method under test: {@link ImageIOUtil#writeImage(BufferedImage, String, OutputStream)}
   */
  @Test
  @DisplayName(
      "Test writeImage(BufferedImage, String, OutputStream) with 'image', 'formatName', 'output'; when 'png'; then array length is ninety")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageIOUtil.writeImage(BufferedImage, String, OutputStream)"})
  void testWriteImageWithImageFormatNameOutput_whenPng_thenArrayLengthIsNinety()
      throws IOException {
    // Arrange
    BufferedImage image = new BufferedImage(1, 1, 1);
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    ImageIOUtil.writeImage(image, "png", output);

    // Assert
    assertEquals(90, output.toByteArray().length);
  }
}
