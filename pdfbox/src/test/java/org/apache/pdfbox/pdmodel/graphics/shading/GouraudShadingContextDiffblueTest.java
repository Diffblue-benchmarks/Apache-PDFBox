package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GouraudShadingContextDiffblueTest {
  @Mock private PDShadingType4 pDShadingType4;

  @Mock private Rectangle rectangle;

  @InjectMocks private Type4ShadingContext type4ShadingContext;

  /**
   * Test {@link GouraudShadingContext#setTriangleList(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then not {@link Type4ShadingContext} DataEmpty.
   * </ul>
   *
   * <p>Method under test: {@link GouraudShadingContext#setTriangleList(List)}
   */
  @Test
  @DisplayName("Test setTriangleList(List); given 'null'; then not Type4ShadingContext DataEmpty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GouraudShadingContext.setTriangleList(List)"})
  void testSetTriangleList_givenNull_thenNotType4ShadingContextDataEmpty() {
    // Arrange
    ArrayList<ShadedTriangle> triangleList = new ArrayList<>();
    triangleList.add(null);

    // Act
    type4ShadingContext.setTriangleList(triangleList);

    // Assert
    assertFalse(type4ShadingContext.isDataEmpty());
  }

  /**
   * Test {@link GouraudShadingContext#setTriangleList(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then not {@link Type4ShadingContext} DataEmpty.
   * </ul>
   *
   * <p>Method under test: {@link GouraudShadingContext#setTriangleList(List)}
   */
  @Test
  @DisplayName("Test setTriangleList(List); given 'null'; then not Type4ShadingContext DataEmpty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GouraudShadingContext.setTriangleList(List)"})
  void testSetTriangleList_givenNull_thenNotType4ShadingContextDataEmpty2() {
    // Arrange
    ArrayList<ShadedTriangle> triangleList = new ArrayList<>();
    triangleList.add(null);
    triangleList.add(null);

    // Act
    type4ShadingContext.setTriangleList(triangleList);

    // Assert
    assertFalse(type4ShadingContext.isDataEmpty());
  }

  /**
   * Test {@link GouraudShadingContext#setTriangleList(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link Type4ShadingContext} DataEmpty.
   * </ul>
   *
   * <p>Method under test: {@link GouraudShadingContext#setTriangleList(List)}
   */
  @Test
  @DisplayName("Test setTriangleList(List); when ArrayList(); then Type4ShadingContext DataEmpty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GouraudShadingContext.setTriangleList(List)"})
  void testSetTriangleList_whenArrayList_thenType4ShadingContextDataEmpty() {
    // Arrange and Act
    type4ShadingContext.setTriangleList(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(type4ShadingContext.isDataEmpty());
  }

  /**
   * Test {@link GouraudShadingContext#calcPixelTableArray(Rectangle)}.
   *
   * <ul>
   *   <li>When {@link Rectangle#Rectangle()}.
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link GouraudShadingContext#calcPixelTableArray(Rectangle)}
   */
  @Test
  @DisplayName(
      "Test calcPixelTableArray(Rectangle); when Rectangle(); then return array length is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[][] GouraudShadingContext.calcPixelTableArray(Rectangle)"})
  void testCalcPixelTableArray_whenRectangle_thenReturnArrayLengthIsOne() throws IOException {
    // Arrange and Act
    int[][] actualCalcPixelTableArrayResult =
        type4ShadingContext.calcPixelTableArray(new Rectangle());

    // Assert
    assertEquals(1, actualCalcPixelTableArrayResult.length);
    assertArrayEquals(new int[] {-1}, actualCalcPixelTableArrayResult[0]);
  }

  /**
   * Test {@link GouraudShadingContext#dispose()}.
   *
   * <p>Method under test: {@link GouraudShadingContext#dispose()}
   */
  @Test
  @DisplayName("Test dispose()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GouraudShadingContext.dispose()"})
  void testDispose() {
    // Arrange and Act
    type4ShadingContext.dispose();

    // Assert
    assertNull(type4ShadingContext.getColorModel());
  }

  /**
   * Test {@link GouraudShadingContext#isDataEmpty()}.
   *
   * <p>Method under test: {@link GouraudShadingContext#isDataEmpty()}
   */
  @Test
  @DisplayName("Test isDataEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GouraudShadingContext.isDataEmpty()"})
  void testIsDataEmpty() {
    // Arrange, Act and Assert
    assertTrue(type4ShadingContext.isDataEmpty());
  }
}
