package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.awt.color.ICC_Profile;
import java.awt.image.WritableRaster;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class PDDeviceCMYKDiffblueTest {
  /**
   * Method under test: {@link PDDeviceCMYK#getICCProfile()}
   */
  @Test
  void testGetICCProfile() throws IOException {
    // Arrange and Act
    ICC_Profile actualICCProfile = (new PDDeviceCMYK()).getICCProfile();

    // Assert
    byte[] data = actualICCProfile.getData();
    assertEquals((byte) -1, data[8522]);
    assertEquals((byte) -1, data[8523]);
    assertEquals((byte) -1, data[8526]);
    assertEquals((byte) -1, data[8527]);
    assertEquals((byte) -1, data[8530]);
    assertEquals((byte) -1, data[8531]);
    assertEquals((byte) -43, data[8507]);
    assertEquals(0, actualICCProfile.getProfileClass());
    assertEquals((byte) 0, data[0]);
    assertEquals((byte) 0, data[1]);
    assertEquals((byte) 0, data[10]);
    assertEquals((byte) 0, data[11]);
    assertEquals((byte) 0, data[8508]);
    assertEquals((byte) 0, data[8509]);
    assertEquals((byte) 0, data[8511]);
    assertEquals((byte) 0, data[8513]);
    assertEquals((byte) 0, data[8514]);
    assertEquals((byte) 0, data[8515]);
    assertEquals((byte) 0, data[8517]);
    assertEquals((byte) 0, data[8519]);
    assertEquals((byte) 0, data[8520]);
    assertEquals((byte) 0, data[8521]);
    assertEquals((byte) 0, data[8524]);
    assertEquals((byte) 0, data[8525]);
    assertEquals((byte) 0, data[8528]);
    assertEquals((byte) 0, data[8529]);
    assertEquals(1, actualICCProfile.getPCSType());
    assertEquals((byte) 16, data[9]);
    assertEquals(2, actualICCProfile.getMajorVersion());
    assertEquals((byte) 2, data[8]);
    assertEquals(4, actualICCProfile.getNumComponents());
    assertEquals((byte) 7, data[24]);
    assertEquals(8532, data.length);
    assertEquals(9, actualICCProfile.getColorSpaceType());
    assertEquals(Byte.MIN_VALUE, data[8510]);
    assertEquals(Byte.MIN_VALUE, data[8512]);
    assertEquals(Byte.MIN_VALUE, data[8516]);
    assertEquals(Byte.MIN_VALUE, data[8518]);
    assertEquals(Short.SIZE, actualICCProfile.getMinorVersion());
    assertEquals(' ', data[23]);
    assertEquals('!', data[2]);
    assertEquals('A', data[4]);
    assertEquals('B', data[6]);
    assertEquals('C', data[Short.SIZE]);
    assertEquals('D', data[5]);
    assertEquals('E', data[7]);
    assertEquals('K', data[19]);
    assertEquals('L', data[20]);
    assertEquals('M', data[17]);
    assertEquals('T', data[3]);
    assertEquals('Y', data[18]);
    assertEquals('a', data[21]);
    assertEquals('b', data[22]);
    assertEquals('c', data[13]);
    assertEquals('n', data[14]);
    assertEquals('r', data[15]);
    assertEquals('s', data[12]);
  }

  /**
   * Method under test: {@link PDDeviceCMYK#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("DeviceCMYK", (new PDDeviceCMYK()).getName());
  }

  /**
   * Method under test: {@link PDDeviceCMYK#getDefaultDecode(int)}
   */
  @Test
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f},
        (new PDDeviceCMYK()).getDefaultDecode(1), 0.0f);
  }

  /**
   * Method under test: {@link PDDeviceCMYK#toRGB(float[])}
   */
  @Test
  void testToRGB() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 0.6499733f, 0.31564814f},
        (new PDDeviceCMYK()).toRGB(new float[]{10.0f, -1.0f, 10.0f, -1.0f}), 0.0f);
  }

  /**
   * Method under test: {@link PDDeviceCMYK#toRawImage(WritableRaster)}
   */
  @Test
  void testToRawImage() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDDeviceCMYK()).toRawImage(null));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDDeviceCMYK#getInitialColor()}
   *   <li>{@link PDDeviceCMYK#getNumberOfComponents()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDDeviceCMYK pdDeviceCMYK = new PDDeviceCMYK();

    // Act
    PDColor actualInitialColor = pdDeviceCMYK.getInitialColor();
    int actualNumberOfComponents = pdDeviceCMYK.getNumberOfComponents();

    // Assert
    assertNull(actualInitialColor.getPatternName());
    assertEquals(4, actualNumberOfComponents);
    assertFalse(actualInitialColor.isPattern());
    assertSame(pdDeviceCMYK, actualInitialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f, 1.0f}, actualInitialColor.getComponents(), 0.0f);
  }
}
