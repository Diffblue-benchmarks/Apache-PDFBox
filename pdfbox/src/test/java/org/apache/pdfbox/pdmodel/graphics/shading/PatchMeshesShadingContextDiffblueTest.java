package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PatchMeshesShadingContextDiffblueTest {
  @Mock private PDShadingType6 pDShadingType6;

  @Mock private Rectangle rectangle;

  @InjectMocks private Type6ShadingContext type6ShadingContext;

  /**
   * Test {@link PatchMeshesShadingContext#calcPixelTableArray(Rectangle)}.
   *
   * <ul>
   *   <li>When {@link Rectangle#Rectangle()}.
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link PatchMeshesShadingContext#calcPixelTableArray(Rectangle)}
   */
  @Test
  @DisplayName(
      "Test calcPixelTableArray(Rectangle); when Rectangle(); then return array length is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[][] PatchMeshesShadingContext.calcPixelTableArray(Rectangle)"})
  void testCalcPixelTableArray_whenRectangle_thenReturnArrayLengthIsOne() throws IOException {
    // Arrange and Act
    int[][] actualCalcPixelTableArrayResult =
        type6ShadingContext.calcPixelTableArray(new Rectangle());

    // Assert
    assertEquals(1, actualCalcPixelTableArrayResult.length);
    assertArrayEquals(new int[] {-1}, actualCalcPixelTableArrayResult[0]);
  }

  /**
   * Test {@link PatchMeshesShadingContext#dispose()}.
   *
   * <p>Method under test: {@link PatchMeshesShadingContext#dispose()}
   */
  @Test
  @DisplayName("Test dispose()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PatchMeshesShadingContext.dispose()"})
  void testDispose() {
    // Arrange and Act
    type6ShadingContext.dispose();

    // Assert
    assertNull(type6ShadingContext.getColorModel());
  }

  /**
   * Test {@link PatchMeshesShadingContext#isDataEmpty()}.
   *
   * <p>Method under test: {@link PatchMeshesShadingContext#isDataEmpty()}
   */
  @Test
  @DisplayName("Test isDataEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PatchMeshesShadingContext.isDataEmpty()"})
  void testIsDataEmpty() {
    // Arrange, Act and Assert
    assertTrue(type6ShadingContext.isDataEmpty());
  }
}
