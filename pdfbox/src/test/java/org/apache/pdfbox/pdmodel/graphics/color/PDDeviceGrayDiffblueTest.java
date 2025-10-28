package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.awt.image.WritableRaster;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class PDDeviceGrayDiffblueTest {
  /**
   * Method under test: {@link PDDeviceGray#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("DeviceGray", PDDeviceGray.INSTANCE.getName());
  }

  /**
   * Method under test: {@link PDDeviceGray#getDefaultDecode(int)}
   */
  @Test
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 1.0f}, PDDeviceGray.INSTANCE.getDefaultDecode(1), 0.0f);
  }

  /**
   * Method under test: {@link PDDeviceGray#toRGB(float[])}
   */
  @Test
  void testToRGB() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{10.0f, 10.0f, 10.0f},
        PDDeviceGray.INSTANCE.toRGB(new float[]{10.0f, 0.0f, 10.0f, 0.0f}), 0.0f);
  }

  /**
   * Method under test: {@link PDDeviceGray#toRawImage(WritableRaster)}
   */
  @Test
  void testToRawImage() throws IOException {
    // Arrange, Act and Assert
    assertNull(PDDeviceGray.INSTANCE.toRawImage(null));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDDeviceGray#getInitialColor()}
   *   <li>{@link PDDeviceGray#getNumberOfComponents()}
   * </ul>
   */
  @Test
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
}
