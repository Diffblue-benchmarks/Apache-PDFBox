package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * <p>
   * Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getStencilImage(PDImage, Paint)"})
  void testGetStencilImage() throws IOException, NumberFormatException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1,
        PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualStencilImage = SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    ColorModel colorModel = actualStencilImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0, 24}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   * <p>
   * Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getStencilImage(PDImage, Paint)"})
  void testGetStencilImage2() throws IOException, NumberFormatException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1, 1,
        PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualStencilImage = SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    ColorModel colorModel = actualStencilImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0, 24}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   * <p>
   * Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getStencilImage(PDImage, Paint)"})
  void testGetStencilImage3() throws IOException, NumberFormatException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1,
        PDDeviceRGB.INSTANCE);

    // Act
    BufferedImage actualStencilImage = SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

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
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0, 24}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   * <p>
   * Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getStencilImage(PDImage, Paint)"})
  void testGetStencilImage4() throws IOException, NumberFormatException {
    // Arrange
    PDDocument document = new PDDocument();
    byte[] byteArray = "AXAXAXAX".getBytes("UTF-8");
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, byteArray, 1, 1, 1, new PDCalGray());

    // Act
    BufferedImage actualStencilImage = SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

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
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0, 24}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   * <p>
   * Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getStencilImage(PDImage, Paint)"})
  void testGetStencilImage5() throws IOException, NumberFormatException {
    // Arrange
    PDDocument document = new PDDocument();
    byte[] byteArray = "AXAXAXAX".getBytes("UTF-8");
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, byteArray, 1, 1, 1, new PDCalRGB());

    // Act
    BufferedImage actualStencilImage = SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

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
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0, 24}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   * <ul>
   *   <li>Then return TileWidth is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint); then return TileWidth is eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getStencilImage(PDImage, Paint)"})
  void testGetStencilImage_thenReturnTileWidthIsEight() throws IOException, NumberFormatException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, "AXAXAXAX".getBytes("UTF-8"), 8, 1, 1,
        PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualStencilImage = SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    assertTrue(actualStencilImage.getColorModel() instanceof DirectColorModel);
    assertTrue(actualStencilImage.getSampleModel() instanceof SinglePixelPackedSampleModel);
    assertEquals(1, actualStencilImage.getWritableTileIndices().length);
    assertEquals(8, actualStencilImage.getTileWidth());
    assertEquals(8, actualStencilImage.getWidth());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   * <ul>
   *   <li>Then return TileWidth is nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint); then return TileWidth is nine")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getStencilImage(PDImage, Paint)"})
  void testGetStencilImage_thenReturnTileWidthIsNine() throws IOException, NumberFormatException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, "AXAXAXAX".getBytes("UTF-8"), 9, 1, 1,
        PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualStencilImage = SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    assertTrue(actualStencilImage.getColorModel() instanceof DirectColorModel);
    assertTrue(actualStencilImage.getSampleModel() instanceof SinglePixelPackedSampleModel);
    assertEquals(1, actualStencilImage.getWritableTileIndices().length);
    assertEquals(9, actualStencilImage.getTileWidth());
    assertEquals(9, actualStencilImage.getWidth());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   * <ul>
   *   <li>Then return TileWidth is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint); then return TileWidth is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getStencilImage(PDImage, Paint)"})
  void testGetStencilImage_thenReturnTileWidthIsTwo() throws IOException, NumberFormatException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, "AXAXAXAX".getBytes("UTF-8"), 2, 1, 1,
        PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualStencilImage = SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    assertTrue(actualStencilImage.getColorModel() instanceof DirectColorModel);
    assertTrue(actualStencilImage.getSampleModel() instanceof SinglePixelPackedSampleModel);
    assertEquals(1, actualStencilImage.getWritableTileIndices().length);
    assertEquals(2, actualStencilImage.getTileWidth());
    assertEquals(2, actualStencilImage.getWidth());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   * <ul>
   *   <li>When {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint); when 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getStencilImage(PDImage, Paint)"})
  void testGetStencilImage_whenA() throws IOException, NumberFormatException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualStencilImage = SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    ColorModel colorModel = actualStencilImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0, 24}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey2() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 8, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey3() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, -1, 1, 1, PDDeviceGray.INSTANCE);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey4() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, -1, 1, PDDeviceGray.INSTANCE);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey5() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 12, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey6() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, -1, PDDeviceGray.INSTANCE);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey7() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceRGB.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey8() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        1, 1, 1, new PDCalGray());

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey9() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        1, 1, 1, new PDCalRGB());

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey10() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        8, 1, 1, new PDCalGray());

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey11() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        8, 1, 1, new PDCalRGB());

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code colorKey}.
   * <ul>
   *   <li>Then Data DataBuffer return {@link DataBufferByte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'; then Data DataBuffer return DataBufferByte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey_thenDataDataBufferReturnDataBufferByte() throws IOException {
    // Arrange and Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceGray.INSTANCE), null);

    // Assert
    DataBuffer dataBuffer = actualRGBImage.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = actualRGBImage.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertArrayEquals(new byte[]{0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new byte[]{0}, ((DataBufferByte) dataBuffer2).getData());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[]{8}, actualRGBImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code colorKey}.
   * <ul>
   *   <li>Then Data DataBuffer return {@link DataBufferByte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'; then Data DataBuffer return DataBufferByte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey_thenDataDataBufferReturnDataBufferByte2() throws IOException {
    // Arrange and Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(
        LosslessFactory.prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1, 1, PDDeviceGray.INSTANCE), null);

    // Assert
    DataBuffer dataBuffer = actualRGBImage.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = actualRGBImage.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertArrayEquals(new byte[]{0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new byte[]{0}, ((DataBufferByte) dataBuffer2).getData());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[]{8}, actualRGBImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code colorKey}.
   * <ul>
   *   <li>Then return SampleModel ScanlineStride is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'; then return SampleModel ScanlineStride is eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey_thenReturnSampleModelScanlineStrideIsEight() throws IOException {
    // Arrange and Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 8, 1, 1, PDDeviceGray.INSTANCE), null);

    // Assert
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertEquals(8, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{8}, actualRGBImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with {@code pdImage}, {@code colorKey}.
   * <ul>
   *   <li>When createThumbnail {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'; when createThumbnail COSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, COSArray)"})
  void testGetRGBImageWithPdImageColorKey_whenCreateThumbnailCOSStream() throws IOException {
    // Arrange
    PDImageXObject pdImage = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"})
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceGray.INSTANCE);
    Rectangle region = new Rectangle(1, 1);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"})
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey2() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 8, 1, 1, PDDeviceGray.INSTANCE);
    Rectangle region = new Rectangle(1, 1);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"})
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey3() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, -1, 1, 1, PDDeviceGray.INSTANCE);
    Rectangle region = new Rectangle(1, 1);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"})
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey4() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, -1, 1, PDDeviceGray.INSTANCE);
    Rectangle region = new Rectangle(1, 1);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"})
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey5() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 12, PDDeviceGray.INSTANCE);
    Rectangle region = new Rectangle(1, 1);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"})
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey6() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, -1, PDDeviceGray.INSTANCE);
    Rectangle region = new Rectangle(1, 1);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"})
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey7() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceRGB.INSTANCE);
    Rectangle region = new Rectangle(1, 1);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"})
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey8() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        1, 1, 1, new PDCalGray());
    Rectangle region = new Rectangle(1, 1);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"})
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey9() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        1, 1, 1, new PDCalRGB());
    Rectangle region = new Rectangle(1, 1);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"})
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey10() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, null, 1, new COSArray());

    // Assert
    ColorModel colorModel = actualRGBImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualRGBImage.getData().getSampleModel());
    assertSame(sampleModel, actualRGBImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"})
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey11() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new Rectangle(1, 1), 1, null);

    // Assert
    DataBuffer dataBuffer = actualRGBImage.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = actualRGBImage.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertArrayEquals(new byte[]{0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new byte[]{0}, ((DataBufferByte) dataBuffer2).getData());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[]{8}, actualRGBImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"})
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey12() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1, 1,
        PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new Rectangle(1, 1), 1, null);

    // Assert
    DataBuffer dataBuffer = actualRGBImage.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = actualRGBImage.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertArrayEquals(new byte[]{0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new byte[]{0}, ((DataBufferByte) dataBuffer2).getData());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[]{8}, actualRGBImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <ul>
   *   <li>When createThumbnail {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'; when createThumbnail COSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"})
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey_whenCreateThumbnailCOSStream() throws IOException {
    // Arrange
    PDImageXObject pdImage = PDImageXObject.createThumbnail(new COSStream());
    Rectangle region = new Rectangle(1, 1);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)} with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <ul>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'; when zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage SampledImageReader.getRGBImage(PDImage, Rectangle, int, COSArray)"})
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey_whenZero() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceGray.INSTANCE);
    Rectangle region = new Rectangle(1, 1);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, region, 0, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   * <p>
   * Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WritableRaster SampledImageReader.getRawRaster(PDImage)"})
  void testGetRawRaster() throws IOException {
    // Arrange and Act
    WritableRaster actualRawRaster = SampledImageReader.getRawRaster(LosslessFactory.prepareImageXObject(
        new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceGray.INSTANCE));

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
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new byte[]{0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   * <p>
   * Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WritableRaster SampledImageReader.getRawRaster(PDImage)"})
  void testGetRawRaster2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> SampledImageReader.getRawRaster(LosslessFactory.prepareImageXObject(new PDDocument(),
            new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, -1, 1, 1, PDDeviceGray.INSTANCE)));
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   * <p>
   * Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WritableRaster SampledImageReader.getRawRaster(PDImage)"})
  void testGetRawRaster3() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> SampledImageReader.getRawRaster(LosslessFactory.prepareImageXObject(new PDDocument(),
            new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, -1, 1, PDDeviceGray.INSTANCE)));
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   * <p>
   * Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WritableRaster SampledImageReader.getRawRaster(PDImage)"})
  void testGetRawRaster4() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> SampledImageReader.getRawRaster(LosslessFactory.prepareImageXObject(new PDDocument(),
            new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, -1, PDDeviceGray.INSTANCE)));
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   * <p>
   * Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WritableRaster SampledImageReader.getRawRaster(PDImage)"})
  void testGetRawRaster5() throws IOException {
    // Arrange and Act
    WritableRaster actualRawRaster = SampledImageReader.getRawRaster(LosslessFactory.prepareImageXObject(
        new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceRGB.INSTANCE));

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
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new byte[]{0, -1, 0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0, 0, 0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0, 1, 2}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   * <p>
   * Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WritableRaster SampledImageReader.getRawRaster(PDImage)"})
  void testGetRawRaster6() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    WritableRaster actualRawRaster = SampledImageReader.getRawRaster(LosslessFactory.prepareImageXObject(document,
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalGray()));

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
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new byte[]{0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   * <p>
   * Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WritableRaster SampledImageReader.getRawRaster(PDImage)"})
  void testGetRawRaster7() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    WritableRaster actualRawRaster = SampledImageReader.getRawRaster(LosslessFactory.prepareImageXObject(document,
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalRGB()));

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
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new byte[]{0, -1, 0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0, 0, 0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0, 1, 2}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   * <ul>
   *   <li>Then DataBuffer return {@link DataBufferUShort}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage); then DataBuffer return DataBufferUShort")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WritableRaster SampledImageReader.getRawRaster(PDImage)"})
  void testGetRawRaster_thenDataBufferReturnDataBufferUShort() throws IOException {
    // Arrange and Act
    WritableRaster actualRawRaster = SampledImageReader.getRawRaster(LosslessFactory.prepareImageXObject(
        new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 12, PDDeviceGray.INSTANCE));

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
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{Short.SIZE}, sampleModel.getSampleSize());
    assertArrayEquals(new short[]{16644}, ((DataBufferUShort) dataBuffer).getData());
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   * <ul>
   *   <li>Then return Bounds CenterX is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage); then return Bounds CenterX is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WritableRaster SampledImageReader.getRawRaster(PDImage)"})
  void testGetRawRaster_thenReturnBoundsCenterXIsFour() throws IOException {
    // Arrange and Act
    WritableRaster actualRawRaster = SampledImageReader.getRawRaster(LosslessFactory.prepareImageXObject(
        new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 8, 1, 1, PDDeviceGray.INSTANCE));

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
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new byte[]{0, -1, 0, 0, 0, 0, 0, -1}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   * <ul>
   *   <li>When createThumbnail {@link COSStream#COSStream()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage); when createThumbnail COSStream(); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WritableRaster SampledImageReader.getRawRaster(PDImage)"})
  void testGetRawRaster_whenCreateThumbnailCOSStream_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> SampledImageReader.getRawRaster(PDImageXObject.createThumbnail(new COSStream())));
  }
}
