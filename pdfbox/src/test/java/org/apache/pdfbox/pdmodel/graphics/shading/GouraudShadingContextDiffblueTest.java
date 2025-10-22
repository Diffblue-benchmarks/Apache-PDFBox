package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.DirectColorModel;
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

class GouraudShadingContextDiffblueTest {
  /**
   * Test {@link GouraudShadingContext#setTriangleList(List)}.
   * <p>
   * Method under test: {@link GouraudShadingContext#setTriangleList(List)}
   */
  @Test
  @DisplayName("Test setTriangleList(List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GouraudShadingContext.setTriangleList(List)"})
  void testSetTriangleList() throws IOException {
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
    type4ShadingContext.setTriangleList(new ArrayList<>());

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
  }

  /**
   * Test {@link GouraudShadingContext#calcPixelTableArray(Rectangle)}.
   * <p>
   * Method under test: {@link GouraudShadingContext#calcPixelTableArray(Rectangle)}
   */
  @Test
  @DisplayName("Test calcPixelTableArray(Rectangle)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int[][] GouraudShadingContext.calcPixelTableArray(Rectangle)"})
  void testCalcPixelTableArray() throws IOException {
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
    int[][] actualCalcPixelTableArrayResult = type4ShadingContext.calcPixelTableArray(new Rectangle(1, 1));

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    assertEquals(2, actualCalcPixelTableArrayResult.length);
    assertArrayEquals(new int[]{-1, -1}, actualCalcPixelTableArrayResult[0]);
    assertArrayEquals(new int[]{-1, -1}, actualCalcPixelTableArrayResult[1]);
  }

  /**
   * Test {@link GouraudShadingContext#calcPixelTableArray(Rectangle)}.
   * <p>
   * Method under test: {@link GouraudShadingContext#calcPixelTableArray(Rectangle)}
   */
  @Test
  @DisplayName("Test calcPixelTableArray(Rectangle)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int[][] GouraudShadingContext.calcPixelTableArray(Rectangle)"})
  void testCalcPixelTableArray2() throws IOException {
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
    int[][] actualCalcPixelTableArrayResult = type4ShadingContext.calcPixelTableArray(new Rectangle(1, 1));

    // Assert
    verify(cosArray).toFloatArray();
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    assertEquals(2, actualCalcPixelTableArrayResult.length);
    assertArrayEquals(new int[]{167772150, 167772150}, actualCalcPixelTableArrayResult[0]);
    assertArrayEquals(new int[]{167772150, 167772150}, actualCalcPixelTableArrayResult[1]);
  }

  /**
   * Test {@link GouraudShadingContext#dispose()}.
   * <p>
   * Method under test: {@link GouraudShadingContext#dispose()}
   */
  @Test
  @DisplayName("Test dispose()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GouraudShadingContext.dispose()"})
  void testDispose() throws IOException {
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
    type4ShadingContext.dispose();

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    assertNull(type4ShadingContext.getColorModel());
    assertNull(type4ShadingContext.getShadingColorSpace());
  }

  /**
   * Test {@link GouraudShadingContext#isDataEmpty()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GouraudShadingContext#isDataEmpty()}
   */
  @Test
  @DisplayName("Test isDataEmpty(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GouraudShadingContext.isDataEmpty()"})
  void testIsDataEmpty_thenReturnTrue() throws IOException {
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
    boolean actualIsDataEmptyResult = (new Type4ShadingContext(shading, cm, xform, matrix, new Rectangle(1, 1)))
        .isDataEmpty();

    // Assert
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    verify(shading).collectTriangles(isA(AffineTransform.class), isA(Matrix.class));
    verify(shading).getBitsPerFlag();
    assertTrue(actualIsDataEmptyResult);
  }
}
