package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.color.ICC_ProfileGray;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.DataBufferUShort;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.Raster;
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
import org.junit.jupiter.api.Test;

class SampledImageReaderDiffblueTest {
  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   * <p>
   * Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint)")
  void testGetStencilImage() throws IOException, NumberFormatException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1,
        PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualStencilImage = SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    WritableRaster alphaRaster = actualStencilImage.getAlphaRaster();
    Rectangle bounds = alphaRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    Raster data = actualStencilImage.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualStencilImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    WritableRaster raster = actualStencilImage.getRaster();
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    assertSame(dataBuffer, raster.getDataBuffer());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   * <p>
   * Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint)")
  void testGetStencilImage2() throws IOException, NumberFormatException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1, 1,
        PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualStencilImage = SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    WritableRaster alphaRaster = actualStencilImage.getAlphaRaster();
    Rectangle bounds = alphaRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    Raster data = actualStencilImage.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualStencilImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    WritableRaster raster = actualStencilImage.getRaster();
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    assertSame(dataBuffer, raster.getDataBuffer());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   * <p>
   * Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint)")
  void testGetStencilImage3() throws IOException, NumberFormatException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1,
        PDDeviceRGB.INSTANCE);

    // Act
    BufferedImage actualStencilImage = SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    WritableRaster alphaRaster = actualStencilImage.getAlphaRaster();
    Rectangle bounds = alphaRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    Raster data = actualStencilImage.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualStencilImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    WritableRaster raster = actualStencilImage.getRaster();
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    assertSame(dataBuffer, raster.getDataBuffer());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   * <p>
   * Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint)")
  void testGetStencilImage4() throws IOException, NumberFormatException {
    // Arrange
    PDDocument document = new PDDocument();
    byte[] byteArray = "AXAXAXAX".getBytes("UTF-8");
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, byteArray, 1, 1, 1, new PDCalGray());

    // Act
    BufferedImage actualStencilImage = SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    WritableRaster alphaRaster = actualStencilImage.getAlphaRaster();
    Rectangle bounds = alphaRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    Raster data = actualStencilImage.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualStencilImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    WritableRaster raster = actualStencilImage.getRaster();
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    assertSame(dataBuffer, raster.getDataBuffer());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   * <p>
   * Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint)")
  void testGetStencilImage5() throws IOException, NumberFormatException {
    // Arrange
    PDDocument document = new PDDocument();
    byte[] byteArray = "AXAXAXAX".getBytes("UTF-8");
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, byteArray, 1, 1, 1, new PDCalRGB());

    // Act
    BufferedImage actualStencilImage = SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    WritableRaster alphaRaster = actualStencilImage.getAlphaRaster();
    Rectangle bounds = alphaRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    Raster data = actualStencilImage.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualStencilImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    WritableRaster raster = actualStencilImage.getRaster();
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    assertSame(dataBuffer, raster.getDataBuffer());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   * <ul>
   *   <li>Then return AlphaRaster Bounds CenterX is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint); then return AlphaRaster Bounds CenterX is four")
  void testGetStencilImage_thenReturnAlphaRasterBoundsCenterXIsFour() throws IOException, NumberFormatException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, "AXAXAXAX".getBytes("UTF-8"), 8, 1, 1,
        PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualStencilImage = SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    WritableRaster alphaRaster = actualStencilImage.getAlphaRaster();
    Rectangle bounds = alphaRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    Raster data = actualStencilImage.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = alphaRaster.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    Point[] writableTileIndices = actualStencilImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    assertEquals(4.0d, bounds.getCenterX());
    assertEquals(8, actualStencilImage.getTileWidth());
    assertEquals(8, actualStencilImage.getWidth());
    assertEquals(8, dataBuffer.getSize());
    assertEquals(8, dataBuffer2.getSize());
    assertEquals(8, alphaRaster.getWidth());
    assertEquals(8, data.getWidth());
    WritableRaster raster = actualStencilImage.getRaster();
    assertEquals(8, raster.getWidth());
    assertEquals(8, sampleModel.getWidth());
    assertEquals(8, sampleModel2.getWidth());
    assertEquals(8, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
    assertEquals(8, ((SinglePixelPackedSampleModel) sampleModel2).getScanlineStride());
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertEquals(8, data2.length);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertEquals(8, data3.length);
    Dimension size = bounds.getSize();
    assertEquals(8, size.width);
    assertEquals(8, bounds.width);
    assertEquals(8.0d, size.getWidth());
    assertEquals(8.0d, bounds.getWidth());
    assertEquals(8.0d, bounds.getMaxX());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    assertSame(data2, bankData[0]);
    assertSame(data3, bankData2[0]);
    assertSame(dataBuffer, raster.getDataBuffer());
    assertSame(sampleModel, data.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   * <ul>
   *   <li>Then return AlphaRaster Bounds CenterX is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint); then return AlphaRaster Bounds CenterX is one")
  void testGetStencilImage_thenReturnAlphaRasterBoundsCenterXIsOne() throws IOException, NumberFormatException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, "AXAXAXAX".getBytes("UTF-8"), 2, 1, 1,
        PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualStencilImage = SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    WritableRaster alphaRaster = actualStencilImage.getAlphaRaster();
    Rectangle bounds = alphaRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    Raster data = actualStencilImage.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = alphaRaster.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    Point[] writableTileIndices = actualStencilImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    assertEquals(1.0d, bounds.getCenterX());
    assertEquals(2, actualStencilImage.getTileWidth());
    assertEquals(2, actualStencilImage.getWidth());
    assertEquals(2, dataBuffer.getSize());
    assertEquals(2, dataBuffer2.getSize());
    assertEquals(2, alphaRaster.getWidth());
    assertEquals(2, data.getWidth());
    WritableRaster raster = actualStencilImage.getRaster();
    assertEquals(2, raster.getWidth());
    assertEquals(2, sampleModel.getWidth());
    assertEquals(2, sampleModel2.getWidth());
    assertEquals(2, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
    assertEquals(2, ((SinglePixelPackedSampleModel) sampleModel2).getScanlineStride());
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertEquals(2, data2.length);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertEquals(2, data3.length);
    Dimension size = bounds.getSize();
    assertEquals(2, size.width);
    assertEquals(2, bounds.width);
    assertEquals(2.0d, size.getWidth());
    assertEquals(2.0d, bounds.getWidth());
    assertEquals(2.0d, bounds.getMaxX());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    assertSame(data2, bankData[0]);
    assertSame(data3, bankData2[0]);
    assertSame(dataBuffer, raster.getDataBuffer());
    assertSame(sampleModel, data.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   * <ul>
   *   <li>Then return AlphaRaster DataBuffer Data is array of {@code int} with
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint); then return AlphaRaster DataBuffer Data is array of int with zero")
  void testGetStencilImage_thenReturnAlphaRasterDataBufferDataIsArrayOfIntWithZero()
      throws IOException, NumberFormatException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualStencilImage = SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    DataBuffer dataBuffer = actualStencilImage.getAlphaRaster().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = actualStencilImage.getData().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    assertArrayEquals(new int[]{0}, ((DataBufferInt) dataBuffer).getData());
    assertArrayEquals(new int[]{0}, ((DataBufferInt) dataBuffer2).getData());
  }

  /**
   * Test {@link SampledImageReader#getStencilImage(PDImage, Paint)}.
   * <ul>
   *   <li>Then return ninth element is {@code -16777174}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getStencilImage(PDImage, Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(PDImage, Paint); then return ninth element is '-16777174'")
  void testGetStencilImage_thenReturnNinthElementIs16777174() throws IOException, NumberFormatException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, "AXAXAXAX".getBytes("UTF-8"), 9, 1, 1,
        PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualStencilImage = SampledImageReader.getStencilImage(pdImage, Color.decode("42"));

    // Assert
    WritableRaster alphaRaster = actualStencilImage.getAlphaRaster();
    Rectangle bounds = alphaRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    Raster data = actualStencilImage.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    SampleModel sampleModel = actualStencilImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = alphaRaster.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertEquals(-16777174, data2[8]);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertEquals(-16777174, data3[8]);
    Point[] writableTileIndices = actualStencilImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    assertEquals(4.5d, bounds.getCenterX());
    assertEquals(9, actualStencilImage.getTileWidth());
    assertEquals(9, actualStencilImage.getWidth());
    assertEquals(9, dataBuffer.getSize());
    assertEquals(9, dataBuffer2.getSize());
    assertEquals(9, alphaRaster.getWidth());
    assertEquals(9, data.getWidth());
    WritableRaster raster = actualStencilImage.getRaster();
    assertEquals(9, raster.getWidth());
    assertEquals(9, sampleModel.getWidth());
    assertEquals(9, sampleModel2.getWidth());
    assertEquals(9, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
    assertEquals(9, ((SinglePixelPackedSampleModel) sampleModel2).getScanlineStride());
    assertEquals(9, data2.length);
    assertEquals(9, data3.length);
    Dimension size = bounds.getSize();
    assertEquals(9, size.width);
    assertEquals(9, bounds.width);
    assertEquals(9.0d, size.getWidth());
    assertEquals(9.0d, bounds.getWidth());
    assertEquals(9.0d, bounds.getMaxX());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    assertSame(data2, bankData[0]);
    assertSame(data3, bankData2[0]);
    assertSame(dataBuffer, raster.getDataBuffer());
    assertSame(sampleModel, data.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with
   * {@code pdImage}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  void testGetRGBImageWithPdImageColorKey() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    Raster data = actualRGBImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualRGBImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualRGBImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with
   * {@code pdImage}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  void testGetRGBImageWithPdImageColorKey2() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, -1, 1, 1, PDDeviceGray.INSTANCE);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with
   * {@code pdImage}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  void testGetRGBImageWithPdImageColorKey3() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, -1, 1, PDDeviceGray.INSTANCE);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with
   * {@code pdImage}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  void testGetRGBImageWithPdImageColorKey4() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 12, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    Raster data = actualRGBImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualRGBImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualRGBImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data2, bankData[0]);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data3, bankData2[0]);
    assertArrayEquals(new int[]{4276545}, data2);
    assertArrayEquals(new int[]{4276545}, data3);
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with
   * {@code pdImage}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  void testGetRGBImageWithPdImageColorKey5() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, -1, PDDeviceGray.INSTANCE);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, new COSArray()));
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with
   * {@code pdImage}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  void testGetRGBImageWithPdImageColorKey6() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceRGB.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    Raster data = actualRGBImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualRGBImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualRGBImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with
   * {@code pdImage}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  void testGetRGBImageWithPdImageColorKey7() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        1, 1, 1, new PDCalGray());

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    Raster data = actualRGBImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualRGBImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualRGBImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with
   * {@code pdImage}, {@code colorKey}.
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'")
  void testGetRGBImageWithPdImageColorKey8() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        1, 1, 1, new PDCalRGB());

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    Raster data = actualRGBImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualRGBImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualRGBImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with
   * {@code pdImage}, {@code colorKey}.
   * <ul>
   *   <li>Then return SampleModel ScanlineStride is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'; then return SampleModel ScanlineStride is one")
  void testGetRGBImageWithPdImageColorKey_thenReturnSampleModelScanlineStrideIsOne() throws IOException {
    // Arrange and Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceGray.INSTANCE), null);

    // Assert
    Raster data = actualRGBImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    WritableRaster raster = actualRGBImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    Point[] writableTileIndices = actualRGBImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    byte[][] bankData = ((DataBufferByte) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    byte[][] bankData2 = ((DataBufferByte) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    byte[] data2 = ((DataBufferByte) dataBuffer).getData();
    assertEquals(1, data2.length);
    byte[] data3 = ((DataBufferByte) dataBuffer2).getData();
    assertEquals(1, data3.length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertSame(data2, bankData[0]);
    assertSame(data3, bankData2[0]);
    assertSame(sampleModel, data.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with
   * {@code pdImage}, {@code colorKey}.
   * <ul>
   *   <li>Then return SampleModel ScanlineStride is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'; then return SampleModel ScanlineStride is one")
  void testGetRGBImageWithPdImageColorKey_thenReturnSampleModelScanlineStrideIsOne2() throws IOException {
    // Arrange and Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(
        LosslessFactory.prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1, 1, PDDeviceGray.INSTANCE), null);

    // Assert
    Raster data = actualRGBImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    WritableRaster raster = actualRGBImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    Point[] writableTileIndices = actualRGBImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    byte[][] bankData = ((DataBufferByte) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    byte[][] bankData2 = ((DataBufferByte) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    byte[] data2 = ((DataBufferByte) dataBuffer).getData();
    assertEquals(1, data2.length);
    byte[] data3 = ((DataBufferByte) dataBuffer2).getData();
    assertEquals(1, data3.length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertSame(data2, bankData[0]);
    assertSame(data3, bankData2[0]);
    assertSame(sampleModel, data.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with
   * {@code pdImage}, {@code colorKey}.
   * <ul>
   *   <li>Then return second element is {@code 16776191}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'; then return second element is '16776191'")
  void testGetRGBImageWithPdImageColorKey_thenReturnSecondElementIs16776191() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        8, 1, 1, new PDCalGray());

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    Raster data = actualRGBImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualRGBImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualRGBImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertEquals(16776191, data2[1]);
    assertEquals(16776191, data2[7]);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertEquals(16776191, data3[1]);
    assertEquals(16776191, data3[7]);
    assertEquals(8, data2.length);
    assertEquals(8, data3.length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertSame(data2, bankData[0]);
    assertSame(data3, bankData2[0]);
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with
   * {@code pdImage}, {@code colorKey}.
   * <ul>
   *   <li>Then return second element is {@code 16777215}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'; then return second element is '16777215'")
  void testGetRGBImageWithPdImageColorKey_thenReturnSecondElementIs16777215() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 8, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    Raster data = actualRGBImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualRGBImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualRGBImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertEquals(16777215, data2[1]);
    assertEquals(16777215, data2[7]);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertEquals(16777215, data3[1]);
    assertEquals(16777215, data3[7]);
    assertEquals(8, data2.length);
    assertEquals(8, data3.length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertSame(data2, bankData[0]);
    assertSame(data3, bankData2[0]);
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with
   * {@code pdImage}, {@code colorKey}.
   * <ul>
   *   <li>Then return second element is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'; then return second element is minus one")
  void testGetRGBImageWithPdImageColorKey_thenReturnSecondElementIsMinusOne() throws IOException {
    // Arrange and Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 8, 1, 1, PDDeviceGray.INSTANCE), null);

    // Assert
    Raster data = actualRGBImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    WritableRaster raster = actualRGBImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    byte[] data2 = ((DataBufferByte) dataBuffer).getData();
    assertEquals((byte) -1, data2[1]);
    assertEquals((byte) -1, data2[7]);
    byte[] data3 = ((DataBufferByte) dataBuffer2).getData();
    assertEquals((byte) -1, data3[1]);
    assertEquals((byte) -1, data3[7]);
    assertEquals((byte) 0, data2[2]);
    assertEquals((byte) 0, data2[3]);
    assertEquals((byte) 0, data2[4]);
    assertEquals((byte) 0, data2[5]);
    assertEquals((byte) 0, data2[6]);
    assertEquals((byte) 0, data3[2]);
    assertEquals((byte) 0, data3[3]);
    assertEquals((byte) 0, data3[4]);
    assertEquals((byte) 0, data3[5]);
    assertEquals((byte) 0, data3[6]);
    Point[] writableTileIndices = actualRGBImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    byte[][] bankData = ((DataBufferByte) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    byte[][] bankData2 = ((DataBufferByte) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    assertEquals(8, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(8, data2.length);
    assertEquals(8, data3.length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertSame(data2, bankData[0]);
    assertSame(data3, bankData2[0]);
    assertSame(sampleModel, data.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with
   * {@code pdImage}, {@code colorKey}.
   * <ul>
   *   <li>Then return second element is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'; then return second element is zero")
  void testGetRGBImageWithPdImageColorKey_thenReturnSecondElementIsZero() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        8, 1, 1, new PDCalRGB());

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new COSArray());

    // Assert
    Raster data = actualRGBImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualRGBImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertEquals(0, data2[1]);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertEquals(0, data3[1]);
    Point[] writableTileIndices = actualRGBImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    assertEquals(13311, data2[7]);
    assertEquals(13311, data3[7]);
    assertEquals(16711935, data2[5]);
    assertEquals(16711935, data3[5]);
    assertEquals(65280, data2[2]);
    assertEquals(65280, data3[2]);
    assertEquals(8, data2.length);
    assertEquals(8, data3.length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertSame(data2, bankData[0]);
    assertSame(data3, bankData2[0]);
  }

  /**
   * Test {@link SampledImageReader#getRGBImage(PDImage, COSArray)} with
   * {@code pdImage}, {@code colorKey}.
   * <ul>
   *   <li>When createThumbnail {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getRGBImage(PDImage, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, COSArray) with 'pdImage', 'colorKey'; when createThumbnail COSStream()")
  void testGetRGBImageWithPdImageColorKey_whenCreateThumbnailCOSStream() throws IOException {
    // Arrange
    PDImageXObject pdImage = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, new COSArray()));
  }

  /**
   * Test
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   * with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test:
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceGray.INSTANCE);
    Rectangle region = new Rectangle(1, 1);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray());

    // Assert
    Raster data = actualRGBImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualRGBImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualRGBImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
  }

  /**
   * Test
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   * with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test:
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey2() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 8, 1, 1, PDDeviceGray.INSTANCE);
    Rectangle region = new Rectangle(1, 1);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray());

    // Assert
    Raster data = actualRGBImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualRGBImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualRGBImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
  }

  /**
   * Test
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   * with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test:
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey3() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, -1, 1, 1, PDDeviceGray.INSTANCE);
    Rectangle region = new Rectangle(1, 1);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray()));
  }

  /**
   * Test
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   * with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test:
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey4() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, -1, 1, PDDeviceGray.INSTANCE);
    Rectangle region = new Rectangle(1, 1);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray()));
  }

  /**
   * Test
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   * with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test:
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey5() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 12, PDDeviceGray.INSTANCE);
    Rectangle region = new Rectangle(1, 1);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray());

    // Assert
    Raster data = actualRGBImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualRGBImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualRGBImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data2, bankData[0]);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data3, bankData2[0]);
    assertArrayEquals(new int[]{4276545}, data2);
    assertArrayEquals(new int[]{4276545}, data3);
  }

  /**
   * Test
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   * with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test:
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey6() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, -1, PDDeviceGray.INSTANCE);
    Rectangle region = new Rectangle(1, 1);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray()));
  }

  /**
   * Test
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   * with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test:
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey7() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceRGB.INSTANCE);
    Rectangle region = new Rectangle(1, 1);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray());

    // Assert
    Raster data = actualRGBImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualRGBImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualRGBImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
  }

  /**
   * Test
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   * with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test:
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey8() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        1, 1, 1, new PDCalGray());
    Rectangle region = new Rectangle(1, 1);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray());

    // Assert
    Raster data = actualRGBImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualRGBImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualRGBImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
  }

  /**
   * Test
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   * with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test:
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey9() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1},
        1, 1, 1, new PDCalRGB());
    Rectangle region = new Rectangle(1, 1);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray());

    // Assert
    Raster data = actualRGBImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualRGBImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualRGBImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
  }

  /**
   * Test
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   * with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test:
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey10() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, null, 1, new COSArray());

    // Assert
    Raster data = actualRGBImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualRGBImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualRGBImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   * with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test:
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey11() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new Rectangle(1, 1), 1, null);

    // Assert
    Raster data = actualRGBImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualRGBImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    ColorModel colorModel = actualRGBImage.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileGray);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    byte[] data2 = profile.getData();
    assertEquals((byte) -42, data2[531]);
    assertEquals((byte) -45, data2[538]);
    assertEquals(0, colorModel.getTransferType());
    assertEquals(0, dataBuffer.getDataType());
    assertEquals(0, dataBuffer2.getDataType());
    assertEquals(0, data.getTransferType());
    assertEquals(0, raster.getTransferType());
    assertEquals(0, sampleModel.getDataType());
    assertEquals(0, sampleModel.getTransferType());
    assertEquals((byte) 0, data2[532]);
    assertEquals((byte) 0, data2[534]);
    assertEquals((byte) 0, data2[535]);
    assertEquals((byte) 0, data2[536]);
    assertEquals((byte) 0, data2[537]);
    assertEquals((byte) 0, data2[544]);
    assertEquals((byte) 0, data2[545]);
    assertEquals((byte) 0, data2[546]);
    assertEquals((byte) 0, data2[547]);
    assertEquals((byte) 0, data2[548]);
    assertEquals((byte) 0, data2[549]);
    assertEquals((byte) 0, data2[550]);
    assertEquals((byte) 0, data2[553]);
    assertEquals((byte) 0, data2[554]);
    assertEquals((byte) 0, data2[555]);
    assertEquals(1, colorSpace.getNumComponents());
    assertEquals(1, profile.getNumComponents());
    assertEquals(1, colorModel.getNumColorComponents());
    assertEquals(1, colorModel.getNumComponents());
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getPixelStride());
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(1, data.getNumBands());
    assertEquals(1, raster.getNumBands());
    assertEquals(1, sampleModel.getNumBands());
    assertEquals(1, sampleModel.getNumDataElements());
    Point[] writableTileIndices = actualRGBImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, colorModel.getComponentSize().length);
    byte[][] bankData = ((DataBufferByte) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    byte[][] bankData2 = ((DataBufferByte) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    assertEquals(1.0f, ((ICC_ProfileGray) profile).getGamma());
    assertEquals(10, actualRGBImage.getType());
    assertEquals((byte) 1, data2[533]);
    assertEquals((byte) 1, data2[551]);
    assertEquals((byte) 1, data2[552]);
    assertEquals((byte) 2, data2[2]);
    assertEquals(556, data2.length);
    assertEquals(6, colorSpace.getType());
    assertEquals(6, profile.getColorSpaceType());
    assertEquals(8, colorModel.getPixelSize());
    assertFalse(colorSpace.isCS_sRGB());
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    assertEquals(size, bounds7.getSize().getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    assertEquals(point, bounds7.getLocation().getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
    assertEquals(',', data2[3]);
    assertEquals('-', data2[539]);
    assertEquals('A', data2[18]);
    assertEquals('G', data2[Short.SIZE]);
    assertEquals('R', data2[17]);
    assertEquals('Y', data2[19]);
    assertEquals('c', data2[540]);
    assertEquals('r', data2[542]);
    assertEquals('u', data2[541]);
    assertEquals('v', data2[543]);
    byte[] data3 = ((DataBufferByte) dataBuffer).getData();
    assertSame(data3, bankData[0]);
    byte[] data4 = ((DataBufferByte) dataBuffer2).getData();
    assertSame(data4, bankData2[0]);
    assertSame(sampleModel, data.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(new byte[]{0}, data3);
    assertArrayEquals(new byte[]{0}, data4);
    assertArrayEquals(new float[]{0.9642029f, 1.0f, 0.8249054f}, ((ICC_ProfileGray) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   * with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <p>
   * Method under test:
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'")
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey12() throws IOException {
    // Arrange
    PDImageXObject pdImage = LosslessFactory.prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1, 1,
        PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualRGBImage = SampledImageReader.getRGBImage(pdImage, new Rectangle(1, 1), 1, null);

    // Assert
    Raster data = actualRGBImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualRGBImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    ColorModel colorModel = actualRGBImage.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileGray);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    SampleModel sampleModel = actualRGBImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    byte[] data2 = profile.getData();
    assertEquals((byte) -42, data2[531]);
    assertEquals((byte) -45, data2[538]);
    assertEquals(0, colorModel.getTransferType());
    assertEquals(0, dataBuffer.getDataType());
    assertEquals(0, dataBuffer2.getDataType());
    assertEquals(0, data.getTransferType());
    assertEquals(0, raster.getTransferType());
    assertEquals(0, sampleModel.getDataType());
    assertEquals(0, sampleModel.getTransferType());
    assertEquals((byte) 0, data2[532]);
    assertEquals((byte) 0, data2[534]);
    assertEquals((byte) 0, data2[535]);
    assertEquals((byte) 0, data2[536]);
    assertEquals((byte) 0, data2[537]);
    assertEquals((byte) 0, data2[544]);
    assertEquals((byte) 0, data2[545]);
    assertEquals((byte) 0, data2[546]);
    assertEquals((byte) 0, data2[547]);
    assertEquals((byte) 0, data2[548]);
    assertEquals((byte) 0, data2[549]);
    assertEquals((byte) 0, data2[550]);
    assertEquals((byte) 0, data2[553]);
    assertEquals((byte) 0, data2[554]);
    assertEquals((byte) 0, data2[555]);
    assertEquals(1, colorSpace.getNumComponents());
    assertEquals(1, profile.getNumComponents());
    assertEquals(1, colorModel.getNumColorComponents());
    assertEquals(1, colorModel.getNumComponents());
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getPixelStride());
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(1, data.getNumBands());
    assertEquals(1, raster.getNumBands());
    assertEquals(1, sampleModel.getNumBands());
    assertEquals(1, sampleModel.getNumDataElements());
    Point[] writableTileIndices = actualRGBImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, colorModel.getComponentSize().length);
    byte[][] bankData = ((DataBufferByte) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    byte[][] bankData2 = ((DataBufferByte) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    assertEquals(1.0f, ((ICC_ProfileGray) profile).getGamma());
    assertEquals(10, actualRGBImage.getType());
    assertEquals((byte) 1, data2[533]);
    assertEquals((byte) 1, data2[551]);
    assertEquals((byte) 1, data2[552]);
    assertEquals((byte) 2, data2[2]);
    assertEquals(556, data2.length);
    assertEquals(6, colorSpace.getType());
    assertEquals(6, profile.getColorSpaceType());
    assertEquals(8, colorModel.getPixelSize());
    assertFalse(colorSpace.isCS_sRGB());
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    assertEquals(size, bounds7.getSize().getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    assertEquals(point, bounds7.getLocation().getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
    assertEquals(',', data2[3]);
    assertEquals('-', data2[539]);
    assertEquals('A', data2[18]);
    assertEquals('G', data2[Short.SIZE]);
    assertEquals('R', data2[17]);
    assertEquals('Y', data2[19]);
    assertEquals('c', data2[540]);
    assertEquals('r', data2[542]);
    assertEquals('u', data2[541]);
    assertEquals('v', data2[543]);
    byte[] data3 = ((DataBufferByte) dataBuffer).getData();
    assertSame(data3, bankData[0]);
    byte[] data4 = ((DataBufferByte) dataBuffer2).getData();
    assertSame(data4, bankData2[0]);
    assertSame(sampleModel, data.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(new byte[]{0}, data3);
    assertArrayEquals(new byte[]{0}, data4);
    assertArrayEquals(new float[]{0.9642029f, 1.0f, 0.8249054f}, ((ICC_ProfileGray) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   * with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <ul>
   *   <li>When createThumbnail {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'; when createThumbnail COSStream()")
  void testGetRGBImageWithPdImageRegionSubsamplingColorKey_whenCreateThumbnailCOSStream() throws IOException {
    // Arrange
    PDImageXObject pdImage = PDImageXObject.createThumbnail(new COSStream());
    Rectangle region = new Rectangle(1, 1);

    // Act and Assert
    assertThrows(IOException.class, () -> SampledImageReader.getRGBImage(pdImage, region, 1, new COSArray()));
  }

  /**
   * Test
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   * with {@code pdImage}, {@code region}, {@code subsampling}, {@code colorKey}.
   * <ul>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SampledImageReader#getRGBImage(PDImage, Rectangle, int, COSArray)}
   */
  @Test
  @DisplayName("Test getRGBImage(PDImage, Rectangle, int, COSArray) with 'pdImage', 'region', 'subsampling', 'colorKey'; when zero")
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
  void testGetRawRaster() throws IOException {
    // Arrange and Act
    WritableRaster actualRawRaster = SampledImageReader.getRawRaster(LosslessFactory.prepareImageXObject(
        new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceGray.INSTANCE));

    // Assert
    Rectangle bounds = actualRawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   * <p>
   * Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage)")
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
  void testGetRawRaster5() throws IOException {
    // Arrange and Act
    WritableRaster actualRawRaster = SampledImageReader.getRawRaster(LosslessFactory.prepareImageXObject(
        new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceRGB.INSTANCE));

    // Assert
    Rectangle bounds = actualRawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   * <p>
   * Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage)")
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
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   * <p>
   * Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage)")
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
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
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
  void testGetRawRaster_thenDataBufferReturnDataBufferUShort() throws IOException {
    // Arrange and Act
    WritableRaster actualRawRaster = SampledImageReader.getRawRaster(LosslessFactory.prepareImageXObject(
        new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 12, PDDeviceGray.INSTANCE));

    // Assert
    Rectangle bounds = actualRawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferUShort);
    SampleModel sampleModel = actualRawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertEquals(1, dataBuffer.getDataType());
    assertEquals(1, actualRawRaster.getTransferType());
    assertEquals(1, sampleModel.getDataType());
    assertEquals(1, sampleModel.getTransferType());
    short[][] bankData = ((DataBufferUShort) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    short[] data = ((DataBufferUShort) dataBuffer).getData();
    assertSame(data, bankData[0]);
    assertArrayEquals(new int[]{Short.SIZE}, sampleModel.getSampleSize());
    assertArrayEquals(new short[]{16644}, data);
  }

  /**
   * Test {@link SampledImageReader#getRawRaster(PDImage)}.
   * <ul>
   *   <li>Then return eighth element is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SampledImageReader#getRawRaster(PDImage)}
   */
  @Test
  @DisplayName("Test getRawRaster(PDImage); then return eighth element is minus one")
  void testGetRawRaster_thenReturnEighthElementIsMinusOne() throws IOException {
    // Arrange and Act
    WritableRaster actualRawRaster = SampledImageReader.getRawRaster(LosslessFactory.prepareImageXObject(
        new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 8, 1, 1, PDDeviceGray.INSTANCE));

    // Assert
    Rectangle bounds = actualRawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    byte[] data = ((DataBufferByte) dataBuffer).getData();
    assertEquals((byte) -1, data[7]);
    assertEquals((byte) 0, data[3]);
    assertEquals((byte) 0, data[4]);
    assertEquals((byte) 0, data[5]);
    assertEquals((byte) 0, data[6]);
    byte[][] bankData = ((DataBufferByte) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    assertEquals(4.0d, bounds.getCenterX());
    assertEquals(8, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(8, dataBuffer.getSize());
    assertEquals(8, actualRawRaster.getWidth());
    assertEquals(8, sampleModel.getWidth());
    assertEquals(8, data.length);
    Dimension size = bounds.getSize();
    assertEquals(8, size.width);
    assertEquals(8, bounds.width);
    assertEquals(8.0d, size.getWidth());
    assertEquals(8.0d, bounds.getWidth());
    assertEquals(8.0d, bounds.getMaxX());
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertSame(data, bankData[0]);
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
  void testGetRawRaster_whenCreateThumbnailCOSStream_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> SampledImageReader.getRawRaster(PDImageXObject.createThumbnail(new COSStream())));
  }
}
