package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.awt.image.WritableRaster;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDDeviceRGBDiffblueTest {
  /**
   * Test {@link PDDeviceRGB#getName()}.
   * <p>
   * Method under test: {@link PDDeviceRGB#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("DeviceRGB", PDDeviceRGB.INSTANCE.getName());
  }

  /**
   * Test {@link PDDeviceRGB#getDefaultDecode(int)}.
   * <p>
   * Method under test: {@link PDDeviceRGB#getDefaultDecode(int)}
   */
  @Test
  @DisplayName("Test getDefaultDecode(int)")
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f}, PDDeviceRGB.INSTANCE.getDefaultDecode(1), 0.0f);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDDeviceRGB#getInitialColor()}
   *   <li>{@link PDDeviceRGB#getNumberOfComponents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    PDDeviceRGB pdDeviceRGB = PDDeviceRGB.INSTANCE;

    // Act
    PDColor actualInitialColor = pdDeviceRGB.getInitialColor();
    int actualNumberOfComponents = pdDeviceRGB.getNumberOfComponents();

    // Assert
    assertNull(actualInitialColor.getPatternName());
    assertEquals(3, actualNumberOfComponents);
    assertFalse(actualInitialColor.isPattern());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, actualInitialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDDeviceRGB#toRGB(float[])}.
   * <p>
   * Method under test: {@link PDDeviceRGB#toRGB(float[])}
   */
  @Test
  @DisplayName("Test toRGB(float[])")
  void testToRGB() {
    // Arrange
    float[] value = new float[]{10.0f, 0.0f, 10.0f, 0.0f};

    // Act and Assert
    assertSame(value, PDDeviceRGB.INSTANCE.toRGB(value));
  }

  /**
   * Test {@link PDDeviceRGB#toRawImage(WritableRaster)} with {@code raster}.
   * <p>
   * Method under test: {@link PDDeviceRGB#toRawImage(WritableRaster)}
   */
  @Test
  @DisplayName("Test toRawImage(WritableRaster) with 'raster'")
  void testToRawImageWithRaster() throws IOException {
    // Arrange, Act and Assert
    assertNull(PDDeviceRGB.INSTANCE.toRawImage(null));
  }
}
