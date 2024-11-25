package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.awt.image.WritableRaster;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDDeviceGrayDiffblueTest {
  /**
   * Test {@link PDDeviceGray#getName()}.
   * <p>
   * Method under test: {@link PDDeviceGray#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("DeviceGray", PDDeviceGray.INSTANCE.getName());
  }

  /**
   * Test {@link PDDeviceGray#getDefaultDecode(int)}.
   * <p>
   * Method under test: {@link PDDeviceGray#getDefaultDecode(int)}
   */
  @Test
  @DisplayName("Test getDefaultDecode(int)")
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 1.0f}, PDDeviceGray.INSTANCE.getDefaultDecode(1), 0.0f);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDDeviceGray#getInitialColor()}
   *   <li>{@link PDDeviceGray#getNumberOfComponents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    PDDeviceGray pdDeviceGray = PDDeviceGray.INSTANCE;

    // Act
    PDColor actualInitialColor = pdDeviceGray.getInitialColor();
    int actualNumberOfComponents = pdDeviceGray.getNumberOfComponents();

    // Assert
    assertNull(actualInitialColor.getPatternName());
    assertEquals(1, actualNumberOfComponents);
    assertFalse(actualInitialColor.isPattern());
    assertArrayEquals(new float[]{0.0f}, actualInitialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDDeviceGray#toRGB(float[])}.
   * <ul>
   *   <li>When array of {@code float} with ten and zero.</li>
   *   <li>Then return array of {@code float} with ten and ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDeviceGray#toRGB(float[])}
   */
  @Test
  @DisplayName("Test toRGB(float[]); when array of float with ten and zero; then return array of float with ten and ten")
  void testToRGB_whenArrayOfFloatWithTenAndZero_thenReturnArrayOfFloatWithTenAndTen() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{10.0f, 10.0f, 10.0f},
        PDDeviceGray.INSTANCE.toRGB(new float[]{10.0f, 0.0f, 10.0f, 0.0f}), 0.0f);
  }

  /**
   * Test {@link PDDeviceGray#toRawImage(WritableRaster)} with {@code raster}.
   * <p>
   * Method under test: {@link PDDeviceGray#toRawImage(WritableRaster)}
   */
  @Test
  @DisplayName("Test toRawImage(WritableRaster) with 'raster'")
  void testToRawImageWithRaster() throws IOException {
    // Arrange, Act and Assert
    assertNull(PDDeviceGray.INSTANCE.toRawImage(null));
  }
}
