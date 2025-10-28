package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.awt.image.WritableRaster;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class PDDeviceRGBDiffblueTest {
  /**
   * Method under test: {@link PDDeviceRGB#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("DeviceRGB", PDDeviceRGB.INSTANCE.getName());
  }

  /**
   * Method under test: {@link PDDeviceRGB#getDefaultDecode(int)}
   */
  @Test
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f}, PDDeviceRGB.INSTANCE.getDefaultDecode(1), 0.0f);
  }

  /**
   * Method under test: {@link PDDeviceRGB#toRGB(float[])}
   */
  @Test
  void testToRGB() {
    // Arrange
    float[] value = new float[]{10.0f, 0.0f, 10.0f, 0.0f};

    // Act and Assert
    assertSame(value, PDDeviceRGB.INSTANCE.toRGB(value));
  }

  /**
   * Method under test: {@link PDDeviceRGB#toRawImage(WritableRaster)}
   */
  @Test
  void testToRawImage() throws IOException {
    // Arrange, Act and Assert
    assertNull(PDDeviceRGB.INSTANCE.toRawImage(null));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDDeviceRGB#getInitialColor()}
   *   <li>{@link PDDeviceRGB#getNumberOfComponents()}
   * </ul>
   */
  @Test
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
}
