package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.awt.image.WritableRaster;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDShadingPattern;
import org.junit.jupiter.api.Test;

class PDPatternDiffblueTest {
  /**
   * Method under test: {@link PDPattern#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("Pattern", (new PDPattern(new PDResources())).getName());
  }

  /**
   * Method under test: {@link PDPattern#getNumberOfComponents()}
   */
  @Test
  void testGetNumberOfComponents() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDPattern(new PDResources())).getNumberOfComponents());
  }

  /**
   * Method under test: {@link PDPattern#getDefaultDecode(int)}
   */
  @Test
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDPattern(new PDResources())).getDefaultDecode(1));
  }

  /**
   * Method under test: {@link PDPattern#toRGB(float[])}
   */
  @Test
  void testToRGB() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDPattern(new PDResources())).toRGB(new float[]{10.0f, 0.5f, 10.0f, 0.5f}));
  }

  /**
   * Method under test: {@link PDPattern#toRGBImage(WritableRaster)}
   */
  @Test
  void testToRGBImage() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDPattern(new PDResources())).toRGBImage(null));
  }

  /**
   * Method under test: {@link PDPattern#toRawImage(WritableRaster)}
   */
  @Test
  void testToRawImage() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDPattern(new PDResources())).toRawImage(null));
  }

  /**
   * Method under test: {@link PDPattern#getPattern(PDColor)}
   */
  @Test
  void testGetPattern() throws IOException {
    // Arrange
    PDPattern pdPattern = new PDPattern(new PDResources());

    // Act and Assert
    assertThrows(IOException.class, () -> pdPattern.getPattern(new PDColor(new COSArray(), PDDeviceGray.INSTANCE)));
  }

  /**
   * Method under test: {@link PDPattern#getPattern(PDColor)}
   */
  @Test
  void testGetPattern2() throws IOException {
    // Arrange
    COSDictionary resourceDictionary = new COSDictionary();
    PDPattern pdPattern = new PDPattern(new PDResources(resourceDictionary, new DefaultResourceCache()));

    // Act and Assert
    assertThrows(IOException.class, () -> pdPattern.getPattern(new PDColor(new COSArray(), PDDeviceGray.INSTANCE)));
  }

  /**
   * Method under test: {@link PDPattern#getPattern(PDColor)}
   */
  @Test
  void testGetPattern3() throws IOException {
    // Arrange
    PDResources resources = new PDResources();
    resources.add(new PDShadingPattern());
    PDPattern pdPattern = new PDPattern(resources);

    // Act and Assert
    assertThrows(IOException.class, () -> pdPattern.getPattern(new PDColor(new COSArray(), PDDeviceGray.INSTANCE)));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDPattern#toString()}
   *   <li>{@link PDPattern#getInitialColor()}
   *   <li>{@link PDPattern#getUnderlyingColorSpace()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDPattern pdPattern = new PDPattern(new PDResources());

    // Act
    String actualToStringResult = pdPattern.toString();
    PDColor actualInitialColor = pdPattern.getInitialColor();
    PDColorSpace actualUnderlyingColorSpace = pdPattern.getUnderlyingColorSpace();

    // Assert
    assertEquals("Pattern", actualToStringResult);
    assertNull(actualInitialColor.getPatternName());
    assertNull(actualInitialColor.getColorSpace());
    assertNull(actualUnderlyingColorSpace);
    assertEquals(0, actualInitialColor.getComponents().length);
    assertFalse(actualInitialColor.isPattern());
  }
}
