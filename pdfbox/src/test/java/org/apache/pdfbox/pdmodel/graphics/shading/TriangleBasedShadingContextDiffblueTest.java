package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TriangleBasedShadingContextDiffblueTest {
  /**
   * Test {@link TriangleBasedShadingContext#createPixelTable(Rectangle)}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType4} {@link PDShadingType4#getBackground()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TriangleBasedShadingContext#createPixelTable(Rectangle)}
   */
  @Test
  @DisplayName(
      "Test createPixelTable(Rectangle); given PDShadingType4 getBackground() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TriangleBasedShadingContext.createPixelTable(Rectangle)"})
  void testCreatePixelTable_givenPDShadingType4GetBackgroundReturnNull() throws IOException {
    // Arrange
    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    Type4ShadingContext type4ShadingContext =
        new Type4ShadingContext(shading, cm, xform, matrix, new Rectangle());

    // Act
    type4ShadingContext.createPixelTable(new Rectangle());

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
  }

  /**
   * Test {@link TriangleBasedShadingContext#createPixelTable(Rectangle)}.
   *
   * <ul>
   *   <li>Then calls {@link COSArray#toFloatArray()}.
   * </ul>
   *
   * <p>Method under test: {@link TriangleBasedShadingContext#createPixelTable(Rectangle)}
   */
  @Test
  @DisplayName("Test createPixelTable(Rectangle); then calls toFloatArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TriangleBasedShadingContext.createPixelTable(Rectangle)"})
  void testCreatePixelTable_thenCallsToFloatArray() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    Type4ShadingContext type4ShadingContext =
        new Type4ShadingContext(shading, cm, xform, matrix, new Rectangle());

    // Act
    type4ShadingContext.createPixelTable(new Rectangle());

    // Assert
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
  }

  /**
   * Test {@link TriangleBasedShadingContext#calcPixelTable(List, int[][], Rectangle)}.
   *
   * <p>Method under test: {@link TriangleBasedShadingContext#calcPixelTable(List, int[][],
   * Rectangle)}
   */
  @Test
  @DisplayName("Test calcPixelTable(List, int[][], Rectangle)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TriangleBasedShadingContext.calcPixelTable(List, int[][], Rectangle)"})
  void testCalcPixelTable() throws IOException {
    // Arrange
    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    Type4ShadingContext type4ShadingContext =
        new Type4ShadingContext(shading, cm, xform, matrix, new Rectangle());
    ArrayList<ShadedTriangle> triangleList = new ArrayList<>();

    // Act
    type4ShadingContext.calcPixelTable(
        triangleList, new int[][] {new int[] {1, 0, 1, 0}}, new Rectangle());

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
  }

  /**
   * Test {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType4} {@link PDShadingType4#getBackground()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test getRaster(int, int, int, int); given PDShadingType4 getBackground() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Raster TriangleBasedShadingContext.getRaster(int, int, int, int)"})
  void testGetRaster_givenPDShadingType4GetBackgroundReturnNull() throws IOException {
    // Arrange
    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    Type4ShadingContext type4ShadingContext =
        new Type4ShadingContext(shading, cm, xform, matrix, new Rectangle());

    // Act
    Raster actualRaster = type4ShadingContext.getRaster(2, 3, 1, 1);

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    DataBuffer dataBuffer = actualRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertArrayEquals(new byte[] {0, 0, 0, 0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(
        new int[] {0, 0, 0, 0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(
        new int[] {0, 1, 2, 3}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {8, 8, 8, 8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}.
   *
   * <ul>
   *   <li>Given {@link Rectangle#Rectangle()} add two and two.
   * </ul>
   *
   * <p>Method under test: {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}
   */
  @Test
  @DisplayName("Test getRaster(int, int, int, int); given Rectangle() add two and two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Raster TriangleBasedShadingContext.getRaster(int, int, int, int)"})
  void testGetRaster_givenRectangleAddTwoAndTwo() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);

    Rectangle deviceBounds = new Rectangle();
    deviceBounds.add(2, 2);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();

    Type4ShadingContext type4ShadingContext =
        new Type4ShadingContext(shading, cm, xform, new Matrix(), deviceBounds);

    // Act
    Raster actualRaster = type4ShadingContext.getRaster(2, 3, 1, 1);

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
    assertArrayEquals(new byte[] {0, 0, 0, 0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(
        new int[] {0, 0, 0, 0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(
        new int[] {0, 1, 2, 3}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {8, 8, 8, 8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}.
   *
   * <ul>
   *   <li>Given {@link Rectangle#Rectangle(int, int, int, int)} with four and four and four and
   *       four.
   * </ul>
   *
   * <p>Method under test: {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test getRaster(int, int, int, int); given Rectangle(int, int, int, int) with four and four and four and four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Raster TriangleBasedShadingContext.getRaster(int, int, int, int)"})
  void testGetRaster_givenRectangleWithFourAndFourAndFourAndFour() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();
    Rectangle deviceBounds = new Rectangle(4, 4, 4, 4);

    Type4ShadingContext type4ShadingContext =
        new Type4ShadingContext(shading, cm, xform, matrix, deviceBounds);

    // Act
    Raster actualRaster = type4ShadingContext.getRaster(2, 3, 1, 1);

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
    assertTrue(frame instanceof Double);
    DataBuffer dataBuffer = actualRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new byte[] {0, 0, 0, 0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(
        new int[] {0, 0, 0, 0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(
        new int[] {0, 1, 2, 3}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {8, 8, 8, 8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}.
   *
   * <ul>
   *   <li>Then return DataBuffer Data is array of {@code byte} with minus ten and minus one.
   * </ul>
   *
   * <p>Method under test: {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test getRaster(int, int, int, int); then return DataBuffer Data is array of byte with minus ten and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Raster TriangleBasedShadingContext.getRaster(int, int, int, int)"})
  void testGetRaster_thenReturnDataBufferDataIsArrayOfByteWithMinusTenAndMinusOne()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    Type4ShadingContext type4ShadingContext =
        new Type4ShadingContext(shading, cm, xform, matrix, new Rectangle(4, 4));

    // Act
    Raster actualRaster = type4ShadingContext.getRaster(2, 3, 1, 1);

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
    assertTrue(frame instanceof Double);
    DataBuffer dataBuffer = actualRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new byte[] {-10, -1, -1, -1}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(
        new int[] {0, 0, 0, 0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(
        new int[] {0, 1, 2, 3}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {8, 8, 8, 8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}.
   *
   * <ul>
   *   <li>Then return DataBuffer Data is array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test getRaster(int, int, int, int); then return DataBuffer Data is array of byte with zero and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Raster TriangleBasedShadingContext.getRaster(int, int, int, int)"})
  void testGetRaster_thenReturnDataBufferDataIsArrayOfByteWithZeroAndZero() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    Type4ShadingContext type4ShadingContext =
        new Type4ShadingContext(shading, cm, xform, matrix, new Rectangle());

    // Act
    Raster actualRaster = type4ShadingContext.getRaster(2, 3, 1, 1);

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
    assertArrayEquals(new byte[] {0, 0, 0, 0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(
        new int[] {0, 0, 0, 0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(
        new int[] {0, 1, 2, 3}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {8, 8, 8, 8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then Bounds Bounds2D return {@link Rectangle}.
   * </ul>
   *
   * <p>Method under test: {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test getRaster(int, int, int, int); when minus one; then Bounds Bounds2D return Rectangle")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Raster TriangleBasedShadingContext.getRaster(int, int, int, int)"})
  void testGetRaster_whenMinusOne_thenBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any()))
        .thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);
    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    Type4ShadingContext type4ShadingContext =
        new Type4ShadingContext(shading, cm, xform, matrix, new Rectangle());

    // Act
    Raster actualRaster = type4ShadingContext.getRaster(2, -1, 1, 1);

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
    assertTrue(frame instanceof Double);
    DataBuffer dataBuffer = actualRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    Rectangle actualBounds = bounds.getBounds();
    assertEquals(bounds, actualBounds);
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new byte[] {0, 0, 0, 0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(
        new int[] {0, 0, 0, 0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(
        new int[] {0, 1, 2, 3}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {8, 8, 8, 8}, sampleModel.getSampleSize());
  }
}
