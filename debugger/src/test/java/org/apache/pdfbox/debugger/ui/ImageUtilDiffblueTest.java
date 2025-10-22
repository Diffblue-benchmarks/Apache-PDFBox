package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImageUtilDiffblueTest {
  /**
   * Test {@link ImageUtil#getRotatedImage(BufferedImage, int)}.
   * <ul>
   *   <li>When ninety.</li>
   *   <li>Then ColorModel return {@link DirectColorModel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtil#getRotatedImage(BufferedImage, int)}
   */
  @Test
  @DisplayName("Test getRotatedImage(BufferedImage, int); when ninety; then ColorModel return DirectColorModel")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage ImageUtil.getRotatedImage(BufferedImage, int)"})
  void testGetRotatedImage_whenNinety_thenColorModelReturnDirectColorModel() {
    // Arrange and Act
    BufferedImage actualRotatedImage = ImageUtil.getRotatedImage(new BufferedImage(1, 1, 1), 90);

    // Assert
    ColorModel colorModel = actualRotatedImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRotatedImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRotatedImage.getData().getSampleModel());
    assertSame(sampleModel, actualRotatedImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link ImageUtil#getRotatedImage(BufferedImage, int)}.
   * <ul>
   *   <li>When one hundred eighty.</li>
   *   <li>Then ColorModel return {@link DirectColorModel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtil#getRotatedImage(BufferedImage, int)}
   */
  @Test
  @DisplayName("Test getRotatedImage(BufferedImage, int); when one hundred eighty; then ColorModel return DirectColorModel")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage ImageUtil.getRotatedImage(BufferedImage, int)"})
  void testGetRotatedImage_whenOneHundredEighty_thenColorModelReturnDirectColorModel() {
    // Arrange and Act
    BufferedImage actualRotatedImage = ImageUtil.getRotatedImage(new BufferedImage(1, 1, 1), 180);

    // Assert
    ColorModel colorModel = actualRotatedImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRotatedImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRotatedImage.getData().getSampleModel());
    assertSame(sampleModel, actualRotatedImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link ImageUtil#getRotatedImage(BufferedImage, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtil#getRotatedImage(BufferedImage, int)}
   */
  @Test
  @DisplayName("Test getRotatedImage(BufferedImage, int); when one; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage ImageUtil.getRotatedImage(BufferedImage, int)"})
  void testGetRotatedImage_whenOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ImageUtil.getRotatedImage(new BufferedImage(1, 1, 1), 1));
  }

  /**
   * Test {@link ImageUtil#getRotatedImage(BufferedImage, int)}.
   * <ul>
   *   <li>When three hundred sixty.</li>
   *   <li>Then ColorModel return {@link DirectColorModel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtil#getRotatedImage(BufferedImage, int)}
   */
  @Test
  @DisplayName("Test getRotatedImage(BufferedImage, int); when three hundred sixty; then ColorModel return DirectColorModel")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage ImageUtil.getRotatedImage(BufferedImage, int)"})
  void testGetRotatedImage_whenThreeHundredSixty_thenColorModelReturnDirectColorModel() {
    // Arrange and Act
    BufferedImage actualRotatedImage = ImageUtil.getRotatedImage(new BufferedImage(1, 1, 1), 360);

    // Assert
    ColorModel colorModel = actualRotatedImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRotatedImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRotatedImage.getData().getSampleModel());
    assertSame(sampleModel, actualRotatedImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link ImageUtil#getRotatedImage(BufferedImage, int)}.
   * <ul>
   *   <li>When two hundred seventy.</li>
   *   <li>Then ColorModel return {@link DirectColorModel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtil#getRotatedImage(BufferedImage, int)}
   */
  @Test
  @DisplayName("Test getRotatedImage(BufferedImage, int); when two hundred seventy; then ColorModel return DirectColorModel")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage ImageUtil.getRotatedImage(BufferedImage, int)"})
  void testGetRotatedImage_whenTwoHundredSeventy_thenColorModelReturnDirectColorModel() {
    // Arrange and Act
    BufferedImage actualRotatedImage = ImageUtil.getRotatedImage(new BufferedImage(1, 1, 1), 270);

    // Assert
    ColorModel colorModel = actualRotatedImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRotatedImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRotatedImage.getData().getSampleModel());
    assertSame(sampleModel, actualRotatedImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }
}
