package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import java.awt.image.Raster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TriangleBasedShadingContextDiffblueTest {
  /**
   * Test {@link TriangleBasedShadingContext#createPixelTable(Rectangle)}.
   * <ul>
   *   <li>Given {@link PDShadingType4} {@link PDShading#getBackground()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TriangleBasedShadingContext#createPixelTable(Rectangle)}
   */
  @Test
  @DisplayName("Test createPixelTable(Rectangle); given PDShadingType4 getBackground() return 'null'")
  void testCreatePixelTable_givenPDShadingType4GetBackgroundReturnNull() throws IOException {
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
   * Test {@link TriangleBasedShadingContext#createPixelTable(Rectangle)}.
   * <ul>
   *   <li>Then calls {@link COSArray#toFloatArray()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TriangleBasedShadingContext#createPixelTable(Rectangle)}
   */
  @Test
  @DisplayName("Test createPixelTable(Rectangle); then calls toFloatArray()")
  void testCreatePixelTable_thenCallsToFloatArray() throws IOException {
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
   * Test
   * {@link TriangleBasedShadingContext#calcPixelTable(List, int[][], Rectangle)}.
   * <p>
   * Method under test:
   * {@link TriangleBasedShadingContext#calcPixelTable(List, int[][], Rectangle)}
   */
  @Test
  @DisplayName("Test calcPixelTable(List, int[][], Rectangle)")
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
   * Test {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}.
   * <p>
   * Method under test:
   * {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}
   */
  @Test
  @DisplayName("Test getRaster(int, int, int, int)")
  void testGetRaster() throws IOException {
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
    Raster actualRaster = (new Type4ShadingContext(shading, cm, xform, matrix, new Rectangle(1, 1))).getRaster(2, -1, 1,
        1);

    // Assert
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    Rectangle bounds = actualRaster.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle bounds4 = bounds3.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle2D bounds2D = bounds5.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds4.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds3.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds2.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    Rectangle bounds6 = bounds2D5.getBounds();
    Rectangle2D bounds2D6 = bounds6.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    Rectangle bounds7 = frame.getBounds();
    Rectangle2D bounds2D7 = bounds7.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D3.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D bounds2D9 = bounds2D4.getBounds2D();
    assertTrue(bounds2D9 instanceof Rectangle);
    Rectangle2D bounds2D10 = bounds2D5.getBounds2D();
    assertTrue(bounds2D10 instanceof Rectangle);
    Rectangle2D bounds2D11 = frame.getBounds2D();
    assertTrue(bounds2D11 instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds4.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds3.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds2.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    Rectangle2D frame5 = bounds2D5.getFrame();
    assertTrue(frame5 instanceof Rectangle2D.Double);
    Rectangle2D frame6 = frame.getFrame();
    assertTrue(frame6 instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = actualRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    Point location = bounds.getLocation();
    Rectangle bounds8 = bounds5.getBounds();
    Point location2 = bounds8.getLocation();
    assertEquals(location, location2.getLocation());
    Rectangle bounds9 = bounds6.getBounds();
    assertEquals(location, bounds9.getLocation().getLocation());
    Rectangle bounds10 = bounds7.getBounds();
    assertEquals(location, bounds10.getLocation().getLocation());
    Rectangle bounds11 = bounds2D3.getBounds();
    assertEquals(location, bounds11.getLocation().getLocation());
    Rectangle bounds12 = bounds2D4.getBounds();
    assertEquals(location, bounds12.getLocation().getLocation());
    Rectangle bounds13 = frame4.getBounds();
    assertEquals(location, bounds13.getLocation().getLocation());
    assertEquals(location, location.getLocation());
    assertEquals(location, ((Rectangle) bounds2D2).getLocation().getLocation());
    assertEquals(location, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(location, ((Rectangle) bounds2D10).getLocation().getLocation());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(location, bounds14.getLocation());
    assertEquals(location, location2);
    assertEquals(location, bounds5.getLocation());
    assertEquals(location, bounds4.getLocation());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(location, bounds15.getLocation());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(location, bounds16.getLocation());
    assertEquals(location, bounds3.getLocation());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(location, bounds17.getLocation());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(location, bounds18.getLocation());
    Rectangle bounds19 = bounds13.getBounds();
    assertEquals(location, bounds19.getLocation());
    assertEquals(location, bounds2.getLocation());
    Rectangle bounds20 = bounds2D2.getBounds();
    assertEquals(location, bounds20.getLocation());
    assertEquals(location, bounds6.getLocation());
    Rectangle bounds21 = bounds2D10.getBounds();
    assertEquals(location, bounds21.getLocation());
    Rectangle bounds22 = bounds2D11.getBounds();
    assertEquals(location, bounds22.getLocation());
    Rectangle bounds23 = frame2.getBounds();
    assertEquals(location, bounds23.getLocation());
    Rectangle bounds24 = frame3.getBounds();
    assertEquals(location, bounds24.getLocation());
    Rectangle bounds25 = frame5.getBounds();
    assertEquals(location, bounds25.getLocation());
    Rectangle bounds26 = frame6.getBounds();
    assertEquals(location, bounds26.getLocation());
    assertEquals(location, bounds7.getLocation());
    assertEquals(location, ((Rectangle) bounds2D).getLocation());
    assertEquals(location, ((Rectangle) bounds2D4).getLocation());
    assertEquals(location, ((Rectangle) bounds2D6).getLocation());
    assertEquals(location, ((Rectangle) bounds2D7).getLocation());
    assertEquals(location, ((Rectangle) bounds2D5).getLocation());
    assertEquals(location, ((Rectangle) bounds2D8).getLocation());
    assertEquals(location, ((Rectangle) bounds2D9).getLocation());
    Dimension size = bounds.getSize();
    Dimension size2 = bounds8.getSize();
    assertEquals(size, size2.getSize());
    assertEquals(size, bounds9.getSize().getSize());
    assertEquals(size, bounds10.getSize().getSize());
    assertEquals(size, bounds11.getSize().getSize());
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, bounds13.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D10).getSize().getSize());
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds5.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, bounds15.getSize());
    assertEquals(size, bounds16.getSize());
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds17.getSize());
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds19.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds20.getSize());
    assertEquals(size, bounds6.getSize());
    assertEquals(size, bounds21.getSize());
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds23.getSize());
    assertEquals(size, bounds24.getSize());
    assertEquals(size, bounds25.getSize());
    assertEquals(size, bounds26.getSize());
    assertEquals(size, bounds7.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    assertEquals(size, ((Rectangle) bounds2D9).getSize());
  }

  /**
   * Test {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}.
   * <ul>
   *   <li>Given {@link PDShadingType4} {@link PDShading#getBackground()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}
   */
  @Test
  @DisplayName("Test getRaster(int, int, int, int); given PDShadingType4 getBackground() return 'null'")
  void testGetRaster_givenPDShadingType4GetBackgroundReturnNull() throws IOException {
    // Arrange
    PDShadingType4 shading = mock(PDShadingType4.class);
    when(shading.collectTriangles(Mockito.<AffineTransform>any(), Mockito.<Matrix>any())).thenReturn(new ArrayList<>());
    when(shading.getBitsPerFlag()).thenReturn(1);
    when(shading.getBackground()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act
    Raster actualRaster = (new Type4ShadingContext(shading, cm, xform, matrix, new Rectangle(1, 1))).getRaster(2, 3, 1,
        1);

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    Rectangle bounds = actualRaster.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle bounds4 = bounds3.getBounds();
    assertTrue(bounds4.getBounds().getBounds2D() instanceof Rectangle);
    assertTrue(bounds4.getBounds2D() instanceof Rectangle);
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds2.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds.getBounds2D();
    assertTrue(bounds2D3.getBounds().getBounds2D() instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame.getBounds().getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D3 instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D2.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D3.getBounds2D() instanceof Rectangle);
    assertTrue(frame.getBounds2D() instanceof Rectangle2D.Double);
    assertTrue(bounds4.getFrame() instanceof Rectangle2D.Double);
    assertTrue(bounds3.getFrame() instanceof Rectangle2D.Double);
    assertTrue(bounds2.getFrame() instanceof Rectangle2D.Double);
    assertTrue(bounds2D3.getFrame() instanceof Rectangle2D.Double);
    assertTrue(frame.getFrame() instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
  }

  /**
   * Test {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}.
   * <ul>
   *   <li>Given {@link Rectangle#Rectangle(int, int, int, int)} with four and four
   * and four and four.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}
   */
  @Test
  @DisplayName("Test getRaster(int, int, int, int); given Rectangle(int, int, int, int) with four and four and four and four")
  void testGetRaster_givenRectangleWithFourAndFourAndFourAndFour() throws IOException {
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
   * Test {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}.
   * <ul>
   *   <li>Given {@link Rectangle#Rectangle(int, int)} with four and one.</li>
   *   <li>When three.</li>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}
   */
  @Test
  @DisplayName("Test getRaster(int, int, int, int); given Rectangle(int, int) with four and one; when three; then return array length is one")
  void testGetRaster_givenRectangleWithFourAndOne_whenThree_thenReturnArrayLengthIsOne() throws IOException {
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
   * Test {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}.
   * <ul>
   *   <li>Then Bounds Bounds Bounds Bounds Bounds Bounds2D return
   * {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}
   */
  @Test
  @DisplayName("Test getRaster(int, int, int, int); then Bounds Bounds Bounds Bounds Bounds Bounds2D return Rectangle")
  void testGetRaster_thenBoundsBoundsBoundsBoundsBoundsBounds2DReturnRectangle() throws IOException {
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
    Raster actualRaster = (new Type4ShadingContext(shading, cm, xform, matrix, new Rectangle(1, 1))).getRaster(2, 3, 1,
        1);

    // Assert
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    Rectangle bounds = actualRaster.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle bounds4 = bounds3.getBounds();
    assertTrue(bounds4.getBounds().getBounds2D() instanceof Rectangle);
    assertTrue(bounds4.getBounds2D() instanceof Rectangle);
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D bounds2D2 = bounds2.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds.getBounds2D();
    assertTrue(bounds2D3.getBounds().getBounds2D() instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame.getBounds().getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D3 instanceof Rectangle);
    assertTrue(bounds2D.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D2.getBounds2D() instanceof Rectangle);
    assertTrue(bounds2D3.getBounds2D() instanceof Rectangle);
    assertTrue(frame.getBounds2D() instanceof Rectangle2D.Double);
    assertTrue(bounds4.getFrame() instanceof Rectangle2D.Double);
    assertTrue(bounds3.getFrame() instanceof Rectangle2D.Double);
    assertTrue(bounds2.getFrame() instanceof Rectangle2D.Double);
    assertTrue(bounds2D3.getFrame() instanceof Rectangle2D.Double);
    assertTrue(frame.getFrame() instanceof Rectangle2D.Double);
    assertTrue(frame instanceof Rectangle2D.Double);
  }

  /**
   * Test {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}.
   * <ul>
   *   <li>Then return DataBuffer Data is array of {@code byte} with minus ten and
   * minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}
   */
  @Test
  @DisplayName("Test getRaster(int, int, int, int); then return DataBuffer Data is array of byte with minus ten and minus one")
  void testGetRaster_thenReturnDataBufferDataIsArrayOfByteWithMinusTenAndMinusOne() throws IOException {
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
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new byte[]{-10, -1, -1, -1}, ((DataBufferByte) dataBuffer).getData());
  }
}
