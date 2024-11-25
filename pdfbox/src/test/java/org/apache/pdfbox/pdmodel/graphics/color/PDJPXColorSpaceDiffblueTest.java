package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.github.jaiimageio.impl.common.BogusColorSpace;
import java.awt.color.ColorSpace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDJPXColorSpaceDiffblueTest {
  /**
   * Test {@link PDJPXColorSpace#PDJPXColorSpace(ColorSpace)}.
   * <p>
   * Method under test: {@link PDJPXColorSpace#PDJPXColorSpace(ColorSpace)}
   */
  @Test
  @DisplayName("Test new PDJPXColorSpace(ColorSpace)")
  void testNewPDJPXColorSpace() {
    // Arrange and Act
    PDJPXColorSpace actualPdjpxColorSpace = new PDJPXColorSpace(new BogusColorSpace(10));

    // Assert
    assertEquals("JPX", actualPdjpxColorSpace.getName());
    assertEquals(10, actualPdjpxColorSpace.getNumberOfComponents());
  }

  /**
   * Test {@link PDJPXColorSpace#getName()}.
   * <p>
   * Method under test: {@link PDJPXColorSpace#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("JPX", (new PDJPXColorSpace(new BogusColorSpace(10))).getName());
  }

  /**
   * Test {@link PDJPXColorSpace#getNumberOfComponents()}.
   * <ul>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDJPXColorSpace#getNumberOfComponents()}
   */
  @Test
  @DisplayName("Test getNumberOfComponents(); then return ten")
  void testGetNumberOfComponents_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10, (new PDJPXColorSpace(new BogusColorSpace(10))).getNumberOfComponents());
  }

  /**
   * Test {@link PDJPXColorSpace#getDefaultDecode(int)}.
   * <ul>
   *   <li>Then return array of {@code float} with zero and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDJPXColorSpace#getDefaultDecode(int)}
   */
  @Test
  @DisplayName("Test getDefaultDecode(int); then return array of float with zero and one")
  void testGetDefaultDecode_thenReturnArrayOfFloatWithZeroAndOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f,
        0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f}, (new PDJPXColorSpace(new BogusColorSpace(10))).getDefaultDecode(1), 0.0f);
  }

  /**
   * Test {@link PDJPXColorSpace#getInitialColor()}.
   * <p>
   * Method under test: {@link PDJPXColorSpace#getInitialColor()}
   */
  @Test
  @DisplayName("Test getInitialColor()")
  void testGetInitialColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDJPXColorSpace(new BogusColorSpace(10))).getInitialColor());
  }

  /**
   * Test {@link PDJPXColorSpace#toRGB(float[])}.
   * <p>
   * Method under test: {@link PDJPXColorSpace#toRGB(float[])}
   */
  @Test
  @DisplayName("Test toRGB(float[])")
  void testToRGB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDJPXColorSpace(new BogusColorSpace(10))).toRGB(new float[]{10.0f, 0.5f, 10.0f, 0.5f}));
  }

  /**
   * Test {@link PDJPXColorSpace#getCOSObject()}.
   * <p>
   * Method under test: {@link PDJPXColorSpace#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDJPXColorSpace(new BogusColorSpace(10))).getCOSObject());
  }
}
