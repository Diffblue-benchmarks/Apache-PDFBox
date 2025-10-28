package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

class FDFAnnotationTextMarkupDiffblueTest {
  /**
   * Method under test: {@link FDFAnnotationTextMarkup#setCoords(float[])}
   */
  @Test
  void testSetCoords() {
    // Arrange
    FDFAnnotationHighlight fdfAnnotationHighlight = new FDFAnnotationHighlight();

    // Act
    fdfAnnotationHighlight.setCoords(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = fdfAnnotationHighlight.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, fdfAnnotationHighlight.getCoords(), 0.0f);
  }

  /**
   * Method under test: {@link FDFAnnotationTextMarkup#getCoords()}
   */
  @Test
  void testGetCoords() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationHighlight()).getCoords());
  }

  /**
   * Method under test: {@link FDFAnnotationTextMarkup#getCoords()}
   */
  @Test
  void testGetCoords2() {
    // Arrange
    FDFAnnotationHighlight fdfAnnotationHighlight = new FDFAnnotationHighlight();
    fdfAnnotationHighlight.setCoords(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, fdfAnnotationHighlight.getCoords(), 0.0f);
  }
}
