package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.github.jaiimageio.impl.common.BogusColorSpace;
import java.awt.color.ColorSpace;
import org.junit.jupiter.api.Test;

class PDJPXColorSpaceDiffblueTest {
  /**
   * Method under test: {@link PDJPXColorSpace#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("JPX", (new PDJPXColorSpace(new BogusColorSpace(10))).getName());
  }

  /**
   * Method under test: {@link PDJPXColorSpace#getNumberOfComponents()}
   */
  @Test
  void testGetNumberOfComponents() {
    // Arrange, Act and Assert
    assertEquals(10, (new PDJPXColorSpace(new BogusColorSpace(10))).getNumberOfComponents());
  }

  /**
   * Method under test: {@link PDJPXColorSpace#getDefaultDecode(int)}
   */
  @Test
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f,
        0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f}, (new PDJPXColorSpace(new BogusColorSpace(10))).getDefaultDecode(1), 0.0f);
  }

  /**
   * Method under test: {@link PDJPXColorSpace#getInitialColor()}
   */
  @Test
  void testGetInitialColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDJPXColorSpace(new BogusColorSpace(10))).getInitialColor());
  }

  /**
   * Method under test: {@link PDJPXColorSpace#toRGB(float[])}
   */
  @Test
  void testToRGB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDJPXColorSpace(new BogusColorSpace(10))).toRGB(new float[]{10.0f, 0.5f, 10.0f, 0.5f}));
  }

  /**
   * Method under test: {@link PDJPXColorSpace#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDJPXColorSpace(new BogusColorSpace(10))).getCOSObject());
  }

  /**
   * Method under test: {@link PDJPXColorSpace#PDJPXColorSpace(ColorSpace)}
   */
  @Test
  void testNewPDJPXColorSpace() {
    // Arrange and Act
    PDJPXColorSpace actualPdjpxColorSpace = new PDJPXColorSpace(new BogusColorSpace(10));

    // Assert
    assertEquals("JPX", actualPdjpxColorSpace.getName());
    assertEquals(10, actualPdjpxColorSpace.getNumberOfComponents());
  }
}
