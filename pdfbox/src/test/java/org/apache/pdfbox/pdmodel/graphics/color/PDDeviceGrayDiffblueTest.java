package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.image.WritableRaster;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDDeviceGrayDiffblueTest {
  /**
   * Test {@link PDDeviceGray#getName()}.
   *
   * <p>Method under test: {@link PDDeviceGray#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDDeviceGray.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("DeviceGray", PDDeviceGray.INSTANCE.getName());
  }

  /**
   * Test {@link PDDeviceGray#getDefaultDecode(int)}.
   *
   * <p>Method under test: {@link PDDeviceGray#getDefaultDecode(int)}
   */
  @Test
  @DisplayName("Test getDefaultDecode(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDDeviceGray.getDefaultDecode(int)"})
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[] {0.0f, 1.0f}, PDDeviceGray.INSTANCE.getDefaultDecode(1), 0.0f);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDDeviceGray#getInitialColor()}
   *   <li>{@link PDDeviceGray#getNumberOfComponents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDColor PDDeviceGray.getInitialColor()",
    "int PDDeviceGray.getNumberOfComponents()"
  })
  void testGettersAndSetters() {
    // Arrange
    PDDeviceGray pdDeviceGray = PDDeviceGray.INSTANCE;

    // Act
    PDColor actualInitialColor = pdDeviceGray.getInitialColor();

    // Assert
    assertNull(actualInitialColor.getPatternName());
    assertEquals(1, pdDeviceGray.getNumberOfComponents());
    assertFalse(actualInitialColor.isPattern());
    assertSame(PDDeviceGray.INSTANCE, actualInitialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, actualInitialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDDeviceGray#toRGB(float[])}.
   *
   * <ul>
   *   <li>When array of {@code float} with ten and zero.
   *   <li>Then return array of {@code float} with ten and ten.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceGray#toRGB(float[])}
   */
  @Test
  @DisplayName(
      "Test toRGB(float[]); when array of float with ten and zero; then return array of float with ten and ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDDeviceGray.toRGB(float[])"})
  void testToRGB_whenArrayOfFloatWithTenAndZero_thenReturnArrayOfFloatWithTenAndTen() {
    // Arrange and Act
    float[] actualToRGBResult = PDDeviceGray.INSTANCE.toRGB(new float[] {10.0f, 0.0f, 10.0f, 0.0f});

    // Assert
    assertArrayEquals(new float[] {10.0f, 10.0f, 10.0f}, actualToRGBResult, 0.0f);
  }

  /**
   * Test {@link PDDeviceGray#toRawImage(WritableRaster)} with {@code raster}.
   *
   * <p>Method under test: {@link PDDeviceGray#toRawImage(WritableRaster)}
   */
  @Test
  @DisplayName("Test toRawImage(WritableRaster) with 'raster'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.awt.image.BufferedImage PDDeviceGray.toRawImage(WritableRaster)"})
  void testToRawImageWithRaster() throws IOException {
    // Arrange, Act and Assert
    assertNull(PDDeviceGray.INSTANCE.toRawImage(null));
  }
}
