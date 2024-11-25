package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.color.ICC_ProfileGray;
import java.awt.color.ICC_ProfileRGB;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDTristimulus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LosslessFactoryDiffblueTest {
  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>Given {@link ScratchFile#ScratchFile(MemoryUsageSetting)} with
   * memUsageSetting is setupMainMemoryOnly zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage); given ScratchFile(MemoryUsageSetting) with memUsageSetting is setupMainMemoryOnly zero")
  void testCreateFromImage_givenScratchFileWithMemUsageSettingIsSetupMainMemoryOnlyZero() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(0L)));
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult = LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = rawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    Raster data = image.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer3 = data2.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferInt);
    WritableRaster raster = image.getRaster();
    DataBuffer dataBuffer4 = raster.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferInt);
    WritableRaster raster2 = opaqueImage.getRaster();
    DataBuffer dataBuffer5 = raster2.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferInt);
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    SampleModel sampleModel = opaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    PDColorSpace colorSpace = actualCreateFromImageResult.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceRGB);
    assertEquals(1, actualCreateFromImageResult.getStream().getFilters().size());
    Point[] writableTileIndices = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer3).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer4).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer5).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, raster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices2[0]);
    FontMetrics expectedFontMetrics = image.getGraphics().getFontMetrics();
    assertSame(expectedFontMetrics, opaqueImage.getGraphics().getFontMetrics());
    assertSame(sampleModel, data2.getSampleModel());
    assertSame(sampleModel, raster2.getSampleModel());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>Then Image ColorModel ColorSpace return {@link ICC_ColorSpace}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage); then Image ColorModel ColorSpace return ICC_ColorSpace")
  void testCreateFromImage_thenImageColorModelColorSpaceReturnICC_ColorSpace() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult = LosslessFactory.createFromImage(document,
        new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY));

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    BufferedImage image = actualCreateFromImageResult.getImage();
    ColorModel colorModel = image.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileGray);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Raster data = image.getData();
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer2 = data2.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    WritableRaster raster = image.getRaster();
    DataBuffer dataBuffer3 = raster.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferByte);
    WritableRaster raster2 = opaqueImage.getRaster();
    DataBuffer dataBuffer4 = raster2.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferByte);
    DataBuffer dataBuffer5 = rawRaster.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferByte);
    SampleModel sampleModel = image.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    SampleModel sampleModel2 = opaqueImage.getSampleModel();
    assertTrue(sampleModel2 instanceof PixelInterleavedSampleModel);
    SampleModel sampleModel3 = rawRaster.getSampleModel();
    assertTrue(sampleModel3 instanceof PixelInterleavedSampleModel);
    PDColorSpace colorSpace2 = actualCreateFromImageResult.getColorSpace();
    assertTrue(colorSpace2 instanceof PDDeviceGray);
    byte[] data3 = profile.getData();
    assertEquals((byte) -42, data3[531]);
    assertEquals((byte) -45, data3[538]);
    assertEquals(0, profile.getPCSType());
    assertEquals(0, colorModel.getTransferType());
    assertEquals(0, dataBuffer.getDataType());
    assertEquals(0, dataBuffer2.getDataType());
    assertEquals(0, dataBuffer3.getDataType());
    assertEquals(0, dataBuffer4.getDataType());
    assertEquals(0, data.getTransferType());
    assertEquals(0, data2.getTransferType());
    assertEquals(0, raster.getTransferType());
    assertEquals(0, raster2.getTransferType());
    assertEquals(0, sampleModel.getDataType());
    assertEquals(0, sampleModel.getTransferType());
    assertEquals((byte) 0, data3[0]);
    assertEquals((byte) 0, data3[1]);
    assertEquals((byte) 0, data3[10]);
    assertEquals((byte) 0, data3[11]);
    assertEquals((byte) 0, data3[532]);
    assertEquals((byte) 0, data3[534]);
    assertEquals((byte) 0, data3[535]);
    assertEquals((byte) 0, data3[536]);
    assertEquals((byte) 0, data3[537]);
    assertEquals((byte) 0, data3[544]);
    assertEquals((byte) 0, data3[545]);
    assertEquals((byte) 0, data3[546]);
    assertEquals((byte) 0, data3[547]);
    assertEquals((byte) 0, data3[548]);
    assertEquals((byte) 0, data3[549]);
    assertEquals((byte) 0, data3[550]);
    assertEquals((byte) 0, data3[553]);
    assertEquals((byte) 0, data3[554]);
    assertEquals((byte) 0, data3[555]);
    assertEquals(1, colorSpace.getNumComponents());
    assertEquals(1, profile.getNumComponents());
    assertEquals(1, profile.getProfileClass());
    assertEquals(1, colorModel.getNumColorComponents());
    assertEquals(1, colorModel.getNumComponents());
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getPixelStride());
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(1, data.getNumBands());
    assertEquals(1, data2.getNumBands());
    assertEquals(1, raster.getNumBands());
    assertEquals(1, raster2.getNumBands());
    assertEquals(1, sampleModel.getNumBands());
    assertEquals(1, sampleModel.getNumDataElements());
    assertEquals(1, actualCreateFromImageResult.getStream().getFilters().size());
    assertEquals(1, actualCreateFromImageResult.getBitsPerComponent());
    Point[] writableTileIndices = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    assertEquals(1, colorModel.getComponentSize().length);
    byte[][] bankData = ((DataBufferByte) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    byte[][] bankData2 = ((DataBufferByte) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    byte[][] bankData3 = ((DataBufferByte) dataBuffer3).getBankData();
    assertEquals(1, bankData3.length);
    byte[][] bankData4 = ((DataBufferByte) dataBuffer4).getBankData();
    assertEquals(1, bankData4.length);
    assertEquals(1, ((DataBufferByte) dataBuffer5).getBankData().length);
    assertEquals(1.0f, ((ICC_ProfileGray) profile).getGamma());
    assertEquals(10, image.getType());
    assertEquals(10, opaqueImage.getType());
    assertEquals((byte) 1, data3[533]);
    assertEquals((byte) 1, data3[551]);
    assertEquals((byte) 1, data3[552]);
    assertEquals(2, profile.getMajorVersion());
    assertEquals((byte) 2, data3[2]);
    assertEquals((byte) 2, data3[8]);
    assertEquals(48, profile.getMinorVersion());
    assertEquals(556, data3.length);
    assertEquals(6, colorSpace.getType());
    assertEquals(6, profile.getColorSpaceType());
    assertEquals((byte) 7, data3[24]);
    assertEquals(8, colorModel.getPixelSize());
    assertFalse(colorSpace.isCS_sRGB());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(colorModel, opaqueImage.getColorModel());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, raster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices2[0]);
    assertEquals(' ', data3[23]);
    assertEquals(',', data3[3]);
    assertEquals('-', data3[539]);
    assertEquals('0', data3[9]);
    assertEquals('A', data3[18]);
    assertEquals('G', data3[Short.SIZE]);
    assertEquals('R', data3[17]);
    assertEquals('X', data3[20]);
    assertEquals('Y', data3[19]);
    assertEquals('Y', data3[21]);
    assertEquals('Z', data3[22]);
    assertEquals('c', data3[5]);
    assertEquals('c', data3[540]);
    assertEquals('l', data3[4]);
    assertEquals('m', data3[12]);
    assertEquals('m', data3[6]);
    assertEquals('n', data3[13]);
    assertEquals('r', data3[15]);
    assertEquals('r', data3[542]);
    assertEquals('s', data3[7]);
    assertEquals('t', data3[14]);
    assertEquals('u', data3[541]);
    assertEquals('v', data3[543]);
    assertEquals(sampleModel, sampleModel2);
    assertEquals(sampleModel, sampleModel3);
    FontMetrics expectedFontMetrics = image.getGraphics().getFontMetrics();
    assertSame(expectedFontMetrics, opaqueImage.getGraphics().getFontMetrics());
    byte[] data4 = ((DataBufferByte) dataBuffer).getData();
    assertSame(data4, bankData[0]);
    byte[] data5 = ((DataBufferByte) dataBuffer2).getData();
    assertSame(data5, bankData2[0]);
    byte[] data6 = ((DataBufferByte) dataBuffer3).getData();
    assertSame(data6, bankData3[0]);
    byte[] data7 = ((DataBufferByte) dataBuffer4).getData();
    assertSame(data7, bankData4[0]);
    assertSame(sampleModel, data.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertSame(sampleModel2, data2.getSampleModel());
    assertSame(sampleModel2, raster2.getSampleModel());
    assertSame(colorSpace2, colorSpace2.getInitialColor().getColorSpace());
    assertArrayEquals(new byte[]{0}, data4);
    assertArrayEquals(new byte[]{0}, data5);
    assertArrayEquals(new byte[]{0}, data6);
    assertArrayEquals(new byte[]{0}, data7);
    assertArrayEquals(new float[]{0.9642029f, 1.0f, 0.8249054f}, ((ICC_ProfileGray) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>Then Image SampleModel return {@link SinglePixelPackedSampleModel}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage); then Image SampleModel return SinglePixelPackedSampleModel")
  void testCreateFromImage_thenImageSampleModelReturnSinglePixelPackedSampleModel() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult = LosslessFactory.createFromImage(document,
        new BufferedImage(BufferedImage.TYPE_BYTE_GRAY, 1, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = rawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    Raster data = image.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer3 = data2.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferInt);
    WritableRaster raster = image.getRaster();
    DataBuffer dataBuffer4 = raster.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferInt);
    WritableRaster raster2 = opaqueImage.getRaster();
    DataBuffer dataBuffer5 = raster2.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferInt);
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    SampleModel sampleModel = rawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    SampleModel sampleModel2 = image.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel3 = opaqueImage.getSampleModel();
    assertTrue(sampleModel3 instanceof SinglePixelPackedSampleModel);
    PDStream stream = actualCreateFromImageResult.getStream();
    List<Object> decodeParms = stream.getDecodeParms();
    assertEquals(1, decodeParms.size());
    Object getResult = decodeParms.get(0);
    assertTrue(getResult instanceof Map);
    PDColorSpace colorSpace = actualCreateFromImageResult.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceRGB);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertEquals(0, data3[1]);
    assertEquals(0, data3[2]);
    assertEquals(0, data3[3]);
    assertEquals(0, data3[4]);
    assertEquals(0, data3[5]);
    assertEquals(0, data3[6]);
    assertEquals(0, data3[7]);
    assertEquals(0, data3[8]);
    assertEquals(0, data3[9]);
    int[] data4 = ((DataBufferInt) dataBuffer3).getData();
    assertEquals(0, data4[1]);
    assertEquals(0, data4[2]);
    assertEquals(0, data4[3]);
    assertEquals(0, data4[4]);
    assertEquals(0, data4[5]);
    assertEquals(0, data4[6]);
    assertEquals(0, data4[7]);
    assertEquals(0, data4[8]);
    assertEquals(0, data4[9]);
    int[] data5 = ((DataBufferInt) dataBuffer4).getData();
    assertEquals(0, data5[1]);
    assertEquals(0, data5[2]);
    assertEquals(0, data5[3]);
    assertEquals(0, data5[4]);
    assertEquals(0, data5[5]);
    assertEquals(0, data5[6]);
    assertEquals(0, data5[7]);
    assertEquals(0, data5[8]);
    assertEquals(0, data5[9]);
    int[] data6 = ((DataBufferInt) dataBuffer5).getData();
    assertEquals(0, data6[1]);
    assertEquals(0, data6[2]);
    assertEquals(0, data6[3]);
    assertEquals(0, data6[4]);
    assertEquals(0, data6[5]);
    assertEquals(0, data6[6]);
    assertEquals(0, data6[7]);
    assertEquals(0, data6[8]);
    assertEquals(0, data6[9]);
    byte[] data7 = ((DataBufferByte) dataBuffer).getData();
    assertEquals((byte) 0, data7[10]);
    assertEquals((byte) 0, data7[11]);
    assertEquals((byte) 0, data7[12]);
    assertEquals((byte) 0, data7[13]);
    assertEquals((byte) 0, data7[14]);
    assertEquals((byte) 0, data7[15]);
    assertEquals((byte) 0, data7[17]);
    assertEquals((byte) 0, data7[18]);
    assertEquals((byte) 0, data7[19]);
    assertEquals((byte) 0, data7[20]);
    assertEquals((byte) 0, data7[21]);
    assertEquals((byte) 0, data7[22]);
    assertEquals((byte) 0, data7[23]);
    assertEquals((byte) 0, data7[24]);
    assertEquals((byte) 0, data7[25]);
    assertEquals((byte) 0, data7[26]);
    assertEquals((byte) 0, data7[27]);
    assertEquals((byte) 0, data7[28]);
    assertEquals((byte) 0, data7[29]);
    assertEquals((byte) 0, data7[3]);
    assertEquals((byte) 0, data7[4]);
    assertEquals((byte) 0, data7[5]);
    assertEquals((byte) 0, data7[6]);
    assertEquals((byte) 0, data7[7]);
    assertEquals((byte) 0, data7[8]);
    assertEquals((byte) 0, data7[9]);
    assertEquals((byte) 0, data7[Short.SIZE]);
    assertEquals(1, stream.getFilters().size());
    Point[] writableTileIndices = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    byte[][] bankData = ((DataBufferByte) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    int[][] bankData3 = ((DataBufferInt) dataBuffer3).getBankData();
    assertEquals(1, bankData3.length);
    int[][] bankData4 = ((DataBufferInt) dataBuffer4).getBankData();
    assertEquals(1, bankData4.length);
    int[][] bankData5 = ((DataBufferInt) dataBuffer5).getBankData();
    assertEquals(1, bankData5.length);
    assertEquals(10, image.getTileWidth());
    assertEquals(10, opaqueImage.getTileWidth());
    assertEquals(10, image.getWidth());
    assertEquals(10, opaqueImage.getWidth());
    assertEquals(10, dataBuffer2.getSize());
    assertEquals(10, dataBuffer3.getSize());
    assertEquals(10, dataBuffer4.getSize());
    assertEquals(10, dataBuffer5.getSize());
    assertEquals(10, data.getWidth());
    assertEquals(10, data2.getWidth());
    assertEquals(10, raster.getWidth());
    assertEquals(10, raster2.getWidth());
    assertEquals(10, rawRaster.getWidth());
    assertEquals(10, sampleModel2.getWidth());
    assertEquals(10, sampleModel.getWidth());
    assertEquals(10, ((SinglePixelPackedSampleModel) sampleModel2).getScanlineStride());
    assertEquals(4, ((Map<String, Integer>) getResult).size());
    assertEquals(10, ((Map<String, Integer>) getResult).get("Columns").intValue());
    assertEquals(10, actualCreateFromImageResult.getWidth());
    assertEquals(10, data3.length);
    assertEquals(10, data4.length);
    assertEquals(10, data5.length);
    assertEquals(10, data6.length);
    Dimension size = bounds.getSize();
    assertEquals(10, size.width);
    assertEquals(10, bounds.width);
    assertEquals(10.0d, size.getWidth());
    assertEquals(10.0d, bounds.getWidth());
    assertEquals(10.0d, bounds.getMaxX());
    assertEquals(15, ((Map<String, Integer>) getResult).get("Predictor").intValue());
    assertEquals(3, ((Map<String, Integer>) getResult).get("Colors").intValue());
    assertEquals(30, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(30, dataBuffer.getSize());
    assertEquals(30, data7.length);
    assertEquals(5.0d, bounds.getCenterX());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, raster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices2[0]);
    assertEquals(sampleModel2, sampleModel3);
    FontMetrics expectedFontMetrics = image.getGraphics().getFontMetrics();
    assertSame(expectedFontMetrics, opaqueImage.getGraphics().getFontMetrics());
    assertSame(data7, bankData[0]);
    assertSame(data3, bankData2[0]);
    assertSame(data4, bankData3[0]);
    assertSame(data5, bankData4[0]);
    assertSame(data6, bankData5[0]);
    assertSame(sampleModel2, data.getSampleModel());
    assertSame(sampleModel2, raster.getSampleModel());
    assertSame(sampleModel3, data2.getSampleModel());
    assertSame(sampleModel3, raster2.getSampleModel());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>Then return RawRaster SampleModel PixelStride is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage); then return RawRaster SampleModel PixelStride is one")
  void testCreateFromImage_thenReturnRawRasterSampleModelPixelStrideIsOne() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult = LosslessFactory.createFromImage(document,
        new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_GRAY));

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = rawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    Raster data = image.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer3 = data2.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferInt);
    WritableRaster raster = image.getRaster();
    DataBuffer dataBuffer4 = raster.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferInt);
    WritableRaster raster2 = opaqueImage.getRaster();
    DataBuffer dataBuffer5 = raster2.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferInt);
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    SampleModel sampleModel = rawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    SampleModel sampleModel2 = opaqueImage.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    PDColorSpace colorSpace = actualCreateFromImageResult.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getPixelStride());
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(1, sampleModel.getNumBands());
    assertEquals(1, sampleModel.getNumDataElements());
    assertEquals(1, actualCreateFromImageResult.getStream().getFilters().size());
    Point[] writableTileIndices = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets().length);
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getBankIndices().length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer3).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer4).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer5).getBankData().length);
    assertEquals(1, sampleModel.getSampleSize().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, raster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices2[0]);
    FontMetrics expectedFontMetrics = image.getGraphics().getFontMetrics();
    assertSame(expectedFontMetrics, opaqueImage.getGraphics().getFontMetrics());
    assertSame(sampleModel2, data2.getSampleModel());
    assertSame(sampleModel2, raster2.getSampleModel());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one
   * and eight.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage); when BufferedImage(int, int, int) with one and one and eight")
  void testCreateFromImage_whenBufferedImageWithOneAndOneAndEight() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult = LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 8));

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = rawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    Raster data = image.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer3 = data2.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferInt);
    WritableRaster raster = image.getRaster();
    DataBuffer dataBuffer4 = raster.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferInt);
    WritableRaster raster2 = opaqueImage.getRaster();
    DataBuffer dataBuffer5 = raster2.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferInt);
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    SampleModel sampleModel = opaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    PDColorSpace colorSpace = actualCreateFromImageResult.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceRGB);
    assertEquals(1, actualCreateFromImageResult.getStream().getFilters().size());
    Point[] writableTileIndices = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer3).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer4).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer5).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, raster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices2[0]);
    FontMetrics expectedFontMetrics = image.getGraphics().getFontMetrics();
    assertSame(expectedFontMetrics, opaqueImage.getGraphics().getFontMetrics());
    assertSame(sampleModel, data2.getSampleModel());
    assertSame(sampleModel, raster2.getSampleModel());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one
   * and five.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage); when BufferedImage(int, int, int) with one and one and five")
  void testCreateFromImage_whenBufferedImageWithOneAndOneAndFive() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult = LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 5));

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = rawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    Raster data = image.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer3 = data2.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferInt);
    WritableRaster raster = image.getRaster();
    DataBuffer dataBuffer4 = raster.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferInt);
    WritableRaster raster2 = opaqueImage.getRaster();
    DataBuffer dataBuffer5 = raster2.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferInt);
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    SampleModel sampleModel = opaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    PDColorSpace colorSpace = actualCreateFromImageResult.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceRGB);
    assertEquals(1, actualCreateFromImageResult.getStream().getFilters().size());
    Point[] writableTileIndices = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer3).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer4).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer5).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, raster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices2[0]);
    FontMetrics expectedFontMetrics = image.getGraphics().getFontMetrics();
    assertSame(expectedFontMetrics, opaqueImage.getGraphics().getFontMetrics());
    assertSame(sampleModel, data2.getSampleModel());
    assertSame(sampleModel, raster2.getSampleModel());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one
   * and four.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage); when BufferedImage(int, int, int) with one and one and four")
  void testCreateFromImage_whenBufferedImageWithOneAndOneAndFour() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult = LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 4));

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = rawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    Raster data = image.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer3 = data2.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferInt);
    WritableRaster raster = image.getRaster();
    DataBuffer dataBuffer4 = raster.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferInt);
    WritableRaster raster2 = opaqueImage.getRaster();
    DataBuffer dataBuffer5 = raster2.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferInt);
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    SampleModel sampleModel = opaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    PDColorSpace colorSpace = actualCreateFromImageResult.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceRGB);
    assertEquals(1, actualCreateFromImageResult.getStream().getFilters().size());
    Point[] writableTileIndices = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer3).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer4).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer5).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, raster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices2[0]);
    FontMetrics expectedFontMetrics = image.getGraphics().getFontMetrics();
    assertSame(expectedFontMetrics, opaqueImage.getGraphics().getFontMetrics());
    assertSame(sampleModel, data2.getSampleModel());
    assertSame(sampleModel, raster2.getSampleModel());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one
   * and one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage); when BufferedImage(int, int, int) with one and one and one")
  void testCreateFromImage_whenBufferedImageWithOneAndOneAndOne() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult = LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = rawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    Raster data = image.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer3 = data2.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferInt);
    WritableRaster raster = image.getRaster();
    DataBuffer dataBuffer4 = raster.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferInt);
    WritableRaster raster2 = opaqueImage.getRaster();
    DataBuffer dataBuffer5 = raster2.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferInt);
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    SampleModel sampleModel = opaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    PDColorSpace colorSpace = actualCreateFromImageResult.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceRGB);
    assertEquals(1, actualCreateFromImageResult.getStream().getFilters().size());
    Point[] writableTileIndices = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer3).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer4).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer5).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, raster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices2[0]);
    FontMetrics expectedFontMetrics = image.getGraphics().getFontMetrics();
    assertSame(expectedFontMetrics, opaqueImage.getGraphics().getFontMetrics());
    assertSame(sampleModel, data2.getSampleModel());
    assertSame(sampleModel, raster2.getSampleModel());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one
   * and six.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage); when BufferedImage(int, int, int) with one and one and six")
  void testCreateFromImage_whenBufferedImageWithOneAndOneAndSix() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult = LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 6));

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    PDImageXObject softMask = actualCreateFromImageResult.getSoftMask();
    WritableRaster rawRaster2 = softMask.getRawRaster();
    DataBuffer dataBuffer = rawRaster2.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = rawRaster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    WritableRaster alphaRaster = image.getAlphaRaster();
    DataBuffer dataBuffer3 = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferInt);
    Raster data = image.getData();
    DataBuffer dataBuffer4 = data.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferInt);
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer5 = data2.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferInt);
    WritableRaster raster = opaqueImage.getRaster();
    DataBuffer dataBuffer6 = raster.getDataBuffer();
    assertTrue(dataBuffer6 instanceof DataBufferInt);
    BufferedImage image2 = softMask.getImage();
    ColorModel colorModel = image2.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    BufferedImage opaqueImage2 = softMask.getOpaqueImage();
    ColorModel colorModel2 = opaqueImage2.getColorModel();
    assertTrue(colorModel2 instanceof DirectColorModel);
    ColorModel colorModel3 = opaqueImage.getColorModel();
    assertTrue(colorModel3 instanceof DirectColorModel);
    SampleModel sampleModel = image2.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = opaqueImage2.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    PDColorSpace colorSpace = softMask.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    PDColorSpace colorSpace2 = actualCreateFromImageResult.getColorSpace();
    assertTrue(colorSpace2 instanceof PDDeviceRGB);
    List<COSName> filters = actualCreateFromImageResult.getStream().getFilters();
    assertEquals(1, filters.size());
    Point[] writableTileIndices = image2.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    Point[] writableTileIndices3 = opaqueImage2.getWritableTileIndices();
    assertEquals(1, writableTileIndices3.length);
    Point[] writableTileIndices4 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices4.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer3).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer4).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer5).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer6).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize().getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, alphaRaster.getBounds());
    Raster data3 = image2.getData();
    assertEquals(bounds, data3.getBounds());
    assertEquals(bounds, data.getBounds());
    Raster data4 = opaqueImage2.getData();
    assertEquals(bounds, data4.getBounds());
    assertEquals(bounds, data2.getBounds());
    WritableRaster raster2 = image2.getRaster();
    assertEquals(bounds, raster2.getBounds());
    WritableRaster raster3 = image.getRaster();
    assertEquals(bounds, raster3.getBounds());
    WritableRaster raster4 = opaqueImage2.getRaster();
    assertEquals(bounds, raster4.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, rawRaster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(filters, softMask.getStream().getFilters());
    Point point = writableTileIndices2[0];
    assertEquals(point, point.getLocation().getLocation());
    assertEquals(point, (writableTileIndices[0]).getLocation());
    assertEquals(point, (writableTileIndices3[0]).getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices4[0]);
    assertEquals(colorModel3, colorModel);
    assertEquals(colorModel3, colorModel2);
    FontMetrics fontMetrics = image.getGraphics().getFontMetrics();
    assertSame(fontMetrics, image2.getGraphics().getFontMetrics());
    assertSame(fontMetrics, opaqueImage2.getGraphics().getFontMetrics());
    assertSame(fontMetrics, opaqueImage.getGraphics().getFontMetrics());
    assertSame(raster3, alphaRaster.getParent());
    assertSame(raster3, alphaRaster.getWritableParent());
    assertSame(dataBuffer3, raster3.getDataBuffer());
    assertSame(sampleModel, data3.getSampleModel());
    assertSame(sampleModel, raster2.getSampleModel());
    assertSame(sampleModel2, data4.getSampleModel());
    assertSame(sampleModel2, raster4.getSampleModel());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
    assertSame(colorSpace2, colorSpace2.getInitialColor().getColorSpace());
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one
   * and three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage); when BufferedImage(int, int, int) with one and one and three")
  void testCreateFromImage_whenBufferedImageWithOneAndOneAndThree() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult = LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 3));

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    PDImageXObject softMask = actualCreateFromImageResult.getSoftMask();
    WritableRaster rawRaster2 = softMask.getRawRaster();
    DataBuffer dataBuffer = rawRaster2.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = rawRaster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    WritableRaster alphaRaster = image.getAlphaRaster();
    DataBuffer dataBuffer3 = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferInt);
    Raster data = image.getData();
    DataBuffer dataBuffer4 = data.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferInt);
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer5 = data2.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferInt);
    WritableRaster raster = opaqueImage.getRaster();
    DataBuffer dataBuffer6 = raster.getDataBuffer();
    assertTrue(dataBuffer6 instanceof DataBufferInt);
    BufferedImage image2 = softMask.getImage();
    ColorModel colorModel = image2.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    BufferedImage opaqueImage2 = softMask.getOpaqueImage();
    ColorModel colorModel2 = opaqueImage2.getColorModel();
    assertTrue(colorModel2 instanceof DirectColorModel);
    ColorModel colorModel3 = opaqueImage.getColorModel();
    assertTrue(colorModel3 instanceof DirectColorModel);
    SampleModel sampleModel = image2.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = opaqueImage2.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    PDColorSpace colorSpace = softMask.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    PDColorSpace colorSpace2 = actualCreateFromImageResult.getColorSpace();
    assertTrue(colorSpace2 instanceof PDDeviceRGB);
    List<COSName> filters = actualCreateFromImageResult.getStream().getFilters();
    assertEquals(1, filters.size());
    Point[] writableTileIndices = image2.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    Point[] writableTileIndices3 = opaqueImage2.getWritableTileIndices();
    assertEquals(1, writableTileIndices3.length);
    Point[] writableTileIndices4 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices4.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer3).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer4).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer5).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer6).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize().getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, alphaRaster.getBounds());
    Raster data3 = image2.getData();
    assertEquals(bounds, data3.getBounds());
    assertEquals(bounds, data.getBounds());
    Raster data4 = opaqueImage2.getData();
    assertEquals(bounds, data4.getBounds());
    assertEquals(bounds, data2.getBounds());
    WritableRaster raster2 = image2.getRaster();
    assertEquals(bounds, raster2.getBounds());
    WritableRaster raster3 = image.getRaster();
    assertEquals(bounds, raster3.getBounds());
    WritableRaster raster4 = opaqueImage2.getRaster();
    assertEquals(bounds, raster4.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, rawRaster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(filters, softMask.getStream().getFilters());
    Point point = writableTileIndices2[0];
    assertEquals(point, point.getLocation().getLocation());
    assertEquals(point, (writableTileIndices[0]).getLocation());
    assertEquals(point, (writableTileIndices3[0]).getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices4[0]);
    assertEquals(colorModel3, colorModel);
    assertEquals(colorModel3, colorModel2);
    FontMetrics fontMetrics = image.getGraphics().getFontMetrics();
    assertSame(fontMetrics, image2.getGraphics().getFontMetrics());
    assertSame(fontMetrics, opaqueImage2.getGraphics().getFontMetrics());
    assertSame(fontMetrics, opaqueImage.getGraphics().getFontMetrics());
    assertSame(raster3, alphaRaster.getParent());
    assertSame(raster3, alphaRaster.getWritableParent());
    assertSame(dataBuffer3, raster3.getDataBuffer());
    assertSame(sampleModel, data3.getSampleModel());
    assertSame(sampleModel, raster2.getSampleModel());
    assertSame(sampleModel2, data4.getSampleModel());
    assertSame(sampleModel2, raster4.getSampleModel());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
    assertSame(colorSpace2, colorSpace2.getInitialColor().getColorSpace());
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one
   * and two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage); when BufferedImage(int, int, int) with one and one and two")
  void testCreateFromImage_whenBufferedImageWithOneAndOneAndTwo() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult = LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 2));

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    PDImageXObject softMask = actualCreateFromImageResult.getSoftMask();
    WritableRaster rawRaster2 = softMask.getRawRaster();
    DataBuffer dataBuffer = rawRaster2.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = rawRaster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    WritableRaster alphaRaster = image.getAlphaRaster();
    DataBuffer dataBuffer3 = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferInt);
    Raster data = image.getData();
    DataBuffer dataBuffer4 = data.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferInt);
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer5 = data2.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferInt);
    WritableRaster raster = opaqueImage.getRaster();
    DataBuffer dataBuffer6 = raster.getDataBuffer();
    assertTrue(dataBuffer6 instanceof DataBufferInt);
    BufferedImage image2 = softMask.getImage();
    ColorModel colorModel = image2.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    BufferedImage opaqueImage2 = softMask.getOpaqueImage();
    ColorModel colorModel2 = opaqueImage2.getColorModel();
    assertTrue(colorModel2 instanceof DirectColorModel);
    ColorModel colorModel3 = opaqueImage.getColorModel();
    assertTrue(colorModel3 instanceof DirectColorModel);
    SampleModel sampleModel = image2.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = opaqueImage2.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    PDColorSpace colorSpace = softMask.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    PDColorSpace colorSpace2 = actualCreateFromImageResult.getColorSpace();
    assertTrue(colorSpace2 instanceof PDDeviceRGB);
    List<COSName> filters = actualCreateFromImageResult.getStream().getFilters();
    assertEquals(1, filters.size());
    Point[] writableTileIndices = image2.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    Point[] writableTileIndices3 = opaqueImage2.getWritableTileIndices();
    assertEquals(1, writableTileIndices3.length);
    Point[] writableTileIndices4 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices4.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer3).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer4).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer5).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer6).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize().getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, alphaRaster.getBounds());
    Raster data3 = image2.getData();
    assertEquals(bounds, data3.getBounds());
    assertEquals(bounds, data.getBounds());
    Raster data4 = opaqueImage2.getData();
    assertEquals(bounds, data4.getBounds());
    assertEquals(bounds, data2.getBounds());
    WritableRaster raster2 = image2.getRaster();
    assertEquals(bounds, raster2.getBounds());
    WritableRaster raster3 = image.getRaster();
    assertEquals(bounds, raster3.getBounds());
    WritableRaster raster4 = opaqueImage2.getRaster();
    assertEquals(bounds, raster4.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, rawRaster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(filters, softMask.getStream().getFilters());
    Point point = writableTileIndices2[0];
    assertEquals(point, point.getLocation().getLocation());
    assertEquals(point, (writableTileIndices[0]).getLocation());
    assertEquals(point, (writableTileIndices3[0]).getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices4[0]);
    assertEquals(colorModel3, colorModel);
    assertEquals(colorModel3, colorModel2);
    FontMetrics fontMetrics = image.getGraphics().getFontMetrics();
    assertSame(fontMetrics, image2.getGraphics().getFontMetrics());
    assertSame(fontMetrics, opaqueImage2.getGraphics().getFontMetrics());
    assertSame(fontMetrics, opaqueImage.getGraphics().getFontMetrics());
    assertSame(raster3, alphaRaster.getParent());
    assertSame(raster3, alphaRaster.getWritableParent());
    assertSame(dataBuffer3, raster3.getDataBuffer());
    assertSame(sampleModel, data3.getSampleModel());
    assertSame(sampleModel, raster2.getSampleModel());
    assertSame(sampleModel2, data4.getSampleModel());
    assertSame(sampleModel2, raster4.getSampleModel());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
    assertSame(colorSpace2, colorSpace2.getInitialColor().getColorSpace());
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument(COSDocument)} with doc is
   * {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage); when PDDocument(COSDocument) with doc is COSDocument()")
  void testCreateFromImage_whenPDDocumentWithDocIsCOSDocument() throws IOException {
    // Arrange
    PDDocument document = new PDDocument(new COSDocument());

    // Act
    PDImageXObject actualCreateFromImageResult = LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 1));

    // Assert
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = rawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    Raster data = image.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer3 = data2.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferInt);
    WritableRaster raster = image.getRaster();
    DataBuffer dataBuffer4 = raster.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferInt);
    WritableRaster raster2 = opaqueImage.getRaster();
    DataBuffer dataBuffer5 = raster2.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferInt);
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    SampleModel sampleModel = opaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    PDColorSpace colorSpace = actualCreateFromImageResult.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceRGB);
    assertEquals(1, actualCreateFromImageResult.getStream().getFilters().size());
    Point[] writableTileIndices = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer3).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer4).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer5).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, raster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices2[0]);
    FontMetrics expectedFontMetrics = image.getGraphics().getFontMetrics();
    assertSame(expectedFontMetrics, opaqueImage.getGraphics().getFontMetrics());
    assertSame(sampleModel, data2.getSampleModel());
    assertSame(sampleModel, raster2.getSampleModel());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then Image Raster DataBuffer return {@link DataBufferInt}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage); when PDDocument(); then Image Raster DataBuffer return DataBufferInt")
  void testCreateFromImage_whenPDDocument_thenImageRasterDataBufferReturnDataBufferInt() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDImageXObject actualCreateFromImageResult = LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 1));

    // Assert
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = rawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    Raster data = image.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer3 = data2.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferInt);
    WritableRaster raster = image.getRaster();
    DataBuffer dataBuffer4 = raster.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferInt);
    WritableRaster raster2 = opaqueImage.getRaster();
    DataBuffer dataBuffer5 = raster2.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferInt);
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    SampleModel sampleModel = opaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    PDColorSpace colorSpace = actualCreateFromImageResult.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceRGB);
    assertEquals(1, actualCreateFromImageResult.getStream().getFilters().size());
    Point[] writableTileIndices = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer3).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer4).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer5).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, raster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices2[0]);
    FontMetrics expectedFontMetrics = image.getGraphics().getFontMetrics();
    assertSame(expectedFontMetrics, opaqueImage.getGraphics().getFontMetrics());
    assertSame(sampleModel, data2.getSampleModel());
    assertSame(sampleModel, raster2.getSampleModel());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test
   * {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)}.
   * <p>
   * Method under test:
   * {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)")
  void testPrepareImageXObject() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L)));
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualPrepareImageXObjectResult = LosslessFactory.prepareImageXObject(document,
        "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1, PDDeviceGray.INSTANCE);

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualPrepareImageXObjectResult.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    BufferedImage image = actualPrepareImageXObjectResult.getImage();
    Raster data = image.getData();
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage opaqueImage = actualPrepareImageXObjectResult.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer2 = data2.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    WritableRaster raster = image.getRaster();
    DataBuffer dataBuffer3 = raster.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferByte);
    WritableRaster raster2 = opaqueImage.getRaster();
    DataBuffer dataBuffer4 = raster2.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferByte);
    DataBuffer dataBuffer5 = rawRaster.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferByte);
    SampleModel sampleModel = opaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertTrue(rawRaster.getSampleModel() instanceof PixelInterleavedSampleModel);
    PDColorSpace colorSpace = actualPrepareImageXObjectResult.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    assertEquals(1, actualPrepareImageXObjectResult.getStream().getFilters().size());
    Point[] writableTileIndices = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer3).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer4).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer5).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, raster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices2[0]);
    FontMetrics expectedFontMetrics = image.getGraphics().getFontMetrics();
    assertSame(expectedFontMetrics, opaqueImage.getGraphics().getFontMetrics());
    assertSame(sampleModel, data2.getSampleModel());
    assertSame(sampleModel, raster2.getSampleModel());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test
   * {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link StreamCacheCreateFunction}
   * {@link StreamCacheCreateFunction#create()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace); given 'null'; when StreamCacheCreateFunction create() return 'null'")
  void testPrepareImageXObject_givenNull_whenStreamCacheCreateFunctionCreateReturnNull() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualPrepareImageXObjectResult = LosslessFactory.prepareImageXObject(document,
        "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1, PDDeviceGray.INSTANCE);

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualPrepareImageXObjectResult.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    BufferedImage image = actualPrepareImageXObjectResult.getImage();
    Raster data = image.getData();
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage opaqueImage = actualPrepareImageXObjectResult.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer2 = data2.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    WritableRaster raster = image.getRaster();
    DataBuffer dataBuffer3 = raster.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferByte);
    WritableRaster raster2 = opaqueImage.getRaster();
    DataBuffer dataBuffer4 = raster2.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferByte);
    DataBuffer dataBuffer5 = rawRaster.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferByte);
    SampleModel sampleModel = opaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertTrue(rawRaster.getSampleModel() instanceof PixelInterleavedSampleModel);
    PDColorSpace colorSpace = actualPrepareImageXObjectResult.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    assertEquals(1, actualPrepareImageXObjectResult.getStream().getFilters().size());
    Point[] writableTileIndices = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer3).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer4).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer5).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, raster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices2[0]);
    FontMetrics expectedFontMetrics = image.getGraphics().getFontMetrics();
    assertSame(expectedFontMetrics, opaqueImage.getGraphics().getFontMetrics());
    assertSame(sampleModel, data2.getSampleModel());
    assertSame(sampleModel, raster2.getSampleModel());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test
   * {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)}.
   * <ul>
   *   <li>Then Image ColorModel ColorSpace return {@link ICC_ColorSpace}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace); then Image ColorModel ColorSpace return ICC_ColorSpace")
  void testPrepareImageXObject_thenImageColorModelColorSpaceReturnICC_ColorSpace() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    byte[] byteArray = "AXAXAXAX".getBytes("UTF-8");

    // Act
    PDImageXObject actualPrepareImageXObjectResult = LosslessFactory.prepareImageXObject(document, byteArray, 1, 1, 1,
        new PDCalGray());

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualPrepareImageXObjectResult.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    BufferedImage image = actualPrepareImageXObjectResult.getImage();
    ColorModel colorModel = image.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    assertTrue(((ICC_ColorSpace) colorSpace).getProfile() instanceof ICC_ProfileRGB);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = rawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    Raster data = image.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    BufferedImage opaqueImage = actualPrepareImageXObjectResult.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer3 = data2.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferInt);
    WritableRaster raster = image.getRaster();
    DataBuffer dataBuffer4 = raster.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferInt);
    WritableRaster raster2 = opaqueImage.getRaster();
    DataBuffer dataBuffer5 = raster2.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferInt);
    assertTrue(colorModel instanceof DirectColorModel);
    ColorModel colorModel2 = opaqueImage.getColorModel();
    assertTrue(colorModel2 instanceof DirectColorModel);
    SampleModel sampleModel = rawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    SampleModel sampleModel2 = image.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel3 = opaqueImage.getSampleModel();
    assertTrue(sampleModel3 instanceof SinglePixelPackedSampleModel);
    PDColorSpace colorSpace2 = actualPrepareImageXObjectResult.getColorSpace();
    COSBase cOSObject = colorSpace2.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    PDTristimulus blackPoint = ((PDCalGray) colorSpace2).getBlackPoint();
    COSBase cOSObject2 = blackPoint.getCOSObject();
    assertTrue(cOSObject2 instanceof COSArray);
    PDTristimulus whitepoint = ((PDCalGray) colorSpace2).getWhitepoint();
    COSBase cOSObject3 = whitepoint.getCOSObject();
    assertTrue(cOSObject3 instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSDictionary);
    List<? extends COSBase> toListResult2 = ((COSArray) cOSObject2).toList();
    assertEquals(3, toListResult2.size());
    COSBase getResult = toListResult2.get(0);
    assertTrue(getResult instanceof COSFloat);
    List<? extends COSBase> toListResult3 = ((COSArray) cOSObject3).toList();
    assertEquals(3, toListResult3.size());
    COSBase getResult2 = toListResult3.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    assertTrue(toListResult.get(0) instanceof COSName);
    assertTrue(colorSpace2 instanceof PDCalGray);
    assertEquals("CalGray", colorSpace2.getName());
    PDColor initialColor = colorSpace2.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertEquals(0, ((DirectColorModel) colorModel).getAlphaMask());
    assertEquals(0, sampleModel.getDataType());
    assertEquals(0, sampleModel.getTransferType());
    assertEquals(0.0f, blackPoint.getX());
    assertEquals(0.0f, blackPoint.getY());
    assertEquals(0.0f, blackPoint.getZ());
    assertEquals(1, image.getType());
    assertEquals(1, opaqueImage.getType());
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getPixelStride());
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(1, sampleModel.getHeight());
    assertEquals(1, sampleModel.getNumBands());
    assertEquals(1, sampleModel2.getNumDataElements());
    assertEquals(1, sampleModel.getNumDataElements());
    assertEquals(1, sampleModel.getWidth());
    assertEquals(1, ((SinglePixelPackedSampleModel) sampleModel2).getScanlineStride());
    assertEquals(1, actualPrepareImageXObjectResult.getStream().getFilters().size());
    assertEquals(1, colorSpace2.getNumberOfComponents());
    Point[] writableTileIndices = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    int[][] bankData = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer3).getBankData();
    assertEquals(1, bankData2.length);
    int[][] bankData3 = ((DataBufferInt) dataBuffer4).getBankData();
    assertEquals(1, bankData3.length);
    int[][] bankData4 = ((DataBufferInt) dataBuffer5).getBankData();
    assertEquals(1, bankData4.length);
    assertEquals(1.0f, ((PDCalGray) colorSpace2).getGamma());
    assertEquals(1.0f, whitepoint.getX());
    assertEquals(1.0f, whitepoint.getY());
    assertEquals(1.0f, whitepoint.getZ());
    assertEquals(16711680, ((DirectColorModel) colorModel).getRedMask());
    assertEquals(24, colorModel.getPixelSize());
    assertEquals(255, ((DirectColorModel) colorModel).getBlueMask());
    assertEquals(3, colorSpace.getNumComponents());
    assertEquals(3, colorModel.getNumColorComponents());
    assertEquals(3, colorModel.getNumComponents());
    assertEquals(3, colorModel.getTransferType());
    assertEquals(3, dataBuffer2.getDataType());
    assertEquals(3, dataBuffer3.getDataType());
    assertEquals(3, dataBuffer4.getDataType());
    assertEquals(3, dataBuffer5.getDataType());
    assertEquals(3, data.getNumBands());
    assertEquals(3, data2.getNumBands());
    assertEquals(3, raster.getNumBands());
    assertEquals(3, raster2.getNumBands());
    assertEquals(3, data.getTransferType());
    assertEquals(3, data2.getTransferType());
    assertEquals(3, raster.getTransferType());
    assertEquals(3, raster2.getTransferType());
    assertEquals(3, sampleModel2.getDataType());
    assertEquals(3, sampleModel2.getNumBands());
    assertEquals(3, sampleModel2.getTransferType());
    int[] componentSize = colorModel.getComponentSize();
    assertEquals(3, componentSize.length);
    assertEquals(5, colorSpace.getType());
    assertEquals(65280, ((DirectColorModel) colorModel).getGreenMask());
    assertEquals(8, componentSize[1]);
    assertEquals(8, componentSize[2]);
    assertFalse(initialColor.isPattern());
    assertTrue(colorSpace.isCS_sRGB());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, raster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices2[0]);
    assertEquals(colorModel, colorModel2);
    assertEquals(sampleModel2, sampleModel3);
    FontMetrics expectedFontMetrics = image.getGraphics().getFontMetrics();
    assertSame(expectedFontMetrics, opaqueImage.getGraphics().getFontMetrics());
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data3, bankData[0]);
    int[] data4 = ((DataBufferInt) dataBuffer3).getData();
    assertSame(data4, bankData2[0]);
    int[] data5 = ((DataBufferInt) dataBuffer4).getData();
    assertSame(data5, bankData3[0]);
    int[] data6 = ((DataBufferInt) dataBuffer5).getData();
    assertSame(data6, bankData4[0]);
    assertSame(sampleModel2, data.getSampleModel());
    assertSame(sampleModel2, raster.getSampleModel());
    assertSame(sampleModel3, data2.getSampleModel());
    assertSame(sampleModel3, raster2.getSampleModel());
    assertSame(getResult, toListResult2.get(1));
    assertSame(getResult, toListResult2.get(2));
    assertSame(getResult2, toListResult3.get(1));
    assertSame(getResult2, toListResult3.get(2));
    assertSame(colorSpace2, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0}, data3);
    assertArrayEquals(new int[]{0}, data4);
    assertArrayEquals(new int[]{0}, data5);
    assertArrayEquals(new int[]{0}, data6);
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel2).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel2.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel2).getBitOffsets());
  }

  /**
   * Test
   * {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return Width is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace); when 'A'; then return Width is one")
  void testPrepareImageXObject_whenA_thenReturnWidthIsOne() throws IOException {
    // Arrange and Act
    PDImageXObject actualPrepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 1, 1, null);

    // Assert
    PDStream stream = actualPrepareImageXObjectResult.getStream();
    assertEquals(1, stream.getFilters().size());
    assertEquals(1, actualPrepareImageXObjectResult.getWidth());
    assertEquals(12, stream.getLength());
    COSStream cOSObject = stream.getCOSObject();
    assertEquals(12L, cOSObject.getLength());
    assertEquals(7, cOSObject.getValues().size());
    assertEquals(7, cOSObject.size());
  }

  /**
   * Test
   * {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)}.
   * <ul>
   *   <li>When {@code AXXXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Stream Length is fourteen.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace); when 'AXXXAXAX' Bytes is 'UTF-8'; then return Stream Length is fourteen")
  void testPrepareImageXObject_whenAxxxaxaxBytesIsUtf8_thenReturnStreamLengthIsFourteen() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualPrepareImageXObjectResult = LosslessFactory.prepareImageXObject(document,
        "AXXXAXAX".getBytes("UTF-8"), 1, 1, 1, PDDeviceGray.INSTANCE);

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualPrepareImageXObjectResult.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    BufferedImage image = actualPrepareImageXObjectResult.getImage();
    Raster data = image.getData();
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage opaqueImage = actualPrepareImageXObjectResult.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer2 = data2.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    WritableRaster raster = image.getRaster();
    DataBuffer dataBuffer3 = raster.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferByte);
    WritableRaster raster2 = opaqueImage.getRaster();
    DataBuffer dataBuffer4 = raster2.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferByte);
    DataBuffer dataBuffer5 = rawRaster.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferByte);
    SampleModel sampleModel = opaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertTrue(rawRaster.getSampleModel() instanceof PixelInterleavedSampleModel);
    PDColorSpace colorSpace = actualPrepareImageXObjectResult.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    PDStream stream = actualPrepareImageXObjectResult.getStream();
    assertEquals(1, stream.getFilters().size());
    Point[] writableTileIndices = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer3).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer4).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer5).getBankData().length);
    assertEquals(14, stream.getLength());
    assertEquals(14L, stream.getCOSObject().getLength());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, raster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices2[0]);
    FontMetrics expectedFontMetrics = image.getGraphics().getFontMetrics();
    assertSame(expectedFontMetrics, opaqueImage.getGraphics().getFontMetrics());
    assertSame(sampleModel, data2.getSampleModel());
    assertSame(sampleModel, raster2.getSampleModel());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test
   * {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then return Width is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace); when MIN_VALUE; then return Width is MIN_VALUE")
  void testPrepareImageXObject_whenMin_value_thenReturnWidthIsMin_value() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    PDDeviceGray initColorSpace = PDDeviceGray.INSTANCE;

    // Act
    PDImageXObject actualPrepareImageXObjectResult = LosslessFactory.prepareImageXObject(document,
        "AXAXAXAX".getBytes("UTF-8"), Integer.MIN_VALUE, 1, 1, initColorSpace);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualPrepareImageXObjectResult.getStream().getFilters().size());
    assertEquals(Integer.MIN_VALUE, actualPrepareImageXObjectResult.getWidth());
    PDDeviceGray expectedColorSpace = initColorSpace.INSTANCE;
    assertSame(expectedColorSpace, actualPrepareImageXObjectResult.getColorSpace());
  }

  /**
   * Test
   * {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace); when PDDocument()")
  void testPrepareImageXObject_whenPDDocument() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDImageXObject actualPrepareImageXObjectResult = LosslessFactory.prepareImageXObject(document,
        "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1, PDDeviceGray.INSTANCE);

    // Assert
    WritableRaster rawRaster = actualPrepareImageXObjectResult.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    BufferedImage image = actualPrepareImageXObjectResult.getImage();
    Raster data = image.getData();
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage opaqueImage = actualPrepareImageXObjectResult.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer2 = data2.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    WritableRaster raster = image.getRaster();
    DataBuffer dataBuffer3 = raster.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferByte);
    WritableRaster raster2 = opaqueImage.getRaster();
    DataBuffer dataBuffer4 = raster2.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferByte);
    DataBuffer dataBuffer5 = rawRaster.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferByte);
    SampleModel sampleModel = opaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertTrue(rawRaster.getSampleModel() instanceof PixelInterleavedSampleModel);
    PDColorSpace colorSpace = actualPrepareImageXObjectResult.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    assertEquals(1, actualPrepareImageXObjectResult.getStream().getFilters().size());
    Point[] writableTileIndices = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer3).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer4).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer5).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, raster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices2[0]);
    FontMetrics expectedFontMetrics = image.getGraphics().getFontMetrics();
    assertSame(expectedFontMetrics, opaqueImage.getGraphics().getFontMetrics());
    assertSame(sampleModel, data2.getSampleModel());
    assertSame(sampleModel, raster2.getSampleModel());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }
}
