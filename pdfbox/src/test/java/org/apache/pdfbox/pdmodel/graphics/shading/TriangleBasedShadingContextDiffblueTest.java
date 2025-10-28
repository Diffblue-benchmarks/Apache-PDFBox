package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TriangleBasedShadingContextDiffblueTest {
  /**
   * Method under test:
   * {@link TriangleBasedShadingContext#createPixelTable(Rectangle)}
   */
  @Test
  void testCreatePixelTable() throws IOException {
    // Arrange
    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any())).thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();
    Type4ShadingContext type4ShadingContext = new Type4ShadingContext(shading, cm, xform, matrix, new Rectangle(1, 1));

    // Act
    type4ShadingContext.createPixelTable(new Rectangle(1, 1));

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
  }

  /**
   * Method under test:
   * {@link TriangleBasedShadingContext#createPixelTable(Rectangle)}
   */
  @Test
  void testCreatePixelTable2() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any())).thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();
    Type4ShadingContext type4ShadingContext = new Type4ShadingContext(shading, cm, xform, matrix, new Rectangle(1, 1));

    // Act
    type4ShadingContext.createPixelTable(new Rectangle(1, 1));

    // Assert
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
  }

  /**
   * Method under test:
   * {@link TriangleBasedShadingContext#calcPixelTable(List, int[][], Rectangle)}
   */
  @Test
  void testCalcPixelTable() throws IOException {
    // Arrange
    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any())).thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();
    Type4ShadingContext type4ShadingContext = new Type4ShadingContext(shading, cm, xform, matrix, new Rectangle(1, 1));
    ArrayList<ShadedTriangle> triangleList = new ArrayList<>();

    // Act
    type4ShadingContext.calcPixelTable(triangleList, new int[][]{new int[]{1, 0, 1, 0}}, new Rectangle(1, 1));

    // Assert that nothing has changed
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
  }

  /**
   * Method under test:
   * {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}
   */
  @Test
  void testGetRaster() throws IOException {
    // Arrange
    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any())).thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();
    Rectangle deviceBounds = new Rectangle(1, 1);

    // Act
    Raster actualRaster = (new Type4ShadingContext(shading, cm, xform, matrix, deviceBounds)).getRaster(2, 3, 1, 1);

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    DataBuffer dataBuffer = actualRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertNull(actualRaster.getParent());
    assertEquals(0, dataBuffer.getDataType());
    assertEquals(0, dataBuffer.getOffset());
    assertEquals(0, actualRaster.getMinX());
    assertEquals(0, actualRaster.getMinY());
    assertEquals(0, actualRaster.getSampleModelTranslateX());
    assertEquals(0, actualRaster.getSampleModelTranslateY());
    assertEquals(0, actualRaster.getTransferType());
    assertEquals(0, sampleModel.getDataType());
    assertEquals(0, sampleModel.getTransferType());
    assertEquals(1, dataBuffer.getNumBanks());
    assertEquals(1, actualRaster.getHeight());
    assertEquals(1, actualRaster.getWidth());
    assertEquals(1, sampleModel.getHeight());
    assertEquals(1, sampleModel.getWidth());
    byte[][] bankData = ((DataBufferByte) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    assertEquals(4, ((PixelInterleavedSampleModel) sampleModel).getPixelStride());
    assertEquals(4, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(4, dataBuffer.getSize());
    assertEquals(4, actualRaster.getNumBands());
    assertEquals(4, actualRaster.getNumDataElements());
    assertEquals(4, sampleModel.getNumBands());
    assertEquals(4, sampleModel.getNumDataElements());
    assertEquals(deviceBounds, actualRaster.getBounds());
    byte[] data = ((DataBufferByte) dataBuffer).getData();
    assertSame(data, bankData[0]);
    assertArrayEquals(new byte[]{0, 0, 0, 0}, data);
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0, 0, 0, 0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0, 1, 2, 3}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
  }

  /**
   * Method under test:
   * {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}
   */
  @Test
  void testGetRaster2() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any())).thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();
    Rectangle deviceBounds = new Rectangle(1, 1);

    // Act
    Raster actualRaster = (new Type4ShadingContext(shading, cm, xform, matrix, deviceBounds)).getRaster(2, 3, 1, 1);

    // Assert
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    DataBuffer dataBuffer = actualRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertNull(actualRaster.getParent());
    assertEquals(0, dataBuffer.getDataType());
    assertEquals(0, dataBuffer.getOffset());
    assertEquals(0, actualRaster.getMinX());
    assertEquals(0, actualRaster.getMinY());
    assertEquals(0, actualRaster.getSampleModelTranslateX());
    assertEquals(0, actualRaster.getSampleModelTranslateY());
    assertEquals(0, actualRaster.getTransferType());
    assertEquals(0, sampleModel.getDataType());
    assertEquals(0, sampleModel.getTransferType());
    assertEquals(1, dataBuffer.getNumBanks());
    assertEquals(1, actualRaster.getHeight());
    assertEquals(1, actualRaster.getWidth());
    assertEquals(1, sampleModel.getHeight());
    assertEquals(1, sampleModel.getWidth());
    byte[][] bankData = ((DataBufferByte) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    assertEquals(4, ((PixelInterleavedSampleModel) sampleModel).getPixelStride());
    assertEquals(4, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(4, dataBuffer.getSize());
    assertEquals(4, actualRaster.getNumBands());
    assertEquals(4, actualRaster.getNumDataElements());
    assertEquals(4, sampleModel.getNumBands());
    assertEquals(4, sampleModel.getNumDataElements());
    assertEquals(deviceBounds, actualRaster.getBounds());
    byte[] data = ((DataBufferByte) dataBuffer).getData();
    assertSame(data, bankData[0]);
    assertArrayEquals(new byte[]{0, 0, 0, 0}, data);
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0, 0, 0, 0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0, 1, 2, 3}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
  }

  /**
   * Method under test:
   * {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}
   */
  @Test
  void testGetRaster3() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any())).thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act
    Raster actualRaster = (new Type4ShadingContext(shading, cm, xform, matrix, new Rectangle(4, 1))).getRaster(2, 3, 1,
        1);

    // Assert
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    Rectangle bounds = actualRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = actualRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertNull(actualRaster.getParent());
    assertEquals(0, dataBuffer.getDataType());
    assertEquals(0, dataBuffer.getOffset());
    assertEquals(0, actualRaster.getMinX());
    assertEquals(0, actualRaster.getMinY());
    assertEquals(0, actualRaster.getSampleModelTranslateX());
    assertEquals(0, actualRaster.getSampleModelTranslateY());
    assertEquals(0, actualRaster.getTransferType());
    assertEquals(0, sampleModel.getDataType());
    assertEquals(0, sampleModel.getTransferType());
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.5d, bounds.getCenterX());
    assertEquals(0.5d, bounds.getCenterY());
    assertEquals(1, dataBuffer.getNumBanks());
    assertEquals(1, actualRaster.getHeight());
    assertEquals(1, actualRaster.getWidth());
    assertEquals(1, sampleModel.getHeight());
    assertEquals(1, sampleModel.getWidth());
    byte[][] bankData = ((DataBufferByte) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    Dimension size = bounds.getSize();
    assertEquals(1, size.height);
    assertEquals(1, size.width);
    assertEquals(1, bounds.height);
    assertEquals(1, bounds.width);
    assertEquals(1.0d, size.getHeight());
    assertEquals(1.0d, size.getWidth());
    assertEquals(1.0d, bounds.getHeight());
    assertEquals(1.0d, bounds.getWidth());
    assertEquals(1.0d, bounds.getMaxX());
    assertEquals(1.0d, bounds.getMaxY());
    assertEquals(4, ((PixelInterleavedSampleModel) sampleModel).getPixelStride());
    assertEquals(4, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(4, dataBuffer.getSize());
    assertEquals(4, actualRaster.getNumBands());
    assertEquals(4, actualRaster.getNumDataElements());
    assertEquals(4, sampleModel.getNumBands());
    assertEquals(4, sampleModel.getNumDataElements());
    assertFalse(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    byte[] data = ((DataBufferByte) dataBuffer).getData();
    assertSame(data, bankData[0]);
    assertArrayEquals(new byte[]{0, 0, 0, 0}, data);
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0, 0, 0, 0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0, 1, 2, 3}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
  }

  /**
   * Method under test:
   * {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}
   */
  @Test
  void testGetRaster4() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any())).thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act
    Raster actualRaster = (new Type4ShadingContext(shading, cm, xform, matrix, new Rectangle(4, 4, 4, 4))).getRaster(2,
        3, 1, 1);

    // Assert
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    Rectangle bounds = actualRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = actualRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertNull(actualRaster.getParent());
    assertEquals(0, dataBuffer.getDataType());
    assertEquals(0, dataBuffer.getOffset());
    assertEquals(0, actualRaster.getMinX());
    assertEquals(0, actualRaster.getMinY());
    assertEquals(0, actualRaster.getSampleModelTranslateX());
    assertEquals(0, actualRaster.getSampleModelTranslateY());
    assertEquals(0, actualRaster.getTransferType());
    assertEquals(0, sampleModel.getDataType());
    assertEquals(0, sampleModel.getTransferType());
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.5d, bounds.getCenterX());
    assertEquals(0.5d, bounds.getCenterY());
    assertEquals(1, dataBuffer.getNumBanks());
    assertEquals(1, actualRaster.getHeight());
    assertEquals(1, actualRaster.getWidth());
    assertEquals(1, sampleModel.getHeight());
    assertEquals(1, sampleModel.getWidth());
    byte[][] bankData = ((DataBufferByte) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    Dimension size = bounds.getSize();
    assertEquals(1, size.height);
    assertEquals(1, size.width);
    assertEquals(1, bounds.height);
    assertEquals(1, bounds.width);
    assertEquals(1.0d, size.getHeight());
    assertEquals(1.0d, size.getWidth());
    assertEquals(1.0d, bounds.getHeight());
    assertEquals(1.0d, bounds.getWidth());
    assertEquals(1.0d, bounds.getMaxX());
    assertEquals(1.0d, bounds.getMaxY());
    assertEquals(4, ((PixelInterleavedSampleModel) sampleModel).getPixelStride());
    assertEquals(4, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(4, dataBuffer.getSize());
    assertEquals(4, actualRaster.getNumBands());
    assertEquals(4, actualRaster.getNumDataElements());
    assertEquals(4, sampleModel.getNumBands());
    assertEquals(4, sampleModel.getNumDataElements());
    assertFalse(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    byte[] data = ((DataBufferByte) dataBuffer).getData();
    assertSame(data, bankData[0]);
    assertArrayEquals(new byte[]{0, 0, 0, 0}, data);
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0, 0, 0, 0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0, 1, 2, 3}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
  }

  /**
   * Method under test:
   * {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}
   */
  @Test
  void testGetRaster5() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any())).thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);

    Rectangle deviceBounds = new Rectangle(1, 1);
    deviceBounds.add(new Point(4, 4));
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();

    // Act
    Raster actualRaster = (new Type4ShadingContext(shading, cm, xform, new Matrix(), deviceBounds)).getRaster(2, 3, 1,
        1);

    // Assert
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    Rectangle bounds = actualRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = actualRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertNull(actualRaster.getParent());
    assertEquals(0, dataBuffer.getDataType());
    assertEquals(0, dataBuffer.getOffset());
    assertEquals(0, actualRaster.getMinX());
    assertEquals(0, actualRaster.getMinY());
    assertEquals(0, actualRaster.getSampleModelTranslateX());
    assertEquals(0, actualRaster.getSampleModelTranslateY());
    assertEquals(0, actualRaster.getTransferType());
    assertEquals(0, sampleModel.getDataType());
    assertEquals(0, sampleModel.getTransferType());
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(0.5d, bounds.getCenterX());
    assertEquals(0.5d, bounds.getCenterY());
    assertEquals(1, dataBuffer.getNumBanks());
    assertEquals(1, actualRaster.getHeight());
    assertEquals(1, actualRaster.getWidth());
    assertEquals(1, sampleModel.getHeight());
    assertEquals(1, sampleModel.getWidth());
    byte[][] bankData = ((DataBufferByte) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    Dimension size = bounds.getSize();
    assertEquals(1, size.height);
    assertEquals(1, size.width);
    assertEquals(1, bounds.height);
    assertEquals(1, bounds.width);
    assertEquals(1.0d, size.getHeight());
    assertEquals(1.0d, size.getWidth());
    assertEquals(1.0d, bounds.getHeight());
    assertEquals(1.0d, bounds.getWidth());
    assertEquals(1.0d, bounds.getMaxX());
    assertEquals(1.0d, bounds.getMaxY());
    assertEquals(4, ((PixelInterleavedSampleModel) sampleModel).getPixelStride());
    assertEquals(4, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(4, dataBuffer.getSize());
    assertEquals(4, actualRaster.getNumBands());
    assertEquals(4, actualRaster.getNumDataElements());
    assertEquals(4, sampleModel.getNumBands());
    assertEquals(4, sampleModel.getNumDataElements());
    assertFalse(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    byte[] data = ((DataBufferByte) dataBuffer).getData();
    assertSame(data, bankData[0]);
    assertArrayEquals(new byte[]{-10, -1, -1, -1}, data);
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0, 0, 0, 0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0, 1, 2, 3}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
  }

  /**
   * Method under test:
   * {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}
   */
  @Test
  void testGetRaster6() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any())).thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();
    Rectangle deviceBounds = new Rectangle(1, 1);

    // Act
    Raster actualRaster = (new Type4ShadingContext(shading, cm, xform, matrix, deviceBounds)).getRaster(2, -1, 1, 1);

    // Assert
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    DataBuffer dataBuffer = actualRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertNull(actualRaster.getParent());
    assertEquals(0, dataBuffer.getDataType());
    assertEquals(0, dataBuffer.getOffset());
    assertEquals(0, actualRaster.getMinX());
    assertEquals(0, actualRaster.getMinY());
    assertEquals(0, actualRaster.getSampleModelTranslateX());
    assertEquals(0, actualRaster.getSampleModelTranslateY());
    assertEquals(0, actualRaster.getTransferType());
    assertEquals(0, sampleModel.getDataType());
    assertEquals(0, sampleModel.getTransferType());
    assertEquals(1, dataBuffer.getNumBanks());
    assertEquals(1, actualRaster.getHeight());
    assertEquals(1, actualRaster.getWidth());
    assertEquals(1, sampleModel.getHeight());
    assertEquals(1, sampleModel.getWidth());
    byte[][] bankData = ((DataBufferByte) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    assertEquals(4, ((PixelInterleavedSampleModel) sampleModel).getPixelStride());
    assertEquals(4, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(4, dataBuffer.getSize());
    assertEquals(4, actualRaster.getNumBands());
    assertEquals(4, actualRaster.getNumDataElements());
    assertEquals(4, sampleModel.getNumBands());
    assertEquals(4, sampleModel.getNumDataElements());
    assertEquals(deviceBounds, actualRaster.getBounds());
    byte[] data = ((DataBufferByte) dataBuffer).getData();
    assertSame(data, bankData[0]);
    assertArrayEquals(new byte[]{0, 0, 0, 0}, data);
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0, 0, 0, 0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0, 1, 2, 3}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
  }
}
