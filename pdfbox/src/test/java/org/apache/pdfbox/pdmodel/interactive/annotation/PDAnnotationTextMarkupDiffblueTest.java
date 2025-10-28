package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

class PDAnnotationTextMarkupDiffblueTest {
  /**
   * Method under test: {@link PDAnnotationTextMarkup#setQuadPoints(float[])}
   */
  @Test
  void testSetQuadPoints() {
    // Arrange
    PDAnnotationTextMarkup pdAnnotationTextMarkup = new PDAnnotationTextMarkup("Sub Type");

    // Act
    pdAnnotationTextMarkup.setQuadPoints(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, pdAnnotationTextMarkup.getQuadPoints(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationTextMarkup#getQuadPoints()}
   */
  @Test
  void testGetQuadPoints() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDAnnotationTextMarkup("Sub Type")).getQuadPoints().length);
    assertNull((new PDAnnotationTextMarkup(new COSDictionary())).getQuadPoints());
  }
}
