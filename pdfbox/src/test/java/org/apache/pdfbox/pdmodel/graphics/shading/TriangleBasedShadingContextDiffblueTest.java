package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.DataBufferByte;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.Raster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionType0;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TriangleBasedShadingContextDiffblueTest {
  @Mock private PDShadingType4 pDShadingType4;

  @Mock private Rectangle rectangle;

  @InjectMocks private Type4ShadingContext type4ShadingContext;

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
   * <ul>
   *   <li>Given {@link PDShadingType4} {@link PDShadingType4#getFunction()} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link TriangleBasedShadingContext#calcPixelTable(List, int[][],
   * Rectangle)}
   */
  @Test
  @DisplayName(
      "Test calcPixelTable(List, int[][], Rectangle); given PDShadingType4 getFunction() throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TriangleBasedShadingContext.calcPixelTable(List, int[][], Rectangle)"})
  void testCalcPixelTable_givenPDShadingType4GetFunctionThrowIOException() throws IOException {
    // Arrange
    when(pDShadingType4.getFunction()).thenThrow(new IOException());

    ShadedTriangle shadedTriangle = mock(ShadedTriangle.class);
    Point p0 = new Point();
    Line line =
        new Line(
            p0,
            new Point(),
            new float[] {10.0f, 0.5f, 10.0f, 0.5f},
            new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(shadedTriangle.getLine()).thenReturn(line);
    when(shadedTriangle.getDeg()).thenReturn(2);

    ArrayList<ShadedTriangle> triangleList = new ArrayList<>();
    triangleList.add(shadedTriangle);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            type4ShadingContext.calcPixelTable(
                triangleList, new int[][] {new int[] {}}, new Rectangle()));
    verify(pDShadingType4).getFunction();
    verify(shadedTriangle).getDeg();
    verify(shadedTriangle).getLine();
  }

  /**
   * Test {@link TriangleBasedShadingContext#calcPixelTable(List, int[][], Rectangle)}.
   *
   * <ul>
   *   <li>Then calls {@link PDShadingType4#evalFunction(float[])}.
   * </ul>
   *
   * <p>Method under test: {@link TriangleBasedShadingContext#calcPixelTable(List, int[][],
   * Rectangle)}
   */
  @Test
  @DisplayName("Test calcPixelTable(List, int[][], Rectangle); then calls evalFunction(float[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TriangleBasedShadingContext.calcPixelTable(List, int[][], Rectangle)"})
  void testCalcPixelTable_thenCallsEvalFunction() throws IOException {
    // Arrange
    when(pDShadingType4.evalFunction(Mockito.<float[]>any())).thenThrow(new IOException());
    when(pDShadingType4.getFunction()).thenReturn(new PDFunctionType0(COSBoolean.FALSE));

    ShadedTriangle shadedTriangle = mock(ShadedTriangle.class);
    Point p0 = new Point();
    Line line =
        new Line(
            p0,
            new Point(),
            new float[] {10.0f, 0.5f, 10.0f, 0.5f},
            new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(shadedTriangle.getLine()).thenReturn(line);
    when(shadedTriangle.getDeg()).thenReturn(2);

    ArrayList<ShadedTriangle> triangleList = new ArrayList<>();
    triangleList.add(shadedTriangle);

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            type4ShadingContext.calcPixelTable(
                triangleList, new int[][] {new int[] {}}, new Rectangle()));
    verify(pDShadingType4).evalFunction(isA(float[].class));
    verify(pDShadingType4).getFunction();
    verify(shadedTriangle).getDeg();
    verify(shadedTriangle).getLine();
  }

  /**
   * Test {@link TriangleBasedShadingContext#calcPixelTable(List, int[][], Rectangle)}.
   *
   * <ul>
   *   <li>Then calls {@link PDShadingType4#getBackground()}.
   * </ul>
   *
   * <p>Method under test: {@link TriangleBasedShadingContext#calcPixelTable(List, int[][],
   * Rectangle)}
   */
  @Test
  @DisplayName("Test calcPixelTable(List, int[][], Rectangle); then calls getBackground()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TriangleBasedShadingContext.calcPixelTable(List, int[][], Rectangle)"})
  void testCalcPixelTable_thenCallsGetBackground() throws IOException {
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
   *   <li>Given {@link PDShadingType4}.
   *   <li>When one.
   *   <li>Then DataBuffer return {@link DataBufferByte}.
   * </ul>
   *
   * <p>Method under test: {@link TriangleBasedShadingContext#getRaster(int, int, int, int)}
   */
  @Test
  @DisplayName(
      "Test getRaster(int, int, int, int); given PDShadingType4; when one; then DataBuffer return DataBufferByte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Raster TriangleBasedShadingContext.getRaster(int, int, int, int)"})
  void testGetRaster_givenPDShadingType4_whenOne_thenDataBufferReturnDataBufferByte() {
    // Arrange and Act
    Raster actualRaster = type4ShadingContext.getRaster(2, 3, 1, 1);

    // Assert
    assertTrue(actualRaster.getDataBuffer() instanceof DataBufferByte);
    assertTrue(actualRaster.getSampleModel() instanceof PixelInterleavedSampleModel);
    assertNull(actualRaster.getParent());
    assertEquals(0, actualRaster.getMinX());
    assertEquals(0, actualRaster.getMinY());
    assertEquals(0, actualRaster.getSampleModelTranslateX());
    assertEquals(0, actualRaster.getSampleModelTranslateY());
    assertEquals(0, actualRaster.getTransferType());
    assertEquals(1, actualRaster.getHeight());
    assertEquals(1, actualRaster.getWidth());
    assertEquals(4, actualRaster.getNumBands());
    assertEquals(4, actualRaster.getNumDataElements());
  }
}
