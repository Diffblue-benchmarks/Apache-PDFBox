package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferUShort;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SampledImageReaderDiffblueTest {
  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   *
   * <p>Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getStencilImage(PDImage, Paint)"})
  void testGetStencilImage() throws IOException, NumberFormatException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(), "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualStencilImage =
        SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    ColorModel colorModel = actualStencilImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    WritableRaster raster = actualStencilImage.getRaster();
    WritableRaster alphaRaster = actualStencilImage.getAlphaRaster();
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    assertSame(sampleModel, actualStencilImage.getData().getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0, 24},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   *
   * <p>Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getStencilImage(PDImage, Paint)"})
  void testGetStencilImage2() throws IOException, NumberFormatException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(), new byte[] {}, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualStencilImage =
        SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    ColorModel colorModel = actualStencilImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    WritableRaster raster = actualStencilImage.getRaster();
    WritableRaster alphaRaster = actualStencilImage.getAlphaRaster();
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    assertSame(sampleModel, actualStencilImage.getData().getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0, 24},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   *
   * <p>Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getStencilImage(PDImage, Paint)"})
  void testGetStencilImage3() throws IOException, NumberFormatException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(), "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1, PDDeviceRGB.INSTANCE);

    // Act
    BufferedImage actualStencilImage =
        SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    ColorModel colorModel = actualStencilImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    WritableRaster raster = actualStencilImage.getRaster();
    WritableRaster alphaRaster = actualStencilImage.getAlphaRaster();
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    assertSame(sampleModel, actualStencilImage.getData().getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0, 24},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   *
   * <p>Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getStencilImage(PDImage, Paint)"})
  void testGetStencilImage4() throws IOException, NumberFormatException {
    // Arrange
    PDDocument document = new PDDocument();
    byte[] byteArray = "AXAXAXAX".getBytes("UTF-8");

    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(document, byteArray, 1, 1, 1, new PDCalGray());

    // Act
    BufferedImage actualStencilImage =
        SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    ColorModel colorModel = actualStencilImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    WritableRaster raster = actualStencilImage.getRaster();
    WritableRaster alphaRaster = actualStencilImage.getAlphaRaster();
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    assertSame(sampleModel, actualStencilImage.getData().getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0, 24},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   *
   * <p>Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getStencilImage(PDImage, Paint)"})
  void testGetStencilImage5() throws IOException, NumberFormatException {
    // Arrange
    PDDocument document = new PDDocument();
    byte[] byteArray = "AXAXAXAX".getBytes("UTF-8");

    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(document, byteArray, 1, 1, 1, new PDCalRGB());

    // Act
    BufferedImage actualStencilImage =
        SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    ColorModel colorModel = actualStencilImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    WritableRaster raster = actualStencilImage.getRaster();
    WritableRaster alphaRaster = actualStencilImage.getAlphaRaster();
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    assertSame(sampleModel, actualStencilImage.getData().getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0, 24},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   *
   * <ul>
   *   <li>Then return TileWidth is eight.
   * </ul>
   *
   * <p>Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint); then return TileWidth is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getStencilImage(PDImage, Paint)"})
  void testGetStencilImage_thenReturnTileWidthIsEight() throws IOException, NumberFormatException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(), "AXAXAXAX".getBytes("UTF-8"), 8, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualStencilImage =
        SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    assertTrue(actualStencilImage.getColorModel() instanceof DirectColorModel);
    assertTrue(actualStencilImage.getSampleModel() instanceof SinglePixelPackedSampleModel);
    assertEquals(1, actualStencilImage.getWritableTileIndices().length);
    assertEquals(8, actualStencilImage.getTileWidth());
    assertEquals(8, actualStencilImage.getWidth());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   *
   * <ul>
   *   <li>Then return TileWidth is nine.
   * </ul>
   *
   * <p>Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint); then return TileWidth is nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getStencilImage(PDImage, Paint)"})
  void testGetStencilImage_thenReturnTileWidthIsNine() throws IOException, NumberFormatException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(), "AXAXAXAX".getBytes("UTF-8"), 9, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualStencilImage =
        SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    assertTrue(actualStencilImage.getColorModel() instanceof DirectColorModel);
    assertTrue(actualStencilImage.getSampleModel() instanceof SinglePixelPackedSampleModel);
    assertEquals(1, actualStencilImage.getWritableTileIndices().length);
    assertEquals(9, actualStencilImage.getTileWidth());
    assertEquals(9, actualStencilImage.getWidth());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   *
   * <ul>
   *   <li>Then return TileWidth is two.
   * </ul>
   *
   * <p>Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint); then return TileWidth is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getStencilImage(PDImage, Paint)"})
  void testGetStencilImage_thenReturnTileWidthIsTwo() throws IOException, NumberFormatException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(), "AXAXAXAX".getBytes("UTF-8"), 2, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualStencilImage =
        SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    assertTrue(actualStencilImage.getColorModel() instanceof DirectColorModel);
    assertTrue(actualStencilImage.getSampleModel() instanceof SinglePixelPackedSampleModel);
    assertEquals(1, actualStencilImage.getWritableTileIndices().length);
    assertEquals(2, actualStencilImage.getTileWidth());
    assertEquals(2, actualStencilImage.getWidth());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return AlphaRaster Parent is Raster.
   * </ul>
   *
   * <p>Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName(
      "Test getStencilImage(PDImage, Paint); when 'A'; then return AlphaRaster Parent is Raster")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getStencilImage(PDImage, Paint)"})
  void testGetStencilImage_whenA_thenReturnAlphaRasterParentIsRaster()
      throws IOException, NumberFormatException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            1,
            1,
            1,
            PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualStencilImage =
        SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    ColorModel colorModel = actualStencilImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    WritableRaster raster = actualStencilImage.getRaster();
    WritableRaster alphaRaster = actualStencilImage.getAlphaRaster();
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    assertSame(sampleModel, actualStencilImage.getData().getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0, 24},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code
   * colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            1,
            1,
            PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code
   * colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey2() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            1,
            1,
            PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, null);

    // Assert
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[] {8}, actualRGBImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[] {8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code
   * colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey3() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(), new byte[] {}, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, null);

    // Assert
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[] {8}, actualRGBImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[] {8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code
   * colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey4() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            8,
            1,
            1,
            PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code
   * colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey5() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            -1,
            1,
            1,
            PDDeviceGray.INSTANCE);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code
   * colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey6() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            -1,
            1,
            PDDeviceGray.INSTANCE);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code
   * colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey7() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            1,
            12,
            PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code
   * colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey8() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            1,
            -1,
            PDDeviceGray.INSTANCE);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code
   * colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey9() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            1,
            12,
            PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, null);

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code
   * colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey10() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            1,
            1,
            PDDeviceRGB.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code
   * colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey11() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            document, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalGray());

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code
   * colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey12() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            document, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalRGB());

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code
   * colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey13() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            1,
            1,
            PDDeviceRGB.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, null);

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code
   * colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey14() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            document, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalGray());

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, null);

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code
   * colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey15() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(), new byte[] {}, 1, 1, 8, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, null);

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code
   * colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey16() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            document, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, 8, 1, 1, new PDCalGray());

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code
   * colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey17() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            document, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, 8, 1, 1, new PDCalRGB());

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code
   * colorKey}.
   *
   * <ul>
   *   <li>Then return SampleModel ScanlineStride is eight.
   * </ul>
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName(
      "Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'; then return SampleModel ScanlineStride is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey_thenReturnSampleModelScanlineStrideIsEight()
      throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            8,
            1,
            1,
            PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, null);

    // Assert
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertEquals(8, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[] {8}, actualRGBImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[] {8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code
   * colorKey}.
   *
   * <ul>
   *   <li>When createThumbnail {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName(
      "Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'; when createThumbnail COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey_whenCreateThumbnailCOSStream() throws IOException {
    // Arrange
    PDImageXObject pdImage = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code
   * pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName(
      "Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"
  })
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            1,
            1,
            PDDeviceGray.INSTANCE);
    Rectangle region = new Rectangle();

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code
   * pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName(
      "Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"
  })
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey2() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            1,
            1,
            PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, null, 1, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code
   * pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName(
      "Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"
  })
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey3() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            1,
            1,
            PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, null, 1, null);

    // Assert
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[] {8}, actualRGBImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[] {8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code
   * pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName(
      "Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"
  })
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey4() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            1,
            1,
            PDDeviceRGB.INSTANCE);
    Rectangle region = new Rectangle();

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code
   * pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName(
      "Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"
  })
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey5() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            document, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalGray());
    Rectangle region = new Rectangle();

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code
   * pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName(
      "Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"
  })
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey6() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            document, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalRGB());
    Rectangle region = new Rectangle();

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code
   * pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName(
      "Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"
  })
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey7() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            document, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalGray());

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, null, 1, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code
   * pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName(
      "Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"
  })
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey8() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            document, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalRGB());

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, null, 1, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code
   * pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName(
      "Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"
  })
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey9() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            document, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalGray());

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, null, 1, null);

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code
   * pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName(
      "Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"
  })
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey10() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            document, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalRGB());

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, null, 1, null);

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code
   * pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName(
      "Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"
  })
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey11() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(), new byte[] {}, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, null, 1, null);

    // Assert
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[] {8}, actualRGBImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[] {8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code
   * pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName(
      "Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"
  })
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey12() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            8,
            1,
            1,
            PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, null, 1, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertEquals(8, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code
   * pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName(
      "Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"
  })
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey13() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            8,
            1,
            1,
            PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, null, 1, null);

    // Assert
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertEquals(8, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[] {8}, actualRGBImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[] {8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code
   * pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName(
      "Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"
  })
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey14() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            1,
            12,
            PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, null, 1, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code
   * pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName(
      "Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"
  })
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey15() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            1,
            -1,
            PDDeviceGray.INSTANCE);

    // Act and Assert
    assertThrows(
        IOException.class, () -> SampledImageReader.getRGBImage(pdImage, null, 1, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code
   * pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName(
      "Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'; given one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"
  })
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey_givenOne() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            1,
            1,
            PDDeviceGray.INSTANCE);

    Rectangle region = new Rectangle();
    region.add(1, 0);

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code
   * pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   *
   * <ul>
   *   <li>When createThumbnail {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName(
      "Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'; when createThumbnail COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"
  })
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey_whenCreateThumbnailCOSStream()
      throws IOException {
    // Arrange
    PDImageXObject pdImage = PDImageXObject.createThumbnail(new COSStream());
    Rectangle region = new Rectangle();

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code
   * pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName(
      "Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'; when zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"
  })
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey_whenZero() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            1,
            1,
            PDDeviceGray.INSTANCE);

    // Act and Assert
    assertThrows(
        IOException.class, () -> SampledImageReader.getRGBImage(pdImage, null, 0, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   *
   * <p>Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WritableRaster SampledImageReader.getRawRaster(PDImage)"})
  void testGetRawRaster() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            1,
            1,
            PDDeviceGray.INSTANCE);

    // Act
    WritableRaster actualRawRaster = SampledImageReader.getRawRaster(pdImage);

    // Assert
    Rectangle bounds = actualRawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new byte[] {0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   *
   * <p>Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WritableRaster SampledImageReader.getRawRaster(PDImage)"})
  void testGetRawRaster2() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            -1,
            1,
            1,
            PDDeviceGray.INSTANCE);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRawRaster(pdImage));
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   *
   * <p>Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WritableRaster SampledImageReader.getRawRaster(PDImage)"})
  void testGetRawRaster3() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            -1,
            1,
            PDDeviceGray.INSTANCE);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRawRaster(pdImage));
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   *
   * <p>Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WritableRaster SampledImageReader.getRawRaster(PDImage)"})
  void testGetRawRaster4() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            1,
            -1,
            PDDeviceGray.INSTANCE);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRawRaster(pdImage));
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   *
   * <p>Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WritableRaster SampledImageReader.getRawRaster(PDImage)"})
  void testGetRawRaster5() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            1,
            1,
            PDDeviceRGB.INSTANCE);

    // Act
    WritableRaster actualRawRaster = SampledImageReader.getRawRaster(pdImage);

    // Assert
    Rectangle bounds = actualRawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new byte[] {0, -1, 0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(
        new int[] {0, 0, 0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(
        new int[] {0, 1, 2}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   *
   * <p>Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WritableRaster SampledImageReader.getRawRaster(PDImage)"})
  void testGetRawRaster6() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            document, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalGray());

    // Act
    WritableRaster actualRawRaster = SampledImageReader.getRawRaster(pdImage);

    // Assert
    Rectangle bounds = actualRawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new byte[] {0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   *
   * <p>Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WritableRaster SampledImageReader.getRawRaster(PDImage)"})
  void testGetRawRaster7() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            document, new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalRGB());

    // Act
    WritableRaster actualRawRaster = SampledImageReader.getRawRaster(pdImage);

    // Assert
    Rectangle bounds = actualRawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new byte[] {0, -1, 0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(
        new int[] {0, 0, 0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(
        new int[] {0, 1, 2}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   *
   * <ul>
   *   <li>Then DataBuffer return {@link DataBufferUShort}.
   * </ul>
   *
   * <p>Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage); then DataBuffer return DataBufferUShort")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WritableRaster SampledImageReader.getRawRaster(PDImage)"})
  void testGetRawRaster_thenDataBufferReturnDataBufferUShort() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            1,
            12,
            PDDeviceGray.INSTANCE);

    // Act
    WritableRaster actualRawRaster = SampledImageReader.getRawRaster(pdImage);

    // Assert
    Rectangle bounds = actualRawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferUShort);
    SampleModel sampleModel = actualRawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertEquals(1, dataBuffer.getDataType());
    assertEquals(1, actualRawRaster.getTransferType());
    assertEquals(1, sampleModel.getDataType());
    assertEquals(1, sampleModel.getTransferType());
    assertEquals(1, ((DataBufferUShort) dataBuffer).getBankData().length);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {Short.SIZE}, sampleModel.getSampleSize());
    assertArrayEquals(new short[] {16644}, ((DataBufferUShort) dataBuffer).getData());
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   *
   * <ul>
   *   <li>Then return Bounds CenterX is four.
   * </ul>
   *
   * <p>Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage); then return Bounds CenterX is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WritableRaster SampledImageReader.getRawRaster(PDImage)"})
  void testGetRawRaster_thenReturnBoundsCenterXIsFour() throws IOException {
    // Arrange
    PDImageXObject pdImage =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            8,
            1,
            1,
            PDDeviceGray.INSTANCE);

    // Act
    WritableRaster actualRawRaster = SampledImageReader.getRawRaster(pdImage);

    // Assert
    Rectangle bounds = actualRawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertEquals(4.0d, bounds.getCenterX());
    assertEquals(8, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(8, dataBuffer.getSize());
    assertEquals(8, actualRawRaster.getWidth());
    assertEquals(8, sampleModel.getWidth());
    assertEquals(8, bounds.width);
    assertEquals(8.0d, bounds.getWidth());
    assertEquals(8.0d, bounds.getMaxX());
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(
        new byte[] {0, -1, 0, 0, 0, 0, 0, -1}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   *
   * <ul>
   *   <li>When createThumbnail {@link COSStream#COSStream()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName(
      "Test getRawRaster(PDImage); when createThumbnail COSStream(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WritableRaster SampledImageReader.getRawRaster(PDImage)"})
  void testGetRawRaster_whenCreateThumbnailCOSStream_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> SampledImageReader.getRawRaster(PDImageXObject.createThumbnail(new COSStream())));
  }
}
