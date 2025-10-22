package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.DirectColorModel;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PatchMeshesShadingContextDiffblueTest {
  /**
   * Test {@link PatchMeshesShadingContext#calcPixelTableArray(Rectangle)}.
   * <p>
   * Method under test: {@link PatchMeshesShadingContext#calcPixelTableArray(Rectangle)}
   */
  @Test
  @DisplayName("Test calcPixelTableArray(Rectangle)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int[][] PatchMeshesShadingContext.calcPixelTableArray(Rectangle)"})
  void testCalcPixelTableArray() throws IOException {
    // Arrange
    PDShadingType6 shading = mock(PDShadingType6.class);
    when(shading.collectPatches(Mockito.<AffineTransform>any(), Mockito.<Matrix>any(), anyInt()))
        .thenReturn(new ArrayList<>());
    when(shading.getBackground()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();
    Type6ShadingContext type6ShadingContext = new Type6ShadingContext(shading, colorModel, xform, matrix,
        new Rectangle(1, 1));

    // Act
    int[][] actualCalcPixelTableArrayResult = type6ShadingContext.calcPixelTableArray(new Rectangle(1, 1));

    // Assert
    verify(shading).collectPatches(isA(AffineTransform.class), isA(Matrix.class), eq(12));
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    assertEquals(2, actualCalcPixelTableArrayResult.length);
    assertArrayEquals(new int[]{-1, -1}, actualCalcPixelTableArrayResult[0]);
    assertArrayEquals(new int[]{-1, -1}, actualCalcPixelTableArrayResult[1]);
  }

  /**
   * Test {@link PatchMeshesShadingContext#calcPixelTableArray(Rectangle)}.
   * <p>
   * Method under test: {@link PatchMeshesShadingContext#calcPixelTableArray(Rectangle)}
   */
  @Test
  @DisplayName("Test calcPixelTableArray(Rectangle)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int[][] PatchMeshesShadingContext.calcPixelTableArray(Rectangle)"})
  void testCalcPixelTableArray2() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    PDShadingType6 shading = mock(PDShadingType6.class);
    when(shading.collectPatches(Mockito.<AffineTransform>any(), Mockito.<Matrix>any(), anyInt()))
        .thenReturn(new ArrayList<>());
    when(shading.getBackground()).thenReturn(cosArray);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();
    Type6ShadingContext type6ShadingContext = new Type6ShadingContext(shading, colorModel, xform, matrix,
        new Rectangle(1, 1));

    // Act
    int[][] actualCalcPixelTableArrayResult = type6ShadingContext.calcPixelTableArray(new Rectangle(1, 1));

    // Assert
    verify(cosArray).toFloatArray();
    verify(shading).collectPatches(isA(AffineTransform.class), isA(Matrix.class), eq(12));
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    assertEquals(2, actualCalcPixelTableArrayResult.length);
    assertArrayEquals(new int[]{167772150, 167772150}, actualCalcPixelTableArrayResult[0]);
    assertArrayEquals(new int[]{167772150, 167772150}, actualCalcPixelTableArrayResult[1]);
  }

  /**
   * Test {@link PatchMeshesShadingContext#dispose()}.
   * <p>
   * Method under test: {@link PatchMeshesShadingContext#dispose()}
   */
  @Test
  @DisplayName("Test dispose()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PatchMeshesShadingContext.dispose()"})
  void testDispose() throws IOException {
    // Arrange
    PDShadingType6 shading = mock(PDShadingType6.class);
    when(shading.collectPatches(Mockito.<AffineTransform>any(), Mockito.<Matrix>any(), anyInt()))
        .thenReturn(new ArrayList<>());
    when(shading.getBackground()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();
    Type6ShadingContext type6ShadingContext = new Type6ShadingContext(shading, colorModel, xform, matrix,
        new Rectangle(1, 1));

    // Act
    type6ShadingContext.dispose();

    // Assert
    verify(shading).collectPatches(isA(AffineTransform.class), isA(Matrix.class), eq(12));
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    assertNull(type6ShadingContext.getColorModel());
    assertNull(type6ShadingContext.getShadingColorSpace());
  }

  /**
   * Test {@link PatchMeshesShadingContext#isDataEmpty()}.
   * <ul>
   *   <li>Given {@link PDShadingType6} {@link PDMeshBasedShadingType#collectPatches(AffineTransform, Matrix, int)} return {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PatchMeshesShadingContext#isDataEmpty()}
   */
  @Test
  @DisplayName("Test isDataEmpty(); given PDShadingType6 collectPatches(AffineTransform, Matrix, int) return ArrayList(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PatchMeshesShadingContext.isDataEmpty()"})
  void testIsDataEmpty_givenPDShadingType6CollectPatchesReturnArrayList_thenReturnTrue() throws IOException {
    // Arrange
    PDShadingType6 shading = mock(PDShadingType6.class);
    when(shading.collectPatches(Mockito.<AffineTransform>any(), Mockito.<Matrix>any(), anyInt()))
        .thenReturn(new ArrayList<>());
    when(shading.getBackground()).thenReturn(null);
    when(shading.getColorSpace()).thenReturn(PDDeviceGray.INSTANCE);
    DirectColorModel colorModel = new DirectColorModel(1, 1, 1, 1);

    AffineTransform xform = new AffineTransform();
    Matrix matrix = new Matrix();

    // Act
    boolean actualIsDataEmptyResult = (new Type6ShadingContext(shading, colorModel, xform, matrix, new Rectangle(1, 1)))
        .isDataEmpty();

    // Assert
    verify(shading).collectPatches(isA(AffineTransform.class), isA(Matrix.class), eq(12));
    verify(shading).getBackground();
    verify(shading).getColorSpace();
    assertTrue(actualIsDataEmptyResult);
  }
}
